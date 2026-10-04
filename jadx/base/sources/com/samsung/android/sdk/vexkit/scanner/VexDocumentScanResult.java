package com.samsung.android.sdk.vexkit.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanResult;", "", VexDocumentScanConstants.KEY_PDF_URI, "Landroid/net/Uri;", "scannedDocuments", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanResult$ScannedDocument;", "Lkotlin/collections/ArrayList;", "(Landroid/net/Uri;Ljava/util/ArrayList;)V", "getPdfUri", "()Landroid/net/Uri;", "getScannedDocuments", "()Ljava/util/ArrayList;", "Companion", "ScannedDocument", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class VexDocumentScanResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexDocumentScanResult";
    private final Uri pdfUri;
    private final ArrayList<ScannedDocument> scannedDocuments;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanResult$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "fromResultIntent", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanResult;", "data", "Landroid/content/Intent;", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final VexDocumentScanResult fromResultIntent(Intent data) {
            Uri uri;
            Uri uri2;
            Intrinsics.checkNotNullParameter(data, "data");
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                uri = (Uri) data.getParcelableExtra(VexDocumentScanConstants.KEY_PDF_URI, Uri.class);
            } else {
                Parcelable parcelableExtra = data.getParcelableExtra(VexDocumentScanConstants.KEY_PDF_URI);
                uri = parcelableExtra instanceof Uri ? (Uri) parcelableExtra : null;
            }
            ArrayList<Bundle> parcelableArrayListExtra = i >= 33 ? data.getParcelableArrayListExtra(VexDocumentScanConstants.KEY_SCANNED_DOCUMENT_BUNDLES, Bundle.class) : data.getParcelableArrayListExtra(VexDocumentScanConstants.KEY_SCANNED_DOCUMENT_BUNDLES);
            ArrayList arrayList = new ArrayList();
            if (parcelableArrayListExtra != null) {
                for (Bundle bundle : parcelableArrayListExtra) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        uri2 = (Uri) bundle.getParcelable(VexDocumentScanConstants.KEY_RECTIFIED_IMAGE_URI, Uri.class);
                    } else {
                        Parcelable parcelable = bundle.getParcelable(VexDocumentScanConstants.KEY_RECTIFIED_IMAGE_URI);
                        uri2 = parcelable instanceof Uri ? (Uri) parcelable : null;
                    }
                    arrayList.add(new ScannedDocument(uri2));
                }
            } else {
                Log.i(VexDocumentScanResult.TAG, "fromResultIntent# scannedDocumentBundles is null");
            }
            return new VexDocumentScanResult(uri, arrayList);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanResult$ScannedDocument;", "", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getImageUri", "()Landroid/net/Uri;", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class ScannedDocument {
        private final Uri imageUri;

        public ScannedDocument(Uri uri) {
            this.imageUri = uri;
        }

        public final Uri getImageUri() {
            return this.imageUri;
        }
    }

    public VexDocumentScanResult(Uri uri, ArrayList<ScannedDocument> scannedDocuments) {
        Intrinsics.checkNotNullParameter(scannedDocuments, "scannedDocuments");
        this.pdfUri = uri;
        this.scannedDocuments = scannedDocuments;
    }

    @JvmStatic
    public static final VexDocumentScanResult fromResultIntent(Intent intent) {
        return INSTANCE.fromResultIntent(intent);
    }

    public final Uri getPdfUri() {
        return this.pdfUri;
    }

    public final ArrayList<ScannedDocument> getScannedDocuments() {
        return this.scannedDocuments;
    }
}
