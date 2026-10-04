package com.samsung.android.support.senl.p145cm.base.framework.sem.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.samsung.android.sdk.mobileservice.social.buddy.request.TargetAppListRequest;
import com.samsung.android.support.senl.p145cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/content/PackageManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "PackageManagerCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PackageManagerCompatImplFactory extends AbsPackageManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "PackageManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J!\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/content/PackageManagerCompatImplFactory$PackageManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;", "<init>", "()V", "getApplicationIconForIconTray", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", TargetAppListRequest.BundleKey.PACKAGE_NAME, "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "hasFeature", "", "featureType", "", "(Landroid/content/Context;I)Ljava/lang/Boolean;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nPackageManagerCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackageManagerCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/content/PackageManagerCompatImplFactory$PackageManagerCompatSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
    public static final class PackageManagerCompatSemImpl implements AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl
        @Nullable
        public Drawable getApplicationIconForIconTray(@NotNull Context context, @Nullable String package_name, @NotNull ResolveInfo resolveInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
            if (package_name != null) {
                try {
                    return context.getPackageManager().semGetApplicationIconForIconTray(package_name, 1);
                } catch (PackageManager.NameNotFoundException e) {
                    AbstractC0000a.m23t("getApplicationIconForIconTray: NameNotFoundException] ", e.getMessage(), LoggerBase.INSTANCE, PackageManagerCompatImplFactory.TAG);
                } catch (NoSuchMethodError e2) {
                    AbstractC0000a.m23t("getApplicationIconForIconTray: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, PackageManagerCompatImplFactory.TAG);
                } catch (OutOfMemoryError e3) {
                    AbstractC0000a.m23t("getApplicationIconForIconTray: OutOfMemoryError] ", e3.getMessage(), LoggerBase.INSTANCE, PackageManagerCompatImplFactory.TAG);
                }
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl
        @Nullable
        public Boolean hasFeature(@Nullable Context context, int featureType) {
            PackageManager packageManager;
            PackageManager packageManager2;
            PackageManager packageManager3;
            PackageManager packageManager4;
            if (featureType == 0) {
                if (context == null || (packageManager = context.getPackageManager()) == null) {
                    return null;
                }
                return Boolean.valueOf(packageManager.hasSystemFeature("com.samsung.feature.samsung_experience_mobile"));
            }
            if (featureType == 1) {
                if (context == null || (packageManager2 = context.getPackageManager()) == null) {
                    return null;
                }
                return Boolean.valueOf(packageManager2.hasSystemFeature("com.samsung.feature.samsung_experience_mobile_lite"));
            }
            if (featureType == 2) {
                if (context == null || (packageManager3 = context.getPackageManager()) == null) {
                    return null;
                }
                return Boolean.valueOf(packageManager3.hasSystemFeature("com.sec.feature.folder_type"));
            }
            if (featureType != 3) {
                return Boolean.FALSE;
            }
            if (context == null || (packageManager4 = context.getPackageManager()) == null) {
                return null;
            }
            return Boolean.valueOf(packageManager4.hasSystemFeature("com.sec.feature.dual_lcd"));
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory
    @Nullable
    public AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl create(int deviceType) {
        return (deviceType != 2 || Build.VERSION.SDK_INT >= 33) ? super.create(deviceType) : new PackageManagerCompatSemImpl();
    }
}
