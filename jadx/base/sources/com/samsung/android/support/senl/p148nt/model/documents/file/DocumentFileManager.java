package com.samsung.android.support.senl.p148nt.model.documents.file;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.pen.recogengine.C7467a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.C9922a;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentFileManager {
    private static DocumentFileManager sInstance;
    private final Map<String, DocumentFileOperator> mDocumentFileOperators = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IOAction<T> {
        T operate();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NewAction<T> extends IOAction<T> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OpenAction<T> {
        T operate();
    }

    private DocumentFileManager() {
    }

    @NonNull
    private DocumentFileOperator addOperator(String str, DocumentFileOperation documentFileOperation) {
        DocumentFileOperator documentFileOperator;
        synchronized (this.mDocumentFileOperators) {
            try {
                documentFileOperator = this.mDocumentFileOperators.get(str);
                if (documentFileOperator == null) {
                    documentFileOperator = new DocumentFileOperator(str);
                    this.mDocumentFileOperators.put(str, documentFileOperator);
                }
                documentFileOperator.addOperation(documentFileOperation);
            } catch (Throwable th) {
                throw th;
            }
        }
        return documentFileOperator;
    }

    private <T> T execute(String str, OpenAction<T> openAction) {
        T tOperate;
        DocumentFileOperator documentFileOperatorAddOperator = addOperator(str, DocumentFileOperation.OPEN);
        synchronized (documentFileOperatorAddOperator.getLock()) {
            try {
                documentFileOperatorAddOperator.onStart();
                try {
                    tOperate = openAction.operate();
                } finally {
                    documentFileOperatorAddOperator.onEnd();
                    removeOperator(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tOperate;
    }

    public static synchronized DocumentFileManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DocumentFileManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$close$14(SpenWNote spenWNote, boolean z) {
        if (spenWNote.isClosed()) {
            return null;
        }
        spenWNote.close(z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$closeWordDocument$13(SpenWordDocument spenWordDocument, boolean z) {
        if (spenWordDocument.isClosed()) {
            return null;
        }
        spenWordDocument.close(z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$copy$15(String str, String str2) throws IOException {
        SpenWNote.makeFile(str, str2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$quickSave$9(SpenWNote spenWNote, String str) {
        spenWNote.quickSave(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$quickSaveWordDocument$10(SpenWordDocument spenWordDocument, String str) {
        spenWordDocument.quickSave(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$saveAsDirectory$7(SpenWNote spenWNote, String str) {
        spenWNote.saveAsDirectory(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$saveAsDirectory$8(SpenWNote spenWNote, String str, boolean z) throws IOException {
        spenWNote.saveAsDirectory(str, z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$saveWordDocument$12(SpenWordDocument spenWordDocument, String str) {
        spenWordDocument.save(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$snapSaveWordDocument$11(SpenWordDocument spenWordDocument, String str, boolean z) {
        spenWordDocument.snapSave(str, z);
        return null;
    }

    private void removeOperator(String str) {
        synchronized (this.mDocumentFileOperators) {
            try {
                DocumentFileOperator documentFileOperator = this.mDocumentFileOperators.get(str);
                if (documentFileOperator != null && documentFileOperator.isIdle()) {
                    this.mDocumentFileOperators.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public void close(@NonNull String str, @Nullable SpenWNote spenWNote, boolean z) {
        if (spenWNote == null) {
            return;
        }
        execute(str, DocumentFileOperation.CLOSE, new C7467a(spenWNote, 1, z));
    }

    @WorkerThread
    public void closeWordDocument(@NonNull String str, @Nullable SpenWordDocument spenWordDocument, boolean z) {
        if (spenWordDocument == null) {
            return;
        }
        execute(str, DocumentFileOperation.CLOSE, new C7467a(spenWordDocument, 2, z));
    }

    @WorkerThread
    public void copy(@NonNull String str, @NonNull String str2) {
        execute(str, DocumentFileOperation.COPY, new C0287e(str, str2, 25));
    }

    @WorkerThread
    public void delete(@NonNull String str, IOAction<Boolean> iOAction) {
        execute(str, DocumentFileOperation.DELETE, iOAction);
    }

    @WorkerThread
    public <T> T executeAction(@NonNull String str, IOAction<T> iOAction) {
        return (T) execute(str, DocumentFileOperation.EXECUTE_ACTION, iOAction);
    }

    @NonNull
    @WorkerThread
    public SpenWNote open(@NonNull Context context, @NonNull String str, int i, int i2, boolean z, boolean z2) {
        return (SpenWNote) execute(str, new C11448e(context, str, i, i2, z, z2, 1));
    }

    @NonNull
    @WorkerThread
    public SpenWordDocument openWordDocument(@NonNull Context context, @NonNull String str, int i, int i2, boolean z, boolean z2) {
        return (SpenWordDocument) execute(str, new C11448e(context, str, i, i2, z, z2, 0));
    }

    @WorkerThread
    public void quickSave(SpenWNote spenWNote, String str) {
        execute(str, DocumentFileOperation.SAVE_CACHE, new C11446c(str, spenWNote, 0));
    }

    @WorkerThread
    public void quickSaveWordDocument(SpenWordDocument spenWordDocument, String str) {
        execute(str, DocumentFileOperation.SAVE_CACHE, new C11445b(spenWordDocument, str, 1));
    }

    @WorkerThread
    public void saveAsDirectory(SpenWNote spenWNote, String str) {
        execute(str, DocumentFileOperation.SAVE, new C11446c(str, spenWNote, 1));
    }

    @WorkerThread
    public void saveWordDocument(SpenWordDocument spenWordDocument, String str) {
        execute(str, DocumentFileOperation.SAVE, new C11445b(spenWordDocument, str, 0));
    }

    @WorkerThread
    public void snapSaveWordDocument(SpenWordDocument spenWordDocument, String str, boolean z) {
        execute(str, DocumentFileOperation.SNAP_SAVE, new C11449f(spenWordDocument, str, 0, z));
    }

    @NonNull
    @WorkerThread
    public SpenWNote open(@NonNull final Context context, @NonNull String str, final SpenWNote.PageMode pageMode, final SpenWNote.Orientation orientation, final int i, final boolean z) {
        return (SpenWNote) execute(str, DocumentFileOperation.OPEN, new NewAction() { // from class: com.samsung.android.support.senl.nt.model.documents.file.g
            @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
            public final Object operate() {
                return DocumentConstructor.makeSpenWNote(context, pageMode, orientation, i, z);
            }
        });
    }

    @NonNull
    @WorkerThread
    public SpenWordDocument openWordDocument(@NonNull final Context context, @NonNull final String str, final SpenWNote.Orientation orientation, final int i, final SpenWNote.PageMode pageMode, final boolean z) {
        return (SpenWordDocument) execute(str, DocumentFileOperation.OPEN, new NewAction() { // from class: com.samsung.android.support.senl.nt.model.documents.file.d
            @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
            public final Object operate() {
                return SpenWordDocument.create(context, str, orientation, i, pageMode, z);
            }
        });
    }

    @WorkerThread
    public void saveAsDirectory(SpenWNote spenWNote, String str, boolean z) {
        execute(str, DocumentFileOperation.SAVE, new C11449f(spenWNote, str, 1, z));
    }

    @NonNull
    @WorkerThread
    public SpenWNote open(@NonNull Context context, @NonNull String str, int i, int i2, boolean z, boolean z2, boolean z3) {
        return (SpenWNote) execute(str, new C11444a(context, str, i, i2, z, z2, z3, 1));
    }

    @NonNull
    @WorkerThread
    public SpenWordDocument openWordDocument(@NonNull Context context, @NonNull String str, int i, int i2, boolean z, boolean z2, boolean z3) {
        return (SpenWordDocument) execute(str, new C11444a(context, str, i, i2, z, z2, z3, 0));
    }

    @NonNull
    @WorkerThread
    public SpenWNote open(Context context, String str, String str2) {
        return (SpenWNote) execute(str, new C9922a(context, str, str2));
    }

    private <T> T execute(String str, DocumentFileOperation documentFileOperation, IOAction<T> iOAction) {
        T tOperate;
        DocumentFileOperator documentFileOperatorAddOperator = addOperator(str, documentFileOperation);
        synchronized (documentFileOperatorAddOperator.getLock()) {
            try {
                documentFileOperatorAddOperator.onStart();
                try {
                    tOperate = iOAction.operate();
                } finally {
                    documentFileOperatorAddOperator.onEnd();
                    removeOperator(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tOperate;
    }
}
