package org.junit;

import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t, Matcher<T> matcher) {
        super((Object) t, (Matcher<?>) matcher);
    }

    public <T> AssumptionViolatedException(String str, T t, Matcher<T> matcher) {
        super(str, t, matcher);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th) {
        super(str, th);
    }
}
