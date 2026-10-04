package org.junit.internal.requests;

import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.Ordering;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class OrderingRequest extends MemoizingRequest {
    private final Ordering ordering;
    private final Request request;

    public OrderingRequest(Request request, Ordering ordering) {
        this.request = request;
        this.ordering = ordering;
    }

    @Override // org.junit.internal.requests.MemoizingRequest
    public Runner createRunner() {
        Runner runner = this.request.getRunner();
        try {
            this.ordering.apply(runner);
            return runner;
        } catch (InvalidOrderingException e) {
            return new ErrorReportingRunner(this.ordering.getClass(), e);
        }
    }
}
