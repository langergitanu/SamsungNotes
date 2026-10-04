package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0572g implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f970a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ResolvableFuture f971b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f972c;

    public /* synthetic */ C0572g(SearchResultsImpl searchResultsImpl, ResolvableFuture resolvableFuture) {
        this.f972c = searchResultsImpl;
        this.f971b = resolvableFuture;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f970a) {
            case 0:
                ((SearchResultsImpl) this.f972c).lambda$getNextPageAsync$0(this.f971b, (AppSearchResult) obj);
                break;
            default:
                PlatformStorage.lambda$createSearchSessionAsync$0(this.f971b, (PlatformStorage.SearchContext) this.f972c, (AppSearchResult) obj);
                break;
        }
    }

    public /* synthetic */ C0572g(ResolvableFuture resolvableFuture, PlatformStorage.SearchContext searchContext) {
        this.f971b = resolvableFuture;
        this.f972c = searchContext;
    }
}
