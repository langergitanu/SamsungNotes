package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import opennlp.tools.parser.Parse;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SummaryResultParser {
    private static final String ATTR_KEYWORDS = "keywords";
    private static final String ATTR_SUMMARY = "summary";
    private static final String ATTR_TITLE = "title";
    private static final String TAG = "AI#SummaryResult";
    private boolean mEnd;
    private int mIndex;
    private ArrayList<String> mKeywords;
    private ArrayList<String> mSummaries;
    private String mTitle;

    public SummaryResultParser() {
        this.mIndex = 0;
        this.mEnd = true;
        this.mTitle = "";
        this.mSummaries = new ArrayList<>();
        this.mKeywords = new ArrayList<>();
        this.mIndex = 0;
        this.mEnd = true;
    }

    private boolean isValidSummaryResult() {
        if (TextUtils.isEmpty(this.mTitle) || (this.mTitle.contains("\"title\"") && this.mTitle.contains("\"summary\"") && this.mTitle.contains("\"keywords\""))) {
            Logger.m11003i(TAG, "isValidSummaryResult# false by title : " + LoggerBase.getEncode(this.mTitle));
            return false;
        }
        ArrayList<String> arrayList = this.mSummaries;
        if (arrayList == null) {
            return true;
        }
        for (String str : arrayList) {
            if (TextUtils.isEmpty(str) || (str.contains("\"title\"") && str.contains("\"summary\"") && str.contains("\"keywords\""))) {
                Logger.m11003i(TAG, "isValidSummaryResult# false by str : " + LoggerBase.getEncode(str));
                return false;
            }
        }
        return true;
    }

    private void parseSummaryResultPlain(String str) {
        Logger.m11003i(TAG, "parseSummaryResultPlain# text : " + LoggerBase.getEncode(str));
        if (str == null) {
            return;
        }
        this.mSummaries = new ArrayList<>();
        this.mKeywords = new ArrayList<>();
        try {
            String[] strArrSplit = str.split("\"");
            if (strArrSplit.length <= 1) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            char c = 0;
            for (String str2 : strArrSplit) {
                if (!str2.equalsIgnoreCase(SQLKeyword.COMMA) && !str2.contains(":") && !str2.contains("]") && !str2.contains(",\n")) {
                    if (str2.compareToIgnoreCase("title") == 0) {
                        c = 1;
                    } else if (str2.compareToIgnoreCase("summary") == 0) {
                        c = 2;
                    } else if (str2.compareToIgnoreCase("keywords") == 0) {
                        c = 4;
                    } else {
                        if (!TextUtils.isEmpty(spannableStringBuilder)) {
                            Logger.m11003i(TAG, "parseSummaryResultPlain# add summary length : " + spannableStringBuilder.length() + ", data : " + LoggerBase.getEncode(spannableStringBuilder.toString()));
                            this.mSummaries.add(spannableStringBuilder.toString());
                            spannableStringBuilder.clear();
                        }
                        if (c == 1) {
                            Logger.m11003i(TAG, "parseSummaryResultPlain# add title. length : " + str2.length() + ", data : " + LoggerBase.getEncode(str2));
                            this.mTitle = str2;
                        } else if (c != 2) {
                            if (c != 3) {
                                if (c == 4) {
                                    Logger.m11003i(TAG, "parseSummaryResultPlain# add keywords. length : " + str2.length() + ", data : " + LoggerBase.getEncode(str2));
                                    this.mKeywords.add(str2);
                                }
                            } else if (str2.endsWith("\\")) {
                                spannableStringBuilder.append((CharSequence) str2.substring(0, str2.length() - 1)).append((CharSequence) "\"");
                            } else {
                                spannableStringBuilder.append((CharSequence) str2);
                                c = 2;
                            }
                        } else if (str2.endsWith("\\")) {
                            spannableStringBuilder.append((CharSequence) str2.substring(0, str2.length() - 1)).append((CharSequence) "\"");
                            c = 3;
                        } else {
                            Logger.m11003i(TAG, "parseSummaryResultPlain# add summary. length : " + str2.length() + ", data : " + LoggerBase.getEncode(str2));
                            this.mSummaries.add(str2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("Failed to parse plain string : "), TAG);
        }
    }

    private String trimJsonString(String str) {
        int iIndexOf = str.indexOf(Parse.BRACKET_LCB);
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("[");
        }
        if (iIndexOf == -1) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf("}");
        if (iLastIndexOf == -1) {
            iLastIndexOf = str.lastIndexOf("]");
        }
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(iIndexOf, iLastIndexOf + 1).replace("\\n", "").replace("\\", "");
    }

    public boolean getEnd() {
        return this.mEnd;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public ArrayList<String> getKeywords() {
        return this.mKeywords;
    }

    public SummaryResultParser getNext() {
        this.mIndex++;
        SummaryResultParser summaryResultParser = new SummaryResultParser();
        summaryResultParser.mTitle = "";
        summaryResultParser.mSummaries = new ArrayList<>();
        summaryResultParser.mKeywords = this.mKeywords;
        summaryResultParser.mEnd = false;
        int length = this.mTitle.length() - 1;
        int i = this.mIndex;
        if (length > i) {
            String str = this.mTitle;
            summaryResultParser.mTitle = str.substring(0, str.length() + (i - length));
            return summaryResultParser;
        }
        summaryResultParser.mTitle = this.mTitle;
        for (String str2 : this.mSummaries) {
            length += str2.length();
            int i2 = this.mIndex;
            if (length > i2) {
                summaryResultParser.mSummaries.add(str2.substring(0, str2.length() + (i2 - length)));
                return summaryResultParser;
            }
            summaryResultParser.mSummaries.add(str2);
        }
        summaryResultParser.mEnd = true;
        return summaryResultParser;
    }

    public ArrayList<String> getSummaries() {
        return this.mSummaries;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setKeywords(ArrayList<String> arrayList) {
        this.mKeywords = arrayList;
    }

    public void setSummaries(ArrayList<String> arrayList) {
        this.mSummaries = arrayList;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SummaryResult{title='");
        sb.append(this.mTitle);
        sb.append("', summary=");
        sb.append(this.mSummaries);
        sb.append(", keywords=");
        sb.append(this.mKeywords);
        sb.append(", index=");
        sb.append(this.mIndex);
        sb.append(", end=");
        return AbstractC0622a.m1172r(sb, this.mEnd, '}');
    }

    public SummaryResultParser(String str) {
        this.mIndex = 0;
        this.mEnd = true;
        if (SCSTools.getRequestType().equals(AppInfo.RequestType.CLOUD)) {
            try {
                String strTrimJsonString = trimJsonString(str);
                if (TextUtils.isEmpty(strTrimJsonString)) {
                    Logger.m11004w(TAG, "Failed to parse json string. This is not json string");
                    parseSummaryResultPlain(str);
                }
                JSONObject jSONObject = new JSONObject(strTrimJsonString);
                String string = jSONObject.getString("title");
                JSONArray jSONArray = jSONObject.getJSONArray("summary");
                JSONArray jSONArray2 = jSONObject.has("keywords") ? jSONObject.getJSONArray("keywords") : new JSONArray();
                this.mTitle = string.trim();
                this.mSummaries = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String strTrim = jSONArray.getString(i).replace("\"", "\\\"").trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        this.mSummaries.add(strTrim);
                    }
                }
                this.mKeywords = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.mKeywords.add(jSONArray2.getString(i2).trim());
                }
                if (isValidSummaryResult()) {
                    return;
                }
                parseSummaryResultPlain(str);
                return;
            } catch (Exception e) {
                Logger.m11004w(TAG, "Failed to parse json string : " + e.getMessage());
                parseSummaryResultPlain(str);
                return;
            }
        }
        this.mTitle = "title1";
        ArrayList<String> arrayList = new ArrayList<>();
        this.mSummaries = arrayList;
        arrayList.add(str);
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.mKeywords = arrayList2;
        arrayList2.add("keyword1");
        this.mKeywords.add("keyword2");
    }
}
