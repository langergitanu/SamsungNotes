package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.graphics.PointF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTAnglePosition;", "", "<init>", "()V", "mCPoint", "Landroid/graphics/PointF;", "mRadius", "", "setCenterPosition", "", "xPos", "", "yPos", "getRadius", "setRadius", "radius", "getViewPosition", "viewWidth", "viewHeight", "angle", "", "getCenterOffset", "viewPosition", "getAngleToCenter", "relativeX", "relativeY", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTAnglePosition {

    @NotNull
    private static final String TAG = "QTAnglePosition";

    @NotNull
    private PointF mCPoint = new PointF(0.0f, 0.0f);
    private float mRadius;

    public final double getAngleToCenter(float relativeX, float relativeY) {
        PointF pointF = this.mCPoint;
        double degrees = Math.toDegrees(Math.atan2(relativeY - pointF.y, relativeX - pointF.x));
        double d = PopOverActivityWrapper.DEFAULT_WIDTH;
        return (degrees + d) % d;
    }

    @NotNull
    public final PointF getCenterOffset(@NotNull PointF viewPosition) {
        Intrinsics.checkNotNullParameter(viewPosition, "viewPosition");
        PointF pointF = this.mCPoint;
        return new PointF(pointF.x - viewPosition.x, pointF.y - viewPosition.y);
    }

    /* JADX INFO: renamed from: getRadius, reason: from getter */
    public final float getMRadius() {
        return this.mRadius;
    }

    @NotNull
    public final PointF getViewPosition(int viewWidth, int viewHeight, double angle) {
        Logger.m11003i(TAG, "setViewPosition() angle=" + angle);
        double d = (angle * 3.141592653589793d) / ((double) 180);
        float fM2210a = (int) (AbstractC2821a.m2210a(d, (double) this.mRadius, (double) this.mCPoint.x) - ((double) (viewWidth / 2)));
        float fM5b = (int) (AbstractC0000a.m5b(d, this.mRadius, this.mCPoint.y) - ((double) (viewHeight / 2)));
        Logger.m11003i(TAG, AbstractC0541b.m770l("newPosition[", fM2210a, SQLKeyword.COMMA, fM5b, "]"));
        return new PointF(fM2210a, fM5b);
    }

    public final void setCenterPosition(int xPos, int yPos) {
        PointF pointF = this.mCPoint;
        pointF.x = xPos;
        pointF.y = yPos;
    }

    public final void setRadius(float radius) {
        this.mRadius = radius;
    }
}
