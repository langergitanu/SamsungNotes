package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.pdf.SpenPdfWriter;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportPDFTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportPdfParam;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslatedPDFSaveTask implements Runnable {
    private static final String TAG = Logger.createTag("TranslatedPDFSaveTask");
    private static final String TRANSLATION = "translation";
    private final Context mAppContext;
    private final Callback mCallback;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final String mDocumentPath;
    private Executor mExecutor;

    @PageMode
    private final int mPageMode;
    private final String mPdfFileName;
    private TranslationOverlayManager mTranslationOverlayManager;
    private String mFirstTempPdfPath = "";
    private String mSecondTempPdfPath = "";
    private String mUuid = "";
    private SpenWNote mNote = null;
    private SpenNotePdfExport mPDFExport = null;
    private SpenPdfWriter mPDFWriter = null;
    private final AtomicBoolean mIsCanceled = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onFailed(int i, String str);

        void onProgress(int i, int i2);

        void onSuccess(String str);
    }

    public TranslatedPDFSaveTask(Context context, String str, String str2, @PageMode int i, ComposerViewPresenter composerViewPresenter, @NonNull Callback callback) {
        this.mAppContext = context;
        this.mDocumentPath = str;
        this.mPdfFileName = str2;
        this.mPageMode = i;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mCallback = callback;
    }

    private void closeDoc() {
        try {
            DocumentFileManager.getInstance().close(this.mDocumentPath, this.mNote, true);
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("closeDoc, e: "), TAG);
        }
    }

    private void closePdfControllers() {
        SpenNotePdfExport spenNotePdfExport = this.mPDFExport;
        if (spenNotePdfExport != null) {
            spenNotePdfExport.close();
        }
        SpenPdfWriter spenPdfWriter = this.mPDFWriter;
        if (spenPdfWriter != null) {
            spenPdfWriter.close();
        }
    }

    private void closeTranslator() {
        TranslationOverlayManager translationOverlayManager = this.mTranslationOverlayManager;
        if (translationOverlayManager != null) {
            translationOverlayManager.release();
            this.mTranslationOverlayManager = null;
        }
    }

    private void deleteTempFiles() {
        FileUtils.deleteFile(this.mFirstTempPdfPath);
        FileUtils.deleteFile(this.mSecondTempPdfPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fail(int i, String str) {
        release();
        notifyFailure(i, str);
    }

    private String getTempDirectory() {
        File file = new File(DocumentCacheUtils.getPDFWriterCacheFolder(this.mAppContext));
        if (!file.exists() && !file.mkdir()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentCacheUtils.getPDFWriterCacheFolder(this.mAppContext));
        String strM1170p = AbstractC0622a.m1170p(File.separator, "translation", sb);
        File file2 = new File(strM1170p);
        if (file2.exists() || file2.mkdir()) {
            return strM1170p;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean importTranslatedPDF() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || composerViewPresenter.getComposerModel() == null || this.mComposerViewPresenter.getComposerModel().getDoc() == null || this.mComposerViewPresenter.getComposerModel().getDocState() == null) {
            Logger.m10999d(TAG, "importTranslatedPDF# Failed by invalid status");
            return false;
        }
        if (this.mIsCanceled.get()) {
            return false;
        }
        this.mUuid = UUIDUtils.newGenUUID(this.mAppContext);
        return new ImportPDFTask(new ImportPdfParam().setIsNew(true).setContext(this.mAppContext).setUuid(this.mUuid).setFolderUuid("uncategorized:///").setExternalPath(this.mSecondTempPdfPath).setTitle(this.mPdfFileName).setPreferredPageMode(this.mPageMode).setPreferredIsPortraitOrientation(this.mComposerViewPresenter.getComposerModel().getDoc().getOrientation() == SpenWNote.Orientation.PORTRAIT).setUuidToCopyExtraData(this.mComposerViewPresenter.getComposerModel().getDocState().getUuid()).setCaller(TAG)).setImported(true).call().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyFailure$1(int i, String str) {
        Callback callback = this.mCallback;
        if (this.mIsCanceled.get()) {
            i = 2;
        }
        callback.onFailed(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifySuccess$0() {
        this.mCallback.onSuccess(this.mUuid);
    }

    private void notifyFailure(int i, String str) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0101a(this, i, str, 13));
    }

    private void notifySuccess() {
        new Handler(Looper.getMainLooper()).post(new RunnableC9414a(this, 1));
    }

    private void release() {
        closeTranslator();
        closePdfControllers();
        closeDoc();
        deleteTempFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void runOnWorkerThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
            return;
        }
        if (this.mExecutor == null) {
            this.mExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        }
        this.mExecutor.execute(runnable);
    }

    private boolean saveDocumentAsPDF(SpenWNote spenWNote, String str) {
        if (this.mIsCanceled.get()) {
            return false;
        }
        int width = spenWNote.getWidth() != 0 ? spenWNote.getWidth() : spenWNote.getPageDefaultWidth();
        int height = spenWNote.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW ? DocumentPageRatio.PageRatioType.A4_LANDSCAPE.getHeight(width) : DocumentPageRatio.PAGE_RATIO.getHeight(width);
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(str, this.mPdfFileName, Constants.PDF_EXTENSION);
        SpenNotePdfExport spenNotePdfExport = new SpenNotePdfExport(this.mAppContext, 0);
        this.mPDFExport = spenNotePdfExport;
        spenNotePdfExport.setDocument(spenWNote);
        ISpenNotePdfManager.ResultType resultTypeExportFile = this.mPDFExport.exportFile(height, strGenerateUniqueFilePath);
        Logger.m10999d(TAG, "saveDocumentAsPDF, result: " + resultTypeExportFile);
        if (resultTypeExportFile != ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS || !AbstractC2322a.m1607A(strGenerateUniqueFilePath)) {
            return false;
        }
        this.mFirstTempPdfPath = strGenerateUniqueFilePath;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveTranslatedPDF(String str) {
        if (this.mIsCanceled.get()) {
            return false;
        }
        this.mSecondTempPdfPath = FileUtils.generateUniqueFilePath(str, this.mPdfFileName, Constants.PDF_EXTENSION);
        this.mPDFWriter.setWatermarkString(this.mAppContext.getResources().getString(C9086R.string.ai_translated_content));
        return this.mPDFWriter.save(this.mSecondTempPdfPath);
    }

    private void setTranslatedTextToPDF(final String str) {
        if (this.mIsCanceled.get()) {
            fail(2, "canceled before translation");
            return;
        }
        SpenPdfWriter spenPdfWriter = new SpenPdfWriter(this.mAppContext);
        this.mPDFWriter = spenPdfWriter;
        spenPdfWriter.open(this.mFirstTempPdfPath, "", this.mNote.getWidth());
        this.mComposerViewPresenter.getAiMenuManager().setStopImageOverlay(true);
        TranslationOverlayManager translationOverlayManager = new TranslationOverlayManager(this.mComposerViewPresenter, this.mPDFWriter);
        this.mTranslationOverlayManager = translationOverlayManager;
        translationOverlayManager.translateAll(new TranslationOverlayManager.TaskListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.TaskListener
            public void onCompleted() {
                TranslatedPDFSaveTask.this.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C93931 c93931 = C93931.this;
                        if (!TranslatedPDFSaveTask.this.saveTranslatedPDF(str) || !TranslatedPDFSaveTask.this.importTranslatedPDF()) {
                            TranslatedPDFSaveTask.this.fail(1, "fail to import PDF note");
                        } else {
                            Logger.m10999d(TranslatedPDFSaveTask.TAG, "setTranslatedTextToPDF, success");
                            TranslatedPDFSaveTask.this.success();
                        }
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.TaskListener
            public void onFailed(final int i, @NonNull final String str2) {
                TranslatedPDFSaveTask.this.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String str3 = TranslatedPDFSaveTask.TAG;
                        StringBuilder sb = new StringBuilder("setTranslatedTextToPDF# onFailed, type : ");
                        sb.append(i);
                        sb.append(", e: ");
                        AbstractC8014b.m7213o(sb, str2, str3);
                        TranslatedPDFSaveTask.this.fail(i, str2);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.TaskListener
            public void onProgress(final int i, final int i2) {
                TranslatedPDFSaveTask.this.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2 = TranslatedPDFSaveTask.TAG;
                        StringBuilder sb = new StringBuilder("setTranslatedTextToPDF, onProgress : ");
                        sb.append(i);
                        sb.append(" / ");
                        AbstractC8014b.m7221w(sb, str2, i2);
                        TranslatedPDFSaveTask.this.mCallback.onProgress(i, i2);
                    }
                });
            }
        }, this.mComposerViewPresenter.getPdfManager().getTranslationMap(), this.mComposerViewPresenter.getPdfManager().getImageTranslationMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void success() {
        release();
        notifySuccess();
    }

    public void cancel() {
        this.mIsCanceled.set(true);
        SpenNotePdfExport spenNotePdfExport = this.mPDFExport;
        if (spenNotePdfExport != null) {
            spenNotePdfExport.cancelExportFile();
        }
        TranslationOverlayManager translationOverlayManager = this.mTranslationOverlayManager;
        if (translationOverlayManager != null) {
            translationOverlayManager.cancelTranslateAll();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String tempDirectory = getTempDirectory();
        if (tempDirectory == null) {
            notifyFailure(1, "tempDir is null");
            return;
        }
        if (this.mIsCanceled.get()) {
            notifyFailure(2, "canceled before start");
            return;
        }
        try {
            DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
            Context context = this.mAppContext;
            SpenWNote spenWNoteOpen = documentFileManager.open(context, this.mDocumentPath, SpenDocumentDisplayUtils.getScreenWidth(context), 11000, false, false);
            this.mNote = spenWNoteOpen;
            if (saveDocumentAsPDF(spenWNoteOpen, tempDirectory)) {
                setTranslatedTextToPDF(tempDirectory);
            } else {
                fail(1, "fail to save document as PDF");
            }
        } catch (Exception e) {
            Logger.m11000e(TAG, "run# failed, e: " + e.getMessage());
            fail(1, e.getMessage());
        }
    }
}
