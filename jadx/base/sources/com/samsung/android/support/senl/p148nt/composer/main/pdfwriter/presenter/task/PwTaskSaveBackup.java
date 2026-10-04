package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task;

import android.app.Activity;
import android.os.Environment;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.addons.base.utils.FileUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwTaskSaveBackup extends TaskShareCommon<InputValues, TaskShareCommon.ResultValues> {
    private static final String TAG = Logger.createTag("PwTaskSaveBackup");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Activity mActivity;
        private final List<PwFileManager.CacheInfo> mCacheList;
        private final int mPageHeight;
        private final int mPageWidth;

        public InputValues(Activity activity, List<PwFileManager.CacheInfo> list, int i, int i2) {
            this.mActivity = activity;
            this.mCacheList = list;
            this.mPageWidth = i;
            this.mPageHeight = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpenWNote createNote(InputValues inputValues, PwFileManager.CacheInfo cacheInfo) {
        try {
            return new SpenWNote(inputValues.mActivity, cacheInfo.getCacheFile().getPath(), inputValues.mPageWidth, 1000, true, false, false);
        } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException e) {
            AbstractC8014b.m7205g(e, new StringBuilder("createNote# "), TAG);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File makeDstDir() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "SamsungNotes");
        if (file.exists() || file.mkdir()) {
            return file;
        }
        Logger.m11000e(TAG, "makeDstDir# fail");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String save(InputValues inputValues, SpenWNote spenWNote, PwFileManager.CacheInfo cacheInfo, File file) {
        spenWNote.setPDFReaderMode(true);
        SpenNotePdfExport spenNotePdfExport = new SpenNotePdfExport(inputValues.mActivity);
        spenNotePdfExport.setDocument(spenWNote);
        ShareToOtherAppHandler shareToOtherAppHandler = new ShareToOtherAppHandler();
        String originPdfFilePath = cacheInfo.getOriginPdfFilePath();
        String str = File.separator;
        String strSubstring = cacheInfo.getOriginPdfFilePath().substring(originPdfFilePath.lastIndexOf(str) + 1);
        String strMakePdf = shareToOtherAppHandler.getMakeUriHelper().makePdf(inputValues.mActivity, spenNotePdfExport, inputValues.mPageHeight, file.getPath() + str + strSubstring);
        String str2 = TAG;
        Logger.m10999d(str2, "save# origin: " + Logger.getEncode(cacheInfo.getOriginPdfFilePath()) + "   to: " + Logger.getEncode(strMakePdf));
        if (TextUtils.isEmpty(strMakePdf)) {
            Logger.m11000e(str2, "save# fail");
        }
        spenNotePdfExport.close();
        try {
            spenWNote.close(true);
            return strMakePdf;
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("save# close note"), TAG);
            return strMakePdf;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon
    public Task.Callback<TaskShareCommon.ResultValues> getDefaultCallback() {
        final Task.Callback defaultCallback = super.getDefaultCallback();
        return new Task.Callback<TaskShareCommon.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.task.PwTaskSaveBackup.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskShareCommon.ResultValues resultValues) {
                defaultCallback.onError(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskShareCommon.ResultValues resultValues) {
                if (resultValues == null) {
                    Logger.m11000e(PwTaskSaveBackup.TAG, "onSuccess result is null.");
                    return;
                }
                if (TextUtils.isEmpty(resultValues.getPath())) {
                    Logger.m11000e(PwTaskSaveBackup.TAG, "onSuccess# getPath is empty");
                    return;
                }
                String strSubstring = resultValues.getPath().substring(resultValues.getPath().indexOf(Environment.DIRECTORY_DOCUMENTS));
                if (TextUtils.isEmpty(strSubstring)) {
                    return;
                }
                ToastHandler.showEncodingLog(resultValues.getContext(), resultValues.getContext().getString(C9086R.string.save_as_file_saved, strSubstring), 0);
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.task.PwTaskSaveBackup.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                SpenWNote spenWNoteCreateNote;
                File fileMakeDstDir = PwTaskSaveBackup.this.makeDstDir();
                if (fileMakeDstDir == null) {
                    PwTaskSaveBackup.this.notifyCallback(false, new TaskShareCommon.ResultValues(inputValues.mActivity));
                    return;
                }
                List<PwFileManager.CacheInfo> list = inputValues.mCacheList;
                if (list != null) {
                    PwFileManager pwFileManager = new PwFileManager();
                    str = null;
                    for (PwFileManager.CacheInfo cacheInfo : list) {
                        if (FileUtils.isExistedFile(cacheInfo.getCacheFile().getPath()) && (spenWNoteCreateNote = PwTaskSaveBackup.this.createNote(inputValues, cacheInfo)) != null) {
                            String strSave = PwTaskSaveBackup.this.save(inputValues, spenWNoteCreateNote, cacheInfo, fileMakeDstDir);
                            pwFileManager.deleteCache(cacheInfo.getCacheFile().getPath(), cacheInfo.getUuid());
                            if (str == null) {
                                str = strSave;
                            }
                        }
                    }
                    list.clear();
                } else {
                    str = null;
                }
                PwTaskSaveBackup.this.notifyCallback(!TextUtils.isEmpty(str), new TaskShareCommon.ResultValues(inputValues.mActivity, str, null));
            }
        });
    }
}
