package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslatorCommonHelper {
    private static final String ACTION_SSS_TRANSLATE = "sec.intent.action.TRANSLATE";
    public static final String EXTRA_KEY_TRANSLATED_TEXT = "translatedText";
    private static final String EXTRA_KEY_TRANSLATION_RESULT = "needsTranslatedTextResult";
    public static final int PARCEL_SAFE_TEXT_LENGTH = 100000;
    private static final String TAG = Logger.createTag("TranslatorCommonHelper", AiConstants.PREFIX_TAG);
    private static final String TRANSLATOR_PACKAGE_NAME_SSS = "com.samsung.android.app.interpreter";
    private static String mCommonTranslatorPackageName;

    public static boolean checkLimitation(Context context, String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length > 10000) {
            AiCommonUtil.showCustomToast(context, context.getResources().getString(C9086R.string.ai_error_cant_traslate_in_text_with_more_than));
            return false;
        }
        if (length >= 1) {
            return true;
        }
        AiCommonUtil.showCustomToast(context, context.getString(C9086R.string.ai_error_can_not_find_any_text));
        return false;
    }

    public static Intent createCommonTranslatorIntent(String str) {
        return new Intent().setPackage(TRANSLATOR_PACKAGE_NAME_SSS).setAction(ACTION_SSS_TRANSLATE).putExtra("android.intent.extra.TEXT", str);
    }

    public static Intent enableGettingResult(Intent intent, boolean z) {
        if (z) {
            Logger.m11003i(TAG, "enableGettingResult# isResult = true");
            intent.putExtra(EXTRA_KEY_TRANSLATION_RESULT, true);
        }
        return intent;
    }

    public static Intent getIntentForCommonTranslator(String str) {
        return createCommonTranslatorIntent(UnicodeUtils.removeObjectReplacementChar(str));
    }

    public static String getPackageNameCommonTranslator() {
        return mCommonTranslatorPackageName;
    }

    public static String preProcess(String str) {
        String strReplaceAll = str.trim().replaceAll("\r\n|\n+", "\n");
        StringBuilder sb = new StringBuilder(str.length());
        if (!strReplaceAll.isEmpty()) {
            sb.append(strReplaceAll.charAt(0));
        }
        for (int i = 1; i < strReplaceAll.length(); i++) {
            char cCharAt = strReplaceAll.charAt(i);
            char cCharAt2 = strReplaceAll.charAt(i - 1);
            if (cCharAt != '\n' || cCharAt2 == '.') {
                sb.append(cCharAt);
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void setPackageNameCommonTranslator(String str) {
        mCommonTranslatorPackageName = str;
    }
}
