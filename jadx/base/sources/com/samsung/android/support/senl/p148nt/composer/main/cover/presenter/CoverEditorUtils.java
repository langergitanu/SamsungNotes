package com.samsung.android.support.senl.p148nt.composer.main.cover.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverEditorUtils {
    private static final String TAG = Logger.createCoverTag("CoverEditorUtils");
    private static final int TEXT_LINE_SPACING_NOT_NEEDED = -1;

    public static List<Pair<String, Integer>> createColorList() {
        return new ArrayList(Arrays.asList(new Pair(CoverConstants.Color.SET_1, Integer.valueOf(C9086R.string.cover_color_set_1_tts)), new Pair(CoverConstants.Color.SET_2, Integer.valueOf(C9086R.string.cover_color_set_2_tts)), new Pair(CoverConstants.Color.SET_3, Integer.valueOf(C9086R.string.cover_color_set_3_tts)), new Pair(CoverConstants.Color.SET_4, Integer.valueOf(C9086R.string.cover_color_set_4_tts)), new Pair(CoverConstants.Color.SET_5, Integer.valueOf(C9086R.string.cover_color_set_5_tts)), new Pair(CoverConstants.Color.SET_6, Integer.valueOf(C9086R.string.cover_color_set_6_tts)), new Pair(CoverConstants.Color.SKY_BLUE, Integer.valueOf(C9086R.string.cover_color_sky_blue_tts)), new Pair(CoverConstants.Color.LAVENDER, Integer.valueOf(C9086R.string.cover_color_lavender_tts)), new Pair(CoverConstants.Color.CORAL, Integer.valueOf(C9086R.string.cover_color_coral_tts)), new Pair(CoverConstants.Color.ORANGE, Integer.valueOf(C9086R.string.cover_color_orange_tts)), new Pair(CoverConstants.Color.YELLOW, Integer.valueOf(C9086R.string.cover_color_yellow_tts)), new Pair(CoverConstants.Color.BEIGE, Integer.valueOf(C9086R.string.cover_color_beige_tts)), new Pair(CoverConstants.Color.GREEN, Integer.valueOf(C9086R.string.cover_color_green_tts)), new Pair(CoverConstants.Color.VIVID_BLUE, Integer.valueOf(C9086R.string.cover_color_vivid_blue_tts)), new Pair(CoverConstants.Color.VIVID_PURPLE, Integer.valueOf(C9086R.string.cover_color_vivid_purple_tts)), new Pair(CoverConstants.Color.VIVID_CORAL, Integer.valueOf(C9086R.string.cover_color_vivid_coral_tts)), new Pair(CoverConstants.Color.VIVID_ORANGE, Integer.valueOf(C9086R.string.cover_color_vivid_orange_tts)), new Pair(CoverConstants.Color.VIVID_YELLOW, Integer.valueOf(C9086R.string.cover_color_vivid_yellow_tts)), new Pair(CoverConstants.Color.VIVID_GREEN, Integer.valueOf(C9086R.string.cover_color_vivid_green_tts)), new Pair(CoverConstants.Color.NAVY, Integer.valueOf(C9086R.string.cover_color_navy_tts))));
    }

    public static List<String> createIllustList() {
        return new ArrayList(Arrays.asList(CoverConstants.Template.ILLUST_1, CoverConstants.Template.ILLUST_2, CoverConstants.Template.ILLUST_3, CoverConstants.Template.ILLUST_4, CoverConstants.Template.ILLUST_5, CoverConstants.Template.ILLUST_6, CoverConstants.Template.ILLUST_7, CoverConstants.Template.ILLUST_8, CoverConstants.Template.ILLUST_9, CoverConstants.Template.ILLUST_10, CoverConstants.Template.ILLUST_11, CoverConstants.Template.ILLUST_12));
    }

    public static List<String> createPatternList() {
        return new ArrayList(Arrays.asList(CoverConstants.Template.PATTERN_1, CoverConstants.Template.PATTERN_2, CoverConstants.Template.PATTERN_3, CoverConstants.Template.PATTERN_4, CoverConstants.Template.PATTERN_5, CoverConstants.Template.PATTERN_6, CoverConstants.Template.PATTERN_7, CoverConstants.Template.PATTERN_8, CoverConstants.Template.PATTERN_9, CoverConstants.Template.PATTERN_10, CoverConstants.Template.PATTERN_11, CoverConstants.Template.PATTERN_12));
    }

    public static ArrayList<String> createSelectedTemplateList() {
        return new ArrayList<>(Arrays.asList("DEFAULT:///", CoverConstants.Template.PATTERN_1, CoverConstants.Template.ILLUST_1, "BASIC_STYLE_1:///"));
    }

    public static List<Pair<String, Integer>> createStickerList() {
        return new ArrayList(Arrays.asList(new Pair(CoverStickerConstants.Category.NONE.UUID, Integer.valueOf(C9086R.string.cover_sticker_none_tts)), new Pair(CoverStickerConstants.Category.TRAVEL.UUID, Integer.valueOf(C9086R.string.cover_sticker_travel_tts)), new Pair(CoverStickerConstants.Category.INFORMATION.UUID, Integer.valueOf(C9086R.string.cover_sticker_information_tts)), new Pair(CoverStickerConstants.Category.DIARY.UUID, Integer.valueOf(C9086R.string.cover_sticker_diary_tts)), new Pair(CoverStickerConstants.Category.PLANNER.UUID, Integer.valueOf(C9086R.string.cover_sticker_planner_tts)), new Pair(CoverStickerConstants.Category.RECIPE.UUID, Integer.valueOf(C9086R.string.cover_sticker_recipe_tts)), new Pair(CoverStickerConstants.Category.TODO.UUID, Integer.valueOf(C9086R.string.cover_sticker_todo_tts)), new Pair(CoverStickerConstants.Category.STUDY.UUID, Integer.valueOf(C9086R.string.cover_sticker_study_tts)), new Pair(CoverStickerConstants.Category.SHOPPING.UUID, Integer.valueOf(C9086R.string.cover_sticker_shopping_tts)), new Pair(CoverStickerConstants.Category.CASHBOOK.UUID, Integer.valueOf(C9086R.string.cover_sticker_cashbook_tts)), new Pair(CoverStickerConstants.Category.WORKOUT.UUID, Integer.valueOf(C9086R.string.cover_sticker_workout_tts)), new Pair(CoverStickerConstants.Category.WORK.UUID, Integer.valueOf(C9086R.string.cover_sticker_work_tts))));
    }

    public static Map<Integer, List<String>> createTemplateMap() {
        HashMap map = new HashMap();
        map.put(0, createPatternList());
        map.put(1, createPatternList());
        map.put(2, createIllustList());
        map.put(3, createTextList());
        return map;
    }

    public static List<String> createTextList() {
        return new ArrayList(Arrays.asList("BASIC_STYLE_1:///", "BASIC_STYLE_2:///", "cover_v2:////BASIC_STYLE_6:///", "BASIC_STYLE_3:///", "BASIC_STYLE_4:///", "cover_v2:////BASIC_STYLE_7:///", "BASIC_STYLE_5:///", "cover_v2:////BASIC_STYLE_8:///"));
    }

    public static List<Integer> createTypeList() {
        return new ArrayList(Arrays.asList(Integer.valueOf(C9086R.string.cover_type_none), Integer.valueOf(C9086R.string.cover_type_pattern), Integer.valueOf(C9086R.string.cover_type_illust), Integer.valueOf(C9086R.string.cover_type_text)));
    }

    public static String getAiGeneratedLabelText(Context context, String str, int i) {
        return (CscFeature.INSTANCE.getInstance().isChinaAiFeature() && i == 4 && !TextUtils.isEmpty(str)) ? AbstractC0541b.m757C(context.getResources().getString(C9086R.string.cover_ai_generated_label), " ", str) : str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00df  */
    @ColorInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getBackgroundColor(Context context, String str) {
        int i;
        String str2;
        String strReplaceAll = str.replaceAll(" ", "");
        switch (strReplaceAll.hashCode()) {
            case -1855995702:
                i = !strReplaceAll.equals(CoverConstants.Color.VIVID_YELLOW) ? C9086R.color.cover_color_sky_blue : C9086R.color.cover_color_vivid_yellow;
                break;
            case -1395475317:
                if (strReplaceAll.equals(CoverConstants.Color.NAVY)) {
                    i = C9086R.color.cover_color_navy;
                    break;
                }
                break;
            case -871622247:
                if (strReplaceAll.equals(CoverConstants.Color.BEIGE)) {
                    i = C9086R.color.cover_color_beige;
                    break;
                }
                break;
            case -604543229:
                if (strReplaceAll.equals(CoverConstants.Color.ORANGE)) {
                    i = C9086R.color.cover_color_orange;
                    break;
                }
                break;
            case -447295087:
                if (strReplaceAll.equals(CoverConstants.Color.PURPLE)) {
                    i = C9086R.color.cover_news_bg_color;
                    break;
                }
                break;
            case -385558032:
                if (strReplaceAll.equals(CoverConstants.Color.VIVID_BLUE)) {
                    i = C9086R.color.cover_color_vivid_blue;
                    break;
                }
                break;
            case -85913015:
                if (strReplaceAll.equals(CoverConstants.Color.YELLOW)) {
                    i = C9086R.color.cover_color_yellow;
                    break;
                }
                break;
            case 558743864:
                if (strReplaceAll.equals(CoverConstants.Color.GREEN)) {
                    i = C9086R.color.cover_color_green;
                    break;
                }
                break;
            case 568393901:
                str2 = CoverConstants.Color.SKY_BLUE;
                strReplaceAll.equals(str2);
                break;
            case 1055833751:
                if (strReplaceAll.equals(CoverConstants.Color.VIVID_GREEN)) {
                    i = C9086R.color.cover_color_vivid_green;
                    break;
                }
                break;
            case 1096413030:
                if (strReplaceAll.equals(CoverConstants.Color.CORAL)) {
                    i = C9086R.color.cover_color_coral;
                    break;
                }
                break;
            case 1275907612:
                if (strReplaceAll.equals(CoverConstants.Color.LAVENDER)) {
                    i = C9086R.color.cover_color_lavender;
                    break;
                }
                break;
            case 1386522712:
                if (strReplaceAll.equals(CoverConstants.Color.LIGHT_BLUE)) {
                    i = C9086R.color.cover_info_bg_color;
                    break;
                }
                break;
            case 1593502917:
                if (strReplaceAll.equals(CoverConstants.Color.VIVID_CORAL)) {
                    i = C9086R.color.cover_color_vivid_coral;
                    break;
                }
                break;
            case 1716157814:
                str2 = "DEFAULT:///";
                strReplaceAll.equals(str2);
                break;
            case 1806508523:
                if (strReplaceAll.equals(CoverConstants.Color.BROWN)) {
                    i = C9086R.color.cover_work_bg_color;
                    break;
                }
                break;
            case 1822705583:
                if (strReplaceAll.equals(CoverConstants.Color.DARK_GREEN)) {
                    i = C9086R.color.cover_cashbook_bg_color;
                    break;
                }
                break;
            case 1920341380:
                if (strReplaceAll.equals(CoverConstants.Color.VIVID_ORANGE)) {
                    i = C9086R.color.cover_color_vivid_orange;
                    break;
                }
                break;
            case 2077589522:
                if (strReplaceAll.equals(CoverConstants.Color.VIVID_PURPLE)) {
                    i = C9086R.color.cover_color_vivid_purple;
                    break;
                }
                break;
        }
        return ContextCompat.getColor(context, i);
    }

    public static Drawable getCategoryDrawable(Context context, String str) {
        String strReplaceAll;
        if (str == null) {
            str = getDefaultCategory();
        }
        strReplaceAll = str.replaceAll(" ", "");
        strReplaceAll.getClass();
        switch (strReplaceAll) {
            case "NEWS:///":
                return context.getDrawable(C9086R.drawable.cover_news_12);
            case "NONE:///":
                return context.getDrawable(C9086R.drawable.cover_none_0);
            case "INFORMATION:///":
                return context.getDrawable(C9086R.drawable.cover_info_4);
            case "WORKOUT:///":
                return context.getDrawable(C9086R.drawable.cover_workout_9);
            case "TODO:///":
                return context.getDrawable(C9086R.drawable.cover_todo_1);
            case "PLANNER:///":
                return context.getDrawable(C9086R.drawable.cover_planner_6);
            case "DIARY:///":
                return context.getDrawable(C9086R.drawable.cover_diary_8);
            case "RECIPE:///":
                return context.getDrawable(C9086R.drawable.cover_recipe_11);
            case "SHOPPING:///":
                return context.getDrawable(C9086R.drawable.cover_shopping_5);
            case "WORK:///":
                return context.getDrawable(C9086R.drawable.cover_work_2);
            case "STUDY:///":
                return context.getDrawable(C9086R.drawable.cover_study_3);
            case "TRAVEL:///":
                return context.getDrawable(C9086R.drawable.cover_travel_7);
            case "CASHBOOK:///":
                return context.getDrawable(C9086R.drawable.cover_cashbook_10);
            default:
                Drawable downloadedStickerDrawable = CoverStickerDownloadUtils.getDownloadedStickerDrawable(context, strReplaceAll);
                return downloadedStickerDrawable == null ? context.getDrawable(C9086R.drawable.cover_sticker_error) : downloadedStickerDrawable;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int[] getColorSet(String str) {
        String str2;
        switch (str.hashCode()) {
            case 78407827:
                str2 = CoverConstants.Color.SET_1;
                str.equals(str2);
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            case 79331348:
                if (str.equals(CoverConstants.Color.SET_2)) {
                    return new int[]{C9086R.color.cover_color_set_2_first, C9086R.color.cover_color_set_2_second, C9086R.color.cover_color_set_2_third};
                }
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            case 80254869:
                if (str.equals(CoverConstants.Color.SET_3)) {
                    return new int[]{C9086R.color.cover_color_set_3_first, C9086R.color.cover_color_set_3_second, C9086R.color.cover_color_set_3_third};
                }
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            case 81178390:
                if (str.equals(CoverConstants.Color.SET_4)) {
                    return new int[]{C9086R.color.cover_color_set_4_first, C9086R.color.cover_color_set_4_second, C9086R.color.cover_color_set_4_third};
                }
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            case 82101911:
                if (str.equals(CoverConstants.Color.SET_5)) {
                    return new int[]{C9086R.color.cover_color_set_5_first, C9086R.color.cover_color_set_5_second, C9086R.color.cover_color_set_5_third};
                }
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            case 83025432:
                if (str.equals(CoverConstants.Color.SET_6)) {
                    return new int[]{C9086R.color.cover_color_set_6_first, C9086R.color.cover_color_set_6_second, C9086R.color.cover_color_set_6_third};
                }
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            case 1716157814:
                str2 = "DEFAULT:///";
                str.equals(str2);
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
            default:
                return new int[]{C9086R.color.cover_color_set_1_first, C9086R.color.cover_color_set_1_second, C9086R.color.cover_color_set_1_third};
        }
    }

    @ColorInt
    public static int getCoverChipBackgroundColor(Context context, String str, String str2) {
        int color;
        if (str.contains(CoverConstants.COLOR_SET) || str.equals("DEFAULT:///")) {
            int[] colorSet = getColorSet(str);
            color = (!"cover_v2:////BASIC_STYLE_6:///".equals(str2) || str.equals("DEFAULT:///")) ? context.getColor(colorSet[0]) : context.getColor(colorSet[1]);
        } else {
            color = ("BASIC_STYLE_1:///".equals(str2) || "BASIC_STYLE_2:///".equals(str2)) ? getBackgroundColor(context, str) : context.getColor(C9086R.color.cover_color_label);
        }
        return ContextUtils.isNightMode(context) ? overlayColor(color) : color;
    }

    public static String getDefaultBackgroundColor() {
        return CoverConstants.Color.SKY_BLUE;
    }

    public static String getDefaultCategory() {
        return CoverStickerConstants.Category.NONE.UUID;
    }

    public static String getDefaultTemplate() {
        return "BASIC_STYLE_1:///";
    }

    public static String getExistFilePath(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(PageCacheUtils.getRootCacheDirectoryPath(context));
        String str3 = File.separator;
        AbstractC2821a.m2207B(sb, str3, str, str3, Constants.MAIN_THUMBNAIL_PATH);
        String strM1170p = AbstractC0622a.m1170p(str3, str2, sb);
        if (!TextUtils.isEmpty(strM1170p) && AbstractC2322a.m1607A(strM1170p)) {
            return strM1170p;
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Drawable getIllustDrawable(Context context, String str) {
        switch (str.hashCode()) {
            case -1324714358:
                str.equals(CoverConstants.Template.ILLUST_1);
                break;
            case -1323790837:
                if (str.equals(CoverConstants.Template.ILLUST_2)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_02);
                }
                break;
            case -1322867316:
                if (str.equals(CoverConstants.Template.ILLUST_3)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_03);
                }
                break;
            case -1321943795:
                if (str.equals(CoverConstants.Template.ILLUST_4)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_04);
                }
                break;
            case -1321020274:
                if (str.equals(CoverConstants.Template.ILLUST_5)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_05);
                }
                break;
            case -1320096753:
                if (str.equals(CoverConstants.Template.ILLUST_6)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_06);
                }
                break;
            case -1319173232:
                if (str.equals(CoverConstants.Template.ILLUST_7)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_07);
                }
                break;
            case -1318249711:
                if (str.equals(CoverConstants.Template.ILLUST_8)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_08);
                }
                break;
            case -1317326190:
                if (str.equals(CoverConstants.Template.ILLUST_9)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_09);
                }
                break;
            case 1874620400:
                if (str.equals(CoverConstants.Template.ILLUST_10)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_10);
                }
                break;
            case 1875543921:
                if (str.equals(CoverConstants.Template.ILLUST_11)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_11);
                }
                break;
            case 1876467442:
                if (str.equals(CoverConstants.Template.ILLUST_12)) {
                    return context.getDrawable(C9086R.drawable.cover_type_illust_12);
                }
                break;
        }
        return context.getDrawable(C9086R.drawable.cover_type_illust_01);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Drawable getPatternDrawable(Context context, String str) {
        switch (str.hashCode()) {
            case 860770369:
                str.equals(CoverConstants.Template.PATTERN_1);
                break;
            case 861693890:
                if (str.equals(CoverConstants.Template.PATTERN_2)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_02);
                }
                break;
            case 862617411:
                if (str.equals(CoverConstants.Template.PATTERN_3)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_03);
                }
                break;
            case 863540932:
                if (str.equals(CoverConstants.Template.PATTERN_4)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_04);
                }
                break;
            case 864464453:
                if (str.equals(CoverConstants.Template.PATTERN_5)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_05);
                }
                break;
            case 865387974:
                if (str.equals(CoverConstants.Template.PATTERN_6)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_06);
                }
                break;
            case 866311495:
                if (str.equals(CoverConstants.Template.PATTERN_7)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_07);
                }
                break;
            case 867235016:
                if (str.equals(CoverConstants.Template.PATTERN_8)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_08);
                }
                break;
            case 868158537:
                if (str.equals(CoverConstants.Template.PATTERN_9)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_09);
                }
                break;
            case 905170201:
                if (str.equals(CoverConstants.Template.PATTERN_10)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_10);
                }
                break;
            case 906093722:
                if (str.equals(CoverConstants.Template.PATTERN_11)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_11);
                }
                break;
            case 907017243:
                if (str.equals(CoverConstants.Template.PATTERN_12)) {
                    return context.getDrawable(C9086R.drawable.cover_type_pattern_12);
                }
                break;
        }
        return context.getDrawable(C9086R.drawable.cover_type_pattern_01);
    }

    public static String getRandomColor() {
        String[] strArr = {CoverConstants.Color.SKY_BLUE, CoverConstants.Color.LAVENDER, CoverConstants.Color.CORAL, CoverConstants.Color.ORANGE, CoverConstants.Color.YELLOW, CoverConstants.Color.BEIGE, CoverConstants.Color.GREEN, CoverConstants.Color.VIVID_BLUE, CoverConstants.Color.VIVID_PURPLE, CoverConstants.Color.VIVID_CORAL, CoverConstants.Color.VIVID_ORANGE, CoverConstants.Color.VIVID_YELLOW, CoverConstants.Color.VIVID_GREEN, CoverConstants.Color.NAVY};
        int iNextInt = JavaInstanceConstructor.getSecureRandom().nextInt(14);
        AbstractC0000a.m3D(iNextInt, "getRandomColor# index : ", TAG);
        return strArr[iNextInt];
    }

    public static String getRandomTemplate() {
        int iRandom = (int) ((Math.random() * 10.0d) % 5.0d);
        AbstractC0000a.m3D(iRandom, "getRandomTemplate# index : ", TAG);
        return new String[]{"BASIC_STYLE_1:///", "BASIC_STYLE_2:///", "BASIC_STYLE_3:///", "BASIC_STYLE_4:///", "BASIC_STYLE_5:///"}[iRandom];
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getSACategoryDetail(String str) {
        if (str == null) {
            str = getDefaultCategory();
        }
        switch (str.hashCode()) {
            case -2117339864:
                return str.equals(CoverStickerConstants.Category.NEWS.UUID) ? "m" : "a";
            case -2102829299:
                str.equals(CoverStickerConstants.Category.NONE.UUID);
                return "a";
            case -1874741535:
                return str.equals(CoverStickerConstants.Category.INFORMATION.UUID) ? "e" : "a";
            case -770090030:
                return str.equals(CoverStickerConstants.Category.WORKOUT.UUID) ? "j" : "a";
            case -512958181:
                return str.equals(CoverStickerConstants.Category.TODO.UUID) ? "b" : "a";
            case -238790521:
                return str.equals(CoverStickerConstants.Category.PLANNER.UUID) ? "g" : "a";
            case 13039096:
                return str.equals(CoverStickerConstants.Category.DIARY.UUID) ? "i" : "a";
            case 133752419:
                return str.equals(CoverStickerConstants.Category.RECIPE.UUID) ? "l" : "a";
            case 739901757:
                return str.equals(CoverStickerConstants.Category.SHOPPING.UUID) ? "f" : "a";
            case 817619558:
                return str.equals(CoverStickerConstants.Category.WORK.UUID) ? "c" : "a";
            case 831466750:
                return str.equals(CoverStickerConstants.Category.STUDY.UUID) ? "d" : "a";
            case 1167157743:
                return str.equals(CoverStickerConstants.Category.TRAVEL.UUID) ? "h" : "a";
            case 1589852785:
                return str.equals(CoverStickerConstants.Category.CASHBOOK.UUID) ? "k" : "a";
            default:
                return "a";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getSAColorDetail(String str) {
        if (str == null) {
            str = getDefaultBackgroundColor();
        }
        switch (str.hashCode()) {
            case -1855995702:
                return str.equals(CoverConstants.Color.VIVID_YELLOW) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_12 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case -1395475317:
                return str.equals(CoverConstants.Color.NAVY) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_14 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case -871622247:
                return str.equals(CoverConstants.Color.BEIGE) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_6 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case -604543229:
                return str.equals(CoverConstants.Color.ORANGE) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_4 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case -385558032:
                return str.equals(CoverConstants.Color.VIVID_BLUE) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_8 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case -85913015:
                return str.equals(CoverConstants.Color.YELLOW) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_5 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 78407827:
                return str.equals(CoverConstants.Color.SET_1) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_15 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 79331348:
                return str.equals(CoverConstants.Color.SET_2) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_16 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 80254869:
                return str.equals(CoverConstants.Color.SET_3) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_17 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 81178390:
                return str.equals(CoverConstants.Color.SET_4) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_18 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 82101911:
                return str.equals(CoverConstants.Color.SET_5) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_19 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 83025432:
                return str.equals(CoverConstants.Color.SET_6) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_20 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 558743864:
                return str.equals(CoverConstants.Color.GREEN) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_7 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 568393901:
                str.equals(CoverConstants.Color.SKY_BLUE);
                return AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 1055833751:
                return str.equals(CoverConstants.Color.VIVID_GREEN) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_13 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 1096413030:
                return str.equals(CoverConstants.Color.CORAL) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_3 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 1275907612:
                return str.equals(CoverConstants.Color.LAVENDER) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_2 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 1593502917:
                return str.equals(CoverConstants.Color.VIVID_CORAL) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_10 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 1920341380:
                return str.equals(CoverConstants.Color.VIVID_ORANGE) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_11 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            case 2077589522:
                return str.equals(CoverConstants.Color.VIVID_PURPLE) ? AssistSAConstants.DETAIL_SAVE_COVER_COLOR_9 : AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
            default:
                return AssistSAConstants.DETAIL_SAVE_COVER_COLOR_1;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getSATemplateDetail(String str) {
        if (str == null) {
            str = getDefaultTemplate();
        }
        switch (str.hashCode()) {
            case -1689747289:
                str.equals("BASIC_STYLE_1:///");
                return AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1688823768:
                return str.equals("BASIC_STYLE_2:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_2 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1687900247:
                return str.equals("BASIC_STYLE_3:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_4 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1686976726:
                return str.equals("BASIC_STYLE_4:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_5 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1686053205:
                return str.equals("BASIC_STYLE_5:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_7 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1324714358:
                return str.equals(CoverConstants.Template.ILLUST_1) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_1 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1323790837:
                return str.equals(CoverConstants.Template.ILLUST_2) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_2 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1322867316:
                return str.equals(CoverConstants.Template.ILLUST_3) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_3 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1321943795:
                return str.equals(CoverConstants.Template.ILLUST_4) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_4 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1321020274:
                return str.equals(CoverConstants.Template.ILLUST_5) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_5 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1320096753:
                return str.equals(CoverConstants.Template.ILLUST_6) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_6 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1319173232:
                return str.equals(CoverConstants.Template.ILLUST_7) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_7 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1318249711:
                return str.equals(CoverConstants.Template.ILLUST_8) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_8 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case -1317326190:
                return str.equals(CoverConstants.Template.ILLUST_9) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_9 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 378664822:
                return str.equals("cover_v2:////BASIC_STYLE_6:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_3 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 379588343:
                return str.equals("cover_v2:////BASIC_STYLE_7:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_6 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 380511864:
                return str.equals("cover_v2:////BASIC_STYLE_8:///") ? AssistSAConstants.DETAIL_SAVE_COVER_TEXT_8 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 860770369:
                return str.equals(CoverConstants.Template.PATTERN_1) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_1 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 861693890:
                return str.equals(CoverConstants.Template.PATTERN_2) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_2 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 862617411:
                return str.equals(CoverConstants.Template.PATTERN_3) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_3 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 863540932:
                return str.equals(CoverConstants.Template.PATTERN_4) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_4 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 864464453:
                return str.equals(CoverConstants.Template.PATTERN_5) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_5 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 865387974:
                return str.equals(CoverConstants.Template.PATTERN_6) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_6 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 866311495:
                return str.equals(CoverConstants.Template.PATTERN_7) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_7 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 867235016:
                return str.equals(CoverConstants.Template.PATTERN_8) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_8 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 868158537:
                return str.equals(CoverConstants.Template.PATTERN_9) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_9 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 905170201:
                return str.equals(CoverConstants.Template.PATTERN_10) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_10 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 906093722:
                return str.equals(CoverConstants.Template.PATTERN_11) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_11 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 907017243:
                return str.equals(CoverConstants.Template.PATTERN_12) ? AssistSAConstants.DETAIL_SAVE_COVER_PATTERN_12 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 1874620400:
                return str.equals(CoverConstants.Template.ILLUST_10) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_10 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 1875543921:
                return str.equals(CoverConstants.Template.ILLUST_11) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_11 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            case 1876467442:
                return str.equals(CoverConstants.Template.ILLUST_12) ? AssistSAConstants.DETAIL_SAVE_COVER_ILLUST_12 : AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
            default:
                return AssistSAConstants.DETAIL_SAVE_COVER_TEXT_1;
        }
    }

    public static int getSpanCount(Context context, int i, int i2) {
        if (i2 == 0) {
            float f = i;
            if (f <= ResourceUtils.convertDpToPixel(context, 175.0f)) {
                return 1;
            }
            if (f <= ResourceUtils.convertDpToPixel(context, 249.0f)) {
                return 2;
            }
            return f <= ResourceUtils.convertDpToPixel(context, 323.0f) ? 3 : 4;
        }
        float f4 = i;
        if (f4 <= ResourceUtils.convertDpToPixel(context, 135.0f)) {
            return 1;
        }
        if (f4 <= ResourceUtils.convertDpToPixel(context, 183.0f)) {
            return 2;
        }
        if (f4 <= ResourceUtils.convertDpToPixel(context, 231.0f)) {
            return 3;
        }
        if (f4 <= ResourceUtils.convertDpToPixel(context, 279.0f)) {
            return 4;
        }
        return f4 <= ResourceUtils.convertDpToPixel(context, 317.0f) ? 5 : 6;
    }

    @ColorInt
    public static Pair<Integer, Integer> getSummaryColor(Context context, String str, String str2) {
        int i = C9086R.color.cover_summary_text_color;
        int i2 = C9086R.color.cover_summary_text_hint_color;
        if (str.contains(CoverConstants.COLOR_SET)) {
            i = getColorSet(str)[2];
        } else if ((str.contains(CoverConstants.COLOR_VIVID) || str.contains(CoverConstants.Color.NAVY)) && (("DEFAULT:///".equals(str2) || "BASIC_STYLE_1:///".equals(str2) || "BASIC_STYLE_2:///".equals(str2)) && !str.equals(CoverConstants.Color.VIVID_YELLOW))) {
            i = C9086R.color.cover_summary_white_text_color;
            i2 = C9086R.color.cover_summary_white_text_hint_color;
        }
        return new Pair<>(Integer.valueOf(ContextCompat.getColor(context, i)), Integer.valueOf(ContextCompat.getColor(context, i2)));
    }

    private static float getSummaryTextHeight(TextView textView) {
        if (textView.getVisibility() == 8) {
            return -1.0f;
        }
        textView.measure(0, 0);
        float lineHeight = textView.getLineHeight();
        for (int i = 0; i < textView.getLineCount(); i++) {
            textView.getLineBounds(i, new Rect());
            lineHeight = Math.max(lineHeight, r2.height());
        }
        return lineHeight;
    }

    public static Drawable getTemplateDrawable(Context context, String str, String str2) {
        String templateType = getTemplateType(str);
        int iHashCode = templateType.hashCode();
        if (iHashCode != -2132503219) {
            if (iHashCode == -1709661664) {
                templateType.equals(CoverConstants.TemplateType.TEXT.UUID);
            } else if (iHashCode == -73107600 && templateType.equals(CoverConstants.TemplateType.PATTERN.UUID)) {
                return getPatternDrawable(context, str);
            }
        } else if (templateType.equals(CoverConstants.TemplateType.ILLUST.UUID)) {
            return getIllustDrawable(context, str);
        }
        return getTextDrawable(context, str, str2);
    }

    public static String getTemplateType(String str) {
        int iIndexOf = str.indexOf(CoverConstants.VERSION_SEPARATOR);
        if (iIndexOf > 0) {
            str = str.substring(iIndexOf + 5);
        }
        if (str.contains("_")) {
            str = str.substring(0, str.lastIndexOf("_"));
        }
        str.getClass();
        String str2 = CoverConstants.TemplateType.ILLUST.UUID;
        if (!str.equals(CoverConstants.TemplateType.ILLUST.UUID)) {
            str2 = CoverConstants.TemplateType.PATTERN.UUID;
            if (!str.equals(CoverConstants.TemplateType.PATTERN.UUID)) {
                return CoverConstants.TemplateType.TEXT.UUID;
            }
        }
        return str2;
    }

    public static int getTemplateTypeIndex(String str) {
        String templateType = getTemplateType(str);
        templateType.getClass();
        if (templateType.equals(CoverConstants.TemplateType.ILLUST.UUID)) {
            return 2;
        }
        return !templateType.equals(CoverConstants.TemplateType.PATTERN.UUID) ? 3 : 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c7, code lost:
    
        if (r13.equals("BASIC_STYLE_4:///") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ce, code lost:
    
        if (r13.equals("BASIC_STYLE_3:///") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
    
        r12.findDrawableByLayerId(com.samsung.android.support.senl.p148nt.composer.C9086R.id.cover_thumbnail_bg_shape).setTint(r10);
        r12.findDrawableByLayerId(com.samsung.android.support.senl.p148nt.composer.C9086R.id.cover_thumbnail_bg_label).setTint(r0);
        r12.findDrawableByLayerId(com.samsung.android.support.senl.p148nt.composer.C9086R.id.cover_thumbnail_bg_layer).setTint(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a4, code lost:
    
        if (r13.equals("BASIC_STYLE_4:///") != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ab, code lost:
    
        if (r13.equals("BASIC_STYLE_3:///") != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ad, code lost:
    
        r12.findDrawableByLayerId(com.samsung.android.support.senl.p148nt.composer.C9086R.id.cover_thumbnail_bg_layer).setTint(r11);
        r12.findDrawableByLayerId(com.samsung.android.support.senl.p148nt.composer.C9086R.id.cover_thumbnail_bg_shape).setTint(r9);
        r12.findDrawableByLayerId(com.samsung.android.support.senl.p148nt.composer.C9086R.id.cover_thumbnail_bg_label).setTint(r0);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable getTextColorDrawable(Context context, Drawable drawable, String str, String str2) {
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        layerDrawable.mutate();
        if (!str2.contains(CoverConstants.COLOR_SET) && !str2.equals("DEFAULT:///")) {
            int color = context.getColor(C9086R.color.cover_color_label);
            int color2 = context.getColor(C9086R.color.cover_color_strap);
            int color3 = context.getColor(C9086R.color.cover_color_shape);
            int backgroundColor = getBackgroundColor(context, str2);
            switch (str.hashCode()) {
                case -1689747289:
                    str.equals("BASIC_STYLE_1:///");
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
                case -1688823768:
                    str.equals("BASIC_STYLE_2:///");
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
                case -1687900247:
                    break;
                case -1686976726:
                    break;
                case -1686053205:
                    if (str.equals("BASIC_STYLE_5:///")) {
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setTint(color);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_strap).setTint(color2);
                    }
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
                case 378664822:
                    if (str.equals("cover_v2:////BASIC_STYLE_6:///")) {
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_line).setTint(backgroundColor);
                    }
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
                case 379588343:
                    if (str.equals("cover_v2:////BASIC_STYLE_7:///")) {
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setTint(color);
                    }
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
                case 380511864:
                    if (str.equals("cover_v2:////BASIC_STYLE_8:///")) {
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setTint(color3);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setTint(color);
                        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_strap).setTint(color);
                    }
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
                default:
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
                    break;
            }
            return layerDrawable;
        }
        int[] colorSet = getColorSet(str2);
        int color4 = ContextCompat.getColor(context, colorSet[0]);
        int color5 = ContextCompat.getColor(context, colorSet[1]);
        int color6 = ContextCompat.getColor(context, colorSet[2]);
        switch (str.hashCode()) {
            case -1689747289:
                str.equals("BASIC_STYLE_1:///");
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
            case -1688823768:
                if (str.equals("BASIC_STYLE_2:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_line).setTint(color6);
                }
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
            case -1687900247:
                break;
            case -1686976726:
                break;
            case -1686053205:
                if (str.equals("BASIC_STYLE_5:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color5);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setTint(color4);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_strap).setTint(color6);
                }
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
            case 378664822:
                if (str.equals("cover_v2:////BASIC_STYLE_6:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color5);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_line).setTint(color6);
                }
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
            case 379588343:
                if (str.equals("cover_v2:////BASIC_STYLE_7:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color6);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setTint(color4);
                }
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
            case 380511864:
                if (str.equals("cover_v2:////BASIC_STYLE_8:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setTint(color5);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color6);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_strap).setTint(color5);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setTint(color4);
                }
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
            default:
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(color4);
                break;
        }
        return layerDrawable;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable getTextDrawable(Context context, String str, String str2) {
        Drawable drawable;
        switch (str.hashCode()) {
            case -1689747289:
                str.equals("BASIC_STYLE_1:///");
                break;
            case -1688823768:
                drawable = !str.equals("BASIC_STYLE_2:///") ? AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_1) : AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_2);
                break;
            case -1687900247:
                if (str.equals("BASIC_STYLE_3:///")) {
                    drawable = AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_4);
                    break;
                }
                break;
            case -1686976726:
                if (str.equals("BASIC_STYLE_4:///")) {
                    drawable = AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_5);
                    break;
                }
                break;
            case -1686053205:
                if (str.equals("BASIC_STYLE_5:///")) {
                    drawable = AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_7);
                    break;
                }
                break;
            case 378664822:
                if (str.equals("cover_v2:////BASIC_STYLE_6:///")) {
                    drawable = AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_3);
                    break;
                }
                break;
            case 379588343:
                if (str.equals("cover_v2:////BASIC_STYLE_7:///")) {
                    drawable = AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_6);
                    break;
                }
                break;
            case 380511864:
                if (str.equals("cover_v2:////BASIC_STYLE_8:///")) {
                    drawable = AppCompatResources.getDrawable(context, C9086R.drawable.cover_editor_type_text_8);
                    break;
                }
                break;
        }
        return getTextColorDrawable(context, drawable, str, str2);
    }

    public static Drawable getThumbnailDrawable(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = 1;
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeFile(str, options));
    }

    public static String getThumbnailFilePath(Context context, String str, int i, int i2) {
        String existFilePath = null;
        for (String str2 : (ContextUtils.isNightMode(context) && ContentUtils.supportInvertedBGColor(ContentUtils.hasBackgroundColorNotes(i, false), i2)) ? new String[]{Constants.MAIN_DARK_FULL_THUMBNAIL_FILE_NAME, "d_full_thumbnail_text"} : new String[]{Constants.MAIN_FULL_THUMBNAIL_FILE_NAME, "full_thumbnail_text"}) {
            existFilePath = getExistFilePath(context, str, str2);
            if (existFilePath != null) {
                return existFilePath;
            }
        }
        return existFilePath;
    }

    private static void measurePreview(Context context, View view, String str) {
        TextView textView = (TextView) view.findViewById(C9086R.id.text_summary);
        float summaryTextHeight = getSummaryTextHeight(textView);
        view.measure(View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_new_preview_thumbnail_width), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(r2) * 1.0f), 1073741824));
        if (summaryTextHeight != -1.0f) {
            float measuredHeight = textView.getMeasuredHeight() / textView.getMaxLines();
            if (measuredHeight < summaryTextHeight) {
                textView.setLineSpacing(measuredHeight - summaryTextHeight, 1.0f);
            }
        }
        CoverThumbnailCreator.saveCoverFile(context, str, view, CoverThumbnailCreator.ThumbnailType.RECT);
    }

    private static void measurePreviewSquare(Context context, View view, String str) {
        if (view instanceof ConstraintLayout) {
            ConstraintSet constraintSet = new ConstraintSet();
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            constraintSet.clone(constraintLayout);
            constraintSet.applyTo(constraintLayout);
        }
        TextView textView = (TextView) view.findViewById(C9086R.id.text_summary);
        Resources resources = context.getResources();
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        textView.setTextSize(0, resources.getDimensionPixelSize(companion.getInstance().isDexMode(context) ? C9086R.dimen.cover_editor_new_preview_text_summary_font_size_for_dex : C9086R.dimen.cover_editor_new_preview_text_summary_font_size));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDimensionPixelSize(companion.getInstance().isDexMode(context) ? C9086R.dimen.cover_editor_new_preview_thumbnail_width_for_dex : C9086R.dimen.cover_editor_new_preview_thumbnail_width), 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        CoverThumbnailCreator.saveCoverFile(context, str, view, CoverThumbnailCreator.ThumbnailType.SQUARE);
    }

    public static boolean needToApplyWhiteColor(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplaceAll = str.replaceAll(" ", "");
        strReplaceAll.getClass();
        switch (strReplaceAll) {
            case "NAVY:///":
            case "VIVID_BLUE:///":
            case "VIVID_GREEN:///":
            case "VIVID_CORAL:///":
            case "VIVID_ORANGE:///":
            case "VIVID_PURPLE:///":
                if ("DEFAULT:///".equals(str2) || "BASIC_STYLE_1:///".equals(str2) || "BASIC_STYLE_2:///".equals(str2)) {
                    return true;
                }
            default:
                return false;
        }
    }

    @ColorInt
    public static int overlayColor(@ColorInt int i) {
        float f = 23 * 0.4f;
        return Color.rgb(Math.round((Color.red(i) * 0.6f) + f), Math.round((Color.green(i) * 0.6f) + f), Math.round((Color.blue(i) * 0.6f) + f));
    }

    public static void savePreviewJpg(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i) {
        Logger.m10999d(TAG, "savePreviewJpg# uuid : " + str5 + ", state : " + i);
        if (context == null) {
            context = BaseUtils.getApplicationContext();
        }
        View viewInflate = LayoutInflater.from(context).inflate(C9086R.layout.cover_new_preview, (ViewGroup) null);
        viewInflate.findViewById(C9086R.id.cover_preview).setBackground(getTemplateDrawable(context, str3, str4));
        ImageView imageView = (ImageView) viewInflate.findViewById(C9086R.id.cover_line_view);
        if (3 == getTemplateTypeIndex(str3)) {
            if (!TextUtils.isEmpty(str)) {
                TextView textView = (TextView) viewInflate.findViewById(C9086R.id.text_summary);
                textView.setText(str);
                textView.setVisibility(0);
                textView.setTextColor(((Integer) getSummaryColor(context, str4, str3).first).intValue());
            }
            ((ImageView) viewInflate.findViewById(C9086R.id.sticker_icon_view)).setImageDrawable(getCategoryDrawable(context, str2));
            setStickerBackground(viewInflate, str2);
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        viewInflate.setLayoutDirection(3);
        measurePreview(context, viewInflate, str5);
        measurePreviewSquare(context, viewInflate, str5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setBackgroundTemplate(Context context, View view, String str, String str2) {
        String str3;
        if (context == null) {
            return;
        }
        LayerDrawable layerDrawable = (LayerDrawable) ResourcesCompat.getDrawable(context.getResources(), C9086R.drawable.cover_thumbnail_background, null);
        layerDrawable.mutate();
        layerDrawable.setDrawableByLayerId(C9086R.id.cover_thumbnail_bg_line, "BASIC_STYLE_2:///".equals(str) ? ResourcesCompat.getDrawable(context.getResources(), C9086R.drawable.cover_thumbnail_bg_line_2, null) : ResourcesCompat.getDrawable(context.getResources(), C9086R.drawable.cover_thumbnail_bg_line_1, null));
        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_strap).setAlpha("BASIC_STYLE_5:///".equals(str) ? 255 : 0);
        switch (str.hashCode()) {
            case -1689747289:
                str3 = "BASIC_STYLE_1:///";
                str.equals(str3);
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(0);
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(0);
                break;
            case -1688823768:
                str.equals("BASIC_STYLE_2:///");
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(0);
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(0);
                break;
            case -1687900247:
                if (!str.equals("BASIC_STYLE_3:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(0);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(0);
                } else {
                    layerDrawable.setDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape, ResourcesCompat.getDrawable(context.getResources(), C9086R.drawable.cover_thumbnail_bg_shape_1, null));
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(255);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(255);
                }
                break;
            case -1686976726:
                if (str.equals("BASIC_STYLE_4:///")) {
                    layerDrawable.setDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape, ResourcesCompat.getDrawable(context.getResources(), C9086R.drawable.cover_thumbnail_bg_shape_2, null));
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(255);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(255);
                    break;
                }
                break;
            case -1686053205:
                if (str.equals("BASIC_STYLE_5:///")) {
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(0);
                    layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(255);
                    break;
                }
                break;
            case 1716157814:
                str3 = "DEFAULT:///";
                str.equals(str3);
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_shape).setAlpha(0);
                layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_label).setAlpha(0);
                break;
        }
        Logger.m10999d(TAG, "setBackgroundTemplate# colorId : " + str2 + ", templateUuid : " + str);
        layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(getBackgroundColor(context, str2));
        view.findViewById(C9086R.id.cover_preview).setBackground(layerDrawable);
        boolean zNeedToApplyWhiteColor = needToApplyWhiteColor(str2, str);
        int color = context.getColor(zNeedToApplyWhiteColor ? C9086R.color.cover_summary_white_text_color : C9086R.color.cover_summary_text_color);
        EditText editText = (EditText) view.findViewById(C9086R.id.edit_summary);
        editText.setTextColor(color);
        editText.setHintTextColor(context.getColor(zNeedToApplyWhiteColor ? C9086R.color.cover_summary_white_text_hint_color : C9086R.color.cover_summary_text_hint_color));
        ((TextView) view.findViewById(C9086R.id.text_summary)).setTextColor(color);
    }

    private static void setBadgeBackground(View view, String str) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C9086R.id.edit_preview);
        if (CoverStickerConstants.Category.NONE.UUID.equals(str) || NotesDocumentCoverUtils.isHigherCoverVersion(str)) {
            constraintLayout.findViewById(C9086R.id.badge_container).setVisibility(8);
        } else {
            constraintLayout.findViewById(C9086R.id.badge_container).setVisibility(0);
        }
    }

    private static void setLayoutPreview(Context context, View view, String str, String str2, String str3, String str4) {
        ((TextView) view.findViewById(C9086R.id.text_summary)).setText(str);
        ((ImageView) view.findViewById(C9086R.id.edit_badge)).setImageDrawable(getCategoryDrawable(context, str2));
        setBadgeBackground(view, str2);
        setBackgroundTemplate(context, view, str3, str4);
        view.findViewById(C9086R.id.edit_summary).setVisibility(8);
    }

    private static void setStickerBackground(View view, String str) {
        View viewFindViewById = view.findViewById(C9086R.id.sticker_container);
        if (str.equals(CoverStickerConstants.Category.NONE.UUID)) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.findViewById(C9086R.id.sticker_view).setVisibility(0);
        }
    }
}
