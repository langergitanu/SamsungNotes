package com.samsung.android.sdk.vexkit.scanner;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanConstants;", "", "()V", "ACTION_CLOSE_SCAN_DOCUMENT", "", "ACTION_EDIT_DOCUMENT", "ACTION_SCAN_DOCUMENT", "ACTION_SINGLE_SCAN_DOCUMENT", "KEY_CAPTURE_MODE", "KEY_CLIENT_PACKAGE_NAME", "KEY_EDIT_DOC_RECT", "KEY_EDIT_INPUT_FILE", "KEY_EDIT_INPUT_FILE_PATH", "KEY_EXTERNAL_STORAGE_IMPORT", "KEY_IS_HEIF", "KEY_IS_SECURE", "KEY_NON_DESTRUCTION", "KEY_OBJECT_REMOVER", "KEY_PDF_URI", "KEY_RECTIFIED_IMAGE_URI", "KEY_SCANNED_DOCUMENT_BUNDLES", "KEY_SCAN_MODE", "VEX_EDIT_DOC_ACTIVITY", "VEX_SCANNER_PACKAGE", "VEX_SCAN_DOC_ACTIVITY", "VEX_SINGLE_SCAN_DOC_ACTIVITY", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class VexDocumentScanConstants {
    public static final String ACTION_CLOSE_SCAN_DOCUMENT = "com.samsung.android.app.vex.scanner.action.CLOSE_SCAN_DOCUMENT";
    public static final String ACTION_EDIT_DOCUMENT = "com.samsung.android.app.vex.scanner.action.EDIT_DOCUMENT";
    public static final String ACTION_SCAN_DOCUMENT = "com.samsung.android.app.vex.scanner.action.SCAN_DOCUMENT";
    public static final String ACTION_SINGLE_SCAN_DOCUMENT = "com.samsung.android.app.vex.scanner.action.SINGLE_SCAN_DOCUMENT";
    public static final VexDocumentScanConstants INSTANCE = new VexDocumentScanConstants();
    public static final String KEY_CAPTURE_MODE = "CAPTURE_MODE";
    public static final String KEY_CLIENT_PACKAGE_NAME = "clientPackageName";
    public static final String KEY_EDIT_DOC_RECT = "EDIT_DOC_RECT";
    public static final String KEY_EDIT_INPUT_FILE = "EDIT_INPUT_FILE";
    public static final String KEY_EDIT_INPUT_FILE_PATH = "EDIT_INPUT_FILE_PATH";
    public static final String KEY_EXTERNAL_STORAGE_IMPORT = "EXTERNAL_STORAGE_IMPORT";
    public static final String KEY_IS_HEIF = "IS_HEIF";
    public static final String KEY_IS_SECURE = "IS_SECURE";
    public static final String KEY_NON_DESTRUCTION = "NON_DESTRUCTION";
    public static final String KEY_OBJECT_REMOVER = "OBJECT_REMOVER";
    public static final String KEY_PDF_URI = "pdfUri";
    public static final String KEY_RECTIFIED_IMAGE_URI = "rectifiedImageUri";
    public static final String KEY_SCANNED_DOCUMENT_BUNDLES = "scannedDocumentBundles";
    public static final String KEY_SCAN_MODE = "SCAN_MODE";
    public static final String VEX_EDIT_DOC_ACTIVITY = "com.samsung.android.app.vex.scanner.SingleEditActivity";
    public static final String VEX_SCANNER_PACKAGE = "com.samsung.android.app.vex.scanner";
    public static final String VEX_SCAN_DOC_ACTIVITY = "com.samsung.android.app.vex.scanner.ScanDocActivity";
    public static final String VEX_SINGLE_SCAN_DOC_ACTIVITY = "com.samsung.android.app.vex.scanner.SingleScanDocActivity";

    private VexDocumentScanConstants() {
    }
}
