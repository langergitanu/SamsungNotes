package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0569d implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f965a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ResolvableFuture f966b;

    public /* synthetic */ C0569d(ResolvableFuture resolvableFuture, int i) {
        this.f965a = i;
        this.f966b = resolvableFuture;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f965a) {
            case 0:
                EnterpriseGlobalSearchSessionImpl.lambda$getSchemaAsync$1(this.f966b, (AppSearchResult) obj);
                break;
            case 1:
                GlobalSearchSessionImpl.lambda$getSchemaAsync$1(this.f966b, (AppSearchResult) obj);
                break;
            case 2:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture((AppSearchResult) obj, this.f966b);
                break;
            case 3:
                SearchSessionImpl.lambda$searchSuggestionAsync$3(this.f966b, (AppSearchResult) obj);
                break;
            case 4:
                SearchSessionImpl.lambda$getSchemaAsync$1(this.f966b, (AppSearchResult) obj);
                break;
            case 5:
                SearchSessionImpl.lambda$getStorageInfoAsync$8(this.f966b, (AppSearchResult) obj);
                break;
            case 6:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture((AppSearchResult) obj, this.f966b);
                break;
            case 7:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture((AppSearchResult) obj, this.f966b);
                break;
            case 8:
                SearchSessionImpl.lambda$setSchemaAsync$0(this.f966b, (AppSearchResult) obj);
                break;
            case 9:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture((AppSearchResult) obj, this.f966b);
                break;
            default:
                AppSearchResultToPlatformConverter.platformAppSearchResultToFuture((AppSearchResult) obj, this.f966b);
                break;
        }
    }
}
