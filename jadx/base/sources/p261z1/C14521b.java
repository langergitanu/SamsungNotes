package p261z1;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.transition.C3970a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.SpenSdkCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
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
import p002A0.C0009i;
import p003A1.C0012a;
import p003A1.C0013b;
import p042J1.AbstractC0155m;
import p044K.C0158a;
import p086V.C0322h;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: z1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14521b {

    /* JADX INFO: renamed from: a */
    public final C0012a f10361a;

    /* JADX INFO: renamed from: b */
    public final C0013b f10362b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC14510a f10363c;

    /* JADX INFO: renamed from: d */
    public final String f10364d;

    /* JADX INFO: renamed from: e */
    public final long f10365e;

    /* JADX INFO: renamed from: f */
    public String f10366f = null;

    public C14521b(C0012a c0012a, C0013b c0013b, InterfaceC14510a interfaceC14510a) {
        this.f10361a = c0012a;
        this.f10362b = c0013b;
        this.f10363c = interfaceC14510a;
        c0012a.getClass();
        this.f10364d = C0012a.m39b();
        this.f10365e = c0012a.f263f;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb A[Catch: IOException -> 0x0014, JSONException -> 0x0017, TryCatch #4 {IOException -> 0x0014, JSONException -> 0x0017, blocks: (B:3:0x0008, B:5:0x000c, B:12:0x001d, B:13:0x0022, B:14:0x0034, B:16:0x003a, B:17:0x004a, B:19:0x0068, B:20:0x006c, B:22:0x0072, B:23:0x0080, B:24:0x0088, B:27:0x0099, B:29:0x00ab, B:31:0x00b1, B:34:0x00cd, B:35:0x00d2, B:37:0x00dd, B:39:0x00ec, B:42:0x00f6, B:44:0x00fb, B:50:0x0107, B:52:0x011b, B:54:0x0126, B:55:0x0132, B:57:0x013a, B:58:0x0142, B:60:0x0148, B:62:0x0160, B:64:0x0166, B:67:0x0178, B:68:0x017d, B:69:0x0198, B:72:0x01ce, B:74:0x01d4, B:75:0x01d7, B:77:0x01dd, B:79:0x01ef, B:81:0x0201, B:89:0x020f, B:88:0x020c, B:90:0x0210, B:91:0x021c), top: B:100:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b A[Catch: IOException -> 0x0014, JSONException -> 0x0017, TryCatch #4 {IOException -> 0x0014, JSONException -> 0x0017, blocks: (B:3:0x0008, B:5:0x000c, B:12:0x001d, B:13:0x0022, B:14:0x0034, B:16:0x003a, B:17:0x004a, B:19:0x0068, B:20:0x006c, B:22:0x0072, B:23:0x0080, B:24:0x0088, B:27:0x0099, B:29:0x00ab, B:31:0x00b1, B:34:0x00cd, B:35:0x00d2, B:37:0x00dd, B:39:0x00ec, B:42:0x00f6, B:44:0x00fb, B:50:0x0107, B:52:0x011b, B:54:0x0126, B:55:0x0132, B:57:0x013a, B:58:0x0142, B:60:0x0148, B:62:0x0160, B:64:0x0166, B:67:0x0178, B:68:0x017d, B:69:0x0198, B:72:0x01ce, B:74:0x01d4, B:75:0x01d7, B:77:0x01dd, B:79:0x01ef, B:81:0x0201, B:89:0x020f, B:88:0x020c, B:90:0x0210, B:91:0x021c), top: B:100:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0124  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m15172a(HashMap map) throws SyncException {
        JSONObject jSONObject;
        Iterator it;
        HashMap map2;
        JSONObject jSONObject2;
        DocSyncEntry docSyncEntry;
        C0012a c0012a = this.f10361a;
        try {
            JSONObject jSONObject3 = this.f10366f != null ? new JSONObject(this.f10366f) : null;
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList.add((String) ((Map.Entry) it2.next()).getKey());
            }
            Context context = c0012a.f262e;
            HashMap map3 = c0012a.f70k;
            HashMap map4 = c0012a.f74o;
            new HashMap();
            HashMap map5 = new HashMap();
            List<DocSyncEntry> cacheSyncDocInfoList = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getCacheSyncDocInfoList(arrayList);
            if (cacheSyncDocInfoList != null) {
                for (DocSyncEntry docSyncEntry2 : cacheSyncDocInfoList) {
                    map5.put(docSyncEntry2.getUuid(), docSyncEntry2);
                }
            }
            Iterator it3 = map.entrySet().iterator();
            while (it3.hasNext()) {
                String str = (String) ((Map.Entry) it3.next()).getKey();
                if (map4.isEmpty() || !map4.containsKey(str)) {
                    it = it3;
                    map2 = map3;
                    jSONObject2 = null;
                } else {
                    it = it3;
                    map2 = map3;
                    jSONObject2 = new JSONObject((String) map4.get(str));
                    map4.remove(str);
                }
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                DocSyncEntry docSyncEntry3 = (DocSyncEntry) map5.get(str);
                jSONObject2.put("uuid", str);
                if (docSyncEntry3 != null) {
                    docSyncEntry = docSyncEntry3;
                    int isDeleted = "trash:///".equals(docSyncEntry3.getCategoryUuid()) ? docSyncEntry.getIsDeleted() : 0;
                    jSONObject2.put("deleted", isDeleted);
                    jSONObject2.put(DBSchema.DocumentPage.FAVORITE, (docSyncEntry == null ? docSyncEntry.getIsFavorite() : 0) != 1);
                    jSONObject2.put("category_uuid", C0322h.m670a().f829o.getNoteCategoryUUID(c0012a.f262e, str));
                    jSONObject2.put("extra_timestamp", docSyncEntry == null ? docSyncEntry.getCategoryServerTimeStamp().longValue() : 0L);
                    jSONArray.put(jSONObject2);
                    it3 = it;
                    map3 = map2;
                } else {
                    docSyncEntry = docSyncEntry3;
                }
                jSONObject2.put("deleted", isDeleted);
                jSONObject2.put(DBSchema.DocumentPage.FAVORITE, (docSyncEntry == null ? docSyncEntry.getIsFavorite() : 0) != 1);
                jSONObject2.put("category_uuid", C0322h.m670a().f829o.getNoteCategoryUUID(c0012a.f262e, str));
                jSONObject2.put("extra_timestamp", docSyncEntry == null ? docSyncEntry.getCategoryServerTimeStamp().longValue() : 0L);
                jSONArray.put(jSONObject2);
                it3 = it;
                map3 = map2;
            }
            HashMap map6 = map3;
            if (!map6.isEmpty()) {
                for (Map.Entry entry : map6.entrySet()) {
                    String str2 = (String) entry.getKey();
                    C0009i c0009i = (C0009i) entry.getValue();
                    if (map4.isEmpty() || !map4.containsKey(str2)) {
                        jSONObject = null;
                    } else {
                        jSONObject = new JSONObject((String) map4.get(str2));
                        map4.remove(str2);
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("uuid", str2);
                    jSONObject.put("deleted", c0009i.f42e);
                    jSONObject.put(DBSchema.DocumentPage.FAVORITE, c0009i.f44g);
                    jSONObject.put("category_uuid", c0009i.f45h);
                    jSONObject.put("extra_timestamp", c0009i.f46i);
                    jSONArray.put(jSONObject);
                }
            }
            jSONObject3.put("file_info", jSONArray);
            String str3 = this.f10364d + "extra.list";
            String str4 = str3 + ".json";
            File file = new File(str4);
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncExtraList", "[UEL] failed to delete makeFileInfoJSON");
            }
            if (!file.createNewFile()) {
                Debugger.m8609e("SyncOldNote$SyncExtraList", "[UEL] Failed to create makeFileInfoJSON");
                throw new SyncException(312, "[UEL] Failed to create makeFileInfoJSON");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(jSONObject3.toString().getBytes("UTF-8"));
                fileOutputStream.close();
                C0322h.m670a().f816b.zip(str4, str3);
                if (file.delete()) {
                    return;
                }
                Debugger.m8609e("SyncOldNote$SyncExtraList", "[UEL] failed to delete makeFileInfoJSON");
            } finally {
            }
        } catch (IOException e) {
            String str5 = "[UEL] Failed to makeFileInfoJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncExtraList", str5);
            throw new SyncException(312, str5);
        } catch (JSONException e2) {
            String str6 = "[UEL] Failed to makeFileInfoJSON() - " + e2.getMessage();
            Debugger.m8609e("SyncOldNote$SyncExtraList", str6);
            throw new SyncException(304, str6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0673 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m15173b() throws Throwable {
        String str;
        String str2;
        String str3;
        Throwable th;
        ?? r6;
        String str4;
        String unzippedFileName;
        FileInputStream fileInputStream;
        String str5;
        HashMap map;
        int i;
        String filePath;
        String string;
        C0012a c0012a = this.f10361a;
        StringBuilder sb = new StringBuilder();
        String str6 = this.f10364d;
        String strM1170p = AbstractC0622a.m1170p(str6, "extra.list", sb);
        File file = new File(strM1170p);
        String str7 = "SyncOldNote$SyncExtraList";
        if (file.exists() && !file.delete()) {
            Debugger.m8609e("SyncOldNote$SyncExtraList", "[DEL] failed to delete SyncExtraList");
        }
        try {
            if (this.f10362b.m43e("extra.list")) {
                AbstractC6848m.m5009b(c0012a.f69j, "extra_uuid_version", str6);
            }
        } catch (SyncException e) {
            AbstractC6670b.m4752m(e, new StringBuilder("[DEL] Fail to download extra list : "), "SyncOldNote$SyncExtraList");
        }
        if (this.f10363c.isCancelled()) {
            Debugger.m8607d("SyncOldNote$SyncExtraList", "[DEL] Cancelled in Extra List");
            return false;
        }
        if (!file.exists()) {
            Debugger.m8615i("SyncOldNote$SyncExtraList", "[DEL] No downloaded file!");
            return true;
        }
        String str8 = "[DEL] Start to get extra list of server";
        Debugger.m8607d("SyncOldNote$SyncExtraList", "[DEL] Start to get extra list of server");
        try {
            try {
                try {
                    try {
                        try {
                            str3 = "[DEL] Fail to read extra list - ";
                            try {
                                try {
                                    try {
                                        C0322h.m670a().f816b.unzip(new File(strM1170p), new File(str6), true, true);
                                        Debugger.m8607d("SyncOldNote$SyncExtraList", "[DEL] Finished to unzip!");
                                        str4 = strM1170p + ".json";
                                        unzippedFileName = C0322h.m670a().f816b.getUnzippedFileName();
                                    } catch (JSONException e2) {
                                        e = e2;
                                        str6 = "SyncOldNote$SyncExtraList";
                                        String str9 = str3 + e.getMessage();
                                        Debugger.m8609e(str6, str9);
                                        throw new SyncException(304, str9);
                                    }
                                } catch (FileNotFoundException e3) {
                                    e = e3;
                                    str6 = "SyncOldNote$SyncExtraList";
                                    str2 = str3;
                                    String str10 = str2 + e.getMessage();
                                    Debugger.m8609e(str6, str10);
                                    throw new SyncException(319, str10);
                                } catch (IOException e5) {
                                    e = e5;
                                    str6 = "SyncOldNote$SyncExtraList";
                                    str = str3;
                                    String str11 = str + e.getMessage();
                                    Debugger.m8609e(str6, str11);
                                    throw new SyncException(312, str11);
                                } catch (Throwable th2) {
                                    th = th2;
                                    str6 = "SyncOldNote$SyncExtraList";
                                    strM1170p = "[DEL] InputStream close - Exception = ";
                                    th = th;
                                    r6 = 0;
                                    if (r6 != 0) {
                                    }
                                }
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                str6 = "SyncOldNote$SyncExtraList";
                            } catch (IOException e7) {
                                e = e7;
                                str6 = "SyncOldNote$SyncExtraList";
                            } catch (JSONException e8) {
                                e = e8;
                                str6 = "SyncOldNote$SyncExtraList";
                            }
                        } catch (FileNotFoundException e9) {
                            e = e9;
                            str6 = "SyncOldNote$SyncExtraList";
                            str3 = "[DEL] Fail to read extra list - ";
                        } catch (IOException e10) {
                            e = e10;
                            str6 = "SyncOldNote$SyncExtraList";
                            str3 = "[DEL] Fail to read extra list - ";
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        r6 = str8;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str6 = "SyncOldNote$SyncExtraList";
                    strM1170p = "[DEL] InputStream close - Exception = ";
                }
            } catch (JSONException e11) {
                e = e11;
                str6 = "SyncOldNote$SyncExtraList";
                str3 = "[DEL] Fail to read extra list - ";
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            str6 = "SyncOldNote$SyncExtraList";
            str2 = "[DEL] Fail to read extra list - ";
        } catch (IOException e13) {
            e = e13;
            str6 = "SyncOldNote$SyncExtraList";
            str = "[DEL] Fail to read extra list - ";
        }
        if (!"extra.list.json".equals(unzippedFileName)) {
            try {
                Debugger.m8615i("SyncOldNote$SyncExtraList", "[DEL] unzipped file is not extra.list.json : " + unzippedFileName);
                str4 = str6 + "e";
                if (!FileUtils.exists(str4)) {
                    String str12 = "[DEL] Failed to read extra list of server : " + unzippedFileName;
                    Debugger.m8609e("SyncOldNote$SyncExtraList", str12);
                    throw new SyncException(304, str12);
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                str6 = "SyncOldNote$SyncExtraList";
                str2 = str3;
            } catch (IOException e15) {
                e = e15;
                str6 = "SyncOldNote$SyncExtraList";
                str = str3;
                String str112 = str + e.getMessage();
                Debugger.m8609e(str6, str112);
                throw new SyncException(312, str112);
            } catch (Throwable th5) {
                th = th5;
                str6 = "SyncOldNote$SyncExtraList";
                strM1170p = "[DEL] InputStream close - Exception = ";
                r6 = 0;
                if (r6 != 0) {
                    throw th;
                }
                try {
                    r6.close();
                    throw th;
                } catch (IOException e16) {
                    AbstractC0000a.m20q(e16, new StringBuilder(strM1170p), str6);
                    throw th;
                }
            }
            String str102 = str2 + e.getMessage();
            Debugger.m8609e(str6, str102);
            throw new SyncException(319, str102);
        }
        FileInputStream fileInputStream2 = new FileInputStream(str4);
        try {
            JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
            if (jSONObjectM394i != null) {
                JSONArray jSONArray = jSONObjectM394i.getJSONArray("file_info");
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < length) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        FileInputStream fileInputStream3 = fileInputStream2;
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            long j = jSONObject.getLong("extra_timestamp");
                            String string2 = jSONObject.getString("uuid");
                            int i4 = jSONObject.getInt("deleted");
                            int i5 = i2;
                            boolean z = jSONObject.getBoolean(DBSchema.DocumentPage.FAVORITE);
                            if (jSONObject.has("category_uuid")) {
                                try {
                                    string = jSONObject.getString("category_uuid");
                                    fileInputStream = fileInputStream3;
                                } catch (FileNotFoundException e17) {
                                    e = e17;
                                    str6 = str7;
                                    str2 = str3;
                                } catch (IOException e18) {
                                    e = e18;
                                    str6 = str7;
                                    str = str3;
                                    String str1122 = str + e.getMessage();
                                    Debugger.m8609e(str6, str1122);
                                    throw new SyncException(312, str1122);
                                } catch (JSONException e19) {
                                    e = e19;
                                    str6 = str7;
                                    String str92 = str3 + e.getMessage();
                                    Debugger.m8609e(str6, str92);
                                    throw new SyncException(304, str92);
                                } catch (Throwable th6) {
                                    th = th6;
                                    str6 = str7;
                                    r6 = fileInputStream3;
                                    strM1170p = "[DEL] InputStream close - Exception = ";
                                    if (r6 != 0) {
                                    }
                                }
                            } else {
                                fileInputStream = fileInputStream3;
                                Debugger.m8609e(str7, "[DEL] No category uuid!");
                                string = "1";
                            }
                            String str13 = string;
                            try {
                                C0009i c0009i = new C0009i(i4, 0L, string2, "extra.list");
                                int i6 = length;
                                str5 = str7;
                                try {
                                    try {
                                        c0009i.f44g = z;
                                        c0009i.f45h = str13;
                                        c0009i.f46i = j;
                                        jSONObject.remove("extra_timestamp");
                                        jSONObject.remove("uuid");
                                        jSONObject.remove("deleted");
                                        jSONObject.remove(DBSchema.DocumentPage.FAVORITE);
                                        jSONObject.remove("category_uuid");
                                        if (jSONObject.length() > 0) {
                                            c0012a.f74o.put(string2, jSONObject.toString());
                                        }
                                        arrayList.add(c0009i);
                                        i2 = i5 + 1;
                                        jSONArray = jSONArray2;
                                        length = i6;
                                        str7 = str5;
                                        fileInputStream2 = fileInputStream;
                                    } catch (JSONException e20) {
                                        e = e20;
                                        str6 = str5;
                                        String str922 = str3 + e.getMessage();
                                        Debugger.m8609e(str6, str922);
                                        throw new SyncException(304, str922);
                                    }
                                } catch (FileNotFoundException e21) {
                                    e = e21;
                                    str2 = str3;
                                    str6 = str5;
                                    String str1022 = str2 + e.getMessage();
                                    Debugger.m8609e(str6, str1022);
                                    throw new SyncException(319, str1022);
                                } catch (IOException e22) {
                                    e = e22;
                                    str = str3;
                                    str6 = str5;
                                    String str11222 = str + e.getMessage();
                                    Debugger.m8609e(str6, str11222);
                                    throw new SyncException(312, str11222);
                                } catch (Throwable th7) {
                                    th = th7;
                                    th = th;
                                    strM1170p = "[DEL] InputStream close - Exception = ";
                                    str6 = str5;
                                    r6 = fileInputStream;
                                    if (r6 != 0) {
                                    }
                                }
                            } catch (FileNotFoundException e23) {
                                e = e23;
                                str5 = str7;
                                str2 = str3;
                                str6 = str5;
                                String str10222 = str2 + e.getMessage();
                                Debugger.m8609e(str6, str10222);
                                throw new SyncException(319, str10222);
                            } catch (IOException e24) {
                                e = e24;
                                str5 = str7;
                                str = str3;
                                str6 = str5;
                                String str112222 = str + e.getMessage();
                                Debugger.m8609e(str6, str112222);
                                throw new SyncException(312, str112222);
                            } catch (JSONException e25) {
                                e = e25;
                                str5 = str7;
                                str6 = str5;
                                String str9222 = str3 + e.getMessage();
                                Debugger.m8609e(str6, str9222);
                                throw new SyncException(304, str9222);
                            } catch (Throwable th8) {
                                th = th8;
                                str5 = str7;
                                th = th;
                                strM1170p = "[DEL] InputStream close - Exception = ";
                                str6 = str5;
                                r6 = fileInputStream;
                                if (r6 != 0) {
                                }
                            }
                        } catch (FileNotFoundException e26) {
                            e = e26;
                            str5 = str7;
                            fileInputStream = fileInputStream3;
                            str2 = str3;
                            str6 = str5;
                        } catch (IOException e27) {
                            e = e27;
                            str5 = str7;
                            fileInputStream = fileInputStream3;
                            str = str3;
                            str6 = str5;
                            String str1122222 = str + e.getMessage();
                            Debugger.m8609e(str6, str1122222);
                            throw new SyncException(312, str1122222);
                        } catch (JSONException e28) {
                            e = e28;
                            str5 = str7;
                            fileInputStream = fileInputStream3;
                            str6 = str5;
                            String str92222 = str3 + e.getMessage();
                            Debugger.m8609e(str6, str92222);
                            throw new SyncException(304, str92222);
                        } catch (Throwable th9) {
                            th = th9;
                            str5 = str7;
                            fileInputStream = fileInputStream3;
                            th = th;
                            strM1170p = "[DEL] InputStream close - Exception = ";
                            str6 = str5;
                            r6 = fileInputStream;
                            if (r6 != 0) {
                            }
                        }
                    } catch (FileNotFoundException e29) {
                        e = e29;
                        fileInputStream = fileInputStream2;
                    } catch (IOException e30) {
                        e = e30;
                        fileInputStream = fileInputStream2;
                    } catch (JSONException e31) {
                        e = e31;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th10) {
                        th = th10;
                        fileInputStream = fileInputStream2;
                    }
                }
                fileInputStream = fileInputStream2;
                int i7 = length;
                str5 = str7;
                try {
                    jSONObjectM394i.remove("file_info");
                    if (jSONObjectM394i.length() > 0) {
                        try {
                            this.f10366f = jSONObjectM394i.toString();
                        } catch (FileNotFoundException e32) {
                            e = e32;
                            str2 = str3;
                            str6 = str5;
                            String str102222 = str2 + e.getMessage();
                            Debugger.m8609e(str6, str102222);
                            throw new SyncException(319, str102222);
                        } catch (IOException e33) {
                            e = e33;
                            str = str3;
                            str6 = str5;
                            String str11222222 = str + e.getMessage();
                            Debugger.m8609e(str6, str11222222);
                            throw new SyncException(312, str11222222);
                        } catch (JSONException e34) {
                            e = e34;
                            str6 = str5;
                            String str922222 = str3 + e.getMessage();
                            Debugger.m8609e(str6, str922222);
                            throw new SyncException(304, str922222);
                        } catch (Throwable th11) {
                            th = th11;
                            th = th;
                            strM1170p = "[DEL] InputStream close - Exception = ";
                            str6 = str5;
                            r6 = fileInputStream;
                            if (r6 != 0) {
                            }
                        }
                    }
                    str6 = str5;
                } catch (FileNotFoundException e35) {
                    e = e35;
                    str6 = str5;
                } catch (IOException e36) {
                    e = e36;
                    str6 = str5;
                    str = str3;
                    String str112222222 = str + e.getMessage();
                    Debugger.m8609e(str6, str112222222);
                    throw new SyncException(312, str112222222);
                } catch (Throwable th12) {
                    th = th12;
                    strM1170p = "[DEL] InputStream close - Exception = ";
                    str6 = str5;
                    th = th;
                    r6 = fileInputStream;
                    if (r6 != 0) {
                    }
                }
                try {
                    Debugger.m8607d(str6, "[DEL] Finished to get serverCList #: " + i7);
                    try {
                        fileInputStream.close();
                    } catch (IOException e37) {
                        AbstractC0000a.m20q(e37, new StringBuilder("[DEL] InputStream close - Exception = "), str6);
                    }
                    Debugger.m8615i(str6, "[DEL] Handle the extra list : " + arrayList.size());
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((C0009i) it.next()).f38a);
                    }
                    Context context = c0012a.f262e;
                    Context context2 = c0012a.f262e;
                    new HashMap();
                    HashMap map2 = new HashMap();
                    List<DocSyncEntry> cacheSyncDocInfoList = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getCacheSyncDocInfoList(arrayList2);
                    if (cacheSyncDocInfoList != null) {
                        for (DocSyncEntry docSyncEntry : cacheSyncDocInfoList) {
                            map2.put(docSyncEntry.getUuid(), docSyncEntry);
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        C0009i c0009i2 = (C0009i) it2.next();
                        String str14 = c0009i2.f38a;
                        int i8 = c0009i2.f42e;
                        DocSyncEntry docSyncEntry2 = (DocSyncEntry) map2.get(str14);
                        if (docSyncEntry2 != null) {
                            long jLongValue = docSyncEntry2 != null ? docSyncEntry2.getCategoryServerTimeStamp().longValue() : 0L;
                            long j2 = c0009i2.f46i;
                            Iterator it3 = it2;
                            if (j2 > jLongValue) {
                                map = map2;
                                Debugger.m8607d(str6, "[DEL] " + str14 + " : localTime = " + jLongValue + " , serverTime = " + j2);
                                AbstractC0000a.m17n(i8, "[DEL] Update deleted state : deleted in server = ", str6);
                                if (((docSyncEntry2 == null || !"trash:///".equals(docSyncEntry2.getCategoryUuid())) ? 0 : docSyncEntry2.getIsDeleted()) == i8) {
                                    i = 1;
                                } else if (i8 == C0322h.m670a().f831q.getSdocContractNo()) {
                                    Debugger.m8607d(str6, "[DEL] restoreSDoc");
                                    i = 1;
                                    C0322h.m670a().f831q.restoreSDoc(context2, str14, true);
                                } else {
                                    i = 1;
                                    i = 1;
                                    if (i8 == C0322h.m670a().f831q.getSdocContractToRecycleBin()) {
                                        Debugger.m8607d(str6, "[DEL] Move to the recycle bin");
                                        C0322h.m670a().f831q.deleteSDoc(context2, str14, i8, true);
                                    }
                                }
                                Debugger.m8607d(str6, "[DEL] Update favorite : isFavorite in server is " + c0009i2.f44g);
                                int[] iArr = new int[i];
                                int noteFavorite = C0322h.m670a().f831q.setNoteFavorite(context2, str14, c0009i2.f44g, i);
                                iArr[0] = noteFavorite;
                                if (noteFavorite == 0) {
                                    Debugger.m8609e(str6, "[DEL] Fail to set favorite. There is no field");
                                }
                                if (docSyncEntry2 != null) {
                                    try {
                                        filePath = docSyncEntry2.getFilePath();
                                    } catch (Exception e38) {
                                        AbstractC0000a.m21r(e38, new StringBuilder("[DEL] Fail to save favorite to the file : "), str6);
                                    }
                                } else {
                                    filePath = null;
                                }
                                if (filePath != null && !filePath.isEmpty() && SpenSDocFile.isFavorite(filePath) != c0009i2.f44g) {
                                    Debugger.m8607d(str6, "[DEL] Update favorite in file : isFavorite = " + c0009i2.f44g);
                                    SpenSdkCompat.with(context2).asSpenSDocFile().setFavorite(filePath, c0009i2.f44g);
                                }
                                Debugger.m8607d(str6, "[DEL] Update category in server");
                                if (C0322h.m670a().f829o.isExistCategory(context2, c0009i2.f45h) && C0322h.m670a().f829o.getCategoryDeleted(c0009i2.f45h) == C0322h.m670a().f831q.getSdocContractNo()) {
                                    iArr[0] = C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str14, c0009i2.f45h, C0322h.m670a().f831q.getSdocContractNo(), c0009i2.f46i);
                                    Debugger.m8615i(str6, "[DEL] Update category in server - deleted no, category = " + c0009i2.f45h);
                                    if (iArr[0] <= 0) {
                                        Debugger.m8609e(str6, "[DEL] Fail to set as a valid category.");
                                    } else {
                                        Debugger.m8607d(str6, "[DEL] succeed to set as a valid category!");
                                    }
                                } else if (i8 == C0322h.m670a().f831q.getSdocContractNo()) {
                                    iArr[0] = C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str14, "1", C0322h.m670a().f831q.getSdocContractNo(), c0009i2.f46i);
                                    Debugger.m8609e(str6, "[DEL] Update category " + c0009i2.f38a + " to 1 for note = " + str14);
                                    if (iArr[0] <= 0) {
                                        Debugger.m8609e(str6, "[DEL] Fail to set as 1 category.");
                                    } else {
                                        Debugger.m8607d(str6, "[DEL] succeed to set as 1 category!");
                                    }
                                } else {
                                    iArr[0] = C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str14, "trash:///", C0322h.m670a().f831q.getSdocContractNo(), c0009i2.f46i);
                                    Debugger.m8616s(str6, "[DEL] Update category in server - deleted ");
                                    if (iArr[0] <= 0) {
                                        Debugger.m8609e(str6, "[DEL] Fail to set as a valid category.");
                                    } else {
                                        Debugger.m8607d(str6, "[DEL] succeed to set as a valid category!");
                                    }
                                }
                            } else {
                                map = map2;
                                if (j2 == jLongValue) {
                                    AbstractC0000a.m17n(i8, "[DEL] Check deleted state in server : ", str6);
                                    if (((docSyncEntry2 == null || !"trash:///".equals(docSyncEntry2.getCategoryUuid())) ? 0 : docSyncEntry2.getIsDeleted()) != i8) {
                                        if (i8 == C0322h.m670a().f831q.getSdocContractNo()) {
                                            Debugger.m8607d(str6, "[DEL] restoreSDoc");
                                            C0322h.m670a().f831q.restoreSDoc(context2, str14, true);
                                        } else if (i8 == C0322h.m670a().f831q.getSdocContractToRecycleBin()) {
                                            Debugger.m8607d(str6, "[DEL] Move to the recycle bin");
                                            C0322h.m670a().f831q.deleteSDoc(context2, str14, i8, true);
                                        }
                                    }
                                } else {
                                    StringBuilder sbM1323p = AbstractC1974b.m1323p(jLongValue, "[DEL] not updated : localTime = ", " , serverTime = ");
                                    sbM1323p.append(j2);
                                    Debugger.m8616s(str6, sbM1323p.toString());
                                }
                            }
                            it2 = it3;
                            map2 = map;
                        } else {
                            c0012a.f70k.put(str14, c0009i2);
                        }
                    }
                    Debugger.m8615i(str6, "[DEL] Finished to Handle the extra list");
                    return true;
                } catch (FileNotFoundException e39) {
                    e = e39;
                } catch (IOException e40) {
                    e = e40;
                    str = str3;
                    String str1122222222 = str + e.getMessage();
                    Debugger.m8609e(str6, str1122222222);
                    throw new SyncException(312, str1122222222);
                } catch (JSONException e41) {
                    e = e41;
                    String str9222222 = str3 + e.getMessage();
                    Debugger.m8609e(str6, str9222222);
                    throw new SyncException(304, str9222222);
                } catch (Throwable th13) {
                    th = th13;
                    strM1170p = "[DEL] InputStream close - Exception = ";
                    th = th;
                    r6 = fileInputStream;
                    if (r6 != 0) {
                    }
                }
            } else {
                fileInputStream = fileInputStream2;
                str6 = "SyncOldNote$SyncExtraList";
                strM1170p = "[DEL] InputStream close - Exception = ";
                try {
                    Debugger.m8609e(str6, "[DEL] Failed to read extra list of server!");
                    throw new SyncException(304, "[DEL] Failed to read extra list of server!");
                } catch (FileNotFoundException e42) {
                    e = e42;
                } catch (IOException e43) {
                    e = e43;
                    str = str3;
                    String str11222222222 = str + e.getMessage();
                    Debugger.m8609e(str6, str11222222222);
                    throw new SyncException(312, str11222222222);
                } catch (JSONException e44) {
                    e = e44;
                    String str92222222 = str3 + e.getMessage();
                    Debugger.m8609e(str6, str92222222);
                    throw new SyncException(304, str92222222);
                } catch (Throwable th14) {
                    th = th14;
                    th = th;
                    r6 = fileInputStream;
                    if (r6 != 0) {
                    }
                }
            }
        } catch (FileNotFoundException e45) {
            e = e45;
            fileInputStream = fileInputStream2;
            str6 = "SyncOldNote$SyncExtraList";
        } catch (IOException e46) {
            e = e46;
            fileInputStream = fileInputStream2;
            str6 = "SyncOldNote$SyncExtraList";
        } catch (JSONException e47) {
            e = e47;
            fileInputStream = fileInputStream2;
            str6 = "SyncOldNote$SyncExtraList";
        } catch (Throwable th15) {
            th = th15;
            fileInputStream = fileInputStream2;
            str6 = "SyncOldNote$SyncExtraList";
        }
        str2 = str3;
        String str1022222 = str2 + e.getMessage();
        Debugger.m8609e(str6, str1022222);
        throw new SyncException(319, str1022222);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m15174c() throws SyncException {
        long j = this.f10365e;
        C0158a.m407a().getClass();
        if (!C0158a.m410f()) {
            C0012a c0012a = this.f10361a;
            boolean z = c0012a.f76q;
            Context context = c0012a.f262e;
            boolean z2 = z || C0322h.m670a().f829o.getDirtyCountOfNoteCategory(context) > 0;
            c0012a.f76q = z2;
            if (z2) {
                Debugger.m8615i("SyncOldNote$SyncExtraList", "[UEL] Need to update Server");
                try {
                    C0322h.m670a().f831q.getSdocContractNo();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("syncname", "extra.list");
                    jSONObject.put("syncpath", "extra.list");
                    jSONObject.put("ModifiedTime", j);
                    jSONObject.put("IsFolder", "0");
                    jSONObject.put("category", "category");
                    HashMap uuidAndNoteCategoryTimeList = C0322h.m670a().f829o.getUuidAndNoteCategoryTimeList(context);
                    if (uuidAndNoteCategoryTimeList == null) {
                        Debugger.m8607d("SyncOldNote$SyncExtraList", "[UEL] update list is null");
                        return false;
                    }
                    m15172a(uuidAndNoteCategoryTimeList);
                    if (this.f10363c.isCancelled()) {
                        Debugger.m8607d("SyncOldNote$SyncExtraList", "[UEL] Cancelled Extra List");
                        return false;
                    }
                    String str = this.f10364d + "extra.list";
                    AbstractC6848m.m5014g(c0012a.f69j, str, "extra_uuid_version", Long.toString(j), jSONObject, new C3970a(this, 13, uuidAndNoteCategoryTimeList, str));
                    Debugger.m8615i("SyncOldNote$SyncExtraList", "[UEL] success to upload Extra List : " + uuidAndNoteCategoryTimeList.size());
                    Debugger.m8615i("SyncOldNote$SyncExtraList", "[UEL] Finished to update Server");
                    return true;
                } catch (SyncException e) {
                    Debugger.m8609e("SyncOldNote$SyncExtraList", "[UEL] Failed to upload Extra List");
                    throw e;
                } catch (JSONException e2) {
                    Debugger.m8609e("SyncOldNote$SyncExtraList", "[UEL] Failed to to upload Extra List : " + e2.getMessage());
                    throw new SyncException(304, "Failed to upload category");
                }
            }
        }
        return true;
    }
}
