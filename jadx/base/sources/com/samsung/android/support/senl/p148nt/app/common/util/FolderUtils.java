package com.samsung.android.support.senl.p148nt.app.common.util;

import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderUtils {
    public static final String[] sStaticFolders = {FolderConstants.ScreenOffMemo.UUID, FolderConstants.MathNotes.UUID};
    public static final int[] sNotSelectableHolderType = {3, 4, 1, 2};

    public static int getAdjustedFolderDefaultColor(int i, Context context) {
        Resources resources = context.getResources();
        if (i == -1 || i == 0 || i == resources.getColor(C8003R.color.sub_folder_icon_default_bg_color, null)) {
            return ResourceUtils.isSupportBackgroundBlur() ? resources.getColor(C8003R.color.new_folder_color_default_high_contrast, null) : resources.getColor(C8003R.color.folder_list_item_icon_default_bg_color, null);
        }
        if (!ResourceUtils.isSupportBackgroundBlur()) {
            return i;
        }
        int color = resources.getColor(DrawableUtils.getNewFolderColor(context, i), null);
        return color == resources.getColor(C8003R.color.new_folder_color_default, null) ? resources.getColor(C8003R.color.new_folder_color_default_high_contrast, null) : color;
    }

    public static int getDrawerFolderDrawable(String str, boolean z, boolean z2, boolean z3) {
        return FolderConstants.AllNotes.UUID.equals(str) ? z ? C8003R.drawable.ic_all_solid : C8003R.drawable.ic_all : FolderConstants.OldNotes.UUID.equals(str) ? z ? C8003R.drawable.ic_old_notes_solid : C8003R.drawable.ic_old_notes : "favorite:///".equals(str) ? z ? C8003R.drawable.ic_favorite_solid : C8003R.drawable.ic_favorite : "lock:///".equals(str) ? z ? C8003R.drawable.ic_drawer_lock_solid : C8003R.drawable.ic_drawer_lock : "recentlyImported:///".equals(str) ? z ? C8003R.drawable.ic_import_solid : C8003R.drawable.ic_import : FolderConstants.SharedNotes.UUID.equals(str) ? z ? C8003R.drawable.ic_shared_notebooks_solid : C8003R.drawable.ic_shared_notebooks : FolderConstants.Coedit.UUID.equals(str) ? z ? C8003R.drawable.ic_drawer_coedit_solid : C8003R.drawable.ic_drawer_coedit : FolderConstants.RecycleBin.UUID.equals(str) ? z ? C8003R.drawable.ic_delete_solid : C8003R.drawable.ic_delete : FolderConstants.MyFolders.UUID.equals(str) ? z ? z3 ? z2 ? C8003R.drawable.ic_folder_home_solid : C8003R.drawable.ic_folder_home_close_solid : C8003R.drawable.ic_drawer_folder_solid : z3 ? z2 ? C8003R.drawable.ic_folder_home : C8003R.drawable.ic_folder_home_close : C8003R.drawable.ic_drawer_folder : z ? z3 ? z2 ? C8003R.drawable.ic_folder_open_solid : C8003R.drawable.ic_drawer_folder_solid : C8003R.drawable.ic_drawer_folder_solid : z3 ? z2 ? C8003R.drawable.ic_folder_open : C8003R.drawable.ic_drawer_folder : C8003R.drawable.ic_drawer_folder;
    }

    public static int getFolderHomeDrawable(boolean z, boolean z2) {
        return z ? z2 ? C8003R.drawable.ic_folder_home_solid : C8003R.drawable.ic_folder_home : LocaleUtils.isRTLMode() ? z2 ? C8003R.drawable.ic_folder_left_rtl : C8003R.drawable.ic_folder_home_close : z2 ? C8003R.drawable.ic_folder_home_close_solid : C8003R.drawable.ic_folder_home_close;
    }

    public static String getPrefixedFolderName(Context context, String str) {
        return FolderConstants.MyFolders.UUID.equals(str) ? context.getString(C8003R.string.settings_my_folders) : FolderConstants.ScreenOffMemo.UUID.equals(str) ? context.getString(C8003R.string.string_screen_off_memo) : FolderConstants.MathNotes.UUID.equals(str) ? context.getString(C8003R.string.string_math_notes) : FolderConstants.Coedit.UUID.equals(str) ? context.getString(C8003R.string.co_edit_title) : "";
    }

    public static int getUserFolderDrawable(boolean z, boolean z2) {
        return z ? z2 ? C8003R.drawable.ic_folder_open_solid : C8003R.drawable.ic_folder_open : z2 ? C8003R.drawable.ic_drawer_folder_solid : C8003R.drawable.ic_drawer_folder;
    }

    public static boolean hasChildFolder(NotesFolder notesFolder) {
        if (notesFolder == null || !notesFolder.hasChild()) {
            return false;
        }
        if (!FolderConstants.MyFolders.UUID.equals(notesFolder.getUuid())) {
            return true;
        }
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            if (!isIgnoreFolder(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIgnoreFolder(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return false;
        }
        for (String str : sStaticFolders) {
            if (str.equals(notesFolder.getUuid()) && notesFolder.getDocumentCount() == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotSelectableFolder(int i) {
        for (int i2 : sNotSelectableHolderType) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStaticFolder(String str) {
        for (String str2 : sStaticFolders) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
