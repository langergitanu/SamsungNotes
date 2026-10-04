package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000e¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/BoardingPassAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/WalletAction;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "iconUri", "getIconUri", "()Landroid/net/Uri;", "isSupportAction", "", "()Z", "isSupportBoardingPass", "isSupportOldBoardingPass", "runAction", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BoardingPassAction extends WalletAction {

    @NotNull
    private static final String INTENT_KEY_QR_DATA = "extra_key_qr_data";

    @NotNull
    private static final String INTENT_KEY_QR_FORMAT = "extra_key_qr_format";

    @NotNull
    private static final String JSON_KEY_QR_CODE_TYPE = "QrCodeType";

    @NotNull
    private static final String JSON_KEY_QR_CODE_VALUE = "QrCodeValue";

    @NotNull
    private static final String SUPPORTED_FEATURE_BOARDING_PASS = "BOARDING_PASS";

    @NotNull
    private static final String TAG = "BoardingPassAction";

    @NotNull
    private static final String WALLET_CLASS_NAME = "com.samsung.android.spay.BoardingPassReceiver";

    @NotNull
    private static final String WALLET_PACKAGE_NAME = "com.samsung.android.spay";

    @NotNull
    private static final String WALLET_URI = "samsungpay://launch?action=usbpc_add";

    @NotNull
    private final Uri iconUri;
    private final boolean isSupportAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoardingPassAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.iconUri = getResourceUri(C7039R.drawable.capsule_traveling, context);
        boolean z = isSupportBoardingPass() || isSupportOldBoardingPass();
        if (!z) {
            LibLogger.m5432i(TAG, "Wallet doesn't support boarding pass.");
        }
        this.isSupportAction = z;
    }

    private final boolean isSupportBoardingPass() {
        return isSupportFeature(SUPPORTED_FEATURE_BOARDING_PASS);
    }

    private final boolean isSupportOldBoardingPass() {
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager != null) {
                return packageManager.getComponentEnabledSetting(new ComponentName(WALLET_PACKAGE_NAME, WALLET_CLASS_NAME)) == 1;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            LibLogger.m5430e(TAG, "Samsung Wallet is not installed");
            return false;
        } catch (Exception e) {
            LibLogger.m5430e(TAG, "Exception occurred while check wallet app : " + e);
            return false;
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public Uri getIconUri() {
        return this.iconUri;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    /* JADX INFO: renamed from: isSupportAction, reason: from getter */
    public boolean getIsSupportAction() {
        return this.isSupportAction;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    public boolean runAction() {
        LibLogger.m5432i(TAG, "runAction");
        if (getIsSupportAction()) {
            Bundle bundle = new Bundle();
            JsonElement jsonElement = getInfo().get(JSON_KEY_QR_CODE_VALUE);
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            JsonElement jsonElement2 = getInfo().get(JSON_KEY_QR_CODE_TYPE);
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            bundle.putString(INTENT_KEY_QR_DATA, asString);
            Integer num = ActionConstants.INSTANCE.getBARCODE_LOOKUP_TABLE().get(asString2);
            bundle.putInt(INTENT_KEY_QR_FORMAT, num != null ? num.intValue() : -1);
            boolean z = asString == null || asString.length() == 0;
            StringBuilder sb = new StringBuilder("Send boarding pass intent : ");
            sb.append(!z);
            LibLogger.m5432i(TAG, sb.toString());
            Intent intent = new Intent();
            intent.setData(Uri.parse(WALLET_URI));
            intent.setFlags(268435456);
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        }
        return true;
    }
}
