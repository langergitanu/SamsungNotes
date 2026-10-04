package com.samsung.android.support.senl.p148nt.data.database.core.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final SQLiteDatabase mDelegate;

    public NotesSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.mDelegate = sQLiteDatabase;
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String str) {
        return new NotesSQLiteStatement(this.mDelegate.compileStatement(str));
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        StringBuilder sbM12325j = AbstractC11014a.m12325j("DELETE FROM ", str);
        sbM12325j.append(TextUtils.isEmpty(str2) ? "" : AbstractC0541b.m772n(SQLKeyword.WHERE, str2));
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = compileStatement(sbM12325j.toString());
        SimpleSQLiteQuery.bind(supportSQLiteStatementCompileStatement, objArr);
        return supportSQLiteStatementCompileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void execSQL(String str) {
        this.mDelegate.execSQL(str);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public long insert(String str, int i, ContentValues contentValues) {
        return this.mDelegate.insertWithOnConflict(str, null, contentValues, i);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    public boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        return this.mDelegate == sQLiteDatabase;
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        return this.mDelegate.needUpgrade(i);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public Cursor query(String str) {
        return this.mDelegate.rawQuery(str, null);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.mDelegate.setForeignKeyConstraintsEnabled(z);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i) {
        this.mDelegate.setMaxSqlCacheSize(i);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        return this.mDelegate.setMaximumSize(j);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        this.mDelegate.setPageSize(j);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void setVersion(int i) {
        this.mDelegate.setVersion(i);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sbM1627q = AbstractC2322a.m1627q(120, "UPDATE ");
        sbM1627q.append(CONFLICT_VALUES[i]);
        sbM1627q.append(str);
        sbM1627q.append(" SET ");
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        int i2 = 0;
        for (String str3 : contentValues.keySet()) {
            int iM2213d = AbstractC2821a.m2213d(sbM1627q, i2, 1, i2 > 0 ? "," : "", str3);
            objArr2[i2] = contentValues.get(str3);
            sbM1627q.append("=?");
            i2 = iM2213d;
        }
        if (objArr != null) {
            for (int i4 = size; i4 < length; i4++) {
                objArr2[i4] = objArr[i4 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sbM1627q.append(SQLKeyword.WHERE);
            sbM1627q.append(str2);
        }
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = compileStatement(sbM1627q.toString());
        SimpleSQLiteQuery.bind(supportSQLiteStatementCompileStatement, objArr2);
        return supportSQLiteStatementCompileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) {
        this.mDelegate.execSQL(str, objArr);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public Cursor query(String str, Object[] objArr) {
        return this.mDelegate.rawQuery(str, (String[]) Arrays.copyOf(objArr, objArr.length, String[].class));
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        return this.mDelegate.yieldIfContendedSafely(j);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return this.mDelegate.rawQueryWithFactory(new NotesSQLiteCursorFactory(supportSQLiteQuery), supportSQLiteQuery.getQuery(), EMPTY_STRING_ARRAY, "");
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return this.mDelegate.rawQueryWithFactory(new NotesSQLiteCursorFactory(supportSQLiteQuery), supportSQLiteQuery.getQuery(), EMPTY_STRING_ARRAY, "", cancellationSignal);
    }
}
