package com.samsung.android.spen.libwrapper;

import android.view.View;
import com.samsung.android.spen.libinterface.HoverPopupWindowInterface;
import com.samsung.android.spen.libsdl.SdlHoverPopupWindow;
import com.samsung.android.spen.libse.SeHoverPopupWindow;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HoverPopupWindowWrapper {
    public static final int TYPE_NONE;
    public static final int TYPE_TOOLTIP;
    public static final int TYPE_USER_CUSTOM;
    public static final int TYPE_WIDGET_DEFAULT;
    private HoverPopupWindowInterface instance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Gravity {
        public static int BOTTOM;
        public static int CENTER_VERTICAL;
        public static int LEFT;
        public static int RIGHT;
        public static int TOP;

        static {
            if (PlatformUtils.isSemDevice()) {
                BOTTOM = SeHoverPopupWindow.Gravity.BOTTOM;
                CENTER_VERTICAL = SeHoverPopupWindow.Gravity.CENTER_VERTICAL;
                LEFT = SeHoverPopupWindow.Gravity.LEFT;
                RIGHT = SeHoverPopupWindow.Gravity.RIGHT;
                TOP = SeHoverPopupWindow.Gravity.TOP;
                return;
            }
            BOTTOM = SdlHoverPopupWindow.Gravity.BOTTOM;
            CENTER_VERTICAL = SdlHoverPopupWindow.Gravity.CENTER_VERTICAL;
            LEFT = SdlHoverPopupWindow.Gravity.LEFT;
            RIGHT = SdlHoverPopupWindow.Gravity.RIGHT;
            TOP = SdlHoverPopupWindow.Gravity.TOP;
        }

        private Gravity() {
        }
    }

    static {
        if (PlatformUtils.isSemDevice()) {
            TYPE_NONE = SeHoverPopupWindow.TYPE_NONE;
            TYPE_TOOLTIP = SeHoverPopupWindow.TYPE_TOOLTIP;
            TYPE_USER_CUSTOM = SeHoverPopupWindow.TYPE_USER_CUSTOM;
            TYPE_WIDGET_DEFAULT = SeHoverPopupWindow.TYPE_WIDGET_DEFAULT;
            return;
        }
        TYPE_NONE = SdlHoverPopupWindow.TYPE_NONE;
        TYPE_TOOLTIP = SdlHoverPopupWindow.TYPE_TOOLTIP;
        TYPE_USER_CUSTOM = SdlHoverPopupWindow.TYPE_USER_CUSTOM;
        TYPE_WIDGET_DEFAULT = SdlHoverPopupWindow.TYPE_WIDGET_DEFAULT;
    }

    public HoverPopupWindowWrapper(HoverPopupWindowInterface hoverPopupWindowInterface) throws PlatformException {
        try {
            this.instance = hoverPopupWindowInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setContent(CharSequence charSequence) throws PlatformException {
        try {
            this.instance.setContent(charSequence);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setGravity(int i) throws PlatformException {
        try {
            this.instance.setGravity(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setHoverPopupListener(HoverPopupWindowInterface.HoverPopupWindowListenerCallback hoverPopupWindowListenerCallback) throws PlatformException {
        try {
            this.instance.setHoverPopupListener(hoverPopupWindowListenerCallback);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setOffset(int i, int i2) throws PlatformException {
        try {
            this.instance.setOffset(i, i2);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void show() throws PlatformException {
        try {
            this.instance.show();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setContent(View view) throws PlatformException {
        try {
            this.instance.setContent(view);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void show(int i) throws PlatformException {
        try {
            this.instance.show(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
