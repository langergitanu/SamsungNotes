package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SummarizationOnDevice {
    private static final String LANGUAGE = "language";
    private static final String TAG = Logger.createTag("SummarizationOnDevice", AiConstants.PREFIX_TAG);

    public static boolean supportSummaryOnDevice(String str) {
        Bundle bundle;
        boolean z = false;
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null && (bundle = applicationContext.getPackageManager().getApplicationInfo(Features.OFFLINE_LANGUAGE_MODEL_APP_INFO, 128).metaData) != null) {
                JSONArray jSONArray = new JSONArray(bundle.getString(Features.OFFLINE_LANGUAGE_MODEL_FUNC_INFO));
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (str.equals(jSONObject.getString("language")) && jSONObject.getString(Features.META_FUNCTION).contains(Features.FUNCTION)) {
                        z = true;
                        break;
                    }
                    i++;
                }
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException | JSONException e) {
            AbstractC8014b.m7205g(e, new StringBuilder("supportSummaryOnDevice# e : "), TAG);
        }
        Logger.m10999d(TAG, "supportSummaryOnDevice# language : " + str + ", isSupport : " + z);
        return z;
    }
}
