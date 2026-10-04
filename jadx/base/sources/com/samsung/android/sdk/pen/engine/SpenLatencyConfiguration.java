package com.samsung.android.sdk.pen.engine;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPadProPainting;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 I2\u00020\u0001:\u0001IB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ&\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201002\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105J\u0006\u00106\u001a\u00020)J\b\u00107\u001a\u00020)H\u0002J\u0010\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010;J\u000e\u0010<\u001a\u00020)2\u0006\u0010-\u001a\u00020\fJ\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\fJ\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020!H\u0003J \u0010A\u001a\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`D2\u0006\u0010$\u001a\u00020%H\u0003J\u0018\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020!H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0014\u0010\u001d\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mDisplayManager", "Landroid/hardware/display/DisplayManager;", "mDisplayListener", "Landroid/hardware/display/DisplayManager$DisplayListener;", "isChromeOS", "", "()Z", "setChromeOS", "(Z)V", "isVST", "setVST", "mUnbufferedDispatchEnabled", "isTouchAnalysisEnabled", "isDeviceSupportStylus", "supportPrediction", "", "getSupportPrediction", "()I", "supportPredictionInModel", "getSupportPredictionInModel", "isFrontBufferRenderingSupported", "isSupportUnbufferedDispatchTouch", "isSupportFrontBufferRendering", "hwRotation", "getHwRotation", "hwRefreshRate", "", "getHwRefreshRate", "()F", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "executeTouchAnalysis", "", "setUniformLatencyEnabled", "flag", "setUnbufferedDispatchEnabled", "enable", "checkAndUpdateUnbufferedDispatch", "getVisibleRects", "Landroid/util/Pair;", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "close", "updateRefreshRate", "updateHWInfo", "drawPad", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPad;", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPadProPainting;", "setForcedWithoutStylusSupport", "setVSTEnabled", "enabled", "requestRefreshRate", "refreshRate", "getAllowedDisplayMode", "Ljava/util/ArrayList;", "Landroid/view/Display$Mode;", "Lkotlin/collections/ArrayList;", "setPreferredDisplayRefreshRate", "window", "Landroid/view/Window;", "frameRate", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenLatencyConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenLatencyConfiguration.kt\ncom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,760:1\n1#2:761\n*E\n"})
public final class SpenLatencyConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenLatencyConf";
    private static boolean mIsForcedWithoutStylusSupport;
    private static boolean mIsInitializedPenAntiAliasEnabled;
    private static boolean mIsPenAntiAliasEnabled;
    private boolean isChromeOS;
    private boolean isVST;

    @Nullable
    private Context mContext;

    @Nullable
    private DisplayManager.DisplayListener mDisplayListener;

    @Nullable
    private DisplayManager mDisplayManager;
    private boolean mUnbufferedDispatchEnabled;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 J\t\u0010\u0010\u001a\u00020\rH\u0083 J\u0011\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 J\t\u0010\u0014\u001a\u00020\u0013H\u0083 J\u0011\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u0011\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0013H\u0083 J\u0011\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0017H\u0083 J!\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsInitializedPenAntiAliasEnabled", "", "mIsPenAntiAliasEnabled", "mIsForcedWithoutStylusSupport", "isPenAntiAliasEnabled", "()Z", "Native_init", "", "latencyConfiguration", "Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "Native_executeTouchAnalysis", "Native_updatePredictionType", "predictionType", "", "Native_getPredictionType", "Native_updateRefreshRate", "refreshRate", "", "Native_setAppRuntimeForChrome", "isARC", "Native_setAppRuntimeVST", "isVST", "Native_setUniformLatency", "flag", "Native_setUnbufferedDispatch", "enable", "Native_setHWRotation", Key.ROTATION, "Native_setHWRefreshRate", "rate", "Native_setScreenOrientation", "orientation", "realWidth", "realHeight", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_executeTouchAnalysis() {
            SpenLatencyConfiguration.Native_executeTouchAnalysis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPredictionType() {
            return SpenLatencyConfiguration.Native_getPredictionType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(SpenLatencyConfiguration latencyConfiguration) {
            SpenLatencyConfiguration.Native_init(latencyConfiguration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAppRuntimeForChrome(boolean isARC) {
            SpenLatencyConfiguration.Native_setAppRuntimeForChrome(isARC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAppRuntimeVST(boolean isVST) {
            SpenLatencyConfiguration.Native_setAppRuntimeVST(isVST);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHWRefreshRate(float rate) {
            SpenLatencyConfiguration.Native_setHWRefreshRate(rate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHWRotation(int rotation) {
            SpenLatencyConfiguration.Native_setHWRotation(rotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScreenOrientation(int orientation, int realWidth, int realHeight) {
            SpenLatencyConfiguration.Native_setScreenOrientation(orientation, realWidth, realHeight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setUnbufferedDispatch(boolean enable) {
            SpenLatencyConfiguration.Native_setUnbufferedDispatch(enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setUniformLatency(boolean flag) {
            SpenLatencyConfiguration.Native_setUniformLatency(flag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updatePredictionType(int predictionType) {
            SpenLatencyConfiguration.Native_updatePredictionType(predictionType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updateRefreshRate(float refreshRate) {
            SpenLatencyConfiguration.Native_updateRefreshRate(refreshRate);
        }

        public final synchronized boolean isPenAntiAliasEnabled() {
            if (SpenLatencyConfiguration.mIsInitializedPenAntiAliasEnabled) {
                return SpenLatencyConfiguration.mIsPenAntiAliasEnabled;
            }
            String[] strArr = {"SM-P61"};
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(str) && str.length() >= 7) {
                String str2 = strArr[0];
                Intrinsics.checkNotNull(str);
                boolean zM14145S = StringsKt.m14145S(str, str2);
                SpenLatencyConfiguration.mIsInitializedPenAntiAliasEnabled = true;
                SpenLatencyConfiguration.mIsPenAntiAliasEnabled = !zM14145S;
                Log.i(SpenLatencyConfiguration.TAG, "SpenLatencyConfiguration:: isPenAntiAliasEnabled deviceModelName : " + str + SQLKeyword.COMMA + (zM14145S ? "IN LIST" : "NOT IN LIST"));
                return SpenLatencyConfiguration.mIsPenAntiAliasEnabled;
            }
            return false;
        }

        private Companion() {
        }
    }

    public SpenLatencyConfiguration(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must be not null");
        }
        this.mContext = context;
        Companion companion = INSTANCE;
        companion.Native_init(this);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            boolean z = packageManager.hasSystemFeature("org.chromium.arc") || packageManager.hasSystemFeature("org.chromium.arc.device_management");
            this.isChromeOS = z;
            AbstractC4539a.m3208r("SpenLatencyConfiguration:: Is Chrome OS = ", TAG, z);
        }
        companion.Native_setAppRuntimeForChrome(this.isChromeOS);
        updateRefreshRate();
        Object systemService = context.getSystemService("display");
        DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
        this.mDisplayManager = displayManager;
        if (displayManager != null) {
            DisplayManager.DisplayListener displayListener = new DisplayManager.DisplayListener() { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$2$1
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int displayId) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int displayId) {
                    this.this$0.updateRefreshRate();
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int displayId) {
                }
            };
            this.mDisplayListener = displayListener;
            displayManager.registerDisplayListener(displayListener, null);
        }
        if (isTouchAnalysisEnabled()) {
            executeTouchAnalysis();
        }
        if (isSupportUnbufferedDispatchTouch()) {
            setUnbufferedDispatchEnabled(true);
        }
        companion.Native_setHWRotation(getHwRotation());
        companion.Native_setHWRefreshRate(getHwRefreshRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_executeTouchAnalysis();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPredictionType();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(SpenLatencyConfiguration spenLatencyConfiguration);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAppRuntimeForChrome(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAppRuntimeVST(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHWRefreshRate(float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHWRotation(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setScreenOrientation(int i, int i2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setUnbufferedDispatch(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setUniformLatency(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updatePredictionType(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updateRefreshRate(float f);

    private final Activity getActivity() {
        for (Context baseContext = this.mContext; baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        Log.i(TAG, "SpenLatencyConfiguration:: getActivity - Activity NOT found");
        return null;
    }

    @RequiresApi(api = 23)
    private final ArrayList<Display.Mode> getAllowedDisplayMode(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Log.d(TAG, "SpenLatencyConfiguration:: current refresh rate : " + ((int) defaultDisplay.getRefreshRate()) + "Hz");
        Display.Mode mode = defaultDisplay.getMode();
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        ArrayList<Display.Mode> arrayList = new ArrayList<>();
        if (supportedModes != null) {
            Iterator it = ArrayIteratorKt.iterator(supportedModes);
            while (it.hasNext()) {
                Display.Mode mode2 = (Display.Mode) it.next();
                if (mode != null && mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight()) {
                    arrayList.add(mode2);
                } else {
                    Log.d(TAG, "SpenLatencyConfiguration:: getRequestedMode skipping mode, mode=" + mode2);
                }
            }
        }
        return arrayList;
    }

    private final float getHwRefreshRate() {
        float displayRefreshRate;
        ArrayList arrayList = new ArrayList();
        final String str = "SM-T87";
        final float f = 120.0f;
        arrayList.add(new Object(str, f) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate
            private float displayRefreshRate;
            private String name;

            {
                Intrinsics.checkNotNullParameter(str, "name");
                this.name = str;
                this.displayRefreshRate = f;
            }

            public final float getDisplayRefreshRate() {
                return this.displayRefreshRate;
            }

            public final String getName() {
                return this.name;
            }

            public final void setDisplayRefreshRate(float f4) {
                this.displayRefreshRate = f4;
            }

            public final void setName(String str2) {
                Intrinsics.checkNotNullParameter(str2, "<set-?>");
                this.name = str2;
            }
        });
        final String str2 = "SM-T97";
        arrayList.add(new Object(str2, f) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate
            private float displayRefreshRate;
            private String name;

            {
                Intrinsics.checkNotNullParameter(str2, "name");
                this.name = str2;
                this.displayRefreshRate = f;
            }

            public final float getDisplayRefreshRate() {
                return this.displayRefreshRate;
            }

            public final String getName() {
                return this.name;
            }

            public final void setDisplayRefreshRate(float f4) {
                this.displayRefreshRate = f4;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }
        });
        String str3 = Build.MODEL;
        if (TextUtils.isEmpty(str3) || str3.length() < 7) {
            return 0.0f;
        }
        try {
            int i = FloatingFeatureWrapper.create(this.mContext).getInt("SEC_FLOATING_FEATURE_LCD_CONFIG_HFR_MODE");
            Log.i(TAG, "SpenLatencyConfiguration:: LCD_CONFIG_HFR_MODE : " + i);
            if (i == 4) {
                Log.i(TAG, "SpenLatencyConfiguration:: dVRR is on - Set refreshRate to 120hz");
                return 120.0f;
            }
        } catch (PlatformException e) {
            Log.d(TAG, "SpenLatencyConfiguration:: Could not find ContextProvider Exception = " + e);
        }
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                displayRefreshRate = 0.0f;
                break;
            }
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate spenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate = (SpenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate) next;
            Intrinsics.checkNotNull(str3);
            if (StringsKt.m14145S(str3, spenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate.getName())) {
                displayRefreshRate = spenLatencyConfiguration$hwRefreshRate$DeviceRefreshRate.getDisplayRefreshRate();
                break;
            }
        }
        Log.i(TAG, "SpenLatencyConfiguration:: getHwRefreshRate deviceModelName : " + str3 + SQLKeyword.COMMA + (displayRefreshRate == 0.0f ? "NOT IN LIST" : "IN LIST"));
        return displayRefreshRate;
    }

    private final int getHwRotation() {
        ArrayList arrayList = new ArrayList();
        final String str = "SM-T54";
        final int i = 2;
        arrayList.add(new Object(str, i) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str, "name");
                this.name = str;
                this.rotation = i;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str2) {
                Intrinsics.checkNotNullParameter(str2, "<set-?>");
                this.name = str2;
            }

            public final void setRotation(int i2) {
                this.rotation = i2;
            }
        });
        final String str2 = "SM-T83";
        final int i2 = 3;
        arrayList.add(new Object(str2, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str2, "name");
                this.name = str2;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str3 = "SM-T86";
        arrayList.add(new Object(str3, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str3, "name");
                this.name = str3;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str4 = "SM-T97";
        arrayList.add(new Object(str4, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str4, "name");
                this.name = str4;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str5 = "SM-F92";
        arrayList.add(new Object(str5, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str5, "name");
                this.name = str5;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str6 = "SM-F93";
        arrayList.add(new Object(str6, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str6, "name");
                this.name = str6;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str7 = "SM-F94";
        arrayList.add(new Object(str7, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str7, "name");
                this.name = str7;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str8 = "SM-F95";
        arrayList.add(new Object(str8, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str8, "name");
                this.name = str8;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str9 = "SM-X80";
        arrayList.add(new Object(str9, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str9, "name");
                this.name = str9;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str10 = "SM-X90";
        arrayList.add(new Object(str10, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str10, "name");
                this.name = str10;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str11 = "SM-X71";
        arrayList.add(new Object(str11, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str11, "name");
                this.name = str11;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str12 = "SM-X81";
        arrayList.add(new Object(str12, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str12, "name");
                this.name = str12;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str13 = "SM-X91";
        arrayList.add(new Object(str13, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str13, "name");
                this.name = str13;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str14 = "SM-X82";
        arrayList.add(new Object(str14, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str14, "name");
                this.name = str14;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str15 = "SM-X92";
        arrayList.add(new Object(str15, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str15, "name");
                this.name = str15;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str16 = "SM-X73";
        arrayList.add(new Object(str16, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str16, "name");
                this.name = str16;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str17 = "SM-X83";
        arrayList.add(new Object(str17, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str17, "name");
                this.name = str17;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str18 = "SM-X93";
        arrayList.add(new Object(str18, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str18, "name");
                this.name = str18;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str19 = "dedede";
        arrayList.add(new Object(str19, i2) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str19, "name");
                this.name = str19;
                this.rotation = i2;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str20 = "SM-T63";
        arrayList.add(new Object(str20, i) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str20, "name");
                this.name = str20;
                this.rotation = i;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        final String str21 = "SM-X35";
        arrayList.add(new Object(str21, i) { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$hwRotation$Device
            private String name;
            private int rotation;

            {
                Intrinsics.checkNotNullParameter(str21, "name");
                this.name = str21;
                this.rotation = i;
            }

            public final String getName() {
                return this.name;
            }

            public final int getRotation() {
                return this.rotation;
            }

            public final void setName(String str22) {
                Intrinsics.checkNotNullParameter(str22, "<set-?>");
                this.name = str22;
            }

            public final void setRotation(int i22) {
                this.rotation = i22;
            }
        });
        String str22 = Build.MODEL;
        int rotation = 0;
        if (TextUtils.isEmpty(str22)) {
            return 0;
        }
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenLatencyConfiguration$hwRotation$Device spenLatencyConfiguration$hwRotation$Device = (SpenLatencyConfiguration$hwRotation$Device) next;
            if (str22.length() >= spenLatencyConfiguration$hwRotation$Device.getName().length()) {
                Intrinsics.checkNotNull(str22);
                if (StringsKt.m14145S(str22, spenLatencyConfiguration$hwRotation$Device.getName())) {
                    rotation = spenLatencyConfiguration$hwRotation$Device.getRotation();
                    break;
                }
            }
        }
        Log.i(TAG, "SpenLatencyConfiguration:: getHwRotation deviceModelName : " + str22 + SQLKeyword.COMMA + (rotation != 0 ? "IN LIST" : "NOT IN LIST"));
        return rotation;
    }

    private final int getSupportPredictionInModel() {
        if (this.mContext == null) {
            return 0;
        }
        String str = Build.MODEL;
        if (!mIsForcedWithoutStylusSupport && !isDeviceSupportStylus()) {
            Log.i(TAG, "SpenLatencyConfiguration:: S-pen feature is not support on device, so prediction don't support.");
            return 0;
        }
        if (this.isChromeOS) {
            Integer num = new HashMap<String, Integer>() { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$supportPredictionInModel$chromeDevicePrediction$1
                {
                    put("hatch", 1);
                    put("dedede", 2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean containsValue(Integer num2) {
                    return super.containsValue((Object) num2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                public final /* bridge */ Integer getOrDefault(Object obj, Integer num2) {
                    return !(obj instanceof String) ? num2 : getOrDefault((String) obj, num2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<Integer> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<Integer> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str2) {
                    return super.containsKey((Object) str2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj instanceof Integer) {
                        return containsValue((Integer) obj);
                    }
                    return false;
                }

                public /* bridge */ Integer get(String str2) {
                    return (Integer) super.get((Object) str2);
                }

                public /* bridge */ Integer getOrDefault(String str2, Integer num2) {
                    return (Integer) super.getOrDefault((Object) str2, num2);
                }

                public /* bridge */ Integer remove(String str2) {
                    return (Integer) super.remove((Object) str2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Integer) obj2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if ((obj instanceof String) && (obj2 instanceof Integer)) {
                        return remove((String) obj, (Integer) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str2, Integer num2) {
                    return super.remove((Object) str2, (Object) num2);
                }
            }.get(str);
            if (num == null) {
                return 0;
            }
            Log.i(TAG, "SpenLatencyConfiguration:: getSupportPredictionInModel " + str + " device is in chromeDevicePrediction list prediction id = " + num);
            return num.intValue();
        }
        if (!TextUtils.isEmpty(str) && str.length() >= 7) {
            HashMap<String, Integer> map = new HashMap<String, Integer>() { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$supportPredictionInModel$predictionMap$1
                {
                    put("N98", 2);
                    put("N97", 2);
                    put("N96", 2);
                    put("N95", 2);
                    put("N93", 2);
                    put("T97", 2);
                    put("T87", 2);
                    put("T86", 2);
                    put("T73", 2);
                    put("F92", 3);
                    put("F93", 3);
                    put("X70", 3);
                    put("X80", 3);
                    put("X90", 3);
                    put("X71", 3);
                    put("X81", 3);
                    put("X91", 3);
                    put("X51", 2);
                    put("X61", 2);
                    put("F94", 3);
                    put("X82", 3);
                    put("X92", 3);
                    put("X73", 3);
                    put("X83", 3);
                    put("X93", 3);
                    put("F95", 3);
                    put("T82", 1);
                    put("T83", 1);
                    put("T54", 1);
                    put("T57", 1);
                    put("T63", 1);
                    put("P20", 1);
                    put("X52", 3);
                    put("X62", 2);
                    put("X30", 1);
                    put("X35", 1);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean containsValue(Integer num2) {
                    return super.containsValue((Object) num2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                public final /* bridge */ Integer getOrDefault(Object obj, Integer num2) {
                    return !(obj instanceof String) ? num2 : getOrDefault((String) obj, num2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<Integer> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<Integer> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str2) {
                    return super.containsKey((Object) str2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj instanceof Integer) {
                        return containsValue((Integer) obj);
                    }
                    return false;
                }

                public /* bridge */ Integer get(String str2) {
                    return (Integer) super.get((Object) str2);
                }

                public /* bridge */ Integer getOrDefault(String str2, Integer num2) {
                    return (Integer) super.getOrDefault((Object) str2, num2);
                }

                public /* bridge */ Integer remove(String str2) {
                    return (Integer) super.remove((Object) str2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Integer) obj2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if ((obj instanceof String) && (obj2 instanceof Integer)) {
                        return remove((String) obj, (Integer) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str2, Integer num2) {
                    return super.remove((Object) str2, (Object) num2);
                }
            };
            HashMap<String, Integer> map2 = new HashMap<String, Integer>() { // from class: com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration$supportPredictionInModel$predictionMap2$1
                {
                    put("G998", 2);
                    put("S918", 3);
                    put("S928", 3);
                    put("S938", 3);
                    put("S948", 3);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean containsValue(Integer num2) {
                    return super.containsValue((Object) num2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                public final /* bridge */ Integer getOrDefault(Object obj, Integer num2) {
                    return !(obj instanceof String) ? num2 : getOrDefault((String) obj, num2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<Integer> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<Integer> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str2) {
                    return super.containsKey((Object) str2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj instanceof Integer) {
                        return containsValue((Integer) obj);
                    }
                    return false;
                }

                public /* bridge */ Integer get(String str2) {
                    return (Integer) super.get((Object) str2);
                }

                public /* bridge */ Integer getOrDefault(String str2, Integer num2) {
                    return (Integer) super.getOrDefault((Object) str2, num2);
                }

                public /* bridge */ Integer remove(String str2) {
                    return (Integer) super.remove((Object) str2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Integer) obj2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if ((obj instanceof String) && (obj2 instanceof Integer)) {
                        return remove((String) obj, (Integer) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str2, Integer num2) {
                    return super.remove((Object) str2, (Object) num2);
                }
            };
            Intrinsics.checkNotNull(str);
            String strSubstring = str.substring(3, 6);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Integer num2 = map.get(strSubstring);
            if (num2 == null) {
                String strSubstring2 = str.substring(3, 7);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                num2 = map2.get(strSubstring2);
            }
            if (num2 != null) {
                Log.i(TAG, "SpenLatencyConfiguration:: getSupportPredictionInModel " + str + " sets " + num2);
                return num2.intValue();
            }
        }
        AbstractC4539a.m3207q("SpenLatencyConfiguration:: getSupportPredictionInModel ", str, " does not support prediction.", TAG);
        return 0;
    }

    private final boolean isDeviceSupportStylus() {
        Context context;
        if (this.isChromeOS) {
            return true;
        }
        if (this.isVST || (context = this.mContext) == null) {
            return false;
        }
        try {
            if (FloatingFeatureWrapper.create(context).getInt("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_SPEN_VERSION") > 0) {
                return true;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                if (packageManager.hasSystemFeature("com.sec.feature.spen_usp")) {
                    return true;
                }
            }
        } catch (PlatformException e) {
            e.printStackTrace();
        }
        return false;
    }

    private final boolean isSupportFrontBufferRendering() {
        boolean z;
        if (mIsForcedWithoutStylusSupport) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("SGH-N582");
        arrayList.add("SM-N93");
        arrayList.add("SM-N950U");
        String[][] strArr = {new String[]{"SM-P61", QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING}};
        String str = Build.MODEL;
        if (this.isChromeOS) {
            AbstractC4539a.m3207q("SpenLatencyConfiguration:: isSupportFrontBufferRendering Chrome OS deviceModelName : ", str, ", NOT IN LIST", TAG);
            return true;
        }
        if (this.isVST) {
            AbstractC4539a.m3207q("SpenLatencyConfiguration:: isSupportFrontBufferRendering VST device deviceModelName : ", str, ", NOT IN LIST", TAG);
            return true;
        }
        if (!TextUtils.isEmpty(str) && str.length() >= 7) {
            if (!PlatformUtils.isSamsungDevice(this.mContext)) {
                Log.i(TAG, "SpenLatencyConfiguration:: isSupportFrontBufferRendering() This model is not samsung device, FBR feature is disabled");
                return false;
            }
            if (!mIsForcedWithoutStylusSupport && !isDeviceSupportStylus()) {
                Log.i(TAG, "SpenLatencyConfiguration:: isSupportFrontBufferRendering() S-pen is not support by device, FBR feature is disabled");
                return false;
            }
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Intrinsics.checkNotNull(str);
                if (StringsKt.m14145S(str, (String) next)) {
                    z = false;
                    break;
                }
            }
            String[] strArr2 = strArr[0];
            Intrinsics.checkNotNull(str);
            z = (StringsKt.m14145S(str, strArr2[0]) && Build.VERSION.RELEASE.compareTo(strArr2[1]) == 0) ? false : z;
            Log.i(TAG, "SpenLatencyConfiguration:: isSupportFrontBufferRendering deviceModelName : " + str + SQLKeyword.COMMA + (!z ? "IN LIST" : "NOT IN LIST"));
        }
        return z;
    }

    private final boolean isSupportUnbufferedDispatchTouch() {
        boolean z = false;
        if ((!mIsForcedWithoutStylusSupport && !isDeviceSupportStylus()) || !isFrontBufferRenderingSupported()) {
            return false;
        }
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str) && str.length() >= 7) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("S938");
            arrayList.add("S948");
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Intrinsics.checkNotNull(str);
                if (StringsKt.m14162r(str, (String) next)) {
                    z = true;
                    break;
                }
            }
        }
        Log.i(TAG, "SpenLatencyConfiguration::isSupportUnbufferedDispatchTouch modelName : " + str + ", device is support UBD : " + z);
        return z;
    }

    private final boolean isTouchAnalysisEnabled() {
        if (mIsForcedWithoutStylusSupport || isDeviceSupportStylus()) {
            int supportPredictionInModel = getSupportPredictionInModel();
            if (supportPredictionInModel != 0) {
                INSTANCE.Native_updatePredictionType(supportPredictionInModel);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("SM-T39");
            arrayList.add("SM-P58");
            String str = Build.MODEL;
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Intrinsics.checkNotNull(str);
                if (StringsKt.m14145S(str, (String) next)) {
                }
            }
            return true;
        }
        return false;
    }

    @RequiresApi(api = 23)
    private final void requestRefreshRate(float refreshRate) {
        Display.Mode mode;
        Activity activity = getActivity();
        if (activity == null) {
            Log.i(TAG, "SpenLatencyConfiguration:: requestRefreshRate: activity is null");
            return;
        }
        Window window = activity.getWindow();
        Iterator<Display.Mode> it = getAllowedDisplayMode(activity).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                mode = null;
                break;
            }
            Display.Mode next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            mode = next;
            if (((int) mode.getRefreshRate()) == ((int) refreshRate)) {
                Log.d(TAG, "SpenLatencyConfiguration:: requestRefreshRate: set preferred display mode " + mode);
                break;
            }
        }
        if (mode == null) {
            window.getAttributes().preferredDisplayModeId = 0;
            Intrinsics.checkNotNull(window);
            setPreferredDisplayRefreshRate(window, 0.0f);
        } else {
            window.getAttributes().preferredDisplayModeId = mode.getModeId();
            Intrinsics.checkNotNull(window);
            setPreferredDisplayRefreshRate(window, refreshRate);
        }
    }

    private final void setPreferredDisplayRefreshRate(Window window, float frameRate) {
        try {
            Field field = WindowManager.LayoutParams.class.getField("preferredMinDisplayRefreshRate");
            Field field2 = WindowManager.LayoutParams.class.getField("preferredMaxDisplayRefreshRate");
            WindowManager.LayoutParams attributes = window.getAttributes();
            field.setFloat(attributes, frameRate);
            field2.setFloat(attributes, frameRate);
            window.setAttributes(attributes);
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.toString());
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRefreshRate() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        float refreshRate = defaultDisplay.getRefreshRate();
        Companion companion = INSTANCE;
        companion.Native_updateRefreshRate(refreshRate);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        companion.Native_setScreenOrientation(defaultDisplay.getRotation(), displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public final boolean checkAndUpdateUnbufferedDispatch() {
        INSTANCE.Native_setUnbufferedDispatch(this.mUnbufferedDispatchEnabled);
        return this.mUnbufferedDispatchEnabled;
    }

    public final void close() {
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayListener);
        }
        this.mDisplayListener = null;
        this.mDisplayManager = null;
        this.mContext = null;
    }

    public final void executeTouchAnalysis() {
        Companion companion = INSTANCE;
        companion.Native_updatePredictionType(0);
        companion.Native_executeTouchAnalysis();
    }

    public final int getSupportPrediction() {
        int iNative_getPredictionType = INSTANCE.Native_getPredictionType();
        return iNative_getPredictionType == 0 ? getSupportPredictionInModel() : iNative_getPredictionType;
    }

    @NotNull
    public final Pair<Rect, Rect> getVisibleRects(@Nullable View view, @Nullable SpenDisplay display) {
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup == null || view == null || display == null) {
            Log.e(TAG, "SpenLatencyConfiguration:: Failed. Not attached to layout!");
            return new Pair<>(new Rect(), new Rect());
        }
        Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        Rect rect2 = new Rect(0, 0, view.getWidth(), view.getHeight());
        Point point = new Point(0, 0);
        viewGroup.getChildVisibleRect(view, rect, point);
        rect.offset(-point.x, -point.y);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect2.set(rect);
        rect2.offset(iArr[0], iArr[1]);
        rect2.intersect(0, 0, display.widthPixels, display.heightPixels);
        return new Pair<>(rect, rect2);
    }

    /* JADX INFO: renamed from: isChromeOS, reason: from getter */
    public final boolean getIsChromeOS() {
        return this.isChromeOS;
    }

    public final boolean isFrontBufferRenderingSupported() {
        return SpenFbrDrawPad.INSTANCE.isSupported() && isSupportFrontBufferRendering();
    }

    /* JADX INFO: renamed from: isVST, reason: from getter */
    public final boolean getIsVST() {
        return this.isVST;
    }

    public final void setChromeOS(boolean z) {
        this.isChromeOS = z;
    }

    public final void setForcedWithoutStylusSupport(boolean enable) {
        AbstractC6670b.m4759t("SpenLatencyConfiguration:: setForcedWithoutStylusSupport : ", TAG, enable);
        mIsForcedWithoutStylusSupport = enable;
    }

    public final void setUnbufferedDispatchEnabled(boolean enable) {
        this.mUnbufferedDispatchEnabled = enable;
        INSTANCE.Native_setUnbufferedDispatch(enable);
    }

    public final void setUniformLatencyEnabled(boolean flag) {
        INSTANCE.Native_setUniformLatency(flag);
    }

    public final void setVST(boolean z) {
        this.isVST = z;
    }

    public final void setVSTEnabled(boolean enabled) {
        this.isVST = enabled;
        Log.i(TAG, "SpenLatencyConfiguration:: setVSTEnabled ".concat(enabled ? "enabled" : "disabled"));
        INSTANCE.Native_setAppRuntimeVST(this.isVST);
    }

    public final void updateHWInfo(@Nullable SpenFbrDrawPad drawPad) {
        if (drawPad != null) {
            drawPad.setHWRotation(getHwRotation());
            drawPad.setHWRefreshRate(getHwRefreshRate());
        }
    }

    public final void updateHWInfo(@Nullable SpenFbrDrawPadProPainting drawPad) {
        if (drawPad != null) {
            drawPad.setHWRotation(getHwRotation());
            drawPad.setHWRefreshRate(getHwRefreshRate());
        }
    }
}
