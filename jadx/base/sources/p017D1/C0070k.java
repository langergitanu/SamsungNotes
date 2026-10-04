package p017D1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.synchronization.managers.C6901d;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import org.json.JSONException;
import org.json.JSONObject;
import p008B1.C0029b;
import p020E.C0073a;
import p022E1.C0075a;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.AbstractC0100d;
import p026F1.C0097a;
import p034H1.C0113a;
import p034H1.C0115c;
import p042J1.AbstractC0153k;
import p042J1.C0145c;
import p042J1.C0152j;
import p173d0.C11971a;
import p195k1.C12969a;
import p234q1.C14433b;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: D1.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0070k extends AbstractC0067h {

    /* JADX INFO: renamed from: h */
    public long f248h;

    /* JADX INFO: renamed from: i */
    public long f249i;

    public C0070k(C0077c c0077c, C0082h c0082h, InterfaceC14510a interfaceC14510a, C0097a c0097a, String str, C0075a c0075a) {
        super(c0077c, c0082h, interfaceC14510a, c0097a, str, c0075a);
        this.f248h = 0L;
        this.f249i = 0L;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m160e(boolean z, C0113a c0113a, C6748q c6748q) {
        if (z || ((c6748q.m4884l() && c6748q.m4874b() == 1) || (c6748q.m4884l() && c6748q.m4874b() == 2))) {
            return true;
        }
        if (this.f248h < this.f249i) {
            return c6748q.m4879g() == 0 || c6748q.m4878f() == 1;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0387 A[Catch: all -> 0x0135, TRY_LEAVE, TryCatch #3 {all -> 0x0135, blocks: (B:16:0x00a3, B:18:0x00b0, B:20:0x00b8, B:25:0x00d7, B:27:0x00dd, B:29:0x0109, B:33:0x011d, B:35:0x0129, B:37:0x012f, B:44:0x013f, B:46:0x0145, B:51:0x0152, B:53:0x0157, B:57:0x016f, B:56:0x015c, B:58:0x0174, B:60:0x017e, B:62:0x0184, B:66:0x01a2, B:69:0x01ac, B:79:0x021a, B:81:0x021f, B:83:0x0222, B:85:0x0231, B:87:0x026e, B:89:0x0275, B:91:0x0279, B:93:0x0280, B:95:0x028e, B:97:0x0294, B:99:0x029b, B:130:0x037f, B:132:0x0387, B:133:0x03b2, B:136:0x03bf, B:135:0x03b8, B:137:0x03cd, B:139:0x03d8, B:141:0x03e0, B:142:0x03f1, B:109:0x02bd, B:111:0x02d6, B:112:0x02f7, B:115:0x030f, B:117:0x0325, B:120:0x0334, B:122:0x033f, B:123:0x0347, B:119:0x032f, B:70:0x01c2, B:72:0x01d7, B:74:0x01e2, B:76:0x01eb, B:77:0x01ff, B:78:0x0206, B:30:0x010d, B:31:0x0116, B:23:0x00cf, B:143:0x03f2, B:144:0x03fb), top: B:152:0x00a3, inners: #2, #4 }] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [F1.a] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m161f(String str, String str2, C6748q c6748q, boolean z) {
        String str3;
        String str4;
        String str5;
        String str6;
        C0113a c0113a;
        String str7;
        C0073a c0073a;
        String str8;
        C0097a c0097a;
        C11971a c11971aM162g;
        C6903f c6903f;
        C11971a c11971a;
        String str9;
        String str10;
        C11971a c11971a2;
        StringBuilder sb = new StringBuilder("perform() : ");
        String str11 = this.f241e;
        sb.append(str11);
        sb.append(" of ");
        sb.append(Logger.getEncode(str2));
        sb.append(", isRecovery = ");
        sb.append(z);
        Debugger.m8615i("SyncNote/SyncSDocxUpdateLocalNote", sb.toString());
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxUpdateLocalNote";
        c0152jM378g.f455d = str11;
        C0077c c0077c = this.f237a;
        c0152jM378g.m371b(c0077c.f262e);
        if (UUIDUtils.isDynamicTemplateUuid(str11) && !UUIDUtils.isDynamicTemplateUuidCompatible(str11)) {
            throw new SyncException(12001, "High formated note");
        }
        C0075a c0075a = this.f246g;
        if (c0075a.m211c(str11)) {
            throw new SyncException(CoeditBaseConstants.COEDIT_IMPORT_MAX_STROKE_OBJECT, "Composer is busy!");
        }
        if (c0075a.m210b(c6748q.m4874b(), str11)) {
            Debugger.m8615i("SyncNote/SyncSDocxUpdateLocalNote", "handleLatestServerNote() : local " + str11 + " is being updated and so ignore the server update!");
            return;
        }
        C12969a c12969a = new C12969a(c0077c.f262e, str11);
        C0073a c0073a2 = new C0073a(this, 3);
        try {
            try {
                try {
                    AbstractC0100d.f327a = true;
                    c0113a = new C0113a(str11);
                    if (m160e(z, c0113a, c6748q)) {
                        str7 = " of ";
                        c0073a = c0073a2;
                        str8 = "[CurrentMemoryState] After saving a note";
                    } else {
                        if (C0115c.m276b(c6748q)) {
                            str7 = " of ";
                            c0073a = c0073a2;
                            if (!(TextUtils.isEmpty(C0145c.m331p("SyncControlLowVersionNote", str11, "")) ? true : !r5.equals(C0145c.m322g()))) {
                                throw new SyncException(338, "Low Version");
                            }
                            if (C0115c.m276b(c6748q)) {
                                Context applicationContext = BaseUtils.getApplicationContext();
                                NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                                SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                                NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                str8 = "[CurrentMemoryState] After saving a note";
                                syncNoteDataRepositoryCreateSyncNoteDataRepository.removeNoteSyncStateFlag(str11, 32768L);
                            } else {
                                str8 = "[CurrentMemoryState] After saving a note";
                            }
                            C0145c.m302J("SyncControlLowVersionNote", str11);
                        } else {
                            str7 = " of ";
                            c0073a = c0073a2;
                            str8 = "[CurrentMemoryState] After saving a note";
                        }
                        if ((c6748q.m4880h() & 512) == 512) {
                            if (c6748q.m4884l()) {
                                if (c6748q.m4884l() && c6748q.m4874b() == 3) {
                                    c0113a.m270a(c6748q);
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e) {
                                        Debugger.m8609e("SyncNote/SyncSDocxUpdateLocalNote", "Exception = " + e.toString());
                                    }
                                    c0113a.m271b(str2, "a max object note was not uploaded and conflicted again!");
                                }
                            } else {
                                c0113a.m271b(str2, "conflict a max object note!");
                            }
                        }
                        if (!TextUtils.isEmpty(c6748q.m4873a()) && !c0113a.m272c(c6748q, str2)) {
                            Debugger.m8615i("SyncNote/SyncSDocxUpdateLocalNote", str11 + " is conflicted and not downloaded!");
                            AbstractC0068i.m158a();
                            return;
                        }
                    }
                    int iM4878f = c6748q.m4878f();
                    c0097a = this.f240d;
                    if (iM4878f == 1) {
                        Debugger.m8615i("SyncNote/SyncSDocxUpdateLocalNote", str11 + " is deleted");
                        c11971aM162g = null;
                    } else {
                        Debugger.printMemory("SyncNote/SyncSDocxUpdateLocalNote", "[CurrentMemoryState] Before loading a note to SPEN SDK");
                        AbstractC0153k.m377f("SyncNote/SyncSDocxUpdateLocalNote", "Before loading a note to SPEN SDK");
                        c11971aM162g = m162g(str11);
                        Debugger.printMemory("SyncNote/SyncSDocxUpdateLocalNote", "[CurrentMemoryState] After loading a note to SPEN SDK");
                        if (c11971aM162g != null) {
                            if (c11971aM162g.f8522f.f8676d0 != 0) {
                                c0097a.f320c = true;
                                if (c6748q.m4882j() == 0) {
                                    Debugger.m8609e("SyncNote/SyncSDocxUpdateLocalNote", str11 + " was not grouped in DB");
                                }
                            }
                            c12969a.f9309c = c11971aM162g.m13528b();
                        } else {
                            Debugger.m8609e("SyncNote/SyncSDocxUpdateLocalNote", "wDocData of " + str11 + " is null!");
                        }
                    }
                    c6903f = c0077c.f265h;
                    str3 = str11;
                } catch (SyncException e2) {
                    e = e2;
                    str3 = str11;
                }
                try {
                    Context context = c0077c.f262e;
                    try {
                        str5 = this.f240d;
                        str4 = "SyncNote/SyncSDocxUpdateLocalNote";
                        str6 = str;
                        c11971a = c11971aM162g;
                        String str12 = str7;
                        try {
                            new C0029b(c6903f, context, str5, str6, c11971a, c12969a, c0073a).m58b();
                            C11971a c11971a3 = (C11971a) c12969a.f9309c;
                            str9 = c11971a3.f8534r;
                            Debugger.m8615i(str4, "After compareForDownSync : serverCommitId = " + str9 + str12 + Logger.getEncode(c11971a3.f8535s));
                            this.f248h = c6748q.m4883k();
                            this.f249i = ((C11971a) c12969a.f9309c).f8533q;
                            try {
                            } catch (SyncException e3) {
                                e = e3;
                            }
                        } catch (SyncException e5) {
                            e = e5;
                            str5 = str3;
                        }
                    } catch (SyncException e6) {
                        e = e6;
                        str4 = "SyncNote/SyncSDocxUpdateLocalNote";
                        str5 = str3;
                        str6 = str;
                    }
                } catch (SyncException e7) {
                    e = e7;
                    str4 = "SyncNote/SyncSDocxUpdateLocalNote";
                    str5 = str3;
                    str6 = str;
                    if (e.getExceptionCode() == 12000) {
                    }
                    if (!ComposerManager.getInstance().isOpen(str5, null)) {
                        throw e;
                    }
                    throw e;
                }
                if (!m160e(z, c0113a, c6748q) && c6748q.m4879g() == 1) {
                    NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
                    if ((notesDocumentEntity != null ? notesDocumentEntity.getLastModifiedAt() : -1L) != ((C11971a) c12969a.f9309c).f8522f.f8704x) {
                        if (!c0113a.m272c(c6748q, str2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(" is conflicted and not downloaded!!");
                            Debugger.m8615i(str4, sb2.toString());
                            AbstractC0068i.m158a();
                            return;
                        }
                        str10 = str3;
                    } else {
                        String str13 = str3;
                        if (c11971a != null) {
                            c0113a.m274e(c6748q.m4873a(), str9);
                            c0113a.m270a(c6748q);
                            Context applicationContext2 = BaseUtils.getApplicationContext();
                            C6901d.m5113d(c6748q);
                            String str14 = c6748q.f4132e;
                            if (c6748q.m4879g() != 0) {
                                NotesDataRepositoryFactory.newInstance(applicationContext2).createDocumentDataRepository();
                                SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(applicationContext2).createSyncNoteDataRepository();
                                NotesDataRepositoryFactory.newInstance(applicationContext2).createDocumentTempDataRepository();
                                new C14433b(12);
                                syncNoteDataRepositoryCreateSyncNoteDataRepository2.updateDirty(str14, 0);
                            }
                            Debugger.m8614f(str4, str13 + " maybe conflicted but cleared!");
                            AbstractC0068i.m158a();
                            return;
                        }
                        Debugger.m8614f(str4, str13 + " is same as the server note but corrupted!");
                        str10 = str13;
                    }
                    if (e.getExceptionCode() == 12000) {
                        C11971a c11971a4 = (C11971a) c12969a.f9309c;
                        long j = c11971a4.f8533q;
                        int i = c11971a4.f8522f.f8651I;
                        SyncDelayInfoEntity syncDelayInfoEntity = new SyncDelayInfoEntity();
                        syncDelayInfoEntity.setUuid(str5);
                        syncDelayInfoEntity.setServerId(str6);
                        syncDelayInfoEntity.setAppVersion(C0145c.m322g());
                        syncDelayInfoEntity.setReason(12000);
                        syncDelayInfoEntity.setRetryCount(0);
                        syncDelayInfoEntity.setServerTimestamp(j);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(DBSchema.DocumentExtra.FORMAT_VERSION, i);
                        } catch (JSONException unused) {
                            Debugger.m8609e("SyncDelayInfoUtils", "UpdateSyncDelayInfo() : fail to put jsonObject!");
                        }
                        syncDelayInfoEntity.setExtra(jSONObject.toString());
                        C6742k.m4841o().m4847G(syncDelayInfoEntity);
                    }
                    if (!ComposerManager.getInstance().isOpen(str5, null) || c0075a.m213e(str5)) {
                        throw e;
                    }
                    Debugger.m8609e(str4, "perform() : fail to notify the invalid version = " + str5);
                    throw e;
                }
                str10 = str3;
                if (c11971a != null) {
                    c11971a.m13536k((C11971a) c12969a.f9309c);
                    c11971a2 = c11971a;
                } else {
                    c11971a2 = (C11971a) c12969a.f9309c;
                }
                c11971a2.f8521e = null;
                Debugger.printMemory(str4, "[CurrentMemoryState] Before ungrouping the stroke groups");
                if (c0097a.f320c) {
                    AbstractC0153k.m377f(str4, "Before ungrouping a note");
                    c11971a2.m13535j();
                }
                Debugger.printMemory(str4, "[CurrentMemoryState] After ungrouping the stroke groups");
                m156c(c12969a);
                AbstractC0067h.m155b(c12969a);
                c12969a.f9309c = null;
                AbstractC0153k.m377f(str4, "Before saving a note");
                m157d(c11971a2, str6, z);
                AbstractC0153k.m377f(str4, "After saving a note");
                String str15 = str8;
                Debugger.printMemory(str4, str15);
                c0077c.f266i.f4136d.m15037k(str10);
                AbstractC0068i.m158a();
                Debugger.printMemory(str4, str15);
            } catch (NullPointerException | OutOfMemoryError unused2) {
                throw new SyncException(337, "Out of memory");
            }
        } catch (Throwable th) {
            AbstractC0068i.m158a();
            throw th;
        }
    }

    /* JADX INFO: renamed from: g */
    public final C11971a m162g(String str) {
        try {
            return this.f238b.m226m(str);
        } catch (Exception e) {
            AbstractC4539a.m3213w(e, new StringBuilder("readLocalNoteForDownSync() : fail to readWDocByUuid , Exception : "), "SyncNote/SyncSDocxUpdateLocalNote");
            return null;
        } catch (OutOfMemoryError e2) {
            Debugger.m8609e("SyncNote/SyncSDocxUpdateLocalNote", "readLocalNoteForDownSync() : fail to readWDocByUuid , OutOfMemoryError : " + e2.toString());
            return null;
        }
    }
}
