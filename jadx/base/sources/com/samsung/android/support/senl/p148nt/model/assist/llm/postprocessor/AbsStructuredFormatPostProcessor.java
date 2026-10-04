package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.DetailSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.SubContent;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.Title;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.SentenceSeparator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbsStructuredFormatPostProcessor {
    static final String CONTENTS = "contents";
    static final String DETAILS = "details";
    static final String SUBHEADING = "subheading";
    static final String TITLE = "title";
    static final int UNKNOWN_INDEX = -1;
    final AutoFormatResult mResult = new AutoFormatResult();
    final String mSrcText;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AutoFormatResult {
        public Title mTitle = new Title();
        public List<SubContent> mSubContents = new ArrayList();
    }

    public AbsStructuredFormatPostProcessor(String str) {
        this.mSrcText = str;
    }

    public String applyJsonFormat() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", this.mResult.mTitle.getText());
        JsonArray jsonArray = new JsonArray();
        for (SubContent subContent : this.mResult.mSubContents) {
            JsonArray jsonArray2 = new JsonArray();
            Iterator<DetailSentence> it = subContent.mDetails.iterator();
            while (it.hasNext()) {
                jsonArray2.add(it.next().getText());
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("subheading", subContent.getHeader());
            jsonObject2.add("details", jsonArray2);
            jsonArray.add(jsonObject2);
        }
        jsonObject.add("contents", jsonArray);
        return StringUtils.convertUnexpectedChars(new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement) jsonObject).replace("\\t", "\t").replace("\\\t", "\\t").replace("\\\\\"", "\"").replace("\\\"", "\"").replace("\\\\", "\\"));
    }

    public List<Sentence> splitSrcTextByNewLineAndDot() {
        return new SentenceSeparator(this.mSrcText).execute();
    }
}
