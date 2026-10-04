package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class VElementBase {
    private String mId;

    public String getId() {
        return this.mId;
    }

    public abstract void setDefaultMember();

    public void setId(String str) {
        this.mId = str;
    }

    public String toString() {
        return AbstractC0622a.m1170p(this.mId, "]", new StringBuilder("Element [mId="));
    }
}
