package com.samsung.android.support.senl.p148nt.base.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001:\u00046789B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0007H\u0002J\u0016\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\u000e\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020'J\b\u0010)\u001a\u00020!H\u0002J\u0006\u0010%\u001a\u00020!J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020!H\u0002J\u0006\u0010-\u001a\u00020!J\b\u00102\u001a\u00020!H\u0007J\b\u00103\u001a\u00020!H\u0002J\u0012\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0003\u001a\u0004\b0\u00101¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MEM_MONITOR_ENABLED", "", "MONITORING_DURATION", "", "JAVA_HEAP", "NATIVE_HEAP", "CODE", "STACK", "GRAPHICS", "PRIVATE_OTHER", "SYSTEM", "TOTAL_PSS", "TOTAL_SWAP", "mHandler", "Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$BackgroundHandler;", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "mDumpRunnable", "Ljava/lang/Runnable;", "mDumpRunning", "mHasDumpPermission", "Ljava/lang/Boolean;", "sIsMonitoring", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sItems", "", "init", "", "context", "Landroid/content/Context;", "hasDumpPermission", "dump", "maxCalledCount", "", MicrosoftAuthorizationResponse.INTERVAL, "createHandler", "setDumpRunning", "dumpRunning", "executeDumpCmd", "stop", "totalPss", "getTotalPss$annotations", "getTotalPss", "()I", "monitor", "printMemoryStats", "getUsage", "value", "BackgroundHandler", "MemInfo", "DumpMemInfo", "DebugMemInfo", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMemoryLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryLogger.kt\ncom/samsung/android/support/senl/nt/base/common/MemoryLogger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
public final class MemoryLogger {
    private static final boolean MEM_MONITOR_ENABLED = false;
    private static final long MONITORING_DURATION = 10000;

    @NotNull
    private static final String TAG = "[Memory]";

    @Nullable
    private static Runnable mDumpRunnable;
    private static volatile boolean mDumpRunning;

    @Nullable
    private static ExecutorService mExecutorService;

    @Nullable
    private static BackgroundHandler mHandler;

    @Nullable
    private static Boolean mHasDumpPermission;

    @NotNull
    public static final MemoryLogger INSTANCE = new MemoryLogger();

    @NotNull
    private static final AtomicBoolean sIsMonitoring = new AtomicBoolean(false);

    @NotNull
    private static final String TOTAL_PSS = "summary.total-pss";

    @NotNull
    private static final String JAVA_HEAP = "summary.java-heap";

    @NotNull
    private static final String NATIVE_HEAP = "summary.native-heap";

    @NotNull
    private static final String GRAPHICS = "summary.graphics";

    @NotNull
    private static final String CODE = "summary.code";

    @NotNull
    private static final String STACK = "summary.stack";

    @NotNull
    private static final String SYSTEM = "summary.system";

    @NotNull
    private static final String PRIVATE_OTHER = "summary.private-other";

    @NotNull
    private static final String TOTAL_SWAP = "summary.total-swap";

    @NotNull
    private static final List<String> sItems = new ArrayList(CollectionsKt.listOf((Object[]) new String[]{TOTAL_PSS, JAVA_HEAP, NATIVE_HEAP, GRAPHICS, CODE, STACK, SYSTEM, PRIVATE_OTHER, TOTAL_SWAP}));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u001f\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u000eR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$BackgroundHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Landroid/os/Looper;)V", "mMaxCalledCount", "", "Ljava/lang/Integer;", "mCalledCount", "mInterval", "mStopFlag", "", "setCountState", "", "maxCalledCount", MicrosoftAuthorizationResponse.INTERVAL, "setRepeatState", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "(Ljava/lang/Integer;I)V", "handleMessage", "msg", "Landroid/os/Message;", "setStopFlag", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BackgroundHandler extends Handler {
        private int mCalledCount;
        private int mInterval;

        @Nullable
        private Integer mMaxCalledCount;
        private boolean mStopFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BackgroundHandler(@NotNull Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.mInterval = 5000;
        }

        private final void set(Integer maxCalledCount, int interval) {
            this.mMaxCalledCount = maxCalledCount;
            this.mCalledCount = 0;
            this.mInterval = interval;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            MemoryLogger.INSTANCE.dump();
            Integer num = this.mMaxCalledCount;
            if (num != null) {
                int iIntValue = num.intValue();
                int i = this.mCalledCount + 1;
                this.mCalledCount = i;
                if (iIntValue <= i) {
                    return;
                }
            }
            if (this.mStopFlag) {
                this.mStopFlag = false;
            } else {
                sendMessageDelayed(Message.obtain(), this.mInterval);
            }
        }

        public final void setCountState(int maxCalledCount, int interval) {
            set(Integer.valueOf(maxCalledCount), interval);
        }

        public final void setRepeatState(int interval) {
            set(null, interval);
        }

        public final void setStopFlag() {
            this.mStopFlag = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$DebugMemInfo;", "Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$MemInfo;", "<init>", "()V", "print", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DebugMemInfo extends MemInfo {

        @NotNull
        private static final String[] mMemStatsTargets = {MemoryLogger.JAVA_HEAP, MemoryLogger.NATIVE_HEAP, MemoryLogger.CODE, MemoryLogger.STACK, MemoryLogger.GRAPHICS, MemoryLogger.PRIVATE_OTHER, MemoryLogger.SYSTEM, "", MemoryLogger.TOTAL_PSS, ""};

        @Override // com.samsung.android.support.senl.nt.base.common.MemoryLogger.MemInfo
        @SuppressLint({"DefaultLocale"})
        public void print() {
            String str;
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Map<String, String> memoryStats = memoryInfo.getMemoryStats();
            if (memoryStats == null) {
                return;
            }
            StringBuilder sb = new StringBuilder("MemStats:   ");
            int length = MemInfo.INSTANCE.getMTargets().length;
            for (int i = 0; i < length; i++) {
                String[] strArr = mMemStatsTargets;
                if (strArr[i].length() != 0 && (str = memoryStats.get(strArr[i])) != null && str.length() != 0) {
                    sb.append(MemInfo.INSTANCE.getMTargets()[i]);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str2 = String.format("%8.2f  ", Arrays.copyOf(new Object[]{Float.valueOf(Integer.parseInt(str) / 1024.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                }
            }
            Logger.m8702i(MemoryLogger.TAG, sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\tH\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$DumpMemInfo;", "Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$MemInfo;", "<init>", "()V", "mInfoMap", "", "", "", "parseLine", "", "line", "print", "isCountType", "", "key", "suspectActivityLeak", "activityCountOnMemory", "getActivityCountOnMemory", "()I", "dumpHprof", "path", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nMemoryLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryLogger.kt\ncom/samsung/android/support/senl/nt/base/common/MemoryLogger$DumpMemInfo\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,394:1\n108#2:395\n80#2,22:396\n*S KotlinDebug\n*F\n+ 1 MemoryLogger.kt\ncom/samsung/android/support/senl/nt/base/common/MemoryLogger$DumpMemInfo\n*L\n289#1:395\n289#1:396,22\n*E\n"})
    public static final class DumpMemInfo extends MemInfo {
        private static final int NUMBER_COUNT = 9;
        private static boolean mIsDumpedHprof;

        @NotNull
        private final Map<String, Integer> mInfoMap = new HashMap(MemInfo.INSTANCE.getMTargets().length);

        private final void dumpHprof(String path) {
            try {
                Debug.dumpHprofData(AbstractC2821a.m2221l(path, "/activityLeak", new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()), ".hprof"));
            } catch (IOException e) {
                Logger.m8698e(MemoryLogger.TAG, "suspectActivityLeak# fail : " + e);
            }
        }

        private final int getActivityCountOnMemory() {
            Integer num = this.mInfoMap.get(MemInfo.ACTIVITIES);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        private final boolean isCountType(String key) {
            return Intrinsics.areEqual(key, MemInfo.ACTIVITIES);
        }

        public final void parseLine(@NotNull String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            for (String str : MemInfo.INSTANCE.getMTargets()) {
                int iM14129C = StringsKt.m14129C(str, 0, 6, line);
                if (iM14129C >= 0) {
                    int length = str.length() + iM14129C;
                    String strSubstring = line.substring(length, length + 9);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    int length2 = strSubstring.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length2) {
                        boolean z2 = Intrinsics.compare((int) strSubstring.charAt(!z ? i : length2), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    String string = strSubstring.subSequence(i, length2 + 1).toString();
                    if (string.length() > 0) {
                        this.mInfoMap.put(str, Integer.valueOf(Integer.parseInt(string)));
                        return;
                    }
                    return;
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.MemoryLogger.MemInfo
        @SuppressLint({"DefaultLocale"})
        public void print() {
            StringBuilder sb = new StringBuilder("unit: MB    ");
            for (String str : MemInfo.INSTANCE.getMTargets()) {
                Integer num = this.mInfoMap.get(str);
                if (num != null) {
                    int iIntValue = num.intValue();
                    sb.append(str);
                    if (isCountType(str)) {
                        sb.append(iIntValue);
                        sb.append(' ');
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str2 = String.format("%8.2f  ", Arrays.copyOf(new Object[]{Float.valueOf(iIntValue / 1024.0f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        sb.append(str2);
                    }
                }
            }
            Logger.m8702i(MemoryLogger.TAG, sb.toString());
        }

        public final void suspectActivityLeak() {
            int activityCount = ApplicationManager.INSTANCE.getInstance().getActivityTracker().getActivityCount();
            if (getActivityCountOnMemory() <= activityCount + 2) {
                return;
            }
            Logger.m8698e(MemoryLogger.TAG, "suspectActivityLeak# " + getActivityCountOnMemory() + " / " + activityCount);
            if (mIsDumpedHprof) {
                return;
            }
            mIsDumpedHprof = true;
            String strM12320e = AbstractC11014a.m12320e(Environment.getExternalStorageDirectory(), "/SamsungNotes");
            if (FileUtils.makeDirectory(strM12320e)) {
                dumpHprof(strM12320e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\"\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$MemInfo;", "", "<init>", "()V", "print", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class MemInfo {
        public static final float MB_UNIT = 1024.0f;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final String PSS = "TOTAL PSS:";

        @NotNull
        public static final String ACTIVITIES = "Activities:";

        @NotNull
        private static final String[] mTargets = {"Java Heap:", "Native Heap:", "Code:", "Stack:", "Graphics:", "Private Other:", "System:", "Unknown:", PSS, ACTIVITIES};

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryLogger$MemInfo$Companion;", "", "<init>", "()V", "MB_UNIT", "", "PSS", "", "ACTIVITIES", "mTargets", "", "getMTargets", "()[Ljava/lang/String;", "[Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final String[] getMTargets() {
                return MemInfo.mTargets;
            }

            private Companion() {
            }
        }

        public abstract void print();
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.common.MemoryLogger$monitor$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/common/MemoryLogger$monitor$1", "Ljava/util/TimerTask;", "run", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C88761 extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MemoryLogger.INSTANCE.printMemoryStats();
        }
    }

    private MemoryLogger() {
    }

    private final synchronized void createHandler() {
        if (mHandler == null) {
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper(...)");
            mHandler = new BackgroundHandler(mainLooper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dump$lambda$0() throws Throwable {
        MemoryLogger memoryLogger = INSTANCE;
        memoryLogger.setDumpRunning(true);
        memoryLogger.executeDumpCmd();
        memoryLogger.setDumpRunning(false);
    }

    private final void executeDumpCmd() throws Throwable {
        InputStream errorStream;
        InputStream inputStream;
        try {
            Process processExec = Runtime.getRuntime().exec("dumpsys meminfo " + Process.myPid());
            Intrinsics.checkNotNullExpressionValue(processExec, "exec(...)");
            errorStream = processExec.getErrorStream();
            try {
                inputStream = processExec.getInputStream();
                try {
                    processExec.waitFor();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(inputStream, th);
                                throw th2;
                            }
                        }
                    }
                    CloseableKt.closeFinally(inputStream, null);
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit2 = Unit.INSTANCE;
                        } finally {
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                    DumpMemInfo dumpMemInfo = new DumpMemInfo();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), StandardCharsets.UTF_8));
                        try {
                            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                dumpMemInfo.parseLine(line);
                            }
                            dumpMemInfo.print();
                            dumpMemInfo.suspectActivityLeak();
                            Unit unit3 = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedReader, null);
                        } finally {
                        }
                    } catch (IOException e) {
                        Logger.m8698e(TAG, e.toString());
                        BackgroundHandler backgroundHandler = mHandler;
                        if (backgroundHandler != null) {
                            backgroundHandler.setStopFlag();
                        }
                    }
                } catch (IOException unused) {
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit4 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit5 = Unit.INSTANCE;
                        } finally {
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                } catch (InterruptedException unused2) {
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit6 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit7 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                } catch (Throwable th3) {
                    th = th3;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit8 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                            Unit unit9 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(errorStream, null);
                    throw th;
                }
            } catch (IOException unused3) {
                inputStream = null;
            } catch (InterruptedException unused4) {
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (IOException unused5) {
            errorStream = null;
            inputStream = null;
        } catch (InterruptedException unused6) {
            errorStream = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            errorStream = null;
            inputStream = null;
        }
    }

    public static final int getTotalPss() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        StringBuilder sb = new StringBuilder("MemStats:   ");
        int i = 0;
        for (Map.Entry<String, String> entry : memoryInfo.getMemoryStats().entrySet()) {
            sb.append(" / ");
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue());
            if (Intrinsics.areEqual(TOTAL_PSS, entry.getKey())) {
                i = Integer.parseInt(entry.getValue()) / 1024;
            }
        }
        Logger.m8702i(TAG, sb.toString());
        return i;
    }

    @JvmStatic
    public static /* synthetic */ void getTotalPss$annotations() {
    }

    private final String getUsage(String value) {
        if (value == null) {
            return "0MB";
        }
        try {
            return (Long.parseLong(value) / 1024) + "MB";
        } catch (NumberFormatException e) {
            Debugger.INSTANCE.m8621e(TAG, "convertToMB, e: " + e.getMessage());
            return "0MB";
        }
    }

    private final boolean hasDumpPermission() {
        Boolean bool = mHasDumpPermission;
        if (bool == null) {
            return false;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    @JvmStatic
    public static final void monitor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printMemoryStats() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        Map<String, String> memoryStats = memoryInfo.getMemoryStats();
        StringBuilder sb = new StringBuilder("MemStats:   ");
        for (String str : sItems) {
            sb.append(StringsKt.m14139M(str, "summary.", ""));
            sb.append(" : ");
            sb.append(getUsage(memoryStats.get(str)));
            sb.append(" / ");
        }
        Logger.m8702i(TAG, sb.toString());
    }

    private final synchronized void setDumpRunning(boolean dumpRunning) {
        mDumpRunning = dumpRunning;
    }

    public final void dump(int maxCalledCount, int interval) {
        stop();
        createHandler();
        BackgroundHandler backgroundHandler = mHandler;
        if (backgroundHandler != null) {
            backgroundHandler.setCountState(maxCalledCount, interval);
        }
        BackgroundHandler backgroundHandler2 = mHandler;
        if (backgroundHandler2 != null) {
            backgroundHandler2.sendMessage(Message.obtain());
        }
    }

    public final synchronized void init(@NotNull Context context) {
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (mHasDumpPermission == null) {
                mHasDumpPermission = Boolean.valueOf(context.checkSelfPermission("android.permission.DUMP") == 0 && context.checkSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void stop() {
        BackgroundHandler backgroundHandler = mHandler;
        if (backgroundHandler == null || backgroundHandler == null) {
            return;
        }
        backgroundHandler.removeCallbacksAndMessages(null);
    }

    public final void dump(int interval) {
        stop();
        createHandler();
        BackgroundHandler backgroundHandler = mHandler;
        if (backgroundHandler != null) {
            backgroundHandler.setRepeatState(interval);
        }
        BackgroundHandler backgroundHandler2 = mHandler;
        if (backgroundHandler2 != null) {
            backgroundHandler2.sendMessage(Message.obtain());
        }
    }

    public final synchronized void dump() {
        ExecutorService executorService;
        if (!hasDumpPermission()) {
            new DebugMemInfo().print();
            return;
        }
        if (mExecutorService == null) {
            mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            mDumpRunnable = new RunnableC0284b(25);
        }
        if (!mDumpRunning && (executorService = mExecutorService) != null) {
            executorService.execute(mDumpRunnable);
        }
    }
}
