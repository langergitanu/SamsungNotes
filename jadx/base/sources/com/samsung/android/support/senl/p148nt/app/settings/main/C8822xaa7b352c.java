package com.samsung.android.support.senl.p148nt.app.settings.main;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.dialog.SettingsConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.task.SetWifiSyncOnlyTask;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import kotlin.Metadata;
import p244u1.C14477a;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.main.SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/settings/main/SettingsSyncHelper$mTurnOnWiFiSyncOnlyConfirmDialogFragmentListener$1", "Lcom/samsung/android/support/senl/nt/app/common/dialog/SettingsConfirmDialogFragment$WifiSyncOnlyDialogListener;", "onConfirm", "", "isWiFiSyncOnly", "", "onCancel", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class C8822xaa7b352c implements SettingsConfirmDialogFragment.WifiSyncOnlyDialogListener {
    final /* synthetic */ SettingsBaseFragment $fragment;
    final /* synthetic */ SettingsSyncHelper this$0;

    public C8822xaa7b352c(SettingsBaseFragment settingsBaseFragment, SettingsSyncHelper settingsSyncHelper) {
        this.$fragment = settingsBaseFragment;
        this.this$0 = settingsSyncHelper;
    }

    @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
    public void onCancel() {
        C14477a.m15065b().m15075k(false);
        this.this$0.updateSCloudSyncSummary();
        this.this$0.checkedNotificationPermissions();
    }

    @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.WifiSyncOnlyDialogListener
    public void onConfirm(boolean isWiFiSyncOnly) {
        SetWifiSyncOnlyTask setWifiSyncOnlyTask = new SetWifiSyncOnlyTask();
        setWifiSyncOnlyTask.setCallback(new C8823xcc108cb6(this.$fragment, this));
        setWifiSyncOnlyTask.run(Boolean.valueOf(isWiFiSyncOnly));
    }

    @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
    public void onConfirm() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_TURN_ON_SYNC_OPTION, true);
        C14477a.m15065b().m15075k(true);
        this.this$0.updateSCloudSyncSummary();
        this.this$0.checkedNotificationPermissions();
    }
}
