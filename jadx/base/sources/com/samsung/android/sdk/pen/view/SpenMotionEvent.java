package com.samsung.android.sdk.pen.view;

import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import androidx.compose.animation.core.AnimationKt;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 )2\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u001b\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u001b\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u0011\u0010\"\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u0011\u0010&\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\r¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "", "event", "Landroid/view/MotionEvent;", "<init>", "(Landroid/view/MotionEvent;)V", "msToNano", "", "getMsToNano", "()J", "action", "", "getAction", "()I", "toolType", "getToolType", "downTime", "getDownTime", "eventTime", "getEventTime", "eventTimeNano", "getEventTimeNano", "pointerCount", "getPointerCount", "eventInfo", "", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent$EventInfo;", "getEventInfo", "()[Lcom/samsung/android/sdk/pen/view/SpenMotionEvent$EventInfo;", "[Lcom/samsung/android/sdk/pen/view/SpenMotionEvent$EventInfo;", "historySize", "getHistorySize", "historicalEventInfo", "getHistoricalEventInfo", "source", "getSource", "buttonState", "getButtonState", "flags", "getFlags", "EventInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMotionEvent {

    @NotNull
    private static final String TAG = "SpenMotionEvent";

    @Nullable
    private static Method getEventTimeNanosMethod;

    @Nullable
    private static Method getHistoryEventTimeNanosMethod;

    @Nullable
    private static Method isResampledMethod;
    private static final boolean isUpsideDownCakeAndAbove;
    private final int action;
    private final int buttonState;
    private final long downTime;

    @NotNull
    private final EventInfo[] eventInfo;
    private final long eventTime;
    private final long eventTimeNano;
    private final int flags;

    @NotNull
    private final EventInfo[] historicalEventInfo;
    private final int historySize;
    private final long msToNano;
    private final int pointerCount;
    private final int source;
    private final int toolType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean checkNanoAPI = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenMotionEvent$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "checkNanoAPI", "", "getCheckNanoAPI", "()Z", "setCheckNanoAPI", "(Z)V", "getEventTimeNanosMethod", "Ljava/lang/reflect/Method;", "getGetEventTimeNanosMethod", "()Ljava/lang/reflect/Method;", "setGetEventTimeNanosMethod", "(Ljava/lang/reflect/Method;)V", "getHistoryEventTimeNanosMethod", "getGetHistoryEventTimeNanosMethod", "setGetHistoryEventTimeNanosMethod", "isResampledMethod", "setResampledMethod", "isUpsideDownCakeAndAbove", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getCheckNanoAPI() {
            return SpenMotionEvent.checkNanoAPI;
        }

        @Nullable
        public final Method getGetEventTimeNanosMethod() {
            return SpenMotionEvent.getEventTimeNanosMethod;
        }

        @Nullable
        public final Method getGetHistoryEventTimeNanosMethod() {
            return SpenMotionEvent.getHistoryEventTimeNanosMethod;
        }

        @Nullable
        public final Method isResampledMethod() {
            return SpenMotionEvent.isResampledMethod;
        }

        public final boolean isUpsideDownCakeAndAbove() {
            return SpenMotionEvent.isUpsideDownCakeAndAbove;
        }

        public final void setCheckNanoAPI(boolean z) {
            SpenMotionEvent.checkNanoAPI = z;
        }

        public final void setGetEventTimeNanosMethod(@Nullable Method method) {
            SpenMotionEvent.getEventTimeNanosMethod = method;
        }

        public final void setGetHistoryEventTimeNanosMethod(@Nullable Method method) {
            SpenMotionEvent.getHistoryEventTimeNanosMethod = method;
        }

        public final void setResampledMethod(@Nullable Method method) {
            SpenMotionEvent.isResampledMethod = method;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001a\u0010(\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenMotionEvent$EventInfo;", "", "<init>", "()V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", "eventTimeNano", "getEventTimeNano", "setEventTimeNano", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "pressure", "getPressure", "setPressure", "tilt", "getTilt", "setTilt", "orientation", "getOrientation", "setOrientation", "minor", "getMinor", "setMinor", "major", "getMajor", "setMajor", "rawX", "getRawX", "setRawX", "rawY", "getRawY", "setRawY", "id", "", "getId", "()I", "setId", "(I)V", "isResampled", "", "()Z", "setResampled", "(Z)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class EventInfo {
        private long eventTime;
        private long eventTimeNano;
        private int id;
        private boolean isResampled;
        private float major;
        private float minor;
        private float orientation;
        private float pressure;
        private float rawX;
        private float rawY;
        private float tilt;
        private float x;
        private float y;

        public final long getEventTime() {
            return this.eventTime;
        }

        public final long getEventTimeNano() {
            return this.eventTimeNano;
        }

        public final int getId() {
            return this.id;
        }

        public final float getMajor() {
            return this.major;
        }

        public final float getMinor() {
            return this.minor;
        }

        public final float getOrientation() {
            return this.orientation;
        }

        public final float getPressure() {
            return this.pressure;
        }

        public final float getRawX() {
            return this.rawX;
        }

        public final float getRawY() {
            return this.rawY;
        }

        public final float getTilt() {
            return this.tilt;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: isResampled, reason: from getter */
        public final boolean getIsResampled() {
            return this.isResampled;
        }

        public final void setEventTime(long j) {
            this.eventTime = j;
        }

        public final void setEventTimeNano(long j) {
            this.eventTimeNano = j;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setMajor(float f) {
            this.major = f;
        }

        public final void setMinor(float f) {
            this.minor = f;
        }

        public final void setOrientation(float f) {
            this.orientation = f;
        }

        public final void setPressure(float f) {
            this.pressure = f;
        }

        public final void setRawX(float f) {
            this.rawX = f;
        }

        public final void setRawY(float f) {
            this.rawY = f;
        }

        public final void setResampled(boolean z) {
            this.isResampled = z;
        }

        public final void setTilt(float f) {
            this.tilt = f;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final void setY(float f) {
            this.y = f;
        }
    }

    static {
        isUpsideDownCakeAndAbove = Build.VERSION.SDK_INT >= 34;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SpenMotionEvent(@NotNull MotionEvent event) {
        Object obj;
        Intrinsics.checkNotNullParameter(event, "event");
        this.msToNano = AnimationKt.MillisToNanos;
        if (checkNanoAPI) {
            checkNanoAPI = false;
            try {
                getEventTimeNanosMethod = MotionEvent.class.getMethod("semGetEventTimeNano", null);
            } catch (Exception unused) {
            }
            try {
                getHistoryEventTimeNanosMethod = MotionEvent.class.getMethod("semGetHistoricalEventTimeNano", Integer.TYPE);
            } catch (Exception unused2) {
            }
            Log.d(TAG, "NanoSecond event time API check, main: " + (getEventTimeNanosMethod == null ? "not found" : "found") + ", history: " + (getHistoryEventTimeNanosMethod == null ? "not found" : "found"));
        }
        try {
            isResampledMethod = MotionEvent.PointerCoords.class.getDeclaredMethod("isResampled", null);
        } catch (NoSuchMethodException | SecurityException unused3) {
        }
        this.action = event.getActionMasked();
        this.toolType = event.getToolType(0);
        this.downTime = event.getDownTime();
        long eventTime = event.getEventTime();
        this.eventTime = eventTime;
        long jLongValue = eventTime * this.msToNano;
        Method method = getEventTimeNanosMethod;
        if (method != null) {
            try {
                Intrinsics.checkNotNull(method);
                Object objInvoke = method.invoke(event, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Long");
                jLongValue = ((Long) objInvoke).longValue();
            } catch (Exception unused4) {
            }
        }
        this.eventTimeNano = jLongValue;
        int pointerCount = event.getPointerCount();
        this.pointerCount = pointerCount;
        this.eventInfo = new EventInfo[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            EventInfo eventInfo = new EventInfo();
            eventInfo.setX(event.getX(i));
            eventInfo.setY(event.getY(i));
            if (Build.VERSION.SDK_INT >= 29) {
                eventInfo.setRawX(event.getRawX(i));
                eventInfo.setRawY(event.getRawY(i));
            } else {
                eventInfo.setRawX(event.getX(i));
                eventInfo.setRawY(event.getY(i));
            }
            eventInfo.setPressure(event.getPressure(i));
            eventInfo.setTilt(event.getAxisValue(25, i));
            eventInfo.setOrientation(event.getAxisValue(8, i));
            eventInfo.setId(event.getPointerId(i));
            eventInfo.setMinor(event.getToolMinor());
            eventInfo.setMajor(event.getToolMajor());
            eventInfo.setResampled(false);
            if (isUpsideDownCakeAndAbove) {
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                event.getPointerCoords(i, pointerCoords);
                try {
                    Method method2 = isResampledMethod;
                    Object objInvoke2 = method2 != null ? method2.invoke(pointerCoords, null) : null;
                    Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.Boolean");
                    eventInfo.setResampled(((Boolean) objInvoke2).booleanValue());
                } catch (Exception unused5) {
                }
            }
            this.eventInfo[i] = eventInfo;
        }
        int historySize = event.getHistorySize();
        this.historySize = historySize;
        int i2 = historySize * this.pointerCount;
        this.historicalEventInfo = new EventInfo[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.historySize;
            int i6 = i4 / i5;
            int i7 = i4 % i5;
            EventInfo eventInfo2 = new EventInfo();
            eventInfo2.setEventTime(event.getHistoricalEventTime(i7));
            eventInfo2.setEventTimeNano(eventInfo2.getEventTime() * this.msToNano);
            Method method3 = getHistoryEventTimeNanosMethod;
            if (method3 != null) {
                try {
                    Intrinsics.checkNotNull(method3);
                    Object objInvoke3 = method3.invoke(event, Integer.valueOf(i7));
                    Intrinsics.checkNotNull(objInvoke3, "null cannot be cast to non-null type kotlin.Long");
                    eventInfo2.setEventTimeNano(((Long) objInvoke3).longValue());
                } catch (Exception unused6) {
                }
            }
            eventInfo2.setX(event.getHistoricalX(i6, i7));
            eventInfo2.setY(event.getHistoricalY(i6, i7));
            eventInfo2.setPressure(event.getHistoricalPressure(i6, i7));
            eventInfo2.setTilt(event.getHistoricalAxisValue(25, i6, i7));
            eventInfo2.setOrientation(event.getHistoricalAxisValue(8, i6, i7));
            eventInfo2.setMinor(event.getHistoricalToolMinor(i6, i7));
            eventInfo2.setMajor(event.getHistoricalToolMajor(i6, i7));
            eventInfo2.setResampled(false);
            if (isUpsideDownCakeAndAbove) {
                MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
                event.getHistoricalPointerCoords(i6, i7, pointerCoords2);
                Method method4 = isResampledMethod;
                if (method4 != null) {
                    try {
                        Intrinsics.checkNotNull(method4);
                        obj = null;
                        try {
                            Object objInvoke4 = method4.invoke(pointerCoords2, null);
                            Intrinsics.checkNotNull(objInvoke4, "null cannot be cast to non-null type kotlin.Boolean");
                            eventInfo2.setResampled(((Boolean) objInvoke4).booleanValue());
                        } catch (Exception unused7) {
                        }
                    } catch (Exception unused8) {
                        obj = null;
                    }
                } else {
                    obj = null;
                }
            }
            this.historicalEventInfo[i4] = eventInfo2;
        }
        this.source = event.getSource();
        this.buttonState = event.getButtonState();
        this.flags = event.getFlags();
    }

    public final int getAction() {
        return this.action;
    }

    public final int getButtonState() {
        return this.buttonState;
    }

    public final long getDownTime() {
        return this.downTime;
    }

    @NotNull
    public final EventInfo[] getEventInfo() {
        return this.eventInfo;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final long getEventTimeNano() {
        return this.eventTimeNano;
    }

    public final int getFlags() {
        return this.flags;
    }

    @NotNull
    public final EventInfo[] getHistoricalEventInfo() {
        return this.historicalEventInfo;
    }

    public final int getHistorySize() {
        return this.historySize;
    }

    public final long getMsToNano() {
        return this.msToNano;
    }

    public final int getPointerCount() {
        return this.pointerCount;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getToolType() {
        return this.toolType;
    }
}
