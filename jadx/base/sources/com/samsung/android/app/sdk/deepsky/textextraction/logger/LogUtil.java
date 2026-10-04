package com.samsung.android.app.sdk.deepsky.textextraction.logger;

import android.graphics.Bitmap;
import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/logger/LogUtil;", "", "()V", "logString", "", "Landroid/graphics/Bitmap;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LogUtil {

    @NotNull
    public static final LogUtil INSTANCE = new LogUtil();

    private LogUtil() {
    }

    @NotNull
    public final String logString(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return AbstractC0622a.m1164j(bitmap.getWidth(), bitmap.getHeight(), "bitmap=(", "x", ")");
    }
}
