package com.samsung.android.support.notes.bixby.bixby2.contract;

import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.aid.BixbySearchParam;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0007J1\u0010\b\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH&J.\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH&J.\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J$\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010%\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/contract/IBixby2ActionBackgound;", "", "isValidUUIDs", "", "noteIds", "", "", "([Ljava/lang/String;)Z", "deleteNotes", "", "asyncParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "successResponse", "Ljava/lang/Runnable;", "([Ljava/lang/String;Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;Ljava/lang/Runnable;)V", "searchNotes", "searchParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/BixbySearchParam;", "saveNotes", Bixby2Constants.BIXBY_PARAM_NOTE_TITLE, "content", "category", "updateNotes", "noteId", "searchFolders", "folderName", "deleteFolders", "folderIds", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;[Ljava/lang/String;)V", "createFolder", "updateFolder", "folderId", "getAppState", "isNoteEmpty", "showRecentNotes", "maxCount", "", "diagnoseTroubleShooting", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBixby2ActionBackgound {
    void createFolder(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String folderName);

    void deleteFolders(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String[] folderIds);

    void deleteNotes(@Nullable String[] noteIds, @NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable Runnable successResponse);

    void diagnoseTroubleShooting(@Nullable String category, @NotNull AbsBixby2Async.AsyncParam asyncParam);

    void getAppState(@NotNull AbsBixby2Async.AsyncParam asyncParam);

    void isNoteEmpty(@NotNull AbsBixby2Async.AsyncParam asyncParam);

    boolean isValidUUIDs(@Nullable String[] noteIds);

    void saveNotes(@Nullable String noteTitle, @Nullable String content, @Nullable String category, @NotNull AbsBixby2Async.AsyncParam asyncParam);

    void searchFolders(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String folderName);

    void searchNotes(@NotNull BixbySearchParam searchParam, @NotNull AbsBixby2Async.AsyncParam asyncParam);

    void showRecentNotes(int maxCount, @NotNull AbsBixby2Async.AsyncParam asyncParam);

    void updateFolder(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String folderId, @Nullable String folderName);

    void updateNotes(@Nullable String noteId, @Nullable String noteTitle, @Nullable String content, @NotNull AbsBixby2Async.AsyncParam asyncParam);
}
