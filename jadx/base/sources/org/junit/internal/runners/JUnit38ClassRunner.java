package org.junit.internal.runners;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.lang.annotation.Annotation;
import junit.extensions.TestDecorator;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class JUnit38ClassRunner extends Runner implements Filterable, Orderable {
    private volatile Test test;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class OldTestClassAdaptingListener implements TestListener {
        private final RunNotifier notifier;

        private Description asDescription(Test test) {
            return test instanceof Describable ? ((Describable) test).getDescription() : Description.createTestDescription(getEffectiveClass(test), getName(test));
        }

        private Class<? extends Test> getEffectiveClass(Test test) {
            return test.getClass();
        }

        private String getName(Test test) {
            return test instanceof TestCase ? ((TestCase) test).getName() : test.toString();
        }

        @Override // junit.framework.TestListener
        public void addError(Test test, Throwable th) {
            this.notifier.fireTestFailure(new Failure(asDescription(test), th));
        }

        @Override // junit.framework.TestListener
        public void addFailure(Test test, AssertionFailedError assertionFailedError) {
            addError(test, assertionFailedError);
        }

        @Override // junit.framework.TestListener
        public void endTest(Test test) {
            this.notifier.fireTestFinished(asDescription(test));
        }

        @Override // junit.framework.TestListener
        public void startTest(Test test) {
            this.notifier.fireTestStarted(asDescription(test));
        }

        private OldTestClassAdaptingListener(RunNotifier runNotifier) {
            this.notifier = runNotifier;
        }
    }

    public JUnit38ClassRunner(Class<?> cls) {
        this(new TestSuite(cls.asSubclass(TestCase.class)));
    }

    private static String createSuiteDescription(TestSuite testSuite) {
        int iCountTestCases = testSuite.countTestCases();
        return AbstractC2322a.m1616f(iCountTestCases, "TestSuite with ", " tests", iCountTestCases == 0 ? "" : String.format(" [example: %s]", testSuite.testAt(0)));
    }

    private static Annotation[] getAnnotations(TestCase testCase) {
        try {
            return testCase.getClass().getMethod(testCase.getName(), null).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private Test getTest() {
        return this.test;
    }

    private static Description makeDescription(Test test) {
        if (test instanceof TestCase) {
            TestCase testCase = (TestCase) test;
            return Description.createTestDescription(testCase.getClass(), testCase.getName(), getAnnotations(testCase));
        }
        if (!(test instanceof TestSuite)) {
            return test instanceof Describable ? ((Describable) test).getDescription() : test instanceof TestDecorator ? makeDescription(((TestDecorator) test).getTest()) : Description.createSuiteDescription(test.getClass());
        }
        TestSuite testSuite = (TestSuite) test;
        Description descriptionCreateSuiteDescription = Description.createSuiteDescription(testSuite.getName() == null ? createSuiteDescription(testSuite) : testSuite.getName(), new Annotation[0]);
        int iTestCount = testSuite.testCount();
        for (int i = 0; i < iTestCount; i++) {
            descriptionCreateSuiteDescription.addChild(makeDescription(testSuite.testAt(i)));
        }
        return descriptionCreateSuiteDescription;
    }

    private void setTest(Test test) {
        this.test = test;
    }

    public TestListener createAdaptingListener(RunNotifier runNotifier) {
        return new OldTestClassAdaptingListener(runNotifier);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        if (getTest() instanceof Filterable) {
            ((Filterable) getTest()).filter(filter);
            return;
        }
        if (getTest() instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) getTest();
            TestSuite testSuite2 = new TestSuite(testSuite.getName());
            int iTestCount = testSuite.testCount();
            for (int i = 0; i < iTestCount; i++) {
                Test testTestAt = testSuite.testAt(i);
                if (filter.shouldRun(makeDescription(testTestAt))) {
                    testSuite2.addTest(testTestAt);
                }
            }
            setTest(testSuite2);
            if (testSuite2.testCount() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return makeDescription(getTest());
    }

    @Override // org.junit.runner.manipulation.Orderable
    public void order(Orderer orderer) {
        if (getTest() instanceof Orderable) {
            ((Orderable) getTest()).order(orderer);
        }
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        TestResult testResult = new TestResult();
        testResult.addListener(createAdaptingListener(runNotifier));
        getTest().run(testResult);
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (getTest() instanceof Sortable) {
            ((Sortable) getTest()).sort(sorter);
        }
    }

    public JUnit38ClassRunner(Test test) {
        setTest(test);
    }
}
