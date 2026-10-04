package com.samsung.android.support.senl.p148nt.model.converter.task.service.category;

import android.database.Cursor;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CategoryColorConvertTask implements Runnable {
    private final CategoryColorConverter mConverter;

    public CategoryColorConvertTask(FolderAccessHandler.FolderColorResourceInjector folderColorResourceInjector) {
        this.mConverter = new CategoryColorConverter(folderColorResourceInjector);
    }

    @Override // java.lang.Runnable
    public void run() {
        SupportSQLiteDatabase writableDatabase = NotesDatabaseManager.getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("SELECT UUID, oldColor FROM (SELECT category_tree.* FROM category_tree WHERE parentUUID = 'uncategorized:///') AS tree JOIN (SELECT category_tree.displayName AS 'oldName', category_tree.displayNameColor AS 'oldColor' FROM category_tree WHERE parentUUID = 'old:///') AS old ON tree.displayName = oldName");
        try {
            int columnIndex = cursorQuery.getColumnIndex("UUID");
            int columnIndex2 = cursorQuery.getColumnIndex("oldColor");
            if (columnIndex >= 0 && columnIndex2 >= 0) {
                while (cursorQuery.moveToNext()) {
                    writableDatabase.execSQL("UPDATE OR ABORT category_tree SET displayNameColor = " + this.mConverter.getConvertedColor(cursorQuery.getInt(columnIndex2)) + " WHERE UUID = '" + cursorQuery.getString(columnIndex) + "' ");
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
