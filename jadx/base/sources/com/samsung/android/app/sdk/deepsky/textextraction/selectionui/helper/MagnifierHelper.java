package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Magnifier;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.utils.AbstractC4359a;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.util.VectorUtil;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J)\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/MagnifierHelper;", "", "teView", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/view/View;Landroid/content/Context;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isShowing", "setShowing", "magnifier", "Landroid/widget/Magnifier;", "viewRect", "Landroid/graphics/RectF;", "getViewRect", "()Landroid/graphics/RectF;", "setViewRect", "(Landroid/graphics/RectF;)V", "dismiss", "", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "linePoly", "", "Landroid/graphics/Point;", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "(Landroid/view/MotionEvent;[Landroid/graphics/Point;F)Z", "initMagnifier", "lineHeight", "", "setMagnifierZoom", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class MagnifierHelper {
    private static final float LINE_RATIO_IN_MAGNIFIER = 0.5f;
    private static final float LINE_TILT_THRESHOLD = 5.0f;

    @NotNull
    private static final String TAG = "MagnifierHelper";

    @NotNull
    private final Context context;
    private boolean isEnabled;
    private boolean isShowing;

    @Nullable
    private Magnifier magnifier;

    @NotNull
    private final View teView;

    @NotNull
    private RectF viewRect;

    public MagnifierHelper(@NotNull View teView, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(teView, "teView");
        Intrinsics.checkNotNullParameter(context, "context");
        this.teView = teView;
        this.context = context;
        this.isEnabled = true;
        this.viewRect = new RectF();
    }

    private final Magnifier initMagnifier(int lineHeight) {
        AbstractC4359a.m3080s();
        Magnifier magnifierBuild = AbstractC4359a.m3072k(this.teView).setCornerRadius(this.context.getResources().getDimension(C7039R.dimen.magnifier_corner_radius)).setDefaultSourceToMagnifierOffset(0, this.context.getResources().getDimensionPixelOffset(C7039R.dimen.magnifier_vertical_offset) + (-lineHeight)).setOverlay(ResourcesCompat.getDrawable(this.context.getResources(), C7039R.drawable.magnifer_boundary, null)).build();
        Intrinsics.checkNotNullExpressionValue(magnifierBuild, "Builder(teView)\n        …  )\n            ).build()");
        return magnifierBuild;
    }

    private final void setMagnifierZoom(int lineHeight, float scaleFactor) {
        Magnifier magnifier = this.magnifier;
        if (magnifier != null) {
            magnifier.setZoom(((magnifier.getHeight() / lineHeight) * 0.5f) / scaleFactor);
        }
    }

    public final void dismiss() {
        this.isShowing = false;
        Magnifier magnifier = this.magnifier;
        if (magnifier != null) {
            magnifier.dismiss();
        }
        this.magnifier = null;
    }

    @NotNull
    public final RectF getViewRect() {
        return this.viewRect;
    }

    public final boolean handleTouchEvent(@NotNull MotionEvent event, @NotNull Point[] linePoly, float scaleFactor) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(linePoly, "linePoly");
        if (this.isEnabled && scaleFactor == 1.0f) {
            VectorUtil vectorUtil = VectorUtil.INSTANCE;
            if (!vectorUtil.isTilted(linePoly, LINE_TILT_THRESHOLD)) {
                int iCalcDistanceFromPointToPoint = vectorUtil.calcDistanceFromPointToPoint(linePoly[0], linePoly[3]);
                int i = (linePoly[0].y + linePoly[2].y) / 2;
                this.teView.getLocationOnScreen(new int[2]);
                if (this.magnifier == null) {
                    this.magnifier = initMagnifier(iCalcDistanceFromPointToPoint);
                }
                setMagnifierZoom(iCalcDistanceFromPointToPoint, scaleFactor);
                float rawX = ((event.getRawX() - r7[0]) / scaleFactor) + this.context.getResources().getDimensionPixelOffset(C7039R.dimen.magnifier_horizontal_offset);
                float f = i * scaleFactor;
                int actionMasked = event.getActionMasked();
                if (actionMasked == 0) {
                    dismiss();
                    return true;
                }
                if (actionMasked == 1) {
                    dismiss();
                    return false;
                }
                if (actionMasked == 2 && this.isShowing) {
                    Magnifier magnifier = this.magnifier;
                    if (magnifier != null) {
                        magnifier.show(rawX, f);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final void setShowing(boolean z) {
        this.isShowing = z;
    }

    public final void setViewRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.viewRect = rectF;
    }
}
