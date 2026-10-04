package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.ContextCompat;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareCreatedWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskMakePdf extends TaskShareCommon<InputValues, TaskShareCommon.ResultValues> {
    private static final String TAG = Logger.createTag("TaskMakePdf");
    protected SpenNotePdfExport mSpenNotePdfExport;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PdfShareType {
        NOTES_COMPAT(C9086R.string.composer_share_pdf_raster, 0),
        STANDARD(C9086R.string.composer_share_pdf_vector, 1);

        public final int exportType;
        public final int resId;

        PdfShareType(int i, int i2) {
            this.resId = i;
            this.exportType = i2;
        }
    }

    private void closeDoc(SpenWNote spenWNote, String str) {
        try {
            DocumentFileManager.getInstance().close(str, spenWNote, true);
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("executeTask# close SpenWNote fail e : "), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.String] */
    public void exportPdf(InputValues inputValues) {
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                spenWNoteOpen = DocumentFileManager.getInstance().open(inputValues.mContext, inputValues.mShareData.getPath(), inputValues.mComposerModel.getDoc().getPageDefaultWidth(), 1000, true, false, false);
                resetParameterInNote(inputValues.mComposerModel.getDoc(), spenWNoteOpen);
                exportPdf(inputValues, spenWNoteOpen);
            } catch (Exception e) {
                Logger.m11000e(TAG, "executeTask# new SpenWNote fail e : " + e.getMessage());
                notifyCallback(false, new TaskShareCommon.ResultValues(inputValues.mContext));
            }
        } finally {
            closeDoc(spenWNoteOpen, inputValues.mShareData.getPath());
        }
    }

    private void exportPdfForNormal(InputValues inputValues) {
        try {
            if (TextUtils.isEmpty(inputValues.mDestPath)) {
                sharePdf(inputValues);
            } else {
                saveAsPdfFile(inputValues);
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "exportPdfForNormal# " + e.getMessage(), e);
            notifyCallback(false, new TaskShareCommon.ResultValues(inputValues.mContext));
        }
    }

    private void exportPdfForPrint(InputValues inputValues) {
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = new ShareCacheHelper().getContextShareDir(inputValues.mContext, false);
        if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
            Logger.m11000e(TAG, "exportPdfForPrint# failed to getPathForShare");
            notifyCallback(false, new TaskShareCommon.ResultValues(inputValues.mContext));
            return;
        }
        int pageDefaultHeight = inputValues.mComposerModel.getDoc().getPageDefaultHeight();
        String strGenerateNewFilePath = ShareUtils.generateNewFilePath(contextShareDir.mDir, inputValues.mShareData.getTitle(), inputValues.mShareData.getLastModifiedTime(), Constants.PDF_EXTENSION);
        this.mSpenNotePdfExport.setTransparentBackgroundColor(ContextCompat.getColor(inputValues.mContext, C9086R.color.composer_main_background_light));
        String strMakePdf = this.mShareToOtherAppHandler.getMakeUriHelper().makePdf(inputValues.mContext, this.mSpenNotePdfExport, pageDefaultHeight, strGenerateNewFilePath);
        if (TextUtils.isEmpty(strMakePdf) || !AbstractC2322a.m1607A(strMakePdf)) {
            notifyCallback(false, new TaskShareCommon.ResultValues(inputValues.mContext));
        } else {
            notifyCallback(true, new TaskShareCommon.ResultValues(inputValues.mContext, strMakePdf, null));
        }
    }

    private void removeAllStickyMemoObject(SpenWNote spenWNote) {
        if (spenWNote.hasCustomObject()) {
            Logger.m11003i(TAG, "removeAllStickyMemoObject#");
            for (SpenWPage spenWPage : spenWNote.getPageList()) {
                if (spenWPage.getCustomObjectCount() > 0) {
                    spenWPage.removeAllCustomObject();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetParameterInNote(SpenWNote spenWNote, SpenWNote spenWNote2) {
        if (spenWNote2.getPageDefaultHeight() == 0) {
            spenWNote2.setPageDefaultHeight(spenWNote.getPageDefaultHeight());
        }
        removeAllStickyMemoObject(spenWNote2);
    }

    private void sharePdf(InputValues inputValues) {
        this.mShareToOtherAppHandler.sharePdf(inputValues.mContext, this.mSpenNotePdfExport, inputValues.mComposerModel.getDoc().getPageDefaultHeight(), inputValues.mShareData, 0);
        notifyCallback(true, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        if (this.mIsCanceled) {
            Logger.m11003i(TAG, "cancel# already canceled");
            return;
        }
        if (this.mSpenNotePdfExport != null) {
            Logger.m11003i(TAG, "cancel# cancelExportFile");
            this.mSpenNotePdfExport.cancelExportFile();
        }
        this.mIsCanceled = true;
        this.mShareToOtherAppHandler.cancel();
    }

    public void saveAsPdfFile(InputValues inputValues) {
        String strMakePdf = this.mShareToOtherAppHandler.getMakeUriHelper().makePdf(inputValues.mContext, this.mSpenNotePdfExport, inputValues.mComposerModel.getDoc().getPageDefaultHeight(), inputValues.mDestPath);
        if (TextUtils.isEmpty(strMakePdf) || !AbstractC2322a.m1607A(strMakePdf)) {
            notifyCallback(false, new TaskShareCommon.ResultValues(inputValues.mContext));
        } else {
            notifyCallback(true, new TaskShareCommon.ResultValues(inputValues.mContext, strMakePdf, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private final String mDestPath;
        private boolean mIsPrint;
        private boolean mIsWidgetMyfiles;
        private final PdfShareType mPdfShareType;
        private final ShareData mShareData;
        private final ShareWNote mShareWNote;

        public InputValues(Context context, ComposerModel composerModel, ShareData shareData, ShareWNote shareWNote, boolean z) {
            this(context, composerModel, "", shareData, shareWNote, PdfShareType.NOTES_COMPAT);
            this.mIsPrint = z;
        }

        public ComposerModel getComposerModel() {
            return this.mComposerModel;
        }

        public Context getContext() {
            return this.mContext;
        }

        public String getDestPath() {
            return this.mDestPath;
        }

        public boolean isWidgetMyfiles() {
            return this.mIsWidgetMyfiles;
        }

        public void setWidgetMyfiles() {
            this.mIsWidgetMyfiles = true;
        }

        public InputValues(Context context, ComposerModel composerModel, String str, ShareData shareData, ShareWNote shareWNote, PdfShareType pdfShareType) {
            this.mIsPrint = false;
            this.mIsWidgetMyfiles = false;
            this.mContext = context;
            this.mComposerModel = composerModel;
            this.mDestPath = str;
            this.mShareData = shareData;
            this.mShareWNote = shareWNote;
            this.mPdfShareType = pdfShareType == null ? PdfShareType.NOTES_COMPAT : pdfShareType;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakePdf.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m11003i(TaskMakePdf.TAG, "executeTask# start");
                if (!(inputValues.mShareWNote instanceof ShareCreatedWNote)) {
                    TaskMakePdf.this.exportPdf(inputValues);
                    Logger.m11003i(TaskMakePdf.TAG, "executeTask# end");
                    return;
                }
                Logger.m11003i(TaskMakePdf.TAG, "executeTask# isPDFViewer");
                TaskMakePdf.this.resetParameterInNote(inputValues.mComposerModel.getDoc(), inputValues.mShareWNote.getNote());
                TaskMakePdf taskMakePdf = TaskMakePdf.this;
                InputValues inputValues2 = inputValues;
                taskMakePdf.exportPdf(inputValues2, inputValues2.mShareWNote.getNote());
                inputValues.mShareWNote.close(inputValues.mShareData.getPath());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exportPdf(InputValues inputValues, SpenWNote spenWNote) {
        AbstractC8014b.m7195A(new StringBuilder("exportPdf# exportType : "), TAG, inputValues.mPdfShareType.exportType);
        if (!this.mIsCanceled) {
            spenWNote.setPDFReaderMode(inputValues.mComposerModel.getDoc().isPDFReaderMode());
            SpenNotePdfExport spenNotePdfExport = new SpenNotePdfExport(inputValues.mContext, inputValues.mPdfShareType.exportType);
            this.mSpenNotePdfExport = spenNotePdfExport;
            spenNotePdfExport.setDocument(spenWNote);
            if (!inputValues.mIsPrint) {
                exportPdfForNormal(inputValues);
            } else {
                exportPdfForPrint(inputValues);
            }
            this.mSpenNotePdfExport.close();
            this.mSpenNotePdfExport = null;
            return;
        }
        notifyCallback(true, new TaskShareCommon.ResultValues(inputValues.mContext));
    }
}
