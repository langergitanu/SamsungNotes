package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AESHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion35 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion35");

    public AlterDBtoVersion35() {
        super(34, 35);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3 A[LOOP:0: B:10:0x004d->B:44:0x00c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c2 A[EDGE_INSN: B:80:0x00c2->B:43:0x00c2 BREAK  A[LOOP:0: B:10:0x004d->B:44:0x00c3], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[Catch: all -> 0x00e5, SQLException -> 0x00e8, SYNTHETIC, TRY_LEAVE, TryCatch #2 {SQLException -> 0x00e8, blocks: (B:48:0x00e1, B:61:0x00f9, B:60:0x00f6), top: B:74:0x0017 }] */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        byte[] blob;
        int i;
        byte[] bArrMarshall;
        String str = TAG;
        DataLogger.m12302d(str, "alterDBtoVersion35, replace task span");
        supportSQLiteDatabase.beginTransaction();
        try {
            try {
                Cursor cursorQuery = supportSQLiteDatabase.query("SELECT displayContent, UUID, contentSecureVersion FROM sdoc WHERE isDeleted != 1 ");
                int i2 = 0;
                try {
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                SpenSdkInitializer.initialize(BaseUtils.getApplicationContext());
                                String str2 = ToolConstructor.makeSDocLocker(BaseUtils.getApplicationContext()).getUserCode()[0];
                                DataLogger.m12302d(str, "alterDBtoVersion35, count: " + cursorQuery.getCount());
                                if (cursorQuery.moveToFirst()) {
                                    while (true) {
                                        ContentValues contentValuesCreateContentValues = AndroidClassConstructor.createContentValues();
                                        try {
                                            blob = cursorQuery.getBlob(cursorQuery.getColumnIndex("displayContent"));
                                        } catch (Exception e) {
                                            DataLogger.m12304e(TAG, "alterDBtoVersion35", e);
                                        }
                                        if (blob != null && (((i = cursorQuery.getInt(cursorQuery.getColumnIndex("contentSecureVersion"))) != 1 || (blob = AESHelper.decrypt(blob, str2)) != null) && (bArrMarshall = DisplayDataHelper.marshall((DisplayData) DisplayDataHelper.unmarshall(blob, DisplayData.CREATOR_VERSION_1))) != null && (i != 1 || (bArrMarshall = AESHelper.encrypt(bArrMarshall, str2)) != null))) {
                                            contentValuesCreateContentValues.put("displayContent", bArrMarshall);
                                            if (contentValuesCreateContentValues.size() > 0) {
                                                supportSQLiteDatabase2 = supportSQLiteDatabase;
                                                try {
                                                    supportSQLiteDatabase2.update("sdoc", 1, contentValuesCreateContentValues, "UUID=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("UUID"))});
                                                    i2++;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    Throwable th2 = th;
                                                    if (cursorQuery != null) {
                                                    }
                                                }
                                            }
                                            if (cursorQuery.moveToNext()) {
                                                break;
                                            } else {
                                                supportSQLiteDatabase = supportSQLiteDatabase2;
                                            }
                                        }
                                        supportSQLiteDatabase2 = supportSQLiteDatabase;
                                        if (cursorQuery.moveToNext()) {
                                        }
                                    }
                                } else {
                                    supportSQLiteDatabase2 = supportSQLiteDatabase;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            Throwable th22 = th;
                            if (cursorQuery != null) {
                                throw th22;
                            }
                            try {
                                cursorQuery.close();
                                throw th22;
                            } catch (Throwable th4) {
                                th22.addSuppressed(th4);
                                throw th22;
                            }
                        }
                    }
                    supportSQLiteDatabase2.setTransactionSuccessful();
                    DataLogger.m12302d(TAG, "alterDBtoVersion35, updateCount: " + i2);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    supportSQLiteDatabase2.endTransaction();
                } catch (SQLException e2) {
                    e = e2;
                    SQLException sQLException = e;
                    DataLogger.m12304e(TAG, "alterDBtoVersion35", sQLException);
                    throw sQLException;
                }
            } catch (Throwable th5) {
                th = th5;
                Throwable th6 = th;
                supportSQLiteDatabase.endTransaction();
                throw th6;
            }
        } catch (SQLException e3) {
            e = e3;
        } catch (Throwable th7) {
            th = th7;
            Throwable th62 = th;
            supportSQLiteDatabase.endTransaction();
            throw th62;
        }
    }
}
