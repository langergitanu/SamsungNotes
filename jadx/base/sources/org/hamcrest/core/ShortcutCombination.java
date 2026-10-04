package org.hamcrest.core;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Iterator;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class ShortcutCombination<T> extends BaseMatcher<T> {
    private final Iterable<Matcher<? super T>> matchers;

    public ShortcutCombination(Iterable<Matcher<? super T>> iterable) {
        this.matchers = iterable;
    }

    @Override // org.hamcrest.SelfDescribing
    public abstract void describeTo(Description description);

    public void describeTo(Description description, String str) {
        description.appendList("(", AbstractC0541b.m773o(" ", str, " "), ")", this.matchers);
    }

    @Override // org.hamcrest.Matcher
    public abstract boolean matches(Object obj);

    public boolean matches(Object obj, boolean z) {
        Iterator<Matcher<? super T>> it = this.matchers.iterator();
        while (it.hasNext()) {
            if (it.next().matches(obj) == z) {
                return z;
            }
        }
        return !z;
    }
}
