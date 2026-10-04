package com.samsung.android.support.senl.p148nt.app.converter;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderConverterResources implements FolderAccessHandler.FolderColorResourceInjector {
    private final int[] mColorArray;
    private final int mDefaultColor;
    private final int[] mOldColorArray;
    private final int mOldScreenOffMemoColor;
    private final int mOldUncategorizedColor;

    public FolderConverterResources(@NonNull Resources resources) {
        this.mOldScreenOffMemoColor = resources.getColor(C8003R.color.category_mark_color_screen_off_memo, null);
        this.mOldUncategorizedColor = resources.getColor(C8003R.color.category_mark_color_background_uncategorized, null);
        this.mOldColorArray = resources.getIntArray(C8003R.array.old_v3_folder_mark_color);
        this.mDefaultColor = resources.getColor(C8003R.color.folder_color_default, null);
        this.mColorArray = resources.getIntArray(C8003R.array.folder_mark_new_color);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.folder.FolderAccessHandler.FolderColorResourceInjector
    public int getDefaultFolderColor() {
        return this.mDefaultColor;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.folder.FolderAccessHandler.FolderColorResourceInjector
    public int[] getFolderColorArray() {
        return this.mColorArray;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.folder.FolderAccessHandler.FolderColorResourceInjector
    public int[] getOldFolderColorArray() {
        return this.mOldColorArray;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.folder.FolderAccessHandler.FolderColorResourceInjector
    public int getOldScreenOffMemoColor() {
        return this.mOldScreenOffMemoColor;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.access.folder.FolderAccessHandler.FolderColorResourceInjector
    public int getOldUncategorizedColor() {
        return this.mOldUncategorizedColor;
    }
}
