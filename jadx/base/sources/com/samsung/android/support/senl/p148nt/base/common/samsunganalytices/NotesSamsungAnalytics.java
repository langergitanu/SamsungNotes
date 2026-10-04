package com.samsung.android.support.senl.p148nt.base.common.samsunganalytices;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import com.samsung.context.sdk.samsunganalytics.SamsungAnalytics;
import com.sec.android.diagmonagent.log.provider.DiagMonConfig;
import com.sec.android.diagmonagent.log.provider.DiagMonSDK;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics;", "", "<init>", "()V", "LogParam", "StatusLogParam", "ILogParam", "LogParamScreenID", "LogParamEvent", "LogParamDetail", "LogParamValue", "LogParamDetailValue", "LogParamDimension", "StatusLogParamDetail", "StatusLogParamValue", "NotesSALogger", "ENGLogger", "USERLogger", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class NotesSamsungAnalytics {

    @NotNull
    private static final String SERVICE_ID = "sn0vpasr64";

    @NotNull
    private static final String TAG = "NotesSALog";

    @NotNull
    private static final String TRACKING_ID = "034-399-1015448";

    @NotNull
    private static final String VST_TRACKING_ID = "034-397-1005510";

    @Nullable
    private static BOOLEAN mEnabledSA;

    @Nullable
    private static NotesSALogger mLogger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ArrayList<LogParam> mCumulativeLogs = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0005H\u0007J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J*\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\"\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J$\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0007J.\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001bH\u0007J\u001a\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0007J\u001a\u0010!\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0007J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020&H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SERVICE_ID", "TRACKING_ID", "VST_TRACKING_ID", "mEnabledSA", "Lcom/samsung/android/support/senl/cm/base/framework/support/BOOLEAN;", "mCumulativeLogs", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParam;", "Lkotlin/collections/ArrayList;", "mLogger", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$NotesSALogger;", "init", "", "enable", "", "setup", "application", "Landroid/app/Application;", "insertLog", "screenID", "getCustomDimension", "", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "event", "value", "", "dimensions", "sentEventLog", "eventBuilder", "Lcom/samsung/context/sdk/samsunganalytics/LogBuilders$EventBuilder;", "insertStatusLog", "statusID", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final synchronized Map<String, String> getCustomDimension(String detail) {
            HashMap map;
            map = new HashMap();
            map.put(LogBuilders.CustomDimension.DETAIL, detail);
            return map;
        }

        private final void sentEventLog(String screenID, LogBuilders.EventBuilder eventBuilder) {
            if (!TextUtils.isEmpty(screenID)) {
                eventBuilder.setScreenView(screenID);
            }
            SamsungAnalytics.getInstance().sendLog(eventBuilder.build());
        }

        @JvmStatic
        public final synchronized void init(boolean enable) {
            try {
                NotesSamsungAnalytics.mCumulativeLogs.clear();
                if (enable) {
                    NotesSamsungAnalytics.mEnabledSA = null;
                } else {
                    NotesSamsungAnalytics.mEnabledSA = new BOOLEAN(false);
                }
                if (DeviceInfo.isEngMode()) {
                    NotesSamsungAnalytics.mLogger = new ENGLogger();
                } else {
                    NotesSamsungAnalytics.mLogger = new USERLogger();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @JvmStatic
        public final synchronized void insertLog(@NotNull String screenID) {
            Intrinsics.checkNotNullParameter(screenID, "screenID");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(screenID));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                SamsungAnalytics.getInstance().sendLog(new LogBuilders.ScreenViewBuilder().setScreenView(screenID).build());
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SALog Screen = " + screenID);
                }
            }
        }

        @JvmStatic
        public final synchronized void insertStatusLog(@NotNull String statusID, @NotNull String detail) {
            Intrinsics.checkNotNullParameter(statusID, "statusID");
            Intrinsics.checkNotNullParameter(detail, "detail");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(new StatusLogParam(statusID, detail)));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                StatusLogManager.insertStatusLog(statusID, detail);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SA Status Log statusID = " + statusID + " detail = " + detail);
                }
            }
        }

        @JvmStatic
        public final synchronized void setup(@NotNull Application application) {
            try {
                Intrinsics.checkNotNullParameter(application, "application");
                if (NotesSamsungAnalytics.mEnabledSA != null) {
                    BOOLEAN r5 = NotesSamsungAnalytics.mEnabledSA;
                    if (r5 == null || !r5.isFalse()) {
                        Logger.m8697d(NotesSamsungAnalytics.TAG, "setup, already finished");
                    } else {
                        Logger.m8697d(NotesSamsungAnalytics.TAG, "setup, disabled");
                    }
                    return;
                }
                Logger.m8697d(NotesSamsungAnalytics.TAG, "setup, enabled");
                NotesSamsungAnalytics.mEnabledSA = new BOOLEAN(true);
                String str = "1.0";
                try {
                    str = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    Logger.m8699e(NotesSamsungAnalytics.TAG, "setup", e);
                }
                SamsungAnalytics.setConfiguration(application, new Configuration().setTrackingId(DeviceInfo.isVSTModel() ? NotesSamsungAnalytics.VST_TRACKING_ID : NotesSamsungAnalytics.TRACKING_ID).setVersion(str).enableAutoDeviceId());
                DiagMonSDK.setConfiguration(new DiagMonConfig(application.getApplicationContext()).setAgree(DiagMonUtil.AGREE_TYPE_DIAGNOSTIC).setServiceId(NotesSamsungAnalytics.SERVICE_ID));
                DiagMonSDK.enableUncaughtExceptionLogging(application.getApplicationContext());
                if (!NotesSamsungAnalytics.mCumulativeLogs.isEmpty()) {
                    Iterator it = NotesSamsungAnalytics.mCumulativeLogs.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        ((LogParam) next).insertLog();
                    }
                    NotesSamsungAnalytics.mCumulativeLogs.clear();
                }
                Context applicationContext = application.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                Intrinsics.checkNotNull(str);
                StatusLogManager.setUpStatus(applicationContext, str);
            } catch (Throwable th) {
                throw th;
            }
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized void insertLog(@Nullable String screenID, @NotNull String event, @NotNull String detail, long value) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(detail, "detail");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(screenID, event, detail, value));
                return;
            }
            BOOLEAN r8 = NotesSamsungAnalytics.mEnabledSA;
            if (r8 == null || !r8.isFalse()) {
                LogBuilders.EventBuilder eventValue = new LogBuilders.EventBuilder().setEventName(event).setDimension(getCustomDimension(detail)).setEventValue(value);
                Intrinsics.checkNotNullExpressionValue(eventValue, "setEventValue(...)");
                sentEventLog(screenID, eventValue);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SALog ScreenID = " + screenID + "Event= " + event + ", Detail = " + detail + ", Value = " + value);
                }
            }
        }

        @JvmStatic
        public final synchronized void insertStatusLog(@NotNull String statusID, int value) {
            Intrinsics.checkNotNullParameter(statusID, "statusID");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(new StatusLogParam(statusID, value)));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                StatusLogManager.insertStatusLog(statusID, value);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SA Status Log statusID = " + statusID + " value = " + value);
                }
            }
        }

        @JvmStatic
        public final synchronized void insertLog(@Nullable String screenID, @NotNull String event, long value) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(screenID, event, value));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                LogBuilders.EventBuilder eventValue = new LogBuilders.EventBuilder().setEventName(event).setEventValue(value);
                Intrinsics.checkNotNullExpressionValue(eventValue, "setEventValue(...)");
                sentEventLog(screenID, eventValue);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SALog ScreenID = " + screenID + " Event  = " + event + ", Value = " + value);
                }
            }
        }

        @JvmStatic
        public final synchronized void insertLog(@Nullable String screenID, @NotNull String event, @Nullable String detail) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(screenID, event, String.valueOf(detail)));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                LogBuilders.EventBuilder dimension = new LogBuilders.EventBuilder().setEventName(event).setDimension(getCustomDimension(String.valueOf(detail)));
                Intrinsics.checkNotNullExpressionValue(dimension, "setDimension(...)");
                sentEventLog(screenID, dimension);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SALog ScreenID = " + screenID + " Event = " + event + ", Detail = " + detail);
                }
            }
        }

        @JvmStatic
        public final synchronized void insertLog(@Nullable String screenID, @NotNull String event, @NotNull Map<String, String> dimensions) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(dimensions, "dimensions");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(screenID, event, dimensions));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                LogBuilders.EventBuilder dimension = new LogBuilders.EventBuilder().setEventName(event).setDimension(dimensions);
                Intrinsics.checkNotNullExpressionValue(dimension, "setDimension(...)");
                sentEventLog(screenID, dimension);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SALog ScreenID = " + screenID + " Event = " + event + ", dimensions = " + dimensions);
                }
            }
        }

        @JvmStatic
        public final synchronized void insertLog(@Nullable String screenID, @NotNull String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (NotesSamsungAnalytics.mEnabledSA == null) {
                NotesSamsungAnalytics.mCumulativeLogs.add(new LogParam(screenID, event));
                return;
            }
            BOOLEAN r12 = NotesSamsungAnalytics.mEnabledSA;
            if (r12 == null || !r12.isFalse()) {
                LogBuilders.EventBuilder eventName = new LogBuilders.EventBuilder().setEventName(event);
                Intrinsics.checkNotNullExpressionValue(eventName, "setEventName(...)");
                sentEventLog(screenID, eventName);
                NotesSALogger notesSALogger = NotesSamsungAnalytics.mLogger;
                if (notesSALogger != null) {
                    notesSALogger.mo8641d(NotesSamsungAnalytics.TAG, "set SALog ScreenID = " + screenID + " Event = " + event);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ENGLogger;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$NotesSALogger;", "<init>", "()V", "d", "", "tag", "", "msg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ENGLogger implements NotesSALogger {
        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.NotesSALogger
        /* JADX INFO: renamed from: d */
        public void mo8641d(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8697d(tag, msg);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ILogParam {
        void insertLog();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParamDetail;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mScreenID", "", "mEvent", "mDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParamDetail implements ILogParam {

        @NotNull
        private final String mDetail;

        @NotNull
        private final String mEvent;

        @Nullable
        private final String mScreenID;

        public LogParamDetail(@Nullable String str, @NotNull String mEvent, @NotNull String mDetail) {
            Intrinsics.checkNotNullParameter(mEvent, "mEvent");
            Intrinsics.checkNotNullParameter(mDetail, "mDetail");
            this.mScreenID = str;
            this.mEvent = mEvent;
            this.mDetail = mDetail;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertLog(this.mScreenID, this.mEvent, this.mDetail);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParamDetailValue;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mScreenID", "", "mEvent", "mDetail", "mValue", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParamDetailValue implements ILogParam {

        @NotNull
        private final String mDetail;

        @NotNull
        private final String mEvent;

        @Nullable
        private final String mScreenID;
        private final long mValue;

        public LogParamDetailValue(@Nullable String str, @NotNull String mEvent, @NotNull String mDetail, long j) {
            Intrinsics.checkNotNullParameter(mEvent, "mEvent");
            Intrinsics.checkNotNullParameter(mDetail, "mDetail");
            this.mScreenID = str;
            this.mEvent = mEvent;
            this.mDetail = mDetail;
            this.mValue = j;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertLog(this.mScreenID, this.mEvent, this.mDetail, this.mValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParamDimension;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mScreenID", "", "mEvent", "mDimensions", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParamDimension implements ILogParam {

        @NotNull
        private final Map<String, String> mDimensions;

        @NotNull
        private final String mEvent;

        @Nullable
        private final String mScreenID;

        public LogParamDimension(@Nullable String str, @NotNull String mEvent, @NotNull Map<String, String> mDimensions) {
            Intrinsics.checkNotNullParameter(mEvent, "mEvent");
            Intrinsics.checkNotNullParameter(mDimensions, "mDimensions");
            this.mScreenID = str;
            this.mEvent = mEvent;
            this.mDimensions = mDimensions;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertLog(this.mScreenID, this.mEvent, this.mDimensions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParamEvent;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mScreenID", "", "mEvent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParamEvent implements ILogParam {

        @NotNull
        private final String mEvent;

        @Nullable
        private final String mScreenID;

        public LogParamEvent(@Nullable String str, @NotNull String mEvent) {
            Intrinsics.checkNotNullParameter(mEvent, "mEvent");
            this.mScreenID = str;
            this.mEvent = mEvent;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertLog(this.mScreenID, this.mEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParamScreenID;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mScreenID", "", "<init>", "(Ljava/lang/String;)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParamScreenID implements ILogParam {

        @NotNull
        private final String mScreenID;

        public LogParamScreenID(@NotNull String mScreenID) {
            Intrinsics.checkNotNullParameter(mScreenID, "mScreenID");
            this.mScreenID = mScreenID;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertLog(this.mScreenID);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParamValue;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mScreenID", "", "mEvent", "mValue", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParamValue implements ILogParam {

        @NotNull
        private final String mEvent;

        @Nullable
        private final String mScreenID;
        private final long mValue;

        public LogParamValue(@Nullable String str, @NotNull String mEvent, long j) {
            Intrinsics.checkNotNullParameter(mEvent, "mEvent");
            this.mScreenID = str;
            this.mEvent = mEvent;
            this.mValue = j;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertLog(this.mScreenID, this.mEvent, this.mValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$NotesSALogger;", "", "d", "", "tag", "", "msg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface NotesSALogger {
        /* JADX INFO: renamed from: d */
        void mo8641d(@NotNull String tag, @Nullable String msg);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$StatusLogParamDetail;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mStatusID", "", "mDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StatusLogParamDetail implements ILogParam {

        @NotNull
        private final String mDetail;

        @NotNull
        private final String mStatusID;

        public StatusLogParamDetail(@NotNull String mStatusID, @NotNull String mDetail) {
            Intrinsics.checkNotNullParameter(mStatusID, "mStatusID");
            Intrinsics.checkNotNullParameter(mDetail, "mDetail");
            this.mStatusID = mStatusID;
            this.mDetail = mDetail;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertStatusLog(this.mStatusID, this.mDetail);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$StatusLogParamValue;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "mStatusID", "", "mValue", "", "<init>", "(Ljava/lang/String;I)V", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StatusLogParamValue implements ILogParam {

        @NotNull
        private final String mStatusID;
        private final int mValue;

        public StatusLogParamValue(@NotNull String mStatusID, int i) {
            Intrinsics.checkNotNullParameter(mStatusID, "mStatusID");
            this.mStatusID = mStatusID;
            this.mValue = i;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.ILogParam
        public void insertLog() {
            NotesSamsungAnalytics.INSTANCE.insertStatusLog(this.mStatusID, this.mValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$USERLogger;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$NotesSALogger;", "<init>", "()V", "d", "", "tag", "", "msg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class USERLogger implements NotesSALogger {
        @Override // com.samsung.android.support.senl.nt.base.common.samsunganalytices.NotesSamsungAnalytics.NotesSALogger
        /* JADX INFO: renamed from: d */
        public void mo8641d(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
        }
    }

    @JvmStatic
    public static final synchronized void init(boolean z) {
        INSTANCE.init(z);
    }

    @JvmStatic
    public static final synchronized void insertLog(@NotNull String str) {
        INSTANCE.insertLog(str);
    }

    @JvmStatic
    public static final synchronized void insertStatusLog(@NotNull String str, @NotNull String str2) {
        INSTANCE.insertStatusLog(str, str2);
    }

    @JvmStatic
    public static final synchronized void setup(@NotNull Application application) {
        INSTANCE.setup(application);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0007B#\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\tB#\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fB+\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\rB/\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0004\u0010\u0010B\u0011\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0004\u0010\u0013J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParam;", "", "screenID", "", "<init>", "(Ljava/lang/String;)V", "event", "(Ljava/lang/String;Ljava/lang/String;)V", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "value", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "dimensions", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "statusLogParam", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$StatusLogParam;", "(Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$StatusLogParam;)V", "mParam", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "insertLog", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParam {

        @NotNull
        private ILogParam mParam;

        public LogParam(@NotNull String screenID) {
            Intrinsics.checkNotNullParameter(screenID, "screenID");
            this.mParam = new LogParamScreenID(screenID);
        }

        public final void insertLog() {
            this.mParam.insertLog();
        }

        public LogParam(@Nullable String str, @NotNull String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.mParam = new LogParamEvent(str, event);
        }

        public LogParam(@Nullable String str, @NotNull String event, @NotNull String detail) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.mParam = new LogParamDetail(str, event, detail);
        }

        public LogParam(@Nullable String str, @NotNull String event, long j) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.mParam = new LogParamValue(str, event, j);
        }

        public LogParam(@Nullable String str, @NotNull String event, @NotNull String detail, long j) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.mParam = new LogParamDetailValue(str, event, detail, j);
        }

        public LogParam(@Nullable String str, @NotNull String event, @NotNull Map<String, String> dimensions) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(dimensions, "dimensions");
            this.mParam = new LogParamDimension(str, event, dimensions);
        }

        public LogParam(@NotNull StatusLogParam statusLogParam) {
            Intrinsics.checkNotNullParameter(statusLogParam, "statusLogParam");
            this.mParam = statusLogParam.getMParam();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$StatusLogParam;", "", "screenID", "", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "value", "", "(Ljava/lang/String;I)V", "mParam", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "getMParam", "()Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;", "setMParam", "(Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$ILogParam;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StatusLogParam {

        @NotNull
        private ILogParam mParam;

        public StatusLogParam(@NotNull String screenID, @NotNull String detail) {
            Intrinsics.checkNotNullParameter(screenID, "screenID");
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.mParam = new StatusLogParamDetail(screenID, detail);
        }

        @NotNull
        public final ILogParam getMParam() {
            return this.mParam;
        }

        public final void setMParam(@NotNull ILogParam iLogParam) {
            Intrinsics.checkNotNullParameter(iLogParam, "<set-?>");
            this.mParam = iLogParam;
        }

        public StatusLogParam(@NotNull String screenID, int i) {
            Intrinsics.checkNotNullParameter(screenID, "screenID");
            this.mParam = new StatusLogParamValue(screenID, i);
        }
    }

    @JvmStatic
    public static final synchronized void insertLog(@Nullable String str, @NotNull String str2, @NotNull String str3, long j) {
        INSTANCE.insertLog(str, str2, str3, j);
    }

    @JvmStatic
    public static final synchronized void insertStatusLog(@NotNull String str, int i) {
        INSTANCE.insertStatusLog(str, i);
    }

    @JvmStatic
    public static final synchronized void insertLog(@Nullable String str, @NotNull String str2, long j) {
        INSTANCE.insertLog(str, str2, j);
    }

    @JvmStatic
    public static final synchronized void insertLog(@Nullable String str, @NotNull String str2, @Nullable String str3) {
        INSTANCE.insertLog(str, str2, str3);
    }

    @JvmStatic
    public static final synchronized void insertLog(@Nullable String str, @NotNull String str2, @NotNull Map<String, String> map) {
        INSTANCE.insertLog(str, str2, map);
    }

    @JvmStatic
    public static final synchronized void insertLog(@Nullable String str, @NotNull String str2) {
        INSTANCE.insertLog(str, str2);
    }
}
