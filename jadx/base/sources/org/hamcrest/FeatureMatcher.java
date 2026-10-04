package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class FeatureMatcher<T, U> extends TypeSafeDiagnosingMatcher<T> {
    private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("featureValueOf", 1, 0);
    private final String featureDescription;
    private final String featureName;
    private final Matcher<? super U> subMatcher;

    public FeatureMatcher(Matcher<? super U> matcher, String str, String str2) {
        super(TYPE_FINDER);
        this.subMatcher = matcher;
        this.featureDescription = str;
        this.featureName = str2;
    }

    @Override // org.hamcrest.SelfDescribing
    public final void describeTo(Description description) {
        description.appendText(this.featureDescription).appendText(" ").appendDescriptionOf(this.subMatcher);
    }

    public abstract U featureValueOf(T t);

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(T t, Description description) {
        U uFeatureValueOf = featureValueOf(t);
        if (this.subMatcher.matches(uFeatureValueOf)) {
            return true;
        }
        description.appendText(this.featureName).appendText(" ");
        this.subMatcher.describeMismatch(uFeatureValueOf, description);
        return false;
    }
}
