package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.os.Build;
import android.os.SemSystemProperties;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \f2\u00020\u0001:\u0005\b\t\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ISystemPropertiesCompatImpl", "SystemPropertiesCompatPureImpl", "SystemPropertiesDelegateSdlImpl", "SystemPropertiesCompatSemBaseImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSystemPropertiesCompatImplFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Class<?> SystemPropertiesClass = null;

    @Nullable
    private static Method SystemPropertiesGet = null;

    @NotNull
    private static final String TAG = "SystemPropertiesCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SystemPropertiesClass", "Ljava/lang/Class;", "SystemPropertiesGet", "Ljava/lang/reflect/Method;", "getSystemProperties", "name", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final String getSystemProperties(@Nullable String name) {
            try {
                synchronized (SystemPropertiesCompat.class) {
                    try {
                        if (AbsSystemPropertiesCompatImplFactory.SystemPropertiesClass == null) {
                            AbsSystemPropertiesCompatImplFactory.SystemPropertiesClass = Class.forName("android.os.SystemProperties");
                        }
                        if (AbsSystemPropertiesCompatImplFactory.SystemPropertiesGet == null) {
                            Class cls = AbsSystemPropertiesCompatImplFactory.SystemPropertiesClass;
                            AbsSystemPropertiesCompatImplFactory.SystemPropertiesGet = cls != null ? cls.getMethod("get", String.class) : null;
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
                Method method = AbsSystemPropertiesCompatImplFactory.SystemPropertiesGet;
                Object objInvoke = method != null ? method.invoke(AbsSystemPropertiesCompatImplFactory.SystemPropertiesClass, name) : null;
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                return (String) objInvoke;
            } catch (ClassNotFoundException e) {
                AbstractC0000a.m23t("getSystemProperties, e : ", e.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (IllegalAccessException e2) {
                AbstractC0000a.m23t("getSystemProperties, e : ", e2.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodException e3) {
                AbstractC0000a.m23t("getSystemProperties, e : ", e3.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (InvocationTargetException e5) {
                AbstractC0000a.m23t("getSystemProperties, e : ", e5.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl;", "", "buildCharacteristics", "", "getBuildCharacteristics", "()Ljava/lang/String;", "salesCode", "getSalesCode", IdentityApiContract.Parameter.COUNTRY_CODE, "getCountryCode", "countryIsoCode", "getCountryIsoCode", "productCode", "getProductCode", "factoryModelName", "getFactoryModelName", "oneUIVersion", "", "getOneUIVersion", "()I", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISystemPropertiesCompatImpl {

        @NotNull
        public static final String COUNTRY_CODE_KEY = "ro.csc.countryiso_code";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String FACTORY_NAME_KEY = "ro.factory.model";
        public static final int ONE_UI_NONE = 0;

        @NotNull
        public static final String PRODUCT_CODE_KEY = "ril.product_code";

        @NotNull
        public static final String SALES_CODE_VZW = "VZW";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl$Companion;", "", "<init>", "()V", "COUNTRY_CODE_KEY", "", "PRODUCT_CODE_KEY", "FACTORY_NAME_KEY", "SALES_CODE_VZW", "ONE_UI_NONE", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String COUNTRY_CODE_KEY = "ro.csc.countryiso_code";

            @NotNull
            public static final String FACTORY_NAME_KEY = "ro.factory.model";
            public static final int ONE_UI_NONE = 0;

            @NotNull
            public static final String PRODUCT_CODE_KEY = "ril.product_code";

            @NotNull
            public static final String SALES_CODE_VZW = "VZW";

            private Companion() {
            }
        }

        @Nullable
        String getBuildCharacteristics();

        @Nullable
        String getCountryCode();

        @Nullable
        String getCountryIsoCode();

        @Nullable
        String getFactoryModelName();

        int getOneUIVersion();

        @Nullable
        String getProductCode();

        @Nullable
        String getSalesCode();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$SystemPropertiesCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl;", "<init>", "()V", "buildCharacteristics", "", "getBuildCharacteristics", "()Ljava/lang/String;", "salesCode", "getSalesCode", IdentityApiContract.Parameter.COUNTRY_CODE, "getCountryCode", "countryIsoCode", "getCountryIsoCode", "productCode", "getProductCode", "factoryModelName", "getFactoryModelName", "oneUIVersion", "", "getOneUIVersion", "()I", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class SystemPropertiesCompatPureImpl implements ISystemPropertiesCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getBuildCharacteristics() {
            try {
                Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, "ro.build.characteristics");
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                return (String) objInvoke;
            } catch (ClassNotFoundException e) {
                AbstractC0000a.m23t("getDeviceType, e : ", e.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (IllegalAccessException e2) {
                AbstractC0000a.m23t("getDeviceType, e : ", e2.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodException e3) {
                AbstractC0000a.m23t("getDeviceType, e : ", e3.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (InvocationTargetException e5) {
                AbstractC0000a.m23t("getDeviceType, e : ", e5.getMessage(), LoggerBase.INSTANCE, AbsSystemPropertiesCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getCountryCode() {
            return AbsSystemPropertiesCompatImplFactory.INSTANCE.getSystemProperties("ro.csc.countryiso_code");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getCountryIsoCode() {
            return AbsSystemPropertiesCompatImplFactory.INSTANCE.getSystemProperties("ro.csc.countryiso_code");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getFactoryModelName() {
            return DeviceInfo.getModelName();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        public int getOneUIVersion() {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getProductCode() {
            return AbsSystemPropertiesCompatImplFactory.INSTANCE.getSystemProperties("ril.product_code");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getSalesCode() {
            try {
                Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, "ro.csc.sales_code");
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                return (String) objInvoke;
            } catch (ClassNotFoundException unused) {
                LoggerBase.INSTANCE.m7133e(AbsSystemPropertiesCompatImplFactory.TAG, "fail to retrieve salesCode");
                return null;
            } catch (IllegalAccessException unused2) {
                LoggerBase.INSTANCE.m7133e(AbsSystemPropertiesCompatImplFactory.TAG, "fail to retrieve salesCode");
                return null;
            } catch (NoSuchMethodException unused3) {
                LoggerBase.INSTANCE.m7133e(AbsSystemPropertiesCompatImplFactory.TAG, "fail to retrieve salesCode");
                return null;
            } catch (InvocationTargetException unused4) {
                LoggerBase.INSTANCE.m7133e(AbsSystemPropertiesCompatImplFactory.TAG, "fail to retrieve salesCode");
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$SystemPropertiesCompatSemBaseImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$SystemPropertiesCompatPureImpl;", "<init>", "()V", "factoryModelName", "", "getFactoryModelName", "()Ljava/lang/String;", "oneUIVersion", "", "getOneUIVersion", "()I", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class SystemPropertiesCompatSemBaseImpl extends SystemPropertiesCompatPureImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getFactoryModelName() {
            return Build.VERSION.SDK_INT >= 29 ? AbsSystemPropertiesCompatImplFactory.INSTANCE.getSystemProperties("ro.factory.model") : DeviceInfo.getModelName();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        public int getOneUIVersion() {
            return SemSystemProperties.getInt("ro.build.version.oneui", 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$SystemPropertiesDelegateSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$SystemPropertiesCompatPureImpl;", "<init>", "()V", "salesCode", "", "getSalesCode", "()Ljava/lang/String;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SystemPropertiesDelegateSdlImpl extends SystemPropertiesCompatPureImpl {
        /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0067 A[RETURN] */
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String getSalesCode() {
            String str;
            File file = new File("/system/csc/sales_code.dat");
            if (file.exists()) {
                byte[] bArr = new byte[20];
                try {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            if (fileInputStream.read(bArr) > 0) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                str = new String(bArr, UTF_8);
                            } else {
                                LoggerBase.INSTANCE.m7133e(AbsSystemPropertiesCompatImplFactory.TAG, "failed to read");
                                str = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str = null;
                        }
                        try {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileInputStream, null);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(fileInputStream, th);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str = null;
                        LoggerBase.INSTANCE.m7134e(AbsSystemPropertiesCompatImplFactory.TAG, "getCSCVersion", th);
                        if (str == null) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    LoggerBase.INSTANCE.m7134e(AbsSystemPropertiesCompatImplFactory.TAG, "getCSCVersion", th);
                    if (str == null) {
                    }
                }
            } else {
                LoggerBase.INSTANCE.m7133e(AbsSystemPropertiesCompatImplFactory.TAG, "Couldn't find a CSC file");
                str = null;
            }
            if (str == null) {
                return null;
            }
            String strSubstring = str.substring(0, 3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
    }

    @JvmStatic
    @Nullable
    public static final String getSystemProperties(@Nullable String str) {
        return INSTANCE.getSystemProperties(str);
    }

    @NotNull
    public ISystemPropertiesCompatImpl create(int deviceType) {
        return deviceType == 3 ? new SystemPropertiesDelegateSdlImpl() : new SystemPropertiesCompatPureImpl();
    }
}
