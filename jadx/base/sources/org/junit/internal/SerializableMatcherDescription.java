package org.junit.internal;

import java.io.Serializable;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
class SerializableMatcherDescription<T> extends BaseMatcher<T> implements Serializable {
    private final String matcherDescription;

    private SerializableMatcherDescription(Matcher<T> matcher) {
        this.matcherDescription = StringDescription.asString(matcher);
    }

    public static <T> Matcher<T> asSerializableMatcher(Matcher<T> matcher) {
        return (matcher == null || (matcher instanceof Serializable)) ? matcher : new SerializableMatcherDescription(matcher);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText(this.matcherDescription);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        throw new UnsupportedOperationException("This Matcher implementation only captures the description");
    }
}
