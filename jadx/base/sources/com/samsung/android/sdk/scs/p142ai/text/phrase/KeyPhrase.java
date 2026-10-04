package com.samsung.android.sdk.scs.p142ai.text.phrase;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyPhrase {
    private double phraseScore;
    private String phraseText;

    public static KeyPhrase create() {
        return new KeyPhrase();
    }

    public double getScore() {
        return this.phraseScore;
    }

    public String getString() {
        return this.phraseText;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setScore(double d) {
        this.phraseScore = d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setString(String str) {
        this.phraseText = str;
    }
}
