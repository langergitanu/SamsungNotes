package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.adobe.internal.xmp.XMPConst;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.function.IntConsumer;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StreamingSummaryParser {
    private static final String TAG = "StreamingSummaryParser";
    private final SummaryResultParser mResult = new SummaryResultParser();
    private StringBuilder mStreamBuffer;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$parse$0(Deque deque, int i) {
        char c = (char) i;
        if (c == '{' && (deque.isEmpty() || ((Character) deque.peek()).charValue() != '\"')) {
            deque.push(Character.valueOf(c));
            return;
        }
        if (c == '\"') {
            if (!deque.isEmpty() && ((Character) deque.peek()).charValue() == '\"') {
                deque.pop();
                if (deque.isEmpty() || ((Character) deque.peek()).charValue() != ':') {
                    return;
                }
                deque.pop();
                return;
            }
            if (deque.isEmpty() || ((Character) deque.peek()).charValue() != ',') {
                deque.push(Character.valueOf(c));
                return;
            } else {
                deque.pop();
                deque.push(Character.valueOf(c));
                return;
            }
        }
        if (c == ':' && (deque.isEmpty() || ((Character) deque.peek()).charValue() != '\"')) {
            deque.push(Character.valueOf(c));
            return;
        }
        if (c == '[' && !deque.isEmpty() && ((Character) deque.peek()).charValue() != '\"') {
            deque.pop();
            deque.push(Character.valueOf(c));
        } else {
            if (c != ']' || deque.isEmpty() || ((Character) deque.peek()).charValue() == '\"') {
                return;
            }
            deque.pop();
        }
    }

    private void setJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("title");
        JSONArray jSONArray = jSONObject.has(DBSchema.DocumentCover.SUMMARY) ? jSONObject.getJSONArray(DBSchema.DocumentCover.SUMMARY) : new JSONArray();
        JSONArray jSONArray2 = jSONObject.has(SearchIndexablesContract.RawData.COLUMN_KEYWORDS) ? jSONObject.getJSONArray(SearchIndexablesContract.RawData.COLUMN_KEYWORDS) : new JSONArray();
        this.mResult.setTitle(string.trim());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            String strTrim = jSONArray.getString(i).replace("\"", "\\\"").trim();
            if (!TextUtils.isEmpty(strTrim)) {
                arrayList.add(strTrim);
            }
        }
        this.mResult.setSummaries(arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            arrayList2.add(jSONArray2.getString(i2).replace("\"", "\\\"").trim());
        }
        this.mResult.setKeywords(arrayList2);
    }

    public ArrayList<String> getKeywords() {
        return this.mResult.getKeywords();
    }

    public SummaryResultParser getResult() {
        return this.mResult;
    }

    public ArrayList<String> getSummaries() {
        return this.mResult.getSummaries();
    }

    public String getTitle() {
        return this.mResult.getTitle();
    }

    @SuppressLint({WarningType.NewApi})
    public void parse(String str) {
        this.mStreamBuffer = new StringBuilder(str);
        try {
            final ArrayDeque arrayDeque = new ArrayDeque();
            this.mStreamBuffer.chars().forEach(new IntConsumer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.e
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    StreamingSummaryParser.lambda$parse$0(arrayDeque, i);
                }
            });
            StringBuilder sb = new StringBuilder();
            while (!arrayDeque.isEmpty()) {
                char cCharValue = ((Character) arrayDeque.pop()).charValue();
                if (cCharValue == '\"') {
                    char cCharValue2 = ((Character) arrayDeque.peek()).charValue();
                    if (cCharValue2 == ':') {
                        arrayDeque.pop();
                        sb.append('\"');
                    } else if (cCharValue2 == '[') {
                        sb.append('\"');
                    } else {
                        sb.append("\":\"\"");
                    }
                } else if (cCharValue == '[') {
                    sb.append(PropertyUtils.INDEXED_DELIM2);
                } else if (cCharValue == '{') {
                    sb.append('}');
                } else if (cCharValue == ':') {
                    sb.append(XMPConst.ARRAY_ITEM_NAME);
                }
            }
            setJSONObject(this.mStreamBuffer.toString().concat(sb.toString()));
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("parseError 0: "), TAG);
            try {
                setJSONObject(this.mStreamBuffer.toString());
            } catch (Exception e2) {
                AbstractC8014b.m7205g(e2, new StringBuilder("parseError 1: "), TAG);
            }
            try {
                setJSONObject(this.mStreamBuffer.toString().replace("</OutputJSON>}", ""));
            } catch (Exception e3) {
                AbstractC8014b.m7205g(e3, new StringBuilder("parseError: 2"), TAG);
            }
        }
        Logger.m11003i(TAG, "parseResult: \n".concat(this.mResult.toString()));
    }
}
