package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.LocaleList;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001b¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/CouponAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/WalletAction;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "brandName", "", "couponName", "getCouponName", "()Ljava/lang/String;", "couponName$delegate", "Lkotlin/Lazy;", "couponType", "expirationDate", "", "getExpirationDate", "()J", "expirationDate$delegate", "iconUri", "getIconUri", "()Landroid/net/Uri;", "isSupportAction", "", "()Z", "initCouponName", "initExpirationDate", "isSupportCoupon", "isSupportOldCoupon", "parseCouponType", "couponTypeString", "runAction", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCouponAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CouponAction.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/action/data/CouponAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,175:1\n1#2:176\n*E\n"})
public final class CouponAction extends WalletAction {

    @NotNull
    private static final String BARCODE_PREFIX = "Barcode_";

    @NotNull
    private static final String BARCODE_TYPE_CODE_128 = "CODE_128";

    @NotNull
    private static final String INTENT_KEY_BARCODE_FORMAT = "extra_key_barcode_format";

    @NotNull
    private static final String INTENT_KEY_BARCODE_SERIAL_NUMBER = "extra_key_barcode_serial_number";

    @NotNull
    private static final String INTENT_KEY_BRAND_NAME = "extra_key_brand_name";

    @NotNull
    private static final String INTENT_KEY_COUPON_IMAGE_URI = "extra_key_coupon_image_uri";

    @NotNull
    private static final String INTENT_KEY_COUPON_NAME = "extra_key_coupon_name";

    @NotNull
    private static final String INTENT_KEY_EXPIRATION_DATE = "extra_key_expiration_date";

    @NotNull
    private static final String INTENT_KEY_MEMO = "extra_key_memo";

    @NotNull
    private static final String INTENT_KEY_NEED_COUPON_IMAGE_EXTRACTION = "extra_key_need_coupon_image_extraction";

    @NotNull
    private static final String INTENT_KEY_ORIGINAL_IMAGE_URI = "extra_key_original_image_uri";

    @NotNull
    private static final String JSON_KEY_BRAND = "Brand";

    @NotNull
    private static final String JSON_KEY_COUPON_CODE_VALUE = "CouponCodeValue";

    @NotNull
    private static final String JSON_KEY_COUPON_NAME = "CouponName";

    @NotNull
    private static final String JSON_KEY_COUPON_TYPE = "CouponType";

    @NotNull
    private static final String JSON_KEY_HOW_TO_USE = "HowToUse";

    @NotNull
    private static final String JSON_KEY_OFFER = "Offer";

    @NotNull
    private static final String JSON_KEY_VALID_DAY = "ValidDay";

    @NotNull
    private static final String JSON_KEY_VALID_MONTH = "ValidMonth";

    @NotNull
    private static final String JSON_KEY_VALID_YEAR = "ValidYear";

    /* JADX INFO: renamed from: NA */
    @NotNull
    private static final String f4739NA = "N/A";

    @NotNull
    private static final String SUPPORTED_FEATURE_COUPONS = "COUPONS";

    @NotNull
    private static final String TAG = "CouponAction";

    @NotNull
    private static final String WALLET_METADATA_KEY = "com.samsung.android.spay.vas.coupons.support.addFromExternalApp";

    @NotNull
    private static final String WALLET_PACKAGE_NAME = "com.samsung.android.spay";

    @NotNull
    private static final String WALLET_URI = "samsungpay://launch?action=coupons_add";

    @NotNull
    private final String brandName;

    /* JADX INFO: renamed from: couponName$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy couponName;

    @NotNull
    private String couponType;

    /* JADX INFO: renamed from: expirationDate$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy expirationDate;

    @NotNull
    private final Uri iconUri;
    private final boolean isSupportAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CouponAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        String asString;
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.couponType = BARCODE_TYPE_CODE_128;
        this.iconUri = getResourceUri(C7039R.drawable.capsule_coupon, context);
        boolean z = isSupportCoupon() || isSupportOldCoupon();
        if (!z) {
            LibLogger.m5432i(TAG, "Wallet app doesn't support coupon");
        }
        this.isSupportAction = z;
        JsonElement jsonElement = info.get(JSON_KEY_BRAND);
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null) {
            asString = "";
        } else {
            asString = Intrinsics.areEqual(asString, f4739NA) ? null : asString;
            if (asString == null) {
            }
        }
        this.brandName = asString;
        this.couponName = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.action.data.CouponAction$couponName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return this.this$0.initCouponName();
            }
        });
        this.expirationDate = LazyKt.lazy(new Function0<Long>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.action.data.CouponAction$expirationDate$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(this.this$0.initExpirationDate());
            }
        });
    }

    private final String getCouponName() {
        return (String) this.couponName.getValue();
    }

    private final long getExpirationDate() {
        return ((Number) this.expirationDate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String initCouponName() {
        JsonElement jsonElement = getInfo().get(JSON_KEY_COUPON_NAME);
        String str = null;
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (!Intrinsics.areEqual(asString, f4739NA) && asString != null) {
            str = asString;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() <= 18) {
            return str;
        }
        String strSubstring = str.substring(0, 15);
        return AbstractC12991c.m13991l(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)", strSubstring, "...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long initExpirationDate() {
        Date date;
        Instant instant;
        Configuration configuration;
        LocaleList locales;
        JsonElement jsonElement = getInfo().get(JSON_KEY_VALID_YEAR);
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        JsonElement jsonElement2 = getInfo().get(JSON_KEY_VALID_MONTH);
        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        JsonElement jsonElement3 = getInfo().get(JSON_KEY_VALID_DAY);
        String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        String strM1622l = AbstractC2322a.m1622l(asString2, "/", asString3, "/", asString);
        Resources resources = getContext().getResources();
        Locale locale = (resources == null || (configuration = resources.getConfiguration()) == null || (locales = configuration.getLocales()) == null) ? null : locales.get(0);
        if (SetsKt.setOf((Object[]) new String[]{asString, asString2, asString3}).contains(f4739NA) || SetsKt.setOf((Object[]) new String[]{asString, asString2, asString3}).contains(null) || (date = new SimpleDateFormat("MM/dd/yyyy", locale).parse(strM1622l)) == null || (instant = date.toInstant()) == null) {
            return -1L;
        }
        return instant.toEpochMilli();
    }

    private final boolean isSupportCoupon() {
        return isSupportFeature(SUPPORTED_FEATURE_COUPONS);
    }

    private final boolean isSupportOldCoupon() {
        ApplicationInfo applicationInfo = null;
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager != null) {
                applicationInfo = packageManager.getApplicationInfo(WALLET_PACKAGE_NAME, 128);
            }
        } catch (PackageManager.NameNotFoundException e) {
            LibLogger.m5432i(TAG, "Can't find wallet app : " + e);
        } catch (IllegalArgumentException e2) {
            LibLogger.m5432i(TAG, "Can't find wallet app : " + e2);
        } catch (Exception e3) {
            LibLogger.m5432i(TAG, "Exception during check old wallet app : " + e3);
        }
        if (applicationInfo != null) {
            return applicationInfo.metaData.getBoolean(WALLET_METADATA_KEY, false);
        }
        return false;
    }

    private final String parseCouponType(String couponTypeString) {
        return StringsKt.m14162r(couponTypeString, BARCODE_PREFIX) ? StringsKt.m14139M(couponTypeString, BARCODE_PREFIX, "") : couponTypeString;
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
        JsonElement jsonElement;
        String asString;
        LibLogger.m5432i(TAG, "runAction");
        if (getIsSupportAction()) {
            Bundle bundle = new Bundle();
            bundle.putString(INTENT_KEY_COUPON_NAME, getCouponName());
            bundle.putParcelable(INTENT_KEY_ORIGINAL_IMAGE_URI, getImageUri());
            if (getExpirationDate() != -1) {
                bundle.putLong(INTENT_KEY_EXPIRATION_DATE, getExpirationDate());
            }
            bundle.putString(INTENT_KEY_BRAND_NAME, this.brandName);
            JsonObject info = getInfo();
            JsonElement jsonElement2 = info.get(JSON_KEY_HOW_TO_USE);
            if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                Intrinsics.checkNotNullExpressionValue(asString, "asString");
                if (asString.length() > 0) {
                    bundle.putString(INTENT_KEY_MEMO, asString);
                }
            }
            JsonElement jsonElement3 = info.get(JSON_KEY_COUPON_TYPE);
            if (jsonElement3 != null) {
                Intrinsics.checkNotNullExpressionValue(jsonElement3, "get(JSON_KEY_COUPON_TYPE)");
                String asString2 = jsonElement3.getAsString();
                Intrinsics.checkNotNullExpressionValue(asString2, "it.asString");
                this.couponType = parseCouponType(asString2);
            }
            if (this.couponType.length() > 0 && (jsonElement = info.get(JSON_KEY_COUPON_CODE_VALUE)) != null) {
                Intrinsics.checkNotNullExpressionValue(jsonElement, "get(JSON_KEY_COUPON_CODE_VALUE)");
                bundle.putString(INTENT_KEY_BARCODE_SERIAL_NUMBER, jsonElement.getAsString());
            }
            if (this.couponType.length() > 0) {
                bundle.putString(INTENT_KEY_BARCODE_FORMAT, this.couponType);
            }
            getContext().grantUriPermission(WALLET_PACKAGE_NAME, getImageUri(), 1);
            bundle.putBoolean(INTENT_KEY_NEED_COUPON_IMAGE_EXTRACTION, true);
            boolean z = getCouponName().length() > 0;
            LibLogger.m5432i(TAG, "Send coupon intent : " + z + SQLKeyword.COMMA + getImageUri());
            Intent intent = new Intent();
            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            intent.setData(Uri.parse(WALLET_URI));
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        }
        return true;
    }
}
