package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.C4536R;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.util.DeviceProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int zab(int i, int i2, int i4, int i5) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i4;
        }
        if (i == 2) {
            return i5;
        }
        throw new IllegalStateException(AbstractC4539a.m3197g(33, i, "Unknown color scheme: "));
    }

    public final void zaa(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i4 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i4);
        setMinWidth(i4);
        int i5 = C4536R.drawable.common_google_signin_btn_icon_dark;
        int i6 = C4536R.drawable.common_google_signin_btn_icon_light;
        int iZab = zab(i2, i5, i6, i6);
        int i7 = C4536R.drawable.common_google_signin_btn_text_dark;
        int i8 = C4536R.drawable.common_google_signin_btn_text_light;
        int iZab2 = zab(i2, i7, i8, i8);
        if (i == 0 || i == 1) {
            iZab = iZab2;
        } else if (i != 2) {
            throw new IllegalStateException(AbstractC4539a.m3197g(32, i, "Unknown button size: "));
        }
        Drawable drawableWrap = DrawableCompat.wrap(resources.getDrawable(iZab));
        DrawableCompat.setTintList(drawableWrap, resources.getColorStateList(C4536R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(drawableWrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawableWrap);
        int i9 = C4536R.color.common_google_signin_btn_text_dark;
        int i10 = C4536R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i2, i9, i10, i10))));
        if (i == 0) {
            setText(resources.getString(C4536R.string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(C4536R.string.common_signin_button_text_long));
        } else {
            if (i != 2) {
                throw new IllegalStateException(AbstractC4539a.m3197g(32, i, "Unknown button size: "));
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
