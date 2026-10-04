package androidx.appsearch.platformstorage.converter;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.StorageInfo;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ResponseToPlatformConverter {
    private ResponseToPlatformConverter() {
    }

    public static StorageInfo toJetpackStorageInfo(android.app.appsearch.StorageInfo storageInfo) {
        Preconditions.checkNotNull(storageInfo);
        return new StorageInfo.Builder().setAliveNamespacesCount(storageInfo.getAliveNamespacesCount()).setAliveDocumentsCount(storageInfo.getAliveDocumentsCount()).setSizeBytes(storageInfo.getSizeBytes()).build();
    }
}
