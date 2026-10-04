package com.samsung.android.sdk.pen.setting;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushDragArea;", "", "penGuide", "Landroid/view/View;", "colorGuide", "isCurrentPen", "", "isCurrentColor", "points", "", "Landroid/graphics/Point;", "<init>", "(Landroid/view/View;Landroid/view/View;ZZ[Landroid/graphics/Point;)V", "mPenHelper", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDragAreaHelper;", "mColorHelper", "mQuadrilateral", "Lcom/samsung/android/sdk/pen/setting/SpenQuadrilateral;", "mTarget", "close", "", "setTarget", "isPenView", "startDrag", "currentTag", "", "getCurrentTag", "()Ljava/lang/String;", "setDragLocation", "isYourLocation", "hasRightAngle", "isContains", LangPackConfigConstants.LANGUAGE_CODE_PT, "getOverlapArea", "", "another", "Landroid/graphics/Rect;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushDragArea {

    @NotNull
    private static final String TAG = "SpenBrushDragArea";

    @NotNull
    private SpenBrushDragAreaHelper mColorHelper;

    @NotNull
    private SpenBrushDragAreaHelper mPenHelper;

    @NotNull
    private SpenQuadrilateral mQuadrilateral;

    @Nullable
    private SpenBrushDragAreaHelper mTarget;

    public SpenBrushDragArea(@NotNull View penGuide, @NotNull View colorGuide, boolean z, boolean z2, @NotNull Point... points) {
        Intrinsics.checkNotNullParameter(penGuide, "penGuide");
        Intrinsics.checkNotNullParameter(colorGuide, "colorGuide");
        Intrinsics.checkNotNullParameter(points, "points");
        this.mPenHelper = new SpenBrushPenDragAreaHelper(penGuide, z, z2);
        this.mColorHelper = new SpenBrushColorDragAreaHelper(colorGuide, z2, z);
        this.mQuadrilateral = new SpenQuadrilateral((Point[]) Arrays.copyOf(points, points.length));
    }

    public final void close() {
        this.mPenHelper.close();
        this.mColorHelper.close();
        SpenBrushDragAreaHelper spenBrushDragAreaHelper = this.mTarget;
        if (spenBrushDragAreaHelper != null) {
            spenBrushDragAreaHelper.close();
        }
        this.mTarget = null;
    }

    @Nullable
    public final String getCurrentTag() {
        SpenBrushDragAreaHelper spenBrushDragAreaHelper = this.mTarget;
        if (spenBrushDragAreaHelper != null) {
            return spenBrushDragAreaHelper.getCurrentTag();
        }
        return null;
    }

    public final int getOverlapArea(@NotNull Rect another) {
        Intrinsics.checkNotNullParameter(another, "another");
        return this.mQuadrilateral.getOverlapArea(another);
    }

    public final boolean hasRightAngle() {
        return this.mQuadrilateral.isRectangle();
    }

    public final boolean isContains(@NotNull Point pt) {
        Intrinsics.checkNotNullParameter(pt, "pt");
        return this.mQuadrilateral.isContains(pt);
    }

    public final void setDragLocation(boolean isYourLocation) {
        if (isYourLocation) {
            SpenBrushDragAreaHelper spenBrushDragAreaHelper = this.mTarget;
            if (spenBrushDragAreaHelper != null) {
                spenBrushDragAreaHelper.performDraggingInside();
                return;
            }
            return;
        }
        SpenBrushDragAreaHelper spenBrushDragAreaHelper2 = this.mTarget;
        if (spenBrushDragAreaHelper2 != null) {
            spenBrushDragAreaHelper2.performDraggingOutside();
        }
    }

    public final void setTarget(boolean isPenView) {
        this.mTarget = isPenView ? this.mPenHelper : this.mColorHelper;
    }

    public final void startDrag() {
        this.mPenHelper.startDrag(this.mColorHelper.getGuide());
        this.mColorHelper.startDrag(this.mPenHelper.getGuide());
    }
}
