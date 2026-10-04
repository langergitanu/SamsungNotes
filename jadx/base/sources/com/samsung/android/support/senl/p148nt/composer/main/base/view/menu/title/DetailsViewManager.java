package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.DetailsDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IDetailsDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.document.SDocXBodyTextGetter;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DetailsViewManager {
    private static final String TAG = Logger.createTag("DetailsViewManager");
    private final Contract mContract;
    private final IDetailsDialog.OnDetailsDialogListener mDetailsDialogListener = new IDetailsDialog.OnDetailsDialogListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.DetailsViewManager.1
        @Override // com.samsung.android.support.senl.nt.base.winset.app.dialog.IDetailsDialog.OnDetailsDialogListener
        @Nullable
        public Pair<Integer, Integer> getBodyTextCount(@NonNull String str) {
            String text = new SDocXBodyTextGetter(DetailsViewManager.this.mContract.getActivity().getBaseContext()).getText(str);
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
            NotesFolder folder;
            if (str == null || (folder = FolderManager.getInstance().getAllDocumentCategoryTree(false).getFolder(str)) == null) {
                return null;
            }
            return new IDetailsDialog.FolderInfo(folder.getUuid(), folder.getDisplayName(), folder.getParentUuid());
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.dialog.IDetailsDialog.OnDetailsDialogListener
        @Nullable
        public void onFolderSelected(@NonNull String str) {
        }
    };
    private DetailsDialogFragment mDialog;
    private final KeyguardPresenter mKeyguardPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();
    }

    public DetailsViewManager(@NonNull KeyguardPresenter keyguardPresenter, Contract contract) {
        this.mContract = contract;
        this.mKeyguardPresenter = keyguardPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1() {
        this.mKeyguardPresenter.dismissKeyguard(this.mContract.getActivity(), new RunnableC10496a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view) {
        if (this.mContract.getActivity().getSupportFragmentManager().findFragmentByTag("DetailsDialog") != null) {
            return;
        }
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(500L, tag);
            this.mContract.getPresenter().getSoftInputManager().hideAndExecute(new RunnableC10496a(this, 1));
            ComposerSA.insertLog(this.mContract.getPresenter().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_EDIT_TITLE_DETAILS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showDialog, reason: merged with bridge method [inline-methods] */
    public void lambda$init$0() {
        this.mDialog = new DetailsDialogFragment();
        String folderUuid = this.mContract.getPresenter().getFolderUuid();
        if ("uncategorized:///".equals(folderUuid) || "coedit:///".equals(folderUuid)) {
            folderUuid = "";
        }
        this.mDialog.setDetailsDialogData(this.mContract.getPresenter().getDocUuid(), this.mContract.getPresenter().getDocPath(), folderUuid, this.mContract.getPresenter().getTitle(), this.mContract.getPresenter().getCoverSummary(), this.mContract.getPresenter().getLastModified());
        this.mDialog.setIsFolderSelectedEnable(false);
        this.mDialog.setDetailsDialogListener(this.mDetailsDialogListener);
        if (this.mDialog.isAdded()) {
            return;
        }
        this.mDialog.show(this.mContract.getActivity().getSupportFragmentManager(), "DetailsDialog");
        ComposerSA.insertLog("401", "2044", "Composer");
    }

    public void dismiss() {
        DetailsDialogFragment detailsDialogFragment = this.mDialog;
        if (detailsDialogFragment == null || !detailsDialogFragment.isAdded()) {
            return;
        }
        this.mDialog.dismiss();
    }

    public void init(View view) {
        DetailsDialogFragment detailsDialogFragment = (DetailsDialogFragment) this.mContract.getActivity().getSupportFragmentManager().findFragmentByTag("DetailsDialog");
        if (detailsDialogFragment != null && detailsDialogFragment.isAdded()) {
            detailsDialogFragment.dismissAllowingStateLoss();
        }
        view.setOnClickListener(new ViewOnClickListenerC8556a(this, 17));
    }
}
