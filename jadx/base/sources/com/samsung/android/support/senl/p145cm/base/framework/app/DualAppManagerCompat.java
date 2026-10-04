package com.samsung.android.support.senl.p145cm.base.framework.app;

import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsDualAppManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.DualAppManagerImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/DualAppManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDualAppManagerCompatImplFactory$IDualAppManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDualAppManagerCompatImplFactory$IDualAppManagerCompatImpl;)V", "isDualAppId", "", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "", "getAllWhitelistedPackages", "", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DualAppManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static DualAppManagerCompat mInstance;

    @NotNull
    private final AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/DualAppManagerCompat$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/DualAppManagerCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/DualAppManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized DualAppManagerCompat getInstance() {
            DualAppManagerCompat dualAppManagerCompat;
            try {
                if (DualAppManagerCompat.mInstance == null) {
                    DualAppManagerCompat.mInstance = new DualAppManagerCompat(new DualAppManagerImplFactory().create(DeviceInfo.isSemDevice()), null);
                }
                dualAppManagerCompat = DualAppManagerCompat.mInstance;
                Intrinsics.checkNotNull(dualAppManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.DualAppManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return dualAppManagerCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ DualAppManagerCompat(AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl iDualAppManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iDualAppManagerCompatImpl);
    }

    @NotNull
    public static final synchronized DualAppManagerCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final List<String> getAllWhitelistedPackages() {
        return this.mImpl.getAllWhitelistedPackages();
    }

    public final boolean isDualAppId(int userId) {
        return this.mImpl.isDualAppId(userId);
    }

    private DualAppManagerCompat(AbsDualAppManagerCompatImplFactory.IDualAppManagerCompatImpl iDualAppManagerCompatImpl) {
        this.mImpl = iDualAppManagerCompatImpl;
    }
}
