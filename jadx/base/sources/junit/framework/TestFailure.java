package junit.framework;

import org.junit.internal.Throwables;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class TestFailure {
    protected Test fFailedTest;
    protected Throwable fThrownException;

    public TestFailure(Test test, Throwable th) {
        this.fFailedTest = test;
        this.fThrownException = th;
    }

    public String exceptionMessage() {
        return thrownException().getMessage();
    }

    public Test failedTest() {
        return this.fFailedTest;
    }

    public boolean isFailure() {
        return thrownException() instanceof AssertionFailedError;
    }

    public Throwable thrownException() {
        return this.fThrownException;
    }

    public String toString() {
        return this.fFailedTest + ": " + this.fThrownException.getMessage();
    }

    public String trace() {
        return Throwables.getStacktrace(thrownException());
    }
}
