package com.samsung.android.spen.libse;

import android.view.View;
import com.samsung.android.spen.libinterface.HoverPopupWindowInterface;
import com.samsung.android.widget.SemHoverPopupWindow;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeHoverPopupWindow implements HoverPopupWindowInterface {
    public static int TYPE_NONE = 0;
    public static int TYPE_TOOLTIP = 1;
    public static int TYPE_USER_CUSTOM = 3;
    public static int TYPE_WIDGET_DEFAULT = 2;
    SemHoverPopupWindow instance;

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

    public SeHoverPopupWindow(SemHoverPopupWindow semHoverPopupWindow) {
        this.instance = semHoverPopupWindow;
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setContent(CharSequence charSequence) {
        SemHoverPopupWindow semHoverPopupWindow = this.instance;
        if (semHoverPopupWindow != null) {
            semHoverPopupWindow.setContent(charSequence);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setGravity(int i) {
        SemHoverPopupWindow semHoverPopupWindow = this.instance;
        if (semHoverPopupWindow != null) {
            semHoverPopupWindow.setGravity(i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setHoverPopupListener(final HoverPopupWindowInterface.HoverPopupWindowListenerCallback hoverPopupWindowListenerCallback) {
        new SemHoverPopupWindow.OnSetContentViewListener() { // from class: com.samsung.android.spen.libse.SeHoverPopupWindow.1
            public boolean onSetContentView(View view, SemHoverPopupWindow semHoverPopupWindow) {
                hoverPopupWindowListenerCallback.onSetContentView(view, new SeHoverPopupWindow(semHoverPopupWindow));
                return true;
            }
        };
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setOffset(int i, int i2) {
        SemHoverPopupWindow semHoverPopupWindow = this.instance;
        if (semHoverPopupWindow != null) {
            semHoverPopupWindow.setOffset(i, i2);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void show() {
        SemHoverPopupWindow semHoverPopupWindow = this.instance;
        if (semHoverPopupWindow != null) {
            semHoverPopupWindow.show();
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void setContent(View view) {
        SemHoverPopupWindow semHoverPopupWindow = this.instance;
        if (semHoverPopupWindow != null) {
            semHoverPopupWindow.setContent(view);
        }
    }

    @Override // com.samsung.android.spen.libinterface.HoverPopupWindowInterface
    public void show(int i) {
        SemHoverPopupWindow semHoverPopupWindow = this.instance;
        if (semHoverPopupWindow != null) {
            semHoverPopupWindow.show();
        }
    }
}
