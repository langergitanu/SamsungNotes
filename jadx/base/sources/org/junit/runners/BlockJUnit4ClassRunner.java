package org.junit.runners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.Fail;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.MemberValueConsumer;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class BlockJUnit4ClassRunner extends ParentRunner<FrameworkMethod> {
    private final ConcurrentMap<FrameworkMethod, Description> methodDescriptions;
    private static TestClassValidator PUBLIC_CLASS_VALIDATOR = new PublicClassValidator();
    private static final ThreadLocal<RuleContainer> CURRENT_RULE_CONTAINER = new ThreadLocal<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RuleCollector<T> implements MemberValueConsumer<T> {
        final List<T> result;

        private RuleCollector() {
            this.result = new ArrayList();
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember<?> frameworkMember, T t) {
            RuleContainer ruleContainer;
            Rule rule = (Rule) frameworkMember.getAnnotation(Rule.class);
            if (rule != null && (ruleContainer = (RuleContainer) BlockJUnit4ClassRunner.CURRENT_RULE_CONTAINER.get()) != null) {
                ruleContainer.setOrder(t, rule.order());
            }
            this.result.add(t);
        }
    }

    public BlockJUnit4ClassRunner(Class<?> cls) {
        super(cls);
        this.methodDescriptions = new ConcurrentHashMap();
    }

    private Class<? extends Throwable> getExpectedException(Test test) {
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    private long getTimeout(Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    private boolean hasOneConstructor() {
        return getTestClass().getJavaClass().getConstructors().length == 1;
    }

    private void validateMethods(List<Throwable> list) {
        RuleMemberValidator.RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    private void validatePublicConstructor(List<Throwable> list) {
        if (getTestClass().getJavaClass() != null) {
            list.addAll(PUBLIC_CLASS_VALIDATOR.validateTestClass(getTestClass()));
        }
    }

    private Statement withRules(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        RuleContainer ruleContainer = new RuleContainer();
        CURRENT_RULE_CONTAINER.set(ruleContainer);
        try {
            List<TestRule> testRules = getTestRules(obj);
            for (MethodRule methodRule : rules(obj)) {
                if (!(methodRule instanceof TestRule) || !testRules.contains(methodRule)) {
                    ruleContainer.add(methodRule);
                }
            }
            Iterator<TestRule> it = testRules.iterator();
            while (it.hasNext()) {
                ruleContainer.add(it.next());
            }
            CURRENT_RULE_CONTAINER.remove();
            return ruleContainer.apply(frameworkMethod, describeChild(frameworkMethod), obj, statement);
        } catch (Throwable th) {
            CURRENT_RULE_CONTAINER.remove();
            throw th;
        }
    }

    @Override // org.junit.runners.ParentRunner
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        validatePublicConstructor(list);
        validateNoNonStaticInnerClass(list);
        validateConstructor(list);
        validateInstanceMethods(list);
        validateFields(list);
        validateMethods(list);
    }

    public List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(Test.class);
    }

    public Object createTest() {
        return getTestClass().getOnlyConstructor().newInstance(null);
    }

    @Override // org.junit.runners.ParentRunner
    public List<FrameworkMethod> getChildren() {
        return computeTestMethods();
    }

    public List<TestRule> getTestRules(Object obj) {
        RuleCollector ruleCollector = new RuleCollector();
        getTestClass().collectAnnotatedMethodValues(obj, Rule.class, TestRule.class, ruleCollector);
        getTestClass().collectAnnotatedFieldValues(obj, Rule.class, TestRule.class, ruleCollector);
        return ruleCollector.result;
    }

    public Statement methodBlock(final FrameworkMethod frameworkMethod) {
        try {
            Object objRun = new ReflectiveCallable() { // from class: org.junit.runners.BlockJUnit4ClassRunner.2
                @Override // org.junit.internal.runners.model.ReflectiveCallable
                public Object runReflectiveCall() {
                    return BlockJUnit4ClassRunner.this.createTest(frameworkMethod);
                }
            }.run();
            return withInterruptIsolation(withRules(frameworkMethod, objRun, withAfters(frameworkMethod, objRun, withBefores(frameworkMethod, objRun, withPotentialTimeout(frameworkMethod, objRun, possiblyExpectingExceptions(frameworkMethod, objRun, methodInvoker(frameworkMethod, objRun)))))));
        } catch (Throwable th) {
            return new Fail(th);
        }
    }

    public Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
        return new InvokeMethod(frameworkMethod, obj);
    }

    public Statement possiblyExpectingExceptions(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        Class<? extends Throwable> expectedException = getExpectedException((Test) frameworkMethod.getAnnotation(Test.class));
        return expectedException != null ? new ExpectException(statement, expectedException) : statement;
    }

    public List<MethodRule> rules(Object obj) {
        RuleCollector ruleCollector = new RuleCollector();
        getTestClass().collectAnnotatedMethodValues(obj, Rule.class, MethodRule.class, ruleCollector);
        getTestClass().collectAnnotatedFieldValues(obj, Rule.class, MethodRule.class, ruleCollector);
        return ruleCollector.result;
    }

    public String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    public void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
        validateZeroArgConstructor(list);
    }

    public void validateFields(List<Throwable> list) {
        RuleMemberValidator.RULE_VALIDATOR.validate(getTestClass(), list);
    }

    @Deprecated
    public void validateInstanceMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(After.class, false, list);
        validatePublicVoidNoArgMethods(Before.class, false, list);
        validateTestMethods(list);
        if (computeTestMethods().isEmpty()) {
            list.add(new Exception("No runnable methods"));
        }
    }

    public void validateNoNonStaticInnerClass(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass()) {
            list.add(new Exception("The inner class " + getTestClass().getName() + " is not static."));
        }
    }

    public void validateOnlyOneConstructor(List<Throwable> list) {
        if (hasOneConstructor()) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public constructor"));
    }

    public void validateTestMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(Test.class, false, list);
    }

    public void validateZeroArgConstructor(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass() || !hasOneConstructor() || getTestClass().getOnlyConstructor().getParameterTypes().length == 0) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
    }

    public Statement withAfters(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(After.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(statement, annotatedMethods, obj);
    }

    public Statement withBefores(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Before.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(statement, annotatedMethods, obj);
    }

    @Deprecated
    public Statement withPotentialTimeout(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        long timeout = getTimeout((Test) frameworkMethod.getAnnotation(Test.class));
        return timeout <= 0 ? statement : FailOnTimeout.builder().withTimeout(timeout, TimeUnit.MILLISECONDS).build(statement);
    }

    public Object createTest(FrameworkMethod frameworkMethod) {
        return createTest();
    }

    @Override // org.junit.runners.ParentRunner
    public Description describeChild(FrameworkMethod frameworkMethod) {
        Description description = this.methodDescriptions.get(frameworkMethod);
        if (description != null) {
            return description;
        }
        Description descriptionCreateTestDescription = Description.createTestDescription(getTestClass().getJavaClass(), testName(frameworkMethod), frameworkMethod.getAnnotations());
        this.methodDescriptions.putIfAbsent(frameworkMethod, descriptionCreateTestDescription);
        return descriptionCreateTestDescription;
    }

    @Override // org.junit.runners.ParentRunner
    public boolean isIgnored(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotation(Ignore.class) != null;
    }

    @Override // org.junit.runners.ParentRunner
    public void runChild(final FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        Description descriptionDescribeChild = describeChild(frameworkMethod);
        if (isIgnored(frameworkMethod)) {
            runNotifier.fireTestIgnored(descriptionDescribeChild);
        } else {
            runLeaf(new Statement() { // from class: org.junit.runners.BlockJUnit4ClassRunner.1
                @Override // org.junit.runners.model.Statement
                public void evaluate() {
                    BlockJUnit4ClassRunner.this.methodBlock(frameworkMethod).evaluate();
                }
            }, descriptionDescribeChild, runNotifier);
        }
    }

    public BlockJUnit4ClassRunner(TestClass testClass) {
        super(testClass);
        this.methodDescriptions = new ConcurrentHashMap();
    }
}
