package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion22 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion22");

    public AlterDBtoVersion22() {
        super(21, 22);
    }

    private void insertContentData(String str, int i, SpenContentBase spenContentBase, SupportSQLiteDatabase supportSQLiteDatabase) {
        int type = spenContentBase.getType();
        ContentValues contentValues = new ContentValues();
        String strNewUUID = UUIDUtils.newUUID(BaseUtils.getApplicationContext());
        if (type == 0) {
            return;
        }
        contentValues.put("UUID", strNewUUID);
        contentValues.put("sdocUUID", str);
        contentValues.put("srcID", Integer.valueOf(i));
        contentValues.put("mime_type", "text/plain");
        supportSQLiteDatabase.insert("content", 1, contentValues);
    }

    private void insertSdocFilePath(@NonNull Context context, String str, String str2, int i, SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC11014a.m12334s("Load sdoc with sdocFilePath  ", str2, TAG);
        try {
            ArrayList<SpenContentBase> contentList = DocumentConstructor.makeSpenSDoc(context, str2, null, null).getContentList();
            if (contentList == null) {
                return;
            }
            Iterator<SpenContentBase> it = contentList.iterator();
            while (it.hasNext()) {
                insertContentData(str, i, it.next(), supportSQLiteDatabase);
            }
        } catch (SpenSDocInvalidPasswordException | SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e) {
            DataLogger.m12303e(TAG, "IOException alterDBtoVersion19() : " + e.toString());
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursorQuery;
        DataLogger.m12302d(TAG, "alterDBtoVersion22");
        Cursor cursorQuery2 = null;
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                supportSQLiteDatabase.execSQL("ALTER TABLE stroke ADD COLUMN pageWidth INTEGER DEFAULT 0 ");
                cursorQuery = supportSQLiteDatabase.query("SELECT _id FROM stroke");
            } catch (Throwable th) {
                th = th;
            }
            try {
                WindowManager windowManager = (WindowManager) BaseUtils.getApplicationContext().getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                if (i > i2) {
                    i = i2;
                }
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    do {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("pageWidth", Double.valueOf(((double) i) * 0.7d));
                        supportSQLiteDatabase.update("stroke", 1, contentValues, "_id=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("_id"))});
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery2 = supportSQLiteDatabase.query("SELECT UUID, filePath FROM sdoc WHERE sdoc.isDeleted = 0");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    if (cursorQuery2 != null && cursorQuery2.moveToFirst()) {
                        do {
                            arrayList2.add(cursorQuery2.getString(cursorQuery2.getColumnIndex("UUID")));
                            arrayList.add(cursorQuery2.getString(cursorQuery2.getColumnIndex("filePath")));
                        } while (cursorQuery2.moveToNext());
                    }
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        insertSdocFilePath(applicationContext, (String) arrayList2.get(i4), (String) arrayList.get(i4), i4, supportSQLiteDatabase);
                    }
                }
                supportSQLiteDatabase.setTransactionSuccessful();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                supportSQLiteDatabase.endTransaction();
            } catch (SQLException e) {
                e = e;
                DataLogger.m12304e(TAG, "alterDBtoVersion22()", e);
                throw e;
            } catch (Exception e2) {
                e = e2;
                cursor2 = cursorQuery2;
                cursorQuery2 = cursorQuery;
                DataLogger.m12303e(TAG, "Exception alterDBtoVersion22() : " + e.toString());
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                supportSQLiteDatabase.endTransaction();
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery2;
                cursorQuery2 = cursorQuery;
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                supportSQLiteDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e3) {
            e = e3;
        } catch (Exception e5) {
            e = e5;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }
}
