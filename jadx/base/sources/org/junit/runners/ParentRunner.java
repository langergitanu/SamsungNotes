package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.Checks;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.RuleContainer;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InvalidTestClassError;
import org.junit.runners.model.MemberValueConsumer;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.TestClassValidator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class ParentRunner<T> extends Runner implements Filterable, Orderable {
    private static final List<TestClassValidator> VALIDATORS = Collections.singletonList(new AnnotationsValidator());
    private final Lock childrenLock = new ReentrantLock();
    private volatile List<T> filteredChildren = null;
    private volatile RunnerScheduler scheduler = new RunnerScheduler() { // from class: org.junit.runners.ParentRunner.1
        @Override // org.junit.runners.model.RunnerScheduler
        public void schedule(Runnable runnable) {
            runnable.run();
        }

        @Override // org.junit.runners.model.RunnerScheduler
        public void finished() {
        }
    };
    private final TestClass testClass;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ClassRuleCollector implements MemberValueConsumer<TestRule> {
        final List<RuleContainer.RuleEntry> entries;

        private ClassRuleCollector() {
            this.entries = new ArrayList();
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public /* bridge */ /* synthetic */ void accept(FrameworkMember frameworkMember, TestRule testRule) {
            accept2((FrameworkMember<?>) frameworkMember, testRule);
        }

        public List<TestRule> getOrderedRules() {
            Collections.sort(this.entries, RuleContainer.ENTRY_COMPARATOR);
            ArrayList arrayList = new ArrayList(this.entries.size());
            Iterator<RuleContainer.RuleEntry> it = this.entries.iterator();
            while (it.hasNext()) {
                arrayList.add((TestRule) it.next().rule);
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(FrameworkMember<?> frameworkMember, TestRule testRule) {
            ClassRule classRule = (ClassRule) frameworkMember.getAnnotation(ClassRule.class);
            this.entries.add(new RuleContainer.RuleEntry(testRule, 1, classRule != null ? Integer.valueOf(classRule.order()) : null));
        }
    }

    public ParentRunner(Class<?> cls) throws InvalidTestClassError {
        this.testClass = createTestClass(cls);
        validate();
    }

    private void applyValidators(List<Throwable> list) {
        if (getTestClass().getJavaClass() != null) {
            Iterator<TestClassValidator> it = VALIDATORS.iterator();
            while (it.hasNext()) {
                list.addAll(it.next().validateTestClass(getTestClass()));
            }
        }
    }

    private boolean areAllChildrenIgnored() {
        Iterator<T> it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            if (!isIgnored(it.next())) {
                return false;
            }
        }
        return true;
    }

    private Comparator<? super T> comparator(final Sorter sorter) {
        return new Comparator<T>() { // from class: org.junit.runners.ParentRunner.5
            @Override // java.util.Comparator
            public int compare(T t, T t2) {
                return sorter.compare(ParentRunner.this.describeChild(t), ParentRunner.this.describeChild(t2));
            }
        };
    }

    private List<T> getFilteredChildren() {
        if (this.filteredChildren == null) {
            this.childrenLock.lock();
            try {
                if (this.filteredChildren == null) {
                    this.filteredChildren = Collections.unmodifiableList(new ArrayList(getChildren()));
                }
            } finally {
                this.childrenLock.unlock();
            }
        }
        return this.filteredChildren;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runChildren(final RunNotifier runNotifier) {
        RunnerScheduler runnerScheduler = this.scheduler;
        try {
            for (final T t : getFilteredChildren()) {
                runnerScheduler.schedule(new Runnable() { // from class: org.junit.runners.ParentRunner.4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ParentRunner.this.runChild(t, runNotifier);
                    }
                });
            }
        } finally {
            runnerScheduler.finished();
        }
    }

    private boolean shouldNotReorder() {
        return getDescription().getAnnotation(FixMethodOrder.class) != null;
    }

    private boolean shouldRun(Filter filter, T t) {
        return filter.shouldRun(describeChild(t));
    }

    private void validate() throws InvalidTestClassError {
        ArrayList arrayList = new ArrayList();
        collectInitializationErrors(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InvalidTestClassError(this.testClass.getJavaClass(), arrayList);
        }
    }

    private void validateClassRules(List<Throwable> list) {
        RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), list);
        RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    private Statement withClassRules(Statement statement) {
        List<TestRule> listClassRules = classRules();
        return listClassRules.isEmpty() ? statement : new RunRules(statement, listClassRules, getDescription());
    }

    public Statement childrenInvoker(final RunNotifier runNotifier) {
        return new Statement() { // from class: org.junit.runners.ParentRunner.2
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                ParentRunner.this.runChildren(runNotifier);
            }
        };
    }

    public Statement classBlock(RunNotifier runNotifier) {
        Statement statementChildrenInvoker = childrenInvoker(runNotifier);
        return !areAllChildrenIgnored() ? withInterruptIsolation(withClassRules(withAfterClasses(withBeforeClasses(statementChildrenInvoker)))) : statementChildrenInvoker;
    }

    public List<TestRule> classRules() {
        ClassRuleCollector classRuleCollector = new ClassRuleCollector();
        this.testClass.collectAnnotatedMethodValues(null, ClassRule.class, TestRule.class, classRuleCollector);
        this.testClass.collectAnnotatedFieldValues(null, ClassRule.class, TestRule.class, classRuleCollector);
        return classRuleCollector.getOrderedRules();
    }

    public void collectInitializationErrors(List<Throwable> list) {
        validatePublicVoidNoArgMethods(BeforeClass.class, true, list);
        validatePublicVoidNoArgMethods(AfterClass.class, true, list);
        validateClassRules(list);
        applyValidators(list);
    }

    @Deprecated
    public TestClass createTestClass(Class<?> cls) {
        return new TestClass(cls);
    }

    public abstract Description describeChild(T t);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) {
        this.childrenLock.lock();
        try {
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (shouldRun(filter, next)) {
                    try {
                        filter.apply(next);
                    } catch (NoTestsRemainException unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.filteredChildren = Collections.unmodifiableList(arrayList);
            if (this.filteredChildren.isEmpty()) {
                throw new NoTestsRemainException();
            }
        } finally {
            this.childrenLock.unlock();
        }
    }

    public abstract List<T> getChildren();

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Class<?> javaClass = getTestClass().getJavaClass();
        Description descriptionCreateSuiteDescription = (javaClass == null || !javaClass.getName().equals(getName())) ? Description.createSuiteDescription(getName(), getRunnerAnnotations()) : Description.createSuiteDescription(javaClass, getRunnerAnnotations());
        Iterator<T> it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            descriptionCreateSuiteDescription.addChild(describeChild(it.next()));
        }
        return descriptionCreateSuiteDescription;
    }

    public String getName() {
        return this.testClass.getName();
    }

    public Annotation[] getRunnerAnnotations() {
        return this.testClass.getAnnotations();
    }

    public final TestClass getTestClass() {
        return this.testClass;
    }

    public boolean isIgnored(T t) {
        return false;
    }

    @Override // org.junit.runner.manipulation.Orderable
    public void order(Orderer orderer) {
        if (shouldNotReorder()) {
            return;
        }
        this.childrenLock.lock();
        try {
            List<T> filteredChildren = getFilteredChildren();
            LinkedHashMap linkedHashMap = new LinkedHashMap(filteredChildren.size());
            for (T t : filteredChildren) {
                Description descriptionDescribeChild = describeChild(t);
                List arrayList = (List) linkedHashMap.get(descriptionDescribeChild);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    linkedHashMap.put(descriptionDescribeChild, arrayList);
                }
                arrayList.add(t);
                orderer.apply(t);
            }
            List<Description> listOrder = orderer.order(linkedHashMap.keySet());
            ArrayList arrayList2 = new ArrayList(filteredChildren.size());
            Iterator<Description> it = listOrder.iterator();
            while (it.hasNext()) {
                arrayList2.addAll((Collection) linkedHashMap.get(it.next()));
            }
            this.filteredChildren = Collections.unmodifiableList(arrayList2);
            this.childrenLock.unlock();
        } catch (Throwable th) {
            this.childrenLock.unlock();
            throw th;
        }
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, getDescription());
        eachTestNotifier.fireTestSuiteStarted();
        try {
            try {
                try {
                    classBlock(runNotifier).evaluate();
                    eachTestNotifier.fireTestSuiteFinished();
                } catch (AssumptionViolatedException e) {
                    eachTestNotifier.addFailedAssumption(e);
                    eachTestNotifier.fireTestSuiteFinished();
                }
            } catch (StoppedByUserException e2) {
                throw e2;
            } catch (Throwable th) {
                eachTestNotifier.addFailure(th);
                eachTestNotifier.fireTestSuiteFinished();
            }
        } catch (Throwable th2) {
            eachTestNotifier.fireTestSuiteFinished();
            throw th2;
        }
    }

    public abstract void runChild(T t, RunNotifier runNotifier);

    public final void runLeaf(Statement statement, Description description, RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, description);
        eachTestNotifier.fireTestStarted();
        try {
            try {
                try {
                    statement.evaluate();
                    eachTestNotifier.fireTestFinished();
                } catch (AssumptionViolatedException e) {
                    eachTestNotifier.addFailedAssumption(e);
                    eachTestNotifier.fireTestFinished();
                }
            } catch (Throwable th) {
                eachTestNotifier.addFailure(th);
                eachTestNotifier.fireTestFinished();
            }
        } catch (Throwable th2) {
            eachTestNotifier.fireTestFinished();
            throw th2;
        }
    }

    public void setScheduler(RunnerScheduler runnerScheduler) {
        this.scheduler = runnerScheduler;
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (shouldNotReorder()) {
            return;
        }
        this.childrenLock.lock();
        try {
            Iterator<T> it = getFilteredChildren().iterator();
            while (it.hasNext()) {
                sorter.apply(it.next());
            }
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Collections.sort(arrayList, comparator(sorter));
            this.filteredChildren = Collections.unmodifiableList(arrayList);
            this.childrenLock.unlock();
        } catch (Throwable th) {
            this.childrenLock.unlock();
            throw th;
        }
    }

    public void validatePublicVoidNoArgMethods(Class<? extends Annotation> cls, boolean z, List<Throwable> list) {
        Iterator<FrameworkMethod> it = getTestClass().getAnnotatedMethods(cls).iterator();
        while (it.hasNext()) {
            it.next().validatePublicVoidNoArg(z, list);
        }
    }

    public Statement withAfterClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(AfterClass.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(statement, annotatedMethods, null);
    }

    public Statement withBeforeClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(BeforeClass.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(statement, annotatedMethods, null);
    }

    public final Statement withInterruptIsolation(final Statement statement) {
        return new Statement() { // from class: org.junit.runners.ParentRunner.3
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                try {
                    statement.evaluate();
                } finally {
                    Thread.interrupted();
                }
            }
        };
    }

    public ParentRunner(TestClass testClass) throws InvalidTestClassError {
        this.testClass = (TestClass) Checks.notNull(testClass);
        validate();
    }
}
