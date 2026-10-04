package com.samsung.android.support.senl.p148nt.model.restore.document;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import p012C1.CallableC0046b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DuplicatedDatabaseDetector {
    public static final String NEED_TO_BE_ARRANGED = "arrange_db";
    private static final String TAG;
    private static final Executor sExecutor;
    private final NotesDebugDao mNotesDebugDao = NotesDatabaseManager.getInstance().getDebugDao();
    private OnArrangeListener mOnArrangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnArrangeListener {
        void onFinish();

        void onStart();
    }

    static {
        String strCreateTag = ModelLogger.createTag("DuplicatedDatabaseDetector");
        TAG = strCreateTag;
        sExecutor = Executors.newFixedThreadPool(1, new SenlThreadFactory(strCreateTag));
    }

    public static void checkNeedToArrange() {
        String str = TAG;
        DataLogger.m12302d(str, "checkNeedToArrange");
        if (NotesDatabaseManager.getInstance().getDebugDao().existDirtyRows()) {
            DataLogger.m12305f(str, "checkNeedToArrange, need to arrange database");
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(NEED_TO_BE_ARRANGED, true);
        }
    }

    private void deleteDatabaseNotExist() {
        List<DocumentData> listDumpDocumentsForUsed = this.mNotesDebugDao.dumpDocumentsForUsed();
        ArrayList arrayList = new ArrayList();
        for (DocumentData documentData : listDumpDocumentsForUsed) {
            if (!new File(documentData.getFilePath()).exists()) {
                arrayList.add(documentData.getUuid());
            }
        }
        DataLogger.m12305f(TAG, "deleteDatabaseNotExist, count : " + arrayList.size());
        if (arrayList.isEmpty()) {
            return;
        }
        this.mNotesDebugDao.deleteNotes(arrayList);
    }

    private int deleteDuplicated() {
        DataLogger.m12305f(TAG, "deleteDuplicated, start");
        List<DocumentData> listDumpDocumentsForUsed = this.mNotesDebugDao.dumpDocumentsForUsed();
        ArrayList arrayList = new ArrayList();
        for (DocumentData documentData : listDumpDocumentsForUsed) {
            List<DocumentData> listFindRecentlyUsed = this.mNotesDebugDao.findRecentlyUsed(documentData.getFilePath());
            if (existDuplicatedPath(listFindRecentlyUsed.size())) {
                DataLogger.m12307i(TAG, "deleteDuplicated$findRecentlyUsed, path : " + DataLogger.getEncode(documentData.getFilePath()) + ", count : " + listFindRecentlyUsed.size());
                arrayList.add(new Pair(listFindRecentlyUsed.get(0).getUuid(), listFindRecentlyUsed.get(0).getFilePath()));
            }
        }
        DataLogger.m12305f(TAG, "deleteDuplicated, count : " + arrayList.size());
        NotesDatabaseManager.getInstance().runInTransaction(new RunnableC10960a(this, arrayList, 4));
        return arrayList.size();
    }

    private boolean existDuplicatedPath(int i) {
        return i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$deleteDuplicated$0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            this.mNotesDebugDao.deleteDocuments((String) pair.first, (String) pair.second);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$execute$1() {
        deleteDatabaseNotExist();
        return Integer.valueOf(deleteDuplicated());
    }

    public boolean execute() {
        if (!SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(NEED_TO_BE_ARRANGED, false)) {
            return false;
        }
        OnArrangeListener onArrangeListener = this.mOnArrangeListener;
        if (onArrangeListener != null) {
            onArrangeListener.onStart();
        }
        DataRepositoryScheduler.callable(new CallableC0046b(this, 4)).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).observe(new OnCompletionListener<Integer>() { // from class: com.samsung.android.support.senl.nt.model.restore.document.DuplicatedDatabaseDetector.1
            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onFail(@NonNull Exception exc) {
                DataLogger.m12305f(DuplicatedDatabaseDetector.TAG, "execute, fail : " + exc.getMessage());
                if (DuplicatedDatabaseDetector.this.mOnArrangeListener != null) {
                    DuplicatedDatabaseDetector.this.mOnArrangeListener.onFinish();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onComplete(@Nullable Integer num) {
                DataLogger.m12305f(DuplicatedDatabaseDetector.TAG, "execute, result : " + num);
                SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(DuplicatedDatabaseDetector.NEED_TO_BE_ARRANGED, false);
                if (DuplicatedDatabaseDetector.this.mOnArrangeListener != null) {
                    DuplicatedDatabaseDetector.this.mOnArrangeListener.onFinish();
                }
            }
        }).executeOn(sExecutor).execute();
        return true;
    }

    public DuplicatedDatabaseDetector setOnArrangeListener(OnArrangeListener onArrangeListener) {
        this.mOnArrangeListener = onArrangeListener;
        return this;
    }
}
