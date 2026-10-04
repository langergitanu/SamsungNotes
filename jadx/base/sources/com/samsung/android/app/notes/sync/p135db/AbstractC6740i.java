package com.samsung.android.app.notes.sync.p135db;

import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6740i {
    /* JADX INFO: renamed from: a */
    public static String m4838a(String str, boolean z) {
        List<String> listFindUuidListByDisplayName = FolderManager.getInstance().findUuidListByDisplayName(str, z);
        if (listFindUuidListByDisplayName == null) {
            return "1";
        }
        for (String str2 : listFindUuidListByDisplayName) {
            if (PredefinedCategory.UNCATEGORIZED.getUuid().equals(FolderManager.getInstance().getCategoryEntity(str2).getParentUuid())) {
                return str2;
            }
        }
        return "1";
    }
}
