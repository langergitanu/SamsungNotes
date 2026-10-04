package p186h1;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p086V.C0322h;

/* JADX INFO: renamed from: h1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12023d {

    /* JADX INFO: renamed from: a */
    public static final String f8776a = "SS$".concat("MigrationPrefUtils");

    /* JADX INFO: renamed from: A */
    public static int m13656A() {
        return SharedPreferencesCompat.getInstance(FTUConstants.PREF_FTU).getInt(FTUConstants.KEY_LAST_USED_COMPOSER_FTU_VERSION, 0);
    }

    /* JADX INFO: renamed from: B */
    public static boolean m13657B() {
        return SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(TipCardUtil.KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED, false);
    }

    /* JADX INFO: renamed from: C */
    public static boolean m13658C() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST, DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()));
    }

    /* JADX INFO: renamed from: D */
    public static int m13659D(Context context) {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_COLOR, context.getResources().getColor(C7943R.color.background_color_white, null));
    }

    /* JADX INFO: renamed from: E */
    public static int m13660E() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 1);
    }

    /* JADX INFO: renamed from: F */
    public static boolean m13661F() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, true);
    }

    /* JADX INFO: renamed from: G */
    public static String m13662G() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
    }

    /* JADX INFO: renamed from: H */
    public static int m13663H() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1);
    }

    /* JADX INFO: renamed from: I */
    public static boolean m13664I() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_QUICK_TOOLS, true);
    }

    /* JADX INFO: renamed from: J */
    public static Set m13665J() {
        return SharedPreferencesCompat.getInstance("Settings").getStringSet(SettingsConstants.RECENT_USED_FROM, new HashSet());
    }

    /* JADX INFO: renamed from: K */
    public static Set m13666K() {
        return SharedPreferencesCompat.getInstance("Settings").getStringSet(SettingsConstants.RECENT_USED_TO, new HashSet());
    }

    /* JADX INFO: renamed from: L */
    public static int m13667L() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, 0);
    }

    /* JADX INFO: renamed from: M */
    public static int m13668M() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
    }

    /* JADX INFO: renamed from: N */
    public static boolean m13669N() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, true);
    }

    /* JADX INFO: renamed from: O */
    public static boolean m13670O() {
        return SharedPreferencesCompat.getInstance("SearchSettings").getBoolean(NotesConstants.KEY_RECENT_SEARCHES, true);
    }

    /* JADX INFO: renamed from: P */
    public static boolean m13671P() {
        return SharedPreferencesCompat.getInstance("SearchSettings").getBoolean(NotesConstants.KEY_RECENT_TAGS, true);
    }

    /* JADX INFO: renamed from: Q */
    public static boolean m13672Q() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, false);
    }

    /* JADX INFO: renamed from: R */
    public static int m13673R() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:262:0x0950 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0965 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX INFO: renamed from: S */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m13674S(String str) {
        String str2;
        Throwable th;
        StringBuilder sb;
        IOException e;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObjectM394i;
        String str3 = "Start to restore preferences. " + AbstractC0299q.m652w(str);
        String str4 = f8776a;
        AbstractC0299q.m643n(str4, str3);
        String strM387b = AbstractC0155m.m387b(str, "preferences.list");
        Context appContext = C0322h.m670a().f815a.getAppContext();
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream = new FileInputStream(strM387b);
            try {
                jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                str2 = "InputStream close - Exception = ";
                fileInputStream2 = fileInputStream;
            } catch (Throwable th2) {
                th = th2;
                str2 = "InputStream close - Exception = ";
                fileInputStream2 = fileInputStream;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "InputStream close - Exception = ";
        } catch (Throwable th3) {
            th = th3;
            str2 = "InputStream close - Exception = ";
        }
        if (jSONObjectM394i != null) {
            fileInputStream2 = fileInputStream;
            try {
                SharedPreferences.Editor editorEdit = appContext.getSharedPreferences("Settings", 0).edit();
                if (jSONObjectM394i.has("settings_spen_only_mode")) {
                    try {
                        boolean z = jSONObjectM394i.getBoolean("settings_spen_only_mode");
                        editorEdit.putBoolean("settings_spen_only_mode", z);
                        AbstractC0299q.m643n(str4, "put settings_spen_only_mode as " + z);
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream3 = fileInputStream2;
                        str2 = "InputStream close - Exception = ";
                        AbstractC0299q.m646q(str4, "Failed to restorePreferences() - " + e.getMessage());
                        if (fileInputStream3 != null) {
                        }
                    } catch (Throwable th4) {
                        fileInputStream3 = fileInputStream2;
                        th = th4;
                        str2 = "InputStream close - Exception = ";
                        if (fileInputStream3 != null) {
                        }
                    }
                }
                if (jSONObjectM394i.has("settings_shape_recognition_mode")) {
                    boolean z2 = jSONObjectM394i.getBoolean("settings_shape_recognition_mode");
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES, z2);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_auto_fix_shapes as " + z2);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_NOTES_ASSIST)) {
                    boolean z3 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST, z3);
                    AbstractC0299q.m643n(str4, "put settings_notes_assist as " + z3);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE)) {
                    int i = jSONObjectM394i.getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE);
                    editorEdit.putInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, i);
                    AbstractC0299q.m643n(str4, "put settings_pen_color_for_saved_notes as " + i);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE)) {
                    int i2 = jSONObjectM394i.getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE);
                    editorEdit.putInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, i2);
                    AbstractC0299q.m643n(str4, "put settings_preferred_note_style as " + i2);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_PAGE_SIZE)) {
                    int i4 = jSONObjectM394i.getInt(SettingsConstants.SETTINGS_PAGE_SIZE);
                    editorEdit.putInt(SettingsConstants.SETTINGS_PAGE_SIZE, i4);
                    AbstractC0299q.m643n(str4, "put settings_page_size as " + i4);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION)) {
                    boolean z4 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, z4);
                    AbstractC0299q.m643n(str4, "put settings_page_scroll_direction as " + z4);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN)) {
                    int i5 = jSONObjectM394i.getInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN);
                    editorEdit.putInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, i5);
                    AbstractC0299q.m643n(str4, "put settings_page_layout_column as " + i5);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_TEMPLATE_TYPE)) {
                    int i6 = jSONObjectM394i.getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE);
                    editorEdit.putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, i6);
                    AbstractC0299q.m643n(str4, "put settings_template_type as " + i6);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_PAGE_TEMPLATE)) {
                    String string = jSONObjectM394i.getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE);
                    editorEdit.putString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, string);
                    AbstractC0299q.m643n(str4, "put settings_page_template as " + string);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_PAGE_COLOR)) {
                    int i7 = jSONObjectM394i.getInt(SettingsConstants.SETTINGS_PAGE_COLOR);
                    editorEdit.putInt(SettingsConstants.SETTINGS_PAGE_COLOR, i7);
                    AbstractC0299q.m643n(str4, "put settings_page_color as " + i7);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES)) {
                    boolean z5 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, z5);
                    AbstractC0299q.m643n(str4, "put settings_auto_save_notes as " + z5);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE)) {
                    boolean z6 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, z6);
                    AbstractC0299q.m643n(str4, "put settings_auto_detect_language as " + z6);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES)) {
                    boolean z7 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, z7);
                    AbstractC0299q.m643n(str4, "put settings_show_links_in_notes as " + z7);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS)) {
                    boolean z8 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, z8);
                    AbstractC0299q.m643n(str4, "put settings_show_web_previews as " + z8);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_CLIPPING_OPTIONS)) {
                    boolean z9 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, z9);
                    AbstractC0299q.m643n(str4, "put settings_clipping_options as " + z9);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ACTION_ICONS)) {
                    boolean z10 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ACTION_ICONS);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ACTION_ICONS, z10);
                    AbstractC0299q.m643n(str4, "put settings_action_icons as " + z10);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING)) {
                    boolean z11 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, z11);
                    AbstractC0299q.m643n(str4, "put settings_hide_scroll_bar_when_editing as " + z11);
                }
                if (CommonUtils.isSupportHideNavigationOption() && jSONObjectM394i.has(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING)) {
                    boolean z12 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, z12);
                    AbstractC0299q.m643n(str4, "put settings_hide_navigation_bar_when_writing as " + z12);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING)) {
                    boolean z13 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, z13);
                    AbstractC0299q.m643n(str4, "put settings_block_back_key_while_editing as " + z13);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_QUICK_TOOLS)) {
                    boolean z14 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_QUICK_TOOLS);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_QUICK_TOOLS, z14);
                    AbstractC0299q.m643n(str4, "put settings_quick_tools as " + z14);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE)) {
                    String string2 = jSONObjectM394i.getString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE);
                    editorEdit.putString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, string2);
                    AbstractC0299q.m643n(str4, "put settings_handwriting_recognition_language as " + string2);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
                    boolean z15 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, z15);
                    AbstractC0299q.m643n(str4, "put settings_handwriting_recognition as " + z15);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_CLEAN_UP_AND_CONVERT_TEXT)) {
                    boolean z16 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_CLEAN_UP_AND_CONVERT_TEXT);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_CLEAN_UP_AND_CONVERT_TEXT, z16);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_clean_up_and_convert_text as " + z16);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_SPEN_TO_TEXT)) {
                    boolean z17 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_SPEN_TO_TEXT);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_SPEN_TO_TEXT, z17);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_spen_to_text as " + z17);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_STRAIGHTEN)) {
                    boolean z18 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_STRAIGHTEN);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_STRAIGHTEN, z18);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_straighten as " + z18);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_PEN_STYLE)) {
                    boolean z19 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_PEN_STYLE);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_PEN_STYLE, z19);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_pen_style as " + z19);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_CONVERT_TO_TEXT)) {
                    boolean z20 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_CONVERT_TO_TEXT);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_CONVERT_TO_TEXT, z20);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_convert_to_text as " + z20);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES)) {
                    boolean z21 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES, z21);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_auto_fix_shapes as " + z21);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_EASY_WRITING_PAD)) {
                    boolean z22 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_EASY_WRITING_PAD);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_EASY_WRITING_PAD, z22);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_easy_writing_pad as " + z22);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_LOCK_CANVAS)) {
                    boolean z23 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_LOCK_CANVAS);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_LOCK_CANVAS, z23);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_lock_canvas as " + z23);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_ASSISTANCE)) {
                    boolean z24 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_ASSISTANCE);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_ASSISTANCE, z24);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_assistance as " + z24);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_ADD_ONS_LASER_POINTER)) {
                    boolean z25 = jSONObjectM394i.getBoolean(SettingsConstants.SETTINGS_ADD_ONS_LASER_POINTER);
                    editorEdit.putBoolean(SettingsConstants.SETTINGS_ADD_ONS_LASER_POINTER, z25);
                    AbstractC0299q.m643n(str4, "put settings_add_ons_laser_pointer as " + z25);
                }
                if (jSONObjectM394i.has(SettingsConstants.RECENT_USED_FROM)) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = jSONObjectM394i.getJSONArray(SettingsConstants.RECENT_USED_FROM);
                    int length = jSONArray.length();
                    for (int i8 = 0; i8 < length; i8++) {
                        hashSet.add((String) jSONArray.get(i8));
                    }
                    editorEdit.putStringSet(SettingsConstants.RECENT_USED_FROM, hashSet);
                    AbstractC0299q.m643n(str4, "put RECENT_USED_FROM as " + hashSet.size());
                }
                if (jSONObjectM394i.has(SettingsConstants.RECENT_USED_TO)) {
                    HashSet hashSet2 = new HashSet();
                    JSONArray jSONArray2 = jSONObjectM394i.getJSONArray(SettingsConstants.RECENT_USED_TO);
                    int length2 = jSONArray2.length();
                    for (int i9 = 0; i9 < length2; i9++) {
                        hashSet2.add((String) jSONArray2.get(i9));
                    }
                    editorEdit.putStringSet(SettingsConstants.RECENT_USED_TO, hashSet2);
                    AbstractC0299q.m643n(str4, "put RECENT_USED_TO as " + hashSet2.size());
                }
                if (jSONObjectM394i.has("custom_toolbar_item_order")) {
                    String string3 = jSONObjectM394i.getString("custom_toolbar_item_order");
                    editorEdit.putString(SettingsConstants.SETTINGS_TOOLBAR_ITEM_ORDER, string3);
                    AbstractC0299q.m643n(str4, "put custom_toolbar_item_order as " + string3);
                }
                if (jSONObjectM394i.has("custom_toolbar_candidate_item_order")) {
                    String string4 = jSONObjectM394i.getString("custom_toolbar_candidate_item_order");
                    editorEdit.putString(SettingsConstants.SETTINGS_CANDIDATE_TOOLBAR_ITEM_ORDER, string4);
                    AbstractC0299q.m643n(str4, "put custom_toolbar_candidate_item_order as " + string4);
                }
                editorEdit.apply();
                SharedPreferences.Editor editorEdit2 = appContext.getSharedPreferences(Constants.APP_LAUNCH_PREFERENCE, 0).edit();
                if (jSONObjectM394i.has(NotesConstants.KEY_ORDER_BY)) {
                    if (jSONObjectM394i.has(NotesConstants.KEY_SORT_BY)) {
                        int i10 = jSONObjectM394i.getInt(NotesConstants.KEY_SORT_BY);
                        editorEdit2.putInt(NotesConstants.KEY_SORT_BY, i10);
                        AbstractC0299q.m643n(str4, "put sortby as " + i10);
                    }
                    int i11 = jSONObjectM394i.getInt(NotesConstants.KEY_ORDER_BY);
                    editorEdit2.putInt(NotesConstants.KEY_ORDER_BY, i11);
                    AbstractC0299q.m643n(str4, "put orderby as " + i11);
                } else if (jSONObjectM394i.has(NotesConstants.KEY_SORT_BY)) {
                    int i12 = jSONObjectM394i.getInt(NotesConstants.KEY_SORT_BY);
                    int iM13680c = m13680c(i12);
                    editorEdit2.putInt(NotesConstants.KEY_SORT_BY, iM13680c);
                    AbstractC0299q.m643n(str4, "put sortby as " + iM13680c);
                    int iM13679b = m13679b(i12);
                    editorEdit2.putInt(NotesConstants.KEY_ORDER_BY, iM13679b);
                    AbstractC0299q.m643n(str4, "put orderby as " + iM13679b);
                }
                if (jSONObjectM394i.has(NotesConstants.KEY_PIN_FAVORITES)) {
                    boolean z26 = jSONObjectM394i.getBoolean(NotesConstants.KEY_PIN_FAVORITES);
                    editorEdit2.putBoolean(NotesConstants.KEY_PIN_FAVORITES, z26);
                    AbstractC0299q.m643n(str4, "put pin_favorites as " + z26);
                }
                if (jSONObjectM394i.has("view_mode")) {
                    int i13 = jSONObjectM394i.getInt("view_mode");
                    if (ContentUtils.isSimpleViewMode(i13)) {
                        i13 = ModelFeature.getFeature().needNoThumbnailSimpleList() ? 6 : 3;
                    }
                    editorEdit2.putInt("view_mode", i13);
                    AbstractC0299q.m643n(str4, "put view_mode as " + i13);
                }
                if (jSONObjectM394i.has(TipCardUtil.KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED)) {
                    boolean z27 = jSONObjectM394i.getBoolean(TipCardUtil.KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED);
                    editorEdit2.putBoolean(TipCardUtil.KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED, z27);
                    AbstractC0299q.m643n(str4, "put key_microsoft_feed_login_tipcard_canceled as " + z27);
                }
                if (jSONObjectM394i.has("coedit_note_sync_type")) {
                    String string5 = jSONObjectM394i.getString("coedit_note_sync_type");
                    C0145c.m305M(appContext, string5);
                    AbstractC0299q.m643n(str4, "put coedit_note_sync_type as " + string5);
                }
                if (jSONObjectM394i.has(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE)) {
                    String string6 = jSONObjectM394i.getString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE);
                    m13675T(appContext, string6);
                    AbstractC0299q.m643n(str4, "put settings_default_editing_mode as " + string6);
                }
                editorEdit2.apply();
                SharedPreferences.Editor editorEdit3 = appContext.getSharedPreferences(appContext.getPackageName() + "com.samsung.android.app.notes_spensettings0_2", 0).edit();
                if (jSONObjectM394i.has("KEY_SETTING_FAVORITEPEN_INFO")) {
                    String string7 = jSONObjectM394i.getString("KEY_SETTING_FAVORITEPEN_INFO");
                    editorEdit3.putString("KEY_SETTING_FAVORITEPEN_INFO", string7);
                    AbstractC0299q.m643n(str4, "put KEY_SETTING_FAVORITEPEN_INFO as " + string7);
                }
                editorEdit3.apply();
                SharedPreferences.Editor editorEdit4 = appContext.getSharedPreferences(FTUConstants.PREF_FTU, 0).edit();
                if (jSONObjectM394i.has(FTUConstants.KEY_LAST_USED_COMPOSER_FTU_VERSION)) {
                    int i14 = jSONObjectM394i.getInt(FTUConstants.KEY_LAST_USED_COMPOSER_FTU_VERSION);
                    editorEdit4.putInt(FTUConstants.KEY_LAST_USED_COMPOSER_FTU_VERSION, i14);
                    AbstractC0299q.m643n(str4, "put key_last_used_ftu_version as " + i14);
                }
                editorEdit4.apply();
                SharedPreferences.Editor editorEdit5 = appContext.getSharedPreferences("SearchSettings", 0).edit();
                if (jSONObjectM394i.has(NotesConstants.KEY_RECENT_TAGS)) {
                    boolean z28 = jSONObjectM394i.getBoolean(NotesConstants.KEY_RECENT_TAGS);
                    editorEdit5.putBoolean(NotesConstants.KEY_RECENT_TAGS, z28);
                    AbstractC0299q.m643n(str4, "put recent_tags as " + z28);
                }
                if (jSONObjectM394i.has(NotesConstants.KEY_RECENT_SEARCHES)) {
                    boolean z29 = jSONObjectM394i.getBoolean(NotesConstants.KEY_RECENT_SEARCHES);
                    editorEdit5.putBoolean(NotesConstants.KEY_RECENT_SEARCHES, z29);
                    AbstractC0299q.m643n(str4, "put recent_searches as " + z29);
                }
                editorEdit5.apply();
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    e = e6;
                    sb = new StringBuilder("InputStream close - Exception = ");
                    sb.append(e);
                    AbstractC0299q.m646q(str4, sb.toString());
                }
            } catch (Exception e7) {
                e = e7;
                str2 = "InputStream close - Exception = ";
                fileInputStream3 = fileInputStream2;
                AbstractC0299q.m646q(str4, "Failed to restorePreferences() - " + e.getMessage());
                if (fileInputStream3 != null) {
                }
                AbstractC0299q.m643n(str4, "End to restore preferences.");
            } catch (Throwable th5) {
                th = th5;
                str2 = "InputStream close - Exception = ";
                fileInputStream3 = fileInputStream2;
                th = th;
                if (fileInputStream3 != null) {
                }
            }
            AbstractC0299q.m643n(str4, "End to restore preferences.");
        }
        try {
            AbstractC0299q.m643n(str4, "[pref] json obj is null");
            fileInputStream.close();
            try {
                fileInputStream.close();
            } catch (IOException e8) {
                AbstractC0299q.m646q(str4, "InputStream close - Exception = " + e8);
            }
        } catch (Exception e9) {
            e = e9;
            str2 = "InputStream close - Exception = ";
            fileInputStream3 = fileInputStream;
            try {
                AbstractC0299q.m646q(str4, "Failed to restorePreferences() - " + e.getMessage());
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e10) {
                        e = e10;
                        sb = new StringBuilder(str2);
                        sb.append(e);
                        AbstractC0299q.m646q(str4, sb.toString());
                    }
                }
                AbstractC0299q.m643n(str4, "End to restore preferences.");
            } catch (Throwable th6) {
                th = th6;
                th = th;
                if (fileInputStream3 != null) {
                    throw th;
                }
                try {
                    fileInputStream3.close();
                    throw th;
                } catch (IOException e11) {
                    AbstractC0299q.m646q(str4, str2 + e11);
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = "InputStream close - Exception = ";
            fileInputStream3 = fileInputStream;
            if (fileInputStream3 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: T */
    public static void m13675T(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, str);
        editorEdit.apply();
        AbstractC0299q.m643n(f8776a, "save as settings_default_editing_mode= " + str);
    }

    /* JADX INFO: renamed from: U */
    public static void m13676U(int i) {
        SharedPreferences.Editor editorEdit = C0322h.m670a().f815a.getAppContext().getSharedPreferences("SAMSUNGNOTE_MIGRATION_PREFERENCES", 0).edit();
        editorEdit.putInt("exception_count", i);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: V */
    public static void m13677V(int i) {
        SharedPreferences.Editor editorEdit = C0322h.m670a().f815a.getAppContext().getSharedPreferences("SAMSUNGNOTE_MIGRATION_PREFERENCES", 0).edit();
        editorEdit.putInt("retry_count", i);
        editorEdit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0680 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m13678a(String str) {
        Throwable th;
        String str2;
        String str3 = f8776a;
        AbstractC0299q.m643n(str3, "Start backupPreferences.");
        Context appContext = C0322h.m670a().f815a.getAppContext();
        FileOutputStream fileOutputStream = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES, appContext.getSharedPreferences("Settings", 0).getBoolean(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES, true));
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(Constants.APP_LAUNCH_PREFERENCE, 0);
            int i = sharedPreferences.getInt(NotesConstants.KEY_SORT_BY, 2);
            AbstractC0299q.m643n(str3, "backup preference sortby : " + i);
            jSONObject.put(NotesConstants.KEY_SORT_BY, i);
            int i2 = sharedPreferences.getInt(NotesConstants.KEY_ORDER_BY, 5);
            AbstractC0299q.m643n(str3, "backup preference orderby : " + i2);
            jSONObject.put(NotesConstants.KEY_ORDER_BY, i2);
            boolean z = sharedPreferences.getBoolean(NotesConstants.KEY_PIN_FAVORITES, false);
            AbstractC0299q.m643n(str3, "backup preference pin_favorites : " + z);
            jSONObject.put(NotesConstants.KEY_PIN_FAVORITES, z);
            int i4 = sharedPreferences.getInt("view_mode", -1);
            AbstractC0299q.m643n(str3, "backup preference view_mode : " + i4);
            if (i4 != -1) {
                jSONObject.put("view_mode", ContentUtils.getViewMode());
            }
            jSONObject.put("KEY_SETTING_FAVORITEPEN_INFO", appContext.getSharedPreferences(appContext.getPackageName() + "com.samsung.android.app.notes_spensettings0_2", 0).getString("KEY_SETTING_FAVORITEPEN_INFO", ""));
            boolean zM13657B = m13657B();
            jSONObject.put(TipCardUtil.KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED, zM13657B);
            AbstractC0299q.m643n(str3, "backup microsoftFeedLoginTipCardCanceled : " + zM13657B);
            String strM324i = C0145c.m324i(appContext);
            jSONObject.put("coedit_note_sync_type", strM324i);
            AbstractC0299q.m643n(str3, "backup coeditNoteSyncType : " + strM324i);
            boolean zM13658C = m13658C();
            jSONObject.put(SettingsConstants.SETTINGS_NOTES_ASSIST, zM13658C);
            AbstractC0299q.m643n(str3, "backup notesAssist : " + zM13658C);
            int iM13667L = m13667L();
            jSONObject.put(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, iM13667L);
            AbstractC0299q.m643n(str3, "backup screenOffMemoStyle : " + iM13667L);
            String strM13698u = m13698u();
            jSONObject.put(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, strM13698u);
            AbstractC0299q.m643n(str3, "backup defaultEditingMode : " + strM13698u);
            int iM13663H = m13663H();
            jSONObject.put(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, iM13663H);
            AbstractC0299q.m643n(str3, "backup preferredNoteStyle : " + iM13663H);
            int iM13668M = m13668M();
            jSONObject.put(SettingsConstants.SETTINGS_PAGE_SIZE, iM13668M);
            AbstractC0299q.m643n(str3, "backup settingsPageSize : " + iM13668M);
            boolean zM13661F = m13661F();
            jSONObject.put(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, zM13661F);
            AbstractC0299q.m643n(str3, "backup pageScrollDirection : " + zM13661F);
            int iM13660E = m13660E();
            jSONObject.put(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, iM13660E);
            AbstractC0299q.m643n(str3, "backup pageLayoutColumn : " + iM13660E);
            int iM13673R = m13673R();
            jSONObject.put(SettingsConstants.SETTINGS_TEMPLATE_TYPE, iM13673R);
            AbstractC0299q.m643n(str3, "backup templateType : " + iM13673R);
            String strM13662G = m13662G();
            jSONObject.put(SettingsConstants.SETTINGS_PAGE_TEMPLATE, strM13662G);
            AbstractC0299q.m643n(str3, "backup pageTemplate : " + strM13662G);
            int iM13659D = m13659D(appContext);
            jSONObject.put(SettingsConstants.SETTINGS_PAGE_COLOR, iM13659D);
            AbstractC0299q.m643n(str3, "backup pageColor : " + iM13659D);
            boolean zM13693p = m13693p();
            jSONObject.put(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, zM13693p);
            AbstractC0299q.m643n(str3, "backup autoSaveNotes : " + zM13693p);
            boolean zM13692o = m13692o();
            jSONObject.put(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, zM13692o);
            AbstractC0299q.m643n(str3, "backup autoDetectLanguage : " + zM13692o);
            boolean zM13669N = m13669N();
            jSONObject.put(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, zM13669N);
            AbstractC0299q.m643n(str3, "backup showLinksInNotes : " + zM13669N);
            boolean zM13672Q = m13672Q();
            jSONObject.put(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, zM13672Q);
            AbstractC0299q.m643n(str3, "backup showWebPreviews : " + zM13672Q);
            boolean zM13695r = m13695r();
            jSONObject.put(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, zM13695r);
            AbstractC0299q.m643n(str3, "backup clippingOptions : " + zM13695r);
            boolean zM13681d = m13681d();
            jSONObject.put(SettingsConstants.SETTINGS_ACTION_ICONS, zM13681d);
            AbstractC0299q.m643n(str3, "backup actionIcon : " + zM13681d);
            boolean zM13703z = m13703z();
            jSONObject.put(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, zM13703z);
            AbstractC0299q.m643n(str3, "backup hideScrollBarWhileEditing : " + zM13703z);
            boolean zM13702y = m13702y();
            jSONObject.put(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, zM13702y);
            AbstractC0299q.m643n(str3, "backup hideNavigationBarWhileWriting : " + zM13702y);
            boolean zM13694q = m13694q();
            jSONObject.put(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, zM13694q);
            AbstractC0299q.m643n(str3, "backup blockBackKeyWhileEditing : " + zM13694q);
            boolean zM13664I = m13664I();
            jSONObject.put(SettingsConstants.SETTINGS_QUICK_TOOLS, zM13664I);
            AbstractC0299q.m643n(str3, "backup quickTools : " + zM13664I);
            String strM13701x = m13701x();
            jSONObject.put(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, strM13701x);
            AbstractC0299q.m643n(str3, "backup HWRecognitionLanguage : " + strM13701x);
            boolean zM13700w = m13700w();
            jSONObject.put(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, zM13700w);
            AbstractC0299q.m643n(str3, "backup HWRecognition : " + zM13700w);
            boolean zM13684g = m13684g();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_CLEAN_UP_AND_CONVERT_TEXT, zM13684g);
            AbstractC0299q.m643n(str3, "backup addOnsCleanUpAndConvertText : " + zM13684g);
            boolean zM13689l = m13689l();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_SPEN_TO_TEXT, zM13689l);
            AbstractC0299q.m643n(str3, "backup addOnsSpenToText : " + zM13689l);
            boolean zM13690m = m13690m();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_STRAIGHTEN, zM13690m);
            AbstractC0299q.m643n(str3, "backup addOnsStraightens : " + zM13690m);
            boolean zM13688k = m13688k();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_PEN_STYLE, zM13688k);
            AbstractC0299q.m643n(str3, "backup addOnsPenStyle : " + zM13688k);
            boolean zM13685h = m13685h();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_CONVERT_TO_TEXT, zM13685h);
            AbstractC0299q.m643n(str3, "backup addOnsConvertToText : " + zM13685h);
            boolean zM13683f = m13683f();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES, zM13683f);
            AbstractC0299q.m643n(str3, "backup addOnsAutoFixShapes : " + zM13683f);
            boolean zM13686i = m13686i();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_EASY_WRITING_PAD, zM13686i);
            AbstractC0299q.m643n(str3, "backup addOnsEasyWritingPad : " + zM13686i);
            boolean zM13691n = m13691n();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_LOCK_CANVAS, zM13691n);
            AbstractC0299q.m643n(str3, "backup addOnsLockCanvas : " + zM13691n);
            boolean zM13682e = m13682e();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_ASSISTANCE, zM13682e);
            AbstractC0299q.m643n(str3, "backup addOnsAssistance : " + zM13682e);
            boolean zM13687j = m13687j();
            jSONObject.put(SettingsConstants.SETTINGS_ADD_ONS_LASER_POINTER, zM13687j);
            AbstractC0299q.m643n(str3, "backup addOnsLaserPointer : " + zM13687j);
            Set setM13665J = m13665J();
            if (!setM13665J.isEmpty()) {
                AbstractC0299q.m643n(str3, "backup addRecentUsedFromLanguage : " + setM13665J.size());
                JSONArray jSONArray = new JSONArray();
                Iterator it = setM13665J.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put(SettingsConstants.RECENT_USED_FROM, jSONArray);
            }
            Set setM13666K = m13666K();
            if (!setM13666K.isEmpty()) {
                AbstractC0299q.m643n(str3, "backup addRecentUsedToLanguage : " + setM13666K.size());
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = setM13666K.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put((String) it2.next());
                }
                jSONObject.put(SettingsConstants.RECENT_USED_TO, jSONArray2);
            }
            int iM13656A = m13656A();
            jSONObject.put(FTUConstants.KEY_LAST_USED_COMPOSER_FTU_VERSION, iM13656A);
            AbstractC0299q.m643n(str3, "backup lastUsedFtuVersion : " + iM13656A);
            boolean zM13671P = m13671P();
            jSONObject.put(NotesConstants.KEY_RECENT_TAGS, zM13671P);
            AbstractC0299q.m643n(str3, "backup showRecentTags : " + zM13671P);
            boolean zM13670O = m13670O();
            jSONObject.put(NotesConstants.KEY_RECENT_SEARCHES, zM13670O);
            AbstractC0299q.m643n(str3, "backup showRecentSearches : " + zM13670O);
            String strM13697t = m13697t();
            jSONObject.put("custom_toolbar_item_order", strM13697t);
            AbstractC0299q.m643n(str3, "backup customToolbarItemOrder : " + strM13697t);
            String strM13696s = m13696s();
            jSONObject.put("custom_toolbar_candidate_item_order", strM13696s);
            AbstractC0299q.m643n(str3, "backup customToolbarCandidateItemOrder : " + strM13696s);
            File file = new File(AbstractC0155m.m387b(str, "preferences.list"));
            if (file.exists() && !file.delete()) {
                AbstractC0299q.m646q(str3, "Failed to delete preferences.list file.");
            }
            if (file.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                    fileOutputStream2.close();
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        AbstractC0299q.m646q(str3, "Failed to backupPreferences. " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                AbstractC0000a.m1B(e2, new StringBuilder("Failed to close fos. "), str3);
                            }
                        }
                    } catch (Throwable th2) {
                        str2 = "Failed to close fos. ";
                        th = th2;
                        if (fileOutputStream != null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e3) {
                            AbstractC0000a.m1B(e3, new StringBuilder(str2), str3);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    str2 = "Failed to close fos. ";
                    if (fileOutputStream != null) {
                    }
                }
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
        }
        AbstractC0299q.m643n(str3, "Finish backupPreferences.");
    }

    /* JADX INFO: renamed from: b */
    public static int m13679b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return 4;
        }
        return 5;
    }

    /* JADX INFO: renamed from: c */
    public static int m13680c(int i) {
        if (i == 0 || i == 1) {
            return 2;
        }
        return (i == 2 || i == 3) ? 1 : 0;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m13681d() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ACTION_ICONS, true);
    }

    /* JADX INFO: renamed from: e */
    public static boolean m13682e() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_ASSISTANCE, true);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m13683f() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_AUTO_FIX_SHAPES, true);
    }

    /* JADX INFO: renamed from: g */
    public static boolean m13684g() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_CLEAN_UP_AND_CONVERT_TEXT, true);
    }

    /* JADX INFO: renamed from: h */
    public static boolean m13685h() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_CONVERT_TO_TEXT, true);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m13686i() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_EASY_WRITING_PAD, true);
    }

    /* JADX INFO: renamed from: j */
    public static boolean m13687j() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_LASER_POINTER, true);
    }

    /* JADX INFO: renamed from: k */
    public static boolean m13688k() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_PEN_STYLE, true);
    }

    /* JADX INFO: renamed from: l */
    public static boolean m13689l() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_SPEN_TO_TEXT, true);
    }

    /* JADX INFO: renamed from: m */
    public static boolean m13690m() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_STRAIGHTEN, true);
    }

    /* JADX INFO: renamed from: n */
    public static boolean m13691n() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ADD_ONS_LOCK_CANVAS, true);
    }

    /* JADX INFO: renamed from: o */
    public static boolean m13692o() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, true);
    }

    /* JADX INFO: renamed from: p */
    public static boolean m13693p() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, true);
    }

    /* JADX INFO: renamed from: q */
    public static boolean m13694q() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, false);
    }

    /* JADX INFO: renamed from: r */
    public static boolean m13695r() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, true);
    }

    /* JADX INFO: renamed from: s */
    public static String m13696s() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_CANDIDATE_TOOLBAR_ITEM_ORDER, "");
    }

    /* JADX INFO: renamed from: t */
    public static String m13697t() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_TOOLBAR_ITEM_ORDER, "");
    }

    /* JADX INFO: renamed from: u */
    public static String m13698u() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO);
    }

    /* JADX INFO: renamed from: v */
    public static int m13699v() {
        return C0322h.m670a().f815a.getAppContext().getSharedPreferences("SAMSUNGNOTE_MIGRATION_PREFERENCES", 0).getInt("exception_count", 0);
    }

    /* JADX INFO: renamed from: w */
    public static boolean m13700w() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, true);
    }

    /* JADX INFO: renamed from: x */
    public static String m13701x() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, null);
    }

    /* JADX INFO: renamed from: y */
    public static boolean m13702y() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, CommonUtils.isDefaultHideNavigationOptionEnabled());
    }

    /* JADX INFO: renamed from: z */
    public static boolean m13703z() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, false);
    }
}
