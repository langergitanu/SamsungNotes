package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.DateTimeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDeleteMdeNote extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskDeleteNote");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        ComposerModel mComposerModel;
        Context mContext;

        public InputValues(Context context, ComposerModel composerModel) {
            this.mContext = context;
            this.mComposerModel = composerModel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMdeNote(Context context, ComposerModel composerModel) {
        if (composerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
            composerModel.getNotesDocEntityManager().setOnRemovedListener(null);
        }
        composerModel.setUpToFinishWithoutSave();
        composerModel.getMdeManager().deleteNote(context.getApplicationContext(), composerModel.getMdeInfo().getSpaceId(), composerModel.getDocState().getUuid());
        if (composerModel.getMdeManager().getMdeInfo().isStandAlone()) {
            String title = composerModel.getNotesDocEntityManager().getTitle();
            if (TextUtils.isEmpty(title)) {
                title = BaseUtils.getApplicationContext().getString(C9086R.string.coedit_note_auto_title, composerModel.getMdeInfo().getCreatorName(), DateTimeUtil.convertFormattedMMDD(context.getApplicationContext(), composerModel.getNotesDocEntityManager().getCreatedTime()));
            }
            composerModel.getMdeManager().deleteSpace(composerModel.getMdeInfo().getGroupId(), title);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToUpdate() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDeleteMdeNote.1
            @Override // java.lang.Runnable
            public void run() {
                TaskDeleteMdeNote taskDeleteMdeNote = TaskDeleteMdeNote.this;
                InputValues inputValues2 = inputValues;
                taskDeleteMdeNote.deleteMdeNote(inputValues2.mContext, inputValues2.mComposerModel);
                TaskDeleteMdeNote.this.getTaskCallback().onSuccess(new ResultValues());
            }
        });
    }
}
