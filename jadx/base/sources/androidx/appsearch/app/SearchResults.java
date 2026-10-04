package androidx.appsearch.app;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public interface SearchResults extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ListenableFuture<List<SearchResult>> getNextPageAsync();
}
