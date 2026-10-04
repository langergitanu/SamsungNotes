package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.EnterpriseGlobalSearchSession;
import androidx.appsearch.app.Features;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.GetByDocumentIdRequest;
import androidx.appsearch.app.GetSchemaResponse;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.appsearch.platformstorage.converter.RequestToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SearchSpecToPlatformConverter;
import androidx.appsearch.platformstorage.util.BatchResultCallbackAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.concurrent.Executor;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(35)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class EnterpriseGlobalSearchSessionImpl implements EnterpriseGlobalSearchSession {
    private final Executor mExecutor;
    private final Features mFeatures;
    private final android.app.appsearch.EnterpriseGlobalSearchSession mPlatformSession;

    public EnterpriseGlobalSearchSessionImpl(android.app.appsearch.EnterpriseGlobalSearchSession enterpriseGlobalSearchSession, Executor executor, Features features) {
        this.mPlatformSession = AbstractC0560a.m867a(Preconditions.checkNotNull(enterpriseGlobalSearchSession));
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mFeatures = (Features) Preconditions.checkNotNull(features);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AppSearchBatchResult lambda$getByDocumentIdAsync$0(GetByDocumentIdRequest getByDocumentIdRequest, AppSearchBatchResult appSearchBatchResult) {
        if (getByDocumentIdRequest.getIds().isEmpty() || !appSearchBatchResult.getAll().isEmpty()) {
            return appSearchBatchResult;
        }
        AppSearchBatchResult.Builder builder = new AppSearchBatchResult.Builder();
        String namespace = getByDocumentIdRequest.getNamespace();
        for (String str : getByDocumentIdRequest.getIds()) {
            builder.setFailure(str, 6, AbstractC0541b.m775q("Document (", namespace, SQLKeyword.COMMA, str, ") not found."));
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSchemaAsync$1(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        AppSearchResultToPlatformConverter.platformAppSearchResultToFuture(appSearchResult, resolvableFuture, new C0561b(1));
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(String str, String str2, final GetByDocumentIdRequest getByDocumentIdRequest) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(getByDocumentIdRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getByDocumentId(str, str2, RequestToPlatformConverter.toPlatformGetByDocumentIdRequest(getByDocumentIdRequest), this.mExecutor, new BatchResultCallbackAdapter(resolvableFutureCreate, new C0561b(0), new Function() { // from class: androidx.appsearch.platformstorage.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return EnterpriseGlobalSearchSessionImpl.lambda$getByDocumentIdAsync$0(getByDocumentIdRequest, (AppSearchBatchResult) obj);
            }
        }));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public Features getFeatures() {
        return this.mFeatures;
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public ListenableFuture<GetSchemaResponse> getSchemaAsync(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformSession.getSchema(str, str2, this.mExecutor, new C0569d(resolvableFutureCreate, 0));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.EnterpriseGlobalSearchSession
    public SearchResults search(String str, SearchSpec searchSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSpec);
        return new SearchResultsImpl(this.mPlatformSession.search(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(searchSpec)), searchSpec, this.mExecutor);
    }
}
