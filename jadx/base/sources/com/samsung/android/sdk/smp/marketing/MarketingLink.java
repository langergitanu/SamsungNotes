package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.SmpAppReferrer;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.DataManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MarketingLink {
    private static final String TAG = "MarketingLink";
    private String mAction;
    private ArrayList<String> mAppReferrer;
    private ArrayList<String> mBasicReferrer;
    private String mClassName;
    private int mComponent;
    private String mData;
    private Bundle mExtra;
    private String mPackageName;
    private String mRedirectionUrl;
    private ArrayList<String> mReferrerAppFilter;
    private String mReferrerStrForLandingPage;
    private boolean mRequireValidation;
    private String mType;
    private String mUrl;

    private String appendReferrerDelimiter(String str, String str2) {
        return !TextUtils.isEmpty(str) ? AbstractC0541b.m756B(str, str2) : str;
    }

    private String appendReferrerKeyValue(Context context, String str, ArrayList<String> arrayList, String str2, String str3, boolean z) throws InternalException.InvalidReferrerException {
        if (arrayList == null) {
            return str;
        }
        String delimiter = getDelimiter(MarketingConstants.REFERRER_DELIMITER_U003D, z);
        String delimiter2 = getDelimiter("|", z);
        for (String str4 : arrayList) {
            String referrerValueByType = getReferrerValueByType(context, str2, str4, str3);
            if (!TextUtils.isEmpty(referrerValueByType)) {
                str = AbstractC2821a.m2221l(appendReferrerDelimiter(str, delimiter2), str4, delimiter, referrerValueByType);
            } else if (this.mRequireValidation) {
                SmpLog.m6495e(TAG, str3, "fail to parse resource. invalid referrer");
                throw new InternalException.InvalidReferrerException();
            }
        }
        return str;
    }

    private String getDelimiter(String str, boolean z) {
        return z ? Uri.encode(str) : str;
    }

    public static boolean isValid(ArrayList<MarketingLink> arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        Iterator<MarketingLink> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid(str)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<MarketingLink> parse(Context context, String str, JSONObject jSONObject) throws JSONException {
        ArrayList<MarketingLink> arrayList = new ArrayList<>();
        JSONArray jSONArray = jSONObject.getJSONArray("action");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            MarketingLink marketingLink = new MarketingLink();
            marketingLink.mType = jSONObject2.getString("type");
            marketingLink.mPackageName = jSONObject2.optString("pkg");
            marketingLink.mUrl = jSONObject2.optString("url");
            marketingLink.mRedirectionUrl = jSONObject2.optString(MarketingConstants.LINK_REDIRECTION_URL);
            parseReferrer(context, str, marketingLink, jSONObject2.optJSONObject(MarketingConstants.LINK_REFERRER));
            marketingLink.mAction = jSONObject2.optString("action");
            marketingLink.mComponent = jSONObject2.optInt(MarketingConstants.INTENT_COMPONENT, 0);
            marketingLink.mData = jSONObject2.optString("data");
            marketingLink.mClassName = jSONObject2.optString(MarketingConstants.INTENT_CLASS);
            marketingLink.mExtra = parseIntentExtras(jSONObject2);
            arrayList.add(marketingLink);
        }
        return arrayList;
    }

    private static Bundle parseIntentExtras(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("extra");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArray = jSONArrayOptJSONArray.getJSONArray(i);
            String string = jSONArray.getString(1);
            switch (jSONArray.getInt(0)) {
                case 1:
                    bundle.putBoolean(string, jSONArray.getBoolean(2));
                    break;
                case 2:
                    bundle.putInt(string, jSONArray.getInt(2));
                    break;
                case 3:
                    bundle.putIntArray(string, parseToIntArray(jSONArray.getJSONArray(2)));
                    break;
                case 4:
                    bundle.putIntegerArrayList(string, parseToIntArrayList(jSONArray.getJSONArray(2)));
                    break;
                case 5:
                    bundle.putLong(string, jSONArray.getLong(2));
                    break;
                case 6:
                    bundle.putString(string, jSONArray.getString(2));
                    break;
                case 7:
                    bundle.putStringArray(string, parseToStringArray(jSONArray.getJSONArray(2)));
                    break;
                case 8:
                    bundle.putStringArrayList(string, parseToStringArrayList(jSONArray.getJSONArray(2)));
                    break;
                case 9:
                    bundle.putDouble(string, jSONArray.getDouble(2));
                    break;
                case 10:
                    bundle.putFloat(string, (float) jSONArray.getDouble(2));
                    break;
                case 11:
                    bundle.putShort(string, (short) jSONArray.getInt(2));
                    break;
            }
        }
        return bundle;
    }

    private static void parseReferrer(Context context, String str, MarketingLink marketingLink, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("data");
        if (jSONArray.length() == 0) {
            SmpLog.m6495e(TAG, str, "fail to parse resource. no referrer data");
            throw new JSONException("Invalid JSONArray. no referrer data");
        }
        marketingLink.mRequireValidation = jSONObject.optBoolean(MarketingConstants.LINK_REFERRER_REQUIRE_VALIDATION, true);
        marketingLink.mAppReferrer = new ArrayList<>();
        marketingLink.mBasicReferrer = new ArrayList<>();
        marketingLink.mReferrerAppFilter = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            String string2 = jSONObject2.getString("key");
            if (MarketingConstants.REFERRER_TYPE_APP_FILTER.equals(string)) {
                marketingLink.mReferrerAppFilter.add(string2);
            } else if (MarketingConstants.REFERRER_TYPE_BASIC.equals(string)) {
                marketingLink.mBasicReferrer.add(string2);
            } else if (MarketingConstants.REFERRER_TYPE_APP.equals(string)) {
                marketingLink.mAppReferrer.add(string2);
            } else {
                SmpLog.m6501w(TAG, "parse. not supported referrer type : " + string);
            }
        }
        marketingLink.mReferrerStrForLandingPage = marketingLink.getReferrerKeyValue(context, str, marketingLink.mType);
    }

    private static int[] parseToIntArray(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            throw new JSONException("Invalid JSONArray");
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            iArr[i] = jSONArray.getInt(i);
        }
        return iArr;
    }

    private static ArrayList<Integer> parseToIntArrayList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            throw new JSONException("Invalid JSONArray");
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
        }
        return arrayList;
    }

    private static String[] parseToStringArray(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            throw new JSONException("Invalid JSONArray");
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        return strArr;
    }

    private static ArrayList<String> parseToStringArrayList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            throw new JSONException("Invalid JSONArray");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public int getComponent() {
        return this.mComponent;
    }

    public String getData() {
        return this.mData;
    }

    public Bundle getExtra() {
        return this.mExtra;
    }

    public String getLinkUri() {
        String str = this.mType;
        if (str == null) {
            return null;
        }
        str.getClass();
        switch (str) {
            case "intent":
                return !TextUtils.isEmpty(this.mData) ? this.mData : this.mPackageName;
            case "app":
                return this.mPackageName;
            case "url":
                return this.mUrl;
            default:
                return null;
        }
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getRedirectionUrl() {
        return this.mRedirectionUrl;
    }

    public String getReferrerKeyValue(Context context, String str, String str2) throws InternalException.InvalidReferrerException {
        boolean z = !"url".equals(str2);
        String strAppendReferrerKeyValue = appendReferrerKeyValue(context, appendReferrerKeyValue(context, appendReferrerKeyValue(context, "", this.mBasicReferrer, MarketingConstants.REFERRER_TYPE_BASIC, str, z), this.mAppReferrer, MarketingConstants.REFERRER_TYPE_APP, str, z), this.mReferrerAppFilter, MarketingConstants.REFERRER_TYPE_APP_FILTER, str, z);
        SmpLog.m6499i(TAG, str, "referrer: " + strAppendReferrerKeyValue);
        return strAppendReferrerKeyValue;
    }

    public String getReferrerStrForLandingPage() {
        return this.mReferrerStrForLandingPage;
    }

    public String getReferrerValueByType(Context context, String str, String str2, String str3) {
        str.getClass();
        switch (str) {
            case "appReferrer":
                try {
                    return SmpAppReferrer.get(context, str2);
                } catch (Exception e) {
                    SmpLog.m6495e(TAG, str3, "get app referrer error. " + e.toString());
                    return null;
                }
            case "appFilter":
                try {
                    return DataManager.getAppFilterData(context, str2);
                } catch (Exception e2) {
                    SmpLog.m6495e(TAG, str3, "get app filter error. " + e2.toString());
                    return null;
                }
            case "basicReferrer":
                if ("mid".equals(str2)) {
                    return str3;
                }
                if ("appVersion".equals(str2)) {
                    return DeviceInfoUtil.getAppVersion(context);
                }
                SmpLog.m6502w(TAG, str3, "not supported referrer type:" + str2);
                return null;
            default:
                return null;
        }
    }

    public String getType() {
        return this.mType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setExtra(Bundle bundle) {
        this.mExtra = bundle;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("type", this.mType);
        bundle.putString("url", this.mUrl);
        bundle.putString(MarketingConstants.LINK_REDIRECTION_URL, this.mRedirectionUrl);
        bundle.putString("pkg", this.mPackageName);
        bundle.putString("action", this.mAction);
        bundle.putInt(MarketingConstants.INTENT_COMPONENT, this.mComponent);
        bundle.putString("data", this.mData);
        bundle.putString(MarketingConstants.INTENT_CLASS, this.mClassName);
        bundle.putBundle("extra", this.mExtra);
        bundle.putBoolean(MarketingConstants.LINK_REFERRER_REQUIRE_VALIDATION, this.mRequireValidation);
        bundle.putString(MarketingConstants.REFERRER_STR, this.mReferrerStrForLandingPage);
        bundle.putStringArrayList(MarketingConstants.REFERRER_TYPE_APP_FILTER, this.mReferrerAppFilter);
        bundle.putStringArrayList(MarketingConstants.REFERRER_TYPE_BASIC, this.mBasicReferrer);
        bundle.putStringArrayList(MarketingConstants.REFERRER_TYPE_APP, this.mAppReferrer);
        return bundle;
    }

    private boolean isValid(String str) {
        if ("app".equals(this.mType)) {
            return !TextUtils.isEmpty(this.mPackageName);
        }
        if ("url".equals(this.mType)) {
            return !TextUtils.isEmpty(this.mUrl);
        }
        if (MarketingConstants.LINK_TYPE_INTENT.equals(this.mType)) {
            return !TextUtils.isEmpty(this.mPackageName) && this.mComponent == 1;
        }
        if ("2".equals(str)) {
            return MarketingConstants.LINK_TYPE_IGNORE.equals(this.mType);
        }
        return false;
    }

    public static MarketingLink parse(Bundle bundle) {
        MarketingLink marketingLink = new MarketingLink();
        marketingLink.mType = bundle.getString("type");
        marketingLink.mUrl = bundle.getString("url");
        marketingLink.mRedirectionUrl = bundle.getString(MarketingConstants.LINK_REDIRECTION_URL);
        marketingLink.mPackageName = bundle.getString("pkg");
        marketingLink.mAction = bundle.getString("action");
        marketingLink.mComponent = bundle.getInt(MarketingConstants.INTENT_COMPONENT, 0);
        marketingLink.mData = bundle.getString("data");
        marketingLink.mClassName = bundle.getString(MarketingConstants.INTENT_CLASS);
        marketingLink.mExtra = bundle.getBundle("extra");
        marketingLink.mReferrerAppFilter = bundle.getStringArrayList(MarketingConstants.REFERRER_TYPE_APP_FILTER);
        marketingLink.mBasicReferrer = bundle.getStringArrayList(MarketingConstants.REFERRER_TYPE_BASIC);
        marketingLink.mAppReferrer = bundle.getStringArrayList(MarketingConstants.REFERRER_TYPE_APP);
        marketingLink.mReferrerStrForLandingPage = bundle.getString(MarketingConstants.REFERRER_STR);
        marketingLink.mRequireValidation = bundle.getBoolean(MarketingConstants.LINK_REFERRER_REQUIRE_VALIDATION);
        return marketingLink;
    }
}
