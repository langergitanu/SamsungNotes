package org.hamcrest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MatcherAssert {
    public static <T> void assertThat(T t, Matcher<? super T> matcher) {
        assertThat("", t, matcher);
    }

    public static <T> void assertThat(String str, T t, Matcher<? super T> matcher) {
        if (matcher.matches(t)) {
            return;
        }
        StringDescription stringDescription = new StringDescription();
        stringDescription.appendText(str).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n     but: ");
        matcher.describeMismatch(t, stringDescription);
        throw new AssertionError(stringDescription.toString());
    }

    public static void assertThat(String str, boolean z) {
        if (!z) {
            throw new AssertionError(str);
        }
    }
}
