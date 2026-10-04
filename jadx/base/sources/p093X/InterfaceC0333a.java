package p093X;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: X.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface InterfaceC0333a {
    String addCategory(Context context, String str, String str2, int i, boolean z);

    NotesCategoryTreeEntity createRestoredFolder();

    void deleteCategory(Context context, String str, long j, int i, boolean z);

    void deleteCategorySync(Context context, String str);

    int getCategoryDeleted(String str);

    String getCategoryName(Context context, String str);

    int getCategoryOrder(Context context, String str);

    long getCategoryServerTimestamp(Context context, String str);

    List getCategoryUUIDList(Context context);

    List getCategoryUUIDListByDeleted(Context context, boolean z);

    List getCategoryUUIDListByDirty(Context context, int i);

    int getDirtyCountOfNoteCategory(Context context);

    long getNoteCategoryDirty(Context context, String str);

    long getNoteCategoryServerTimestamp(Context context, String str);

    String getNoteCategoryUUID(Context context, String str);

    List getUUIDListByCategory(Context context, String str, boolean z);

    HashMap getUuidAndNoteCategoryTimeList(Context context);

    boolean isExistCategory(Context context, String str);

    void recoveryCategory(Context context, String str, long j, int i);

    void setCategoryDirty(Context context, String str, int i);

    void setCategoryOrder(Context context, HashMap map, long j);

    int setNoteCategory(Context context, String str, String str2);

    int setNoteCategory(Context context, String str, String str2, int i, long j);

    void setNoteCategoryDirty(Context context, String str, int i);

    void setTimestampAndDirty(Context context, String str, long j, int i);

    Object synchronizeCategory();

    void updateCategoryNameAndColor(Context context, String str, String str2, int i);
}
