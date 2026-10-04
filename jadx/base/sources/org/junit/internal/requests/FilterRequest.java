package org.junit.internal.requests;

import androidx.appcompat.widget.AbstractC0541b;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class FilterRequest extends Request {
    private final Filter fFilter;
    private final Request request;

    public FilterRequest(Request request, Filter filter) {
        this.request = request;
        this.fFilter = filter;
    }

    @Override // org.junit.runner.Request
    public Runner getRunner() {
        try {
            Runner runner = this.request.getRunner();
            this.fFilter.apply(runner);
            return runner;
        } catch (NoTestsRemainException unused) {
            return new ErrorReportingRunner((Class<?>) Filter.class, new Exception(AbstractC0541b.m774p("No tests found matching ", this.fFilter.describe(), " from ", this.request.toString())));
        }
    }
}
