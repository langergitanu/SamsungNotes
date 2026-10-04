package p261z1;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.transition.C3970a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocResolverContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.TagContentItem;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0003c;
import p002A0.C0010j;
import p003A1.C0012a;
import p003A1.C0013b;
import p042J1.AbstractC0155m;
import p044K.C0158a;
import p086V.C0322h;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: z1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14522c {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10367a;

    /* JADX INFO: renamed from: b */
    public final C0012a f10368b;

    /* JADX INFO: renamed from: c */
    public final C0013b f10369c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC14510a f10370d;

    /* JADX INFO: renamed from: e */
    public final String f10371e;

    /* JADX INFO: renamed from: f */
    public final long f10372f;

    /* JADX INFO: renamed from: g */
    public String f10373g;

    public C14522c(C0012a c0012a, C0013b c0013b, InterfaceC14510a interfaceC14510a, int i) {
        this.f10367a = i;
        switch (i) {
            case 1:
                this.f10373g = null;
                this.f10368b = c0012a;
                this.f10369c = c0013b;
                this.f10370d = interfaceC14510a;
                c0012a.getClass();
                this.f10371e = C0012a.m39b();
                this.f10372f = c0012a.f263f;
                break;
            default:
                this.f10373g = null;
                this.f10368b = c0012a;
                this.f10369c = c0013b;
                this.f10370d = interfaceC14510a;
                c0012a.getClass();
                this.f10371e = C0012a.m39b();
                this.f10372f = c0012a.f263f;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c6  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m15175c() throws Throwable {
        String str;
        String str2;
        String str3;
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObjectM394i;
        HashMap<String, Long> map;
        long j;
        HashMap<String, Long> map2;
        String str4;
        C0012a c0012a = this.f10368b;
        StringBuilder sb = new StringBuilder();
        String str5 = this.f10371e;
        String strM1170p = AbstractC0622a.m1170p(str5, "extra_info.list", sb);
        File file = new File(strM1170p);
        if (file.exists() && !file.delete()) {
            Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[DEIL] failed to delete SyncExtraListInfo");
        }
        try {
            if (this.f10369c.m43e("extra_info.list")) {
                AbstractC6848m.m5009b(c0012a.f69j, "extra_info_version", str5);
            }
        } catch (SyncException e) {
            AbstractC6670b.m4752m(e, new StringBuilder("[DEIL] Fail to download mapped list : "), "SyncOldNote$SyncExtraListInfo");
        }
        if (this.f10370d.isCancelled()) {
            Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[DEIL] Cancelled in mapped List");
            return false;
        }
        if (!file.exists()) {
            Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[DEIL] No downloaded file!");
            return true;
        }
        String str6 = DBSchema.Document.LAST_MAPPED_AT;
        Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[DEIL] Start to get extra info list of server");
        FileInputStream fileInputStream3 = null;
        try {
            try {
                try {
                    try {
                        str3 = "[DEIL] Fail to read extra info list - ";
                        try {
                            C0322h.m670a().f816b.unzip(new File(strM1170p), new File(str5), true, true);
                            Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[DEIL] Finished to unzip!");
                            String str7 = strM1170p + ".json";
                            String unzippedFileName = C0322h.m670a().f816b.getUnzippedFileName();
                            if (!"extra_info.list.json".equals(unzippedFileName)) {
                                Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[DEIL] unzipped file is not extra_info.list.json : " + unzippedFileName);
                                str7 = str5 + "e";
                                if (!FileUtils.exists(str7)) {
                                    String str8 = "[DEIL] Failed to read extra list info of server : " + unzippedFileName;
                                    Debugger.m8609e("SyncOldNote$SyncExtraListInfo", str8);
                                    throw new SyncException(304, str8);
                                }
                            }
                            fileInputStream = new FileInputStream(str7);
                            try {
                                jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                            } catch (FileNotFoundException e2) {
                                e = e2;
                            } catch (IOException e3) {
                                e = e3;
                            } catch (JSONException e5) {
                                e = e5;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream2 = fileInputStream;
                            }
                        } catch (FileNotFoundException e6) {
                            e = e6;
                        } catch (IOException e7) {
                            e = e7;
                        } catch (JSONException e8) {
                            e = e8;
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        str3 = "[DEIL] Fail to read extra info list - ";
                    } catch (IOException e10) {
                        e = e10;
                        str3 = "[DEIL] Fail to read extra info list - ";
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (JSONException e11) {
                e = e11;
                str3 = "[DEIL] Fail to read extra info list - ";
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            str2 = "[DEIL] Fail to read extra info list - ";
        } catch (IOException e13) {
            e = e13;
            str = "[DEIL] Fail to read extra info list - ";
        }
        try {
            if (jSONObjectM394i == null) {
                Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[DEIL] Failed to read extra info list of server!");
                throw new SyncException(304, "[DEIL] Failed to read extra info list of server!");
            }
            JSONArray jSONArray = jSONObjectM394i.getJSONArray("file_info");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("uuid");
                C0003c c0003c = new C0003c(string, jSONObject.getLong("timestamp"), jSONObject.getLong(str6));
                FileInputStream fileInputStream4 = fileInputStream;
                jSONObject.remove("uuid");
                jSONObject.remove("timestamp");
                jSONObject.remove(str6);
                if (jSONObject.length() > 0) {
                    str4 = str6;
                    c0012a.f75p.put(string, jSONObject.toString());
                } else {
                    str4 = str6;
                }
                arrayList.add(c0003c);
                i++;
                fileInputStream = fileInputStream4;
                str6 = str4;
            }
            FileInputStream fileInputStream5 = fileInputStream;
            jSONObjectM394i.remove("file_info");
            if (jSONObjectM394i.length() > 0) {
                this.f10373g = jSONObjectM394i.toString();
            }
            Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[DEIL] Finished to get serverCList #: " + length);
            try {
                fileInputStream5.close();
            } catch (IOException e14) {
                AbstractC0000a.m20q(e14, new StringBuilder("[DEIL] InputStream close - Exception = "), "SyncOldNote$SyncExtraListInfo");
            }
            HashMap<String, Long> map3 = new HashMap<>();
            HashMap<String, Long> map4 = new HashMap<>();
            Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[DEIL] Handle the extra info list : " + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((C0003c) it.next()).f13a);
            }
            Context context = c0012a.f262e;
            Context context2 = c0012a.f262e;
            new HashMap();
            HashMap map5 = new HashMap();
            List<DocSyncEntry> cacheSyncDocInfoList = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getCacheSyncDocInfoList(arrayList2);
            if (cacheSyncDocInfoList != null) {
                for (DocSyncEntry docSyncEntry : cacheSyncDocInfoList) {
                    map5.put(docSyncEntry.getUuid(), docSyncEntry);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0003c c0003c2 = (C0003c) it2.next();
                String str9 = c0003c2.f13a;
                DocSyncEntry docSyncEntry2 = (DocSyncEntry) map5.get(str9);
                if (docSyncEntry2 != null) {
                    long jLongValue = docSyncEntry2 != null ? docSyncEntry2.getServerTimestamp().longValue() : 0L;
                    long j2 = c0003c2.f14b;
                    if (docSyncEntry2 != null) {
                        long lastMappedAt = docSyncEntry2.getLastMappedAt();
                        map = map3;
                        j = lastMappedAt;
                    } else {
                        map = map3;
                        j = 0;
                    }
                    HashMap<String, Long> map6 = map4;
                    Iterator it3 = it2;
                    long j3 = c0003c2.f15c;
                    Context context3 = context2;
                    StringBuilder sbM1323p = AbstractC1974b.m1323p(jLongValue, "[Converted] performDownload() : localSDocServerTime = ", " , serverSDocServerTime = ");
                    sbM1323p.append(j2);
                    HashMap map7 = map5;
                    AbstractC1038a.m1223x(sbM1323p, " , localSDocLastMappedAt = ", j, " , serverSDocLastMappedAt = ");
                    sbM1323p.append(j3);
                    Debugger.m8607d("SyncOldNote$SyncExtraListInfo", sbM1323p.toString());
                    if (j2 > jLongValue) {
                        c0012a.f72m.put(str9, c0003c2);
                    } else {
                        if (j2 == jLongValue && j3 != 0) {
                            if (j3 > j) {
                                map2 = map6;
                                map2.put(str9, Long.valueOf(j3));
                                map.put(str9, Long.valueOf(j3));
                            } else {
                                map2 = map6;
                                if (j3 == j) {
                                    map2.put(str9, Long.valueOf(j3));
                                }
                            }
                        }
                        if (j <= j3) {
                            if (j3 != 0) {
                                NotesDataRepositoryFactory.newInstance(context3).createMappedDocumentRepository().delete(str9, j3);
                            }
                        } else if (j != 0) {
                            NotesDataRepositoryFactory.newInstance(context3).createMappedDocumentRepository().delete(str9, j);
                        }
                        map4 = map2;
                        map3 = map;
                        context2 = context3;
                        it2 = it3;
                        map5 = map7;
                    }
                    map2 = map6;
                    if (j <= j3) {
                    }
                    map4 = map2;
                    map3 = map;
                    context2 = context3;
                    it2 = it3;
                    map5 = map7;
                } else {
                    c0012a.f71l.put(str9, c0003c2);
                    map3 = map3;
                    context2 = context2;
                }
            }
            HashMap<String, Long> map8 = map3;
            Context context4 = context2;
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context4).createSyncNoteDataRepository();
            NotesDatabaseManager.getInstance().getSyncInfoDao();
            syncNoteDataRepositoryCreateSyncNoteDataRepository.insertLastMappedAtList(map4);
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context4).createSyncNoteDataRepository();
            NotesDatabaseManager.getInstance().getSyncInfoDao();
            syncNoteDataRepositoryCreateSyncNoteDataRepository2.setLastMappedAtList(map8);
            Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[DEIL] Finished to Handle the extra info list");
            return true;
        } catch (FileNotFoundException e15) {
            e = e15;
        } catch (IOException e16) {
            e = e16;
            str = str3;
            String str10 = str + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncExtraListInfo", str10);
            throw new SyncException(312, str10);
        } catch (JSONException e17) {
            e = e17;
            String str11 = str3 + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncExtraListInfo", str11);
            throw new SyncException(304, str11);
        } catch (Throwable th4) {
            th = th4;
            th = th;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 == null) {
                throw th;
            }
            try {
                fileInputStream3.close();
                throw th;
            } catch (IOException e18) {
                AbstractC0000a.m20q(e18, new StringBuilder("[DEIL] InputStream close - Exception = "), "SyncOldNote$SyncExtraListInfo");
                throw th;
            }
        }
        str2 = str3;
        String str12 = str2 + e.getMessage();
        Debugger.m8609e("SyncOldNote$SyncExtraListInfo", str12);
        throw new SyncException(319, str12);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x020d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m15176a(HashMap map) throws SyncException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long jLongValue;
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        switch (this.f10367a) {
            case 0:
                C0012a c0012a = this.f10368b;
                try {
                    JSONObject jSONObject4 = this.f10373g != null ? new JSONObject(this.f10373g) : null;
                    if (jSONObject4 == null) {
                        jSONObject4 = new JSONObject();
                    }
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) ((Map.Entry) it.next()).getKey());
                    }
                    Context context = c0012a.f262e;
                    HashMap map2 = c0012a.f71l;
                    HashMap map3 = c0012a.f75p;
                    new HashMap();
                    HashMap map4 = new HashMap();
                    List<DocSyncEntry> cacheSyncDocInfoList = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getCacheSyncDocInfoList(arrayList);
                    if (cacheSyncDocInfoList != null) {
                        for (DocSyncEntry docSyncEntry : cacheSyncDocInfoList) {
                            map4.put(docSyncEntry.getUuid(), docSyncEntry);
                        }
                    }
                    Iterator it2 = map.entrySet().iterator();
                    while (it2.hasNext()) {
                        String str5 = (String) ((Map.Entry) it2.next()).getKey();
                        if (map3.isEmpty() || !map3.containsKey(str5)) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = new JSONObject((String) map3.get(str5));
                            map3.remove(str5);
                        }
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        DocSyncEntry docSyncEntry2 = (DocSyncEntry) map4.get(str5);
                        jSONObject2.put("uuid", str5);
                        long lastMappedAt = 0;
                        if (docSyncEntry2 != null) {
                            jSONObject3 = jSONObject4;
                            jLongValue = docSyncEntry2.getServerTimestamp().longValue();
                        } else {
                            jSONObject3 = jSONObject4;
                            jLongValue = 0;
                        }
                        jSONObject2.put("timestamp", jLongValue);
                        if (docSyncEntry2 != null) {
                            lastMappedAt = docSyncEntry2.getLastMappedAt();
                        }
                        jSONObject2.put(DBSchema.Document.LAST_MAPPED_AT, lastMappedAt);
                        jSONArray.put(jSONObject2);
                        jSONObject4 = jSONObject3;
                    }
                    JSONObject jSONObject5 = jSONObject4;
                    if (!map2.isEmpty()) {
                        for (Map.Entry entry : map2.entrySet()) {
                            String str6 = (String) entry.getKey();
                            C0003c c0003c = (C0003c) entry.getValue();
                            if (map3.isEmpty() || !map3.containsKey(str6)) {
                                jSONObject = null;
                            } else {
                                jSONObject = new JSONObject((String) map3.get(str6));
                                map3.remove(str6);
                            }
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            jSONObject.put("uuid", str6);
                            jSONObject.put("timestamp", c0003c.f14b);
                            jSONObject.put(DBSchema.Document.LAST_MAPPED_AT, c0003c.f15c);
                            jSONArray.put(jSONObject);
                            jSONObject5 = jSONObject5;
                        }
                    }
                    JSONObject jSONObject6 = jSONObject5;
                    jSONObject6.put("file_info", jSONArray);
                    String str7 = this.f10371e + "extra_info.list";
                    String str8 = str7 + ".json";
                    File file = new File(str8);
                    if (file.exists() && !file.delete()) {
                        Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[UEIL] failed to delete makeFileInfoJSON");
                    }
                    if (!file.createNewFile()) {
                        Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[UEIL] Failed to create makeFileInfoJSON");
                        throw new SyncException(312, "[UEIL] Failed to create makeFileInfoJSON");
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(jSONObject6.toString().getBytes("UTF-8"));
                        fileOutputStream.close();
                        C0322h.m670a().f816b.zip(str8, str7);
                        if (file.delete()) {
                            return;
                        }
                        Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[UEIL] failed to delete makeFileInfoJSON");
                        return;
                    } finally {
                    }
                } catch (IOException e) {
                    String str9 = "[UEIL] Failed to makeFileInfoJSON() - " + e.getMessage();
                    Debugger.m8609e("SyncOldNote$SyncExtraListInfo", str9);
                    throw new SyncException(312, str9);
                } catch (JSONException e2) {
                    String str10 = "[UEIL] Failed to makeFileInfoJSON() - " + e2.getMessage();
                    Debugger.m8609e("SyncOldNote$SyncExtraListInfo", str10);
                    throw new SyncException(304, str10);
                }
            default:
                String str11 = "[UELT] Failed to makeFileInfoJSON() - ";
                C0012a c0012a2 = this.f10368b;
                String str12 = "SyncOldNote$SyncExtraListTag";
                try {
                    try {
                        JSONObject jSONObject7 = this.f10373g != null ? new JSONObject(this.f10373g) : null;
                        if (jSONObject7 == null) {
                            jSONObject7 = new JSONObject();
                        }
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            Iterator it3 = map.entrySet().iterator();
                            while (true) {
                                String str13 = "deleted";
                                String str14 = "tag_extra_info";
                                if (!it3.hasNext()) {
                                    str3 = str11;
                                    str4 = str12;
                                    JSONObject jSONObject8 = jSONObject7;
                                    String str15 = "deleted";
                                    String str16 = "tag_extra_info";
                                    try {
                                        if (!c0012a2.f73n.isEmpty()) {
                                            Iterator it4 = c0012a2.f73n.entrySet().iterator();
                                            while (it4.hasNext()) {
                                                Map.Entry entry2 = (Map.Entry) it4.next();
                                                Object obj = (String) entry2.getKey();
                                                ArrayList arrayList2 = (ArrayList) entry2.getValue();
                                                JSONObject jSONObject9 = new JSONObject();
                                                JSONArray jSONArray3 = new JSONArray();
                                                Iterator it5 = arrayList2.iterator();
                                                while (it5.hasNext()) {
                                                    TagContentItem tagContentItem = (TagContentItem) it5.next();
                                                    JSONObject jSONObject10 = new JSONObject();
                                                    jSONObject10.put("tag_uuid", tagContentItem.getTagUUID());
                                                    String str17 = str16;
                                                    jSONObject10.put(str17, tagContentItem.getExtraInfo());
                                                    Iterator it6 = it4;
                                                    String str18 = str15;
                                                    jSONObject10.put(str18, tagContentItem.getIsDeleted());
                                                    jSONObject10.put("timestamp", tagContentItem.getTagModifiedTime());
                                                    jSONArray3.put(jSONObject10);
                                                    str15 = str18;
                                                    it5 = it5;
                                                    str16 = str17;
                                                    it4 = it6;
                                                }
                                                Iterator it7 = it4;
                                                String str19 = str15;
                                                String str20 = str16;
                                                jSONObject9.put("uuid", obj);
                                                jSONObject9.put("tag_uuid_list", jSONArray3);
                                                jSONObject9.put("extra_timestamp", ((TagContentItem) arrayList2.get(0)).getTagServerTime());
                                                jSONArray2.put(jSONObject9);
                                                str15 = str19;
                                                str16 = str20;
                                                it4 = it7;
                                            }
                                        }
                                        jSONObject8.put("file_info", jSONArray2);
                                        sb = new StringBuilder();
                                    } catch (JSONException e3) {
                                        e = e3;
                                    }
                                    try {
                                        sb.append(this.f10371e);
                                        sb.append("extra_tag.list");
                                        String string = sb.toString();
                                        String str21 = string + ".json";
                                        File file2 = new File(str21);
                                        if (file2.exists()) {
                                            if (file2.delete()) {
                                                str = str4;
                                            } else {
                                                str = str4;
                                                try {
                                                    Debugger.m8609e(str, "[UELT] failed to delete makeFileInfoJSON");
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    String str22 = str3 + e.getMessage();
                                                    Debugger.m8609e(str, str22);
                                                    throw new SyncException(312, str22);
                                                } catch (JSONException e6) {
                                                    e = e6;
                                                    str2 = str3;
                                                    String str23 = str2 + e.getMessage();
                                                    Debugger.m8609e(str, str23);
                                                    throw new SyncException(304, str23);
                                                }
                                            }
                                        }
                                        if (!file2.createNewFile()) {
                                            Debugger.m8609e(str, "[UELT] Failed to create makeFileInfoJSON");
                                            throw new SyncException(312, "[UELT] Failed to create makeFileInfoJSON");
                                        }
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                        try {
                                            fileOutputStream2.write(jSONObject8.toString().getBytes("UTF-8"));
                                            fileOutputStream2.close();
                                            C0322h.m670a().f816b.zip(str21, string);
                                            if (file2.delete()) {
                                                return;
                                            }
                                            Debugger.m8609e(str, "[UELT] failed to delete makeFileInfoJSON");
                                            return;
                                        } finally {
                                        }
                                    } catch (IOException e7) {
                                        e = e7;
                                        str = str4;
                                        String str222 = str3 + e.getMessage();
                                        Debugger.m8609e(str, str222);
                                        throw new SyncException(312, str222);
                                    } catch (JSONException e8) {
                                        e = e8;
                                        str = str4;
                                        str2 = str3;
                                        String str232 = str2 + e.getMessage();
                                        Debugger.m8609e(str, str232);
                                        throw new SyncException(304, str232);
                                    }
                                    break;
                                } else {
                                    try {
                                        String str24 = (String) ((Map.Entry) it3.next()).getKey();
                                        List<String> noteTagUUIDList = C0322h.m670a().f830p.getNoteTagUUIDList(str24);
                                        Iterator it8 = it3;
                                        JSONObject jSONObject11 = new JSONObject();
                                        str3 = str11;
                                        try {
                                            JSONArray jSONArray4 = new JSONArray();
                                            for (String str25 : noteTagUUIDList) {
                                                str4 = str12;
                                                try {
                                                    try {
                                                        JSONObject jSONObject12 = new JSONObject();
                                                        jSONObject12.put("tag_uuid", str25);
                                                        jSONObject12.put(str14, C0322h.m670a().f830p.getNoteTagExtraInfo(str24, str25));
                                                        jSONObject12.put(str13, C0322h.m670a().f830p.getNoteTagDeleted(str24, str25));
                                                        jSONObject12.put("timestamp", C0322h.m670a().f830p.getNoteTagModifiedTime(str24, str25));
                                                        jSONArray4.put(jSONObject12);
                                                        jSONObject7 = jSONObject7;
                                                        str12 = str4;
                                                        str13 = str13;
                                                        str14 = str14;
                                                    } catch (IOException e9) {
                                                        e = e9;
                                                        str = str4;
                                                        String str2222 = str3 + e.getMessage();
                                                        Debugger.m8609e(str, str2222);
                                                        throw new SyncException(312, str2222);
                                                    }
                                                } catch (JSONException e10) {
                                                    e = e10;
                                                    str2 = str3;
                                                    str = str4;
                                                    String str2322 = str2 + e.getMessage();
                                                    Debugger.m8609e(str, str2322);
                                                    throw new SyncException(304, str2322);
                                                }
                                                break;
                                            }
                                            String str26 = str12;
                                            JSONObject jSONObject13 = jSONObject7;
                                            jSONObject11.put("uuid", str24);
                                            jSONObject11.put("tag_uuid_list", jSONArray4);
                                            jSONObject11.put("extra_timestamp", C0322h.m670a().f830p.getNoteTagServerTimestamp(str24, (String) noteTagUUIDList.get(0)));
                                            jSONArray2.put(jSONObject11);
                                            it3 = it8;
                                            str11 = str3;
                                            jSONObject7 = jSONObject13;
                                            str12 = str26;
                                        } catch (IOException e11) {
                                            e = e11;
                                            str4 = str12;
                                            str = str4;
                                            String str22222 = str3 + e.getMessage();
                                            Debugger.m8609e(str, str22222);
                                            throw new SyncException(312, str22222);
                                        } catch (JSONException e12) {
                                            e = e12;
                                            str4 = str12;
                                            str2 = str3;
                                            str = str4;
                                            String str23222 = str2 + e.getMessage();
                                            Debugger.m8609e(str, str23222);
                                            throw new SyncException(304, str23222);
                                        }
                                    } catch (IOException e13) {
                                        e = e13;
                                        str3 = str11;
                                    } catch (JSONException e14) {
                                        e = e14;
                                        str3 = str11;
                                    }
                                }
                            }
                        } catch (JSONException e15) {
                            e = e15;
                            str3 = str11;
                            str = str12;
                        }
                    } catch (IOException e16) {
                        e = e16;
                        str3 = str11;
                        str = str12;
                    }
                } catch (JSONException e17) {
                    e = e17;
                    str = "SyncOldNote$SyncExtraListTag";
                    str2 = "[UELT] Failed to makeFileInfoJSON() - ";
                }
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m15177b() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        JSONObject jSONObjectM394i;
        String str;
        String str2;
        JSONArray jSONArray;
        int i;
        String str3;
        long j;
        String string;
        switch (this.f10367a) {
            case 0:
                return m15175c();
            default:
                C0012a c0012a = this.f10368b;
                StringBuilder sb = new StringBuilder();
                String str4 = this.f10371e;
                String strM1170p = AbstractC0622a.m1170p(str4, "extra_tag.list", sb);
                File file = new File(strM1170p);
                if (file.exists() && !file.delete()) {
                    Debugger.m8609e("SyncOldNote$SyncExtraListTag", "[DELT] failed to delete SyncExtraList");
                }
                try {
                    if (this.f10369c.m43e("extra_tag.list")) {
                        AbstractC6848m.m5009b(c0012a.f69j, "extra_tag_uuid_version", str4);
                    }
                    break;
                } catch (SyncException e) {
                    AbstractC6670b.m4752m(e, new StringBuilder("[DELT] Fail to download extra tag list : "), "SyncOldNote$SyncExtraListTag");
                }
                if (this.f10370d.isCancelled()) {
                    Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[DELT] Cancelled in Extra tag List");
                    return false;
                }
                if (file.exists()) {
                    String str5 = "tag_extra_info";
                    String str6 = "tag_uuid";
                    Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[DELT] Start to get extra tag list of server");
                    try {
                        try {
                            C0322h.m670a().f816b.unzip(new File(strM1170p), new File(str4), true, true);
                            fileInputStream2 = new FileInputStream(strM1170p + ".json");
                            try {
                                jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
                            } catch (FileNotFoundException e2) {
                                e = e2;
                            } catch (IOException e3) {
                                e = e3;
                            } catch (JSONException e5) {
                                e = e5;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream3 = fileInputStream2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                    } catch (IOException e7) {
                        e = e7;
                    } catch (JSONException e8) {
                        e = e8;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                    }
                    try {
                        if (jSONObjectM394i == null) {
                            Debugger.m8609e("SyncOldNote$SyncExtraListTag", "[DELT] Failed to read extra tag list of server!");
                            throw new SyncException(304, "[DELT] Failed to read extra tag list of server!");
                        }
                        JSONArray jSONArray2 = jSONObjectM394i.getJSONArray("file_info");
                        int length = jSONArray2.length();
                        ArrayList<C0010j> arrayList = new ArrayList();
                        int i2 = 0;
                        while (i2 < length) {
                            JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                            String string2 = jSONObject.getString("uuid");
                            JSONArray jSONArray3 = jSONObject.getJSONArray("tag_uuid_list");
                            FileInputStream fileInputStream4 = fileInputStream2;
                            int length2 = jSONArray3.length();
                            int i4 = i2;
                            long j2 = jSONObject.getLong("extra_timestamp");
                            ArrayList arrayList2 = new ArrayList();
                            int i5 = 0;
                            while (i5 < length2) {
                                int i6 = length2;
                                JSONObject jSONObject2 = jSONArray3.getJSONObject(i5);
                                if (jSONObject2.has(str6)) {
                                    String string3 = jSONObject2.getString(str6);
                                    if (jSONObject2.has(str5)) {
                                        string = jSONObject2.getString(str5);
                                        str = str5;
                                        str2 = str6;
                                    } else {
                                        str = str5;
                                        StringBuilder sb2 = new StringBuilder();
                                        str2 = str6;
                                        sb2.append("[DELT] No tag extra info : ");
                                        sb2.append(jSONObjectM394i);
                                        Debugger.m8609e("SyncOldNote$SyncExtraListTag", sb2.toString());
                                        string = null;
                                    }
                                    if (string == null) {
                                        string = "";
                                    }
                                    TagContentItem tagContentItem = new TagContentItem(string2, string3, string, jSONObject2.getInt("deleted"), jSONObject2.getLong("timestamp"), j2);
                                    i = i5;
                                    str3 = string2;
                                    jSONArray = jSONArray3;
                                    j = j2;
                                    arrayList2.add(tagContentItem);
                                } else {
                                    str = str5;
                                    str2 = str6;
                                    jSONArray = jSONArray3;
                                    i = i5;
                                    str3 = string2;
                                    j = j2;
                                    Debugger.m8609e("SyncOldNote$SyncExtraListTag", "[DELT] No tag uuid list!");
                                }
                                int i7 = i + 1;
                                string2 = str3;
                                j2 = j;
                                jSONArray3 = jSONArray;
                                str5 = str;
                                str6 = str2;
                                i5 = i7;
                                length2 = i6;
                            }
                            arrayList.add(new C0010j(string2, arrayList2, j2));
                            i2 = i4 + 1;
                            fileInputStream2 = fileInputStream4;
                            str5 = str5;
                            str6 = str6;
                        }
                        FileInputStream fileInputStream5 = fileInputStream2;
                        jSONObjectM394i.remove("file_info");
                        if (jSONObjectM394i.length() > 0) {
                            this.f10373g = jSONObjectM394i.toString();
                        }
                        Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[DELT] Finished to get serverCList #: " + length);
                        try {
                            fileInputStream5.close();
                        } catch (IOException e9) {
                            AbstractC0000a.m20q(e9, new StringBuilder("[DELT] InputStream close - Exception = "), "SyncOldNote$SyncExtraListTag");
                        }
                        Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[DELT] Handle the extra tag list : " + arrayList.size());
                        for (C0010j c0010j : arrayList) {
                            String str7 = c0010j.f57a;
                            ArrayList arrayList3 = c0010j.f58b;
                            SDocResolverContractImpl sDocResolverContractImpl = C0322h.m670a().f831q;
                            Context context = c0012a.f262e;
                            Context context2 = c0012a.f262e;
                            if (sDocResolverContractImpl.isExistNote(context, str7)) {
                                long noteTagServerTimestamp = C0322h.m670a().f830p.getNoteTagServerTimestamp(str7);
                                long j3 = c0010j.f59c;
                                if (j3 > noteTagServerTimestamp) {
                                    Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[DELT] Update tag in server");
                                    if (C0322h.m670a().f831q.isExistNote(context2, str7)) {
                                        int noteTagContentList = C0322h.m670a().f830p.setNoteTagContentList(context2, str7, arrayList3, C0322h.m670a().f831q.getSdocContractNo());
                                        Debugger.m8616s("SyncOldNote$SyncExtraListTag", "Update tags in server : " + str7);
                                        if (noteTagContentList <= 0) {
                                            Debugger.m8609e("SyncOldNote$SyncExtraListTag", "Fail to setNoteTagContentList");
                                        } else {
                                            Debugger.m8607d("SyncOldNote$SyncExtraListTag", "succeed to set");
                                        }
                                    } else {
                                        c0012a.f73n.put(str7, arrayList3);
                                    }
                                } else {
                                    StringBuilder sbM1323p = AbstractC1974b.m1323p(noteTagServerTimestamp, "[DELT] not updated : localTime = ", " , serverTime = ");
                                    sbM1323p.append(j3);
                                    Debugger.m8616s("SyncOldNote$SyncExtraListTag", sbM1323p.toString());
                                }
                            } else {
                                c0012a.f73n.put(str7, arrayList3);
                            }
                        }
                        Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[DELT] Finished to Handle the extra tag list");
                        break;
                    } catch (FileNotFoundException e10) {
                        e = e10;
                    } catch (IOException e11) {
                        e = e11;
                        String str8 = "[DELT] Fail to read extra tag list - " + e.getMessage();
                        Debugger.m8609e("SyncOldNote$SyncExtraListTag", str8);
                        throw new SyncException(312, str8);
                    } catch (JSONException e12) {
                        e = e12;
                        String str9 = "[DELT] Fail to read extra tag list - " + e.getMessage();
                        Debugger.m8609e("SyncOldNote$SyncExtraListTag", str9);
                        throw new SyncException(304, str9);
                    } catch (Throwable th5) {
                        th = th5;
                        th = th;
                        fileInputStream = fileInputStream3;
                        if (fileInputStream == null) {
                            throw th;
                        }
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (IOException e13) {
                            AbstractC0000a.m20q(e13, new StringBuilder("[DELT] InputStream close - Exception = "), "SyncOldNote$SyncExtraListTag");
                            throw th;
                        }
                    }
                    String str10 = "[DELT] Fail to read extra tag list - " + e.getMessage();
                    Debugger.m8609e("SyncOldNote$SyncExtraListTag", str10);
                    throw new SyncException(319, str10);
                }
                Debugger.m8615i("SyncOldNote$SyncExtraListTag", "[DELT] No downloaded file!");
                return true;
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m15178d() throws SyncException {
        switch (this.f10367a) {
            case 0:
                long j = this.f10372f;
                C0158a.m407a().getClass();
                if (C0158a.m410f()) {
                    return true;
                }
                C0012a c0012a = this.f10368b;
                boolean z = c0012a.f78s;
                Context context = c0012a.f262e;
                boolean z2 = z | (C0322h.m670a().f831q.getDirtyCountOfNoteExtraInfo(context) > 0);
                c0012a.f78s = z2;
                if (!z2) {
                    return true;
                }
                Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[UEIL] Need to update Server");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("syncname", "extra_info.list");
                    jSONObject.put("syncpath", "extra_info.list");
                    jSONObject.put("ModifiedTime", j);
                    jSONObject.put("IsFolder", "0");
                    jSONObject.put("category", "category");
                    HashMap uuidAndNoteTimeList = C0322h.m670a().f831q.getUuidAndNoteTimeList(context);
                    if (uuidAndNoteTimeList == null) {
                        Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[UEIL] update list is null");
                    } else {
                        m15176a(uuidAndNoteTimeList);
                        if (!this.f10370d.isCancelled()) {
                            String str = this.f10371e + "extra_info.list";
                            AbstractC6848m.m5014g(c0012a.f69j, str, "extra_info_version", Long.toString(j), jSONObject, new C3970a(this, 14, uuidAndNoteTimeList, str));
                            Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[UEIL] success to upload Extra Info List : " + uuidAndNoteTimeList.size());
                            Debugger.m8615i("SyncOldNote$SyncExtraListInfo", "[UEIL] Finished to update Server");
                            return true;
                        }
                        Debugger.m8607d("SyncOldNote$SyncExtraListInfo", "[UEIL] Cancelled Extra Info List");
                    }
                    return false;
                } catch (SyncException e) {
                    Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[UEIL] Failed to upload Extra Info List");
                    throw e;
                } catch (JSONException e2) {
                    Debugger.m8609e("SyncOldNote$SyncExtraListInfo", "[UEIL] Failed to to upload Extra Info List : " + e2.getMessage());
                    throw new SyncException(304, "Failed to upload category");
                }
            default:
                long j2 = this.f10372f;
                C0158a.m407a().getClass();
                if (C0158a.m410f()) {
                    return true;
                }
                C0012a c0012a2 = this.f10368b;
                boolean z3 = c0012a2.f77r | (C0322h.m670a().f830p.getDirtyCountOfNoteTag() > 0);
                c0012a2.f77r = z3;
                if (!z3) {
                    return true;
                }
                Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] Need to update Server");
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("syncname", "extra_tag.list");
                    jSONObject2.put("syncpath", "extra_tag.list");
                    jSONObject2.put("ModifiedTime", j2);
                    jSONObject2.put("IsFolder", "0");
                    jSONObject2.put("category", "category");
                    HashMap sDocUuidAndNoteTagTimeList = C0322h.m670a().f830p.getSDocUuidAndNoteTagTimeList();
                    if (sDocUuidAndNoteTagTimeList == null) {
                        Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] update list is null");
                    } else {
                        m15176a(sDocUuidAndNoteTagTimeList);
                        if (!this.f10370d.isCancelled()) {
                            String str2 = this.f10371e + "extra_tag.list";
                            AbstractC6848m.m5014g(c0012a2.f69j, str2, "extra_tag_uuid_version", Long.toString(j2), jSONObject2, new C3970a(this, 15, sDocUuidAndNoteTagTimeList, str2));
                            Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] success to upload Extra tag List : " + j2);
                            Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] Finished to update Server");
                            return true;
                        }
                        Debugger.m8607d("SyncOldNote$SyncExtraListTag", "[UELT] Cancelled Extra tag List");
                    }
                    return false;
                } catch (SyncException e3) {
                    Debugger.m8609e("SyncOldNote$SyncExtraListTag", "[UELT] Failed to upload Extra tag List");
                    throw e3;
                } catch (JSONException e5) {
                    Debugger.m8609e("SyncOldNote$SyncExtraListTag", "[UELT] Failed to to upload Extra tag List : " + e5.getMessage());
                    throw new SyncException(304, "Failed to upload tag");
                }
        }
    }
}
