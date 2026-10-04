package org.junit.internal.requests;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Sorter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SortingRequest extends Request {
    private final Comparator<Description> comparator;
    private final Request request;

    public SortingRequest(Request request, Comparator<Description> comparator) {
        this.request = request;
        this.comparator = comparator;
    }

    @Override // org.junit.runner.Request
    public Runner getRunner() {
        Runner runner = this.request.getRunner();
        new Sorter(this.comparator).apply(runner);
        return runner;
    }
}
