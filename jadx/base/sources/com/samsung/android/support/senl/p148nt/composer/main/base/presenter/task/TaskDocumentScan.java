package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDocumentScan extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskDocumentScan");
    private TaskAddImageHandler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final String mCacheDirPath;
        private final ObjectManager mObjectManager;
        private final String mSrcDirPath;
        private final int mTargetPageIndex;

        public InputValues(ObjectManager objectManager, String str, int i) {
            this.mObjectManager = objectManager;
            this.mCacheDirPath = objectManager.getCachePath();
            this.mSrcDirPath = str;
            this.mTargetPageIndex = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final String mSrcDirPath;

        public ResultValues(String str) {
            this.mSrcDirPath = str;
        }

        public void clearSrcDir() {
            try {
                FileUtils.deleteFile(new File(this.mSrcDirPath));
            } catch (IOException e) {
                Logger.m11000e(TaskDocumentScan.TAG, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(final InputValues inputValues, ArrayList<ObjectManager.ImageData> arrayList) {
        this.mHandler.init(inputValues.mObjectManager, inputValues.mTargetPageIndex, arrayList, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDocumentScan.2
            @Override // java.lang.Runnable
            public void run() {
                TaskDocumentScan.this.notifyCallback(true, new ResultValues(inputValues.mSrcDirPath));
            }
        });
        TaskAddImageHandler taskAddImageHandler = this.mHandler;
        taskAddImageHandler.sendMessage(taskAddImageHandler.obtainMessage(0));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear ");
        TaskAddImageHandler taskAddImageHandler = this.mHandler;
        if (taskAddImageHandler != null) {
            taskAddImageHandler.release();
            this.mHandler = null;
        }
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        this.mHandler = new TaskAddImageHandler();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDocumentScan.1
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = new File(inputValues.mSrcDirPath).listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    TaskDocumentScan.this.notifyCallback(false, null);
                    return;
                }
                ArrayList arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    try {
                        String str = inputValues.mCacheDirPath + file.getName();
                        FileUtil.forceRenameTo(file.getPath(), str);
                        arrayList.add(new ObjectManager.ImageData(str, ImageUtil.isGenerativeEditImage(file.getPath()) || C2paHandler.getInstance().isC2paExist(file.getPath())));
                    } catch (IOException e) {
                        Logger.m11000e(TaskDocumentScan.TAG, e.getMessage());
                    }
                }
                TaskDocumentScan.this.sendMessage(inputValues, arrayList);
            }
        });
    }
}
