package com.samsung.android.spen.libsdl;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.samsung.android.spen.libinterface.PointerIconInterface;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlPointerIcon implements PointerIconInterface {
    public static final int HOVERING_SPENICON_CURSOR = 2;
    public static final int HOVERING_SPENICON_CUSTOM = 0;
    public static final int HOVERING_SPENICON_DEFAULT = 1;
    public static final int HOVERING_SPENICON_MORE = 10;
    public static final int TYPE_STYLUS_SCROLL_DOWN = 15;
    public static final int TYPE_STYLUS_SCROLL_LEFT = 17;
    public static final int TYPE_STYLUS_SCROLL_RIGHT = 13;
    public static final int TYPE_STYLUS_SCROLL_UP = 11;
    private int mHoverIconID = -1;

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public boolean isPointerIconSupported() throws NoSuchMethodException {
        try {
            Class<?> cls = Class.forName("android.view.PointerIcon");
            Class cls2 = Integer.TYPE;
            cls.getMethod("setHoveringSpenIcon", cls2, cls2);
            cls.getMethod("setHoveringSpenIcon", cls2, Drawable.class);
            return true;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void removeHoveringSpenCustomIcon() throws IllegalAccessException, InvocationTargetException {
        Class.forName("android.view.PointerIcon").getMethod("removeHoveringSpenCustomIcon", Integer.TYPE).invoke(null, Integer.valueOf(this.mHoverIconID));
        this.mHoverIconID = -1;
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(Context context, View view, int i, int i2) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        setHoveringSpenIcon(context, view, i2);
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(Context context, View view, int i) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName("android.view.PointerIcon");
        Class cls2 = Integer.TYPE;
        cls.getMethod("setHoveringSpenIcon", cls2, cls2).invoke(null, Integer.valueOf(i), -1);
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(View view, Drawable drawable, Point point, int i) {
        setHoveringSpenIcon(view, drawable, point);
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(View view, Drawable drawable, Point point) {
        this.mHoverIconID = ((Integer) Class.forName("android.view.PointerIcon").getMethod("setHoveringSpenIcon", Integer.TYPE, Drawable.class, Point.class).invoke(null, 0, drawable, point)).intValue();
    }
}
