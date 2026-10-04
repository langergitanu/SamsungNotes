package com.samsung.android.support.senl.p148nt.data.database.temp.domain.repository;

import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/temp/domain/repository/DeletedNoteRepository;", "", "insert", "", "deletedNote", "Lcom/samsung/android/support/senl/nt/data/database/temp/domain/model/DeletedNote;", OpenSessionApi.ITEM_LIMIT_DELETE, "filePath", "", "getDeletedNotes", "", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface DeletedNoteRepository {
    void delete(@NotNull String filePath);

    @NotNull
    List<DeletedNote> getDeletedNotes();

    void insert(@NotNull DeletedNote deletedNote);
}
