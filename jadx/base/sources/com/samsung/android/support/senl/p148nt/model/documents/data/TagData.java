package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class TagData implements Parcelable, Cloneable {
    @ColorInt
    public abstract int getColor();

    public abstract String getName();

    public abstract TagData setColor(@ColorInt int i);

    public abstract TagData setName(String str);

    @Override // 
    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TagData mo22198clone() {
        return (TagData) super.clone();
    }
}
