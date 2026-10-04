package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.PackageIdentifier;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;

/* JADX INFO: renamed from: androidx.appsearch.platformstorage.converter.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0568e {
    /* JADX INFO: renamed from: b */
    public static /* synthetic */ PackageIdentifier m994b(String str, byte[] bArr) {
        return new PackageIdentifier(str, bArr);
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ SearchSpec.Builder m995c() {
        return new SearchSpec.Builder();
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ SetSchemaRequest.Builder m999g() {
        return new SetSchemaRequest.Builder();
    }

    /* JADX INFO: renamed from: k */
    public static /* bridge */ /* synthetic */ SetSchemaResponse.MigrationFailure m1003k(Object obj) {
        return (SetSchemaResponse.MigrationFailure) obj;
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ void m1007o() {
    }
}
