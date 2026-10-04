package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.ReportSystemUsageRequest;
import android.app.appsearch.ReportUsageRequest;
import android.app.appsearch.exceptions.AppSearchException;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.AbstractC0573h;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class RequestToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addTakenActionGenericDocuments(PutDocumentsRequest.Builder builder, GenericDocument genericDocument) {
            try {
                builder.addTakenActionGenericDocuments(new GenericDocument[]{genericDocument});
            } catch (AppSearchException e) {
                throw new RuntimeException("Unexpected AppSearchException which should not be possible", e);
            }
        }
    }

    private RequestToPlatformConverter() {
    }

    public static GetByDocumentIdRequest toPlatformGetByDocumentIdRequest(androidx.appsearch.app.GetByDocumentIdRequest getByDocumentIdRequest) {
        Preconditions.checkNotNull(getByDocumentIdRequest);
        AbstractC0565b.m926D();
        GetByDocumentIdRequest.Builder builderAddIds = AbstractC0565b.m934h(getByDocumentIdRequest.getNamespace()).addIds(getByDocumentIdRequest.getIds());
        for (Map.Entry<String, List<String>> entry : getByDocumentIdRequest.getProjections().entrySet()) {
            builderAddIds.addProjection(entry.getKey(), entry.getValue());
        }
        return builderAddIds.build();
    }

    public static PutDocumentsRequest toPlatformPutDocumentsRequest(androidx.appsearch.app.PutDocumentsRequest putDocumentsRequest) {
        Preconditions.checkNotNull(putDocumentsRequest);
        PutDocumentsRequest.Builder builderM935i = AbstractC0565b.m935i();
        Iterator<androidx.appsearch.app.GenericDocument> it = putDocumentsRequest.getGenericDocuments().iterator();
        while (it.hasNext()) {
            builderM935i.addGenericDocuments(GenericDocumentToPlatformConverter.toPlatformGenericDocument(it.next()));
        }
        for (androidx.appsearch.app.GenericDocument genericDocument : putDocumentsRequest.getTakenActionGenericDocuments()) {
            if (Build.VERSION.SDK_INT >= 35) {
                ApiHelperForV.addTakenActionGenericDocuments(builderM935i, GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocument));
            } else {
                builderM935i.addGenericDocuments(GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocument));
            }
        }
        return builderM935i.build();
    }

    public static RemoveByDocumentIdRequest toPlatformRemoveByDocumentIdRequest(androidx.appsearch.app.RemoveByDocumentIdRequest removeByDocumentIdRequest) {
        Preconditions.checkNotNull(removeByDocumentIdRequest);
        AbstractC0573h.m1052D();
        return AbstractC0573h.m1063k(removeByDocumentIdRequest.getNamespace()).addIds(removeByDocumentIdRequest.getIds()).build();
    }

    public static ReportSystemUsageRequest toPlatformReportSystemUsageRequest(androidx.appsearch.app.ReportSystemUsageRequest reportSystemUsageRequest) {
        Preconditions.checkNotNull(reportSystemUsageRequest);
        AbstractC0565b.m947u();
        return AbstractC0565b.m939m(reportSystemUsageRequest.getPackageName(), reportSystemUsageRequest.getDatabaseName(), reportSystemUsageRequest.getNamespace(), reportSystemUsageRequest.getDocumentId()).setUsageTimestampMillis(reportSystemUsageRequest.getUsageTimestampMillis()).build();
    }

    public static ReportUsageRequest toPlatformReportUsageRequest(androidx.appsearch.app.ReportUsageRequest reportUsageRequest) {
        Preconditions.checkNotNull(reportUsageRequest);
        AbstractC0565b.m924B();
        return AbstractC0565b.m942p(reportUsageRequest.getNamespace(), reportUsageRequest.getDocumentId()).setUsageTimestampMillis(reportUsageRequest.getUsageTimestampMillis()).build();
    }
}
