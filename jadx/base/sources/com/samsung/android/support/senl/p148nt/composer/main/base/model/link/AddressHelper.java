package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AddressHelper {
    private static final int ADDRESS_MAX_RESULT = 1;
    public static final String MYANMAR_ZAWGYI = "my_ZG";
    private static final String TAG = Logger.createTag("AddressHelper");

    public static String findAddress(String str) {
        int iIndexOf;
        while (true) {
            try {
                String strFindAddress = WebView.findAddress(str);
                if (strFindAddress != null && (iIndexOf = str.indexOf(strFindAddress)) >= 0) {
                    str = str.substring(iIndexOf + strFindAddress.length());
                    try {
                        return URLEncoder.encode(strFindAddress, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return null;
            } catch (UnsupportedOperationException | Exception unused2) {
                return null;
            }
        }
    }

    public static Address findAddressByGeocoder(Context context, String str) {
        Geocoder geocoder;
        if (context == null) {
            return null;
        }
        try {
            geocoder = MYANMAR_ZAWGYI.equals(Locale.getDefault().toString()) ? new Geocoder(context, new Locale.Builder().setLanguage("my").setRegion("MM").build()) : new Geocoder(context, Locale.getDefault());
        } catch (IOException e) {
            e = e;
            Logger.m11001e(TAG, "findAddressByGeocoder failed location.", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            Logger.m11001e(TAG, "findAddressByGeocoder failed location.", e);
        }
        if (!Geocoder.isPresent()) {
            Logger.m11000e(TAG, "findAddressByGeocoder# geocoder is not present");
            return null;
        }
        List<Address> fromLocationName = geocoder.getFromLocationName(str, 1);
        Logger.m11003i(TAG, "findAddressByGeocoder# Done. addressList:" + fromLocationName);
        if (fromLocationName != null && !fromLocationName.isEmpty()) {
            return fromLocationName.get(0);
        }
        return null;
    }

    public static String normalAddressText(@NonNull Address address) {
        Logger.m11003i(TAG, "normalAddressText#");
        StringBuilder sb = new StringBuilder(256);
        if (LocaleUtils.isChineseLanguage()) {
            return normalCHNAddressText(address, sb, SQLKeyword.COMMA);
        }
        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
            if (!TextUtils.isEmpty(sb)) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(address.getAddressLine(i));
        }
        if (TextUtils.isEmpty(sb)) {
            sb.insert(0, address.getFeatureName());
        }
        return sb.toString();
    }

    private static String normalCHNAddressText(@NonNull Address address, StringBuilder sb, String str) {
        String[] strArr = {address.getAdminArea(), address.getLocality(), address.getSubLocality(), address.getThoroughfare(), address.getSubThoroughfare(), address.getPremises(), address.getPostalCode(), address.getCountryName()};
        for (int i = 0; i < 8; i++) {
            String str2 = strArr[i];
            if (str2 != null && !str2.isEmpty()) {
                if (!TextUtils.isEmpty(sb)) {
                    sb.append(str);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
