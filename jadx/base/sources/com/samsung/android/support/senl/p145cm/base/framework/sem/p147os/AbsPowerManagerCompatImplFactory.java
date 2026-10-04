package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.content.Context;
import android.os.PowerManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.common.status.ThermalStatus;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \f2\u00020\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "context", "Landroid/content/Context;", "IPowerManagerCompatImpl", "PowerManagerCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPowerManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "PowerManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;", "", "isInteractive", "", "()Z", "wakeUp", "time", "", "reason", "", "goToSleep", "acquireWakeLock", "", "tag", "", "timeout", "releaseWakeLock", "addThermalStatusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$ThermalStatusListener;", "removeThermalStatusListener", "currentThermalStatus", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "getCurrentThermalStatus", "()Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPowerManagerCompatImpl {
        void acquireWakeLock(@Nullable String tag, long timeout);

        void addThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener);

        @NotNull
        ThermalStatus.Types getCurrentThermalStatus();

        boolean goToSleep(long time);

        boolean isInteractive();

        void releaseWakeLock();

        void removeThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener);

        boolean wakeUp(long time, int reason);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$PowerManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPowerManager", "Landroid/os/PowerManager;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "isInteractive", "", "()Z", "wakeUp", "time", "", "reason", "", "goToSleep", "acquireWakeLock", "", "tag", "", "timeout", "releaseWakeLock", "addThermalStatusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$ThermalStatusListener;", "removeThermalStatusListener", "currentThermalStatus", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "getCurrentThermalStatus", "()Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PowerManagerCompatPureImpl implements IPowerManagerCompatImpl {

        @Nullable
        private PowerManager mPowerManager;

        @Nullable
        private PowerManager.WakeLock mWakeLock;

        public PowerManagerCompatPureImpl(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            this.mPowerManager = (PowerManager) systemService;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void acquireWakeLock(@Nullable String tag, long timeout) {
            try {
                LoggerBase.Companion companion = LoggerBase.INSTANCE;
                Object obj = this.mWakeLock;
                if (obj == null) {
                    obj = "null";
                }
                companion.m7132d(AbsPowerManagerCompatImplFactory.TAG, "acquireWakeLock wakeLock/tag " + obj + " / " + (tag != null ? tag : "null"));
                if (this.mWakeLock == null) {
                    PowerManager powerManager = this.mPowerManager;
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager != null ? powerManager.newWakeLock(1, tag) : null;
                    this.mWakeLock = wakeLockNewWakeLock;
                    if (wakeLockNewWakeLock != null) {
                        wakeLockNewWakeLock.acquire(timeout);
                    }
                }
            } catch (Exception e) {
                AbstractC0000a.m23t("acquireWakeLock: ", e.getMessage(), LoggerBase.INSTANCE, AbsPowerManagerCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void addThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            listener.onThermalStatusChanged(ThermalStatus.Types.NONE);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        @NotNull
        public ThermalStatus.Types getCurrentThermalStatus() {
            return ThermalStatus.Types.NONE;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public boolean goToSleep(long time) {
            try {
                Class.forName("android.os.PowerManager").getMethod("goToSleep", Long.TYPE).invoke(this.mPowerManager, Long.valueOf(time));
                return true;
            } catch (ClassNotFoundException unused) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "goToSleep : ClassNotFoundException]");
                return false;
            } catch (IllegalAccessException unused2) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "goToSleep : IllegalAccessException]");
                return false;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("goToSleep: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AbsPowerManagerCompatImplFactory.TAG);
                return false;
            } catch (NoSuchMethodException unused3) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "goToSleep : NoSuchMethodException]");
                return false;
            } catch (InvocationTargetException unused4) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "goToSleep : InvocationTargetException]");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public boolean isInteractive() {
            try {
                PowerManager powerManager = this.mPowerManager;
                if (powerManager != null) {
                    return powerManager.isInteractive();
                }
                return false;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("isInteractive: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AbsPowerManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void releaseWakeLock() {
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            Object obj = this.mWakeLock;
            if (obj == null) {
                obj = "null";
            }
            companion.m7132d(AbsPowerManagerCompatImplFactory.TAG, "releaseWakeLock " + obj);
            try {
                PowerManager.WakeLock wakeLock = this.mWakeLock;
                if (wakeLock == null || wakeLock == null || !wakeLock.isHeld()) {
                    return;
                }
                PowerManager.WakeLock wakeLock2 = this.mWakeLock;
                if (wakeLock2 != null) {
                    wakeLock2.release();
                }
                this.mWakeLock = null;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("releaseWakeLock: ", e.getMessage(), LoggerBase.INSTANCE, AbsPowerManagerCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void removeThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public boolean wakeUp(long time, int reason) {
            try {
                Class.forName("android.os.PowerManager").getMethod("wakeUp", Long.TYPE, Integer.TYPE).invoke(this.mPowerManager, Long.valueOf(time), Integer.valueOf(reason));
                return true;
            } catch (ClassNotFoundException unused) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "wakeup : ClassNotFoundException]");
                return false;
            } catch (IllegalAccessException unused2) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "wakeup : IllegalAccessException]");
                return false;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("wakeup: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AbsPowerManagerCompatImplFactory.TAG);
                return false;
            } catch (NoSuchMethodException unused3) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "wakeup : NoSuchMethodException]");
                return false;
            } catch (InvocationTargetException unused4) {
                LoggerBase.INSTANCE.m7133e(AbsPowerManagerCompatImplFactory.TAG, "wakeup : InvocationTargetException]");
                return false;
            }
        }
    }

    @NotNull
    public IPowerManagerCompatImpl create(int deviceType, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PowerManagerCompatPureImpl(context);
    }
}
