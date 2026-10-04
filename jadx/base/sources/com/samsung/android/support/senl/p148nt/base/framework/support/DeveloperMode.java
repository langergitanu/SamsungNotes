package com.samsung.android.support.senl.p148nt.base.framework.support;

import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\u001b\u001a\u00020\u0014H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00058F@BX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/support/DeveloperMode;", "", "<init>", "()V", "IS_ENG_BUILD", "", "getIS_ENG_BUILD", "()Z", SearchConstants.TargetContents.TAG, "", "DEBUG_FILE", "MIN_DEBUG_CLICKTIME", "", "MIN_DEBUG_CLICKCOUNT", "mFilesDir", "mPreviousTime", "mDebugClickCount", "", "mOnDeveloperMode", "initFilesDirForDeveloperMode", "", "filesDir", "isEnable", "isOnDeveloperMode", "isOnDeveloperMode$annotations", "setOnDeveloperMode", "(Z)V", "checkOnDeveloperMode", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeveloperMode {

    @NotNull
    private static final String DEBUG_FILE = "debug.dat";

    @NotNull
    public static final DeveloperMode INSTANCE = new DeveloperMode();
    private static final boolean IS_ENG_BUILD = Intrinsics.areEqual("eng", Build.TYPE);
    private static final long MIN_DEBUG_CLICKCOUNT = 5;
    private static final long MIN_DEBUG_CLICKTIME = 300;

    @NotNull
    private static final String TAG = "DeveloperMode";
    private static int mDebugClickCount;

    @Nullable
    private static String mFilesDir;
    private static boolean mOnDeveloperMode;
    private static long mPreviousTime;

    private DeveloperMode() {
    }

    @JvmStatic
    public static final void checkOnDeveloperMode() {
        if (!IS_ENG_BUILD || mFilesDir == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - mPreviousTime;
        mPreviousTime = jUptimeMillis;
        if (j >= 300) {
            mDebugClickCount = 0;
            return;
        }
        int i = mDebugClickCount + 1;
        mDebugClickCount = i;
        if (i >= 5) {
            setOnDeveloperMode(!mOnDeveloperMode);
            mDebugClickCount = 0;
        }
    }

    @JvmStatic
    public static final void initFilesDirForDeveloperMode(@Nullable String filesDir) {
        if (IS_ENG_BUILD) {
            mFilesDir = filesDir;
            if (new File(mFilesDir, DEBUG_FILE).exists()) {
                mOnDeveloperMode = true;
                Logger.m8697d(TAG, "setOnDeveloperMode On ");
            }
        }
    }

    public static final boolean isOnDeveloperMode() {
        return mOnDeveloperMode;
    }

    @JvmStatic
    public static /* synthetic */ void isOnDeveloperMode$annotations() {
    }

    private static final void setOnDeveloperMode(boolean z) {
        if (!IS_ENG_BUILD || mFilesDir == null) {
            return;
        }
        File file = new File(mFilesDir, DEBUG_FILE);
        if (mOnDeveloperMode) {
            mOnDeveloperMode = false;
            Logger.m8697d(TAG, "setOnDeveloperMode Off ");
            if (!file.exists() || file.delete()) {
                return;
            }
            Logger.m8702i(TAG, "setOnDeveloperMode file delete fail");
            return;
        }
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile()) {
                Logger.m8702i(TAG, "setOnDeveloperMode createNewFile fail");
            }
            mOnDeveloperMode = true;
            Logger.m8697d(TAG, "setOnDeveloperMode On ");
        } catch (IOException e) {
            AbstractC4539a.m3214x("setOnDeveloperMode, e : ", e.getMessage(), TAG);
        }
    }

    public final boolean getIS_ENG_BUILD() {
        return IS_ENG_BUILD;
    }
}
