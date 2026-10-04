package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.net.Uri;
import android.os.UserHandle;
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
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IUserHandleCompatImpl", "UserHandleCompatSdlImpl", "UserHandleCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsUserHandleCompatImplFactory {
    private static final int SECURE_FOLDER_USER_ID = 150;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", "", "isUserOwner", "", "()Z", "getUserId", "", "defaultId", "isKnoxMode", "isSecureFolderMode", "isSecureFolderId", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUriWithUserId", "Landroid/net/Uri;", "uri", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IUserHandleCompatImpl {
        @Nullable
        Uri getUriWithUserId(@Nullable Uri uri, int userId);

        int getUserId(int defaultId);

        boolean isKnoxMode();

        boolean isSecureFolderId(int userId);

        boolean isSecureFolderMode();

        boolean isUserOwner();
    }

    @NotNull
    public IUserHandleCompatImpl create(int deviceType) {
        return deviceType == 3 ? new UserHandleCompatSdlImpl() : new UserHandleCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$UserHandleCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", "<init>", "()V", "isUserOwner", "", "()Z", "getUserId", "", "defaultId", "isKnoxMode", "isSecureFolderMode", "isSecureFolderId", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUriWithUserId", "Landroid/net/Uri;", "uri", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UserHandleCompatPureImpl implements IUserHandleCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isKnoxMode() {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isSecureFolderId(int userId) {
            return userId == 150;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isSecureFolderMode() {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isUserOwner() {
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public int getUserId(int defaultId) {
            return defaultId;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        @Nullable
        public Uri getUriWithUserId(@Nullable Uri uri, int userId) {
            return uri;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$UserHandleCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", "<init>", "()V", "isUserOwner", "", "()Z", "getUserId", "", "defaultId", "isKnoxMode", "isSecureFolderMode", "isSecureFolderId", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUriWithUserId", "Landroid/net/Uri;", "uri", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UserHandleCompatSdlImpl implements IUserHandleCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public int getUserId(int defaultId) {
            try {
                Object objInvoke = UserHandle.class.getDeclaredMethod("getCallingUserId", null).invoke(null, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e("UserHandleCompat", "getUserId", e);
                return defaultId;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isKnoxMode() {
            try {
                Object objInvoke = UserHandle.class.getDeclaredMethod("getCallingUserId", null).invoke(null, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue() >= 100;
            } catch (Exception e) {
                AbstractC0000a.m23t("isKnoxMode: Exception] ", e.getMessage(), LoggerBase.INSTANCE, "UserHandleCompat");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isSecureFolderId(int userId) {
            return userId == 150;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isSecureFolderMode() {
            try {
                Object objInvoke = UserHandle.class.getDeclaredMethod("getCallingUserId", null).invoke(null, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) objInvoke).intValue();
                return 150 <= iIntValue && iIntValue < 161;
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e("UserHandleCompat", "isSecureFolderMode()", e);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        public boolean isUserOwner() {
            try {
                Object objInvoke = UserHandle.class.getDeclaredMethod("myUserId", null).invoke(null, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue() == 0;
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7132d("UserHandleCompat", e.toString());
                return true;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsUserHandleCompatImplFactory.IUserHandleCompatImpl
        @Nullable
        public Uri getUriWithUserId(@Nullable Uri uri, int userId) {
            return uri;
        }
    }
}
