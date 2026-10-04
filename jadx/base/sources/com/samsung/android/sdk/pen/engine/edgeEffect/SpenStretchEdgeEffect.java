package com.samsung.android.sdk.pen.engine.edgeEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u0000 A2\u00020\u0001:\u0001AB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010#\u001a\u00020$2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J8\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\fH\u0016J(\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020$H\u0016J \u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u0002012\u0006\u0010>\u001a\u000201H\u0002J\b\u0010?\u001a\u00020$H\u0002J\u0012\u0010@\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenStretchEdgeEffect;", "Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffect;", "context", "Landroid/content/Context;", "mOwnerView", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "mScreenWidth", "", "mScreenHeight", "mIsEffectEnabled", "", "mIsActionMove", "mCurPullTime", "", "mEffectRecede", "mRotation", "", "mTransitionX", "", "mTransitionY", "mPrevPoint", "Landroid/graphics/PointF;", "mCurPoint", "mDeltaPoint", "mEffect", "", "Landroid/widget/EdgeEffect;", "[Landroid/widget/EdgeEffect;", "mDirection", "mTouchFrameCount", "mIsShowHorizontalEdgeEffect", "isFinished", "()Z", "init", "", "drawEffect", "canvas", "Landroid/graphics/Canvas;", "onTouch", "event", "Landroid/view/MotionEvent;", "showEdgeEffect", "left", "top", "right", "bottom", "velocityX", "", "velocityY", "setEffectEnabled", "enabled", "setScreenInfo", "width", "height", "startX", "startY", "close", "onPull", "direction", "deltaDistance", "velocity", "releaseEdgeEffect", "isOppositeScroll", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenStretchEdgeEffect implements SpenEdgeEffect {
    private static final float DEFAULT_DURATION = 0.25f;
    public static final int MAX_FRAME_COUNT_FOR_HORIZONTAL_EDGE_EFFECT = 3;
    public static final float MIN_GRADIENT_FOR_HORIZONTAL_EDGE_EFFECT = 0.1f;
    private static final float MIN_VELOCITY = 100.0f;
    private static final float OPPOSITE_SCROLL_THRESHOLD = 0.2f;
    private static final long PULL_TIME = 167;

    @NotNull
    private static final String TAG = "SpenStretchEdgeEffect";

    @NotNull
    private PointF mCurPoint;
    private long mCurPullTime;

    @NotNull
    private PointF mDeltaPoint;
    private int mDirection;

    @NotNull
    private EdgeEffect[] mEffect;
    private boolean mEffectRecede;
    private boolean mIsActionMove;
    private boolean mIsEffectEnabled;
    private boolean mIsShowHorizontalEdgeEffect;

    @NotNull
    private final View mOwnerView;

    @NotNull
    private PointF mPrevPoint;

    @NotNull
    private float[] mRotation;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchFrameCount;

    @NotNull
    private int[] mTransitionX;

    @NotNull
    private int[] mTransitionY;

    public SpenStretchEdgeEffect(@Nullable Context context, @NotNull View mOwnerView) {
        Intrinsics.checkNotNullParameter(mOwnerView, "mOwnerView");
        this.mOwnerView = mOwnerView;
        this.mRotation = new float[4];
        this.mTransitionX = new int[4];
        this.mTransitionY = new int[4];
        this.mPrevPoint = new PointF();
        this.mCurPoint = new PointF();
        this.mDeltaPoint = new PointF();
        this.mEffect = new EdgeEffect[4];
        this.mIsShowHorizontalEdgeEffect = true;
        init(context);
    }

    private final void init(Context context) {
        this.mDirection = -1;
        for (int i = 0; i < 4; i++) {
            this.mEffect[i] = new EdgeEffect(context);
            this.mRotation[i] = i * 90.0f;
        }
        int[] iArr = this.mTransitionX;
        iArr[0] = 0;
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 0;
        int[] iArr2 = this.mTransitionY;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 1;
        iArr2[3] = 1;
        this.mIsEffectEnabled = true;
        this.mIsActionMove = false;
    }

    private final boolean isOppositeScroll(MotionEvent event) {
        boolean z = false;
        if (event == null) {
            return false;
        }
        float x = event.getX() - this.mCurPoint.x;
        float y2 = event.getY() - this.mCurPoint.y;
        int i = this.mDirection;
        boolean z2 = (i == 1 && x > 0.2f) | (i == 3 && x < -0.2f) | (i == 0 && y2 < -0.2f);
        if (i == 2 && y2 > 0.2f) {
            z = true;
        }
        return z2 | z;
    }

    private final void onPull(int direction, float deltaDistance, float velocity) {
        EdgeEffect edgeEffect = this.mEffect[direction];
        if (edgeEffect != null) {
            if (!this.mIsActionMove) {
                if (velocity <= 100.0f || this.mEffectRecede) {
                    return;
                }
                this.mDirection = direction;
                edgeEffect.onPull((velocity * 0.25f) / edgeEffect.getMaxHeight());
                this.mOwnerView.invalidate();
                new Handler().postDelayed(new RunnableC10960a(edgeEffect, this, 24), PULL_TIME);
                return;
            }
            if (deltaDistance < 0.0f) {
                if (edgeEffect.isFinished()) {
                    return;
                }
                edgeEffect.onRelease();
                this.mOwnerView.invalidate();
                return;
            }
            this.mDirection = direction;
            edgeEffect.onPull(deltaDistance / edgeEffect.getMaxHeight());
            this.mOwnerView.invalidate();
            this.mPrevPoint.set(this.mCurPoint);
            this.mCurPullTime = SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPull$lambda$3$lambda$2(EdgeEffect edgeEffect, SpenStretchEdgeEffect spenStretchEdgeEffect) {
        edgeEffect.onRelease();
        spenStretchEdgeEffect.mEffectRecede = true;
    }

    private final void releaseEdgeEffect() {
        for (int i = 0; i < 4; i++) {
            EdgeEffect edgeEffect = this.mEffect[i];
            if (edgeEffect != null) {
                edgeEffect.onRelease();
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    public void drawEffect(@Nullable Canvas canvas) {
        if (canvas == null) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (this.mEffect[i] == null) {
                return;
            }
        }
        for (int i2 = 0; i2 < 4; i2++) {
            EdgeEffect edgeEffect = this.mEffect[i2];
            if (edgeEffect != null && !edgeEffect.isFinished()) {
                int iSave = canvas.save();
                canvas.translate(this.mScreenWidth * this.mTransitionX[i2], this.mScreenHeight * this.mTransitionY[i2]);
                canvas.rotate(this.mRotation[i2]);
                if (edgeEffect.draw(canvas)) {
                    this.mOwnerView.invalidate();
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    public boolean isFinished() {
        for (int i = 0; i < 4; i++) {
            EdgeEffect edgeEffect = this.mEffect[i];
            if (edgeEffect != null && !edgeEffect.isFinished()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTouch(@Nullable MotionEvent event) {
        if (event == null || !this.mIsEffectEnabled) {
            return;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            releaseEdgeEffect();
            this.mIsActionMove = false;
            this.mEffectRecede = false;
            this.mPrevPoint.set(event.getX(), event.getY());
            this.mTouchFrameCount = 0;
            this.mIsShowHorizontalEdgeEffect = true;
        } else if (actionMasked == 1) {
            this.mIsActionMove = false;
            releaseEdgeEffect();
        } else if (actionMasked == 2) {
            this.mIsActionMove = true;
            int i = this.mTouchFrameCount + 1;
            this.mTouchFrameCount = i;
            if (this.mIsShowHorizontalEdgeEffect && i < 3) {
                PointF pointF = this.mDeltaPoint;
                if (Math.abs(pointF.y / pointF.x) > 0.10000000149011612d) {
                    this.mIsShowHorizontalEdgeEffect = false;
                }
            }
            if (this.mDirection != -1) {
                if (isOppositeScroll(event)) {
                    EdgeEffect edgeEffect = this.mEffect[this.mDirection];
                    if (edgeEffect != null) {
                        edgeEffect.onRelease();
                    }
                    this.mDirection = -1;
                } else if (SystemClock.currentThreadTimeMillis() - this.mCurPullTime > PULL_TIME) {
                    onPull(this.mDirection, 0.0f, 0.0f);
                }
            }
        } else if (actionMasked == 3) {
        }
        this.mCurPoint.set(event.getX(), event.getY());
    }

    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    public void setEffectEnabled(boolean enabled) {
        this.mIsEffectEnabled = enabled;
    }

    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    public void setScreenInfo(int width, int height, int startX, int startY) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "setScreenInfo width=", ", height=", ", startX=");
        sbM1173s.append(startX);
        sbM1173s.append(", startY=");
        sbM1173s.append(startY);
        Log.d(TAG, sbM1173s.toString());
        this.mScreenWidth = width;
        this.mScreenHeight = height;
        EdgeEffect edgeEffect = this.mEffect[3];
        if (edgeEffect != null) {
            edgeEffect.setSize(height, width);
        }
        EdgeEffect edgeEffect2 = this.mEffect[0];
        if (edgeEffect2 != null) {
            edgeEffect2.setSize(this.mScreenWidth, this.mScreenHeight);
        }
        EdgeEffect edgeEffect3 = this.mEffect[1];
        if (edgeEffect3 != null) {
            edgeEffect3.setSize(this.mScreenHeight, this.mScreenWidth);
        }
        EdgeEffect edgeEffect4 = this.mEffect[2];
        if (edgeEffect4 != null) {
            edgeEffect4.setSize(this.mScreenWidth, this.mScreenHeight);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffect
    public void showEdgeEffect(boolean left, boolean top, boolean right, boolean bottom, float velocityX, float velocityY) {
        if (this.mIsEffectEnabled) {
            PointF pointF = this.mDeltaPoint;
            PointF pointF2 = this.mCurPoint;
            float f = pointF2.x;
            PointF pointF3 = this.mPrevPoint;
            pointF.set(f - pointF3.x, pointF2.y - pointF3.y);
            if (left && this.mIsShowHorizontalEdgeEffect) {
                onPull(3, this.mDeltaPoint.x, -velocityX);
            }
            if (top) {
                onPull(0, this.mDeltaPoint.y, -velocityY);
            }
            if (right && this.mIsShowHorizontalEdgeEffect) {
                onPull(1, -this.mDeltaPoint.x, velocityX);
            }
            if (bottom) {
                onPull(2, -this.mDeltaPoint.y, velocityY);
            }
        }
    }
}
