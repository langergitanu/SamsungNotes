package com.samsung.android.support.senl.p148nt.app.main.noteslist.task;

import android.app.Activity;
import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentTimeUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/DeleteExpiredNotesTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "result", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/DeleteTask$Result;", "recycleBinExpiredTime", "", "execute", "taskParams", "(Lkotlin/Unit;)V", "getExpiredDocumentUuids", "", "", "context", "Landroid/content/Context;", "getTag", "getResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeleteExpiredNotesTask extends WorkerTask<Unit> {

    @NotNull
    public static final String TAG = "DeleteExpiredNotesTask";
    private final long recycleBinExpiredTime;

    @NotNull
    private final DeleteTask.Result result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteExpiredNotesTask(@NotNull Activity activity) {
        super(activity.hashCode(), null, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.result = new DeleteTask.Result(getHashCode());
        this.recycleBinExpiredTime = DocumentTimeUtils.getRecycleBinExpiredTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(DeleteExpiredNotesTask deleteExpiredNotesTask, boolean z) {
        List<String> expiredRecycleBinDataNotInFolder = FolderManager.getInstance().getExpiredRecycleBinDataNotInFolder(deleteExpiredNotesTask.recycleBinExpiredTime);
        Intrinsics.checkNotNull(expiredRecycleBinDataNotInFolder);
        List<String> list = expiredRecycleBinDataNotInFolder;
        if (!list.isEmpty()) {
            FolderManager.getInstance().deleteByUuidWithDeleteExpiredFolder(list);
        }
        if (z) {
            RequestToSyncManager.INSTANCE.requestSyncByModification();
        }
        TaskState.INSTANCE.getInstance().setIsRunning("DELETE_DATA", false);
    }

    private final List<String> getExpiredDocumentUuids(Context context) {
        List<String> expiredRecycleBinDataNotInFolder = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getExpiredRecycleBinDataNotInFolder(this.recycleBinExpiredTime);
        Intrinsics.checkNotNullExpressionValue(expiredRecycleBinDataNotInFolder, "getExpiredRecycleBinDataNotInFolder(...)");
        return expiredRecycleBinDataNotInFolder;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public WorkerTask.Result getResult() {
        return this.result;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Unit taskParams) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null || !SpenSdkInitializer.initialize(applicationContext)) {
            return;
        }
        TaskState.INSTANCE.getInstance().setIsRunning("DELETE_DATA", true);
        boolean z = NotesDataRepositoryFactory.newInstance(applicationContext).createNotesRecycleBinRepository().correctRecycleBinTime(System.currentTimeMillis(), TimeManager.INSTANCE.getCurrentTime(applicationContext)) > 0;
        DocumentWriteResolver.deleteExpiredNotes(applicationContext, getExpiredDocumentUuids(applicationContext), 1, TAG);
        FolderManager.getInstance().executeOperation(new RunnableC0116a(2, this, z));
    }
}
