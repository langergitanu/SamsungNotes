package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.os.Environment;
import androidx.core.util.Pair;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aSerializableAtomHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskSaveVoiceForRecordApp extends SingleThreadTask<InputValues, ResultValues> {
    private static final String DIRECTORY_NOTES_APP = "SamsungNotes";
    private static final String DIRECTORY_RECORDING_APP = "Recordings";
    private static final int SAVED_FAIL_DUPLICATE_NAME = 2;
    private static final int SAVED_FAIL_FILE_ERROR = 1;
    private static final String TAG = Logger.createTag("TaskSaveVoiceForRecordApp");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private final String mDocumentPath;
        private final List<SpenVoiceData> mShareList;
        private final String mUuid;

        public InputValues(Context context, String str, List<SpenVoiceData> list, String str2) {
            this.mContext = context;
            this.mUuid = str;
            ArrayList arrayList = new ArrayList();
            this.mShareList = arrayList;
            arrayList.addAll(list);
            this.mDocumentPath = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private final int mErrorCode;

        public ResultValues(Context context, int i) {
            this.mContext = context;
            this.mErrorCode = i;
        }

        public void showErrorToast() {
            AbstractC8014b.m7195A(new StringBuilder("showErrorToast#"), TaskSaveVoiceForRecordApp.TAG, this.mErrorCode);
            int i = this.mErrorCode;
            if ((i & 2) != 0) {
                ToastHandler.show(this.mContext, "It didn't save files because of a duplicate name.", 0);
            } else if ((i & 1) != 0) {
                ToastHandler.show(this.mContext, "It didn't save files because of a file error.", 0);
            } else {
                ToastHandler.show(this.mContext, "It saved files to Recordings folder ", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File makeDstDir() {
        File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_RECORDING_APP), DIRECTORY_NOTES_APP);
        if (file.exists() || file.mkdir()) {
            return file;
        }
        Logger.m11000e(TAG, "makeDstDir# fail");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(int i) {
        Task.IProgressBarUpdater iProgressBarUpdater = this.mProgressBarUpdater;
        if (iProgressBarUpdater != null) {
            iProgressBarUpdater.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDialogTitle(String str) {
        Task.IProgressBarUpdater iProgressBarUpdater = this.mProgressBarUpdater;
        if (iProgressBarUpdater != null) {
            iProgressBarUpdater.updateDialogTitle(str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public Pair<Boolean, Integer> getProbressBarParams() {
        return new Pair<>(Boolean.TRUE, Integer.valueOf(C9086R.string.composer_save_to_device));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isProgressBarStyle() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskSaveVoiceForRecordApp.1
            /* JADX WARN: Removed duplicated region for block: B:48:0x015b  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
                int i;
                try {
                    try {
                        File fileMakeDstDir = TaskSaveVoiceForRecordApp.this.makeDstDir();
                        if (fileMakeDstDir == null) {
                            Logger.m11000e(TaskSaveVoiceForRecordApp.TAG, "save# cannot make directory for save file");
                            TaskSaveVoiceForRecordApp.this.setProgress(100);
                            TaskSaveVoiceForRecordApp.this.setProgress(100);
                            TaskSaveVoiceForRecordApp.this.notifyCallback(true, new ResultValues(inputValues.mContext, 0));
                            return;
                        }
                        i = 0;
                        int i2 = 0;
                        for (SpenVoiceData spenVoiceData : inputValues.mShareList) {
                            try {
                                i2++;
                                int size = (int) ((i2 / inputValues.mShareList.size()) * 100.0f);
                                TaskSaveVoiceForRecordApp.this.updateDialogTitle(spenVoiceData.getName());
                                String attachedFile = spenVoiceData.getAttachedFile();
                                if (FileUtils.exists(attachedFile)) {
                                    String str = fileMakeDstDir.getAbsolutePath() + File.separator + (spenVoiceData.getName() + "_" + inputValues.mUuid.hashCode() + Extension.DOT + Constants.VOICE_EXTENSION);
                                    if (FileUtils.exists(str)) {
                                        Logger.m11000e(TaskSaveVoiceForRecordApp.TAG, "save# destFilePath exist");
                                        i |= 2;
                                        TaskSaveVoiceForRecordApp.this.setProgress(size);
                                    } else {
                                        if (new M4aSerializableAtomHelper(attachedFile).makeFileForVoiceRecordingApp(str)) {
                                            UriHelper.requestScanFile(inputValues.mContext, str, "audio/m4a");
                                        } else {
                                            Logger.m11000e(TaskSaveVoiceForRecordApp.TAG, "makeFileForVoiceRecordingApp# fail");
                                            i |= 1;
                                        }
                                        TaskSaveVoiceForRecordApp.this.setProgress(size);
                                    }
                                } else {
                                    Logger.m11000e(TaskSaveVoiceForRecordApp.TAG, "save# srcFilePath not exist");
                                    TaskSaveVoiceForRecordApp.this.setProgress(size);
                                }
                            } catch (Exception e) {
                                e = e;
                                Logger.m11001e(TaskSaveVoiceForRecordApp.TAG, e.getMessage(), e);
                                TaskSaveVoiceForRecordApp.this.setProgress(100);
                                TaskSaveVoiceForRecordApp.this.notifyCallback(i == 0, new ResultValues(inputValues.mContext, i));
                                return;
                            }
                        }
                        TaskSaveVoiceForRecordApp.this.setProgress(100);
                        TaskSaveVoiceForRecordApp.this.notifyCallback(i == 0, new ResultValues(inputValues.mContext, i));
                    } catch (Throwable th) {
                        th = th;
                        TaskSaveVoiceForRecordApp.this.setProgress(100);
                        TaskSaveVoiceForRecordApp.this.notifyCallback(0 == 0, new ResultValues(inputValues.mContext, 0));
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i = 0;
                } catch (Throwable th2) {
                    th = th2;
                    TaskSaveVoiceForRecordApp.this.setProgress(100);
                    TaskSaveVoiceForRecordApp.this.notifyCallback(0 == 0, new ResultValues(inputValues.mContext, 0));
                    throw th;
                }
            }
        });
    }
}
