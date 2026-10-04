package com.samsung.android.support.senl.p148nt.model.repository.data.sticky;

import android.content.Context;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sticky.StickyNoteRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p193j4.C12937a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/repository/data/sticky/DocumentStickyRepository;", "Lcom/samsung/android/support/senl/nt/model/repository/data/sticky/StickyDataSource;", "<init>", "()V", "stickyMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/StickyNoteEntity;", "Lkotlin/collections/HashMap;", "isChanged", "", "getAllObjectIds", "", "get", "objectId", "insert", "", "entities", "load", Constants.ARG_UPDATE, "entity", OpenSessionApi.ITEM_LIMIT_DELETE, "deleteByPageId", "pageId", "save", "context", "Landroid/content/Context;", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDocumentStickyRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DocumentStickyRepository.kt\ncom/samsung/android/support/senl/nt/model/repository/data/sticky/DocumentStickyRepository\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n1869#2,2:70\n*S KotlinDebug\n*F\n+ 1 DocumentStickyRepository.kt\ncom/samsung/android/support/senl/nt/model/repository/data/sticky/DocumentStickyRepository\n*L\n27#1:70,2\n*E\n"})
public final class DocumentStickyRepository implements StickyDataSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;
    private boolean isChanged;

    @NotNull
    private final HashMap<String, StickyNoteEntity> stickyMap = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/repository/data/sticky/DocumentStickyRepository$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return DocumentStickyRepository.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = ModelLogger.createTag("DocumentStickyRepository");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteByPageId$lambda$1(String str, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return Intrinsics.areEqual(((StickyNoteEntity) entry.getValue()).getPageUuid(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteByPageId$lambda$2(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource
    public void delete(@NotNull String objectId) {
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        AbstractC11014a.m12334s("delete: ", objectId, TAG);
        this.stickyMap.remove(objectId);
        this.isChanged = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource
    public void deleteByPageId(@NotNull String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        AbstractC11014a.m12334s("deleteByPageId: ", pageId, TAG);
        this.stickyMap.entrySet().removeIf(new C7233a(new C12937a(pageId, 0), 5));
        this.isChanged = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource
    @Nullable
    public StickyNoteEntity get(@NotNull String objectId) {
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        return this.stickyMap.get(objectId);
    }

    @NotNull
    public final Collection<String> getAllObjectIds() {
        Set<String> setKeySet = this.stickyMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        return setKeySet;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource
    public void insert(@NotNull Collection<? extends StickyNoteEntity> entities, boolean load) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        DataLogger.m12302d(TAG, "insert, size: " + entities.size());
        if (entities.isEmpty()) {
            return;
        }
        for (StickyNoteEntity stickyNoteEntity : entities) {
            this.stickyMap.put(stickyNoteEntity.getObjectId(), stickyNoteEntity);
        }
        if (load) {
            return;
        }
        this.isChanged = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource
    /* JADX INFO: renamed from: isChanged, reason: from getter */
    public boolean getIsChanged() {
        return this.isChanged;
    }

    public final void save(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isChanged) {
            StickyNoteRepository stickyNoteRepositoryCreateStickyNoteRepository = NotesDataRepositoryFactory.newInstance(context).createStickyNoteRepository();
            Intrinsics.checkNotNullExpressionValue(stickyNoteRepositoryCreateStickyNoteRepository, "createStickyNoteRepository(...)");
            stickyNoteRepositoryCreateStickyNoteRepository.retainOnly(this.stickyMap);
            this.isChanged = false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource
    public void update(@NotNull StickyNoteEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        AbstractC11014a.m12334s("update: ", entity.getObjectId(), TAG);
        this.stickyMap.put(entity.getObjectId(), entity);
        this.isChanged = true;
    }
}
