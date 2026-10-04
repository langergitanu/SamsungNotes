package com.samsung.android.support.senl.p148nt.data.database.core.document.folder;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.sort.NotesCategoryTreeComparator;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesCategoryTreeSortUtils {
    private static final String TAG = DataLogger.createTag("NotesCategoryTreeSortUtils");

    public static SortParam getSortParam() {
        return new SortParam.SortParamBuilder().setSortType(6).setLastSortTimeType(1).build();
    }

    private static void printError(@NonNull List<? extends FolderSortData> list, @NonNull SortParam sortParam, IllegalArgumentException illegalArgumentException) {
        DataLogger.m12303e(TAG, "sort, e: " + illegalArgumentException.getMessage());
        if (illegalArgumentException.getMessage() == null || !illegalArgumentException.getMessage().contains("Comparison method violates its general contract!")) {
            return;
        }
        for (FolderSortData folderSortData : list) {
            DataLogger.m12303e(TAG, "sort, data: " + folderSortData);
        }
        DataLogger.m12303e(TAG, "sort, sortParam: " + sortParam);
    }

    public static void sort(@NonNull FolderSortData folderSortData) {
        sort(folderSortData, getSortParam());
    }

    public static void sort(@NonNull FolderSortData folderSortData, @NonNull SortParam sortParam) {
        sort((List<? extends FolderSortData>) Collections.singletonList(folderSortData), sortParam);
    }

    public static void sort(@NonNull List<? extends FolderSortData> list) {
        sort(list, getSortParam());
    }

    public static void sort(@NonNull List<? extends FolderSortData> list, @NonNull SortParam sortParam) {
        NotesCategoryTreeComparator sortParam2 = new NotesCategoryTreeComparator().setSortParam(sortParam);
        ArrayList arrayList = new ArrayList(list);
        while (!arrayList.isEmpty()) {
            FolderSortData folderSortData = (FolderSortData) arrayList.remove(0);
            try {
                folderSortData.getChildren().sort(sortParam2);
            } catch (IllegalArgumentException e) {
                printError(folderSortData.getChildren(), sortParam, e);
            }
            arrayList.addAll(folderSortData.getChildren());
        }
    }
}
