package com.samsung.android.support.senl.p148nt.model.domain.folder;

import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.repository.category.ParentFolderChecker;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.folder.FolderWriteResolver;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/folder/MoveFolderInTrashUseCase;", "", "folderManager", "Lcom/samsung/android/support/senl/nt/model/folder/FolderManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/model/folder/FolderManager;)V", "parentFolderChecker", "Lcom/samsung/android/support/senl/nt/data/repository/category/ParentFolderChecker;", "writeResolver", "Lcom/samsung/android/support/senl/nt/model/folder/FolderWriteResolver;", "execute", "", "uuids", "", "", "toParentUuid", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MoveFolderInTrashUseCase {

    @NotNull
    private static final String TAG;

    @NotNull
    private final ParentFolderChecker parentFolderChecker;

    @NotNull
    private final FolderWriteResolver writeResolver;

    static {
        String strCreateTag = ModelLogger.createTag("MoveFolderInTrashUseCase");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public MoveFolderInTrashUseCase(@NotNull FolderManager folderManager) {
        Intrinsics.checkNotNullParameter(folderManager, "folderManager");
        ParentFolderChecker parentFolderChecker = folderManager.getParentFolderChecker();
        Intrinsics.checkNotNullExpressionValue(parentFolderChecker, "getParentFolderChecker(...)");
        this.parentFolderChecker = parentFolderChecker;
        FolderWriteResolver writeResolver = folderManager.getWriteResolver();
        Intrinsics.checkNotNullExpressionValue(writeResolver, "getWriteResolver(...)");
        this.writeResolver = writeResolver;
    }

    public final boolean execute(@NotNull Collection<String> uuids, @NotNull String toParentUuid) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        Intrinsics.checkNotNullParameter(toParentUuid, "toParentUuid");
        try {
            if (!this.parentFolderChecker.isInvalidRelationShip(toParentUuid, uuids)) {
                this.writeResolver.moveInTrash(uuids, toParentUuid);
            }
            DataUpdateManager.INSTANCE.getInstance().onFolderUpdated();
            return true;
        } catch (InvalidParentFolderException e) {
            AbstractC11014a.m12314C("execute, e: ", e.getMessage(), TAG);
            return false;
        }
    }
}
