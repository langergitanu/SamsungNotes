package com.samsung.android.spen.libsdl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import android.view.View;
import com.samsung.android.spen.libinterface.HoverPopupWindowInterface;
import com.samsung.android.spen.libinterface.ViewInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlView implements ViewInterface {
    private View instance;

    public SdlView(View view) {
        this.instance = view;
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void extractSmartClipData() {
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public HoverPopupWindowInterface getHoverPopupWindow() {
        return new SdlHoverPopupWindow(this.instance.getHoverPopupWindow());
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void performHapticFeedback(int i) {
        if (i != 1) {
            return;
        }
        this.instance.performHapticFeedback(0);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void requestAccessibilityFocus() {
        this.instance.sendAccessibilityEvent(8);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setHoverPopupType(int i) {
        this.instance.setHoverPopupType(i);
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setPointerIcon(int i, PointerIcon pointerIcon) {
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setPointerIcon(Context context, int i) {
    }

    @Override // com.samsung.android.spen.libinterface.ViewInterface
    public void setPointerIcon(Resources resources, Bitmap bitmap, float f, float f4) {
    }
}
