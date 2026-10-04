package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p018D2.AbstractC0071a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/UnderlineDrawInfo;", "", "entityType", "", "underlineInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;", "(Ljava/lang/String;Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$UnderlineInfo;)V", "getEntityType", "()Ljava/lang/String;", "start", "Landroid/graphics/PointF;", "getStart", "()Landroid/graphics/PointF;", "stop", "getStop", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class UnderlineDrawInfo {

    @NotNull
    private final String entityType;

    @NotNull
    private final PointF start;

    @NotNull
    private final PointF stop;

    public UnderlineDrawInfo(@NotNull String entityType, @NotNull OcrResult.UnderlineInfo underlineInfo) {
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        Intrinsics.checkNotNullParameter(underlineInfo, "underlineInfo");
        this.entityType = entityType;
        PointF start = underlineInfo.getStart();
        Intrinsics.checkNotNull(start);
        this.start = AbstractC0071a.m172f(start);
        PointF stop = underlineInfo.getStop();
        Intrinsics.checkNotNull(stop);
        this.stop = AbstractC0071a.m172f(stop);
    }

    public final void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        PointF pointF = this.start;
        float f = pointF.x;
        float f4 = pointF.y;
        PointF pointF2 = this.stop;
        canvas.drawLine(f, f4, pointF2.x, pointF2.y, paint);
    }

    @NotNull
    public final String getEntityType() {
        return this.entityType;
    }

    @NotNull
    public final PointF getStart() {
        return this.start;
    }

    @NotNull
    public final PointF getStop() {
        return this.stop;
    }
}
