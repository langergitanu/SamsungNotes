package com.samsung.android.support.senl.p148nt.model.domain.note;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MoveNoteToTrashUseCase {
    private static final String TAG = ModelLogger.createTag("MoveNoteToTrashUseCase");
    private final NotesDocumentRepository mRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private final Set<String> mDeletedNotes;

        public Result(Set<String> set) {
            HashSet hashSet = new HashSet();
            this.mDeletedNotes = hashSet;
            hashSet.addAll(set);
        }

        @NonNull
        public Set<String> getDeletedNotes() {
            return this.mDeletedNotes;
        }
    }

    public MoveNoteToTrashUseCase(NotesDocumentRepository notesDocumentRepository) {
        this.mRepository = notesDocumentRepository;
    }

    private List<String> getDeletableUuids(Collection<String> collection) {
        return this.mRepository.getUnlockedNormalNotes(collection);
    }

    @NonNull
    public Result execute(@NonNull Context context, @NonNull Collection<String> collection) {
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("DELETE_DATA", true);
        HashSet hashSet = new HashSet();
        List<String> deletableUuids = getDeletableUuids(collection);
        if (DocumentWriteResolver.delete(context, deletableUuids, 2, TAG)) {
            hashSet.addAll(deletableUuids);
        }
        companion.getInstance().setIsRunning("DELETE_DATA", false);
        return new Result(hashSet);
    }
}
