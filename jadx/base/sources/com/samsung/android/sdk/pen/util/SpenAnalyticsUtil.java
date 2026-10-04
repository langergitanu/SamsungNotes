package com.samsung.android.sdk.pen.util;

import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J(\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012J\"\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000eJ$\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J,\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenAnalyticsUtil;", "", "<init>", "()V", "mNativeInstance", "", "mListener", "Lcom/samsung/android/sdk/pen/util/SpenAnalyticsUtil$AnalyticsListener;", "init", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "insertLog", "screenID", "", "eventID", "value", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "", "insertStatusLog", "statusID", "AnalyticsListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenAnalyticsUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenAnalyticsUtil.kt\ncom/samsung/android/sdk/pen/util/SpenAnalyticsUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n1#2:141\n*E\n"})
public final class SpenAnalyticsUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int EVENT_CTT_RESULT_CONVERT = 4310;
    public static final int EVENT_CTT_RESULT_COPY = 4319;
    public static final int EVENT_WRITING_EXTRACT_TEXT_RESULT_CLOSE = 4506;
    public static final int EVENT_WRITING_EXTRACT_TEXT_RESULT_CONVERT = 4508;
    public static final int EVENT_WRITING_EXTRACT_TEXT_RESULT_COPY = 4507;
    public static final int EVENT_WRITING_EXTRACT_TEXT_RESULT_SETTINGS = 4505;
    public static final int SCREEN_CTT = 412;
    public static final int SCREEN_NONE = 0;
    public static final int SCREEN_WRITING = 411;

    @NotNull
    private static final String TAG = "SpenAnalyticsUtil";

    @Nullable
    private static volatile SpenAnalyticsUtil mInstance;

    @Nullable
    private AnalyticsListener mListener;
    private long mNativeInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenAnalyticsUtil$AnalyticsListener;", "", "onInsertLog", "", "screenID", "", "eventID", "value", "", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "onInsertStatusLog", "statusID", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface AnalyticsListener {
        void onInsertLog(@Nullable String screenID);

        void onInsertLog(@Nullable String screenID, @Nullable String eventID);

        void onInsertLog(@Nullable String screenID, @Nullable String eventID, int value);

        void onInsertLog(@Nullable String screenID, @Nullable String eventID, @Nullable String detail);

        void onInsertLog(@Nullable String screenID, @Nullable String eventID, @Nullable String detail, int value);

        void onInsertStatusLog(@Nullable String statusID, int value);

        void onInsertStatusLog(@Nullable String statusID, @Nullable String detail);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0011H\u0007J\t\u0010\u0013\u001a\u00020\u0014H\u0083 J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0083 J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0011H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenAnalyticsUtil$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SCREEN_NONE", "", "SCREEN_WRITING", "SCREEN_CTT", "EVENT_WRITING_EXTRACT_TEXT_RESULT_SETTINGS", "EVENT_WRITING_EXTRACT_TEXT_RESULT_CLOSE", "EVENT_WRITING_EXTRACT_TEXT_RESULT_COPY", "EVENT_WRITING_EXTRACT_TEXT_RESULT_CONVERT", "EVENT_CTT_RESULT_COPY", "EVENT_CTT_RESULT_CONVERT", "mInstance", "Lcom/samsung/android/sdk/pen/util/SpenAnalyticsUtil;", "getInstance", "Native_init", "", "Native_finalize", "", "nativeInstance", "Native_construct", "", "analyticsUtil", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenAnalyticsUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenAnalyticsUtil.kt\ncom/samsung/android/sdk/pen/util/SpenAnalyticsUtil$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n1#2:141\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeInstance, SpenAnalyticsUtil analyticsUtil) {
            return SpenAnalyticsUtil.Native_construct(nativeInstance, analyticsUtil);
        }

        @JvmStatic
        private final void Native_finalize(long nativeInstance) {
            SpenAnalyticsUtil.Native_finalize(nativeInstance);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenAnalyticsUtil.Native_init();
        }

        @JvmStatic
        @NotNull
        public final SpenAnalyticsUtil getInstance() {
            SpenAnalyticsUtil spenAnalyticsUtil;
            SpenAnalyticsUtil spenAnalyticsUtil2 = SpenAnalyticsUtil.mInstance;
            if (spenAnalyticsUtil2 != null) {
                return spenAnalyticsUtil2;
            }
            synchronized (this) {
                spenAnalyticsUtil = SpenAnalyticsUtil.mInstance;
                if (spenAnalyticsUtil == null) {
                    spenAnalyticsUtil = new SpenAnalyticsUtil(null);
                    SpenAnalyticsUtil.mInstance = spenAnalyticsUtil;
                }
            }
            return spenAnalyticsUtil;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SpenAnalyticsUtil(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenAnalyticsUtil spenAnalyticsUtil);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init();

    @JvmStatic
    @NotNull
    public static final SpenAnalyticsUtil getInstance() {
        return INSTANCE.getInstance();
    }

    public final void insertLog(int screenID) {
        Integer numValueOf = Integer.valueOf(screenID);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        insertLog(numValueOf != null ? numValueOf.toString() : null);
    }

    public final void insertStatusLog(int statusID, @Nullable String detail) {
        insertStatusLog(String.valueOf(statusID), detail);
    }

    public final void setListener(@Nullable AnalyticsListener listener) {
        this.mListener = listener;
    }

    private SpenAnalyticsUtil() {
        Companion companion = INSTANCE;
        long jNative_init = companion.Native_init();
        this.mNativeInstance = jNative_init;
        if (jNative_init != 0) {
            companion.Native_construct(jNative_init, this);
        }
    }

    public final void insertLog(int screenID, int eventID) {
        Integer numValueOf = Integer.valueOf(screenID);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        insertLog(numValueOf != null ? numValueOf.toString() : null, String.valueOf(eventID));
    }

    public final void insertStatusLog(int statusID, int value) {
        insertStatusLog(String.valueOf(statusID), value);
    }

    public final void insertLog(int screenID, int eventID, int value) {
        Integer numValueOf = Integer.valueOf(screenID);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        insertLog(numValueOf != null ? numValueOf.toString() : null, String.valueOf(eventID), value);
    }

    public final void insertStatusLog(@NotNull String statusID, @Nullable String detail) {
        Intrinsics.checkNotNullParameter(statusID, "statusID");
        Log.d(TAG, "insertStatusLog state:" + statusID + ", d:" + detail);
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertStatusLog(statusID, detail);
        }
    }

    public final void insertLog(int screenID, int eventID, @Nullable String detail) {
        Integer numValueOf = Integer.valueOf(screenID);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        insertLog(numValueOf != null ? numValueOf.toString() : null, String.valueOf(eventID), detail);
    }

    public final void insertLog(int screenID, int eventID, @Nullable String detail, int value) {
        Integer numValueOf = Integer.valueOf(screenID);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        insertLog(numValueOf != null ? numValueOf.toString() : null, String.valueOf(eventID), detail, value);
    }

    public final void insertStatusLog(@NotNull String statusID, int value) {
        Intrinsics.checkNotNullParameter(statusID, "statusID");
        Log.d(TAG, "insertStatusLog state:" + statusID + ", v:" + value);
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertStatusLog(statusID, value);
        }
    }

    public final void insertLog(@Nullable String screenID) {
        AbstractC2322a.m1609C("insertLog s:", screenID, TAG);
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertLog(screenID);
        }
    }

    public final void insertLog(@Nullable String screenID, @Nullable String eventID) {
        Log.d(TAG, "insertLog s:" + screenID + " e:" + eventID);
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertLog(screenID, eventID);
        }
    }

    public final void insertLog(@Nullable String screenID, @Nullable String eventID, int value) {
        StringBuilder sbM16m = AbstractC0000a.m16m("insertLog s:", screenID, ", e:", eventID, ", v : ");
        sbM16m.append(value);
        Log.d(TAG, sbM16m.toString());
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertLog(screenID, eventID, value);
        }
    }

    public final void init() {
    }

    public final void insertLog(@Nullable String screenID, @Nullable String eventID, @Nullable String detail) {
        StringBuilder sbM16m = AbstractC0000a.m16m("insertLog s:", screenID, ", e:", eventID, ", d:");
        sbM16m.append(detail);
        Log.d(TAG, sbM16m.toString());
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertLog(screenID, eventID, detail);
        }
    }

    public final void insertLog(@Nullable String screenID, @Nullable String eventID, @Nullable String detail, int value) {
        StringBuilder sbM16m = AbstractC0000a.m16m("insertLog s:", screenID, ", e:", eventID, ", d:");
        sbM16m.append(detail);
        sbM16m.append(", v : ");
        sbM16m.append(value);
        Log.d(TAG, sbM16m.toString());
        AnalyticsListener analyticsListener = this.mListener;
        if (analyticsListener != null) {
            analyticsListener.onInsertLog(screenID, eventID, detail, value);
        }
    }
}
