package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.common.util.LockFileUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenDocumentRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentService;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentRestoreUtils;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6747p {

    /* JADX INFO: renamed from: a */
    public final Context f4121a;

    /* JADX INFO: renamed from: c */
    public int f4123c;

    /* JADX INFO: renamed from: d */
    public DocumentSubscriptionId f4124d;

    /* JADX INFO: renamed from: e */
    public IDocumentServiceWrapper f4125e;

    /* JADX INFO: renamed from: f */
    public final AtomicBoolean f4126f;

    /* JADX INFO: renamed from: b */
    public final SyncSaveDocumentManager$DocumentServiceConnection f4122b = new SyncSaveDocumentManager$DocumentServiceConnection(this, 0);

    /* JADX INFO: renamed from: g */
    public final Object f4127g = new Object();

    public C6747p(Context context) {
        this.f4121a = context;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.f4126f = atomicBoolean;
        atomicBoolean.set(false);
    }

    /* JADX INFO: renamed from: a */
    public final void m4869a() {
        synchronized (this.f4127g) {
            try {
                if (this.f4125e != null) {
                    return;
                }
                SyncSaveDocumentManager$DocumentServiceConnection syncSaveDocumentManager$DocumentServiceConnection = this.f4122b;
                Context context = this.f4121a;
                if (context == null) {
                    Logger.m8703w("SyncSaveDocumentManager", "null context!");
                } else {
                    syncSaveDocumentManager$DocumentServiceConnection.setRequestDisconnect(false);
                    this.f4123c = Resources.getSystem().getDisplayMetrics().widthPixels;
                    context.bindService(new Intent(context, (Class<?>) NotesWordDocumentService.class), syncSaveDocumentManager$DocumentServiceConnection, 1);
                }
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100L);
                        if (this.f4126f.getAndSet(false)) {
                            return;
                        }
                    } catch (InterruptedException e) {
                        Logger.m8698e("SyncSaveDocumentManager", "Exception : " + e.toString());
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4870b() {
        synchronized (this.f4127g) {
            try {
                this.f4122b.setRequestDisconnect(true);
                IDocumentServiceWrapper iDocumentServiceWrapper = this.f4125e;
                if (iDocumentServiceWrapper != null) {
                    iDocumentServiceWrapper.unsubscribe();
                    this.f4125e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Context context = this.f4121a;
        if (context != null) {
            context.unbindService(this.f4122b);
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m4871c(String str) {
        synchronized (this.f4127g) {
            try {
                IDocumentServiceWrapper iDocumentServiceWrapper = this.f4125e;
                if (iDocumentServiceWrapper == null) {
                    Logger.m8703w("SyncSaveDocumentManager", "isReadyToReplaceOriginalDocument, mService is not connected yet");
                    return false;
                }
                return iDocumentServiceWrapper.askForReadyToReplaceOriginalDocument(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m4872d(String str, boolean z, NotesDocumentEntity notesDocumentEntity) throws IOException {
        NotesDocumentEntity notesDocumentEntityM9f;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int[] iArr = {3};
        C6744m c6744m = new C6744m(iArr, countDownLatch);
        DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> saveStrategy = SpenDocumentRepositoryFactory.newInstance(notesDocumentEntity.getUuid(), null, notesDocumentEntity.getFilePath(), "", "SyncSaveDocumentManager", this.f4124d).createWordDocRepository().setPageWidth(this.f4123c).setSaveStrategy(2050);
        NotesDocument notesDocument = new NotesDocument(this.f4121a, saveStrategy, false);
        notesDocument.setDirty(true);
        notesDocument.setNewDocument(z);
        ((WordDocumentEntityContainer) saveStrategy.getDocumentEntity()).setEntity(notesDocumentEntity);
        saveStrategy.setLockAccountGuid(notesDocumentEntity.getLockAccountGuid());
        boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(notesDocumentEntity.getUuid());
        Debugger.m8607d("SyncSaveDocumentManager", "openSdocxFile start");
        try {
            DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
            Context context = this.f4121a;
            SpenWordDocument spenWordDocumentOpenWordDocument = documentFileManager.openWordDocument(context, str, SpenDocumentDisplayUtils.getScreenWidth(context), 3000, true, true, zIsCoeditUuid);
            String uuid = notesDocumentEntity.getUuid();
            Context context2 = this.f4121a;
            if (((HashMap) C6903f.m5119c().f4476d).containsKey(uuid)) {
                if (uuid != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(context2, uuid);
                    AbstractC0000a.m18o(context2, context2, context2);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if (((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCorrupted() : 0) & 1) == 1) {
                    if (AbstractC0299q.m650u(uuid) == 0) {
                        Debugger.m8612ef("CorruptedNote", "isCorruptedDbState() : " + uuid + " wont be uploaded!");
                        C0145c.m308P(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : -1L, "SyncControlCorruptedNote", uuid);
                    }
                    if (!DocumentRestoreUtils.createCopyAndMoveToTrash(context2, uuid)) {
                        Logger.m8698e("SyncSaveDocumentManager", "handleCorruptedNoteState - fail to copy corrupted note");
                    }
                }
            }
            int lockTypeFromSdocx = LockFileUtils.getLockTypeFromSdocx(this.f4121a, spenWordDocumentOpenWordDocument);
            if (lockTypeFromSdocx == 2) {
                ((WordDocumentEntityContainer) saveStrategy.getDocumentEntity()).getEntity().setIsLock(2);
            } else if (lockTypeFromSdocx == 3) {
                ((WordDocumentEntityContainer) saveStrategy.getDocumentEntity()).getEntity().setIsLock(3);
            }
            notesDocument.setDoc(spenWordDocumentOpenWordDocument);
            saveStrategy.addSaveStrategy(524288);
            synchronized (this.f4127g) {
                try {
                    IDocumentServiceWrapper iDocumentServiceWrapper = this.f4125e;
                    if (iDocumentServiceWrapper == null) {
                        Logger.m8703w("SyncSaveDocumentManager", "save, mService is not connected yet");
                        return false;
                    }
                    iDocumentServiceWrapper.save(notesDocument, false, true, new C6743l(this, notesDocument, str, notesDocumentEntity, c6744m));
                    try {
                    } catch (InterruptedException e) {
                        Logger.m8698e("SyncSaveDocumentManager", e.toString());
                    }
                    if (!Thread.currentThread().isInterrupted()) {
                        countDownLatch.await();
                        int i = iArr[0];
                        if (i == 0) {
                            return true;
                        }
                        if (i == 1) {
                            throw new IOException("ERROR_DOCUMENT_SERVICE_ALREADY_CLOSED", new SyncException(506, "ERROR_DOCUMENT_SERVICE_ALREADY_CLOSED"));
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (SpenBoundFileNotFoundException unused) {
            throw new IOException("Failed to openSdocxFile due to SpenBoundFileNotFoundException", new SyncException(337, "Failed to openSdocxFile due to SpenBoundFileNotFoundException"));
        } catch (SpenUnsupportedTypeException e2) {
            SyncException syncException = new SyncException(337, "Failed to openSdocxFile due to SpenUnsupportedTypeException");
            syncException.setSpenUnsupportedTypeException(e2);
            throw new IOException("Failed to openSdocxFile due to SpenUnsupportedTypeException", syncException);
        } catch (SpenUnsupportedVersionException unused2) {
            throw new IOException("Failed to openSdocxFile due to SpenUnsupportedVersionException", new SyncException(12000, "Failed to openSdocxFile due to SpenUnsupportedVersionException"));
        } catch (IOException unused3) {
            throw new IOException("Failed to openSdocxFile", new SyncException(328, "Failed to openSdocxFile"));
        }
    }
}
