package com.samsung.android.support.senl.p145cm.base.framework.sem.feature;

import com.samsung.android.feature.SemFloatingFeature;
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
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$IFloatingFeatureCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IFloatingFeatureCompatImpl", "FloatingFeatureCompatPureImpl", "FloatingFeatureCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FloatingFeatureImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\bH&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$IFloatingFeatureCompatImpl;", "", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IFloatingFeatureCompatImpl {
        boolean getBoolean(@Nullable String tag);

        boolean getBoolean(@Nullable String tag, boolean defaultValue);

        int getInt(@Nullable String tag);

        int getInt(@Nullable String tag, int defaultValue);

        @NotNull
        String getString(@Nullable String tag);

        @NotNull
        String getString(@Nullable String tag, @Nullable String defaultValue);
    }

    @NotNull
    public final IFloatingFeatureCompatImpl create(int deviceType) {
        return deviceType == 2 ? new FloatingFeatureCompatSemImpl() : new FloatingFeatureCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$FloatingFeatureCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$IFloatingFeatureCompatImpl;", "<init>", "()V", "mSemFloatingFeature", "Lcom/samsung/android/feature/SemFloatingFeature;", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FloatingFeatureCompatSemImpl implements IFloatingFeatureCompatImpl {

        @NotNull
        private static final String TAG = "FloatingFeatureDelegateSemImpl";

        @Nullable
        private SemFloatingFeature mSemFloatingFeature;

        public FloatingFeatureCompatSemImpl() {
            try {
                this.mSemFloatingFeature = SemFloatingFeature.getInstance();
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag, boolean defaultValue) {
            SemFloatingFeature semFloatingFeature = this.mSemFloatingFeature;
            if (semFloatingFeature != null) {
                try {
                    Intrinsics.checkNotNull(semFloatingFeature);
                    return semFloatingFeature.getBoolean(tag);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getBoolean: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public int getInt(@Nullable String tag, int defaultValue) {
            SemFloatingFeature semFloatingFeature = this.mSemFloatingFeature;
            if (semFloatingFeature != null) {
                try {
                    Intrinsics.checkNotNull(semFloatingFeature);
                    return semFloatingFeature.getInt(tag);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getInt: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return defaultValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag, @Nullable String defaultValue) {
            SemFloatingFeature semFloatingFeature = this.mSemFloatingFeature;
            if (semFloatingFeature != null) {
                try {
                    Intrinsics.checkNotNull(semFloatingFeature);
                    String string = semFloatingFeature.getString(tag);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getString: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return String.valueOf(defaultValue);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag) {
            SemFloatingFeature semFloatingFeature = this.mSemFloatingFeature;
            if (semFloatingFeature == null) {
                return false;
            }
            try {
                Intrinsics.checkNotNull(semFloatingFeature);
                return semFloatingFeature.getBoolean(tag);
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("getBoolean: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public int getInt(@Nullable String tag) {
            SemFloatingFeature semFloatingFeature = this.mSemFloatingFeature;
            if (semFloatingFeature == null) {
                return 0;
            }
            try {
                Intrinsics.checkNotNull(semFloatingFeature);
                return semFloatingFeature.getInt(tag);
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("getInt: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return 0;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag) {
            SemFloatingFeature semFloatingFeature = this.mSemFloatingFeature;
            if (semFloatingFeature != null) {
                try {
                    Intrinsics.checkNotNull(semFloatingFeature);
                    String string = semFloatingFeature.getString(tag);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getString: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                    return "";
                }
            }
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$FloatingFeatureCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$IFloatingFeatureCompatImpl;", "<init>", "()V", "mFloatingObject", "", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FloatingFeatureCompatPureImpl implements IFloatingFeatureCompatImpl {

        @NotNull
        private static final String TAG = "FloatingFeatureDelegatePureImpl";

        @Nullable
        private Object mFloatingObject;

        public FloatingFeatureCompatPureImpl() {
            try {
                Class<?> cls = Class.forName("com.samsung.android.feature.FloatingFeature");
                this.mFloatingObject = cls.getMethod("getInstance", null).invoke(cls, null);
            } catch (ClassNotFoundException e) {
                AbstractC0000a.m23t("FloatingFeatureDelegatePureImpl, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (IllegalAccessException e2) {
                AbstractC0000a.m23t("FloatingFeatureDelegatePureImpl, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (NoSuchMethodException e3) {
                AbstractC0000a.m23t("FloatingFeatureDelegatePureImpl, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
            } catch (InvocationTargetException e5) {
                AbstractC0000a.m23t("FloatingFeatureDelegatePureImpl, e : ", e5.getMessage(), LoggerBase.INSTANCE, TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag, boolean defaultValue) {
            Object obj = this.mFloatingObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getBoolean", String.class, Boolean.TYPE).invoke(this.mFloatingObject, tag, Boolean.valueOf(defaultValue));
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

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public int getInt(@Nullable String tag, int defaultValue) {
            Object obj = this.mFloatingObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getInt", String.class, Integer.TYPE).invoke(this.mFloatingObject, tag, Integer.valueOf(defaultValue));
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

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag, @Nullable String defaultValue) {
            Object obj = this.mFloatingObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getString", String.class, String.class).invoke(this.mFloatingObject, tag, defaultValue);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                    return (String) objInvoke;
                } catch (IllegalAccessException e) {
                    AbstractC0000a.m23t("getString#, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (NoSuchMethodException e2) {
                    AbstractC0000a.m23t("getString#, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                } catch (InvocationTargetException e3) {
                    AbstractC0000a.m23t("getString#, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return String.valueOf(defaultValue);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public boolean getBoolean(@Nullable String tag) {
            Object obj = this.mFloatingObject;
            if (obj == null) {
                return false;
            }
            try {
                Intrinsics.checkNotNull(obj);
                Object objInvoke = obj.getClass().getMethod("getBoolean", String.class).invoke(this.mFloatingObject, tag);
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

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        public int getInt(@Nullable String tag) {
            Object obj = this.mFloatingObject;
            if (obj == null) {
                return 0;
            }
            try {
                Intrinsics.checkNotNull(obj);
                Object objInvoke = obj.getClass().getMethod("getInt", String.class).invoke(this.mFloatingObject, tag);
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

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.feature.FloatingFeatureImplFactory.IFloatingFeatureCompatImpl
        @NotNull
        public String getString(@Nullable String tag) {
            Object obj = this.mFloatingObject;
            if (obj != null) {
                try {
                    Intrinsics.checkNotNull(obj);
                    Object objInvoke = obj.getClass().getMethod("getString", String.class).invoke(this.mFloatingObject, tag);
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
