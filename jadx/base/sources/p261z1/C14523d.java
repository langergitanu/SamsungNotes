package p261z1;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.credentials.playservices.C2517b;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.app.notes.sync.p135db.C6741j;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.SpenSdkCompat;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesMappedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.C13883h;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0003c;
import p002A0.C0009i;
import p003A1.C0012a;
import p003A1.C0013b;
import p010C.C0042g;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p074R1.C0233e;
import p086V.C0322h;
import p093X.C0338f;
import p207n1.C13540g;
import p207n1.C13541h;
import p234q1.C14433b;
import p243u0.C14472b;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: z1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14523d {

    /* JADX INFO: renamed from: e */
    public final C0012a f10378e;

    /* JADX INFO: renamed from: f */
    public final C0013b f10379f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC14510a f10380g;

    /* JADX INFO: renamed from: h */
    public final String f10381h;

    /* JADX INFO: renamed from: i */
    public boolean f10382i;

    /* JADX INFO: renamed from: j */
    public List f10383j;

    /* JADX INFO: renamed from: a */
    public final ArrayList f10374a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public final ArrayList f10375b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final ArrayList f10376c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public final ArrayList f10377d = new ArrayList();

    /* JADX INFO: renamed from: k */
    public final HashMap f10384k = new HashMap();

    public C14523d(C0012a c0012a, C0013b c0013b, InterfaceC14510a interfaceC14510a) {
        this.f10378e = c0012a;
        this.f10379f = c0013b;
        this.f10380g = interfaceC14510a;
        c0012a.getClass();
        this.f10381h = C0012a.m39b();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m15179a(File file) throws SyncException {
        this.f10382i = true;
        try {
            Debugger.m8616s("SyncOldNote$SyncSDoc", "checkValidSDocFile");
            SpenSdkCompat.with(this.f10378e.f262e).asSpenSDocFile().checkValidity(file.getAbsolutePath());
            return true;
        } catch (SpenSDocUnsupportedFileException e) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", e.toString());
            if (!file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncSDoc", "UnsupportedFileException : can't delete the file!");
            }
            return false;
        } catch (SpenSDocUnsupportedVersionException e2) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", e2.toString());
            this.f10382i = false;
            return true;
        } catch (IOException e3) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", e3.toString());
            throw new SyncException(307, "Failed to checkValidity!");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r16 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
    
        if (r9 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011d, code lost:
    
        if (r9.isEmpty() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0121, code lost:
    
        r0 = androidx.compose.runtime.AbstractC1974b.m1324q(r11);
        r0.append((java.lang.String) r9.get(0));
        r0 = r0.toString();
        r3 = androidx.compose.runtime.AbstractC1974b.m1324q(r11);
        r3.append(r19.f39b.replaceAll(":", "_"));
        r2 = r3.toString();
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8616s("SyncOldNote$SyncSDoc", "downloadFileName: " + r0);
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8616s("SyncOldNote$SyncSDoc", "tempPath: " + r2);
        r3 = new java.io.File(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0173, code lost:
    
        if (r2.equals(r0) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0175, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "file names are not matched!");
        r2 = new java.io.File(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0183, code lost:
    
        if (r2.renameTo(r3) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0185, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to renameTo");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x018e, code lost:
    
        if (r2.delete() != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0190, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "can't delete the file!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x019a, code lost:
    
        throw new com.samsung.android.app.notes.sync.error.SyncException(307, "Failed to renameTo");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x019b, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x019c, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to downloadSDocFile!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a1, code lost:
    
        return r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f5 A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File m15180b(String str, C0009i c0009i) throws SyncException {
        String str2;
        File file;
        int i;
        String message;
        String str3 = c0009i.f38a;
        File file2 = null;
        int i2 = 0;
        ArrayList arrayListM5009b = null;
        while (true) {
            int i4 = i2 + 1;
            if (i2 >= 3) {
                str2 = str;
                break;
            }
            if (!this.f10380g.isCancelled()) {
                try {
                    str2 = str;
                } catch (SyncException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    arrayListM5009b = AbstractC6848m.m5009b(this.f10378e.f69j, str3, str2);
                } catch (SyncException e3) {
                    e = e3;
                    StringBuilder sbM15l = AbstractC0000a.m15l("Failed to downloadFile : ", str3, " in ");
                    sbM15l.append(((C13540g) C13541h.m14287e().f9588a).f9582d);
                    Debugger.m8616s("SyncOldNote$SyncSDoc", sbM15l.toString());
                    Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to downloadFile : " + i4 + " => " + e.getMessage());
                    try {
                        message = e.getMessage();
                    } catch (Exception unused) {
                        file = file2;
                    }
                    if (message != null) {
                        file = file2;
                        try {
                            int iIndexOf = message.indexOf(58, message.indexOf("rcode")) + 1;
                            i = Integer.parseInt(message.substring(iIndexOf, message.indexOf(44, iIndexOf)));
                        } catch (Exception unused2) {
                            Debugger.m8609e("SyncOldNote$SyncSDoc", "downloadSDocFile : can't parse the error!");
                            i = 0;
                            if (i == 79901) {
                                Debugger.m8609e("SyncOldNote$SyncSDoc", "[Sdoc] There is no " + str3);
                                return file;
                            }
                            if (e.getExceptionCode() != 307) {
                                throw e;
                            }
                            i2 = i4;
                            file2 = file;
                        }
                        if (i == 79901) {
                        }
                    } else {
                        file = file2;
                        i = 0;
                        if (i == 79901) {
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    StringBuilder sbM15l2 = AbstractC0000a.m15l("Failed to downloadFile : ", str3, " in ");
                    sbM15l2.append(((C13540g) C13541h.m14287e().f9588a).f9582d);
                    Debugger.m8616s("SyncOldNote$SyncSDoc", sbM15l2.toString());
                    Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to downloadFile : " + i4 + " => " + e.getMessage());
                }
                if (!arrayListM5009b.isEmpty()) {
                    break;
                }
                Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to downloadFile : " + i4);
                i2 = i4;
            } else {
                Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled downloadSDocFile");
                return file2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067 A[Catch: OutOfMemoryError -> 0x005c, PHI: r1
      0x0067: PHI (r1v4 int) = (r1v3 int), (r1v6 int), (r1v6 int) binds: [B:17:0x0060, B:7:0x0038, B:9:0x0049] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {OutOfMemoryError -> 0x005c, blocks: (B:3:0x000b, B:5:0x0010, B:6:0x001a, B:8:0x003a, B:10:0x004b, B:12:0x0056, B:18:0x0067, B:20:0x0078, B:17:0x0060, B:22:0x007e, B:24:0x009e), top: B:36:0x000b, inners: #1 }] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m15181c(File file, C0009i c0009i) {
        String str = c0009i.f38a;
        try {
            if (this.f10382i) {
                int sdocContractLockTypeNone = C0322h.m670a().f831q.getSdocContractLockTypeNone();
                try {
                    sdocContractLockTypeNone = SpenSdkCompat.with(this.f10378e.f262e).asSpenSDocFile().getDocumentType(file.getAbsolutePath());
                } catch (Exception e) {
                    Debugger.m8609e("SyncOldNote$SyncSDoc", e.toString());
                }
                if (sdocContractLockTypeNone != C0322h.m670a().f831q.getSdocContractLockTypeNone()) {
                    this.f10379f.getClass();
                    if (SystemPropertiesCompat.INSTANCE.getInstance().isLDUModel()) {
                        Debugger.m8615i("SyncOldNote$SyncSDoc", "ignore the downloaded lock note due to the LDU!");
                        if (!file.delete()) {
                            Debugger.m8609e("SyncOldNote$SyncSDoc", "failed to delete sdoc completeFile");
                            return false;
                        }
                    } else if (m15182d(null, Integer.valueOf(sdocContractLockTypeNone), "Failed to renameTo 2", c0009i, file, c0009i.f38a)) {
                        Debugger.m8607d("SyncOldNote$SyncSDoc", "Succeed to save valid note(update)");
                        return true;
                    }
                }
            } else {
                Debugger.m8615i("SyncOldNote$SyncSDoc", "isValidSdoc is false!");
                if (m15182d(Integer.valueOf(C0322h.m670a().f831q.getSdocContractNo()), null, "Failed to renameTo 3", c0009i, file, c0009i.f38a)) {
                    Debugger.m8615i("SyncOldNote$SyncSDoc", "Succeed to save invalid note(update)");
                    return true;
                }
            }
        } catch (OutOfMemoryError e2) {
            try {
                Debugger.m8612ef("SyncOldNote$SyncSDoc", "handleDownloadedSDocFile() : fail to perform , UUID : " + str + " , " + e2.getMessage());
                if (C0145c.m328m(0L, "SyncControlOutOfMemoryOldNote", str) == 0) {
                    C0145c.m308P(c0009i.f40c, "SyncControlOutOfMemoryOldNote", str);
                }
            } catch (Exception unused) {
                Debugger.m8609e("SyncOldNote$SyncSDoc", "handleDownloadedSDocFile() : fail to addOutOfMemoryOldNote");
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0233  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m15182d(Integer num, Integer num2, String str, C0009i c0009i, File file, String str2) throws SyncException {
        C0009i c0009i2;
        ArrayList arrayList;
        String filePath;
        NotesDocumentEntity notesDocumentEntityM9f;
        NotesDocumentEntity notesDocumentEntity;
        long lastModifiedAt;
        long j;
        String str3 = str2;
        String str4 = this.f10381h + c0009i.f39b.replaceAll(":", "_");
        File file2 = new File(str4);
        if (!file.renameTo(file2)) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", "failed to rename completeFile");
            if (!file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncSDoc", "failed to delete completeFile");
            }
            throw new SyncException(307, str);
        }
        C0012a c0012a = this.f10378e;
        Context context = c0012a.f262e;
        HashMap map = c0012a.f70k;
        HashMap map2 = c0012a.f73n;
        Context context2 = c0012a.f262e;
        C6748q c6748q = str3 != null ? new C6748q(context, str3) : null;
        NotesDocumentEntity notesDocumentEntity2 = c6748q.f4128a;
        NotesDocumentEntity notesDocumentEntity3 = c6748q.f4128a;
        if (notesDocumentEntity2 != null) {
            int isDeleted = (notesDocumentEntity2 == null || !"trash:///".equals(notesDocumentEntity2.getCategoryUuid())) ? 0 : notesDocumentEntity2.getIsDeleted();
            if (isDeleted == C0322h.m670a().f831q.getSdocContractYes()) {
                isDeleted = C0322h.m670a().f831q.getSdocContractNo();
            }
            C14433b c14433b = new C14433b(false);
            C0338f c0338f = new C0338f();
            c14433b.f10228b = c0338f;
            if (str3 != null) {
                notesDocumentEntityM9f = AbstractC0000a.m9f(context2, str3);
                AbstractC0000a.m18o(context2, context2, context2);
            } else {
                notesDocumentEntityM9f = null;
            }
            if (notesDocumentEntityM9f != null) {
                c0338f.f856a = notesDocumentEntityM9f;
            }
            c0338f.f856a.setFilePath(str4);
            c0338f.f856a.setUuid(str3);
            c0338f.f857b = false;
            c0338f.f856a.setRemoveActionLinkData(true);
            c14433b.m15042t(c0009i.f40c);
            c0338f.f858c = true;
            c0338f.f856a.setIsSynced(true);
            c0338f.f856a.setIsDirty(0);
            if (num != null) {
                Debugger.m8615i("SyncOldNote$SyncSDoc", "isDeleted state = " + num);
                c0338f.f856a.setIsDeleted(num.intValue());
                isDeleted = num.intValue();
            } else {
                AbstractC0000a.m0A(isDeleted, "deleted state = ", "SyncOldNote$SyncSDoc");
                c0338f.f856a.setIsDeleted(isDeleted);
            }
            if (num2 != null) {
                c0338f.f856a.setIsLock(num2.intValue());
            }
            if (!C0322h.m670a().f832r.saveDoc(context2, c14433b.m15035i())) {
                Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to saveDoc the note(update)");
                return false;
            }
            long jLongValue = notesDocumentEntity3 != null ? notesDocumentEntity3.getServerTimestamp().longValue() : 0L;
            long j2 = c0009i.f40c;
            if (notesDocumentEntity3 != null) {
                notesDocumentEntity = notesDocumentEntity3;
                lastModifiedAt = notesDocumentEntity3.getLastModifiedAt();
            } else {
                notesDocumentEntity = notesDocumentEntity3;
                lastModifiedAt = 0;
            }
            NotesDocumentEntity notesDocumentEntity4 = (str3 != null ? new C6748q(context2, str3) : null).f4128a;
            long lastModifiedAt2 = notesDocumentEntity4 != null ? notesDocumentEntity4.getLastModifiedAt() : 0L;
            NotesDocumentEntity notesDocumentEntity5 = notesDocumentEntity;
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j2, "[Converted] handleConvertedNote() : serverSDocSyncModifiedTime = ", " , localSDocSyncModifiedTime = ");
            sbM1323p.append(jLongValue);
            long j3 = jLongValue;
            AbstractC1038a.m1223x(sbM1323p, " , serverSDocLastModifiedAt = ", lastModifiedAt2, " , localSDocLastModifiedAt = ");
            sbM1323p.append(lastModifiedAt);
            Debugger.m8607d("SyncOldNote$SyncSDoc", sbM1323p.toString());
            if (j2 > j3) {
                C0003c c0003c = (C0003c) c0012a.f72m.get(str3);
                SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
                NotesDatabaseManager.getInstance().getSyncInfoDao();
                if (lastModifiedAt2 > lastModifiedAt) {
                    Debugger.m8615i("SyncOldNote$SyncSDoc", "[Converted] handleConvertedNote() : " + str3 + " is modified");
                    c0012a.f78s = true;
                    if (c0003c == null) {
                        syncNoteDataRepositoryCreateSyncNoteDataRepository.setLastMappedAt(str3, 0L);
                        Debugger.m8607d("SyncOldNote$SyncSDoc", "[Converted] handleConvertedNote() : lastMappedAt of " + str3 + " is 0");
                        NotesDataRepositoryFactory.newInstance(context2).createMappedDocumentRepository().delete(str3, j2);
                    } else if (c0009i.f40c == c0003c.f14b) {
                        syncNoteDataRepositoryCreateSyncNoteDataRepository.setLastMappedAt(str3, c0003c.f15c);
                        NotesDataRepositoryFactory.newInstance(context2).createMappedDocumentRepository().delete(str3, j2);
                    } else {
                        syncNoteDataRepositoryCreateSyncNoteDataRepository.setLastMappedAt(str3, 0L);
                        NotesDataRepositoryFactory.newInstance(context2).createMappedDocumentRepository().delete(str3, j2);
                    }
                } else {
                    Debugger.m8615i("SyncOldNote$SyncSDoc", "[Converted] handleConvertedNote() : " + str3 + " is restored");
                    NotesMappedDocumentRepository notesMappedDocumentRepositoryCreateMappedDocumentRepository = NotesDataRepositoryFactory.newInstance(context2).createMappedDocumentRepository();
                    if (c0003c != null) {
                        long j5 = c0003c.f15c;
                        if (c0009i.f40c == c0003c.f14b) {
                            syncNoteDataRepositoryCreateSyncNoteDataRepository.setLastMappedAt(str3, j5);
                            c0012a.f78s = true;
                            j = 0;
                            if (j5 != 0) {
                                notesMappedDocumentRepositoryCreateMappedDocumentRepository.delete(str3, j2);
                            }
                        } else {
                            j = 0;
                        }
                        if ((notesDocumentEntity5 != null ? notesDocumentEntity5.getLastMappedAt() : j) != j) {
                            notesMappedDocumentRepositoryCreateMappedDocumentRepository.delete(str3, notesDocumentEntity5 != null ? notesDocumentEntity5.getLastMappedAt() : j);
                        }
                    }
                }
            }
            if (isDeleted != C0322h.m670a().f831q.getSdocContractToRecycleBin()) {
                return true;
            }
            C0322h.m670a().f831q.recycleBinResolverUpdateTimeMoved(context2, str3, System.currentTimeMillis());
            return true;
        }
        int sdocContractNo = C0322h.m670a().f831q.getSdocContractNo();
        if (map.containsKey(str3)) {
            C0009i c0009i3 = (C0009i) map.get(str3);
            map.remove(str3);
            if (c0009i3 != null) {
                sdocContractNo = c0009i3.f42e;
            }
            c0009i2 = c0009i3;
        } else {
            c0009i2 = null;
        }
        if (map2.containsKey(str3)) {
            ArrayList arrayList2 = (ArrayList) map2.get(str3);
            map2.remove(str3);
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (sdocContractNo == C0322h.m670a().f831q.getSdocContractYes()) {
            sdocContractNo = C0322h.m670a().f831q.getSdocContractNo();
        }
        C14433b c14433b2 = new C14433b(5);
        ((C0338f) c14433b2.f10228b).f856a.setFilePath(str4);
        ((C0338f) c14433b2.f10228b).f856a.setUuid(str3);
        C0338f c0338f2 = (C0338f) c14433b2.f10228b;
        c0338f2.f857b = true;
        c0338f2.f856a.setRemoveActionLinkData(true);
        c14433b2.m15042t(c0009i.f40c);
        C0338f c0338f3 = (C0338f) c14433b2.f10228b;
        c0338f3.f858c = true;
        c0338f3.f856a.setIsSynced(true);
        ((C0338f) c14433b2.f10228b).f856a.setIsDirty(0);
        if (num != null) {
            ((C0338f) c14433b2.f10228b).f856a.setIsDeleted(num.intValue());
            sdocContractNo = num.intValue();
        } else {
            ((C0338f) c14433b2.f10228b).f856a.setIsDeleted(sdocContractNo);
        }
        if (num2 != null) {
            ((C0338f) c14433b2.f10228b).f856a.setIsLock(num2.intValue());
        }
        if (!C0322h.m670a().f832r.saveDoc(context2, c14433b2.m15035i())) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to save note(add)");
            if (!file2.exists() || file2.delete()) {
                return false;
            }
            Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to delete moveFile");
            return false;
        }
        if (c0009i2 == null) {
            Debugger.m8607d("SyncOldNote$SyncSDoc", "serverItem is null");
            C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str3, "1", C0322h.m670a().f831q.getSdocContractNo(), 0L);
        } else {
            Debugger.m8607d("SyncOldNote$SyncSDoc", "new extra data : ");
            if (C0322h.m670a().f831q.setNoteFavorite(context2, str3, c0009i2.f44g, true) <= 0) {
                Debugger.m8609e("SyncOldNote$SyncSDoc", "Fail to set favorite.");
            }
            if (notesDocumentEntity3 != null) {
                try {
                    filePath = notesDocumentEntity3.getFilePath();
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("Fail to save favorite to the file : "), "SyncOldNote$SyncSDoc");
                }
            } else {
                filePath = null;
            }
            if (filePath != null && !filePath.isEmpty() && SpenSDocFile.isFavorite(filePath) != c0009i2.f44g) {
                Debugger.m8607d("SyncOldNote$SyncSDoc", "Update favorite in file : isFavorite = " + c0009i2.f44g);
                SpenSdkCompat.with(context2).asSpenSDocFile().setFavorite(filePath, c0009i2.f44g);
            }
            if (C0322h.m670a().f829o.isExistCategory(context2, c0009i2.f45h) && C0322h.m670a().f829o.getCategoryDeleted(c0009i2.f45h) == C0322h.m670a().f831q.getSdocContractNo()) {
                int noteCategory = C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str3, c0009i2.f45h, C0322h.m670a().f831q.getSdocContractNo(), c0009i2.f46i);
                Debugger.m8616s("SyncOldNote$SyncSDoc", "Update category in server - deleted no");
                if (noteCategory <= 0) {
                    Debugger.m8609e("SyncOldNote$SyncSDoc", "Fail to set as a valid category.");
                } else {
                    Debugger.m8607d("SyncOldNote$SyncSDoc", "succeed to set as a valid category!");
                }
                str3 = str2;
            } else if (sdocContractNo == C0322h.m670a().f831q.getSdocContractNo()) {
                str3 = str2;
                int noteCategory2 = C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str3, "1", C0322h.m670a().f831q.getSdocContractNo(), c0009i2.f46i);
                Debugger.m8609e("SyncOldNote$SyncSDoc", "Update category " + c0009i2.f38a + " to 1 for note = " + str3);
                if (noteCategory2 <= 0) {
                    Debugger.m8609e("SyncOldNote$SyncSDoc", "Fail to set as 1 category.");
                } else {
                    Debugger.m8607d("SyncOldNote$SyncSDoc", "succeed to set as 1 category!");
                }
            } else {
                str3 = str2;
                int noteCategory3 = C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, str3, "trash:///", C0322h.m670a().f831q.getSdocContractNo(), c0009i2.f46i);
                Debugger.m8616s("SyncOldNote$SyncSDoc", "Update category in server - deleted ");
                if (noteCategory3 <= 0) {
                    Debugger.m8609e("SyncOldNote$SyncSDoc", "Fail to set as a valid category.");
                } else {
                    Debugger.m8607d("SyncOldNote$SyncSDoc", "succeed to set as a valid category!");
                }
            }
        }
        if (sdocContractNo == C0322h.m670a().f831q.getSdocContractToRecycleBin()) {
            C0322h.m670a().f831q.recycleBinResolverUpdateTimeMoved(context2, str3, System.currentTimeMillis());
        }
        if (arrayList == null) {
            Debugger.m8607d("SyncOldNote$SyncSDoc", "serverItem is null");
            return true;
        }
        int noteTagContentList = C0322h.m670a().f830p.setNoteTagContentList(context2, str3, arrayList, C0322h.m670a().f831q.getSdocContractNo());
        Debugger.m8616s("SyncOldNote$SyncSDoc", "Update tags in server : " + str3);
        if (noteTagContentList <= 0) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", "Fail to setNoteTagContentList");
        } else {
            Debugger.m8607d("SyncOldNote$SyncSDoc", "succeed to set");
        }
        Debugger.m8616s("SyncOldNote$SyncSDoc", "Update tags in server : " + str3);
        map2.remove(str3);
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:263|(1:265)(1:266)|267|(2:269|270)(1:271)|395|272|(4:274|(1:276)(1:277)|278|(4:280|281|438|247)(1:284))|285|286|402|287|305|281|438|247) */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x07ce, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x07d0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x07d2, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to uploadFile - " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x07ed, code lost:
    
        if (r0.getExceptionCode() == 312) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x07ef, code lost:
    
        r12.f261d = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x07fa, code lost:
    
        if (r0.getExceptionCode() == 501) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x07fc, code lost:
    
        r12.f259b = false;
        r12.f261d = false;
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "Recover the previous history for sdoc");
        p079T.AbstractC0299q.m616Z(java.lang.Long.parseLong("1464416139847"));
        p042J1.C0145c.m309Q(r13, java.lang.Boolean.TRUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x081a, code lost:
    
        if (r0.getExceptionCode() == 503) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x081c, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "There are duplicated sync paths in S Cloud!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0828, code lost:
    
        if (r0.getExceptionCode() == 504) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x082a, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", "There are a decryption error and pass it!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0832, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0833, code lost:
    
        r0 = "Failed to uploadFile -" + r0.getMessage();
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8609e("SyncOldNote$SyncSDoc", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x084f, code lost:
    
        throw new com.samsung.android.app.notes.sync.error.SyncException(304, r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x088c  */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5, types: [int] */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v97 */
    /* JADX WARN: Type inference failed for: r3v98 */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m15183e() throws SyncException {
        String str;
        String filePath;
        HashMap map;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C14523d c14523d;
        C14523d c14523d2;
        ArrayList arrayList5;
        String str2;
        boolean z;
        long j;
        long jLongValue;
        boolean z2;
        Iterator it;
        C14523d c14523d3;
        String str3;
        JSONObject jSONObjectM37a;
        String str4;
        long jLongValue2;
        long jMax;
        boolean z3;
        Iterator it2;
        HashMap map2;
        String str5;
        String str6;
        C0013b c0013b;
        Iterator it3;
        long jLongValue3;
        C14523d c14523d4 = this;
        C0013b c0013b2 = c14523d4.f10379f;
        InterfaceC14510a interfaceC14510a = c14523d4.f10380g;
        String str7 = "Cancelled SDoc";
        boolean z4 = false;
        if (interfaceC14510a.isCancelled()) {
            Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled SDoc");
            return false;
        }
        boolean zM401p = AbstractC0155m.m401p();
        String str8 = "device storage is full!";
        C0012a c0012a = c14523d4.f10378e;
        if (!zM401p) {
            c0012a.f259b = false;
            c0012a.f261d = false;
            c0012a.f258a = false;
            c0012a.f260c = false;
            throw new SyncException(323, "device storage is full!");
        }
        Debugger.m8607d("SyncOldNote$SyncSDoc", "Start to get local list ");
        List uUIDListByDirty = c0012a.f81v;
        Context context = c0012a.f262e;
        if (uUIDListByDirty == null) {
            uUIDListByDirty = C0322h.m670a().f831q.getUUIDListByDirty(context, C0322h.m670a().f831q.getSdocContractYes());
        }
        if (uUIDListByDirty == null) {
            Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to getUUIDList()");
            throw new SyncException(314, "Failed to getUUIDList()");
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it4 = uUIDListByDirty.iterator();
        while (true) {
            str = "trash:///";
            filePath = "";
            if (!it4.hasNext()) {
                break;
            }
            String str9 = (String) it4.next();
            NotesDocumentEntity notesDocumentEntity = (str9 != null ? new C6748q(context, str9) : null).f4128a;
            filePath = notesDocumentEntity != null ? notesDocumentEntity.getFilePath() : "";
            boolean z5 = z4;
            String strSubstring = (TextUtils.isEmpty(filePath) || !filePath.contains("/")) ? null : filePath.substring(filePath.lastIndexOf(47) + 1);
            if (notesDocumentEntity != null) {
                c0013b = c0013b2;
                it3 = it4;
                jLongValue3 = notesDocumentEntity.getServerTimestamp().longValue();
            } else {
                c0013b = c0013b2;
                it3 = it4;
                jLongValue3 = 0;
            }
            arrayList6.add(new C0009i((notesDocumentEntity == null || !"trash:///".equals(notesDocumentEntity.getCategoryUuid())) ? z5 : notesDocumentEntity.getIsDeleted(), Math.max(jLongValue3, notesDocumentEntity != null ? notesDocumentEntity.getCategoryServerTimeStamp().longValue() : 0L), str9, strSubstring));
            c0013b2 = c0013b;
            z4 = z5;
            it4 = it3;
        }
        boolean z6 = z4;
        C0013b c0013b3 = c0013b2;
        Debugger.m8615i("SyncOldNote$SyncSDoc", "Finish to get local list : " + arrayList6.size());
        c14523d4.f10383j = arrayList6;
        Debugger.m8607d("SyncOldNote$SyncSDoc", "getServerSDocArray start");
        try {
            ArrayList arrayList7 = c0012a.f80u;
            c0013b3.getClass();
            ArrayList arrayListM41g = C0013b.m41g(arrayList7);
            Debugger.m8615i("SyncOldNote$SyncSDoc", "Finish to get server list : " + arrayListM41g.size());
            Iterator it5 = arrayListM41g.iterator();
            while (true) {
                boolean zHasNext = it5.hasNext();
                map = c14523d4.f10384k;
                if (!zHasNext) {
                    break;
                }
                C0009i c0009i = (C0009i) it5.next();
                map.put(c0009i.f38a, c0009i);
            }
            if (interfaceC14510a.isCancelled()) {
                Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled SDoc");
                return z6;
            }
            if (DeviceUtils.isUnpackDevice()) {
                int size = c14523d4.f10383j.size();
                c14523d4.f10383j = (List) c14523d4.f10383j.stream().filter(new C0233e(25)).collect(Collectors.toCollection(new C2747a(26)));
                StringBuilder sbM778t = AbstractC0541b.m778t(size, "Excluding the files from the unpack. originalSize: ", ", after: ");
                sbM778t.append(c14523d4.f10383j.size());
                Debugger.m8607d("SyncOldNote$SyncSDoc", sbM778t.toString());
            }
            if (arrayListM41g.size() + c14523d4.f10383j.size() == 0) {
                AbstractC0153k.m376e("SyncOldNote$SyncSDoc", "Old Note : no server change!");
                Debugger.m8615i("SyncOldNote$SyncSDoc", "There is no sdoc to sync");
                return true;
            }
            Debugger.m8615i("SyncOldNote$SyncSDoc", "Start to compare");
            Iterator it6 = c14523d4.f10383j.iterator();
            while (true) {
                boolean zHasNext2 = it6.hasNext();
                arrayList = c14523d4.f10376c;
                arrayList2 = c14523d4.f10375b;
                arrayList3 = c14523d4.f10377d;
                arrayList4 = c14523d4.f10374a;
                if (!zHasNext2) {
                    break;
                }
                C0009i c0009i2 = (C0009i) it6.next();
                Iterator it7 = it6;
                String str10 = c0009i2.f38a;
                InterfaceC14510a interfaceC14510a2 = interfaceC14510a;
                int i = c0009i2.f42e;
                String str11 = filePath;
                C0009i c0009i3 = (C0009i) map.get(str10);
                if (c0009i3 != null) {
                    str6 = str8;
                    int i2 = c0009i3.f42e;
                    map.remove(c0009i3.f38a);
                    map2 = map;
                    str5 = str;
                    long j2 = c0009i2.f40c;
                    long j3 = c0009i3.f40c;
                    if (j3 > j2) {
                        if (i2 == C0322h.m670a().f831q.getSdocContractYes()) {
                            arrayList.add(c0009i3);
                        } else {
                            arrayList2.add(c0009i3);
                        }
                    } else if (j3 >= j2) {
                        C0322h.m670a().f831q.setNoteDirty(context, str10, C0322h.m670a().f831q.getSdocContractNo());
                    } else if (i != C0322h.m670a().f831q.getSdocContractYes()) {
                        arrayList4.add(c0009i2);
                    } else if (i2 == C0322h.m670a().f831q.getSdocContractYes()) {
                        arrayList.add(c0009i2);
                    } else {
                        arrayList3.add(c0009i2);
                    }
                } else {
                    map2 = map;
                    str5 = str;
                    str6 = str8;
                    if (i == C0322h.m670a().f831q.getSdocContractYes()) {
                        arrayList3.add(c0009i2);
                    } else {
                        String noteFilePath = C0322h.m670a().f831q.getNoteFilePath(context, str10);
                        if ((noteFilePath == null || noteFilePath.isEmpty()) ? z6 : AbstractC2322a.m1607A(noteFilePath)) {
                            arrayList4.add(c0009i2);
                        } else {
                            Debugger.m8609e("SyncOldNote$SyncSDoc", "Local is changed but no note data : " + str10 + ", isDeleted = " + i);
                        }
                    }
                }
                str = str5;
                it6 = it7;
                interfaceC14510a = interfaceC14510a2;
                str8 = str6;
                filePath = str11;
                map = map2;
                c14523d4 = this;
            }
            String str12 = str;
            InterfaceC14510a interfaceC14510a3 = interfaceC14510a;
            String str13 = str8;
            String str14 = filePath;
            Debugger.m8615i("SyncOldNote$SyncSDoc", "toUploadList : " + arrayList4.size() + ", toDeleteServerList : " + arrayList3.size());
            ArrayList<String> arrayList8 = new ArrayList();
            Debugger.m8607d("SyncOldNote$SyncSDoc", "Start to compare more");
            Iterator it8 = map.entrySet().iterator();
            while (it8.hasNext()) {
                Map.Entry entry = (Map.Entry) it8.next();
                C0009i c0009i4 = (C0009i) entry.getValue();
                String str15 = c0009i4.f38a;
                C6748q c6748q = str15 != null ? new C6748q(context, str15) : null;
                NotesDocumentEntity notesDocumentEntity2 = c6748q.f4128a;
                long jLongValue4 = notesDocumentEntity2 != null ? notesDocumentEntity2.getServerTimestamp().longValue() : 0L;
                Iterator it9 = it8;
                String str16 = str12;
                if (jLongValue4 != c0009i4.f40c) {
                    if (c0009i4.f42e == C0322h.m670a().f831q.getSdocContractYes()) {
                        Debugger.m8616s("SyncOldNote$SyncSDoc", "only server is deleted - ServerKey : " + ((String) entry.getKey()));
                        if (c6748q.f4128a != null ? true : z6) {
                            arrayList.add(c0009i4);
                        } else {
                            arrayList8.add(c0009i4.f38a);
                        }
                    } else {
                        arrayList2.add(c0009i4);
                    }
                }
                str12 = str16;
                it8 = it9;
            }
            String str17 = str12;
            Debugger.m8615i("SyncOldNote$SyncSDoc", "toDownloadList : " + arrayList2.size() + ", toDeleteLocalList : " + arrayList.size());
            HashMap map3 = c0012a.f70k;
            HashMap map4 = c0012a.f73n;
            int size2 = map3.size();
            for (String str18 : arrayList8) {
                if (map3.isEmpty()) {
                    break;
                }
                map3.remove(str18);
            }
            if (size2 > map3.size() && !c0012a.f76q) {
                c0012a.f76q = true;
            }
            int size3 = map4.size();
            for (String str19 : arrayList8) {
                if (map4.isEmpty()) {
                    break;
                }
                map4.remove(str19);
            }
            if (size3 > map4.size() && !c0012a.f77r) {
                c0012a.f77r = true;
            }
            if (arrayList3.size() + arrayList.size() + arrayList2.size() + arrayList4.size() <= 0) {
                Debugger.m8615i("SyncOldNote$SyncSDoc", "There is no sdoc item to sync");
                return true;
            }
            if (!arrayList.isEmpty()) {
                Debugger.m8615i("SyncOldNote$SyncSDoc", "deleteLocal() : " + arrayList.size());
                Iterator it10 = arrayList.iterator();
                while (it10.hasNext()) {
                    C0009i c0009i5 = (C0009i) it10.next();
                    String str20 = c0009i5.f38a;
                    Debugger.m8616s("SyncOldNote$SyncSDoc", "try to deleteSDoc - " + str20);
                    C6748q c6748q2 = str20 != null ? new C6748q(context, str20) : null;
                    NotesDocumentEntity notesDocumentEntity3 = c6748q2.f4128a;
                    long jLongValue5 = notesDocumentEntity3 != null ? notesDocumentEntity3.getServerTimestamp().longValue() : 0L;
                    NotesDocumentEntity notesDocumentEntity4 = c6748q2.f4128a;
                    long jLongValue6 = notesDocumentEntity4 != null ? notesDocumentEntity4.getCategoryServerTimeStamp().longValue() : 0L;
                    long j5 = jLongValue5;
                    long j6 = c0009i5.f40c;
                    if (j5 > j6) {
                        NotesDocumentEntity notesDocumentEntity5 = c6748q2.f4128a;
                        if (((notesDocumentEntity5 == null || !str17.equals(notesDocumentEntity5.getCategoryUuid())) ? z6 : notesDocumentEntity5.getIsDeleted()) != C0322h.m670a().f831q.getSdocContractYes()) {
                            arrayList4.add(c0009i5);
                        }
                    } else if (jLongValue6 > j6) {
                        NotesDocumentEntity notesDocumentEntity6 = c6748q2.f4128a;
                        if (((notesDocumentEntity6 == null || !str17.equals(notesDocumentEntity6.getCategoryUuid())) ? z6 : notesDocumentEntity6.getIsDeleted()) != C0322h.m670a().f831q.getSdocContractYes()) {
                            C0322h.m670a().f831q.setNoteServerTimeAndDirty(c0012a.f262e, str20, jLongValue6, C0322h.m670a().f831q.getSdocContractYes());
                            arrayList4.add(c0009i5);
                        }
                    } else {
                        Debugger.m8616s("SyncOldNote$SyncSDoc", "deleteSDoc - " + str20);
                        NotesDocumentEntity notesDocumentEntity7 = c6748q2.f4128a;
                        if (((notesDocumentEntity7 == null || !str17.equals(notesDocumentEntity7.getCategoryUuid())) ? z6 : notesDocumentEntity7.getIsDeleted()) == C0322h.m670a().f831q.getSdocContractYes()) {
                            SyncState.removeDontSyncOldNote(c0009i5.f38a);
                            C0322h.m670a().f831q.deleteSDocSync(context, str20, z6, "OldServer");
                        } else {
                            Debugger.m8615i("SyncOldNote$SyncSDoc", "[DEL] deleteLocal() : Ignore the deletion and Move " + str20 + " to the recycle bin currently");
                            SyncState.addDontSyncOldNote(str20, c0009i5.f40c);
                            C0322h.m670a().f831q.deleteSDoc(context, str20, 2, true);
                            it2 = it10;
                            C0322h.m670a().f831q.setNoteServerTimeAndDirty(c0012a.f262e, str20, c0009i5.f40c, C0322h.m670a().f831q.getSdocContractNo());
                            it10 = it2;
                            z6 = false;
                        }
                    }
                    it2 = it10;
                    it10 = it2;
                    z6 = false;
                }
                Debugger.m8607d("SyncOldNote$SyncSDoc", "deleteLocal() finish");
            }
            if (!arrayList3.isEmpty()) {
                C0158a.m407a().getClass();
                if (C0158a.m410f()) {
                    c14523d = this;
                } else {
                    Debugger.m8615i("SyncOldNote$SyncSDoc", "deleteServer() : " + arrayList3.size());
                    Iterator it11 = arrayList3.iterator();
                    while (true) {
                        if (!it11.hasNext()) {
                            c14523d = this;
                            Debugger.m8607d("SyncOldNote$SyncSDoc", "deleteServer() finish");
                            z3 = true;
                            break;
                        }
                        C0009i c0009i6 = (C0009i) it11.next();
                        if (interfaceC14510a3.isCancelled()) {
                            Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled SDoc");
                            z3 = false;
                            c14523d = this;
                            break;
                        }
                        String str21 = c0009i6.f38a;
                        Debugger.m8616s("SyncOldNote$SyncSDoc", "Delete Server Files - " + str21);
                        try {
                            try {
                                AbstractC6848m.m5008a(c0012a.f69j, str21, String.valueOf(c0009i6.f40c), new C13883h(this, str21, 8));
                            } catch (SyncException e) {
                                e = e;
                                AbstractC6670b.m4752m(e, new StringBuilder("Failed to deleteFile - "), "SyncOldNote$SyncSDoc");
                                throw e;
                            }
                        } catch (SyncException e2) {
                            e = e2;
                        }
                    }
                    if (!z3 && interfaceC14510a3.isCancelled()) {
                        Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled before uploading sDocs!");
                        return false;
                    }
                }
            }
            boolean zIsEmpty = arrayList4.isEmpty();
            String str22 = c14523d.f10381h;
            if (!zIsEmpty) {
                C0158a.m407a().getClass();
                if (C0158a.m410f()) {
                    c14523d2 = c14523d;
                    arrayList5 = arrayList2;
                    str2 = str13;
                } else {
                    Debugger.m8615i("SyncOldNote$SyncSDoc", "uploadSdoc() : " + arrayList4.size());
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Iterator it12 = arrayList4.iterator();
                    while (true) {
                        if (!it12.hasNext()) {
                            c14523d2 = c14523d;
                            arrayList5 = arrayList2;
                            str2 = str13;
                            Debugger.m8615i("SyncOldNote$SyncSDoc", "uploadSdoc() finish : tut = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                            z2 = true;
                            break;
                        }
                        C0009i c0009i7 = (C0009i) it12.next();
                        if (!AbstractC0155m.m401p()) {
                            c0012a.f259b = false;
                            c0012a.f261d = false;
                            throw new SyncException(323, str13);
                        }
                        String str23 = c0009i7.f38a;
                        String str24 = c0009i7.f39b;
                        C6741j c6741j = new C6741j(context, str23);
                        NotesDocumentEntity notesDocumentEntity8 = c6741j.f4107a.f4128a;
                        if ((notesDocumentEntity8 != null ? notesDocumentEntity8.getIsLock() : 0) == C0322h.m670a().f831q.getSdocContractLockTypeSdoc()) {
                            NotesDocumentEntity notesDocumentEntity9 = c6741j.f4107a.f4128a;
                            String lockAccountGuid = notesDocumentEntity9 != null ? notesDocumentEntity9.getLockAccountGuid() : str14;
                            String strM14294h = C13541h.m14287e().m14294h();
                            arrayList5 = arrayList2;
                            it = it12;
                            String strM331p = C0145c.m331p("UserIdForSync", "UserIdForLocalPasswordKey", null);
                            String str25 = ((C13540g) C13541h.m14287e().f9588a).f9582d;
                            if (TextUtils.isEmpty(strM14294h)) {
                                Debugger.m8609e("SyncOldNote$SyncSDoc", "uploadSdoc : " + str23 + " is locked but passed due to empty current guidHash");
                            } else if (LockUtils.isNoteOwner(lockAccountGuid, strM14294h, strM331p, str25) != 1) {
                                Debugger.m8615i("SyncOldNote$SyncSDoc", "uploadSdoc : " + str23 + " is locked and passed due to different account!!");
                                C0322h.m670a().f831q.setNoteDirty(context, str23, C0322h.m670a().f831q.getSdocContractNo());
                            }
                            c14523d = this;
                            arrayList2 = arrayList5;
                            it12 = it;
                        } else {
                            arrayList5 = arrayList2;
                            it = it12;
                        }
                        if (interfaceC14510a3.isCancelled()) {
                            Debugger.m8607d("SyncOldNote$SyncSDoc", str7);
                            c14523d2 = this;
                            str2 = str13;
                            z2 = false;
                            break;
                        }
                        Debugger.m8616s("SyncOldNote$SyncSDoc", "Upload Files - " + str23);
                        try {
                            try {
                                jSONObjectM37a = c0009i7.m37a();
                                str4 = str22 + str24;
                                Debugger.m8615i("SyncOldNote$SyncSDoc", "uploadFile - uuid:  " + str23 + " , name: " + str24);
                            } catch (SyncException e3) {
                                e = e3;
                                c14523d3 = this;
                                str3 = str7;
                            }
                            if (AbstractC0155m.m386a(str4)) {
                                NotesDocumentEntity notesDocumentEntity10 = c6741j.f4107a.f4128a;
                                long jLongValue7 = notesDocumentEntity10 != null ? notesDocumentEntity10.getServerTimestamp().longValue() : 0L;
                                NotesDocumentEntity notesDocumentEntity11 = c6741j.f4107a.f4128a;
                                if (notesDocumentEntity11 != null) {
                                    str3 = str7;
                                    jLongValue2 = notesDocumentEntity11.getCategoryServerTimeStamp().longValue();
                                } else {
                                    str3 = str7;
                                    jLongValue2 = 0;
                                }
                                try {
                                    jMax = Math.max(jLongValue7, jLongValue2);
                                } catch (SyncException e5) {
                                    e = e5;
                                    c14523d3 = this;
                                }
                                if (jMax == 0) {
                                    Debugger.m8614f("SyncOldNote$SyncSDoc", "try to uploadFile - serverTimestamp is 0");
                                    NotesDocumentEntity notesDocumentEntity12 = c6741j.f4107a.f4128a;
                                    jMax = notesDocumentEntity12 != null ? notesDocumentEntity12.getLastModifiedAt() : 0L;
                                    if (jMax == 0) {
                                        c0012a.f261d = false;
                                        Debugger.m8614f("SyncOldNote$SyncSDoc", "Fail to uploadFile - serverTimestamp is 0");
                                        c14523d = this;
                                        str7 = str3;
                                        arrayList2 = arrayList5;
                                        it12 = it;
                                    } else {
                                        C0322h.m670a().f831q.setNoteServerTime(context, str23, jMax);
                                    }
                                }
                                c0009i7.f40c = jMax;
                                c14523d3 = this;
                                AbstractC6848m.m5014g(c0012a.f69j, str4, str23, String.valueOf(jMax), jSONObjectM37a, new C2517b(6, c14523d3, c6741j, c0009i7, str23));
                                c14523d = c14523d3;
                                str7 = str3;
                                arrayList2 = arrayList5;
                                it12 = it;
                            } else {
                                new C14472b(12).mo4791d();
                                c0012a.f259b = false;
                                c0012a.f261d = false;
                                Debugger.m8609e("SyncOldNote$SyncSDoc", "Failed to uploadFile - >1G : " + str23);
                                c14523d = this;
                                arrayList2 = arrayList5;
                                it12 = it;
                            }
                        } catch (JSONException e6) {
                            e = e6;
                        }
                    }
                    if (!z2 && interfaceC14510a3.isCancelled()) {
                        Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled before downloading sDocs!");
                        return false;
                    }
                }
            }
            if (arrayList5.isEmpty()) {
                return true;
            }
            Debugger.m8615i("SyncOldNote$SyncSDoc", "downloadSdoc() : " + arrayList5.size());
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            Iterator it13 = arrayList5.iterator();
            long j7 = 0;
            long j8 = 0;
            int i4 = 0;
            int i5 = 0;
            while (it13.hasNext()) {
                C0009i c0009i8 = (C0009i) it13.next();
                i4++;
                if (!AbstractC0155m.m401p()) {
                    c0012a.f258a = false;
                    c0012a.f260c = false;
                    throw new SyncException(323, str2);
                }
                Iterator it14 = it13;
                String str26 = c0009i8.f38a;
                long j9 = jElapsedRealtime2;
                if (interfaceC14510a3.isCancelled()) {
                    Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled downloadSdoc");
                } else {
                    C6748q c6748q3 = str26 != null ? new C6748q(context, str26) : null;
                    int i6 = i5;
                    String str27 = str22;
                    Debugger.m8616s("SyncOldNote$SyncSDoc", "Download Files - " + str26);
                    NotesDocumentEntity notesDocumentEntity13 = c6748q3.f4128a;
                    if (notesDocumentEntity13 != null) {
                        j = j8;
                        jLongValue = notesDocumentEntity13.getServerTimestamp().longValue();
                    } else {
                        j = j8;
                        jLongValue = 0;
                    }
                    long j10 = j7;
                    if (jLongValue > c0009i8.f40c) {
                        StringBuilder sbM1323p = AbstractC1974b.m1323p(jLongValue, "ignore this file : newTime = ", " , item.getTimeStamp = ");
                        sbM1323p.append(c0009i8.f40c);
                        Debugger.m8615i("SyncOldNote$SyncSDoc", sbM1323p.toString());
                    } else {
                        try {
                            String strM397l = AbstractC0155m.m397l(str27);
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            if (UserManagerCompat.getInstance().isDigitalLegacyMode(context)) {
                                C0042g c0042gM78a = C0042g.m78a(context);
                                if (c0042gM78a.m79b()) {
                                    c0042gM78a.f186b.mo73j();
                                } else {
                                    Debugger.m8609e("SCRPCSettingManager", "notifySyncProgress() : fail!");
                                }
                            }
                            File fileM15180b = c14523d2.m15180b(strM397l, c0009i8);
                            if (fileM15180b != null) {
                                if (!fileM15180b.exists()) {
                                    throw new SyncException(307, "There is no completeFile!");
                                }
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime3;
                                if (c14523d2.m15179a(fileM15180b)) {
                                    if (C0322h.m670a().f831q.getNoteServerTime(context, str26) <= c0009i8.f40c) {
                                        long jElapsedRealtime5 = SystemClock.elapsedRealtime();
                                        if (c14523d2.m15181c(fileM15180b, c0009i8)) {
                                            long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime5;
                                            Debugger.m8607d("SyncOldNote$SyncSDoc", "try to setNoteServerTimeAndDirty");
                                            C0322h.m670a().f831q.setNoteServerTimeAndDirty(c0012a.f262e, str26, c0009i8.f40c, C0322h.m670a().f831q.getSdocContractNo());
                                            i5 = i6 + 1;
                                            long j11 = j10 + jElapsedRealtime4;
                                            StringBuilder sbM780v = AbstractC0541b.m780v("downloadSdoc() ", i5, str26, " [", " / ");
                                            sbM780v.append(i4);
                                            sbM780v.append(" / ");
                                            sbM780v.append(arrayList5.size());
                                            sbM780v.append("] dt = ");
                                            sbM780v.append(jElapsedRealtime4);
                                            sbM780v.append(" , ct = ");
                                            sbM780v.append(jElapsedRealtime6);
                                            Debugger.m8615i("SyncOldNote$SyncSDoc", sbM780v.toString());
                                            c14523d2 = this;
                                            j8 = j + jElapsedRealtime6;
                                            it13 = it14;
                                            str22 = str27;
                                            j7 = j11;
                                            jElapsedRealtime2 = j9;
                                        } else {
                                            Debugger.m8609e("SyncOldNote$SyncSDoc", "fail to save(update) note");
                                        }
                                    } else if (!fileM15180b.delete()) {
                                        Debugger.m8609e("SyncOldNote$SyncSDoc", "failed to delete sdoc completeFile");
                                    }
                                }
                            } else if (interfaceC14510a3.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled downloadSdoc");
                            }
                        } catch (SyncException e7) {
                            AbstractC6670b.m4752m(e7, new StringBuilder("Failed to downloadSDocFile -"), "SyncOldNote$SyncSDoc");
                            throw e7;
                        }
                    }
                    it13 = it14;
                    i5 = i6;
                    str22 = str27;
                    jElapsedRealtime2 = j9;
                    j8 = j;
                    j7 = j10;
                }
                z = false;
                break;
            }
            long jElapsedRealtime7 = SystemClock.elapsedRealtime();
            StringBuilder sbM1323p2 = AbstractC1974b.m1323p(j7, "downloadSdoc() finish : tdt = ", " , tct = ");
            sbM1323p2.append(j8);
            sbM1323p2.append(" , tt = ");
            sbM1323p2.append(jElapsedRealtime7 - jElapsedRealtime2);
            Debugger.m8615i("SyncOldNote$SyncSDoc", sbM1323p2.toString());
            z = true;
            if (z || !interfaceC14510a3.isCancelled()) {
                return true;
            }
            Debugger.m8607d("SyncOldNote$SyncSDoc", "Cancelled before finishing downloading sDocs!");
            return false;
        } catch (JSONException e8) {
            String str28 = "getServerSDocArray - downloadList - " + e8.getMessage();
            Debugger.m8609e("SyncOldNote$SyncSDoc", str28);
            throw new SyncException(304, str28);
        }
    }
}
