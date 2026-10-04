package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 02\u00020\u0001:\u0002/0B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0016J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0011\u0010\"\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b#\u0010\u0018¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenViewCore;", "", "mContext", "Landroid/content/Context;", "nativeViewCore", "", "<init>", "(Landroid/content/Context;J)V", "getNativeViewCore", "()J", "setNativeViewCore", "(J)V", "value", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom;", "deltaZoom", "getDeltaZoom", "()Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenDeltaZoom;", "penStyle", "", "getPenStyle", "()Ljava/lang/String;", "penColor", "", "getPenColor", "()I", "penSize", "", "getPenSize", "()F", "isPenCurveEnabled", "", "()Z", "advancedPenSetting", "getAdvancedPenSetting", "penParticleDensity", "getPenParticleDensity", "close", "", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setPenSettingInfo", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "ScrollAlignmentMode", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenViewCore {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenViewCore";

    @Nullable
    private SpenDeltaZoom deltaZoom;

    @Nullable
    private Context mContext;
    private long nativeViewCore;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0083 J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0083 J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 J!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0083 J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u0018\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001d\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenViewCore$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_construct", "", "nativeViewCore", "", "viewCore", "Lcom/samsung/android/sdk/pen/engine/SpenViewCore;", "Native_getDeltaZoom", "Native_setToolTypeAction", "", "toolType", "", "action", "Native_getToolTypeAction", "Native_setPenSettingInfo", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "displayHandle", "Native_getPenStyle", "Native_getPenColor", "Native_getPenSize", "", "Native_isPenCurveEnabled", "Native_getAdvancedPenSetting", "Native_getPenParticleDensity", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeViewCore, SpenViewCore viewCore) {
            return SpenViewCore.Native_construct(nativeViewCore, viewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getAdvancedPenSetting(long nativeViewCore) {
            return SpenViewCore.Native_getAdvancedPenSetting(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getDeltaZoom(long nativeViewCore) {
            return SpenViewCore.Native_getDeltaZoom(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPenColor(long nativeViewCore) {
            return SpenViewCore.Native_getPenColor(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPenParticleDensity(long nativeViewCore) {
            return SpenViewCore.Native_getPenParticleDensity(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getPenSize(long nativeViewCore) {
            return SpenViewCore.Native_getPenSize(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getPenStyle(long nativeViewCore) {
            return SpenViewCore.Native_getPenStyle(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getToolTypeAction(long nativeViewCore, int toolType) {
            return SpenViewCore.Native_getToolTypeAction(nativeViewCore, toolType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isPenCurveEnabled(long nativeViewCore) {
            return SpenViewCore.Native_isPenCurveEnabled(nativeViewCore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setPenSettingInfo(long nativeViewCore, SpenSettingPenInfo penInfo, long displayHandle) {
            return SpenViewCore.Native_setPenSettingInfo(nativeViewCore, penInfo, displayHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setToolTypeAction(long nativeViewCore, int toolType, int action) {
            SpenViewCore.Native_setToolTypeAction(nativeViewCore, toolType, action);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenViewCore$ScrollAlignmentMode;", "", "toInt", "", "<init>", "(Ljava/lang/String;II)V", "ALIGNMENT_MODE_OPTIMAL", "ALIGNMENT_MODE_LEFT_TOP", "ALIGNMENT_MODE_LEFT_MID", "ALIGNMENT_MODE_LEFT_BOTTOM", "ALIGNMENT_MODE_MID_TOP", "ALIGNMENT_MODE_MID", "ALIGNMENT_MODE_MID_BOTTOM", "ALIGNMENT_MODE_RIGHT_TOP", "ALIGNMENT_MODE_RIGHT_MID", "ALIGNMENT_MODE_RIGHT_BOTTOM", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ScrollAlignmentMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScrollAlignmentMode[] $VALUES;
        private final int toInt;
        public static final ScrollAlignmentMode ALIGNMENT_MODE_OPTIMAL = new ScrollAlignmentMode("ALIGNMENT_MODE_OPTIMAL", 0, 0);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_LEFT_TOP = new ScrollAlignmentMode("ALIGNMENT_MODE_LEFT_TOP", 1, 1);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_LEFT_MID = new ScrollAlignmentMode("ALIGNMENT_MODE_LEFT_MID", 2, 2);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_LEFT_BOTTOM = new ScrollAlignmentMode("ALIGNMENT_MODE_LEFT_BOTTOM", 3, 3);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_MID_TOP = new ScrollAlignmentMode("ALIGNMENT_MODE_MID_TOP", 4, 4);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_MID = new ScrollAlignmentMode("ALIGNMENT_MODE_MID", 5, 5);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_MID_BOTTOM = new ScrollAlignmentMode("ALIGNMENT_MODE_MID_BOTTOM", 6, 6);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_RIGHT_TOP = new ScrollAlignmentMode("ALIGNMENT_MODE_RIGHT_TOP", 7, 7);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_RIGHT_MID = new ScrollAlignmentMode("ALIGNMENT_MODE_RIGHT_MID", 8, 8);
        public static final ScrollAlignmentMode ALIGNMENT_MODE_RIGHT_BOTTOM = new ScrollAlignmentMode("ALIGNMENT_MODE_RIGHT_BOTTOM", 9, 9);

        private static final /* synthetic */ ScrollAlignmentMode[] $values() {
            return new ScrollAlignmentMode[]{ALIGNMENT_MODE_OPTIMAL, ALIGNMENT_MODE_LEFT_TOP, ALIGNMENT_MODE_LEFT_MID, ALIGNMENT_MODE_LEFT_BOTTOM, ALIGNMENT_MODE_MID_TOP, ALIGNMENT_MODE_MID, ALIGNMENT_MODE_MID_BOTTOM, ALIGNMENT_MODE_RIGHT_TOP, ALIGNMENT_MODE_RIGHT_MID, ALIGNMENT_MODE_RIGHT_BOTTOM};
        }

        static {
            ScrollAlignmentMode[] scrollAlignmentModeArr$values = $values();
            $VALUES = scrollAlignmentModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scrollAlignmentModeArr$values);
        }

        private ScrollAlignmentMode(String str, int i, int i2) {
            this.toInt = i2;
        }

        @NotNull
        public static EnumEntries<ScrollAlignmentMode> getEntries() {
            return $ENTRIES;
        }

        public static ScrollAlignmentMode valueOf(String str) {
            return (ScrollAlignmentMode) Enum.valueOf(ScrollAlignmentMode.class, str);
        }

        public static ScrollAlignmentMode[] values() {
            return (ScrollAlignmentMode[]) $VALUES.clone();
        }
    }

    public SpenViewCore(@Nullable Context context, long j) {
        this.mContext = context;
        this.nativeViewCore = j;
        if (j == 0) {
            throw new NullPointerException("nativeViewCore is null");
        }
        Companion companion = INSTANCE;
        companion.Native_construct(j, this);
        this.deltaZoom = new SpenDeltaZoom(companion.Native_getDeltaZoom(this.nativeViewCore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenViewCore spenViewCore);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getAdvancedPenSetting(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getDeltaZoom(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPenColor(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPenParticleDensity(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getPenSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getPenStyle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getToolTypeAction(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isPenCurveEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setPenSettingInfo(long j, SpenSettingPenInfo spenSettingPenInfo, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setToolTypeAction(long j, int i, int i2);

    public final void close() {
        this.mContext = null;
        SpenDeltaZoom spenDeltaZoom = this.deltaZoom;
        if (spenDeltaZoom != null) {
            spenDeltaZoom.close();
            this.deltaZoom = null;
        }
        this.nativeViewCore = 0L;
    }

    @Nullable
    public final String getAdvancedPenSetting() {
        long j = this.nativeViewCore;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getAdvancedPenSetting(j);
    }

    @Nullable
    public final SpenDeltaZoom getDeltaZoom() {
        return this.deltaZoom;
    }

    public final long getNativeViewCore() {
        return this.nativeViewCore;
    }

    public final int getPenColor() {
        long j = this.nativeViewCore;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPenColor(j);
    }

    public final int getPenParticleDensity() {
        long j = this.nativeViewCore;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPenParticleDensity(j);
    }

    public final float getPenSize() {
        long j = this.nativeViewCore;
        if (j == 0) {
            return 0.0f;
        }
        return INSTANCE.Native_getPenSize(j);
    }

    @Nullable
    public final String getPenStyle() {
        long j = this.nativeViewCore;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPenStyle(j);
    }

    public final int getToolTypeAction(int toolType) {
        long j = this.nativeViewCore;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getToolTypeAction(j, toolType);
    }

    public final boolean isPenCurveEnabled() {
        long j = this.nativeViewCore;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isPenCurveEnabled(j);
    }

    public final void setNativeViewCore(long j) {
        this.nativeViewCore = j;
    }

    public final boolean setPenSettingInfo(@NotNull SpenSettingPenInfo penInfo, @Nullable SpenDisplay display) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        if (this.nativeViewCore == 0 || display == null) {
            return false;
        }
        AbstractC2322a.m1609C("setPenSettingInfo style = ", penInfo.name, TAG);
        return INSTANCE.Native_setPenSettingInfo(this.nativeViewCore, penInfo, display.handle);
    }

    public final void setToolTypeAction(int toolType, int action) {
        long j = this.nativeViewCore;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setToolTypeAction(j, toolType, action);
    }
}
