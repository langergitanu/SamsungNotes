package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pdf.SpenPdfRenderer;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.WDocConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.HyperTextUpdateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAddPdf extends SingleThreadTask<InputValues, ResultValues> implements PdfManager.AttachPdfStateListener {
    private static final int BUTTON_STATE_ANIM_DURATION = 300;
    private static final float BUTTON_STATE_DISABLE_ALPHA = 0.4f;
    private static final float BUTTON_STATE_ENABLE_ALPHA = 1.0f;
    private static final int PROGRESS_DOWNLOAD_DONE = 10;
    private static final int STATE_ATTACH = 3;
    private static final int STATE_CANCEL = 100;
    private static final int STATE_DOWNLOAD = 1;
    private static final int STATE_DOWNLOAD_DONE = 2;
    private static final int STATE_INIT = -1;
    private static final int STATE_START = 0;
    private static final String TAG = Logger.createTag("TaskAddPdf");
    private List<PdfFileInfo> mDownloadFileList;
    private Handler mHandler;
    private HyperTextUpdateController mHyperTextUpdateController;
    private boolean mIsSecured;
    private Runnable mLastRunnableForHandler;
    private String mOriginalFileName;
    private AlertDialog mPwdDialog;
    private Runnable mRunnableToBeginHistoryGroup;
    private Runnable mRunnableToEndHistoryGroup;
    private final AtomicInteger mCurState = new AtomicInteger(-1);
    private Integer mFirstPageIndex = null;
    private int mFinishPdfCount = 0;
    private int mErrorCode = 0;
    private boolean mIsAutoFocusEnabled = false;
    private long mLimitDocumentSize = 1073741824;
    private int mErrorCodeOverSize = 131072;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComposerContract {
        void changeNoteType(SpenWNote spenWNote, SpenWNote.PageMode pageMode, SpenWNote.Orientation orientation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PdfFileInfo {
        private String mFilePath;
        private final Uri mUri;

        public PdfFileInfo(String str, Uri uri) {
            this.mFilePath = str;
            this.mUri = uri;
        }

        public String getFilePath() {
            return this.mFilePath;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public void setFilePath(String str) {
            this.mFilePath = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PdfVerifyPasswordDialogFragment extends VerifyPasswordDialogFragment {
        private static final int PDF_PASSWORD_MAX_LENGTH = 32;
        private final String mPath;
        private final PdfManager mPdfManager;
        private String mPwd;
        private final ResultListener mResultListener;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface ResultListener {
            void onResult(String str);
        }

        public PdfVerifyPasswordDialogFragment(PdfManager pdfManager, String str, ResultListener resultListener) {
            this.mPdfManager = pdfManager;
            this.mPath = str;
            this.mResultListener = resultListener;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment
        public AlertDialog createDialog(Context context) {
            this.mTitle = context.getResources().getString(C9086R.string.composer_pdf_password_title);
            this.mHintStr = context.getResources().getString(C9086R.string.composer_pdf_password_hint);
            this.mMaxLength = 32;
            AlertDialog alertDialogCreateDialog = super.createDialog(context);
            this.mAlertDialog = alertDialogCreateDialog;
            alertDialogCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.PdfVerifyPasswordDialogFragment.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    ((VerifyPasswordDialogFragment) PdfVerifyPasswordDialogFragment.this).mAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.PdfVerifyPasswordDialogFragment.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!PdfVerifyPasswordDialogFragment.this.mPdfManager.verifyPassword(PdfVerifyPasswordDialogFragment.this.mPath, ((VerifyPasswordDialogFragment) PdfVerifyPasswordDialogFragment.this).mEditText.getText().toString())) {
                                PdfVerifyPasswordDialogFragment.this.setNotMatchPassword();
                                return;
                            }
                            PdfVerifyPasswordDialogFragment pdfVerifyPasswordDialogFragment = PdfVerifyPasswordDialogFragment.this;
                            pdfVerifyPasswordDialogFragment.mPwd = ((VerifyPasswordDialogFragment) pdfVerifyPasswordDialogFragment).mEditText.getText().toString();
                            InputMethodCompat.getInstance().hideSoftInput(PdfVerifyPasswordDialogFragment.this.getContext(), ((VerifyPasswordDialogFragment) PdfVerifyPasswordDialogFragment.this).mEditText);
                            ((VerifyPasswordDialogFragment) PdfVerifyPasswordDialogFragment.this).mAlertDialog.dismiss();
                        }
                    });
                    PdfVerifyPasswordDialogFragment.this.positiveButtonEnable(false);
                }
            });
            this.mAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.PdfVerifyPasswordDialogFragment.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    PdfVerifyPasswordDialogFragment.this.mResultListener.onResult(PdfVerifyPasswordDialogFragment.this.mPwd);
                }
            });
            this.mAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.PdfVerifyPasswordDialogFragment.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1) {
                        return false;
                    }
                    dialogInterface.dismiss();
                    return false;
                }
            });
            this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.PdfVerifyPasswordDialogFragment.4
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    PdfVerifyPasswordDialogFragment.this.positiveButtonEnable(editable.toString().length() != 0);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                }
            });
            return this.mAlertDialog;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment
        public void positiveButtonEnable(boolean z) {
            AlertDialog alertDialog = this.mAlertDialog;
            if (alertDialog == null) {
                return;
            }
            Button button = alertDialog.getButton(-1);
            button.setEnabled(z);
            if (z) {
                button.animate().alpha(1.0f).setDuration(300L).start();
            } else {
                button.animate().alpha(0.4f).setDuration(300L).start();
            }
        }
    }

    public TaskAddPdf() {
        this.mThreadWaitingTermination = true;
    }

    private void applyTemplateToLastPage(SpenWNote spenWNote, NoteManager noteManager, int i) {
        int i2 = i + 1;
        if (i2 == spenWNote.getPageCount()) {
            noteManager.insertPage(i, i - 1);
            noteManager.deletePage(i2, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean attachPdf(InputValues inputValues, PdfFileInfo pdfFileInfo, String str) {
        boolean z;
        boolean z2;
        String str2 = TAG;
        Logger.m11003i(str2, "attachPdf# start - curPageIndex : " + inputValues.curPageIndex);
        SpenWNote note = inputValues.noteManager.getNote();
        int pageCount = note.getPageCount();
        SpenWNote.PageMode pageMode = note.getPageMode();
        SpenWNote.PageMode pageMode2 = SpenWNote.PageMode.SINGLE;
        boolean z3 = true;
        if (pageMode == pageMode2) {
            z = false;
        } else {
            int i = pageCount - 1;
            if (inputValues.curPageIndex == i) {
                Logger.m11003i(str2, "attachPdf# curPageIndex is dummy page.");
            } else if (!isEmptyCurrentPage(inputValues.context, inputValues.noteManager, inputValues.curPageIndex)) {
                inputValues.curPageIndex = Math.min(inputValues.curPageIndex + 1, i);
            } else if (inputValues.curPageIndex < i) {
                z = true;
            }
            z = false;
        }
        if (str != null) {
            inputValues.pdfManager.unlock(pdfFileInfo.getFilePath(), pdfFileInfo.getFilePath() + "_unlock", str);
            pdfFileInfo.setFilePath(pdfFileInfo.getFilePath() + "_unlock");
        }
        if (note.isGroupingHistory()) {
            z2 = false;
        } else {
            waitToBeginCommitHistory(note);
            z2 = true;
        }
        if (checkCancelState(inputValues.context, false)) {
            if (z2 && note.isGroupingHistory()) {
                Logger.m11003i(str2, "attachPdf# clear beginHistory");
                waitToEndCommitHistory(note);
            }
            return false;
        }
        ISpenNotePdfManager.ResultType resultTypeAttach = inputValues.pdfManager.attach(inputValues.curPageIndex, pdfFileInfo.getFilePath(), "", inputValues.isTemplate);
        Logger.m11003i(str2, "attachPdf# resultType: " + resultTypeAttach.name());
        if (resultTypeAttach == ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS || !(resultTypeAttach != ISpenNotePdfManager.ResultType.RESULT_TYPE_CANCEL || isExternalPDFOpenedByReader(inputValues) || pageCount == note.getPageCount())) {
            Logger.addFileLog(str2, "addPdf-" + note.getPageCount(), 0);
            if (this.mFirstPageIndex == null) {
                this.mFirstPageIndex = Integer.valueOf(inputValues.curPageIndex);
            }
            inputValues.curPageIndex += syncPageInfo(note, inputValues.pageManager, pageCount, inputValues.curPageIndex);
            this.mFinishPdfCount++;
            if (z) {
                inputValues.noteManager.deletePage(inputValues.curPageIndex, false, false);
            }
            if (inputValues.isTemplate && note.getPageMode() != pageMode2) {
                applyTemplateToLastPage(note, inputValues.noteManager, inputValues.curPageIndex);
            }
            updateBackgroundColorInvert(inputValues.noteManager, note);
            setFileName(((InputValues) getInputValue()).context, pdfFileInfo.getUri(), inputValues.inputTitle);
        } else {
            Logger.addFileLog(str2, "addPdffail :" + resultTypeAttach.ordinal(), 0);
            setErrorCode(resultTypeAttach.ordinal());
            z3 = false;
        }
        if (z2) {
            waitToEndCommitHistory(note);
        }
        Logger.m11003i(str2, "attachPdf# " + this.mFinishPdfCount + " end");
        return z3;
    }

    private void attachPdfList(InputValues inputValues) {
        setState(3);
        Iterator<PdfFileInfo> it = this.mDownloadFileList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PdfFileInfo next = it.next();
            if (checkCancelState(inputValues.context, false)) {
                break;
            } else {
                attachPdf(inputValues, next, null);
            }
        }
        if (this.mFinishPdfCount > 0) {
            inputValues.noteManager.getNotePdfData().setHavingPdf();
        }
        notifyCallback(this.mFinishPdfCount > 0, new ResultValues(inputValues.context, inputValues.textManager, inputValues.pageManager, this.mOriginalFileName, this.mErrorCode, this.mIsSecured, inputValues.curPageIndex, this.mFirstPageIndex));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canChangePageModeAndOrientation(InputValues inputValues) {
        if (inputValues.isStartedByExternalImportMenu && this.mDownloadFileList.size() == 1) {
            SpenWNote.Orientation orientation = SpenWNote.Orientation.PORTRAIT;
            SpenWNote.PageMode pageMode = getPageMode(inputValues.pdfManager, this.mDownloadFileList.get(0).getFilePath());
            if (pageMode != null) {
                ISpenNotePdfManager.NoteOrientation noteOrientation = inputValues.pdfManager.getNoteOrientation(this.mDownloadFileList.get(0).getFilePath(), null, ISpenNotePdfManager.PageMode.PAGE_MODE_LIST);
                String str = TAG;
                Logger.m11000e(str, "executeTask# noteOrientation." + noteOrientation);
                if (noteOrientation == ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE_NEW) {
                    orientation = SpenWNote.Orientation.LANDSCAPE_NEW;
                }
                if (!inputValues.isPDFReader && inputValues.noteManager.getNote().getOrientation() != orientation) {
                    Logger.m11003i(str, "executeTask# mismatched orientation");
                    return false;
                }
            } else {
                if (!inputValues.isPDFReader) {
                    return false;
                }
                if (inputValues.noteManager.getNote().getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
                    PdfFileInfo pdfFileInfo = this.mDownloadFileList.get(0);
                    if (!checkPageLandscapeLimitForPurePdf(pdfFileInfo)) {
                        AbstractC8014b.m7221w(new StringBuilder("canChangePageModeAndOrientation# checkPageLandscapeLimitForPurePdf"), TAG, this.mErrorCode);
                    }
                    int i = this.mErrorCode;
                    if (i != 0) {
                        if ((805306368 | i) == 0) {
                            Logger.m11000e(TAG, "executeTask# l." + this.mErrorCode);
                            notifyCallback(false, new ResultValues(inputValues.context, this.mErrorCode));
                            return true;
                        }
                        this.mErrorCode = 0;
                        this.mDownloadFileList.add(pdfFileInfo);
                        pageMode = SpenWNote.PageMode.LIST;
                    }
                }
            }
            if (pageModeChange(inputValues.context, inputValues.noteManager, pageMode, orientation)) {
                Logger.m11003i(TAG, "executeTask# pageModeChange to " + pageMode + " / " + orientation);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNoteType(SpenWNote spenWNote, SpenWNote.PageMode pageMode, SpenWNote.Orientation orientation, ComposerContract composerContract) {
        String str = TAG;
        Logger.m10999d(str, "changeNoteType# start : toPageMode = " + pageMode + " / toOrientation = " + orientation);
        composerContract.changeNoteType(spenWNote, pageMode, orientation);
        Logger.m10999d(str, "changeNoteType# end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCancelState(Context context) {
        return checkCancelState(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPageCountLimit(PdfManager pdfManager) {
        Logger.m11003i(TAG, "checkPageCountLimit#");
        int pageCount = 0;
        for (PdfFileInfo pdfFileInfo : new ArrayList(this.mDownloadFileList)) {
            if (pageCount > 200) {
                errorFile(pdfFileInfo, 134217728);
            } else {
                pageCount += pdfManager.getPageCount(pdfFileInfo.getFilePath());
                if (pageCount > 200) {
                    errorFile(pdfFileInfo, 134217728);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PdfFileInfo> checkPageLandscapeLimit(InputValues inputValues) {
        SpenWNote.PageMode pageMode = inputValues.noteManager.getNote().getPageMode();
        SpenWNote.Orientation orientation = inputValues.noteManager.getNote().getOrientation();
        ArrayList arrayList = new ArrayList(this.mDownloadFileList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PdfFileInfo pdfFileInfo = (PdfFileInfo) it.next();
            String filePath = pdfFileInfo.getFilePath();
            SpenWNote.PageMode pageMode2 = getPageMode(inputValues.pdfManager, filePath);
            ISpenNotePdfManager.NoteOrientation noteOrientation = inputValues.pdfManager.getNoteOrientation(filePath, null, ISpenNotePdfManager.PageMode.PAGE_MODE_LIST);
            boolean z = pageMode2 == SpenWNote.PageMode.LIST && (noteOrientation == ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE || noteOrientation == ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE_NEW);
            SpenWNote.PageMode pageMode3 = SpenWNote.PageMode.SINGLE;
            if (pageMode == pageMode3 || orientation == SpenWNote.Orientation.PORTRAIT) {
                if (z) {
                    if (pageMode == pageMode3) {
                        setErrorCode(1073741824);
                    } else {
                        setErrorCode(268435456);
                    }
                    Logger.m11000e(TAG, "checkPageLandscapeLimit# can not add landscape sdocx");
                    it.remove();
                }
            } else if (orientation == SpenWNote.Orientation.LANDSCAPE_NEW) {
                if (pageMode2 == null) {
                    if (!checkPageLandscapeLimitForPurePdf(pdfFileInfo)) {
                        Logger.m11000e(TAG, "checkPageLandscapeLimit# can not add portrait pure pdf");
                        it.remove();
                    }
                } else if (!z) {
                    setErrorCode(536870912);
                    Logger.m11000e(TAG, "checkPageLandscapeLimit# can not add portrait sdocx");
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    private boolean checkPageLandscapeLimitForPurePdf(PdfFileInfo pdfFileInfo) {
        Logger.m11003i(TAG, "checkPageLandscapeLimit#");
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(pdfFileInfo.getFilePath()), 268435456);
            try {
                SpenPdfRenderer spenPdfRenderer = new SpenPdfRenderer(parcelFileDescriptorOpen);
                int pageCount = spenPdfRenderer.getPageCount();
                for (int i = 0; i < pageCount; i++) {
                    if (spenPdfRenderer.getPageHeight(i) > spenPdfRenderer.getPageWidth(i)) {
                        errorFile(pdfFileInfo, 536870912);
                        release(parcelFileDescriptorOpen, spenPdfRenderer);
                        return false;
                    }
                }
                release(parcelFileDescriptorOpen, spenPdfRenderer);
                return true;
            } catch (IOException e) {
                Logger.m11000e(TAG, "checkPageLandscapeLimit# ParcelFileDescriptor e = " + e);
                errorFile(pdfFileInfo, 1048576);
                release(parcelFileDescriptorOpen, null);
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e2) {
            Logger.m11000e(TAG, "checkPageLandscapeLimit# ParcelFileDescriptor e = " + e2);
            errorFile(pdfFileInfo, 16777216);
            release(null, null);
            return false;
        }
    }

    private void checkSecure(PdfManager pdfManager) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(this.mDownloadFileList);
        for (int i = 0; i < arrayList.size(); i++) {
            String filePath = ((PdfFileInfo) arrayList.get(i)).getFilePath();
            boolean zHasPassword = pdfManager.hasPassword(filePath);
            boolean zHasOwnerPermission = pdfManager.hasOwnerPermission(filePath);
            if (zHasPassword || zHasOwnerPermission) {
                sb.append("checkSecure# ");
                sb.append(i);
                sb.append(" hasPwd: ");
                sb.append(zHasPassword);
                sb.append(" hasOwnerPermission: ");
                sb.append(zHasOwnerPermission);
                sb.append('\n');
                errorFile((PdfFileInfo) arrayList.get(i), ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED.ordinal());
            }
        }
        if (sb.length() > 0) {
            Logger.m11003i(TAG, sb.toString());
        }
    }

    private void checkSecureExternalImport(PdfManager pdfManager) {
        String filePath = this.mDownloadFileList.get(0).getFilePath();
        if (pdfManager.hasPassword(filePath)) {
            Logger.m11003i(TAG, "checkSecureExternalImport# hasPwd");
            errorFile(this.mDownloadFileList.get(0), 4194304);
        } else if (pdfManager.hasOwnerPermission(filePath)) {
            Logger.m11003i(TAG, "checkSecureExternalImport# hasOwnerPermission");
            errorFile(this.mDownloadFileList.get(0), 8388608);
        }
    }

    private boolean checkSecurePdfReader(final InputValues inputValues) {
        PdfManager pdfManager = inputValues.pdfManager;
        String filePath = this.mDownloadFileList.get(0).getFilePath();
        if (!pdfManager.hasPassword(filePath)) {
            if (pdfManager.hasOwnerPermission(filePath)) {
                Logger.m11003i(TAG, "checkSecurePdfReader# hasOwnerPermission");
                this.mIsSecured = true;
            }
            return false;
        }
        Logger.m11003i(TAG, "checkSecurePdfReader# hasPwd");
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.3
            @Override // java.lang.Runnable
            public void run() {
                TaskAddPdf.this.mLastRunnableForHandler = null;
                TaskAddPdf taskAddPdf = TaskAddPdf.this;
                taskAddPdf.showPwdDialog(inputValues, (PdfFileInfo) taskAddPdf.mDownloadFileList.get(0));
            }
        };
        this.mLastRunnableForHandler = runnable;
        this.mHandler.post(runnable);
        return true;
    }

    private static void closeParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            return;
        }
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            Logger.m11000e(TAG, "closeParcelFileDescriptor# IOException e = " + e);
        }
    }

    private void dismissPwdDialog() {
        AlertDialog alertDialog = this.mPwdDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        Logger.m10999d(TAG, "clear# dismiss pwd dialog");
        this.mPwdDialog.dismiss();
    }

    private String downloadPdf(Context context, Uri uri, String str) {
        if (uri == null || TextUtils.isEmpty(uri.toString())) {
            Logger.m10999d(TAG, "downloadPdf# uri is empty");
            setErrorCode(16777216);
            return null;
        }
        ContentPickerUtils.DownloadFileResult downloadFileResultDownloadPdf = ContentPickerUtils.downloadPdf(context, str, uri, this.mLimitDocumentSize);
        int i = downloadFileResultDownloadPdf.mSaveResult;
        if (i == 0) {
            return downloadFileResultDownloadPdf.mFilePath;
        }
        if (i == 2) {
            setErrorCode(this.mErrorCodeOverSize);
        } else if (i != 3) {
            setErrorCode(16777216);
        } else {
            setErrorCode(65536);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a A[PHI: r4
      0x005a: PHI (r4v2 java.lang.String) = (r4v1 java.lang.String), (r4v5 java.lang.String) binds: [B:22:0x004d, B:24:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void downloadPdfList(Context context, List<Uri> list, List<String> list2, String str) {
        Logger.m11003i(TAG, "downloadPdfList#");
        setState(1);
        this.mDownloadFileList = new ArrayList();
        if (list == null || (list2 != null && list2.size() == 1)) {
            StorageChecker storageChecker = this.mStorageChecker;
            if (storageChecker == null || storageChecker.checkAvailableStateToAdd(list2.get(0))) {
                this.mDownloadFileList.add(new PdfFileInfo(list2.get(0), list != null ? list.get(0) : null));
            } else {
                setErrorCode(131072);
            }
            setDownloadDoneState();
            return;
        }
        int i = 0;
        while (i < list.size()) {
            if (checkCancelState(context, false)) {
                this.mDownloadFileList.clear();
                return;
            }
            Uri uri = list.get(i);
            String strDownloadPdf = (list2 == null || list2.size() <= i) ? null : list2.get(i);
            if (TextUtils.isEmpty(strDownloadPdf)) {
                strDownloadPdf = downloadPdf(context, uri, str);
                if (!TextUtils.isEmpty(strDownloadPdf)) {
                    long length = new File(strDownloadPdf).length();
                    long j = this.mLimitDocumentSize;
                    if (j < length) {
                        Logger.m11000e(TAG, "downloadPdfList limitDocumentSize : " + this.mLimitDocumentSize + " / fileSize : " + length);
                        setErrorCode(this.mErrorCodeOverSize);
                    } else {
                        this.mLimitDocumentSize = j - length;
                        this.mDownloadFileList.add(new PdfFileInfo(strDownloadPdf, uri));
                    }
                }
            }
            i++;
        }
        setDownloadDoneState();
    }

    private void errorFile(PdfFileInfo pdfFileInfo, int i) {
        setErrorCode(i);
        this.mDownloadFileList.remove(pdfFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAddPdfList(InputValues inputValues) {
        if (this.mDownloadFileList.size() != 1) {
            checkSecure(inputValues.pdfManager);
        } else if (inputValues.isPDFReader && inputValues.isStartedByExternalImportMenu) {
            if (checkSecurePdfReader(inputValues)) {
                return;
            }
        } else if (inputValues.isStartedByExternalImportMenu) {
            checkSecureExternalImport(inputValues.pdfManager);
        } else {
            checkSecure(inputValues.pdfManager);
        }
        attachPdfList(inputValues);
    }

    private SpenWNote.PageMode getPageMode(PdfManager pdfManager, String str) {
        return pdfManager.convertPageMode(pdfManager.getPageMode(str));
    }

    private boolean isEmptyCurrentPage(Context context, NoteManager noteManager, int i) {
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
        spenBodyTextContext.setDocument(noteManager.getNote());
        spenBodyTextContext.measureText();
        RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(i);
        spenBodyTextContext.close();
        boolean zIsObjectEmpty = noteManager.isObjectEmpty(i);
        SpenWPage page = noteManager.getNote().getPage(i);
        boolean zHasPDF = page.hasPDF();
        boolean z = page.getCustomObjectCount() > 0;
        String str = TAG;
        StringBuilder sbM2226q = AbstractC2821a.m2226q("isEmptyCurrentPage# ", i, " objs: ", zIsObjectEmpty, " body: ");
        sbM2226q.append(measuredFitRect);
        sbM2226q.append(" pdf: ");
        sbM2226q.append(zHasPDF);
        sbM2226q.append(" memo: ");
        sbM2226q.append(z);
        Logger.m11003i(str, sbM2226q.toString());
        return measuredFitRect.isEmpty() && zIsObjectEmpty && !zHasPDF && !z;
    }

    private boolean isExternalPDFOpenedByReader(InputValues inputValues) {
        return inputValues.isPDFReader && inputValues.isStartedByExternalImportMenu;
    }

    private boolean pageModeChange(final Context context, final NoteManager noteManager, final SpenWNote.PageMode pageMode, final SpenWNote.Orientation orientation) {
        if (pageMode == null || (noteManager.getNote().getPageMode().equals(pageMode) && noteManager.getNote().getOrientation() == orientation)) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                TaskAddPdf.this.mLastRunnableForHandler = null;
                if (TaskAddPdf.this.checkCancelState(context)) {
                    return;
                }
                TaskAddPdf.this.changeNoteType(noteManager.getNote(), pageMode, orientation, ((InputValues) TaskAddPdf.this.getInputValue()).composerContract);
                TaskAddPdf.this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.2.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.m11003i(TaskAddPdf.TAG, "pageModeChange# post#executeAddPdfOnExecutorService#");
                        TaskAddPdf taskAddPdf = TaskAddPdf.this;
                        taskAddPdf.executeAddPdfList((InputValues) taskAddPdf.getInputValue());
                    }
                });
            }
        };
        this.mLastRunnableForHandler = runnable;
        this.mHandler.post(runnable);
        return true;
    }

    private static void release(ParcelFileDescriptor parcelFileDescriptor, SpenPdfRenderer spenPdfRenderer) {
        closeParcelFileDescriptor(parcelFileDescriptor);
        if (spenPdfRenderer != null) {
            spenPdfRenderer.close();
        }
    }

    private void setDownloadDoneState() {
        setState(2);
        setProgress(10);
    }

    private void setErrorCode(int i) {
        this.mErrorCode = AddPdfUtil.getConvertErrorCode(i) | this.mErrorCode;
    }

    private void setFileName(Context context, Uri uri, String str) {
        if (uri == null || !TextUtils.isEmpty(this.mOriginalFileName)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = FileUtils.getFileNameFromUri(context, uri);
            if (TextUtils.isEmpty(str)) {
                Logger.m11003i(TAG, "setFileName# path is empty");
                return;
            }
        }
        if (str.endsWith(Constants.PDF_EXTENSION_WITH_DOT)) {
            this.mOriginalFileName = UnicodeUtils.normalizeNFC(str.substring(0, str.length() - 4));
        } else {
            this.mOriginalFileName = UnicodeUtils.normalizeNFC(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimitPdfFileSize(boolean z) {
        StorageChecker storageChecker = this.mStorageChecker;
        if (storageChecker != null) {
            this.mLimitDocumentSize = storageChecker.getMaximumDocumentSize();
        }
        if (z) {
            AddPdfUtil.setMaximumPdfSizeMB(100);
            if (this.mLimitDocumentSize > AddPdfUtil.getMaximumPdfSize()) {
                this.mLimitDocumentSize = AddPdfUtil.getMaximumPdfSize();
                this.mErrorCodeOverSize = 134217728;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setPdfManager(PdfManager.AttachPdfStateListener attachPdfStateListener) {
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setPdfActionKey("TaskAddPdf").setPdfActionCaller(getClass()).setActionType(attachPdfStateListener == null ? ICollectParam.ActionType.RESUME_PDF.getValue() : ICollectParam.ActionType.PAUSE_PDF.getValue()).build());
        ((InputValues) getInputValue()).pdfManager.setListener(attachPdfStateListener);
    }

    private void setProgress(int i) {
        Task.IProgressBarUpdater iProgressBarUpdater = this.mProgressBarUpdater;
        if (iProgressBarUpdater != null) {
            iProgressBarUpdater.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int i) {
        if (this.mCurState.get() == 100) {
            return;
        }
        AbstractC8014b.m7217s(i, "setState# ", TAG);
        this.mCurState.set(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPwdDialog(final InputValues inputValues, final PdfFileInfo pdfFileInfo) {
        String str = TAG;
        Logger.m10999d(str, "post#showPasswordDialog#");
        if (this.mExecutorService == null) {
            Logger.m10999d(str, "post#showPasswordDialog# this task was cleared");
            return;
        }
        AlertDialog alertDialogCreateDialog = new PdfVerifyPasswordDialogFragment(inputValues.pdfManager, pdfFileInfo.getFilePath(), new PdfVerifyPasswordDialogFragment.ResultListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.PdfVerifyPasswordDialogFragment.ResultListener
            public void onResult(final String str2) {
                Logger.m10999d(TaskAddPdf.TAG, "post#showPwdDialog#onResult#");
                if (TextUtils.isEmpty(str2)) {
                    TaskAddPdf.this.notifyCallback(false, new ResultValues(inputValues.context, ISpenNotePdfManager.ResultType.RESULT_TYPE_CANCEL.ordinal()));
                } else {
                    TaskAddPdf.this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.m10999d(TaskAddPdf.TAG, "post#attachPdfOnExecutorService#");
                            C99744 c99744 = C99744.this;
                            if (TaskAddPdf.this.checkCancelState(inputValues.context)) {
                                return;
                            }
                            TaskAddPdf.this.setState(3);
                            TaskAddPdf.this.mIsSecured = true;
                            C99744 c997442 = C99744.this;
                            boolean zAttachPdf = TaskAddPdf.this.attachPdf(inputValues, pdfFileInfo, str2);
                            C99744 c997443 = C99744.this;
                            TaskAddPdf.this.notifyCallback(zAttachPdf, new ResultValues(inputValues.context, inputValues.textManager, inputValues.pageManager, TaskAddPdf.this.mOriginalFileName, TaskAddPdf.this.mErrorCode, TaskAddPdf.this.mIsSecured, inputValues.curPageIndex, TaskAddPdf.this.mFirstPageIndex));
                        }
                    });
                }
            }
        }).createDialog(inputValues.context);
        this.mPwdDialog = alertDialogCreateDialog;
        alertDialogCreateDialog.show();
    }

    private int syncPageInfo(SpenWNote spenWNote, PageManager pageManager, int i, int i2) {
        int pageCount = spenWNote.getPageCount() - i;
        int pageCount2 = spenWNote.getPageCount() - pageManager.getPageCount();
        AbstractC8014b.m7221w(AbstractC0622a.m1173s(i2, pageCount, "syncPageInfo# pageIndex: ", " count: ", " not inserted pageInfo count: "), TAG, pageCount2);
        if (pageCount2 > 0) {
            ArrayList arrayList = new ArrayList(pageCount);
            ArrayList arrayList2 = new ArrayList(pageCount);
            ArrayList arrayList3 = new ArrayList(pageCount);
            int i4 = (i2 + pageCount) - pageCount2;
            for (int i5 = 0; i5 < pageCount2; i5++) {
                int i6 = i5 + i4;
                SpenWPage page = spenWNote.getPage(i6);
                String id = page.getId();
                arrayList.add(new PageInfo(i6, page.getWidth(), page.getHeight(), id));
                arrayList2.add(Integer.valueOf(i6));
                arrayList3.add(id);
            }
            pageManager.insert(arrayList, arrayList2, new PageManager.PageUpdateState(true, (List<String>) arrayList3));
        }
        return pageCount;
    }

    private void updateBackgroundColorInvert(NoteManager noteManager, SpenWNote spenWNote) {
        if (spenWNote.isBackgroundColorInverted()) {
            Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
            while (it.hasNext()) {
                if (it.next().hasPDF()) {
                    noteManager.deleteBackgroundColorInvertedAndNotify();
                    return;
                }
            }
        }
    }

    private void waitToBeginCommitHistory(final SpenWNote spenWNote) {
        if (this.mRunnableToBeginHistoryGroup == null) {
            this.mRunnableToBeginHistoryGroup = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.5
                @Override // java.lang.Runnable
                public void run() {
                    spenWNote.beginHistoryGroup(WDocConstants.HISTORY_GROUP_ADD_PDF);
                }
            };
        }
        waitToMainThread(this.mHandler, this.mRunnableToBeginHistoryGroup);
    }

    private void waitToEndCommitHistory(final SpenWNote spenWNote) {
        if (this.mRunnableToEndHistoryGroup == null) {
            this.mRunnableToEndHistoryGroup = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.6
                @Override // java.lang.Runnable
                public void run() {
                    if (spenWNote.isClosed()) {
                        Logger.m11000e(TaskAddPdf.TAG, "waitToEndCommitHistory# note is closed: ");
                    } else {
                        spenWNote.endHistoryGroup();
                    }
                }
            };
        }
        waitToMainThread(this.mHandler, this.mRunnableToEndHistoryGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel# " + this.mCurState);
        if (this.mCurState.get() == 3) {
            ((InputValues) getInputValue()).pdfManager.cancelToAttach();
        }
        if (iCancelCallback != null && this.mCurState.get() < 3) {
            iCancelCallback.onCancel(true);
        }
        setState(100);
        dismissPwdDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear#");
        cancel(null);
        setPdfManager(null);
        ((InputValues) getInputValue()).textManager.setAutoScrollToCursorOnLayoutChanged(this.mIsAutoFocusEnabled);
        super.clear();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        dismissPwdDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task, com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task, com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public boolean isCoeditNoTimeoutPause() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isProgressBarStyle() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.PdfManager.AttachPdfStateListener
    public void onCompleted() {
        Logger.m10999d(TAG, "onCompleted#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.PdfManager.AttachPdfStateListener
    public void onProgressChanged(int i) {
        double size = 90.0d / ((double) this.mDownloadFileList.size());
        double d = (((double) this.mFinishPdfCount) * size) + 10.0d;
        if (i > 0) {
            d += (size * ((double) i)) / 100.0d;
        }
        Logger.m11003i(TAG, "onProgressChanged#" + i + " => " + d);
        setProgress(Math.min((int) d, 100));
    }

    private boolean checkCancelState(Context context, boolean z) {
        if (this.mCurState.get() != 100) {
            return false;
        }
        setErrorCode(ISpenNotePdfManager.ResultType.RESULT_TYPE_CANCEL.ordinal());
        if (!z) {
            return true;
        }
        notifyCallback(false, new ResultValues(context, this.mErrorCode));
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        this.mIsAutoFocusEnabled = inputValues.textManager.isAutoFocusEnabled();
        inputValues.textManager.setAutoScrollToCursorOnLayoutChanged(false);
        inputValues.textManager.updateTextOnlyMode();
        if (inputValues.composerControllerManager != null) {
            HyperTextUpdateController hyperTextUpdateController = inputValues.composerControllerManager.getHyperTextUpdateController();
            this.mHyperTextUpdateController = hyperTextUpdateController;
            if (hyperTextUpdateController != null) {
                hyperTextUpdateController.setBlock(true);
            }
        }
        this.mCurState.set(0);
        setProgress(0);
        setPdfManager(this);
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.mHandler = new Handler();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(TaskAddPdf.TAG, "executeTask");
                if ((inputValues.uriList == null || inputValues.uriList.isEmpty()) && (inputValues.filePathList == null || inputValues.filePathList.isEmpty())) {
                    Logger.m11000e(TaskAddPdf.TAG, "executeTask# inputValues error");
                    TaskAddPdf.this.notifyCallback(true, new ResultValues(inputValues.context, 0));
                    return;
                }
                TaskAddPdf.this.setLimitPdfFileSize(inputValues.mIsLimitPdfFileSize);
                TaskAddPdf.this.downloadPdfList(inputValues.context, inputValues.uriList, inputValues.filePathList, inputValues.pdfManager.getCacheDirPath());
                if (TaskAddPdf.this.mDownloadFileList.isEmpty()) {
                    Logger.m11000e(TaskAddPdf.TAG, "executeTask# mDownloadFileList is empty after downloadPdfList.");
                    TaskAddPdf.this.notifyCallback(false, new ResultValues(inputValues.context, TaskAddPdf.this.mErrorCode));
                    return;
                }
                if (inputValues.mIsLimitPdfFileSize) {
                    TaskAddPdf.this.checkPageCountLimit(inputValues.pdfManager);
                    if (TaskAddPdf.this.mDownloadFileList.isEmpty()) {
                        Logger.m11000e(TaskAddPdf.TAG, "executeTask# mDownloadFileList is empty after checkPageCountLimit.");
                        TaskAddPdf.this.notifyCallback(false, new ResultValues(inputValues.context, TaskAddPdf.this.mErrorCode));
                        return;
                    }
                }
                if (TaskAddPdf.this.canChangePageModeAndOrientation(inputValues)) {
                    return;
                }
                TaskAddPdf taskAddPdf = TaskAddPdf.this;
                taskAddPdf.mDownloadFileList = taskAddPdf.checkPageLandscapeLimit(inputValues);
                TaskAddPdf.this.executeAddPdfList(inputValues);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask
    public void notifyCallback(boolean z, ResultValues resultValues) {
        super.notifyCallback(z, resultValues);
        HyperTextUpdateController hyperTextUpdateController = this.mHyperTextUpdateController;
        if (hyperTextUpdateController != null) {
            hyperTextUpdateController.setBlock(false);
            this.mHyperTextUpdateController = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        boolean isSecured;
        Context mContext;
        int mErrorCode;
        int mFinalPageIndex;
        Integer mFirstPageIndex;
        String originalFileName;
        PageManager pageManager;
        TextManager textManager;

        public ResultValues(Context context, int i) {
            this.pageManager = null;
            this.isSecured = false;
            this.mFirstPageIndex = null;
            this.mContext = context;
            this.mErrorCode = i;
        }

        public Integer getFirstPageIndex() {
            return this.mFirstPageIndex;
        }

        public boolean isSecured() {
            return this.isSecured;
        }

        public void notifyPageUpdate() {
            PageManager pageManager = this.pageManager;
            if (pageManager != null) {
                pageManager.notifyDataSetChanged(3, 0, 0);
            }
        }

        public void showErrorToast(boolean z) {
            AbstractC8014b.m7221w(new StringBuilder("showErrorToast#"), TaskAddPdf.TAG, this.mErrorCode);
            AddPdfUtil.showErrorToast(this.mContext, this.mErrorCode, z);
        }

        public void updateTitle() {
            if (TextUtils.isEmpty(this.originalFileName) || !TextUtils.isEmpty(this.textManager.getTitle())) {
                return;
            }
            String str = this.originalFileName;
            this.textManager.setTitle(str.substring(0, Math.min(str.length(), 50)));
        }

        public ResultValues(Context context, TextManager textManager, PageManager pageManager, String str, int i, boolean z, int i2, Integer num) {
            this(context, i);
            this.textManager = textManager;
            this.pageManager = pageManager;
            this.originalFileName = str;
            this.isSecured = z;
            this.mFinalPageIndex = i2;
            this.mFirstPageIndex = num;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private ComposerContract composerContract;
        private final ComposerControllerManager composerControllerManager;
        private final Context context;
        private int curPageIndex;
        private final List<String> filePathList;
        private String inputTitle;
        private boolean isPDFReader;
        private boolean isStartedByExternalImportMenu;
        private boolean isTemplate;
        private final boolean mIsLimitPdfFileSize;
        private final NoteManager noteManager;
        private final PageManager pageManager;
        private final PdfManager pdfManager;
        private final TextManager textManager;
        private final List<Uri> uriList;

        public InputValues(Context context, NoteManager noteManager, PdfManager pdfManager, PageManager pageManager, TextManager textManager, ComposerControllerManager composerControllerManager, List<Uri> list, List<String> list2, int i, boolean z) {
            this.inputTitle = "";
            this.context = context;
            this.noteManager = noteManager;
            this.pdfManager = pdfManager;
            this.pageManager = pageManager;
            this.textManager = textManager;
            this.composerControllerManager = composerControllerManager;
            this.uriList = list;
            this.filePathList = list2;
            this.curPageIndex = i;
            this.mIsLimitPdfFileSize = z;
        }

        public void setInputTitle(String str) {
            this.inputTitle = str;
            Logger.m10999d(TaskAddPdf.TAG, "setInputTitle# " + Logger.getEncode(str));
        }

        public InputValues(Context context, NoteManager noteManager, PdfManager pdfManager, PageManager pageManager, TextManager textManager, ComposerControllerManager composerControllerManager, List<Uri> list, List<String> list2, int i, boolean z, boolean z2, ComposerContract composerContract, boolean z3, boolean z4) {
            this(context, noteManager, pdfManager, pageManager, textManager, composerControllerManager, list, list2, i, z);
            this.isStartedByExternalImportMenu = z2;
            this.composerContract = composerContract;
            this.isTemplate = z3;
            this.isPDFReader = z4;
        }
    }
}
