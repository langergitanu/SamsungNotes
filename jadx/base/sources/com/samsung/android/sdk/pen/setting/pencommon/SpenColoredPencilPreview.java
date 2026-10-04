package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0014J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColoredPencilPreview;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreview;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPointY", "", "mXPoints", "", "createEvent", "Landroid/view/MotionEvent;", "event", "orientation", "tilt", TextConst.METHOD_GET_EVENT, "index", "", "downTime", "", "eventTime", "action", "calculatePoints", "view", "Landroid/view/View;", "strokeSize", "checkDeltaValue", "", "defaultPCount", "defaultDp", "getPressure", "decidePosition", "getPoint", "Landroid/graphics/PointF;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColoredPencilPreview extends SpenPreview {
    public static final int COLOREDPENCIL_PREVIEW_POINT_COUNT = 20;
    private float mPointY;

    @NotNull
    private float[] mXPoints;

    public SpenColoredPencilPreview(@Nullable Context context) {
        super(context);
        this.mXPoints = new float[21];
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public int calculatePoints(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        checkDeltaValue(view, 20, 0.025f);
        return decidePosition(view, strokeSize);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public void checkDeltaValue(@NotNull View view, int defaultPCount, float defaultDp) {
        Intrinsics.checkNotNullParameter(view, "view");
        setPointCount(defaultPCount);
        setDp(defaultDp);
    }

    @NotNull
    public final MotionEvent createEvent(@NotNull MotionEvent event, float orientation, float tilt) {
        Intrinsics.checkNotNullParameter(event, "event");
        long downTime = event.getDownTime();
        long eventTime = event.getEventTime();
        int metaState = event.getMetaState();
        int buttonState = event.getButtonState();
        float xPrecision = event.getXPrecision();
        float yPrecision = event.getYPrecision();
        int deviceId = event.getDeviceId();
        int edgeFlags = event.getEdgeFlags();
        int source = event.getSource();
        int flags = event.getFlags();
        int toolType = event.getToolType(0);
        MotionEvent.PointerProperties[] pointerPropertiesArr = {new MotionEvent.PointerProperties()};
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerPropertiesArr[0] = pointerProperties;
        pointerProperties.toolType = toolType;
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoordsArr[0] = pointerCoords;
        pointerCoords.setAxisValue(8, orientation);
        pointerCoordsArr[0].setAxisValue(25, tilt);
        pointerCoordsArr[0].x = event.getX();
        pointerCoordsArr[0].y = event.getY();
        pointerCoordsArr[0].pressure = event.getPressure();
        MotionEvent motionEventObtain = MotionEvent.obtain(downTime, eventTime, event.getAction(), 1, pointerPropertiesArr, pointerCoordsArr, metaState, buttonState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
        Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
        return motionEventObtain;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public int decidePosition(@NotNull View view, float strokeSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        int mCountOfPoint = getMCountOfPoint();
        this.mPointY = view.getMeasuredHeight() / 2.0f;
        this.mXPoints[0] = (strokeSize / 2.0f) + view.getPaddingStart();
        float measuredWidth = (((view.getMeasuredWidth() - view.getPaddingStart()) - view.getPaddingEnd()) - strokeSize) / (mCountOfPoint - 1);
        for (int i = 1; i < mCountOfPoint; i++) {
            float[] fArr = this.mXPoints;
            fArr[i] = fArr[i - 1] + measuredWidth;
        }
        setPointCount(mCountOfPoint);
        return mCountOfPoint;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    @NotNull
    public MotionEvent getEvent(int index, long downTime, long eventTime, int action) {
        MotionEvent event = super.getEvent(index, downTime, eventTime, action);
        if (index <= 0) {
            return event;
        }
        MotionEvent motionEventCreateEvent = createEvent(event, 0.0f, index * 0.075f);
        event.recycle();
        return motionEventCreateEvent;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    @NotNull
    public PointF getPoint(int index) {
        return new PointF(this.mXPoints[index], this.mPointY);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPreview
    public float getPressure(int index) {
        return 0.7f;
    }
}
