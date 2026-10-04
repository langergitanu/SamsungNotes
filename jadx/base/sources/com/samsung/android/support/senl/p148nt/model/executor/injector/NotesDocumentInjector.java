package com.samsung.android.support.senl.p148nt.model.executor.injector;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.data.MdeDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.mde.NotesMdeRepository;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenWordDocRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NotesDocumentInjector {
    private static final String TAG = ModelLogger.createTag("NotesDocumentInjector");

    private NotesDocumentInjector() {
    }

    @NonNull
    public static <T extends ISpenDocument, E extends DocumentEntityContainer> NotesDocument<T> provide(@NonNull Context context, @NonNull DocumentRepository<T, ? extends DocumentEntityContainer> documentRepository) {
        String strCreateSavedPath;
        String str = "";
        if (documentRepository.getWritingMode() == 100) {
            strCreateSavedPath = NotesDocumentFileUtils.createPdfWriterSavePath(DocumentCacheUtils.getPDFWriterCacheFolder(context), documentRepository.getUuid());
        } else {
            strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(context, documentRepository.getUuid(), documentRepository.getSavePath(), ".sdocx");
            String str2 = TAG;
            DataLogger.m12307i(str2, "provide, savePath : " + DataLogger.getEncode(strCreateSavedPath));
            File file = new File(strCreateSavedPath);
            boolean z = documentRepository.getMode() == 10000;
            boolean zStartsWith = strCreateSavedPath.startsWith(WDocUtils.getNoteFilePath(context));
            boolean zExists = file.exists();
            StringBuilder sbM2230u = AbstractC2821a.m2230u("provide, externalConvert: ", ", isInternalNotePath: ", ", isExist: ", z, zStartsWith);
            sbM2230u.append(zExists);
            DataLogger.m12302d(str2, sbM2230u.toString());
            if (!z && !zStartsWith) {
                DataLogger.m12307i(str2, "provide, save path is not the doc internal storage");
                str = strCreateSavedPath;
                strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(context, ".sdocx");
            }
        }
        documentRepository.savePath(strCreateSavedPath);
        documentRepository.loadPath(str);
        NotesDocument<T> notesDocument = new NotesDocument<>(context, documentRepository);
        notesDocument.setLoadTime(System.currentTimeMillis(), "provide");
        notesDocument.setMdeDataSource(provideNotesMdeRepository());
        return notesDocument;
    }

    @NonNull
    public static <T extends ISpenDocument, E extends DocumentEntityContainer> NotesDocument<T> provideDummy(@NonNull Context context, @Nullable SpenSDocDataSource spenSDocDataSource, @Nullable String str, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12307i(TAG, "provideDummy, spenSDocDataSource : " + spenSDocDataSource + ", caller : " + str);
        if (spenSDocDataSource == null) {
            return new NotesDocument<>(context, SpenWordDocRepository.create(documentSubscriptionId));
        }
        NotesDocument<T> notesDocumentProvide = provide(context, spenSDocDataSource, spenSDocDataSource.getDocument().getDocumentRepository().mo22197clone().caller(str).documentSubscriptionId(documentSubscriptionId));
        notesDocumentProvide.setDoc(spenSDocDataSource.getSpenSDoc());
        return notesDocumentProvide;
    }

    @NonNull
    public static MdeDataSource provideNotesMdeRepository() {
        return new NotesMdeRepository("", "", "");
    }

    @Nullable
    public static <T extends ISpenDocument, E extends DocumentEntityContainer> NotesDocument<T> restoreCache(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        String str3 = TAG;
        DataLogger.m12302d(str3, "restoreCache, path: " + DataLogger.getEncode(str) + ", caller : " + str2);
        if (TextUtils.isEmpty(str) || !SpenSdkInitializer.initialize(context)) {
            return null;
        }
        DataLogger.m12308p(str3, "read parcelable cache - start");
        NotesDocument<T> notesDocument = (NotesDocument) DocumentCacheUtils.readParcelableFromFile(str, DocumentDataSource.class.getClassLoader());
        if (notesDocument != null) {
            notesDocument.setLoadTime(System.currentTimeMillis(), "restoreCache");
            notesDocument.getDocumentRepository().documentSubscriptionId(documentSubscriptionId);
        }
        DataLogger.m12308p(str3, "read parcelable cache - end");
        return notesDocument;
    }

    @NonNull
    public static <T extends ISpenDocument, E extends DocumentEntityContainer> NotesDocument<T> provide(@NonNull Context context, @NonNull SpenSDocDataSource spenSDocDataSource, @NonNull DocumentRepository<T, ? extends DocumentEntityContainer> documentRepository) {
        NotesDocument<T> notesDocumentProvide = provide(context, documentRepository);
        spenSDocDataSource.getDocument().copy(notesDocumentProvide);
        notesDocumentProvide.setLoadTime(System.currentTimeMillis(), "provide");
        return notesDocumentProvide;
    }
}
