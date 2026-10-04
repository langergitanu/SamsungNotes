package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQueryBuilder;
import com.samsung.android.app.notes.sync.p135db.AbstractC6736e;
import com.samsung.android.app.notes.sync.p135db.AbstractC6739h;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.access.hashtag.HashTagAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.sync.TagContentItem;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p079T.AbstractC0299q;
import p093X.InterfaceC0335c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocTagResolverContractImpl implements InterfaceC0335c, HashTagAccessHandler.HashTagAccessContract {
    @Override // p093X.InterfaceC0335c
    public String addTag(Context context, String str, String str2, boolean z) {
        NotesHashtagEntity notesHashtagEntity = new NotesHashtagEntity();
        notesHashtagEntity.setName(str2);
        notesHashtagEntity.setUuid(str);
        notesHashtagEntity.setExtraInfo("");
        notesHashtagEntity.setLastModifiedAt(System.currentTimeMillis());
        notesHashtagEntity.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime(context)));
        try {
            NotesDatabaseManager.getInstance().getHashtagDao().upsert(notesHashtagEntity);
            return notesHashtagEntity.getUuid();
        } catch (SQLiteFullException e) {
            Debugger.m8609e("HashTagWriteResolver", e.getMessage());
            DialogUtils.showNotEnoughStorageDialog(context, null);
            return null;
        }
    }

    @Override // p093X.InterfaceC0335c
    public void deleteTag(Context context, String str, long j, int i, boolean z) {
        NotesHashtagEntity entity = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(str);
        entity.setIsDirty(i);
        entity.setServerTimestamp(Long.valueOf(j));
        entity.setIsDeleted(1);
        NotesDatabaseManager.getInstance().getHashtagDao().update(entity);
        for (String str2 : AbstractC6736e.m4833c(str, true)) {
            if (AbstractC6736e.m4832b(str2).size() == 1) {
                AbstractC6739h.m4835b(str2, "", TimeManager.getCurrentTime(context), System.currentTimeMillis(), 1);
            }
        }
        NotesDatabaseManager.getInstance().getHashtagContentDao().deleteByHashtagUuid(str);
        new NotesTagRepository(context).notifyTagBoard();
    }

    @Override // p093X.InterfaceC0335c
    public void deleteTagSync(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesDatabaseManager.getInstance().getHashtagDao().deleteByUuid(str);
    }

    @Override // p093X.InterfaceC0335c
    public int getDirtyCountOfNoteTag() {
        int i;
        Debugger.m8607d("HashTagReadResolver", "getDirtyCountOfNoteTag 1");
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(new SimpleSQLiteQuery(AbstractC0541b.m773o(" SELECT COUNT(*) AS sdocCount   FROM hashtagContent ", TextUtils.isEmpty("hashtagContent.isDirty IS 1") ? "" : " WHERE (hashtagContent.isDirty IS 1) ", "  GROUP BY hashtagContent.sdocUUID "), null));
        try {
            Logger.m8697d("HashTagReadResolver", "getDirtyCountOfNoteTag 2");
            int columnIndex = cursorQuery.getColumnIndex("sdocCount");
            if (!cursorQuery.moveToFirst() || columnIndex < 0) {
                i = 0;
            } else {
                i = cursorQuery.getInt(columnIndex);
                Logger.m8697d("HashTagReadResolver", "getDirtyCountOfNoteTag 3 result : " + i);
            }
            cursorQuery.close();
            return i;
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

    @Override // com.samsung.android.support.senl.nt.base.common.access.hashtag.HashTagAccessHandler.HashTagAccessContract
    public List<HashTagData> getHashTagData(String str) {
        return AbstractC6736e.m4831a(str);
    }

    @Override // p093X.InterfaceC0335c
    public int getNoteTagDeleted(String str, String str2) {
        int i = 0;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] strArr = {str, str2};
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTagContent.TABLE_NAME).columns(new String[]{"isDeleted"}).selection("sdocUUID IS ? AND hashtagUUID IS ? ", strArr).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("isDeleted");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                i = cursorQuery.getInt(columnIndex);
            }
            cursorQuery.close();
            return i;
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

    @Override // p093X.InterfaceC0335c
    public String getNoteTagExtraInfo(String str, String str2) {
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTagContent.TABLE_NAME).selection(AbstractC0541b.m775q("sdocUUID IS '", str, "' AND hashtagUUID IS '", str2, "'"), null).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("extraInfo");
            String string = (!cursorQuery.moveToFirst() || columnIndex < 0) ? "" : cursorQuery.getString(columnIndex);
            cursorQuery.close();
            return string;
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

    @Override // p093X.InterfaceC0335c
    public long getNoteTagModifiedTime(String str, String str2) {
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTagContent.TABLE_NAME).selection(AbstractC0541b.m775q("sdocUUID IS '", str, "' AND hashtagUUID IS '", str2, "'"), null).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("lastModifiedAt");
            long j = (!cursorQuery.moveToFirst() || columnIndex < 0) ? 0L : cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j;
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

    @Override // p093X.InterfaceC0335c
    public long getNoteTagServerTimestamp(String str) {
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(new SimpleSQLiteQuery(AbstractC0299q.m599I(AbstractC0541b.m773o("sdocUUID IS '", str, "'")), null));
        try {
            int columnIndex = cursorQuery.getColumnIndex("serverTimestampMax");
            long j = (!cursorQuery.moveToFirst() || columnIndex < 0) ? 0L : cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j;
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

    @Override // p093X.InterfaceC0335c
    public List<String> getNoteTagUUIDList(String str) {
        return AbstractC6736e.m4832b(str);
    }

    @Override // p093X.InterfaceC0335c
    public List<String> getSDocUUIDListByTag(String str, boolean z) {
        return AbstractC6736e.m4833c(str, z);
    }

    @Override // p093X.InterfaceC0335c
    public HashMap<String, Long> getSDocUuidAndNoteTagTimeList() {
        HashMap<String, Long> map = new HashMap<>();
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(new SimpleSQLiteQuery(AbstractC0299q.m599I(""), null));
        try {
            if (cursorQuery.moveToFirst()) {
                SyncDocumentDao syncDocumentDao = NotesDatabaseManager.getInstance().getSyncDocumentDao();
                int columnIndex = cursorQuery.getColumnIndex("sdocUUID");
                int columnIndex2 = cursorQuery.getColumnIndex("serverTimestampMax");
                if (columnIndex >= 0 && columnIndex2 >= 0) {
                    do {
                        String string = cursorQuery.getString(columnIndex);
                        long j = cursorQuery.getLong(columnIndex2);
                        if (syncDocumentDao.getNoteDeleted(string) == 0 || SyncState.getDontSyncOldNote(string) == 0) {
                            map.put(string, Long.valueOf(j));
                        }
                    } while (cursorQuery.moveToNext());
                }
            }
            cursorQuery.close();
            return map;
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

    @Override // p093X.InterfaceC0335c
    public int getTagDeleted(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"isDeleted"}).selection("UUID IS ?", new String[]{str}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("isDeleted");
            if (columnIndex >= 0 && cursorQuery.moveToFirst()) {
                i = cursorQuery.getInt(columnIndex);
            }
            cursorQuery.close();
            return i;
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

    @Override // p093X.InterfaceC0335c
    public String getTagExtraInfo(String str) {
        String string = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"extraInfo"}).selection("UUID IS ?", new String[]{str}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("extraInfo");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                string = cursorQuery.getString(columnIndex);
            }
            cursorQuery.close();
            return string;
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

    @Override // p093X.InterfaceC0335c
    public long getTagLastModifiedTime(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"lastModifiedAt"}).selection("UUID IS ?", new String[]{str}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("lastModifiedAt");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                j = cursorQuery.getLong(columnIndex);
            }
            cursorQuery.close();
            return j;
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

    @Override // p093X.InterfaceC0335c
    public String getTagName(String str) {
        String string = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"name"}).selection("UUID IS ?", new String[]{str}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("name");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                string = cursorQuery.getString(columnIndex);
            }
            cursorQuery.close();
            return string;
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

    @Override // p093X.InterfaceC0335c
    public long getTagServerTimestamp(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"serverTimestamp"}).selection("UUID IS ?", new String[]{str}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("serverTimestamp");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                j = cursorQuery.getLong(columnIndex);
            }
            cursorQuery.close();
            return j;
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

    @Override // p093X.InterfaceC0335c
    public String getTagUUID(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return NotesDatabaseManager.getInstance().getHashtagDao().getHashTagUuid(str, z, false);
    }

    @Override // p093X.InterfaceC0335c
    public List<String> getTagUUIDList() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"UUID"}).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("UUID");
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

    @Override // p093X.InterfaceC0335c
    public List<String> getTagUUIDListByDeleted(boolean z) {
        String[] strArr;
        String str;
        ArrayList arrayList = new ArrayList();
        String[] strArr2 = {"UUID"};
        if (z) {
            strArr = null;
            str = null;
        } else {
            strArr = new String[]{Integer.toString(0)};
            str = "isDeleted IS ? ";
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(strArr2).selection(str, strArr).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("UUID");
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

    @Override // p093X.InterfaceC0335c
    public List<String> getTagUUIDListByDirty(int i) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {Integer.toString(i)};
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"UUID"}).selection("isDirty IS ?", strArr).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("UUID");
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

    @Override // p093X.InterfaceC0335c
    public boolean isExistTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"UUID"}).selection("UUID IS ?", new String[]{str}).create());
        try {
            boolean z = cursorQuery.getCount() > 0;
            cursorQuery.close();
            return z;
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

    @Override // p093X.InterfaceC0335c
    public void recoveryTag(Context context, String str, long j, int i) {
        synchronized (AbstractC6739h.f4106a) {
            NotesHashtagEntity entity = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(str);
            entity.setIsDirty(i);
            entity.setServerTimestamp(Long.valueOf(j));
            entity.setIsDeleted(0);
            NotesDatabaseManager.getInstance().getHashtagDao().update(entity);
        }
        new NotesTagRepository(context).notifyTagBoard();
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    @Override // p093X.InterfaceC0335c
    public void setNoteTag(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        NotesHashtagContentEntity entityBySdocUuidAndContentUuid = NotesDatabaseManager.getInstance().getHashtagContentDao().getEntityBySdocUuidAndContentUuid(str, str2);
        entityBySdocUuidAndContentUuid.setHashtagUuid(str3);
        NotesDatabaseManager.getInstance().getHashtagContentDao().update(entityBySdocUuidAndContentUuid);
        new NotesTagRepository(context).notifyTagBoard();
    }

    @Override // p093X.InterfaceC0335c
    public void setNoteTagContent(Context context, String str, String str2, int i, long j, long j2, String str3, int i2) {
        boolean z;
        if (str2 == null) {
            return;
        }
        if (str2.equals("NOTAG")) {
            if (!TextUtils.isEmpty(str)) {
                NotesDatabaseManager.getInstance().getHashtagContentDao().deleteByUuid(str);
            }
            AbstractC6739h.m4835b(str, str3, j2, j, i2);
            return;
        }
        NotesDatabaseManager.getInstance().getHashtagContentDao().deleteBySdocUuidAndContentUuid(str, "NOTAG");
        ArrayList arrayListM4832b = AbstractC6736e.m4832b(str);
        ArrayList arrayList = new ArrayList();
        ArrayList<NotesHashtagContentEntity> arrayList2 = new ArrayList<>();
        boolean z2 = true;
        if (arrayListM4832b.indexOf(str2) != -1) {
            arrayList2.add(AbstractC6739h.m4836c(str2, str, j2, j, i2, str3));
        } else if (i != 1) {
            arrayList.add(AbstractC6739h.m4834a(str2, str, j2, j, i2, str3));
        }
        if (arrayList2.isEmpty()) {
            z = false;
        } else {
            NotesDatabaseManager.getInstance().getHashtagContentDao().updateBySdocUuidAndContentUuid(arrayList2);
            z = true;
        }
        if (arrayList.isEmpty()) {
            z2 = z;
        } else {
            NotesDatabaseManager.getInstance().getHashtagContentDao().upsert((Collection) arrayList);
        }
        if (z2) {
            new NotesTagRepository(context).notifyTagBoard();
        }
    }

    @Override // p093X.InterfaceC0335c
    public int setNoteTagContentList(Context context, String str, List<TagContentItem> list, int i) {
        String str2;
        boolean z;
        if (!TextUtils.isEmpty(str) && list != null) {
            if (TextUtils.isEmpty(str)) {
                str2 = str;
            } else {
                str2 = str;
                NotesDatabaseManager.getInstance().getHashtagContentDao().deleteByUuid(str2);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<NotesHashtagContentEntity> arrayList2 = new ArrayList<>();
            Iterator<TagContentItem> it = list.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    if (arrayList2.isEmpty()) {
                        z = false;
                    } else {
                        NotesDatabaseManager.getInstance().getHashtagContentDao().updateBySdocUuidAndContentUuid(arrayList2);
                        z = true;
                    }
                    if (arrayList.isEmpty()) {
                        z2 = z;
                    } else {
                        NotesDatabaseManager.getInstance().getHashtagContentDao().upsert((Collection) arrayList);
                    }
                    if (z2) {
                        new NotesTagRepository(context).notifyTagBoard();
                    }
                    return 0;
                }
                TagContentItem next = it.next();
                String tagUUID = next.getTagUUID();
                long tagServerTime = next.getTagServerTime();
                long tagModifiedTime = next.getTagModifiedTime();
                int isDeleted = next.getIsDeleted();
                String extraInfo = next.getExtraInfo();
                if (!tagUUID.equals("NOTAG")) {
                    if (AbstractC6736e.m4832b(str).indexOf(tagUUID) != -1) {
                        arrayList2.add(AbstractC6739h.m4836c(tagUUID, str, tagServerTime, tagModifiedTime, i, extraInfo));
                    } else if (isDeleted != 1) {
                        arrayList.add(AbstractC6739h.m4834a(tagUUID, str, tagServerTime, tagModifiedTime, i, extraInfo));
                    }
                    str2 = str;
                } else if (AbstractC6739h.m4835b(str2, extraInfo, tagServerTime, tagModifiedTime, i) != null) {
                    return 1;
                }
            }
        }
        return -1;
    }

    @Override // p093X.InterfaceC0335c
    public void setNoteTagDirty(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesDatabaseManager.getInstance().getHashtagContentDao().updateDirtyBySdocUuid(str, i);
    }

    @Override // p093X.InterfaceC0335c
    public void setTagDirty(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesDatabaseManager.getInstance().getHashtagDao().updateDirtyByHashtagUuid(str, i);
    }

    @Override // p093X.InterfaceC0335c
    public void setTagModifiedAndServerTimestampAndExtraInfo(String str, long j, long j2, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesHashtagEntity entity = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(str);
        entity.setServerTimestamp(Long.valueOf(j2));
        entity.setLastModifiedAt(j);
        entity.setExtraInfo(str2);
        NotesDatabaseManager.getInstance().getHashtagDao().update(entity);
    }

    @Override // p093X.InterfaceC0335c
    public void setTagServerTimestamp(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesDatabaseManager.getInstance().getHashtagDao().updateServerTimestampByHashtagUuid(str, j);
    }

    @Override // p093X.InterfaceC0335c
    public Object synchronizeTag() {
        return AbstractC6739h.f4106a;
    }

    @Override // p093X.InterfaceC0335c
    public void updateTagName(String str, String str2) {
        NotesHashtagEntity entity = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(str);
        entity.setName(str2);
        NotesDatabaseManager.getInstance().getHashtagDao().update(entity);
    }

    @Override // p093X.InterfaceC0335c
    public long getNoteTagServerTimestamp(String str, String str2) {
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTagContent.TABLE_NAME).selection(AbstractC0541b.m775q("sdocUUID IS '", str, "' AND hashtagUUID IS '", str2, "'"), null).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("serverTimestamp");
            long j = (!cursorQuery.moveToFirst() || columnIndex < 0) ? 0L : cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j;
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
