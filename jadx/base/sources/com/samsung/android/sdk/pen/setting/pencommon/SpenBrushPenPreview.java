package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenBrushPenPreview;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreview;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "calculatePoints", "", "view", "Landroid/view/View;", "strokeSize", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenPreview extends SpenPreview {
    private static final float BRUSHPEN_PRESSURE_DP = 0.03f;
    private static final int BRUSHPEN_PREVIEW_POINT_COUNT = 10;

    @NotNull
    private static final String TAG = "SpenBrushPenPreview";

    public SpenBrushPenPreview(@Nullable Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public int calculatePoints(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        checkDeltaValue(view, 10, BRUSHPEN_PRESSURE_DP);
        int measuredWidth = (view.getMeasuredWidth() - view.getPaddingStart()) - view.getPaddingEnd();
        int mCountOfPoint = getMCountOfPoint();
        setPoint(view.getPaddingStart() + (strokeSize / 4), (view.getMeasuredHeight() / 2.0f) - (strokeSize / 4.0f), (measuredWidth - ((int) (2 * r2))) / (mCountOfPoint - 1));
        return getMCountOfPoint();
    }
}
