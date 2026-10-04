package com.samsung.android.support.senl.p145cm.base.framework.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.content.PackageManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002BCB\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0018\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ&\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\rH\u0007J\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\"\u0010\u001f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020\rJ\u0018\u0010!\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010!\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J(\u0010!\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001aJ\"\u0010!\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\rH\u0002J\u001a\u0010(\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010*\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010,\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010-\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010.\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ&\u0010/\u001a\u0004\u0018\u0001002\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00101\u001a\u0004\u0018\u000102J1\u00103\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00105\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u00106J\"\u00107\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u00108\u001a\u00020\u001aJ\u001a\u00109\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010;J*\u0010<\u001a\u00020=2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rJ,\u0010?\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010@\u001a\u0004\u0018\u00010\u001a2\u0006\u0010A\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010)\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;)V", "mKMemoPackage", "", "Ljava/lang/Boolean;", "isKMemoPackage", "context", "Landroid/content/Context;", "mSepType", "", "Ljava/lang/Integer;", "isSepModel", "isOldSepLiteModel", "()Z", "isSepLiteModel", "isNewSepLiteModel", "mFolderType", "isFolderType", "mDualScreen", "isDualScreen", "getVersionCode", "packageName", "", "compareVersionName", "target", "reference", "faultResult", "isPackageInstalled", "minVersionCode", "isPackageEnabled", "includeService", "minVersionName", "Landroid/content/pm/PackageInfo;", "pm", "Landroid/content/pm/PackageManager;", "flags", "checkPackageEnabledSetting", "mHandwritingVersion", "isSupportedActionLink", "mIsTelephonyModel", "isTelephonyModel", "isSemHoverDevice", "getVersionInfo", "getApplicationIconForIconTray", "Landroid/graphics/drawable/Drawable;", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "getStringArrayFromPackage", "", "identifierName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "checkPackcagePermission", "permission", "getComponentEnabledSetting", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "setComponentEnabledSetting", "", "newState", "getMetaData", "key", "defaultValue", "Version", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPackageManagerCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackageManagerCompat.kt\ncom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,494:1\n1#2:495\n739#3,9:496\n739#3,9:509\n37#4:505\n36#4,3:506\n37#4:518\n36#4,3:519\n*S KotlinDebug\n*F\n+ 1 PackageManagerCompat.kt\ncom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat\n*L\n138#1:496,9\n140#1:509,9\n139#1:505\n139#1:506,3\n141#1:518\n141#1:519,3\n*E\n"})
public final class PackageManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = androidx.core.content.PackageManagerCompat.LOG_TAG;

    @Nullable
    private static PackageManagerCompat mInstance;

    @Nullable
    private Boolean mDualScreen;

    @Nullable
    private Boolean mFolderType;
    private int mHandwritingVersion;

    @Nullable
    private final AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl mImpl;
    private int mIsTelephonyModel;

    @Nullable
    private Boolean mKMemoPackage;

    @Nullable
    private Integer mSepType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat;", "getApkVersionName", "context", "Landroid/content/Context;", "packageName", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getApkVersionName(@Nullable Context context, @Nullable String packageName) {
            PackageManager packageManager;
            String str;
            if (context != null) {
                try {
                    packageManager = context.getPackageManager();
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7133e(PackageManagerCompat.TAG, "PackageManager.NameNotFoundException : " + e);
                    return "";
                }
            } else {
                packageManager = null;
            }
            if (packageManager == null || (str = packageManager.getPackageInfo(String.valueOf(packageName), 0).versionName) == null) {
                return "";
            }
            Intrinsics.checkNotNull(str);
            return str;
        }

        @NotNull
        public final synchronized PackageManagerCompat getInstance() {
            PackageManagerCompat packageManagerCompat;
            try {
                if (PackageManagerCompat.mInstance == null) {
                    PackageManagerCompat.mInstance = new PackageManagerCompat(new PackageManagerCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                packageManagerCompat = PackageManagerCompat.mInstance;
                Intrinsics.checkNotNull(packageManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.content.PackageManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return packageManagerCompat;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\n¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/PackageManagerCompat$Version;", "", "major", "", "minor", "patch", "revision", "<init>", "(IIII)V", "versionCode", "(I)V", "getMajor", "()I", "setMajor", "getMinor", "setMinor", "getPatch", "setPatch", "getRevision", "setRevision", "toString", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Version {
        private int major;
        private int minor;
        private int patch;
        private int revision;

        public Version(int i, int i2, int i4, int i5) {
            this.major = i;
            this.minor = i2;
            this.patch = i4;
            this.revision = i5;
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getPatch() {
            return this.patch;
        }

        public final int getRevision() {
            return this.revision;
        }

        public final void setMajor(int i) {
            this.major = i;
        }

        public final void setMinor(int i) {
            this.minor = i;
        }

        public final void setPatch(int i) {
            this.patch = i;
        }

        public final void setRevision(int i) {
            this.revision = i;
        }

        @NotNull
        public String toString() {
            return this.major + Extension.DOT + this.minor + Extension.DOT + this.patch + Extension.DOT + this.revision;
        }

        public Version(int i) {
            this(i / 100000000, (i / 10000000) % 10, (i / 100000) % 100, (i / 1000) % 100);
        }
    }

    public /* synthetic */ PackageManagerCompat(AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPackageManagerCompatImpl);
    }

    public static /* synthetic */ int compareVersionName$default(PackageManagerCompat packageManagerCompat, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        return packageManagerCompat.compareVersionName(str, str2, i);
    }

    public final boolean checkPackageEnabledSetting(@Nullable Context context, @Nullable String packageName) {
        if (context == null) {
            return false;
        }
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(String.valueOf(packageName));
            return applicationEnabledSetting == 0 || applicationEnabledSetting == 1;
        } catch (Exception e) {
            AbstractC0000a.m23t("checkPackageEnabledSetting: Exception] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    public final boolean checkPackcagePermission(@Nullable Context context, @Nullable String packageName, @NotNull String permission) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (context == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(String.valueOf(packageName), 4096);
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr != null) {
                Integer numValueOf = strArr != null ? Integer.valueOf(strArr.length) : null;
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    for (int i = 0; i < iIntValue; i++) {
                        String[] strArr2 = packageInfo.requestedPermissions;
                        if (Intrinsics.areEqual(strArr2 != null ? strArr2[i] : null, permission) && (iArr = packageInfo.requestedPermissionsFlags) != null && (iArr[i] & 2) == 2) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            LoggerBase.INSTANCE.m7133e(TAG, "checkPackcagePermission: NameNotFoundException]" + e);
        }
        return false;
    }

    @JvmOverloads
    public final int compareVersionName(@Nullable String str, @Nullable String str2) {
        return compareVersionName$default(this, str, str2, 0, 4, null);
    }

    @Nullable
    public final Drawable getApplicationIconForIconTray(@Nullable Context context, @Nullable String packageName, @Nullable ResolveInfo resolveInfo) {
        AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl;
        if (context == null || resolveInfo == null || (iPackageManagerCompatImpl = this.mImpl) == null) {
            return null;
        }
        return iPackageManagerCompatImpl.getApplicationIconForIconTray(context, packageName, resolveInfo);
    }

    public final int getComponentEnabledSetting(@Nullable Context context, @Nullable ComponentName componentName) {
        if (context == null || componentName == null) {
            return 0;
        }
        return context.getPackageManager().getComponentEnabledSetting(componentName);
    }

    public final boolean getMetaData(@Nullable Context context, @Nullable String packageName, @Nullable String key, boolean defaultValue) {
        if (context != null && !TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(key)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(String.valueOf(packageName), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                return applicationInfo.metaData.getBoolean(key, defaultValue);
            } catch (Exception e) {
                AbstractC0000a.m23t("getMetaData# ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            }
        }
        return false;
    }

    @Nullable
    public final String[] getStringArrayFromPackage(@Nullable Context context, @Nullable String packageName, @Nullable String identifierName) {
        Resources resourcesForApplication;
        int identifier;
        if (context != null && !TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(identifierName)) {
            if (packageName != null) {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e) {
                    AbstractC0000a.m23t("getStringArrayFromPackage : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            } else {
                resourcesForApplication = null;
            }
            if (resourcesForApplication != null && (identifier = resourcesForApplication.getIdentifier(identifierName, "array", packageName)) > 0) {
                return resourcesForApplication.getStringArray(identifier);
            }
        }
        return null;
    }

    public final int getVersionCode(@Nullable Context context, @Nullable String packageName) {
        PackageInfo packageInfo;
        if (context == null) {
            return -1;
        }
        if (packageName != null) {
            try {
                packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } else {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    @NotNull
    public final String getVersionInfo(@Nullable Context context) {
        if (context == null) {
            return "Unknown";
        }
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
            return !TextUtils.isEmpty(packageInfo.versionName) ? String.valueOf(packageInfo.versionName) : "Unknown";
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC0000a.m23t("getVersionInfo :", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return "Unknown";
        }
    }

    public final boolean isDualScreen(@Nullable Context context) {
        Boolean bool = this.mDualScreen;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl = this.mImpl;
        Boolean boolHasFeature = iPackageManagerCompatImpl != null ? iPackageManagerCompatImpl.hasFeature(context, 3) : null;
        this.mDualScreen = boolHasFeature;
        if (boolHasFeature != null) {
            return boolHasFeature.booleanValue();
        }
        return false;
    }

    public final boolean isFolderType(@Nullable Context context) {
        Boolean bool = this.mFolderType;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl = this.mImpl;
        Boolean boolHasFeature = iPackageManagerCompatImpl != null ? iPackageManagerCompatImpl.hasFeature(context, 2) : null;
        this.mFolderType = boolHasFeature;
        if (boolHasFeature != null) {
            return boolHasFeature.booleanValue();
        }
        return false;
    }

    public final boolean isKMemoPackage(@Nullable Context context) {
        Boolean bool = this.mKMemoPackage;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        Boolean boolValueOf = Boolean.valueOf(Intrinsics.areEqual("com.samsung.android.kmemo", context.getApplicationContext().getPackageName()));
        this.mKMemoPackage = boolValueOf;
        LoggerBase.INSTANCE.m7132d(TAG, "is Memo package? " + boolValueOf);
        Boolean bool2 = this.mKMemoPackage;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    public final boolean isNewSepLiteModel() {
        return Intrinsics.areEqual("sep_lite_new", FloatingFeature.INSTANCE.getInstance().getString("SEC_FLOATING_FEATURE_COMMON_CONFIG_SEP_CATEGORY"));
    }

    public final boolean isOldSepLiteModel() {
        return Intrinsics.areEqual("sep_lite", FloatingFeature.INSTANCE.getInstance().getString("SEC_FLOATING_FEATURE_COMMON_CONFIG_SEP_CATEGORY"));
    }

    public final boolean isPackageEnabled(@Nullable Context context, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        return isPackageEnabled(packageManager, packageName, 512) != null;
    }

    public final boolean isPackageInstalled(@Nullable Context context, @Nullable String packageName) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(String.valueOf(packageName), 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean isSemHoverDevice(@Nullable Context context) {
        PackageManager packageManager;
        return (context == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("com.sec.feature.hovering_ui")) ? false : true;
    }

    public final boolean isSepLiteModel(@Nullable Context context) {
        String string;
        Integer num = this.mSepType;
        if (num != null) {
            return num != null && num.intValue() == 2;
        }
        if (context == null) {
            return false;
        }
        try {
            string = FloatingFeature.INSTANCE.getInstance().getString("SEC_FLOATING_FEATURE_COMMON_CONFIG_SEP_CATEGORY");
        } catch (Exception e) {
            AbstractC0000a.m23t("Exception isSepLightModel: ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        if (!Intrinsics.areEqual("sep_lite", string) && !Intrinsics.areEqual("sep_lite_new", string)) {
            if (string.length() == 0) {
                AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl = this.mImpl;
                if (iPackageManagerCompatImpl != null ? Intrinsics.areEqual(iPackageManagerCompatImpl.hasFeature(context, 1), Boolean.TRUE) : false) {
                    this.mSepType = 2;
                    return true;
                }
                AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl2 = this.mImpl;
                if (iPackageManagerCompatImpl2 != null ? Intrinsics.areEqual(iPackageManagerCompatImpl2.hasFeature(context, 0), Boolean.TRUE) : false) {
                    this.mSepType = 1;
                }
            }
            return false;
        }
        this.mSepType = 2;
        return true;
    }

    public final boolean isSepModel(@Nullable Context context) {
        Integer num = this.mSepType;
        if (num != null) {
            return num != null && num.intValue() == 1;
        }
        AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl = this.mImpl;
        if (iPackageManagerCompatImpl != null ? Intrinsics.areEqual(iPackageManagerCompatImpl.hasFeature(context, 0), Boolean.TRUE) : false) {
            this.mSepType = 1;
            return true;
        }
        AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl2 = this.mImpl;
        if (iPackageManagerCompatImpl2 != null ? Intrinsics.areEqual(iPackageManagerCompatImpl2.hasFeature(context, 1), Boolean.TRUE) : false) {
            this.mSepType = 2;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isSupportedActionLink(@Nullable Context context) {
        if (this.mHandwritingVersion == 0) {
            if (context != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo("com.samsung.android.sdk.handwriting", 0) : null;
                    if (packageInfo != null) {
                        this.mHandwritingVersion = packageInfo.versionCode;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, e.getMessage(), e);
                    this.mHandwritingVersion = -1;
                }
            }
        }
        return this.mHandwritingVersion >= 200000000;
    }

    public final boolean isTelephonyModel(@Nullable Context context) {
        if (this.mIsTelephonyModel == -1) {
            if (context == null) {
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                this.mIsTelephonyModel = packageManager.hasSystemFeature("android.hardware.telephony") ? 1 : 0;
            }
        }
        return this.mIsTelephonyModel == 1;
    }

    public final void setComponentEnabledSetting(@Nullable Context context, @Nullable ComponentName componentName, int newState, int flags) {
        if (context == null || componentName == null) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        String str = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("setComponentEnabledSetting, componentName: ", componentEnabledSetting, componentName.getClassName(), ", currentState: ", ", newState: ");
        sbM780v.append(newState);
        sbM780v.append(", flags: ");
        sbM780v.append(flags);
        companion.m7135f(str, sbM780v.toString());
        packageManager.setComponentEnabledSetting(componentName, newState, flags);
    }

    private PackageManagerCompat(AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl iPackageManagerCompatImpl) {
        this.mImpl = iPackageManagerCompatImpl;
        this.mIsTelephonyModel = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compareVersionName(@Nullable String target, @Nullable String reference, int faultResult) {
        List listEmptyList;
        List listM13999t;
        List listEmptyList2;
        int i;
        if (target != null && reference != null) {
            List listM13999t2 = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, target);
            if (listM13999t2.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
                String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                listM13999t = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, reference);
                if (listM13999t.isEmpty()) {
                }
            } else {
                ListIterator listIterator = listM13999t2.listIterator(listM13999t2.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t2);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                listM13999t = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, reference);
                if (listM13999t.isEmpty()) {
                    ListIterator listIterator2 = listM13999t.listIterator(listM13999t.size());
                    while (listIterator2.hasPrevious()) {
                        if (((String) listIterator2.previous()).length() != 0) {
                            listEmptyList2 = AbstractC12991c.m14000u(listIterator2, 1, listM13999t);
                            break;
                        }
                    }
                    listEmptyList2 = CollectionsKt.emptyList();
                    String[] strArr3 = (String[]) listEmptyList2.toArray(new String[0]);
                    if (strArr2.length == 4 && strArr3.length == 4) {
                        for (i = 0; i < 4; i++) {
                            try {
                                int iCompare = Intrinsics.compare(Integer.parseInt(strArr2[i]), Integer.parseInt(strArr3[i]));
                                if (iCompare != 0) {
                                    return iCompare;
                                }
                            } catch (NumberFormatException e) {
                                LoggerBase.INSTANCE.m7138w(TAG, "Wrong format of version : " + e.getMessage());
                                return faultResult;
                            }
                        }
                        return 0;
                    }
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                    String[] strArr32 = (String[]) listEmptyList2.toArray(new String[0]);
                    if (strArr2.length == 4) {
                        while (i < 4) {
                        }
                        return 0;
                    }
                }
            }
        }
        return faultResult;
    }

    public final boolean isPackageEnabled(@Nullable Context context, @NotNull String packageName, boolean includeService) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        return isPackageEnabled(packageManager, packageName, includeService ? 5 : 1) != null;
    }

    public final boolean isPackageEnabled(@Nullable Context context, @NotNull String packageName, boolean includeService, @NotNull String minVersionName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(minVersionName, "minVersionName");
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        PackageInfo packageInfoIsPackageEnabled = isPackageEnabled(packageManager, packageName, includeService ? 5 : 1);
        if (packageInfoIsPackageEnabled == null) {
            return false;
        }
        String str = packageInfoIsPackageEnabled.versionName;
        Integer numValueOf = str != null ? Integer.valueOf(str.compareTo(minVersionName)) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() >= 0) {
            return true;
        }
        LoggerBase.INSTANCE.m7132d(TAG, AbstractC0541b.m774p("isPackageEnabled: ", packageName, " version is less than ", minVersionName));
        return false;
    }

    public final boolean isPackageInstalled(@Nullable Context context, @Nullable String packageName, int minVersionCode) {
        if (context == null) {
            return false;
        }
        try {
            int i = context.getPackageManager().getPackageInfo(String.valueOf(packageName), 1).versionCode;
            if (minVersionCode <= i) {
                return true;
            }
            LoggerBase.INSTANCE.m7133e(TAG, "isPackageInstalled, versionCode: " + i + ", minVersionCode: " + minVersionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private final PackageInfo isPackageEnabled(PackageManager pm, String packageName, int flags) {
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, flags);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null && applicationInfo.enabled) {
                return packageInfo;
            }
            LoggerBase.INSTANCE.m7132d(TAG, "isPackageEnabled: " + packageName + "is not enabled.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC0000a.m23t("isPackageEnabled: NameNotFoundException] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        }
    }
}
