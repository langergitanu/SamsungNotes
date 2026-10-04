package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.Utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class IntentParser {
    private static final String TAG = Logger.createTag("IntentParser");
    public static final String TYPE_TEXT_PLAIN = "text/plain";

    public static String getExtraText(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        return !TextUtils.isEmpty(charSequenceExtra) ? charSequenceExtra.toString() : "";
    }

    public static boolean hasCalculate(Intent intent) {
        return intent.getBooleanExtra("poc_for_calculate", false);
    }

    private static boolean hasContentsExtra(Intent intent) {
        if (!intent.hasExtra(ComposerConstants.ACTION_SEND_ADDITION)) {
            return false;
        }
        String str = TAG;
        Logger.m11003i(str, "handleAdditionalData# package = " + intent.getStringExtra(ComposerConstants.ACTION_SEND_ADDITION));
        if (intent.hasExtra(ComposerConstants.CONTENT_TYPE)) {
            return true;
        }
        Logger.m11000e(str, "handleAdditionalData# can't get content_type");
        return false;
    }

    public static boolean hasWebAppCard(Intent intent) {
        if (!hasContentsExtra(intent) || !ComposerConstants.TYPE_APP_CARD.equals(intent.getStringExtra(ComposerConstants.CONTENT_TYPE))) {
            return false;
        }
        Logger.m11003i(TAG, "hasWebAppCard# contentType : TYPE_APP_CARD ");
        return true;
    }

    public static boolean hasWebCard(Intent intent) {
        String type;
        if (!"android.intent.action.SEND".equals(intent.getAction()) || (type = intent.getType()) == null || !type.startsWith("text/plain")) {
            return false;
        }
        String extraText = getExtraText(intent);
        if (TextUtils.isEmpty(extraText) || hasWebClip(intent)) {
            return false;
        }
        return Utils.getWebUrlPattern().matcher(removeUnicodeObj(extraText)).find();
    }

    public static boolean hasWebClip(Intent intent) {
        if (!hasContentsExtra(intent) || !ComposerConstants.TYPE_WEB_CLIP.equals(intent.getStringExtra(ComposerConstants.CONTENT_TYPE))) {
            return false;
        }
        Logger.m11003i(TAG, "handleAdditionalData# TYPE_WEB_CLIP ");
        return true;
    }

    public static String removeUnicodeObj(@NonNull String str) {
        return UnicodeUtils.removeObjectReplacementChar(str);
    }
}
