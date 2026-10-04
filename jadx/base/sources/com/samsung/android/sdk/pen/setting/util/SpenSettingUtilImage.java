package com.samsung.android.sdk.pen.setting.util;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.Log;
import android.view.View;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007J*\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J2\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0007J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\tH\u0002¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilImage;", "", "<init>", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "resId", "", "oriWidth", "oriHeight", "rotate", "getVectorDrawableSelected", "Landroid/graphics/drawable/StateListDrawable;", "resource", "normalColor", "selectedColor", "getDrawableSelected", "normalResource", "normalTintColor", "selectedResource", "selectedTintColor", "setForegroundDrawable", "", "target", "Landroid/view/View;", "resourceId", "id", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilImage {

    @NotNull
    public static final SpenSettingUtilImage INSTANCE = new SpenSettingUtilImage();

    private SpenSettingUtilImage() {
    }

    @JvmStatic
    @Nullable
    public static final Drawable getDrawable(@NotNull Context context, int resId, int oriWidth, int oriHeight, int rotate) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (resId == 0 || oriHeight == 0 || oriWidth == 0) {
            Log.i("SpenSettingUtilImage", "Impossible to make drawable");
            return null;
        }
        Drawable drawable = INSTANCE.getDrawable(context, resId);
        if (drawable == null || rotate == 0) {
            return drawable;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(oriWidth, oriHeight, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        drawable.setBounds(0, 0, oriWidth, oriHeight);
        drawable.draw(canvasM4740a);
        Matrix matrix = new Matrix();
        matrix.postRotate(rotate);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        return new BitmapDrawable(context.getResources(), bitmapCreateBitmap2);
    }

    @JvmStatic
    @NotNull
    public static final StateListDrawable getDrawableSelected(@Nullable Context context, int normalResource, int normalTintColor, int selectedResource, int selectedTintColor) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (normalResource != 0) {
            Drawable drawable = INSTANCE.getDrawable(context, normalResource);
            if (normalTintColor != -1 && drawable != null) {
                drawable.setTint(normalTintColor);
            }
            stateListDrawable.addState(new int[]{-16842919, -16842913, -16842908}, drawable);
        }
        if (selectedResource != 0) {
            SpenSettingUtilImage spenSettingUtilImage = INSTANCE;
            Drawable drawable2 = spenSettingUtilImage.getDrawable(context, selectedResource);
            if (selectedTintColor != -1) {
                Intrinsics.checkNotNull(drawable2);
                drawable2.setTint(selectedTintColor);
            }
            stateListDrawable.addState(new int[]{R.attr.state_selected}, spenSettingUtilImage.getDrawable(context, selectedResource));
        }
        return stateListDrawable;
    }

    @JvmStatic
    @Nullable
    public static final StateListDrawable getVectorDrawableSelected(@NotNull Context context, int resource, int normalColor, int selectedColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = context.getDrawable(resource);
        if (drawable == null || !(drawable instanceof VectorDrawable)) {
            Log.i("SpenSettingUtilImage", "VectorDrawable is possible only.");
            return null;
        }
        VectorDrawable vectorDrawable = (VectorDrawable) drawable;
        vectorDrawable.mutate();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        vectorDrawable.setColorFilter(normalColor, mode);
        stateListDrawable.addState(new int[]{-16842919, -16842913, -16842908}, drawable);
        VectorDrawable vectorDrawable2 = (VectorDrawable) context.getDrawable(resource);
        if (vectorDrawable2 != null) {
            vectorDrawable2.mutate();
        }
        if (vectorDrawable2 != null) {
            vectorDrawable2.setColorFilter(selectedColor, mode);
        }
        stateListDrawable.addState(new int[]{R.attr.state_selected}, vectorDrawable2);
        return stateListDrawable;
    }

    @JvmStatic
    public static final void setForegroundDrawable(@NotNull Context context, @NotNull View target, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        if (resourceId == 0) {
            target.setForeground(null);
        } else {
            target.setForeground(context.getResources().getDrawable(resourceId, null));
        }
    }

    private final Drawable getDrawable(Context context, int id) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getDrawable(id, null);
    }
}
