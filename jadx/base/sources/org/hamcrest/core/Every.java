package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Every<T> extends TypeSafeDiagnosingMatcher<Iterable<T>> {
    private final Matcher<? super T> matcher;

    public Every(Matcher<? super T> matcher) {
        this.matcher = matcher;
    }

    @Factory
    public static <U> Matcher<Iterable<U>> everyItem(Matcher<U> matcher) {
        return new Every(matcher);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("every item is ").appendDescriptionOf(this.matcher);
    }

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(Iterable<T> iterable, Description description) {
        for (T t : iterable) {
            if (!this.matcher.matches(t)) {
                description.appendText("an item ");
                this.matcher.describeMismatch(t, description);
                return false;
            }
        }
        return true;
    }
}
