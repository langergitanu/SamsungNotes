package org.junit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TestCouldNotBeSkippedException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public TestCouldNotBeSkippedException(org.junit.internal.AssumptionViolatedException assumptionViolatedException) {
        super("Test could not be skipped due to other failures", assumptionViolatedException);
    }
}
