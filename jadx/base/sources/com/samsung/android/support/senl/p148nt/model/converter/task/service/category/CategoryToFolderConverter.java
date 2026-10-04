package com.samsung.android.support.senl.p148nt.model.converter.task.service.category;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CategoryToFolderConverter {
    private static final String TAG = ModelLogger.createConverterTag("CategoryToFolderConverter");
    private final CategoryColorConverter mColorConverter;

    public CategoryToFolderConverter(CategoryColorConverter categoryColorConverter) {
        this.mColorConverter = categoryColorConverter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$convert$0(String str) {
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
        if (categoryEntity == null || TextUtils.isEmpty(categoryEntity.getDisplayName())) {
            DataLogger.m12307i(TAG, "convertCategoryToFolder, UNCATEGORIZED");
            return PredefinedCategory.UNCATEGORIZED.getUuid();
        }
        String strConvertNewCategory = PredefinedCategory.convertNewCategory(str);
        if (str.equals(strConvertNewCategory)) {
            return createNewFolder(categoryEntity.getDisplayName(), this.mColorConverter.getConvertedColor(categoryEntity.getDisplayNameColor()));
        }
        AbstractC0000a.m2C("convertCategoryToFolder, predefinedFolder : ", strConvertNewCategory, TAG);
        return strConvertNewCategory;
    }

    public String convert(@NonNull String str) {
        return (String) FolderManager.getInstance().executeOperation(new CallableC7766b(this, str, 5));
    }

    public String createNewFolder(String str, int i) {
        String strReplaceAll = str.replaceAll("[\\*/\\\\\\?:<>\\|\"]+", "");
        StringBuilder sb = new StringBuilder();
        PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
        sb.append(predefinedCategory.getPath());
        sb.append(strReplaceAll);
        String string = sb.toString();
        String strFindAndMakeCategory = FolderManager.getInstance().findAndMakeCategory(FolderManager.getInstance().getAllDocumentCategoryTree(false), string, i);
        String str2 = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("createNewFolder, newFolderPath : ", string, ", newFolderUuid : ", strFindAndMakeCategory, ", color : ");
        sbM16m.append(i);
        DataLogger.m12307i(str2, sbM16m.toString());
        return strFindAndMakeCategory == null ? predefinedCategory.getUuid() : strFindAndMakeCategory;
    }
}
