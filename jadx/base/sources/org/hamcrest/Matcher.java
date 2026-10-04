package org.hamcrest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Matcher<T> extends SelfDescribing {
    @Deprecated
    void _dont_implement_Matcher___instead_extend_BaseMatcher_();

    void describeMismatch(Object obj, Description description);

    boolean matches(Object obj);
}
