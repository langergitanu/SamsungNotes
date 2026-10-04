package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenInkPreview;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreview;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPointCount", "", "mCurrent", "mStartTime", "", "mCurrentTime", "mInterval", "drawStartEvent", "Landroid/view/MotionEvent;", "getDrawStartEvent", "()Landroid/view/MotionEvent;", "drawNextEvent", "getDrawNextEvent", "drawEndEvent", "getDrawEndEvent", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenInkPreview extends SpenPreview {

    @NotNull
    private static final String TAG = "SpenInkPreview";
    private static final int TIMESTAMP = 250;
    private int mCurrent;
    private long mCurrentTime;
    private long mInterval;
    private int mPointCount;
    private long mStartTime;

    public SpenInkPreview(@Nullable Context context) {
        super(context);
        Log.i(TAG, "SpenInkPreview() count=200 timeStamp=250");
        setPointCount(200);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    @Nullable
    public MotionEvent getDrawEndEvent() {
        int i = this.mCurrent;
        if (i != this.mPointCount - 1) {
            return null;
        }
        long j = this.mStartTime;
        return getEvent(i, j, ((long) 250) + j, 1);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
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

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    @Nullable
    public MotionEvent getDrawStartEvent() {
        this.mPointCount = getMCountOfPoint();
        this.mCurrent = 0;
        this.mInterval = 1L;
        Log.i(TAG, "@@@@@ getDrawStartEvent() isFixedWidth()" + getMIsFixedWidth() + " interval=" + this.mInterval);
        if (this.mPointCount <= 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mStartTime = jCurrentTimeMillis;
        MotionEvent event = getEvent(this.mCurrent, jCurrentTimeMillis, jCurrentTimeMillis, 0);
        this.mCurrent++;
        this.mCurrentTime = this.mStartTime + this.mInterval;
        return event;
    }
}
