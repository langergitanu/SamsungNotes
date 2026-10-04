package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.common.status.ThermalStatus;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsPowerManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.PowerManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PowerManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;)V", "isInteractive", "", "()Z", "wakeUp", "time", "", "reason", "", "goToSleep", "acquireWakeLock", "", "tag", "", "timeout", "releaseWakeLock", "addThermalStatusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/framework/os/PowerManagerCompat$OnThermalStatusListener;", "removeThermalStatusListener", "currentThermalStatus", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "getCurrentThermalStatus", "()Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "OnThermalStatusListener", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PowerManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "PowerManagerCompat";

    @Nullable
    private static PowerManagerCompat sInstance;

    @NotNull
    private final AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PowerManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/os/PowerManagerCompat;", "getInstance", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized PowerManagerCompat getInstance(@NotNull Context context) {
            PowerManagerCompat powerManagerCompat;
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                if (PowerManagerCompat.sInstance == null) {
                    PowerManagerCompatImplFactory powerManagerCompatImplFactory = new PowerManagerCompatImplFactory();
                    int deviceType = DeviceInfo.getDeviceType();
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    PowerManagerCompat.sInstance = new PowerManagerCompat(powerManagerCompatImplFactory.create(deviceType, applicationContext), null);
                }
                powerManagerCompat = PowerManagerCompat.sInstance;
                Intrinsics.checkNotNull(powerManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.os.PowerManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return powerManagerCompat;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PowerManagerCompat$OnThermalStatusListener;", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$ThermalStatusListener;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnThermalStatusListener extends ThermalStatus.ThermalStatusListener {
    }

    public /* synthetic */ PowerManagerCompat(AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl iPowerManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPowerManagerCompatImpl);
    }

    @JvmStatic
    @NotNull
    public static final synchronized PowerManagerCompat getInstance(@NotNull Context context) {
        return INSTANCE.getInstance(context);
    }

    public final void acquireWakeLock(@Nullable String tag, long timeout) {
        this.mImpl.acquireWakeLock(tag, timeout);
    }

    public final void addThermalStatusListener(@NotNull OnThermalStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mImpl.addThermalStatusListener(listener);
    }

    @NotNull
    public final ThermalStatus.Types getCurrentThermalStatus() {
        return this.mImpl.getCurrentThermalStatus();
    }

    public final boolean goToSleep(long time) {
        return this.mImpl.goToSleep(time);
    }

    public final boolean isInteractive() {
        return this.mImpl.isInteractive();
    }

    public final void releaseWakeLock() {
        this.mImpl.releaseWakeLock();
    }

    public final void removeThermalStatusListener(@NotNull OnThermalStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mImpl.removeThermalStatusListener(listener);
    }

    public final boolean wakeUp(long time, int reason) {
        return this.mImpl.wakeUp(time, reason);
    }

    private PowerManagerCompat(AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl iPowerManagerCompatImpl) {
        this.mImpl = iPowerManagerCompatImpl;
    }
}
