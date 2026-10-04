package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/TimeManager;", "", "<init>", "()V", "updateSettings", "", "context", "Landroid/content/Context;", "timeDifference", "", "currentSystemTime", "currentElapsedTime", "updateSettingsUsingServer", "serverTimeStamp", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TimeManager {
    private static final int CONVERT_MUL = 1000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long INITIAL_TIME = 1464416139847L;

    @NotNull
    private static final String SYNC_PREFERENCE_TIME_MANAGER_DIFF_TIME_KEY = "diffTimeKey";

    @NotNull
    private static final String SYNC_PREFERENCE_TIME_MANAGER_LAST_CURRENT_TIME_KEY = "lastTimeKey";

    @NotNull
    private static final String SYNC_PREFERENCE_TIME_MANAGER_LAST_ELAPSE_TIME_KEY = "lastElapseTimeKey";

    @NotNull
    private static final String SYNC_PREFERENCE_TIME_MANAGER_NAME = "TimeManagerName";

    @NotNull
    private static final String TAG = "TimeManager";

    @Nullable
    private static Long sTimeDifference;

    @Nullable
    private static TimeManager sTimeManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0013\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/TimeManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sTimeDifference", "", "Ljava/lang/Long;", "sTimeManager", "Lcom/samsung/android/support/senl/nt/base/common/TimeManager;", "SYNC_PREFERENCE_TIME_MANAGER_NAME", "SYNC_PREFERENCE_TIME_MANAGER_DIFF_TIME_KEY", "SYNC_PREFERENCE_TIME_MANAGER_LAST_CURRENT_TIME_KEY", "SYNC_PREFERENCE_TIME_MANAGER_LAST_ELAPSE_TIME_KEY", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/TimeManager;", "getCurrentTime", "context", "Landroid/content/Context;", "currentTime", "getCurrentTime$annotations", "()J", "getTimeDifference", "updateTimeDifference", "", "INITIAL_TIME", "CONVERT_MUL", "", "convertSdkTimeToAppTime", "wdocTime", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTimeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeManager.kt\ncom/samsung/android/support/senl/nt/base/common/TimeManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getCurrentTime$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private final long getTimeDifference(Context context) {
            if (TimeManager.sTimeDifference == null) {
                updateTimeDifference(context);
            }
            Long l = TimeManager.sTimeDifference;
            Intrinsics.checkNotNull(l, "null cannot be cast to non-null type kotlin.Long");
            return l.longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void updateTimeDifference(Context context) {
            TimeManager.sTimeDifference = Long.valueOf(context.getSharedPreferences(TimeManager.SYNC_PREFERENCE_TIME_MANAGER_NAME, 0).getLong(TimeManager.SYNC_PREFERENCE_TIME_MANAGER_DIFF_TIME_KEY, 0L));
        }

        @JvmStatic
        public final long convertSdkTimeToAppTime(long wdocTime) {
            return wdocTime < 1464416139847000L ? wdocTime : wdocTime / ((long) 1000);
        }

        @JvmStatic
        public final long getCurrentTime(@Nullable Context context) {
            return System.currentTimeMillis() - (context != null ? TimeManager.INSTANCE.getTimeDifference(context) : 0L);
        }

        @NotNull
        public final synchronized TimeManager getInstance() {
            TimeManager timeManager;
            try {
                if (TimeManager.sTimeManager == null) {
                    TimeManager.sTimeManager = new TimeManager(null);
                }
                timeManager = TimeManager.sTimeManager;
                Intrinsics.checkNotNull(timeManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.TimeManager");
            } catch (Throwable th) {
                throw th;
            }
            return timeManager;
        }

        private Companion() {
        }

        public final long getCurrentTime() {
            return getCurrentTime(BaseUtils.getApplicationContext());
        }
    }

    public /* synthetic */ TimeManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final long convertSdkTimeToAppTime(long j) {
        return INSTANCE.convertSdkTimeToAppTime(j);
    }

    public static final long getCurrentTime() {
        return INSTANCE.getCurrentTime();
    }

    @NotNull
    public static final synchronized TimeManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final synchronized void updateSettings(Context context, long timeDifference, long currentSystemTime, long currentElapsedTime) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SYNC_PREFERENCE_TIME_MANAGER_NAME, 0);
        Debugger.INSTANCE.m8619d(TAG, "Time Difference stored. TIME_DIFFERENCE : " + timeDifference + ", currentDeviceTime : " + currentSystemTime + ", currentElapsedTime" + currentElapsedTime);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong(SYNC_PREFERENCE_TIME_MANAGER_DIFF_TIME_KEY, timeDifference);
        editorEdit.putLong(SYNC_PREFERENCE_TIME_MANAGER_LAST_CURRENT_TIME_KEY, currentSystemTime);
        editorEdit.putLong(SYNC_PREFERENCE_TIME_MANAGER_LAST_ELAPSE_TIME_KEY, currentElapsedTime);
        editorEdit.apply();
        INSTANCE.updateTimeDifference(context);
    }

    public final synchronized void updateSettingsUsingServer(long serverTimeStamp) throws Throwable {
        Throwable th;
        try {
            try {
                Debugger.Companion companion = Debugger.INSTANCE;
                companion.m8619d(TAG, "updateSettingsUsingServer() start");
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    long j = applicationContext.getSharedPreferences(SYNC_PREFERENCE_TIME_MANAGER_NAME, 0).getLong(SYNC_PREFERENCE_TIME_MANAGER_DIFF_TIME_KEY, 0L);
                    if (serverTimeStamp > 0) {
                        companion.m8619d(TAG, "[Time] The received server time is " + serverTimeStamp);
                        long j2 = jCurrentTimeMillis - serverTimeStamp;
                        if (j != j2) {
                            companion.m8619d(TAG, "[Time] The new TIME_DIFFERENCE is " + j2);
                            updateSettings(applicationContext, j2, jCurrentTimeMillis, jElapsedRealtime);
                        }
                    } else {
                        companion.m8621e(TAG, "[Time] The received server time is 0");
                    }
                    return;
                }
                try {
                    companion.m8619d(TAG, "updateSettingsUsingServer() fail# context null");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    private TimeManager() {
    }

    @JvmStatic
    public static final long getCurrentTime(@Nullable Context context) {
        return INSTANCE.getCurrentTime(context);
    }
}
