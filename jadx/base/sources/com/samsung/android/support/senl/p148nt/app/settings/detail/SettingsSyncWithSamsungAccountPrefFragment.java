package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.app.notes.sync.quota.InterfaceC6872e;
import com.samsung.android.app.notes.sync.quota.QuotaServiceTask;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.app.notes.sync.synchronization.controllers.C6896g;
import com.samsung.android.sdk.pen.setting.quicktool.RunnableC7661m;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.EdpManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.ProgressPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.TextViewPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler;
import com.samsung.android.support.senl.p148nt.app.settings.common.listener.SyncStateListener;
import com.samsung.android.support.senl.p148nt.app.settings.task.SetWifiSyncOnlyTask;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog.NetworkConnectionFailedHelper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p026F1.AbstractC0100d;
import p026F1.C0098b;
import p030G1.InterfaceC0107a;
import p035H2.RunnableC0116a;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p066P2.RunnableC0202d;
import p079T.RunnableC0284b;
import p091W2.C0331a;
import p192j1.C12936a;
import p204m3.RunnableC13531b;
import p207n1.C13540g;
import p207n1.C13541h;
import p244u1.C14477a;
import p249v1.C14499b;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010\u0006J\u000f\u0010(\u001a\u00020\u000bH\u0002¢\u0006\u0004\b(\u0010\u0006J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0014H\u0002¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\u000b2\b\b\u0001\u0010,\u001a\u00020 H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\u0006J\u0017\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0014H\u0002¢\u0006\u0004\b2\u0010+J\u000f\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010\u0006J\u0017\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0014H\u0002¢\u0006\u0004\b5\u0010+J\u001f\u00108\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020 H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010\u0006R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsSyncWithSamsungAccountPrefFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "Landroidx/preference/Preference$OnPreferenceClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "<init>", "()V", "Landroid/os/Bundle;", "bundle", "", "s", "", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "onStart", "onResume", "onStop", "onDestroy", "Landroidx/preference/Preference;", "preference", "", "onPreferenceClick", "(Landroidx/preference/Preference;)Z", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "Landroid/view/View;", VPathDataCmd.RCurveTo, "onClick", "(Landroid/view/View;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "initializeGlobalSyncStatusHandler", "releaseGlobalSyncStatusHandler", "isWifiSyncOnly", "setWifiSyncOnly", "(Z)V", "stringId", "updateSamsungAccountSyncTypeSummary", "(I)V", "initLayout", "updateLayout", "isChecked", "updateSyncLayout", "updateLogoutLayout", "enabled", "enabledSyncMenu", "syncing", "errorCode", "updateSyncNow", "(ZI)V", "enableSyncNow", "Lcom/samsung/android/support/senl/nt/app/settings/common/listener/SyncStateListener;", "mSyncEnableModeListener", "Lcom/samsung/android/support/senl/nt/app/settings/common/listener/SyncStateListener;", "Landroidx/appcompat/app/AlertDialog;", "mSyncTypeDialog", "Landroidx/appcompat/app/AlertDialog;", "isQuotaUiNeeded", "Z", "Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler;", "mGlobalSyncStatusHandler", "Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler;", "Lcom/samsung/android/app/notes/sync/quota/e;", "mQuotaListener", "Lcom/samsung/android/app/notes/sync/quota/e;", "LG1/a;", "mUiSyncProgressListener", "LG1/a;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsSyncWithSamsungAccountPrefFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsSyncWithSamsungAccountPrefFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsSyncWithSamsungAccountPrefFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,771:1\n1#2:772\n*E\n"})
public final class SettingsSyncWithSamsungAccountPrefFragment extends SettingsBaseFragment implements Preference.OnPreferenceClickListener, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {
    private static final int REQUEST_ID_GET_ACCESS_TOKEN_FOR_SYNC = 106;

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_AUTO_SYNC_OFF_DESCRIPTION = "settings_sync_with_samsung_account_auto_sync_off_description";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE = "settings_sync_with_samsung_account_cloud_usage";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CONTENTS_CATEGORY = "settings_sync_with_samsung_account_contents_category";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_DESCRIPTION = "settings_sync_with_samsung_account_description";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_DESCRIPTION_CATEGORY = "settings_sync_with_samsung_account_description_category";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_LOG_OUT = "settings_sync_with_samsung_account_log_out";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_NOW = "settings_sync_with_samsung_account_sync_now";

    @NotNull
    private static final String SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE = "settings_sync_with_samsung_account_sync_type";

    @NotNull
    public static final String TAG = "ST$SettingsSyncWithSamsungAccountPrefFragment";
    private boolean isQuotaUiNeeded;

    @Nullable
    private SettingsGlobalSyncStatusHandler mGlobalSyncStatusHandler;

    @Nullable
    private SyncStateListener mSyncEnableModeListener;

    @Nullable
    private AlertDialog mSyncTypeDialog;

    @Nullable
    private InterfaceC6872e mQuotaListener = new C8790n(this, 0);

    @Nullable
    private InterfaceC0107a mUiSyncProgressListener = new InterfaceC0107a() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment$mUiSyncProgressListener$1
        @Override // p030G1.InterfaceC0107a
        public void onEnded(int errorCode) {
            if (CommonUtil.isNotAvailableActivity(this.this$0.getActivity())) {
                return;
            }
            this.this$0.updateSyncNow(false, errorCode);
        }

        @Override // p030G1.InterfaceC0107a
        public void onProgress(C0098b syncProgressInfo) {
            Intrinsics.checkNotNullParameter(syncProgressInfo, "syncProgressInfo");
            if (CommonUtil.isNotAvailableActivity(this.this$0.getActivity())) {
                return;
            }
            this.this$0.updateSyncNow(true, 0);
        }

        @Override // p030G1.InterfaceC0107a
        public void onStarted() {
            if (CommonUtil.isNotAvailableActivity(this.this$0.getActivity())) {
                return;
            }
            this.this$0.updateSyncNow(true, 0);
        }
    };

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment$setWifiSyncOnly$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/settings/detail/SettingsSyncWithSamsungAccountPrefFragment$setWifiSyncOnly$1", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Callback;", "PROGRESS_TAG", "", "onStart", "", "task", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "onEnd", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C87751 implements WorkerTask.Callback {
        final /* synthetic */ boolean $isWifiSyncOnly;
        private final String PROGRESS_TAG = "progress_dialog";

        public C87751(boolean z) {
            this.$isWifiSyncOnly = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onEnd$lambda$1(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, C87751 c87751, boolean z) {
            DialogFragment dialogFragment = (DialogFragment) settingsSyncWithSamsungAccountPrefFragment.getChildFragmentManager().findFragmentByTag(c87751.PROGRESS_TAG);
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
            settingsSyncWithSamsungAccountPrefFragment.enableSyncNow();
            settingsSyncWithSamsungAccountPrefFragment.updateSamsungAccountSyncTypeSummary(z ? C8003R.string.settings_wifi_sync_only : C8003R.string.settings_both_wifi_and_mobile);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStart$lambda$0(WorkerTask workerTask, SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, C87751 c87751) {
            if (workerTask.isCompleted() || workerTask.isCancelled()) {
                return;
            }
            DialogFragment dialogFragmentCreateCircleProgressDialogFragment = DialogUtils.createCircleProgressDialogFragment();
            dialogFragmentCreateCircleProgressDialogFragment.setCancelable(false);
            dialogFragmentCreateCircleProgressDialogFragment.show(settingsSyncWithSamsungAccountPrefFragment.getChildFragmentManager(), c87751.PROGRESS_TAG);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onEnd(WorkerTask.Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
            View view = SettingsSyncWithSamsungAccountPrefFragment.this.getView();
            if (view != null) {
                view.post(new RunnableC0202d(SettingsSyncWithSamsungAccountPrefFragment.this, this, this.$isWifiSyncOnly, 5));
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onStart(WorkerTask<?> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            View view = SettingsSyncWithSamsungAccountPrefFragment.this.getView();
            if (view != null) {
                view.postDelayed(new RunnableC13531b(task, 1, SettingsSyncWithSamsungAccountPrefFragment.this, this), 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableSyncNow() {
        ProgressPreference progressPreference = (ProgressPreference) findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_NOW);
        if (progressPreference == null) {
            return;
        }
        C14477a.m15065b().f10283a.getClass();
        if (!C14499b.m15085e()) {
            MainLogger.m7258i(TAG, "enableSyncNow() isCurrentSyncPossible : false");
            C6896g c6896g = C14477a.m15065b().f10283a;
            c6896g.getClass();
            if (!C14499b.m15085e()) {
                c6896g.mo5089a(105);
                Debugger.m8607d("SyncOldServiceController", "stop sync by updateSyncState");
            }
            progressPreference.setProgressVisibility(8);
            progressPreference.setTitle(C8003R.string.settings_sync_now);
            if (C0145c.m299G(getContext())) {
                progressPreference.setSummary(C8003R.string.settings_sync_now_wifi_not_available_on_only_wifi_check);
                return;
            } else {
                progressPreference.setSummary(C8003R.string.settings_sync_now_failed);
                return;
            }
        }
        if (!C14477a.m15065b().f10283a.m5099h()) {
            MainLogger.m7258i(TAG, "enableSyncNow() isNotSyncing : false");
            progressPreference.setProgressVisibility(0);
            progressPreference.setTitle(C8003R.string.settings_sync_now_stop);
            progressPreference.setSummary(C8003R.string.settings_sync_now_syncing);
            return;
        }
        MainLogger.m7258i(TAG, "enableSyncNow() isNotSyncing : true");
        progressPreference.setProgressVisibility(8);
        progressPreference.setTitle(C8003R.string.settings_sync_now);
        if (!C0145c.m298F(getContext()) && C0145c.m299G(getContext())) {
            progressPreference.setSummary(C8003R.string.settings_sync_now_wifi_not_available_on_only_wifi_check);
            return;
        }
        if (AbstractC0100d.m239a(getContext()) != 0) {
            progressPreference.setSummary(C8003R.string.settings_sync_now_failed);
            return;
        }
        long jM15161u = AbstractC14517a.m15161u();
        if (jM15161u <= 0) {
            progressPreference.setSummary(C8003R.string.settings_sync_now_no_history);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getResources().getString(C8003R.string.settings_sync_now_last_synced);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{AbstractC0155m.m396k(getContext(), jM15161u)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        progressPreference.setSummary(str);
    }

    private final void enabledSyncMenu(boolean enabled) {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_NOW);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setEnabled(enabled);
            if (!enabled) {
                updateSyncNow(false, 0);
            }
        }
        Preference preferenceFindPreference2 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setEnabled(enabled);
        }
        Preference preferenceFindPreference3 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_LOG_OUT);
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setEnabled(enabled);
        }
        Preference preferenceFindPreference4 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE);
        if (!this.isQuotaUiNeeded || preferenceFindPreference4 == null) {
            return;
        }
        preferenceFindPreference4.setEnabled(enabled);
    }

    private final void initLayout() {
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (switchPreference != null) {
            switchPreference.setChecked(C0158a.m407a().m417k());
            switchPreference.setOnPreferenceChangeListener(new C8789m(this));
            switchPreference.setOnCheckedChangeListener(new C0331a(this, 8));
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_DESCRIPTION_CATEGORY);
        if (preferenceCategory != null) {
            preferenceCategory.seslSetSubheaderRoundedBackground(12);
        }
        PreferenceCategory preferenceCategory2 = (PreferenceCategory) findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CONTENTS_CATEGORY);
        if (preferenceCategory2 != null) {
            preferenceCategory2.seslSetSubheaderRoundedBackground(3);
        }
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE);
        if (preferenceFindPreference != null) {
            if (C0145c.m339x(getContext())) {
                preferenceFindPreference.setVisible(false);
            } else {
                preferenceFindPreference.setVisible(true);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getResources().getString(C8003R.string.settings_sync_notes_data);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String str = String.format(string, Arrays.copyOf(new Object[]{getResources().getString(C8003R.string.settings_sync_notes_data_body)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                preferenceFindPreference.setTitle(str);
            }
        }
        Preference preferenceFindPreference2 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE);
        if (preferenceFindPreference2 != null && !this.isQuotaUiNeeded) {
            preferenceFindPreference2.setVisible(false);
        }
        TextViewPreference textViewPreference = (TextViewPreference) findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_DESCRIPTION);
        if (preferenceFindPreference2 == null || textViewPreference == null) {
            return;
        }
        if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
            textViewPreference.setTitle(C8003R.string.settings_sync_notes_description_jp);
            preferenceFindPreference2.setTitle(C8003R.string.settings_cloud_usage_status_jp);
        } else if (CommonUtils.hasSaSetting(getContext())) {
            textViewPreference.setTitle(C8003R.string.settings_sync_notes_description_na);
            preferenceFindPreference2.setTitle(C8003R.string.settings_cloud_usage_status_na);
        } else {
            textViewPreference.setTitle(C8003R.string.settings_sync_notes_description);
            preferenceFindPreference2.setTitle(C8003R.string.settings_cloud_usage_status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initLayout$lambda$17$lambda$14(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue && C14477a.m15065b().f10283a.m5099h() && C0145c.m299G(settingsSyncWithSamsungAccountPrefFragment.getContext()) && !C0145c.m298F(settingsSyncWithSamsungAccountPrefFragment.getContext())) {
            MainLogger.m7258i(TAG, "onCheckedChanged(). : settings_cannot_sync_in_wifi_only");
        }
        C14477a.m15065b().m15075k(zBooleanValue);
        if (!ContentResolver.getMasterSyncAutomatically()) {
            return false;
        }
        settingsSyncWithSamsungAccountPrefFragment.updateSyncLayout(zBooleanValue);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$17$lambda$16(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        MainLogger.m7258i(TAG, "onCheckedChanged(). Sync Accounts ".concat(z ? "enabled" : "disabled"));
        buttonView.setClickable(false);
        buttonView.postDelayed(new RunnableC8785i(buttonView, 1), 500L);
        if (z && C14477a.m15065b().f10283a.m5099h() && C0145c.m299G(settingsSyncWithSamsungAccountPrefFragment.getContext()) && !C0145c.m298F(settingsSyncWithSamsungAccountPrefFragment.getContext())) {
            MainLogger.m7258i(TAG, "onCheckedChanged(). : R.string.settings_cannot_sync_in_wifi_only");
        }
        C14477a.m15065b().m15075k(z);
        if (ContentResolver.getMasterSyncAutomatically()) {
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC, z);
            settingsSyncWithSamsungAccountPrefFragment.updateSyncLayout(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$17$lambda$16$lambda$15(CompoundButton compoundButton) {
        compoundButton.setEnabled(true);
        compoundButton.setClickable(true);
    }

    private final void initializeGlobalSyncStatusHandler() {
        if (this.mGlobalSyncStatusHandler != null) {
            return;
        }
        SettingsGlobalSyncStatusHandler settingsGlobalSyncStatusHandler = new SettingsGlobalSyncStatusHandler(new C8789m(this));
        this.mGlobalSyncStatusHandler = settingsGlobalSyncStatusHandler;
        Intrinsics.checkNotNull(settingsGlobalSyncStatusHandler);
        settingsGlobalSyncStatusHandler.initialize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeGlobalSyncStatusHandler$lambda$6(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment) {
        Preference preferenceFindPreference = settingsSyncWithSamsungAccountPrefFragment.findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_AUTO_SYNC_OFF_DESCRIPTION);
        PreferenceCategory preferenceCategory = (PreferenceCategory) settingsSyncWithSamsungAccountPrefFragment.findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_DESCRIPTION_CATEGORY);
        SwitchPreference switchPreference = (SwitchPreference) settingsSyncWithSamsungAccountPrefFragment.findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (ContentResolver.getMasterSyncAutomatically()) {
            if (preferenceCategory != null) {
                preferenceCategory.seslSetSubheaderRoundedBackground(12);
            }
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setVisible(false);
            }
            if (switchPreference != null) {
                switchPreference.setVisible(true);
                switchPreference.setEnabled(true);
                switchPreference.setChecked(C0158a.m407a().m417k());
                settingsSyncWithSamsungAccountPrefFragment.updateSyncLayout(switchPreference.isChecked());
                return;
            }
            return;
        }
        if (preferenceFindPreference != null) {
            preferenceFindPreference.seslSetSubheaderRoundedBackground(0);
            preferenceFindPreference.setVisible(true);
        }
        if (preferenceCategory != null) {
            preferenceCategory.seslSetSubheaderRoundedBackground(0);
        }
        if (switchPreference != null) {
            switchPreference.setVisible(false);
            switchPreference.setEnabled(false);
        }
        settingsSyncWithSamsungAccountPrefFragment.enabledSyncMenu(C0158a.m407a().m417k());
        if (C14477a.m15065b().f10283a.m5099h()) {
            return;
        }
        MainLogger.m7258i(TAG, "onStatusChanged. is syncing. stopSync()");
        C14477a.m15065b().m15076l(104);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mQuotaListener$lambda$1(final SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, final int i, long j, long j2) {
        double d = 1073741824L;
        final double d2 = j / d;
        final double d3 = j2 / d;
        final FragmentActivity activity = settingsSyncWithSamsungAccountPrefFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        Intrinsics.checkNotNull(activity);
        activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.l
            @Override // java.lang.Runnable
            public final void run() {
                SettingsSyncWithSamsungAccountPrefFragment.mQuotaListener$lambda$1$lambda$0(this.f6316a, i, activity, d2, d3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mQuotaListener$lambda$1$lambda$0(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, int i, Activity activity, double d, double d2) {
        Preference preferenceFindPreference = settingsSyncWithSamsungAccountPrefFragment.findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE);
        if (preferenceFindPreference == null) {
            return;
        }
        if (i == 101 || i == 201) {
            preferenceFindPreference.setSummary(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_cloud_usage_calc_fail_jp : C8003R.string.settings_cloud_usage_calc_fail);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = activity.getString(C8003R.string.settings_cloud_usage_used_size);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{AbstractC2322a.m1624n("%.2f", new Object[]{Double.valueOf(d)}, 1, "format(...)"), settingsSyncWithSamsungAccountPrefFragment.getString(C8003R.string.settings_gb), AbstractC2322a.m1624n("%.2f", new Object[]{Double.valueOf(d2)}, 1, "format(...)"), activity.getString(C8003R.string.settings_gb)}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        preferenceFindPreference.setSummary(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$12$lambda$11(SwitchPreference switchPreference) {
        switchPreference.setClickable(true);
        switchPreference.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$13() {
        if (ContentResolver.getMasterSyncAutomatically()) {
            C14477a.m15065b().f10283a.m5101k(true, true);
        } else {
            C14477a.m15065b().m15072h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreferenceClick$lambda$8$lambda$7(SwitchPreference switchPreference) {
        switchPreference.setEnabled(true);
        switchPreference.setClickable(false);
    }

    private final void releaseGlobalSyncStatusHandler() {
        SettingsGlobalSyncStatusHandler settingsGlobalSyncStatusHandler = this.mGlobalSyncStatusHandler;
        if (settingsGlobalSyncStatusHandler != null) {
            settingsGlobalSyncStatusHandler.release();
        }
        this.mGlobalSyncStatusHandler = null;
    }

    private final void setWifiSyncOnly(boolean isWifiSyncOnly) {
        SetWifiSyncOnlyTask setWifiSyncOnlyTask = new SetWifiSyncOnlyTask();
        setWifiSyncOnlyTask.setCallback(new C87751(isWifiSyncOnly));
        setWifiSyncOnlyTask.run(Boolean.valueOf(isWifiSyncOnly));
    }

    private final void updateLayout() {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_AUTO_SYNC_OFF_DESCRIPTION);
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_DESCRIPTION_CATEGORY);
        Preference preferenceFindPreference2 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE);
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (switchPreference != null) {
            switchPreference.setChecked(C0158a.m407a().m417k());
        }
        if (preferenceFindPreference != null && preferenceCategory != null && switchPreference != null) {
            if (ContentResolver.getMasterSyncAutomatically()) {
                preferenceCategory.seslSetSubheaderRoundedBackground(12);
                preferenceFindPreference.setVisible(false);
                switchPreference.setVisible(true);
                updateSyncLayout(switchPreference.isChecked());
            } else {
                preferenceFindPreference.seslSetSubheaderRoundedBackground(0);
                preferenceCategory.seslSetSubheaderRoundedBackground(0);
                preferenceFindPreference.setVisible(true);
                switchPreference.setVisible(false);
                enabledSyncMenu(C0158a.m407a().m417k());
            }
        }
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setSummary(C0145c.m299G(getContext()) ? C8003R.string.settings_wifi_sync_only : C8003R.string.settings_both_wifi_and_mobile);
        }
        updateLogoutLayout();
    }

    private final void updateLogoutLayout() {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_LOG_OUT);
        if (preferenceFindPreference == null) {
            return;
        }
        if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.LOCAL) {
            preferenceFindPreference.setVisible(false);
        } else {
            preferenceFindPreference.setVisible(((C13540g) C13541h.m14287e().f9588a).m14285a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSamsungAccountSyncTypeSummary(@StringRes int stringId) {
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setSummary(stringId);
        }
    }

    private final void updateSyncLayout(boolean isChecked) {
        getListView().post(new RunnableC0116a(12, this, isChecked));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSyncLayout$lambda$20(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, boolean z) {
        SwitchPreference switchPreference = (SwitchPreference) settingsSyncWithSamsungAccountPrefFragment.findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (switchPreference == null) {
            return;
        }
        switchPreference.setChecked(z);
        if (z) {
            settingsSyncWithSamsungAccountPrefFragment.enabledSyncMenu(true);
        } else {
            settingsSyncWithSamsungAccountPrefFragment.enabledSyncMenu(C0158a.m407a().m417k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSyncNow(boolean syncing, int errorCode) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new RunnableC7661m(this, syncing, errorCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSyncNow$lambda$22(SettingsSyncWithSamsungAccountPrefFragment settingsSyncWithSamsungAccountPrefFragment, boolean z, int i) {
        ProgressPreference progressPreference = (ProgressPreference) settingsSyncWithSamsungAccountPrefFragment.findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_NOW);
        if (progressPreference == null) {
            return;
        }
        if ((progressPreference.getProgressVisibility() == 0) == z) {
            AbstractC6670b.m4739D("updateSyncNow() ignore, same SyncingState: ", TAG, z);
            return;
        }
        if (z) {
            MainLogger.m7258i(TAG, "updateSyncNow() : true");
            progressPreference.setProgressVisibility(0);
            progressPreference.setTitle(C8003R.string.settings_sync_now_stop);
            progressPreference.setSummary(C8003R.string.settings_sync_now_syncing);
            return;
        }
        MainLogger.m7258i(TAG, "updateSyncNow() : false");
        progressPreference.setProgressVisibility(8);
        progressPreference.setTitle(C8003R.string.settings_sync_now);
        if (!C0145c.m298F(settingsSyncWithSamsungAccountPrefFragment.getContext()) && C0145c.m299G(settingsSyncWithSamsungAccountPrefFragment.getContext())) {
            progressPreference.setSummary(C8003R.string.settings_sync_now_wifi_not_available_on_only_wifi_check);
            return;
        }
        if (i != 0) {
            EdpManager.getInstance().setUnsupportedEdpDevice(i == 124);
            EdpManager.getInstance().setKeyErrorEdpDevice(i == 125);
            progressPreference.setSummary(C8003R.string.settings_sync_now_failed);
            return;
        }
        long jM15161u = AbstractC14517a.m15161u();
        if (jM15161u <= 0) {
            progressPreference.setSummary(C8003R.string.settings_sync_now_no_history);
            return;
        }
        String strM396k = AbstractC0155m.m396k(settingsSyncWithSamsungAccountPrefFragment.getContext(), jM15161u);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = settingsSyncWithSamsungAccountPrefFragment.getResources().getString(C8003R.string.settings_sync_now_last_synced);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{strM396k}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        progressPreference.setSummary(str);
        MainLogger.m7258i(TAG, "updateSyncNow(). Last synced : " + jM15161u);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AbstractC8014b.m7200b(requestCode, resultCode, "onActivityResult() : requestCode = ", " , resultCode : ", TAG);
        if (requestCode == 106 && resultCode == -1) {
            C14477a.m15065b().f10283a.getClass();
            if (C14499b.m15085e()) {
                SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
                if (switchPreference != null) {
                    switchPreference.setClickable(false);
                    switchPreference.postDelayed(new RunnableC8787k(switchPreference, 1), 500);
                }
                new SenlThreadFactory(TAG).newThread(new RunnableC0284b(18)).start();
            } else {
                NetworkConnectionFailedHelper.getInstance().show(getContext(), 1);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == C8003R.id.wifi_only_layout) {
            if (C0145c.m299G(getContext()) && !C0145c.m298F(getContext())) {
                C14477a.m15065b().m15076l(105);
            }
            AlertDialog alertDialog = this.mSyncTypeDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            setWifiSyncOnly(true);
        } else if (id == C8003R.id.both_wifi_mobile_layout) {
            AlertDialog alertDialog2 = this.mSyncTypeDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            setWifiSyncOnly(false);
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.EVENT_SETTINGS_SYNC_NOTE_USING, id == C8003R.id.wifi_only_layout ? "a" : "b");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x009a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable android.os.Bundle r9, @org.jetbrains.annotations.Nullable java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment.onCreatePreferences(android.os.Bundle, java.lang.String):void");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        releaseGlobalSyncStatusHandler();
        SyncStateListener syncStateListener = this.mSyncEnableModeListener;
        if (syncStateListener != null) {
            syncStateListener.release();
        }
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }
        this.mSyncEnableModeListener = null;
        this.mQuotaListener = null;
        this.mUiSyncProgressListener = null;
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        int i = 0;
        if (key != null) {
            switch (key.hashCode()) {
                case 632035222:
                    if (key.equals(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE)) {
                        View viewInflate = getLayoutInflater().inflate(C8003R.layout.sync_notes_data_type_dialog, (ViewGroup) null);
                        viewInflate.findViewById(C8003R.id.wifi_only_layout).setOnClickListener(this);
                        viewInflate.findViewById(C8003R.id.both_wifi_mobile_layout).setOnClickListener(this);
                        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), i, 2, null).setView(viewInflate).setNegativeButton(getResources().getString(C8003R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(7)).create();
                        this.mSyncTypeDialog = alertDialogCreate;
                        Intrinsics.checkNotNull(alertDialogCreate);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = getResources().getString(C8003R.string.settings_sync_notes_data);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String str = String.format(string, Arrays.copyOf(new Object[]{getResources().getString(C8003R.string.settings_sync_notes_data_body)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        alertDialogCreate.setTitle(str);
                        AlertDialog alertDialog = this.mSyncTypeDialog;
                        Intrinsics.checkNotNull(alertDialog);
                        alertDialog.setCanceledOnTouchOutside(false);
                        if (C0145c.m299G(getContext())) {
                            View viewFindViewById = viewInflate.findViewById(C8003R.id.wifi_only);
                            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RadioButton");
                            ((RadioButton) viewFindViewById).setChecked(true);
                        } else {
                            View viewFindViewById2 = viewInflate.findViewById(C8003R.id.both_wifi_mobile);
                            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RadioButton");
                            ((RadioButton) viewFindViewById2).setChecked(true);
                        }
                        AlertDialog alertDialog2 = this.mSyncTypeDialog;
                        Intrinsics.checkNotNull(alertDialog2);
                        alertDialog2.show();
                    }
                    break;
                case 1405855482:
                    if (key.equals(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_NOW)) {
                        MainLogger.m7258i(TAG, "User selects sync_now_layout!");
                        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
                        if (switchPreference != null) {
                            switchPreference.setClickable(false);
                            switchPreference.postDelayed(new RunnableC8787k(switchPreference, i), 500);
                        }
                        if (!C14477a.m15065b().f10283a.m5099h()) {
                            MainLogger.m7258i(TAG, "stopSync due to syncing!");
                            C14477a.m15065b().m15076l(102);
                        } else if (C0145c.m299G(getContext()) && !C0145c.m298F(getContext())) {
                            AbstractC8014b.m7201c(C8003R.string.settings_cannot_sync_in_wifi_only, "onClick(). : ", TAG);
                        } else if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.LOCAL) {
                            try {
                                C13541h.m14287e().getClass();
                                Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_CHECKLIST_VALIDATION");
                                intent.setPackage("com.osp.app.signin");
                                intent.putExtra("client_id", CommonUtils.getAppServiceId());
                                intent.putExtra("validation_result_only", false);
                                startActivityForResult(intent, 106);
                            } catch (ActivityNotFoundException e) {
                                AbstractC6670b.m4738C("requestIDValidation fail : ", e.getMessage(), TAG);
                                return false;
                            }
                        }
                    }
                    break;
                case 2072680015:
                    if (key.equals(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE)) {
                        MainLogger.m7255e(TAG, "onPreferenceClick# unused key SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE");
                    }
                    break;
                case 2129899275:
                    if (key.equals(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_LOG_OUT)) {
                        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                            MainLogger.m7258i(TAG, "onClick(). SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_USAGE");
                            C13541h c13541hM14287e = C13541h.m14287e();
                            if (((AccountSamsungType) c13541hM14287e.f9592e) == AccountSamsungType.LOCAL) {
                                ((C13540g) c13541hM14287e.f9588a).m14285a();
                            } else {
                                Debugger.m8609e("SAccountManager", "[SA] onLoggedOut() : Not supported yet!");
                            }
                            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SAMSUNG_CLOUD_SYNC, SettingsSAConstants.EVENT_SAMSUNG_CLOUD_SYNC_SIGN_OUT);
                        }
                    }
                    break;
            }
            return false;
        }
        AbstractC6670b.m4738C("onPreferenceClick# unexpected key: ", key, TAG);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            activity.finish();
        }
        if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.LOCAL) {
            C12936a.m13839c().getClass();
            if (!C12936a.m13842g()) {
                activity.finish();
            }
        }
        if (SettingsCompat.INSTANCE.getInstance().isUPSM(activity)) {
            MainLogger.m7258i(TAG, "UPSM mode. finish()");
            activity.finish();
        }
        MainLogger.m7258i(TAG, "onResume()");
        Preference preferenceFindPreference = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_NOW);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
        }
        Preference preferenceFindPreference2 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_SYNC_TYPE);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(this);
        }
        Preference preferenceFindPreference3 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_CLOUD_USAGE);
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(this);
        }
        Preference preferenceFindPreference4 = findPreference(SETTINGS_SYNC_WITH_SAMSUNG_ACCOUNT_LOG_OUT);
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(this);
        }
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        updateLayout();
        if (C0145c.m338w(activity)) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
            C14477a.m15065b().m15077m(activity);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        updateLayout();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.isQuotaUiNeeded) {
            C6871d.m5056b().m5057a(this.mQuotaListener);
            C6871d.m5056b().m5058c(1);
        }
        C14477a c14477aM15065b = C14477a.m15065b();
        InterfaceC0107a interfaceC0107a = this.mUiSyncProgressListener;
        c14477aM15065b.f10283a.getClass();
        ArrayList arrayList = C14499b.f10312f;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        ArrayList arrayList2 = C14499b.f10312f;
                        arrayList2.add(interfaceC0107a);
                        Debugger.m8607d("SyncLogic", "Added Ui Sync progress listener - size : " + arrayList2.size());
                        break;
                    }
                    if (((InterfaceC0107a) it.next()).equals(interfaceC0107a)) {
                    }
                }
            } finally {
            }
        }
        C14477a.m15065b().m15068a(this.mSyncEnableModeListener);
        enableSyncNow();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.isQuotaUiNeeded) {
            C6871d c6871dM5056b = C6871d.m5056b();
            InterfaceC6872e interfaceC6872e = this.mQuotaListener;
            c6871dM5056b.getClass();
            synchronized (InterfaceC6872e.class) {
                ((ArrayList) c6871dM5056b.f4367b).remove(interfaceC6872e);
            }
            C6871d c6871dM5056b2 = C6871d.m5056b();
            c6871dM5056b2.getClass();
            Debugger.m8615i("QT/QuotaHelper", "cancelGetQuota()");
            QuotaServiceTask quotaServiceTask = (QuotaServiceTask) c6871dM5056b2.f4368c;
            if (quotaServiceTask != null) {
                quotaServiceTask.cancel(true);
                c6871dM5056b2.f4368c = null;
            }
        }
        C14477a c14477aM15065b = C14477a.m15065b();
        InterfaceC0107a interfaceC0107a = this.mUiSyncProgressListener;
        c14477aM15065b.f10283a.getClass();
        ArrayList arrayList = C14499b.f10312f;
        synchronized (arrayList) {
            arrayList.remove(interfaceC0107a);
            Debugger.m8607d("SyncLogic", "Removed Ui Sync progress listener - size : " + arrayList.size());
        }
        C14477a.m15065b().m15070e(this.mSyncEnableModeListener);
    }
}
