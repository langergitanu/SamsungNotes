package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: renamed from: org.hamcrest.core.Is */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class C14250Is<T> extends BaseMatcher<T> {
    private final Matcher<T> matcher;

    public C14250Is(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    @Factory
    /* JADX INFO: renamed from: is */
    public static <T> Matcher<T> m14984is(Matcher<T> matcher) {
        return new C14250Is(matcher);
    }

    @Factory
    public static <T> Matcher<T> isA(Class<T> cls) {
        return m14984is(IsInstanceOf.instanceOf(cls));
    }

    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public void describeMismatch(Object obj, Description description) {
        this.matcher.describeMismatch(obj, description);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("is ").appendDescriptionOf(this.matcher);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return this.matcher.matches(obj);
    }

    @Factory
    /* JADX INFO: renamed from: is */
    public static <T> Matcher<T> m14983is(T t) {
        return m14984is(IsEqual.equalTo(t));
    }

    @Factory
    @Deprecated
    /* JADX INFO: renamed from: is */
    public static <T> Matcher<T> m14982is(Class<T> cls) {
        return m14984is(IsInstanceOf.instanceOf(cls));
    }
}
