package com.samsung.android.support.senl.p148nt.model.repository.data.sticky;

import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/repository/data/sticky/StickyDataSource;", "", "get", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/StickyNoteEntity;", "objectId", "", "insert", "", "entities", "", "load", "", Constants.ARG_UPDATE, "entity", OpenSessionApi.ITEM_LIMIT_DELETE, "deleteByPageId", "pageId", "isChanged", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface StickyDataSource {
    void delete(@NotNull String objectId);

    void deleteByPageId(@NotNull String pageId);

    @Nullable
    StickyNoteEntity get(@NotNull String objectId);

    void insert(@NotNull Collection<? extends StickyNoteEntity> entities, boolean load);

    /* JADX INFO: renamed from: isChanged */
    boolean getIsChanged();

    void update(@NotNull StickyNoteEntity entity);
}
