package androidx.appsearch.platformstorage;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchResult;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.platformstorage.converter.SearchResultToPlatformConverter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class SearchResultsImpl implements SearchResults {
    private final Executor mExecutor;
    private final android.app.appsearch.SearchResults mPlatformResults;
    private final SearchSpec mSearchSpec;

    public SearchResultsImpl(android.app.appsearch.SearchResults searchResults, SearchSpec searchSpec, Executor executor) {
        this.mPlatformResults = AbstractC0570e.m1032j(Preconditions.checkNotNull(searchResults));
        this.mSearchSpec = (SearchSpec) Preconditions.checkNotNull(searchSpec);
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNextPageAsync$0(ResolvableFuture resolvableFuture, AppSearchResult appSearchResult) {
        if (!appSearchResult.isSuccess()) {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
            return;
        }
        List list = (List) appSearchResult.getResultValue();
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 == 31 || i2 == 32) && i == 0 && !this.mSearchSpec.getFilterNamespaces().isEmpty() && !this.mSearchSpec.getFilterNamespaces().contains(AbstractC0570e.m1029g(list.get(i)).getGenericDocument().getNamespace())) {
                resolvableFuture.set(Collections.EMPTY_LIST);
                return;
            }
            arrayList.add(SearchResultToPlatformConverter.toJetpackSearchResult(AbstractC0570e.m1029g(list.get(i))));
        }
        resolvableFuture.set(arrayList);
    }

    @Override // androidx.appsearch.app.SearchResults, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mPlatformResults.close();
    }

    @Override // androidx.appsearch.app.SearchResults
    @SuppressLint({"WrongConstant"})
    public ListenableFuture<List<SearchResult>> getNextPageAsync() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mPlatformResults.getNextPage(this.mExecutor, new C0572g(this, resolvableFutureCreate));
        return resolvableFutureCreate;
    }
}
