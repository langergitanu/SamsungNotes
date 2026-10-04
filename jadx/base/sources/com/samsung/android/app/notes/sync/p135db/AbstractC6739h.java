package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.sqlite.p113db.SupportSQLiteQueryBuilder;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p244u1.C14477a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6739h {

    /* JADX INFO: renamed from: a */
    public static final Object f4106a = new Object();

    /* JADX INFO: renamed from: a */
    public static NotesHashtagContentEntity m4834a(String str, String str2, long j, long j2, int i, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        NotesHashtagContentEntity notesHashtagContentEntity = new NotesHashtagContentEntity();
        notesHashtagContentEntity.setHashtagUuid(str);
        notesHashtagContentEntity.setSdocUuid(str2);
        notesHashtagContentEntity.setExtraInfo(str3);
        notesHashtagContentEntity.setServerTimestamp(Long.valueOf(j));
        notesHashtagContentEntity.setIsDirty(i);
        notesHashtagContentEntity.setLastModifiedAt(j2);
        return notesHashtagContentEntity;
    }

    /* JADX INFO: renamed from: b */
    public static Uri m4835b(String str, String str2, long j, long j2, int i) {
        NotesHashtagContentEntity notesHashtagContentEntity = new NotesHashtagContentEntity();
        notesHashtagContentEntity.setHashtagUuid("NOTAG");
        notesHashtagContentEntity.setSdocUuid(str);
        notesHashtagContentEntity.setExtraInfo(str2);
        notesHashtagContentEntity.setIsDirty(i);
        notesHashtagContentEntity.setServerTimestamp(Long.valueOf(j));
        notesHashtagContentEntity.setLastModifiedAt(j2);
        NotesDatabaseManager.getInstance().getHashtagContentDao().upsert(notesHashtagContentEntity);
        return Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME);
    }

    /* JADX INFO: renamed from: c */
    public static NotesHashtagContentEntity m4836c(String str, String str2, long j, long j2, int i, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        NotesHashtagContentEntity notesHashtagContentEntity = new NotesHashtagContentEntity();
        notesHashtagContentEntity.setServerTimestamp(Long.valueOf(j));
        notesHashtagContentEntity.setLastModifiedAt(j2);
        notesHashtagContentEntity.setIsDirty(i);
        notesHashtagContentEntity.setExtraInfo(str3);
        return notesHashtagContentEntity;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03fc  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m4837d(Context context, ArrayList arrayList, ArrayList arrayList2, String str, boolean z) {
        int i;
        HashMap map;
        int i2;
        Iterator it;
        ArrayList arrayList3;
        ArrayList arrayList4;
        HashTagData hashTagData;
        int i4;
        C6737f c6737f;
        Iterator it2;
        ArrayList arrayList5;
        int i5;
        NotesHashtagEntity entity;
        C6737f c6737f2;
        Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid start");
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList7.add(((HashTagData) it3.next()).getName().toLowerCase());
        }
        ArrayList arrayList8 = new ArrayList();
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList8.add(((HashTagData) it4.next()).getName().toLowerCase());
        }
        ArrayList arrayList9 = new ArrayList();
        ArrayList<HashTagData> arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList<HashTagData> arrayList12 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            HashTagData hashTagData2 = (HashTagData) it5.next();
            if (arrayList2.contains(hashTagData2)) {
                arrayList9.add(hashTagData2);
                arrayList6.add(hashTagData2.getName());
            } else if (arrayList7.contains(hashTagData2.getName().toLowerCase())) {
                arrayList12.add(hashTagData2);
                arrayList6.add(hashTagData2.getName());
            } else {
                arrayList10.add(hashTagData2);
                arrayList6.add(hashTagData2.getName());
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            HashTagData hashTagData3 = (HashTagData) it6.next();
            if (!arrayList.contains(hashTagData3)) {
                if (arrayList8.contains(hashTagData3.getName().toLowerCase())) {
                    arrayList12.add(hashTagData3);
                    arrayList6.add(hashTagData3.getName());
                } else {
                    arrayList12.add(hashTagData3);
                    arrayList11.add(hashTagData3);
                    arrayList6.add(hashTagData3.getName());
                }
            }
        }
        HashMap map2 = new HashMap();
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList6.size(); i7++) {
            sb.append(" '");
            String lowerCase = ((String) arrayList6.get(i7)).toLowerCase();
            if (lowerCase.contains("'")) {
                lowerCase = lowerCase.replace("'", "''");
            }
            sb.append(lowerCase);
            sb.append("' ");
            if (i7 < arrayList6.size() - 1) {
                sb.append(',');
            }
        }
        NotesHashtagContentDao.HashTagExtra hashTagExtra = null;
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(SupportSQLiteQueryBuilder.builder(OldDBSchema.HashTag.TABLE_NAME).columns(new String[]{"UUID", "name", "isDeleted"}).selection(" LOWER(hashtag.name) IN ( " + sb.toString() + " ) ", null).create());
        try {
            int columnIndex = cursorQuery.getColumnIndex("isDeleted");
            if (cursorQuery.moveToFirst() && columnIndex >= 0) {
                while (true) {
                    String string = cursorQuery.getString(i6);
                    String string2 = cursorQuery.getString(1);
                    map2.put(string2, new C6737f(string2, string, cursorQuery.getInt(columnIndex)));
                    if (!cursorQuery.moveToNext()) {
                        break;
                    } else {
                        i6 = 0;
                    }
                }
            }
            cursorQuery.close();
            long currentTime = TimeManager.getCurrentTime(context);
            ArrayList<NotesHashtagContentDao.HashTagExtra> arrayList13 = new ArrayList<>();
            for (HashTagData hashTagData4 : arrayList10) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(hashTagData4.getName()) && (c6737f2 = (C6737f) map2.get(hashTagData4.getName())) != null) {
                    Debugger.m8607d("HashTagWriteResolver", "deleteHashTagContents newDelete : " + c6737f2 + " " + str + " ");
                    NotesHashtagContentEntity notesHashtagContentEntity = new NotesHashtagContentEntity();
                    notesHashtagContentEntity.setSdocUuid(str);
                    notesHashtagContentEntity.setHashtagUuid(c6737f2.f4099b);
                    hashTagExtra = new NotesHashtagContentDao.HashTagExtra(2, notesHashtagContentEntity, null);
                }
                if (hashTagExtra != null) {
                    arrayList13.add(hashTagExtra);
                }
                hashTagExtra = null;
            }
            Iterator it7 = arrayList9.iterator();
            while (it7.hasNext()) {
                HashTagData hashTagData5 = (HashTagData) it7.next();
                ArrayList arrayList14 = new ArrayList();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(hashTagData5.getName()) || (c6737f = (C6737f) map2.get(hashTagData5.getName())) == null) {
                    it2 = it7;
                    arrayList5 = arrayList9;
                } else {
                    String str2 = c6737f.f4099b;
                    if (c6737f.f4100c != 1 || (entity = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(str2)) == null) {
                        it2 = it7;
                        arrayList5 = arrayList9;
                    } else {
                        it2 = it7;
                        entity.setIsDeleted(0);
                        entity.setIsDeleted(1);
                        entity.setServerTimestamp(Long.valueOf(currentTime));
                        arrayList5 = arrayList9;
                        entity.setLastModifiedAt(System.currentTimeMillis());
                        arrayList14.add(new NotesHashtagContentDao.HashTagExtra(1, null, entity));
                    }
                    NotesHashtagContentEntity entityBySdocUuidAndContentUuid = NotesDatabaseManager.getInstance().getHashtagContentDao().getEntityBySdocUuidAndContentUuid(str, str2);
                    if (entityBySdocUuidAndContentUuid != null) {
                        entityBySdocUuidAndContentUuid.setServerTimestamp(Long.valueOf(currentTime));
                        entityBySdocUuidAndContentUuid.setIsDeleted(0);
                        i5 = 1;
                        entityBySdocUuidAndContentUuid.setIsDirty(1);
                    } else {
                        i5 = 1;
                    }
                    arrayList14.add(new NotesHashtagContentDao.HashTagExtra(i5, entityBySdocUuidAndContentUuid, null));
                }
                arrayList13.addAll(arrayList14);
                it7 = it2;
                arrayList9 = arrayList5;
            }
            ArrayList arrayList15 = arrayList9;
            Iterator it8 = arrayList11.iterator();
            while (it8.hasNext()) {
                HashTagData hashTagData6 = (HashTagData) it8.next();
                ArrayList arrayList16 = new ArrayList();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(hashTagData6.getName())) {
                    it = it8;
                    arrayList3 = arrayList10;
                    arrayList4 = arrayList11;
                } else {
                    C6737f c6737f3 = (C6737f) map2.get(hashTagData6.getName());
                    if (c6737f3 == null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            it = it8;
                            hashTagData = hashTagData6;
                            if (((String) entry.getKey()).equalsIgnoreCase(hashTagData.getName())) {
                                c6737f3 = (C6737f) entry.getValue();
                                break;
                            } else {
                                hashTagData6 = hashTagData;
                                it8 = it;
                            }
                        }
                        it = it8;
                        hashTagData = hashTagData6;
                        if (c6737f3 != null) {
                            String name = hashTagData.getName();
                            String strNewUUID = UUIDUtils.newUUID(context);
                            c6737f3 = new C6737f(name, strNewUUID, 0);
                            NotesHashtagEntity notesHashtagEntity = new NotesHashtagEntity();
                            notesHashtagEntity.setName(hashTagData.getName());
                            notesHashtagEntity.setUuid(strNewUUID);
                            notesHashtagEntity.setExtraInfo("");
                            arrayList3 = arrayList10;
                            notesHashtagEntity.setLastModifiedAt(System.currentTimeMillis());
                            notesHashtagEntity.setServerTimestamp(Long.valueOf(currentTime));
                            arrayList4 = arrayList11;
                            arrayList16.add(new NotesHashtagContentDao.HashTagExtra(0, null, notesHashtagEntity));
                            Debugger.m8607d("HashTagWriteResolver", "addHashTagContents insert ");
                            i4 = 1;
                        } else {
                            arrayList3 = arrayList10;
                            arrayList4 = arrayList11;
                            i4 = 1;
                            if (c6737f3.f4100c == 1) {
                                NotesHashtagEntity entity2 = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(c6737f3.f4099b);
                                entity2.setIsDeleted(0);
                                entity2.setLastModifiedAt(System.currentTimeMillis());
                                entity2.setServerTimestamp(Long.valueOf(currentTime));
                                arrayList16.add(new NotesHashtagContentDao.HashTagExtra(1, null, entity2));
                            }
                        }
                        NotesHashtagContentEntity notesHashtagContentEntity2 = new NotesHashtagContentEntity();
                        notesHashtagContentEntity2.setHashtagUuid(c6737f3.f4099b);
                        notesHashtagContentEntity2.setSdocUuid(str);
                        notesHashtagContentEntity2.setExtraInfo("");
                        notesHashtagContentEntity2.setIsDirty(i4);
                        notesHashtagContentEntity2.setServerTimestamp(Long.valueOf(currentTime));
                        notesHashtagContentEntity2.setLastModifiedAt(System.currentTimeMillis());
                        arrayList16.add(new NotesHashtagContentDao.HashTagExtra(0, notesHashtagContentEntity2, null));
                        Debugger.m8607d("HashTagWriteResolver", "addHashTagContents insert cpo");
                    } else {
                        it = it8;
                        hashTagData = hashTagData6;
                        if (c6737f3 != null) {
                        }
                        NotesHashtagContentEntity notesHashtagContentEntity22 = new NotesHashtagContentEntity();
                        notesHashtagContentEntity22.setHashtagUuid(c6737f3.f4099b);
                        notesHashtagContentEntity22.setSdocUuid(str);
                        notesHashtagContentEntity22.setExtraInfo("");
                        notesHashtagContentEntity22.setIsDirty(i4);
                        notesHashtagContentEntity22.setServerTimestamp(Long.valueOf(currentTime));
                        notesHashtagContentEntity22.setLastModifiedAt(System.currentTimeMillis());
                        arrayList16.add(new NotesHashtagContentDao.HashTagExtra(0, notesHashtagContentEntity22, null));
                        Debugger.m8607d("HashTagWriteResolver", "addHashTagContents insert cpo");
                    }
                }
                arrayList13.addAll(arrayList16);
                arrayList10 = arrayList3;
                arrayList11 = arrayList4;
                it8 = it;
            }
            ArrayList arrayList17 = arrayList10;
            ArrayList arrayList18 = arrayList11;
            for (HashTagData hashTagData7 : arrayList12) {
                ArrayList arrayList19 = new ArrayList();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(hashTagData7.getName())) {
                    C6737f c6737f4 = (C6737f) map2.get(hashTagData7.getName());
                    if (c6737f4 == null) {
                        Iterator it9 = map2.entrySet().iterator();
                        while (true) {
                            if (!it9.hasNext()) {
                                break;
                            }
                            Map.Entry entry2 = (Map.Entry) it9.next();
                            if (((String) entry2.getKey()).equalsIgnoreCase(hashTagData7.getName())) {
                                c6737f4 = (C6737f) entry2.getValue();
                                break;
                            }
                        }
                    }
                    if (c6737f4 != null) {
                        String str3 = c6737f4.f4099b;
                        NotesHashtagContentEntity entityBySdocUuidAndContentUuid2 = NotesDatabaseManager.getInstance().getHashtagContentDao().getEntityBySdocUuidAndContentUuid(str, str3);
                        if (entityBySdocUuidAndContentUuid2 != null) {
                            entityBySdocUuidAndContentUuid2.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime(context)));
                            entityBySdocUuidAndContentUuid2.setIsDeleted(0);
                            i = 1;
                            entityBySdocUuidAndContentUuid2.setIsDirty(1);
                        } else {
                            i = 1;
                        }
                        map = map2;
                        arrayList19.add(new NotesHashtagContentDao.HashTagExtra(i, entityBySdocUuidAndContentUuid2, null));
                        if (!c6737f4.f4098a.equals(hashTagData7.getName())) {
                            NotesHashtagEntity entity3 = NotesDatabaseManager.getInstance().getHashtagDao().getEntity(str3);
                            if (entity3 != null) {
                                entity3.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime(context)));
                                entity3.setIsDeleted(0);
                                i2 = 1;
                                entity3.setIsDirty(1);
                                entity3.setName(hashTagData7.getName());
                            } else {
                                i2 = 1;
                            }
                            arrayList19.add(new NotesHashtagContentDao.HashTagExtra(i2, null, entity3));
                        }
                    } else {
                        map = map2;
                    }
                }
                arrayList13.addAll(arrayList19);
                map2 = map;
            }
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid delete : " + arrayList17.size());
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid update : " + arrayList15.size());
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid insert : " + arrayList18.size());
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid updateCases : " + arrayList12.size());
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid cpo : " + arrayList13.size());
            if (arrayList13.isEmpty()) {
                return;
            }
            if (arrayList2.isEmpty()) {
                long currentTime2 = TimeManager.getCurrentTime(context);
                long jCurrentTimeMillis = System.currentTimeMillis();
                NotesHashtagContentEntity notesHashtagContentEntity3 = new NotesHashtagContentEntity();
                notesHashtagContentEntity3.setHashtagUuid("NOTAG");
                notesHashtagContentEntity3.setSdocUuid(str);
                notesHashtagContentEntity3.setExtraInfo("");
                notesHashtagContentEntity3.setIsDirty(1);
                notesHashtagContentEntity3.setServerTimestamp(Long.valueOf(currentTime2));
                notesHashtagContentEntity3.setLastModifiedAt(jCurrentTimeMillis);
                arrayList13.add(new NotesHashtagContentDao.HashTagExtra(0, notesHashtagContentEntity3, null));
            } else {
                NotesHashtagContentEntity entityBySdocUuidAndContentUuid3 = NotesDatabaseManager.getInstance().getHashtagContentDao().getEntityBySdocUuidAndContentUuid(str, "NOTAG");
                NotesHashtagContentDao.HashTagExtra hashTagExtra2 = entityBySdocUuidAndContentUuid3 != null ? new NotesHashtagContentDao.HashTagExtra(2, entityBySdocUuidAndContentUuid3, null) : null;
                if (hashTagExtra2 != null) {
                    arrayList13.add(hashTagExtra2);
                }
            }
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid end0");
            NotesHashtagContentEntity notesHashtagContentEntity4 = new NotesHashtagContentEntity();
            notesHashtagContentEntity4.setSdocUuid(str);
            notesHashtagContentEntity4.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime(context)));
            arrayList13.add(new NotesHashtagContentDao.HashTagExtra(3, notesHashtagContentEntity4, null));
            NotesDatabaseManager.getInstance().getHashtagContentDao().updateHashTagsBySdocUuid(NotesDatabaseManager.getInstance().getHashtagDao(), arrayList13);
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid end1");
            if (z) {
                return;
            }
            C14477a.m15065b().m15071g(null);
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuid end2");
            new NotesTagRepository(context).notifyTagBoard();
        } finally {
        }
    }
}
