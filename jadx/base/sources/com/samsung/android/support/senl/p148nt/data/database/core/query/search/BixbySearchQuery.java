package com.samsung.android.support.senl.p148nt.data.database.core.query.search;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbySearchQuery {
    private final List<String> mCategoryUuids;
    private final SearchParam mParam;
    private final StringBuilder mSelectionBuilder = new StringBuilder();

    public BixbySearchQuery(List<String> list, SearchParam searchParam) {
        this.mCategoryUuids = list;
        this.mParam = searchParam;
    }

    private String createCategoryCondition(String str) {
        return AbstractC0541b.m773o("categoryUUID = '", str, "' ");
    }

    private String getCategoryCondition() {
        String lowerCase = this.mParam.getQueryFolderName().toLowerCase();
        if (lowerCase.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
        if (lowerCase.equals(predefinedCategory.getDisplayName().toLowerCase())) {
            sb.append(createCategoryCondition(predefinedCategory.getUuid()));
        } else {
            PredefinedCategory predefinedCategory2 = PredefinedCategory.SCREEN_OFF_MEMO;
            if (lowerCase.equals(predefinedCategory2.getDisplayName().toLowerCase())) {
                sb.append(createCategoryCondition(predefinedCategory2.getUuid()));
            } else {
                PredefinedCategory predefinedCategory3 = PredefinedCategory.MATH_NOTES;
                if (lowerCase.equals(predefinedCategory3.getDisplayName().toLowerCase())) {
                    sb.append(createCategoryCondition(predefinedCategory3.getUuid()));
                } else {
                    int size = this.mCategoryUuids.size();
                    int i = 0;
                    while (i < size) {
                        boolean z = i == size + (-1);
                        sb.append(createCategoryCondition(this.mCategoryUuids.get(i)));
                        sb.append(z ? "" : SQLKeyword.f7405OR);
                        i++;
                    }
                }
            }
        }
        return "(" + sb.toString() + PropertyUtils.MAPPED_DELIM2;
    }

    private String getFavoriteCondition() {
        if (this.mParam.isFavoriteNoteOnly()) {
            return (this.mSelectionBuilder.toString().isEmpty() ? "" : SQLKeyword.AND).concat("isFavorite = 1");
        }
        return "";
    }

    private String getLockCondition() {
        if (this.mParam.isLockedNoteOnly()) {
            return (this.mSelectionBuilder.toString().isEmpty() ? "" : SQLKeyword.AND).concat(QueryConstants.LOCKED_CONDITION);
        }
        return "";
    }

    @NonNull
    public String createSelection() {
        StringBuilder sb = this.mSelectionBuilder;
        sb.append(getCategoryCondition());
        sb.append(getFavoriteCondition());
        sb.append(getLockCondition());
        return sb.toString();
    }
}
