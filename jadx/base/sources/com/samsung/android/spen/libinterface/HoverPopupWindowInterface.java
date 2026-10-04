package com.samsung.android.spen.libinterface;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HoverPopupWindowInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HoverPopupWindowListenerCallback {
        boolean onSetContentView(View view, HoverPopupWindowInterface hoverPopupWindowInterface);
    }

    void setContent(View view);

    void setContent(CharSequence charSequence);

    void setGravity(int i);

    void setHoverPopupListener(HoverPopupWindowListenerCallback hoverPopupWindowListenerCallback);

    void setOffset(int i, int i2);

    void show();

    void show(int i);
}
