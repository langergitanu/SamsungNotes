package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH\u0007J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH\u0007J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH\u0007J5\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0013\"\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0013H\u0007¢\u0006\u0002\u0010\u0015J-\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0013\"\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\u001e\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getNoteEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "context", "Landroid/content/Context;", "uuid", "getUnLockedEntities", "", "docUuids", "getLockedEntitiesWithExcludeTypes", "countLegacyNotes", "", "uuids", "excludeLegacyNote", "", "uuidList", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "excludeUnlockedNote", "excludeNotOwnerNote", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyUtils$OwnerNotes;", "(Landroid/content/Context;[Ljava/lang/String;)Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyUtils$OwnerNotes;", "isNoteOwner", "", "userGUID", "updateDocumentGUID", "", "guid", "filePath", "getNoteEntityNotOwner", "OwnerNotes", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLockManagerStrategyUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockManagerStrategyUtils.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,209:1\n37#2:210\n36#2,3:211\n37#2:214\n36#2,3:215\n*S KotlinDebug\n*F\n+ 1 LockManagerStrategyUtils.kt\ncom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyUtils\n*L\n59#1:210\n59#1:211,3\n68#1:214\n68#1:215,3\n*E\n"})
public final class LockManagerStrategyUtils {

    @NotNull
    public static final LockManagerStrategyUtils INSTANCE = new LockManagerStrategyUtils();

    @NotNull
    private static final String TAG = LockLogger.createTag("LockManagerStrategyUtils");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\nR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategyUtils$OwnerNotes;", "", "<init>", "()V", "mResult", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "clear", "", "addOwnerNote", "uuid", "failCode", "changeOwnerNoteToInvalid", "validNote", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getValidNote", "()Ljava/util/ArrayList;", "hasInvalidNote", "", "print", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class OwnerNotes {

        @NotNull
        private final HashMap<String, Integer> mResult = new HashMap<>();

        public final void addOwnerNote(@NotNull String uuid, int failCode) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.mResult.put(uuid, Integer.valueOf(failCode));
        }

        public final void changeOwnerNoteToInvalid(@NotNull String uuid, int failCode) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.mResult.replace(uuid, Integer.valueOf(failCode));
        }

        public final void clear() {
            this.mResult.clear();
        }

        @NotNull
        public final ArrayList<String> getValidNote() {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : this.mResult.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue().intValue() == -1) {
                    arrayList.add(key);
                }
            }
            return arrayList;
        }

        public final boolean hasInvalidNote() {
            Iterator<Map.Entry<String, Integer>> it = this.mResult.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().intValue() != -1) {
                    return true;
                }
            }
            return false;
        }

        public final void print() {
            LockLogger.m7356d(LockManagerStrategyUtils.TAG, "OwnerNotes# size : " + this.mResult.size());
            for (Map.Entry<String, Integer> entry : this.mResult.entrySet()) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                LockLogger.m7356d(LockManagerStrategyUtils.TAG, "OwnerNotes# key/value : " + key + "/" + iIntValue);
            }
        }
    }

    private LockManagerStrategyUtils() {
    }

    @JvmStatic
    public static final int countLegacyNotes(@NotNull Context context, @Nullable List<String> uuids) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uuids != null) {
            return NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockNoteCount(uuids, LockUtils.sLegacyLockTypes);
        }
        return 0;
    }

    @JvmStatic
    @NotNull
    public static final String[] excludeLegacyNote(@NotNull Context context, @NotNull String... uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        List<String> lockedNoteUuidsWithExcludeTypes = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockedNoteUuidsWithExcludeTypes(CollectionsKt.listOf(Arrays.copyOf(uuidList, uuidList.length)), LockUtils.sLegacyLockTypes);
        Intrinsics.checkNotNull(lockedNoteUuidsWithExcludeTypes);
        return (String[]) lockedNoteUuidsWithExcludeTypes.toArray(new String[0]);
    }

    @JvmStatic
    @NotNull
    public static final OwnerNotes excludeNotOwnerNote(@NotNull Context context, @NotNull String... uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        OwnerNotes ownerNotes = new OwnerNotes();
        ArrayList arrayList = new ArrayList();
        List<NotesDocumentEntity> entitiesByUuids = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getEntitiesByUuids(CollectionsKt.listOf(Arrays.copyOf(uuidList, uuidList.length)));
        String strM14294h = C13541h.m14287e().m14294h();
        String localUserID = LockPrefUtils.getLocalUserID(context);
        String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        for (NotesDocumentEntity notesDocumentEntity : entitiesByUuids) {
            if (LockUtils.isUnLockedDocType(notesDocumentEntity.getIsLock())) {
                String uuid = notesDocumentEntity.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
                ownerNotes.addOwnerNote(uuid, -1);
            } else if (localUserID != null && LockUtils.isNoteOwner(notesDocumentEntity.getLockAccountGuid(), strM14294h, localUserID, str) == 1) {
                Intrinsics.checkNotNull(notesDocumentEntity);
                arrayList.add(notesDocumentEntity);
                String uuid2 = notesDocumentEntity.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                ownerNotes.addOwnerNote(uuid2, -1);
            }
        }
        Iterator<NotesDocumentEntity> it = DocumentLockResolver.changeAccountGUIDs(context, arrayList, strM14294h).iterator();
        while (it.hasNext()) {
            String uuid3 = it.next().getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid3, "getUuid(...)");
            ownerNotes.changeOwnerNoteToInvalid(uuid3, 11);
        }
        ownerNotes.print();
        return ownerNotes;
    }

    @JvmStatic
    @NotNull
    public static final String[] excludeUnlockedNote(@NotNull Context context, @NotNull String[] uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        List<String> lockedNoteUuidsWithExcludeTypes = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockedNoteUuidsWithExcludeTypes(CollectionsKt.listOf(Arrays.copyOf(uuidList, uuidList.length)), LockUtils.getUnlockedDocTypes());
        Intrinsics.checkNotNull(lockedNoteUuidsWithExcludeTypes);
        return (String[]) lockedNoteUuidsWithExcludeTypes.toArray(new String[0]);
    }

    @JvmStatic
    @NotNull
    public static final List<NotesDocumentEntity> getLockedEntitiesWithExcludeTypes(@NotNull Context context, @Nullable List<String> docUuids) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (docUuids == null) {
            return CollectionsKt.emptyList();
        }
        List<NotesDocumentEntity> lockedEntitiesWithExcludeTypes = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockedEntitiesWithExcludeTypes(docUuids, LockUtils.getUnlockedDocTypes());
        Intrinsics.checkNotNull(lockedEntitiesWithExcludeTypes);
        return lockedEntitiesWithExcludeTypes;
    }

    @JvmStatic
    @NotNull
    public static final NotesDocumentEntity getNoteEntity(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(uuid);
        Intrinsics.checkNotNullExpressionValue(notesDocumentEntity, "get(...)");
        return notesDocumentEntity;
    }

    @JvmStatic
    @Nullable
    public static final NotesDocumentEntity getNoteEntityNotOwner(@Nullable Context context, @Nullable String uuid) {
        NotesDocumentEntity notesDocumentEntityM9f;
        if (context == null || uuid == null || (notesDocumentEntityM9f = AbstractC0000a.m9f(context, uuid)) == null || LockUtils.isUnLockedDocType(notesDocumentEntityM9f.getIsLock())) {
            return null;
        }
        String lockAccountGuid = notesDocumentEntityM9f.getLockAccountGuid();
        String strM14294h = C13541h.m14287e().m14294h();
        String localUserID = LockPrefUtils.getLocalUserID(context);
        String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        if (localUserID == null || LockUtils.isNoteOwner(lockAccountGuid, strM14294h, localUserID, str) == 1) {
            return null;
        }
        return notesDocumentEntityM9f;
    }

    @JvmStatic
    @NotNull
    public static final List<NotesDocumentEntity> getUnLockedEntities(@NotNull Context context, @Nullable List<String> docUuids) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (docUuids == null) {
            return CollectionsKt.emptyList();
        }
        List<NotesDocumentEntity> entities = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getEntities(docUuids, LockUtils.getUnlockedDocTypes());
        Intrinsics.checkNotNullExpressionValue(entities, "getEntities(...)");
        return entities;
    }

    @JvmStatic
    public static final boolean isNoteOwner(@NotNull Context context, @NotNull String uuid, @Nullable String userGUID) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(uuid);
        if (notesDocumentEntity == null) {
            return false;
        }
        if (LockUtils.isUnLockedDocType(notesDocumentEntity.getIsLock())) {
            return true;
        }
        String lockAccountGuid = notesDocumentEntity.getLockAccountGuid();
        if (userGUID == null) {
            String strM14294h = C13541h.m14287e().m14294h();
            String localUserID = LockPrefUtils.getLocalUserID(context);
            String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
            if (localUserID != null && LockUtils.isNoteOwner(lockAccountGuid, strM14294h, localUserID, str) == 1) {
                LockManagerStrategyUtils lockManagerStrategyUtils = INSTANCE;
                Intrinsics.checkNotNull(strM14294h);
                String filePath = notesDocumentEntity.getFilePath();
                Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
                lockManagerStrategyUtils.updateDocumentGUID(context, uuid, strM14294h, filePath);
                return true;
            }
        } else if (LockUtils.isNoteOwner(lockAccountGuid, userGUID) == 1) {
            LockManagerStrategyUtils lockManagerStrategyUtils2 = INSTANCE;
            String filePath2 = notesDocumentEntity.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath2, "getFilePath(...)");
            lockManagerStrategyUtils2.updateDocumentGUID(context, uuid, userGUID, filePath2);
            return true;
        }
        return false;
    }

    private final void updateDocumentGUID(Context context, String uuid, String guid, String filePath) {
        LockLogger.m7356d(TAG, "updateDocumentGUID# uuid:" + uuid);
        DocumentLockResolver.changeAccountGuidByUuid(context, uuid, guid, filePath);
    }
}
