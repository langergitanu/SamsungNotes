package androidx.appsearch.platformstorage;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.SearchSuggestionResult;
import android.app.appsearch.SearchSuggestionSpec;
import android.content.Context;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.AppSearchSession;
import androidx.appsearch.app.Features;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.GetByDocumentIdRequest;
import androidx.appsearch.app.GetSchemaResponse;
import androidx.appsearch.app.PutDocumentsRequest;
import androidx.appsearch.app.RemoveByDocumentIdRequest;
import androidx.appsearch.app.ReportUsageRequest;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.app.SetSchemaRequest;
import androidx.appsearch.app.SetSchemaResponse;
import androidx.appsearch.app.StorageInfo;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.exceptions.IllegalSchemaException;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.appsearch.platformstorage.converter.RequestToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SearchSpecToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SearchSuggestionSpecToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SetSchemaRequestToPlatformConverter;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.appsearch.platformstorage.util.BatchResultCallbackAdapter;
import androidx.appsearch.platformstorage.util.SchemaValidationUtil;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import p066P2.C0200b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class SearchSessionImpl implements AppSearchSession {
    private final Context mContext;
    private final Executor mExecutor;
    private final Features mFeatures;
    private final android.app.appsearch.AppSearchSession mPlatformSession;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    public static class ApiHelperForU {
        private ApiHelperForU() {
        }

        @DoNotInline
        public static void searchSuggestion(android.app.appsearch.AppSearchSession appSearchSession, String str, SearchSuggestionSpec searchSuggestionSpec, Executor executor, Consumer<AppSearchResult<List<SearchSuggestionResult>>> consumer) {
            appSearchSession.searchSuggestion(str, searchSuggestionSpec, executor, consumer);
        }
    }

    public SearchSessionImpl(android.app.appsearch.AppSearchSession appSearchSession, Executor executor, Context context) {
        this.mPlatformSession = AbstractC0570e.m1026d(Preconditions.checkNotNull(appSearchSession));
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        Context context2 = (Context) Preconditions.checkNotNull(context);
        this.mContext = context2;
        this.mFeatures = new FeaturesImpl(context2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSchemaAsync$1(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new C0561b(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getStorageInfoAsync$8(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new C0561b(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAsync$6(ResolvableFuture resolvableFuture, SearchSpec searchSpec, String str, AppSearchResult appSearchResult) {
        if (!appSearchResult.isSuccess()) {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
            return;
        }
        try {
            Set set = (Set) appSearchResult.getResultValue();
            List<String> filterNamespaces = searchSpec.getFilterNamespaces();
            for (int i = 0; i < filterNamespaces.size(); i++) {
                if (set.contains(filterNamespaces.get(i))) {
                    this.mPlatformSession.remove(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(searchSpec), this.mExecutor, new C0569d(resolvableFuture, 9));
                    return;
                }
            }
            resolvableFuture.set(null);
        } catch (Throwable th) {
            resolvableFuture.setException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$searchSuggestionAsync$3(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new C0200b(9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setSchemaAsync$0(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new C0561b(3));
    }

    private boolean needsSchemaValidation() {
        long appSearchVersionCode = AppSearchVersionUtil.getAppSearchVersionCode(this.mContext);
        return appSearchVersionCode >= AppSearchVersionUtil.MainlineVersions.U_BASE && appSearchVersionCode < AppSearchVersionUtil.MainlineVersions.M2023_11;
    }

    @Override // androidx.appsearch.app.AppSearchSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mPlatformSession.close();
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(GetByDocumentIdRequest getByDocumentIdRequest) {
        Preconditions.checkNotNull(getByDocumentIdRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getByDocumentId(RequestToPlatformConverter.toPlatformGetByDocumentIdRequest(getByDocumentIdRequest), this.mExecutor, new BatchResultCallbackAdapter(resolvableFutureCreate, new C0561b(0)));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public Features getFeatures() {
        return this.mFeatures;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<Set<String>> getNamespacesAsync() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getNamespaces(this.mExecutor, new C0569d(resolvableFutureCreate, 7));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<GetSchemaResponse> getSchemaAsync() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getSchema(this.mExecutor, new C0569d(resolvableFutureCreate, 4));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<StorageInfo> getStorageInfoAsync() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getStorageInfo(this.mExecutor, new C0569d(resolvableFutureCreate, 5));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<AppSearchBatchResult<String, Void>> putAsync(PutDocumentsRequest putDocumentsRequest) {
        Preconditions.checkNotNull(putDocumentsRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.put(RequestToPlatformConverter.toPlatformPutDocumentsRequest(putDocumentsRequest), this.mExecutor, BatchResultCallbackAdapter.forSameValueType(resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<AppSearchBatchResult<String, Void>> removeAsync(RemoveByDocumentIdRequest removeByDocumentIdRequest) {
        Preconditions.checkNotNull(removeByDocumentIdRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.remove(RequestToPlatformConverter.toPlatformRemoveByDocumentIdRequest(removeByDocumentIdRequest), this.mExecutor, BatchResultCallbackAdapter.forSameValueType(resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<Void> reportUsageAsync(ReportUsageRequest reportUsageRequest) {
        Preconditions.checkNotNull(reportUsageRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.reportUsage(RequestToPlatformConverter.toPlatformReportUsageRequest(reportUsageRequest), this.mExecutor, new C0569d(resolvableFutureCreate, 10));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<Void> requestFlushAsync() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.set(null);
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public SearchResults search(String str, SearchSpec searchSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSpec);
        return new SearchResultsImpl(this.mPlatformSession.search(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(searchSpec)), searchSpec, this.mExecutor);
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<List<androidx.appsearch.app.SearchSuggestionResult>> searchSuggestionAsync(String str, androidx.appsearch.app.SearchSuggestionSpec searchSuggestionSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSuggestionSpec);
        if (Build.VERSION.SDK_INT < 34) {
            throw new UnsupportedOperationException("Search Suggestion is not supported on this AppSearch implementation.");
        }
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        ApiHelperForU.searchSuggestion(this.mPlatformSession, str, SearchSuggestionSpecToPlatformConverter.toPlatformSearchSuggestionSpec(searchSuggestionSpec), this.mExecutor, new C0569d(resolvableFutureCreate, 3));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.AppSearchSession
    public ListenableFuture<SetSchemaResponse> setSchemaAsync(SetSchemaRequest setSchemaRequest) {
        Preconditions.checkNotNull(setSchemaRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        if (needsSchemaValidation()) {
            try {
                SchemaValidationUtil.checkSchemasAreValidOrThrow(setSchemaRequest.getSchemas(), getFeatures().getMaxIndexedProperties());
            } catch (IllegalSchemaException e) {
                resolvableFutureCreate.setException(new AppSearchException(3, e.getMessage()));
                return resolvableFutureCreate;
            }
        }
        android.app.appsearch.AppSearchSession appSearchSession = this.mPlatformSession;
        android.app.appsearch.SetSchemaRequest platformSetSchemaRequest = SetSchemaRequestToPlatformConverter.toPlatformSetSchemaRequest(setSchemaRequest);
        Executor executor = this.mExecutor;
        appSearchSession.setSchema(platformSetSchemaRequest, executor, executor, new C0569d(resolvableFutureCreate, 8));
        return resolvableFutureCreate;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.appsearch.platformstorage.i] */
    @Override // androidx.appsearch.app.AppSearchSession
    @SuppressLint({"WrongConstant"})
    public ListenableFuture<Void> removeAsync(final String str, final SearchSpec searchSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSpec);
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        if (searchSpec.getJoinSpec() == null) {
            if (Build.VERSION.SDK_INT >= 33 || searchSpec.getFilterNamespaces().isEmpty()) {
                this.mPlatformSession.remove(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(searchSpec), this.mExecutor, new C0569d(resolvableFutureCreate, 6));
                return resolvableFutureCreate;
            }
            this.mPlatformSession.getNamespaces(this.mExecutor, new Consumer() { // from class: androidx.appsearch.platformstorage.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f973a.lambda$removeAsync$6(resolvableFutureCreate, searchSpec, str, (AppSearchResult) obj);
                }
            });
            return resolvableFutureCreate;
        }
        throw new IllegalArgumentException("JoinSpec not allowed in removeByQuery, but JoinSpec was provided.");
    }
}
