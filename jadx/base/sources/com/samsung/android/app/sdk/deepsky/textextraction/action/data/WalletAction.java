package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b \u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0004R\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/WalletAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "title", "", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "title$delegate", "Lkotlin/Lazy;", "initTitle", "isSupportFeature", "", ExtensionConst.KEY_PARAM_FEATURE, "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class WalletAction extends Action {

    @NotNull
    private static final String TAG = "WalletAction";

    @NotNull
    private static final String WALLET_GET_SUPPORTED_FEATURE_LIST = "get_supported_feature_list";

    @NotNull
    private static final String WALLET_LABEL_DEFAULT = "Wallet";

    @NotNull
    private static final String WALLET_LABEL_KEY = "app_label";

    @NotNull
    private static final String WALLET_SHARE_GLOBAL_ARG_LABEL = "wallet_app_label_info";

    @NotNull
    private static final String WALLET_SHARE_GLOBAL_ARG_SUPPORT = "support_add_item_from_external_app";

    @NotNull
    private static final String WALLET_SHARE_GLOBAL_METHOD = "GET_global";

    @NotNull
    private static final String WALLET_SHARE_GLOBAL_URI = "content://com.samsung.android.spay.common.share/global";

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.title = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.action.data.WalletAction$title$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return this.this$0.initTitle();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String initTitle() {
        String str = WALLET_LABEL_DEFAULT;
        try {
            ContentResolver contentResolver = getContext().getContentResolver();
            Bundle bundleCall = contentResolver != null ? contentResolver.call(Uri.parse(WALLET_SHARE_GLOBAL_URI), WALLET_SHARE_GLOBAL_METHOD, WALLET_SHARE_GLOBAL_ARG_LABEL, (Bundle) null) : null;
            String string = bundleCall != null ? bundleCall.getString(WALLET_LABEL_KEY, "") : null;
            if (string != null) {
                str = string;
            }
        } catch (Exception e) {
            LibLogger.m5430e(TAG, "Exception occurred while get app name from wallet : " + e);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getContext().getString(C7039R.string.add_to);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.add_to)");
        return AbstractC2322a.m1624n(string2, new Object[]{str}, 1, "format(format, *args)");
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public String getTitle() {
        return (String) this.title.getValue();
    }

    public final boolean isSupportFeature(@NotNull String feature) {
        String str;
        Intrinsics.checkNotNullParameter(feature, "feature");
        try {
            ContentResolver contentResolver = getContext().getContentResolver();
            Bundle bundleCall = contentResolver != null ? contentResolver.call(Uri.parse(WALLET_SHARE_GLOBAL_URI), WALLET_SHARE_GLOBAL_METHOD, WALLET_SHARE_GLOBAL_ARG_SUPPORT, (Bundle) null) : null;
            if (bundleCall == null) {
                bundleCall = new Bundle();
            }
            ArrayList<String> stringArrayList = bundleCall.getStringArrayList(WALLET_GET_SUPPORTED_FEATURE_LIST);
            if (stringArrayList != null && !stringArrayList.isEmpty()) {
                if (stringArrayList.contains(feature)) {
                    str = "Wallet supports " + feature;
                } else {
                    str = "Wallet does not support " + feature;
                }
                LibLogger.m5432i(TAG, str);
                return stringArrayList.contains(feature);
            }
            LibLogger.m5432i(TAG, "Wallet is not supported version");
            return false;
        } catch (Exception e) {
            LibLogger.m5432i(TAG, "Exception during check wallet app : " + e);
            return false;
        }
    }
}
