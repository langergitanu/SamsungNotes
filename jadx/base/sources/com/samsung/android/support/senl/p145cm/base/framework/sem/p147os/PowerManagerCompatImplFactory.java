package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.content.Context;
import android.os.PowerManager;
import android.p108os.PowerManager$OnThermalStatusChangedListener;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.AbstractC7894a;
import com.samsung.android.support.senl.p145cm.base.common.status.ThermalStatus;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BuildCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsPowerManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/PowerManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "context", "Landroid/content/Context;", "PowerManagerCompatSemImpl", "PowerManagerCompatSemOverQImpl", "PowerManagerCompatSemOverRImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PowerManagerCompatImplFactory extends AbsPowerManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "PowerManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/PowerManagerCompatImplFactory$PowerManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsPowerManagerCompatImplFactory$IPowerManagerCompatImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPowerManager", "Landroid/os/PowerManager;", "getMPowerManager", "()Landroid/os/PowerManager;", "setMPowerManager", "(Landroid/os/PowerManager;)V", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "isInteractive", "", "()Z", "wakeUp", "time", "", "reason", "", "goToSleep", "acquireWakeLock", "", "tag", "", "timeout", "releaseWakeLock", "addThermalStatusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$ThermalStatusListener;", "removeThermalStatusListener", "currentThermalStatus", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "getCurrentThermalStatus", "()Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class PowerManagerCompatSemImpl implements AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl {

        @Nullable
        private PowerManager mPowerManager;

        @Nullable
        private PowerManager.WakeLock mWakeLock;

        public PowerManagerCompatSemImpl(@Nullable Context context) {
            Object systemService = context != null ? context.getSystemService("power") : null;
            this.mPowerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void acquireWakeLock(@Nullable String tag, long timeout) {
            try {
                LoggerBase.INSTANCE.m7132d(PowerManagerCompatImplFactory.TAG, "acquireWakeLock wakeLock/tag " + this.mWakeLock + "/" + tag);
                if (this.mWakeLock == null) {
                    PowerManager powerManager = this.mPowerManager;
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager != null ? powerManager.newWakeLock(1, tag) : null;
                    this.mWakeLock = wakeLockNewWakeLock;
                    if (wakeLockNewWakeLock != null) {
                        wakeLockNewWakeLock.acquire(timeout);
                    }
                }
            } catch (Exception e) {
                AbstractC0000a.m23t("acquireWakeLock: ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
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

        @Nullable
        public final PowerManager getMPowerManager() {
            return this.mPowerManager;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public boolean goToSleep(long time) {
            try {
                PowerManager powerManager = this.mPowerManager;
                if (powerManager == null) {
                    return true;
                }
                powerManager.semGoToSleep(time);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("semGoToSleep: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
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
                AbstractC0000a.m23t("isInteractive: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void releaseWakeLock() {
            LoggerBase.INSTANCE.m7132d(PowerManagerCompatImplFactory.TAG, "releaseWakeLock " + this.mWakeLock);
            try {
                PowerManager.WakeLock wakeLock = this.mWakeLock;
                if (wakeLock == null || !wakeLock.isHeld()) {
                    return;
                }
                PowerManager.WakeLock wakeLock2 = this.mWakeLock;
                if (wakeLock2 != null) {
                    wakeLock2.release();
                }
                this.mWakeLock = null;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("releaseWakeLock: ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void removeThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public final void setMPowerManager(@Nullable PowerManager powerManager) {
            this.mPowerManager = powerManager;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public boolean wakeUp(long time, int reason) {
            try {
                PowerManager powerManager = this.mPowerManager;
                if (powerManager == null) {
                    return true;
                }
                powerManager.semWakeUp(time, reason, PowerManagerCompatImplFactory.TAG);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("semWakeUp: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(api = 29)
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/PowerManagerCompatImplFactory$PowerManagerCompatSemOverQImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/PowerManagerCompatImplFactory$PowerManagerCompatSemImpl;", "Landroid/os/PowerManager$OnThermalStatusChangedListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listeners", "", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$ThermalStatusListener;", "addThermalStatusListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeThermalStatusListener", "currentThermalStatus", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "getCurrentThermalStatus", "()Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "convertThermalStatus", "status", "", "onThermalStatusChanged", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class PowerManagerCompatSemOverQImpl extends PowerManagerCompatSemImpl implements PowerManager$OnThermalStatusChangedListener {

        @NotNull
        private final List<ThermalStatus.ThermalStatusListener> listeners;

        public PowerManagerCompatSemOverQImpl(@Nullable Context context) {
            super(context);
            this.listeners = new ArrayList();
        }

        private final ThermalStatus.Types convertThermalStatus(int status) {
            switch (status) {
                case 1:
                    return ThermalStatus.Types.LIGHT;
                case 2:
                    return ThermalStatus.Types.MODERATE;
                case 3:
                    return ThermalStatus.Types.SEVERE;
                case 4:
                case 5:
                case 6:
                    return ThermalStatus.Types.CRITICAL;
                default:
                    return ThermalStatus.Types.NONE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.PowerManagerCompatImplFactory.PowerManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void addThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener) {
            PowerManager mPowerManager;
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (this.listeners.isEmpty() && (mPowerManager = getMPowerManager()) != null) {
                mPowerManager.addThermalStatusListener(AbstractC7894a.m6809j(this));
            }
            this.listeners.add(listener);
            listener.onThermalStatusChanged(getCurrentThermalStatus());
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.PowerManagerCompatImplFactory.PowerManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        @NotNull
        public ThermalStatus.Types getCurrentThermalStatus() {
            try {
                PowerManager mPowerManager = getMPowerManager();
                return convertThermalStatus(mPowerManager != null ? mPowerManager.getCurrentThermalStatus() : 0);
            } catch (Exception e) {
                AbstractC0000a.m23t("getCurrentThermalStatus: ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
                return ThermalStatus.Types.NONE;
            }
        }

        public void onThermalStatusChanged(int status) {
            Iterator<ThermalStatus.ThermalStatusListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onThermalStatusChanged(convertThermalStatus(status));
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.PowerManagerCompatImplFactory.PowerManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public void removeThermalStatusListener(@NotNull ThermalStatus.ThermalStatusListener listener) {
            PowerManager mPowerManager;
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.remove(listener);
            if (!this.listeners.isEmpty() || (mPowerManager = getMPowerManager()) == null) {
                return;
            }
            mPowerManager.removeThermalStatusListener(AbstractC7894a.m6809j(this));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(api = 30)
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/PowerManagerCompatImplFactory$PowerManagerCompatSemOverRImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/PowerManagerCompatImplFactory$PowerManagerCompatSemOverQImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "wakeUp", "", "time", "", "reason", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PowerManagerCompatSemOverRImpl extends PowerManagerCompatSemOverQImpl {
        public PowerManagerCompatSemOverRImpl(@Nullable Context context) {
            super(context);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.PowerManagerCompatImplFactory.PowerManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl
        public boolean wakeUp(long time, int reason) {
            try {
                PowerManager mPowerManager = getMPowerManager();
                if (mPowerManager == null) {
                    return true;
                }
                mPowerManager.semWakeUp(time, reason, PowerManagerCompatImplFactory.TAG);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("semWakeUp: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, PowerManagerCompatImplFactory.TAG);
                return false;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsPowerManagerCompatImplFactory
    @NotNull
    public AbsPowerManagerCompatImplFactory.IPowerManagerCompatImpl create(int deviceType, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (deviceType != 2) {
            return super.create(deviceType, context);
        }
        BuildCompat.Companion companion = BuildCompat.INSTANCE;
        return companion.isOver(BuildCompat.Version.f5792R) ? new PowerManagerCompatSemOverRImpl(context) : companion.isAtLeast(BuildCompat.Version.f5791Q) ? new PowerManagerCompatSemOverQImpl(context) : new PowerManagerCompatSemImpl(context);
    }
}
