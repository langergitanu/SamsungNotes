package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/utils/DocumentRestoreUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "createCopyAndMoveToTrash", "", "context", "Landroid/content/Context;", "uuid", "importFileToTrash", "", "path", "prevEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "repository", "Lcom/samsung/android/support/senl/nt/data/repository/document/NotesDocumentRepository;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocumentRestoreUtils {

    @NotNull
    public static final DocumentRestoreUtils INSTANCE = new DocumentRestoreUtils();

    @NotNull
    private static final String TAG = "DocumentRestoreUtils";

    private DocumentRestoreUtils() {
    }

    @JvmStatic
    public static final boolean createCopyAndMoveToTrash(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(uuid);
        if (notesDocumentEntity == null) {
            AbstractC11014a.m12314C("createCopyAndMoveToTrash, note not exist: ", uuid, TAG);
            return false;
        }
        String filePath = notesDocumentEntity.getFilePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(context, ".sdocx");
        Intrinsics.checkNotNullExpressionValue(strCreateSavedPath, "createSavedPath(...)");
        try {
            FileUtils.copyDirectory(new File(filePath), new File(strCreateSavedPath));
            DocumentRestoreUtils documentRestoreUtils = INSTANCE;
            String strNewUUID = UUIDUtils.newUUID(context);
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository2 = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository2, "createDocumentDataRepository(...)");
            documentRestoreUtils.importFileToTrash(strNewUUID, strCreateSavedPath, notesDocumentEntity, notesDocumentRepositoryCreateDocumentDataRepository2);
            return true;
        } catch (IOException e) {
            AbstractC11014a.m12314C("createCopyAndMoveToTrash, e: ", e.getMessage(), TAG);
            return false;
        }
    }

    private final void importFileToTrash(String uuid, String path, NotesDocumentEntity prevEntity, NotesDocumentRepository repository) {
        NotesDocumentEntity notesDocumentEntityMo22193clone = prevEntity.mo22193clone();
        Intrinsics.checkNotNullExpressionValue(notesDocumentEntityMo22193clone, "clone(...)");
        notesDocumentEntityMo22193clone.setId(null);
        notesDocumentEntityMo22193clone.setUuid(uuid);
        notesDocumentEntityMo22193clone.setFilePath(path);
        notesDocumentEntityMo22193clone.setIsDeleted(2);
        notesDocumentEntityMo22193clone.setCategoryUuid("trash:///");
        notesDocumentEntityMo22193clone.setAbsolutePath(PredefinedCategory.UNCATEGORIZED.getPath());
        notesDocumentEntityMo22193clone.setRecycleBinTimeMoved(System.currentTimeMillis());
        notesDocumentEntityMo22193clone.setIsDirty(0);
        notesDocumentEntityMo22193clone.setCategoryIsDirty(0);
        repository.insert(notesDocumentEntityMo22193clone);
    }
}
