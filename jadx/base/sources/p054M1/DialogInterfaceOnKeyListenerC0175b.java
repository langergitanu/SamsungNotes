package p054M1;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.samsung.android.app.notes.widget.common.ConvertConfirmDialogActivity;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiDisclaimerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialogFragment;

/* JADX INFO: renamed from: M1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class DialogInterfaceOnKeyListenerC0175b implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f557a;

    public /* synthetic */ DialogInterfaceOnKeyListenerC0175b(int i) {
        this.f557a = i;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        switch (this.f557a) {
            case 0:
                return ConvertConfirmDialogActivity.ConvertConfirmsDialogFragment.onCreateDialog$lambda$2(dialogInterface, i, keyEvent);
            case 1:
                return AiDisclaimerDialog.getDialog$lambda$1(dialogInterface, i, keyEvent);
            case 2:
                return PermissionHelper.showGotoSettingsDialog$lambda$10(dialogInterface, i, keyEvent);
            default:
                return AbsSTTDialogFragment.mOnKeyListener$lambda$1(dialogInterface, i, keyEvent);
        }
    }
}
