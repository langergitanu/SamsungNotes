package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenObliquePreview;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreview;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPointY", "", "mXPoints", "", "calculatePoints", "", "view", "Landroid/view/View;", "strokeSize", "getPressure", "index", "decidePosition", "pointCount", "getPointCount", "()I", "setPointCount", "(I)V", "getPoint", "Landroid/graphics/PointF;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObliquePreview extends SpenPreview {
    public static final int OBLIQUE_PREVIEW_POINT_COUNT = 6;
    private float mPointY;

    @NotNull
    private float[] mXPoints;

    public SpenObliquePreview(@Nullable Context context) {
        super(context);
        this.mXPoints = new float[6];
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public int calculatePoints(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        checkDeltaValue(view, 6, 0.025f);
        return decidePosition(view, strokeSize);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public int decidePosition(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = view.getPaddingStart() == 0 && getMSizeLevel() <= 2;
        float measuredWidth = ((view.getMeasuredWidth() - view.getPaddingStart()) - view.getPaddingEnd()) - strokeSize;
        int mCountOfPoint = getMCountOfPoint();
        this.mPointY = view.getMeasuredHeight() / 2.0f;
        this.mXPoints[0] = (strokeSize / 2.0f) + view.getPaddingStart();
        if (z) {
            float dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_size_preview_oblique_min_padding);
            measuredWidth -= 2 * dimensionPixelSize;
            float[] fArr = this.mXPoints;
            fArr[0] = fArr[0] + dimensionPixelSize;
        }
        float f = measuredWidth / (mCountOfPoint - 1);
        for (int i = 1; i < mCountOfPoint; i++) {
            float[] fArr2 = this.mXPoints;
            fArr2[i] = fArr2[i - 1] + f;
        }
        setPointCount(mCountOfPoint);
        return mCountOfPoint;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    @NotNull
    public PointF getPoint(int index) {
        return new PointF(this.mXPoints[index], this.mPointY);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    /* JADX INFO: renamed from: getPointCount */
    public int getMCountOfPoint() {
        return 6;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public float getPressure(int index) {
        return 0.7f;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public void setPointCount(int i) {
        super.setPointCount(i);
    }
}
