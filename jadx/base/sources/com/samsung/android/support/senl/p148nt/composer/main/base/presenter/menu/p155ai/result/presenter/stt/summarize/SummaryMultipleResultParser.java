package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SummaryMultipleResultParser {
    private static final String JSON_VALUE_BEGIN = "```json";
    private static final String JSON_VALUE_END = "```";
    private static final String TAG = "AI#SummaryMultipleResultParser";
    private final ArrayList<SummaryResultParser> resultParsers;

    public SummaryMultipleResultParser(String str) {
        ArrayList<SummaryResultParser> arrayList = new ArrayList<>();
        this.resultParsers = arrayList;
        if (str == null) {
            return;
        }
        String strReplace = str.replace(JSON_VALUE_BEGIN, "").replace(JSON_VALUE_END, "");
        if (tryToParseListResult(strReplace)) {
            Logger.m10999d(TAG, "tryToParseListResult# parse success, size " + arrayList.size());
            return;
        }
        Logger.m10999d(TAG, "tryToParseListResult# parse success");
        if (!tryToParseListResult(AbstractC0541b.m756B("[" + strReplace, "]"))) {
            Logger.m11000e(TAG, "tryToParseListResult# error append with square brackets");
            return;
        }
        Logger.m10999d(TAG, "tryToParseListResult# parse success with square brackets, size: " + arrayList.size());
    }

    private boolean tryToParseListResult(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                SummaryResultParser summaryResultParser = new SummaryResultParser(jSONArray.getJSONObject(i).toString());
                if (!summaryResultParser.getSummaries().isEmpty()) {
                    this.resultParsers.add(summaryResultParser);
                }
            }
            return true;
        } catch (Exception e) {
            Logger.m11004w(TAG, "#tryToParseListResult: Warning to parse multiple json string : " + e.getMessage());
            return false;
        }
    }

    public ArrayList<SummaryResultParser> getResultParsers() {
        return this.resultParsers;
    }
}
