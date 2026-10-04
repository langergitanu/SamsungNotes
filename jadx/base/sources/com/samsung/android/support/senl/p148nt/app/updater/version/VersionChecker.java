package com.samsung.android.support.senl.p148nt.app.updater.version;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ(\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0006\u0010\u001a\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/updater/version/VersionChecker;", "", "<init>", "()V", "mLastVersionCode", "", "mCurrentVersionCode", "mLastCheckedMarketVersionCode", "checkVersionStart", "Lcom/samsung/android/support/senl/nt/app/updater/version/VersionChecker$StartType;", "isVersionUpdated", "", "resetVersionUpdated", "", "checkVersionCode", "lastOsVersion", "currentOsVersion", "lastVersionCode", "currentVersionCode", "value", "getLastVersionCode", "()I", "setLastVersionCode", "(I)V", "getCurrentVersionCode", "setCurrentVersionCode", "initLastCheckedMarketVersionCode", "lastCheckedMarketVersionCode", "getLastCheckedMarketVersionCode", "setLastCheckedMarketVersionCode", "StartType", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VersionChecker {

    @NotNull
    private static final String IS_VERSION_UPDATED = "is_version_updated";

    @NotNull
    private static final String LOG_TAG = "UpdateManager$VersionChecker";

    @NotNull
    private static final String OS_VERSION = "os_version";
    private int mLastCheckedMarketVersionCode;
    private int mLastVersionCode = -1;
    private int mCurrentVersionCode = -1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/updater/version/VersionChecker$StartType;", "", "<init>", "(Ljava/lang/String;I)V", "FirstTime", "FirstTimeAfterVersionUpdate", "FirstTimeAfterOSUpdate", "Normal", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StartType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StartType[] $VALUES;
        public static final StartType FirstTime = new StartType("FirstTime", 0);
        public static final StartType FirstTimeAfterVersionUpdate = new StartType("FirstTimeAfterVersionUpdate", 1);
        public static final StartType FirstTimeAfterOSUpdate = new StartType("FirstTimeAfterOSUpdate", 2);
        public static final StartType Normal = new StartType("Normal", 3);

        private static final /* synthetic */ StartType[] $values() {
            return new StartType[]{FirstTime, FirstTimeAfterVersionUpdate, FirstTimeAfterOSUpdate, Normal};
        }

        static {
            StartType[] startTypeArr$values = $values();
            $VALUES = startTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(startTypeArr$values);
        }

        private StartType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<StartType> getEntries() {
            return $ENTRIES;
        }

        public static StartType valueOf(String str) {
            return (StartType) Enum.valueOf(StartType.class, str);
        }

        public static StartType[] values() {
            return (StartType[]) $VALUES.clone();
        }
    }

    private final StartType checkVersionCode(int lastOsVersion, int currentOsVersion, int lastVersionCode, int currentVersionCode) {
        if (lastVersionCode == -1) {
            MainLogger.m7257f(LOG_TAG, "checkVersionCode# App is first launched with " + currentVersionCode);
            return StartType.FirstTime;
        }
        if (lastVersionCode < currentVersionCode) {
            MainLogger.m7257f(LOG_TAG, "checkVersionCode# App is updated - previous: " + lastVersionCode + ", current: " + currentVersionCode);
            SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(IS_VERSION_UPDATED, 1);
            return StartType.FirstTimeAfterVersionUpdate;
        }
        if (lastVersionCode > currentVersionCode) {
            MainLogger.m7258i(LOG_TAG, AbstractC0622a.m1164j(currentVersionCode, lastVersionCode, "checkVersionCode# Current version code (", ") is less then the one recognized on last startup (", "). Defenisvely assuming normal app start."));
            MainLogger.m7257f(LOG_TAG, "checkVersionCode# App is updated - previous: " + lastVersionCode + ", current: " + currentVersionCode);
            return StartType.Normal;
        }
        if (lastOsVersion >= currentOsVersion) {
            return StartType.Normal;
        }
        MainLogger.m7257f(LOG_TAG, "checkVersionCode# OS is updated - previous: " + lastOsVersion + ", current: " + currentOsVersion);
        return StartType.FirstTimeAfterOSUpdate;
    }

    @NotNull
    public final StartType checkVersionStart() {
        StartType startTypeCheckVersionCode = StartType.Normal;
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext);
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
            int i = companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(OS_VERSION, -1);
            int i2 = Build.VERSION.SDK_INT;
            setLastVersionCode(companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("app_version", -1));
            setCurrentVersionCode(packageInfo.versionCode);
            MainLogger.m7258i(LOG_TAG, "checkVersionStart, lastOsVersion: " + i + " -> currentOsVersion: " + i2 + ", lastVersionCode: " + getMLastVersionCode() + " -> currentVersionCode: " + getMCurrentVersionCode());
            startTypeCheckVersionCode = checkVersionCode(i, i2, getMLastVersionCode(), getMCurrentVersionCode());
            companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(OS_VERSION, i2);
            companion.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt("app_version", getMCurrentVersionCode());
            return startTypeCheckVersionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            MainLogger.m7258i(LOG_TAG, "checkVersionStart, Unable to determine current app version");
            return startTypeCheckVersionCode;
        }
    }

    /* JADX INFO: renamed from: getCurrentVersionCode, reason: from getter */
    public final int getMCurrentVersionCode() {
        return this.mCurrentVersionCode;
    }

    /* JADX INFO: renamed from: getLastCheckedMarketVersionCode, reason: from getter */
    public final int getMLastCheckedMarketVersionCode() {
        return this.mLastCheckedMarketVersionCode;
    }

    /* JADX INFO: renamed from: getLastVersionCode, reason: from getter */
    public final int getMLastVersionCode() {
        return this.mLastVersionCode;
    }

    public final void initLastCheckedMarketVersionCode() {
        setLastCheckedMarketVersionCode(0);
    }

    public final boolean isVersionUpdated() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(IS_VERSION_UPDATED, 0) == 1;
    }

    public final void resetVersionUpdated() {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(IS_VERSION_UPDATED, 0);
    }

    public final void setCurrentVersionCode(int i) {
        this.mCurrentVersionCode = i;
    }

    public final void setLastCheckedMarketVersionCode(int i) {
        this.mLastCheckedMarketVersionCode = i;
    }

    public final void setLastVersionCode(int i) {
        this.mLastVersionCode = i;
    }
}
