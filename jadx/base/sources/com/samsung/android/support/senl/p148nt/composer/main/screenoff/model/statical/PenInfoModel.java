package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenPairedColorModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u0016\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u000fJ\u0006\u00109\u001a\u00020)J\u0010\u0010:\u001a\u00020)2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u00106\u001a\u00020\rH\u0002J\u0010\u0010<\u001a\u00020)2\u0006\u00107\u001a\u00020\u000fH\u0002J\u0012\u0010=\u001a\u00020)2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010>\u001a\u00020\u000fH\u0002J\b\u0010?\u001a\u00020\rH\u0002J\b\u0010@\u001a\u00020\u000fH\u0002J\n\u0010A\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010B\u001a\u00020)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001e\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR$\u00101\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u00104R\u0011\u00107\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b8\u0010\u001d¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenInfoModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PEN_GARAGE_POSITION_RIGHT_MODEL_NAMES", "", "[Ljava/lang/String;", "FILE_PATH_PEN_GARAGE_POSITION", "SEM_SPEN_WRITING_COLOR_SWITCH", "SEM_SPEN_WRITING_COLOR", "DEFAULT_PEN_SIZE", "", "DEFAULT_PEN_SIZE_LEVEL", "", "mContentResolver", "Landroid/content/ContentResolver;", "value", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "spenSettingPenInfo", "getSpenSettingPenInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "", "enabledWritingColorSwitch", "getEnabledWritingColorSwitch", "()Z", "currentPairedColor", "getCurrentPairedColor", "()I", "currentPairedColorCode", "getCurrentPairedColorCode", "()Ljava/lang/String;", "savedPairedColorCode", "getSavedPairedColorCode", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenInfoModel$PEN_POSITION_TYPE;", "penPositionType", "getPenPositionType", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenInfoModel$PEN_POSITION_TYPE;", "isPreInitialized", "init", "", "context", "Landroid/content/Context;", "initPairedColorCode", "initCurrentPairedColor", "initSettingPenInfo", "initPenPositionType", "isRightPenPositionType", "color", "getColor", "setColor", "(I)V", "setSize", "size", "sizeLevel", "getSizeLevel", "saveData", "saveColorData", "saveSizeData", "saveSizeLevelData", "savePairedColorCode", "loadColorData", "loadSizeData", "loadSizeLevelData", "loadPairedColorCode", "release", "PEN_POSITION_TYPE", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenInfoModel {
    private static final float DEFAULT_PEN_SIZE = 11.0f;
    private static final int DEFAULT_PEN_SIZE_LEVEL = 24;

    @NotNull
    private static final String FILE_PATH_PEN_GARAGE_POSITION = "/sys/class/sec/sec_epen/input/device/of_node/wacom,spen_garage_pos";

    @NotNull
    private static final String SEM_SPEN_WRITING_COLOR = "spen_writing_color";

    @NotNull
    private static final String SEM_SPEN_WRITING_COLOR_SWITCH = "spen_writing_color_switch";
    private static int currentPairedColor;

    @Nullable
    private static String currentPairedColorCode;
    private static boolean enabledWritingColorSwitch;
    private static boolean isPreInitialized;

    @Nullable
    private static ContentResolver mContentResolver;

    @Nullable
    private static String savedPairedColorCode;

    @Nullable
    private static SpenSettingUIPenInfo spenSettingPenInfo;

    @NotNull
    public static final PenInfoModel INSTANCE = new PenInfoModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("PenInfoModel");

    @NotNull
    private static final String[] PEN_GARAGE_POSITION_RIGHT_MODEL_NAMES = {"N97", "N77", "SCV45", "SC-01M", "N96", "SCV40", "SC-01L", "N95", "SCV37", "SC-01K", "N93", "SCV34", "SC-01J", "N92", "N91"};

    @NotNull
    private static PEN_POSITION_TYPE penPositionType = PEN_POSITION_TYPE.LEFT;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenInfoModel$PEN_POSITION_TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PEN_POSITION_TYPE {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PEN_POSITION_TYPE[] $VALUES;
        public static final PEN_POSITION_TYPE LEFT = new PEN_POSITION_TYPE("LEFT", 0);
        public static final PEN_POSITION_TYPE RIGHT = new PEN_POSITION_TYPE("RIGHT", 1);

        private static final /* synthetic */ PEN_POSITION_TYPE[] $values() {
            return new PEN_POSITION_TYPE[]{LEFT, RIGHT};
        }

        static {
            PEN_POSITION_TYPE[] pen_position_typeArr$values = $values();
            $VALUES = pen_position_typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pen_position_typeArr$values);
        }

        private PEN_POSITION_TYPE(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PEN_POSITION_TYPE> getEntries() {
            return $ENTRIES;
        }

        public static PEN_POSITION_TYPE valueOf(String str) {
            return (PEN_POSITION_TYPE) Enum.valueOf(PEN_POSITION_TYPE.class, str);
        }

        public static PEN_POSITION_TYPE[] values() {
            return (PEN_POSITION_TYPE[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PenPairedColorModel.PAIRED_COLOR_TYPE.values().length];
            try {
                iArr[PenPairedColorModel.PAIRED_COLOR_TYPE.DEVICE_COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PenPairedColorModel.PAIRED_COLOR_TYPE.PEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PenInfoModel() {
    }

    private final void initCurrentPairedColor() {
        Integer num;
        Integer num2;
        String str;
        HashMap<String, Integer> pairedColorSet;
        int iIntValue = 0;
        try {
            PenPairedColorModel penPairedColorModel = PenPairedColorModel.INSTANCE;
            int i = WhenMappings.$EnumSwitchMapping$0[penPairedColorModel.getPairedColorType().ordinal()];
            if (i == 1) {
                String deviceColorCode = SystemPropertiesCompat.INSTANCE.getInstance().getDeviceColorCode();
                SOLogger.INSTANCE.SOLoggerD(TAG, "initCurrentPairedColor# deviceColorCode : ".concat(deviceColorCode == null ? "is null" : deviceColorCode));
                if (deviceColorCode != null) {
                    currentPairedColorCode = deviceColorCode;
                } else {
                    currentPairedColorCode = Constants.PairedColorCode.DEFAULT;
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!enabledWritingColorSwitch || (str = currentPairedColorCode) == null || ((str != null && str.length() == 0) || ((pairedColorSet = penPairedColorModel.getPairedColorSet()) != null && !pairedColorSet.containsKey(currentPairedColorCode)))) {
                    currentPairedColorCode = Constants.PairedColorCode.DEFAULT;
                }
            }
            SOLogger.INSTANCE.SOLoggerD(TAG, "initCurrentPairedColor# colorCode : " + currentPairedColorCode);
            HashMap<String, Integer> pairedColorSet2 = penPairedColorModel.getPairedColorSet();
            currentPairedColor = (pairedColorSet2 == null || (num2 = pairedColorSet2.get(currentPairedColorCode)) == null) ? 0 : num2.intValue();
        } catch (Exception e) {
            AbstractC0000a.m24u("initCurrentPairedColor# error ", e.getMessage(), SOLogger.INSTANCE, TAG);
            currentPairedColorCode = Constants.PairedColorCode.DEFAULT;
            HashMap<String, Integer> pairedColorSet3 = PenPairedColorModel.INSTANCE.getPairedColorSet();
            if (pairedColorSet3 != null && (num = pairedColorSet3.get(currentPairedColorCode)) != null) {
                iIntValue = num.intValue();
            }
            currentPairedColor = iIntValue;
        }
    }

    private final void initPairedColorCode() {
        enabledWritingColorSwitch = Settings.System.getInt(mContentResolver, SEM_SPEN_WRITING_COLOR_SWITCH, 1) > 0;
        currentPairedColorCode = Settings.System.getString(mContentResolver, SEM_SPEN_WRITING_COLOR);
        savedPairedColorCode = loadPairedColorCode();
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPairedColorCode# enabledWritingColorSwitch/currentPairedColorCode/savedPairedColorCode " + enabledWritingColorSwitch + "/" + currentPairedColorCode + "/" + savedPairedColorCode);
    }

    private final void initPenPositionType() throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(FILE_PATH_PEN_GARAGE_POSITION));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr, 0, fileInputStream.available());
            fileInputStream.close();
            String str = new String(bArr, Charsets.UTF_8);
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str2 = TAG;
            sOLogger.SOLoggerD(str2, "initPenPositionType# str.charAt(0) " + str.charAt(0));
            if ('1' == str.charAt(0)) {
                sOLogger.SOLoggerD(str2, "initPenPositionType# left");
                penPositionType = PEN_POSITION_TYPE.LEFT;
            } else {
                sOLogger.SOLoggerD(str2, "initPenPositionType# right");
                penPositionType = PEN_POSITION_TYPE.RIGHT;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            SOLogger.INSTANCE.SOLoggerE(TAG, "initPenPositionType# " + e.getMessage());
            if (isRightPenPositionType()) {
                penPositionType = PEN_POSITION_TYPE.RIGHT;
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    AbstractC0000a.m24u("initPenPositionType# ", e3.getMessage(), SOLogger.INSTANCE, TAG);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    AbstractC0000a.m24u("initPenPositionType# ", e5.getMessage(), SOLogger.INSTANCE, TAG);
                }
            }
            throw th;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPenPositionType# model/mPenPositionType : " + Build.MODEL + "/" + penPositionType);
    }

    private final void initSettingPenInfo() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
        spenSettingUIPenInfo.isDpSize = true;
        spenSettingUIPenInfo.color = loadColorData();
        spenSettingUIPenInfo.size = loadSizeData();
        spenSettingUIPenInfo.sizeLevel = loadSizeLevelData();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        sOLogger.SOLoggerD(str, "initSettingPenInfo# color/size/sizeLevel " + AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(16777215 & spenSettingUIPenInfo.color)}, 1, "format(...)") + "/" + spenSettingUIPenInfo.size + "/" + spenSettingUIPenInfo.sizeLevel);
        spenSettingPenInfo = spenSettingUIPenInfo;
    }

    private final boolean isRightPenPositionType() {
        try {
            String modelName = DeviceInfo.getModelName();
            SOLogger.INSTANCE.SOLoggerD(TAG, "isRightPenPositionType# modelName ".concat(modelName == null ? "null" : modelName));
            if (!DeviceUtils.isTabletModel()) {
                for (String str : PEN_GARAGE_POSITION_RIGHT_MODEL_NAMES) {
                    if (modelName == null || !StringsKt.m14162r(modelName, str)) {
                    }
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            AbstractC0000a.m24u("isRightPenPositionType# ", e.getMessage(), SOLogger.INSTANCE, TAG);
            return false;
        }
    }

    private final int loadColorData() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        if (companion.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).contains(Constants.Preference.PREF_KEY_PEN_COLOR)) {
            return companion.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).getColor(Constants.Preference.PREF_KEY_PEN_COLOR, C9086R.color.screenoff_pen_color_default);
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & currentPairedColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        sOLogger.SOLoggerD(str, "loadColorData# not contains ".concat(str2));
        return currentPairedColor;
    }

    private final String loadPairedColorCode() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).getString(Constants.Preference.PREF_KEY_SAVED_PAIRED_COLOR_CODE, Constants.PairedColorCode.DEFAULT);
    }

    private final float loadSizeData() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).getFloat(Constants.Preference.PREF_KEY_PEN_SIZE, DEFAULT_PEN_SIZE);
    }

    private final int loadSizeLevelData() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).getInt(Constants.Preference.PREF_KEY_PEN_SIZE_LEVEL, 24);
    }

    private final void saveColorData(int color) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).putInt(Constants.Preference.PREF_KEY_PEN_COLOR, color);
    }

    private final void savePairedColorCode(String currentPairedColorCode2) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).putString(Constants.Preference.PREF_KEY_SAVED_PAIRED_COLOR_CODE, currentPairedColorCode2);
    }

    private final void saveSizeData(float size) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).putFloat(Constants.Preference.PREF_KEY_PEN_SIZE, size);
    }

    private final void saveSizeLevelData(int sizeLevel) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SPEN_SETTINGS_PREF).putInt(Constants.Preference.PREF_KEY_PEN_SIZE_LEVEL, sizeLevel);
    }

    public final int getColor() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = spenSettingPenInfo;
        if (spenSettingUIPenInfo != null) {
            return spenSettingUIPenInfo.color;
        }
        return 0;
    }

    public final int getCurrentPairedColor() {
        return currentPairedColor;
    }

    @Nullable
    public final String getCurrentPairedColorCode() {
        return currentPairedColorCode;
    }

    public final boolean getEnabledWritingColorSwitch() {
        return enabledWritingColorSwitch;
    }

    @NotNull
    public final PEN_POSITION_TYPE getPenPositionType() {
        return penPositionType;
    }

    @Nullable
    public final String getSavedPairedColorCode() {
        return savedPairedColorCode;
    }

    public final int getSizeLevel() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = spenSettingPenInfo;
        if (spenSettingUIPenInfo != null) {
            return spenSettingUIPenInfo.sizeLevel;
        }
        return 0;
    }

    @Nullable
    public final SpenSettingUIPenInfo getSpenSettingPenInfo() {
        return spenSettingPenInfo;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isPreInitialized = true;
        mContentResolver = context.getContentResolver();
        initPairedColorCode();
        initCurrentPairedColor();
        initSettingPenInfo();
        initPenPositionType();
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        isPreInitialized = false;
        mContentResolver = null;
        saveData();
    }

    public final void saveData() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = spenSettingPenInfo;
        if (spenSettingUIPenInfo == null) {
            return;
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        sOLogger.SOLoggerD(str, "saveData# color/size/sizeLevel " + AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(16777215 & spenSettingUIPenInfo.color)}, 1, "format(...)") + "/" + spenSettingUIPenInfo.size + "/" + spenSettingUIPenInfo.sizeLevel);
        saveColorData(spenSettingUIPenInfo.color);
        saveSizeData(spenSettingUIPenInfo.size);
        saveSizeLevelData(spenSettingUIPenInfo.sizeLevel);
        savePairedColorCode(currentPairedColorCode);
    }

    public final void setColor(int i) {
        SpenSettingUIPenInfo spenSettingUIPenInfo = spenSettingPenInfo;
        if (spenSettingUIPenInfo != null) {
            spenSettingUIPenInfo.color = i;
        }
        saveColorData(i);
    }

    public final void setSize(float size, int sizeLevel) {
        SpenSettingUIPenInfo spenSettingUIPenInfo = spenSettingPenInfo;
        if (spenSettingUIPenInfo != null) {
            spenSettingUIPenInfo.size = size;
        }
        if (spenSettingUIPenInfo != null) {
            spenSettingUIPenInfo.sizeLevel = sizeLevel;
        }
        saveSizeData(size);
        saveSizeLevelData(sizeLevel);
    }
}
