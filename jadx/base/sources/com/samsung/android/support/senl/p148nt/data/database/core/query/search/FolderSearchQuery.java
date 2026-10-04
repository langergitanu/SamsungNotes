package com.samsung.android.support.senl.p148nt.data.database.core.query.search;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.FolderSearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderSearchQuery {
    private final FolderSearchParam mParam;

    public FolderSearchQuery(@NonNull FolderSearchParam folderSearchParam) {
        this.mParam = folderSearchParam;
    }

    @NonNull
    private String getExcludedFolderUuids() {
        return QueryUtils.getCommaSeparatedString(this.mParam.getExcludedFolders());
    }

    private String getInsideFolderQuery() {
        if (this.mParam.getTargetFolderUuid().isEmpty()) {
            return "";
        }
        return "category_tree.parentUUID = '" + this.mParam.getTargetFolderUuid() + "'";
    }

    public String getQuery(int i) {
        return new NotesSQLBuilder().select(this.mParam.getSelectOnlyUuid() ? "category_tree.UUID" : "category_tree.*").from(DBSchema.CategoryTree.TABLE_NAME).where(QueryConstants.USED_FOLDER_CONDITION).and(new SearchFilterQuery().getTimeFilterQuery(DBSchema.CategoryTree.TABLE_NAME, this.mParam.getFilterParam())).and("category_tree.UUID").notIn(getExcludedFolderUuids()).and("category_tree.parentUUID != 'old:///'").and(getInsideFolderQuery()).and(QueryUtils.getLikeSelection("category_tree.displayName", this.mParam.getWords())).limit(i).withDelimiter(this.mParam.getWithDelimiter()).build();
    }
}
