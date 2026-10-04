package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.model.repository.pdfwriter.PDFWriterRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwComposerModel extends ComposerModel {
    public static final String KEY_SAVED_PATH = "key_pw_saved_path";
    public static final String KEY_SAVE_DIRTY = "key_pw_save_dirty";
    private static final String TAG = Logger.createTag("PwComposerModel");
    private final String mCacheFolderPath;
    private boolean mIsDirty;
    private ISaveDelegate mSaveDelegate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISaveDelegate {
        void save(Runnable runnable);
    }

    public PwComposerModel(Activity activity, @NonNull Config config) {
        super(activity, config);
        this.mIsPDFReader = true;
        this.mCacheFolderPath = DocumentCacheUtils.getCacheFolder(activity);
    }

    public void deleteCacheInfo() {
        if (getDocInfo() == null) {
            return;
        }
        new PwFileManager().deleteCacheInfo(getDocInfo().getUuid());
        this.mIsDirty = false;
    }

    public boolean isChangedDocStateWithSnapSavedDataAndDirty() {
        return isChangedDocStateWithSnapSavedData() || this.mIsDirty;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public void onSaveInstanceState(Activity activity, @NonNull Bundle bundle, boolean z) {
        super.onSaveInstanceState(activity, bundle, z);
        bundle.putBoolean(KEY_SAVE_DIRTY, this.mIsDirty);
        String docPath = getDocInfo().getDocPath();
        if (AbstractC2322a.m1607A(docPath)) {
            bundle.putString(KEY_SAVED_PATH, docPath);
            return;
        }
        String pDFWriterCachePath = DocumentCacheUtils.getPDFWriterCachePath(activity, getDocInfo().getUuid());
        if (AbstractC2322a.m1607A(pDFWriterCachePath)) {
            bundle.putString(KEY_SAVED_PATH, pDFWriterCachePath);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public void restoreStateOnlyData(Bundle bundle) {
        super.restoreStateOnlyData(bundle);
        if (bundle == null) {
            return;
        }
        this.mIsDirty = bundle.getBoolean(KEY_SAVE_DIRTY);
    }

    public boolean save(Runnable runnable) {
        if (this.mSaveDelegate == null) {
            Logger.m10999d(TAG, "save# no delegate");
            return false;
        }
        if (isChangedDocStateWithSnapSavedDataAndDirty()) {
            this.mSaveDelegate.save(runnable);
            return true;
        }
        Logger.m10999d(TAG, "save# no changes");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public boolean saveAsync(boolean z, boolean z2) {
        return save(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public boolean saveCache(boolean z) {
        if (!this.mIsDirty) {
            this.mIsDirty = isChangedDocStateWithSnapSavedData();
        }
        if (!super.saveCache(z)) {
            return false;
        }
        if (FileUtils.exists(getDocInfo().getDocPath())) {
            return true;
        }
        File file = new File(this.mCacheFolderPath);
        if (!file.exists() && !file.mkdir()) {
            Logger.m11000e(TAG, "saveCache# fail to make a cache folder");
            return true;
        }
        getComposerSaveModel().saveCacheForced(getDocState(), z);
        PdfFileInfo pdfFileInfo = ((PwDocInfo) getDocInfo()).getPdfFileInfo();
        if (!pdfFileInfo.getPath().isEmpty()) {
            PDFWriterRepositoryFactory.createPDFWriterRepository().insert(getDocState().getUuid(), pdfFileInfo.getPath());
        }
        Logger.m11003i(TAG, "saveCache# make file");
        return true;
    }

    public void setSaveDelegate(ISaveDelegate iSaveDelegate) {
        this.mSaveDelegate = iSaveDelegate;
    }

    public void trimCacheInfo() {
        if (getDocInfo() == null) {
            return;
        }
        PwFileManager pwFileManager = new PwFileManager();
        String docPath = getDocInfo().getDocPath();
        pwFileManager.deleteCacheInfo(getDocInfo().getUuid());
        pwFileManager.deleteUnexpectedFile(docPath, getDocInfo().getUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public boolean saveCache(boolean z, int i) {
        if (!this.mIsDirty) {
            this.mIsDirty = isChangedDocStateWithSnapSavedData();
        }
        return super.saveCache(z, i);
    }
}
