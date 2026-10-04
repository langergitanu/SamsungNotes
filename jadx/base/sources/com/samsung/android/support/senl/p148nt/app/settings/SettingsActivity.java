package com.samsung.android.support.senl.p148nt.app.settings;

import android.app.ActivityManager;
import android.app.ComponentCaller;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.settings.about.AboutActivity;
import com.samsung.android.support.senl.p148nt.app.settings.about.SetupWizardWelcomeActivity;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.SettingsAdvancedFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsAutoTranscribePrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsConvertOldNotesFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsCustomizeToolbarFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsDefaultNoteStyleFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsImportPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistOnDeviceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsPasswordAndBiometricsFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsScreenOffMemoStyleFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSearchFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.SettingsHWRFragment;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainFragment;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.MainListStartManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u000eH\u0016J*\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u0010H\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0012H\u0014J\b\u00101\u001a\u00020\u0010H\u0014J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0010H\u0016J\"\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0006\u00108\u001a\u00020\u000eJ\u0012\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0012\u0010>\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010\nH\u0002R\u0018\u0010\u0006\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u00106\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment$Contract;", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$NoteEditable;", "<init>", "()V", "mFragmentType", "", "getMFragmentType$annotations", "mCallee", "", "mFragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "mIsTabletLayout", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initFragmentType", "initFragment", "settingFragment", "Landroidx/fragment/app/Fragment;", "getSettingFragment", "()Landroidx/fragment/app/Fragment;", "initFragmentArgument", "fragment", "onSupportNavigateUp", "isExistClassInSameTask", "context", "Landroid/content/Context;", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "onWindowFocusChanged", "hasFocus", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", NotesConstants.KEY_CALLER, "Landroid/app/ComponentCaller;", "swapSettingFragment", "fragmentType", "startSettingsActivity", "key", "initToolBar", "setDisplayHomeAsUpEnabled", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "isSupportNavigateUp", "()Z", "isDisableMoreGalaxyAI", "createSettingsFragment", "getSettingsFragmentTag", "toolbarTitle", "getToolbarTitle", "()I", "getFragmentTypeFromTargetPreferenceKey", "targetPreferenceKey", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsActivity extends AppCompatActivity implements SettingsBaseFragment.Contract, ActivityLifecycleTracker.NoteEditable {

    @NotNull
    private static final String TAG = "ST$SettingsActivity";

    @Nullable
    private String mCallee = SettingsConstants.CALLEE_SETTINGS;

    @Nullable
    private SettingsBaseFragment mFragment;
    private int mFragmentType;
    private boolean mIsTabletLayout;

    private final Fragment createSettingsFragment(int fragmentType) {
        AbstractC8014b.m7201c(fragmentType, "createSettingsFragment# Type : ", TAG);
        switch (fragmentType) {
            case 0:
                return new SettingsMainFragment();
            case 1:
                return new SettingsSyncWithSamsungAccountPrefFragment();
            case 2:
                return new SettingsSyncToMicrosoftPrefFragment();
            case 3:
                return new SettingsScreenOffMemoStyleFragment();
            case 4:
                return new SettingsAdvancedFragment();
            case 5:
                return new SettingsDefaultNoteStyleFragment();
            case 6:
                return new SettingsPasswordAndBiometricsFragment();
            case 7:
                return new SettingsConvertOldNotesFragment();
            case 8:
                return new SettingsImportPrefFragment();
            case 9:
                return new SettingsNotesAssistPrefFragment();
            case 10:
                return new SettingsNotesAssistOnDeviceFragment();
            case 11:
                return new SettingsHWRFragment();
            case 12:
                return new SettingsCustomizeToolbarFragment();
            case 13:
                return new SettingsSearchFragment();
            case 14:
                return new SettingsAutoTranscribePrefFragment();
            default:
                MainLogger.m7255e(TAG, "createSettingsFragment# Type : " + fragmentType + " is invalid");
                return new SettingsMainFragment();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getFragmentTypeFromTargetPreferenceKey(String targetPreferenceKey) {
        int i;
        MainLogger.m7254d(TAG, "getFragmentTypeFromTargetPreferenceKey# ");
        if (targetPreferenceKey != null) {
            switch (targetPreferenceKey.hashCode()) {
                case -2118166339:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_CLIPPING_OPTIONS)) {
                        MainLogger.m7254d(TAG, "getFragmentTypeFromTargetPreferenceKey# " + MainLogger.getEncode(targetPreferenceKey) + " is not defined on SettingsSearchProvider, return Main");
                        i = 0;
                    } else {
                        i = 4;
                    }
                    break;
                case -2001920725:
                    if (targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_SAMSUNG_ACCOUNT)) {
                        i = 8;
                        break;
                    }
                    break;
                case -1883074265:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR)) {
                    }
                    break;
                case -1882559631:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_PHONE)) {
                    }
                    break;
                case -1752842880:
                    if (targetPreferenceKey.equals(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE)) {
                        i = 9;
                        break;
                    }
                    break;
                case -1621276800:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_NOTES_ASSIST_MORE_GALAXY_AI_FEATURE)) {
                    }
                    break;
                case -1380260848:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING)) {
                    }
                    break;
                case -1004673047:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
                    }
                    break;
                case -972378119:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD)) {
                    }
                    break;
                case -935883241:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_SAMSUNG_ACCOUNT)) {
                    }
                    break;
                case -826246688:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING)) {
                    }
                    break;
                case -821391588:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS)) {
                    }
                    break;
                case -665736065:
                    if (targetPreferenceKey.equals(SettingsConstants.SETTINGS_LOCK_CREATE_CHANGE_PASSWORD)) {
                        i = 6;
                        break;
                    }
                    break;
                case -561983901:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR)) {
                    }
                    break;
                case -545459603:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_ACTION_ICONS)) {
                    }
                    break;
                case -239703315:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_QUICK_TOOLS)) {
                    }
                    break;
                case -51298271:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY)) {
                    }
                    break;
                case 197317699:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_NOTES)) {
                    }
                    break;
                case 235906209:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_GOOGLE_DRIVE)) {
                    }
                    break;
                case 357581661:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES)) {
                    }
                    break;
                case 378521193:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE)) {
                    }
                    break;
                case 487904093:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_PHONE)) {
                    }
                    break;
                case 555354271:
                    if (targetPreferenceKey.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND)) {
                        i = 3;
                        break;
                    }
                    break;
                case 834322709:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND)) {
                    }
                    break;
                case 902093467:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_FINGERPRINT)) {
                    }
                    break;
                case 916017755:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_SCRAPBOOKS_FROM_SAMSUNG_ACCOUNT)) {
                    }
                    break;
                case 922445471:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_IRIS)) {
                    }
                    break;
                case 1123331238:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_NOTES_ASSIST_ALIAS)) {
                    }
                    break;
                case 1454998611:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES)) {
                    }
                    break;
                case 1466795311:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND)) {
                    }
                    break;
                case 1563105813:
                    if (targetPreferenceKey.equals(SettingsConstants.SETTINGS_IMPORT_NOTES_FROM_PHONE)) {
                    }
                    break;
                case 1696494445:
                    if (!targetPreferenceKey.equals(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING)) {
                    }
                    break;
            }
        }
        MainLogger.m7254d(TAG, "getFragmentTypeFromTargetPreferenceKey# " + i + " ");
        return i;
    }

    @SettingsConstants.FragmentType
    private static /* synthetic */ void getMFragmentType$annotations() {
    }

    private final Fragment getSettingFragment() {
        MainLogger.m7254d(TAG, "getSettingFragment# Type : " + this.mFragmentType);
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TAG);
        return (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isAdded()) ? createSettingsFragment(this.mFragmentType) : fragmentFindFragmentByTag;
    }

    private final String getSettingsFragmentTag(int fragmentType) {
        AbstractC8014b.m7201c(fragmentType, "getSettingsFragmentTag# Type : ", TAG);
        switch (fragmentType) {
            case 0:
                return SettingsMainFragment.TAG;
            case 1:
                return SettingsSyncWithSamsungAccountPrefFragment.TAG;
            case 2:
                return SettingsSyncToMicrosoftPrefFragment.TAG;
            case 3:
                return SettingsScreenOffMemoStyleFragment.TAG;
            case 4:
                return SettingsAdvancedFragment.TAG;
            case 5:
                return SettingsDefaultNoteStyleFragment.TAG;
            case 6:
                return SettingsPasswordAndBiometricsFragment.TAG;
            case 7:
                return SettingsConvertOldNotesFragment.TAG;
            case 8:
                return SettingsImportPrefFragment.TAG;
            case 9:
                return SettingsNotesAssistPrefFragment.TAG;
            case 10:
                return SettingsNotesAssistOnDeviceFragment.TAG;
            case 11:
                return SettingsHWRFragment.TAG;
            case 12:
                return SettingsCustomizeToolbarFragment.TAG;
            case 13:
                return SettingsSearchFragment.TAG;
            case 14:
                return SettingsAutoTranscribePrefFragment.TAG;
            default:
                return null;
        }
    }

    private final int getToolbarTitle() {
        AbstractC8014b.m7201c(this.mFragmentType, "getToolbarTitle# Type : ", TAG);
        int i = this.mFragmentType;
        switch (i) {
            case 0:
                return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_title_jp : C8003R.string.settings_title;
            case 1:
                return SettingsMenuUtils.getSamsungCloudSyncMenuTitleRes(getBaseContext());
            case 2:
                return C8003R.string.settings_sync_to_ms;
            case 3:
                return C8003R.string.settings_screen_off_memo_style;
            case 4:
                return C8003R.string.settings_advanced;
            case 5:
                return C8003R.string.settings_default_note_style;
            case 6:
                return SettingsMenuUtils.getLockNotesTitleRes(getApplicationContext());
            case 7:
                return C8003R.string.settings_convert_your_notes;
            case 8:
                return C8003R.string.settings_import_notes;
            case 9:
                return C8003R.string.settings_notes_assist;
            case 10:
                return C8003R.string.settings_notes_assist_on_device_summarize;
            case 11:
                return Intrinsics.areEqual(SettingsConstants.CALLEE_COMPOSER, this.mCallee) ? C8003R.string.settings_handwriting_recognition_add_languages : C8003R.string.settings_handwriting_recognition;
            case 12:
                return C8003R.string.settings_customize_toolbar;
            case 13:
                return C8003R.string.search_settings;
            case 14:
                return C8003R.string.settings_auto_transcribe;
            default:
                AbstractC8014b.m7201c(i, "getToolbarTitle# unexpected fragmentType : ", TAG);
                return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_title_jp : C8003R.string.settings_title;
        }
    }

    private final void initFragment() {
        Fragment settingFragment = getSettingFragment();
        if (settingFragment == null) {
            MainLogger.m7258i(TAG, "initFragment# FragmentType is null. finish activity");
            finish();
            return;
        }
        initFragmentArgument(settingFragment);
        if (settingFragment instanceof SettingsBaseFragment) {
            ((SettingsBaseFragment) settingFragment).setContract(this);
        }
        setTitle(getToolbarTitle());
        getSupportFragmentManager().beginTransaction().replace(C8003R.id.fragment_container, settingFragment, TAG).commit();
    }

    private final void initFragmentArgument(Fragment fragment) {
        MainLogger.m7258i(TAG, "initFragmentArgument# ");
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(SettingsConstants.KEY_CALLEE, this.mCallee);
        MainLogger.m7258i(TAG, "initFragmentArgument# callee: " + this.mCallee);
        if (!TextUtils.isEmpty(intent.getStringExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY))) {
            String stringExtra = intent.getStringExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY);
            bundle.putString(SettingsConstants.KEY_TARGET_PREFERENCE, stringExtra);
            AbstractC8014b.m7209k("initFragmentArgument# preferenceKey: ", MainLogger.getEncode(stringExtra), TAG);
        }
        if (intent.hasExtra(SettingsConstants.KEY_LANGUAGE_LIST_FILTER)) {
            String stringExtra2 = intent.getStringExtra(SettingsConstants.KEY_LANGUAGE_LIST_FILTER);
            if (!TextUtils.isEmpty(stringExtra2)) {
                AbstractC8014b.m7209k("initFragmentArgument# language list filter: ", stringExtra2, TAG);
                bundle.putString(SettingsConstants.KEY_LANGUAGE_LIST_FILTER, stringExtra2);
            }
        }
        fragment.setArguments(bundle);
    }

    private final void initFragmentType() {
        int fragmentTypeFromTargetPreferenceKey;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            fragmentTypeFromTargetPreferenceKey = intent.getIntExtra(SettingsConstants.FRAGMENT_TYPE, 0);
        } else {
            Intrinsics.checkNotNull(stringExtra);
            fragmentTypeFromTargetPreferenceKey = getFragmentTypeFromTargetPreferenceKey(stringExtra);
        }
        this.mFragmentType = fragmentTypeFromTargetPreferenceKey;
    }

    private final void initToolBar() {
        MainLogger.m7258i(TAG, "initToolBar# ");
        Toolbar toolbar = (Toolbar) findViewById(C8003R.id.toolbar);
        toolbar.setTitle(getToolbarTitle());
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(C8003R.id.collapsing_toolbar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0019 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isExistClassInSameTask(Context context, String className) {
        int taskId = getTaskId();
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.AppTask> it = ((ActivityManager) systemService).getAppTasks().iterator();
        while (it.hasNext()) {
            ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
            if (Build.VERSION.SDK_INT <= 29) {
                if (taskId != taskInfo.id) {
                    continue;
                } else if (taskInfo.baseActivity == null) {
                    ComponentName componentName = taskInfo.baseActivity;
                    Intrinsics.checkNotNull(componentName);
                    String className2 = componentName.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className2, "getClassName(...)");
                    if (StringsKt.m14145S(className2, className)) {
                        return true;
                    }
                } else {
                    continue;
                }
            } else if (taskId != taskInfo.taskId) {
                continue;
            } else if (taskInfo.baseActivity == null) {
            }
        }
        return false;
    }

    private final boolean isSupportNavigateUp() {
        if (Intrinsics.areEqual(SettingsConstants.CALLEE_NONE, this.mCallee)) {
            MainLogger.m7254d(TAG, "isSupportNavigateUp, callee is not defined, may called from app info or global search, except tips app");
            return false;
        }
        if ((!Intrinsics.areEqual(SettingsConstants.CALLEE_COMPOSER, this.mCallee) && !Intrinsics.areEqual(this.mCallee, SettingsConstants.CALLEE_COMPOSER_DELEGATE_SETTINGS)) || 11 != this.mFragmentType) {
            return true;
        }
        MainLogger.m7254d(TAG, "isSupportNavigateUp, callee is composer");
        return false;
    }

    private final void setDisplayHomeAsUpEnabled() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!WindowManagerCompat.INSTANCE.getInstance().isPopOver(this) || PopOverActivityWrapper.getCurrentLayoutAnchorType(this) == -2) {
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    public final boolean isDisableMoreGalaxyAI() {
        return getIntent() != null && getIntent().getBooleanExtra(SettingsConstants.KEY_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS, false) && Intrinsics.areEqual(SettingsConstants.EXTRA_FROM_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS, getIntent().getStringExtra(SettingsConstants.KEY_NOTES_ASSIST_FOR_LAUNCH_FROM));
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NotNull ComponentCaller caller) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        super.onActivityResult(requestCode, resultCode, data, caller);
        SettingsBaseFragment settingsBaseFragment = this.mFragment;
        if (settingsBaseFragment != null) {
            settingsBaseFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = this.mFragmentType;
        if (5 == i) {
            SettingsDefaultNoteStyleFragment settingsDefaultNoteStyleFragment = (SettingsDefaultNoteStyleFragment) getSupportFragmentManager().findFragmentByTag(TAG);
            if (settingsDefaultNoteStyleFragment != null && settingsDefaultNoteStyleFragment.onBackKeyDown()) {
                return;
            }
        } else if (10 == i) {
            swapSettingFragment(9);
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
        setDisplayHomeAsUpEnabled();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MainListStartManager.INSTANCE.getInstance().canNotUseNoteList()) {
            ToastHandler.show(getApplicationContext(), C8003R.string.updating_note_try_again_later, 1);
            finish();
            return;
        }
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
        setContentView(C8003R.layout.settings_preference_activity);
        if (savedInstanceState != null) {
            this.mCallee = savedInstanceState.getString(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_SETTINGS);
        } else {
            String stringExtra = getIntent().getStringExtra(SettingsConstants.KEY_CALLEE);
            this.mCallee = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mCallee = getIntent().getBooleanExtra(SettingsConstants.KEY_FROM_TIPS, false) ? SettingsConstants.CALLEE_TIPS : SettingsConstants.CALLEE_NONE;
            }
        }
        initFragmentType();
        initFragment();
        initToolBar();
        ContextUtils.setTaskDescription(this, C8003R.color.task_description_title_color);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        SystemUi.setNavigationBarTheme(window, !ContextUtils.isNightMode(getApplicationContext()));
        PermissionHelper.noticeAppPermissionIfNeededs(this);
        this.mIsTabletLayout = ResourceUtils.isTabletLayout(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AiCommonUtil.releaseActionStatus(this);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(SettingsConstants.KEY_CALLEE, this.mCallee);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        if (CommonUtil.isNotAvailableActivity(this)) {
            return false;
        }
        if (!isSupportNavigateUp()) {
            finish();
            return true;
        }
        MainLogger.m7258i(TAG, "onSupportNavigateUp# ");
        int i = this.mFragmentType;
        if (i != 0) {
            if (10 == i) {
                swapSettingFragment(9);
                return true;
            }
            if ((12 == i && (Intrinsics.areEqual(this.mCallee, SettingsConstants.CALLEE_COMPOSER) || Intrinsics.areEqual(this.mCallee, SettingsConstants.CALLEE_COMPOSER_DELEGATE_SETTINGS))) || 13 == this.mFragmentType) {
                onBackPressed();
                return true;
            }
            Intent intent = new Intent(getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
            intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
            intent.setFlags(131072);
            startActivity(intent);
            finish();
            return true;
        }
        Class<?> noteListClass = NoteListAccessHandler.getNoteListClass();
        Intrinsics.checkNotNull(noteListClass);
        String name = noteListClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (isExistClassInSameTask(this, name)) {
            MainLogger.m7254d(TAG, "onSupportNavigateUp, just finish activity, noteListClassAccessName: ".concat(noteListClass.getName()));
            finish();
            return true;
        }
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        if (companion.getInstance().isFreeFormWindow(this) || companion.getInstance().isPairWindowingMode(this) || companion.getInstance().isMultiWindowMode(this)) {
            MultiTaskManager.Companion companion2 = MultiTaskManager.INSTANCE;
            if (!TextUtils.isEmpty(companion2.getInstance().getAvailableClassName(this))) {
                MainLogger.m7254d(TAG, "onSupportNavigateUp, call start activity ".concat(noteListClass.getName()));
                Intent intent2 = new Intent();
                intent2.setClass(this, noteListClass);
                companion2.getInstance().startActivity(this, intent2);
            }
        } else {
            MainLogger.m7254d(TAG, "onSupportNavigateUp, use multi task manager, noteListClassAccessName: ".concat(noteListClass.getName()));
            Intent intent3 = new Intent();
            intent3.setClass(this, noteListClass);
            intent3.addFlags(469762048);
            MultiTaskManager.INSTANCE.getInstance().startActivity(this, intent3);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        SettingsBaseFragment settingsBaseFragment = this.mFragment;
        if (settingsBaseFragment != null) {
            settingsBaseFragment.onWindowFocusChanged(hasFocus);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a7  */
    @Override // com.samsung.android.support.senl.nt.app.settings.common.component.SettingsBaseFragment.Contract
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startSettingsActivity(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MainLogger.m7258i(TAG, "startSettingsActivity# key: " + key);
        if (CommonUtil.isNotAvailableActivity(this)) {
        }
        Intent intent = new Intent();
        switch (key.hashCode()) {
            case -2117034650:
                if (key.equals(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 1));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                        startActivity(intent);
                    } else if (!DeviceInfo.isVSTModel()) {
                        startActivity(intent);
                    } else {
                        PopOverActivityWrapper.startActivity(this, intent, 9);
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case -2012132363:
                if (key.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 3));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case -1004673047:
                if (key.equals(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 11));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case -974570453:
                if (key.equals(SettingsConstants.SETTINGS_PASSWORD_AND_BIOMETRICS)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 6));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case -561983901:
                if (key.equals(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 12));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case -395165134:
                if (key.equals(SettingsConstants.SETTINGS_MICROSOFT_SYNC)) {
                    intent.setClass(this, SettingsActivity.class);
                    intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 2);
                    SettingsBaseFragment settingsBaseFragment = this.mFragment;
                    if (settingsBaseFragment != null && settingsBaseFragment.isMsSignInRequested()) {
                        intent.setAction(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ACTION_START_SIGNOUT_MS_FEED);
                    }
                    Unit unit = Unit.INSTANCE;
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case -328739650:
                if (key.equals(SettingsConstants.SETTINGS_ADVANCED)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 4));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 197317699:
                if (key.equals(SettingsConstants.SETTINGS_IMPORT_NOTES)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 8));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 357581661:
                if (key.equals(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 7));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 363983464:
                if (key.equals(SettingsConstants.SETTINGS_PERMISSIONS)) {
                    Intrinsics.checkNotNullExpressionValue(intent.setClass(this, SetupWizardWelcomeActivity.class), "setClass(...)");
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 378521193:
                if (key.equals(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 14));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 623588723:
                if (key.equals(SettingsConstants.SETTINGS_ABOUT_NOTES)) {
                    Intrinsics.checkNotNullExpressionValue(intent.setClass(this, AboutActivity.class), "setClass(...)");
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 940181886:
                if (key.equals(SettingsConstants.SETTINGS_DEFAULT_NOTE_STYLE)) {
                    intent.setClass(this, SettingsActivity.class);
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 5));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            case 1999504451:
                if (key.equals(SettingsConstants.SETTINGS_NOTES_ASSIST)) {
                    intent.setClass(this, SettingsActivity.class);
                    if (isDisableMoreGalaxyAI()) {
                        intent.setAction(SettingsConstants.KEY_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS);
                    }
                    Intrinsics.checkNotNull(intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 9));
                    intent.putExtra(SettingsConstants.KEY_CALLEE, this.mCallee);
                    if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PERMISSIONS, key)) {
                    }
                }
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
            default:
                MainLogger.m7258i(TAG, "startSettingsActivity# unexpected key: ".concat(key));
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.common.component.SettingsBaseFragment.Contract
    public void swapSettingFragment(int fragmentType) {
        AbstractC6670b.m4736A(fragmentType, "swapSettingFragment# fragmentType: ", TAG);
        Fragment fragmentCreateSettingsFragment = createSettingsFragment(fragmentType);
        if (fragmentCreateSettingsFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.fragment_container, fragmentCreateSettingsFragment, getSettingsFragmentTag(fragmentType)).commit();
            this.mFragmentType = fragmentType;
            setTitle(getToolbarTitle());
            initToolBar();
            if (fragmentCreateSettingsFragment instanceof SettingsBaseFragment) {
                ((SettingsBaseFragment) fragmentCreateSettingsFragment).setContract(this);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AiCommonUtil.onActivityResult(this, requestCode, resultCode, data);
        MainLogger.m7254d(TAG, "onActivityResult# requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (this.mFragmentType == 8) {
            Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(TAG);
            if (fragmentFindFragmentByTag instanceof SettingsImportPrefFragment) {
                ((SettingsImportPrefFragment) fragmentFindFragmentByTag).resultAllFilesAccessPermission(requestCode);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
