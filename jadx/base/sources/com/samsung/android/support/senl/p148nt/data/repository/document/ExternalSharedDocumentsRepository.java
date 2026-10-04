package com.samsung.android.support.senl.p148nt.data.repository.document;

import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.ExternalSharedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.ExternalSharedDocumentEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0014\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/repository/document/ExternalSharedDocumentsRepository;", "", "<init>", "()V", "dao", "Lcom/samsung/android/support/senl/nt/data/database/core/document/dao/ExternalSharedDocumentDao;", "getEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/ExternalSharedDocumentEntity;", "uuid", "", "insert", "", "entity", OpenSessionApi.ITEM_LIMIT_DELETE, "docUuids", "", "deleteDummy", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ExternalSharedDocumentsRepository {

    @NotNull
    private static final String TAG;

    @NotNull
    private final ExternalSharedDocumentDao dao;

    static {
        String strCreateTag = DataLogger.createTag("ExternalSharedDocumentsRepository");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public ExternalSharedDocumentsRepository() {
        ExternalSharedDocumentDao externalSharedDocumentDao = NotesDatabaseManager.getInstance().getExternalSharedDocumentDao();
        Intrinsics.checkNotNullExpressionValue(externalSharedDocumentDao, "getExternalSharedDocumentDao(...)");
        this.dao = externalSharedDocumentDao;
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
    public final ExternalSharedDocumentEntity getEntity(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        AbstractC0000a.m2C("getEntity, uuid: ", uuid, TAG);
        return this.dao.getEntity(uuid);
    }

    public final void insert(@NotNull ExternalSharedDocumentEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        AbstractC0000a.m2C("insert, uuid: ", entity.getUuid(), TAG);
        this.dao.upsert(entity);
    }
}
