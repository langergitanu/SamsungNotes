package org.apache.commons.text.similarity;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FuzzyScore {
    private final Locale locale;

    public FuzzyScore(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null");
        }
        this.locale = locale;
    }

    public Integer fuzzyScore(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("CharSequences must not be null");
        }
        String lowerCase = charSequence.toString().toLowerCase(this.locale);
        String lowerCase2 = charSequence2.toString().toLowerCase(this.locale);
        int i = Integer.MIN_VALUE;
        int i2 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < lowerCase2.length(); i5++) {
            char cCharAt = lowerCase2.charAt(i5);
            boolean z = false;
            while (i4 < lowerCase.length() && !z) {
                if (cCharAt == lowerCase.charAt(i4)) {
                    int i6 = i2 + 1;
                    if (i + 1 == i4) {
                        i6 = i2 + 3;
                    }
                    i2 = i6;
                    z = true;
                    i = i4;
                }
                i4++;
            }
        }
        return Integer.valueOf(i2);
    }

    public Locale getLocale() {
        return this.locale;
    }
}
