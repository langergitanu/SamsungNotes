package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.observer.ObserverSpec;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.observer.DocumentChangeInfo;
import androidx.appsearch.observer.SchemaChangeInfo;
import androidx.core.util.Preconditions;
import p013C2.AbstractC0053a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(33)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ObserverSpecToPlatformConverter {
    private ObserverSpecToPlatformConverter() {
    }

    public static DocumentChangeInfo toJetpackDocumentChangeInfo(android.app.appsearch.observer.DocumentChangeInfo documentChangeInfo) {
        Preconditions.checkNotNull(documentChangeInfo);
        return new DocumentChangeInfo(documentChangeInfo.getPackageName(), documentChangeInfo.getDatabaseName(), documentChangeInfo.getNamespace(), documentChangeInfo.getSchemaName(), documentChangeInfo.getChangedDocumentIds());
    }

    public static SchemaChangeInfo toJetpackSchemaChangeInfo(android.app.appsearch.observer.SchemaChangeInfo schemaChangeInfo) {
        Preconditions.checkNotNull(schemaChangeInfo);
        return new SchemaChangeInfo(schemaChangeInfo.getPackageName(), schemaChangeInfo.getDatabaseName(), schemaChangeInfo.getChangedSchemaNames());
    }

    public static ObserverSpec toPlatformObserverSpec(androidx.appsearch.observer.ObserverSpec observerSpec) {
        Preconditions.checkNotNull(observerSpec);
        return AbstractC0053a.m111c().addFilterSchemas(observerSpec.getFilterSchemas()).build();
    }
}
