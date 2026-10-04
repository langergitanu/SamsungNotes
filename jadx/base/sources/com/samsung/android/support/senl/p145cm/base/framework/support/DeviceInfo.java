package com.samsung.android.support.senl.p145cm.base.framework.support;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.sem.support.DeviceInfoImpl;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\b\u00101\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0014\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b!\u0010\u0017R*\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00058F@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010(R\u0012\u0010)\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010*\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010+\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0003\u001a\u0004\b+\u0010\u0017R\u001a\u0010-\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0003\u001a\u0004\b-\u0010\u0017R\u001a\u0010/\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0003\u001a\u0004\b/\u0010\u0017R\u001a\u00103\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0003\u001a\u0004\b3\u0010\u0017¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/DeviceInfo;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEVICE_TYPE_PURE", "", "DEVICE_TYPE_SEM", "DEVICE_TYPE_SDL", "DEVICE_TYPE_VST", "SEP_11_0", "SEP_11_5", "SEP_13_1", "SEP_14_0", "SEP_15_1", "SEM_INT", "Ljava/lang/Integer;", "SEM_PLATFORM_INT", "mIsSdlDevice", "isSemDevice", "", "isSemDevice$annotations", "()Z", "getSemAPIVersionInt", "defaultVersion", "isSdlDevice", "isSdlDevice$annotations", HandoffConstant.KEY_DEVICE_TYPE, "getDeviceType$annotations", "getDeviceType", "()I", "misOtherCorpDevice", "isOtherCorpDevice", "isOtherCorpDevice$annotations", "getSemPlatformVersionInt", "value", IdentityApiContract.Parameter.MODEL_NAME, "getModelName$annotations", "getModelName", "()Ljava/lang/String;", "BinaryMode", "BinaryModeExt", "isUserMode", "isUserMode$annotations", "isEngMode", "isEngMode$annotations", "isUserDebugMode", "isUserDebugMode$annotations", "checkBinaryMode", "", "isVSTModel", "isVSTModel$annotations", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeviceInfo {

    @Nullable
    private static Integer BinaryMode = null;

    @Nullable
    private static Integer BinaryModeExt = null;
    public static final int DEVICE_TYPE_PURE = 1;
    public static final int DEVICE_TYPE_SDL = 3;
    public static final int DEVICE_TYPE_SEM = 2;
    public static final int DEVICE_TYPE_VST = 4;

    @Nullable
    private static Integer SEM_INT = null;

    @Nullable
    private static Integer SEM_PLATFORM_INT = null;
    public static final int SEP_11_0 = 110000;
    public static final int SEP_11_5 = 110500;
    public static final int SEP_13_1 = 130100;
    public static final int SEP_14_0 = 140000;
    public static final int SEP_15_1 = 150100;

    @NotNull
    private static final String TAG = "DeviceInfo";
    private static int misOtherCorpDevice;

    @Nullable
    private static String modelName;

    @NotNull
    public static final DeviceInfo INSTANCE = new DeviceInfo();
    private static int mIsSdlDevice = -1;

    static {
        try {
            SEM_INT = Integer.valueOf(Build.VERSION.class.getField("SEM_INT").getInt(Build.VERSION.class));
            SEM_PLATFORM_INT = Integer.valueOf(Build.VERSION.class.getField("SEM_PLATFORM_INT").getInt(Build.VERSION.class));
        } catch (IllegalAccessException e) {
            AbstractC0000a.m23t("DeviceInfo, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        } catch (NoSuchFieldException e2) {
            AbstractC0000a.m23t("DeviceInfo, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        misOtherCorpDevice = -1;
    }

    private DeviceInfo() {
    }

    private final void checkBinaryMode() {
        String str = Build.TYPE;
        if (str == null) {
            BinaryMode = null;
            BinaryModeExt = null;
        } else if (Intrinsics.areEqual(IdentityApiContract.Token.USER, str)) {
            BinaryMode = 1;
            BinaryModeExt = 1;
        } else if (Intrinsics.areEqual("eng", str)) {
            BinaryMode = 2;
            BinaryModeExt = 2;
        } else {
            BinaryMode = 0;
            BinaryModeExt = Intrinsics.areEqual("userdebug", str) ? 3 : BinaryMode;
        }
    }

    public static final int getDeviceType() {
        if (isVSTModel()) {
            return 4;
        }
        if (isSemDevice()) {
            return 2;
        }
        return isSdlDevice() ? 3 : 1;
    }

    @Nullable
    public static final String getModelName() {
        String str = modelName;
        if (str != null) {
            return str;
        }
        String str2 = Build.MODEL;
        modelName = str2;
        return str2;
    }

    @JvmStatic
    public static final int getSemAPIVersionInt(int defaultVersion) {
        if (!isSemDevice()) {
            return defaultVersion;
        }
        Integer num = SEM_INT;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @JvmStatic
    public static final int getSemPlatformVersionInt(int defaultVersion) {
        Integer num = SEM_PLATFORM_INT;
        Integer numValueOf = Integer.valueOf(defaultVersion);
        if (num == null) {
            num = numValueOf;
        }
        Intrinsics.checkNotNullExpressionValue(num, "requireNonNullElse(...)");
        return num.intValue();
    }

    public static final boolean isEngMode() {
        if (BinaryMode == null) {
            INSTANCE.checkBinaryMode();
        }
        Integer num = BinaryMode;
        return (num == null || num == null || num.intValue() != 2) ? false : true;
    }

    public static final boolean isOtherCorpDevice() {
        if (misOtherCorpDevice == -1) {
            if (isSemDevice() || isSdlDevice() || isVSTModel()) {
                misOtherCorpDevice = 0;
            } else {
                misOtherCorpDevice = 1;
            }
        }
        return misOtherCorpDevice == 1;
    }

    public static final boolean isSdlDevice() {
        if (mIsSdlDevice == -1) {
            try {
                Class.forName("com.sec.android.secmediarecorder.SecMediaRecorder");
                mIsSdlDevice = 1;
            } catch (Error unused) {
                mIsSdlDevice = 0;
            } catch (Exception unused2) {
                mIsSdlDevice = 0;
            }
        }
        return mIsSdlDevice == 1;
    }

    public static final boolean isSemDevice() {
        return SEM_INT != null;
    }

    public static final boolean isUserDebugMode() {
        if (BinaryModeExt == null) {
            INSTANCE.checkBinaryMode();
        }
        Integer num = BinaryModeExt;
        return (num == null || num == null || num.intValue() != 3) ? false : true;
    }

    public static final boolean isUserMode() {
        if (BinaryMode == null) {
            INSTANCE.checkBinaryMode();
        }
        Integer num = BinaryMode;
        return (num == null || num == null || num.intValue() != 1) ? false : true;
    }

    public static final boolean isVSTModel() {
        return DeviceInfoImpl.INSTANCE.isVSTModel();
    }

    @JvmStatic
    public static /* synthetic */ void getDeviceType$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getModelName$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isEngMode$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isOtherCorpDevice$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isSdlDevice$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isSemDevice$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isUserDebugMode$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isUserMode$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isVSTModel$annotations() {
    }
}
