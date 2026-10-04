package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.IPwInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.PdfWriterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.PwFragmentContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwDialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.sub.PwServiceContractImpl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwFragmentPresenter extends BaseComposerPresenter implements PwFragmentContract.IPresenter {
    private static final String KEY_DOC_PATH = "doc_path";
    private static final String TAG = Logger.createTag("PwFragmentPresenter");
    private final PwRestoreManager mRestoreManager;

    public PwFragmentPresenter(@NonNull BaseComposerPresenter.ComponentFactory componentFactory) {
        super(componentFactory);
        this.mRestoreManager = new PwRestoreManager();
    }

    private boolean checkIfEnableToUseDocPath(@NonNull Bundle bundle) {
        try {
            String string = bundle.getString("doc_path", "");
            if (string.isEmpty() || FileUtils.exists(string)) {
                return true;
            }
            return FileUtils.exists(SpenWNoteFile.getCachePath(this.mSubManager.getComposerLifeState().getActivity(), string, 0));
        } catch (Exception e) {
            Logger.m11001e(TAG, "saveLastDocPath# ", e);
            return true;
        }
    }

    private boolean closeIfNoCacheData(Activity activity, @Nullable Bundle bundle) {
        String string;
        PdfFileInfo pdfFileInfo;
        if (bundle == null || (string = bundle.getString(PwComposerModel.KEY_SAVED_PATH)) == null || AbstractC2322a.m1607A(string)) {
            return false;
        }
        setActivity(activity);
        this.mSubManager.getComposerLifeState().setSavedInstanceState(bundle);
        ToastHandler.show(activity.getApplicationContext(), C9086R.string.unable_to_open_note, 1);
        if ((this.mServiceContractImpl.getDocInfo() instanceof PwDocInfo) && (pdfFileInfo = ((PwDocInfo) this.mServiceContractImpl.getDocInfo()).getPdfFileInfo()) != null) {
            PdfWriterManager.getInstance().moveExistPwToFront(activity, pdfFileInfo);
        }
        finish("closeIfNoCacheData");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSaveBackupDialog$0() {
        Logger.m10999d(TAG, "showSaveBackupDialog#");
        ((PwDialogPresenterManager) this.mSubManager.getDialogPresenterManager()).showSaveBackupDialog();
    }

    private void setDialogContract() {
        ((PwDialogPresenterManager) this.mSubManager.getDialogPresenterManager()).setPwDialogContract(new PwDialogPresenterManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.PwFragmentPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.dialog.PwSaveBackupDialogPresenter.Contract
            public void clearData() {
                PwFragmentPresenter.this.mRestoreManager.clearDeleteData();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.dialog.PwSaveBackupDialogPresenter.Contract
            public List<PwFileManager.CacheInfo> getCacheList() {
                return PwFragmentPresenter.this.mRestoreManager.getDeleteTargetCacheList();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.dialog.PwSaveBackupDialogPresenter.Contract
            public void getPageSize(int[] iArr) {
                iArr[0] = ((BaseComposerPresenter) PwFragmentPresenter.this).mSubManager.getComposerModel().getDoc().getPageDefaultWidth();
                iArr[1] = ((BaseComposerPresenter) PwFragmentPresenter.this).mSubManager.getComposerModel().getDoc().getPageDefaultHeight();
            }
        });
    }

    private void setDocPathInSaveInstanceState(@NonNull Bundle bundle) {
        try {
            bundle.putString("doc_path", this.mSubManager.getComposerModel().getDocInfo().getDocPath());
        } catch (Exception e) {
            Logger.m11001e(TAG, "saveLastDocPath# ", e);
        }
    }

    private void showSaveBackupDialog() {
        if (this.mRestoreManager.hasDeleteTarget()) {
            if (this.mSubManager.getControllerManager().getTaskController().isRunning()) {
                Logger.m10999d(TAG, "showSaveBackupDialog# pending");
                this.mSubManager.getControllerManager().getTaskController().addPendingJob(new RunnableC9767a(this, 20), 3);
            } else {
                Logger.m10999d(TAG, "showSaveBackupDialog#");
                ((PwDialogPresenterManager) this.mSubManager.getDialogPresenterManager()).showSaveBackupDialog();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void unregisterFromPdfWriterManager(Activity activity) {
        if (activity instanceof IPwInfo) {
            PdfWriterManager.getInstance().unregister((IPwInfo) activity);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public ServiceContractImpl createServiceContractImpl(ServiceContractImpl.Contract contract) {
        return new PwServiceContractImpl(this.mSubManager, this.mComposerCloser, contract, this.mRestoreManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.PwFragmentContract.IPresenter
    public void discardBackup() {
        this.mRestoreManager.discard();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        setActivity(activity);
        if (bundle == null && !activity.getIntent().hasExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO)) {
            Logger.m11000e(TAG, "onActivityCreated# no pdf data");
            finish("no pdf data");
            return;
        }
        if (!this.mRestoreManager.canRestore(activity)) {
            finish("isRestoring");
        } else if (this.mRestoreManager.isRestoreState(activity, (PwFragmentContract.IView) this.mView, bundle) || closeIfNoCacheData(activity, bundle)) {
            return;
        }
        super.onActivityCreated(activity, bundle);
        if (this.mSubManager.getComposerModel().getDocState() != null && (activity instanceof IPwInfo)) {
            PdfWriterManager.getInstance().register((IPwInfo) activity, ((PwDocInfo) this.mSubManager.getComposerModel().getDocInfo()).getPdfFileInfo());
        }
        if (bundle == null || checkIfEnableToUseDocPath(bundle)) {
            return;
        }
        Logger.m11004w(TAG, "onActivityCreated# no sdocx file");
        this.mSubManager.getComposerLifeState().setSavedInstanceState(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onDestroy(Activity activity) {
        unregisterFromPdfWriterManager(activity);
        super.onDestroy(activity);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onDetachView(Activity activity) {
        unregisterFromPdfWriterManager(activity);
        super.onDetachView(activity);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.OnInitFinishedListener
    public void onInitFinished() {
        super.onInitFinished();
        setDialogContract();
        this.mRestoreManager.done(this.mSubManager.getComposerModel().getDocState());
        showSaveBackupDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public void onSaveInstanceState(@NonNull Bundle bundle, boolean z, boolean z2) {
        super.onSaveInstanceState(bundle, z, z2);
        this.mRestoreManager.onSaveInstanceState(bundle);
        setDocPathInSaveInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.PwFragmentContract.IPresenter
    public void restoreBackup(Activity activity) {
        this.mRestoreManager.restore(activity);
    }
}
