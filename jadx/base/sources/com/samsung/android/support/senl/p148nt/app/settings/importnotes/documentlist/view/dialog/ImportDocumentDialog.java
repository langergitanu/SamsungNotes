package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.dialog;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.ErrorDialog;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.FileDownloadDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.ImportDialogResultListener;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.NoteDataWarningDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/dialog/ImportDocumentDialog;", "", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "appName", "", "view", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/dialog/ImportDocumentDialogContract$IView;", "<init>", "(Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;Ljava/lang/String;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/dialog/ImportDocumentDialogContract$IView;)V", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getAppName", "()Ljava/lang/String;", "mView", "mMemoDataWarningResultListener", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/ImportDialogResultListener$NoteDataWarning;", "mDownloadingResultListener", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/ImportDialogResultListener$Downloading;", "dismissCancelDownloadingDialog", "", "showCancelDownloadingDialog", "isCancelDownloadingDialogAdded", "", "showProgressDialog", "dismissProgressDialog", "showNoteDataWarningDialog", "type", "", "size", "", "showErrorDialog", "context", "Landroid/content/Context;", "restoreDialog", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportDocumentDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportDocumentDialog.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/dialog/ImportDocumentDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,190:1\n1#2:191\n*E\n"})
public final class ImportDocumentDialog {

    @NotNull
    private static final String IMPORT_PROGRESS_DIALOG_FRAGMENT_TAG = "IMPORT_PROGRESS_DIALOG";

    @NotNull
    private static final String TAG = "ST$ImportDocumentDialog";

    @Nullable
    private final String appName;

    @Nullable
    private final DocTypeConstants importType;

    @NotNull
    private final ImportDialogResultListener.Downloading mDownloadingResultListener;

    @NotNull
    private final ImportDialogResultListener.NoteDataWarning mMemoDataWarningResultListener;

    @NotNull
    private final ImportDocumentDialogContract.IView mView;

    public ImportDocumentDialog(@Nullable DocTypeConstants docTypeConstants, @Nullable String str, @NotNull ImportDocumentDialogContract.IView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.importType = docTypeConstants;
        this.appName = str;
        this.mView = view;
        this.mMemoDataWarningResultListener = new ImportDialogResultListener.NoteDataWarning() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialog$mMemoDataWarningResultListener$1
            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.dialog.ImportDialogResultListener.NoteDataWarning
            public void onCancel() {
                this.this$0.mView.activityFinish();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.dialog.ImportDialogResultListener.NoteDataWarning
            public void onConfirm() {
                this.this$0.showCancelDownloadingDialog();
                this.this$0.mView.registerImportListRequest();
            }
        };
        this.mDownloadingResultListener = new ImportDialogResultListener.Downloading() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialog$mDownloadingResultListener$1
            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.dialog.ImportDialogResultListener.Downloading
            public void onCancel() {
                this.this$0.mView.unregisterImportListRequest();
                this.this$0.mView.activityFinish();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.dialog.ImportDialogResultListener.Downloading
            public void onDismiss() {
                this.this$0.mView.setCancelDownloadingEnded(true);
            }
        };
    }

    public final void dismissCancelDownloadingDialog() {
        FragmentManager childFragmentManager;
        boolean zIsFragmentAdded = this.mView.isFragmentAdded();
        AbstractC6670b.m4739D("dismissCancelDownloadingDialog, isRootFragmentAdded: ", TAG, zIsFragmentAdded);
        if (zIsFragmentAdded && (childFragmentManager = this.mView.getChildFragmentManager()) != null) {
            FileDownloadDialogFragment fileDownloadDialogFragment = (FileDownloadDialogFragment) childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG);
            if (fileDownloadDialogFragment != null) {
                MainLogger.m7258i(TAG, "dismissCancelDownloadingDialog, it.isAdded: " + fileDownloadDialogFragment + ".isAdded");
                if (fileDownloadDialogFragment.isAdded()) {
                    fileDownloadDialogFragment.dismissAllowingStateLoss();
                }
                this.mView.setCancelDownloadingEnded(true);
            }
            DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(IMPORT_PROGRESS_DIALOG_FRAGMENT_TAG);
            if (dialogFragment == null || !dialogFragment.isAdded()) {
                return;
            }
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    public final void dismissProgressDialog() {
        DialogFragment dialogFragment;
        MainLogger.m7258i(TAG, "dismissProgressDialog()");
        FragmentManager childFragmentManager = this.mView.getChildFragmentManager();
        if (childFragmentManager == null || (dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(IMPORT_PROGRESS_DIALOG_FRAGMENT_TAG)) == null || !dialogFragment.isAdded()) {
            return;
        }
        dialogFragment.dismissAllowingStateLoss();
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final DocTypeConstants getImportType() {
        return this.importType;
    }

    public final boolean isCancelDownloadingDialogAdded() {
        Fragment fragmentFindFragmentByTag;
        FragmentManager childFragmentManager = this.mView.getChildFragmentManager();
        if (childFragmentManager == null || (fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG)) == null) {
            return false;
        }
        return fragmentFindFragmentByTag.isAdded();
    }

    public final void restoreDialog() {
        FragmentManager childFragmentManager = this.mView.getChildFragmentManager();
        if (childFragmentManager != null) {
            FileDownloadDialogFragment fileDownloadDialogFragment = (FileDownloadDialogFragment) childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG);
            if (fileDownloadDialogFragment != null && fileDownloadDialogFragment.isAdded()) {
                fileDownloadDialogFragment.setOnResultListener(this.mDownloadingResultListener);
            }
            NoteDataWarningDialogFragment noteDataWarningDialogFragment = (NoteDataWarningDialogFragment) childFragmentManager.findFragmentByTag(NoteDataWarningDialogFragment.TAG);
            if (noteDataWarningDialogFragment == null || !noteDataWarningDialogFragment.isAdded()) {
                return;
            }
            noteDataWarningDialogFragment.setOnResultListener(this.mMemoDataWarningResultListener);
        }
    }

    public final void showCancelDownloadingDialog() {
        FragmentManager childFragmentManager;
        boolean zIsCancelDownloadingDialogAdded = isCancelDownloadingDialogAdded();
        AbstractC6670b.m4739D("showCancelDownloadingDialog, isCancelDownloadDialogAdded: ", TAG, zIsCancelDownloadingDialogAdded);
        if (zIsCancelDownloadingDialogAdded || (childFragmentManager = this.mView.getChildFragmentManager()) == null) {
            return;
        }
        FileDownloadDialogFragment fileDownloadDialogFragment = new FileDownloadDialogFragment();
        String str = this.appName;
        DocTypeConstants docTypeConstants = this.importType;
        Intrinsics.checkNotNull(docTypeConstants);
        fileDownloadDialogFragment.setData(str, docTypeConstants);
        fileDownloadDialogFragment.setOnResultListener(this.mDownloadingResultListener);
        if (fileDownloadDialogFragment.isAdded()) {
            return;
        }
        try {
            childFragmentManager.beginTransaction().add(fileDownloadDialogFragment, FileDownloadDialogFragment.TAG).commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("IllegalStateException :", e.getMessage(), TAG);
        }
    }

    public final void showErrorDialog(@Nullable Context context) {
        MainLogger.m7258i(TAG, "showErrorDialog()");
        if (context != null) {
            new ErrorDialog(context).show();
        }
    }

    public final void showNoteDataWarningDialog(int type, double size) {
        MainLogger.m7258i(TAG, "showNoteDataWarningDialog()");
        FragmentManager childFragmentManager = this.mView.getChildFragmentManager();
        if (childFragmentManager != null) {
            NoteDataWarningDialogFragment noteDataWarningDialogFragment = (NoteDataWarningDialogFragment) childFragmentManager.findFragmentByTag(NoteDataWarningDialogFragment.TAG);
            if (noteDataWarningDialogFragment == null || !noteDataWarningDialogFragment.isAdded()) {
                NoteDataWarningDialogFragment noteDataWarningDialogFragment2 = new NoteDataWarningDialogFragment();
                noteDataWarningDialogFragment2.setData(type, size);
                noteDataWarningDialogFragment2.setOnResultListener(this.mMemoDataWarningResultListener);
                try {
                    childFragmentManager.beginTransaction().add(noteDataWarningDialogFragment2, NoteDataWarningDialogFragment.TAG).commitAllowingStateLoss();
                } catch (IllegalStateException e) {
                    AbstractC6670b.m4738C("showNoteDataWarningDialog, IllegalStateException :", e.getMessage(), TAG);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void showProgressDialog() {
        MainLogger.m7258i(TAG, "showProgressDialog()");
        FragmentManager childFragmentManager = this.mView.getChildFragmentManager();
        if (childFragmentManager != null) {
            DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(IMPORT_PROGRESS_DIALOG_FRAGMENT_TAG);
            if (dialogFragment == null || !dialogFragment.isAdded()) {
                DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
                dialogFragmentCreateProgressDialogFragment.setCancelable(false);
                dialogFragmentCreateProgressDialogFragment.show(childFragmentManager, IMPORT_PROGRESS_DIALOG_FRAGMENT_TAG);
            }
        }
    }
}
