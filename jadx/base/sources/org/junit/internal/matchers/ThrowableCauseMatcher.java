package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ThrowableCauseMatcher<T extends Throwable> extends org.hamcrest.TypeSafeMatcher<T> {
    private final Matcher<?> causeMatcher;

    public ThrowableCauseMatcher(Matcher<?> matcher) {
        this.causeMatcher = matcher;
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasCause(Matcher<?> matcher) {
        return new ThrowableCauseMatcher(matcher);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("exception with cause ");
        description.appendDescriptionOf(this.causeMatcher);
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(T t, Description description) {
        description.appendText("cause ");
        this.causeMatcher.describeMismatch(t.getCause(), description);
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(T t) {
        return this.causeMatcher.matches(t.getCause());
    }
}
