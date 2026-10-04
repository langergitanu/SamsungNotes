package junit.extensions;

import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class TestSetup extends TestDecorator {
    public TestSetup(Test test) {
        super(test);
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public void run(final TestResult testResult) {
        testResult.runProtected(this, new Protectable() { // from class: junit.extensions.TestSetup.1
            @Override // junit.framework.Protectable
            public void protect() {
                TestSetup.this.setUp();
                TestSetup.this.basicRun(testResult);
                TestSetup.this.tearDown();
            }
        });
    }

    public void setUp() {
    }

    public void tearDown() {
    }
}
