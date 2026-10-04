package com.samsung.android.spen.libse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.PointerIcon;
import android.view.View;
import com.samsung.android.spen.libinterface.PointerIconInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SePointerIcon implements PointerIconInterface {
    public static final int TYPE_NULL = 0;
    public static final int TYPE_STYLUS_DEFAULT = 20001;
    public static final int TYPE_STYLUS_MORE = 20010;
    public static final int TYPE_STYLUS_SCROLL_DOWN = 20015;
    public static final int TYPE_STYLUS_SCROLL_LEFT = 20017;
    public static final int TYPE_STYLUS_SCROLL_RIGHT = 20013;
    public static final int TYPE_STYLUS_SCROLL_UP = 20011;
    public static final int TYPE_TEXT = 20002;

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        Bitmap bitmapCreateBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public boolean isPointerIconSupported() {
        return true;
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void removeHoveringSpenCustomIcon() {
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(Context context, View view, int i, int i2) {
        view.semSetPointerIcon(i, PointerIcon.getSystemIcon(context, i2));
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(Context context, View view, int i) {
        view.semSetPointerIcon(2, PointerIcon.getSystemIcon(context, i));
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(View view, Drawable drawable, Point point, int i) {
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
        if (bitmapDrawableToBitmap != null) {
            view.semSetPointerIcon(i, PointerIcon.create(bitmapDrawableToBitmap, point.x, point.y));
        }
    }

    @Override // com.samsung.android.spen.libinterface.PointerIconInterface
    public void setHoveringSpenIcon(View view, Drawable drawable, Point point) {
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
        if (bitmapDrawableToBitmap != null) {
            view.semSetPointerIcon(2, PointerIcon.create(bitmapDrawableToBitmap, point.x, point.y));
        }
    }
}
