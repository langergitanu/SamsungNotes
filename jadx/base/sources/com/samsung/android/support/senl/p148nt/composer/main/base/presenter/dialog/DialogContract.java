package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface DialogContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IAIDrawingDeleteConfirmDialogPresenter extends IPresenter {
        void delete();

        void setOffOption();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICanNotUseSpenDialogPresenter extends IPresenter {
        void onClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialog {
        void dismiss();

        boolean isShowing();

        void show();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogCreator {
        IDialog createAiDrawingDeleteConfirmDialog(Context context, IAIDrawingDeleteConfirmDialogPresenter iAIDrawingDeleteConfirmDialogPresenter);

        IDialog createAutoRestoredNoteNotiDialog(Context context, IPresenter iPresenter);

        DialogFragment createBeautifierLanguageDialogFragment();

        DialogFragment createCanNotAddToNoteDialogFragment();

        IDialog createCanNotUsePenDialog(Context context, ICanNotUseSpenDialogPresenter iCanNotUseSpenDialogPresenter);

        IDialog createConfirmCancelVoiceDialog(Activity activity, IVoiceDialogPresenter iVoiceDialogPresenter);

        IDialog createConfirmRemoveItemDialog(Activity activity, IVoiceDialogPresenter iVoiceDialogPresenter, SpenWPage spenWPage, SpenObjectBase spenObjectBase);

        IDialog createConfirmRemoveRecordingDialog(Activity activity, IVoiceDialogPresenter iVoiceDialogPresenter);

        DialogFragment createConfirmSyncConflictDialogFragment();

        void createConfirmWebCardPreviewDialog(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener);

        DialogFragment createConvertSettingDialogFragment();

        DialogFragment createDirectWriteSettingDialogFragment();

        DialogFragment createHashTagRenameDialogFragment();

        DialogFragment createLinkEditDialogFragment(boolean z);

        IDialog createManualSaveConfirmDialog(Context context, IManualSaveConfirmDialogPresenter iManualSaveConfirmDialogPresenter);

        IDialog createQuickNoteDialog(QuickNoteDialogPresenter quickNoteDialogPresenter);

        DialogFragment createRenameDialogFragment();

        DialogFragment createSaveAsRenameDialogFragment();

        DialogFragment createSaveNoteConfirmDialogFragment();

        DialogFragment createShareSaveNoteConfirmDialogFragment();

        IDialog createSummaryOptionDialog(Context context, int i, ISummaryOptionDialogPresenter iSummaryOptionDialogPresenter, boolean z);

        DialogFragment createSyncWaitingProgressDialogFragment();

        DialogFragment createTableDialogFragment();

        IDialog createTextBoxMoreDialog(Activity activity, String str, String str2, IPresenter iPresenter);

        DialogFragment createTranslatedPDFBlockingDialogFragment();

        DialogFragment createTranslatedPDFGuideDialogFragment();

        DialogFragment createTurnOffTranslationDialogFragment();

        DialogFragment createUnavailableContentDialogFragment();

        IDialog createUnlockConfirmDialog(Activity activity, IUnlockConfirmDialogPresenter iUnlockConfirmDialogPresenter);

        DialogFragment createVersionUpdateDialogFragment();

        DialogFragment createVoiceDataRenameDialogFragment();

        DialogFragment createVoiceDeleteConfirmDialog();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDownloadState {
        void onFail(int i);

        void onSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IFragmentPresenter {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IFragmentPresenterContainer {
        public static final int TYPE_APP_VERSION_UPDATE = 18;
        public static final int TYPE_DIRECT_WRITE_SETTING = 12;
        public static final int TYPE_HASHTAG_RENAME = 3;
        public static final int TYPE_HW_BEAUTIFIER_LANGUAGE_SETTING = 15;
        public static final int TYPE_LINK_EDIT = 20;
        public static final int TYPE_SAVE_AS_RENAME = 7;
        public static final int TYPE_SAVE_NOTE_CONFIRM = 8;
        public static final int TYPE_SHARE_SAVE_NOTE_CONFIRM = 14;
        public static final int TYPE_SYNC_CONFLICT = 11;
        public static final int TYPE_SYNC_WAITING = 10;
        public static final int TYPE_TABLE_CREATE_SETTING = 19;
        public static final int TYPE_TEXT_RECOGNITION = 2;
        public static final int TYPE_TURN_OFF_TRANSLATION = 16;
        public static final int TYPE_UNAVAILABLE_CONTENT = 17;
        public static final int TYPE_VOICE_DATA_RENAME = 9;
        public static final int TYPE_VOICE_DELTE_CONFIRM = 13;
        public static final int TYPE_VOICE_RENAME = 1;

        @Nullable
        IFragmentPresenter getDialogFragmentPresenter(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IManualSaveConfirmDialogPresenter extends IPresenter {
        @StringRes
        int getMessageId();

        void onPositiveButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IParent {
        boolean finish(String str);

        void startInAppCollaboration(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void onDismiss();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IQuickNoteDialog extends IDialog {
        void dismiss(boolean z);

        void update();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISummaryOptionDialogPresenter extends IPresenter {
        View getAnchorView();

        int[] getLocation();

        void setOption(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISyncWaitingProgressDialogPresenter extends IPresenter {
        boolean canStopToSendRequestSyncMsg();

        void cancel();

        String getUuid();

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
        void onDismiss();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IUnlockConfirmDialogPresenter extends IPresenter {
        void unlock(Activity activity);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IVoiceDialogPresenter extends IPresenter {
        void cancelRecording();

        void removeItem(SpenWPage spenWPage, SpenObjectBase spenObjectBase);

        void stopRecording();
    }
}
