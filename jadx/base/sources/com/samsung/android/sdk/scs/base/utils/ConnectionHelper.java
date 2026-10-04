package com.samsung.android.sdk.scs.base.utils;

import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ConnectionHelper {
    public static Intent getC2PAServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_CONTENT_AUTHENTICATION_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES);
    }

    public static Intent getDownloadCoreServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_DOWNLOAD_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_AICORE_SERVICES);
    }

    public static Intent getDownloadServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_DOWNLOAD_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES);
    }

    public static Intent getImageEditorServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_IMAGE_EDITOR_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES);
    }

    public static Intent getNaturalLanguageServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_TEXT_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
    }

    public static Intent getPortraitServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_PORTRAIT_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES);
    }

    public static Intent getPrerequisiteServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_PREREQUISITE_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES);
    }

    public static Intent getSuggestionServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_SUGGESTION_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
    }

    public static Intent getTextToSpeechServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_TEXT_TO_SPEECH_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    public static Intent getTextToSpeechServiceIntentForExternal() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_TEXT_TO_SPEECH_SERVICE_FOR_EXTERNAL, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    public static Intent getTranslationServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_TRANSLATION_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    public static Intent getTranslationServiceIntentForExternal() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_TRANSLATION_SERVICE_FOR_EXTERNAL, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    public static Intent getVisionServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_VISION_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
    }

    public static Intent getWallpaperServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_WALLPAPER_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_AICORE_SERVICES);
    }
}
