package com.samsung.android.support.senl.document.memoconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.document.data.ConverterFileDataAdapter;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.InsufficientStorageException;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.document.util.ZipUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AudioFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NMemoConverter extends SQLiteOpenHelper {
    public static final int CONVERT_MODE_NORMAL = 0;
    public static final int CONVERT_MODE_RENAME = 2;
    public static final int CONVERT_MODE_REPLACE = 1;
    private static final String OLD_FILE_DIR = "app_attach/";
    private static final String TAG = "NMemoConverter";
    private static String XML_TAG_CONTENTS = "contents";
    private static String XML_TAG_CONTENTS_CONTENT = "content";
    private static String XML_TAG_CONTENTS_VOICE_CONTENT = "voice_content";
    private static String XML_TAG_HEADER = "header";
    private static String XML_TAG_MEMO_META = "meta";
    private static String XML_TAG_MEMO_META_CREATEDTIME = "createdTime";
    private static String XML_TAG_MEMO_META_FAVOURITE = "favourite";
    private static String XML_TAG_MEMO_META_TITLE = "title";
    private static String XML_TAG_MEMO_META_UUID = "uuid";
    private String mAttachedFileFolder;
    private Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MyDatabaseErrorHandler implements DatabaseErrorHandler {
        private MyDatabaseErrorHandler() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            NMemoConverter.dropTables(sQLiteDatabase);
            NMemoConverter.createTables(sQLiteDatabase);
        }
    }

    public NMemoConverter(Context context, String str, String str2) {
        super(context, str, null, 10, new MyDatabaseErrorHandler());
        this.mContext = context;
        this.mAttachedFileFolder = str2;
        Converter.loadSpenSDK(context);
        DocumentLogger.m7181i(TAG, "MemoDBHelper()");
    }

    private void alterDBtoVersion10(SQLiteDatabase sQLiteDatabase) {
        DocumentLogger.m7178d(TAG, "alterDBtoVersion10()");
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE memo ADD COLUMN xmlContent TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE memo ADD COLUMN display_Content TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE memo ADD COLUMN isFavorite INTEGER");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DocumentLogger.m7180e(TAG, "alterDBtoVersion10()", e);
                throw e;
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void alterDBtoVersion8(SQLiteDatabase sQLiteDatabase) throws Throwable {
        DocumentLogger.m7178d(TAG, "alterDBtoVersion8()");
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE memo ADD COLUMN sync1 INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE memo ADD COLUMN sync2 TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE file ADD COLUMN sync1 INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE file ADD COLUMN sync2 TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE category ADD COLUMN sync1 INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE category ADD COLUMN sync2 TEXT");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DocumentLogger.m7180e(TAG, "alterDBtoVersion8()", e);
                throw e;
            }
        } finally {
            sQLiteDatabase.endTransaction();
            updateTimestampsToUTC(sQLiteDatabase);
            updatePathsToRelative(sQLiteDatabase);
        }
    }

    private void alterDBtoVersion9(SQLiteDatabase sQLiteDatabase) {
        DocumentLogger.m7178d(TAG, "alterDBtoVersion9()");
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE memo ADD COLUMN isNeedUpsync INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE file ADD COLUMN isNeedUpsync INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE category ADD COLUMN isNeedUpsync INTEGER");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DocumentLogger.m7180e(TAG, "alterDBtoVersion9()", e);
                throw e;
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static String convertToSDocFile(Context context, String str) throws Throwable {
        String memoXML = null;
        if (str == null) {
            DocumentLogger.m7181i(TAG, "convertTOSDocFile - path is null");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            DocumentLogger.m7181i(TAG, "convertTOSDocFile - zipFile.exists() == false");
            return null;
        }
        Converter.loadSpenSDK(context);
        String str2 = context.getCacheDir() + "/unzip_" + System.currentTimeMillis();
        File file2 = new File(str2);
        file2.mkdir();
        try {
            ZipUtil.unzip(file, file2, false, false);
            memoXML = parseMemoXML(context, str2);
            FileUtil.deleteFile(file2);
            return memoXML;
        } catch (IOException e) {
            DocumentLogger.m7181i(TAG, "convertTOSDocFile - fail to unzip " + e);
            return memoXML;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0432 A[PHI: r17 r19
      0x0432: PHI (r17v3 android.database.Cursor) = (r17v4 android.database.Cursor), (r17v6 android.database.Cursor) binds: [B:119:0x0463, B:108:0x0430] A[DONT_GENERATE, DONT_INLINE]
      0x0432: PHI (r19v1 java.lang.String) = (r19v3 java.lang.String), (r19v6 java.lang.String) binds: [B:119:0x0463, B:108:0x0430] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0472  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String coreConverter(boolean z, String str, ProgressListener progressListener, int i) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i2;
        Cursor cursorQuery;
        String str8;
        Cursor cursor3;
        Converter.SDocData sDocData;
        String str9;
        int i4;
        String str10;
        String str11 = "parse data( ";
        DocumentLogger.m7181i(TAG, "coreConverter start");
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            DocumentLogger.m7181i(TAG, "convertToSDoc DB is empty");
            return null;
        }
        DocumentLogger.m7181i(TAG, "coreConverter : " + str);
        try {
            readableDatabase.beginTransaction();
            HashMap map = new HashMap();
            Cursor cursorQuery2 = readableDatabase.query("category", null, "isDeleted = 0", null, null, null, null);
            while (cursorQuery2.moveToNext()) {
                String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("UUID"));
                String string2 = cursorQuery2.getString(cursorQuery2.getColumnIndex("_display_name"));
                map.put(string, string2);
                DocumentLogger.m7181i(TAG, "convertToSDoc - category / " + string + " / " + string2 + " / ");
            }
            cursorQuery2.close();
            if (str == null) {
                str5 = "isDeleted";
                str4 = "' AND ";
                str3 = "UUID";
                str7 = "_display_name";
                str6 = " = 0";
                i2 = 1;
                str8 = null;
                cursorQuery = readableDatabase.query("memo", null, "isDeleted = 0", null, null, null, null);
            } else {
                str3 = "UUID";
                str4 = "' AND ";
                str5 = "isDeleted";
                str6 = " = 0";
                str7 = "_display_name";
                i2 = 1;
                Cursor cursorQuery3 = readableDatabase.query("memo", null, "UUID = '" + str + "' AND isDeleted = 0", null, null, null, null);
                try {
                    if (i == 1) {
                        deleteMemo(str);
                    } else if (i == 2 && isAlreadyConverted(str)) {
                        cursorQuery = cursorQuery3;
                        str8 = AppDelegator.getInstance().getNoteFilePath(this.mContext) + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + "[" + str + "].sdoc";
                    }
                    cursorQuery = cursorQuery3;
                    str8 = null;
                } catch (Exception e) {
                    e = e;
                    cursor = cursorQuery3;
                    cursor2 = null;
                    str2 = null;
                    try {
                        DocumentLogger.m7181i(TAG, "convertToSDoc() " + e);
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        readableDatabase.close();
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        readableDatabase.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery3;
                    cursor2 = null;
                    readableDatabase.endTransaction();
                    if (cursor != null) {
                    }
                    if (cursor2 != null) {
                    }
                    readableDatabase.close();
                    throw th;
                }
            }
            try {
                String absolutePath = "";
                File filesDir = this.mContext.getFilesDir();
                if (filesDir != null) {
                    try {
                        File parentFile = filesDir.getParentFile();
                        if (parentFile != null) {
                            absolutePath = parentFile.getAbsolutePath();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = cursorQuery;
                        cursor2 = null;
                        str2 = null;
                        DocumentLogger.m7181i(TAG, "convertToSDoc() " + e);
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        readableDatabase.close();
                        return str2;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursorQuery;
                        cursor2 = null;
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        readableDatabase.close();
                        throw th;
                    }
                }
                String str12 = absolutePath;
                int count = cursorQuery.getCount();
                int i5 = i2;
                int i6 = 0;
                cursor2 = null;
                str2 = null;
                while (cursorQuery.moveToNext()) {
                    try {
                        DocumentLogger.m7181i(TAG, str11 + i6 + " )");
                        sDocData = new Converter.SDocData();
                        sDocData.uuid = cursorQuery.getString(cursorQuery.getColumnIndex(str3));
                        sDocData.title = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        sDocData.content = cursorQuery.getString(cursorQuery.getColumnIndex("content"));
                        sDocData.categoryUUID = cursorQuery.getString(cursorQuery.getColumnIndex("categoryUUID"));
                        sDocData.lastModifiedAt = cursorQuery.getString(cursorQuery.getColumnIndex("lastModifiedAt"));
                        sDocData.createdAt = cursorQuery.getString(cursorQuery.getColumnIndex("createdAt"));
                        sDocData.favorite = "0";
                    } catch (Exception e3) {
                        e = e3;
                        cursor3 = cursorQuery;
                    } catch (Throwable th4) {
                        th = th4;
                        cursor3 = cursorQuery;
                    }
                    try {
                        sDocData.favorite = cursorQuery.getString(cursorQuery.getColumnIndex("isFavorite"));
                    } catch (IllegalStateException e5) {
                        DocumentLogger.m7179e(TAG, "No Favorite Data :" + e5);
                    } catch (Exception e6) {
                        e = e6;
                        cursor = cursorQuery;
                        DocumentLogger.m7181i(TAG, "convertToSDoc() " + e);
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        readableDatabase.close();
                        return str2;
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = cursorQuery;
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        readableDatabase.close();
                        throw th;
                    }
                    DocumentLogger.m7181i(TAG, str11 + i6 + " ) : title : " + SDocUtil.logPath(sDocData.title) + " / sDocData.content : " + SDocUtil.logPath(sDocData.content));
                    Converter.SDocDBData sDocDBData = new Converter.SDocDBData();
                    sDocDBData.prevUUID = sDocData.uuid;
                    sDocDBData.strippedContent = cursorQuery.getString(cursorQuery.getColumnIndex("strippedContent"));
                    sDocDBData.lastModifiedTime = sDocData.lastModifiedAt;
                    sDocDBData.favorite = sDocData.favorite;
                    String str13 = sDocData.categoryUUID;
                    if (str13 == null || !map.containsKey(str13)) {
                        cursor3 = cursorQuery;
                        str9 = str11;
                    } else {
                        String str14 = (String) map.get(sDocData.categoryUUID);
                        cursor3 = cursorQuery;
                        try {
                            str9 = str11;
                            String categoryUUID = AppDelegator.getInstance().getCategoryUUID(this.mContext, str14, false);
                            if (categoryUUID.equals("1")) {
                                categoryUUID = AppDelegator.getInstance().addCategory(this.mContext, str14);
                            }
                            sDocDBData.category = categoryUUID;
                        } catch (Exception e7) {
                            e = e7;
                            cursor = cursor3;
                            DocumentLogger.m7181i(TAG, "convertToSDoc() " + e);
                            readableDatabase.endTransaction();
                            if (cursor != null) {
                            }
                            if (cursor2 != null) {
                            }
                            readableDatabase.close();
                            return str2;
                        } catch (Throwable th6) {
                            th = th6;
                            cursor = cursor3;
                            readableDatabase.endTransaction();
                            if (cursor != null) {
                            }
                            if (cursor2 != null) {
                            }
                            readableDatabase.close();
                            throw th;
                        }
                    }
                    String str15 = str8;
                    StringBuilder sb = new StringBuilder();
                    sb.append("memoUUID = '");
                    sb.append(sDocData.uuid);
                    String str16 = str4;
                    sb.append(str16);
                    String str17 = str5;
                    sb.append(str17);
                    String str18 = str12;
                    String str19 = str6;
                    sb.append(str19);
                    int i7 = i6;
                    int i8 = i5;
                    str5 = str17;
                    HashMap map2 = map;
                    int i9 = count;
                    Cursor cursorQuery4 = readableDatabase.query("file", null, sb.toString(), null, null, null, null);
                    try {
                        try {
                            ArrayList arrayList = new ArrayList();
                            while (cursorQuery4.moveToNext()) {
                                ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
                                converterFileDataAdapter.uuid = cursorQuery4.getString(cursorQuery4.getColumnIndex(str3));
                                converterFileDataAdapter.memoUUID = cursorQuery4.getString(cursorQuery4.getColumnIndex("memoUUID"));
                                converterFileDataAdapter.mime_type = cursorQuery4.getString(cursorQuery4.getColumnIndex("mime_type"));
                                String str20 = str7;
                                converterFileDataAdapter.display_name = cursorQuery4.getString(cursorQuery4.getColumnIndex(str20));
                                converterFileDataAdapter.size = cursorQuery4.getString(cursorQuery4.getColumnIndex("_size"));
                                converterFileDataAdapter.orientation = cursorQuery4.getString(cursorQuery4.getColumnIndex("orientation"));
                                String string3 = cursorQuery4.getString(cursorQuery4.getColumnIndex("_data"));
                                converterFileDataAdapter.data = string3;
                                if (string3 != null) {
                                    StringBuilder sb2 = new StringBuilder();
                                    str10 = str3;
                                    sb2.append(this.mAttachedFileFolder);
                                    sb2.append("/");
                                    converterFileDataAdapter.data = string3.replaceAll(OLD_FILE_DIR, sb2.toString());
                                } else {
                                    str10 = str3;
                                }
                                DocumentLogger.m7181i(TAG, "coreConverter - file path : " + SDocUtil.logPath(converterFileDataAdapter.data));
                                converterFileDataAdapter.curFullPath = str18 + converterFileDataAdapter.data;
                                arrayList.add(converterFileDataAdapter);
                                str3 = str10;
                                str7 = str20;
                            }
                            String str21 = str7;
                            String str22 = str3;
                            cursorQuery4.close();
                            String strNewUUID = AppDelegator.getInstance().newUUID(this.mContext);
                            try {
                                Converter.updateSDocDBWithUuid(this.mContext, Converter.createSDoc(this.mContext, sDocData, arrayList, str15), sDocDBData, strNewUUID);
                                if (z) {
                                    deleteMemo(readableDatabase, sDocData.uuid);
                                }
                                if (progressListener != null) {
                                    ArrayList<String> arrayList2 = new ArrayList<>();
                                    arrayList2.add(strNewUUID);
                                    i5 = i8 + 1;
                                    i4 = i9;
                                    progressListener.onProgress(i8, i4, arrayList2);
                                } else {
                                    i4 = i9;
                                    i5 = i8;
                                }
                                int i10 = i7 + 1;
                                str2 = strNewUUID;
                                str12 = str18;
                                cursor2 = cursorQuery4;
                                count = i4;
                                map = map2;
                                str3 = str22;
                                str11 = str9;
                                str6 = str19;
                                str4 = str16;
                                i6 = i10;
                                str8 = str15;
                                str7 = str21;
                                cursorQuery = cursor3;
                            } catch (Exception e8) {
                                e = e8;
                                cursor = cursor3;
                                str2 = strNewUUID;
                                cursor2 = cursorQuery4;
                                DocumentLogger.m7181i(TAG, "convertToSDoc() " + e);
                                readableDatabase.endTransaction();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (cursor2 != null) {
                                }
                                readableDatabase.close();
                                return str2;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            cursor = cursor3;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        cursor = cursor3;
                        cursor2 = cursorQuery4;
                        readableDatabase.endTransaction();
                        if (cursor != null) {
                        }
                        if (cursor2 != null) {
                        }
                        readableDatabase.close();
                        throw th;
                    }
                }
                cursor3 = cursorQuery;
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                cursor3.close();
            } catch (Exception e10) {
                e = e10;
                cursor = cursorQuery;
            } catch (Throwable th8) {
                th = th8;
                cursor = cursorQuery;
            }
        } catch (Exception e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th9) {
            th = th9;
            cursor = null;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        readableDatabase.close();
        return str2;
    }

    private static void createIndexesFor(SQLiteDatabase sQLiteDatabase, String str) {
        String strM775q = AbstractC0541b.m775q("CREATE INDEX IF NOT EXISTS ", str, "_uuid ON ", str, " (UUID);");
        String strM775q2 = AbstractC0541b.m775q("CREATE INDEX IF NOT EXISTS ", str, "_sac1 ON ", str, " (isDirty);");
        String strM775q3 = AbstractC0541b.m775q("CREATE INDEX IF NOT EXISTS ", str, "_sac2 ON ", str, " (isDeleted);");
        String strM775q4 = AbstractC0541b.m775q("CREATE INDEX IF NOT EXISTS ", str, "_accountName ON ", str, " (accountName);");
        String strM775q5 = AbstractC0541b.m775q("CREATE INDEX IF NOT EXISTS ", str, "_accountType ON ", str, " (accountType);");
        sQLiteDatabase.execSQL(strM775q);
        sQLiteDatabase.execSQL(strM775q2);
        sQLiteDatabase.execSQL(strM775q3);
        sQLiteDatabase.execSQL(strM775q4);
        sQLiteDatabase.execSQL(strM775q5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createTables(SQLiteDatabase sQLiteDatabase) {
        DocumentLogger.m7181i(TAG, "createTables()");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS memo ( _id INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT    NOT NULL UNIQUE, isDirty INTEGER NOT NULL DEFAULT 0, isDeleted INTEGER NOT NULL DEFAULT 0, accountType TEXT, accountName TEXT DEFAULT '', sync1 INTEGER, sync2 TEXT, isNeedUpsync INTEGER NOT NULL DEFAULT 0, createdAt INTEGER NOT NULL, lastModifiedAt INTEGER NOT NULL, categoryUUID TEXT    NOT NULL DEFAULT '', title TEXT    NOT NULL DEFAULT '', content TEXT    NOT NULL DEFAULT '', xmlContent TEXT    NOT NULL DEFAULT '', display_Content TEXT    NOT NULL DEFAULT '', vrfileUUID TEXT    NOT NULL DEFAULT '', strippedContent TEXT    NOT NULL DEFAULT '', _data TEXT    NOT NULL DEFAULT '', _phoneNum TEXT, isFavorite INTEGER NOT NULL DEFAULT 0);");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS memo_createdAt ON memo (createdAt);");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS memo_lastModifiedAt ON memo (lastModifiedAt);");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS memo_categoryUUID ON memo (categoryUUID);");
                createIndexesFor(sQLiteDatabase, "memo");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file ( _id INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT    NOT NULL UNIQUE, isDirty INTEGER NOT NULL DEFAULT 0, isDeleted INTEGER NOT NULL DEFAULT 0, accountType TEXT, accountName TEXT DEFAULT '', sync1 INTEGER, sync2 TEXT, isNeedUpsync INTEGER NOT NULL DEFAULT 0, memoUUID TEXT    NOT NULL DEFAULT '', mime_type TEXT    NOT NULL DEFAULT 'application/octet-stream', _display_name TEXT    NOT NULL DEFAULT '', _size INTEGER NOT NULL DEFAULT 0, orientation INTEGER NOT NULL DEFAULT 0, _data TEXT    NOT NULL );");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS file_memoUUID ON file (memoUUID);");
                createIndexesFor(sQLiteDatabase, "file");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS category ( _id INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT    NOT NULL UNIQUE, isDirty INTEGER NOT NULL DEFAULT 0, isDeleted INTEGER NOT NULL DEFAULT 0, accountType TEXT, accountName TEXT DEFAULT '', sync1 INTEGER, sync2 TEXT, isNeedUpsync INTEGER NOT NULL DEFAULT 0, orderBy INTEGER NOT NULL DEFAULT 999999, _display_name TEXT    NOT NULL );");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS category_orderBy ON category (orderBy);");
                createIndexesFor(sQLiteDatabase, "category");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS _sync_state ( _id INTEGER PRIMARY KEY AUTOINCREMENT, accountType TEXT, accountName TEXT DEFAULT '', data TEXT );");
                createTriggers(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DocumentLogger.m7180e(TAG, "createTables()", e);
                throw e;
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private static void createTriggers(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TRIGGER trg_memo_01 AFTER UPDATE OF isDeleted ON memo FOR EACH ROW BEGIN     UPDATE file SET isDirty=1, isDeleted=NEW.isDeleted WHERE memoUUID IS NEW.UUID; END; ");
        sQLiteDatabase.execSQL("CREATE TRIGGER trg_memo_02 AFTER UPDATE OF isDeleted ON category FOR EACH ROW WHEN new.isDeleted IS 1 BEGIN     UPDATE memo SET isDirty=1, categoryUUID='' WHERE categoryUUID IS NEW.UUID; END; ");
    }

    private boolean deleteMemo(String str) {
        ArrayList<String> noteFilePathList;
        String strSubstring;
        if (str == null || (noteFilePathList = AppDelegator.getInstance().getNoteFilePathList(this.mContext, false)) == null) {
            return false;
        }
        for (int i = 0; i < noteFilePathList.size(); i++) {
            String str2 = noteFilePathList.get(i);
            if (str2 != null) {
                int iIndexOf = str2.indexOf("[");
                int iLastIndexOf = str2.lastIndexOf("]");
                if (iIndexOf >= 0 && iLastIndexOf >= 0 && iLastIndexOf > iIndexOf) {
                    int i2 = iIndexOf + 1;
                    if (iLastIndexOf - i2 > 0 && (strSubstring = str2.substring(i2, iLastIndexOf)) != null && strSubstring.length() > 0 && strSubstring.compareTo(str) == 0) {
                        AppDelegator.getInstance().deleteSDoc(this.mContext, AppDelegator.getInstance().getSDocUUID(this.mContext, str2), true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void dropIndexesFor(SQLiteDatabase sQLiteDatabase, String str) {
        String strM773o = AbstractC0541b.m773o("DROP INDEX IF EXISTS ", str, "_uuid;");
        String strM773o2 = AbstractC0541b.m773o("DROP INDEX IF EXISTS ", str, "_sac1;");
        String strM773o3 = AbstractC0541b.m773o("DROP INDEX IF EXISTS ", str, "_sac2;");
        String strM773o4 = AbstractC0541b.m773o("DROP INDEX IF EXISTS ", str, "_accountName;");
        sQLiteDatabase.execSQL(strM773o);
        sQLiteDatabase.execSQL(strM773o2);
        sQLiteDatabase.execSQL(strM773o3);
        sQLiteDatabase.execSQL(strM773o4);
        sQLiteDatabase.execSQL("DROP INDEX IF EXISTS " + str + "_accountType;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dropTables(SQLiteDatabase sQLiteDatabase) {
        DocumentLogger.m7179e(TAG, "dropTables()");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                dropIndexesFor(sQLiteDatabase, "memo");
                sQLiteDatabase.execSQL("DROP INDEX IF EXISTS memo_createdAt;");
                sQLiteDatabase.execSQL("DROP INDEX IF EXISTS memo_lastModifiedAt;");
                sQLiteDatabase.execSQL("DROP INDEX IF EXISTS memo_categoryUUID;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo;");
                dropIndexesFor(sQLiteDatabase, "file");
                sQLiteDatabase.execSQL("DROP INDEX IF EXISTS file_memoUUID;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file;");
                dropIndexesFor(sQLiteDatabase, "category");
                sQLiteDatabase.execSQL("DROP INDEX IF EXISTS category_orderBy;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS category;");
                dropTriggers(sQLiteDatabase);
            } catch (SQLException e) {
                DocumentLogger.m7180e(TAG, "dropTables()", e);
                throw e;
            }
        } finally {
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
    }

    private static void dropTriggers(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trg_memo_01;");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trg_memo_02;");
    }

    private static void extractImageFile(String str, Uri uri, String str2, String str3, int i, ArrayList<ConverterFileDataAdapter> arrayList) {
        String str4 = (TextUtils.isEmpty(str3) || !str3.matches(".*\\.(wbmp|WBMP)")) ? "image/jpeg" : ImageUtil.MIME_TYPE_WBMP;
        if (str3 != null && str3.equals(AudioFormat.ExtType.EXT_M4A)) {
            if (uri != null && (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("null"))) {
                str3 = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str3)) {
                    StringBuilder sb = new StringBuilder("memo_");
                    sb.append(uri.toString());
                    sb.append(Extension.DOT);
                    str3 = AbstractC4539a.m3198h(sb, str4, str4.indexOf("/") + 1);
                } else if (!str3.matches(".*\\.(png|jpg|bmp|gif|jpeg|wbmp|PNG|JPG|GIF|BMP|JPEG|WBMP)")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(uri.getLastPathSegment());
                    sb2.append(Extension.DOT);
                    str3 = AbstractC4539a.m3198h(sb2, str4, str4.indexOf("/") + 1);
                }
            }
            if (!TextUtils.isEmpty(str3) && !str3.startsWith(ImageUtil.MEMO_DRAWING_PREFIX)) {
                str3 = AbstractC0541b.m756B(str3.replaceAll("\\.(png|jpg|bmp|gif|jpeg|PNG|JPG|GIF|BMP|JPEG)", ""), ".jpg");
            }
        }
        if (str3 == null || str3.equals(AudioFormat.ExtType.EXT_M4A)) {
            return;
        }
        ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
        converterFileDataAdapter.uuid = str2.substring(str2.lastIndexOf("/") + 1, str2.length());
        converterFileDataAdapter.memoUUID = str;
        converterFileDataAdapter.mime_type = str4;
        converterFileDataAdapter.display_name = str3;
        converterFileDataAdapter.orientation = Integer.toString(i);
        converterFileDataAdapter.data = str2;
        converterFileDataAdapter.curFullPath = str2;
        arrayList.add(converterFileDataAdapter);
    }

    private static void insertVoiceAttachment(String str, String str2, String str3, ArrayList<ConverterFileDataAdapter> arrayList) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(File.separator);
        File file = new File(AbstractC0541b.m756B(sbM1324q.toString(), str3));
        if (file.exists()) {
            ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
            converterFileDataAdapter.uuid = str3.substring(str3.lastIndexOf("/") + 1, str3.length());
            converterFileDataAdapter.memoUUID = str2;
            converterFileDataAdapter.mime_type = "audio/mp4";
            converterFileDataAdapter.display_name = "Voice";
            converterFileDataAdapter.orientation = Integer.toString(0);
            converterFileDataAdapter.data = file.getAbsolutePath();
            converterFileDataAdapter.curFullPath = file.getAbsolutePath();
            arrayList.add(converterFileDataAdapter);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(5:103|3|94|4|5)|(4:(13:6|(4:98|8|(3:10|(3:12|(2:14|(2:16|110)(2:21|(2:23|111)(2:24|(2:26|112)(2:27|(2:29|108)(1:113)))))(1:109)|30)|107)(1:106)|31)(1:105)|19|20|58|(2:96|60)|64|(1:68)|(1:72)|73|101|74|75)|101|74|75)|32|33|(4:88|35|(2:45|114)(2:39|(2:41|116)(1:115))|46)|90|47|64|(2:66|68)|(2:70|72)|73|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0124, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0125, code lost:
    
        r5 = new java.lang.StringBuilder("parseMemoXML ");
     */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String parseMemoXML(Context context, String str) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String textContent;
        String textContent2;
        String attribute;
        String attribute2;
        String attribute3;
        ArrayList arrayList;
        Document document;
        NodeList elementsByTagName;
        int length;
        int i;
        try {
            fileInputStream2 = new FileInputStream(new File(str + File.separator + "memo_content.xml").getAbsolutePath());
            try {
                try {
                    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(fileInputStream2));
                    document.getDocumentElement().normalize();
                    elementsByTagName = document.getElementsByTagName(XML_TAG_HEADER);
                    length = elementsByTagName.getLength();
                    i = 0;
                    attribute = null;
                    attribute2 = null;
                    attribute3 = null;
                } catch (Exception e) {
                    e = e;
                    textContent = null;
                    textContent2 = null;
                    attribute = null;
                    attribute2 = null;
                    attribute3 = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e2) {
                    DocumentLogger.m7178d(TAG, "parseMemoXML " + e2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
        }
        try {
            while (true) {
                short s = 1;
                if (i >= length) {
                    break;
                }
                try {
                    Node nodeItem = elementsByTagName.item(i);
                    if (nodeItem.getNodeType() == 1) {
                        NodeList elementsByTagName2 = ((Element) nodeItem).getElementsByTagName(XML_TAG_MEMO_META);
                        int length2 = elementsByTagName2.getLength();
                        int i2 = 0;
                        while (i2 < length2) {
                            Node nodeItem2 = elementsByTagName2.item(i2);
                            NodeList nodeList = elementsByTagName2;
                            if (nodeItem2.getNodeType() == s) {
                                Element element = (Element) nodeItem2;
                                if (element.hasAttribute(XML_TAG_MEMO_META_TITLE)) {
                                    attribute = element.getAttribute(XML_TAG_MEMO_META_TITLE);
                                } else if (element.hasAttribute(XML_TAG_MEMO_META_UUID)) {
                                    attribute2 = element.getAttribute(XML_TAG_MEMO_META_UUID);
                                } else if (element.hasAttribute(XML_TAG_MEMO_META_CREATEDTIME)) {
                                    attribute3 = element.getAttribute(XML_TAG_MEMO_META_CREATEDTIME);
                                } else if (element.hasAttribute(XML_TAG_MEMO_META_FAVOURITE)) {
                                    Boolean.parseBoolean(element.getAttribute(XML_TAG_MEMO_META_FAVOURITE));
                                }
                            }
                            i2++;
                            elementsByTagName2 = nodeList;
                            s = 1;
                        }
                    }
                    i++;
                } catch (Exception e5) {
                    e = e5;
                    textContent = null;
                    textContent2 = null;
                }
                e = e5;
                textContent = null;
                textContent2 = null;
                DocumentLogger.m7181i(TAG, "parseMemoXML fail" + e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        IOException e7 = e6;
                        StringBuilder sb = new StringBuilder("parseMemoXML ");
                        sb.append(e7);
                        DocumentLogger.m7178d(TAG, sb.toString());
                    }
                }
                arrayList = new ArrayList();
                if (textContent2 != null && !textContent2.isEmpty()) {
                    translateHtmlContent(str, attribute2, textContent2, arrayList);
                }
                if (textContent != null && !textContent.isEmpty()) {
                    insertVoiceAttachment(str, attribute2, textContent, arrayList);
                }
                Converter.SDocData sDocData = new Converter.SDocData();
                sDocData.uuid = attribute2;
                sDocData.title = attribute;
                sDocData.content = textContent2;
                sDocData.createdAt = attribute3;
                sDocData.lastModifiedAt = Long.toString(new Date().getTime());
                return Converter.createSDoc(context, sDocData, arrayList, null);
            }
            return Converter.createSDoc(context, sDocData, arrayList, null);
        } catch (InsufficientStorageException e8) {
            DocumentLogger.m7179e(TAG, "parseMemoXML : file to createSDOC " + e8);
            return null;
        } catch (IOException e9) {
            AbstractC6670b.m4755p("parseMemoXML : file to createSDOC ", e9, TAG);
            return null;
        }
        NodeList elementsByTagName3 = document.getElementsByTagName(XML_TAG_CONTENTS);
        int length3 = elementsByTagName3.getLength();
        textContent = null;
        textContent2 = null;
        for (int i4 = 0; i4 < length3; i4++) {
            try {
                Node nodeItem3 = elementsByTagName3.item(i4);
                if (nodeItem3 != null && nodeItem3.getNodeType() == 1) {
                    Element element2 = (Element) nodeItem3;
                    textContent2 = element2.getElementsByTagName(XML_TAG_CONTENTS_CONTENT).item(0).getTextContent();
                    if (element2.getElementsByTagName(XML_TAG_CONTENTS_VOICE_CONTENT).item(0) != null) {
                        textContent = element2.getElementsByTagName(XML_TAG_CONTENTS_VOICE_CONTENT).item(0).getTextContent();
                    }
                }
            } catch (Exception e10) {
                e = e10;
            }
        }
        fileInputStream2.close();
        arrayList = new ArrayList();
        if (textContent2 != null) {
            translateHtmlContent(str, attribute2, textContent2, arrayList);
        }
        if (textContent != null) {
            insertVoiceAttachment(str, attribute2, textContent, arrayList);
        }
        Converter.SDocData sDocData2 = new Converter.SDocData();
        sDocData2.uuid = attribute2;
        sDocData2.title = attribute;
        sDocData2.content = textContent2;
        sDocData2.createdAt = attribute3;
        sDocData2.lastModifiedAt = Long.toString(new Date().getTime());
    }

    private static void translateHtmlContent(String str, String str2, String str3, ArrayList<ConverterFileDataAdapter> arrayList) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(File.separator);
        String string = sbM1324q.toString();
        int i = 0;
        String strSubstring = "";
        int iIndexOf = str3.indexOf("<img src=", 0);
        while (iIndexOf > 0) {
            int iIndexOf2 = str3.indexOf(" orientation=", iIndexOf + 1);
            int iIndexOf3 = str3.indexOf(" altText=", iIndexOf2 + 1);
            int iIndexOf4 = str3.indexOf("/", iIndexOf3) - 1;
            int i2 = iIndexOf3 + 10;
            if (iIndexOf4 > i2) {
                try {
                    strSubstring = str3.substring(i2, iIndexOf4);
                    if (strSubstring != null && strSubstring.endsWith("\"")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    DocumentLogger.m7178d(TAG, "translateHtmlcontent " + e);
                }
            } else if (strSubstring != null) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            String str4 = strSubstring;
            String str5 = (String) str3.subSequence(iIndexOf + 10, iIndexOf2 - 1);
            try {
                i = Integer.parseInt((String) str3.subSequence(iIndexOf2 + 14, iIndexOf3 - 1));
            } catch (NumberFormatException e2) {
                DocumentLogger.m7178d(TAG, "translateHtmlContent " + e2);
            }
            int i4 = i;
            File file = new File(AbstractC0541b.m756B(string, str5));
            if (file.exists()) {
                extractImageFile(str2, Uri.fromFile(file), file.getAbsolutePath(), str4, i4, arrayList);
            }
            iIndexOf = str3.indexOf("<img src", iIndexOf2);
            strSubstring = str4;
            i = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[PHI: r1 r2
      0x006c: PHI (r1v7 android.database.sqlite.SQLiteDatabase) = (r1v5 android.database.sqlite.SQLiteDatabase), (r1v8 android.database.sqlite.SQLiteDatabase) binds: [B:30:0x0087, B:18:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r2v6 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v8 android.database.Cursor) binds: [B:30:0x0087, B:18:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updatePathsToRelative(SQLiteDatabase sQLiteDatabase) throws Throwable {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursorQuery;
        Cursor cursorQuery2;
        Cursor cursor = null;
        try {
            sQLiteDatabase2 = sQLiteDatabase;
            try {
                cursorQuery = sQLiteDatabase2.query("memo", new String[]{"UUID", "_data"}, null, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                sQLiteDatabase2.beginTransaction();
                                do {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("_data", ConverterUtils.getRelativePath(string2));
                                    sQLiteDatabase2.update("memo", contentValues, "UUID = '" + string + "'", null);
                                } while (cursorQuery.moveToNext());
                                sQLiteDatabase2.setTransactionSuccessful();
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            DocumentLogger.m7180e(TAG, "Exception occurred in updatePathsToRelative() in memoCursor.", e);
                            if (cursorQuery != null) {
                            }
                            sQLiteDatabase2.endTransaction();
                            try {
                                cursorQuery2 = sQLiteDatabase2.query("file", new String[]{"UUID", "_data"}, null, null, null, null, null);
                                if (cursorQuery2 != null) {
                                }
                                if (cursorQuery2 != null) {
                                }
                                sQLiteDatabase2.endTransaction();
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase2.endTransaction();
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
                DocumentLogger.m7180e(TAG, "Exception occurred in updatePathsToRelative() in memoCursor.", e);
                if (cursorQuery != null) {
                }
                sQLiteDatabase2.endTransaction();
                cursorQuery2 = sQLiteDatabase2.query("file", new String[]{"UUID", "_data"}, null, null, null, null, null);
                if (cursorQuery2 != null) {
                }
                if (cursorQuery2 != null) {
                }
                sQLiteDatabase2.endTransaction();
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                }
                sQLiteDatabase2.endTransaction();
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            sQLiteDatabase2 = sQLiteDatabase;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase2 = sQLiteDatabase;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        sQLiteDatabase2.endTransaction();
        try {
            cursorQuery2 = sQLiteDatabase2.query("file", new String[]{"UUID", "_data"}, null, null, null, null, null);
            if (cursorQuery2 != null) {
                try {
                    if (cursorQuery2.moveToFirst()) {
                        sQLiteDatabase2.beginTransaction();
                        do {
                            String string3 = cursorQuery2.getString(cursorQuery2.getColumnIndex("UUID"));
                            String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndex("_data"));
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("_data", ConverterUtils.getRelativePath(string4));
                            sQLiteDatabase2.update("file", contentValues2, "UUID = '" + string3 + "'", null);
                        } while (cursorQuery2.moveToNext());
                        sQLiteDatabase2.setTransactionSuccessful();
                    }
                } catch (SQLiteException e5) {
                    e = e5;
                    cursor = cursorQuery2;
                    DocumentLogger.m7180e(TAG, "Exception occurred in updatePathsToRelative() in fileCursor.", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = cursorQuery2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.endTransaction();
                    throw th;
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
        } catch (SQLiteException e6) {
            e = e6;
        }
        sQLiteDatabase2.endTransaction();
    }

    private void updateTimestampsToUTC(SQLiteDatabase sQLiteDatabase) throws Throwable {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor = null;
        try {
            sQLiteDatabase2 = sQLiteDatabase;
            try {
                try {
                    Cursor cursorQuery = sQLiteDatabase2.query("memo", new String[]{"UUID", "createdAt", "lastModifiedAt"}, null, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                sQLiteDatabase2.beginTransaction();
                                do {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("createdAt"));
                                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("lastModifiedAt"));
                                    Calendar calendar = Calendar.getInstance();
                                    long j3 = calendar.get(15) + calendar.get(16);
                                    long j5 = j + j3;
                                    long j6 = j2 + j3;
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("createdAt", Long.valueOf(j5));
                                    contentValues.put("lastModifiedAt", Long.valueOf(j6));
                                    sQLiteDatabase2.update("memo", contentValues, "UUID = '" + string + "'", null);
                                } while (cursorQuery.moveToNext());
                                sQLiteDatabase2.setTransactionSuccessful();
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            cursor = cursorQuery;
                            DocumentLogger.m7180e(TAG, "Exception occurred in updateTimestampsToUTC().", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            sQLiteDatabase2.endTransaction();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            sQLiteDatabase2.endTransaction();
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    sQLiteDatabase2.endTransaction();
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            sQLiteDatabase2 = sQLiteDatabase;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    public boolean convertToSDoc(boolean z, ProgressListener progressListener) {
        return coreConverter(z, null, progressListener, 0) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0354 A[PHI: r4 r5 r13 r20
      0x0354: PHI (r4v5 java.util.ArrayList<com.samsung.android.support.senl.document.data.MemoMetaDataItem>) = 
      (r4v4 java.util.ArrayList<com.samsung.android.support.senl.document.data.MemoMetaDataItem>)
      (r4v7 java.util.ArrayList<com.samsung.android.support.senl.document.data.MemoMetaDataItem>)
      (r4v21 java.util.ArrayList<com.samsung.android.support.senl.document.data.MemoMetaDataItem>)
     binds: [B:157:0x03b7, B:167:0x03da, B:127:0x034e] A[DONT_GENERATE, DONT_INLINE]
      0x0354: PHI (r5v4 android.database.sqlite.SQLiteDatabase) = 
      (r5v3 android.database.sqlite.SQLiteDatabase)
      (r5v6 android.database.sqlite.SQLiteDatabase)
      (r5v7 android.database.sqlite.SQLiteDatabase)
     binds: [B:157:0x03b7, B:167:0x03da, B:127:0x034e] A[DONT_GENERATE, DONT_INLINE]
      0x0354: PHI (r13v7 ??) = (r13v6 ??), (r13v9 ??), (r13v10 ??) binds: [B:157:0x03b7, B:167:0x03da, B:127:0x034e] A[DONT_GENERATE, DONT_INLINE]
      0x0354: PHI (r20v6 android.database.Cursor) = (r20v5 android.database.Cursor), (r20v8 android.database.Cursor), (r20v16 android.database.Cursor) binds: [B:157:0x03b7, B:167:0x03da, B:127:0x034e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MemoMetaDataItem> getMemoMetaData() throws Throwable {
        Cursor cursor;
        String str;
        ArrayList<MemoMetaDataItem> arrayList;
        String str2;
        String str3;
        ArrayList<MemoMetaDataItem> arrayList2;
        Cursor cursorQuery;
        Cursor cursor2;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        Cursor cursor3;
        SQLiteDatabase sQLiteDatabase;
        String string6;
        Cursor cursor4;
        Cursor cursor5;
        Cursor cursorQuery2;
        File parentFile;
        String str4 = "0";
        SQLiteDatabase readableDatabase = getReadableDatabase();
        ?? map = 0;
        if (readableDatabase == null) {
            DocumentLogger.m7181i(TAG, "getMemoMetaData DB is empty");
            return null;
        }
        DocumentLogger.m7181i(TAG, "getMemoMetaData");
        ArrayList<MemoMetaDataItem> arrayList3 = new ArrayList<>();
        try {
            try {
                try {
                    readableDatabase.beginTransaction();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (SQLException e) {
                e = e;
                str2 = "convertToSDoc() ";
                arrayList = arrayList3;
            }
            try {
                map = new HashMap();
                Cursor cursorQuery3 = readableDatabase.query("category", null, "isDeleted = 0", null, null, null, null);
                while (cursorQuery3.moveToNext()) {
                    try {
                        try {
                            try {
                                String string7 = cursorQuery3.getString(cursorQuery3.getColumnIndex("UUID"));
                                String string8 = cursorQuery3.getString(cursorQuery3.getColumnIndex("_display_name"));
                                String string9 = cursorQuery3.getString(cursorQuery3.getColumnIndex("orderBy"));
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(string8);
                                arrayList4.add(string9);
                                map.put(string7, arrayList4);
                                DocumentLogger.m7181i(TAG, "getMemoMetaData - category / " + string7 + " / " + string8);
                            } catch (SQLException e2) {
                                e = e2;
                                str2 = "convertToSDoc() ";
                                cursor = cursorQuery3;
                                arrayList = arrayList3;
                                map = 0;
                                DocumentLogger.m7181i(TAG, str2 + e);
                                readableDatabase.endTransaction();
                                if (map != 0) {
                                    map.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                readableDatabase.close();
                                return arrayList;
                            }
                        } catch (SQLException e3) {
                            e = e3;
                            str = "convertToSDoc() ";
                            cursor = cursorQuery3;
                            arrayList = arrayList3;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str = "convertToSDoc() ";
                        cursor = cursorQuery3;
                        arrayList = arrayList3;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery3;
                    }
                }
                String absolutePath = "";
                File filesDir = this.mContext.getFilesDir();
                if (filesDir != null && (parentFile = filesDir.getParentFile()) != null) {
                    absolutePath = parentFile.getAbsolutePath();
                }
                str3 = absolutePath;
                cursor = cursorQuery3;
                str = "convertToSDoc() ";
                arrayList2 = arrayList3;
            } catch (SQLException e6) {
                e = e6;
                arrayList = arrayList3;
                str2 = "convertToSDoc() ";
                map = 0;
                cursor = null;
                DocumentLogger.m7181i(TAG, str2 + e);
                readableDatabase.endTransaction();
                if (map != 0) {
                }
                if (cursor != null) {
                }
                readableDatabase.close();
                return arrayList;
            }
        } catch (Exception e7) {
            e = e7;
            str = "convertToSDoc() ";
            arrayList = arrayList3;
            map = 0;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            map = 0;
            cursor = null;
        }
        try {
            cursorQuery = readableDatabase.query("memo", null, "isDeleted = 0", null, null, null, null);
        } catch (SQLException e8) {
            e = e8;
            arrayList = arrayList2;
            str2 = str;
            map = 0;
            DocumentLogger.m7181i(TAG, str2 + e);
            readableDatabase.endTransaction();
            if (map != 0) {
            }
            if (cursor != null) {
            }
            readableDatabase.close();
            return arrayList;
        } catch (Exception e9) {
            e = e9;
            arrayList = arrayList2;
            map = 0;
            DocumentLogger.m7181i(TAG, str + e);
            readableDatabase.endTransaction();
            if (map != 0) {
            }
            if (cursor != null) {
            }
            readableDatabase.close();
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            map = 0;
            readableDatabase.endTransaction();
            if (map != 0) {
            }
            if (cursor != null) {
            }
            readableDatabase.close();
            throw th;
        }
        while (cursorQuery.moveToNext()) {
            try {
                DocumentLogger.m7181i(TAG, "getMemoMetaData = memo data : " + arrayList2.size());
                string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                string3 = cursorQuery.getString(cursorQuery.getColumnIndex("strippedContent"));
                string4 = cursorQuery.getString(cursorQuery.getColumnIndex("lastModifiedAt"));
                string5 = cursorQuery.getString(cursorQuery.getColumnIndex("createdAt"));
            } catch (SQLException e10) {
                e = e10;
                cursor2 = cursorQuery;
            } catch (Exception e11) {
                e = e11;
                cursor2 = cursorQuery;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                string6 = cursorQuery.getString(cursorQuery.getColumnIndex("isFavorite"));
                sQLiteDatabase = readableDatabase;
            } catch (SQLException e12) {
                e = e12;
                cursor4 = cursorQuery;
                str2 = str;
                arrayList = arrayList2;
                map = cursor4;
                DocumentLogger.m7181i(TAG, str2 + e);
                readableDatabase.endTransaction();
                if (map != 0) {
                }
                if (cursor != null) {
                }
                readableDatabase.close();
                return arrayList;
            } catch (IllegalStateException e13) {
                StringBuilder sb = new StringBuilder();
                sQLiteDatabase = readableDatabase;
                sb.append("No Favorite Data :");
                sb.append(e13);
                DocumentLogger.m7179e(TAG, sb.toString());
                string6 = str4;
            } catch (Exception e14) {
                e = e14;
                cursor3 = cursorQuery;
                arrayList = arrayList2;
                map = cursor3;
                DocumentLogger.m7181i(TAG, str + e);
                readableDatabase.endTransaction();
                if (map != 0) {
                }
                if (cursor != null) {
                }
                readableDatabase.close();
                return arrayList;
            } catch (Throwable th6) {
                th = th6;
                map = cursorQuery;
                readableDatabase.endTransaction();
                if (map != 0) {
                }
                if (cursor != null) {
                }
                readableDatabase.close();
                throw th;
            }
            String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("categoryUUID"));
            MemoMetaDataItem memoMetaDataItem = new MemoMetaDataItem();
            memoMetaDataItem.setUuid(string);
            memoMetaDataItem.setTitle(string2);
            memoMetaDataItem.setContent(string3);
            if (string6 != null) {
                try {
                    memoMetaDataItem.setIsFavorite(string6.compareTo(str4) != 0);
                    if (string10 != null && string10.length() > 0 && map.containsKey(string10)) {
                        memoMetaDataItem.setCategoryName((String) ((List) map.get(string10)).get(0));
                        memoMetaDataItem.setCategoryOrder((String) ((List) map.get(string10)).get(1));
                    }
                    try {
                        memoMetaDataItem.setLastModifiedAt(string4);
                        memoMetaDataItem.setCreatedAt(string5);
                        cursor5 = cursorQuery;
                    } catch (SQLException e15) {
                        e = e15;
                        readableDatabase = sQLiteDatabase;
                        arrayList = arrayList2;
                        cursor2 = cursorQuery;
                        str2 = str;
                        map = cursor2;
                        DocumentLogger.m7181i(TAG, str2 + e);
                        readableDatabase.endTransaction();
                        if (map != 0) {
                        }
                        if (cursor != null) {
                        }
                        readableDatabase.close();
                        return arrayList;
                    } catch (Exception e16) {
                        e = e16;
                        readableDatabase = sQLiteDatabase;
                        arrayList = arrayList2;
                        cursor2 = cursorQuery;
                        map = cursor2;
                        DocumentLogger.m7181i(TAG, str + e);
                        readableDatabase.endTransaction();
                        if (map != 0) {
                            map.close();
                        }
                        if (cursor != null) {
                        }
                        readableDatabase.close();
                        return arrayList;
                    } catch (Throwable th7) {
                        th = th7;
                        readableDatabase = sQLiteDatabase;
                        cursor2 = cursorQuery;
                        map = cursor2;
                        readableDatabase.endTransaction();
                        if (map != 0) {
                        }
                        if (cursor != null) {
                        }
                        readableDatabase.close();
                        throw th;
                    }
                } catch (SQLException e17) {
                    e = e17;
                    cursor4 = cursorQuery;
                    str2 = str;
                    readableDatabase = sQLiteDatabase;
                    arrayList = arrayList2;
                    map = cursor4;
                    DocumentLogger.m7181i(TAG, str2 + e);
                    readableDatabase.endTransaction();
                    if (map != 0) {
                    }
                    if (cursor != null) {
                    }
                    readableDatabase.close();
                    return arrayList;
                } catch (Exception e18) {
                    e = e18;
                    cursor3 = cursorQuery;
                    readableDatabase = sQLiteDatabase;
                    arrayList = arrayList2;
                    map = cursor3;
                    DocumentLogger.m7181i(TAG, str + e);
                    readableDatabase.endTransaction();
                    if (map != 0) {
                    }
                    if (cursor != null) {
                    }
                    readableDatabase.close();
                    return arrayList;
                } catch (Throwable th8) {
                    th = th8;
                    map = cursorQuery;
                    readableDatabase = sQLiteDatabase;
                    readableDatabase.endTransaction();
                    if (map != 0) {
                    }
                    if (cursor != null) {
                    }
                    readableDatabase.close();
                    throw th;
                }
                try {
                    SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                    cursor2 = cursor5;
                    readableDatabase = sQLiteDatabase2;
                    String str5 = str4;
                } catch (SQLException e19) {
                    e = e19;
                    SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase;
                    cursor2 = cursor5;
                    readableDatabase = sQLiteDatabase3;
                } catch (Exception e20) {
                    e = e20;
                    SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase;
                    cursor2 = cursor5;
                    readableDatabase = sQLiteDatabase4;
                } catch (Throwable th9) {
                    th = th9;
                    SQLiteDatabase sQLiteDatabase5 = sQLiteDatabase;
                    cursor2 = cursor5;
                    readableDatabase = sQLiteDatabase5;
                    map = cursor2;
                    readableDatabase.endTransaction();
                    if (map != 0) {
                    }
                    if (cursor != null) {
                    }
                    readableDatabase.close();
                    throw th;
                }
                try {
                    try {
                        cursorQuery2 = readableDatabase.query("file", null, "memoUUID = '" + string + "' AND isDeleted = 0", null, null, null, null);
                        while (cursorQuery2.moveToNext()) {
                            try {
                                ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
                                converterFileDataAdapter.uuid = cursorQuery2.getString(cursorQuery2.getColumnIndex("UUID"));
                                converterFileDataAdapter.memoUUID = cursorQuery2.getString(cursorQuery2.getColumnIndex("memoUUID"));
                                converterFileDataAdapter.mime_type = cursorQuery2.getString(cursorQuery2.getColumnIndex("mime_type"));
                                converterFileDataAdapter.display_name = cursorQuery2.getString(cursorQuery2.getColumnIndex("_display_name"));
                                converterFileDataAdapter.size = cursorQuery2.getString(cursorQuery2.getColumnIndex("_size"));
                                converterFileDataAdapter.orientation = cursorQuery2.getString(cursorQuery2.getColumnIndex("orientation"));
                                String string11 = cursorQuery2.getString(cursorQuery2.getColumnIndex("_data"));
                                converterFileDataAdapter.data = string11;
                                if (string11 != null) {
                                    converterFileDataAdapter.data = string11.replaceAll(OLD_FILE_DIR, this.mAttachedFileFolder + "/");
                                }
                                StringBuilder sb2 = new StringBuilder();
                                String str6 = str3;
                                sb2.append(str6);
                                sb2.append(converterFileDataAdapter.data);
                                converterFileDataAdapter.curFullPath = sb2.toString();
                                String strSubstring = cursorQuery2.getString(cursorQuery2.getColumnIndex("mime_type")).substring(0, 5);
                                if (!memoMetaDataItem.getHasImage() && strSubstring.compareTo("image") == 0) {
                                    memoMetaDataItem.setHasImage(true);
                                    memoMetaDataItem.setImageFile(converterFileDataAdapter);
                                } else if (strSubstring.compareTo("audio") == 0) {
                                    memoMetaDataItem.setHasVoice(true);
                                    memoMetaDataItem.setVoiceRuntime(Converter.getVoiceRuntime(converterFileDataAdapter.curFullPath));
                                }
                                str3 = str6;
                            } catch (SQLException e21) {
                                e = e21;
                                str2 = str;
                                cursor4 = cursor2;
                                arrayList = arrayList2;
                                map = cursor4;
                                DocumentLogger.m7181i(TAG, str2 + e);
                                readableDatabase.endTransaction();
                                if (map != 0) {
                                }
                                if (cursor != null) {
                                }
                                readableDatabase.close();
                                return arrayList;
                            } catch (Exception e22) {
                                e = e22;
                                cursor3 = cursor2;
                                arrayList = arrayList2;
                                map = cursor3;
                                DocumentLogger.m7181i(TAG, str + e);
                                readableDatabase.endTransaction();
                                if (map != 0) {
                                }
                                if (cursor != null) {
                                }
                                readableDatabase.close();
                                return arrayList;
                            }
                        }
                        String str7 = str3;
                        cursorQuery2.close();
                        arrayList = arrayList2;
                        try {
                            arrayList.add(memoMetaDataItem);
                            arrayList2 = arrayList;
                            str3 = str7;
                            cursorQuery = cursor2;
                            str4 = str5;
                        } catch (SQLException e23) {
                            e = e23;
                            str2 = str;
                            map = cursor2;
                            DocumentLogger.m7181i(TAG, str2 + e);
                            readableDatabase.endTransaction();
                            if (map != 0) {
                            }
                            if (cursor != null) {
                            }
                            readableDatabase.close();
                            return arrayList;
                        } catch (Exception e24) {
                            e = e24;
                            map = cursor2;
                            DocumentLogger.m7181i(TAG, str + e);
                            readableDatabase.endTransaction();
                            if (map != 0) {
                            }
                            if (cursor != null) {
                            }
                            readableDatabase.close();
                            return arrayList;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        map = cursor2;
                        readableDatabase.endTransaction();
                        if (map != 0) {
                            map.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        readableDatabase.close();
                        throw th;
                    }
                } catch (SQLException e25) {
                    e = e25;
                    arrayList = arrayList2;
                    str2 = str;
                    map = cursor2;
                    DocumentLogger.m7181i(TAG, str2 + e);
                    readableDatabase.endTransaction();
                    if (map != 0) {
                    }
                    if (cursor != null) {
                    }
                    readableDatabase.close();
                    return arrayList;
                } catch (Exception e26) {
                    e = e26;
                    arrayList = arrayList2;
                    map = cursor2;
                    DocumentLogger.m7181i(TAG, str + e);
                    readableDatabase.endTransaction();
                    if (map != 0) {
                    }
                    if (cursor != null) {
                    }
                    readableDatabase.close();
                    return arrayList;
                }
            } else {
                if (string10 != null) {
                    memoMetaDataItem.setCategoryName((String) ((List) map.get(string10)).get(0));
                    memoMetaDataItem.setCategoryOrder((String) ((List) map.get(string10)).get(1));
                }
                memoMetaDataItem.setLastModifiedAt(string4);
                memoMetaDataItem.setCreatedAt(string5);
                cursor5 = cursorQuery;
                SQLiteDatabase sQLiteDatabase22 = sQLiteDatabase;
                cursor2 = cursor5;
                readableDatabase = sQLiteDatabase22;
                String str52 = str4;
                cursorQuery2 = readableDatabase.query("file", null, "memoUUID = '" + string + "' AND isDeleted = 0", null, null, null, null);
                while (cursorQuery2.moveToNext()) {
                }
                String str72 = str3;
                cursorQuery2.close();
                arrayList = arrayList2;
                arrayList.add(memoMetaDataItem);
                arrayList2 = arrayList;
                str3 = str72;
                cursorQuery = cursor2;
                str4 = str52;
            }
            readableDatabase.close();
            return arrayList;
        }
        cursor2 = cursorQuery;
        arrayList = arrayList2;
        readableDatabase.setTransactionSuccessful();
        readableDatabase.endTransaction();
        cursor2.close();
        cursor.close();
        readableDatabase.close();
        return arrayList;
    }

    public boolean isAlreadyConverted(String str) {
        ArrayList<String> noteFilePathList;
        String strSubstring;
        if (str != null && (noteFilePathList = AppDelegator.getInstance().getNoteFilePathList(this.mContext, false)) != null && noteFilePathList.size() != 0) {
            for (int i = 0; i < noteFilePathList.size(); i++) {
                String str2 = noteFilePathList.get(i);
                if (str2 != null) {
                    int iIndexOf = str2.indexOf("[");
                    int iLastIndexOf = str2.lastIndexOf("]");
                    if (iIndexOf >= 0 && iLastIndexOf >= 0 && iLastIndexOf > iIndexOf) {
                        int i2 = iIndexOf + 1;
                        if (iLastIndexOf - i2 > 0 && (strSubstring = str2.substring(i2, iLastIndexOf)) != null && strSubstring.length() > 0 && strSubstring.compareTo(str) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        DocumentLogger.m7181i(TAG, "onCreate()");
        createTables(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        DocumentLogger.m7178d(TAG, "onUpgrade() " + i + " to " + i2);
        if (i2 != 10) {
            throw new SQLiteException(AbstractC0000a.m11h(i2, "unknown database version: "));
        }
        if (!ConverterUtils.isMondrianOrPicassoInProduction()) {
            if (i == 8) {
                alterDBtoVersion9(sQLiteDatabase);
                alterDBtoVersion10(sQLiteDatabase);
                return;
            } else {
                if (i != 9) {
                    return;
                }
                alterDBtoVersion10(sQLiteDatabase);
                return;
            }
        }
        switch (i) {
            case 5:
                alterDBtoVersion8(sQLiteDatabase);
                alterDBtoVersion9(sQLiteDatabase);
                alterDBtoVersion10(sQLiteDatabase);
                return;
            case 6:
            case 7:
                throw new IllegalStateException(AbstractC0622a.m1164j(i, i2, "Abnormal DB upgrade case. Converting from ", " to ", " should not occur."));
            case 8:
                alterDBtoVersion9(sQLiteDatabase);
                alterDBtoVersion10(sQLiteDatabase);
                return;
            case 9:
                alterDBtoVersion10(sQLiteDatabase);
                return;
            default:
                throw new IllegalStateException(AbstractC0622a.m1164j(i, i2, "Converting from ", " to ", " wasn't implemented."));
        }
    }

    public boolean convertToSDoc(boolean z, String str, int i) {
        return coreConverter(z, str, null, i) != null;
    }

    public String convertToSDoc(String str) {
        return coreConverter(true, str, null, 0);
    }

    private static void deleteMemo(SQLiteDatabase sQLiteDatabase, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("isDeleted", "1");
        sQLiteDatabase.update("memo", contentValues, AbstractC0541b.m773o("UUID = '", str, "'"), null);
        DocumentLogger.m7181i(TAG, "deleteMemo : ".concat(str));
    }
}
