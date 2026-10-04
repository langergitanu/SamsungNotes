package com.samsung.android.support.senl.p148nt.app.main.noteslist.task;

import android.app.Activity;
import android.util.Pair;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesRecycleBinRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p014C3.RunnableC0054a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u0000 \"24\u00120\u0012.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ>\u0010\u0013\u001a\u00020\u001424\u0010\u0015\u001a0\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0018\u00010\u0002H\u0016J8\u0010\u0016\u001a\u00020\u00142\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/DeleteTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Landroid/util/Pair;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "modeIndex", "", "<init>", "(Landroid/app/Activity;I)V", "getModeIndex", "()I", "result", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/DeleteTask$Result;", "isDeletePermanently", "", "isRecycleBinDisabled", "execute", "", "taskParams", OpenSessionApi.ITEM_LIMIT_DELETE, "noteList", "folderList", "getDeleteNotesUuids", "", "arrayList", "getDeleteFoldersUuids", "", "getFoldersOpenedByComposer", "getTag", "getResult", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeleteTask extends WorkerTask<Pair<ArrayList<String>, ArrayList<String>>> {

    @NotNull
    public static final String TAG = "DeleteTask";
    private final boolean isDeletePermanently;
    private boolean isRecycleBinDisabled;
    private final int modeIndex;

    @NotNull
    private final Result result;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/DeleteTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "mHasOpenedNote", "", "tag", "", "getTag", "()Ljava/lang/String;", "value", "hasOpenedNote", "getHasOpenedNote", "()Z", "setHasOpenedNote", "(Z)V", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private final int hashCode;
        private boolean mHasOpenedNote;

        public Result(int i) {
            this.hashCode = i;
        }

        /* JADX INFO: renamed from: getHasOpenedNote, reason: from getter */
        public final boolean getMHasOpenedNote() {
            return this.mHasOpenedNote;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return DeleteTask.TAG;
        }

        public final void setHasOpenedNote(boolean z) {
            this.mHasOpenedNote = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeleteTask(@NotNull Activity activity, int i) {
        super(activity.hashCode(), null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.modeIndex = i;
        this.result = new Result(getHashCode());
        this.isDeletePermanently = NotesUtils.isNeedToDeletePermanently(i);
        this.isRecycleBinDisabled = FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel();
    }

    private final void delete(ArrayList<String> noteList, ArrayList<String> folderList) {
        List<String> deleteNotesUuids = getDeleteNotesUuids(noteList);
        Set<String> deleteFoldersUuids = getDeleteFoldersUuids(folderList);
        if (!this.isDeletePermanently) {
            DocumentWriteResolver.delete(BaseUtils.getContext().getApplicationContext(), deleteNotesUuids, 2, TAG);
            FolderManager.getInstance().moveToRecycleBin(FolderManager.getInstance().getAllDocumentCategoryTree(false), deleteFoldersUuids);
            return;
        }
        if (this.isRecycleBinDisabled || FeatureUtils.isOldMode(this.modeIndex)) {
            MainLogger.m7257f(TAG, "#delete, doc: " + deleteNotesUuids.size() + ", folder: " + deleteFoldersUuids.size());
            DocumentWriteResolver.delete(BaseUtils.getContext().getApplicationContext(), deleteNotesUuids, 1, TAG);
            FolderManager.getInstance().deleteByUuid(deleteFoldersUuids);
            return;
        }
        NotesRecycleBinRepository notesRecycleBinRepositoryCreateNotesRecycleBinRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext().getApplicationContext()).createNotesRecycleBinRepository();
        Intrinsics.checkNotNullExpressionValue(notesRecycleBinRepositoryCreateNotesRecycleBinRepository, "createNotesRecycleBinRepository(...)");
        List<String> documentsInRecycleBin = notesRecycleBinRepositoryCreateNotesRecycleBinRepository.getDocumentsInRecycleBin(deleteNotesUuids);
        List<String> foldersInRecycleBin = notesRecycleBinRepositoryCreateNotesRecycleBinRepository.getFoldersInRecycleBin(deleteFoldersUuids);
        int size = deleteNotesUuids.size();
        int size2 = documentsInRecycleBin.size();
        int size3 = deleteFoldersUuids.size();
        int size4 = foldersInRecycleBin.size();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(size, size2, "#delete, request/result, doc: ", "/", ", folder: ");
        sbM1173s.append(size3);
        sbM1173s.append("/");
        sbM1173s.append(size4);
        MainLogger.m7257f(TAG, sbM1173s.toString());
        DocumentWriteResolver.delete(BaseUtils.getContext().getApplicationContext(), documentsInRecycleBin, 1, TAG);
        FolderManager.getInstance().deleteByUuid(foldersInRecycleBin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(DeleteTask deleteTask, Pair pair) {
        Object first = pair.first;
        Intrinsics.checkNotNullExpressionValue(first, "first");
        Object second = pair.second;
        Intrinsics.checkNotNullExpressionValue(second, "second");
        deleteTask.delete((ArrayList) first, (ArrayList) second);
    }

    private final Set<String> getDeleteFoldersUuids(ArrayList<String> arrayList) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(arrayList);
        HashSet hashSet = new HashSet(copyOnWriteArraySet);
        NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext().getApplicationContext()).createCategoryTreeClosureRepository();
        Intrinsics.checkNotNullExpressionValue(notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository, "createCategoryTreeClosureRepository(...)");
        HashSet hashSet2 = new HashSet();
        Iterator<String> it = getFoldersOpenedByComposer().iterator();
        while (it.hasNext()) {
            Collection<String> foldersWithRelationShip = notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository.getFoldersWithRelationShip(copyOnWriteArraySet, it.next());
            Intrinsics.checkNotNullExpressionValue(foldersWithRelationShip, "getFoldersWithRelationShip(...)");
            hashSet2.addAll(foldersWithRelationShip);
        }
        if (!hashSet2.isEmpty()) {
            this.result.setHasOpenedNote(true);
        }
        hashSet.removeAll(hashSet2);
        return hashSet;
    }

    private final List<String> getDeleteNotesUuids(ArrayList<String> arrayList) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (String str : copyOnWriteArrayList) {
            if (ComposerManager.INSTANCE.getInstance().isOpen(str, null)) {
                this.result.setHasOpenedNote(true);
            } else {
                arrayList2.add(str);
            }
        }
        return arrayList2;
    }

    private final Set<String> getFoldersOpenedByComposer() {
        return ComposerManager.INSTANCE.getInstance().getFolderIdsInUse();
    }

    public final int getModeIndex() {
        return this.modeIndex;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Pair<ArrayList<String>, ArrayList<String>> taskParams) {
        if (taskParams == null) {
            return;
        }
        MainLogger.m7258i(TAG, "execute start isDeletePermanently : " + this.isDeletePermanently + ", isRecycleBinDisabled : " + this.isRecycleBinDisabled);
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("DELETE_DATA", true);
        this.result.setHasOpenedNote(false);
        FolderManager.getInstance().executeOperation(new RunnableC0054a(this, taskParams, 2));
        companion.getInstance().setIsRunning("DELETE_DATA", false);
        MainLogger.m7258i(TAG, "doInBackground end");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public Result getResult() {
        return this.result;
    }
}
