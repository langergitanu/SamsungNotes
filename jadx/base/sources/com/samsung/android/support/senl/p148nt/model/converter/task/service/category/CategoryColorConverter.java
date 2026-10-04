package com.samsung.android.support.senl.p148nt.model.converter.task.service.category;

import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CategoryColorConverter {
    private static final String TAG = ModelLogger.createConverterTag("CategoryColorConverter");
    private final int[] mColorArray;
    private final int mDefaultColor;
    private final int[] mOldColorArray;
    private final int mOldScreenOffMemoColor;
    private final int mOldUncategorizedColor;

    public CategoryColorConverter(FolderAccessHandler.FolderColorResourceInjector folderColorResourceInjector) {
        this.mOldScreenOffMemoColor = folderColorResourceInjector.getOldScreenOffMemoColor();
        this.mOldUncategorizedColor = folderColorResourceInjector.getOldUncategorizedColor();
        this.mOldColorArray = folderColorResourceInjector.getOldFolderColorArray();
        this.mDefaultColor = folderColorResourceInjector.getDefaultFolderColor();
        this.mColorArray = folderColorResourceInjector.getFolderColorArray();
    }

    public int getConvertedColor(int i) {
        int i2 = this.mDefaultColor;
        if (i != this.mOldUncategorizedColor && i != this.mOldScreenOffMemoColor) {
            int i4 = 0;
            while (true) {
                int[] iArr = this.mOldColorArray;
                if (i4 >= iArr.length) {
                    break;
                }
                if (i == iArr[i4]) {
                    i2 = this.mColorArray[i4];
                    break;
                }
                i4++;
            }
        }
        DataLogger.m12307i(TAG, "getConvertedColor, srcColor/dstColor : " + i + '/' + i2);
        return i2;
    }

    public int getDefaultColor() {
        return this.mDefaultColor;
    }
}
