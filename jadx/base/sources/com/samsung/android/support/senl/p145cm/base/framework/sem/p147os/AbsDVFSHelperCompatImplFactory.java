package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.content.Context;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \r2\u00020\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$IDVFSHelperCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "context", "Landroid/content/Context;", "IDVFSHelperCompatImpl", "DVFSHelperCompatSdlImpl", "DVFSHelperCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsDVFSHelperCompatImplFactory {

    @NotNull
    private static final String TAG = "DVFSHelperCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$DVFSHelperCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$IDVFSHelperCompatImpl;", "<init>", "()V", "supportedCPUFrequencyForSSRM", "", "getSupportedCPUFrequencyForSSRM", "()[I", "supportedCPUCoreNum", "getSupportedCPUCoreNum", "addExtraOption", "", "name", "", "value", "", "acquire", "timeout", "", "release", "doBoost", "milisecond", "initScenarioType", "", "context", "Landroid/content/Context;", "ScenarioType", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DVFSHelperCompatPureImpl implements IDVFSHelperCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire() {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean addExtraOption(@Nullable String name, long value) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean doBoost(int milisecond) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        @Nullable
        public int[] getSupportedCPUCoreNum() {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        @Nullable
        public int[] getSupportedCPUFrequencyForSSRM() {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean release() {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire(int timeout) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public void initScenarioType(@Nullable Context context, int ScenarioType) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H&J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$IDVFSHelperCompatImpl;", "", "supportedCPUFrequencyForSSRM", "", "getSupportedCPUFrequencyForSSRM", "()[I", "supportedCPUCoreNum", "getSupportedCPUCoreNum", "addExtraOption", "", "name", "", "value", "", "acquire", "timeout", "", "release", "doBoost", "milisecond", "initScenarioType", "", "context", "Landroid/content/Context;", "ScenarioType", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDVFSHelperCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int HINT_TYPE_SPENSDK_FLING = 1500;

        @NotNull
        public static final String SCENARIO_CPU_MIN = "CPU_MIN";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$IDVFSHelperCompatImpl$Companion;", "", "<init>", "()V", "HINT_TYPE_SPENSDK_FLING", "", "SCENARIO_CPU_MIN", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int HINT_TYPE_SPENSDK_FLING = 1500;

            @NotNull
            public static final String SCENARIO_CPU_MIN = "CPU_MIN";

            private Companion() {
            }
        }

        boolean acquire();

        boolean acquire(int timeout);

        boolean addExtraOption(@Nullable String name, long value);

        boolean doBoost(int milisecond);

        @Nullable
        int[] getSupportedCPUCoreNum();

        @Nullable
        int[] getSupportedCPUFrequencyForSSRM();

        void initScenarioType(@Nullable Context context, int ScenarioType);

        boolean release();
    }

    @NotNull
    public IDVFSHelperCompatImpl create(int deviceType, @Nullable Context context) {
        return deviceType == 3 ? new DVFSHelperCompatSdlImpl(context) : new DVFSHelperCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$DVFSHelperCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$DVFSHelperCompatPureImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDVFSHelperClass", "Ljava/lang/Class;", "mDVFSHelperObject", "", "supportedCPUFrequencyForSSRM", "", "getSupportedCPUFrequencyForSSRM", "()[I", "supportedCPUCoreNum", "getSupportedCPUCoreNum", "addExtraOption", "", "name", "", "value", "", "acquire", "timeout", "", "release", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DVFSHelperCompatSdlImpl extends DVFSHelperCompatPureImpl {

        @NotNull
        private static final String CLASS_NAME = "android.os.DVFSHelper";

        @Nullable
        private Class<?> mDVFSHelperClass;

        @Nullable
        private Object mDVFSHelperObject;

        public DVFSHelperCompatSdlImpl(@Nullable Context context) {
            Field declaredField;
            try {
                Class<?> cls = Class.forName(CLASS_NAME);
                this.mDVFSHelperClass = cls;
                Class[] clsArr = {Context.class, Integer.TYPE};
                if (Build.VERSION.SDK_INT > 36) {
                    Constructor<?> constructor = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, 2));
                    LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "NotesDVFSHelper - SCENARIO_CPU_MIN");
                    this.mDVFSHelperObject = constructor != null ? constructor.newInstance(Arrays.copyOf(new Object[]{context, "CPU_MIN"}, 2)) : null;
                    return;
                }
                Constructor<?> constructor2 = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, 2));
                Class<?> cls2 = this.mDVFSHelperClass;
                Integer numValueOf = (cls2 == null || (declaredField = cls2.getDeclaredField("TYPE_CPU_MIN")) == null) ? null : Integer.valueOf(declaredField.getInt(this.mDVFSHelperClass));
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "NotesDVFSHelper - TYPE_CPU_MIN : " + numValueOf);
                this.mDVFSHelperObject = constructor2 != null ? constructor2.newInstance(Arrays.copyOf(new Object[]{context, numValueOf}, 2)) : null;
            } catch (ClassNotFoundException e) {
                AbstractC0000a.m23t("DVFSHelperCompat : Exception] ", e.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
            } catch (IllegalAccessException e2) {
                AbstractC0000a.m23t("DVFSHelperCompat : Exception] ", e2.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
            } catch (InstantiationException e3) {
                AbstractC0000a.m23t("DVFSHelperCompat : Exception] ", e3.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
            } catch (NoSuchFieldException e5) {
                AbstractC0000a.m23t("DVFSHelperCompat : Exception] ", e5.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
            } catch (NoSuchMethodException e6) {
                AbstractC0000a.m23t("DVFSHelperCompat : Exception] ", e6.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
            } catch (InvocationTargetException e7) {
                AbstractC0000a.m23t("DVFSHelperCompat : Exception] ", e7.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire(int timeout) {
            if (this.mDVFSHelperObject == null) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "mDVFSHelperObject is null");
                return false;
            }
            try {
                Class[] clsArr = {Integer.TYPE};
                Class<?> cls = this.mDVFSHelperClass;
                Method method = cls != null ? cls.getMethod("acquire", (Class[]) Arrays.copyOf(clsArr, 1)) : null;
                Object[] objArr = {Integer.valueOf(timeout)};
                if (method != null) {
                    method.invoke(this.mDVFSHelperObject, Arrays.copyOf(objArr, 1));
                }
                return true;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "acquire : exception] ");
                return false;
            } catch (NoSuchMethodException unused2) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "acquire : exception] ");
                return false;
            } catch (InvocationTargetException unused3) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "acquire : exception] ");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean addExtraOption(@Nullable String name, long value) {
            if (this.mDVFSHelperObject == null) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "mDVFSHelperObject is null");
                return false;
            }
            try {
                Class[] clsArr = {String.class, Long.TYPE};
                Class<?> cls = this.mDVFSHelperClass;
                Method method = cls != null ? cls.getMethod("addExtraOption", (Class[]) Arrays.copyOf(clsArr, 2)) : null;
                Object[] objArr = {String.valueOf(name), Long.valueOf(value)};
                if (method == null) {
                    return true;
                }
                method.invoke(this.mDVFSHelperObject, Arrays.copyOf(objArr, 2));
                return true;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "addExtraOption : exception] ");
                return false;
            } catch (NoSuchMethodException unused2) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "addExtraOption : exception] ");
                return false;
            } catch (InvocationTargetException unused3) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "addExtraOption : exception] ");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        @Nullable
        public int[] getSupportedCPUCoreNum() {
            if (this.mDVFSHelperObject == null) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "mDVFSHelperObject is null");
                return null;
            }
            try {
                Class[] clsArr = new Class[0];
                Class<?> cls = this.mDVFSHelperClass;
                Method method = cls != null ? cls.getMethod("getSupportedCPUCoreNum", (Class[]) Arrays.copyOf(clsArr, 0)) : null;
                Object objInvoke = method != null ? method.invoke(this.mDVFSHelperObject, null) : null;
                if (objInvoke instanceof int[]) {
                    return (int[]) objInvoke;
                }
                return null;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "exception : getSupportedCPUCoreNum()");
                return null;
            } catch (NoSuchMethodException unused2) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "exception : getSupportedCPUCoreNum()");
                return null;
            } catch (InvocationTargetException unused3) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "exception : getSupportedCPUCoreNum()");
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        @Nullable
        public int[] getSupportedCPUFrequencyForSSRM() {
            if (this.mDVFSHelperObject == null) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "mDVFSHelperObject is null");
                return null;
            }
            try {
                Class[] clsArr = new Class[0];
                Class<?> cls = this.mDVFSHelperClass;
                Method method = cls != null ? cls.getMethod("getSupportedCPUFrequencyForSSRM", (Class[]) Arrays.copyOf(clsArr, 0)) : null;
                Object objInvoke = method != null ? method.invoke(this.mDVFSHelperObject, null) : null;
                if (objInvoke instanceof int[]) {
                    return (int[]) objInvoke;
                }
                return null;
            } catch (IllegalAccessException e) {
                AbstractC0000a.m23t("getSupportedCPUFrequencyForSSRM: exception] ", e.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodException e2) {
                AbstractC0000a.m23t("getSupportedCPUFrequencyForSSRM: exception] ", e2.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
                return null;
            } catch (InvocationTargetException e3) {
                AbstractC0000a.m23t("getSupportedCPUFrequencyForSSRM: exception] ", e3.getMessage(), LoggerBase.INSTANCE, AbsDVFSHelperCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean release() {
            if (this.mDVFSHelperObject == null) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "mDVFSHelperObject is null");
                return false;
            }
            try {
                Class[] clsArr = new Class[0];
                Class<?> cls = this.mDVFSHelperClass;
                Method method = cls != null ? cls.getMethod("release", (Class[]) Arrays.copyOf(clsArr, 0)) : null;
                if (method == null) {
                    return true;
                }
                method.invoke(this.mDVFSHelperObject, null);
                return true;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "release : exception] ");
                return false;
            } catch (NoSuchMethodException unused2) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "release : exception] ");
                return false;
            } catch (InvocationTargetException unused3) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "release : exception] ");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.DVFSHelperCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl
        public boolean acquire() {
            if (this.mDVFSHelperObject == null) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "mDVFSHelperObject is null");
                return false;
            }
            try {
                Class[] clsArr = new Class[0];
                Class<?> cls = this.mDVFSHelperClass;
                Method method = cls != null ? cls.getMethod("acquire", (Class[]) Arrays.copyOf(clsArr, 0)) : null;
                if (method == null) {
                    return true;
                }
                method.invoke(this.mDVFSHelperObject, null);
                return true;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "acquire : exception] ");
                return false;
            } catch (NoSuchMethodException unused2) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "acquire : exception] ");
                return false;
            } catch (InvocationTargetException unused3) {
                LoggerBase.INSTANCE.m7132d(AbsDVFSHelperCompatImplFactory.TAG, "acquire : exception] ");
                return false;
            }
        }
    }
}
