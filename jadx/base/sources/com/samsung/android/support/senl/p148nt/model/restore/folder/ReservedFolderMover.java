package com.samsung.android.support.senl.p148nt.model.restore.folder;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.model.domain.folder.AddFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.folder.MoveFolderInTrashUseCase;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u000f\u001a\u00020\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/restore/folder/ReservedFolderMover;", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "execute", "", "fixRestorePath", "reservedFolder", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesCategoryTreeEntity;", "insertClonedFolder", "", "clonedFolderUuid", "", "moveChildrenToClonedFolder", "children", "", "toFolderUuid", "inUsed", "moveReservedFolder", "restoreFolderDao", "Lcom/samsung/android/support/senl/nt/data/database/core/document/dao/RestoreFolderDao;", "documentDao", "Lcom/samsung/android/support/senl/nt/data/database/core/document/dao/NotesDocumentDao;", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ReservedFolderMover {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ReservedFolderMover";

    @NotNull
    private final Context appContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/restore/folder/ReservedFolderMover$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getPureDisplayName", "reservedFolderUuid", "folderEntry", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesCategoryTreeEntity;", "createClonedFolder", "clonedFolderUuid", "invalidFolder", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getPureDisplayName(String reservedFolderUuid, NotesCategoryTreeEntity folderEntry) {
            String pureDisplayName;
            PredefinedCategory predefinedCategoryFind = PredefinedCategory.find(reservedFolderUuid);
            if (predefinedCategoryFind == null) {
                DataLogger.m12303e(ReservedFolderMover.TAG, "getPureDisplayName() : " + reservedFolderUuid + " is not founded!");
                String displayName = folderEntry.getDisplayName();
                Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
                pureDisplayName = UnicodeUtils.removeUnicode(displayName, "\u200b");
            } else if (TextUtils.isEmpty(predefinedCategoryFind.getPureDisplayName())) {
                DataLogger.m12303e(ReservedFolderMover.TAG, "getPureDisplayName() : the display name " + reservedFolderUuid + " is empty!");
                pureDisplayName = "Unknown";
            } else {
                pureDisplayName = predefinedCategoryFind.getPureDisplayName();
                Intrinsics.checkNotNullExpressionValue(pureDisplayName, "getPureDisplayName(...)");
            }
            DataLogger.m12302d(ReservedFolderMover.TAG, "getPureDisplayName(): " + DataLogger.getEncode(pureDisplayName) + "/ len: " + pureDisplayName.length());
            return pureDisplayName;
        }

        @NotNull
        public final NotesCategoryTreeEntity createClonedFolder(@NotNull String clonedFolderUuid, @NotNull NotesCategoryTreeEntity invalidFolder) {
            Intrinsics.checkNotNullParameter(clonedFolderUuid, "clonedFolderUuid");
            Intrinsics.checkNotNullParameter(invalidFolder, "invalidFolder");
            String parentUuid = invalidFolder.getParentUuid();
            String uuid = invalidFolder.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            String pureDisplayName = getPureDisplayName(uuid, invalidFolder);
            String restorePath = invalidFolder.getRestorePath();
            Intrinsics.checkNotNullExpressionValue(restorePath, "getRestorePath(...)");
            NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(clonedFolderUuid, parentUuid, pureDisplayName, UnicodeUtils.removeUnicode(restorePath, "\u200b"));
            notesCategoryTreeEntity.setIsDirty(1);
            notesCategoryTreeEntity.setIsDeleted(invalidFolder.getIsDeleted());
            notesCategoryTreeEntity.setRecycleBinTimeMoved(invalidFolder.getRecycleBinTimeMoved());
            notesCategoryTreeEntity.setCreatedAt(invalidFolder.getCreatedAt());
            notesCategoryTreeEntity.setLastModifiedAt(invalidFolder.getLastModifiedAt());
            notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(invalidFolder.getServerTimeStamp().longValue() + 1));
            notesCategoryTreeEntity.setReorder(invalidFolder.getReorder());
            return notesCategoryTreeEntity;
        }

        private Companion() {
        }
    }

    public ReservedFolderMover(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(ReservedFolderMover reservedFolderMover) {
        RestoreFolderDao restoreFolderDao = NotesDatabaseManager.getInstance().getRestoreFolderDao();
        List<NotesCategoryTreeEntity> invalidReservedFolders = restoreFolderDao.getInvalidReservedFolders();
        DataLogger.m12307i(TAG, "execute, invalidReservedFolders: " + invalidReservedFolders.size());
        if (invalidReservedFolders.isEmpty()) {
            return;
        }
        NotesDocumentDao documentDao = NotesDatabaseManager.getInstance().getDocumentDao();
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : invalidReservedFolders) {
            boolean z = notesCategoryTreeEntity.getIsDeleted() == 0;
            if (!z) {
                restoreFolderDao.fixRestorePath(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getDisplayName(), File.separator + notesCategoryTreeEntity.getDisplayName());
            }
            List<String> childrenUuids = FolderManager.getInstance().getChildrenUuids(notesCategoryTreeEntity.getUuid());
            Intrinsics.checkNotNullExpressionValue(childrenUuids, "getChildrenUuids(...)");
            try {
                if (childrenUuids.isEmpty()) {
                    Intrinsics.checkNotNull(notesCategoryTreeEntity);
                    Intrinsics.checkNotNull(restoreFolderDao);
                    Intrinsics.checkNotNull(documentDao);
                    reservedFolderMover.moveReservedFolder(notesCategoryTreeEntity, restoreFolderDao, documentDao);
                } else {
                    Intrinsics.checkNotNull(notesCategoryTreeEntity);
                    reservedFolderMover.fixRestorePath(notesCategoryTreeEntity);
                    String strNewUUID = UUIDUtils.newUUID(reservedFolderMover.appContext);
                    if (reservedFolderMover.insertClonedFolder(strNewUUID, notesCategoryTreeEntity)) {
                        reservedFolderMover.moveChildrenToClonedFolder(childrenUuids, strNewUUID, z);
                        Intrinsics.checkNotNull(restoreFolderDao);
                        Intrinsics.checkNotNull(documentDao);
                        reservedFolderMover.moveReservedFolder(notesCategoryTreeEntity, restoreFolderDao, documentDao);
                    } else {
                        DataLogger.m12309w(TAG, "execute, fail to insert cloned folder");
                    }
                }
            } catch (InvalidParentFolderException e) {
                AbstractC11014a.m12314C("execute, e: ", e.getMessage(), TAG);
            }
        }
    }

    private final void fixRestorePath(NotesCategoryTreeEntity reservedFolder) {
        String restorePath;
        if (reservedFolder.getIsDeleted() == 2 && (restorePath = reservedFolder.getRestorePath()) != null) {
            String strM756B = AbstractC0541b.m756B(File.separator, reservedFolder.getDisplayName());
            if (StringsKt.m14162r(restorePath, strM756B)) {
                return;
            }
            String displayName = reservedFolder.getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
            if (StringsKt.m14162r(restorePath, displayName)) {
                String displayName2 = reservedFolder.getDisplayName();
                Intrinsics.checkNotNullExpressionValue(displayName2, "getDisplayName(...)");
                String strM14139M = StringsKt.m14139M(restorePath, displayName2, strM756B);
                reservedFolder.setRestorePath(strM14139M);
                DataLogger.m12302d(TAG, "fixRestorePath: " + DataLogger.getEncode(reservedFolder.getDisplayName()) + " to " + DataLogger.getEncode(strM14139M));
            }
        }
    }

    private final boolean insertClonedFolder(String clonedFolderUuid, NotesCategoryTreeEntity reservedFolder) {
        return new AddFolderUseCase().setInTrash().execute(INSTANCE.createClonedFolder(clonedFolderUuid, reservedFolder));
    }

    private final void moveChildrenToClonedFolder(List<String> children, String toFolderUuid, boolean inUsed) {
        if (children.isEmpty()) {
            return;
        }
        if (inUsed) {
            FolderManager.getInstance().move(children, toFolderUuid);
            return;
        }
        FolderManager folderManager = FolderManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(folderManager, "getInstance(...)");
        new MoveFolderInTrashUseCase(folderManager).execute(children, toFolderUuid);
    }

    private final void moveReservedFolder(NotesCategoryTreeEntity reservedFolder, RestoreFolderDao restoreFolderDao, NotesDocumentDao documentDao) {
        if (Intrinsics.areEqual("uncategorized:///", reservedFolder.getParentUuid())) {
            return;
        }
        if (reservedFolder.getIsDeleted() == 0) {
            FolderManager.getInstance().move(reservedFolder.getUuid(), "uncategorized:///");
            return;
        }
        if (reservedFolder.getIsDeleted() == 2) {
            if (!Intrinsics.areEqual("trash:///", reservedFolder.getParentUuid())) {
                FolderManager folderManager = FolderManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(folderManager, "getInstance(...)");
                new MoveFolderInTrashUseCase(folderManager).execute(CollectionsKt.listOf(reservedFolder.getUuid()), "trash:///");
            }
            restoreFolderDao.restoreReservedFolder(reservedFolder.getUuid(), documentDao);
        }
    }

    public final void execute() {
        FolderManager.getInstance().executeOperation(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.restore.folder.d
            @Override // java.lang.Runnable
            public final void run() {
                ReservedFolderMover.execute$lambda$0(this.f7756a);
            }
        });
    }
}
