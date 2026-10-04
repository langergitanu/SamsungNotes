package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsSystemPropertiesCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.SystemPropertiesCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 02\u00020\u0001:\u0002/0B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b \u0010\u000fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001dR\u0011\u0010'\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b(\u0010\u001dR\u0011\u0010)\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001dR\u0011\u0010*\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\u0011\u0010+\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001dR\u0011\u0010,\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001dR\u0011\u0010.\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b.\u0010\u001d¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl;)V", "mDeviceType", "Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat$DeviceType;", HandoffConstant.KEY_DEVICE_TYPE, "getDeviceType", "()Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat$DeviceType;", "mSalesCode", "", "salesCode", "getSalesCode", "()Ljava/lang/String;", "value", IdentityApiContract.Parameter.COUNTRY_CODE, "getCountryCode", "countryIsoCode", "getCountryIsoCode", "productCode", "getProductCode", "factoryName", "getFactoryName", "mIsTestBuild", "", "Ljava/lang/Boolean;", "isSystemTestBuild", "()Z", "mDeviceColorCode", "deviceColorCode", "getDeviceColorCode", "mOneUIVersion", "", "oneUIVersion", "getOneUIVersion", "()I", "isLDUModel", "isChinaLDU", "isNationalDisasterNet", "isChinaModel", "isKoreaModel", "isJapanModel", "isUSAModel", "isVZWModel", "isOmcByod", "DeviceType", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemPropertiesCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int ONE_UI_4_1 = 40100;
    public static final int ONE_UI_5_1 = 50100;
    public static final int ONE_UI_5_1_1 = 50101;
    public static final int ONE_UI_6_0 = 60000;
    public static final int ONE_UI_6_1 = 60100;
    public static final int ONE_UI_6_1_1 = 60101;
    public static final int ONE_UI_7_0 = 70000;
    public static final int ONE_UI_8_0 = 80000;
    public static final int ONE_UI_8_5 = 80500;

    @NotNull
    private static final String TAG = "SystemPropertiesCompat";

    @Nullable
    private static SystemPropertiesCompat mInstance;

    @Nullable
    private String countryCode;

    @Nullable
    private String countryIsoCode;

    @Nullable
    private String factoryName;

    @Nullable
    private String mDeviceColorCode;

    @Nullable
    private DeviceType mDeviceType;

    @NotNull
    private final AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl mImpl;

    @Nullable
    private Boolean mIsTestBuild;
    private int mOneUIVersion;

    @Nullable
    private String mSalesCode;

    @Nullable
    private String productCode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ONE_UI_4_1", "", "ONE_UI_5_1", "ONE_UI_5_1_1", "ONE_UI_6_0", "ONE_UI_6_1", "ONE_UI_6_1_1", "ONE_UI_7_0", "ONE_UI_8_0", "ONE_UI_8_5", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SystemPropertiesCompat getInstance() {
            SystemPropertiesCompat systemPropertiesCompat;
            try {
                if (SystemPropertiesCompat.mInstance == null) {
                    SystemPropertiesCompat.mInstance = new SystemPropertiesCompat(new SystemPropertiesCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                systemPropertiesCompat = SystemPropertiesCompat.mInstance;
                Intrinsics.checkNotNull(systemPropertiesCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.os.SystemPropertiesCompat");
            } catch (Throwable th) {
                throw th;
            }
            return systemPropertiesCompat;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/SystemPropertiesCompat$DeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "phone", "tablet", "other", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DeviceType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeviceType[] $VALUES;
        public static final DeviceType phone = new DeviceType("phone", 0);
        public static final DeviceType tablet = new DeviceType("tablet", 1);
        public static final DeviceType other = new DeviceType("other", 2);

        private static final /* synthetic */ DeviceType[] $values() {
            return new DeviceType[]{phone, tablet, other};
        }

        static {
            DeviceType[] deviceTypeArr$values = $values();
            $VALUES = deviceTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(deviceTypeArr$values);
        }

        private DeviceType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<DeviceType> getEntries() {
            return $ENTRIES;
        }

        public static DeviceType valueOf(String str) {
            return (DeviceType) Enum.valueOf(DeviceType.class, str);
        }

        public static DeviceType[] values() {
            return (DeviceType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ SystemPropertiesCompat(AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl iSystemPropertiesCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSystemPropertiesCompatImpl);
    }

    @Nullable
    public final String getCountryCode() {
        String str = this.countryCode;
        if (str != null) {
            return str;
        }
        String countryCode = this.mImpl.getCountryCode();
        this.countryCode = countryCode;
        if (countryCode == null) {
            this.countryCode = "";
        }
        return this.countryCode;
    }

    @Nullable
    public final String getCountryIsoCode() {
        String str = this.countryIsoCode;
        if (str != null) {
            return str;
        }
        String countryIsoCode = this.mImpl.getCountryIsoCode();
        this.countryIsoCode = countryIsoCode;
        if (countryIsoCode == null) {
            this.countryIsoCode = "";
        }
        return this.countryIsoCode;
    }

    @Nullable
    public final String getDeviceColorCode() {
        String str = this.mDeviceColorCode;
        if (str != null) {
            return str;
        }
        String productCode = INSTANCE.getInstance().getProductCode();
        if (productCode == null || productCode.length() <= 10) {
            AbstractC0000a.m23t("getDeviceColorCode# productCode has problem.", productCode, LoggerBase.INSTANCE, TAG);
        } else {
            String strSubstring = productCode.substring(8, 10);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            this.mDeviceColorCode = strSubstring;
        }
        return this.mDeviceColorCode;
    }

    @Nullable
    public final DeviceType getDeviceType() {
        DeviceType deviceType = this.mDeviceType;
        if (deviceType != null) {
            return deviceType;
        }
        this.mDeviceType = DeviceType.other;
        String buildCharacteristics = this.mImpl.getBuildCharacteristics();
        if (buildCharacteristics != null) {
            LoggerBase.INSTANCE.m7132d(TAG, "getDeviceType, deviceType : ".concat(buildCharacteristics));
            this.mDeviceType = StringsKt.m14162r(buildCharacteristics, "tablet") ? DeviceType.tablet : DeviceType.phone;
        }
        return this.mDeviceType;
    }

    @Nullable
    public final String getFactoryName() {
        String str = this.factoryName;
        if (str != null) {
            return str;
        }
        String factoryModelName = this.mImpl.getFactoryModelName();
        this.factoryName = factoryModelName;
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        if (factoryModelName == null) {
            factoryModelName = "null";
        }
        companion.m7132d(TAG, "getFactoryName : ".concat(factoryModelName));
        if (this.factoryName == null) {
            this.factoryName = "";
        }
        return this.factoryName;
    }

    public final int getOneUIVersion() {
        int i = this.mOneUIVersion;
        if (i > -1) {
            return i;
        }
        int oneUIVersion = this.mImpl.getOneUIVersion();
        this.mOneUIVersion = oneUIVersion;
        if (oneUIVersion == 0) {
            LoggerBase.INSTANCE.m7133e(TAG, "fail to retrieve oneUIVersion. oneUIVersion is none");
        }
        return this.mOneUIVersion;
    }

    @Nullable
    public final String getProductCode() {
        String str = this.productCode;
        if (str != null) {
            return str;
        }
        String productCode = this.mImpl.getProductCode();
        this.productCode = productCode;
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        if (productCode == null) {
            productCode = "null";
        }
        companion.m7132d(TAG, "getProductCode : ".concat(productCode));
        if (this.productCode == null) {
            this.productCode = "";
        }
        return this.productCode;
    }

    @NotNull
    public final String getSalesCode() {
        String str = this.mSalesCode;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        String salesCode = this.mImpl.getSalesCode();
        this.mSalesCode = salesCode;
        if (salesCode == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "fail to retrieve salesCode. salesCode is null");
            this.mSalesCode = "";
        }
        String str2 = this.mSalesCode;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public final boolean isChinaLDU() {
        return Intrinsics.areEqual("CHINA", getCountryCode()) && Intrinsics.areEqual("PAP", getSalesCode());
    }

    public final boolean isChinaModel() {
        return StringsKt__StringsJVMKt.equals(Constants.ISO_CODE_CN, getCountryIsoCode(), true);
    }

    public final boolean isJapanModel() {
        String countryIsoCode = getCountryIsoCode();
        return StringsKt__StringsJVMKt.equals("JAPAN", countryIsoCode, true) || StringsKt__StringsJVMKt.equals("JP", countryIsoCode, true);
    }

    public final boolean isKoreaModel() {
        String countryIsoCode = getCountryIsoCode();
        return StringsKt__StringsJVMKt.equals("KOREA", countryIsoCode, true) || StringsKt__StringsJVMKt.equals("KR", countryIsoCode, true);
    }

    public final boolean isLDUModel() {
        return false;
    }

    public final boolean isNationalDisasterNet() {
        return StringsKt__StringsJVMKt.equals("K06", getSalesCode(), true);
    }

    public final boolean isOmcByod() {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, "persist.sys.omc_byod", Boolean.FALSE);
            if (objInvoke instanceof Boolean) {
                return Intrinsics.areEqual(Boolean.TRUE, objInvoke);
            }
            return false;
        } catch (ClassNotFoundException e) {
            AbstractC0000a.m23t("fail to retrieve OmcByod#", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        } catch (IllegalAccessException e2) {
            AbstractC0000a.m23t("fail to retrieve OmcByod#", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        } catch (NoSuchMethodException e3) {
            AbstractC0000a.m23t("fail to retrieve OmcByod#", e3.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        } catch (InvocationTargetException e5) {
            AbstractC0000a.m23t("fail to retrieve OmcByod#", e5.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    public final boolean isSystemTestBuild() {
        if (this.mIsTestBuild == null) {
            this.mIsTestBuild = Boolean.valueOf(Intrinsics.areEqual("1", AbsSystemPropertiesCompatImplFactory.INSTANCE.getSystemProperties("sysperf.bvt.activate")));
        }
        Boolean bool = this.mIsTestBuild;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final boolean isUSAModel() {
        return StringsKt__StringsJVMKt.equals(AbstractDevicePopManager.CertificateProperties.COUNTRY, getCountryIsoCode(), true);
    }

    public final boolean isVZWModel() {
        return Intrinsics.areEqual("VZW", getSalesCode());
    }

    private SystemPropertiesCompat(AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl iSystemPropertiesCompatImpl) {
        this.mImpl = iSystemPropertiesCompatImpl;
        this.mOneUIVersion = -1;
    }
}
