package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SpellingCorrectorPostProcessor {
    private static final String TAG = "Ai$SpellingCorrectorPostProcessor";
    private static final String TAG_INPUT = "[input]";
    private static final String TAG_OUTPUT = "[output]";
    private final String mInput;
    private final String mResult;
    private static final String DOUBLE_ASTERISKS = "**";
    private static final String TRIPLE_ASTERISKS = "***";
    private static final String[] TAG_SYMBOLS = {"", DOUBLE_ASTERISKS, TRIPLE_ASTERISKS};

    public SpellingCorrectorPostProcessor(String str, String str2) {
        this.mInput = str;
        this.mResult = str2;
    }

    private String extractOutputResult(String str) {
        return this.mResult.substring(str.length() + this.mResult.toLowerCase().lastIndexOf(str));
    }

    private String findContainedOutputTag() {
        for (String str : TAG_SYMBOLS) {
            String strM2221l = AbstractC2821a.m2221l(str, TAG_OUTPUT, str, "\n");
            if (this.mResult.toLowerCase().contains(strM2221l)) {
                return strM2221l;
            }
        }
        return "";
    }

    private String removeAsterisks(String str) {
        if (!this.mInput.contains(TRIPLE_ASTERISKS)) {
            str = str.replace(TRIPLE_ASTERISKS, "");
        }
        if (!this.mInput.contains(DOUBLE_ASTERISKS)) {
            str = str.replace(DOUBLE_ASTERISKS, "");
        }
        String strReplace = str.replace("\r\n", "\n");
        for (String str2 : strReplace.split("\\n")) {
            String strTrim = str2.trim();
            if (strTrim.length() >= 3 && !this.mInput.contains(strTrim)) {
                Integer num = (strTrim.startsWith(TRIPLE_ASTERISKS) && strTrim.endsWith(TRIPLE_ASTERISKS)) ? 3 : (strTrim.startsWith(DOUBLE_ASTERISKS) && strTrim.endsWith(DOUBLE_ASTERISKS)) ? 2 : null;
                if (num != null) {
                    int length = strTrim.length() - num.intValue();
                    if (num.intValue() >= length) {
                        Logger.m8698e(TAG, "removeDoubleAsterisks, [s/e]: [" + num + "/" + length + "] ");
                    } else {
                        strReplace = strReplace.replace(strTrim, strTrim.substring(num.intValue(), length));
                    }
                }
            }
        }
        return strReplace;
    }

    private String removeInputTag() {
        String strTrim = this.mResult.trim();
        String strTrim2 = this.mInput.toLowerCase().trim();
        String strTrim3 = this.mResult.toLowerCase().trim();
        for (String str : TAG_SYMBOLS) {
            String strM2221l = AbstractC2821a.m2221l(str, TAG_INPUT, str, "\n");
            if (!strTrim2.startsWith(strM2221l) && strTrim3.startsWith(strM2221l)) {
                return strTrim.substring(strM2221l.length());
            }
        }
        return this.mResult;
    }

    private String removeTag() {
        String strFindContainedOutputTag = findContainedOutputTag();
        return !TextUtils.isEmpty(strFindContainedOutputTag) ? extractOutputResult(strFindContainedOutputTag) : removeInputTag();
    }

    public String getResult() {
        return TextUtils.isEmpty(this.mInput) ? this.mInput : removeAsterisks(removeTag());
    }
}
