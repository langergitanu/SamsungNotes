package com.samsung.android.imagetranslation.util;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.BasicNlpAnalyzer;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.Token;
import com.samsung.android.sdk.scs.p142ai.text.language.LanguageDetector;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class NLPAnalyzer {
    private static final String TAG = "NLPAnalyzer";
    private static Boolean isBNLPSupported;
    private final BasicNlpAnalyzer mBasicNlpAnalyzer;
    private final LanguageDetector mLanguageDetector;

    public NLPAnalyzer(@NonNull Context context) {
        if (isBNLPSupported == null) {
            isBNLPSupported = Boolean.valueOf(Stream.of((Object[]) new String[]{"FEATURE_TEXT_GET_BNLP_TOKEN", "FEATURE_TEXT_DETECT_LANGUAGE"}).allMatch(new C7139h(context, 1)));
            LTTLogger.m5458d(TAG, "check BNLP supported : " + isBNLPSupported);
        }
        this.mBasicNlpAnalyzer = AiServices.getBasicNlpAnalyzer(context.getApplicationContext());
        this.mLanguageDetector = AiServices.getLanguageDetector(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isSentenceBlock$1(Token token) {
        String posTag = token.getPosTag();
        if (posTag.equals("pron")) {
            return true;
        }
        return posTag.equals("interp") && "?!".contains(token.getRawText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Context context, String str) {
        return Feature.checkFeature(context, str) == 0;
    }

    public boolean isSentenceBlock(@NonNull LttOcrResult.BlockInfo blockInfo) {
        Boolean bool = isBNLPSupported;
        if (bool != null && bool.booleanValue() && this.mBasicNlpAnalyzer != null && this.mLanguageDetector != null) {
            String string = blockInfo.getString();
            if (string.isEmpty()) {
                return false;
            }
            String strDetect = this.mLanguageDetector.detect(string);
            if (strDetect != null && this.mBasicNlpAnalyzer.isSupportedLanguage(strDetect)) {
                List<Token> listAnalyzeToken = this.mBasicNlpAnalyzer.analyzeToken(strDetect, string);
                if (listAnalyzeToken == null) {
                    return false;
                }
                boolean zAnyMatch = listAnalyzeToken.stream().anyMatch(new C7141j(1));
                LTTLogger.m5458d(TAG, "sentence block: " + zAnyMatch);
                return zAnyMatch;
            }
            LTTLogger.m5458d(TAG, "Not supported language: " + strDetect);
        }
        return false;
    }
}
