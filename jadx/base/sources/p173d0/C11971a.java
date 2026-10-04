package p173d0;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.adobe.internal.xmp.XMPConst;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentTempDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentTempDataEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentTempDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentPageRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesMappedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0001a;
import p026F1.C0097a;
import p079T.AbstractC0299q;
import p175e0.AbstractC11974a;
import p178f0.C11979b;
import p178f0.C11980c;
import p182g0.C11991a;
import p182g0.C11992b;
import p182g0.C11998h;
import p182g0.C12000j;
import p182g0.C12001k;
import p182g0.C12002l;
import p182g0.C12003m;
import p182g0.C12004n;
import p182g0.C12005o;
import p182g0.C12011u;
import p185h0.InterfaceC12017b;
import p186h1.C12020a;
import p191j0.AbstractC12916b;
import p191j0.C12917c;
import p191j0.C12920f;
import p191j0.C12923i;
import p191j0.C12930p;
import p191j0.C12931q;
import p191j0.C12932r;
import p194k0.C12965w;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: d0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11971a implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public long f8517a;

    /* JADX INFO: renamed from: e */
    public C12005o f8521e;

    /* JADX INFO: renamed from: f */
    public C11998h f8522f;

    /* JADX INFO: renamed from: g */
    public ArrayList f8523g;

    /* JADX INFO: renamed from: j */
    public C6906i f8526j;

    /* JADX INFO: renamed from: k */
    public C12965w f8527k;

    /* JADX INFO: renamed from: l */
    public Context f8528l;

    /* JADX INFO: renamed from: m */
    public String f8529m;

    /* JADX INFO: renamed from: n */
    public String f8530n;

    /* JADX INFO: renamed from: p */
    public String f8532p;

    /* JADX INFO: renamed from: q */
    public long f8533q;

    /* JADX INFO: renamed from: r */
    public String f8534r;

    /* JADX INFO: renamed from: s */
    public String f8535s;

    /* JADX INFO: renamed from: b */
    public boolean f8518b = false;

    /* JADX INFO: renamed from: c */
    public String f8519c = "";

    /* JADX INFO: renamed from: d */
    public boolean f8520d = false;

    /* JADX INFO: renamed from: h */
    public ArrayList f8524h = new ArrayList();

    /* JADX INFO: renamed from: i */
    public boolean f8525i = false;

    /* JADX INFO: renamed from: o */
    public boolean f8531o = false;

    public C11971a(Context context, String str) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("WDocData() - context is null.");
        }
        this.f8532p = str;
        this.f8528l = context;
        new HashMap();
        LoggerBase.m7130i("WCon_WDocData", "initializeConverterTempDir");
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8528l.getFilesDir());
        String str2 = File.separator;
        String strM1170p = AbstractC0622a.m1170p(str2, "xmlConvert", sb);
        File file = new File(strM1170p);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("initializeConverterTempDir - fail to make cache folder(" + LoggerBase.getEncode(strM1170p) + ")");
        }
        String str3 = m13526c(this.f8528l) + str2 + str + "_" + hashCode();
        File file2 = new File(str3);
        if (!file2.exists() && !file2.mkdirs()) {
            throw new IOException("writeWDoc - fail to make out cache folder(" + LoggerBase.getEncode(str3) + ")");
        }
        String strM757C = AbstractC0541b.m757C(str3, str2, "media");
        File file3 = new File(strM757C);
        if (!file3.exists() && !file3.mkdirs()) {
            throw new IOException("initializeConverterTempDir - fail to make cache folder(" + LoggerBase.getEncode(strM757C) + ")");
        }
        this.f8530n = str3;
        LoggerBase.m7130i("WCon_WDocData", "WDocData - new, hash = [" + hashCode() + "], cp = [" + LoggerBase.getEncode(this.f8530n) + "]");
        String str4 = this.f8530n;
        C6906i c6906i = new C6906i(false);
        C11979b c11979b = new C11979b();
        c11979b.f8573a = str4;
        String strM757C2 = AbstractC0541b.m757C(str4, str2, "media");
        c11979b.f8574b = strM757C2;
        Log.i("WCon_ContentFileManager", "initializeCacheDir");
        File file4 = new File(strM757C2);
        if (!file4.exists() && !file4.mkdirs()) {
            throw new IOException("initializeMediaDir - fail to make cache folder(" + LoggerBase.getEncode(strM757C2) + ")");
        }
        c11979b.f8575c = new HashMap();
        c11979b.f8576d = new HashMap();
        c11979b.f8577e = new ArrayList();
        c11979b.f8578f = new ArrayList();
        c6906i.f4483b = c11979b;
        c6906i.f4484c = new C11980c();
        this.f8526j = c6906i;
    }

    /* JADX INFO: renamed from: c */
    public static String m13526c(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        return AbstractC0622a.m1170p(File.separator, "xmlConvert", sb);
    }

    /* JADX INFO: renamed from: a */
    public final void m13527a() {
        Debugger.printMemory("WCon_WDocData", "[CurrentMemoryState] Before filling the notes tree");
        C12005o c12005o = new C12005o();
        this.f8521e = c12005o;
        c12005o.f8712a = this.f8522f.f8651I;
        c12005o.f8713b = new ArrayList();
        for (C12011u c12011u : this.f8524h) {
            C12004n c12004n = new C12004n();
            c12004n.f8707a = c12011u.f8744e;
            c12004n.f8708b = c12011u.f8760u;
            c12004n.f8709c = c12011u.m13611e();
            c12004n.f8711d = new ArrayList();
            for (C11992b c11992b : c12011u.f8761v) {
                C12002l c12002l = new C12002l();
                c12002l.f8707a = c11992b.f8628g;
                c12002l.f8708b = c11992b.f8630i;
                c12002l.f8709c = c11992b.m13592e();
                c12002l.f8710d = new ArrayList();
                for (AbstractC12916b abstractC12916b : c11992b.f8631j) {
                    C12003m c12003m = new C12003m();
                    c12003m.f8707a = abstractC12916b.mo13811k();
                    c12003m.f8708b = abstractC12916b.mo13808h();
                    c12003m.f8709c = abstractC12916b.mo13809i();
                    c12002l.f8710d.add(c12003m);
                }
                c12004n.f8711d.add(c12002l);
            }
            this.f8521e.f8713b.add(c12004n);
        }
        this.f8521e.f8714c = new ArrayList();
        for (C11991a c11991a : ((C11979b) this.f8526j.f4483b).f8577e) {
            C12001k c12001k = new C12001k();
            c12001k.f8707a = c11991a.f8618k;
            c12001k.f8708b = c11991a.f8615h;
            c12001k.f8709c = c11991a.f8612e;
            this.f8521e.f8714c.add(c12001k);
        }
        this.f8521e.f8715d = new ArrayList();
        for (AbstractC12916b abstractC12916b2 : this.f8522f.f8692l0) {
            C12003m c12003m2 = new C12003m();
            c12003m2.f8707a = abstractC12916b2.mo13811k();
            c12003m2.f8708b = abstractC12916b2.mo13808h();
            c12003m2.f8709c = abstractC12916b2.mo13809i();
            this.f8521e.f8715d.add(c12003m2);
        }
        C12005o c12005o2 = this.f8521e;
        C12000j c12000j = new C12000j();
        c12005o2.f8716e = c12000j;
        C12920f c12920f = this.f8522f.f8654L;
        c12000j.f8707a = c12920f.f8978I.f9296a;
        c12000j.f8708b = c12920f.f8980K;
        c12000j.f8709c = c12920f.mo13809i();
        Debugger.printMemory("WCon_WDocData", "[CurrentMemoryState] After filling the notes tree");
    }

    /* JADX INFO: renamed from: b */
    public final C11971a m13528b() {
        C11971a c11971a = new C11971a();
        c11971a.f8518b = false;
        c11971a.f8519c = "";
        c11971a.f8520d = false;
        c11971a.f8524h = new ArrayList();
        c11971a.f8525i = false;
        c11971a.f8531o = false;
        c11971a.f8528l = this.f8528l;
        new HashMap();
        c11971a.f8530n = this.f8530n;
        C6906i c6906i = new C6906i(6);
        c11971a.f8526j = c6906i;
        c6906i.f4483b = (C11979b) this.f8526j.f4483b;
        LoggerBase.m7130i("WCon_WDocData", "WDocData - downsync, hash = [" + c11971a.hashCode() + "], cp = [" + LoggerBase.getEncode(c11971a.f8530n) + "]");
        return c11971a;
    }

    /* JADX INFO: renamed from: d */
    public final void m13529d() {
        Iterator it = this.f8524h.iterator();
        while (it.hasNext()) {
            for (C11992b c11992b : ((C12011u) it.next()).f8761v) {
                c11992b.getClass();
                ArrayList arrayList = new ArrayList();
                C12931q c12931q = null;
                for (int i = 0; i < c11992b.f8631j.size(); i++) {
                    AbstractC12916b abstractC12916b = (AbstractC12916b) c11992b.f8631j.get(i);
                    if (abstractC12916b.f8990a != 1) {
                        if (c12931q != null) {
                            arrayList.add(c12931q);
                            c12931q = null;
                        }
                        arrayList.add(abstractC12916b);
                    } else {
                        if (c12931q == null) {
                            c12931q = new C12931q(c11992b.f8634m);
                        }
                        C12930p c12930p = (C12930p) abstractC12916b;
                        ArrayList arrayList2 = c12931q.f9105V;
                        if (arrayList2.size() < 100) {
                            arrayList2.add(c12930p);
                        }
                        if (abstractC12916b.f8983N != null) {
                            arrayList.add(c12931q);
                            c12931q = null;
                        } else if (i == c11992b.f8631j.size() - 1) {
                            arrayList.add(c12931q);
                        }
                    }
                }
                c11992b.f8631j.clear();
                c11992b.f8631j.addAll(arrayList);
            }
        }
        ((C11980c) this.f8526j.f4484c).f8581c.clear();
        m13527a();
    }

    /* JADX INFO: renamed from: e */
    public final void m13530e() {
        try {
            LoggerBase.m7130i("WCon_WDocData", " >>> WDocInfo - [" + this.f8532p + "], ct = [" + this.f8522f.f8702v + "], mt = [" + this.f8522f.f8704x + "], st = [" + this.f8533q + "]");
            StringBuilder sb = new StringBuilder(" >>> WDocInfo - Page count = [");
            sb.append(this.f8524h.size());
            sb.append("]");
            LoggerBase.m7130i("WCon_WDocData", sb.toString());
            int i = 0;
            for (C12011u c12011u : this.f8524h) {
                LoggerBase.m7130i("WCon_WDocData", " >>> WDocInfo - Page[" + i + "][" + c12011u.f8744e + "], t = [" + c12011u.f8760u + "], h = [" + c12011u.m13611e() + "]");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" >>> WDocInfo - Layer count = [");
                sb2.append(c12011u.f8761v.size());
                sb2.append("]");
                LoggerBase.m7130i("WCon_WDocData", sb2.toString());
                int i2 = 0;
                for (C11992b c11992b : c12011u.f8761v) {
                    LoggerBase.m7130i("WCon_WDocData", " >>> WDocInfo - Layer[" + i2 + "][" + c11992b.f8628g + "], t = [" + c11992b.f8630i + "], h = [" + c11992b.m13592e() + "]");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" >>> WDocInfo - Object count = [");
                    sb3.append(c11992b.f8631j.size());
                    sb3.append("]");
                    LoggerBase.m7130i("WCon_WDocData", sb3.toString());
                    int i4 = 0;
                    for (AbstractC12916b abstractC12916b : c11992b.f8631j) {
                        LoggerBase.m7130i("WCon_WDocData", " >>> WDocInfo - Object[" + i4 + "][" + abstractC12916b.f8990a + "][" + abstractC12916b.mo13811k() + "], t = [" + abstractC12916b.mo13808h() + "], h = [" + abstractC12916b.mo13809i() + "]");
                        i4++;
                        i = i;
                    }
                    i2++;
                }
                i++;
            }
            for (C11991a c11991a : ((C11979b) this.f8526j.f4483b).f8577e) {
                LoggerBase.m7130i("WCon_WDocData", " >>> WDocInfo - ContentFile[" + c11991a.f8608a + "][" + c11991a.f8616i + "][" + LoggerBase.getEncode(c11991a.f8613f) + "][" + c11991a.f8618k + "], t = [" + c11991a.f8615h + "], h = [" + c11991a.f8612e + "]");
            }
            LoggerBase.m7130i("WCon_WDocData", " >>> WDocInfo - BodyText[" + this.f8522f.f8654L.f8978I.f9296a + "], t = [" + this.f8522f.f8654L.f8980K + "], h = [" + this.f8522f.f8654L.mo13809i() + "]");
        } catch (Exception e) {
            Debugger.m8607d("WCon_WDocData", Log.getStackTraceString(e));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c5  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m13531f(String str) throws SyncException, IOException, SpenUnsupportedTypeException {
        String string;
        String strOptString;
        long j;
        DocumentTempDataEntity entity;
        if (str == null) {
            throw new IllegalArgumentException("readWDoc() - wnotePath is null.");
        }
        if (this.f8531o) {
            throw new IllegalStateException("readWDoc() - WDocData is already initialized.");
        }
        C6748q c6748q = new C6748q(this.f8528l, this.f8532p);
        AbstractC0299q.f770c = c6748q.m4882j();
        if (new File(str).isDirectory()) {
            m13532g(str);
        } else {
            SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(this.f8528l, str, SpenWNoteFile.getOrientation(str) == SpenWNote.Orientation.PORTRAIT ? SpenWNoteFile.getWidth(str) : SpenWNoteFile.getHeight(str), 3000, true, false, false);
            m13532g(spenWNoteOpen.getInternalDirectory());
            DocumentFileManager.getInstance().close(str, spenWNoteOpen, true);
        }
        C11998h c11998h = this.f8522f;
        C12965w c12965w = this.f8527k;
        c11998h.f8646D = c12965w.f9286q;
        int i = c12965w.f9267A;
        if (i >= 3) {
            i = c12965w.f9285p;
        }
        c11998h.f8647E = i;
        this.f8533q = c6748q.m4883k();
        C11998h c11998h2 = this.f8522f;
        Context context = this.f8528l;
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesTagRepository notesTagRepositoryCreateDocumentTagRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        NotesDocumentPageRepository notesDocumentPageRepositoryCreateNotesDocumentPageRepository = NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        NotesMappedDocumentRepository notesMappedDocumentRepositoryCreateMappedDocumentRepository = NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
        if (notesDocumentEntity != null) {
            c11998h2.f8657O = notesDocumentEntity.getIsFavorite() == 1;
            int iM4878f = c6748q.m4878f();
            if (iM4878f == 0) {
                c11998h2.f8658P = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL;
            } else if (iM4878f == 2) {
                c11998h2.f8658P = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED;
            } else {
                LoggerBase.m7126e("WCon_WDocData", "invalid state : note = " + this.f8532p);
            }
            this.f8518b = notesDocumentEntity.getIsLock() == 5;
            String str2 = this.f8532p;
            ArrayList<C0001a> arrayList = new ArrayList();
            List<NotesDocumentPageEntity> favoriteList = notesDocumentPageRepositoryCreateNotesDocumentPageRepository.getFavoriteList(str2);
            if (favoriteList != null) {
                Iterator<NotesDocumentPageEntity> it = favoriteList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C0001a(it.next().getPageUuid()));
                }
            }
            if (arrayList.isEmpty()) {
                string = XMPConst.ARRAY_ITEM_NAME;
            } else {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (C0001a c0001a : arrayList) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("page_uuid", c0001a.f2c);
                        jSONArray.put(jSONObject);
                    }
                    Debugger.m8607d("BookMarkItem", "getBookMarkJsonList() finish : " + jSONArray.length());
                    string = jSONArray.toString();
                } catch (JSONException e) {
                    Debugger.m8609e("BookMarkItem", "getBookMarkJsonList() : Failed to getBookMarkJsonList : " + e.getMessage());
                    throw new SyncException(304, "Failed to getBookMarkJsonList");
                }
            }
            c11998h2.f8659Q = string;
            c11998h2.f8660R = notesMappedDocumentRepositoryCreateMappedDocumentRepository.findOriginalDocumentUuid(this.f8532p);
            c11998h2.f8661S = notesMappedDocumentRepositoryCreateMappedDocumentRepository.getMappedAt(this.f8532p);
            c11998h2.f8662T = notesMappedDocumentRepositoryCreateMappedDocumentRepository.getConverted(this.f8532p);
            c11998h2.f8663U = notesDocumentEntity.getCreatedAt();
            c11998h2.f8664V = notesDocumentEntity.getLastModifiedAt();
            DocumentCoverStateTuple documentCoverStateTupleM4875c = c6748q.m4875c();
            String strM13539a = null;
            if (documentCoverStateTupleM4875c != null) {
                DocumentTempDataRepository documentTempDataRepository = c6748q.f4131d;
                String tempData = (documentTempDataRepository == null || (entity = documentTempDataRepository.getEntity(c6748q.f4132e)) == null) ? null : entity.getTempData();
                if (TextUtils.isEmpty(tempData)) {
                    strOptString = null;
                    if (TextUtils.isEmpty(strOptString)) {
                    }
                } else {
                    try {
                        strOptString = new JSONObject(tempData).optString(DocumentTempDataConstants.KEY_AI_COVER);
                    } catch (JSONException e2) {
                        Debugger.m8609e("DocumentTempDataUtil", "getTempData() :  " + e2.getMessage());
                        strOptString = null;
                    }
                    if (TextUtils.isEmpty(strOptString)) {
                        try {
                            j = new JSONObject(strOptString).getJSONObject("document_cover").getLong("lastModifiedAt");
                        } catch (Exception e3) {
                            AbstractC0000a.m22s("[AiCover] fail to get remoteLastModifiedAt, ", e3, "WCon_WDocData");
                            j = 0;
                        }
                        long lastModifiedAt = c6748q.m4875c().getLastModifiedAt();
                        if (lastModifiedAt > j) {
                            strM13539a = AbstractC11974a.m13539a(documentCoverStateTupleM4875c);
                            if (!TextUtils.isEmpty(strM13539a)) {
                                Debugger.m8615i("WCon_WDocData", "[AiCover] Valid AiCover to the request!, lastModifiedAt = " + documentCoverStateTupleM4875c.getLastModifiedAt());
                            }
                            AbstractC14517a.m15135T(c6748q);
                        } else {
                            StringBuilder sbM1323p = AbstractC1974b.m1323p(lastModifiedAt, "[AiCover] No AiCover to the request!, localLastModifiedAt = ", ", remoteLastModifiedAt = ");
                            sbM1323p.append(j);
                            Debugger.m8615i("WCon_WDocData", sbM1323p.toString());
                        }
                    } else {
                        strM13539a = AbstractC11974a.m13539a(documentCoverStateTupleM4875c);
                        if (!TextUtils.isEmpty(strM13539a)) {
                            Debugger.m8615i("WCon_WDocData", "[AiCover] Valid AiCover to the request, lastModifiedAt = " + documentCoverStateTupleM4875c.getLastModifiedAt());
                        }
                    }
                }
            } else {
                Debugger.m8615i("WCon_WDocData", "[AiCover] No AiCover to the request!");
            }
            c11998h2.f8665W = strM13539a;
            c11998h2.f8682g0 = notesDocumentEntity.getMsSyncAccountId();
            c11998h2.f8684h0 = notesDocumentEntity.getMsSyncDocumentUuid();
            c11998h2.f8686i0 = notesDocumentEntity.getMsLastSyncTime();
            c11998h2.f8688j0 = notesDocumentEntity.getMathMode();
        }
        String str3 = this.f8532p;
        ArrayList<String> arrayList2 = new ArrayList();
        List<NotesTagEntity> tagListByDocUuid = notesTagRepositoryCreateDocumentTagRepository.getTagListByDocUuid(str3);
        if (tagListByDocUuid != null) {
            Iterator<NotesTagEntity> it2 = tagListByDocUuid.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getDisplayName());
            }
        }
        for (String str4 : arrayList2) {
            if (c11998h2.f8680f0 == null) {
                c11998h2.f8680f0 = new ArrayList();
            }
            if (!c11998h2.f8680f0.contains(str4)) {
                c11998h2.f8680f0.add(str4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c A[Catch: all -> 0x0082, TryCatch #1 {all -> 0x0082, blocks: (B:5:0x0048, B:7:0x005a, B:16:0x007c, B:19:0x0086, B:21:0x008d, B:9:0x0061, B:12:0x0070), top: B:128:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[Catch: all -> 0x0082, TRY_LEAVE, TryCatch #1 {all -> 0x0082, blocks: (B:5:0x0048, B:7:0x005a, B:16:0x007c, B:19:0x0086, B:21:0x008d, B:9:0x0061, B:12:0x0070), top: B:128:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m13532g(String str) throws IOException, SpenUnsupportedTypeException {
        boolean z;
        int iM609S;
        int i;
        String str2;
        LoggerBase.m7130i("WCon_WDocData", "readWDocFromDirectory() start : " + LoggerBase.getEncode(str));
        this.f8529m = str;
        if (this.f8531o) {
            throw new IllegalStateException("readWDocFromDirectory() - WDocData is already initialized.");
        }
        LoggerBase.m7130i("WCon_WDocData", "loadMediaInfo - start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0299q.m655z("WCon_WDocData", "loadMediaInfo()", this.f8529m + "/media/mediaInfo.dat"), "r");
        try {
            long filePointer = randomAccessFile.getFilePointer();
            long j = 4;
            if (randomAccessFile.length() <= j) {
                LoggerBase.m7130i("WCon_WDocData", "hasEndTag - EndTag[EOFX] NOT exist");
            } else {
                randomAccessFile.seek(randomAccessFile.length() - j);
                String strM610T = AbstractC0299q.m610T(randomAccessFile, 4);
                if (strM610T != null) {
                    randomAccessFile.seek(filePointer);
                    z = strM610T.compareTo("EOFX") == 0;
                    if (z) {
                        this.f8525i = true;
                        randomAccessFile.skipBytes(4);
                    }
                    iM609S = AbstractC0299q.m609S(randomAccessFile);
                    for (i = 0; i < iM609S; i++) {
                        C11991a c11991a = new C11991a(this.f8530n);
                        c11991a.f8611d = this.f8525i;
                        c11991a.m13584b(randomAccessFile);
                        ((C11979b) this.f8526j.f4483b).m13556b(this.f8529m, c11991a);
                    }
                    randomAccessFile.close();
                    LoggerBase.m7130i("WCon_WDocData", "loadMediaInfo - end");
                    LoggerBase.m7130i("WCon_WDocData", "loadEndTag - start");
                    C12965w c12965w = new C12965w();
                    this.f8527k = c12965w;
                    str2 = this.f8529m;
                    if (str2 != null) {
                        throw new IllegalArgumentException("cachePath is invalid");
                    }
                    File file = new File(str2.concat("/end_tag.bin"));
                    if (!file.exists()) {
                        throw new IOException("WDocEndTag() - cannot access file");
                    }
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        int iM609S2 = AbstractC0299q.m609S(randomAccessFile) - 22;
                        c12965w.f9271b = AbstractC0299q.m606P(randomAccessFile);
                        int i2 = -1;
                        String strM611U = AbstractC0299q.m611U(randomAccessFile, -1);
                        c12965w.f9272c = strM611U;
                        int length = strM611U.length() * 2;
                        c12965w.f9273d = AbstractC0299q.m607Q(randomAccessFile);
                        int iM606P = AbstractC0299q.m606P(randomAccessFile);
                        c12965w.f9274e = iM606P;
                        int i4 = length + 18;
                        if ((iM606P & 2) != 0) {
                            c12965w.f9285p = 1;
                        }
                        String strM611U2 = AbstractC0299q.m611U(randomAccessFile, -1);
                        c12965w.f9275f = strM611U2;
                        int iM1310c = AbstractC1974b.m1310c(strM611U2.length(), 2, 2, i4);
                        c12965w.f9276g = AbstractC0299q.m606P(randomAccessFile);
                        c12965w.f9277h = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
                        String strM611U3 = AbstractC0299q.m611U(randomAccessFile, -1);
                        c12965w.f9278i = strM611U3;
                        int iM1310c2 = AbstractC1974b.m1310c(strM611U3.length(), 2, 2, iM1310c + 8);
                        c12965w.f9279j = AbstractC0299q.m606P(randomAccessFile);
                        c12965w.f9280k = AbstractC0299q.m606P(randomAccessFile);
                        String strM611U4 = AbstractC0299q.m611U(randomAccessFile, -1);
                        c12965w.f9281l = strM611U4;
                        int iM1310c3 = AbstractC1974b.m1310c(strM611U4.length(), 2, 2, iM1310c2 + 8);
                        c12965w.f9282m = AbstractC0299q.m606P(randomAccessFile);
                        c12965w.f9283n = AbstractC0299q.m607Q(randomAccessFile);
                        c12965w.f9284o = AbstractC0299q.m606P(randomAccessFile);
                        c12965w.f9286q = AbstractC0299q.m609S(randomAccessFile);
                        int iM1310c4 = iM1310c3 + 18;
                        if (iM1310c4 < iM609S2) {
                            c12965w.f9287r = AbstractC0299q.m609S(randomAccessFile);
                            iM1310c4 = iM1310c3 + 20;
                        }
                        if (iM1310c4 < iM609S2) {
                            String strM611U5 = AbstractC0299q.m611U(randomAccessFile, -1);
                            c12965w.f9288s = strM611U5;
                            iM1310c4 = AbstractC1974b.m1310c(strM611U5.length(), 2, 2, iM1310c4);
                        }
                        if (iM1310c4 < iM609S2) {
                            int iM606P2 = AbstractC0299q.m606P(randomAccessFile);
                            iM1310c4 += 4;
                            if (iM606P2 > 0) {
                                randomAccessFile.seek(randomAccessFile.getFilePointer() + ((long) iM606P2));
                                iM1310c4 += iM606P2;
                            }
                        }
                        if (iM1310c4 < iM609S2) {
                            int iM606P3 = AbstractC0299q.m606P(randomAccessFile);
                            iM1310c4 += 4;
                            if (iM606P3 > 0) {
                                randomAccessFile.seek(randomAccessFile.getFilePointer() + ((long) iM606P3));
                                iM1310c4 += iM606P3;
                            }
                        }
                        if (iM1310c4 < iM609S2) {
                            c12965w.f9289t = AbstractC0299q.m607Q(randomAccessFile);
                            c12965w.f9290u = AbstractC0299q.m607Q(randomAccessFile);
                            iM1310c4 += 16;
                        }
                        if (iM1310c4 < iM609S2) {
                            c12965w.f9291v = AbstractC0299q.m607Q(randomAccessFile);
                            iM1310c4 += 8;
                        }
                        if (iM1310c4 < iM609S2) {
                            String strM611U6 = AbstractC0299q.m611U(randomAccessFile, -1);
                            c12965w.f9292w = strM611U6;
                            int iM1310c5 = AbstractC1974b.m1310c(strM611U6.length(), 2, 2, iM1310c4);
                            c12965w.f9293x = AbstractC0299q.m606P(randomAccessFile);
                            c12965w.f9294y = AbstractC0299q.m606P(randomAccessFile);
                            iM1310c4 = iM1310c5 + 8;
                        }
                        if (iM1310c4 < iM609S2) {
                            c12965w.f9295z = AbstractC0299q.m607Q(randomAccessFile);
                            iM1310c4 += 8;
                        }
                        if (iM1310c4 < iM609S2) {
                            c12965w.f9267A = AbstractC0299q.m606P(randomAccessFile);
                            iM1310c4 += 4;
                        }
                        if (iM1310c4 < iM609S2) {
                            c12965w.f9268B = AbstractC0299q.m606P(randomAccessFile);
                            iM1310c4 += 4;
                        }
                        if (iM1310c4 < iM609S2) {
                            String strM612V = AbstractC0299q.m612V(randomAccessFile);
                            c12965w.f9269C = strM612V;
                            strM612V.getClass();
                        }
                        randomAccessFile.close();
                        LoggerBase.m7130i("WCon_WDocData", "loadEndTag - end");
                        C12965w c12965w2 = this.f8527k;
                        int i5 = c12965w2.f9271b;
                        if (i5 < 2034) {
                            throw new SpenUnsupportedTypeException(AbstractC2821a.m2223n(new StringBuilder("Unsupported Old Version - ver = ["), "], init ver = [2034]", this.f8527k.f9271b));
                        }
                        if (i5 > 5400 || c12965w2.f9282m > 5400) {
                            LoggerBase.m7126e("WCon_WDocData", "readWDocFromDirectory() : A NEW version(" + this.f8527k.f9271b + SQLKeyword.COMMA + this.f8527k.f9282m + ") of file format is detected. Converter version(5400) MUST be updated!!");
                            StringBuilder sb = new StringBuilder("Unsupported new version(");
                            sb.append(this.f8527k.f9271b);
                            sb.append(SQLKeyword.COMMA);
                            throw new SpenUnsupportedTypeException(AbstractC2821a.m2223n(sb, "), ver(5400)", this.f8527k.f9282m));
                        }
                        C11998h c11998h = new C11998h(this.f8529m, this.f8526j);
                        this.f8522f = c11998h;
                        Log.i("WCon_WNote", "readWDoc()");
                        File file2 = new File(AbstractC0622a.m1170p(c11998h.f8669a, "/note.note", new StringBuilder()));
                        if (!file2.exists()) {
                            throw new IOException("readWDoc() - cannot access note.note data file");
                        }
                        randomAccessFile = new RandomAccessFile(file2, "r");
                        try {
                            c11998h.m13598b(randomAccessFile);
                            randomAccessFile.close();
                            C11998h c11998h2 = this.f8522f;
                            C12965w c12965w3 = this.f8527k;
                            c11998h2.f8646D = c12965w3.f9286q;
                            int i6 = c12965w3.f9267A;
                            if (i6 >= 3) {
                                i6 = c12965w3.f9285p;
                            }
                            c11998h2.f8647E = i6;
                            c11998h2.f8648F = c12965w3.f9287r;
                            c11998h2.f8649G = c12965w3.f9288s;
                            c11998h2.f8666X = c12965w3.f9291v;
                            c11998h2.f8668Z = c12965w3.f9292w;
                            c11998h2.f8670a0 = c12965w3.f9293x;
                            c11998h2.f8672b0 = c12965w3.f9294y;
                            c11998h2.f8667Y = c12965w3.f9295z;
                            c11998h2.f8678e0 = c12965w3.f9269C;
                            File fileM655z = AbstractC0299q.m655z("WCon_WDocData", "loadPageIdInfo()", this.f8529m + "/pageIdInfo.dat");
                            this.f8523g = new ArrayList();
                            randomAccessFile = new RandomAccessFile(fileM655z, "r");
                            try {
                                randomAccessFile.seek(32L);
                                int iM609S3 = AbstractC0299q.m609S(randomAccessFile);
                                for (int i7 = 0; i7 < iM609S3; i7++) {
                                    String strM611U7 = AbstractC0299q.m611U(randomAccessFile, 1024);
                                    if (strM611U7 != null) {
                                        this.f8523g.add(strM611U7);
                                    }
                                    randomAccessFile.seek(randomAccessFile.getFilePointer() + 32);
                                }
                                randomAccessFile.close();
                                this.f8524h = new ArrayList();
                                int size = this.f8523g.size();
                                StringBuilder sb2 = new StringBuilder("readWDoc - page count = [");
                                sb2.append(size);
                                String str3 = "]";
                                sb2.append("]");
                                LoggerBase.m7130i("WCon_WDocData", sb2.toString());
                                int i8 = 0;
                                while (i8 < size) {
                                    LoggerBase.m7130i("WCon_WDocData", "readWDoc - read page [" + i8 + str3);
                                    String str4 = this.f8529m;
                                    String str5 = (String) this.f8523g.get(i8);
                                    C6906i c6906i = this.f8526j;
                                    C12011u c12011u = new C12011u();
                                    c12011u.f8751l = new RectF();
                                    c12011u.f8752m = new ArrayList();
                                    c12011u.f8753n = i2;
                                    c12011u.f8758s = new ArrayList();
                                    c12011u.f8761v = new ArrayList();
                                    c12011u.f8765z = i2;
                                    c12011u.f8733A = 4000;
                                    c12011u.f8734B = 4000;
                                    c12011u.f8735C = 0;
                                    c12011u.f8736D = new LinkedHashMap();
                                    c12011u.f8737E = 0;
                                    String str6 = str3;
                                    c12011u.f8738F = 0L;
                                    new ArrayList();
                                    c12011u.f8739G = new ArrayList();
                                    c12011u.f8740a = str4;
                                    c12011u.f8744e = str5;
                                    c12011u.f8756q = c6906i;
                                    StringBuilder sbM1324q = AbstractC1974b.m1324q(str4);
                                    sbM1324q.append(File.separator);
                                    sbM1324q.append(c12011u.f8744e);
                                    sbM1324q.append(".page");
                                    randomAccessFile = new RandomAccessFile(AbstractC0299q.m655z("WCon_Page", "readWDoc()", sbM1324q.toString()), "r");
                                    try {
                                        c12011u.m13612f(randomAccessFile);
                                        byte[] bArr = new byte[32];
                                        randomAccessFile.read(bArr);
                                        c12011u.f8757r = bArr;
                                        Log.d("WCon_Page", "readWDoc - page Hash = [" + C14433b.m15034q(c12011u.f8757r) + str6);
                                        randomAccessFile.close();
                                        this.f8524h.add(c12011u);
                                        i8++;
                                        str3 = str6;
                                        i2 = -1;
                                    } finally {
                                        try {
                                            throw th;
                                        } catch (Throwable th) {
                                            th.addSuppressed(th);
                                        }
                                    }
                                }
                                C11998h c11998h3 = this.f8522f;
                                this.f8517a = c11998h3.f8702v;
                                this.f8520d = c11998h3.f8656N;
                                this.f8519c = c11998h3.f8649G;
                                this.f8531o = true;
                                LoggerBase.m7130i("WCon_WDocData", "readWDocFromDirectory() end : " + LoggerBase.getEncode(str));
                                return;
                            } finally {
                            }
                        } finally {
                            randomAccessFile.close();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (z) {
            }
            iM609S = AbstractC0299q.m609S(randomAccessFile);
            while (i < iM609S) {
            }
            randomAccessFile.close();
            LoggerBase.m7130i("WCon_WDocData", "loadMediaInfo - end");
            LoggerBase.m7130i("WCon_WDocData", "loadEndTag - start");
            C12965w c12965w4 = new C12965w();
            this.f8527k = c12965w4;
            str2 = this.f8529m;
            if (str2 != null) {
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m13533h(C12005o c12005o) throws SyncException {
        HashMap mapM13606b = c12005o.m13606b();
        if (!mapM13606b.containsKey(this.f8522f.f8654L.f8978I.f9296a)) {
            this.f8522f.f8654L = null;
            if (!c12005o.f8715d.isEmpty()) {
                throw new SyncException(327, "removeUnchangedData - bodyText is not changed, but request floating object");
            }
        }
        ArrayList arrayList = new ArrayList();
        for (AbstractC12916b abstractC12916b : this.f8522f.f8692l0) {
            if (mapM13606b.containsKey(abstractC12916b.mo13811k())) {
                arrayList.add(abstractC12916b);
            }
        }
        this.f8522f.f8692l0 = arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (C12011u c12011u : this.f8524h) {
            if (mapM13606b.containsKey(c12011u.f8744e)) {
                ArrayList arrayList3 = new ArrayList();
                for (C11992b c11992b : c12011u.f8761v) {
                    if (mapM13606b.containsKey(c11992b.f8628g)) {
                        ArrayList arrayList4 = new ArrayList();
                        for (AbstractC12916b abstractC12916b2 : c11992b.f8631j) {
                            if (mapM13606b.containsKey(abstractC12916b2.mo13811k())) {
                                arrayList4.add(abstractC12916b2);
                            }
                        }
                        c11992b.f8631j = arrayList4;
                        arrayList3.add(c11992b);
                    }
                }
                c12011u.f8761v = arrayList3;
                arrayList2.add(c12011u);
            }
        }
        this.f8524h = arrayList2;
        ArrayList arrayList5 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList5.add(((C12011u) it.next()).f8744e);
        }
        this.f8523g = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        for (C11991a c11991a : ((C11979b) this.f8526j.f4483b).f8577e) {
            if (!mapM13606b.containsKey(c11991a.f8618k)) {
                arrayList6.add(c11991a);
            }
        }
        Iterator it2 = arrayList6.iterator();
        while (it2.hasNext()) {
            ((C11979b) this.f8526j.f4483b).f8577e.remove((C11991a) it2.next());
        }
        HashMap map = new HashMap();
        for (C12930p c12930p : ((C11980c) this.f8526j.f4484c).f8581c.values()) {
            if (mapM13606b.containsKey(c12930p.f8978I.f9296a)) {
                map.put(c12930p.f8978I.f9296a, c12930p);
            }
        }
        ((C11980c) this.f8526j.f4484c).f8581c = map;
        HashMap map2 = new HashMap();
        for (C12923i c12923i : ((C11980c) this.f8526j.f4484c).f8583e.values()) {
            if (mapM13606b.containsKey(c12923i.f8978I.f9296a)) {
                map2.put(c12923i.f8978I.f9296a, c12923i);
            }
        }
        ((C11980c) this.f8526j.f4484c).f8583e = map2;
        HashMap map3 = new HashMap();
        for (C12931q c12931q : ((C11980c) this.f8526j.f4484c).f8582d.values()) {
            if (mapM13606b.containsKey(c12931q.mo13811k())) {
                map3.put(c12931q.mo13811k(), c12931q);
            }
        }
        ((C11980c) this.f8526j.f4484c).f8582d = map3;
        HashMap map4 = new HashMap();
        for (C12932r c12932r : ((C11980c) this.f8526j.f4484c).f8584f.values()) {
            if (mapM13606b.containsKey(c12932r.f8978I.f9296a)) {
                map4.put(c12932r.f8978I.f9296a, c12932r);
            }
        }
        ((C11980c) this.f8526j.f4484c).f8584f = map4;
        HashMap map5 = new HashMap();
        for (C12917c c12917c : ((C11980c) this.f8526j.f4484c).f8585g.values()) {
            if (mapM13606b.containsKey(c12917c.f8978I.f9296a)) {
                map5.put(c12917c.f8978I.f9296a, c12917c);
            }
        }
        ((C11980c) this.f8526j.f4484c).f8585g = map5;
    }

    /* JADX INFO: renamed from: i */
    public final String m13534i(C0097a c0097a) throws SyncException {
        AbstractC0299q.f768a = c0097a;
        try {
            C6742k c6742k = new C6742k(Xml.newSerializer());
            try {
                c6742k.m4846F("NoteResource");
                c6742k.m4851h("id", this.f8532p);
                c6742k.m4850f("syncModifiedTime", this.f8533q);
                c6742k.m4850f(GroupContract.Group.CREATED_TIME, this.f8517a);
                c6742k.m4852i("isLocked", this.f8518b);
                c6742k.m4852i("isEncrypted", this.f8520d);
                c6742k.m4851h(GroupContract.Group.LEADER_ID, this.f8519c);
                c6742k.m4848d(2, "xmlVer");
                c6742k.m4864v("noteTree", this.f8521e);
                c6742k.m4868z("contentFileList", CoeditServiceConstants.Element.NAME_CONTENT_FILE, ((C11979b) this.f8526j.f4483b).f8577e);
                c6742k.m4864v(NativeAuthConstants.GrantType.ATTRIBUTES, this.f8522f);
                c6742k.m4868z("pageList", "page", this.f8524h);
                C11998h c11998h = this.f8522f;
                if (!c11998h.f8692l0.isEmpty()) {
                    c6742k.m4868z("floatingObjectList", CoeditServiceConstants.Element.NAME_OBJECT, c11998h.f8692l0);
                }
                if (this.f8522f.f8654L != null) {
                    c6742k.m4846F(ExternalDataConstants.Column.BODY_TEXT);
                    c6742k.m4851h("id", this.f8522f.f8654L.f8978I.f9296a);
                    c6742k.m4864v(CoeditServiceConstants.Element.NAME_OBJECT, this.f8522f.f8654L);
                    c6742k.m4856m(ExternalDataConstants.Column.BODY_TEXT);
                }
                c6742k.m4856m("NoteResource");
                c6742k.m4857n();
                return ((StringWriter) c6742k.f4111c).toString();
            } catch (Exception e) {
                Debugger.m8611e("WCon_WDocData", e);
                throw new SyncException(326, e);
            }
        } catch (IOException unused) {
            throw new SyncException(326, "Fail to init XMLObject");
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11971a)) {
            return false;
        }
        C11971a c11971a = (C11971a) obj;
        if (this.f8517a != c11971a.f8517a) {
            LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mCretedTime[" + this.f8517a + " - " + c11971a.f8517a + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f8521e, c11971a.f8521e)) {
            LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mNoteTree");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f8522f, c11971a.f8522f)) {
            LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mNote");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f8523g, c11971a.f8523g)) {
            LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mPageIdList");
            return false;
        }
        for (int i = 0; i < this.f8524h.size(); i++) {
            LoggerBase.m7130i("WCon_WDocData", " !! equals() - page index = [" + i + "] check");
            if (!AbstractC0299q.m635j(this.f8524h.get(i), c11971a.f8524h.get(i))) {
                LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mPageList - page index = [" + i + "]");
                return false;
            }
        }
        if (!AbstractC0299q.m635j((C11979b) this.f8526j.f4483b, (C11979b) c11971a.f8526j.f4483b)) {
            LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mContentFileManager");
            return false;
        }
        if (AbstractC0299q.m635j(this.f8527k, c11971a.f8527k)) {
            return true;
        }
        LoggerBase.m7130i("WCon_WDocData", " !! equals() - NE - mEndTag");
        return false;
    }

    /* JADX INFO: renamed from: j */
    public final void m13535j() throws SyncException {
        Iterator it;
        Iterator it2;
        Iterator it3 = this.f8524h.iterator();
        while (it3.hasNext()) {
            Iterator it4 = ((C12011u) it3.next()).f8761v.iterator();
            while (it4.hasNext()) {
                C11992b c11992b = (C11992b) it4.next();
                Debugger.printMemory("WCon_Page", "[CurrentMemoryState] Ungrouping the stroke groups in a layer");
                c11992b.getClass();
                ArrayList arrayList = new ArrayList();
                for (AbstractC12916b abstractC12916b : c11992b.f8631j) {
                    if (abstractC12916b.f8990a == 100) {
                        C12931q c12931q = (C12931q) abstractC12916b;
                        ArrayList arrayList2 = c12931q.f9105V;
                        byte[] bArr = c12931q.f9106W;
                        if (bArr == null || bArr.length == 0) {
                            throw new SyncException(328, "ungroupForDownSync - stroke group data is empty");
                        }
                        arrayList2.clear();
                        C12020a c12020a = new C12020a(c12931q.f9106W);
                        int i = 0;
                        int iM13637j = c12020a.m13637j(0);
                        if (iM13637j == 0) {
                            Log.e("WDocObjectStrokeGroup", "ungroupForDownSync - no object");
                            it = it3;
                            it2 = it4;
                        } else {
                            int i2 = 2;
                            int i4 = 2;
                            while (i < iM13637j) {
                                C12930p c12930p = new C12930p(c12931q.f8988S);
                                int iM13637j2 = c12020a.m13637j(i4);
                                int i5 = i4 + i2;
                                String strM13645r = c12020a.m13645r(i5, iM13637j2);
                                int i6 = (iM13637j2 * i2) + i5;
                                long j = ((ByteBuffer) c12020a.f8772b).getLong(i6);
                                Iterator it5 = it3;
                                Iterator it6 = it4;
                                int i7 = ((ByteBuffer) c12020a.f8772b).getInt(i6 + 8);
                                int i8 = i6 + 12;
                                byte[] bArr2 = new byte[i7];
                                c12020a.m13639l(i8, bArr2);
                                c12930p.f8978I.f9296a = strM13645r;
                                c12930p.f8980K = j;
                                c12930p.m13820t();
                                c12930p.m13831u(bArr2);
                                arrayList2.add(c12930p);
                                i++;
                                i4 = i7 + i8;
                                it3 = it5;
                                it4 = it6;
                                i2 = 2;
                            }
                            it = it3;
                            it2 = it4;
                            c12931q.f9106W = null;
                        }
                        arrayList.addAll(arrayList2);
                    } else {
                        it = it3;
                        it2 = it4;
                        arrayList.add(abstractC12916b);
                    }
                    it3 = it;
                    it4 = it2;
                }
                c11992b.f8631j.clear();
                c11992b.f8631j.addAll(arrayList);
                it3 = it3;
            }
        }
        ((C11980c) this.f8526j.f4484c).f8582d.clear();
    }

    /* JADX INFO: renamed from: k */
    public final void m13536k(C11971a c11971a) throws SyncException {
        C6903f c6903f = new C6903f(11, false);
        c6903f.f4476d = C6903f.m5118b(this);
        c6903f.f4474b = C6903f.m5118b(c11971a);
        c6903f.f4475c = c11971a.f8521e.m13606b();
        this.f8517a = c11971a.f8517a;
        this.f8518b = c11971a.f8518b;
        this.f8520d = c11971a.f8520d;
        this.f8519c = c11971a.f8519c;
        this.f8533q = c11971a.f8533q;
        this.f8534r = c11971a.f8534r;
        this.f8535s = c11971a.f8535s;
        this.f8521e = c11971a.f8521e;
        C11998h c11998h = this.f8522f;
        C11998h c11998h2 = c11971a.f8522f;
        c11998h.getClass();
        if (c11998h != c11998h2 && c11998h2 != null) {
            LoggerBase.m7128f("WCon_WNote", "update() - note : [" + c11998h.f8704x + SQLKeyword.COMMA + c11998h.f8650H + "] => [" + c11998h2.f8704x + SQLKeyword.COMMA + c11998h2.f8650H + "]");
            c11998h.f8673c = c11998h2.f8673c;
            c11998h.f8675d = c11998h2.f8675d;
            c11998h.f8702v = c11998h2.f8702v;
            c11998h.f8703w = c11998h2.f8703w;
            c11998h.f8704x = c11998h2.f8704x;
            c11998h.f8705y = c11998h2.f8705y;
            c11998h.f8693m = c11998h2.f8693m;
            c11998h.f8648F = c11998h2.f8648F;
            c11998h.f8649G = c11998h2.f8649G;
            c11998h.f8706z = c11998h2.f8706z;
            c11998h.f8643A = c11998h2.f8643A;
            c11998h.f8644B = c11998h2.f8644B;
            c11998h.f8645C = c11998h2.f8645C;
            c11998h.f8647E = c11998h2.f8647E;
            c11998h.f8650H = c11998h2.f8650H;
            c11998h.f8651I = c11998h2.f8651I;
            c11998h.f8652J = c11998h2.f8652J;
            c11998h.f8697q = c11998h2.f8697q;
            c11998h.f8698r = c11998h2.f8698r;
            c11998h.f8699s = c11998h2.f8699s;
            c11998h.f8700t = c11998h2.f8700t;
            c11998h.f8656N = c11998h2.f8656N;
            c11998h.f8655M = c11998h2.f8655M;
            if (c11998h2.f8654L != null) {
                LoggerBase.m7128f("WCon_WNote", "update() - body : [" + c11998h.f8654L.f8980K + "] => [" + c11998h2.f8654L.f8980K + "]");
                c11998h.f8654L = c11998h2.f8654L;
            }
            C12920f c12920f = c11998h2.f8653K;
            if (c12920f != null) {
                c11998h.f8653K = c12920f;
            }
            c11998h.f8694n = c11998h2.f8694n;
            c11998h.f8695o = c11998h2.f8695o;
            c11998h.f8696p = c11998h2.f8696p;
            c11998h.f8666X = c11998h2.f8666X;
            c11998h.f8668Z = c11998h2.f8668Z;
            c11998h.f8670a0 = c11998h2.f8670a0;
            c11998h.f8672b0 = c11998h2.f8672b0;
            c11998h.f8674c0 = c11998h2.f8674c0;
            c11998h.f8676d0 = c11998h2.f8676d0;
            c11998h.f8678e0 = c11998h2.f8678e0;
            c11998h.f8657O = c11998h2.f8657O;
            c11998h.f8658P = c11998h2.f8658P;
            c11998h.f8659Q = c11998h2.f8659Q;
            c11998h.f8660R = c11998h2.f8660R;
            c11998h.f8661S = c11998h2.f8661S;
            c11998h.f8662T = c11998h2.f8662T;
            c11998h.f8680f0 = c11998h2.f8680f0;
            c11998h.f8663U = c11998h2.f8663U;
            c11998h.f8664V = c11998h2.f8664V;
            c11998h.f8665W = c11998h2.f8665W;
            c11998h.f8688j0 = c11998h2.f8688j0;
            c11998h.f8684h0 = c11998h2.f8684h0;
            c11998h.f8682g0 = c11998h2.f8682g0;
            c11998h.f8686i0 = c11998h2.f8686i0;
        }
        this.f8522f.f8692l0 = c6903f.m5127k(c11971a.f8521e.f8715d);
        ArrayList arrayListM5127k = c6903f.m5127k(c11971a.f8521e.f8713b);
        LoggerBase.m7128f("WCon_WDocData", "update() - page : [" + this.f8524h.size() + "] => [" + arrayListM5127k.size() + "]");
        this.f8524h = arrayListM5127k;
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListM5127k.iterator();
        while (it.hasNext()) {
            arrayList.add(((C12011u) it.next()).f8744e);
        }
        this.f8523g = arrayList;
        HashSet hashSet = new HashSet();
        Iterator it2 = c11971a.f8521e.f8714c.iterator();
        while (it2.hasNext()) {
            hashSet.add(((C12001k) it2.next()).f8707a);
        }
        try {
            ArrayList<C11991a> arrayList2 = ((C11979b) this.f8526j.f4483b).f8577e;
            ArrayList arrayList3 = new ArrayList();
            LoggerBase.m7128f("WCon_WDocData", "update() - contentFile : [" + arrayList2.size() + "] => [" + hashSet.size() + "]");
            for (C11991a c11991a : arrayList2) {
                if (!hashSet.contains(c11991a.f8618k)) {
                    arrayList3.add(c11991a);
                }
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ((C11979b) this.f8526j.f4483b).m13560f((C11991a) it3.next());
            }
            ((C11979b) this.f8526j.f4483b).m13557c();
            this.f8527k = c11971a.f8527k;
        } catch (IOException e) {
            throw new SyncException(312, "failed to update contentFileManager" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m13537l(String str) throws SyncException, IOException {
        File file;
        LoggerBase.m7130i("WCon_WDocData", "writeWDoc - outCachePath = [" + LoggerBase.getEncode(str) + "]");
        if (str == null) {
            throw new IllegalArgumentException("writeWDoc() - wdocCachePath is null.");
        }
        if (!this.f8531o) {
            throw new IllegalStateException("writeWDoc() - WDocData is not initialized.");
        }
        String str2 = this.f8530n;
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalStateException("writeWDoc() - WDocData cache path is invalid.");
        }
        try {
            m13538m(this.f8530n);
            Logger.m8702i("WCon_WDocData", "writeWDocDirectory - outPath = [" + LoggerBase.getEncode(str) + "]");
            File file2 = new File(str);
            if (file2.exists()) {
                file = new File(str.concat(".bak"));
                if (file.exists()) {
                    FileUtils.deleteFile(file);
                }
                if (!file2.renameTo(file)) {
                    throw new IOException("writeWDocDirectory() - Cannot create backup file");
                }
            } else {
                file = null;
            }
            if (!new File(this.f8530n).renameTo(file2)) {
                if (file != null) {
                    file.renameTo(file2);
                }
                throw new IOException("writeWDocDirectory() - Fail to rename to output file.");
            }
            if (file != null) {
                FileUtils.deleteFile(file);
            }
        } catch (SyncException e) {
            throw new SyncException(e.getExceptionCode(), "note[" + this.f8532p + "], " + e.getMessage());
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX INFO: renamed from: m */
    public final void m13538m(String str) throws IOException {
        LoggerBase.m7130i("WCon_WDocData", "writeWDocCache - outCachePath = [" + LoggerBase.getEncode(str) + "]");
        C11998h c11998h = this.f8522f;
        if (str != null) {
            c11998h.getClass();
            c11998h.f8671b = str.concat("/note.note");
        } else {
            c11998h.f8671b = AbstractC0622a.m1170p(c11998h.f8669a, "/note.note", new StringBuilder());
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0299q.m591A("writeWDoc1()", c11998h.f8671b), InternalZipConstants.WRITE_MODE);
        try {
            c11998h.m13600f(randomAccessFile);
            randomAccessFile.close();
            AbstractC0299q.m644o("WCon_WNote", c11998h.f8671b);
            int i = 0;
            int i2 = 0;
            for (C12011u c12011u : this.f8524h) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "writeWDocCache >>> >>>> >>> page index = [", "], id = [");
                sbM778t.append(c12011u.f8744e);
                sbM778t.append("]");
                LoggerBase.m7130i("WCon_WDocData", sbM778t.toString());
                if (str != null) {
                    StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                    sbM1324q.append(File.separator);
                    c12011u.f8741b = AbstractC0622a.m1170p(c12011u.f8744e, ".page", sbM1324q);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c12011u.f8740a);
                    sb.append(File.separator);
                    c12011u.f8741b = AbstractC0622a.m1170p(c12011u.f8744e, ".page", sb);
                }
                randomAccessFile = new RandomAccessFile(AbstractC0299q.m591A("writeWDoc()", c12011u.f8741b), InternalZipConstants.WRITE_MODE);
                try {
                    c12011u.m13614h(randomAccessFile);
                    randomAccessFile.close();
                    i2++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            String strM756B = AbstractC0541b.m756B(str, "/pageIdInfo.dat");
            LoggerBase.m7130i("WCon_WDocData", "writePageIdInfo() - filePath[" + LoggerBase.getEncode(strM756B) + "]");
            randomAccessFile = new RandomAccessFile(AbstractC0299q.m591A("writePageIdInfo()", strM756B), InternalZipConstants.WRITE_MODE);
            try {
                byte[] bArr = this.f8522f.f8701u;
                if (bArr != null) {
                    randomAccessFile.write(bArr);
                } else {
                    randomAccessFile.seek(32L);
                }
                int size = this.f8523g.size();
                AbstractC0299q.m636j0(randomAccessFile, size);
                for (int i4 = 0; i4 < size; i4++) {
                    AbstractC0299q.m640l0(randomAccessFile, (String) this.f8523g.get(i4));
                    byte[] bArr2 = ((C12011u) this.f8524h.get(i4)).f8757r;
                    if (bArr2 != null) {
                        randomAccessFile.write(bArr2);
                    } else {
                        randomAccessFile.seek(randomAccessFile.getFilePointer() + 32);
                    }
                }
                randomAccessFile.close();
                AbstractC0299q.m644o("WCon_WDocData", strM756B);
                String str2 = str + "/media/mediaInfo.dat";
                LoggerBase.m7130i("WCon_WDocData", "writeMediaInfo() - filePath[" + LoggerBase.getEncode(str2) + "]");
                if (this.f8522f.f8650H > 3001) {
                    this.f8525i = true;
                }
                randomAccessFile = new RandomAccessFile(AbstractC0299q.m591A("writeMediaInfo()", str2), InternalZipConstants.WRITE_MODE);
                try {
                    if (this.f8525i) {
                        AbstractC0299q.m632h0(randomAccessFile, this.f8522f.f8650H);
                    }
                    AbstractC0299q.m636j0(randomAccessFile, ((C11979b) this.f8526j.f4483b).f8577e.size());
                    for (C11991a c11991a : ((C11979b) this.f8526j.f4483b).f8577e) {
                        LoggerBase.m7130i("WCon_WDocData", "writeMediaInfo() - No.[" + i + "]");
                        c11991a.f8611d = this.f8525i;
                        c11991a.m13585c(randomAccessFile);
                        i++;
                    }
                    AbstractC0299q.m638k0(randomAccessFile, this.f8525i ? "EOFX" : ComponentUtil.END_FILE_TAG_DATA);
                    randomAccessFile.close();
                    this.f8527k.m13868a(this.f8522f);
                    C12965w c12965w = this.f8527k;
                    c12965w.getClass();
                    Logger.m8697d("WCon_WDocEndTag", "writeWDoc1() : Write data to end_tag.bin");
                    if (str == null) {
                        throw new IOException("outCachePath is null");
                    }
                    String strConcat = str.concat("/end_tag.bin");
                    c12965w.f9270a = strConcat;
                    randomAccessFile = new RandomAccessFile(AbstractC0299q.m591A("writeWDoc()", strConcat), InternalZipConstants.WRITE_MODE);
                    try {
                        c12965w.m13869b(randomAccessFile);
                        randomAccessFile.close();
                        AbstractC0299q.m644o("WCon_WDocEndTag", c12965w.f9270a);
                        Logger.m8697d("WCon_WDocEndTag", "writeWDoc1() : end");
                        LoggerBase.m7130i("WCon_WDocData", "writeWDocCache - end");
                    } finally {
                        randomAccessFile.close();
                    }
                } finally {
                    try {
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        } finally {
            try {
            } catch (Throwable th4) {
                th.addSuppressed(th4);
            }
        }
    }
}
