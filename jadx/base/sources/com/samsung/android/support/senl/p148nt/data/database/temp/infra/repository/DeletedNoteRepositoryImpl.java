package com.samsung.android.support.senl.p148nt.data.database.temp.infra.repository;

import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.repository.DeletedNoteRepository;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.entity.DeletedNoteEntity;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.mapper.MapperKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/temp/infra/repository/DeletedNoteRepositoryImpl;", "Lcom/samsung/android/support/senl/nt/data/database/temp/domain/repository/DeletedNoteRepository;", "dao", "Lcom/samsung/android/support/senl/nt/data/database/temp/infra/dao/DeletedNoteDao;", "<init>", "(Lcom/samsung/android/support/senl/nt/data/database/temp/infra/dao/DeletedNoteDao;)V", "insert", "", "deletedNote", "Lcom/samsung/android/support/senl/nt/data/database/temp/domain/model/DeletedNote;", OpenSessionApi.ITEM_LIMIT_DELETE, "filePath", "", "getDeletedNotes", "", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDeletedNoteRepositoryImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeletedNoteRepositoryImpl.kt\ncom/samsung/android/support/senl/nt/data/database/temp/infra/repository/DeletedNoteRepositoryImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1563#2:32\n1634#2,3:33\n*S KotlinDebug\n*F\n+ 1 DeletedNoteRepositoryImpl.kt\ncom/samsung/android/support/senl/nt/data/database/temp/infra/repository/DeletedNoteRepositoryImpl\n*L\n24#1:32\n24#1:33,3\n*E\n"})
public final class DeletedNoteRepositoryImpl implements DeletedNoteRepository {
    private static final String TAG = DataLogger.createTag("DeletedNoteRepositoryImpl");

    @NotNull
    private final DeletedNoteDao dao;

    public DeletedNoteRepositoryImpl(@NotNull DeletedNoteDao dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.dao = dao;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.temp.domain.repository.DeletedNoteRepository
    public void delete(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        AbstractC0000a.m2C("delete, path: ", DataLogger.getEncode(filePath), TAG);
        this.dao.delete(filePath);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.temp.domain.repository.DeletedNoteRepository
    @NotNull
    public List<DeletedNote> getDeletedNotes() {
        DataLogger.m12307i(TAG, "getDeletedNotes");
        List<DeletedNoteEntity> entities = this.dao.getEntities();
        Intrinsics.checkNotNullExpressionValue(entities, "getEntities(...)");
        List<DeletedNoteEntity> list = entities;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        for (DeletedNoteEntity deletedNoteEntity : list) {
            Intrinsics.checkNotNull(deletedNoteEntity);
            arrayList.add(MapperKt.toDomain(deletedNoteEntity));
        }
        return CollectionsKt.toList(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.temp.domain.repository.DeletedNoteRepository
    public void insert(@NotNull DeletedNote deletedNote) {
        Intrinsics.checkNotNullParameter(deletedNote, "deletedNote");
        DataLogger.m12307i(TAG, "insert, uuid: " + deletedNote.getUuid() + ", path: " + DataLogger.getEncode(deletedNote.getFilePath()));
        this.dao.insert(MapperKt.toEntity(deletedNote));
    }
}
