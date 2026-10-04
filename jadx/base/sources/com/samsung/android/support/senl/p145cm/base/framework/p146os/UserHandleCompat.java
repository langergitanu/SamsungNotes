package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.net.Uri;
import android.os.UserHandle;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsUserHandleCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.UserHandleCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectWrapper;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000eJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\f¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/UserHandleCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserHandleCompatImplFactory$IUserHandleCompatImpl;)V", "mALLUser", "Lcom/samsung/android/support/senl/cm/base/framework/support/ObjectWrapper;", "Landroid/os/UserHandle;", "allUser", "isUserOwner", "", "()Z", "getUserId", "", "defaultId", "isKnoxMode", "isSecureFolderMode", "isSecureFolderId", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUriWithUserId", "Landroid/net/Uri;", "uri", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UserHandleCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int USER_CURRENT = -2;

    @Nullable
    private static UserHandleCompat mInstance;

    @Nullable
    private ObjectWrapper<UserHandle> mALLUser;

    @NotNull
    private final AbsUserHandleCompatImplFactory.IUserHandleCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/UserHandleCompat$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/os/UserHandleCompat;", "USER_CURRENT", "", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/os/UserHandleCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized UserHandleCompat getInstance() {
            UserHandleCompat userHandleCompat;
            try {
                if (UserHandleCompat.mInstance == null) {
                    UserHandleCompat.mInstance = new UserHandleCompat(new UserHandleCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                userHandleCompat = UserHandleCompat.mInstance;
                Intrinsics.checkNotNull(userHandleCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.os.UserHandleCompat");
            } catch (Throwable th) {
                throw th;
            }
            return userHandleCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ UserHandleCompat(AbsUserHandleCompatImplFactory.IUserHandleCompatImpl iUserHandleCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iUserHandleCompatImpl);
    }

    @NotNull
    public static final synchronized UserHandleCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final UserHandle allUser() {
        if (this.mALLUser == null) {
            try {
                Object obj = Class.forName("android.os.UserHandle").getField("ALL").get(null);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.os.UserHandle");
                this.mALLUser = new ObjectWrapper<>((UserHandle) obj);
            } catch (ClassNotFoundException e) {
                LoggerBase.INSTANCE.m7134e("UserHandleCompat", "initUserHandle", e);
                this.mALLUser = new ObjectWrapper<>(null);
            } catch (IllegalAccessException e2) {
                LoggerBase.INSTANCE.m7134e("UserHandleCompat", "initUserHandle", e2);
                this.mALLUser = new ObjectWrapper<>(null);
            } catch (NoSuchFieldException e3) {
                LoggerBase.INSTANCE.m7134e("UserHandleCompat", "initUserHandle", e3);
                this.mALLUser = new ObjectWrapper<>(null);
            }
        }
        ObjectWrapper<UserHandle> objectWrapper = this.mALLUser;
        if (objectWrapper != null) {
            return objectWrapper.getObject();
        }
        return null;
    }

    @Nullable
    public final Uri getUriWithUserId(@Nullable Uri uri, int userId) {
        return this.mImpl.getUriWithUserId(uri, userId);
    }

    public final int getUserId(int defaultId) {
        return this.mImpl.getUserId(defaultId);
    }

    public final boolean isKnoxMode() {
        return this.mImpl.isKnoxMode();
    }

    public final boolean isSecureFolderId(int userId) {
        return this.mImpl.isSecureFolderId(userId);
    }

    public final boolean isSecureFolderMode() {
        return this.mImpl.isSecureFolderMode();
    }

    public final boolean isUserOwner() {
        if (this.mImpl.isUserOwner()) {
            LoggerBase.INSTANCE.m7137i("UserHandleCompat", "Main user!");
            return true;
        }
        LoggerBase.INSTANCE.m7137i("UserHandleCompat", "Not main user!");
        return false;
    }

    private UserHandleCompat(AbsUserHandleCompatImplFactory.IUserHandleCompatImpl iUserHandleCompatImpl) {
        this.mImpl = iUserHandleCompatImpl;
    }
}
