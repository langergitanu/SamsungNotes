package com.samsung.android.app.notes.sync.p135db;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQueryBuilder;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6736e {
    /* JADX INFO: renamed from: a */
    public static ArrayList m4831a(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("hashtagContent.sdocUUID IS '", str, "' AND hashtagContent.isDeleted = 0 ");
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        String string = sbM15l.toString();
        Cursor cursorQuery = notesDatabaseManager.query(new SimpleSQLiteQuery(AbstractC0541b.m774p(" SELECT hashtag.name AS name, hashtag.UUID AS hashtagUUID, COUNT(sdoc.UUID) AS hashtagContentCount, SUM(CASE WHEN sdoc.isDeleted=0 THEN 1 ELSE 0 END) AS hashtagContentCountWithoutDeletedSdoc   , MAX(hashtagContent.serverTimestamp) AS hashtagContentServerTimestampMax  FROM hashtag        LEFT JOIN hashtagContent          ON hashtag.UUID = hashtagContent.hashtagUUID        LEFT JOIN sdoc          ON sdoc.UUID = hashtagContent.sdocUUID ", TextUtils.isEmpty(string) ? "" : AbstractC0541b.m773o(" WHERE (", string, ") "), "  GROUP BY hashtag.UUID ", TextUtils.isEmpty("hashtagContent.lastModifiedAt ASC, hashtagContent._id ASC") ? "" : " ORDER BY hashtagContent.lastModifiedAt ASC, hashtagContent._id ASC"), null));
        try {
            int columnIndex = cursorQuery.getColumnIndex("name");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                do {
                    arrayList.add(new HashTagData().setName(cursorQuery.getString(columnIndex)));
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return arrayList;
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

    /* JADX INFO: renamed from: b */
    public static ArrayList m4832b(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] strArr = {OldDBSchema.HashTagContent.HASHTAG_UUID};
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTagContent.TABLE_NAME).columns(strArr).selection("sdocUUID IS ?", new String[]{str}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex(OldDBSchema.HashTagContent.HASHTAG_UUID);
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                do {
                    arrayList.add(cursorQuery.getString(columnIndex));
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return arrayList;
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

    /* JADX INFO: renamed from: c */
    public static ArrayList m4833c(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] strArr = {"sdocUUID"};
        StringBuilder sb = new StringBuilder("hashtagUUID IS ? ");
        String[] strArr2 = {str};
        if (!z) {
            sb.append(" AND isDeleted != 1");
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTagContent.TABLE_NAME).columns(strArr).selection(sb.toString(), strArr2).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("sdocUUID");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                do {
                    arrayList.add(cursorQuery.getString(columnIndex));
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return arrayList;
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
