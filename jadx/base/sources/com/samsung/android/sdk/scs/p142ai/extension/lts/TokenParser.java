package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenParser {
    private static final String COUNT_KEY = "count";
    private static final String COUNT_MAX_KEY = "countMax";
    private static final String DIGIT_PATTERN = "\\d+";
    private static final String KEY_PATTERN_FORMAT = "\"%s\":%s%s%s";
    private static final String NEGATIVE_NUMBER_PATTERN = "-(\\d+)";
    private static final String NEGATIVE_SIGN = "-";
    private static final String[] PATTERNS = {"\"count\":\"(\\d+)\"", "\"count\":\"-(\\d+)\"", "\"countMax\":\"(\\d+)\"", "\"countMax\":\"-(\\d+)\""};
    private static final String POSITIVE_PATTERN = "(\\d+)";
    private static final String QUOTE = "\"";
    private static final String TAG = "TokenParser";

    private static Map.Entry<String, String> calculateTokenValue(String str, String str2) {
        String str3 = COUNT_MAX_KEY;
        if (!str.contains(COUNT_MAX_KEY)) {
            str3 = "count";
        }
        String str4 = str.contains(NEGATIVE_NUMBER_PATTERN) ? "-" : "";
        Log.i(TAG, str3 + " : " + str4 + str2);
        return new AbstractMap.SimpleEntry(str3, AbstractC0541b.m756B(str4, str2));
    }

    public static Map<String, String> getToken(String str) {
        HashMap map = new HashMap();
        for (String str2 : PATTERNS) {
            String token = parseToken(str, str2);
            if (!token.isEmpty()) {
                Map.Entry<String, String> entryCalculateTokenValue = calculateTokenValue(str2, token);
                map.put(entryCalculateTokenValue.getKey(), entryCalculateTokenValue.getValue());
            }
        }
        return map;
    }

    private static String parseToken(String str, String str2) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (!matcher.find()) {
            AbstractC6670b.m4756q("No match found : ", str2, TAG);
            return "";
        }
        String strGroup = matcher.group(1);
        Log.i(TAG, strGroup);
        return strGroup;
    }
}
