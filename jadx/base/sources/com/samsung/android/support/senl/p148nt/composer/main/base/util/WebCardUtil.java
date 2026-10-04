package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WebCardUtil {
    private static final String COMPOSER_SHAREDPREFERENCES_FILENAME = "ComposerSharedPreferences";
    private static final String COMPOSER_SHAREDPREF_WEBCARD_FIRST_PREVEW = "WebCardFirstPreview";
    private static final String TAG = Logger.createTag("WebCardUtil");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogManager {
        void showWebCardPreviewDialog(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SubText {
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_URL = 2;
        private CharSequence data;
        private int type;

        public SubText(int i, CharSequence charSequence) {
            this.type = i;
            this.data = charSequence;
        }

        public CharSequence getData() {
            return this.data;
        }

        public int getType() {
            return this.type;
        }
    }

    public static ArrayList<SubText> getSubTextForURL(SpannableStringBuilder spannableStringBuilder) {
        ArrayList<SubText> arrayList = new ArrayList<>();
        arrayList.add(new SubText(2, spannableStringBuilder.subSequence(0, spannableStringBuilder.length())));
        return arrayList;
    }

    public static ArrayList<SubText> getSubTextList(SpannableStringBuilder spannableStringBuilder) {
        Matcher matcher = Utils.getWebUrlPattern().matcher(spannableStringBuilder);
        ArrayList<SubText> arrayList = new ArrayList<>();
        int iEnd = 0;
        while (matcher.find()) {
            if (iEnd < matcher.start()) {
                arrayList.add(new SubText(1, spannableStringBuilder.subSequence(iEnd, matcher.start())));
            }
            arrayList.add(new SubText(2, spannableStringBuilder.subSequence(matcher.start(), matcher.end())));
            iEnd = matcher.end();
        }
        if (iEnd < spannableStringBuilder.length()) {
            arrayList.add(new SubText(1, spannableStringBuilder.subSequence(iEnd, spannableStringBuilder.length())));
        }
        return arrayList;
    }

    public static boolean isFirstCheckToShowWebPreviewsPopup() {
        return SharedPreferencesCompat.getInstance(COMPOSER_SHAREDPREFERENCES_FILENAME).getBoolean(COMPOSER_SHAREDPREF_WEBCARD_FIRST_PREVEW, false);
    }

    public static boolean isShowWebPreviewsEnabled() {
        if (!RequestToSyncManager.INSTANCE.isDataCallNotLimitedForApp()) {
            Logger.m11000e(TAG, "isShowWebPreviewsEnabled, isDataCallNotLimitedForApp false ");
            return false;
        }
        boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, false);
        AbstractC8014b.m7220v("isShowWebPreviewsEnabled, : ", TAG, z);
        return z;
    }

    public static boolean isShowWebPreviewsSettingEnabled() {
        boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, false);
        AbstractC8014b.m7220v("isShowWebPreviewsEnabled, : ", TAG, z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setIsFirstCheckToShowWebPreviewsPopup() {
        SharedPreferencesCompat.getInstance(COMPOSER_SHAREDPREFERENCES_FILENAME).putBoolean(COMPOSER_SHAREDPREF_WEBCARD_FIRST_PREVEW, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setIsShowWebPreviewsSettingEnabled() {
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, true);
    }

    public static void showOnlyFirstWebCardPreviewDialog(IDialogManager iDialogManager, DialogInterface.OnDismissListener onDismissListener) {
        iDialogManager.showWebCardPreviewDialog(new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.util.WebCardUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                WebCardUtil.setIsShowWebPreviewsSettingEnabled();
                WebCardUtil.setIsFirstCheckToShowWebPreviewsPopup();
                dialogInterface.dismiss();
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_WEB_PREVIEW_OK);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.util.WebCardUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                WebCardUtil.setIsFirstCheckToShowWebPreviewsPopup();
                dialogInterface.dismiss();
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_WEB_PREVIEW_CANCEL);
            }
        }, onDismissListener);
    }
}
