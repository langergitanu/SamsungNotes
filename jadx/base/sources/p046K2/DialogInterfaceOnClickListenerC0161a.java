package p046K2;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.addons.stub.dialog.InstallFailDialog;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.multi.MultiBiometricPrompt;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsImportPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiPersonalDataRestrictedDialog;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.progress.ComposerProgressBar;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceNotificationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.RemoveTranscriptConfirmDialog;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: K2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0161a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f494a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f495b;

    public /* synthetic */ DialogInterfaceOnClickListenerC0161a(Object obj, int i) {
        this.f494a = i;
        this.f495b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f494a) {
            case 0:
                InstallFailDialog.onCreateDialog$lambda$0((InstallFailDialog) this.f495b, dialogInterface, i);
                break;
            case 1:
                ((IrisApi.OnAuthenticationListener) this.f495b).onUsePasswordClicked();
                break;
            case 2:
                MultiBiometricPrompt.authenticate$lambda$0((MultiBiometricPrompt) this.f495b, dialogInterface, i);
                break;
            case 3:
                ((Runnable) this.f495b).run();
                break;
            case 4:
                ((AbsBaseBiometricView) this.f495b).lambda$showTimerDialog$0(dialogInterface, i);
                break;
            case 5:
                ((AbsBaseOldBiometricView) this.f495b).lambda$showTimerDialog$0(dialogInterface, i);
                break;
            case 6:
                SettingsImportPrefFragment.showDialogWhenMobileNetwork$lambda$2((SettingsImportPrefFragment) this.f495b, dialogInterface, i);
                break;
            case 7:
                SettingsSyncToMicrosoftPrefFragment.showLogoutConfirmDialog$lambda$8((SettingsSyncToMicrosoftPrefFragment) this.f495b, dialogInterface, i);
                break;
            case 8:
                AiPersonalDataRestrictedDialog.Companion.makeDialog$lambda$0((DialogInterface.OnClickListener) this.f495b, dialogInterface, i);
                break;
            case 9:
                HandoffUtils.showWiFiSyncOnlyAndNotWiFiConnected$lambda$4((WeakReference) this.f495b, dialogInterface, i);
                break;
            case 10:
                PermissionHelper.showGotoSettingsDialog$lambda$8((Activity) this.f495b, dialogInterface, i);
                break;
            case 11:
                ((ComposerProgressBar) this.f495b).lambda$initProgressBarDialog$0(dialogInterface, i);
                break;
            case 12:
                VoiceNotificationHelper.showCancelDialog$lambda$0((VoiceNotificationHelper) this.f495b, dialogInterface, i);
                break;
            case 13:
                CommonTemplateStyleLayout.requestShowDeleteDialog$lambda$8((CommonTemplateStyleLayout) this.f495b, dialogInterface, i);
                break;
            case 14:
                RemoveTranscriptConfirmDialog.onCreateDialog$lambda$0((RemoveTranscriptConfirmDialog) this.f495b, dialogInterface, i);
                break;
            default:
                BaseWidgetSettingPresenter.showCancelDialog$lambda$2((AlertDialog) this.f495b, dialogInterface, i);
                break;
        }
    }
}
