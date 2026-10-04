package com.samsung.android.sdk.scs.base.feature;

import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.StatusCodes;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.HashMap;
import p184g4.C12014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class FeatureStatusCache {
    private static final String TAG = "ScsApi@FeatureHolder";
    private static final HashMap<String, Integer> statusMap;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        statusMap = map;
        map.put("FEATURE_IMAGE_GET_BOUNDARIES", -1000);
        map.put("FEATURE_IMAGE_GET_LARGEST_BOUNDARY", -1000);
        map.put("FEATURE_SUGGESTION_SUGGEST_KEYWORD", -1000);
        map.put("FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY", -1000);
        map.put("FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY_DETAILS", -1000);
        map.put("FEATURE_SUGGESTION_SUGGEST_FOLDER_NAME", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_DATETIME_NUMERAL", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_DATETIME_SEARCH", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_PHONE_NUMBER", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_POI", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_BANK", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_IS_MAPPABLE", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_IS_RELATIVE", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_IS_SPECIAL_DAY", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_HAS_YEAR_MONTH_DAY", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_UPI_ID", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_UNIT", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_START_OF_WEEK", -1000);
        map.put("FEATURE_TEXT_GET_ENTITY_LOCAL_DATE_TIME", -1000);
        map.put("FEATURE_TEXT_GET_EVENT", -1000);
        map.put("FEATURE_TEXT_GET_EVENT_HAS_YEAR_MONTH_DAY", -1000);
        map.put("FEATURE_TEXT_GET_EVENT_INDEX", -1000);
        map.put("FEATURE_TEXT_GET_KEY_PHRASE", -1000);
        map.put("FEATURE_TEXT_GET_KEY_PHRASE_EVENT_TITLE", -1000);
        map.put("FEATURE_TEXT_GET_DOCUMENT_CATEGORY", -1000);
        map.put("FEATURE_TEXT_GET_BNLP", -1000);
        map.put("FEATURE_TEXT_GET_BNLP_TOKEN", -1000);
        map.put("FEATURE_TEXT_GET_BNLP_LIGHT_MODEL", -1000);
        map.put("FEATURE_TEXT_DETECT_LANGUAGE", -1000);
        map.put("FEATURE_TEXT_CONVERT_UNIT", -1000);
        map.put("FEATURE_TEXT_GET_REMINDER_ENTITY", -1000);
        map.put("FEATURE_TEXT_GET_EVENT_CATEGORY", -1000);
        map.put("FEATURE_NATURAL_LANGUAGE_QUERY", -1000);
    }

    public static void clear() {
        statusMap.replaceAll(new C12014a(17));
    }

    @StatusCodes.checkFeatureResult
    public static int getStatus(@Feature.featureName String str) {
        Integer num = statusMap.get(str);
        if (num == null) {
            return -1000;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$clear$0(String str, Integer num) {
        return -1000;
    }

    public static void setStatus(@Feature.featureName String str, @StatusCodes.checkFeatureResult int i) {
        statusMap.put(str, Integer.valueOf(i));
        Log.m6489i(TAG, "setStatus() : " + str + " : " + i);
    }
}
