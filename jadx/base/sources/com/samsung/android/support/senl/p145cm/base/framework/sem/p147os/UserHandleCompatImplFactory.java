package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.net.Uri;
import android.os.UserHandle;
import android.text.TextUtils;
import com.samsung.android.knox.SemPersonaManager;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsUserHandleCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserHandleCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "UserHandleCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UserHandleCompatImplFactory extends AbsUserHandleCompatImplFactory {
    public static final int USER_CURRENT = -2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/UserHandleCompatImplFactory$UserHandleCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", "<init>", "()V", "isUserOwner", "", "()Z", "getUserId", "", "defaultId", "isKnoxMode", "isSecureFolderMode", "isSecureFolderId", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUriWithUserId", "Landroid/net/Uri;", "uri", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UserHandleCompatSemImpl implements AbsUserHandleCompatImplFactory.IUserHandleCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        @Nullable
        public Uri getUriWithUserId(@Nullable Uri uri, int userId) {
            if (userId == UserHandle.semGetMyUserId()) {
                return uri;
            }
            if (!Intrinsics.areEqual("content", uri != null ? uri.getScheme() : null) || !TextUtils.isEmpty(uri.getUserInfo())) {
                return uri;
            }
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.encodedAuthority(userId + Log.TAG_SEPARATOR + uri.getEncodedAuthority());
            return builderBuildUpon.build();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public int getUserId(int defaultId) {
            int iSemGetCallingUserId;
            try {
                iSemGetCallingUserId = UserHandle.semGetCallingUserId();
            } catch (Exception e) {
                AbstractC0000a.m23t("getUserId: Exception] ", e.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getUserId: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
            }
            return iSemGetCallingUserId != 0 ? iSemGetCallingUserId : defaultId;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isKnoxMode() {
            try {
                if (SemPersonaManager.isKnoxId(UserHandle.semGetMyUserId())) {
                    return true;
                }
                Object objInvoke = SemPersonaManager.class.getDeclaredMethod("isDoEnabled", Integer.TYPE).invoke(null, Integer.valueOf(UserHandle.semGetMyUserId()));
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e) {
                AbstractC0000a.m23t("isKnoxMode: Exception] ", e.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            } catch (NoClassDefFoundError e2) {
                AbstractC0000a.m23t("isKnoxMode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            } catch (NoSuchMethodError e3) {
                AbstractC0000a.m23t("isKnoxMode: NoSuchMethodError] ", e3.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isSecureFolderId(int userId) {
            try {
                return SemPersonaManager.isSecureFolderId(userId);
            } catch (Exception e) {
                AbstractC0000a.m23t("isSecureFolderId: Exception] ", e.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            } catch (NoClassDefFoundError e2) {
                AbstractC0000a.m23t("isSecureFolderId: NoClassDefFoundError] ", e2.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            } catch (NoSuchMethodError e3) {
                AbstractC0000a.m23t("isSecureFolderId: NoSuchMethodError] ", e3.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isSecureFolderMode() {
            try {
                return SemPersonaManager.isSecureFolderId(UserHandle.semGetMyUserId());
            } catch (Exception e) {
                AbstractC0000a.m23t("isSecureFolderMode: Exception] ", e.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            } catch (NoClassDefFoundError e2) {
                AbstractC0000a.m23t("isSecureFolderMode: NoClassDefFoundError] ", e2.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            } catch (NoSuchMethodError e3) {
                AbstractC0000a.m23t("isSecureFolderMode: NoSuchMethodError] ", e3.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isUserOwner() {
            try {
                return UserHandle.semGetMyUserId() == 0;
            } catch (Exception e) {
                AbstractC0000a.m23t("isUserOwner: Exception] ", e.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return true;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("isUserOwner: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return true;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsUserHandleCompatImplFactory
    @NotNull
    public AbsUserHandleCompatImplFactory.IUserHandleCompatImpl create(int deviceType) {
        return deviceType == 2 ? new UserHandleCompatSemImpl() : super.create(deviceType);
    }
}
