package com.samsung.android.sdk.vexkit.scanner;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScan;", "", Constant.DOC_SCAN_EDIT_PATH, "", "vexDocumentEditConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentEditConfig;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanListener;", "release", "start", "vexDocumentScanConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanConfig;", "Companion", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface VexDocumentScan {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScan$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "close", "", "context", "Landroid/content/Context;", "create", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScan;", "editNoResult", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentEditConfig;", "isAvailable", "", "startNoResult", "vexDocumentScanConfig", "Lcom/samsung/android/sdk/vexkit/scanner/VexDocumentScanConfig;", "isNewTask", "VexKitDocumentScan-INTERNAL-1.0.5_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String TAG = "VexDocumentScan";

        private Companion() {
        }

        public static /* synthetic */ void startNoResult$default(Companion companion, Context context, VexDocumentScanConfig vexDocumentScanConfig, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.startNoResult(context, vexDocumentScanConfig, z);
        }

        @JvmStatic
        public final void close(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Log.i(TAG, "close");
            Intent intent = new Intent(VexDocumentScanConstants.ACTION_CLOSE_SCAN_DOCUMENT);
            intent.putExtra(VexDocumentScanConstants.KEY_CLIENT_PACKAGE_NAME, context.getPackageName());
            context.sendBroadcast(intent);
        }

        @JvmStatic
        public final VexDocumentScan create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            VexDocumentScanImpl vexDocumentScanImpl = new VexDocumentScanImpl(context);
            vexDocumentScanImpl.registerVexDocumentScan();
            return vexDocumentScanImpl;
        }

        @JvmStatic
        public final void editNoResult(Context context, VexDocumentEditConfig config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            config.setExternalStorageImport(true);
            if (config.getInputUri() == null) {
                Log.e(TAG, "editNoResult# can not start scanner!!");
            } else {
                context.startActivity(VexDocumentScanUtilsKt.createEditIntent(context, config));
            }
        }

        @JvmStatic
        public final boolean isAvailable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(VexDocumentScanConstants.VEX_SCANNER_PACKAGE, 0);
                Log.v(TAG, "vexkit : [1.0.5]");
                Log.v(TAG, "vexscanner : [" + packageInfo.versionName + "] : [" + packageInfo.getLongVersionCode() + PropertyUtils.INDEXED_DELIM2);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(TAG, "vexscanner is not installed");
                return false;
            }
        }

        @JvmStatic
        public final void startNoResult(Context context, VexDocumentScanConfig vexDocumentScanConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(vexDocumentScanConfig, "vexDocumentScanConfig");
            startNoResult$default(this, context, vexDocumentScanConfig, false, 4, null);
        }

        @JvmStatic
        public final void startNoResult(Context context, VexDocumentScanConfig vexDocumentScanConfig, boolean isNewTask) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(vexDocumentScanConfig, "vexDocumentScanConfig");
            vexDocumentScanConfig.setExternalStorageImport(true);
            context.startActivity(VexDocumentScanUtilsKt.createScanIntent(context, vexDocumentScanConfig, isNewTask));
        }
    }

    @JvmStatic
    static void close(Context context) {
        INSTANCE.close(context);
    }

    @JvmStatic
    static VexDocumentScan create(Context context) {
        return INSTANCE.create(context);
    }

    @JvmStatic
    static void editNoResult(Context context, VexDocumentEditConfig vexDocumentEditConfig) {
        INSTANCE.editNoResult(context, vexDocumentEditConfig);
    }

    @JvmStatic
    static boolean isAvailable(Context context) {
        return INSTANCE.isAvailable(context);
    }

    @JvmStatic
    static void startNoResult(Context context, VexDocumentScanConfig vexDocumentScanConfig) {
        INSTANCE.startNoResult(context, vexDocumentScanConfig);
    }

    void edit(VexDocumentEditConfig vexDocumentEditConfig, VexDocumentScanListener listener);

    void release();

    void start(VexDocumentScanConfig vexDocumentScanConfig, VexDocumentScanListener listener);

    @JvmStatic
    static void startNoResult(Context context, VexDocumentScanConfig vexDocumentScanConfig, boolean z) {
        INSTANCE.startNoResult(context, vexDocumentScanConfig, z);
    }
}
