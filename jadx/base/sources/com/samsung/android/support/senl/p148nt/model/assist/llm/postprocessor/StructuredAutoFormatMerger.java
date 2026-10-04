package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StructuredAutoFormatMerger {
    private static final String TAG = "Ai$StructuredAutoFormatMerger";
    private String mJsonText;
    private final String QUOTA = "\"";
    private final int NONE = 0;
    private final int FORMATS_EXIST = 1;
    private int mStatus = 0;

    private String extractContents() {
        int iIndexOf = this.mJsonText.indexOf("\"contents\"");
        int iLastIndexOf = this.mJsonText.lastIndexOf("]");
        StringBuilder sb = new StringBuilder("{\n");
        if (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) {
            Logger.m8697d(TAG, "extractContents# can't find contents, add empty contents");
            sb.append("    \"contents\" : []\n}");
        } else {
            String strSubstring = this.mJsonText.substring(iIndexOf, iLastIndexOf + 1);
            sb.append("    ");
            sb.append(strSubstring);
            sb.append("\n}");
        }
        return sb.toString();
    }

    public String getResult(String str) {
        if (this.mStatus == 0) {
            this.mStatus = 1;
            return str;
        }
        this.mJsonText = str;
        return extractContents();
    }
}
