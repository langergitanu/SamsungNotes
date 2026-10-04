package com.samsung.android.support.senl.p145cm.base.common.util;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0007¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/ResourceUtils;", "", "<init>", "()V", "getFloatRes", "", "res", "Landroid/content/res/Resources;", "id", "", "getColor", "context", "Landroid/content/Context;", "resId", "getPrimaryColor", "getControlHighlightColor", "convertDpToPixel", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "convertPxToDp", "px", "convertPixelToSp", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ResourceUtils {

    @NotNull
    public static final ResourceUtils INSTANCE = new ResourceUtils();

    private ResourceUtils() {
    }

    @JvmStatic
    public static final float convertDpToPixel(@Nullable Context context, float dp) {
        Resources resources = context != null ? context.getResources() : null;
        Float fValueOf = (resources != null ? resources.getDisplayMetrics() : null) != null ? Float.valueOf(r1.densityDpi / 160) : null;
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue() * dp;
    }

    @JvmStatic
    public static final float convertPixelToSp(@NotNull Context context, float px) {
        Intrinsics.checkNotNullParameter(context, "context");
        return px / context.getResources().getDisplayMetrics().scaledDensity;
    }

    @JvmStatic
    public static final int convertPxToDp(@NotNull Context context, int px) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (px / (context.getResources().getDisplayMetrics().densityDpi / 160));
    }

    @JvmStatic
    public static final int getColor(@Nullable Context context, int resId) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getColor(resId, null);
    }

    @JvmStatic
    public static final int getControlHighlightColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorControlHighlight});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    @JvmStatic
    public static final float getFloatRes(@NotNull Resources res, int id) {
        Intrinsics.checkNotNullParameter(res, "res");
        TypedValue typedValue = new TypedValue();
        res.getValue(id, typedValue, true);
        return typedValue.getFloat();
    }

    @JvmStatic
    public static final int getPrimaryColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorPrimary});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }
}
