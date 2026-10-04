package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/MembershipAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/WalletAction;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "barcodeRect", "Landroid/graphics/Rect;", "iconUri", "getIconUri", "()Landroid/net/Uri;", "isSupportAction", "", "()Z", MembershipAction.JSON_KEY_MEMBERSHIP_NAME, "", "qrData", "qrFormat", "initStringToBitmap", "Landroid/graphics/Bitmap;", "isSupportMembership", "runAction", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMembershipAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MembershipAction.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/action/data/MembershipAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class MembershipAction extends WalletAction {

    @NotNull
    private static final String INTENT_KEY_IS_MEMBERSHIP_IMG = "extra_key_need_crop_image_extraction";

    @NotNull
    private static final String INTENT_KEY_MEMBERSHIP_IMG = "extra_key_crop_image_uri";

    @NotNull
    private static final String INTENT_KEY_MEMBERSHIP_NAME = "extra_key_name";

    @NotNull
    private static final String INTENT_KEY_QR_DATA = "extra_key_barcode_serial_number";

    @NotNull
    private static final String INTENT_KEY_QR_FORMAT = "extra_key_barcode_format";

    @NotNull
    private static final String INTENT_KEY_SCREEN_IMG = "extra_key_original_image_uri";

    @NotNull
    private static final String JSON_KEY_IS_MEMBERSHIP_IMG = "isMembershipImg";

    @NotNull
    private static final String JSON_KEY_MEMBERSHIP_IMG = "membershipImg";

    @NotNull
    private static final String JSON_KEY_MEMBERSHIP_NAME = "membershipName";

    @NotNull
    private static final String JSON_KEY_QR_CODE_TYPE = "QrCodeType";

    @NotNull
    private static final String JSON_KEY_QR_CODE_VALUE = "QrCodeValue";

    /* JADX INFO: renamed from: NA */
    @NotNull
    private static final String f4741NA = "N/A";

    @NotNull
    private static final String SUPPORTED_FEATURE_MEMBERSHIP = "MEMBERSHIP";

    @NotNull
    private static final String TAG = "MembershipAction";

    @NotNull
    private static final String WALLET_PACKAGE_NAME = "com.samsung.android.spay";

    @NotNull
    private static final String WALLET_URI = "samsungpay://launch?action=membership_add";

    @NotNull
    private final Rect barcodeRect;

    @NotNull
    private final Uri iconUri;
    private final boolean isSupportAction;

    @NotNull
    private final String membershipName;

    @NotNull
    private final String qrData;

    @NotNull
    private final String qrFormat;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MembershipAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        String asString;
        String asString2;
        Rect rectUnflattenFromString;
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.iconUri = getResourceUri(C7039R.drawable.capsule_membership, context);
        boolean zIsSupportMembership = isSupportMembership();
        if (!zIsSupportMembership) {
            LibLogger.m5432i(TAG, "Wallet doesn't support Membership.");
        }
        this.isSupportAction = zIsSupportMembership;
        JsonElement jsonElement = info.get(JSON_KEY_MEMBERSHIP_NAME);
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null) {
            asString = "Membership Card";
        } else {
            asString = Intrinsics.areEqual(asString, f4741NA) ? null : asString;
            if (asString == null) {
            }
        }
        this.membershipName = asString;
        JsonElement jsonElement2 = info.get(JSON_KEY_QR_CODE_VALUE);
        String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        this.qrData = asString3 == null ? "" : asString3;
        JsonElement jsonElement3 = info.get(JSON_KEY_QR_CODE_TYPE);
        String asString4 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        this.qrFormat = asString4 != null ? asString4 : "";
        JsonElement jsonElement4 = info.get("RECT");
        this.barcodeRect = (jsonElement4 == null || (asString2 = jsonElement4.getAsString()) == null || (rectUnflattenFromString = Rect.unflattenFromString(asString2)) == null) ? new Rect() : rectUnflattenFromString;
    }

    private final Bitmap initStringToBitmap() {
        try {
            byte[] bArrDecode = Base64.getDecoder().decode(getInfo().get(JSON_KEY_MEMBERSHIP_IMG).getAsString());
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final boolean isSupportMembership() {
        return isSupportFeature(SUPPORTED_FEATURE_MEMBERSHIP);
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
            bundle.putString(INTENT_KEY_MEMBERSHIP_NAME, this.membershipName);
            bundle.putParcelable(INTENT_KEY_SCREEN_IMG, getImageUri());
            getContext().grantUriPermission(WALLET_PACKAGE_NAME, getImageUri(), 1);
            bundle.putString(INTENT_KEY_MEMBERSHIP_IMG, JSON_KEY_MEMBERSHIP_IMG);
            bundle.putBoolean(INTENT_KEY_IS_MEMBERSHIP_IMG, false);
            bundle.putString(INTENT_KEY_QR_DATA, this.qrData);
            bundle.putString(INTENT_KEY_QR_FORMAT, this.qrFormat);
            LibLogger.m5432i(TAG, "Insert membershipName : " + this.membershipName + ", URi: " + getImageUri() + ", IS_MEMBERSHIP_IMG: false, qrData: " + this.qrData + ", qrFormat: " + this.qrFormat);
            Intent intent = new Intent();
            intent.setData(Uri.parse(WALLET_URI));
            intent.setFlags(268435456);
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        }
        return true;
    }
}
