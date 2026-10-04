package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.ProgressPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft;
import com.samsung.android.support.senl.p148nt.app.settings.task.SetWifiSyncOnlyTask;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p021E0.InterfaceC0074a;
import p025F0.AbstractC0089d;
import p035H2.RunnableC0116a;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p066P2.RunnableC0201c;
import p091W2.C0331a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0012H\u0002J\"\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u00103\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsSyncToMicrosoftPrefFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "Landroidx/preference/Preference$OnPreferenceClickListener;", "<init>", "()V", "mSettingsMicrosoft", "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft;", "mSwitchPreference", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SwitchPreference;", "onCreatePreferences", "", "bundle", "Landroid/os/Bundle;", "s", "", "onResume", "onDestroy", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", SearchIndexablesContract.BaseColumns.COLUMN_INTENT_ACTION, "getIntentAction", "()Ljava/lang/String;", "syncToMicrosoftNow", "initLayout", "setOnPreferenceClickListenerWithKey", "key", "", "updateLayout", "updateSyncNowDelayed", "isSyncProgressing", "updateSyncNow", "updateLastSyncTime", "showProgressingText", "updateSyncType", "updateMoreApps", "startFolderManageSyncActivity", "showSyncTypeDialog", "setWifiSyncOnly", "isWifiSyncOnly", "showLogoutConfirmDialog", "enabledSyncMenu", "enabled", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "showMeridianHome", "isMeridianEnable", "()Z", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsSyncToMicrosoftPrefFragment extends SettingsBaseFragment implements Preference.OnPreferenceClickListener {

    @NotNull
    private static final String COM_MICROSOFT_SKYDRIVE_MERIDIANACTIVITY_ACTION_STARTMERIDIAN = "com.microsoft.skydrive.meridianactivity.action.startmeridian";
    private static final int REQUEST_CODE_START_FOLDER_TO_SYNC = 1;

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_FOLDERS_TO_SYNC = "settings_sync_to_microsoft_folders_to_sync";

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_LAST_SYNC_TIME = "settings_sync_to_microsoft_last_sync_time";

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_MORE_APPS = "settings_sync_to_microsoft_more_apps";

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_SIGN_INFO = "settings_sync_to_microsoft_sign_info";

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_SYNC_NOW = "settings_sync_to_microsoft_sync_now";

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_SYNC_TYPE = "settings_sync_to_microsoft_sync_type";

    @NotNull
    private static final String SETTINGS_SYNC_TO_MICROSOFT_SYNC_WHILE_ROAMING = "settings_sync_to_microsoft_sync_while_roaming";

    @NotNull
    public static final String TAG = "ST$SettingsSyncToMicrosoftPrefFragment";

    @Nullable
    private SettingsMicrosoft mSettingsMicrosoft;

    @Nullable
    private SwitchPreference mSwitchPreference;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment$setWifiSyncOnly$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/settings/detail/SettingsSyncToMicrosoftPrefFragment$setWifiSyncOnly$1", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Callback;", "PROGRESS_TAG", "", "onStart", "", "task", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "onEnd", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C87721 implements WorkerTask.Callback {
        private final String PROGRESS_TAG = "progress_dialog";

        public C87721() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onEnd$lambda$1(SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, C87721 c87721) {
            DialogFragment dialogFragment = (DialogFragment) settingsSyncToMicrosoftPrefFragment.getChildFragmentManager().findFragmentByTag(c87721.PROGRESS_TAG);
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
            settingsSyncToMicrosoftPrefFragment.updateSyncType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStart$lambda$0(WorkerTask workerTask, SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, C87721 c87721) {
            if (workerTask.isCompleted() || workerTask.isCancelled()) {
                return;
            }
            DialogFragment dialogFragmentCreateCircleProgressDialogFragment = DialogUtils.createCircleProgressDialogFragment();
            dialogFragmentCreateCircleProgressDialogFragment.setCancelable(false);
            dialogFragmentCreateCircleProgressDialogFragment.show(settingsSyncToMicrosoftPrefFragment.getChildFragmentManager(), c87721.PROGRESS_TAG);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onEnd(WorkerTask.Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
            View view = SettingsSyncToMicrosoftPrefFragment.this.getView();
            if (view != null) {
                view.post(new RunnableC8515c(SettingsSyncToMicrosoftPrefFragment.this, this, 9));
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onStart(WorkerTask<?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            View view = SettingsSyncToMicrosoftPrefFragment.this.getView();
            if (view != null) {
                view.postDelayed(new RunnableC0201c(task, 28, SettingsSyncToMicrosoftPrefFragment.this, this), 200L);
            }
        }
    }

    private final void enabledSyncMenu(boolean enabled) {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_NOW);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setEnabled(enabled);
        }
        Preference preferenceFindPreference2 = findPreference(SETTINGS_SYNC_TO_MICROSOFT_FOLDERS_TO_SYNC);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setEnabled(enabled);
        }
        Preference preferenceFindPreference3 = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_TYPE);
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setEnabled(enabled);
        }
        Preference preferenceFindPreference4 = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_WHILE_ROAMING);
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setEnabled(enabled);
        }
        Preference preferenceFindPreference5 = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SIGN_INFO);
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setEnabled(enabled);
        }
    }

    private final String getIntentAction() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return null;
        }
        return intent.getAction();
    }

    private final void initLayout() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_SYNC_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        preferenceCategory.seslSetSubheaderRoundedBackground(3);
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
        this.mSwitchPreference = switchPreference;
        if (switchPreference == null) {
            return;
        }
        Intrinsics.checkNotNull(switchPreference);
        switchPreference.setChecked(AbstractC6784f.f4180a.f4186f);
        SwitchPreference switchPreference2 = this.mSwitchPreference;
        Intrinsics.checkNotNull(switchPreference2);
        switchPreference2.setOnPreferenceChangeListener(new C7737b(this, 22));
        SwitchPreference switchPreference3 = this.mSwitchPreference;
        Intrinsics.checkNotNull(switchPreference3);
        switchPreference3.setOnCheckedChangeListener(new C0331a(this, 7));
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_WHILE_ROAMING);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceChangeListener(new C8416h(2));
        Preference preferenceFindPreference2 = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_TYPE);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setVisible(!C0145c.m339x(getContext()));
        }
        setOnPreferenceClickListenerWithKey(SETTINGS_SYNC_TO_MICROSOFT_SYNC_NOW);
        setOnPreferenceClickListenerWithKey(SETTINGS_SYNC_TO_MICROSOFT_FOLDERS_TO_SYNC);
        setOnPreferenceClickListenerWithKey(SETTINGS_SYNC_TO_MICROSOFT_SYNC_TYPE);
        setOnPreferenceClickListenerWithKey(SETTINGS_SYNC_TO_MICROSOFT_SIGN_INFO);
        setOnPreferenceClickListenerWithKey(SETTINGS_SYNC_TO_MICROSOFT_MORE_APPS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initLayout$lambda$0(SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        SwitchPreference switchPreference = settingsSyncToMicrosoftPrefFragment.mSwitchPreference;
        Intrinsics.checkNotNull(switchPreference);
        switchPreference.setChecked(zBooleanValue);
        AbstractC6784f.f4180a.m4949m(zBooleanValue);
        settingsSyncToMicrosoftPrefFragment.enabledSyncMenu(zBooleanValue);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_TOGGLE, zBooleanValue ? "1" : "0");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$2(SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        buttonView.setClickable(false);
        buttonView.postDelayed(new RunnableC8785i(buttonView, 0), 500L);
        if (ContentResolver.getMasterSyncAutomatically()) {
            SwitchPreference switchPreference = settingsSyncToMicrosoftPrefFragment.mSwitchPreference;
            Intrinsics.checkNotNull(switchPreference);
            if (z != switchPreference.isChecked()) {
                CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_TOGGLE, z ? "1" : "0");
            }
            SwitchPreference switchPreference2 = settingsSyncToMicrosoftPrefFragment.mSwitchPreference;
            Intrinsics.checkNotNull(switchPreference2);
            switchPreference2.setChecked(z);
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_MICROSOFT_SYNC, z);
            AbstractC6784f.f4180a.m4949m(z);
            settingsSyncToMicrosoftPrefFragment.enabledSyncMenu(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$2$lambda$1(CompoundButton compoundButton) {
        compoundButton.setEnabled(true);
        compoundButton.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initLayout$lambda$3(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        try {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (zBooleanValue == SharedPreferencesCompat.getInstance("Settings").getBoolean("key_sync_while_roaming", false)) {
                return false;
            }
            SharedPreferencesCompat.getInstance("Settings").putBoolean("key_sync_while_roaming", zBooleanValue);
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_WILE_ROAMING, zBooleanValue ? "1" : "0");
            return true;
        } catch (ClassCastException unused) {
            MainLogger.m7255e(TAG, "Error: ClassCastException");
            return false;
        }
    }

    private final boolean isMeridianEnable() {
        Bundle bundleCall;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                bundleCall = requireContext().getContentResolver().call("com.microsoft.skydrive.content.external", "IS_MERIDIAN_ENABLED", (String) null, (Bundle) null);
            } catch (Exception e) {
                AbstractC0000a.m25v("Call Meridian failed ", e.getMessage(), TAG);
                bundleCall = null;
            }
        } else {
            bundleCall = null;
        }
        if (bundleCall != null) {
            return bundleCall.getBoolean("IS_MERIDIAN_ENABLED", false);
        }
        return false;
    }

    private final void setOnPreferenceClickListenerWithKey(CharSequence key) {
        Preference preferenceFindPreference = findPreference(key);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
        }
    }

    private final void setWifiSyncOnly(boolean isWifiSyncOnly) {
        SetWifiSyncOnlyTask setWifiSyncOnlyTask = new SetWifiSyncOnlyTask();
        setWifiSyncOnlyTask.setCallback(new C87721());
        setWifiSyncOnlyTask.run(Boolean.valueOf(isWifiSyncOnly));
    }

    private final void showLogoutConfirmDialog() {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).setMessage(C8003R.string.settings_sync_to_ms_sign_out_confirm_dialog_body).setPositiveButton(C8003R.string.settings_log_out, new DialogInterfaceOnClickListenerC0161a(this, 7)).setNegativeButton(C8003R.string.cancel_btn, (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLogoutConfirmDialog$lambda$8(SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, DialogInterface dialogInterface, int i) {
        SettingsMicrosoft settingsMicrosoft = settingsSyncToMicrosoftPrefFragment.mSettingsMicrosoft;
        if (settingsMicrosoft != null) {
            Intrinsics.checkNotNull(settingsMicrosoft);
            settingsMicrosoft.signOut();
        }
    }

    private final void showMeridianHome() {
        if (isMeridianEnable()) {
            Intent intent = new Intent(COM_MICROSOFT_SKYDRIVE_MERIDIANACTIVITY_ACTION_STARTMERIDIAN);
            intent.setPackage("com.microsoft.skydrive");
            intent.putExtra("triggerReason", "HOME");
            intent.addFlags(268435456);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                AbstractC8014b.m7209k("showMeridianHome() ", e.getMessage(), TAG);
            }
        }
    }

    private final void showProgressingText() {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_TO_MICROSOFT_LAST_SYNC_TIME);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setTitle(C8003R.string.settings_sync_now_syncing);
    }

    private final void showSyncTypeDialog() {
        View viewInflate = getLayoutInflater().inflate(C8003R.layout.sync_notes_data_type_dialog, (ViewGroup) null);
        final int i = 0;
        final AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), i, 2, null).setView(viewInflate).setNegativeButton(getResources().getString(C8003R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(6)).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C8003R.string.settings_sync_notes_data);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final int i2 = 1;
        String str = String.format(string, Arrays.copyOf(new Object[]{getString(C8003R.string.settings_sync_notes_data_body)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        alertDialogCreate.setTitle(str);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (C0145c.m299G(getContext())) {
            View viewFindViewById = viewInflate.findViewById(C8003R.id.wifi_only);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RadioButton");
            ((RadioButton) viewFindViewById).setChecked(true);
        } else {
            View viewFindViewById2 = viewInflate.findViewById(C8003R.id.both_wifi_mobile);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RadioButton");
            ((RadioButton) viewFindViewById2).setChecked(true);
        }
        viewInflate.findViewById(C8003R.id.wifi_only_layout).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        SettingsSyncToMicrosoftPrefFragment.showSyncTypeDialog$lambda$6(alertDialogCreate, this, view);
                        break;
                    default:
                        SettingsSyncToMicrosoftPrefFragment.showSyncTypeDialog$lambda$7(alertDialogCreate, this, view);
                        break;
                }
            }
        });
        viewInflate.findViewById(C8003R.id.both_wifi_mobile_layout).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        SettingsSyncToMicrosoftPrefFragment.showSyncTypeDialog$lambda$6(alertDialogCreate, this, view);
                        break;
                    default:
                        SettingsSyncToMicrosoftPrefFragment.showSyncTypeDialog$lambda$7(alertDialogCreate, this, view);
                        break;
                }
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSyncTypeDialog$lambda$6(AlertDialog alertDialog, SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, View view) {
        alertDialog.dismiss();
        settingsSyncToMicrosoftPrefFragment.setWifiSyncOnly(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSyncTypeDialog$lambda$7(AlertDialog alertDialog, SettingsSyncToMicrosoftPrefFragment settingsSyncToMicrosoftPrefFragment, View view) {
        alertDialog.dismiss();
        settingsSyncToMicrosoftPrefFragment.setWifiSyncOnly(false);
    }

    private final void startFolderManageSyncActivity() {
        if (FolderAccessHandler.getFolderListClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(getContext(), FolderAccessHandler.getFolderListClass());
        intent.putExtra(FolderConstants.KEY_FOLDER_MODE_INDEX, 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!Intrinsics.areEqual(NotesConstants.ACTION_MICROSOFT_LOGIN, activity.getIntent().getAction())) {
                startActivity(intent);
            } else {
                intent.setAction(NotesConstants.ACTION_MICROSOFT_LOGIN);
                startActivityForResult(intent, 1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.samsung.android.support.senl.nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment$syncToMicrosoftNow$isSyncStarted$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void syncToMicrosoftNow() {
        if (AbstractC6784f.f4180a.m4950n(new InterfaceC0074a() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment$syncToMicrosoftNow$isSyncStarted$1
            @Override // p021E0.InterfaceC0074a
            public void onCancel(List<String> submittedList) {
                Intrinsics.checkNotNullParameter(submittedList, "submittedList");
                this.this$0.updateSyncNow(false);
            }

            @Override // p021E0.InterfaceC0074a
            public void onResult(List<String> submittedList) {
                Intrinsics.checkNotNullParameter(submittedList, "submittedList");
                if (!submittedList.isEmpty()) {
                    this.this$0.updateLastSyncTime();
                }
                this.this$0.updateSyncNow(false);
            }
        })) {
            updateSyncNow(true);
            return;
        }
        AbstractC0089d.m231c(System.currentTimeMillis());
        updateSyncNow(true);
        updateSyncNowDelayed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLastSyncTime() {
        if (getContext() == null) {
            return;
        }
        AbstractC6784f.f4180a.getClass();
        long jM328m = C0145c.m328m(0L, "GRAPH_PREFERENCE", "synced_time");
        String string = jM328m > 0 ? getString(C8003R.string.settings_sync_now_last_synced, AbstractC0155m.m396k(getContext(), jM328m)) : getString(C8003R.string.settings_sync_now_no_history);
        Intrinsics.checkNotNull(string);
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_TO_MICROSOFT_LAST_SYNC_TIME);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setTitle(string);
    }

    private final void updateLayout() {
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
        if (switchPreference == null) {
            return;
        }
        if (ContentResolver.getMasterSyncAutomatically()) {
            switchPreference.setVisible(true);
            enabledSyncMenu(switchPreference.isChecked());
        } else {
            switchPreference.setVisible(false);
            enabledSyncMenu(AbstractC6784f.f4180a.f4186f);
        }
        updateSyncNow(false);
        updateLastSyncTime();
        updateSyncType();
        updateMoreApps();
    }

    private final void updateMoreApps() {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_TO_MICROSOFT_MORE_APPS);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setVisible(isMeridianEnable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSyncNow(boolean isSyncProgressing) {
        ProgressPreference progressPreference = (ProgressPreference) findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_NOW);
        if (progressPreference == null) {
            return;
        }
        progressPreference.setProgressVisibility(isSyncProgressing ? 0 : 8);
        if (isSyncProgressing) {
            showProgressingText();
        } else {
            updateLastSyncTime();
        }
    }

    private final void updateSyncNowDelayed(boolean isSyncProgressing) {
        SwitchPreference switchPreference = this.mSwitchPreference;
        Intrinsics.checkNotNull(switchPreference);
        switchPreference.postDelayed(new RunnableC0116a(11, this, isSyncProgressing), 500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSyncType() {
        boolean zM299G = C0145c.m299G(getContext());
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_TO_MICROSOFT_SYNC_TYPE);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setSummary(zM299G ? C8003R.string.settings_wifi_sync_only : C8003R.string.settings_both_wifi_and_mobile);
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_SYNC_USING, zM299G ? "a" : "b");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (1 != requestCode) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity) || resultCode != -1) {
            return;
        }
        Intrinsics.checkNotNull(activity);
        activity.finish();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        if (((C13540g) C13541h.m14287e().f9588a).m14285a() && C0158a.m407a().m417k() && Intrinsics.areEqual(NotesConstants.ACTION_MICROSOFT_LOGIN, getIntentAction())) {
            AbstractC6784f.f4180a.m4949m(true);
            startFolderManageSyncActivity();
        }
        if (Intrinsics.areEqual(Constants.ACTION_START_SIGNOUT_MS_FEED, getIntentAction())) {
            showLogoutConfirmDialog();
        }
        getPreferenceManager().setSharedPreferencesName("Settings");
        getPreferenceManager().setSharedPreferencesMode(0);
        addPreferencesFromResource(C8003R.xml.settings_sync_to_microsoft_preference);
        initLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
        if (settingsMicrosoft != null) {
            Intrinsics.checkNotNull(settingsMicrosoft);
            settingsMicrosoft.release();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1895598433:
                    if (key.equals(SETTINGS_SYNC_TO_MICROSOFT_SYNC_NOW)) {
                        if (!C0145c.m334s(getContext())) {
                            ToastHandler.show(getContext(), C8003R.string.settings_sync_to_ms_network_connection_error_msg, 1);
                            return false;
                        }
                        if (C0145c.m299G(getContext()) && !C0145c.m298F(getContext())) {
                            ToastHandler.show(getContext(), C8003R.string.settings_sync_over_wifi_only, 1);
                            return false;
                        }
                        syncToMicrosoftNow();
                        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_NOW);
                        return false;
                    }
                    break;
                case -1610499249:
                    if (key.equals(SETTINGS_SYNC_TO_MICROSOFT_MORE_APPS)) {
                        showMeridianHome();
                        return false;
                    }
                    break;
                case -861335208:
                    if (key.equals(SETTINGS_SYNC_TO_MICROSOFT_FOLDERS_TO_SYNC)) {
                        startFolderManageSyncActivity();
                        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_FOLDER_TO_SYNC);
                        return false;
                    }
                    break;
                case 1366178961:
                    if (key.equals(SETTINGS_SYNC_TO_MICROSOFT_SYNC_TYPE)) {
                        showSyncTypeDialog();
                        return false;
                    }
                    break;
                case 1943008291:
                    if (key.equals(SETTINGS_SYNC_TO_MICROSOFT_SIGN_INFO)) {
                        SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
                        Intrinsics.checkNotNull(settingsMicrosoft);
                        if (!settingsMicrosoft.isSignIn()) {
                            return false;
                        }
                        showLogoutConfirmDialog();
                        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_SYNC, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_SIGN_OUT);
                        return false;
                    }
                    break;
            }
        }
        AbstractC6670b.m4738C("onPreferenceClick# unexpected key: ", key, TAG);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MainLogger.m7258i(TAG, "onResume()");
        this.mSettingsMicrosoft = new SettingsMicrosoft(new WeakReference(getActivity()), new SettingsMicrosoft.MicrosoftCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment.onResume.1
            @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
            public void onEnable(boolean enable) {
                SwitchPreference switchPreference = (SwitchPreference) SettingsSyncToMicrosoftPrefFragment.this.findPreference(SettingsConstants.SETTINGS_MICROSOFT_SYNC);
                if (switchPreference == null) {
                    return;
                }
                switchPreference.setChecked(enable);
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
            public void onUpdate(boolean isSignIn, String info) {
                if (isSignIn) {
                    return;
                }
                FragmentActivity activity = SettingsSyncToMicrosoftPrefFragment.this.getActivity();
                Intrinsics.checkNotNull(activity);
                activity.finish();
            }
        });
        updateLayout();
    }
}
