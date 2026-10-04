package com.samsung.android.support.senl.addons.brush.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/CommonUtil;", "", "<init>", "()V", "getImagePathByTimeInAppShare", "", "context", "Landroid/content/Context;", "prefix", BundleContract.EXTRA_DATA, "getFileNameByTime", "getStatusBarHeight", "", "fitPreviewBitmap", "Landroid/graphics/Bitmap;", "origBitmap", "targetWidth", "targetHeight", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CommonUtil {

    @NotNull
    public static final CommonUtil INSTANCE = new CommonUtil();

    private CommonUtil() {
    }

    @JvmStatic
    @NotNull
    public static final String getFileNameByTime(@NotNull String prefix, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return AbstractC0541b.m757C(prefix, new SimpleDateFormat("_yyMMdd_HHmmss_SSS.", Locale.ENGLISH).format(new Date()), extension);
    }

    @JvmStatic
    @NotNull
    public static final String getImagePathByTimeInAppShare(@NotNull Context context, @NotNull String prefix, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return context.getFilesDir() + "/share/" + getFileNameByTime(prefix, extension);
    }

    @JvmStatic
    @SuppressLint({"InternalInsetResource"})
    public static final int getStatusBarHeight(@Nullable Context context) {
        Resources resources;
        int identifier;
        if (context == null || (identifier = (resources = context.getResources()).getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    @Nullable
    public final Bitmap fitPreviewBitmap(@Nullable Bitmap origBitmap, int targetWidth, int targetHeight) {
        Bitmap bitmapCreateBitmap;
        if (origBitmap == null) {
            return null;
        }
        int width = origBitmap.getWidth();
        int height = origBitmap.getHeight();
        float f = width;
        float f4 = height;
        float f5 = f / f4;
        float f6 = targetWidth;
        float f7 = targetHeight;
        float f8 = f6 / f7;
        if (f5 < f8) {
            int i = (int) (((f4 * f8) - f) / 2.0f);
            Bitmap.Config config = origBitmap.getConfig();
            Intrinsics.checkNotNull(config);
            bitmapCreateBitmap = Bitmap.createBitmap((i * 2) + width, height, config);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            new Canvas(bitmapCreateBitmap).drawBitmap(origBitmap, new Rect(0, 0, width, height), new Rect(i, 0, width, height), (Paint) null);
        } else if (f5 > f8) {
            int i2 = ((int) (((f7 / f6) * f) - f4)) + height;
            Bitmap.Config config2 = origBitmap.getConfig();
            Intrinsics.checkNotNull(config2);
            bitmapCreateBitmap = Bitmap.createBitmap(width, i2, config2);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            new Canvas(bitmapCreateBitmap).drawBitmap(origBitmap, new Rect(0, 0, width, height), new Rect(0, 0, width, height), (Paint) null);
        } else {
            bitmapCreateBitmap = origBitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, targetWidth, targetHeight, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
        if (!origBitmap.isRecycled()) {
            origBitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }
}
