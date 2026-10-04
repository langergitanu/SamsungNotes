package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.StringRes;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCondition;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 /2\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0002./B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0017\u001a\u00020\u0016H\u0016J$\u0010\u0018\u001a\u00020\u00162\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0016\u0010\u001c\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010 \u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010!\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u001a\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020'H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareDialogTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/checkdata/CheckedNoteInfo;", "Lkotlin/collections/ArrayList;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "", "isSaveToExternalStorage", "", "taskResultListener", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareDialogTask$TaskResultListener;", "<init>", "(Landroid/app/Activity;IZLcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareDialogTask$TaskResultListener;)V", "mResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "mTaskResultListener", "mSharableNoteList", "", "mIsContentEmpty", "setTaskResultListener", "", "onPreExecute", "execute", "taskParams", "showProgressDialog", "removeProgressDialog", "prepareExportText", "requireNoteList", "", "prepareExportDoc", "prepareExportWord", "prepareExportOthers", "showToast", "closeSpenWNote", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "filePath", "", "showWordExportOptionPopup", "showPdfExportOptionPopup", "executeExportTask", "onUiThread", "getTag", "getResult", "TaskResultListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShareDialogTask extends WorkerTask<ArrayList<CheckedNoteInfo>> {

    @NotNull
    public static final String TAG = "ShareDialogTask";

    @NotNull
    private final Activity activity;
    private final boolean isSaveToExternalStorage;
    private boolean mIsContentEmpty;

    @NotNull
    private final WorkerTask.Result mResult;

    @NotNull
    private List<CheckedNoteInfo> mSharableNoteList;

    @Nullable
    private TaskResultListener mTaskResultListener;
    private final int shareType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J0\u0010\f\u001a\u00020\u00032\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J0\u0010\u000e\u001a\u00020\u00032\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J$\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH&¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/task/ShareDialogTask$TaskResultListener;", "", "showWordExportOptionPopup", "", "sharableNoteLis", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/checkdata/CheckedNoteInfo;", "Lkotlin/collections/ArrayList;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "", "isSaveToExternalStorage", "", "showPdfExportOptionPopup", "sharableNoteList", "executeExportTask", "showCircleProgressDialog", "removeCircleProgressDialog", "showProcessProgressDialog", "removeProcessProgressDialog", "showToast", "context", "Landroid/content/Context;", "resId", XmlErrorCodes.DURATION, "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TaskResultListener {
        void executeExportTask(@NotNull ArrayList<CheckedNoteInfo> sharableNoteList, int shareType, boolean isSaveToExternalStorage);

        void removeCircleProgressDialog();

        void removeProcessProgressDialog();

        void showCircleProgressDialog();

        void showPdfExportOptionPopup(@NotNull ArrayList<CheckedNoteInfo> sharableNoteList, int shareType, boolean isSaveToExternalStorage);

        void showProcessProgressDialog();

        void showToast(@Nullable Context context, @StringRes int resId, int duration);

        void showWordExportOptionPopup(@NotNull ArrayList<CheckedNoteInfo> sharableNoteLis, int shareType, boolean isSaveToExternalStorage);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShareDialogTask(@NotNull Activity activity, int i, boolean z, @NotNull TaskResultListener taskResultListener) {
        super(activity.hashCode(), null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(taskResultListener, "taskResultListener");
        this.activity = activity;
        this.shareType = i;
        this.isSaveToExternalStorage = z;
        this.mResult = new WorkerTask.Result() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask$mResult$1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public int getHashCode() {
                return this.this$0.getHashCode();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public String getTag() {
                return ShareDialogTask.TAG;
            }
        };
        this.mSharableNoteList = new ArrayList();
        setTaskResultListener(taskResultListener);
    }

    private final void closeSpenWNote(SpenWNote spenWNote, String filePath) {
        MainLogger.m7258i(TAG, "closeSpenWNote");
        try {
            DocumentFileManager.getInstance().close(filePath, spenWNote, true);
        } catch (IOException e) {
            AbstractC6670b.m4738C("closeSpenWNote# : ", e.getMessage(), TAG);
        }
    }

    private final void executeExportTask(boolean onUiThread) {
        RunnableC8535a runnableC8535a = new RunnableC8535a(this, 0);
        if (onUiThread) {
            this.activity.runOnUiThread(runnableC8535a);
        } else {
            runnableC8535a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeExportTask$lambda$2(ShareDialogTask shareDialogTask) {
        TaskResultListener taskResultListener = shareDialogTask.mTaskResultListener;
        if (taskResultListener != null) {
            taskResultListener.executeExportTask(new ArrayList<>(shareDialogTask.mSharableNoteList), shareDialogTask.shareType, shareDialogTask.isSaveToExternalStorage);
        }
    }

    private final void prepareExportDoc(ArrayList<CheckedNoteInfo> requireNoteList) {
        Iterator<CheckedNoteInfo> it = requireNoteList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            CheckedNoteInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            CheckedNoteInfo checkedNoteInfo = next;
            SpenWordDocument spenWordDocument = NotesUtils.INSTANCE.getSpenWordDocument(this.activity.getApplicationContext(), checkedNoteInfo.getFilePath(), UUIDUtils.isCoeditUuid(checkedNoteInfo.getUuid()));
            if (spenWordDocument != null) {
                if (spenWordDocument.isContentEmpty()) {
                    this.mIsContentEmpty = true;
                } else {
                    this.mSharableNoteList.add(checkedNoteInfo);
                }
                try {
                    DocumentFileManager.getInstance().closeWordDocument(checkedNoteInfo.getFilePath(), spenWordDocument, true);
                } catch (IOException e) {
                    MainLogger.m7255e(TAG, e.getMessage());
                }
            }
        }
    }

    private final void prepareExportOthers(ArrayList<CheckedNoteInfo> requireNoteList) {
        Iterator<CheckedNoteInfo> it = requireNoteList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            CheckedNoteInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            CheckedNoteInfo checkedNoteInfo = next;
            boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(checkedNoteInfo.getUuid());
            Context applicationContext = this.activity.getApplicationContext();
            String filePath = checkedNoteInfo.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            SpenWNote spenWNote = NotesUtils.getSpenWNote(applicationContext, filePath, zIsCoeditUuid);
            if (spenWNote != null) {
                if (ShareCondition.hasContent(spenWNote)) {
                    this.mSharableNoteList.add(checkedNoteInfo);
                } else {
                    this.mIsContentEmpty = true;
                }
                String filePath2 = checkedNoteInfo.getFilePath();
                Intrinsics.checkNotNullExpressionValue(filePath2, "getFilePath(...)");
                closeSpenWNote(spenWNote, filePath2);
            }
        }
    }

    private final boolean prepareExportText(List<? extends CheckedNoteInfo> requireNoteList) {
        for (CheckedNoteInfo checkedNoteInfo : requireNoteList) {
            boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(checkedNoteInfo.getUuid());
            Context applicationContext = this.activity.getApplicationContext();
            String filePath = checkedNoteInfo.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            SpenWNote spenWNote = NotesUtils.getSpenWNote(applicationContext, filePath, zIsCoeditUuid);
            if (spenWNote != null) {
                if (ShareCondition.hasText(spenWNote)) {
                    this.mSharableNoteList.add(checkedNoteInfo);
                } else {
                    this.mIsContentEmpty = true;
                }
                String filePath2 = checkedNoteInfo.getFilePath();
                Intrinsics.checkNotNullExpressionValue(filePath2, "getFilePath(...)");
                closeSpenWNote(spenWNote, filePath2);
            }
        }
        if (!this.mSharableNoteList.isEmpty()) {
            return false;
        }
        TaskResultListener taskResultListener = this.mTaskResultListener;
        if (taskResultListener != null) {
            taskResultListener.showToast(this.activity.getBaseContext(), this.mIsContentEmpty ? C9086R.string.share_no_text : C9086R.string.base_string_failed_to_load_image, 0);
        }
        return true;
    }

    private final boolean prepareExportWord(ArrayList<CheckedNoteInfo> requireNoteList) {
        Iterator<CheckedNoteInfo> it = requireNoteList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        boolean z = false;
        while (it.hasNext()) {
            CheckedNoteInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            CheckedNoteInfo checkedNoteInfo = next;
            SpenWNote spenWNoteForExportOffice = NotesUtils.getSpenWNoteForExportOffice(this.activity.getApplicationContext(), checkedNoteInfo.getFilePath(), UUIDUtils.isCoeditUuid(checkedNoteInfo.getUuid()));
            if (ShareCondition.hasContent(spenWNoteForExportOffice)) {
                this.mSharableNoteList.add(checkedNoteInfo);
                if (!z && spenWNoteForExportOffice != null && spenWNoteForExportOffice.hasObject(1)) {
                    z = true;
                }
            } else {
                this.mIsContentEmpty = true;
            }
            String filePath = checkedNoteInfo.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            closeSpenWNote(spenWNoteForExportOffice, filePath);
        }
        if (z && RecognitionUtil.isSupported(this.activity.getBaseContext()) && !this.mSharableNoteList.isEmpty()) {
            if (!isCancelled()) {
                showWordExportOptionPopup();
            }
            return true;
        }
        if (!RecognitionUtil.isSupported(this.activity.getApplicationContext())) {
            MainLogger.m7258i(TAG, "Share word : Can not extract text");
            SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
            if (companion.getInstance().getInt(SettingsConstants.SETTINGS_EXPORT, 0) != 1) {
                companion.getInstance("Settings").putInt(SettingsConstants.SETTINGS_EXPORT, 1);
            }
        }
        return false;
    }

    private final void removeProgressDialog() {
        if (this.isSaveToExternalStorage) {
            TaskResultListener taskResultListener = this.mTaskResultListener;
            if (taskResultListener != null) {
                taskResultListener.removeProcessProgressDialog();
                return;
            }
            return;
        }
        TaskResultListener taskResultListener2 = this.mTaskResultListener;
        if (taskResultListener2 != null) {
            taskResultListener2.removeCircleProgressDialog();
        }
    }

    private final void showPdfExportOptionPopup() {
        this.activity.runOnUiThread(new RunnableC8535a(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPdfExportOptionPopup$lambda$1(ShareDialogTask shareDialogTask) {
        TaskResultListener taskResultListener = shareDialogTask.mTaskResultListener;
        if (taskResultListener != null) {
            taskResultListener.showPdfExportOptionPopup(new ArrayList<>(shareDialogTask.mSharableNoteList), shareDialogTask.shareType, shareDialogTask.isSaveToExternalStorage);
        }
    }

    private final void showProgressDialog() {
        if (this.isSaveToExternalStorage) {
            TaskResultListener taskResultListener = this.mTaskResultListener;
            if (taskResultListener != null) {
                taskResultListener.showProcessProgressDialog();
                return;
            }
            return;
        }
        TaskResultListener taskResultListener2 = this.mTaskResultListener;
        if (taskResultListener2 != null) {
            taskResultListener2.showCircleProgressDialog();
        }
    }

    private final void showToast() {
        int i = this.isSaveToExternalStorage ? this.mIsContentEmpty ? C9086R.string.save_as_file_empty_content : C9086R.string.base_string_failed_to_load_image : this.mIsContentEmpty ? C9086R.string.share_empty_content : C9086R.string.base_string_failed_to_load_image;
        TaskResultListener taskResultListener = this.mTaskResultListener;
        if (taskResultListener != null) {
            taskResultListener.showToast(this.activity.getBaseContext(), i, 0);
        }
    }

    private final void showWordExportOptionPopup() {
        this.activity.runOnUiThread(new RunnableC8535a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWordExportOptionPopup$lambda$0(ShareDialogTask shareDialogTask) {
        TaskResultListener taskResultListener = shareDialogTask.mTaskResultListener;
        if (taskResultListener != null) {
            taskResultListener.showWordExportOptionPopup(new ArrayList<>(shareDialogTask.mSharableNoteList), shareDialogTask.shareType, shareDialogTask.isSaveToExternalStorage);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public WorkerTask.Result getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPreExecute() {
        super.onPreExecute();
        showProgressDialog();
    }

    public final void setTaskResultListener(@NotNull TaskResultListener taskResultListener) {
        Intrinsics.checkNotNullParameter(taskResultListener, "taskResultListener");
        this.mTaskResultListener = taskResultListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(@Nullable ArrayList<CheckedNoteInfo> taskParams) {
        if (CommonUtil.isNotAvailableActivity(this.activity) || taskParams == null || taskParams.isEmpty()) {
            MainLogger.m7259w(TAG, "execute, end, invalid activity or params");
            removeProgressDialog();
            return;
        }
        AbstractC6670b.m4736A(this.shareType, "execute# shareType : ", TAG);
        int i = this.shareType;
        if (i == 0) {
            prepareExportDoc(taskParams);
        } else {
            if (i == 1) {
                prepareExportOthers(taskParams);
                if (this.mSharableNoteList.isEmpty()) {
                    showToast();
                } else {
                    showPdfExportOptionPopup();
                }
                MainLogger.m7254d(TAG, "execute, end, sdoc/pdf prepared");
                removeProgressDialog();
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        if (i != 7) {
                            prepareExportOthers(taskParams);
                        } else {
                            List<CheckedNoteInfo> list = this.mSharableNoteList;
                            CheckedNoteInfo checkedNoteInfo = taskParams.get(0);
                            Intrinsics.checkNotNullExpressionValue(checkedNoteInfo, "get(...)");
                            list.add(checkedNoteInfo);
                        }
                    } else if (prepareExportText(taskParams)) {
                        MainLogger.m7254d(TAG, "execute, end, text only prepared");
                        removeProgressDialog();
                        return;
                    }
                }
            } else if (prepareExportWord(taskParams)) {
                MainLogger.m7254d(TAG, "execute, end, word prepared");
                removeProgressDialog();
                return;
            }
        }
        if (this.mSharableNoteList.isEmpty()) {
            showToast();
            MainLogger.m7259w(TAG, "execute, end, shareable note list is empty");
            removeProgressDialog();
        } else {
            if (!this.isSaveToExternalStorage) {
                executeExportTask(false);
                return;
            }
            executeExportTask(true);
            MainLogger.m7259w(TAG, "execute, end, save to external storage");
            removeProgressDialog();
        }
    }
}
