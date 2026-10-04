package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public interface AppSearchSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default ListenableFuture<CommitBlobResponse> commitBlobAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(GetByDocumentIdRequest getByDocumentIdRequest);

    Features getFeatures();

    ListenableFuture<Set<String>> getNamespacesAsync();

    @SuppressLint({"KotlinPropertyAccess"})
    ListenableFuture<GetSchemaResponse> getSchemaAsync();

    ListenableFuture<StorageInfo> getStorageInfoAsync();

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default ListenableFuture<OpenBlobForReadResponse> openBlobForReadAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default ListenableFuture<OpenBlobForWriteResponse> openBlobForWriteAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    ListenableFuture<AppSearchBatchResult<String, Void>> putAsync(PutDocumentsRequest putDocumentsRequest);

    ListenableFuture<AppSearchBatchResult<String, Void>> removeAsync(RemoveByDocumentIdRequest removeByDocumentIdRequest);

    ListenableFuture<Void> removeAsync(String str, SearchSpec searchSpec);

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default ListenableFuture<RemoveBlobResponse> removeBlobAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    ListenableFuture<Void> reportUsageAsync(ReportUsageRequest reportUsageRequest);

    ListenableFuture<Void> requestFlushAsync();

    SearchResults search(String str, SearchSpec searchSpec);

    ListenableFuture<List<SearchSuggestionResult>> searchSuggestionAsync(String str, SearchSuggestionSpec searchSuggestionSpec);

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default ListenableFuture<Void> setBlobVisibilityAsync(SetBlobVisibilityRequest setBlobVisibilityRequest) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    ListenableFuture<SetSchemaResponse> setSchemaAsync(SetSchemaRequest setSchemaRequest);
}
