package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IsAnything<T> extends BaseMatcher<T> {
    private final String message;

    public IsAnything() {
        this("ANYTHING");
    }

    @Factory
    public static Matcher<Object> anything() {
        return new IsAnything();
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText(this.message);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return true;
    }

    public IsAnything(String str) {
        this.message = str;
    }

    @Factory
    public static Matcher<Object> anything(String str) {
        return new IsAnything(str);
    }
}
