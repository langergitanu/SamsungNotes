package p054M1;

import android.content.DialogInterface;
import com.samsung.android.app.notes.widget.common.ConvertConfirmDialogActivity;
import com.samsung.android.sdk.pen.setting.SpenColorControl;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppColorPickerLayout;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ConfirmDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.ImagePicker;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.PasteRawContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceNotificationDialogActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceNotificationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorDialog;

/* JADX INFO: renamed from: M1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class DialogInterfaceOnDismissListenerC0177d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f560a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f561b;

    public /* synthetic */ DialogInterfaceOnDismissListenerC0177d(Object obj, int i) {
        this.f560a = i;
        this.f561b = obj;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f560a) {
            case 0:
                ConvertConfirmDialogActivity.ConvertConfirmsDialogFragment.onCreateDialog$lambda$4((ConvertConfirmDialogActivity.ConvertConfirmsDialogFragment) this.f561b, dialogInterface);
                break;
            case 1:
                SpenColorControl.mPopupDismissListener$lambda$9((SpenColorControl) this.f561b, dialogInterface);
                break;
            case 2:
                ((InAppColorPickerLayout) this.f561b).close();
                break;
            case 3:
                ((AbsBaseBiometricView) this.f561b).lambda$showTimerDialog$2(dialogInterface);
                break;
            case 4:
                ((AbsBaseOldBiometricView) this.f561b).lambda$showTimerDialog$2(dialogInterface);
                break;
            case 5:
                ConfirmDialog.buildDialog$lambda$1((ConfirmDialog) this.f561b, dialogInterface);
                break;
            case 6:
                ImagePicker.showDialog$lambda$4((ImagePicker) this.f561b, dialogInterface);
                break;
            case 7:
                ((PasteRawContent) this.f561b).lambda$handleWebCard$2(dialogInterface);
                break;
            case 8:
                ((VoiceNotificationDialogActivity) this.f561b).finish();
                break;
            case 9:
                ((VoiceNotificationHelper) this.f561b).mCancelDialog = null;
                break;
            default:
                ((TitleEditorDialog) this.f561b).lambda$createDialog$0(dialogInterface);
                break;
        }
    }
}
