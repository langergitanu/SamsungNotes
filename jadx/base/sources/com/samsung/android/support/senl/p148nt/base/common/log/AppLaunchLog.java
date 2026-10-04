package com.samsung.android.support.senl.p148nt.base.common.log;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0007J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/log/AppLaunchLog;", "", "<init>", "()V", "mEnablePrint", "", "mPrefix", "", "APP_TAG", "startTime", "", "snapshotTime", "d", "", "tag", "msg", "snapshot", "param", "Lcom/samsung/android/support/senl/nt/base/common/log/AppLaunchLog$LogParam;", "printLog", "LogParam", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppLaunchLog {

    @NotNull
    private static final String APP_TAG = "SENL$NotesMain$";

    @NotNull
    public static final AppLaunchLog INSTANCE = new AppLaunchLog();
    private static final boolean mEnablePrint = true;

    @NotNull
    private static final String mPrefix = "[NotesLaunch]";
    private static long snapshotTime;
    private static long startTime;

    private AppLaunchLog() {
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8605d(@Nullable String tag, @Nullable String msg) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - startTime;
        INSTANCE.printLog(tag, msg + ", time : " + j);
        startTime = jCurrentTimeMillis;
    }

    private final void printLog(String tag, String msg) {
        AbstractC6670b.m4756q(mPrefix, msg, AbstractC0541b.m772n(APP_TAG, tag));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/log/AppLaunchLog$LogParam;", "", "tag", "", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "snapshot", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "mTag", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "mMsg", "getMMsg", "setMMsg", "mSnapshot", "getMSnapshot", "()Z", "setMSnapshot", "(Z)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParam {

        @Nullable
        private String mMsg;
        private boolean mSnapshot;

        @Nullable
        private String mTag;

        public LogParam(@Nullable String str, @Nullable String str2) {
            this.mTag = str;
            this.mMsg = str2;
        }

        @Nullable
        public final String getMMsg() {
            return this.mMsg;
        }

        public final boolean getMSnapshot() {
            return this.mSnapshot;
        }

        @Nullable
        public final String getMTag() {
            return this.mTag;
        }

        public final void setMMsg(@Nullable String str) {
            this.mMsg = str;
        }

        public final void setMSnapshot(boolean z) {
            this.mSnapshot = z;
        }

        public final void setMTag(@Nullable String str) {
            this.mTag = str;
        }

        public LogParam(@Nullable String str, @Nullable String str2, boolean z) {
            this.mTag = str;
            this.mMsg = str2;
            this.mSnapshot = z;
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8606d(@Nullable String tag, @Nullable String msg, boolean snapshot) {
        if (snapshot) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            INSTANCE.printLog(tag, msg + ", snapshot time : " + (jCurrentTimeMillis - startTime) + " / " + (jCurrentTimeMillis - snapshotTime));
            snapshotTime = jCurrentTimeMillis;
            startTime = jCurrentTimeMillis;
            return;
        }
        m8605d(tag, msg);
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8604d(@NotNull LogParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        m8606d(param.getMTag(), param.getMMsg(), param.getMSnapshot());
    }
}
