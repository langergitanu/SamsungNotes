package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa;

import android.annotation.SuppressLint;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SAManager implements SAConstants {

    @SuppressLint({"StaticFieldLeak"})
    public static final SAManager INSTANCE = new SAManager();

    private SAManager() {
    }

    private String getOrdinalNumberPostfix(int i) {
        return i == 1 ? "st" : i == 2 ? SAConstants.DETAIL_SAVE_DEFAULT_TEMPLATE_DEFAULT_POSTFIX_ND : i == 3 ? SAConstants.DETAIL_SAVE_DEFAULT_TEMPLATE_DEFAULT_POSTFIX_RD : "th";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private String getTemplateDetail(int i, String str) {
        if (TemplateViewType.isDefaultImageType(i)) {
            str.getClass();
            switch (str) {
                case "0":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_BLANK;
                case "1":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_LINED_NARROW;
                case "2":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_LINED;
                case "3":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_LINED_WIDE;
                case "4":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_GRID_NARROW;
                case "5":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_GRID;
                case "6":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_GRID_WIDE;
                case "7":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_DOT_NARROW;
                case "8":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_DOT;
                case "9":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_DOT_WIDE;
                case "10":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_CHECKLIST;
                case "11":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_OXFORD;
                case "13":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_WEEKLY_PLAN;
                case "14":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_MONTHLY_PLAN;
                case "15":
                    return SAConstants.DETAIL_DEFAULT_IMAGE_MUSIC;
                default:
                    return SAConstants.DETAIL_DEFAULT_IMAGE_BLANK;
            }
        }
        if (TemplateViewType.isCustomImageType(i)) {
            return "c";
        }
        if (TemplateViewType.isCustomPdfType(i)) {
            return "d";
        }
        String fileNameFromFilePath = FileUtils.getFileNameFromFilePath(str);
        if (fileNameFromFilePath.indexOf("_") < 0) {
            return "";
        }
        String strSubstring = fileNameFromFilePath.substring(0, fileNameFromFilePath.indexOf("_"));
        strSubstring.getClass();
        switch (strSubstring.hashCode()) {
            case 1537:
                if (!strSubstring.equals("01")) {
                }
                break;
            case 1538:
                if (!strSubstring.equals("02")) {
                }
                break;
            case 1539:
                if (!strSubstring.equals("03")) {
                }
                break;
            case 1540:
                if (!strSubstring.equals("04")) {
                }
                break;
            case 1541:
                if (!strSubstring.equals("05")) {
                }
                break;
            case 1542:
                if (!strSubstring.equals("06")) {
                }
                break;
            case 1543:
                if (!strSubstring.equals("07")) {
                }
                break;
            case 1544:
                if (!strSubstring.equals("08")) {
                }
                break;
            case 1545:
                if (!strSubstring.equals("09")) {
                }
                break;
            case 1567:
                if (!strSubstring.equals(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING)) {
                }
                break;
            case 1568:
                if (!strSubstring.equals(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON)) {
                }
                break;
            case 1569:
                if (!strSubstring.equals("12")) {
                }
                break;
            case 1570:
                if (!strSubstring.equals("13")) {
                }
                break;
            case 1571:
                if (!strSubstring.equals("14")) {
                }
                break;
            case 1572:
                if (!strSubstring.equals("15")) {
                }
                break;
            default:
                break;
        }
        /*  JADX ERROR: Method code generation error
            java.lang.NullPointerException: Switch insn not found in header
            	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */
        /*
            Method dump skipped, instruction units count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAManager.getTemplateDetail(int, java.lang.String):java.lang.String");
    }

    public void logTemplateDetailSA() {
        int i = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
        if (string == null) {
            return;
        }
        NotesSamsungAnalytics.insertLog("510", "5850", getTemplateDetail(i, string));
    }

    public void onAddTemplate(String str) {
        NotesSamsungAnalytics.insertLog(str, SAConstants.EVENT_PAGE_STYLE_ADD_IMAGE_TEMPLATE);
    }

    public void onDownloadDefaultPdf() {
        NotesSamsungAnalytics.insertLog("510", SAConstants.EVENT_PDF_DOWNLOAD);
    }

    public void onSaveDefaultTemplate(int i, int i2) {
        String str;
        if (TemplateViewType.isDefaultImageType(i)) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 < 12) {
                i2++;
            }
            str = i2 + getOrdinalNumberPostfix(i2);
        } else {
            str = i == 3 ? "Image" : "PDF";
        }
        NotesSamsungAnalytics.insertLog("510", SAConstants.EVENT_SAVE_DEFAULT_TEMPLATE, str);
    }

    public void onSelectTemplate(int i, String str) {
        NotesSamsungAnalytics.insertLog("510", "1521", getTemplateDetail(i, str));
    }

    public void onSelectTemplateCategory(int i) {
        NotesSamsungAnalytics.insertLog("510", SAConstants.EVENT_SELECT_TEMPLATE_CATEGORY, i == 0 ? "a" : i == 1 ? "b" : i == 2 ? "c" : i == 3 ? "d" : i == 4 ? "e" : "f");
    }
}
