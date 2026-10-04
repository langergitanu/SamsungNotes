package com.samsung.android.support.senl.p145cm.base.framework.sem.feature;

import com.samsung.android.feature.SemCscFeature;
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
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ICscFeatureCompatImpl", "CscFeatureCompatSdlImpl", "CscFeatureCompatPureImpl", "CscFeatureCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CscFeatureImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\nH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$CscFeatureCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;", "<init>", "()V", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CscFeatureCompatPureImpl implements ICscFeatureCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public int getInt(@Nullable String tag) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag, @Nullable String defaultValue) {
            return String.valueOf(defaultValue);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag, boolean defaultValue) {
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public int getInt(@Nullable String tag, int defaultValue) {
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag) {
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\bH&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;", "", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ICscFeatureCompatImpl {
        boolean getBoolean(@Nullable String tag);

        boolean getBoolean(@Nullable String tag, boolean defaultValue);

        int getInt(@Nullable String tag);

        int getInt(@Nullable String tag, int defaultValue);

        @Nullable
        String getString(@Nullable String tag);

        @Nullable
        String getString(@Nullable String tag, @Nullable String defaultValue);
    }

    @NotNull
    public final ICscFeatureCompatImpl create(int deviceType) {
        return deviceType == 2 ? new CscFeatureCompatSemImpl() : deviceType == 3 ? new CscFeatureCompatSdlImpl() : new CscFeatureCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$CscFeatureCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;", "<init>", "()V", "mCscFeature", "Lcom/samsung/android/feature/SemCscFeature;", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CscFeatureCompatSemImpl implements ICscFeatureCompatImpl {

        @NotNull
        private static final String TAG = "CscFeatureDelegateSemImpl";

        @Nullable
        private SemCscFeature mCscFeature;

        public CscFeatureCompatSemImpl() {
            try {
                this.mCscFeature = SemCscFeature.getInstance();
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("getInstance: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getInstance: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag, boolean defaultValue) {
            SemCscFeature semCscFeature = this.mCscFeature;
            if (semCscFeature != null) {
                try {
                    Intrinsics.checkNotNull(semCscFeature);
                    return semCscFeature.getBoolean(String.valueOf(tag), defaultValue);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getBoolean: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public int getInt(@Nullable String tag, int defaultValue) {
            SemCscFeature semCscFeature = this.mCscFeature;
            if (semCscFeature != null) {
                try {
                    Intrinsics.checkNotNull(semCscFeature);
                    return semCscFeature.getInt(String.valueOf(tag), defaultValue);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getInt: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        @Nullable
        public String getString(@Nullable String tag, @Nullable String defaultValue) {
            SemCscFeature semCscFeature = this.mCscFeature;
            if (semCscFeature != null) {
                try {
                    Intrinsics.checkNotNull(semCscFeature);
                    return semCscFeature.getString(String.valueOf(tag), String.valueOf(defaultValue));
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getString: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag) {
            SemCscFeature semCscFeature = this.mCscFeature;
            if (semCscFeature == null) {
                return false;
            }
            try {
                Intrinsics.checkNotNull(semCscFeature);
                return semCscFeature.getBoolean(String.valueOf(tag));
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("getBoolean: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public int getInt(@Nullable String tag) {
            SemCscFeature semCscFeature = this.mCscFeature;
            if (semCscFeature == null) {
                return 0;
            }
            try {
                Intrinsics.checkNotNull(semCscFeature);
                return semCscFeature.getInt(String.valueOf(tag));
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("getInt: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return 0;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        @Nullable
        public String getString(@Nullable String tag) {
            SemCscFeature semCscFeature = this.mCscFeature;
            if (semCscFeature != null) {
                try {
                    Intrinsics.checkNotNull(semCscFeature);
                    return semCscFeature.getString(String.valueOf(tag));
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getString: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                    return "";
                }
            }
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$CscFeatureCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;", "<init>", "()V", "mCscObject", "", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CscFeatureCompatSdlImpl implements ICscFeatureCompatImpl {

        @NotNull
        private static final String TAG = "CscFeatureDelegateSdlImpl";

        @Nullable
        private Object mCscObject;

        public CscFeatureCompatSdlImpl() {
            try {
                Class<?> cls = Class.forName("com.sec.android.app.CscFeature");
                this.mCscObject = cls.getMethod("getInstance", null).invoke(cls, null);
            } catch (ClassNotFoundException e) {
                AbstractC0000a.m23t("CscFeatureDelegateSdlImpl, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (IllegalAccessException e2) {
                AbstractC0000a.m23t("CscFeatureDelegateSdlImpl, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (NoSuchMethodException e3) {
                AbstractC0000a.m23t("CscFeatureDelegateSdlImpl, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (InvocationTargetException e5) {
                AbstractC0000a.m23t("CscFeatureDelegateSdlImpl, e : ", e5.getMessage(), LoggerBase.INSTANCE, TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag, boolean defaultValue) {
            Object obj = this.mCscObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getBoolean", String.class, Boolean.TYPE).invoke(this.mCscObject, tag, Boolean.valueOf(defaultValue));
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                    return ((Boolean) objInvoke).booleanValue();
                } catch (IllegalAccessException e) {
                    AbstractC0000a.m23t("getBoolean#, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (NoSuchMethodException e2) {
                    AbstractC0000a.m23t("getBoolean#, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (InvocationTargetException e3) {
                    AbstractC0000a.m23t("getBoolean#, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public int getInt(@Nullable String tag, int defaultValue) {
            Object obj = this.mCscObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getInt", String.class, Integer.TYPE).invoke(this.mCscObject, tag, Integer.valueOf(defaultValue));
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                } catch (IllegalAccessException e) {
                    AbstractC0000a.m23t("getInt#, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (NoSuchMethodException e2) {
                    AbstractC0000a.m23t("getInt#, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (InvocationTargetException e3) {
                    AbstractC0000a.m23t("getInt#, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        @Nullable
        public String getString(@Nullable String tag, @Nullable String defaultValue) {
            Object obj = this.mCscObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getString", String.class, String.class).invoke(this.mCscObject, tag, defaultValue);
                    if (objInvoke instanceof String) {
                        return (String) objInvoke;
                    }
                    return null;
                } catch (IllegalAccessException e) {
                    AbstractC0000a.m23t("getString#, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (NoSuchMethodException e2) {
                    AbstractC0000a.m23t("getString#, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (InvocationTargetException e3) {
                    AbstractC0000a.m23t("getString#, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag) {
            Object obj = this.mCscObject;
            if (obj == null) {
                return false;
            }
            try {
                Intrinsics.checkNotNull(obj);
                Object objInvoke = obj.getClass().getMethod("getBoolean", String.class).invoke(this.mCscObject, tag);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                return ((Boolean) objInvoke).booleanValue();
            } catch (IllegalAccessException e) {
                AbstractC0000a.m23t("getBoolean, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            } catch (NoSuchMethodException e2) {
                AbstractC0000a.m23t("getBoolean, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            } catch (InvocationTargetException e3) {
                AbstractC0000a.m23t("getBoolean, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        public int getInt(@Nullable String tag) {
            Object obj = this.mCscObject;
            if (obj == null) {
                return 0;
            }
            try {
                Intrinsics.checkNotNull(obj);
                Object objInvoke = obj.getClass().getMethod("getInt", String.class).invoke(this.mCscObject, tag);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            } catch (IllegalAccessException e) {
                AbstractC0000a.m23t("getInt, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return 0;
            } catch (NoSuchMethodException e2) {
                AbstractC0000a.m23t("getInt, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                return 0;
            } catch (InvocationTargetException e3) {
                AbstractC0000a.m23t("getInt, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                return 0;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.CscFeatureImplFactory.ICscFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag) {
            Object obj = this.mCscObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getString", String.class).invoke(this.mCscObject, tag);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                    return (String) objInvoke;
                } catch (IllegalAccessException e) {
                    AbstractC0000a.m23t("getString, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                    return "";
                } catch (NoSuchMethodException e2) {
                    AbstractC0000a.m23t("getString, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                    return "";
                } catch (InvocationTargetException e3) {
                    AbstractC0000a.m23t("getString, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                    return "";
                }
            }
            return "";
        }
    }
}
