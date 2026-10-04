package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0010\u0018\u0000 M2\u00020\u0001:\u0001MB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J(\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u000bH\u0014J\u0016\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007J&\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rJ\u0018\u00109\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0010\u0010>\u001a\u00020?2\u0006\u00101\u001a\u00020\u000bH\u0014J\u0010\u0010@\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u000bH\u0014J \u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0004J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0007H\u0004J \u0010F\u001a\u00020\u001c2\u0006\u00106\u001a\u0002072\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u0007H\u0014J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0016J\u0018\u0010K\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u00078DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R$\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreview;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "divider", "", "(Landroid/content/Context;F)V", "mStrokeSize", "mSizeLevel", "", "mIsFixedWidth", "", "mIsFixedOpacity", "mPointCount", "mCurrent", "mStartTime", "", "mCurrentTime", "mInterval", "mCountOfPoint", "mStartPointX", "mStartPointY", "mDx", "mDp", "mSpaceDivider", "close", "", "sizeLevel", "getSizeLevel", "()I", "setSizeLevel", "(I)V", "isFixedWidth", "()Z", "isFixedOpacity", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "getDp", "()F", "drawStartEvent", "Landroid/view/MotionEvent;", "getDrawStartEvent", "()Landroid/view/MotionEvent;", "drawNextEvent", "getDrawNextEvent", "drawEndEvent", "getDrawEndEvent", TextConst.METHOD_GET_EVENT, "index", "downTime", "eventTime", "action", "readyToDraw", "view", "Landroid/view/View;", "strokeSize", "calculatePoints", "count", "pointCount", "getPointCount", "setPointCount", "getPoint", "Landroid/graphics/PointF;", "getPressure", "setPoint", "startX", "startY", "dx", "setDp", "checkDeltaValue", "defaultPCount", "defaultDp", "getAdditionalDeleteArea", "space", "decidePosition", "init", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPreview {
    public static final float PRESSURE_DP = 0.025f;
    public static final float PRESSURE_START = 0.7f;
    protected static final int PREVIEW_POINT_COUNT = 8;

    @NotNull
    private static final String TAG = "SpenPreview";
    private static final int TIMESTAMP = 500;
    private int mCountOfPoint;
    private int mCurrent;
    private long mCurrentTime;
    private float mDp;
    private float mDx;
    private long mInterval;
    private boolean mIsFixedOpacity;
    private boolean mIsFixedWidth;
    private int mPointCount;
    private int mSizeLevel = -1;
    private float mSpaceDivider;
    private float mStartPointX;
    private float mStartPointY;
    private long mStartTime;
    private float mStrokeSize;

    public SpenPreview(@Nullable Context context) {
        init(2.0f);
    }

    private final void init(float divider) {
        this.mStartPointX = 0.0f;
        this.mStartPointY = 0.0f;
        setPointCount(8);
        this.mDp = 0.025f;
        this.mSpaceDivider = divider;
    }

    public int calculatePoints(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        checkDeltaValue(view, 8, 0.025f);
        return decidePosition(view, strokeSize);
    }

    public void checkDeltaValue(@NotNull View view, int defaultPCount, float defaultDp) {
        Intrinsics.checkNotNullParameter(view, "view");
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth > ((double) measuredHeight) * 1.5d) {
            setPointCount((measuredWidth / measuredHeight) * defaultPCount);
            setDp((defaultDp * (defaultPCount - 1)) / getMCountOfPoint());
        } else {
            setPointCount(defaultPCount);
            setDp(defaultDp);
        }
    }

    public int decidePosition(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        int measuredWidth = (view.getMeasuredWidth() - view.getPaddingStart()) - view.getPaddingEnd();
        float f = strokeSize / this.mSpaceDivider;
        int additionalDeleteArea = measuredWidth - ((int) getAdditionalDeleteArea(f));
        int mCountOfPoint = getMCountOfPoint();
        float f4 = additionalDeleteArea / (mCountOfPoint + 1);
        setPoint(view.getPaddingStart() + f4 + f, view.getMeasuredHeight() / 2, f4);
        return mCountOfPoint;
    }

    public float getAdditionalDeleteArea(float space) {
        return 2 * space;
    }

    /* JADX INFO: renamed from: getDp, reason: from getter */
    public final float getMDp() {
        return this.mDp;
    }

    @Nullable
    public MotionEvent getDrawEndEvent() {
        int i = this.mCurrent;
        if (i != this.mPointCount - 1) {
            return null;
        }
        long j = this.mStartTime;
        return getEvent(i, j, ((long) 500) + j, 1);
    }

    @Nullable
    public MotionEvent getDrawNextEvent() {
        int i = this.mCurrent;
        if (i >= this.mPointCount - 1) {
            return null;
        }
        MotionEvent event = getEvent(i, this.mStartTime, this.mCurrentTime, 2);
        this.mCurrentTime += this.mInterval;
        this.mCurrent++;
        return event;
    }

    @Nullable
    public MotionEvent getDrawStartEvent() {
        int mCountOfPoint = getMCountOfPoint();
        this.mPointCount = mCountOfPoint;
        this.mCurrent = 0;
        this.mInterval = 500 / (mCountOfPoint - 1);
        if (mCountOfPoint <= 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mStartTime = jCurrentTimeMillis;
        MotionEvent event = getEvent(this.mCurrent, jCurrentTimeMillis, jCurrentTimeMillis, 0);
        this.mCurrent++;
        this.mCurrentTime = this.mStartTime + this.mInterval;
        return event;
    }

    @NotNull
    public MotionEvent getEvent(int index, long downTime, long eventTime, int action) {
        PointF point = getPoint(index);
        MotionEvent motionEventObtain = MotionEvent.obtain(downTime, eventTime, action, point.x, point.y, getPressure(index), this.mStrokeSize, 0, 0.0f, 0.0f, 0, 0);
        Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
        return motionEventObtain;
    }

    @NotNull
    public PointF getPoint(int index) {
        return new PointF((this.mDx * index) + this.mStartPointX, this.mStartPointY);
    }

    /* JADX INFO: renamed from: getPointCount, reason: from getter */
    public int getMCountOfPoint() {
        return this.mCountOfPoint;
    }

    public float getPressure(int index) {
        return 0.7f - (this.mDp * index);
    }

    /* JADX INFO: renamed from: getSizeLevel, reason: from getter */
    public final int getMSizeLevel() {
        return this.mSizeLevel;
    }

    /* JADX INFO: renamed from: isFixedOpacity, reason: from getter */
    public final boolean getMIsFixedOpacity() {
        return this.mIsFixedOpacity;
    }

    /* JADX INFO: renamed from: isFixedWidth, reason: from getter */
    public final boolean getMIsFixedWidth() {
        return this.mIsFixedWidth;
    }

    public final int readyToDraw(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mStrokeSize = strokeSize;
        return calculatePoints(view, strokeSize);
    }

    public final void setDp(float dp) {
        this.mDp = dp;
    }

    public final void setPoint(float startX, float startY, float dx) {
        this.mStartPointX = startX;
        this.mStartPointY = startY;
        this.mDx = dx;
    }

    public void setPointCount(int i) {
        this.mCountOfPoint = i;
    }

    public final void setSizeLevel(int i) {
        this.mSizeLevel = i;
        AbstractC2322a.m1631u(i, "seSizeLevel=", TAG);
    }

    public final int readyToDraw(@NotNull View view, float strokeSize, boolean isFixedWidth, boolean isFixedOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mIsFixedWidth = isFixedWidth;
        this.mIsFixedOpacity = isFixedOpacity;
        this.mStrokeSize = strokeSize;
        return calculatePoints(view, strokeSize);
    }

    public SpenPreview(@Nullable Context context, float f) {
        init(f);
    }

    public void close() {
    }
}
