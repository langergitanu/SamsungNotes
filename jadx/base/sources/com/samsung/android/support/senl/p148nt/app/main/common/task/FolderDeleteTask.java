package com.samsung.android.support.senl.p148nt.app.main.common.task;

import android.app.Activity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.model.domain.folder.DeleteFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderDeleteTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "taskResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderDeleteTask$Result;", "isRecycleBinDisabled", "", "execute", "", "taskParams", "getTag", "getResult", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FolderDeleteTask extends WorkerTask<ArrayList<String>> {

    @NotNull
    public static final String TAG = "FolderDeleteTask";
    private boolean isRecycleBinDisabled;

    @NotNull
    private final Result taskResult;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/FolderDeleteTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "tag", "", "getTag", "()Ljava/lang/String;", "hasOpenedNote", "", "setHasOpenedNote", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private boolean hasOpenedNote;
        private final int hashCode;

        public Result(int i) {
            this.hashCode = i;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return FolderDeleteTask.TAG;
        }

        /* JADX INFO: renamed from: hasOpenedNote, reason: from getter */
        public final boolean getHasOpenedNote() {
            return this.hasOpenedNote;
        }

        public final void setHasOpenedNote(boolean hasOpenedNote) {
            this.hasOpenedNote = hasOpenedNote;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderDeleteTask(@NotNull Activity activity) {
        super(activity.hashCode(), null, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.taskResult = new Result(activity.hashCode());
        this.isRecycleBinDisabled = FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable ArrayList<String> taskParams) {
        if (taskParams == null || taskParams.isEmpty()) {
            MainLogger.m7259w(TAG, "execute ignore, taskParams is invalid");
            return;
        }
        AbstractC6670b.m4739D("execute start, isRecycleBinEnabled : ", TAG, this.isRecycleBinDisabled);
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("DELETE_DATA", true);
        if (this.isRecycleBinDisabled) {
            FolderManager.getInstance().deleteByUuid(taskParams);
        } else {
            NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createCategoryTreeClosureRepository();
            Intrinsics.checkNotNullExpressionValue(notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository, "createCategoryTreeClosureRepository(...)");
            this.taskResult.setHasOpenedNote(taskParams.size() > new DeleteFolderUseCase(notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository).execute(taskParams).getDeletedFolders().size());
        }
        companion.getInstance().setIsRunning("DELETE_DATA", false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Result getTaskResult() {
        return this.taskResult;
    }
}
