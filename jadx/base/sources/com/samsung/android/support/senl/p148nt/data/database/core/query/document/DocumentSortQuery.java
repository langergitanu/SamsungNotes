package com.samsung.android.support.senl.p148nt.data.database.core.query.document;

import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentSortQuery extends SortQuery {
    private String getPinFavoriteQuery() {
        return " ( case when " + getTableName() + ".isFavorite is 0 then 0 else 1 end ) desc, ";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String createQuery(@NonNull SortParam sortParam) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(sortParam.getIsPinFavorite() ? getPinFavoriteQuery() : "");
        sbM1324q.append(super.createQuery(sortParam));
        return sbM1324q.toString();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getCreatedTimeColumn() {
        return "createdAt";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getImportedTimeColumn() {
        return "importedAt";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getLastModifiedTimeColumn() {
        return "lastModifiedAt";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getLastOpenedTimeColumn() {
        return "lastOpenedAt";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getRecycleBinMovedTimeColumn() {
        return "recycle_bin_time_moved";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getTableName() {
        return "sdoc";
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.common.SortQuery
    public String getTitleColumn() {
        return "title";
    }
}
