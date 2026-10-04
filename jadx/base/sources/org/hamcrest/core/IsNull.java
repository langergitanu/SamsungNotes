package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IsNull<T> extends BaseMatcher<T> {
    @Factory
    public static Matcher<Object> notNullValue() {
        return IsNot.not((Matcher) nullValue());
    }

    @Factory
    public static Matcher<Object> nullValue() {
        return new IsNull();
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("null");
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return obj == null;
    }

    @Factory
    public static <T> Matcher<T> notNullValue(Class<T> cls) {
        return IsNot.not(nullValue(cls));
    }

    @Factory
    public static <T> Matcher<T> nullValue(Class<T> cls) {
        return new IsNull();
    }
}
