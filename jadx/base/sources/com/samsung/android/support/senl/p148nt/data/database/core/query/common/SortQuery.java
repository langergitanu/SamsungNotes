package com.samsung.android.support.senl.p148nt.data.database.core.query.common;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.provider.QueryCollatorNaturalCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SortType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SortQuery {
    private static final String TAG = DataLogger.createTag("SortQuery");

    private String createFirstOrder(SortParam sortParam) {
        return sortParam.getSortType() == 0 ? createTitleOrder(sortParam) : createOrderByQuery(sortParam.getSortType(), sortParam.getIsDesc());
    }

    private String createSecondaryOrder(SortParam sortParam) {
        if (sortParam.getSortType() == sortParam.getLastSortTimeType()) {
            return "";
        }
        return SQLKeyword.COMMA + getSortColumn(sortParam.getLastSortTimeType()) + ' ' + getSortLevel(sortParam.getLastIsDesc());
    }

    private String createTitleOrder(SortParam sortParam) {
        String str = getTableName() + Extension.DOT + (sortParam.getLastSortTimeType() == 1 ? getCreatedTimeColumn() : getLastModifiedTimeColumn());
        String str2 = getTableName() + Extension.DOT + getTitleColumn();
        String sqlCollatorString = new QueryCollatorNaturalCompat().getSqlCollatorString();
        StringBuilder sbM16m = AbstractC0000a.m16m(" ( case when ", str2, " is '' then 0 else 1 end ) desc, case when ", str2, " is '' then ");
        sbM16m.append(str);
        sbM16m.append(" end ");
        AbstractC2821a.m2207B(sbM16m, getSortLevel(sortParam.getLastIsDesc()), SQLKeyword.COMMA, str2, " COLLATE ");
        sbM16m.append(sqlCollatorString);
        sbM16m.append(" ");
        sbM16m.append(getSortLevel(sortParam.getIsDesc()));
        return sbM16m.toString();
    }

    private String getSortColumn(@SortType int i) {
        String lastModifiedTimeColumn = getLastModifiedTimeColumn();
        if (i == 0) {
            lastModifiedTimeColumn = getTitleColumn();
        } else if (i == 1) {
            lastModifiedTimeColumn = getCreatedTimeColumn();
        } else if (i == 2) {
            lastModifiedTimeColumn = getLastModifiedTimeColumn();
        } else if (i == 3) {
            lastModifiedTimeColumn = getRecycleBinMovedTimeColumn();
        } else if (i == 4) {
            lastModifiedTimeColumn = getLastOpenedTimeColumn();
        } else if (i == 5) {
            lastModifiedTimeColumn = getImportedTimeColumn();
        }
        DataLogger.m12302d(TAG, "getSortColumn, column : " + lastModifiedTimeColumn + ", sortType : " + i);
        return getTableName() + Extension.DOT + lastModifiedTimeColumn;
    }

    private String getSortLevel(boolean z) {
        return z ? "DESC" : "ASC";
    }

    public String createOrderByQuery(@SortType int i, boolean z) {
        return getSortColumn(i) + " " + getSortLevel(z);
    }

    public String createQuery(SortParam sortParam) {
        return createFirstOrder(sortParam) + createSecondaryOrder(sortParam);
    }

    public abstract String getCreatedTimeColumn();

    public abstract String getImportedTimeColumn();

    public abstract String getLastModifiedTimeColumn();

    public abstract String getLastOpenedTimeColumn();

    public abstract String getRecycleBinMovedTimeColumn();

    public abstract String getTableName();

    public abstract String getTitleColumn();
}
