package org.apache.commons.text.matcher;

import org.apache.commons.lang3.CharSequenceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface StringMatcher {
    default StringMatcher andThen(StringMatcher stringMatcher) {
        return StringMatcherFactory.INSTANCE.andMatcher(this, stringMatcher);
    }

    default int isMatch(char[] cArr, int i) {
        return isMatch(cArr, i, 0, cArr.length);
    }

    int isMatch(char[] cArr, int i, int i2, int i4);

    default int size() {
        return 0;
    }

    default int isMatch(CharSequence charSequence, int i) {
        return isMatch(charSequence, i, 0, charSequence.length());
    }

    default int isMatch(CharSequence charSequence, int i, int i2, int i4) {
        return isMatch(CharSequenceUtils.toCharArray(charSequence), i, i4, i4);
    }
}
