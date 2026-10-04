package com.samsung.android.sdk.vexkit.scanner;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.docscan.common.Constant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanImpl;", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScan;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "vexDocumentScanListener", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanListener;", Constant.DOC_SCAN_EDIT_PATH, "", "vexDocumentEditConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentEditConfig;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "handleActivityResult", "activityResult", "Landroidx/activity/result/ActivityResult;", "registerVexDocumentScan", "release", "start", "vexDocumentScanConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanConfig;", "Companion", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class VexDocumentScanImpl implements VexDocumentScan {
    private static final String TAG = "VexDocumentScan";
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private Context context;
    private VexDocumentScanListener vexDocumentScanListener;

    public VexDocumentScanImpl(Context context) {
        this.context = context;
    }

    private final synchronized void handleActivityResult(ActivityResult activityResult) {
        VexDocumentScanListener vexDocumentScanListener;
        String str;
        Unit unit;
        try {
            Log.v(TAG, "handleActivityResult# " + activityResult.getResultCode());
            if (this.vexDocumentScanListener == null) {
                Log.i(TAG, "handleActivityResult# vexDocumentScanListener is null");
            } else {
                Intent data = activityResult.getData();
                if (-1 == activityResult.getResultCode()) {
                    if (data != null) {
                        VexDocumentScanListener vexDocumentScanListener2 = this.vexDocumentScanListener;
                        Intrinsics.checkNotNull(vexDocumentScanListener2);
                        vexDocumentScanListener2.onCompleted(data);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        vexDocumentScanListener = this.vexDocumentScanListener;
                        Intrinsics.checkNotNull(vexDocumentScanListener);
                        str = "FAILED";
                    }
                    this.vexDocumentScanListener = null;
                } else {
                    vexDocumentScanListener = this.vexDocumentScanListener;
                    Intrinsics.checkNotNull(vexDocumentScanListener);
                    str = "NOT OK";
                }
                vexDocumentScanListener.onError(str);
                this.vexDocumentScanListener = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerVexDocumentScan$lambda$0(VexDocumentScanImpl this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.handleActivityResult(result);
    }

    @Override // com.samsung.android.sdk.vexkit.scanner.VexDocumentScan
    public synchronized void edit(VexDocumentEditConfig vexDocumentEditConfig, VexDocumentScanListener listener) {
        Intrinsics.checkNotNullParameter(vexDocumentEditConfig, "vexDocumentEditConfig");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.vexDocumentScanListener != null) {
            throw new IllegalStateException("VexDocumentScan is already running.");
        }
        if (vexDocumentEditConfig.getInputUri() == null) {
            Log.e(TAG, "edit# can not start scanner!!");
            return;
        }
        this.vexDocumentScanListener = listener;
        ActivityResultLauncher<Intent> activityResultLauncher = this.activityResultLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityResultLauncher");
            activityResultLauncher = null;
        }
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        activityResultLauncher.launch(VexDocumentScanUtilsKt.createEditIntent(context, vexDocumentEditConfig));
    }

    public final void registerVexDocumentScan() {
        Context context = this.context;
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        }
        if (!(context instanceof ComponentActivity)) {
            throw new IllegalArgumentException("Context should be an instance of ComponentActivity");
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        this.activityResultLauncher = ((ComponentActivity) context).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C7737b(this, 9));
    }

    @Override // com.samsung.android.sdk.vexkit.scanner.VexDocumentScan
    public synchronized void release() {
        try {
            Log.i(TAG, "release#");
            ActivityResultLauncher<Intent> activityResultLauncher = this.activityResultLauncher;
            if (activityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityResultLauncher");
                activityResultLauncher = null;
            }
            activityResultLauncher.unregister();
            this.context = null;
            this.vexDocumentScanListener = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.samsung.android.sdk.vexkit.scanner.VexDocumentScan
    public synchronized void start(VexDocumentScanConfig vexDocumentScanConfig, VexDocumentScanListener listener) {
        try {
            Intrinsics.checkNotNullParameter(vexDocumentScanConfig, "vexDocumentScanConfig");
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (this.vexDocumentScanListener != null) {
                throw new IllegalStateException("VexDocumentScan is already running.");
            }
            this.vexDocumentScanListener = listener;
            ActivityResultLauncher<Intent> activityResultLauncher = this.activityResultLauncher;
            if (activityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityResultLauncher");
                activityResultLauncher = null;
            }
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            activityResultLauncher.launch(VexDocumentScanUtilsKt.createScanIntent$default(context, vexDocumentScanConfig, false, 4, null));
        } catch (Throwable th) {
            throw th;
        }
    }
}
