package junit.framework;

import org.junit.runner.Describable;
import org.junit.runner.Description;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class JUnit4TestCaseFacade implements Test, Describable {
    private final Description fDescription;

    public JUnit4TestCaseFacade(Description description) {
        this.fDescription = description;
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return 1;
    }

    @Override // org.junit.runner.Describable
    public Description getDescription() {
        return this.fDescription;
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    public String toString() {
        return getDescription().toString();
    }
}
