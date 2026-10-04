package p067P3;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.PinNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.SaveNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.SelectNoteDialogPresenter;

/* JADX INFO: renamed from: P3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DialogInterfaceOnKeyListenerC0203a implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f630a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f631b;

    public /* synthetic */ DialogInterfaceOnKeyListenerC0203a(Object obj, int i) {
        this.f630a = i;
        this.f631b = obj;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        switch (this.f630a) {
            case 0:
                return PinNoteDialogPresenter.showPinNoteDialog$lambda$0((PinNoteDialogPresenter) this.f631b, dialogInterface, i, keyEvent);
            case 1:
                return SaveNoteDialogPresenter.showSaveNoteDialog$lambda$0((SaveNoteDialogPresenter) this.f631b, dialogInterface, i, keyEvent);
            default:
                return SelectNoteDialogPresenter.showSelectNoteDialog$lambda$0((SelectNoteDialogPresenter) this.f631b, dialogInterface, i, keyEvent);
        }
    }
}
