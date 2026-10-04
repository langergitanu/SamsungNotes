package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Assume {
    @Deprecated
    public Assume() {
    }

    public static void assumeFalse(boolean z) {
        assumeThat(Boolean.valueOf(z), CoreMatchers.m14978is(Boolean.FALSE));
    }

    public static void assumeNoException(Throwable th) {
        assumeThat(th, CoreMatchers.nullValue());
    }

    public static void assumeNotNull(Object... objArr) {
        assumeThat(objArr, CoreMatchers.notNullValue());
        assumeThat(Arrays.asList(objArr), CoreMatchers.everyItem(CoreMatchers.notNullValue()));
    }

    public static <T> void assumeThat(T t, Matcher<T> matcher) {
        if (!matcher.matches(t)) {
            throw new AssumptionViolatedException(t, matcher);
        }
    }

    public static void assumeTrue(boolean z) {
        assumeThat(Boolean.valueOf(z), CoreMatchers.m14978is(Boolean.TRUE));
    }

    public static void assumeFalse(String str, boolean z) {
        assumeTrue(str, !z);
    }

    public static void assumeNoException(String str, Throwable th) {
        assumeThat(str, th, CoreMatchers.nullValue());
    }

    public static void assumeTrue(String str, boolean z) {
        if (!z) {
            throw new AssumptionViolatedException(str);
        }
    }

    public static <T> void assumeThat(String str, T t, Matcher<T> matcher) {
        if (!matcher.matches(t)) {
            throw new AssumptionViolatedException(str, t, matcher);
        }
    }
}
