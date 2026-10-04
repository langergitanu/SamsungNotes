package com.samsung.android.sdk.smp.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "smp.db";
    private static final int DATABASE_VERSION = 5;
    private static final String TAG = "DBHelper";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SmpLog.m6492d(TAG, "create tables");
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS card (_id INTEGER PRIMARY KEY AUTOINCREMENT, mid TEXT NOT NULL UNIQUE,msgtype TEXT,data TEXT,state TEXT NOT NULL,extra TEXT,mrt INTEGER NOT NULL,mdt INTEGER,mct INTEGER,expdt INTEGER,landingredirected INTEGER,fail INTEGER NOT NULL );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feedback (_id INTEGER PRIMARY KEY AUTOINCREMENT,mid TEXT NOT NULL UNIQUE CONSTRAINT fk_cardtable_mid REFERENCES card(mid) ON DELETE CASCADE,lfbid INTEGER NOT NULL,lts INTEGER NOT NULL,feedbacks TEXT NOT NULL,state TEXT NOT NULL,appupdateadded INTEGER,rebootadded INTEGER,debugaction TEXT );");
            sQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS trigger_delete_fb BEFORE DELETE ON card FOR EACH ROW BEGIN  DELETE FROM feedback WHERE feedback.mid= OLD.mid; END");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ack (_id INTEGER PRIMARY KEY AUTOINCREMENT,rid TEXT NOT NULL UNIQUE,ts INTEGER NOT NULL,type TEXT NOT NULL,fail INTEGER NOT NULL,errorcode TEXT,errormsg TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS appfilter (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS start (_id INTEGER PRIMARY KEY AUTOINCREMENT,start TEXT NOT NULL,fail INTEGER NOT NULL );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session (_id INTEGER PRIMARY KEY AUTOINCREMENT,session TEXT NOT NULL,count INTEGER NOT NULL,fail INTEGER NOT NULL );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS externalfeedback (_id INTEGER PRIMARY KEY AUTOINCREMENT,path TEXT NOT NULL UNIQUE,fail INTEGER NOT NULL,timestamp INTEGER NOT NULL );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS appreferrer (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT );");
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("create db fail. "), TAG);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SmpLog.m6498i(TAG, "onUpgrade. oldVersion : " + i + ", newVersion : " + i2);
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ack ADD COLUMN errorcode TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ack ADD COLUMN errormsg TEXT;");
            } catch (Exception e) {
                AbstractC6670b.m4737B(e, new StringBuilder("upgrade db fail. "), TAG);
            }
        }
        if (i < 3) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE card ADD COLUMN landingredirected INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE feedback ADD COLUMN appupdateadded INTEGER;");
                sQLiteDatabase.execSQL("ALTER TABLE feedback ADD COLUMN rebootadded INTEGER;");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS externalfeedback (_id INTEGER PRIMARY KEY AUTOINCREMENT,path TEXT NOT NULL UNIQUE,fail INTEGER NOT NULL,timestamp INTEGER NOT NULL );");
            } catch (Exception e2) {
                AbstractC6670b.m4737B(e2, new StringBuilder("upgrade db fail. "), TAG);
            }
        }
        if (i < 4) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS appreferrer (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT );");
            } catch (Exception e3) {
                AbstractC6670b.m4737B(e3, new StringBuilder("upgrade db fail. "), TAG);
            }
        }
        if (i < 5) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE feedback ADD COLUMN debugaction TEXT;");
            } catch (Exception e5) {
                AbstractC6670b.m4737B(e5, new StringBuilder("upgrade db fail. "), TAG);
            }
        }
    }
}
