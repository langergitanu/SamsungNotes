package junit.extensions;

import androidx.collection.AbstractC0622a;
import junit.framework.Test;
import junit.framework.TestResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class RepeatedTest extends TestDecorator {
    private int fTimesRepeat;

    public RepeatedTest(Test test, int i) {
        super(test);
        if (i < 0) {
            throw new IllegalArgumentException("Repetition count must be >= 0");
        }
        this.fTimesRepeat = i;
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public int countTestCases() {
        return super.countTestCases() * this.fTimesRepeat;
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public void run(TestResult testResult) {
        for (int i = 0; i < this.fTimesRepeat && !testResult.shouldStop(); i++) {
            super.run(testResult);
        }
    }

    @Override // junit.extensions.TestDecorator
    public String toString() {
        return AbstractC0622a.m1170p(super.toString(), "(repeated)", new StringBuilder());
    }
}
