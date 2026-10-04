package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p067P3.DialogInterfaceOnKeyListenerC0203a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISaveNoteDialogPresenter;", "creator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IDialogCreator;", "saveNoteDialogNavigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter$ISaveNoteDialogNavigator;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IDialogCreator;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter$ISaveNoteDialogNavigator;)V", "mActivity", "Landroid/app/Activity;", "mSaveNoteDialogNavigator", "mDialog", "Landroid/app/Dialog;", "mCreator", "onAttachView", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onDetachView", "isShowing", "", "()Z", "showSaveNoteDialog", "cancel", ClientCookie.DISCARD_ATTR, "save", "ISaveNoteDialogNavigator", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SaveNoteDialogPresenter implements DialogContract.ISaveNoteDialogPresenter {

    @NotNull
    private static final String TAG = SOLogger.createTag("SaveNoteDialogPresenter");

    @Nullable
    private Activity mActivity;

    @Nullable
    private final DialogContract.IDialogCreator mCreator;

    @Nullable
    private Dialog mDialog;

    @NotNull
    private final ISaveNoteDialogNavigator mSaveNoteDialogNavigator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter$ISaveNoteDialogNavigator;", "", "onSaveNoteDialogDiscard", "", "onSaveNoteDialogSave", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISaveNoteDialogNavigator {
        void onSaveNoteDialogDiscard();

        void onSaveNoteDialogSave();
    }

    public SaveNoteDialogPresenter(@Nullable DialogContract.IDialogCreator iDialogCreator, @NotNull ISaveNoteDialogNavigator saveNoteDialogNavigator) {
        Intrinsics.checkNotNullParameter(saveNoteDialogNavigator, "saveNoteDialogNavigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "SaveNoteDialogPresenter#");
        this.mCreator = iDialogCreator;
        this.mSaveNoteDialogNavigator = saveNoteDialogNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showSaveNoteDialog$lambda$0(SaveNoteDialogPresenter saveNoteDialogPresenter, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onKey# " + keyEvent.getKeyCode());
        if (keyEvent.getKeyCode() != 4 && keyEvent.getKeyCode() != 3) {
            return false;
        }
        Dialog dialog = saveNoteDialogPresenter.mDialog;
        if (dialog == null) {
            return true;
        }
        dialog.dismiss();
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.DialogContract.ISaveNoteDialogPresenter
    public void cancel() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "cancel#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.DialogContract.ISaveNoteDialogPresenter
    public void discard() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "discard#");
        this.mSaveNoteDialogNavigator.onSaveNoteDialogDiscard();
    }

    public final boolean isShowing() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public final void onAttachView(@Nullable Activity activity) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
        this.mActivity = activity;
    }

    public final void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView#");
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.DialogContract.ISaveNoteDialogPresenter
    public void save() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "save#");
        this.mSaveNoteDialogNavigator.onSaveNoteDialogSave();
    }

    public final void showSaveNoteDialog() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "showSaveNoteDialog#");
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        DialogContract.IDialogCreator iDialogCreator = this.mCreator;
        Dialog dialogCreateSaveNoteDialogPresenter = iDialogCreator != null ? iDialogCreator.createSaveNoteDialogPresenter(activity, this) : null;
        this.mDialog = dialogCreateSaveNoteDialogPresenter;
        if (dialogCreateSaveNoteDialogPresenter != null) {
            dialogCreateSaveNoteDialogPresenter.setOnKeyListener(new DialogInterfaceOnKeyListenerC0203a(this, 1));
        }
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        }
    }
}
