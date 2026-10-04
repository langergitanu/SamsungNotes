package com.samsung.android.support.senl.p145cm.base.framework.emergencymode;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.sem.emergencymode.AbsEmergencyManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.emergencymode.EmergencyManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/emergencymode/EmergencyManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/AbsEmergencyManagerCompatImplFactory$IEmergencyManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/AbsEmergencyManagerCompatImplFactory$IEmergencyManagerCompatImpl;)V", "isEmergencyMode", "", "context", "Landroid/content/Context;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class EmergencyManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static EmergencyManagerCompat mInstance;

    @NotNull
    private final AbsEmergencyManagerCompatImplFactory.IEmergencyManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/emergencymode/EmergencyManagerCompat$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/emergencymode/EmergencyManagerCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/emergencymode/EmergencyManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized EmergencyManagerCompat getInstance() {
            EmergencyManagerCompat emergencyManagerCompat;
            try {
                if (EmergencyManagerCompat.mInstance == null) {
                    EmergencyManagerCompat.mInstance = new EmergencyManagerCompat(new EmergencyManagerCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                emergencyManagerCompat = EmergencyManagerCompat.mInstance;
                Intrinsics.checkNotNull(emergencyManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.emergencymode.EmergencyManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return emergencyManagerCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EmergencyManagerCompat(AbsEmergencyManagerCompatImplFactory.IEmergencyManagerCompatImpl iEmergencyManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iEmergencyManagerCompatImpl);
    }

    public final boolean isEmergencyMode(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        return this.mImpl.isEmergencyMode(context);
    }

    private EmergencyManagerCompat(AbsEmergencyManagerCompatImplFactory.IEmergencyManagerCompatImpl iEmergencyManagerCompatImpl) {
        this.mImpl = iEmergencyManagerCompatImpl;
    }
}
