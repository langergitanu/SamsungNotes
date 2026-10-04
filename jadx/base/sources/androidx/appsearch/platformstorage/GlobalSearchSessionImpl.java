package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.BatchResultCallback;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.exceptions.AppSearchException;
import android.app.appsearch.observer.DocumentChangeInfo;
import android.app.appsearch.observer.ObserverSpec;
import android.app.appsearch.observer.SchemaChangeInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.Features;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.app.ReportSystemUsageRequest;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.appsearch.platformstorage.converter.ObserverSpecToPlatformConverter;
import androidx.appsearch.platformstorage.converter.RequestToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SearchSpecToPlatformConverter;
import androidx.appsearch.platformstorage.util.BatchResultCallbackAdapter;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import p013C2.AbstractC0053a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class GlobalSearchSessionImpl implements GlobalSearchSession {
    private final Executor mExecutor;
    private final Features mFeatures;

    @GuardedBy("mObserverCallbacksLocked")
    private final Map<ObserverCallback, android.app.appsearch.observer.ObserverCallback> mObserverCallbacksLocked = new ArrayMap();
    private final android.app.appsearch.GlobalSearchSession mPlatformSession;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(33)
    public static class ApiHelperForT {
        private ApiHelperForT() {
        }

        @DoNotInline
        public static void getByDocumentId(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback batchResultCallback) {
            globalSearchSession.getByDocumentId(str, str2, getByDocumentIdRequest, executor, batchResultCallback);
        }

        @DoNotInline
        public static void getSchema(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
            globalSearchSession.getSchema(str, str2, executor, consumer);
        }

        @DoNotInline
        public static void registerObserverCallback(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, ObserverSpec observerSpec, Executor executor, android.app.appsearch.observer.ObserverCallback observerCallback) throws AppSearchException {
            globalSearchSession.registerObserverCallback(str, observerSpec, executor, observerCallback);
        }

        @DoNotInline
        public static void unregisterObserverCallback(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, android.app.appsearch.observer.ObserverCallback observerCallback) throws AppSearchException {
            globalSearchSession.unregisterObserverCallback(str, observerCallback);
        }
    }

    public GlobalSearchSessionImpl(android.app.appsearch.GlobalSearchSession globalSearchSession, Executor executor, Features features) {
        this.mPlatformSession = AbstractC0570e.m1028f(Preconditions.checkNotNull(globalSearchSession));
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mFeatures = (Features) Preconditions.checkNotNull(features);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSchemaAsync$1(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new C0561b(1));
    }

    @Override // androidx.appsearch.app.GlobalSearchSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mPlatformSession.close();
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(String str, String str2, androidx.appsearch.app.GetByDocumentIdRequest getByDocumentIdRequest) {
        if (Build.VERSION.SDK_INT < 33) {
            throw new UnsupportedOperationException("GLOBAL_SEARCH_SESSION_GET_BY_ID is not supported on this AppSearch implementation.");
        }
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(getByDocumentIdRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        ApiHelperForT.getByDocumentId(this.mPlatformSession, str, str2, RequestToPlatformConverter.toPlatformGetByDocumentIdRequest(getByDocumentIdRequest), this.mExecutor, new BatchResultCallbackAdapter(resolvableFutureCreate, new C0561b(0)));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public Features getFeatures() {
        return this.mFeatures;
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public ListenableFuture<androidx.appsearch.app.GetSchemaResponse> getSchemaAsync(String str, String str2) {
        if (Build.VERSION.SDK_INT < 33) {
            throw new UnsupportedOperationException("GLOBAL_SEARCH_SESSION_GET_SCHEMA is not supported on this AppSearch implementation.");
        }
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        ApiHelperForT.getSchema(this.mPlatformSession, str, str2, this.mExecutor, new C0569d(resolvableFutureCreate, 1));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public void registerObserverCallback(String str, androidx.appsearch.observer.ObserverSpec observerSpec, Executor executor, final ObserverCallback observerCallback) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(observerSpec);
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(observerCallback);
        if (Build.VERSION.SDK_INT < 33) {
            throw new UnsupportedOperationException("GLOBAL_SEARCH_SESSION_REGISTER_OBSERVER_CALLBACK is not supported on this AppSearch implementation");
        }
        synchronized (this.mObserverCallbacksLocked) {
            android.app.appsearch.observer.ObserverCallback observerCallbackM110b = AbstractC0053a.m110b(this.mObserverCallbacksLocked.get(observerCallback));
            if (observerCallbackM110b == null) {
                observerCallbackM110b = new android.app.appsearch.observer.ObserverCallback() { // from class: androidx.appsearch.platformstorage.GlobalSearchSessionImpl.1
                    public void onDocumentChanged(DocumentChangeInfo documentChangeInfo) {
                        observerCallback.onDocumentChanged(ObserverSpecToPlatformConverter.toJetpackDocumentChangeInfo(documentChangeInfo));
                    }

                    public void onSchemaChanged(SchemaChangeInfo schemaChangeInfo) {
                        observerCallback.onSchemaChanged(ObserverSpecToPlatformConverter.toJetpackSchemaChangeInfo(schemaChangeInfo));
                    }
                };
            }
            try {
                ApiHelperForT.registerObserverCallback(this.mPlatformSession, str, ObserverSpecToPlatformConverter.toPlatformObserverSpec(observerSpec), executor, observerCallbackM110b);
                this.mObserverCallbacksLocked.put(observerCallback, observerCallbackM110b);
            } catch (AppSearchException e) {
                throw new androidx.appsearch.exceptions.AppSearchException(e.getResultCode(), e.getMessage(), e.getCause());
            }
        }
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public ListenableFuture<Void> reportSystemUsageAsync(ReportSystemUsageRequest reportSystemUsageRequest) {
        Preconditions.checkNotNull(reportSystemUsageRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.reportSystemUsage(RequestToPlatformConverter.toPlatformReportSystemUsageRequest(reportSystemUsageRequest), this.mExecutor, new C0569d(resolvableFutureCreate, 2));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public SearchResults search(String str, SearchSpec searchSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSpec);
        return new SearchResultsImpl(this.mPlatformSession.search(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(searchSpec)), searchSpec, this.mExecutor);
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public void unregisterObserverCallback(String str, ObserverCallback observerCallback) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(observerCallback);
        if (Build.VERSION.SDK_INT < 33) {
            throw new UnsupportedOperationException("GLOBAL_SEARCH_SESSION_REGISTER_OBSERVER_CALLBACK is not supported on this AppSearch implementation");
        }
        synchronized (this.mObserverCallbacksLocked) {
            android.app.appsearch.observer.ObserverCallback observerCallbackM110b = AbstractC0053a.m110b(this.mObserverCallbacksLocked.get(observerCallback));
            if (observerCallbackM110b == null) {
                return;
            }
            try {
                ApiHelperForT.unregisterObserverCallback(this.mPlatformSession, str, observerCallbackM110b);
                this.mObserverCallbacksLocked.remove(observerCallback);
            } catch (AppSearchException e) {
                throw new androidx.appsearch.exceptions.AppSearchException(e.getResultCode(), e.getMessage(), e.getCause());
            }
        }
    }
}
