package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MarketingButton {
    private ArrayList<MarketingLink> mMarketingLinks;
    private String mTitle;

    public static ArrayList<MarketingButton> parse(Context context, String str, JSONObject jSONObject) throws JSONException {
        ArrayList<MarketingButton> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(MarketingConstants.BUTTON);
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                MarketingButton marketingButton = new MarketingButton();
                marketingButton.mTitle = jSONObject2.getString("title");
                marketingButton.mMarketingLinks = MarketingLink.parse(context, str, jSONObject2);
                arrayList.add(marketingButton);
            }
        }
        return arrayList;
    }

    public ArrayList<MarketingLink> getMarketingLinks() {
        return this.mMarketingLinks;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("title", this.mTitle);
        for (int i = 0; i < 5 && i < getMarketingLinks().size(); i++) {
            bundle.putBundle(AbstractC0000a.m11h(i, "click_link"), getMarketingLinks().get(i).toBundle());
        }
        return bundle;
    }
}
