package com.samsung.android.sdk.scs.p142ai.text.category;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DocumentCategory {
    private long categoryId;
    private String categoryName;
    private double categoryScore;

    public static DocumentCategory create() {
        return new DocumentCategory();
    }

    public long getId() {
        return this.categoryId;
    }

    public String getName() {
        return this.categoryName;
    }

    public double getScore() {
        return this.categoryScore;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setId(Long l) {
        this.categoryId = l.longValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setName(String str) {
        this.categoryName = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setScore(double d) {
        this.categoryScore = d;
    }
}
