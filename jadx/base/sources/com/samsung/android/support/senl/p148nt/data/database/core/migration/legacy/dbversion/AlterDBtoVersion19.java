package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion19 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion19");

    public AlterDBtoVersion19() {
        super(18, 19);
    }

    private RectF getBitmapRectF(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new RectF(0.0f, 0.0f, options.outWidth, options.outHeight);
    }

    private int getContentType(int i) {
        if (i == 2 || i == 4 || i == 5) {
            return 2;
        }
        return i;
    }

    private void updateSdocFilePath(SupportSQLiteDatabase supportSQLiteDatabase, Context context, String str) {
        float fHeight;
        String string = null;
        try {
            ArrayList<SpenContentBase> contentList = DocumentConstructor.makeSpenSDoc(context, str, null, null).getContentList();
            if (contentList == null) {
                return;
            }
            int i = 0;
            int contentType = 0;
            int i2 = 0;
            for (SpenContentBase spenContentBase : contentList) {
                if (spenContentBase.getText() != null) {
                    if (contentType != 0) {
                        if (i2 != 0) {
                            break;
                        }
                        int contentType2 = getContentType(spenContentBase.getType());
                        if (contentType != contentType2) {
                            i2 = contentType2;
                        }
                    } else {
                        contentType = getContentType(spenContentBase.getType());
                    }
                }
            }
            while (true) {
                fHeight = 0.0f;
                if (i >= contentList.size()) {
                    break;
                }
                if (getContentType(contentList.get(i).getType()) == 3) {
                    String thumbnailPath = contentList.get(i).getThumbnailPath();
                    Cursor cursorQuery = supportSQLiteDatabase.query("SELECT min(content.UUID) AS contentUUID2                      FROM sdoc LEFT JOIN content ON sdoc.UUID = content.sdocUUID  and content.isDeleted = 0 and mime_type in ('content/handwriting')                     WHERE sdoc.isDeleted = 0 and sdoc.filePath = ?                     GROUP BY sdoc.UUID", new String[]{str});
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() != 0) {
                                if (thumbnailPath != null) {
                                    RectF bitmapRectF = getBitmapRectF(thumbnailPath);
                                    fHeight = bitmapRectF.height() / bitmapRectF.width();
                                }
                                cursorQuery.moveToFirst();
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("contentUUID2"));
                            }
                        } finally {
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else {
                    i++;
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("firstContentType", Integer.valueOf(contentType));
            contentValues.put("secondContentType", Integer.valueOf(i2));
            contentValues.put("strokeRatio", Float.valueOf(fHeight));
            contentValues.put("strokeUUID", string);
            String str2 = TAG;
            DataLogger.m12302d(str2, "filePath : " + str);
            DataLogger.m12302d(str2, "firstContentType : " + contentType);
            DataLogger.m12302d(str2, "secondContentType : " + i2);
            DataLogger.m12302d(str2, "strokeRatio : " + fHeight);
            DataLogger.m12302d(str2, "strokeUUID : " + string);
            supportSQLiteDatabase.update("sdoc", 1, contentValues, "filePath=?", new String[]{str});
        } catch (SpenSDocInvalidPasswordException | SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e) {
            DataLogger.m12303e(TAG, "IOException alterDBtoVersion19() : " + e.toString());
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12302d(TAG, "alterDBtoVersion19()");
        supportSQLiteDatabase.beginTransaction();
        try {
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN firstContentType INTEGER DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN secondContentType INTEGER DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN strokeRatio REAL DEFAULT 0.0");
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                try {
                    Cursor cursorQuery = supportSQLiteDatabase.query("SELECT filePath FROM sdoc WHERE sdoc.isDeleted = 0");
                    try {
                        ArrayList arrayList = new ArrayList();
                        if (cursorQuery != null && cursorQuery.moveToFirst()) {
                            do {
                                arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("filePath")));
                            } while (cursorQuery.moveToNext());
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            updateSdocFilePath(supportSQLiteDatabase, applicationContext, (String) it.next());
                        }
                        supportSQLiteDatabase.setTransactionSuccessful();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    DataLogger.m12303e(TAG, "Exception alterDBtoVersion19() : " + e);
                }
            }
            supportSQLiteDatabase.endTransaction();
        } catch (SQLException e2) {
            DataLogger.m12304e(TAG, "alterDBtoVersion19()", e2);
            throw e2;
        }
    }
}
