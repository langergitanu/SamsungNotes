package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Pair;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCopyPage extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskCopyPage");
    private boolean mIsCanceled;
    private NoteManager mNoteManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    public TaskCopyPage() {
        this.mThreadWaitingTermination = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        super.cancel(iCancelCallback);
        Logger.m10999d(TAG, "cancel#");
        this.mIsCanceled = true;
        this.mNoteManager.setCancelState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        cancel(null);
        super.clear();
    }

    public Pair<ClipData.Item, String> createHtmlTextData(Context context, Bitmap bitmap, String str, String str2) {
        String clipboardFileName = ClipboardCacheManager.getClipboardFileName(context, str2, "1.jpg");
        ImageUtil.saveBitmapToFileCache(bitmap, clipboardFileName, Bitmap.CompressFormat.JPEG, 95);
        SpannableString spannableString = new SpannableString(" ");
        Uri uri = ClipDataContentProvider.getUri(clipboardFileName);
        spannableString.setSpan(new ImageSpan(context, uri), 0, 1, 33);
        String strTrim = spannableString.toString().trim();
        String html = HtmlUtils.toHtml(spannableString);
        String clipDataBackupPath = ClipDataBackupPath.getClipDataBackupPath(str);
        return new Pair<>(new ClipData.Item(strTrim, (html + clipDataBackupPath).replace("<img src=", "<img style=\"max-width: 100%;\" src="), null, uri), clipDataBackupPath);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        inputValues.mObjectManager.getSelectedObjectManager().clearSelectedTextTypeObject();
        this.mNoteManager = inputValues.mNoteManager;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopyPage.1
            @Override // java.lang.Runnable
            public void run() {
                final Context context = inputValues.mContext;
                NoteCaptureControl noteCaptureControl = new NoteCaptureControl(context);
                try {
                    SpenWNote note = inputValues.mNoteManager.getNote();
                    ClipboardCacheManager.trimCache(context);
                    String str = ClipboardCacheManager.CLIPBOARD_PAGE_PREFIX + ClipboardCacheManager.getDateString();
                    String str2 = ClipboardCacheManager.getClipboardPath(context).getAbsolutePath() + "/" + str + ".sdocx";
                    InputValues inputValues2 = inputValues;
                    Bitmap pageThumbnail = inputValues2.mNoteManager.getPageThumbnail(noteCaptureControl, note, ((PageCopyData) inputValues2.mDataList.get(0)).getIndex());
                    boolean zCopyPage = inputValues.mNoteManager.copyPage(context, note.getOrientation(), note.getPageDefaultWidth(), inputValues.mDataList, str2);
                    if (TaskCopyPage.this.mIsCanceled) {
                        TaskCopyPage.this.notifyCallback(false, new ResultValues());
                        return;
                    }
                    if (!zCopyPage) {
                        TaskCopyPage.this.notifyCallback(false, new ResultValues());
                        return;
                    }
                    final Pair<ClipData.Item, String> pairCreateHtmlTextData = TaskCopyPage.this.createHtmlTextData(context, pageThumbnail, str2, str);
                    Object obj = pairCreateHtmlTextData.first;
                    if (obj != null && (!TextUtils.isEmpty(((ClipData.Item) obj).getText()) || !TextUtils.isEmpty(((ClipData.Item) pairCreateHtmlTextData.first).getHtmlText()))) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopyPage.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Task.Callback<R> taskCallback = TaskCopyPage.this.getTaskCallback();
                                if (ClipboardManagerCompat.INSTANCE.getInstance().setClip(context, (ClipData.Item) pairCreateHtmlTextData.first, new String[]{Constants.MIME_HTML}, "")) {
                                    if (taskCallback != 0) {
                                        taskCallback.onSuccess(new ResultValues());
                                    }
                                } else if (taskCallback != 0) {
                                    taskCallback.onError(new ResultValues());
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    Logger.m11001e(TaskCopyPage.TAG, e.getMessage(), e);
                    TaskCopyPage.this.notifyCallback(false, new ResultValues());
                } finally {
                    noteCaptureControl.close();
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private List<PageCopyData> mDataList;
        protected NoteManager mNoteManager;
        protected ObjectManager mObjectManager;

        private InputValues(Context context, NoteManager noteManager, ObjectManager objectManager) {
            this.mContext = context;
            this.mNoteManager = noteManager;
            this.mObjectManager = objectManager;
        }

        public Context getContext() {
            return this.mContext;
        }

        public List<PageCopyData> getDataList() {
            return this.mDataList;
        }

        public List<Integer> getIndexList() {
            ArrayList arrayList = new ArrayList();
            Iterator<PageCopyData> it = this.mDataList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().getIndex()));
            }
            return arrayList;
        }

        public NoteManager getNoteManager() {
            return this.mNoteManager;
        }

        public ObjectManager getObjectManager() {
            return this.mObjectManager;
        }

        public InputValues(Context context, NoteManager noteManager, ObjectManager objectManager, PageCopyData pageCopyData) {
            this(context, noteManager, objectManager);
            ArrayList arrayList = new ArrayList();
            this.mDataList = arrayList;
            arrayList.add(pageCopyData);
        }

        public InputValues(Context context, NoteManager noteManager, ObjectManager objectManager, List<PageCopyData> list) {
            this(context, noteManager, objectManager);
            this.mDataList = new ArrayList(list);
        }
    }
}
