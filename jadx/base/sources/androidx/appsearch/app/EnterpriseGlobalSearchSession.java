package androidx.appsearch.app;

import android.annotation.SuppressLint;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public interface EnterpriseGlobalSearchSession {
    ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest);

    Features getFeatures();

    @SuppressLint({"KotlinPropertyAccess"})
    ListenableFuture<GetSchemaResponse> getSchemaAsync(String str, String str2);

    SearchResults search(String str, SearchSpec searchSpec);
}
