package com.samsung.android.sdk.scs.p142ai.text.category;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DocumentSimilarity {
    private boolean isSimilar;
    private double similarityScore;

    public static DocumentSimilarity create() {
        return new DocumentSimilarity();
    }

    public double getScore() {
        return this.similarityScore;
    }

    public boolean isSimilar() {
        return this.isSimilar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setScore(double d) {
        this.similarityScore = d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setSimilarity(boolean z) {
        this.isSimilar = z;
    }
}
