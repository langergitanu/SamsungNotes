package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.VirtualScsAiServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020\u000eH\u0007J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0005H\u0003J\b\u00105\u001a\u00020\u000eH\u0003J\u0012\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020:H\u0003J\b\u0010P\u001a\u00020\u000eH\u0007J\b\u0010Q\u001a\u00020\u000eH\u0007J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\bH\u0007J\b\u0010S\u001a\u00020\u000eH\u0003J\b\u0010T\u001a\u00020\u000eH\u0007J\b\u0010U\u001a\u00020\u000eH\u0007J\u0006\u0010V\u001a\u00020\u000eJ\b\u0010W\u001a\u00020\u000eH\u0007J\u0018\u0010X\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u0005H\u0003J\b\u0010[\u001a\u00020\u000eH\u0007J\b\u0010`\u001a\u00020\u000eH\u0007J\b\u0010a\u001a\u00020\u000eH\u0007J\b\u0010b\u001a\u00020\u000eH\u0007J\b\u0010c\u001a\u00020\u000eH\u0007J\u0010\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010eH\u0007J\b\u0010f\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010 \u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010!\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010#\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010$\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010%\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0003\u001a\u0004\b-\u0010\u0018R\u001a\u0010/\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0003\u001a\u0004\b/\u0010\u0018R\u001a\u00101\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0003\u001a\u0004\b1\u0010\u0018R\u001a\u00106\u001a\u00020\u000e8BX\u0083\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0003\u001a\u0004\b6\u0010\u0018R\u001a\u0010>\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0003\u001a\u0004\b>\u0010\u0018R\u001a\u0010@\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0003\u001a\u0004\b@\u0010\u0018R\u001a\u0010B\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0003\u001a\u0004\bB\u0010\u0018R\u001a\u0010D\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0003\u001a\u0004\bD\u0010\u0018R\u001a\u0010F\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u0010\u0003\u001a\u0004\bF\u0010\u0018R\u001a\u0010H\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0003\u001a\u0004\bH\u0010\u0018R\u001a\u0010J\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bK\u0010\u0003\u001a\u0004\bJ\u0010\u0018R\u001a\u0010L\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0003\u001a\u0004\bL\u0010\u0018R\u001a\u0010N\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0003\u001a\u0004\bN\u0010\u0018R\u001a\u0010\\\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b]\u0010\u0003\u001a\u0004\b\\\u0010\u0018R\u001a\u0010^\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0003\u001a\u0004\b^\u0010\u0018¨\u0006g"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/Features;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PACKAGE_NAME_SMART_CAPTURE", "SMART_CAPTURE_DRAWING_ASSIST_MIN_VERSION_CODE", "", "PACKAGE_NAME_SKETCH_BOOK", "SKETCH_BOOK_SUPPORT_NOTE_MIN_VERSION_CODE", "SKETCH_BOOK_SUPPORT_CREATIVE_STUDIO_MIN_VERSION_CODE", "SKETCH_BOOK_SUPPORT_CREATIVE_STUDIO_FEATURES_MIN_VERSION_CODE", "sIsSepModel", "", "sIsSupportGlobalSettingPermission", "sIsOndeviceSummarySupportAiOneUIVersion", "sIsSupportAiOneUIVersion", "sIsSupportDrawingToolkitOneUIVersion", "sIsC2PASupportOneUiVersion", "sIsAudioEraserSupportOneUiVersion", "sIsQuickToolsSupportOneUiVersion", "sIsSemanticSearchSupportOneUiVersion", "getSIsSemanticSearchSupportOneUiVersion", "()Z", "sIsCreativeStudioSupportOneUiVersion", "sIsSupportAiFunction", "Ljava/lang/Boolean;", "sIsSupportSTTFunction", "sIsSupportSTTSummaryGroupBySubject", "sIsSupportOnDeviceSummaryFunction", "sIsSupportsOngoingActivityNotification", "sIsSupportTranslateFunction", "sIsSupportSketchToImageFunction", "sIsSupportDrawingToolkitFunction", "sIsSupportC2PAFunction", "sIsSupportAudioEraserFunction", "sIsSupportAutoTranscribeFunction", "OFFLINE_LANGUAGE_MODEL_APP_INFO", "OFFLINE_LANGUAGE_MODEL_FUNC_INFO", "META_FUNCTION", "FUNCTION", "DEFAULT_DESIGN_STUDIO_FEATURES", "META_DESIGN_STUDIO_FEATURES", "toggleSupportGlobalSettingPermission", "isSupportAiFunction", "isSupportAiFunction$annotations", "isSupportImageTranslationFunction", "isSupportImageTranslationFunction$annotations", "isSupportNeuralTranslationFunction", "isSupportNeuralTranslationFunction$annotations", "isScsFeatureAvailable", "featureName", "isOnDeviceSummaryFeatureAvailable", "isSupportedDeviceMode", "isSupportedDeviceMode$annotations", "supportSystemAiPermission", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "getRequestSystemAiPermission", "Landroid/content/Intent;", "context", "isSupportSTTFunction", "isSupportSTTFunction$annotations", "isSupportOnDeviceSummaryFunction", "isSupportOnDeviceSummaryFunction$annotations", "isSupportsOngoingActivityNotification", "isSupportsOngoingActivityNotification$annotations", "isSupportSTTAutoDetectLanguage", "isSupportSTTAutoDetectLanguage$annotations", "isQuickToolsSupported", "isQuickToolsSupported$annotations", "isSupportSTTSummaryGroupBySubject", "isSupportSTTSummaryGroupBySubject$annotations", "isSupportSketchToImageFunction", "isSupportSketchToImageFunction$annotations", "isSupportDrawingAssistFunction", "isSupportDrawingAssistFunction$annotations", "isSupportC2PAFunction", "isSupportC2PAFunction$annotations", "isDrawingSupportSmartCaptureInstalled", "isDrawingSupportSketchBookInstalled", "minVersionCode", "isAiDrawingSupportedAiConfigVersion", "isC2PASupportedAiConfigVersion", "isWritingToolkitSupportedAiConfigVersion", "isSummaryGroupBySubjectSupportedAiConfigVersion", "isSearchEngineConnected", "checkAiConfigVersion", "checkVersion", NotesConstants.KEY_CALLER, "isVirtualScsInstalled", "isSupportAudioEraserFunction", "isSupportAudioEraserFunction$annotations", "isSupportAutoTranscribeFunction", "isSupportAutoTranscribeFunction$annotations", "isAutoTranscribeEnable", "isSupportSimpleComposerForCoverDisplay", "isCreativeStudioSupported", "isCreativeStudioSupportedAiConfigVersion", "getCreativeStudioMetaData", "", "isVexScanSupportedAiConfigVersion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Features {

    @NotNull
    public static final String DEFAULT_DESIGN_STUDIO_FEATURES = "wallpaper,sticker,profile card,invitation,greeting card";

    @NotNull
    public static final String FUNCTION = "Summary";

    @NotNull
    public static final String META_DESIGN_STUDIO_FEATURES = "designStudioFeatures";

    @NotNull
    public static final String META_FUNCTION = "supportFunction";

    @NotNull
    public static final String OFFLINE_LANGUAGE_MODEL_APP_INFO = "com.samsung.android.offline.languagemodel";

    @NotNull
    public static final String OFFLINE_LANGUAGE_MODEL_FUNC_INFO = "com.samsung.android.offline.languagemodel.FUNCTION_INFO";

    @NotNull
    public static final String PACKAGE_NAME_SKETCH_BOOK = "com.samsung.android.app.sketchbook";

    @NotNull
    public static final String PACKAGE_NAME_SMART_CAPTURE = "com.samsung.android.app.smartcapture";
    public static final int SKETCH_BOOK_SUPPORT_CREATIVE_STUDIO_FEATURES_MIN_VERSION_CODE = 122000000;
    public static final int SKETCH_BOOK_SUPPORT_CREATIVE_STUDIO_MIN_VERSION_CODE = 121400000;
    public static final int SKETCH_BOOK_SUPPORT_NOTE_MIN_VERSION_CODE = 111700000;
    private static final int SMART_CAPTURE_DRAWING_ASSIST_MIN_VERSION_CODE = 584304000;

    @NotNull
    private static final String TAG = "Ai$Features";
    private static boolean sIsAudioEraserSupportOneUiVersion;
    private static boolean sIsC2PASupportOneUiVersion;
    private static final boolean sIsCreativeStudioSupportOneUiVersion;
    private static boolean sIsOndeviceSummarySupportAiOneUIVersion;
    private static boolean sIsQuickToolsSupportOneUiVersion;
    private static final boolean sIsSemanticSearchSupportOneUiVersion;

    @Nullable
    private static Boolean sIsSupportAiFunction;
    private static boolean sIsSupportAiOneUIVersion;

    @Nullable
    private static Boolean sIsSupportAudioEraserFunction;
    private static boolean sIsSupportAutoTranscribeFunction;

    @Nullable
    private static Boolean sIsSupportC2PAFunction;

    @Nullable
    private static Boolean sIsSupportDrawingToolkitFunction;
    private static boolean sIsSupportDrawingToolkitOneUIVersion;

    @Nullable
    private static Boolean sIsSupportOnDeviceSummaryFunction;

    @Nullable
    private static Boolean sIsSupportSTTFunction;

    @Nullable
    private static Boolean sIsSupportSTTSummaryGroupBySubject;

    @Nullable
    private static Boolean sIsSupportSketchToImageFunction;

    @Nullable
    private static Boolean sIsSupportTranslateFunction;

    @Nullable
    private static Boolean sIsSupportsOngoingActivityNotification;

    @NotNull
    public static final Features INSTANCE = new Features();
    private static final boolean sIsSepModel = DeviceUtils.isSepModel(BaseUtils.getApplicationContext());
    private static boolean sIsSupportGlobalSettingPermission = supportSystemAiPermission(BaseUtils.getApplicationContext());

    static {
        SystemPropertiesCompat.Companion companion = SystemPropertiesCompat.INSTANCE;
        sIsOndeviceSummarySupportAiOneUIVersion = companion.getInstance().getOneUIVersion() >= 70000;
        sIsSupportAiOneUIVersion = companion.getInstance().getOneUIVersion() >= 60100;
        sIsSupportDrawingToolkitOneUIVersion = companion.getInstance().getOneUIVersion() >= 80000;
        sIsC2PASupportOneUiVersion = companion.getInstance().getOneUIVersion() >= 70000;
        sIsAudioEraserSupportOneUiVersion = companion.getInstance().getOneUIVersion() >= 80000;
        sIsQuickToolsSupportOneUiVersion = companion.getInstance().getOneUIVersion() >= 80000;
        sIsSemanticSearchSupportOneUiVersion = companion.getInstance().getOneUIVersion() >= 80500;
        sIsCreativeStudioSupportOneUiVersion = companion.getInstance().getOneUIVersion() >= 80500;
        Feature feature = Feature.INSTANCE;
        sIsSupportAiFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportSTTFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportSTTSummaryGroupBySubject = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportOnDeviceSummaryFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportsOngoingActivityNotification = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportTranslateFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportSketchToImageFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportDrawingToolkitFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportC2PAFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportAudioEraserFunction = feature.getIS_SUPPORT_AI_FUNCTION_DEFAULT();
        sIsSupportAutoTranscribeFunction = feature.getIS_SUPPORT_AUTO_TRANSCRIBE();
    }

    private Features() {
    }

    @JvmStatic
    private static final boolean checkAiConfigVersion(int checkVersion, String caller) {
        Integer configAiVersion = FloatingFeature.INSTANCE.getInstance().getConfigAiVersion();
        if (configAiVersion == null) {
            Logger.m8698e(TAG, "checkAiConfigVersion, caller: " + caller + ", configAiVersion is invalid");
            return false;
        }
        boolean z = checkVersion <= configAiVersion.intValue();
        StringBuilder sbM780v = AbstractC0541b.m780v("checkAiConfigVersion, caller: ", checkVersion, caller, ", checkVersion(", ") <= configAiVersion(");
        sbM780v.append(configAiVersion);
        sbM780v.append("), isSupportedVersion: ");
        sbM780v.append(z);
        Logger.m8697d(TAG, sbM780v.toString());
        return z;
    }

    @JvmStatic
    @Nullable
    public static final List<String> getCreativeStudioMetaData() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            if (!isDrawingSupportSketchBookInstalled(SKETCH_BOOK_SUPPORT_CREATIVE_STUDIO_FEATURES_MIN_VERSION_CODE)) {
                Logger.m8697d(TAG, "getCreativeStudioMetaData, isFeaturesSupported is false");
                return StringsKt__StringsKt.split$default(DEFAULT_DESIGN_STUDIO_FEATURES, new String[]{","}, false, 0, 6, (Object) null);
            }
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(PACKAGE_NAME_SKETCH_BOOK, 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString(META_DESIGN_STUDIO_FEATURES);
                    Logger.m8697d(TAG, "getCreativeStudioMetaData, features : " + string);
                    List<String> listSplit$default = string != null ? StringsKt__StringsKt.split$default(string, new String[]{","}, false, 0, 6, (Object) null) : null;
                    Intrinsics.checkNotNull(listSplit$default, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    return listSplit$default;
                }
            } catch (PackageManager.NameNotFoundException e) {
                AbstractC4539a.m3214x("getCreativeStudioMetaData# e : ", e.getMessage(), TAG);
                return null;
            }
        }
        return null;
    }

    @JvmStatic
    private static final Intent getRequestSystemAiPermission(Context context) {
        Intent intent = new Intent("com.samsung.android.settings.action.INTELLIGENCE_SERVICE_SETTINGS");
        intent.putExtra("key_calling_package", context.getPackageName());
        intent.setPackage("com.android.settings");
        return intent;
    }

    @JvmStatic
    private static final boolean isAiDrawingSupportedAiConfigVersion() {
        if (!FloatingFeature.INSTANCE.getInstance().isAiSupported()) {
            Logger.m8697d(TAG, "isAiDrawingSupportedAiConfigVersion, isAiSupported is false");
            return false;
        }
        if (Build.VERSION.SDK_INT > 34) {
            return checkAiConfigVersion(FloatingFeature.AI_CONFIG_VERSION_20242, "isAiDrawingSupportedAiConfigVersion");
        }
        Logger.m8697d(TAG, "isAiDrawingSupportedAiConfigVersion, do not check config version under u os");
        return true;
    }

    @JvmStatic
    public static final boolean isAutoTranscribeEnable() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE, false) && isSupportAutoTranscribeFunction();
    }

    @JvmStatic
    public static final boolean isC2PASupportedAiConfigVersion() {
        if (!FloatingFeature.INSTANCE.getInstance().isAiSupported()) {
            Logger.m8697d(TAG, "isC2PASupportedAiConfigVersion, isAiSupported is false");
            return false;
        }
        if (Build.VERSION.SDK_INT > 34) {
            return checkAiConfigVersion(20251, "isC2PASupportedAiConfigVersion");
        }
        Logger.m8697d(TAG, "isC2PASupportedAiConfigVersion, do not check config version under u os");
        return false;
    }

    @JvmStatic
    public static final boolean isCreativeStudioSupported() {
        return isCreativeStudioSupportedAiConfigVersion() && isDrawingSupportSketchBookInstalled(SKETCH_BOOK_SUPPORT_CREATIVE_STUDIO_MIN_VERSION_CODE);
    }

    @JvmStatic
    public static final boolean isCreativeStudioSupportedAiConfigVersion() {
        if (!FloatingFeature.INSTANCE.getInstance().isAiSupported()) {
            Logger.m8697d(TAG, "isCreativeStudioSupportedAiConfigVersion, isAiSupported is false");
            return false;
        }
        if (Build.VERSION.SDK_INT > 34) {
            return sIsCreativeStudioSupportOneUiVersion && checkAiConfigVersion(FloatingFeature.AI_CONFIG_VERSION_20261, "isCreativeStudioSupportedAiConfigVersion");
        }
        Logger.m8697d(TAG, "isCreativeStudioSupportedAiConfigVersion, do not check config version under u os");
        return false;
    }

    @JvmStatic
    public static final boolean isDrawingSupportSketchBookInstalled() {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(BaseUtils.getApplicationContext(), PACKAGE_NAME_SKETCH_BOOK);
    }

    @JvmStatic
    public static final boolean isDrawingSupportSmartCaptureInstalled() {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(BaseUtils.getApplicationContext(), PACKAGE_NAME_SMART_CAPTURE, SMART_CAPTURE_DRAWING_ASSIST_MIN_VERSION_CODE);
    }

    @JvmStatic
    private static final boolean isOnDeviceSummaryFeatureAvailable() {
        Context applicationContext;
        boolean z = false;
        try {
            applicationContext = BaseUtils.getApplicationContext();
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC4539a.m3214x("isOnDeviceSummaryFeatureAvailable# e : ", e.getMessage(), TAG);
        } catch (JSONException e2) {
            AbstractC4539a.m3214x("isOnDeviceSummaryFeatureAvailable# e : ", e2.getMessage(), TAG);
        }
        if (applicationContext == null) {
            return false;
        }
        ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(OFFLINE_LANGUAGE_MODEL_APP_INFO, 128);
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null) {
            Logger.m8698e(TAG, "isOnDeviceSummaryFeatureAvailable# metaData null");
            return false;
        }
        JSONArray jSONArray = new JSONArray(bundle.getString(OFFLINE_LANGUAGE_MODEL_FUNC_INFO));
        int length = jSONArray.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String string = jSONArray.getJSONObject(i).getString(META_FUNCTION);
            Intrinsics.checkNotNull(string);
            if (StringsKt.m14162r(string, FUNCTION)) {
                z = true;
                break;
            }
            i++;
        }
        Logger.m8697d(TAG, "isOnDeviceSummaryFeatureAvailable# isSupport : " + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized boolean isQuickToolsSupported() {
        boolean z;
        if (!sIsQuickToolsSupportOneUiVersion || !DeviceUtils.isTabletModel()) {
            z = false;
        } else if (DeviceUtils.isSpenModel()) {
            z = true;
        }
        return z;
    }

    @JvmStatic
    public static /* synthetic */ void isQuickToolsSupported$annotations() {
    }

    @JvmStatic
    private static final boolean isScsFeatureAvailable(String featureName) {
        Logger.m8702i(TAG, "check SCS feature " + featureName);
        int iCheckFeature = Feature.checkFeature(BaseUtils.getApplicationContext(), featureName);
        if (iCheckFeature == 0) {
            Logger.m8702i(TAG, "You can invoke the feature");
            return true;
        }
        if (iCheckFeature == 5) {
            Logger.m8703w(TAG, "The feature is not available on the device. It might be SepLite device.");
            return false;
        }
        if (iCheckFeature == 8) {
            return false;
        }
        if (iCheckFeature == 2) {
            Logger.m8698e(TAG, "Please show UI for SCS enable");
            return false;
        }
        if (iCheckFeature == 3) {
            Logger.m8698e(TAG, "Please show UI for SCS update");
            return false;
        }
        Logger.m8698e(TAG, "unexpected status: " + iCheckFeature);
        return false;
    }

    @JvmStatic
    public static final boolean isSearchEngineConnected() {
        return sIsSepModel && sIsSemanticSearchSupportOneUiVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x000f, B:26:0x006c, B:13:0x0019, B:15:0x001f, B:17:0x0027, B:19:0x0037, B:21:0x005e, B:25:0x0065, B:27:0x0070, B:29:0x007a), top: B:34:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized boolean isSupportAiFunction() {
        boolean zAreEqual;
        try {
            if (sIsSupportAiFunction == null) {
                if (sIsSupportAiOneUIVersion || DeviceInfo.isVSTModel()) {
                    if (isSupportedDeviceMode() && isScsFeatureAvailable("FEATURE_AI_GEN_SUMMARY") && !UserManagerCompat.INSTANCE.getInstance().isDigitalLegacyMode(BaseUtils.getApplicationContext())) {
                        Logger.m8702i(TAG, "isSupportAiFunction# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                        sIsSupportAiFunction = Boolean.valueOf(FloatingFeature.INSTANCE.getInstance().isAiSupported() && sIsSupportGlobalSettingPermission);
                    } else {
                        sIsSupportAiFunction = Boolean.FALSE;
                    }
                }
            }
            zAreEqual = Intrinsics.areEqual(sIsSupportAiFunction, Boolean.TRUE);
            if (!zAreEqual) {
                Logger.m8697d(TAG, "isSupportAiFunction# isSupportAiFunction : " + sIsSupportAiFunction);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zAreEqual;
    }

    @JvmStatic
    public static /* synthetic */ void isSupportAiFunction$annotations() {
    }

    public static final synchronized boolean isSupportAudioEraserFunction() {
        Boolean bool;
        try {
            if (sIsSupportAudioEraserFunction == null) {
                Logger.m8702i(TAG, "isSupportAudioEraserFunction# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                sIsSupportAudioEraserFunction = Boolean.valueOf(sIsAudioEraserSupportOneUiVersion && VoiceManager.isAudioEraserSupported());
            }
            bool = sIsSupportAudioEraserFunction;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportAudioEraserFunction$annotations() {
    }

    public static final synchronized boolean isSupportAutoTranscribeFunction() {
        return sIsSupportAutoTranscribeFunction;
    }

    @JvmStatic
    public static /* synthetic */ void isSupportAutoTranscribeFunction$annotations() {
    }

    public static final synchronized boolean isSupportC2PAFunction() {
        Boolean bool;
        try {
            if (sIsSupportC2PAFunction == null) {
                Logger.m8702i(TAG, "isSupportC2PAFunction# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                sIsSupportC2PAFunction = Boolean.valueOf(sIsC2PASupportOneUiVersion && isScsFeatureAvailable("FEATURE_C2PA") && isC2PASupportedAiConfigVersion() && FloatingFeature.INSTANCE.getInstance().isC2paSupported());
            }
            bool = sIsSupportC2PAFunction;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportC2PAFunction$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0028, B:22:0x004c, B:23:0x004e, B:13:0x0031, B:15:0x003a, B:17:0x0040, B:21:0x0047, B:24:0x0050), top: B:29:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized boolean isSupportDrawingAssistFunction() {
        Boolean bool;
        Boolean boolValueOf;
        try {
            if (sIsSupportDrawingToolkitFunction == null) {
                Logger.m8702i(TAG, "isSupportDrawingAssistFunction# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                if (sIsSupportDrawingToolkitOneUIVersion || DeviceInfo.isVSTModel()) {
                    if (isDrawingSupportSketchBookInstalled(SKETCH_BOOK_SUPPORT_NOTE_MIN_VERSION_CODE)) {
                        boolValueOf = Boolean.valueOf(isAiDrawingSupportedAiConfigVersion() && sIsSupportGlobalSettingPermission);
                    } else {
                        boolValueOf = Boolean.FALSE;
                    }
                    sIsSupportDrawingToolkitFunction = boolValueOf;
                }
            }
            bool = sIsSupportDrawingToolkitFunction;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportDrawingAssistFunction$annotations() {
    }

    public static final boolean isSupportImageTranslationFunction() {
        return isScsFeatureAvailable("FEATURE_NEURAL_TRANSLATION_CLEAR_WITH_SOURCE_ID");
    }

    @JvmStatic
    public static /* synthetic */ void isSupportImageTranslationFunction$annotations() {
    }

    public static final boolean isSupportNeuralTranslationFunction() {
        if (sIsSupportTranslateFunction == null) {
            sIsSupportTranslateFunction = Boolean.valueOf(isScsFeatureAvailable("FEATURE_NEURAL_TRANSLATION"));
        }
        Boolean bool = sIsSupportTranslateFunction;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportNeuralTranslationFunction$annotations() {
    }

    public static final synchronized boolean isSupportOnDeviceSummaryFunction() {
        Boolean bool;
        try {
            if (sIsSupportOnDeviceSummaryFunction == null) {
                sIsSupportOnDeviceSummaryFunction = Boolean.FALSE;
            }
            bool = sIsSupportOnDeviceSummaryFunction;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportOnDeviceSummaryFunction$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized boolean isSupportSTTAutoDetectLanguage() {
        boolean z;
        try {
            if (sIsSupportAiOneUIVersion || DeviceInfo.isVSTModel()) {
                if (isSupportSTTFunction()) {
                    z = isScsFeatureAvailable("FEATURE_SPEECH_LOCALE_RECOGNITION");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    @JvmStatic
    public static /* synthetic */ void isSupportSTTAutoDetectLanguage$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x000d, B:28:0x0071, B:13:0x0016, B:15:0x001c, B:17:0x0024, B:19:0x002c, B:21:0x003c, B:23:0x0063, B:27:0x006a, B:29:0x0075), top: B:34:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized boolean isSupportSTTFunction() {
        Boolean bool;
        try {
            if (sIsSupportSTTFunction == null) {
                if (sIsSupportAiOneUIVersion || DeviceInfo.isVSTModel()) {
                    if (isSupportedDeviceMode() && isScsFeatureAvailable("FEATURE_SPEECH_RECOGNITION") && isScsFeatureAvailable("FEATURE_SPEAKER_DIARISATION") && !UserManagerCompat.INSTANCE.getInstance().isDigitalLegacyMode(BaseUtils.getApplicationContext())) {
                        Logger.m8702i(TAG, "isSupportSTTFunction# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                        sIsSupportSTTFunction = Boolean.valueOf(FloatingFeature.INSTANCE.getInstance().isAiSupported() && sIsSupportGlobalSettingPermission);
                    } else {
                        sIsSupportSTTFunction = Boolean.FALSE;
                    }
                }
            }
            bool = sIsSupportSTTFunction;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportSTTFunction$annotations() {
    }

    public static final synchronized boolean isSupportSTTSummaryGroupBySubject() {
        Boolean bool;
        try {
            if (sIsSupportSTTSummaryGroupBySubject == null) {
                Logger.m8702i(TAG, "isSupportSTTSummaryBy# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                sIsSupportSTTSummaryGroupBySubject = Boolean.valueOf(sIsSupportAiOneUIVersion && !DeviceInfo.isVSTModel() && isSupportSTTFunction() && isScsFeatureAvailable("FEATURE_SPEECH_LOCALE_RECOGNITION") && INSTANCE.isSummaryGroupBySubjectSupportedAiConfigVersion());
            }
            bool = sIsSupportSTTSummaryGroupBySubject;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportSTTSummaryGroupBySubject$annotations() {
    }

    @JvmStatic
    public static final boolean isSupportSimpleComposerForCoverDisplay() {
        boolean isB7Device = ModelFeature.getFeature().getIsB7Device();
        boolean zIsDeviceFolded = DeviceUtils.isDeviceFolded();
        Logger.m8697d(TAG, "isSupportSimpleComposerForSubDisplay# isSupportDevice : " + isB7Device + ", isSupportState : " + zIsDeviceFolded);
        return isB7Device && zIsDeviceFolded;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0028, B:22:0x004b, B:23:0x004d, B:13:0x0031, B:15:0x0039, B:17:0x003f, B:21:0x0046, B:24:0x004f), top: B:29:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized boolean isSupportSketchToImageFunction() {
        Boolean bool;
        Boolean boolValueOf;
        try {
            if (sIsSupportSketchToImageFunction == null) {
                Logger.m8702i(TAG, "isSupportSketchToImageFunction# oneUiVersion : " + SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion());
                if (sIsSupportAiOneUIVersion || DeviceInfo.isVSTModel()) {
                    if (isScsFeatureAvailable("FEATURE_SKETCH_TO_IMAGE")) {
                        boolValueOf = Boolean.valueOf(isAiDrawingSupportedAiConfigVersion() && sIsSupportGlobalSettingPermission);
                    } else {
                        boolValueOf = Boolean.FALSE;
                    }
                    sIsSupportSketchToImageFunction = boolValueOf;
                }
            }
            bool = sIsSupportSketchToImageFunction;
            Intrinsics.checkNotNull(bool);
        } catch (Throwable th) {
            throw th;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportSketchToImageFunction$annotations() {
    }

    private static final boolean isSupportedDeviceMode() {
        return DeviceUtils.INSTANCE.isSupportedAccount(BaseUtils.getApplicationContext());
    }

    @JvmStatic
    private static /* synthetic */ void isSupportedDeviceMode$annotations() {
    }

    public static final synchronized boolean isSupportsOngoingActivityNotification() {
        Boolean bool = sIsSupportsOngoingActivityNotification;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        try {
            Class.forName("android.app.Notification$OngoingActivityStyle");
            sIsSupportsOngoingActivityNotification = Boolean.valueOf(SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000);
        } catch (ClassNotFoundException e) {
            Logger.m8698e(TAG, "Unsupported OngoingActivityNotification: " + e.getMessage());
            sIsSupportsOngoingActivityNotification = Boolean.FALSE;
        }
        Boolean bool2 = sIsSupportsOngoingActivityNotification;
        Intrinsics.checkNotNull(bool2);
        return bool2.booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isSupportsOngoingActivityNotification$annotations() {
    }

    @JvmStatic
    public static final boolean isVexScanSupportedAiConfigVersion() {
        return checkAiConfigVersion(FloatingFeature.AI_CONFIG_VERSION_20261, "isVexScanSupportedAiConfigVersion");
    }

    @JvmStatic
    public static final boolean isVirtualScsInstalled() {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(BaseUtils.getApplicationContext(), VirtualScsAiServiceConstants.SERVICE_PACKAGE);
    }

    @JvmStatic
    public static final boolean isWritingToolkitSupportedAiConfigVersion() {
        return checkAiConfigVersion(20251, "isWritingToolkitSupportedAiConfigVersion");
    }

    @JvmStatic
    public static final boolean supportSystemAiPermission(@Nullable Context appContext) {
        if (appContext == null) {
            return false;
        }
        boolean z = getRequestSystemAiPermission(appContext).resolveActivity(appContext.getPackageManager()) != null;
        Logger.m8697d(TAG, "supportSystemAiPermission# " + z);
        return z;
    }

    @JvmStatic
    public static final synchronized boolean toggleSupportGlobalSettingPermission() {
        boolean z;
        z = !sIsSupportGlobalSettingPermission;
        sIsSupportGlobalSettingPermission = z;
        sIsSupportAiOneUIVersion = true;
        sIsSupportAiFunction = null;
        return z;
    }

    public final boolean getSIsSemanticSearchSupportOneUiVersion() {
        return sIsSemanticSearchSupportOneUiVersion;
    }

    public final boolean isSummaryGroupBySubjectSupportedAiConfigVersion() {
        if (!FloatingFeature.INSTANCE.getInstance().isAiSupported()) {
            Logger.m8697d(TAG, "isSummaryGroupBySubjectSupportedAiConfigVersion, isAiSupported is false");
            return false;
        }
        if (Build.VERSION.SDK_INT > 34) {
            return checkAiConfigVersion(20251, "isSummaryGroupBySubjectSupportedAiConfigVersion");
        }
        Logger.m8697d(TAG, "isSummaryGroupBySubjectSupportedAiConfigVersion, do not check config version under u os");
        return false;
    }

    @JvmStatic
    public static final boolean isDrawingSupportSketchBookInstalled(int minVersionCode) {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(BaseUtils.getApplicationContext(), PACKAGE_NAME_SKETCH_BOOK, minVersionCode);
    }
}
