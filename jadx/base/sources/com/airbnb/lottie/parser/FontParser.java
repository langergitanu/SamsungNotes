package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class FontParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("fFamily", "fName", "fStyle", "ascent");

    private FontParser() {
    }

    public static Font parse(JsonReader jsonReader) {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        float fNextDouble = 0.0f;
        String strNextString3 = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                strNextString3 = jsonReader.nextString();
            } else if (iSelectName == 2) {
                strNextString2 = jsonReader.nextString();
            } else if (iSelectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                fNextDouble = (float) jsonReader.nextDouble();
            }
        }
        jsonReader.endObject();
        return new Font(strNextString, strNextString3, strNextString2, fNextDouble);
    }
}
