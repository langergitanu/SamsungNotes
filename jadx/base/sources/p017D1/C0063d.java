package p017D1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.notes.sync.converters.WDocExceedObjectException;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.app.notes.sync.synchronization.managers.C6901d;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import p001A.AbstractC0000a;
import p007B0.C0018a;
import p007B0.C0019b;
import p007B0.C0025h;
import p008B1.C0028a;
import p008B1.C0030c;
import p008B1.C0031d;
import p008B1.C0034g;
import p012C1.RunnableC0045a;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.AbstractC0100d;
import p026F1.C0097a;
import p034H1.C0113a;
import p042J1.AbstractC0153k;
import p042J1.C0145c;
import p042J1.C0152j;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p178f0.C11979b;
import p178f0.C11980c;
import p182g0.C11991a;
import p182g0.C12005o;
import p186h1.C12020a;
import p207n1.C13541h;
import p234q1.C14433b;
import p234q1.C14434c;
import p235r0.C14440f;
import p235r0.C14445k;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: D1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0063d extends AbstractC0068i {
    /* JADX INFO: renamed from: b */
    public final boolean m144b(C11971a c11971a) {
        return AbstractC4539a.m3210t() && NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(this.f240d.f319b) && ((C11980c) c11971a.f8526j.f4484c).f8580b > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [D1.a, D1.d] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX INFO: renamed from: c */
    public void m145c(C6748q c6748q) throws Throwable {
        C0097a c0097a;
        C6748q c6748q2 = this;
        StringBuilder sb = new StringBuilder("perform() : ");
        String str = c6748q2.f241e;
        sb.append(str);
        Debugger.m8615i("SyncNote/SyncSDocxCreateServerNote", sb.toString());
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxCreateServerNote";
        c0152jM378g.f455d = str;
        C0077c c0077c = c6748q2.f237a;
        Context context = c0077c.f262e;
        C6903f c6903f = c0077c.f265h;
        Context context2 = c0077c.f262e;
        C6749r c6749r = c0077c.f266i;
        c0152jM378g.m371b(context);
        BaseUtils.getApplicationContext();
        C6901d.m5112b(c6748q, c0077c);
        try {
            try {
                try {
                    AbstractC0100d.f327a = true;
                    Debugger.printMemory("SyncNote/SyncSDocxCreateServerNote", "[CurrentMemoryState] Before loading a note to SPEN SDK");
                    AbstractC0153k.m377f("SyncNote/SyncSDocxCreateServerNote", "Before loading a note to SPEN SDK");
                    C11971a c11971aM147e = m147e(c6748q);
                    try {
                        if (c11971aM147e == null) {
                            throw new SyncException(326, "wDocData is null!");
                        }
                        Debugger.printMemory("SyncNote/SyncSDocxCreateServerNote", "[CurrentMemoryState] After loading a note to SPEN SDK");
                        int iM4882j = c6748q.m4882j();
                        int i = ((C11980c) c11971aM147e.f8526j.f4484c).f8580b;
                        C0097a c0097a2 = c6748q2.f240d;
                        C0082h c0082h = c6748q2.f238b;
                        try {
                            try {
                                if (iM4882j > 0) {
                                    if (c11971aM147e.f8522f.f8676d0 != 0) {
                                        StringBuilder sb2 = new StringBuilder("perform() : wDocData is already grouped <- ");
                                        sb2.append(c11971aM147e.f8522f.f8676d0);
                                        Debugger.m8615i("SyncNote/SyncSDocxCreateServerNote", sb2.toString());
                                    } else {
                                        if (!c0082h.m227n(str)) {
                                            throw new SyncException(326, "fail to set saveStrokeGroupSync!");
                                        }
                                        c11971aM147e = m147e(c6748q);
                                        if (c11971aM147e.f8522f.f8676d0 == 0 && !c0082h.m227n(str)) {
                                            throw new SyncException(326, "fail to set saveStrokeGroupSync!!");
                                        }
                                        StringBuilder sb3 = new StringBuilder("perform() : wDocData just got grouped <- ");
                                        sb3.append(c11971aM147e.f8522f.f8676d0);
                                        sb3.append(", totalObjectStrokeCount = ");
                                        sb3.append(i);
                                        Debugger.m8609e("SyncNote/SyncSDocxCreateServerNote", sb3.toString());
                                    }
                                    c0097a2.f320c = true;
                                    c0097a = c0097a2;
                                } else if (c6748q2.m144b(c11971aM147e)) {
                                    c0097a = c0097a2;
                                    if (c11971aM147e.f8522f.f8676d0 != 0) {
                                        StringBuilder sb4 = new StringBuilder("perform() : wDocData is already grouped <- ");
                                        sb4.append(c11971aM147e.f8522f.f8676d0);
                                        sb4.append(", totalObjectStrokeCount = ");
                                        sb4.append(i);
                                        Debugger.m8615i("SyncNote/SyncSDocxCreateServerNote", sb4.toString());
                                    } else {
                                        if (!c0082h.m227n(str)) {
                                            throw new SyncException(326, "fail to set saveStrokeGroupSync!");
                                        }
                                        c11971aM147e = m147e(c6748q);
                                        if (c11971aM147e.f8522f.f8676d0 == 0 && !c0082h.m227n(str)) {
                                            throw new SyncException(326, "fail to set saveStrokeGroupSync!!");
                                        }
                                        StringBuilder sb5 = new StringBuilder("perform() : wDocData just got grouped as needed <- ");
                                        sb5.append(c11971aM147e.f8522f.f8676d0);
                                        sb5.append(", totalObjectStrokeCount = ");
                                        sb5.append(i);
                                        Debugger.m8615i("SyncNote/SyncSDocxCreateServerNote", sb5.toString());
                                    }
                                    c6749r.f4134b.setStrokeGrouped(str, 1);
                                    c0097a.f320c = true;
                                } else {
                                    c0097a = c0097a2;
                                    Debugger.m8615i("SyncNote/SyncSDocxCreateServerNote", "perform() : localWDocData is not grouped, totalObjectStrokeCount = " + i);
                                }
                            } catch (OutOfMemoryError unused) {
                            }
                            try {
                                C12020a c12020a = new C12020a(this, 2);
                                c6903f.m5131p("NU");
                                m148f(c11971aM147e, c12020a);
                                C0031d c0031d = new C0031d(c6903f, context2, c0097a);
                                c0031d.f161g = null;
                                c0031d.f158d = c11971aM147e;
                                c0031d.f159e = c12020a;
                                c0031d.f160f = new C0025h();
                                C0018a c0018aM60b = c0031d.m60b();
                                if (TextUtils.isEmpty(c0018aM60b.f94b)) {
                                    Debugger.m8612ef("SyncNote/SyncSDocxCreateServerNote", "perform() : No server id of " + str);
                                } else {
                                    c6749r.f4134b.updateNoteServerId(str, c0018aM60b.f94b);
                                    if (c0018aM60b.f98f) {
                                        Debugger.m8615i("SyncNote/SyncSDocxCreateServerNote", "perform() : already created!");
                                        if (!C0145c.m338w(context2)) {
                                            C0145c.m309Q(context2, Boolean.TRUE);
                                        }
                                    } else {
                                        if (TextUtils.isEmpty(c0018aM60b.f97e)) {
                                            Debugger.m8612ef("SyncNote/SyncSDocxCreateServerNote", "perform() : No commitId of " + str);
                                        } else {
                                            c6749r.m4887c(str, c0018aM60b.f97e);
                                        }
                                        Debugger.m8614f("SyncNote/SyncSDocxCreateServerNote", "[SyncResult] upSync, new " + str + ", syncModifiedTime = " + c11971aM147e.f8533q);
                                        C6901d c6901d = new C6901d();
                                        C6901d.m5113d(c6748q);
                                        c6901d.m5114a(c11971aM147e);
                                        c6901d.m5115c(c6748q);
                                        C6742k.m4841o().m4855l(c11971aM147e.f8532p);
                                    }
                                }
                                AbstractC0068i.m158a();
                                return;
                            } catch (OutOfMemoryError unused2) {
                                c6748q2 = c6748q;
                                C0145c.m308P(c6748q2.m4883k(), "SyncControlOutOfMemoryNote", str);
                                C14440f c14440f = new C14440f();
                                c14440f.f165b = "SYNC_ERROR";
                                c14440f.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14440f.f165b, 103, "UUID : " + str));
                                c14440f.m62a();
                                throw new SyncException(337, "Out of memory");
                            }
                        } catch (OutOfMemoryError unused3) {
                        } catch (Throwable th) {
                            th = th;
                            AbstractC0068i.m158a();
                            throw th;
                        }
                    } catch (OutOfMemoryError unused4) {
                    }
                } catch (OutOfMemoryError unused5) {
                    c6748q2 = c6748q;
                }
                C0145c.m308P(c6748q2.m4883k(), "SyncControlOutOfMemoryNote", str);
                C14440f c14440f2 = new C14440f();
                c14440f2.f165b = "SYNC_ERROR";
                c14440f2.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14440f2.f165b, 103, "UUID : " + str));
                c14440f2.m62a();
                throw new SyncException(337, "Out of memory");
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX INFO: renamed from: d */
    public void m146d(C6748q c6748q, String str) throws SyncException {
        C6748q c6748q2;
        C0113a c0113a;
        NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
        C0097a c0097a = this.f240d;
        C6748q c6748q3 = "perform() : localWDocData just got grouped <- ";
        StringBuilder sb = new StringBuilder("perform() : ");
        String str2 = this.f241e;
        sb.append(str2);
        Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", sb.toString());
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxUpdateServerNote";
        c0152jM378g.f455d = str2;
        C0077c c0077c = this.f237a;
        Context context = c0077c.f262e;
        C6749r c6749r = c0077c.f266i;
        Context context2 = c0077c.f262e;
        C6903f c6903f = c0077c.f265h;
        c0152jM378g.m371b(context);
        C0113a c0113a2 = new C0113a(str2);
        if (c6748q.m4884l() && c6748q.m4874b() == 0) {
            Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", str2 + " is conflicted and not uploaded!");
            return;
        }
        BaseUtils.getApplicationContext();
        C6901d.m5112b(c6748q, c0077c);
        try {
            try {
                ServerNoteInfo serverNoteInfo = (ServerNoteInfo) new C0028a(c6903f, context2, c0097a, str).m57c().f8772b;
                try {
                    if (!serverNoteInfo.isExists()) {
                        Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", "perform() : The note is already deleted on the server side!");
                        c6749r.f4134b.resetDeletedNoteInServer(str2);
                        if ((c6748q.m4880h() & 32768) == 32768) {
                            Context applicationContext = BaseUtils.getApplicationContext();
                            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                            syncNoteDataRepositoryCreateSyncNoteDataRepository.removeNoteSyncStateFlag(str2, 32768L);
                        }
                        C0145c.m302J("SyncControlLowVersionNote", str2);
                        SyncException syncException = new SyncException(315, "Resource not found!");
                        syncException.setStatusCode(404);
                        throw syncException;
                    }
                    if (serverNoteInfo.getIsHighFormatVer()) {
                        c0113a2.m271b(serverNoteInfo.getModelName(), "Server note is updated");
                        Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", str2 + " is conflicted and not uploaded!");
                        throw new SyncException(12000, "High formated note");
                    }
                    if (serverNoteInfo.getSyncModifiedTime() == c6748q.m4883k()) {
                        c6749r.m4888d(0, str2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(" is same as the server note, and not dirtied and uploaded, serverTimestamp = ");
                        sb2.append(c6748q.m4883k());
                        sb2.append(", modifiedTime = ");
                        sb2.append(notesDocumentEntity != null ? notesDocumentEntity.getLastModifiedAt() : -1L);
                        Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", sb2.toString());
                        AbstractC0068i.m158a();
                        return;
                    }
                    if (TextUtils.isEmpty(c6748q.m4873a())) {
                        if (serverNoteInfo.getModifiedTime() == (notesDocumentEntity != null ? notesDocumentEntity.getLastModifiedAt() : -1L)) {
                            BaseUtils.getApplicationContext();
                            C6901d.m5113d(c6748q);
                            NotesDataRepositoryFactory.newInstance(context2).createDocumentDataRepository();
                            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
                            NotesDataRepositoryFactory.newInstance(context2).createDocumentTempDataRepository();
                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                            String commitId = serverNoteInfo.getCommitId();
                            Debugger.m8607d("WDocWriteResolver", "setCommitId() : " + commitId);
                            syncNoteDataRepositoryCreateSyncNoteDataRepository2.updateCommitId(str2, commitId);
                            syncNoteDataRepositoryCreateSyncNoteDataRepository2.updateDirty(str2, 0);
                            Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", str2 + " is same as the modifiedTime of the server note, and not dirtied and uploaded, with commitId = " + serverNoteInfo.getCommitId());
                            AbstractC0068i.m158a();
                            return;
                        }
                        if (!c6748q.m4884l()) {
                            c0113a2.m271b(serverNoteInfo.getModelName(), "Local note is updated without the commitId");
                            Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", str2 + " is conflicted and not uploaded!");
                            AbstractC0068i.m158a();
                            return;
                        }
                    }
                    AbstractC0100d.f327a = true;
                    Debugger.printMemory("SyncNote/SyncSDocxUpdateServerNote", "[CurrentMemoryState] Before loading a note to SPEN SDK");
                    AbstractC0153k.m377f("SyncNote/SyncSDocxUpdateServerNote", "Before loading a note to SPEN SDK");
                    C11971a c11971aM147e = m147e(c6748q);
                    if (c11971aM147e == null) {
                        throw new SyncException(326, "localWDocData is null!");
                    }
                    Debugger.printMemory("SyncNote/SyncSDocxUpdateServerNote", "[CurrentMemoryState] After loading a note to SPEN SDK");
                    int iM4882j = c6748q.m4882j();
                    int i = ((C11980c) c11971aM147e.f8526j.f4484c).f8580b;
                    C0082h c0082h = this.f238b;
                    try {
                        if (iM4882j > 0) {
                            if (c11971aM147e.f8522f.f8676d0 != 0) {
                                StringBuilder sb3 = new StringBuilder("perform() : localWDocData is grouped <- ");
                                sb3.append(c11971aM147e.f8522f.f8676d0);
                                sb3.append(", totalObjectStrokeCount = ");
                                sb3.append(i);
                                Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", sb3.toString());
                            } else {
                                if (!c0082h.m227n(str2)) {
                                    throw new SyncException(326, "fail to set saveStrokeGroupSync!");
                                }
                                c11971aM147e = m147e(c6748q);
                                if (!c0082h.m227n(str2)) {
                                    throw new SyncException(326, "fail to set saveStrokeGroupSync!!");
                                }
                                StringBuilder sb4 = new StringBuilder("perform() : localWDocData just got grouped <- ");
                                sb4.append(c11971aM147e.f8522f.f8676d0);
                                sb4.append(", totalObjectStrokeCount = ");
                                sb4.append(i);
                                Debugger.m8609e("SyncNote/SyncSDocxUpdateServerNote", sb4.toString());
                            }
                            c0097a.f320c = true;
                        } else if (m144b(c11971aM147e)) {
                            if (c11971aM147e.f8522f.f8676d0 != 0) {
                                StringBuilder sb5 = new StringBuilder("perform() : localWDocData is already grouped <- ");
                                sb5.append(c11971aM147e.f8522f.f8676d0);
                                sb5.append(", totalObjectStrokeCount = ");
                                sb5.append(i);
                                Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", sb5.toString());
                            } else {
                                if (!c0082h.m227n(str2)) {
                                    throw new SyncException(326, "fail to set saveStrokeGroupSync!");
                                }
                                c11971aM147e = m147e(c6748q);
                                if (!c0082h.m227n(str2)) {
                                    throw new SyncException(326, "fail to set saveStrokeGroupSync!!");
                                }
                                StringBuilder sb6 = new StringBuilder("perform() : localWDocData just got grouped as needed <- ");
                                sb6.append(c11971aM147e.f8522f.f8676d0);
                                sb6.append(", totalObjectStrokeCount = ");
                                sb6.append(i);
                                Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", sb6.toString());
                            }
                            c6749r.f4134b.setStrokeGrouped(str2, 1);
                            c0097a.f320c = true;
                        } else if (i > 0) {
                            Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", "perform() : localWDocData is not grouped, totalObjectStrokeCount = " + i);
                        }
                        C0061b c0061b = new C0061b(this, 1);
                        C14433b c14433b = new C14433b(1, false);
                        c6903f.m5131p("NU");
                        C0030c c0030c = new C0030c(c6903f, context2, c0097a);
                        c0030c.f155d = str;
                        c0030c.f156e = c11971aM147e;
                        c0030c.f157f = c14433b;
                        c0030c.m59b();
                        C12005o c12005o = (C12005o) c14433b.f10228b;
                        if (c12005o.f8719h) {
                            c6748q2 = c6748q;
                            c0113a = c0113a2;
                        } else {
                            String str3 = c12005o.f8718g;
                            String str4 = c12005o.f8717f;
                            Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", "After compareForUpsync : serverCommitId = " + str4 + " by " + Logger.getEncode(str3));
                            c6748q2 = c6748q;
                            c0113a = c0113a2;
                            if (!c0113a.m273d(c6748q2, str3, str4)) {
                                Debugger.m8615i("SyncNote/SyncSDocxUpdateServerNote", str2 + " may be conflicted and not uploaded!!");
                                AbstractC0068i.m158a();
                                return;
                            }
                        }
                        AbstractC0153k.m377f("SyncNote/SyncSDocxUpdateServerNote", "Before XML composing for updating");
                        c11971aM147e.m13533h((C12005o) c14433b.f10228b);
                        m148f(c11971aM147e, c0061b);
                        c0082h.m219f(this.f239c, "SyncSDocxUpdateServerNote!");
                        C0034g c0034g = new C0034g(c6903f, context2, c0097a);
                        c0034g.f171h = null;
                        c0034g.f167d = str;
                        c0034g.f169f = c0097a;
                        c0034g.f168e = c11971aM147e;
                        c0034g.f170g = c0061b;
                        C0018a c0018aM63b = c0034g.m63b();
                        if (c0018aM63b == null) {
                            Debugger.m8609e("SyncNote/SyncSDocxUpdateServerNote", "updateServerNote() : updateNoteItem is null!");
                        } else if (c0018aM63b.f98f) {
                            c0113a.m271b("Unknown", "Fail to updateNote due to the conflict!");
                        } else if (TextUtils.isEmpty(c0018aM63b.f97e)) {
                            Debugger.m8612ef("SyncNote/SyncSDocxUpdateServerNote", "updateServerNote() : No commitId!");
                        } else {
                            c6749r.m4887c(str2, c0018aM63b.f97e);
                            c0113a.m270a(c6748q2);
                            Debugger.m8614f("SyncNote/SyncSDocxUpdateServerNote", "[SyncResult] upSync, " + str2 + ", syncModifiedTime = " + c11971aM147e.f8533q);
                            C6901d c6901d = new C6901d();
                            C6901d.m5113d(c6748q2);
                            c6901d.m5114a(c11971aM147e);
                            c6901d.m5115c(c6748q2);
                            C6742k.m4841o().m4855l(c11971aM147e.f8532p);
                        }
                        AbstractC0068i.m158a();
                    } catch (OutOfMemoryError unused) {
                        c6748q3 = c6748q;
                        C0145c.m308P(c6748q3.m4883k(), "SyncControlOutOfMemoryNote", str2);
                        C14440f c14440f = new C14440f();
                        c14440f.f165b = "SYNC_ERROR";
                        c14440f.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14440f.f165b, 103, "UUID : " + str2));
                        c14440f.m62a();
                        throw new SyncException(337, "Out of memory");
                    }
                } catch (OutOfMemoryError unused2) {
                }
            } catch (OutOfMemoryError unused3) {
                c6748q3 = c6748q;
            }
        } catch (Throwable th) {
            AbstractC0068i.m158a();
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public final C11971a m147e(C6748q c6748q) throws SyncException {
        String str = this.f241e;
        try {
            return this.f238b.m226m(str);
        } catch (WDocExceedObjectException unused) {
            if (c6748q.m4882j() != 0) {
                if ((c6748q.m4880h() & 512) == 512) {
                    Context applicationContext = BaseUtils.getApplicationContext();
                    SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
                    NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                    syncNoteDataRepositoryM3196f.removeNoteSyncStateFlag(str, 512L);
                }
                Context applicationContext2 = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f2 = AbstractC4539a.m3196f(applicationContext2, applicationContext2);
                NotesDataRepositoryFactory.newInstance(applicationContext2).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f2.addNoteSyncStateFlag(str, 65536L);
            } else {
                Context applicationContext3 = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f3 = AbstractC4539a.m3196f(applicationContext3, applicationContext3);
                NotesDataRepositoryFactory.newInstance(applicationContext3).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f3.addNoteSyncStateFlag(str, 512L);
            }
            C0145c.m308P(c6748q.m4883k(), "SyncControlExceedObjectNote", str);
            C14445k c14445k = new C14445k();
            c14445k.f165b = "SYNC_ERROR";
            c14445k.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14445k.f165b, 101, ""));
            c14445k.m62a();
            AbstractC0299q.m604N("5044", "c");
            AbstractC0299q.m619b(str, "5038");
            throw new SyncException(337, "Too many objects");
        } catch (SyncException e) {
            throw e;
        } catch (SpenUnsupportedVersionException e2) {
            Debugger.m8615i("SyncNote/SyncSDocxServerNote", "readLocalNoteForUpSync() : Need to update app , uuid = " + str);
            C0077c c0077c = this.f237a;
            if (!SyncState.isAppUpdateNeeded(c0077c.f262e)) {
                SyncState.setAppUpdateNeeded(c0077c.f262e, true);
            }
            throw new SyncException(326, e2);
        } catch (Exception e3) {
            Debugger.m8609e("SyncNote/SyncSDocxServerNote", "readLocalNoteForUpSync() : fail to readWDocByUuid , " + e3.toString());
            throw new SyncException(326, e3);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m148f(C11971a c11971a, InterfaceC6855f interfaceC6855f) throws Throwable {
        String str;
        HashMap map;
        String str2;
        int iM15132Q;
        String str3;
        String str4;
        String str5;
        String str6;
        File file;
        String strM300H;
        C0097a c0097a = this.f240d;
        C0077c c0077c = this.f237a;
        C13541h c13541h = new C13541h(c0077c, c0097a, interfaceC6855f);
        C11979b c11979b = (C11979b) c11971a.f8526j.f4483b;
        C6903f c6903f = c0077c.f265h;
        Context context = c0077c.f262e;
        String str7 = (String) c6903f.f4474b;
        HashMap map2 = new HashMap();
        for (C11991a c11991a : c11979b.f8577e) {
            C0019b c0019b = new C0019b();
            c0019b.f106h = "pending";
            c0019b.f107i = "none";
            c0019b.f109k = false;
            String str8 = c11991a.f8610c;
            c0019b.f103e = str8;
            c0019b.f99a = c11991a.f8618k;
            c0019b.f100b = "application/octet-stream";
            c0019b.f101c = FileUtils.getFileSize(str8);
            try {
                strM300H = C0145c.m300H(c11991a.f8618k, str7.lastIndexOf(IdentityApiContract.Token.BEARER_) == 0 ? str7.substring(7) : str7);
            } catch (SyncException e) {
                Debugger.m8609e("CreateUploadUrlItem", "getChecksum() : msg = " + e.toString());
                strM300H = null;
            }
            c0019b.f102d = strM300H;
            c0019b.f105g = c11991a;
            map2.put(c0019b.f99a, c0019b);
        }
        for (C0019b c0019b2 : new ArrayList(map2.values())) {
            try {
                file = new File(c0019b2.f103e);
            } catch (IOException e2) {
                AbstractC0000a.m20q(e2, new StringBuilder("verifyFiles() : failed to get hash :"), "SyncNote/SyncFiles");
            }
            if (!file.exists() || file.length() == 0) {
                throw new SyncException(326, "empty file , fileInfo = " + c0019b2);
            }
            String strM327l = C0145c.m327l(file);
            if (!strM327l.equals(c0019b2.f99a)) {
                throw new SyncException(326, "sdk hash " + c0019b2.f99a + " and app hash " + strM327l + " is different, fileInfo = " + c0019b2);
            }
            Debugger.m8615i("SyncNote/SyncFiles", "verifyFiles() : valid file = " + Debugger.getEncode(c0019b2.f105g.f8613f) + ", realHash = " + strM327l);
        }
        ArrayList arrayList = new ArrayList(map2.values());
        int i = 0;
        while (true) {
            int size = arrayList.size();
            String str9 = "duplicated";
            String str10 = TelemetryEventStrings.Value.FAILED;
            if (i >= size) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q("UploadResults\n");
                ArrayList arrayList2 = new ArrayList();
                Iterator it = map2.values().iterator();
                int i2 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (it.hasNext()) {
                    C0019b c0019b3 = (C0019b) it.next();
                    Iterator it2 = it;
                    String str11 = c0019b3.f106h;
                    if ("duplicated".equals(str11)) {
                        i2++;
                    } else if ("created".equals(str11)) {
                        i4++;
                        arrayList2.add(c0019b3);
                    } else if (TelemetryEventStrings.Value.FAILED.equals(str11)) {
                        i5++;
                    } else if ("pending".equals(str11)) {
                        i6++;
                    }
                    c0019b3.toString();
                    i7++;
                    it = it2;
                }
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i4, i2, "created = ", ", duplicated = ", ", failed = ");
                AbstractC2821a.m2235z(sbM1173s, i5, i6, ", pending = ", ", total = ");
                sbM1173s.append(i7);
                String string = sbM1173s.toString();
                Debugger.m8607d("CreateUploadUrlItem", string);
                C0152j c0152jM378g = AbstractC0153k.m378g();
                c0152jM378g.f455d = string;
                c0152jM378g.f454c = "CreateUploadUrlResult";
                c0152jM378g.m371b(context);
                if (i5 > 0 || i6 > 0) {
                    throw new SyncException(327, "failed to create url");
                }
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    ((ExecutorService) c13541h.f9591d).submit(new RunnableC0045a(c13541h, new C6903f(c13541h, 2, (C0019b) it3.next(), sbM1324q), 0));
                }
                ((ExecutorService) c13541h.f9591d).shutdown();
                c13541h.m14288a();
                C0152j c0152jM378g2 = AbstractC0153k.m378g();
                c0152jM378g2.f454c = "UploadResults";
                c0152jM378g2.f455d = sbM1324q.toString();
                c0152jM378g2.m371b(context);
                SyncException syncException = (SyncException) c13541h.f9588a;
                if (syncException != null) {
                    throw syncException;
                }
                return;
            }
            int i8 = i + 100;
            List listSubList = arrayList.subList(i, Math.min(i8, arrayList.size()));
            ArrayList arrayList3 = arrayList;
            try {
                C6742k c6742k = new C6742k(Xml.newSerializer());
                c6742k.m4846F("request");
                c6742k.m4846F("fileInfoList");
                Iterator it4 = listSubList.iterator();
                while (true) {
                    boolean zHasNext = it4.hasNext();
                    Iterator it5 = it4;
                    str = "hash";
                    if (!zHasNext) {
                        break;
                    }
                    C0019b c0019b4 = (C0019b) it5.next();
                    c6742k.m4846F("fileInfo");
                    c6742k.m4865w("hash", c0019b4.f99a);
                    c6742k.m4865w("contentType", c0019b4.f100b);
                    c6742k.m4863u("size", c0019b4.f101c);
                    c6742k.m4865w("validationKey", c0019b4.f102d);
                    c6742k.m4856m("fileInfo");
                    str9 = str9;
                    it4 = it5;
                    i8 = i8;
                    str10 = str10;
                }
                int i9 = i8;
                String str12 = str9;
                String str13 = str10;
                c6742k.m4856m("fileInfoList");
                c6742k.m4856m("request");
                c6742k.m4857n();
                String string2 = ((StringWriter) c6742k.f4111c).toString();
                C0097a c0097a2 = (C0097a) c13541h.f9590c;
                int i10 = 3;
                StringBuilder sb = c0097a2.f318a == 3 ? new StringBuilder("/samsungnotes/v3") : new StringBuilder("/samsungnotes/v2");
                sb.append("/binaries/createUploadURLs");
                String strM15044b = C14434c.m15043a().m15044b(sb.toString());
                C6861l c6861l = new C6861l(c0077c, c0097a2);
                c6861l.f4304e = strM15044b;
                c6861l.f4309j = "createUploadURLs";
                c6861l.f4303d = string2;
                C6865p c6865pM5038h = c6861l.m5038h();
                if (c0097a2.f318a >= 3) {
                    if (c6865pM5038h.f4344a != 200) {
                        AbstractC0299q.m600J(context, c6865pM5038h);
                        throw new SyncException(315, c6865pM5038h.toString());
                    }
                } else if (c6865pM5038h.f4344a != 207) {
                    AbstractC0299q.m600J(context, c6865pM5038h);
                    throw new SyncException(315, c6865pM5038h.toString());
                }
                String str14 = c6865pM5038h.f4346c;
                try {
                    XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                    xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                    XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                    xmlPullParserNewPullParser.setInput(new StringReader(str14));
                    int eventType = xmlPullParserNewPullParser.getEventType();
                    C0077c c0077c2 = c0077c;
                    String str15 = "";
                    String strM15134S = str15;
                    String strM15134S2 = null;
                    String strM15134S3 = null;
                    String strM15134S4 = null;
                    int i11 = 0;
                    while (true) {
                        if (eventType != 2) {
                            if (eventType == i10) {
                                String name = xmlPullParserNewPullParser.getName();
                                if ("MultiUploadURLView".equalsIgnoreCase(name)) {
                                    map = map2;
                                    break;
                                }
                                if ("file".equalsIgnoreCase(name)) {
                                    C0019b c0019b5 = (C0019b) map2.get(strM15134S2);
                                    if (c0019b5 == null) {
                                        throw new SyncException(327, strM15134S2 + " file does not existed");
                                    }
                                    if ("created".equalsIgnoreCase(str15)) {
                                        c0019b5.f106h = str15;
                                        str5 = strM15134S3;
                                        c0019b5.f104f = str5;
                                        str6 = strM15134S4;
                                        c0019b5.f105g.f8620m = str6;
                                    } else {
                                        str5 = strM15134S3;
                                        str6 = strM15134S4;
                                        if (str12.equalsIgnoreCase(str15)) {
                                            c0019b5.f106h = str15;
                                        } else {
                                            String str16 = str13;
                                            map = map2;
                                            str2 = str16;
                                            if (str2.equalsIgnoreCase(str15)) {
                                                strM15134S3 = str5;
                                                StringBuilder sb2 = new StringBuilder();
                                                strM15134S4 = str6;
                                                sb2.append("reason : ");
                                                sb2.append(str14);
                                                Debugger.m8609e("CreateUploadUrlItem", sb2.toString());
                                                c0019b5.f106h = str15;
                                                iM15132Q = i11;
                                                c0019b5.f108j = iM15132Q;
                                                str3 = strM15134S;
                                                c0019b5.f107i = str3;
                                                str4 = str;
                                            }
                                            strM15134S3 = str5;
                                            strM15134S4 = str6;
                                        }
                                    }
                                    String str17 = str13;
                                    map = map2;
                                    str2 = str17;
                                    strM15134S3 = str5;
                                    strM15134S4 = str6;
                                }
                                iM15132Q = i11;
                                str3 = strM15134S;
                                str4 = str;
                            } else if (eventType != 4) {
                                Debugger.m8607d("CreateUploadUrlItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                            }
                            String str18 = str13;
                            map = map2;
                            str2 = str18;
                            iM15132Q = i11;
                            str3 = strM15134S;
                            str4 = str;
                        } else {
                            String str19 = str13;
                            map = map2;
                            str2 = str19;
                            iM15132Q = i11;
                            str3 = strM15134S;
                            String name2 = xmlPullParserNewPullParser.getName();
                            if ("created".equalsIgnoreCase(name2) || str12.equalsIgnoreCase(name2) || str2.equalsIgnoreCase(name2)) {
                                str4 = str;
                                str15 = name2;
                            } else if (str.equalsIgnoreCase(name2)) {
                                strM15134S2 = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                                str4 = str;
                            } else {
                                str4 = str;
                                if ("url".equalsIgnoreCase(name2)) {
                                    strM15134S3 = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                                } else if ("uploadToken".equalsIgnoreCase(name2)) {
                                    strM15134S4 = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                                } else if ("status".equalsIgnoreCase(name2)) {
                                    iM15132Q = AbstractC14517a.m15132Q(xmlPullParserNewPullParser);
                                } else {
                                    if ("reason".equalsIgnoreCase(name2)) {
                                        strM15134S = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                                    }
                                    eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                                    if ((eventType == 3 || xmlPullParserNewPullParser.getName() == null || !xmlPullParserNewPullParser.getName().equals("UploadURLView")) && eventType != 1) {
                                        HashMap map3 = map;
                                        str13 = str2;
                                        map2 = map3;
                                        str = str4;
                                        i11 = iM15132Q;
                                        i10 = 3;
                                    }
                                }
                            }
                        }
                        strM15134S = str3;
                        eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                        if (eventType == 3) {
                            HashMap map32 = map;
                            str13 = str2;
                            map2 = map32;
                            str = str4;
                            i11 = iM15132Q;
                            i10 = 3;
                        } else {
                            HashMap map322 = map;
                            str13 = str2;
                            map2 = map322;
                            str = str4;
                            i11 = iM15132Q;
                            i10 = 3;
                        }
                    }
                    arrayList = arrayList3;
                    i = i9;
                    map2 = map;
                    c0077c = c0077c2;
                } catch (Exception e3) {
                    AbstractC0000a.m21r(e3, new StringBuilder("fromXMLString : "), "CreateUploadUrlItem");
                    Debugger.m8610e("CreateUploadUrlItem", "", e3);
                    throw new SyncException(327, e3);
                }
            } catch (Exception e5) {
                Debugger.m8609e("CreateUploadUrlItem", "toXml : " + e5.getMessage());
                throw new SyncException(326, e5);
            }
        }
    }
}
