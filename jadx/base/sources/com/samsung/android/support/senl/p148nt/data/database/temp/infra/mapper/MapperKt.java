package com.samsung.android.support.senl.p148nt.data.database.temp.infra.mapper;

import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.entity.DeletedNoteEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, m13886d2 = {"toDomain", "Lcom/samsung/android/support/senl/nt/data/database/temp/domain/model/DeletedNote;", "Lcom/samsung/android/support/senl/nt/data/database/temp/infra/entity/DeletedNoteEntity;", "toEntity", "ntData_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MapperKt {
    @NotNull
    public static final DeletedNote toDomain(@NotNull DeletedNoteEntity deletedNoteEntity) {
        Intrinsics.checkNotNullParameter(deletedNoteEntity, "<this>");
        long id = deletedNoteEntity.getId();
        String uuid = deletedNoteEntity.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        String filePath = deletedNoteEntity.getFilePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        return new DeletedNote(id, uuid, filePath, deletedNoteEntity.getDeletedBy());
    }

    @NotNull
    public static final DeletedNoteEntity toEntity(@NotNull DeletedNote deletedNote) {
        Intrinsics.checkNotNullParameter(deletedNote, "<this>");
        DeletedNoteEntity deletedNoteEntity = new DeletedNoteEntity();
        deletedNoteEntity.setId(deletedNote.getId());
        deletedNoteEntity.setUuid(deletedNote.getUuid());
        deletedNoteEntity.setFilePath(deletedNote.getFilePath());
        deletedNoteEntity.setDeletedBy(deletedNote.getDeletedBy());
        return deletedNoteEntity;
    }
}
