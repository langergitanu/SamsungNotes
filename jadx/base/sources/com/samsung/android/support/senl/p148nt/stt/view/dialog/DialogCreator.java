package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.DialogContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogCreator;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDialogCreator;", "<init>", "()V", "createDiscardConfirmDialog", "Landroid/app/Dialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDiscardConfirmDialogPresenter;", "createRemoveTranscriptConfirmDialog", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/RemoveTranscriptConfirmDialog;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DialogCreator implements DialogContract.IDialogCreator {

    @NotNull
    private static final String TAG = "DialogCreator";

    @Override // com.samsung.android.support.senl.nt.stt.view.dialog.DialogContract.IDialogCreator
    @NotNull
    public Dialog createDiscardConfirmDialog(@Nullable Activity activity, @NotNull DialogContract.IDiscardConfirmDialogPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Logger.m12713i(TAG, "createDiscardConfirmDialog");
        return new DiscardConfirmDialog(activity, presenter);
    }

    @Override // com.samsung.android.support.senl.nt.stt.view.dialog.DialogContract.IDialogCreator
    @NotNull
    public RemoveTranscriptConfirmDialog createRemoveTranscriptConfirmDialog(@Nullable DialogContract.IRemoveConfirmDialogPresenter presenter) {
        Logger.m12713i(TAG, "createRemoveTranscriptConfirmDialog");
        return new RemoveTranscriptConfirmDialog(presenter);
    }
}
