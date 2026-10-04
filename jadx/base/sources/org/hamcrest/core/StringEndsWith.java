package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringEndsWith extends SubstringMatcher {
    public StringEndsWith(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> endsWith(String str) {
        return new StringEndsWith(str);
    }

    @Override // org.hamcrest.core.SubstringMatcher
    public boolean evalSubstringOf(String str) {
        return str.endsWith(this.substring);
    }

    @Override // org.hamcrest.core.SubstringMatcher
    public String relationship() {
        return "ending with";
    }
}
