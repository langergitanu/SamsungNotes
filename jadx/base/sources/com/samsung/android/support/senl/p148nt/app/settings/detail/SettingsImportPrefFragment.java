package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.ImportActivity;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportConstants;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog.NetworkConnectionFailedHelper;
import com.samsung.android.support.senl.p148nt.base.common.PermissionUtils;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p042J1.C0145c;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnClickListenerC0174a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\tH\u0002J\"\u0010.\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\tH\u0002J)\u00103\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r05\"\u00020\rH\u0002¢\u0006\u0002\u00106J+\u00107\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r052\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\t2\u0006\u0010)\u001a\u00020*J\u0010\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsImportPrefFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mCredential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "mTaskType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onCreatePreferences", "", "bundle", "Landroid/os/Bundle;", "s", "", "onStart", "initLayout", "initNotes", "initNotesFromPhone", "initSNotes", "initSNotesFromPhone", "initSNotesFromSamsungAccount", "initSNotesFromGoogleDrive", "initMemosFromPhone", "initMemosFromSamsungAccount", "initScrapbooksFromSamsungAccount", "initRestore", "initRestoreSNBAKFromPhone", "importMemoFromLocal", "importNotesFromLocal", "importSNoteFromLocal", "importSNoteFromSamsungAccount", "importMemoFromSamsungAccount", "importScrapbookFromSamsungAccount", "importSNoteFromGoogleDrive", "importSNBAKFromLocal", "checkNetworkState", "", "showDialogWhenMobileNetwork", "run", "Ljava/lang/Runnable;", "requestIDValidation", "requestCode", "", "memoPermissionErrorPopupAlertDialog", "mOnPreferenceClickListener", "Landroidx/preference/Preference$OnPreferenceClickListener;", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "setGoogleDriveReady", "requestPermissions", "permissions", "", "(I[Ljava/lang/String;)V", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "resultAllFilesAccessPermission", "removePreference", "preference", "Landroidx/preference/Preference;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsImportPrefFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsImportPrefFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsImportPrefFragment\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,665:1\n37#2:666\n36#2,3:667\n37#2:670\n36#2,3:671\n*S KotlinDebug\n*F\n+ 1 SettingsImportPrefFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsImportPrefFragment\n*L\n630#1:666\n630#1:667,3\n394#1:670\n394#1:671,3\n*E\n"})
public final class SettingsImportPrefFragment extends SettingsBaseFragment {
    private static final int REQUEST_ACCOUNT_PICKER = 102;
    private static final int REQUEST_ID_GET_ACCESS_TOKEN_FOR_IMPORT_MEMO = 104;
    private static final int REQUEST_ID_GET_ACCESS_TOKEN_FOR_IMPORT_SCRAPBOOK = 105;
    private static final int REQUEST_ID_GET_ACCESS_TOKEN_FOR_IMPORT_SNOTE = 103;
    private static final int REQUEST_SYNC_ACCESS_TOKEN = 101;

    @NotNull
    public static final String TAG = "ST$SettingsImportPrefFragment";

    @Nullable
    private GoogleAccountCredential mCredential;

    @NotNull
    private DocTypeConstants mTaskType = DocTypeConstants.NONE;

    @NotNull
    private final Preference.OnPreferenceClickListener mOnPreferenceClickListener = new C7737b(this, 20);

    private final boolean checkNetworkState() {
        if (C0145c.m334s(getActivity())) {
            return false;
        }
        MainLogger.m7258i(TAG, "checkNetworkState(). Data connection is not capable");
        NetworkConnectionFailedHelper.getInstance().show(getActivity(), 2);
        return true;
    }

    private final void importMemoFromLocal() {
        Intent intent = new Intent(getActivity(), (Class<?>) ImportActivity.class);
        intent.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.MEMO_LOCAL.ordinal());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void importMemoFromSamsungAccount() {
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            requestIDValidation(104);
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT, SettingsSAConstants.EVENT_IMPORT_MEMO_FROM_SAMSUNG_ACCOUNT);
        } else if (AccountHelper.loginSamsungAccountByFragment(this, 101)) {
            this.mTaskType = DocTypeConstants.MEMO_SCLOUD;
        }
    }

    private final void importNotesFromLocal() {
        Intent intent = new Intent(getActivity(), (Class<?>) ImportActivity.class);
        intent.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SDOC.ordinal());
        startActivity(intent);
    }

    private final void importSNBAKFromLocal() {
        Intent intent = new Intent(getActivity(), (Class<?>) ImportActivity.class);
        intent.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SDOCX_SCLOUD.ordinal());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void importSNoteFromGoogleDrive() {
        PackageManager packageManager = requireActivity().getPackageManager();
        ArrayList arrayList = new ArrayList();
        arrayList.add("https://www.googleapis.com/auth/drive");
        GoogleAccountCredential googleAccountCredentialUsingOAuth2 = GoogleAccountCredential.usingOAuth2(getActivity(), arrayList);
        if (googleAccountCredentialUsingOAuth2 == null) {
            return;
        }
        this.mCredential = googleAccountCredentialUsingOAuth2;
        Intrinsics.checkNotNull(googleAccountCredentialUsingOAuth2);
        Intent intentNewChooseAccountIntent = googleAccountCredentialUsingOAuth2.newChooseAccountIntent();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intentNewChooseAccountIntent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        if (listQueryIntentActivities.isEmpty()) {
            MainLogger.m7258i(TAG, "importSnoteFromGoogleDrive() There is no activity for REQUEST_ACCOUNT_PICKER!");
            return;
        }
        MainLogger.m7258i(TAG, "importSnoteFromGoogleDrive() Send intent with REQUEST_ACCOUNT_PICKER!");
        startActivityForResult(intentNewChooseAccountIntent, 102);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT, SettingsSAConstants.EVENT_IMPORT_SNOTE_FROM_GOOGLE_DRIVE);
    }

    private final void importSNoteFromLocal() {
        Intent intent = new Intent(getActivity(), (Class<?>) ImportActivity.class);
        intent.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SNOTE_LOCAL.ordinal());
        startActivity(intent);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT, SettingsSAConstants.EVENT_IMPORT_SNOTE_FROM_PHONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void importSNoteFromSamsungAccount() {
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            MainLogger.m7258i(TAG, "importSnoteFromSamsungAccount, requestIDValidation");
            requestIDValidation(103);
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT, SettingsSAConstants.EVENT_IMPORT_SNOTE_FROM_SAMSUNG_ACCOUNT);
        } else {
            MainLogger.m7258i(TAG, "importSnoteFromSamsungAccount() Start logging in the samsung account!");
            if (AccountHelper.loginSamsungAccountByFragment(this, 101)) {
                this.mTaskType = DocTypeConstants.SNOTE_SCLOUD;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void importScrapbookFromSamsungAccount() {
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            requestIDValidation(105);
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT, SettingsSAConstants.EVENT_IMPORT_SCRAPBOOK_FROM_SAMSUNG_ACCOUNT);
        } else if (AccountHelper.loginSamsungAccountByFragment(this, 101)) {
            this.mTaskType = DocTypeConstants.SCRAPBOOK_SCLOUD;
        }
    }

    private final void initLayout() {
        initNotesFromPhone();
        initNotes();
        initSNotesFromPhone();
        initSNotesFromSamsungAccount();
        initSNotesFromGoogleDrive();
        initSNotes();
        initMemosFromPhone();
        initMemosFromSamsungAccount();
        initScrapbooksFromSamsungAccount();
        initRestoreSNBAKFromPhone();
        initRestore();
    }

    private final void initMemosFromPhone() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_PHONE);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!SettingsMenuUtils.isImportMemosFromPhoneSupported(getContext())) {
            removePreference(preferenceFindPreference);
        } else {
            preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
            preferenceFindPreference.setTitle(SettingsMenuUtils.getImportFromDeviceTitleRes());
        }
    }

    private final void initMemosFromSamsungAccount() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_SAMSUNG_ACCOUNT);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!SettingsMenuUtils.isImportFromSamsungAccountSupported()) {
            removePreference(preferenceFindPreference);
        } else {
            preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
            preferenceFindPreference.setTitle(SettingsMenuUtils.getImportFromSamsungAccountTitleRes());
        }
    }

    private final void initNotes() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_IMPORT_NOTES_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        if (!SettingsMenuUtils.isImportNotesSupported()) {
            getPreferenceScreen().removePreference(preferenceCategory);
            return;
        }
        String string = getString(SettingsMenuUtils.getImportNotesCategoryTitleRes());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        preferenceCategory.setTitle(SettingsMenuUtils.addLayoutDirectionMarkToString(string));
    }

    private final void initNotesFromPhone() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_NOTES_FROM_PHONE);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
        preferenceFindPreference.setTitle(SettingsMenuUtils.getImportFromDeviceTitleRes());
    }

    private final void initRestore() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_RESTORE_CATEGORY);
        if (preferenceFindPreference == null) {
            return;
        }
        getPreferenceScreen().removePreference(preferenceFindPreference);
    }

    private final void initRestoreSNBAKFromPhone() {
        findPreference(SettingsConstants.SETTINGS_IMPORT_RESTORE_FROM_SERVER);
    }

    private final void initSNotes() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_IMPORT_SNOTE_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        CharSequence title = preferenceCategory.getTitle();
        preferenceCategory.setTitle(title != null ? SettingsMenuUtils.addLayoutDirectionMarkToString(title) : null);
    }

    private final void initSNotesFromGoogleDrive() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_GOOGLE_DRIVE);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
        if (SettingsMenuUtils.isImportSNotesFromGoogleDriveSupported(getContext())) {
            return;
        }
        MainLogger.m7258i(TAG, "initSNotesFromGoogleDrive(). Hide the google drive menu!");
        removePreference(preferenceFindPreference);
    }

    private final void initSNotesFromPhone() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_PHONE);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!PermissionCompat.FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE) {
            removePreference(preferenceFindPreference);
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
        preferenceFindPreference.setTitle(SettingsMenuUtils.getImportFromDeviceTitleRes());
        if (Build.VERSION.SDK_INT <= 34) {
            return;
        }
        preferenceFindPreference.setSummary(SettingsMenuUtils.getImportFromDeviceSummaryRes());
    }

    private final void initSNotesFromSamsungAccount() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_SAMSUNG_ACCOUNT);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!SettingsMenuUtils.isImportFromSamsungAccountSupported()) {
            removePreference(preferenceFindPreference);
        } else {
            preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
            preferenceFindPreference.setTitle(SettingsMenuUtils.getImportFromSamsungAccountTitleRes());
        }
    }

    private final void initScrapbooksFromSamsungAccount() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_IMPORT_SCRAPBOOKS_FROM_SAMSUNG_ACCOUNT);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!SettingsMenuUtils.isImportFromSamsungAccountSupported()) {
            removePreference(preferenceFindPreference);
        } else {
            preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
            preferenceFindPreference.setTitle(SettingsMenuUtils.getImportFromSamsungAccountTitleRes());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final boolean mOnPreferenceClickListener$lambda$15(SettingsImportPrefFragment settingsImportPrefFragment, Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SettingsDetail;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        String key = preference.getKey();
        AbstractC8014b.m7209k("onPreferenceClick(). key : ", key, TAG);
        if (key != null) {
            switch (key.hashCode()) {
                case -2001920725:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_SAMSUNG_ACCOUNT)) {
                        if (settingsImportPrefFragment.checkNetworkState() || !PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8780d(settingsImportPrefFragment, 11), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                            return true;
                        }
                        settingsImportPrefFragment.showDialogWhenMobileNetwork(new RunnableC8780d(settingsImportPrefFragment, 12));
                        return true;
                    }
                    break;
                case -1882559631:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_PHONE)) {
                        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(5)).toArray(new String[0]);
                        if (!PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8515c(settingsImportPrefFragment, strArr, 7), (String[]) Arrays.copyOf(strArr, strArr.length))) {
                            return true;
                        }
                        settingsImportPrefFragment.importSNoteFromLocal();
                        return true;
                    }
                    break;
                case -935883241:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_SAMSUNG_ACCOUNT)) {
                        if (settingsImportPrefFragment.checkNetworkState() || !PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8780d(settingsImportPrefFragment, 2), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                            return true;
                        }
                        settingsImportPrefFragment.showDialogWhenMobileNetwork(new RunnableC8780d(settingsImportPrefFragment, 3));
                        return true;
                    }
                    break;
                case 235906209:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_SNOTE_FROM_GOOGLE_DRIVE)) {
                        if (settingsImportPrefFragment.checkNetworkState() || !PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8780d(settingsImportPrefFragment, 13), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                            return true;
                        }
                        settingsImportPrefFragment.showDialogWhenMobileNetwork(new RunnableC8780d(settingsImportPrefFragment, 0));
                        return true;
                    }
                    break;
                case 487904093:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_MEMOS_FROM_PHONE)) {
                        if (!PermissionUtils.hasMemoStoragePermission(settingsImportPrefFragment.getContext())) {
                            settingsImportPrefFragment.memoPermissionErrorPopupAlertDialog();
                            return true;
                        }
                        if (!PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8780d(settingsImportPrefFragment, 1), "android.permission.READ_EXTERNAL_STORAGE")) {
                            return true;
                        }
                        settingsImportPrefFragment.importMemoFromLocal();
                        return true;
                    }
                    break;
                case 916017755:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_SCRAPBOOKS_FROM_SAMSUNG_ACCOUNT)) {
                        if (settingsImportPrefFragment.checkNetworkState() || !PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8780d(settingsImportPrefFragment, 4), "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                            return true;
                        }
                        settingsImportPrefFragment.showDialogWhenMobileNetwork(new RunnableC8780d(settingsImportPrefFragment, 10));
                        return true;
                    }
                    break;
                case 1126419624:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_RESTORE_FROM_SERVER)) {
                        settingsImportPrefFragment.importSNBAKFromLocal();
                        return true;
                    }
                    break;
                case 1563105813:
                    if (key.equals(SettingsConstants.SETTINGS_IMPORT_NOTES_FROM_PHONE)) {
                        if (!PermissionHelper.isPermissionGranted(settingsImportPrefFragment.getActivity(), new RunnableC8780d(settingsImportPrefFragment, 9), "android.permission.READ_EXTERNAL_STORAGE")) {
                            return true;
                        }
                        settingsImportPrefFragment.importNotesFromLocal();
                        return true;
                    }
                    break;
            }
        }
        AbstractC8014b.m7209k("unexpected key: ", key, TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$10(SettingsImportPrefFragment settingsImportPrefFragment) {
        settingsImportPrefFragment.requestPermissions(304, "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$11(SettingsImportPrefFragment settingsImportPrefFragment) {
        settingsImportPrefFragment.requestPermissions(305, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$13(SettingsImportPrefFragment settingsImportPrefFragment) {
        settingsImportPrefFragment.requestPermissions(306, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$4(SettingsImportPrefFragment settingsImportPrefFragment) {
        settingsImportPrefFragment.requestPermissions(300, "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$5(SettingsImportPrefFragment settingsImportPrefFragment, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 30) {
            PermissionUtils.showAllFilesAccessPermission(settingsImportPrefFragment.getActivity(), 302);
        } else {
            settingsImportPrefFragment.requestPermissions(302, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$6(SettingsImportPrefFragment settingsImportPrefFragment) {
        settingsImportPrefFragment.requestPermissions(301, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreferenceClickListener$lambda$15$lambda$8(SettingsImportPrefFragment settingsImportPrefFragment) {
        settingsImportPrefFragment.requestPermissions(303, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE");
    }

    private final void memoPermissionErrorPopupAlertDialog() {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null);
        alertDialogBuilderForAppCompat.setMessage(C8003R.string.import_memo_application_permission_alert).setCancelable(true).setPositiveButton(C8003R.string.f6004OK, new DialogInterfaceOnClickListenerC0140a(5)).create();
        alertDialogBuilderForAppCompat.setTitle(C8003R.string.import_memo_application_permission_alert_title);
        alertDialogBuilderForAppCompat.show();
    }

    private final void removePreference(Preference preference) {
        PreferenceGroup parent;
        PreferenceGroup parent2 = preference.getParent();
        if (parent2 != null) {
            parent2.removePreference(preference);
            if (parent2.getPreferenceCount() != 0 || (parent = parent2.getParent()) == null) {
                return;
            }
            parent.removePreference(parent2);
        }
    }

    private final void requestIDValidation(int requestCode) {
        if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.LOCAL) {
            try {
                C13541h.m14287e().getClass();
                Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_CHECKLIST_VALIDATION");
                intent.setPackage("com.osp.app.signin");
                intent.putExtra("client_id", CommonUtils.getAppServiceId());
                intent.putExtra("validation_result_only", false);
                startActivityForResult(intent, requestCode);
            } catch (ActivityNotFoundException e) {
                MainLogger.m7255e(TAG, "requestIDValidation() e : " + e);
            }
        }
    }

    private final void requestPermissions(int requestCode, String... permissions) {
        PermissionHelper.requestPermissions(this, requestCode, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    private final void setGoogleDriveReady() {
        if (this.mCredential == null) {
            MainLogger.m7258i(TAG, "isGoogleDriveReady() credential is null!");
            ArrayList arrayList = new ArrayList();
            arrayList.add("https://www.googleapis.com/auth/drive");
            this.mCredential = GoogleAccountCredential.usingOAuth2(getActivity(), arrayList);
        }
        MainLogger.m7258i(TAG, "isGoogleDriveReady() Drive is ready!");
    }

    private final void showDialogWhenMobileNetwork(Runnable run) {
        C0145c.m313U(getContext(), Boolean.FALSE);
        if (C0145c.m298F(getActivity())) {
            if (run != null) {
                run.run();
                return;
            }
            return;
        }
        MainLogger.m7258i(TAG, "Data connection is not wifi");
        int i = C8003R.string.sync_network_dialog_mobile_data_warning_body;
        if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            i = C8003R.string.sync_network_dialog_mobile_data_warning_body_chn;
        } else if (DeviceUtils.isTabletModel()) {
            i = C8003R.string.sync_network_dialog_mobile_data_warning_body_tablet;
        }
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null);
        alertDialogBuilderForAppCompat.setTitle(C8003R.string.sync_network_dialog_mobile_data_warning_title);
        alertDialogBuilderForAppCompat.setMessage(i);
        alertDialogBuilderForAppCompat.setPositiveButton(C8003R.string.sync_network_dialog_btn_ok, new DialogInterfaceOnClickListenerC0174a(run, this, 4)).setNegativeButton(C8003R.string.sync_network_dialog_btn_cancel, new DialogInterfaceOnClickListenerC0161a(this, 6));
        alertDialogBuilderForAppCompat.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialogWhenMobileNetwork$lambda$1(Runnable runnable, SettingsImportPrefFragment settingsImportPrefFragment, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            C0145c.m313U(settingsImportPrefFragment.getContext(), Boolean.TRUE);
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialogWhenMobileNetwork$lambda$2(SettingsImportPrefFragment settingsImportPrefFragment, DialogInterface dialogInterface, int i) {
        C0145c.m313U(settingsImportPrefFragment.getContext(), Boolean.FALSE);
        dialogInterface.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String stringExtra;
        AbstractC8014b.m7200b(requestCode, resultCode, "onActivityResult# requestCode = ", " , resultCode : ", TAG);
        if (resultCode != -1) {
            if (resultCode < 1 || data == null || (stringExtra = data.getStringExtra("error_code")) == null) {
                return;
            }
            NetworkConnectionFailedHelper.getInstance().show(getContext(), 2);
            MainLogger.m7258i(TAG, "network error code: " + stringExtra + " msg : " + data.getStringExtra("error_message"));
            return;
        }
        switch (requestCode) {
            case 101:
                MainLogger.m7258i(TAG, "onActivityResult() : REQUEST_SYNC_ACCESS_TOKEN");
                Intent intent = new Intent(getActivity(), (Class<?>) ImportActivity.class);
                intent.putExtra(ImportConstants.KEY_TYPE, this.mTaskType.ordinal());
                startActivity(intent);
                break;
            case 102:
                MainLogger.m7258i(TAG, "onActivityResult() : REQUEST_ACCOUNT_PICKER");
                if (data != null && data.getExtras() != null) {
                    MainLogger.m7258i(TAG, "onActivityResult() select a google account!");
                    String stringExtra2 = data.getStringExtra("authAccount");
                    if (stringExtra2 != null) {
                        setGoogleDriveReady();
                        GoogleAccountCredential googleAccountCredential = this.mCredential;
                        Intrinsics.checkNotNull(googleAccountCredential);
                        googleAccountCredential.setSelectedAccountName(stringExtra2);
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImportActivity.class);
                        intent2.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SNOTE_GOOGLEDRIVE.ordinal());
                        intent2.putExtra("account_name", stringExtra2);
                        startActivity(intent2);
                    }
                }
                break;
            case 103:
                Intent intent3 = new Intent(getActivity(), (Class<?>) ImportActivity.class);
                intent3.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SNOTE_SCLOUD.ordinal());
                startActivity(intent3);
                break;
            case 104:
                Intent intent4 = new Intent(getActivity(), (Class<?>) ImportActivity.class);
                intent4.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.MEMO_SCLOUD.ordinal());
                List<ResolveInfo> listQueryIntentActivities = requireActivity().getPackageManager().queryIntentActivities(intent4, 0);
                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
                if (!listQueryIntentActivities.isEmpty()) {
                    startActivity(intent4);
                }
                break;
            case 105:
                Intent intent5 = new Intent(getActivity(), (Class<?>) ImportActivity.class);
                intent5.putExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SCRAPBOOK_SCLOUD.ordinal());
                List<ResolveInfo> listQueryIntentActivities2 = requireActivity().getPackageManager().queryIntentActivities(intent5, 0);
                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities2, "queryIntentActivities(...)");
                if (!listQueryIntentActivities2.isEmpty()) {
                    startActivity(intent5);
                }
                break;
            default:
                AbstractC8014b.m7201c(requestCode, "unexpected requestCode: ", TAG);
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        addPreferencesFromResource(C8003R.xml.settings_import_preference);
        initLayout();
        NotificationUtils.checkedNotificationPermissions$default(this, 0, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (PermissionHelper.verifyRequestResult(getActivity(), grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
            switch (requestCode) {
                case 300:
                    importNotesFromLocal();
                    break;
                case 301:
                    showDialogWhenMobileNetwork(new RunnableC8780d(this, 5));
                    break;
                case 302:
                    importSNoteFromLocal();
                    break;
                case 303:
                    showDialogWhenMobileNetwork(new RunnableC8780d(this, 6));
                    break;
                case 304:
                    importMemoFromLocal();
                    break;
                case 305:
                    showDialogWhenMobileNetwork(new RunnableC8780d(this, 7));
                    break;
                case 306:
                    showDialogWhenMobileNetwork(new RunnableC8780d(this, 8));
                    break;
                case 307:
                default:
                    AbstractC8014b.m7201c(requestCode, "unexpected requestCode: ", TAG);
                    break;
                case 308:
                    importSNBAKFromLocal();
                    break;
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UserInputSkipper.releaseHoldingEventTimeByTag(UserInputSkipper.Tag.SettingsDetail);
    }

    public final void resultAllFilesAccessPermission(int requestCode) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 30 && requestCode == 302) {
            String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(5)).toArray(new String[0]);
            if (PermissionHelper.isPermissionGrantedWithoutNotice(getActivity(), (String[]) Arrays.copyOf(strArr, strArr.length))) {
                importSNoteFromLocal();
                z = true;
            } else {
                String string = getResources().getString(C8003R.string.need_to_allow_permission, getResources().getString(C8003R.string.storage_permission_title));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ToastHandler.show(getContext(), string, 1);
            }
        }
        AbstractC8014b.m7210l("resultAllFilesAccessPermission# result : ", TAG, z);
    }
}
