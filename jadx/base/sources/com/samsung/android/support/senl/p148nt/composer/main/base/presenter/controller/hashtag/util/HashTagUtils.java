package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.HashTagHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagUtils {
    private static final String KEY_WORD = "keyword";
    private static final String TAG = "HashTagUtils";
    private static final String TAG_SERVICE_PKG = "com.samsung.android.service.tagservice";
    private static final String TAG_SERVICE_TAG_BOARD_CLASS = "com.samsung.android.service.tagservice.ui.tagboard.TagBoardMainActivity";
    private static final String TAG_SERVICE_TAG_EDITOR_CLASS = "com.samsung.android.service.tagservice.ui.tageditor.TagEditorActivity";
    private static boolean sInitialized;
    private static boolean sIsSupportedTagService;

    public static int containsIgnoreCase(List<TagData> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    public static String convertByFilter(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!HashTagHelper.isSpecialCharacter(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static Intent getIntentToTagBoardActivity(Context context, String str) {
        if (!CommonUtils.isPackageInstalledAndEnabled(context, TAG_SERVICE_PKG)) {
            return null;
        }
        Intent intent = new Intent();
        intent.setClassName(TAG_SERVICE_PKG, TAG_SERVICE_TAG_BOARD_CLASS);
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.putExtra("keyword", str);
        return intent;
    }

    public static boolean isSupportedTagEditor(Context context) {
        Intent intent = new Intent();
        intent.setClassName(TAG_SERVICE_PKG, TAG_SERVICE_TAG_EDITOR_CLASS);
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    public static boolean isSupportedTagService(Context context) {
        if (sInitialized) {
            return sIsSupportedTagService;
        }
        sInitialized = true;
        try {
            context.getPackageManager().getPackageInfo(TAG_SERVICE_PKG, 0);
            sIsSupportedTagService = true;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m11000e(TAG, "isSupportedTagBoard#" + e.getMessage());
            return false;
        }
    }
}
