package com.samsung.android.support.senl.p148nt.data.common.constants;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCategory, still in use, count: 1, list:
  (r1v1 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCategory) from 0x008d: FILLED_NEW_ARRAY 
  (r2v2 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCategory)
  (r1v1 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCategory)
  (r6v5 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCategory)
 A[WRAPPED] (LINE:142) elemType: com.samsung.android.support.senl.nt.data.common.constants.PredefinedCategory
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class PredefinedCategory {
    ALL("all:///", "all:///", CategoryConstants.All.DISPLAY_NAME),
    RECYCLE_BIN("trash:///", "trash:///", CategoryConstants.RecycleBin.DISPLAY_NAME),
    UNCATEGORIZED("uncategorized:///", "uncategorized:///", "Uncategorized"),
    SCREEN_OFF_MEMO(CategoryConstants.ScreenOffMemo.UUID, "Screen off memo\u200b", "Screen off memo\u200b"),
    MATH_NOTES(CategoryConstants.Math.UUID, "Math notes\u200b", "Math notes\u200b"),
    SHARED_NOTE_BOOK("shared:///", "shared:///", CategoryConstants.SharedNotes.DISPLAY_NAME),
    OLD_NOTES("old:///", "old:///", CategoryConstants.OldNotes.DISPLAY_NAME),
    COEDIT_NOTES("coedit:///", "coedit:///", CategoryConstants.Coedit.DISPLAY_NAME);

    public static final List<String> CHILDREN_FOLDERS_OF_UNCATEGORIZED;
    public static final String[][] DEFAULT_OLD_NOTES_PREDEFINED_CATEGORY;
    public static final PredefinedCategory[] DEFAULT_PREDEFINED_CATEGORY_ARRAY;
    public static final List<String> DEFAULT_PREDEFINED_OLD_FOLDER_UUIDS;
    public static final List<String> INVISIBLE_FOLDERS;
    public static final Set<String> RESTRICTED_FOLDERS;
    private final String mDisplayName;
    private final String mPath;
    private final String mPureDisplayName;
    private final String mUuid;

    static {
        DEFAULT_PREDEFINED_CATEGORY_ARRAY = new PredefinedCategory[]{predefinedCategory, new PredefinedCategory("trash:///", "trash:///", CategoryConstants.RecycleBin.DISPLAY_NAME), new PredefinedCategory("old:///", "old:///", CategoryConstants.OldNotes.DISPLAY_NAME)};
        List<String> listAsList = Arrays.asList("old:///", "1", "2", CategoryConstants.OldRestored.UUID, "old_converted_notes");
        DEFAULT_PREDEFINED_OLD_FOLDER_UUIDS = listAsList;
        DEFAULT_OLD_NOTES_PREDEFINED_CATEGORY = new String[][]{new String[]{"1", "Uncategorized", "1000000"}, new String[]{"2", CategoryConstants.OldScreenOffMemo.DISPLAY_NAME, "999999"}};
        List<String> listAsList2 = Arrays.asList(CategoryConstants.ScreenOffMemo.UUID, CategoryConstants.Math.UUID);
        CHILDREN_FOLDERS_OF_UNCATEGORIZED = listAsList2;
        INVISIBLE_FOLDERS = Arrays.asList("uncategorized:///", "trash:///", "1", "old:///");
        HashSet hashSet = new HashSet();
        RESTRICTED_FOLDERS = hashSet;
        hashSet.addAll(Arrays.asList("uncategorized:///", "trash:///"));
        hashSet.addAll(listAsList2);
        hashSet.addAll(listAsList);
    }

    private PredefinedCategory(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.mUuid = str;
        this.mPath = str2;
        this.mDisplayName = str3;
        this.mPureDisplayName = UnicodeUtils.removeUnicode(str3, "\u200b");
    }

    public static String convertNewCategory(@NonNull String str) {
        return "1".equals(str) ? UNCATEGORIZED.getUuid() : "2".equals(str) ? SCREEN_OFF_MEMO.getUuid() : str;
    }

    public static PredefinedCategory find(@NonNull String str) {
        for (PredefinedCategory predefinedCategory : values()) {
            if (predefinedCategory.getUuid().equals(str)) {
                return predefinedCategory;
            }
        }
        return null;
    }

    public static PredefinedCategory findByPath(@NonNull String str) {
        for (PredefinedCategory predefinedCategory : values()) {
            if (str.startsWith(predefinedCategory.getPath())) {
                return predefinedCategory;
            }
        }
        return null;
    }

    public static boolean isRootFolder(@NonNull String str) {
        return "uncategorized:///".equals(str) || "trash:///".equals(str) || "old:///".equals(str);
    }

    public static PredefinedCategory valueOf(String str) {
        return (PredefinedCategory) Enum.valueOf(PredefinedCategory.class, str);
    }

    public static PredefinedCategory[] values() {
        return (PredefinedCategory[]) $VALUES.clone();
    }

    @NonNull
    public String getDisplayName() {
        return this.mDisplayName;
    }

    @NonNull
    public String getPath() {
        return this.mPath;
    }

    @NonNull
    public String getPureDisplayName() {
        return this.mPureDisplayName;
    }

    @NonNull
    public String getUuid() {
        return this.mUuid;
    }
}
