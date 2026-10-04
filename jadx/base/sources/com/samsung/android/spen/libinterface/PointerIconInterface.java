package com.samsung.android.spen.libinterface;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface PointerIconInterface {
    boolean isPointerIconSupported();

    void removeHoveringSpenCustomIcon();

    void setHoveringSpenIcon(Context context, View view, int i);

    void setHoveringSpenIcon(Context context, View view, int i, int i2);

    void setHoveringSpenIcon(View view, Drawable drawable, Point point);

    void setHoveringSpenIcon(View view, Drawable drawable, Point point, int i);
}
