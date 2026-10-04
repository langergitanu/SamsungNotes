package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FeatureInfo {
    public static final boolean ADD_TO_NEW_NOTE_WITH_PDF_TRANSLATION_FOR_NORMAL_NOTE = false;
    public static final boolean AI_ASSIST_CONTINUES = true;
    public static final boolean AI_ASSIST_STT_TRANSCRIBE = true;
    public static final boolean AI_INCLUDE_SOLVE_MATH = false;
    public static final boolean AI_START_AUTO = true;
    public static final boolean AI_SUGGESTION = true;
    public static final boolean COEDIT_DARK_THEME_OFF = true;
    public static final boolean COEDIT_DISALLOW_ANCHOR_TO_TEXT = false;
    public static final boolean COEDIT_DOWNLOAD_PDF_SIZE_LIMIT = true;
    public static final boolean COEDIT_MULTIPLE_PDF_ENABLED = false;
    public static final boolean COEDIT_VOICE_RECORDING_ENABLED = false;
    public static final boolean COMPOSER_TOOLBAR_BACKGROUND_COLOR = false;
    public static final boolean COMPOSER_WINDOW_INSETS_ANIMATION_WITH_SIP = true;
    public static final boolean CONFLICT_COMPARE_ENABLED = true;
    public static final boolean CONFLICT_MERGE_ENABLED = false;
    public static final boolean CONFLICT_SHOW_VIEW_COMPARE_ENABLED = false;
    public static final boolean COVER_STICKER_DOWNLOAD_ENABLED = false;
    public static final boolean DARK_MODE_COLOR_ENABLED = false;
    public static final boolean ENABLE_DA_DELTA_FOR_USA_MODEL = false;
    public static final boolean ENABLE_FAB_LONG_PRESS = true;
    public static final boolean ENABLE_HYPER_TEXT_IN_EDIT_MODE = true;
    private static final boolean ENABLE_QUICK_TOOL = true;
    public static final boolean INSERT_CONVERT_SPEECH_TO_TEXT_ENABLED = false;
    public static final boolean NEW_COVER_EDITOR_ENABLED = true;
    public static final boolean PDF_OVERLAY_BOTTOM_MENU = false;
    public static final boolean PDF_OVERLAY_STREAMING_UPDATE = false;
    public static final boolean PDF_OVERLAY_STREAMING_UPDATE_SEQUENTIAL_MODE = true;
    public static final boolean PDF_VECTOR_ENABLED = true;
    public static final boolean SELECTION_ANCHOR_CHANGE_STYLE_ENABLED = false;
    public static final boolean SHORTCUT_NEW_FEATURE_ENABLED = true;
    public static final boolean SMART_PEN_ENABLED = false;
    public static final boolean STICKY_NOTE_ENABLED = true;
    public static final boolean STT_EDIT_ENABLED = true;
    public static final boolean STT_SEARCH_IN_COMPOSER = false;
    public static final boolean SUPPORT_A4_LANDSCAPE = true;
    public static final boolean SUPPORT_FAVORITE_TEXT_STYLE = false;
    public static final boolean SUPPORT_SPEN_BUTTON_FOR_MATH = false;
    public static final boolean SUPPORT_TEXT_FORMAT = true;
    public static final boolean SUPPORT_VEX_SCANNER = true;
    public static final boolean TABLET_PAGE_LIST_SLIDE = false;
    public static final boolean TEXT_ONLY_MODE_ENABLED = false;
    public static final boolean USE_CORE_TRANSLATE_IN_TEXTVIEW = true;
    public static final boolean USE_TEXT_TO_HANDWRITING = false;
    private static final String VEX_SCANNER_PACKAGE_NAME = "com.samsung.android.app.vex.scanner";
    public static final boolean VOICE_RECORDER_SAVE_TO_DEVICE = false;
    private static final boolean mIsMdeEnabled = false;
    private static final String TAG = Logger.createTag("FeatureInfo");
    private static Boolean mScanTextEnabled = null;
    public static Boolean mBeautifierFeatureForceEnabled = null;

    public static boolean isActionLinkEnabled(Context context) {
        boolean z = RecognitionUtil.isSupported(context) && PackageManagerCompat.INSTANCE.getInstance().isSupportedActionLink(context) && DeviceUtils.isSpenModel() && SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ACTION_ICONS, true);
        AbstractC8014b.m7220v("stateEnableActionLinkFunc# : ", TAG, z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean isAiDrawingS2IEnabled() {
        boolean z;
        if (Features.isSupportAiFunction()) {
            z = Features.isSupportSketchToImageFunction();
        }
        return z;
    }

    public static synchronized boolean isAiFeatureEnabled() {
        return Features.isSupportAiFunction();
    }

    public static boolean isBeautifierFeatureEnabled() {
        if (mBeautifierFeatureForceEnabled == null) {
            mBeautifierFeatureForceEnabled = Boolean.valueOf(SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 50101);
        }
        return mBeautifierFeatureForceEnabled.booleanValue();
    }

    public static synchronized boolean isCreateImageEnabled() {
        return isAiDrawingS2IEnabled();
    }

    public static boolean isEnabledEasyWritingPad(Context context) {
        boolean zIsNotDexModeOrStandAloneMode = DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(context);
        AbstractC8014b.m7220v("isEnabledEasyWritingPad# : ", TAG, zIsNotDexModeOrStandAloneMode);
        return zIsNotDexModeOrStandAloneMode;
    }

    public static boolean isEnabledQuickTool() {
        return Features.isQuickToolsSupported();
    }

    public static synchronized boolean isEnabledScanText() {
        try {
            if (mScanTextEnabled == null) {
                FloatingFeature.Companion companion = FloatingFeature.INSTANCE;
                String string = companion.getInstance().getString("SEC_FLOATING_FEATURE_CAMERA_CONFIG_STRIDE_OCR_VERSION", "");
                if (TextUtils.isEmpty(string)) {
                    mScanTextEnabled = Boolean.valueOf(companion.getInstance().getBoolean("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_EAGLE_EYE"));
                } else if ("None".equals(string)) {
                    mScanTextEnabled = Boolean.FALSE;
                } else {
                    mScanTextEnabled = Boolean.TRUE;
                }
            }
            Logger.m11003i(TAG, "isEnabledScanText# : " + mScanTextEnabled);
        } catch (Throwable th) {
            throw th;
        }
        return mScanTextEnabled.booleanValue();
    }

    public static boolean isHandwritingHelpEnabled(Context context) {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() > 60100 && RecognitionUtil.isSupported(context);
    }

    public static boolean isHashTagFeatureEnabled() {
        boolean zIsKnoxMode = UserHandleCompat.getInstance().isKnoxMode();
        boolean zIsSecureFolderMode = UserHandleCompat.getInstance().isSecureFolderMode();
        boolean z = (zIsKnoxMode || zIsSecureFolderMode) ? false : true;
        String str = TAG;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("isHashTagFeatureEnabled# mIsHashTagEnabled : ", " <= ", " , ", z, zIsKnoxMode);
        sbM2230u.append(zIsSecureFolderMode);
        sbM2230u.append(" , false");
        Logger.m10999d(str, sbM2230u.toString());
        return z;
    }

    public static synchronized boolean isNeedNoticeSolveMath() {
        return false;
    }

    public static boolean isNotEnabledDeltaDA() {
        return Build.VERSION.SDK_INT > 34;
    }

    public static boolean isOneTouchPdfTranslationOverlayEnabled() {
        return Features.isSupportNeuralTranslationFunction() && Build.VERSION.SDK_INT > 34;
    }

    public static boolean isPdfImageTranslationSupported() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() > 60100 && Features.isSupportImageTranslationFunction();
    }

    public static boolean isSearchSTTInComposerEnabled() {
        return false;
    }

    public static boolean isShowOptionToMovePenToolsEnabled() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, true);
    }

    public static boolean isSoftInputModeAdjustResizeEnabled() {
        return Build.VERSION.SDK_INT < 35;
    }

    public static synchronized boolean isSolveMathEnabled() {
        return FeatureUtils.isSolveMathSupported();
    }

    public static boolean isSummaryOnDeviceMode() {
        return AiActionStatus.isSummaryOnDeviceFeatureEnable();
    }

    public static boolean isSupportAudioEraserFunction() {
        return Features.isSupportAudioEraserFunction();
    }

    public static boolean isSupportBackgroundBlurDialog() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80000;
    }

    public static boolean isSupportDynamicTemplate() {
        return false;
    }

    public static boolean isSupportHyperLinkEdit() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000;
    }

    public static boolean isSupportHyperTextInEditMode() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000;
    }

    public static synchronized boolean isSupportNeuralTranslationFunction() {
        return Features.isSupportNeuralTranslationFunction();
    }

    public static boolean isSupportPdfTranslationOverlayFloatingToolbar() {
        return DeviceUtils.isTabletModel() && SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80000;
    }

    public static boolean isSupportSTTFunction() {
        return Features.isSupportSTTFunction();
    }

    public static boolean isSupportSTTSummaryGroupBySubject() {
        return Features.isSupportSTTSummaryGroupBySubject();
    }

    public static boolean isSupportTranslationLanguageAutoDetectingEffect() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500;
    }

    public static boolean isTextOnlyEnabledFeature() {
        return false;
    }

    public static boolean isVSTModel() {
        return DeviceInfo.isVSTModel();
    }

    public static boolean isVexScanSupported(Context context) {
        return Features.isVexScanSupportedAiConfigVersion() && PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(context, "com.samsung.android.app.vex.scanner");
    }

    public static boolean isVoiceRecorderOngoingActivityNotification() {
        return Features.isSupportsOngoingActivityNotification();
    }

    public static boolean isWindowInsetsAnimationWithSipEnabled() {
        return Build.VERSION.SDK_INT >= 30;
    }
}
