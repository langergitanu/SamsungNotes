package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.DetailsDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IDetailsDialog;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.document.SDocXBodyTextGetter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DetailsMenuHelper {
    private static final String TAG = "DetailsMenuHelper";
    private final IDetailsDialog.OnDetailsDialogListener mDetailsDialogListener = new IDetailsDialog.OnDetailsDialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DetailsMenuHelper.1
        @Override // com.samsung.android.support.senl.nt.base.winset.app.dialog.IDetailsDialog.OnDetailsDialogListener
        @Nullable
        public Pair<Integer, Integer> getBodyTextCount(@NonNull String str) {
            String text = new SDocXBodyTextGetter(DetailsMenuHelper.this.mViewParams.getContext()).getText(str);
            if (text.isEmpty()) {
                return null;
            }
            String strReplaceAll = text.replaceAll("[\\s\\n]+", "");
            if (strReplaceAll.isEmpty()) {
                return null;
            }
            return new Pair<>(Integer.valueOf(strReplaceAll.length()), Integer.valueOf(text.length()));
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.dialog.IDetailsDialog.OnDetailsDialogListener
        @Nullable
        public IDetailsDialog.FolderInfo getFolderInfo(@Nullable String str) {
            if (str == null) {
                return null;
            }
            NotesFolder folderData = DataManager.getInstance().getFolderData(str);
            return new IDetailsDialog.FolderInfo(folderData.getUuid(), folderData.getDisplayName(), folderData.getParentUuid());
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.dialog.IDetailsDialog.OnDetailsDialogListener
        public void onFolderSelected(@Nullable String str) {
            if (DetailsMenuHelper.this.mStateInfo.getFolderUuid().equals(str)) {
                return;
            }
            DetailsMenuHelper.this.mViewParams.getNotesView().onFolderSelected(str);
            DetailsMenuHelper.this.dismissDetailsDialog();
        }
    };
    private final DocumentMap mDocumentMap;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;

    public DetailsMenuHelper(ViewParams viewParams, DocumentMap documentMap, StateInfo stateInfo) {
        this.mViewParams = viewParams;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDetailsDialog() {
        new Handler(Looper.getMainLooper()).post(new RunnableC8496b(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissDetailsDialog$0() {
        if (!this.mViewParams.getAbsFragment().isAdded()) {
            MainLogger.m7255e(TAG, "dismissDetailsDialog# parent fragment is not added");
            return;
        }
        try {
            MainLogger.m7254d(TAG, "dismissDetailsDialog");
            DialogFragment dialogFragment = (DialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag("DetailsDialog");
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "dismissDetailsDialog# IllegalStateException : " + e.getMessage());
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        DetailsDialogFragment detailsDialogFragment = (DetailsDialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag("DetailsDialog");
        if (detailsDialogFragment != null) {
            detailsDialogFragment.setDetailsDialogListener(this.mDetailsDialogListener);
        }
    }

    public void onViewChangeRestoreInstanceState(Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE)) == null || !string.equals("DetailsDialog")) {
            return;
        }
        showDetailsDialog(bundle.getString(DetailsDialogFragment.KEY_DOC_UUID));
    }

    public void onViewChangeSaveInstanceState(Bundle bundle) {
        FragmentManager childFragmentManager = this.mViewParams.getAbsFragment().getChildFragmentManager();
        boolean zIsOldMode = FeatureUtils.isOldMode(this.mViewParams.getModeIndex());
        DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag("DetailsDialog");
        if (dialogFragment != null) {
            if (zIsOldMode) {
                dialogFragment.dismiss();
            }
            bundle.putString(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "DetailsDialog");
            dialogFragment.onSaveInstanceState(bundle);
            dialogFragment.dismiss();
        }
    }

    public void showDetailsDialog(String str) {
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
        if (noteData == null) {
            MainLogger.m7255e(TAG, "showDetailsDialog# entry is null");
            return;
        }
        DetailsDialogFragment detailsDialogFragment = new DetailsDialogFragment();
        String categoryUuid = noteData.getCategoryUuid();
        if ("uncategorized:///".equals(categoryUuid) || "coedit:///".equals(categoryUuid)) {
            categoryUuid = "";
        }
        detailsDialogFragment.setDetailsDialogData(noteData.getUuid(), noteData.getFilePath(), categoryUuid, noteData.getTitle(), noteData.getCoverSummary(), noteData.getLastModifiedAt());
        detailsDialogFragment.setIsFolderSelectedEnable(true);
        detailsDialogFragment.setDetailsDialogListener(this.mDetailsDialogListener);
        if (!detailsDialogFragment.isAdded()) {
            detailsDialogFragment.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), "DetailsDialog");
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT, "2044", "List");
        }
        this.mViewParams.getNotesView().getMode().releaseEditMode();
    }
}
