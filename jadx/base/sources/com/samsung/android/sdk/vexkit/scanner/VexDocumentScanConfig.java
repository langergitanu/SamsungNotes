package com.samsung.android.sdk.vexkit.scanner;

import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanConfig;", "", "()V", "captureMode", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanOption$CaptureMode;", "getCaptureMode", "()Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanOption$CaptureMode;", "setCaptureMode", "(Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanOption$CaptureMode;)V", "externalStorageImport", "", "getExternalStorageImport", "()Z", "setExternalStorageImport", "(Z)V", "scanMode", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanOption$ScanMode;", "getScanMode", "()Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanOption$ScanMode;", "setScanMode", "(Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanOption$ScanMode;)V", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class VexDocumentScanConfig {
    private VexDocumentScanOption.ScanMode scanMode = VexDocumentScanOption.ScanMode.SCAN_MODE_MULTI;
    private VexDocumentScanOption.CaptureMode captureMode = VexDocumentScanOption.CaptureMode.CAPTURE_MODE_BASIC;
    private boolean externalStorageImport = true;

    public final VexDocumentScanOption.CaptureMode getCaptureMode() {
        return this.captureMode;
    }

    public final boolean getExternalStorageImport() {
        return this.externalStorageImport;
    }

    public final VexDocumentScanOption.ScanMode getScanMode() {
        return this.scanMode;
    }

    public final void setCaptureMode(VexDocumentScanOption.CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "<set-?>");
        this.captureMode = captureMode;
    }

    public final void setExternalStorageImport(boolean z) {
        this.externalStorageImport = z;
    }

    public final void setScanMode(VexDocumentScanOption.ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "<set-?>");
        this.scanMode = scanMode;
    }
}
