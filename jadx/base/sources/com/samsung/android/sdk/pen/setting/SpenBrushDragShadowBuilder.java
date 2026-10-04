package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.sdk.pen.setting.util.SpenRoundClipHelper;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", VPathDataCmd.RCurveTo, "Landroid/view/View;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/graphics/Point;", "radius", "", "<init>", "(Landroid/view/View;Landroid/graphics/Point;I)V", "mWidth", "mHeight", "mOffset", "mRoundClipHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenRoundClipHelper;", "onProvideShadowMetrics", "", "shadowSize", "shadowTouchPoint", "onDrawShadow", "canvas", "Landroid/graphics/Canvas;", "getOffset", "pointOffset", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenBrushDragShadowBuilder extends View.DragShadowBuilder {

    @NotNull
    private static final String TAG = "SpenBrushDragShadowBuilder";
    private final int mHeight;

    @NotNull
    private final Point mOffset;

    @NotNull
    private final SpenRoundClipHelper mRoundClipHelper;
    private final int mWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushDragShadowBuilder(@NotNull View v, @NotNull Point offset, int i) {
        super(v);
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(offset, "offset");
        double radians = Math.toRadians(getView().getRotation());
        int scaleX = (int) (getView().getScaleX() * getView().getWidth());
        int scaleY = (int) (getView().getScaleY() * getView().getHeight());
        double dAbs = Math.abs(Math.sin(radians));
        double dAbs2 = Math.abs(Math.cos(radians));
        double d = scaleX;
        double d2 = scaleY;
        int i2 = (int) ((d2 * dAbs) + (d * dAbs2));
        this.mWidth = i2;
        int i4 = (int) ((d2 * dAbs2) + (d * dAbs));
        this.mHeight = i4;
        this.mOffset = offset;
        SpenRoundClipHelper spenRoundClipHelper = new SpenRoundClipHelper();
        this.mRoundClipHelper = spenRoundClipHelper;
        spenRoundClipHelper.setCorner(i);
        float rotation = getView().getRotation();
        float pivotX = v.getPivotX();
        float pivotY = v.getPivotY();
        float scaleX2 = v.getScaleX();
        float scaleY2 = v.getScaleY();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i4, " SIZE[", SQLKeyword.COMMA, "] OFFSET=");
        sbM1173s.append(offset);
        sbM1173s.append(" ROTATE=");
        sbM1173s.append(rotation);
        sbM1173s.append(" PIVOT[");
        AbstractC11014a.m12337v(sbM1173s, pivotX, SQLKeyword.COMMA, pivotY, "] SCALE[");
        Log.i(TAG, AbstractC1038a.m1216q(sbM1173s, scaleX2, SQLKeyword.COMMA, scaleY2, "]"));
    }

    public final void getOffset(@NotNull Point pointOffset) {
        Intrinsics.checkNotNullParameter(pointOffset, "pointOffset");
        float rotation = getView().getRotation();
        float scaleX = getView().getScaleX();
        float scaleY = getView().getScaleY();
        int i = this.mWidth;
        float f = 2;
        float f4 = (i * ((rotation == 0.0f || rotation == 180.0f) ? scaleX - 1.0f : scaleY - 1.0f)) / f;
        float f5 = (this.mHeight * ((rotation == 0.0f || rotation == 180.0f) ? scaleY - 1.0f : scaleX - 1.0f)) / f;
        if (rotation == -90.0f) {
            Point point = this.mOffset;
            pointOffset.set((int) (point.y + f4), (int) ((r9 - point.x) - f5));
        } else if (rotation == 90.0f) {
            Point point2 = this.mOffset;
            pointOffset.set((int) (i - (point2.y + f4)), (int) (point2.x + f5));
        } else {
            Point point3 = this.mOffset;
            pointOffset.set((int) (point3.x + f4), (int) (point3.y + f5));
        }
        Log.i(TAG, "getOffset() [AFTER] pointOffset=" + pointOffset);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.scale(getView().getScaleX(), getView().getScaleY(), this.mWidth / 2.0f, this.mHeight / 2.0f);
        canvas.rotate(getView().getRotation(), this.mWidth / 2.0f, this.mHeight / 2.0f);
        canvas.translate((this.mWidth - getView().getWidth()) / 2.0f, (this.mHeight - getView().getHeight()) / 2.0f);
        this.mRoundClipHelper.applyRoundClip(canvas);
        super.onDrawShadow(canvas);
        float rotation = getView().getRotation();
        StringBuilder sb = new StringBuilder("onDrawShadow() canvas.rotate(");
        sb.append(rotation);
        sb.append(",");
        sb.append(this.mWidth / 2.0f);
        sb.append(this.mHeight / 2.0f);
        AbstractC11014a.m12338w(sb, ")", TAG);
        Log.i(TAG, AbstractC0541b.m770l("onDrawShadow() canvas.translate(", (this.mWidth - getView().getWidth()) / 2.0f, ",", (this.mHeight - getView().getHeight()) / 2.0f, ")"));
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(@NotNull Point shadowSize, @NotNull Point shadowTouchPoint) {
        Intrinsics.checkNotNullParameter(shadowSize, "shadowSize");
        Intrinsics.checkNotNullParameter(shadowTouchPoint, "shadowTouchPoint");
        shadowSize.set(this.mWidth, this.mHeight);
        getOffset(shadowTouchPoint);
    }
}
