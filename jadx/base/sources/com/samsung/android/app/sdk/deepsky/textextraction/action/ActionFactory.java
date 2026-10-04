package com.samsung.android.app.sdk.deepsky.textextraction.action;

import android.content.Context;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.BoardingPassAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.BookAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.CouponAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.FoodAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.LocationAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.MembershipAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.ScheduleAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.ShoppingAction;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.UnclassifiedAction;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/ActionFactory;", "", "()V", "getAction", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "classification", "", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "data", "Lcom/google/gson/JsonObject;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ActionFactory {

    @NotNull
    public static final ActionFactory INSTANCE = new ActionFactory();

    private ActionFactory() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public final Action getAction(@NotNull String classification, @NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject data) {
        Intrinsics.checkNotNullParameter(classification, "classification");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(data, "data");
        switch (classification.hashCode()) {
            case -633276745:
                if (classification.equals("Schedule")) {
                    return new ScheduleAction(context, imageUri, data);
                }
                break;
            case -279816824:
                if (classification.equals(ActionConstants.ACTION_CATEGORY_SHOPPING)) {
                    return new ShoppingAction(context, imageUri, data);
                }
                break;
            case 2076425:
                if (classification.equals(ActionConstants.ACTION_CATEGORY_BOOK)) {
                    return new BookAction(context, imageUri, data);
                }
                break;
            case 2195582:
                if (classification.equals(ActionConstants.ACTION_CATEGORY_FOOD)) {
                    return new FoodAction(context, imageUri, data);
                }
                break;
            case 653222902:
                if (classification.equals(ActionConstants.ACTION_CATEGORY_MEMBERSHIP)) {
                    return new MembershipAction(context, imageUri, data);
                }
                break;
            case 691810669:
                if (classification.equals(ActionConstants.ACTION_CATEGORY_BOARDING_PASS)) {
                    return new BoardingPassAction(context, imageUri, data);
                }
                break;
            case 1965687765:
                if (classification.equals("Location")) {
                    return new LocationAction(context, imageUri, data);
                }
                break;
            case 2024260678:
                if (classification.equals(ActionConstants.ACTION_CATEGORY_COUPON)) {
                    return new CouponAction(context, imageUri, data);
                }
                break;
        }
        return new UnclassifiedAction(context, imageUri, data, classification);
    }
}
