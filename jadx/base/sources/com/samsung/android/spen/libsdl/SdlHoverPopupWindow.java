package com.samsung.android.spen.libsdl;

import android.view.View;
import android.widget.HoverPopupWindow;
import com.samsung.android.spen.libinterface.HoverPopupWindowInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlHoverPopupWindow implements HoverPopupWindowInterface {
    public static int TYPE_NONE = 0;
    public static int TYPE_TOOLTIP = 1;
    public static int TYPE_USER_CUSTOM = 3;
    public static int TYPE_WIDGET_DEFAULT = 2;
    HoverPopupWindow instance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Gravity {
        public static int BOTTOM = 80;
        public static int CENTER_VERTICAL = 16;
        public static int LEFT = 3;
        public static int RIGHT = 5;
        public static int TOP = 48;

        private Gravity() {
        }
    }

    public SdlHoverPopupWindow(HoverPopupWindow hoverPopupWindow) {
        this.instance = hoverPopupWindow;
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setContent(CharSequence charSequence) {
        HoverPopupWindow hoverPopupWindow = this.instance;
        if (hoverPopupWindow != null) {
            hoverPopupWindow.setContent(charSequence);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setGravity(int i) {
        HoverPopupWindow hoverPopupWindow = this.instance;
        if (hoverPopupWindow != null) {
            hoverPopupWindow.setPopupGravity(i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setHoverPopupListener(final HoverPopupWindowInterface.HoverPopupWindowListenerCallback hoverPopupWindowListenerCallback) {
        new HoverPopupWindow.HoverPopupListener() { // from class: com.samsung.android.spen.libsdl.SdlHoverPopupWindow.1
            public boolean onSetContentView(View view, HoverPopupWindow hoverPopupWindow) {
                hoverPopupWindowListenerCallback.onSetContentView(view, new SdlHoverPopupWindow(hoverPopupWindow));
                return true;
            }
        };
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setOffset(int i, int i2) {
        HoverPopupWindow hoverPopupWindow = this.instance;
        if (hoverPopupWindow != null) {
            hoverPopupWindow.setPopupPosOffset(i, i2);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void show() {
        HoverPopupWindow hoverPopupWindow = this.instance;
        if (hoverPopupWindow != null) {
            hoverPopupWindow.show(1);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setContent(View view) {
        HoverPopupWindow hoverPopupWindow = this.instance;
        if (hoverPopupWindow != null) {
            hoverPopupWindow.setContent(view);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void show(int i) {
        HoverPopupWindow hoverPopupWindow = this.instance;
        if (hoverPopupWindow != null) {
            hoverPopupWindow.show(i);
        }
    }
}
