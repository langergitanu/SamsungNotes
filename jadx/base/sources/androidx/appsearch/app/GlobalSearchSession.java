package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.observer.ObserverSpec;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public interface GlobalSearchSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest);

    Features getFeatures();

    @SuppressLint({"KotlinPropertyAccess"})
    ListenableFuture<GetSchemaResponse> getSchemaAsync(String str, String str2);

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default ListenableFuture<OpenBlobForReadResponse> openBlobForReadAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    void registerObserverCallback(String str, ObserverSpec observerSpec, Executor executor, ObserverCallback observerCallback);

    ListenableFuture<Void> reportSystemUsageAsync(ReportSystemUsageRequest reportSystemUsageRequest);

    SearchResults search(String str, SearchSpec searchSpec);

    void unregisterObserverCallback(String str, ObserverCallback observerCallback);
}
