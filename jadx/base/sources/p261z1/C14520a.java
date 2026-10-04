package p261z1;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.credentials.playservices.C2517b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.C13883h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0002b;
import p002A0.C0011k;
import p003A1.C0012a;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p086V.C0322h;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: z1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14520a {

    /* JADX INFO: renamed from: a */
    public final ArrayList f10352a;

    /* JADX INFO: renamed from: b */
    public final ArrayList f10353b;

    /* JADX INFO: renamed from: c */
    public final ArrayList f10354c;

    /* JADX INFO: renamed from: d */
    public final ArrayList f10355d;

    /* JADX INFO: renamed from: e */
    public final C0012a f10356e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC14510a f10357f;

    /* JADX INFO: renamed from: g */
    public final String f10358g;

    /* JADX INFO: renamed from: h */
    public ArrayList f10359h;

    /* JADX INFO: renamed from: i */
    public final HashMap f10360i;

    public C14520a(C0012a c0012a, InterfaceC14510a interfaceC14510a, int i) {
        switch (i) {
            case 1:
                this.f10352a = new ArrayList();
                this.f10353b = new ArrayList();
                this.f10354c = new ArrayList();
                this.f10355d = new ArrayList();
                this.f10360i = new HashMap();
                this.f10356e = c0012a;
                this.f10357f = interfaceC14510a;
                c0012a.getClass();
                this.f10358g = C0012a.m39b();
                break;
            default:
                this.f10352a = new ArrayList();
                this.f10353b = new ArrayList();
                this.f10354c = new ArrayList();
                this.f10355d = new ArrayList();
                this.f10360i = new HashMap();
                this.f10356e = c0012a;
                this.f10357f = interfaceC14510a;
                c0012a.getClass();
                this.f10358g = C0012a.m39b();
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m15167c(C0002b c0002b, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("category_uuid", c0002b.f7a);
            jSONObject.put("name", c0002b.f10d);
            jSONObject.put("color", c0002b.f11e);
            jSONObject.put("timestamp", c0002b.f12f);
            jSONObject.put("deleted", c0002b.f9c);
            String str2 = str + ".json";
            File file = new File(str2);
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncCategory", "failed to delete makeCategoryJSON");
            }
            if (!file.createNewFile()) {
                Debugger.m8609e("SyncOldNote$SyncCategory", "Failed to create makeCategoryJSON");
                throw new SyncException(312, "Failed to create makeCategoryJSON");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
                C0322h.m670a().f816b.zip(str2, str);
            } finally {
            }
        } catch (IOException e) {
            String str3 = "Failed to makeCategoryJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategory", str3);
            throw new SyncException(312, str3);
        } catch (JSONException e2) {
            String str4 = "Failed to makeCategoryJSON() - " + e2.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategory", str4);
            throw new SyncException(304, str4);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m15168d(C0011k c0011k, String str) throws SyncException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag_uuid", c0011k.f60a);
            jSONObject.put("name", c0011k.f63d);
            jSONObject.put("extra_info", c0011k.f66g);
            jSONObject.put(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME, c0011k.f65f);
            jSONObject.put("deleted", c0011k.f62c);
            jSONObject.put("timestamp", c0011k.f64e);
            String str2 = str + ".json";
            File file = new File(str2);
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncTag", "failed to delete makeTagJSON");
            }
            if (!file.createNewFile()) {
                Debugger.m8609e("SyncOldNote$SyncTag", "Failed to create makeTagJSON");
                throw new SyncException(312, "Failed to create makeTagJSON");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
                C0322h.m670a().f816b.zip(str2, str);
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            String str3 = "Failed to makeTagJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncTag", str3);
            throw new SyncException(312, str3);
        } catch (JSONException e2) {
            String str4 = "Failed to makeTagJSON() - " + e2.getMessage();
            Debugger.m8609e("SyncOldNote$SyncTag", str4);
            throw new SyncException(304, str4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0002b m15169a(String str) throws Throwable {
        FileInputStream fileInputStream;
        String str2;
        int i;
        try {
            try {
                try {
                    String strM397l = AbstractC0155m.m397l(this.f10358g);
                    Objects.requireNonNull(strM397l);
                    C0322h.m670a().f816b.unzip(new File(str), new File(strM397l), true, true);
                    str2 = str + ".json";
                    fileInputStream = new FileInputStream(str2);
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                } catch (JSONException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                Throwable th2 = th;
                if (fileInputStream == null) {
                    throw th2;
                }
                try {
                    fileInputStream.close();
                    throw th2;
                } catch (IOException e5) {
                    Debugger.m8609e("SyncOldNote$SyncCategory", "InputStream close - Exception = " + e5);
                    throw th2;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
        } catch (IOException e7) {
            e = e7;
        } catch (JSONException e8) {
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            Throwable th22 = th;
            if (fileInputStream == null) {
            }
        }
        try {
            JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
            if (jSONObjectM394i == null) {
                Debugger.m8609e("SyncOldNote$SyncCategory", "Failed to NoteServiceHelper.readIt");
                throw new SyncException(304, "Failed to NoteServiceHelper.readIt");
            }
            String string = jSONObjectM394i.getString("category_uuid");
            String string2 = jSONObjectM394i.getString("name");
            if (jSONObjectM394i.has("color")) {
                Debugger.m8607d("SyncOldNote$SyncCategory", "categoryColor = -1");
                i = jSONObjectM394i.getInt("color");
            } else {
                i = -1;
            }
            C0002b c0002b = new C0002b(i, string, str, jSONObjectM394i.getLong("timestamp"), string2, jSONObjectM394i.getBoolean("deleted"));
            if (!new File(str2).delete()) {
                Debugger.m8609e("SyncOldNote$SyncCategory", "failed to delete unzipedFilePath");
            }
            try {
                fileInputStream.close();
                return c0002b;
            } catch (IOException e9) {
                Debugger.m8609e("SyncOldNote$SyncCategory", "InputStream close - Exception = " + e9);
                return c0002b;
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            String str3 = "Failed to getCategoryJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategory", str3);
            throw new SyncException(319, str3);
        } catch (IOException e11) {
            e = e11;
            String str4 = "Failed to getCategoryJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategory", str4);
            throw new SyncException(312, str4);
        } catch (JSONException e12) {
            e = e12;
            String str5 = "Failed to getCategoryJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategory", str5);
            throw new SyncException(304, str5);
        } catch (Throwable th4) {
            th = th4;
            Throwable th222 = th;
            if (fileInputStream == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0011k m15170b(String str) throws Throwable {
        FileInputStream fileInputStream;
        String str2;
        try {
            try {
                try {
                    String strM397l = AbstractC0155m.m397l(this.f10358g);
                    Objects.requireNonNull(strM397l);
                    C0322h.m670a().f816b.unzip(new File(str), new File(strM397l), true, true);
                    str2 = str + ".json";
                    fileInputStream = new FileInputStream(str2);
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                } catch (JSONException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                Throwable th2 = th;
                if (fileInputStream == null) {
                    throw th2;
                }
                try {
                    fileInputStream.close();
                    throw th2;
                } catch (IOException e5) {
                    Debugger.m8609e("SyncOldNote$SyncTag", "InputStream close - Exception = " + e5);
                    throw th2;
                }
            }
            try {
                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                if (jSONObjectM394i == null) {
                    Debugger.m8609e("SyncOldNote$SyncTag", "Failed to NoteServiceHelper.readIt");
                    throw new SyncException(304, "Failed to NoteServiceHelper.readIt");
                }
                String string = jSONObjectM394i.getString("tag_uuid");
                String string2 = jSONObjectM394i.getString("name");
                String string3 = jSONObjectM394i.has("extra_info") ? jSONObjectM394i.getString("extra_info") : null;
                if (string3 == null) {
                    string3 = "";
                }
                C0011k c0011k = new C0011k(string, str, string2, jSONObjectM394i.getBoolean("deleted"), jSONObjectM394i.getLong("timestamp"), string3);
                if (jSONObjectM394i.has("extra_info")) {
                    c0011k.f65f = jSONObjectM394i.getLong(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME);
                }
                if (!new File(str2).delete()) {
                    Debugger.m8609e("SyncOldNote$SyncTag", "failed to delete unzipedFilePath");
                }
                try {
                    fileInputStream.close();
                    return c0011k;
                } catch (IOException e6) {
                    Debugger.m8609e("SyncOldNote$SyncTag", "InputStream close - Exception = " + e6);
                    return c0011k;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                String str3 = "Failed to getTagJSON() - " + e.getMessage();
                Debugger.m8609e("SyncOldNote$SyncTag", str3);
                throw new SyncException(319, str3);
            } catch (IOException e8) {
                e = e8;
                String str4 = "Failed to getTagJSON() - " + e.getMessage();
                Debugger.m8609e("SyncOldNote$SyncTag", str4);
                throw new SyncException(312, str4);
            } catch (JSONException e9) {
                e = e9;
                String str5 = "Failed to getTagJSON() - " + e.getMessage();
                Debugger.m8609e("SyncOldNote$SyncTag", str5);
                throw new SyncException(304, str5);
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                if (fileInputStream == null) {
                }
            }
        } catch (FileNotFoundException e10) {
            e = e10;
        } catch (IOException e11) {
            e = e11;
        } catch (JSONException e12) {
            e = e12;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            Throwable th222 = th;
            if (fileInputStream == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:193:0x06ef, code lost:
    
        throw new com.samsung.android.app.notes.sync.error.SyncException(323, "disk space is full. can not add tag.");
     */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m15171e() throws SyncException {
        boolean z;
        boolean z2;
        int i;
        long j = this.f10356e.f263f - 600000;
        Debugger.m8607d("SyncOldNote$SyncTag", "nextSyncTime: " + j);
        Debugger.m8607d("SyncOldNote$SyncTag", "Start to get local tag");
        ArrayList arrayList = new ArrayList();
        List arrayList2 = this.f10356e.f82w;
        if (arrayList2 == null) {
            arrayList2 = C0322h.m670a().f830p.getTagUUIDListByDirty(C0322h.m670a().f831q.getSdocContractYes());
        }
        if (arrayList2 == null) {
            Debugger.m8607d("SyncOldNote$SyncTag", "Failed to GetLocalTagArray");
            arrayList2 = new ArrayList();
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            C0011k c0011k = new C0011k(str, AbstractC0541b.m756B(str, ".tag"), C0322h.m670a().f830p.getTagName(str), C0322h.m670a().f830p.getTagDeleted(str) != C0322h.m670a().f831q.getSdocContractNo(), C0322h.m670a().f830p.getTagServerTimestamp(str), C0322h.m670a().f830p.getTagExtraInfo(str));
            c0011k.f65f = C0322h.m670a().f830p.getTagLastModifiedTime(str);
            arrayList.add(c0011k);
        }
        Debugger.m8607d("SyncOldNote$SyncTag", "Finish to get local tag " + arrayList.size());
        this.f10359h = arrayList;
        Debugger.m8607d("SyncOldNote$SyncTag", "GetServerTagArray start");
        ArrayList<C0011k> arrayList3 = new ArrayList();
        try {
            Iterator it2 = this.f10356e.f80u.iterator();
            while (it2.hasNext()) {
                JSONArray jSONArray = ((JSONObject) it2.next()).getJSONArray("snote_list");
                int length = jSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (!jSONObject.has("filepath")) {
                        i = length;
                        Debugger.m8609e("SyncOldNote$SyncTag", "GetServerTagArray : no filepath!");
                    } else if (jSONObject.getString("filepath").endsWith(".tag")) {
                        C0011k c0011k2 = new C0011k();
                        c0011k2.f60a = jSONObject.getString("datakey");
                        c0011k2.f61b = jSONObject.getString("filepath");
                        i = length;
                        c0011k2.f64e = jSONObject.getLong("clientTimestamp");
                        c0011k2.f62c = jSONObject.getBoolean("deleted");
                        arrayList3.add(c0011k2);
                    } else {
                        i = length;
                    }
                    i2++;
                    length = i;
                }
            }
            Debugger.m8607d("SyncOldNote$SyncTag", "GetServerTagArray finish : " + arrayList3.size());
            for (C0011k c0011k3 : arrayList3) {
                this.f10360i.put(c0011k3.f60a, c0011k3);
            }
            if (this.f10357f.isCancelled()) {
                Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled Tag");
                return false;
            }
            ArrayList arrayList4 = this.f10352a;
            ArrayList arrayList5 = this.f10355d;
            HashMap map = this.f10360i;
            ArrayList arrayList6 = this.f10353b;
            ArrayList arrayList7 = this.f10354c;
            Debugger.m8615i("SyncOldNote$SyncTag", "Start to compare");
            for (C0011k c0011k4 : this.f10359h) {
                String str2 = c0011k4.f60a;
                boolean z3 = c0011k4.f62c;
                C0011k c0011k5 = (C0011k) map.get(str2);
                if (c0011k5 != null) {
                    boolean z4 = c0011k5.f62c;
                    z2 = z;
                    map.remove(c0011k5.f60a);
                    long j2 = c0011k4.f64e;
                    long j3 = c0011k5.f64e;
                    if (j3 > j2) {
                        if (z4) {
                            arrayList7.add(c0011k5);
                        } else {
                            arrayList6.add(c0011k5);
                        }
                    } else if (j3 >= j2) {
                        C0322h.m670a().f830p.setTagDirty(c0011k4.f60a, C0322h.m670a().f831q.getSdocContractNo());
                    } else if (!z3) {
                        arrayList4.add(c0011k4);
                    } else if (z4) {
                        arrayList7.add(c0011k4);
                    } else {
                        arrayList5.add(c0011k4);
                    }
                } else {
                    z2 = z;
                    if (z3) {
                        arrayList5.add(c0011k4);
                    } else {
                        arrayList4.add(c0011k4);
                    }
                }
                z = z2;
            }
            boolean z5 = z;
            Debugger.m8615i("SyncOldNote$SyncTag", "toUploadList: " + arrayList4.size() + " ,toDownloadList: " + arrayList6.size());
            Debugger.m8607d("SyncOldNote$SyncTag", "toDeleteLocalList: " + arrayList7.size() + " ,toDeleteServerList : " + arrayList5.size() + " ->");
            Debugger.m8607d("SyncOldNote$SyncTag", "Start to compare more");
            Iterator it3 = map.entrySet().iterator();
            while (it3.hasNext()) {
                C0011k c0011k6 = (C0011k) ((Map.Entry) it3.next()).getValue();
                if (C0322h.m670a().f830p.getTagServerTimestamp(c0011k6.f60a) != c0011k6.f64e) {
                    if (!c0011k6.f62c) {
                        arrayList6.add(c0011k6);
                    } else if (C0322h.m670a().f830p.isExistTag(c0011k6.f60a)) {
                        arrayList7.add(c0011k6);
                    }
                }
            }
            Debugger.m8615i("SyncOldNote$SyncTag", "toDeleteLocalList: " + arrayList7.size() + " ,toDownloadList : " + arrayList6.size());
            if (this.f10355d.size() + this.f10354c.size() + this.f10353b.size() + this.f10352a.size() > 0) {
                if (!this.f10354c.isEmpty()) {
                    Debugger.m8607d("SyncOldNote$SyncTag", "Start to delete Local tag : " + this.f10354c.size());
                    for (C0011k c0011k7 : this.f10354c) {
                        String str3 = c0011k7.f60a;
                        Debugger.m8616s("SyncOldNote$SyncTag", "Tag : deleteSDoc - " + str3);
                        synchronized (C0322h.m670a().f830p.synchronizeTag()) {
                            try {
                                if (C0322h.m670a().f830p.getTagServerTimestamp(str3) <= c0011k7.f64e) {
                                    if (C0322h.m670a().f830p.getTagDeleted(str3) == C0322h.m670a().f831q.getSdocContractNo()) {
                                        C0322h.m670a().f830p.deleteTag(this.f10356e.f262e, str3, c0011k7.f64e, C0322h.m670a().f831q.getSdocContractNo(), true);
                                    }
                                    C0322h.m670a().f830p.deleteTagSync(str3);
                                }
                            } finally {
                            }
                        }
                        Thread.yield();
                    }
                    Debugger.m8607d("SyncOldNote$SyncTag", "Finished to delete Local");
                }
                if (!this.f10355d.isEmpty()) {
                    C0158a.m407a().getClass();
                    if (!C0158a.m410f()) {
                        StringBuilder sb = new StringBuilder("Start to delete Server : ");
                        ArrayList arrayList8 = this.f10355d;
                        sb.append(arrayList8.size());
                        Debugger.m8607d("SyncOldNote$SyncTag", sb.toString());
                        Iterator it4 = arrayList8.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                Debugger.m8607d("SyncOldNote$SyncTag", "Finished to delete server");
                                break;
                            }
                            C0011k c0011k8 = (C0011k) it4.next();
                            if (this.f10357f.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled Tag");
                                if (this.f10357f.isCancelled()) {
                                    Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled before uploading tag!");
                                    return z5;
                                }
                            } else {
                                String str4 = c0011k8.f60a;
                                Debugger.m8616s("SyncOldNote$SyncTag", "Delete Server Files - " + str4);
                                try {
                                    AbstractC6848m.m5008a(this.f10356e.f69j, str4, String.valueOf(c0011k8.f64e), new C13883h(this, str4, 9));
                                } catch (SyncException e) {
                                    AbstractC6670b.m4752m(e, new StringBuilder("Tag : Failed to deleteFile - "), "SyncOldNote$SyncTag");
                                    throw e;
                                }
                            }
                        }
                    }
                }
                if (!this.f10352a.isEmpty()) {
                    C0158a.m407a().getClass();
                    if (!C0158a.m410f()) {
                        C0012a c0012a = this.f10356e;
                        StringBuilder sb2 = new StringBuilder("Start to upload : ");
                        ArrayList arrayList9 = this.f10352a;
                        sb2.append(arrayList9.size());
                        Debugger.m8607d("SyncOldNote$SyncTag", sb2.toString());
                        Iterator it5 = arrayList9.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                Debugger.m8607d("SyncOldNote$SyncTag", "Finished upload");
                                break;
                            }
                            C0011k c0011k9 = (C0011k) it5.next();
                            String str5 = c0011k9.f60a;
                            String str6 = c0011k9.f61b;
                            Debugger.m8616s("SyncOldNote$SyncTag", "Upload Files - " + str5);
                            if (this.f10357f.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled to upload tag!");
                                if (this.f10357f.isCancelled()) {
                                    Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled before downloading tag!");
                                    return z5;
                                }
                            } else {
                                try {
                                    JSONObject jSONObjectM38a = c0011k9.m38a();
                                    String str7 = this.f10358g + str6;
                                    m15168d(c0011k9, str7);
                                    c0011k9.f64e = C0322h.m670a().f830p.getTagServerTimestamp(str5);
                                    Debugger.m8616s("SyncOldNote$SyncTag", "uploadFile - uuid:  " + str5 + " , name: " + str6);
                                    AbstractC6848m.m5014g(c0012a.f69j, str7, str5, String.valueOf(c0011k9.f64e), jSONObjectM38a, new C2517b(7, this, str5, c0011k9, str7));
                                } catch (SyncException e2) {
                                    Debugger.m8609e("SyncOldNote$SyncTag", "Failed to uploadFile - " + e2.getMessage());
                                    if (e2.getExceptionCode() == 312) {
                                        boolean z6 = z5;
                                        c0012a.f68i = z6;
                                        c0012a.f261d = z6;
                                    } else {
                                        boolean z7 = z5;
                                        if (e2.getExceptionCode() != 501) {
                                            throw e2;
                                        }
                                        c0012a.f68i = z7;
                                        c0012a.f261d = z7;
                                        Debugger.m8609e("SyncOldNote$SyncTag", "Recover the previous history for tag");
                                        C0145c.m310R("TagLastSyncTime", "TagLastSyncTimeKey", Long.toString(Long.parseLong("1464416139847")));
                                        C0145c.m309Q(c0012a.f262e, Boolean.TRUE);
                                    }
                                } catch (JSONException e3) {
                                    String str8 = "Failed to uploadFile -" + e3.getMessage();
                                    Debugger.m8609e("SyncOldNote$SyncTag", str8);
                                    throw new SyncException(304, str8);
                                }
                                z5 = false;
                            }
                        }
                    }
                }
                if (!this.f10353b.isEmpty()) {
                    Debugger.m8607d("SyncOldNote$SyncTag", "Start to download : " + this.f10353b.size());
                    Iterator it6 = this.f10353b.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            Debugger.m8607d("SyncOldNote$SyncTag", "Finished to download");
                            break;
                        }
                        C0011k c0011k10 = (C0011k) it6.next();
                        String str9 = c0011k10.f60a;
                        if (this.f10357f.isCancelled()) {
                            Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled tag");
                            if (this.f10357f.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncTag", "Cancelled before finishing downloading tag!");
                                return false;
                            }
                        } else if (C0322h.m670a().f830p.getTagServerTimestamp(str9) <= c0011k10.f64e) {
                            Debugger.m8616s("SyncOldNote$SyncTag", "Download Files - " + str9);
                            try {
                                String strM397l = AbstractC0155m.m397l(this.f10358g);
                                AbstractC6848m.m5009b(this.f10356e.f69j, str9, strM397l);
                                String str10 = strM397l + c0011k10.f61b;
                                File file = new File(str10);
                                if (!file.exists()) {
                                    throw new SyncException(307, "There is no the completeFile.");
                                }
                                synchronized (C0322h.m670a().f830p.synchronizeTag()) {
                                    try {
                                        if (C0322h.m670a().f830p.getTagServerTimestamp(str9) <= c0011k10.f64e) {
                                            C0011k c0011kM15170b = m15170b(str10);
                                            if (C0322h.m670a().f830p.isExistTag(str9)) {
                                                C0322h.m670a().f830p.updateTagName(str9, c0011kM15170b.f63d);
                                            } else if (C0322h.m670a().f830p.addTag(this.f10356e.f262e, str9, c0011kM15170b.f63d, true) == null) {
                                                break;
                                            }
                                            if (C0322h.m670a().f830p.getTagDeleted(str9) == C0322h.m670a().f831q.getSdocContractYes()) {
                                                C0322h.m670a().f830p.recoveryTag(this.f10356e.f262e, str9, c0011kM15170b.f64e, C0322h.m670a().f831q.getSdocContractNo());
                                            } else {
                                                if (c0011kM15170b.f65f == 0) {
                                                    C0322h.m670a().f830p.setTagServerTimestamp(str9, c0011kM15170b.f64e);
                                                } else {
                                                    C0322h.m670a().f830p.setTagModifiedAndServerTimestampAndExtraInfo(str9, c0011kM15170b.f65f, c0011kM15170b.f64e, c0011kM15170b.f66g);
                                                }
                                                C0322h.m670a().f830p.setTagDirty(str9, C0322h.m670a().f831q.getSdocContractNo());
                                            }
                                            if (!file.delete()) {
                                                Debugger.m8609e("SyncOldNote$SyncTag", "failed to delete completeFile");
                                            }
                                        } else if (!file.delete()) {
                                            Debugger.m8609e("SyncOldNote$SyncTag", "failed to delete tag completeFile");
                                        }
                                    } finally {
                                    }
                                }
                            } catch (SyncException e5) {
                                AbstractC6670b.m4752m(e5, new StringBuilder("Failed to downloadFile -"), "SyncOldNote$SyncTag");
                                throw e5;
                            }
                        }
                    }
                }
            } else {
                Debugger.m8615i("SyncOldNote$SyncTag", "There is no tag to sync");
            }
            this.f10356e.getClass();
            if (!this.f10356e.f68i) {
                return true;
            }
            C0145c.m310R("TagLastSyncTime", "TagLastSyncTimeKey", Long.toString(j));
            Debugger.m8607d("SyncOldNote$SyncTag", "Update last syncTimeForTag : " + j);
            return true;
        } catch (JSONException e6) {
            String str11 = "GetServerTagArray - downloadList - " + e6.getMessage();
            Debugger.m8609e("SyncOldNote$SyncTag", str11);
            throw new SyncException(304, str11);
        }
    }
}
