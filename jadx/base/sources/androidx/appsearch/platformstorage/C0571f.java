package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0571f implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f967a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ResolvableFuture f968b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ PlatformStorage.GlobalSearchContext f969c;

    public /* synthetic */ C0571f(ResolvableFuture resolvableFuture, PlatformStorage.GlobalSearchContext globalSearchContext, int i) {
        this.f967a = i;
        this.f968b = resolvableFuture;
        this.f969c = globalSearchContext;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f967a) {
            case 0:
                PlatformStorage.lambda$createEnterpriseGlobalSearchSessionAsync$2(this.f968b, this.f969c, (AppSearchResult) obj);
                break;
            default:
                PlatformStorage.lambda$createGlobalSearchSessionAsync$1(this.f968b, this.f969c, (AppSearchResult) obj);
                break;
        }
    }
}
