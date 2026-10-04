package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/dialog/DialogCreator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IDialogCreator;", "<init>", "()V", "createSaveNoteDialogPresenter", "Landroid/app/Dialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISaveNoteDialogPresenter;", "createSelectNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISelectNoteDialogPresenter;", "createPinNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IPinNoteDialogPresenter;", "pinnedNoteUri", "Landroid/net/Uri;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DialogCreator implements DialogContract.IDialogCreator {

    @NotNull
    private static final String TAG = SOLogger.createTag("DialogCreator");

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.DialogContract.IDialogCreator
    @NotNull
    public Dialog createPinNoteDialogPresenter(@NotNull Activity activity, @NotNull DialogContract.IPinNoteDialogPresenter presenter, @NotNull Uri pinnedNoteUri) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(pinnedNoteUri, "pinnedNoteUri");
        SOLogger.INSTANCE.SOLoggerD(TAG, "createPinNoteDialogPresenter");
        return new PinNoteDialog(activity, presenter, pinnedNoteUri);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.DialogContract.IDialogCreator
    @NotNull
    public Dialog createSaveNoteDialogPresenter(@NotNull Activity activity, @NotNull DialogContract.ISaveNoteDialogPresenter presenter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "createSaveNoteDialogPresenter");
        return new SaveNoteDialog(activity, presenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.DialogContract.IDialogCreator
    @NotNull
    public Dialog createSelectNoteDialogPresenter(@NotNull Activity activity, @NotNull DialogContract.ISelectNoteDialogPresenter presenter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "createSelectNoteDialogPresenter");
        return new SelectNoteDialog(activity, presenter);
    }
}
