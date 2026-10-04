package com.samsung.android.spen.libinterface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ViewInterface {
    void extractSmartClipData();

    HoverPopupWindowInterface getHoverPopupWindow();

    void performHapticFeedback(int i);

    void requestAccessibilityFocus();

    void setHoverPopupType(int i);

    void setPointerIcon(int i, PointerIcon pointerIcon);

    void setPointerIcon(Context context, int i);

    void setPointerIcon(Resources resources, Bitmap bitmap, float f, float f4);
}
