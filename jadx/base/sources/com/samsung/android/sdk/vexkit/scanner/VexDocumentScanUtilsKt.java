package com.samsung.android.sdk.vexkit.scanner;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanOption;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "createEditIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "vexDocumentEditConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentEditConfig;", "createScanIntent", "vexDocumentScanConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanConfig;", "isNewTask", "", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class VexDocumentScanUtilsKt {
    private static final String TAG = "VexDocumentScan";

    public static final Intent createEditIntent(Context context, VexDocumentEditConfig vexDocumentEditConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vexDocumentEditConfig, "vexDocumentEditConfig");
        StringBuilder sb = new StringBuilder("edit: [");
        sb.append(vexDocumentEditConfig.getInputUri());
        sb.append("] [");
        sb.append(vexDocumentEditConfig.getInputPath());
        sb.append("] [");
        String string = Arrays.toString(vexDocumentEditConfig.getDocRect());
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        sb.append(PropertyUtils.INDEXED_DELIM2);
        Log.v(TAG, sb.toString());
        Log.v(TAG, "edit: [externalStorageImport : " + vexDocumentEditConfig.getExternalStorageImport() + "] [objectRemover : " + vexDocumentEditConfig.getObjectRemover() + "] [nonDestruction : " + vexDocumentEditConfig.getNonDestruction() + "] [isSecure : " + vexDocumentEditConfig.getIsSecure() + "] [isHeif : " + vexDocumentEditConfig.getIsHeif() + PropertyUtils.INDEXED_DELIM2);
        Intent intent = new Intent(VexDocumentScanConstants.ACTION_EDIT_DOCUMENT);
        intent.setClassName(VexDocumentScanConstants.VEX_SCANNER_PACKAGE, VexDocumentScanConstants.VEX_EDIT_DOC_ACTIVITY);
        intent.addFlags(3);
        intent.putExtra(VexDocumentScanConstants.KEY_CLIENT_PACKAGE_NAME, context.getPackageName());
        if (vexDocumentEditConfig.getInputUri() != null) {
            context.grantUriPermission(VexDocumentScanConstants.VEX_SCANNER_PACKAGE, vexDocumentEditConfig.getInputUri(), 3);
            intent.putExtra(VexDocumentScanConstants.KEY_EDIT_INPUT_FILE, String.valueOf(vexDocumentEditConfig.getInputUri()));
        }
        if (vexDocumentEditConfig.getInputPath().length() > 0) {
            intent.putExtra(VexDocumentScanConstants.KEY_EDIT_INPUT_FILE_PATH, vexDocumentEditConfig.getInputPath());
        }
        intent.putExtra(VexDocumentScanConstants.KEY_EDIT_DOC_RECT, vexDocumentEditConfig.getDocRect());
        intent.putExtra(VexDocumentScanConstants.KEY_EXTERNAL_STORAGE_IMPORT, vexDocumentEditConfig.getExternalStorageImport());
        intent.putExtra(VexDocumentScanConstants.KEY_OBJECT_REMOVER, vexDocumentEditConfig.getObjectRemover());
        intent.putExtra(VexDocumentScanConstants.KEY_NON_DESTRUCTION, vexDocumentEditConfig.getNonDestruction());
        intent.putExtra(VexDocumentScanConstants.KEY_IS_SECURE, vexDocumentEditConfig.getIsSecure());
        intent.putExtra(VexDocumentScanConstants.KEY_IS_HEIF, vexDocumentEditConfig.getIsHeif());
        return intent;
    }

    public static final Intent createScanIntent(Context context, VexDocumentScanConfig vexDocumentScanConfig, boolean z) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vexDocumentScanConfig, "vexDocumentScanConfig");
        Log.v(TAG, "start: [" + vexDocumentScanConfig.getScanMode() + "] [" + vexDocumentScanConfig.getCaptureMode() + "] [externalStorageImport : " + vexDocumentScanConfig.getExternalStorageImport() + "] [isNewTask : " + z + PropertyUtils.INDEXED_DELIM2);
        if (vexDocumentScanConfig.getScanMode() == VexDocumentScanOption.ScanMode.SCAN_MODE_SINGLE) {
            str = VexDocumentScanConstants.ACTION_SINGLE_SCAN_DOCUMENT;
            str2 = VexDocumentScanConstants.VEX_SINGLE_SCAN_DOC_ACTIVITY;
        } else {
            str = VexDocumentScanConstants.ACTION_SCAN_DOCUMENT;
            str2 = VexDocumentScanConstants.VEX_SCAN_DOC_ACTIVITY;
        }
        Intent intent = new Intent(str);
        intent.setClassName(VexDocumentScanConstants.VEX_SCANNER_PACKAGE, str2);
        intent.addFlags(3);
        intent.putExtra(VexDocumentScanConstants.KEY_CLIENT_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(VexDocumentScanConstants.KEY_SCAN_MODE, vexDocumentScanConfig.getScanMode().getValue());
        intent.putExtra(VexDocumentScanConstants.KEY_CAPTURE_MODE, vexDocumentScanConfig.getCaptureMode().getValue());
        intent.putExtra(VexDocumentScanConstants.KEY_EXTERNAL_STORAGE_IMPORT, vexDocumentScanConfig.getExternalStorageImport());
        if (z) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public static /* synthetic */ Intent createScanIntent$default(Context context, VexDocumentScanConfig vexDocumentScanConfig, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return createScanIntent(context, vexDocumentScanConfig, z);
    }
}
