package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2) {
        return null;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i, int i2, int i4, boolean z, boolean z2, @Nullable CharSequence charSequence) {
        return charSequence;
    }
}
