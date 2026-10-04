package com.samsung.android.lib.galaxyfinder.search.util;

import android.content.Intent;
import android.os.Parcel;
import android.util.Base64;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/util/SearchIntentUtils;", "", "()V", "getIntentFromString", "Landroid/content/Intent;", "intentStr", "", "getStringFromIntent", MarketingConstants.LINK_TYPE_INTENT, "marshall", "", "unmarshall", "data", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SearchIntentUtils {

    @NotNull
    public static final SearchIntentUtils INSTANCE = new SearchIntentUtils();

    private SearchIntentUtils() {
    }

    private final byte[] marshall(Intent intent) {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
        intent.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        byte[] value = parcelObtain.marshall();
        parcelObtain.recycle();
        Intrinsics.checkNotNullExpressionValue(value, "value");
        return value;
    }

    private final Intent unmarshall(byte[] data) {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
        parcelObtain.unmarshall(data, 0, data.length);
        parcelObtain.setDataPosition(0);
        Intent intent = new Intent();
        intent.readFromParcel(parcelObtain);
        parcelObtain.recycle();
        return intent;
    }

    @NotNull
    public final Intent getIntentFromString(@Nullable String intentStr) {
        byte[] bytes = Base64.decode(intentStr, 0);
        Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
        return unmarshall(bytes);
    }

    @NotNull
    public final String getStringFromIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String strEncodeToString = Base64.encodeToString(marshall(intent), 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return strEncodeToString;
    }
}
