package com.samsung.android.sdk.scs.p142ai.suggestion;

import com.samsung.android.scs.p140ai.sdkcommon.suggestion.SuggestionConst;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum KeywordSuggestionType {
    MEDIA(SuggestionConst.CLIENT_GALLERY);

    private static final Map<String, KeywordSuggestionType> mEnumMap;
    private final String mSuggestionType;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (KeywordSuggestionType keywordSuggestionType : values()) {
            concurrentHashMap.put(keywordSuggestionType.getType(), keywordSuggestionType);
        }
        mEnumMap = Collections.unmodifiableMap(concurrentHashMap);
    }

    KeywordSuggestionType(String str) {
        this.mSuggestionType = str;
    }

    public static KeywordSuggestionType get(String str) {
        return mEnumMap.get(str);
    }

    public String getType() {
        return this.mSuggestionType;
    }
}
