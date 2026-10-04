package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.mobileservice.social.share.BundleKey;
import com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.ViewOnLayoutChangeListenerC7473a;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.cover.CoverCreator;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoverEditorDialogFragment extends DialogFragment implements DialogInterface.OnCancelListener {
    private static final String TAG = Logger.createCoverTag("CoverEditorDialogFragment");
    private final String FILE_PATH = BundleKey.FILE_PATH;
    private final String NOTE_UUID = WidgetConstant.EXTRA_KEY_UUID;
    private CoverCreator mCoverCreator;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private CoverData mOriginCoverData;
    private IResult mResultListener;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoverEditorDialogFragment$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C85901 implements BaseDocumentHelper.Listener {
        final /* synthetic */ String val$title;

        public C85901(String str) {
            this.val$title = str;
        }

        @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
        public void onFailed(@NonNull String str) {
        }

        @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
        public void onOpen(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
            notesDocument.setDirty(true);
            notesDocument.getDoc().insertTitle(this.val$title);
            notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setTitle(this.val$title);
        }

        @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
        public void onSave(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
            CoverEditorDialogFragment.this.updatePreview();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IResult {
        void onCancel(CoverData coverData);

        void onDone(CoverData coverData);
    }

    public CoverEditorDialogFragment() {
    }

    private void enableEditor(View view, boolean z) {
        view.findViewById(C9086R.id.cover_view_container).setAlpha(z ? 1.0f : 0.4f);
        view.findViewById(C9086R.id.cover_disable_view).setOnTouchListener(z ? null : new ViewOnTouchListenerC7005f(10));
    }

    private void executeSaveData() {
        if (this.mCoverCreator.isCoverEnabled()) {
            this.mCoverCreator.saveCoverData("executeSaveData");
            if (!this.mOriginCoverData.equals(this.mCoverCreator.getCoverData())) {
                saveDocAndDB(this.mCoverCreator.getTitleViewText());
            }
            if (!CoverThumbnailCreator.isExistCoverFile(getContext(), this.mCoverCreator.getCoverData().getNoteUuid(), CoverThumbnailCreator.ThumbnailType.RECT)) {
                this.mCoverCreator.savePreviewJpgWithView();
            }
        } else {
            hidePreview();
        }
        loggingSAEvent();
    }

    private void hidePreview() {
        this.mCoverCreator.updateCoverEntity();
        IResult iResult = this.mResultListener;
        if (iResult != null) {
            iResult.onCancel(this.mCoverCreator.getCoverData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$enableEditor$2(View view, MotionEvent motionEvent) {
        Logger.m10999d(TAG, "enableEditor# touch blocked");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(AlertDialog alertDialog, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (alertDialog.isShowing() && i8 - i6 != i4 - i) {
            this.mCoverCreator.updateTypeViewPager();
        }
    }

    private /* synthetic */ void lambda$setSwitchState$1(View view, CompoundButton compoundButton, boolean z) {
        CoverCreator coverCreator = this.mCoverCreator;
        coverCreator.updateCoverEnable(coverCreator.getCoverData().getNoteUuid(), z);
        enableEditor(view, z);
    }

    private void loggingSAEvent() {
        ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, AssistSAConstants.EVENT_COMPOSER_COVER_IMAGE, CoverEditorUtils.getSATemplateDetail(this.mCoverCreator.getCoverData().getTemplateUuid()));
        ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, AssistSAConstants.EVENT_COMPOSER_COVER_COLOR, CoverEditorUtils.getSAColorDetail(this.mCoverCreator.getCoverData().getColorId()));
        ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, AssistSAConstants.EVENT_COMPOSER_COVER_STICKER, CoverEditorUtils.getSACategoryDetail(this.mCoverCreator.getCoverData().getCategoryUuid()));
    }

    private void saveDocAndDB(String str) {
        if (getContext() == null) {
            return;
        }
        Logger.m10999d(TAG, "saveDocAndDB");
        updatePreview();
    }

    private void setSwitchState(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreview() {
        this.mCoverCreator.savePreviewJpgWithView();
        this.mCoverCreator.updateCoverEntity();
        IResult iResult = this.mResultListener;
        if (iResult != null) {
            iResult.onDone(this.mCoverCreator.getCoverData());
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View viewInflate = getLayoutInflater().inflate(C9086R.layout.cover_editor_new_popup_layout, (ViewGroup) null);
        if (getActivity() == null || getArguments() == null) {
            Logger.m10999d(TAG, "onCreateDialog# activity : " + getActivity() + ", argument : " + getArguments());
            return new Dialog(BaseUtils.getApplicationContext());
        }
        if (bundle != null) {
            this.mCoverCreator = new CoverCreator(getActivity(), viewInflate, (CoverData) bundle.getParcelable(CoverData.KEY_COVER_DATA));
        } else {
            CoverCreator coverCreator = new CoverCreator(getActivity(), viewInflate, getArguments().getString(WidgetConstant.EXTRA_KEY_UUID));
            this.mCoverCreator = coverCreator;
            coverCreator.getCoverData().setDocPath(getArguments().getString(BundleKey.FILE_PATH));
        }
        try {
            this.mOriginCoverData = this.mCoverCreator.getCoverData().m22192clone();
        } catch (CloneNotSupportedException e) {
            Logger.m11000e(TAG, "onCreateDialog#" + e.getMessage());
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext()).setView(viewInflate).create();
        Window window = alertDialogCreate.getWindow();
        window.setSoftInputMode(16);
        this.mOnLayoutChangeListener = new ViewOnLayoutChangeListenerC7473a(this, alertDialogCreate, 1);
        window.getDecorView().addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        alertDialogCreate.setCanceledOnTouchOutside(true);
        setSwitchState(viewInflate);
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Logger.m10999d(TAG, "onDestroyView");
        executeSaveData();
        if (getDialog() != null) {
            getDialog().getWindow().getDecorView().removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mCoverCreator.saveCoverData(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE);
        bundle.putParcelable(CoverData.KEY_COVER_DATA, this.mCoverCreator.getCoverData());
    }

    public void setResultListener(IResult iResult) {
        this.mResultListener = iResult;
    }

    public CoverEditorDialogFragment(String str, @Nullable String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(WidgetConstant.EXTRA_KEY_UUID, str);
        bundle.putString(BundleKey.FILE_PATH, str2);
        setArguments(bundle);
    }
}
