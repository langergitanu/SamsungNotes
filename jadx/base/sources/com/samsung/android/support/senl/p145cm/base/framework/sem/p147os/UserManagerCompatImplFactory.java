package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.content.Context;
import android.content.pm.SemUserInfo;
import android.os.Build;
import android.os.UserHandle;
import android.os.UserManager;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsUserManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;", HandoffConstant.KEY_DEVICE_TYPE, "", "UserManagerCompatSem", "UserManagerCompatSemQosSupport", "UserManagerCompatSemQosUnsupported", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UserManagerCompatImplFactory extends AbsUserManagerCompatImplFactory {
    public static final boolean FEATURE_SUPPORT_DIGITAL_LEGACY = true;

    @NotNull
    private static final String TAG = "UserManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserManagerCompatImplFactory$UserManagerCompatSem;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;", "<init>", "()V", "isDigitalLegacyMode", "", "isDigitalLegacyModeChecked", "context", "Landroid/content/Context;", "semUserInfoHasFlag", "flag", "", "isFeatureSupportDigitalLegacy", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class UserManagerCompatSem implements AbsUserManagerCompatImplFactory.IUserManagerCompat {
        private boolean isDigitalLegacyMode;
        private boolean isDigitalLegacyModeChecked;

        private final boolean semUserInfoHasFlag(Context context, int flag) {
            boolean z = false;
            try {
                Object systemService = context.getSystemService(IdentityApiContract.Token.USER);
                UserManager userManager = systemService instanceof UserManager ? (UserManager) systemService : null;
                SemUserInfo semUserInfoSemGetSemUserInfo = userManager != null ? userManager.semGetSemUserInfo(UserHandle.semGetMyUserId()) : null;
                Field declaredField = semUserInfoSemGetSemUserInfo != null ? semUserInfoSemGetSemUserInfo.getClass().getDeclaredField("flags") : null;
                Object obj = declaredField != null ? declaredField.get(semUserInfoSemGetSemUserInfo) : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                if ((((Integer) obj).intValue() & flag) == flag) {
                    z = true;
                }
            } catch (Error e) {
                AbstractC0000a.m23t("semUserInfoHasFlag : Error - ", e.getMessage(), LoggerBase.INSTANCE, UserManagerCompatImplFactory.TAG);
            } catch (Exception e2) {
                AbstractC0000a.m23t("semUserInfoHasFlag : Exception - ", e2.getMessage(), LoggerBase.INSTANCE, UserManagerCompatImplFactory.TAG);
            }
            LoggerBase.INSTANCE.m7132d(UserManagerCompatImplFactory.TAG, "semUserInfoHasFlag : result - " + z);
            return z;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isDigitalLegacyMode(@Nullable Context context) {
            if (Build.VERSION.SDK_INT <= 34) {
                return false;
            }
            if (this.isDigitalLegacyModeChecked) {
                return this.isDigitalLegacyMode;
            }
            if (context != null && semUserInfoHasFlag(context, 16777216)) {
                this.isDigitalLegacyMode = true;
            }
            LoggerBase.INSTANCE.m7132d(UserManagerCompatImplFactory.TAG, "isDigitalLegacyMode() : " + this.isDigitalLegacyMode);
            this.isDigitalLegacyModeChecked = true;
            return this.isDigitalLegacyMode;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isFeatureSupportDigitalLegacy() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserManagerCompatImplFactory$UserManagerCompatSemQosSupport;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserManagerCompatImplFactory$UserManagerCompatSem;", "<init>", "()V", "isGuestMode", "", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UserManagerCompatSemQosSupport extends UserManagerCompatSem {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isGuestMode(@Nullable Context context) {
            Object systemService;
            boolean zSemIsGuestUser = false;
            if (context != null) {
                try {
                    systemService = context.getSystemService(IdentityApiContract.Token.USER);
                } catch (Exception e) {
                    AbstractC0000a.m23t("isGuestModeQ : Exception - ", e.getMessage(), LoggerBase.INSTANCE, UserManagerCompatImplFactory.TAG);
                }
            } else {
                systemService = null;
            }
            UserManager userManager = systemService instanceof UserManager ? (UserManager) systemService : null;
            if (userManager == null) {
                return false;
            }
            zSemIsGuestUser = userManager.semIsGuestUser();
            LoggerBase.INSTANCE.m7132d(UserManagerCompatImplFactory.TAG, "isGuestModeQ : NoSuchMethodException");
            LoggerBase.INSTANCE.m7132d(UserManagerCompatImplFactory.TAG, "isGuestModeQ : result - " + zSemIsGuestUser);
            return zSemIsGuestUser;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserManagerCompatImplFactory$UserManagerCompatSemQosUnsupported;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserManagerCompatImplFactory$UserManagerCompatSem;", "<init>", "()V", "isGuestMode", "", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UserManagerCompatSemQosUnsupported extends UserManagerCompatSem {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserManagerCompatImplFactory.IUserManagerCompat
        public boolean isGuestMode(@Nullable Context context) {
            Object systemService;
            boolean zBooleanValue;
            if (context != null) {
                try {
                    systemService = context.getSystemService(IdentityApiContract.Token.USER);
                } catch (Exception e) {
                    AbstractC0000a.m23t("isGuestMode : Exception - ", e.getMessage(), LoggerBase.INSTANCE, UserManagerCompatImplFactory.TAG);
                    zBooleanValue = false;
                }
            } else {
                systemService = null;
            }
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.UserManager");
            UserManager userManager = (UserManager) systemService;
            Object objInvoke = userManager.getClass().getDeclaredMethod("isGuestUser", null).invoke(userManager, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            zBooleanValue = ((Boolean) objInvoke).booleanValue();
            LoggerBase.INSTANCE.m7132d(UserManagerCompatImplFactory.TAG, "isGuestMode : result - " + zBooleanValue);
            return zBooleanValue;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsUserManagerCompatImplFactory
    @NotNull
    public AbsUserManagerCompatImplFactory.IUserManagerCompat create(int deviceType) {
        return deviceType == 2 ? Build.VERSION.SDK_INT >= 29 ? new UserManagerCompatSemQosSupport() : new UserManagerCompatSemQosUnsupported() : super.create(deviceType);
    }
}
