package com.samsung.android.support.senl.p148nt.stt.presenter;

import com.samsung.android.support.senl.p148nt.stt.view.dialog.DialogContract;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/support/senl/nt/stt/presenter/STTPresenter$mRemoveTranscribeConfirmPresenter$1", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "remove", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTPresenter$mRemoveTranscribeConfirmPresenter$1 implements DialogContract.IRemoveConfirmDialogPresenter {
    final /* synthetic */ STTPresenter this$0;

    public STTPresenter$mRemoveTranscribeConfirmPresenter$1(STTPresenter sTTPresenter) {
        this.this$0 = sTTPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit remove$lambda$0(STTPresenter sTTPresenter) {
        sTTPresenter.showHelpView();
        return Unit.INSTANCE;
    }

    @Override // com.samsung.android.support.senl.nt.stt.view.dialog.DialogContract.IRemoveConfirmDialogPresenter
    public void remove() {
        STTPresenter sTTPresenter = this.this$0;
        sTTPresenter.removeDataFromFile(false, new C11522a(sTTPresenter, 1));
    }
}
