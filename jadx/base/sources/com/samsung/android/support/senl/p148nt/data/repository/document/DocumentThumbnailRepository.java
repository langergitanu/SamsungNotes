package com.samsung.android.support.senl.p148nt.data.repository.document;

import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/repository/document/DocumentThumbnailRepository;", "", "<init>", "()V", "dao", "Lcom/samsung/android/support/senl/nt/data/database/core/document/dao/DocumentThumbnailDao;", "insert", "", "entity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/DocumentThumbnailEntity;", "entities", "", OpenSessionApi.ITEM_LIMIT_DELETE, "docUuids", "", "", "deleteDummy", "getEntity", "uuid", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocumentThumbnailRepository {

    @NotNull
    private static final String TAG;

    @NotNull
    private final DocumentThumbnailDao dao;

    static {
        String strCreateTag = DataLogger.createTag("DocumentThumbnailRepository");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public DocumentThumbnailRepository() {
        DocumentThumbnailDao documentThumbnailDao = NotesDatabaseManager.getInstance().getDocumentThumbnailDao();
        Intrinsics.checkNotNullExpressionValue(documentThumbnailDao, "getDocumentThumbnailDao(...)");
        this.dao = documentThumbnailDao;
    }

    public final void delete(@NotNull List<String> docUuids) {
        Intrinsics.checkNotNullParameter(docUuids, "docUuids");
        DataLogger.m12307i(TAG, "delete, size: " + docUuids.size());
        this.dao.delete((Collection<String>) docUuids);
    }

    public final void deleteDummy() {
        this.dao.deleteDummy();
    }

    @Nullable
    public final DocumentThumbnailEntity getEntity(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        AbstractC0000a.m2C("getEntity, uuid: ", uuid, TAG);
        return this.dao.getEntity(uuid);
    }

    public final void insert(@NotNull DocumentThumbnailEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        AbstractC0000a.m2C("insert, uuid: ", entity.getUuid(), TAG);
        this.dao.upsert(entity);
    }

    public final void insert(@NotNull Collection<DocumentThumbnailEntity> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        DataLogger.m12307i(TAG, "insert, uuid: " + entities.size());
        this.dao.upsert2(entities);
    }
}
