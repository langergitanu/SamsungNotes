package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001d\u001a\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/BackgroundRenderer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearPaint", "Landroid/graphics/Paint;", "highlightPaint", "highlightPath", "Landroid/graphics/Path;", "isDimEnabled", "", "()Z", "setDimEnabled", "(Z)V", "transparentPaint", "viewRect", "Landroid/graphics/RectF;", "getViewRect", "()Landroid/graphics/RectF;", "setViewRect", "(Landroid/graphics/RectF;)V", "drawDimForSelectableBlocks", "", "canvas", "Landroid/graphics/Canvas;", "drawDimForTranslation", "drawSelectionBackground", "drawTranslationBackground", "updateHighlightPath", "highlightPolyList", "", "", "Landroid/graphics/Point;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBackgroundRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BackgroundRenderer.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/BackgroundRenderer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1855#2,2:113\n*S KotlinDebug\n*F\n+ 1 BackgroundRenderer.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/BackgroundRenderer\n*L\n81#1:113,2\n*E\n"})
public final class BackgroundRenderer {

    @NotNull
    private static final String TAG = "BackgroundRenderer";

    @NotNull
    private final Paint clearPaint;

    @NotNull
    private final Context context;

    @NotNull
    private final Paint highlightPaint;

    @NotNull
    private Path highlightPath;
    private boolean isDimEnabled;

    @NotNull
    private final Paint transparentPaint;

    @NotNull
    private RectF viewRect;

    public BackgroundRenderer(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.viewRect = new RectF();
        this.highlightPath = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setPathEffect(new CornerPathEffect(context.getResources().getDimensionPixelSize(C7039R.dimen.textextraction_bg_corner_radius)));
        this.clearPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
        paint2.setColor(context.getResources().getColor(C7039R.color.textextraction_clear_color, null));
        paint2.setPathEffect(new CornerPathEffect(context.getResources().getDimensionPixelSize(C7039R.dimen.textextraction_bg_corner_radius)));
        this.highlightPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(0);
        this.transparentPaint = paint3;
    }

    private final void drawDimForSelectableBlocks(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        canvas.drawColor(this.context.getColor(C7039R.color.textextraction_dim_color));
        canvas.drawPath(this.highlightPath, this.clearPaint);
        canvas.drawPath(this.highlightPath, this.highlightPaint);
        canvas.restoreToCount(iSaveLayer);
    }

    private final void drawDimForTranslation(Canvas canvas) {
        canvas.drawColor(this.context.getColor(C7039R.color.textextraction_dim_color));
        canvas.drawRect(this.viewRect, this.transparentPaint);
    }

    public final void drawSelectionBackground(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawColor(0);
        if (this.isDimEnabled) {
            drawDimForSelectableBlocks(canvas);
        }
    }

    public final void drawTranslationBackground(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawColor(0);
        if (this.isDimEnabled) {
            drawDimForTranslation(canvas);
        }
    }

    @NotNull
    public final RectF getViewRect() {
        return this.viewRect;
    }

    /* JADX INFO: renamed from: isDimEnabled, reason: from getter */
    public final boolean getIsDimEnabled() {
        return this.isDimEnabled;
    }

    public final void setDimEnabled(boolean z) {
        this.isDimEnabled = z;
    }

    public final void setViewRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.viewRect = rectF;
    }

    public final void updateHighlightPath(@NotNull List<Point[]> highlightPolyList) {
        Intrinsics.checkNotNullParameter(highlightPolyList, "highlightPolyList");
        RectF rectF = this.viewRect;
        float fCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(rectF.left + 1.0f, rectF.right - 1.0f), this.viewRect.left);
        RectF rectF2 = this.viewRect;
        float fCoerceAtMost = RangesKt.coerceAtMost(Math.max(rectF2.left + 1.0f, rectF2.right - 1.0f), this.viewRect.right);
        RectF rectF3 = this.viewRect;
        float fCoerceAtLeast2 = RangesKt.coerceAtLeast(Math.min(rectF3.top + 1.0f, rectF3.bottom - 1.0f), this.viewRect.top);
        RectF rectF4 = this.viewRect;
        float fCoerceAtMost2 = RangesKt.coerceAtMost(Math.max(rectF4.top + 1.0f, rectF4.bottom - 1.0f), this.viewRect.bottom);
        this.highlightPath.reset();
        for (Point[] pointArr : highlightPolyList) {
            Path path = new Path();
            path.moveTo(RangesKt.coerceIn(pointArr[0].x, fCoerceAtLeast, fCoerceAtMost), RangesKt.coerceIn(pointArr[0].y, fCoerceAtLeast2, fCoerceAtMost2));
            path.lineTo(RangesKt.coerceIn(pointArr[1].x, fCoerceAtLeast, fCoerceAtMost), RangesKt.coerceIn(pointArr[1].y, fCoerceAtLeast2, fCoerceAtMost2));
            path.lineTo(RangesKt.coerceIn(pointArr[2].x, fCoerceAtLeast, fCoerceAtMost), RangesKt.coerceIn(pointArr[2].y, fCoerceAtLeast2, fCoerceAtMost2));
            path.lineTo(RangesKt.coerceIn(pointArr[3].x, fCoerceAtLeast, fCoerceAtMost), RangesKt.coerceIn(pointArr[3].y, fCoerceAtLeast2, fCoerceAtMost2));
            path.lineTo(RangesKt.coerceIn(pointArr[0].x, fCoerceAtLeast, fCoerceAtMost), RangesKt.coerceIn(pointArr[0].y, fCoerceAtLeast2, fCoerceAtMost2));
            path.close();
            this.highlightPath.addPath(path);
        }
    }
}
