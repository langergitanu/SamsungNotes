package com.samsung.android.support.senl.p148nt.app.settings.externalsearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.settings.search.provider.SecSearchIndexablesContract;
import com.samsung.android.settings.search.provider.SecSearchIndexablesProvider;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.SettingsActivity;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.SettingsAdvancedFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsImportPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsPasswordAndBiometricsFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsScreenOffMemoStyleFragment;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainFragment;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010#\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J%\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u0004\u0018\u00010\u001d2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010$J\u001d\u0010%\u001a\u00020\u001d2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010$J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0002J>\u0010/\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0002JS\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001f2\u0006\u00107\u001a\u00020\u00062\b\b\u0001\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001f\"\u00020\u0006H\u0002¢\u0006\u0002\u0010;J]\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001f2\u0006\u00107\u001a\u00020\u00062\b\b\u0001\u00108\u001a\u00020\u00072\b\b\u0001\u0010<\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001f\"\u00020\u0006H\u0003¢\u0006\u0002\u0010=Je\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001f2\u0006\u00107\u001a\u00020\u00062\b\b\u0001\u00108\u001a\u00020\u00072\b\b\u0001\u0010<\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001f\"\u00020\u0006H\u0003¢\u0006\u0002\u0010?J\u001d\u0010@\u001a\u00020\u001d2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010$J\u0016\u0010A\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010D\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010E\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010G\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010H\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010I\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010J\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u0016\u0010K\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002J\u001d\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001f2\u0006\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\u001dH\u0016J5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001f2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010TJ%\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001f2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020WH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchProvider;", "Lcom/samsung/android/settings/search/provider/SecSearchIndexablesProvider;", "<init>", "()V", "mSettingsMainScreenMenus", "", "", "", "mSettingsAdvancedScreenMenus", "mSettingsImportScreenMenus", "mSettingsScreenOffMemoStyleScreenMenus", "mSettingsLockScreenMenus", "mSettingsNoteAssistScreenMenus", "mSettingsGlobalIntelligenceScreenMenus", "onCreate", "", "initMainScreenMenus", "", "initAdvancedScreenMenus", "initImportScreenMenus", "initScreenOffMemoStyleMenus", "initLockScreenMenus", "initNoteAssistMenu", "initGlobalIntelligenceMenu", "secQueryGetFingerprint", "secQueryAvailability", "extra", "Landroid/os/Bundle;", "secQueryNonIndexableKeys", "Landroid/database/Cursor;", "projection", "", "extras", "([Ljava/lang/String;Landroid/os/Bundle;)Landroid/database/Cursor;", "queryXmlResources", "strings", "([Ljava/lang/String;)Landroid/database/Cursor;", "queryRawData", "addSettingMainMenu", "cursor", "Landroid/database/MatrixCursor;", "addSettingAdvancedMenu", "addSettingImportMenu", "addSettingScreenOffMemoStyleMenu", "addSettingLockMenu", "addNoteAssistMenu", "addGlobalIntelligenceMenu", "addSettingMenus", "settingMenus", "", "settingScreenTitle", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "targetClassName", "getIndexableTuple", "", "keyValue", "titleResId", SearchIndexablesContract.RawData.COLUMN_SCREEN_TITLE, SearchIndexablesContract.RawData.COLUMN_KEYWORDS, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/Object;", SearchIndexablesContract.BaseColumns.COLUMN_ICON_RESID, "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/Object;", "action", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/Object;", "queryNonIndexableKeys", "querySyncMenuNonIndexableKeys", "nonIndexableKeys", "", "queryGeneralMenuNonIndexableKeys", "queryIntelligenceMenuNonIndexableKeys", "queryAdvancedMenuNonIndexableKeys", "queryPermissionsMenuNonIndexableKeys", "queryContactUsMenuNonIndexableKeys", "queryImportMenuNonIndexableKeys", "queryNoteAssistMenuNonIndexableKeys", "queryGlobalIntelligenceMenuNonIndexableKeys", "getNonIndexableTuple", "(Ljava/lang/String;)[Ljava/lang/Object;", "querySiteMapPairs", "getSiteMapPairTuple", "parentClassName", "parentClassTitle", "childClassName", "childClassTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getSearchContext", "Landroid/content/Context;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsSearchProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsSearchProvider.kt\ncom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchProvider\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,722:1\n37#2:723\n36#2,3:724\n*S KotlinDebug\n*F\n+ 1 SettingsSearchProvider.kt\ncom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchProvider\n*L\n451#1:723\n451#1:724,3\n*E\n"})
public final class SettingsSearchProvider extends SecSearchIndexablesProvider {

    @NotNull
    private static final String GLOBAL_SETTINGS_INTELLIGENCE_SERVICE = "com.samsung.android.settings.usefulfeature.intelligenceservice.IntelligenceServiceSettings";

    @NotNull
    private static final String SETTINGS_ALIAS_ACTIVITY_NAME = "com.samsung.android.app.notes.app.settings.SettingsAliasActivity";

    @NotNull
    private static final String TAG = "SettingsSearchProvider";

    @NotNull
    private static final String TOP_LEVEL_SETTINGS_MAIN_SCREEN = "top_level_settings_main_screen";

    @NotNull
    private final Map<String, Integer> mSettingsMainScreenMenus = new HashMap();

    @NotNull
    private final Map<String, Integer> mSettingsAdvancedScreenMenus = new HashMap();

    @NotNull
    private final Map<String, Integer> mSettingsImportScreenMenus = new HashMap();

    @NotNull
    private final Map<String, Integer> mSettingsScreenOffMemoStyleScreenMenus = new HashMap();

    @NotNull
    private final Map<String, Integer> mSettingsLockScreenMenus = new HashMap();

    @NotNull
    private final Map<String, Integer> mSettingsNoteAssistScreenMenus = new HashMap();

    @NotNull
    private final Map<String, Integer> mSettingsGlobalIntelligenceScreenMenus = new HashMap();

    private final void addGlobalIntelligenceMenu(MatrixCursor cursor) {
        Map<String, Integer> map = this.mSettingsGlobalIntelligenceScreenMenus;
        String string = getSearchContext().getString(SettingsMenuUtils.INSTANCE.getSamsungNotesAppLabelRes());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        addSettingMenus(cursor, map, string, SETTINGS_ALIAS_ACTIVITY_NAME, SETTINGS_ALIAS_ACTIVITY_NAME);
    }

    private final void addNoteAssistMenu(MatrixCursor cursor) {
        Map<String, Integer> map = this.mSettingsNoteAssistScreenMenus;
        String string = getSearchContext().getString(C8003R.string.settings_notes_assist);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String name = SettingsNotesAssistPrefFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        addSettingMenus(cursor, map, string, name, name2);
    }

    private final void addSettingAdvancedMenu(MatrixCursor cursor) {
        Map<String, Integer> map = this.mSettingsAdvancedScreenMenus;
        String string = getSearchContext().getString(C8003R.string.settings_advanced);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String name = SettingsAdvancedFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        addSettingMenus(cursor, map, string, name, name2);
    }

    private final void addSettingImportMenu(MatrixCursor cursor) {
        Map<String, Integer> map = this.mSettingsImportScreenMenus;
        String string = getSearchContext().getString(C8003R.string.settings_import_notes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String name = SettingsImportPrefFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        addSettingMenus(cursor, map, string, name, name2);
    }

    private final void addSettingLockMenu(MatrixCursor cursor) {
        Map<String, Integer> map = this.mSettingsLockScreenMenus;
        String string = getSearchContext().getString(C8003R.string.settings_password_and_biometrics);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String name = SettingsPasswordAndBiometricsFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        addSettingMenus(cursor, map, string, name, name2);
    }

    private final void addSettingMainMenu(MatrixCursor cursor) {
        Context searchContext = getSearchContext();
        int samsungNotesSettingTitleRes = SettingsMenuUtils.getSamsungNotesSettingTitleRes();
        String string = searchContext.getString(samsungNotesSettingTitleRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int i = C8003R.drawable.ic_notes;
        String name = SettingsMainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        cursor.addRow(getIndexableTuple(TOP_LEVEL_SETTINGS_MAIN_SCREEN, samsungNotesSettingTitleRes, i, string, name, name2, new String[0]));
        Map<String, Integer> map = this.mSettingsMainScreenMenus;
        String name3 = SettingsMainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        String name4 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        addSettingMenus(cursor, map, string, name3, name4);
    }

    private final void addSettingMenus(MatrixCursor cursor, Map<String, Integer> settingMenus, String settingScreenTitle, String className, String targetClassName) {
        if (settingMenus == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : settingMenus.entrySet()) {
            String str = settingScreenTitle;
            cursor.addRow(getIndexableTuple(entry.getKey(), entry.getValue().intValue(), str, className, targetClassName, new String[0]));
            settingScreenTitle = str;
        }
    }

    private final void addSettingScreenOffMemoStyleMenu(MatrixCursor cursor) {
        Map<String, Integer> map = this.mSettingsScreenOffMemoStyleScreenMenus;
        String string = getSearchContext().getString(C8003R.string.settings_screen_off_memo_style);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String name = SettingsScreenOffMemoStyleFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        addSettingMenus(cursor, map, string, name, name2);
    }

    private final Object[] getIndexableTuple(String keyValue, @StringRes int titleResId, String screenTitle, String className, String targetClassName, String... keywords) {
        return getIndexableTuple(keyValue, titleResId, 0, screenTitle, className, targetClassName, (String[]) Arrays.copyOf(keywords, keywords.length));
    }

    private final Object[] getNonIndexableTuple(String keyValue) {
        AbstractC0000a.m25v("getNonIndexableTuple# keyValue: ", MainLogger.getEncode(keyValue), TAG);
        Object[] objArr = new Object[SecSearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS.length];
        objArr[0] = keyValue;
        return objArr;
    }

    private final Object[] getSiteMapPairTuple(String parentClassName, String parentClassTitle, String childClassName, String childClassTitle) {
        MainLogger.m7254d(TAG, "getSiteMapPairTuple# parent: " + MainLogger.getEncode(parentClassName) + ", child: " + MainLogger.getEncode(childClassName));
        Object[] objArr = new Object[SecSearchIndexablesContract.SITE_MAP_COLUMNS.length];
        objArr[0] = parentClassName;
        objArr[1] = parentClassTitle;
        objArr[2] = childClassName;
        objArr[3] = childClassTitle;
        return objArr;
    }

    private final void initAdvancedScreenMenus() {
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, Integer.valueOf(C8003R.string.settings_show_links_in_notes));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, Integer.valueOf(C8003R.string.settings_show_web_previews));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, Integer.valueOf(C8003R.string.settings_clipping_options));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_ACTION_ICONS, Integer.valueOf(C8003R.string.settings_action_icons));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, Integer.valueOf(C8003R.string.settings_hide_scroll_bar_while_editing));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, Integer.valueOf(C8003R.string.settings_hide_navigation_bar_while_writing));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, Integer.valueOf(C8003R.string.settings_block_back_key_while_editing));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_QUICK_TOOLS, Integer.valueOf(C8003R.string.settings_quick_tools));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR, Integer.valueOf(C8003R.string.settings_customize_toolbar));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, Integer.valueOf(C8003R.string.settings_use_phone_as_toolbar));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, Integer.valueOf(C8003R.string.settings_handwriting_recognition));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES, Integer.valueOf(C8003R.string.settings_convert_your_notes));
        this.mSettingsAdvancedScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_NOTES, Integer.valueOf(C8003R.string.settings_import_notes));
    }

    private final void initGlobalIntelligenceMenu() {
        MainLogger.m7254d(TAG, "initGlobalIntelligenceMenu# ");
        this.mSettingsGlobalIntelligenceScreenMenus.put(SettingsConstants.SETTINGS_NOTES_ASSIST_ALIAS, Integer.valueOf(C8003R.string.settings_notes_assist));
    }

    private final void initImportScreenMenus() {
        if (!SettingsMenuUtils.isImportDataSupported(getSearchContext())) {
            MainLogger.m7254d(TAG, "initImportScreenMenus# ignore do not support import");
            return;
        }
        MainLogger.m7254d(TAG, "initImportScreenMenus# ");
        this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_NOTES_FROM_PHONE, Integer.valueOf(SettingsMenuUtils.getImportFromDeviceTitleRes()));
        this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_PHONE, Integer.valueOf(SettingsMenuUtils.getImportFromDeviceTitleRes()));
        this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_SAMSUNG_ACCOUNT, Integer.valueOf(SettingsMenuUtils.getImportFromSamsungAccountTitleRes()));
        if (!SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_GOOGLE_DRIVE, Integer.valueOf(C8003R.string.settings_import_google_drive));
        }
        this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_PHONE, Integer.valueOf(SettingsMenuUtils.getImportFromDeviceTitleRes()));
        this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_SAMSUNG_ACCOUNT, Integer.valueOf(SettingsMenuUtils.getImportFromSamsungAccountTitleRes()));
        this.mSettingsImportScreenMenus.put(SettingsConstants.SETTINGS_IMPORT_SCRAPBOOKS_FROM_SAMSUNG_ACCOUNT, Integer.valueOf(SettingsMenuUtils.getImportFromSamsungAccountTitleRes()));
    }

    private final void initLockScreenMenus() {
        MainLogger.m7254d(TAG, "initLockScreenMenus# ");
        Context searchContext = getSearchContext();
        this.mSettingsLockScreenMenus.put(SettingsConstants.SETTINGS_LOCK_CREATE_CHANGE_PASSWORD, Integer.valueOf(SettingsMenuUtils.getLockNotesSetPasswordTitleRes(searchContext)));
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        if (settingsMenuUtils.isIrisDeviceSupported(searchContext, new IrisApi())) {
            this.mSettingsLockScreenMenus.put(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_IRIS, Integer.valueOf(C8003R.string.settings_iris));
        }
        if (settingsMenuUtils.isFingerprintDeviceSupported(searchContext, new FingerprintApi())) {
            this.mSettingsLockScreenMenus.put(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_FINGERPRINT, Integer.valueOf(C8003R.string.settings_fingerprint));
        }
    }

    private final void initMainScreenMenus() {
        MainLogger.m7254d(TAG, "initMainScreenMenus# ");
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC, Integer.valueOf(SettingsMenuUtils.getSamsungCloudSyncMenuTitleRes(getSearchContext())));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_MICROSOFT_SYNC, Integer.valueOf(C8003R.string.settings_sync_to_ms));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE, Integer.valueOf(C8003R.string.settings_coedit_note_sync_type));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, Integer.valueOf(C8003R.string.settings_screen_off_memo_style));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_DEFAULT_NOTE_STYLE, Integer.valueOf(C8003R.string.settings_default_note_style));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_PASSWORD_AND_BIOMETRICS, Integer.valueOf(C8003R.string.settings_password_and_biometrics));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, Integer.valueOf(C8003R.string.settings_default_editing_mode));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, Integer.valueOf(C8003R.string.settings_auto_save_notes));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_ADVANCED, Integer.valueOf(C8003R.string.settings_advanced));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_NOTES_ASSIST, Integer.valueOf(C8003R.string.settings_notes_assist));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_DRAWING_ASSIST, Integer.valueOf(SettingsMenuUtils.getDrawingAssistTitleRes()));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_PRIVACY_NOTICE, Integer.valueOf(C8003R.string.settings_privacy_notice));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_PERMISSIONS, Integer.valueOf(C8003R.string.settings_permissions));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_ABOUT_NOTES, Integer.valueOf(SettingsMenuUtils.getAboutSamsungNotesTitleRes()));
        this.mSettingsMainScreenMenus.put(SettingsConstants.SETTINGS_CONTACT_US, Integer.valueOf(C8003R.string.settings_contact_us));
    }

    private final void initNoteAssistMenu() {
        MainLogger.m7254d(TAG, "initNoteAssistMenu# ");
        this.mSettingsNoteAssistScreenMenus.put(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE, Integer.valueOf(C8003R.string.settings_auto_transcribe));
        this.mSettingsNoteAssistScreenMenus.put(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, Integer.valueOf(C8003R.string.settings_auto_detect_language));
        this.mSettingsNoteAssistScreenMenus.put(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY, Integer.valueOf(C8003R.string.settings_notes_assist_on_device_summarize));
        this.mSettingsNoteAssistScreenMenus.put(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD, Integer.valueOf(C8003R.string.settings_notes_assist_language_pack_for_download));
        this.mSettingsNoteAssistScreenMenus.put(SettingsConstants.SETTINGS_NOTES_ASSIST_MORE_GALAXY_AI_FEATURE, Integer.valueOf(C8003R.string.settings_notes_assist_more_galaxy_ai_feature));
    }

    private final void initScreenOffMemoStyleMenus() {
        MainLogger.m7254d(TAG, "initScreenOffMemoStyleMenus# ");
        this.mSettingsScreenOffMemoStyleScreenMenus.put(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND, Integer.valueOf(C8003R.string.settings_screen_off_memo_style_original_pen_on_black_background));
        this.mSettingsScreenOffMemoStyleScreenMenus.put(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND, Integer.valueOf(C8003R.string.settings_screen_off_memo_style_original_pen_on_white_background));
        this.mSettingsScreenOffMemoStyleScreenMenus.put(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND, Integer.valueOf(C8003R.string.settings_screen_off_memo_style_black_pen_on_white_background));
    }

    private final void queryAdvancedMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        Context searchContext = getSearchContext();
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        if (!settingsMenuUtils.isNotesAssistSupported() || !SettingsMenuUtils.isNotesAssistVisible() || PolicyManager.isEdmPolicyAiGrayout()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_NOTES_ASSIST);
        }
        if (!settingsMenuUtils.isDrawingAssistSupported() || !settingsMenuUtils.isDrawingAssistVisible() || PolicyManager.isEdmPolicyAiGrayout()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_DRAWING_ASSIST);
        }
        if (!SettingsMenuUtils.isClippingOptionsSupported() || !SettingsMenuUtils.isClippingOptionsEnabled()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_CLIPPING_OPTIONS);
        }
        if (!SettingsMenuUtils.isActionIconsSupported(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_ACTION_ICONS);
        }
        if (!settingsMenuUtils.isHideScrollBarWhileEditingSupported()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING);
        }
        if (!SettingsMenuUtils.isHideNavigationBarWhileWritingSupported()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING);
        }
        if (!SettingsMenuUtils.isHWRLanguageSupported(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION);
        }
        if (!SettingsMenuUtils.isUsePhoneAsToolbarSupported() || !SettingsMenuUtils.isUsePhoneAsToolbarVisible()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR);
        }
        if (!SettingsMenuUtils.isConvertYourNoteVisible(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES);
        }
        if (!SettingsMenuUtils.isImportDataSupported(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_NOTES);
        }
        if (settingsMenuUtils.isQuickToolsSupported()) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_QUICK_TOOLS);
    }

    private final void queryContactUsMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        if (SettingsMenuUtils.isContactUsSupported(getSearchContext())) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_CONTACT_US);
    }

    private final void queryGeneralMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        Context searchContext = getSearchContext();
        if (!SettingsMenuUtils.isLockNotesSupported(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_PASSWORD_AND_BIOMETRICS);
        }
        if (SettingsMenuUtils.isLockNotesAccessEnabled(searchContext)) {
            if (!SettingsMenuUtils.isLockNotesUsingIrisSupported(searchContext, new IrisApi())) {
                nonIndexableKeys.add(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_IRIS);
            }
            if (!SettingsMenuUtils.isLockNotesUsingFingerprintSupported(searchContext, new FingerprintApi())) {
                nonIndexableKeys.add(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_FINGERPRINT);
            }
        } else {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_LOCK_CREATE_CHANGE_PASSWORD);
            nonIndexableKeys.add(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_IRIS);
            nonIndexableKeys.add(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_FINGERPRINT);
        }
        if (!SettingsMenuUtils.isScreenOffMemoStyleSupported(getSearchContext()) || !SettingsMenuUtils.isScreenOffMemoStyleVisible()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE);
            nonIndexableKeys.add(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND);
            nonIndexableKeys.add(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND);
            nonIndexableKeys.add(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND);
        }
        if (SettingsMenuUtils.INSTANCE.isDefaultEditingModeSupported()) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE);
    }

    private final void queryGlobalIntelligenceMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        if (SettingsMenuUtils.INSTANCE.isNotesAssistSupported() && SettingsMenuUtils.isNotesAssistVisible() && 60101 < SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion()) {
            return;
        }
        MainLogger.m7254d(TAG, "updateGlobalIntelligenceMenuNonIndexableKeys# remove alias menu");
        nonIndexableKeys.add(SettingsConstants.SETTINGS_NOTES_ASSIST_ALIAS);
    }

    private final void queryImportMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        Context searchContext = getSearchContext();
        if (!SettingsMenuUtils.isImportNotesSupported()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_NOTES_FROM_PHONE);
        }
        if (!SettingsMenuUtils.isImportSNotesFromGoogleDriveSupported(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_GOOGLE_DRIVE);
        }
        if (!SettingsMenuUtils.isImportMemosFromPhoneSupported(searchContext)) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_PHONE);
        }
        if (SettingsMenuUtils.isImportFromSamsungAccountSupported()) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_SAMSUNG_ACCOUNT);
        nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_SAMSUNG_ACCOUNT);
        nonIndexableKeys.add(SettingsConstants.SETTINGS_IMPORT_SCRAPBOOKS_FROM_SAMSUNG_ACCOUNT);
    }

    private final void queryIntelligenceMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        if (!settingsMenuUtils.isNotesAssistSupported() || !SettingsMenuUtils.isNotesAssistVisible() || PolicyManager.isEdmPolicyAiGrayout()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_NOTES_ASSIST);
        }
        if (settingsMenuUtils.isDrawingAssistSupported() && settingsMenuUtils.isDrawingAssistVisible() && !PolicyManager.isEdmPolicyAiGrayout()) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_DRAWING_ASSIST);
    }

    private final void queryNoteAssistMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        boolean z = (settingsMenuUtils.isNotesAssistSupported() && SettingsMenuUtils.isNotesAssistVisible()) ? false : true;
        AbstractC8014b.m7210l("queryNoteAssistMenuNonIndexableKeys# isNoteAssistNonIndexable: ", TAG, z);
        if (z || !settingsMenuUtils.isAutoDetectLanguageSupported() || !settingsMenuUtils.isAutoDetectLanguageVisible() || !settingsMenuUtils.isSupportSTTAutoDetectLanguage()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE);
        }
        if (z || !settingsMenuUtils.isNotesAssistOnDeviceSummaryVisible() || PolicyManager.isEdmPolicyAiGrayout()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY);
        }
        if (z) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD);
        }
        if (z) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_NOTES_ASSIST_MORE_GALAXY_AI_FEATURE);
        }
    }

    private final void queryPermissionsMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        if (SettingsMenuUtils.INSTANCE.isPermissionsSupported()) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_PERMISSIONS);
    }

    private final void querySyncMenuNonIndexableKeys(Set<String> nonIndexableKeys) {
        if (!SettingsMenuUtils.isSamsungCloudSyncSupported()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        }
        if (!SettingsMenuUtils.isMicrosoftSyncSupported()) {
            nonIndexableKeys.add(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
        }
        if (SettingsMenuUtils.INSTANCE.isSharedNotesSyncSupported(getSearchContext())) {
            return;
        }
        nonIndexableKeys.add(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE);
    }

    @Override // com.samsung.android.settings.search.provider.SecSearchIndexablesProvider
    @NotNull
    public Context getSearchContext() {
        if (DeviceInfo.isVSTModel()) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            return context;
        }
        Context searchContext = super.getSearchContext();
        Intrinsics.checkNotNullExpressionValue(searchContext, "getSearchContext(...)");
        return searchContext;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        MainLogger.m7254d(TAG, "onCreate# ");
        BaseUtils.setApplicationContext(getSearchContext().getApplicationContext());
        initMainScreenMenus();
        initAdvancedScreenMenus();
        initImportScreenMenus();
        initScreenOffMemoStyleMenus();
        initLockScreenMenus();
        initNoteAssistMenu();
        initGlobalIntelligenceMenu();
        return false;
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider
    @NotNull
    public Cursor queryNonIndexableKeys(@Nullable String[] strings) {
        HashSet hashSet = new HashSet();
        querySyncMenuNonIndexableKeys(hashSet);
        queryIntelligenceMenuNonIndexableKeys(hashSet);
        queryGeneralMenuNonIndexableKeys(hashSet);
        queryAdvancedMenuNonIndexableKeys(hashSet);
        queryPermissionsMenuNonIndexableKeys(hashSet);
        queryContactUsMenuNonIndexableKeys(hashSet);
        queryImportMenuNonIndexableKeys(hashSet);
        queryNoteAssistMenuNonIndexableKeys(hashSet);
        queryGlobalIntelligenceMenuNonIndexableKeys(hashSet);
        MatrixCursor matrixCursor = new MatrixCursor(SecSearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS);
        for (String str : hashSet) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            matrixCursor.addRow(getNonIndexableTuple(str));
        }
        String string = Arrays.toString(hashSet.toArray(new String[0]));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        AbstractC0000a.m25v("queryNonIndexableKeys# ", MainLogger.getEncode(string), TAG);
        SettingsSearchIndexingManager.INSTANCE.saveLastNonIndexableKeys(hashSet);
        return matrixCursor;
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider
    @NotNull
    public Cursor queryRawData(@Nullable String[] strings) {
        if (strings == null) {
            MainLogger.m7254d(TAG, "queryRawData# strings null");
        } else {
            String string = Arrays.toString(strings);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            MainLogger.m7254d(TAG, "queryRawData# " + string);
        }
        MatrixCursor matrixCursor = new MatrixCursor(SecSearchIndexablesContract.INDEXABLES_RAW_COLUMNS);
        addSettingMainMenu(matrixCursor);
        addSettingAdvancedMenu(matrixCursor);
        addSettingImportMenu(matrixCursor);
        addSettingScreenOffMemoStyleMenu(matrixCursor);
        addSettingLockMenu(matrixCursor);
        addNoteAssistMenu(matrixCursor);
        addGlobalIntelligenceMenu(matrixCursor);
        return matrixCursor;
    }

    @Override // com.samsung.android.settings.search.provider.SecSearchIndexablesProvider, com.samsung.android.settings.search.provider.SearchIndexablesProvider
    @NotNull
    public Cursor querySiteMapPairs() {
        MainLogger.m7254d(TAG, "querySiteMapPairs# ");
        Context searchContext = getSearchContext();
        MatrixCursor matrixCursor = new MatrixCursor(SecSearchIndexablesContract.SITE_MAP_COLUMNS);
        String string = searchContext.getString(SettingsMenuUtils.getSamsungNotesSettingTitleRes());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String name = SettingsMainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = SettingsAdvancedFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        String string2 = searchContext.getString(C8003R.string.settings_advanced);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        matrixCursor.addRow(getSiteMapPairTuple(name, string, name2, string2));
        String name3 = SettingsAdvancedFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        String string3 = searchContext.getString(C8003R.string.settings_advanced);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String name4 = SettingsImportPrefFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        String string4 = searchContext.getString(C8003R.string.settings_import_notes);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        matrixCursor.addRow(getSiteMapPairTuple(name3, string3, name4, string4));
        String name5 = SettingsMainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
        String name6 = SettingsScreenOffMemoStyleFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
        String string5 = searchContext.getString(C8003R.string.settings_screen_off_memo_style);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        matrixCursor.addRow(getSiteMapPairTuple(name5, string, name6, string5));
        String name7 = SettingsMainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
        String name8 = SettingsPasswordAndBiometricsFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
        String string6 = searchContext.getString(SettingsMenuUtils.getLockNotesTitleRes(searchContext));
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        matrixCursor.addRow(getSiteMapPairTuple(name7, string, name8, string6));
        String name9 = SettingsMainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name9, "getName(...)");
        String name10 = SettingsNotesAssistPrefFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name10, "getName(...)");
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        String string7 = context.getString(C8003R.string.settings_notes_assist);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        matrixCursor.addRow(getSiteMapPairTuple(name9, string, name10, string7));
        matrixCursor.addRow(getSiteMapPairTuple(GLOBAL_SETTINGS_INTELLIGENCE_SERVICE, SETTINGS_ALIAS_ACTIVITY_NAME));
        return matrixCursor;
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider
    @Nullable
    public Cursor queryXmlResources(@Nullable String[] strings) {
        if (strings == null) {
            MainLogger.m7254d(TAG, "queryXmlResources# data is null");
            return null;
        }
        String string = Arrays.toString(strings);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        MainLogger.m7254d(TAG, "queryXmlResources# " + string);
        return null;
    }

    @Override // com.samsung.android.settings.search.provider.SecSearchIndexablesProvider
    public int secQueryAvailability(@NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        String string = extra.getString(SecSearchIndexablesContract.SEC_EXTRA_KEY_PREFERENCE_KEY);
        int i = ((Intrinsics.areEqual(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, string) || Intrinsics.areEqual(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND, string) || Intrinsics.areEqual(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND, string) || Intrinsics.areEqual(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND, string)) && !(SettingsMenuUtils.isScreenOffMemoStyleSupported(getSearchContext()) && SettingsMenuUtils.isScreenOffMemoStyleVisible())) ? 1 : 0;
        MainLogger.m7254d(TAG, "prefKey: " + string + ", isAvailable: " + i);
        if (i == 1) {
            SettingsSearchIndexingManager.requestIndexing();
        }
        return i;
    }

    @Override // com.samsung.android.settings.search.provider.SecSearchIndexablesProvider
    @NotNull
    public String secQueryGetFingerprint() {
        MainLogger.m7254d(TAG, "secQueryGetFingerprint# ");
        String versionInfo = PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(getSearchContext());
        String string = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return AbstractC0541b.m756B(versionInfo, string);
    }

    @Override // com.samsung.android.settings.search.provider.SecSearchIndexablesProvider
    @NotNull
    public Cursor secQueryNonIndexableKeys(@NotNull String[] projection, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        try {
            Cursor cursorSecQueryNonIndexableKeys = super.secQueryNonIndexableKeys(projection, extras);
            Intrinsics.checkNotNullExpressionValue(cursorSecQueryNonIndexableKeys, "secQueryNonIndexableKeys(...)");
            return cursorSecQueryNonIndexableKeys;
        } catch (ExceptionInInitializerError e) {
            MainLogger.m7255e(TAG, "ExceptionInInitializerError, e: " + e.getMessage());
            return new MatrixCursor(SecSearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS);
        }
    }

    @SuppressLint({"ResourceType"})
    private final Object[] getIndexableTuple(String keyValue, @StringRes int titleResId, @DrawableRes int iconResId, String screenTitle, String className, String targetClassName, String... keywords) {
        return getIndexableTuple(keyValue, titleResId, iconResId, screenTitle, className, targetClassName, "android.intent.action.VIEW", (String[]) Arrays.copyOf(keywords, keywords.length));
    }

    @SuppressLint({"ResourceType"})
    private final Object[] getIndexableTuple(String keyValue, @StringRes int titleResId, @DrawableRes int iconResId, String screenTitle, String className, String targetClassName, String action, String... keywords) {
        String string;
        AbstractC0000a.m25v("getIndexableTuple# keyValue: ", MainLogger.getEncode(keyValue), TAG);
        Object[] objArr = new Object[SecSearchIndexablesContract.INDEXABLES_RAW_COLUMNS.length];
        objArr[12] = keyValue;
        objArr[5] = CharUtils.arrayJoin(" ,", keywords);
        if (Build.VERSION.SDK_INT > 30) {
            string = String.valueOf(titleResId);
        } else {
            string = getSearchContext().getString(titleResId);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        objArr[1] = string;
        objArr[6] = screenTitle;
        objArr[7] = className;
        objArr[10] = getSearchContext().getPackageName();
        objArr[11] = targetClassName;
        objArr[9] = action;
        if (iconResId > 0) {
            objArr[8] = Integer.valueOf(iconResId);
        }
        return objArr;
    }

    private final Object[] getSiteMapPairTuple(String parentClassName, String childClassName) {
        MainLogger.m7254d(TAG, "getSiteMapPairTuple# parent: " + MainLogger.getEncode(parentClassName) + ", child: " + MainLogger.getEncode(childClassName));
        Object[] objArr = new Object[SecSearchIndexablesContract.SITE_MAP_COLUMNS.length];
        objArr[0] = parentClassName;
        objArr[2] = childClassName;
        return objArr;
    }
}
