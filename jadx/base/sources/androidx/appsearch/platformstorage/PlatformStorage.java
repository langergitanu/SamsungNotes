package androidx.appsearch.platformstorage;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.EnterpriseGlobalSearchSession;
import android.content.Context;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appsearch.app.AppSearchEnvironmentFactory;
import androidx.appsearch.app.AppSearchSession;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.platformstorage.converter.SearchContextToPlatformConverter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
public final class PlatformStorage {
    static final Executor EXECUTOR = AppSearchEnvironmentFactory.getEnvironmentInstance().createCachedThreadPoolExecutor();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void createEnterpriseGlobalSearchSession(AppSearchManager appSearchManager, Executor executor, Consumer<AppSearchResult<EnterpriseGlobalSearchSession>> consumer) {
            appSearchManager.createEnterpriseGlobalSearchSession(executor, consumer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GlobalSearchContext {
        final Context mContext;
        final Executor mExecutor;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder {
            private final Context mContext;
            private Executor mExecutor;

            public Builder(Context context) {
                this.mContext = (Context) Preconditions.checkNotNull(context);
            }

            public GlobalSearchContext build() {
                if (this.mExecutor == null) {
                    this.mExecutor = PlatformStorage.EXECUTOR;
                }
                return new GlobalSearchContext(this.mContext, this.mExecutor);
            }

            public Builder setWorkerExecutor(Executor executor) {
                Preconditions.checkNotNull(executor);
                this.mExecutor = executor;
                return this;
            }
        }

        public GlobalSearchContext(Context context, Executor executor) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        public Context getContext() {
            return this.mContext;
        }

        public Executor getWorkerExecutor() {
            return this.mExecutor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SearchContext {
        final Context mContext;
        final String mDatabaseName;
        final Executor mExecutor;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder {
            private final Context mContext;
            private final String mDatabaseName;
            private Executor mExecutor;

            public Builder(Context context, String str) {
                this.mContext = (Context) Preconditions.checkNotNull(context);
                Preconditions.checkNotNull(str);
                if (str.contains("/")) {
                    throw new IllegalArgumentException("Database name cannot contain '/'");
                }
                this.mDatabaseName = str;
            }

            public SearchContext build() {
                if (this.mExecutor == null) {
                    this.mExecutor = PlatformStorage.EXECUTOR;
                }
                return new SearchContext(this.mContext, this.mDatabaseName, this.mExecutor);
            }

            public Builder setWorkerExecutor(Executor executor) {
                this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
                return this;
            }
        }

        public SearchContext(Context context, String str, Executor executor) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mDatabaseName = (String) Preconditions.checkNotNull(str);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        public Context getContext() {
            return this.mContext;
        }

        public String getDatabaseName() {
            return this.mDatabaseName;
        }

        public Executor getWorkerExecutor() {
            return this.mExecutor;
        }
    }

    private PlatformStorage() {
    }

    @RequiresApi(35)
    @SuppressLint({"WrongConstant"})
    public static ListenableFuture<androidx.appsearch.app.EnterpriseGlobalSearchSession> createEnterpriseGlobalSearchSessionAsync(GlobalSearchContext globalSearchContext) {
        if (Build.VERSION.SDK_INT < 35) {
            throw new UnsupportedOperationException("ENTERPRISE_GLOBAL_SEARCH_SESSION is not supported on this AppSearch implementation");
        }
        Preconditions.checkNotNull(globalSearchContext);
        AppSearchManager appSearchManagerM1025c = AbstractC0570e.m1025c(globalSearchContext.mContext.getSystemService(AbstractC0570e.m1033k()));
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        ApiHelperForV.createEnterpriseGlobalSearchSession(appSearchManagerM1025c, globalSearchContext.mExecutor, new C0571f(resolvableFutureCreate, globalSearchContext, 0));
        return resolvableFutureCreate;
    }

    @SuppressLint({"WrongConstant"})
    public static ListenableFuture<GlobalSearchSession> createGlobalSearchSessionAsync(GlobalSearchContext globalSearchContext) {
        Preconditions.checkNotNull(globalSearchContext);
        AppSearchManager appSearchManagerM1025c = AbstractC0570e.m1025c(globalSearchContext.mContext.getSystemService(AbstractC0570e.m1033k()));
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        appSearchManagerM1025c.createGlobalSearchSession(globalSearchContext.mExecutor, new C0571f(resolvableFutureCreate, globalSearchContext, 1));
        return resolvableFutureCreate;
    }

    @SuppressLint({"WrongConstant"})
    public static ListenableFuture<AppSearchSession> createSearchSessionAsync(SearchContext searchContext) {
        Preconditions.checkNotNull(searchContext);
        AppSearchManager appSearchManagerM1025c = AbstractC0570e.m1025c(searchContext.mContext.getSystemService(AbstractC0570e.m1033k()));
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        appSearchManagerM1025c.createSearchSession(SearchContextToPlatformConverter.toPlatformSearchContext(searchContext), searchContext.mExecutor, new C0572g(resolvableFutureCreate, searchContext));
        return resolvableFutureCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createEnterpriseGlobalSearchSessionAsync$2(ResolvableFuture resolvableFuture, GlobalSearchContext globalSearchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new EnterpriseGlobalSearchSessionImpl(AbstractC0560a.m867a(appSearchResult.getResultValue()), globalSearchContext.mExecutor, new FeaturesImpl(globalSearchContext.mContext)));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createGlobalSearchSessionAsync$1(ResolvableFuture resolvableFuture, GlobalSearchContext globalSearchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new GlobalSearchSessionImpl(AbstractC0570e.m1028f(appSearchResult.getResultValue()), globalSearchContext.mExecutor, new FeaturesImpl(globalSearchContext.mContext)));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createSearchSessionAsync$0(ResolvableFuture resolvableFuture, SearchContext searchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new SearchSessionImpl(AbstractC0570e.m1026d(appSearchResult.getResultValue()), searchContext.mExecutor, searchContext.mContext));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }
}
