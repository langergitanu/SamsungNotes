package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DialogCreator implements DialogContract.IDialogCreator {
    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createAiDrawingDeleteConfirmDialog(Context context, DialogContract.IAIDrawingDeleteConfirmDialogPresenter iAIDrawingDeleteConfirmDialogPresenter) {
        return new AiDrawingDeleteConfirmDialog(context, iAIDrawingDeleteConfirmDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createAutoRestoredNoteNotiDialog(Context context, DialogContract.IPresenter iPresenter) {
        return new AutoRestoredNoteNotiDialog(context, iPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createBeautifierLanguageDialogFragment() {
        return new HwBeautifierLanguageDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createCanNotAddToNoteDialogFragment() {
        return new CanNotAddToNoteDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createCanNotUsePenDialog(Context context, DialogContract.ICanNotUseSpenDialogPresenter iCanNotUseSpenDialogPresenter) {
        return new CanNotUseSpenDialog(context, iCanNotUseSpenDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createConfirmCancelVoiceDialog(Activity activity, DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter) {
        return new CancelVoiceConfirmDialog(activity, iVoiceDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createConfirmRemoveItemDialog(Activity activity, DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter, SpenWPage spenWPage, SpenObjectBase spenObjectBase) {
        return new RemoveItemConfirmDialog(activity, iVoiceDialogPresenter, spenWPage, spenObjectBase);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createConfirmRemoveRecordingDialog(Activity activity, DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter) {
        return new RemoveRecordingConfirmDialog(activity, iVoiceDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createConfirmSyncConflictDialogFragment() {
        return new SyncConflictConfirmDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public void createConfirmWebCardPreviewDialog(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        new WebCardPreviewConfirmDialog(activity, onClickListener, onClickListener2, onDismissListener);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createConvertSettingDialogFragment() {
        return new ConvertSettingDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createDirectWriteSettingDialogFragment() {
        return new DirectWriteSettingDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createHashTagRenameDialogFragment() {
        return new HashTagRenameDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createLinkEditDialogFragment(boolean z) {
        return new LinkEditDialogFragment(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createManualSaveConfirmDialog(Context context, DialogContract.IManualSaveConfirmDialogPresenter iManualSaveConfirmDialogPresenter) {
        return new ManualSaveConfirmDialog(context, iManualSaveConfirmDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createQuickNoteDialog(QuickNoteDialogPresenter quickNoteDialogPresenter) {
        return new QuickNoteDialog(quickNoteDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createRenameDialogFragment() {
        return new VoiceRenameDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createSaveAsRenameDialogFragment() {
        return new SaveAsRenameDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createSaveNoteConfirmDialogFragment() {
        return new SaveNoteConfirmDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createShareSaveNoteConfirmDialogFragment() {
        return new ShareSaveNoteConfirmDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createSummaryOptionDialog(Context context, int i, DialogContract.ISummaryOptionDialogPresenter iSummaryOptionDialogPresenter, boolean z) {
        return new SummaryOptionPopup(context, i, iSummaryOptionDialogPresenter, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createSyncWaitingProgressDialogFragment() {
        return new SyncWaitingProgressDialog();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createTableDialogFragment() {
        return new TableDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createTextBoxMoreDialog(Activity activity, String str, String str2, DialogContract.IPresenter iPresenter) {
        return new TextBoxMoreDialog(activity, str, str2, iPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createTranslatedPDFBlockingDialogFragment() {
        return new TranslatedPDFBlockingDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createTranslatedPDFGuideDialogFragment() {
        return new TranslatedPDFGuideDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createTurnOffTranslationDialogFragment() {
        return new TurnOffTranslationModeDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createUnavailableContentDialogFragment() {
        return new UnavailableContentDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogContract.IDialog createUnlockConfirmDialog(Activity activity, DialogContract.IUnlockConfirmDialogPresenter iUnlockConfirmDialogPresenter) {
        return new UnlockConfirmDialog(activity, iUnlockConfirmDialogPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createVersionUpdateDialogFragment() {
        return new VersionUpdateDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createVoiceDataRenameDialogFragment() {
        return new VoiceDataRenameDialogFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialogCreator
    public DialogFragment createVoiceDeleteConfirmDialog() {
        return new VoiceDataDeleteConfirmDialogFragment();
    }
}
