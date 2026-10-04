package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PackageHelper;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "This is for using LLM")
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/ShoppingAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "iconUri", "getIconUri", "()Landroid/net/Uri;", "targetPackage", "", "title", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "runAction", "", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ShoppingAction extends Action {

    @NotNull
    private static final String JSON_KEY_BRAND_NAME = "BrandName";

    @NotNull
    private static final String JSON_KEY_OFFERING_PRICE = "OfferingPrice";

    @NotNull
    private static final String JSON_KEY_PRODUCT_NAME = "ProductName";

    @NotNull
    private static final String JSON_KEY_WHERE_TO_BUY_IT = "WhereToBuyIt";

    /* JADX INFO: renamed from: NA */
    @NotNull
    private static final String f4745NA = "N/A";

    @NotNull
    private static final String REMINDER_PACKAGE_NAME = "com.samsung.android.app.reminder";

    @NotNull
    private static final String TAG = "ShoppingAction";

    @NotNull
    private static final String TYPE_TEXT_PLAIN = "text/plain";

    @NotNull
    private final Uri iconUri;

    @NotNull
    private final String targetPackage;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShoppingAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.iconUri = getResourceUri(C7039R.drawable.capsule_shopping, context);
        String string = context.getString(C7039R.string.add_to_reminder);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.add_to_reminder)");
        this.title = string;
        this.targetPackage = PackageHelper.INSTANCE.isPackageExists(context, REMINDER_PACKAGE_NAME) ? REMINDER_PACKAGE_NAME : "";
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public Uri getIconUri() {
        return this.iconUri;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    public boolean runAction() {
        String asString;
        String asString2;
        String asString3;
        String asString4;
        LibLogger.m5432i(TAG, "runAction");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        JsonObject info = getInfo();
        JsonElement jsonElement = info.get(JSON_KEY_BRAND_NAME);
        if (jsonElement != null && (asString4 = jsonElement.getAsString()) != null) {
            Intrinsics.checkNotNullExpressionValue(asString4, "asString");
            if (asString4.length() > 0 && !Intrinsics.areEqual(asString4, f4745NA)) {
                sb.append(asString4);
            }
        }
        JsonElement jsonElement2 = info.get(JSON_KEY_PRODUCT_NAME);
        if (jsonElement2 != null && (asString3 = jsonElement2.getAsString()) != null) {
            Intrinsics.checkNotNullExpressionValue(asString3, "asString");
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (asString3.length() > 0 && !Intrinsics.areEqual(asString3, f4745NA)) {
                sb.append(asString3);
            }
        }
        JsonElement jsonElement3 = info.get(JSON_KEY_OFFERING_PRICE);
        if (jsonElement3 != null && (asString2 = jsonElement3.getAsString()) != null) {
            Intrinsics.checkNotNullExpressionValue(asString2, "asString");
            if (asString2.length() > 0 && !Intrinsics.areEqual(asString2, f4745NA)) {
                sb2.append("Price: ");
                sb2.append(asString2);
            }
        }
        JsonElement jsonElement4 = info.get(JSON_KEY_WHERE_TO_BUY_IT);
        if (jsonElement4 != null && (asString = jsonElement4.getAsString()) != null) {
            Intrinsics.checkNotNullExpressionValue(asString, "asString");
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            if (asString.length() > 0 && !Intrinsics.areEqual(asString, f4745NA)) {
                sb2.append("Where to buy: ");
                sb2.append(asString);
            }
        }
        if (sb2.length() > 0) {
            sb2.append(MarkdownDocument.NEW_LINE);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.setFlags(268435456);
        if (sb.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", sb.toString());
            intent.putExtra("android.intent.extra.TEXT", sb2.toString());
        } else {
            intent.putExtra("android.intent.extra.TEXT", sb2.toString());
        }
        intent.putExtra("android.intent.extra.STREAM", getImageUri());
        intent.setPackage(this.targetPackage);
        getContext().startActivity(intent);
        return true;
    }
}
