package org.junit.internal.runners.model;

import java.util.Iterator;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class EachTestNotifier {
    private final Description description;
    private final RunNotifier notifier;

    public EachTestNotifier(RunNotifier runNotifier, Description description) {
        this.notifier = runNotifier;
        this.description = description;
    }

    private void addMultipleFailureException(org.junit.runners.model.MultipleFailureException multipleFailureException) {
        Iterator<Throwable> it = multipleFailureException.getFailures().iterator();
        while (it.hasNext()) {
            addFailure(it.next());
        }
    }

    public void addFailedAssumption(AssumptionViolatedException assumptionViolatedException) {
        this.notifier.fireTestAssumptionFailed(new Failure(this.description, assumptionViolatedException));
    }

    public void addFailure(Throwable th) {
        if (th instanceof org.junit.runners.model.MultipleFailureException) {
            addMultipleFailureException((org.junit.runners.model.MultipleFailureException) th);
        } else {
            this.notifier.fireTestFailure(new Failure(this.description, th));
        }
    }

    public void fireTestFinished() {
        this.notifier.fireTestFinished(this.description);
    }

    public void fireTestIgnored() {
        this.notifier.fireTestIgnored(this.description);
    }

    public void fireTestStarted() {
        this.notifier.fireTestStarted(this.description);
    }

    public void fireTestSuiteFinished() {
        this.notifier.fireTestSuiteFinished(this.description);
    }

    public void fireTestSuiteStarted() {
        this.notifier.fireTestSuiteStarted(this.description);
    }
}
