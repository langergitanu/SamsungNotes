package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SubstringMatcher extends TypeSafeMatcher<String> {
    protected final String substring;

    public SubstringMatcher(String str) {
        this.substring = str;
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("a string ").appendText(relationship()).appendText(" ").appendValue(this.substring);
    }

    public abstract boolean evalSubstringOf(String str);

    public abstract String relationship();

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(String str, Description description) {
        description.appendText("was \"").appendText(str).appendText("\"");
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(String str) {
        return evalSubstringOf(str);
    }
}
