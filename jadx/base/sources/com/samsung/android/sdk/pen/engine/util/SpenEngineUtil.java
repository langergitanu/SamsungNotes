package com.samsung.android.sdk.pen.engine.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Selection;
import android.text.Spannable;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J8\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0007J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J\u0019\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0083 J9\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/util/SpenEngineUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "drawRemoverPreview", "", "bitmap", "Landroid/graphics/Bitmap;", "density", "", WiggleAnimationConfig.KEY_SCALE, "size", "strokeColor", "", "fillColor", "getNewCursorPosition", "buf", "Landroid/text/Spannable;", "what", "oldStart", "oldEnd", "newStart", "newEnd", "isRTL", "text", "isDefaultRTL", "Native_isRTL", "Native_drawRemoverPreview", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenEngineUtil {

    @NotNull
    public static final SpenEngineUtil INSTANCE = new SpenEngineUtil();

    @NotNull
    private static final String TAG = "SpenEngineUtil";

    private SpenEngineUtil() {
    }

    @JvmStatic
    private static final native boolean Native_drawRemoverPreview(Bitmap bitmap, float density, float scale, float size, int strokeColor, int fillColor);

    @JvmStatic
    private static final native boolean Native_isRTL(String text, boolean isDefaultRTL);

    @JvmStatic
    public static final boolean drawRemoverPreview(@Nullable Bitmap bitmap, float density, float scale, float size, int strokeColor, int fillColor) {
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                float f = width / 2.0f;
                float f4 = height / 2.0f;
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(fillColor);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f, f4, size, paint);
                paint.setColor(strokeColor);
                paint.setStrokeWidth(density * 1.0f);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(f, f4, size, paint);
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final int getNewCursorPosition(@NotNull Spannable buf, @NotNull Object what, int oldStart, int oldEnd, int newStart, int newEnd) {
        boolean z;
        int selectionEnd;
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(what, "what");
        boolean z2 = true;
        if (what == Selection.SELECTION_END) {
            z = true;
            selectionEnd = newStart;
        } else {
            z = false;
            selectionEnd = -1;
        }
        if (what != Selection.SELECTION_START) {
            z2 = z;
            newStart = -1;
        }
        if (z2 && (buf.getSpanFlags(what) & 512) == 0) {
            if (newStart < 0) {
                newStart = Selection.getSelectionStart(buf);
            }
            if (selectionEnd < 0) {
                selectionEnd = Selection.getSelectionEnd(buf);
            }
            if (newStart == selectionEnd) {
                return newStart;
            }
        }
        return -1;
    }

    @JvmStatic
    public static final boolean isRTL(@NotNull String text, boolean isDefaultRTL) {
        Intrinsics.checkNotNullParameter(text, "text");
        return Native_isRTL(text, isDefaultRTL);
    }
}
