package com.samsung.android.support.senl.p148nt.model.utils;

import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentBackgroundUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum InvertBackgroundColorType {
        None,
        Pdf,
        Image
    }

    public static int getDefaultBackgroundColor(int i) {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_COLOR, i);
    }

    public static boolean getDefaultInvertBackground() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_PAGE_COLOR_ADJUST_IN_DARK_MODE, true);
    }

    public static InvertBackgroundColorType getInvertBackgroundColorType(List<SpenWPage> list) {
        InvertBackgroundColorType invertBackgroundColorType = InvertBackgroundColorType.None;
        if (list != null) {
            for (SpenWPage spenWPage : list) {
                if (spenWPage.hasPDF()) {
                    return InvertBackgroundColorType.Pdf;
                }
                if (spenWPage.getTemplateType() == 12 && spenWPage.hasBackgroundImage()) {
                    return InvertBackgroundColorType.Image;
                }
            }
        }
        return invertBackgroundColorType;
    }

    public static String getTemplatePath() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
    }

    public static int getTemplateViewType() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
    }
}
