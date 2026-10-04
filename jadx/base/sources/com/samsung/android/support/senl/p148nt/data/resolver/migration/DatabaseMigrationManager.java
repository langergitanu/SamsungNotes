package com.samsung.android.support.senl.p148nt.data.resolver.migration;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion47;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DatabaseMigrationManager {
    private static final String TAG;
    private static final Executor sExecutor;
    private final Callable<Boolean> mCallable = new Callable<Boolean>() { // from class: com.samsung.android.support.senl.nt.data.resolver.migration.DatabaseMigrationManager.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            SupportSQLiteDatabase writableDatabase = NotesDatabaseManager.getWritableDatabase();
            DataLogger.m12302d(DatabaseMigrationManager.TAG, "execute#call, start");
            List<Pair<Integer, Integer>> listExecuteTextSearchMigrationReturningIndex = MigrationToVersion47.executeTextSearchMigrationReturningIndex(writableDatabase);
            if (DatabaseMigrationManager.this.checkMigration(writableDatabase, listExecuteTextSearchMigrationReturningIndex)) {
                DatabaseMigrationManager.enableSeparateSearchData(false);
                return Boolean.TRUE;
            }
            DataLogger.m12302d(DatabaseMigrationManager.TAG, "execute#call, end - result : " + listExecuteTextSearchMigrationReturningIndex);
            return Boolean.valueOf(listExecuteTextSearchMigrationReturningIndex.isEmpty());
        }
    };
    private final OnCompletionListener<Boolean> mOnCompletionListener = new OnCompletionListener<Boolean>() { // from class: com.samsung.android.support.senl.nt.data.resolver.migration.DatabaseMigrationManager.2
        @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
        public void onFail(@NonNull Exception exc) {
            AbstractC11014a.m12333r(exc, new StringBuilder("execute, e : "), DatabaseMigrationManager.TAG);
            if (DatabaseMigrationManager.this.mOnMigrationListener != null) {
                DatabaseMigrationManager.this.mOnMigrationListener.onFinish();
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
        public void onComplete(@Nullable Boolean bool) {
            DataLogger.m12302d(DatabaseMigrationManager.TAG, "execute, result : " + bool);
            if (bool != null && bool.booleanValue()) {
                DatabaseMigrationManager.enableSeparateSearchData(false);
            }
            if (DatabaseMigrationManager.this.mOnMigrationListener != null) {
                DatabaseMigrationManager.this.mOnMigrationListener.onFinish();
            }
        }
    };
    private OnMigrationListener mOnMigrationListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnMigrationListener {
        void onFinish();

        void onStart();
    }

    static {
        String strCreateTag = DataLogger.createTag("DatabaseMigrationManager");
        TAG = strCreateTag;
        sExecutor = Executors.newFixedThreadPool(1, new SenlThreadFactory(strCreateTag));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enableSeparateSearchData(boolean z) {
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(MigrationToVersion47.PREF_KEY_SEPARATE_SEARCH_DATA, z);
    }

    public static boolean needToSeparateSearchData() {
        return SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(MigrationToVersion47.PREF_KEY_SEPARATE_SEARCH_DATA, false);
    }

    @VisibleForTesting
    public boolean checkMigration(SupportSQLiteDatabase supportSQLiteDatabase, List<Pair<Integer, Integer>> list) {
        return MigrationToVersion47.checkMaxRetryTextSearchMigration(supportSQLiteDatabase, list);
    }

    public boolean execute() {
        String str = TAG;
        DataLogger.m12302d(str, "execute, start");
        if (!needToSeparateSearchData()) {
            DataLogger.m12302d(str, "execute, do not need to separate");
            return false;
        }
        OnMigrationListener onMigrationListener = this.mOnMigrationListener;
        if (onMigrationListener != null) {
            onMigrationListener.onStart();
        }
        DataRepositoryScheduler.callable(this.mCallable).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).observe(this.mOnCompletionListener).executeOn(sExecutor).execute();
        return true;
    }

    @VisibleForTesting
    public Callable<Boolean> getCallable() {
        return this.mCallable;
    }

    @VisibleForTesting
    public OnCompletionListener<Boolean> getCompletionListener() {
        return this.mOnCompletionListener;
    }

    public DatabaseMigrationManager setOnMigrationListener(@Nullable OnMigrationListener onMigrationListener) {
        this.mOnMigrationListener = onMigrationListener;
        return this;
    }
}
