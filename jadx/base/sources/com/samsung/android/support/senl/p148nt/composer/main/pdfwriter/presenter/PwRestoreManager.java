package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RestoreInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.PwFragmentContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.sub.PwServiceContractImpl;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.pdfwriter.PDFWriterRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.service.RestoreCacheManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwRestoreManager implements PwServiceContractImpl.RestoreManagerContract {
    private static final String KEY_RESTORE_INFO = "restore_info";
    private static final String TAG = Logger.createTag("PwRestoreManager");
    private List<PwFileManager.CacheInfo> mDeleteTargetCacheList;
    private RestoreInfo mRestoreInfo;
    private boolean mRestoreCheckFlag = true;
    private final PwFileManager mPwFileManager = new PwFileManager();

    private File findRestoreTargetAndRemoveItFrom(String str, List<PwFileManager.CacheInfo> list) {
        Iterator<PwFileManager.CacheInfo> it = list.iterator();
        File cacheFile = null;
        while (it.hasNext()) {
            PwFileManager.CacheInfo next = it.next();
            if (next.getOriginPdfFilePath().equals(str)) {
                cacheFile = next.getCacheFile();
                it.remove();
            }
        }
        return cacheFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean hasBackupData(Activity activity, PwFragmentContract.IView iView, boolean z) {
        Fragment fragment;
        PdfFileInfo pdfFileInfo = (PdfFileInfo) activity.getIntent().getParcelableExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO);
        String str = TAG;
        Logger.m10999d(str, "hasBackupData# " + pdfFileInfo);
        if (pdfFileInfo == null) {
            return false;
        }
        if (!z) {
            fragment = null;
        } else if (iView instanceof Fragment) {
            fragment = (Fragment) iView;
        } else {
            Logger.m11000e(str, "hasBackupData# fail cast fragment");
            fragment = null;
        }
        List<PwFileManager.CacheInfo> validCacheFiles = this.mPwFileManager.getValidCacheFiles(activity, true, fragment);
        if (validCacheFiles == null) {
            Logger.m10999d(str, "hasBackupData# not exist cacheInfo");
            return false;
        }
        if (pdfFileInfo.isSaveAs()) {
            this.mDeleteTargetCacheList = this.mPwFileManager.getDeleteTargetList(validCacheFiles);
            Logger.m10999d(str, "hasBackupData# delete target# " + this.mDeleteTargetCacheList.size());
        } else {
            File fileFindRestoreTargetAndRemoveItFrom = findRestoreTargetAndRemoveItFrom(pdfFileInfo.getPath(), validCacheFiles);
            this.mDeleteTargetCacheList = this.mPwFileManager.getDeleteTargetList(validCacheFiles);
            Logger.m10999d(str, "hasBackupData# delete target# " + this.mDeleteTargetCacheList.size());
            if (fileFindRestoreTargetAndRemoveItFrom != null) {
                this.mRestoreInfo = new RestoreInfo(FileUtils.extractFileName(fileFindRestoreTargetAndRemoveItFrom.getName()), pdfFileInfo, fileFindRestoreTargetAndRemoveItFrom.getPath());
                if (z) {
                    iView.showRestoreDialog(fileFindRestoreTargetAndRemoveItFrom.lastModified());
                }
                return true;
            }
        }
        return false;
    }

    public boolean canRestore(Activity activity) {
        PdfFileInfo pdfFileInfo = (PdfFileInfo) activity.getIntent().getParcelableExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO);
        if (pdfFileInfo == null) {
            return true;
        }
        String uuid = PDFWriterRepositoryFactory.createPDFWriterRepository().getUuid(pdfFileInfo.getPath());
        if (TextUtils.isEmpty(uuid) || !RestoreCacheManager.isRestoring(uuid)) {
            return true;
        }
        Logger.m11000e(TAG, "canRestore# " + pdfFileInfo);
        ToastHandler.show(activity, C9086R.string.updating_note_try_again_later, 0);
        return false;
    }

    public void clearDeleteData() {
        List<PwFileManager.CacheInfo> list = this.mDeleteTargetCacheList;
        if (list == null) {
            return;
        }
        list.clear();
        this.mDeleteTargetCacheList = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.sub.PwServiceContractImpl.RestoreManagerContract
    public PwDocInfo createPwDocInfo() {
        if (this.mRestoreInfo == null) {
            return null;
        }
        PwDocInfo pwDocInfo = new PwDocInfo(DocInfo.OpenType.OpenByView, this.mRestoreInfo.getSavePath(), this.mRestoreInfo.getUuid());
        pwDocInfo.setPdfFileInfo(this.mRestoreInfo.getPdfFileInfo());
        return pwDocInfo;
    }

    public void discard() {
        if (this.mRestoreInfo == null) {
            return;
        }
        Logger.m10999d(TAG, "discard#");
        this.mPwFileManager.deleteCache(this.mRestoreInfo.getSavePath(), this.mRestoreInfo.getUuid());
    }

    public void done(NotesDocument<SpenWordDocument> notesDocument) {
        if (this.mRestoreInfo != null) {
            Logger.m11003i(TAG, "done#");
            notesDocument.setDirty(true);
            this.mRestoreInfo = null;
        }
    }

    public List<PwFileManager.CacheInfo> getDeleteTargetCacheList() {
        return this.mDeleteTargetCacheList;
    }

    public boolean hasDeleteTarget() {
        List<PwFileManager.CacheInfo> list = this.mDeleteTargetCacheList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.sub.PwServiceContractImpl.RestoreManagerContract
    public boolean hasRestoreInfo() {
        return this.mRestoreInfo != null;
    }

    public boolean isRestoreState(Activity activity, PwFragmentContract.IView iView, @Nullable Bundle bundle) {
        if (!this.mRestoreCheckFlag) {
            if (bundle != null) {
                RestoreInfo restoreInfo = (RestoreInfo) bundle.getParcelable(KEY_RESTORE_INFO);
                this.mRestoreInfo = restoreInfo;
                if (restoreInfo != null) {
                    return true;
                }
            }
            return false;
        }
        this.mRestoreCheckFlag = false;
        if (bundle == null) {
            return hasBackupData(activity, iView, true);
        }
        RestoreInfo restoreInfo2 = (RestoreInfo) bundle.getParcelable(KEY_RESTORE_INFO);
        this.mRestoreInfo = restoreInfo2;
        if (restoreInfo2 != null) {
            return true;
        }
        hasBackupData(activity, iView, false);
        return false;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putParcelable(KEY_RESTORE_INFO, this.mRestoreInfo);
    }

    public void restore(Activity activity) {
        if (this.mRestoreInfo == null) {
            return;
        }
        Logger.m11002f(TAG, "restore#, " + this.mRestoreInfo.getUuid() + "/" + Logger.getEncode(this.mRestoreInfo.getPdfFileInfo().getPath()));
        Intent intent = activity.getIntent();
        intent.setAction("");
        intent.setData(null);
        intent.removeExtra(ComposerConstants.ARG_PDF_OPEN_URI);
        intent.putExtra("new_doc", true);
        intent.putExtra("tool_type", 2);
        intent.putExtra("sdoc_uuid", this.mRestoreInfo.getUuid());
        intent.putExtra("doc_path", this.mRestoreInfo.getPdfFileInfo().getPath());
    }
}
