package com.samsung.android.spen.libwrapper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import android.view.View;
import com.samsung.android.spen.libinterface.ViewInterface;
import com.samsung.android.spen.libsdl.SdlView;
import com.samsung.android.spen.libse.SeView;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ViewWrapper {
    private ViewInterface instance;
    private boolean isSetIconNotSupportedPlatform;

    private ViewWrapper(ViewInterface viewInterface, boolean z) throws PlatformException {
        try {
            this.instance = viewInterface;
            this.isSetIconNotSupportedPlatform = !z;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static ViewWrapper create(Context context, View view) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new ViewWrapper(new SeView(view), true);
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new ViewWrapper(new SdlView(view), false);
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public HoverPopupWindowWrapper getHoverPopupWindow() throws PlatformException {
        try {
            return new HoverPopupWindowWrapper(this.instance.getHoverPopupWindow());
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void performHapticFeedback(int i) throws PlatformException {
        try {
            this.instance.performHapticFeedback(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void requestAccessibilityFocus() throws PlatformException {
        try {
            this.instance.requestAccessibilityFocus();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setHoverPopupType(int i) throws PlatformException {
        try {
            this.instance.setHoverPopupType(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setPointerIcon(Context context, int i) throws PlatformException {
        if (this.isSetIconNotSupportedPlatform) {
            return;
        }
        try {
            this.instance.setPointerIcon(context, i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setPointerIcon(int i, PointerIcon pointerIcon) throws PlatformException {
        if (this.isSetIconNotSupportedPlatform) {
            return;
        }
        try {
            this.instance.setPointerIcon(i, pointerIcon);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setPointerIcon(Resources resources, Bitmap bitmap, float f, float f4) throws PlatformException {
        if (this.isSetIconNotSupportedPlatform) {
            return;
        }
        try {
            this.instance.setPointerIcon(resources, bitmap, f, f4);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
