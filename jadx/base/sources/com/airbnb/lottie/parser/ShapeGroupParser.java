package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class ShapeGroupParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("nm", "hd", LangPackConfigConstants.LANGUAGE_CODE_IT);

    private ShapeGroupParser() {
    }

    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (iSelectName != 2) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                    if (contentModel != null) {
                        arrayList.add(contentModel);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new ShapeGroup(strNextString, arrayList, zNextBoolean);
    }
}
