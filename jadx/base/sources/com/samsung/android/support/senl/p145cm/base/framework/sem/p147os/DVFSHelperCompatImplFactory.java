package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.content.Context;
import android.os.Build;
import com.samsung.android.os.SemDvfsManager;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsDVFSHelperCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/DVFSHelperCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$IDVFSHelperCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "context", "Landroid/content/Context;", "DVFSHelperCompatSemSosImpl", "DVFSHelperCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DVFSHelperCompatImplFactory extends AbsDVFSHelperCompatImplFactory {

    @NotNull
    private static final String TAG = "DVFSHelperCompatImpl";

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsDVFSHelperCompatImplFactory
    @NotNull
    public AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl create(int deviceType, @Nullable Context context) {
        return deviceType == 2 ? Build.VERSION.SDK_INT > 30 ? new DVFSHelperCompatSemSosImpl(context) : new DVFSHelperCompatSemImpl(context) : super.create(deviceType, context);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/DVFSHelperCompatImplFactory$DVFSHelperCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$DVFSHelperCompatPureImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSemDvfsManager", "Lcom/samsung/android/os/SemDvfsManager;", "supportedCPUFrequencyForSSRM", "", "getSupportedCPUFrequencyForSSRM", "()[I", "addExtraOption", "", "name", "", "value", "", "acquire", "timeout", "", "release", "doBoost", "milisecond", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DVFSHelperCompatSemImpl extends AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl {

        @Nullable
        private SemDvfsManager mSemDvfsManager;

        public DVFSHelperCompatSemImpl(@Nullable Context context) {
            try {
                if (Build.VERSION.SDK_INT <= 36) {
                    this.mSemDvfsManager = context != null ? SemDvfsManager.createInstance(context, 12) : null;
                } else {
                    this.mSemDvfsManager = context != null ? SemDvfsManager.createInstance(context, "CPU_MIN") : null;
                }
            } catch (Exception e) {
                AbstractC0000a.m23t("DVFSHelperDelegateSemImpl: Exception] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
            } catch (NoClassDefFoundError e2) {
                AbstractC0000a.m23t("DVFSHelperDelegateSemImpl: NoClassDefFoundError] ", e2.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
            } catch (NoSuchMethodError e3) {
                AbstractC0000a.m23t("DVFSHelperDelegateSemImpl: NoSuchMethodError] ", e3.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire(int timeout) {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            if (semDvfsManager == null) {
                return true;
            }
            try {
                semDvfsManager.acquire(timeout);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("acquire: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean addExtraOption(@Nullable String name, long value) {
            if (Intrinsics.areEqual("CPU", name)) {
                SemDvfsManager semDvfsManager = this.mSemDvfsManager;
                if (semDvfsManager == null) {
                    LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                    return false;
                }
                if (semDvfsManager == null) {
                    return true;
                }
                try {
                    semDvfsManager.setDvfsValue((int) value);
                    return true;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("addExtraOption: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                }
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean doBoost(int milisecond) {
            if (this.mSemDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(DVFSHelperCompatImplFactory.TAG, "doBoost, milisecond : " + milisecond);
            if (getSupportedCPUFrequencyForSSRM() != null) {
                addExtraOption("CPU", r3[0]);
            } else {
                companion.m7133e(DVFSHelperCompatImplFactory.TAG, "supportedCFTable is null");
            }
            return acquire(milisecond);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        @Nullable
        public int[] getSupportedCPUFrequencyForSSRM() {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return null;
            }
            if (semDvfsManager != null) {
                try {
                    return semDvfsManager.getSupportedFrequencyForSsrm();
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getSupportedCPUFrequencyForSSRM: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                }
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean release() {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            if (semDvfsManager == null) {
                return true;
            }
            try {
                semDvfsManager.release();
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("release: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire() {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            if (semDvfsManager == null) {
                return true;
            }
            try {
                semDvfsManager.acquire();
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("acquire: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/DVFSHelperCompatImplFactory$DVFSHelperCompatSemSosImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$DVFSHelperCompatPureImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mClassSemDvfsManager", "Ljava/lang/Class;", "mSemDvfsManager", "Lcom/samsung/android/os/SemDvfsManager;", "initScenarioType", "", "ScenarioType", "", "acquire", "", "timeout", "release", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DVFSHelperCompatSemSosImpl extends AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl {

        @NotNull
        private static final String CLASS_NAME = "com.samsung.android.os.SemDvfsManager";

        @NotNull
        private static final String SCENARIO_SPENSDK_FLING = "SPENSDK_FLING";

        @Nullable
        private Class<?> mClassSemDvfsManager;

        @Nullable
        private SemDvfsManager mSemDvfsManager;

        public DVFSHelperCompatSemSosImpl(@Nullable Context context) {
            try {
                this.mClassSemDvfsManager = Class.forName(CLASS_NAME);
            } catch (ClassNotFoundException e) {
                AbstractC0000a.m23t("DVFSHelperDelegateSemSosImpl: Exception] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire(int timeout) {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            if (semDvfsManager == null) {
                return true;
            }
            try {
                semDvfsManager.acquire(timeout);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("acquire timeout: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public void initScenarioType(@Nullable Context context, int ScenarioType) {
            if (this.mClassSemDvfsManager == null) {
                LoggerBase.INSTANCE.m7133e(DVFSHelperCompatImplFactory.TAG, "initScenarioType# mClassSemDvfsManager is null");
                return;
            }
            if (ScenarioType != 1500) {
                LoggerBase.INSTANCE.m7133e(DVFSHelperCompatImplFactory.TAG, "initScenarioType# ScenarioType failed : " + ScenarioType);
                return;
            }
            SemDvfsManager semDvfsManagerCreateInstance = SemDvfsManager.createInstance(context, SCENARIO_SPENSDK_FLING);
            if (semDvfsManagerCreateInstance == null) {
                LoggerBase.INSTANCE.m7133e(DVFSHelperCompatImplFactory.TAG, "initScenarioType# semDvfsManager : createInstance failed");
            } else if (!semDvfsManagerCreateInstance.checkHintSupported(1500)) {
                LoggerBase.INSTANCE.m7133e(DVFSHelperCompatImplFactory.TAG, "setHint: failed ");
            } else {
                this.mSemDvfsManager = semDvfsManagerCreateInstance;
                semDvfsManagerCreateInstance.setHint(1500);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean release() {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            if (semDvfsManager == null) {
                return true;
            }
            try {
                semDvfsManager.release();
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("release: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire() {
            SemDvfsManager semDvfsManager = this.mSemDvfsManager;
            if (semDvfsManager == null) {
                LoggerBase.INSTANCE.m7132d(DVFSHelperCompatImplFactory.TAG, "mSemDvfsManager is null");
                return false;
            }
            if (semDvfsManager == null) {
                return true;
            }
            try {
                semDvfsManager.acquire();
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("acquire: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, DVFSHelperCompatImplFactory.TAG);
                return false;
            }
        }
    }
}
