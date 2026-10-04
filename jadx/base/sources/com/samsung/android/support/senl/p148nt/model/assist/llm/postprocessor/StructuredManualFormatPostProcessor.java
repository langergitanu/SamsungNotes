package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.DetailSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.SubContent;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StructuredManualFormatPostProcessor extends AbsStructuredFormatPostProcessor {
    private static final String SUMMARY = "summary";
    private static final String TAG = "Ai$StructuredManualFormatPostProcessor";
    private final ResultData mCoverResult;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultData {
        String mData;
        String mTitle = "";
        String mSummary = "";

        public ResultData(String str) {
            this.mData = str;
        }
    }

    public StructuredManualFormatPostProcessor(String str, String str2) {
        super(str);
        this.mCoverResult = new ResultData(str2);
    }

    private void applyManualFormatting(List<Sentence> list) {
        Logger.m8697d(TAG, "applyManualFormatting");
        SubContent subContent = new SubContent();
        if (!TextUtils.isEmpty(this.mCoverResult.mData) ? parseResultData() : false) {
            this.mResult.mTitle.setText(this.mCoverResult.mTitle);
            subContent.setHeader(this.mCoverResult.mSummary);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new DetailSentence(i, list.get(i).getText()));
        }
        subContent.mDetails = arrayList;
        this.mResult.mSubContents.clear();
        this.mResult.mSubContents.add(subContent);
    }

    private String parse(String str, String str2) {
        int length = str.length() + str2.indexOf(str);
        if (length <= str.length()) {
            return "";
        }
        String strReplaceAll = str2.substring(length).replaceAll("\"", "").replaceAll(":", "").replaceAll(",$", "");
        int length2 = strReplaceAll.length();
        int iCharCount = 0;
        while (iCharCount < length2) {
            int iCodePointAt = strReplaceAll.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return strReplaceAll.substring(iCharCount, length2);
    }

    private boolean parseResultData() {
        String[] strArrSplit = this.mCoverResult.mData.replace("\\n", "\n").split("\n");
        Logger.m8697d(TAG, "parseResultData# extractResult size : " + strArrSplit.length);
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String str = strArrSplit[i];
            if (str.contains("title")) {
                this.mCoverResult.mTitle = StringUtils.convertUnexpectedChars(parse("title", str));
            } else if (str.contains("summary")) {
                this.mCoverResult.mSummary = StringUtils.convertUnexpectedChars(parse("summary", str));
            }
        }
        return (TextUtils.isEmpty(this.mCoverResult.mTitle) || TextUtils.isEmpty(this.mCoverResult.mSummary)) ? false : true;
    }

    public String getResult() {
        applyManualFormatting(splitSrcTextByNewLineAndDot());
        return applyJsonFormat();
    }
}
