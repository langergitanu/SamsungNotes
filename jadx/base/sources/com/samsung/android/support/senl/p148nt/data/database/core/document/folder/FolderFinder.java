package com.samsung.android.support.senl.p148nt.data.database.core.document.folder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderFinder {
    private final PredefinedCategory mDefaultFolder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private final String mFolderUuid;
        private final String[] mPathArray;
        private final PredefinedCategory mRootFolder;

        public Result(@NonNull PredefinedCategory predefinedCategory) {
            this(predefinedCategory, predefinedCategory.getUuid());
        }

        @NonNull
        public String getFolderUuid() {
            return this.mFolderUuid;
        }

        @NonNull
        public String[] getPathArray() {
            return this.mPathArray;
        }

        @NonNull
        public PredefinedCategory getRootFolder() {
            return this.mRootFolder;
        }

        public Result(@NonNull PredefinedCategory predefinedCategory, @NonNull String str) {
            this(predefinedCategory, str, new String[0]);
        }

        public Result(@NonNull PredefinedCategory predefinedCategory, @NonNull String str, @NonNull String[] strArr) {
            this.mRootFolder = predefinedCategory;
            this.mFolderUuid = str;
            this.mPathArray = strArr;
        }
    }

    public FolderFinder(PredefinedCategory predefinedCategory) {
        this.mDefaultFolder = predefinedCategory;
    }

    @NonNull
    public Result find(@NonNull String str) {
        PredefinedCategory predefinedCategoryFindByPath;
        if (TextUtils.isEmpty(str)) {
            return new Result(this.mDefaultFolder);
        }
        PredefinedCategory predefinedCategoryFindByPath2 = PredefinedCategory.findByPath(str);
        if (predefinedCategoryFindByPath2 == null) {
            return new Result(this.mDefaultFolder);
        }
        String[] strArrSplit = str.split(predefinedCategoryFindByPath2.getPath());
        if (strArrSplit.length <= 1) {
            return new Result(predefinedCategoryFindByPath2);
        }
        String[] strArrSplit2 = strArrSplit[1].split(File.separator);
        return strArrSplit2.length == 0 ? new Result(predefinedCategoryFindByPath2) : (strArrSplit2.length != 1 || (predefinedCategoryFindByPath = PredefinedCategory.findByPath(strArrSplit2[0])) == null) ? new Result(predefinedCategoryFindByPath2, "", strArrSplit2) : new Result(predefinedCategoryFindByPath2, predefinedCategoryFindByPath.getUuid());
    }
}
