package junit.extensions;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class TestDecorator extends Assert implements Test {
    protected Test fTest;

    public TestDecorator(Test test) {
        this.fTest = test;
    }

    public void basicRun(TestResult testResult) {
        this.fTest.run(testResult);
    }

    public int countTestCases() {
        return this.fTest.countTestCases();
    }

    public Test getTest() {
        return this.fTest;
    }

    public void run(TestResult testResult) {
        basicRun(testResult);
    }

    public String toString() {
        return this.fTest.toString();
    }
}
