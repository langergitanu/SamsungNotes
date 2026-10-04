package com.samsung.android.support.senl.p148nt.model.repository.data.scheduler;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSchedulerDataSource;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentSchedulerRepository implements DocumentSchedulerDataSource {
    private static final String TAG = ModelLogger.createTag("DocumentSchedulerRepository");
    private final ExecutorService mExecutorService;

    public DocumentSchedulerRepository(@NonNull ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    public static DocumentSchedulerDataSource create(@NonNull ExecutorService executorService) {
        DataLogger.m12307i(TAG, "create, executorService : " + executorService);
        return new DocumentSchedulerRepository(executorService);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSchedulerDataSource
    @NonNull
    public ExecutorService getExecutorService() {
        DataLogger.m12307i(TAG, "getExecutorService, executorService : " + this.mExecutorService);
        return this.mExecutorService;
    }
}
