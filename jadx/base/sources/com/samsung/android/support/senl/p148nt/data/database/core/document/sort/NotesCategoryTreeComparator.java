package com.samsung.android.support.senl.p148nt.data.database.core.document.sort;

import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesCategoryTreeComparator implements Comparator<FolderSortData> {
    private SortParam mSortParam;

    private int predefinedSort(FolderSortData folderSortData, FolderSortData folderSortData2) {
        PredefinedCategory predefinedCategory = PredefinedCategory.SCREEN_OFF_MEMO;
        if (predefinedCategory.getUuid().equals(folderSortData.getUuid())) {
            return 1;
        }
        PredefinedCategory predefinedCategory2 = PredefinedCategory.MATH_NOTES;
        if (predefinedCategory2.getUuid().equals(folderSortData.getUuid())) {
            return 1;
        }
        return (predefinedCategory.getUuid().equals(folderSortData2.getUuid()) || predefinedCategory2.getUuid().equals(folderSortData2.getUuid())) ? -1 : 0;
    }

    public SortParam getSortParam() {
        return this.mSortParam;
    }

    public NotesCategoryTreeComparator setSortParam(SortParam sortParam) {
        this.mSortParam = sortParam;
        return this;
    }

    @Override // java.util.Comparator
    public int compare(FolderSortData folderSortData, FolderSortData folderSortData2) {
        int iCompare;
        if (folderSortData == null || folderSortData2 == null || getSortParam() == null) {
            return 0;
        }
        int sortType = getSortParam().getSortType();
        if (sortType == 0) {
            iCompare = new NameComparator().compare(folderSortData.getDisplayName(), folderSortData2.getDisplayName());
            if (iCompare == 0) {
                iCompare = new NotesCategoryTreeComparator().setSortParam(new SortParam.SortParamBuilder().setSortType(getSortParam().getLastSortTimeType()).setIsDesc(getSortParam().getLastIsDesc()).build()).compare(folderSortData, folderSortData2);
            }
        } else if (sortType == 1) {
            iCompare = Long.compare(folderSortData.getCreatedAt(), folderSortData2.getCreatedAt());
            if (iCompare == 0) {
                iCompare = new NameComparator().compare(folderSortData.getDisplayName(), folderSortData2.getDisplayName());
            }
        } else if (sortType == 3) {
            iCompare = Long.compare(folderSortData.getRecycleBinTimeMoved(), folderSortData2.getRecycleBinTimeMoved());
            if (iCompare == 0) {
                iCompare = Long.compare(folderSortData.getCreatedAt(), folderSortData2.getCreatedAt());
            }
        } else if (sortType != 6) {
            iCompare = Long.compare(folderSortData.getLastModifiedAt(), folderSortData2.getLastModifiedAt());
            if (iCompare == 0) {
                iCompare = new NameComparator().compare(folderSortData.getDisplayName(), folderSortData2.getDisplayName());
            }
        } else {
            int iPredefinedSort = predefinedSort(folderSortData, folderSortData2);
            if (iPredefinedSort != 0) {
                return iPredefinedSort;
            }
            iCompare = Long.compare(folderSortData.getReorder().intValue(), folderSortData2.getReorder().intValue());
            if (iCompare == 0) {
                iCompare = new NotesCategoryTreeComparator().setSortParam(new SortParam.SortParamBuilder().setSortType(getSortParam().getLastSortTimeType()).setIsDesc(getSortParam().getLastIsDesc()).build()).compare(folderSortData, folderSortData2);
            }
        }
        return getSortParam().getIsDesc() ? iCompare * (-1) : iCompare;
    }
}
