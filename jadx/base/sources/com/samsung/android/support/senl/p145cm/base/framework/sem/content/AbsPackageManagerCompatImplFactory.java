package com.samsung.android.support.senl.p145cm.base.framework.sem.content;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import com.samsung.android.sdk.mobileservice.social.buddy.request.TargetAppListRequest;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IPackageManagerCompatImpl", "PackageManagerCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPackageManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "PackageManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J!\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;", "", "getApplicationIconForIconTray", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", TargetAppListRequest.BundleKey.PACKAGE_NAME, "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "hasFeature", "", "featureType", "", "(Landroid/content/Context;I)Ljava/lang/Boolean;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPackageManagerCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FEATURE_TYPE_DUAL_SCREEN = 3;
        public static final int FEATURE_TYPE_FOLDER_TYPE = 2;
        public static final int FEATURE_TYPE_SAMSUNG_EXPERIENCE_MOBILE = 0;
        public static final int FEATURE_TYPE_SAMSUNG_EXPERIENCE_MOBILE_LITE = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl$Companion;", "", "<init>", "()V", "FEATURE_TYPE_SAMSUNG_EXPERIENCE_MOBILE", "", "FEATURE_TYPE_SAMSUNG_EXPERIENCE_MOBILE_LITE", "FEATURE_TYPE_FOLDER_TYPE", "FEATURE_TYPE_DUAL_SCREEN", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int FEATURE_TYPE_DUAL_SCREEN = 3;
            public static final int FEATURE_TYPE_FOLDER_TYPE = 2;
            public static final int FEATURE_TYPE_SAMSUNG_EXPERIENCE_MOBILE = 0;
            public static final int FEATURE_TYPE_SAMSUNG_EXPERIENCE_MOBILE_LITE = 1;

            private Companion() {
            }
        }

        @Nullable
        Drawable getApplicationIconForIconTray(@NotNull Context context, @Nullable String package_name, @NotNull ResolveInfo resolveInfo);

        @Nullable
        Boolean hasFeature(@Nullable Context context, int featureType);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001f\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$PackageManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/content/AbsPackageManagerCompatImplFactory$IPackageManagerCompatImpl;", "<init>", "()V", "getApplicationIconForIconTray", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", TargetAppListRequest.BundleKey.PACKAGE_NAME, "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "hasFeature", "", "featureType", "", "(Landroid/content/Context;I)Ljava/lang/Boolean;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PackageManagerCompatPureImpl implements IPackageManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl
        @Nullable
        public Drawable getApplicationIconForIconTray(@NotNull Context context, @Nullable String package_name, @NotNull ResolveInfo resolveInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
            try {
                return resolveInfo.loadIcon(context.getPackageManager());
            } catch (OutOfMemoryError e) {
                AbstractC0000a.m23t("getApplicationIconForIconTray: OutOfMemoryError] ", e.getMessage(), LoggerBase.INSTANCE, AbsPackageManagerCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.content.AbsPackageManagerCompatImplFactory.IPackageManagerCompatImpl
        @NotNull
        public Boolean hasFeature(@Nullable Context context, int featureType) {
            return Boolean.FALSE;
        }
    }

    @Nullable
    public IPackageManagerCompatImpl create(int deviceType) {
        return new PackageManagerCompatPureImpl();
    }
}
