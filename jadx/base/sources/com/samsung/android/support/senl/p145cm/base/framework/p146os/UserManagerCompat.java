package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsUserManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.UserManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/UserManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsUserManagerCompatImplFactory$IUserManagerCompat;)V", "isGuestMode", "", "context", "Landroid/content/Context;", "isDigitalLegacyMode", "isFeatureSupportDigitalLegacy", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UserManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static UserManagerCompat sInstance;

    @NotNull
    private final AbsUserManagerCompatImplFactory.IUserManagerCompat mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/UserManagerCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/os/UserManagerCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/os/UserManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserManagerCompat getInstance() {
            if (UserManagerCompat.sInstance == null) {
                UserManagerCompat.sInstance = new UserManagerCompat(new UserManagerCompatImplFactory().create(DeviceInfo.getDeviceType()));
            }
            UserManagerCompat userManagerCompat = UserManagerCompat.sInstance;
            Intrinsics.checkNotNull(userManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.os.UserManagerCompat");
            return userManagerCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public UserManagerCompat(@NotNull AbsUserManagerCompatImplFactory.IUserManagerCompat mImpl) {
        Intrinsics.checkNotNullParameter(mImpl, "mImpl");
        this.mImpl = mImpl;
    }

    @NotNull
    public static final UserManagerCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final boolean isDigitalLegacyMode(@Nullable Context context) {
        return this.mImpl.isDigitalLegacyMode(context);
    }

    public final boolean isFeatureSupportDigitalLegacy() {
        return this.mImpl.isFeatureSupportDigitalLegacy();
    }

    public final boolean isGuestMode(@Nullable Context context) {
        return this.mImpl.isGuestMode(context);
    }
}
