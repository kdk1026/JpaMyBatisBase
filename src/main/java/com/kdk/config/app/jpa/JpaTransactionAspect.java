package com.kdk.config.app.jpa;

import java.util.Collections;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2025. 2. 1. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@Configuration
@Aspect
public class JpaTransactionAspect {

	private static final String AOP_TRANSACTION_EXPRESSION = "execution(* com.kdk.app.**..impl.*Impl.*(..))";

	@Qualifier("jpaTransactionManager")
	@Autowired
	private TransactionManager jpaTransactionManager;

	private static final String[] DEFAULT_READ_ONLY_METHOD_RULE_TRANSACTION_ATTRIBUTES = {
			"select*",
			"get*",
			"find*",
			"search*",
			"fetch*"
		};

		private static final String[] DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES = {
			"*"
		};

		private RuleBasedTransactionAttribute readOnlyTransactionRule () {
			RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
			readOnly.setReadOnly(true);
			readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
			return readOnly;
		}

		private RuleBasedTransactionAttribute requiredTransactionRule () {
			RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
			required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
			required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			required.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);
			return required;
		}

	    @Bean
	    TransactionInterceptor jpaTransactionAdvice() {
			NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();

			RuleBasedTransactionAttribute readOnly = this.readOnlyTransactionRule();
			RuleBasedTransactionAttribute required = this.requiredTransactionRule();

			for (String methodName : DEFAULT_READ_ONLY_METHOD_RULE_TRANSACTION_ATTRIBUTES) {
				transactionAttributeSource.addTransactionalMethod(methodName , readOnly);
			}

			for (String methodName : DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES) {
				transactionAttributeSource.addTransactionalMethod(methodName , required);
			}

			return new TransactionInterceptor(jpaTransactionManager, transactionAttributeSource);
		}

	    @Bean
	    Advisor jpaTransactionAdviceAdvisor() {
			AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
			pointcut.setExpression(AOP_TRANSACTION_EXPRESSION);

			return new DefaultPointcutAdvisor(pointcut, this.jpaTransactionAdvice());
		}

}
