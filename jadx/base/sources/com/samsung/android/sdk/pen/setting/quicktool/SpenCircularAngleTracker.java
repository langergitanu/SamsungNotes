package com.samsung.android.sdk.pen.setting.quicktool;

import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTUtil;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularAngleTracker;", "", "angleStep", "", "<init>", "(F)V", "currentValue", "", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "accumulatedRotation", "currentAngle", "start", "", "angle", SecureFolderConstants.TEMP_FOLDER_NAME, "getScrollDirection", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTUtil$ScrollDirection;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCircularAngleTracker {
    private static final float DEFAULT_ANGLE_STEP = 3.6f;
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 1;

    @NotNull
    private static final String TAG = "SpenCircularAngleTracker";
    private float accumulatedRotation;
    private final float angleStep;
    private float currentAngle;
    private int currentValue;

    public SpenCircularAngleTracker() {
        this(0.0f, 1, null);
    }

    public final int getCurrentValue() {
        return this.currentValue;
    }

    @NotNull
    public final SpenSettingQTUtil.ScrollDirection getScrollDirection() {
        float f = this.accumulatedRotation;
        return f > 0.0f ? SpenSettingQTUtil.ScrollDirection.DIR_COUNTER_CLOCK_WISE : f < 0.0f ? SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE : SpenSettingQTUtil.ScrollDirection.DIR_NONE;
    }

    public final void move(float angle) {
        float f = angle - this.currentAngle;
        if (f > 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        float f4 = this.accumulatedRotation + f;
        this.accumulatedRotation = f4;
        this.currentAngle = angle;
        float f5 = this.angleStep;
        int i = (int) (f4 / f5);
        if (i != 0) {
            this.accumulatedRotation = f4 - (i * f5);
            this.currentValue = RangesKt.coerceIn(this.currentValue + i, 1, 100);
        }
    }

    public final void setCurrentValue(int i) {
        this.currentValue = i;
    }

    public final void start(float angle) {
        this.accumulatedRotation = 0.0f;
        this.currentAngle = angle;
    }

    public SpenCircularAngleTracker(float f) {
        this.angleStep = f;
        this.currentValue = 1;
    }

    public /* synthetic */ SpenCircularAngleTracker(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_ANGLE_STEP : f);
    }
}
