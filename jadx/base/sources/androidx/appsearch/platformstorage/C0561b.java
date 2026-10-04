package androidx.appsearch.platformstorage;

import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.SetSchemaResponse;
import android.app.appsearch.StorageInfo;
import androidx.appsearch.platformstorage.converter.GenericDocumentToPlatformConverter;
import androidx.appsearch.platformstorage.converter.GetSchemaResponseToPlatformConverter;
import androidx.appsearch.platformstorage.converter.ResponseToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SetSchemaRequestToPlatformConverter;
import java.util.function.Function;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0561b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f963a;

    public /* synthetic */ C0561b(int i) {
        this.f963a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f963a) {
            case 0:
                return GenericDocumentToPlatformConverter.toJetpackGenericDocument((GenericDocument) obj);
            case 1:
                return GetSchemaResponseToPlatformConverter.toJetpackGetSchemaResponse((GetSchemaResponse) obj);
            case 2:
                return ResponseToPlatformConverter.toJetpackStorageInfo((StorageInfo) obj);
            default:
                return SetSchemaRequestToPlatformConverter.toJetpackSetSchemaResponse((SetSchemaResponse) obj);
        }
    }
}
