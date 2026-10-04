package com.samsung.android.support.senl.p148nt.model.collector.updater;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SDocSearchDataUpdater extends AbstractUpdater {
    private static final String TAG = CollectLogger.createTag("SDocSearchDataUpdater");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class Executor implements Runnable {
        private static final String TAG = CollectLogger.createTag("SDocSearchDataUpdater$Executor");

        private List<String> getUpdateList() {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = NotesDatabaseManager.getInstance().query(new SimpleSQLiteQuery("SELECT sdoc.UUID FROM sdoc WHERE sdoc.isDeleted != 1 AND sdoc.filePath LIKE '%.sdoc' AND sdoc.UUID NOT IN ( SELECT Distinct stroke.sdocUUID FROM stroke) "));
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("UUID")));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
                return arrayList;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        private boolean preRecognizeDocument(Context context, NotesDocumentEntity notesDocumentEntity) throws Throwable {
            SpenSDoc spenSDocMakeSpenSDoc;
            SpenNoteDoc spenNoteDocMakeSpenNoteDoc;
            ArrayList<SpenContentBase> contentList;
            SpenNoteDoc spenNoteDoc = null;
            boolean z = false;
            try {
                spenSDocMakeSpenSDoc = DocumentConstructor.makeSpenSDoc(context, notesDocumentEntity.getFilePath(), LockConstants.EXTRA_VALUE_LOCK_CONFIRMED, ToolConstructor.makeSDocLocker(context).getUserCode(), 4);
                try {
                    try {
                        contentList = spenSDocMakeSpenSDoc.getContentList();
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                    spenNoteDocMakeSpenNoteDoc = null;
                }
            } catch (Exception e2) {
                e = e2;
                spenSDocMakeSpenSDoc = null;
            } catch (Throwable th2) {
                th = th2;
                spenSDocMakeSpenSDoc = null;
                spenNoteDocMakeSpenNoteDoc = null;
            }
            if (contentList != null && !contentList.isEmpty()) {
                int i = context.getResources().getDisplayMetrics().widthPixels;
                int i2 = context.getResources().getDisplayMetrics().heightPixels;
                if (i2 < i) {
                    i = i2;
                }
                boolean z2 = false;
                for (SpenContentBase spenContentBase : contentList) {
                    try {
                        if (spenContentBase.getType() == 3) {
                            String attachedFile = ((SpenContentHandWriting) spenContentBase).getAttachedFile();
                            if (TextUtils.isEmpty(attachedFile)) {
                                continue;
                            } else {
                                spenNoteDocMakeSpenNoteDoc = DocumentConstructor.makeSpenNoteDoc(context, attachedFile, i, 0);
                                try {
                                    SpenPageDoc page = spenNoteDocMakeSpenNoteDoc.getPage(0);
                                    ArrayList<SpenSDoc.SearchData> searchData = spenSDocMakeSpenSDoc.getSearchData(new File(attachedFile).getName());
                                    if (searchData != null && !searchData.isEmpty()) {
                                        Iterator<SpenSDoc.SearchData> it = searchData.iterator();
                                        while (it.hasNext()) {
                                            CollectResolver.insertSDocSearchEntities(it.next(), notesDocumentEntity.getUuid(), page.getId());
                                            z2 = true;
                                        }
                                    }
                                    spenNoteDocMakeSpenNoteDoc.close(true);
                                } catch (Exception e3) {
                                    e = e3;
                                    z = z2;
                                    spenNoteDoc = spenNoteDocMakeSpenNoteDoc;
                                    DataLogger.m12303e(TAG, "preRecognizeDocument, exception : " + e.getMessage());
                                    if (spenNoteDoc != null) {
                                        try {
                                            spenNoteDoc.close(true);
                                        } catch (IOException e5) {
                                            AbstractC11014a.m12332q(e5, new StringBuilder("preRecognizeDocument, close noteDoc failed : "), TAG);
                                        }
                                    }
                                    if (spenSDocMakeSpenSDoc != null) {
                                        try {
                                            if (!spenSDocMakeSpenSDoc.isClosed()) {
                                                spenSDocMakeSpenSDoc.close(true);
                                            }
                                        } catch (IOException e6) {
                                            AbstractC11014a.m12332q(e6, new StringBuilder("preRecognizeDocument, close sdoc failed : "), TAG);
                                        }
                                    }
                                    z2 = z;
                                    DataLogger.m12302d(TAG, "preRecognizeDocument, result : " + z2);
                                    return z2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    Throwable th4 = th;
                                    if (spenNoteDocMakeSpenNoteDoc != null) {
                                        try {
                                            spenNoteDocMakeSpenNoteDoc.close(true);
                                        } catch (IOException e7) {
                                            AbstractC11014a.m12332q(e7, new StringBuilder("preRecognizeDocument, close noteDoc failed : "), TAG);
                                        }
                                    }
                                    if (spenSDocMakeSpenSDoc == null) {
                                        throw th4;
                                    }
                                    try {
                                        if (spenSDocMakeSpenSDoc.isClosed()) {
                                            throw th4;
                                        }
                                        spenSDocMakeSpenSDoc.close(true);
                                        throw th4;
                                    } catch (IOException e8) {
                                        AbstractC11014a.m12332q(e8, new StringBuilder("preRecognizeDocument, close sdoc failed : "), TAG);
                                        throw th4;
                                    }
                                }
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        z = z2;
                    }
                }
                try {
                    if (!spenSDocMakeSpenSDoc.isClosed()) {
                        spenSDocMakeSpenSDoc.close(true);
                    }
                } catch (IOException e10) {
                    AbstractC11014a.m12332q(e10, new StringBuilder("preRecognizeDocument, close sdoc failed : "), TAG);
                }
                DataLogger.m12302d(TAG, "preRecognizeDocument, result : " + z2);
                return z2;
            }
            DataLogger.m12302d(TAG, "preRecognizeDocument, empty content base.");
            try {
                if (spenSDocMakeSpenSDoc.isClosed()) {
                    return false;
                }
                spenSDocMakeSpenSDoc.close(true);
                return false;
            } catch (IOException e11) {
                AbstractC11014a.m12332q(e11, new StringBuilder("preRecognizeDocument, close sdoc failed : "), TAG);
                return false;
            }
        }

        private void recognizeDocument(Context context, NotesDocumentEntity notesDocumentEntity) {
            DataLogger.m12307i(TAG, "recognizeDocument : " + notesDocumentEntity.getUuid());
            NotesDataRepositoryFactory.newInstance(context).createDocumentRetryRepository().deleteByUuid(notesDocumentEntity.getUuid());
            if (preRecognizeDocument(context, notesDocumentEntity)) {
                return;
            }
            CollectTaskManager.getInstance().runCollect(new CollectParam.CollectParamBuilder().setUuid(notesDocumentEntity.getUuid()).setLastModifiedAt(notesDocumentEntity.getLastModifiedAt()).setTriggerType(ICollectParam.TriggerType.UPDATE.getValue()).setActionType(ICollectParam.ActionType.START.getValue()).setSourceType(ICollectParam.SourceType.OTHERS.getValue()).setLinkWith(ICollectParam.LinkWith.DEFAULT.getValue()).build());
        }

        private void updateRemains(SharedPreferencesCompat sharedPreferencesCompat, Set<String> set, @NonNull String str) {
            set.remove(str);
            sharedPreferencesCompat.putStringSet("KEY_RECOGNITION_SDOC_LIST", set);
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE");
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet(getUpdateList());
            DataLogger.m12307i(TAG, "execute, uuidSet size : " + linkedHashSet.size());
            if (!linkedHashSet.isEmpty()) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(linkedHashSet);
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                for (String str : linkedHashSet) {
                    if (!TextUtils.isEmpty(str)) {
                        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(str);
                        if (notesDocumentEntity == null) {
                            updateRemains(sharedPreferencesCompat, linkedHashSet2, str);
                        } else {
                            recognizeDocument(applicationContext, notesDocumentEntity);
                            updateRemains(sharedPreferencesCompat, linkedHashSet2, notesDocumentEntity.getUuid());
                        }
                    }
                }
            }
            DataLogger.m12307i(TAG, "execute - end");
            sharedPreferencesCompat.putInt("KEY_RECOGNIZE_SDOC", 1);
        }
    }

    private SDocSearchDataUpdater() {
        super(TAG);
    }

    public static void execute() {
        new SDocSearchDataUpdater().runExecutor();
    }

    private void runExecutor() {
        DataLogger.m12302d(TAG, "execute");
        this.mThreadPoolExecutor.execute(new Executor());
    }
}
