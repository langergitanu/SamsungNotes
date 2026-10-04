package com.samsung.android.sdk.handwriting;

import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HwrLanguageID {
    private static final String TAG = "HwrLanguageID";
    private static final HashMap<String, Integer> mLanguageMap = new HashMap<String, Integer>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.1
        {
            put(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, 10);
            put("eng", 10);
            put("ko_KR", 1);
            put("kor", 1);
            put("ko_KR-nh", 1);
            put("ko_KR_NoHanJa", 2);
            put("zh_CN", 0);
            put("chn", 0);
            put("zh_HK", 84);
            put("zh_TW", 85);
            AbstractC6670b.m4746g(83, this, "ja_JP", 11, "fr_FR");
            AbstractC6670b.m4746g(12, this, "de_DE", 13, "it_IT");
            AbstractC6670b.m4746g(15, this, "es_ES", 14, "pt_PT");
            AbstractC6670b.m4746g(16, this, "ru_RU", 87, "ms_MY");
            AbstractC6670b.m4746g(350, this, "id_ID", 88, "tr_TR");
            AbstractC6670b.m4746g(89, this, "hi_IN", 91, "ar");
            AbstractC6670b.m4746g(92, this, "fa_IR", 90, "th_TH");
            AbstractC6670b.m4746g(107, this, "bg_BG", 108, "kk_KZ");
            AbstractC6670b.m4746g(109, this, "uk_UA", 111, "ka_GE");
            AbstractC6670b.m4746g(110, this, "el_GR", 113, "he_IL");
            AbstractC6670b.m4746g(112, this, "ur_PK", 106, "vi_VN");
            AbstractC6670b.m4746g(105, this, "az_AZ", 104, "ca_ES");
            AbstractC6670b.m4746g(94, this, "cs_CZ", 97, "da_DK");
            AbstractC6670b.m4746g(101, this, "ga_IE", 102, "hu_HU");
            AbstractC6670b.m4746g(103, this, "lt_LT", 98, "nb_NO");
            AbstractC6670b.m4746g(99, this, "nl_NL", 95, "pl_PL");
            AbstractC6670b.m4746g(93, this, "ro_RO", 96, "sl_SI");
            AbstractC6670b.m4746g(100, this, "sv_SE", 207, "af_ZA");
            AbstractC6670b.m4746g(310, this, "es_US", 210, "et_EE");
            AbstractC6670b.m4746g(203, this, "fi_FI", 320, "fr_CA");
            AbstractC6670b.m4746g(202, this, "hr_HR", 201, "hy_AM");
            AbstractC6670b.m4746g(204, this, "is_IS", JPEG.RST0, "lv_LV");
            AbstractC6670b.m4746g(JPEG.RST1, this, "mn_MN", 211, "mr_IN");
            AbstractC6670b.m4746g(330, this, "pt_BR", 206, "sk_SK");
            AbstractC6670b.m4746g(200, this, "sq_AL", JPEG.EOI, "sr_Cyrl_RS");
            Integer numValueOf = Integer.valueOf(JPEG.SOI);
            put("sr_Latn_RS", numValueOf);
            put("sr_RS", numValueOf);
            put("be_BY", 212);
            put("de_AT", 340);
            AbstractC6670b.m4746g(301, this, "en_AU", 302, "en_CA");
            AbstractC6670b.m4746g(300, this, "en_GB", 311, "es_MX");
            AbstractC6670b.m4746g(PopOverActivityWrapper.DEFAULT_WIDTH, this, "nl_BE", 213, "eu_ES");
            AbstractC6670b.m4746g(214, this, "gl_ES", JPEG.RST7, "mk_MK");
            AbstractC6670b.m4746g(303, this, "hg_IN", JPEG.SOS, "bs_BA");
            AbstractC6670b.m4746g(JPEG.DQT, this, "tl_PH", 220, "ky_KG");
            AbstractC6670b.m4746g(JPEG.DRI, this, "uz_UZ", JPEG.DHP, "tk_TM");
            AbstractC6670b.m4746g(JPEG.EXP, this, "tg_TJ", JPEG.APP0, "bn_BD");
            AbstractC6670b.m4746g(JPEG.APP1, this, "ne_NP", JPEG.APP2, "pa_IN");
            AbstractC6670b.m4746g(JPEG.APP3, this, "te_IN", JPEG.APP4, "ta_IN");
            AbstractC6670b.m4746g(JPEG.APP5, this, "mg_MG", 230, "cy_GB");
            AbstractC6670b.m4746g(JPEG.APP7, this, "as_IN", 304, "en_PH");
            AbstractC6670b.m4746g(312, this, "es_CO", 321, "fr_CH");
            AbstractC6670b.m4746g(322, this, "fr_BE", 323, "fr_LU");
            AbstractC6670b.m4746g(324, this, "fr_MC", 341, "de_CH");
            AbstractC6670b.m4746g(342, this, "de_LI", 343, "de_LU");
            AbstractC6670b.m4746g(JPEG.APP8, this, "gu_IN", JPEG.APP9, "kn_IN");
            AbstractC6670b.m4746g(JPEG.APP10, this, "ml_IN", JPEG.APP11, "or_IN");
            AbstractC6670b.m4746g(JPEG.APP12, this, "sw", JPEG.APP13, "zu_ZA");
            AbstractC6670b.m4746g(JPEG.APP14, this, "xh_ZA", JPEG.APP15, "ceb");
            AbstractC6670b.m4746g(240, this, "jv_ID", 241, "mt_MT");
            AbstractC6670b.m4746g(242, this, "ha_NE", 243, "kk_Latn_KZ");
            AbstractC6670b.m4746g(244, this, "su_ID", 245, "ht_HT");
            AbstractC6670b.m4746g(246, this, "om_ET", 247, "ig_NG");
            AbstractC6670b.m4746g(248, this, "haw", 249, "tt");
            AbstractC6670b.m4746g(250, this, "si_LK", 251, "lo_LA");
            AbstractC6670b.m4746g(252, this, "amh", 335, "it_CH");
            AbstractC6670b.m4746g(86, this, "numeric", 1000, "resList");
        }
    };
    private static final HashMap<String, String> mDefaultLanguageMap = new HashMap<String, String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.2
        {
            put("en", DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE);
            put(LangPackConfigConstants.LANGUAGE_CODE_KO, "ko_KR");
            put("zh", "zh_CN");
            put(LangPackConfigConstants.LANGUAGE_CODE_JA, "ja_JP");
            put(LangPackConfigConstants.LANGUAGE_CODE_FR, "fr_FR");
            put(LangPackConfigConstants.LANGUAGE_CODE_DE, "de_DE");
            put(LangPackConfigConstants.LANGUAGE_CODE_IT, "it_IT");
            put(LangPackConfigConstants.LANGUAGE_CODE_ES, "es_ES");
            put(LangPackConfigConstants.LANGUAGE_CODE_PT, "pt_PT");
            put(LangPackConfigConstants.LANGUAGE_CODE_RU, "ru_RU");
            put("ms", "ms_MY");
            put("id", "id_ID");
            put("tr", "tr_TR");
            put("hi", "hi_IN");
            put("ar", "ar");
            put(MarketingConstants.NotificationConst.FLIPPING_ANIMATION, "fa_IR");
            put("th", "th_TH");
            put(MarketingConstants.PopupConst.COLOR_BACKGROUND, "bg_BG");
            put("kk", "kk_KZ");
            put("uk", "uk_UA");
            put("ka", "ka_GE");
            put("el", "el_GR");
            put(VPathDataCmd.SmoothLine, "he_IL");
            put("ur", "ur_PK");
            put(LangPackConfigConstants.LANGUAGE_CODE_VI, "vi_VN");
            put("az", "az_AZ");
            put("ca", "ca_ES");
            put("cs", "cs_CZ");
            put("da", "da_DK");
            put("ga", "ga_IE");
            put("hu", "hu_HU");
            put("lt", "lt_LT");
            put("nb", "nb_NO");
            put("nl", "nl_NL");
            put(LangPackConfigConstants.LANGUAGE_CODE_PL, "pl_PL");
            put("ro", "ro_RO");
            put("sl", "sl_SI");
            put("sv", "sv_SE");
            put("af", "af_ZA");
            put("et", "et_EE");
            put("fi", "fi_FI");
            put("hr", "hr_HR");
            put("hy", "hy_AM");
            put("is", "is_IS");
            put("lv", "lv_LV");
            put("mn", "mn_MN");
            put("mr", "mr_IN");
            put("sk", "sk_SK");
            put("sq", "sq_AL");
            put("sr", "sr_RS");
            put("be", "be_BY");
            put("eu", "eu_ES");
            put("gl", "gl_ES");
            put("mk", "mk_MK");
            put("hg", "hg_IN");
            put("bs", "bs_BA");
            put("tl", "tl_PH");
            put("ky", "ky_KG");
            put("uz", "uz_UZ");
            put("tk", "tk_TM");
            put("tg", "tg_TJ");
            put("bn", "bn_BD");
            put("ne", "ne_NP");
            put("ta", "ta_IN");
            put("te", "te_IN");
            put("pa", "pa_IN");
            put("cy", "cy_GB");
            put("mg", "mg_MG");
            put("as", "as_IN");
            put("gu", "gu_IN");
            put("kn", "kn_IN");
            put("ml", "ml_IN");
            put("or", "or_IN");
            put("sw", "sw");
            put("zu", "zu_ZA");
            put("xh", "xh_ZA");
            put("ceb", "ceb");
            put("jv", "jv_ID");
            put("mt", "mt_MT");
            put(VPathDataCmd.AutoLine, "ha_NE");
            put("su", "su_ID");
            put("ht", "ht_HT");
            put("om", "om_ET");
            put("ig", "ig_NG");
            put("haw", "haw");
            put("tt", "tt");
            put("si", "si_LK");
            put("lo", "lo_LA");
            put("amh", "amh");
        }
    };
    private static final HashMap<String, List<String>> mPriorityLanguageMap = new HashMap<String, List<String>>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3
        {
            put("en", new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.1
                {
                    add(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE);
                    add("en_GB");
                    add("en_AU");
                    add("en_CA");
                }
            });
            put(LangPackConfigConstants.LANGUAGE_CODE_FR, new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.2
                {
                    add("fr_FR");
                    add("fr_CA");
                    add("fr_CH");
                    add("fr_BE");
                    add("fr_LU");
                    add("fr_MC");
                }
            });
            put(LangPackConfigConstants.LANGUAGE_CODE_DE, new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.3
                {
                    add("de_DE");
                    add("de_AT");
                    add("de_CH");
                    add("de_LI");
                    add("de_LU");
                }
            });
            put(LangPackConfigConstants.LANGUAGE_CODE_ES, new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.4
                {
                    add("es_ES");
                    add("es_US");
                    add("es_MX");
                }
            });
            put(LangPackConfigConstants.LANGUAGE_CODE_PT, new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.5
                {
                    add("pt_PT");
                    add("pt_BR");
                }
            });
            put("nl", new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.6
                {
                    add("nl_NL");
                    add("nl_BE");
                }
            });
            put("zh", new ArrayList<String>() { // from class: com.samsung.android.sdk.handwriting.HwrLanguageID.3.7
                {
                    add("zh_CN");
                    add("zh_HK");
                    add("zh_TW");
                }
            });
        }
    };

    public static String getDefaultLanguageCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() != 2 && str.length() != 3) {
            return str;
        }
        HashMap<String, String> map = mDefaultLanguageMap;
        return map.containsKey(str) ? map.get(str) : str;
    }

    public static int getID(String str) {
        HashMap<String, Integer> map = mLanguageMap;
        if (map.containsKey(str)) {
            return map.get(str).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String defaultLanguageCode = getDefaultLanguageCode(getLanguageCodeFrom(str));
        if (map.containsKey(defaultLanguageCode)) {
            return map.get(defaultLanguageCode).intValue() + 2000;
        }
        return -1;
    }

    public static List<Integer> getIDs(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getID(it.next())));
        }
        return arrayList;
    }

    public static String getLanguageCodeFrom(String str) {
        if (str.contains("_")) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit != null && strArrSplit.length > 0) {
                return strArrSplit[0];
            }
            Log.e(TAG, "Cannot split locale string : ".concat(str));
        }
        return str;
    }

    public static List<String> getPriorityLocaleList(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        if (str.length() == 2) {
            HashMap<String, List<String>> map = mPriorityLanguageMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        return new ArrayList();
    }

    public static List<Integer> getIDs(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Integer.valueOf(getID(str)));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
