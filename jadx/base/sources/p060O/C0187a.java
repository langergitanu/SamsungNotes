package p060O;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.importcore.strategy.MdeImportSingleTask;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p186h1.C12020a;

/* JADX INFO: renamed from: O.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0187a {

    /* JADX INFO: renamed from: a */
    public C0189c f587a;

    /* JADX INFO: renamed from: b */
    public InterfaceC0188b f588b;

    /* JADX WARN: Removed duplicated region for block: B:138:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m451a(C6747p c6747p) throws Throwable {
        NotesDocumentEntity notesDocumentEntity;
        boolean zM386a;
        Context context;
        List list;
        int i;
        long j;
        boolean zCopy;
        long lastModifiedAt;
        long createdAt;
        boolean z;
        boolean z2;
        NotesDocumentEntity notesDocumentEntity2;
        Throwable th;
        SpenSDoc spenSDoc;
        SpenSDoc spenSDoc2;
        SpenSDoc spenSDoc3;
        SpenSDoc spenSDoc4;
        Throwable th2;
        StringBuilder sb;
        SpenSDoc spenSDoc5;
        SpenSDoc spenSDoc6;
        SpenSDoc spenSDoc7;
        C0187a c0187a = this;
        Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", "perform()");
        C0189c c0189c = c0187a.f587a;
        Context context2 = c0189c.f589a;
        List list2 = c0189c.f594f;
        int size = list2.size();
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < size && !((MdeImportSingleTask) ((C12020a) c0187a.f588b).f8772b).isCancelled()) {
            if (!AbstractC0155m.m402q()) {
                throw new ShareException(ShareConstants$ResultCode.FAIL_DEVICE_STORAGE_FULL_EXCEPTION, "device storage is full!");
            }
            String str = (String) list2.get(i2);
            long currentTime = TimeManager.getCurrentTime(context2);
            if (str != null) {
                NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context2, str);
                AbstractC0000a.m18o(context2, context2, context2);
                notesDocumentEntity = notesDocumentEntityM9f;
            } else {
                notesDocumentEntity = null;
            }
            String filePath = notesDocumentEntity != null ? notesDocumentEntity.getFilePath() : null;
            if (filePath == null) {
                Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "file path is null ");
                context = context2;
                list = list2;
                i = i2;
            } else {
                try {
                    zM386a = AbstractC0155m.m386a(filePath);
                } catch (SyncException e) {
                    AbstractC6670b.m4752m(e, new StringBuilder("SyncException while checking canUpload. "), "MdeImportSingleTask$MdeImportSDoc");
                    zM386a = false;
                }
                String str2 = filePath.endsWith(".sdoc") ? ".sdoc" : filePath.endsWith(".sdocx") ? ".sdocx" : null;
                if (!zM386a || str2 == null) {
                    context = context2;
                    list = list2;
                    i = i2;
                    Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "file error ");
                } else {
                    list = list2;
                    String str3 = WDocUtils.getNoteFilePath(context2) + currentTime + str2;
                    i = i2;
                    String string = UUID.randomUUID().toString();
                    Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", "cloneSdocFileWithNewName()");
                    try {
                        zCopy = DocumentCopyUtils.copy(context2, filePath, str3);
                        j = currentTime;
                    } catch (IOException e2) {
                        j = currentTime;
                        AbstractC0000a.m20q(e2, new StringBuilder("fail to cloneSdocFileWithNewName : "), "MdeImportSingleTask$MdeImportSDoc");
                        zCopy = false;
                    }
                    if (zCopy) {
                        if (str2.equals(".sdocx")) {
                            SpenWNoteFile.setOwnerId(str3, "");
                            SpenWNoteFile.setDocumentType(str3, SpenWNote.DocumentType.UNLOCKED_DOC);
                        }
                        if (notesDocumentEntity != null) {
                            lastModifiedAt = notesDocumentEntity.getLastModifiedAt();
                            createdAt = notesDocumentEntity.getCreatedAt();
                        } else {
                            lastModifiedAt = 0;
                            createdAt = 0;
                        }
                        long j2 = lastModifiedAt;
                        long j3 = createdAt;
                        Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", "addNewImportedMdeFileToDB()");
                        try {
                            if (SpenSDocFile.isLocked(str3)) {
                                SpenSDocFile.unlock(str3, new SDocLocker(context2).getUserCode());
                            }
                            notesDocumentEntity2 = new NotesDocumentEntity();
                            notesDocumentEntity2.setUuid(string);
                            notesDocumentEntity2.setFilePath(str3);
                            notesDocumentEntity2.setServerTimestamp(Long.valueOf(j));
                            context = context2;
                            notesDocumentEntity2.getTimeSaveParam().setTime(Long.valueOf(j3), Long.valueOf(j2));
                            notesDocumentEntity2.setFirstOpendAt(System.currentTimeMillis());
                            notesDocumentEntity2.setMdeSpaceId(c0189c.f591c);
                            notesDocumentEntity2.setMdeGroupId(c0189c.f592d);
                            notesDocumentEntity2.setMdeOwnerId(c0189c.f593e);
                            z = false;
                            notesDocumentEntity2.setIsFavorite(0);
                            notesDocumentEntity2.setCategoryUuid(PredefinedCategory.SHARED_NOTE_BOOK.getUuid());
                            z2 = true;
                        } catch (Exception e3) {
                            context = context2;
                            z = false;
                            Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", e3.getMessage());
                        }
                        if (notesDocumentEntity2.isSdoc()) {
                            try {
                                Context context3 = c0189c.f589a;
                                SpenSDoc spenSDoc8 = new SpenSDoc(context3, str3, LockConstants.EXTRA_VALUE_LOCK_CONFIRMED, new SDocLocker(context3).getUserCode(), 0);
                                try {
                                    try {
                                        boolean zSave = DocumentWriteResolver.save(c0189c.f589a, true, str3, notesDocumentEntity2, spenSDoc8, (String) null, false, "MdeImportSingleTask$MdeImportSDoc");
                                        if (!spenSDoc8.isClosed()) {
                                            try {
                                                spenSDoc8.close(true);
                                            } catch (Exception e5) {
                                                AbstractC0000a.m21r(e5, new StringBuilder("Failed to close : "), "MdeImportSingleTask$MdeImportSDoc");
                                            }
                                        }
                                        z2 = zSave;
                                    } catch (SpenSDocInvalidPasswordException e6) {
                                        e = e6;
                                        spenSDoc7 = spenSDoc8;
                                        spenSDoc4 = spenSDoc7;
                                        Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "convert, SpenSDocInvalidPasswordException e : " + e.getMessage());
                                        if (spenSDoc4 != null && !spenSDoc4.isClosed()) {
                                            try {
                                                spenSDoc4.close(true);
                                            } catch (Exception e7) {
                                                e = e7;
                                                sb = new StringBuilder("Failed to close : ");
                                                AbstractC0000a.m21r(e, sb, "MdeImportSingleTask$MdeImportSDoc");
                                                z2 = z;
                                                if (z2) {
                                                }
                                                StringBuilder sbM778t = AbstractC0541b.m778t(i5, "import note file [", "/");
                                                sbM778t.append(i + 1);
                                                sbM778t.append("/");
                                                sbM778t.append(size);
                                                sbM778t.append("] : ");
                                                sbM778t.append(str);
                                                Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", sbM778t.toString());
                                                i2 = i + 1;
                                                c0187a = this;
                                                list2 = list;
                                                context2 = context;
                                            }
                                        }
                                        z2 = z;
                                    } catch (SpenSDocUnsupportedFileException e8) {
                                        e = e8;
                                        spenSDoc6 = spenSDoc8;
                                        spenSDoc3 = spenSDoc6;
                                        Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "convert, SpenSDocUnsupportedFileException e : " + e.getMessage());
                                        if (spenSDoc3 != null && !spenSDoc3.isClosed()) {
                                            try {
                                                spenSDoc3.close(true);
                                            } catch (Exception e9) {
                                                e = e9;
                                                sb = new StringBuilder("Failed to close : ");
                                                AbstractC0000a.m21r(e, sb, "MdeImportSingleTask$MdeImportSDoc");
                                                z2 = z;
                                                if (z2) {
                                                }
                                                StringBuilder sbM778t2 = AbstractC0541b.m778t(i5, "import note file [", "/");
                                                sbM778t2.append(i + 1);
                                                sbM778t2.append("/");
                                                sbM778t2.append(size);
                                                sbM778t2.append("] : ");
                                                sbM778t2.append(str);
                                                Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", sbM778t2.toString());
                                                i2 = i + 1;
                                                c0187a = this;
                                                list2 = list;
                                                context2 = context;
                                            }
                                        }
                                        z2 = z;
                                    } catch (SpenSDocUnsupportedVersionException e10) {
                                        e = e10;
                                        spenSDoc5 = spenSDoc8;
                                        spenSDoc = spenSDoc5;
                                        try {
                                            Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "convert, SpenSDocUnsupportedVersionExceptione : " + e.getMessage());
                                            if (spenSDoc != null && !spenSDoc.isClosed()) {
                                                try {
                                                    spenSDoc.close(true);
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    sb = new StringBuilder("Failed to close : ");
                                                    AbstractC0000a.m21r(e, sb, "MdeImportSingleTask$MdeImportSDoc");
                                                    z2 = z;
                                                    if (z2) {
                                                    }
                                                    StringBuilder sbM778t22 = AbstractC0541b.m778t(i5, "import note file [", "/");
                                                    sbM778t22.append(i + 1);
                                                    sbM778t22.append("/");
                                                    sbM778t22.append(size);
                                                    sbM778t22.append("] : ");
                                                    sbM778t22.append(str);
                                                    Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", sbM778t22.toString());
                                                    i2 = i + 1;
                                                    c0187a = this;
                                                    list2 = list;
                                                    context2 = context;
                                                }
                                            }
                                            z2 = z;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (spenSDoc == null) {
                                                throw th;
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e12) {
                                        e = e12;
                                        spenSDoc2 = spenSDoc8;
                                        try {
                                            Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "convert, e : " + e.getMessage());
                                            if (spenSDoc2 != null && !spenSDoc2.isClosed()) {
                                                try {
                                                    spenSDoc2.close(true);
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    sb = new StringBuilder("Failed to close : ");
                                                    AbstractC0000a.m21r(e, sb, "MdeImportSingleTask$MdeImportSDoc");
                                                    z2 = z;
                                                    if (z2) {
                                                    }
                                                    StringBuilder sbM778t222 = AbstractC0541b.m778t(i5, "import note file [", "/");
                                                    sbM778t222.append(i + 1);
                                                    sbM778t222.append("/");
                                                    sbM778t222.append(size);
                                                    sbM778t222.append("] : ");
                                                    sbM778t222.append(str);
                                                    Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", sbM778t222.toString());
                                                    i2 = i + 1;
                                                    c0187a = this;
                                                    list2 = list;
                                                    context2 = context;
                                                }
                                            }
                                            z2 = z;
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            th = th2;
                                            spenSDoc = spenSDoc2;
                                            if (spenSDoc == null || spenSDoc.isClosed()) {
                                                throw th;
                                            }
                                            try {
                                                spenSDoc.close(true);
                                                throw th;
                                            } catch (Exception e14) {
                                                AbstractC0000a.m21r(e14, new StringBuilder("Failed to close : "), "MdeImportSingleTask$MdeImportSDoc");
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        spenSDoc2 = spenSDoc8;
                                        th = th2;
                                        spenSDoc = spenSDoc2;
                                        if (spenSDoc == null) {
                                        }
                                    }
                                } catch (SpenSDocInvalidPasswordException e15) {
                                    e = e15;
                                    spenSDoc7 = spenSDoc8;
                                } catch (SpenSDocUnsupportedFileException e16) {
                                    e = e16;
                                    spenSDoc6 = spenSDoc8;
                                } catch (SpenSDocUnsupportedVersionException e17) {
                                    e = e17;
                                    spenSDoc5 = spenSDoc8;
                                } catch (IOException e18) {
                                    e = e18;
                                    spenSDoc2 = spenSDoc8;
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    spenSDoc2 = spenSDoc8;
                                }
                            } catch (SpenSDocInvalidPasswordException e19) {
                                e = e19;
                                spenSDoc4 = null;
                            } catch (SpenSDocUnsupportedFileException e20) {
                                e = e20;
                                spenSDoc3 = null;
                            } catch (SpenSDocUnsupportedVersionException e21) {
                                e = e21;
                                spenSDoc = null;
                            } catch (IOException e22) {
                                e = e22;
                                spenSDoc2 = null;
                            } catch (Throwable th7) {
                                th = th7;
                                spenSDoc = null;
                                if (spenSDoc == null) {
                                }
                            }
                            if (z2) {
                                i4++;
                            } else {
                                i5++;
                            }
                            StringBuilder sbM778t2222 = AbstractC0541b.m778t(i5, "import note file [", "/");
                            sbM778t2222.append(i + 1);
                            sbM778t2222.append("/");
                            sbM778t2222.append(size);
                            sbM778t2222.append("] : ");
                            sbM778t2222.append(str);
                            Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", sbM778t2222.toString());
                        } else {
                            try {
                                if (!c6747p.m4872d(str3, true, notesDocumentEntity2)) {
                                    Debugger.m8609e("MdeImportSingleTask$MdeImportSDoc", "fail to add the note");
                                    z2 = z;
                                }
                                if (z2) {
                                }
                                StringBuilder sbM778t22222 = AbstractC0541b.m778t(i5, "import note file [", "/");
                                sbM778t22222.append(i + 1);
                                sbM778t22222.append("/");
                                sbM778t22222.append(size);
                                sbM778t22222.append("] : ");
                                sbM778t22222.append(str);
                                Debugger.m8607d("MdeImportSingleTask$MdeImportSDoc", sbM778t22222.toString());
                            } catch (IOException e23) {
                                throw new ShareException(ShareConstants$ResultCode.FAIL_FILE_WRITE_EXCEPTION, e23.getMessage());
                            }
                        }
                    } else {
                        i4++;
                        context = context2;
                    }
                }
                i2 = i + 1;
                c0187a = this;
                list2 = list;
                context2 = context;
            }
            i2 = i + 1;
            c0187a = this;
            list2 = list;
            context2 = context;
        }
        Debugger.m8615i("MdeImportSingleTask$MdeImportSDoc", "successCount = " + i5 + " , failedCount = " + i4);
    }
}
