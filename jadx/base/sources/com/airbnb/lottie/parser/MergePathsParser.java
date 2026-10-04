package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class MergePathsParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("nm", "mm", "hd");

    private MergePathsParser() {
    }

    public static MergePaths parse(JsonReader jsonReader) {
        String strNextString = null;
        boolean zNextBoolean = false;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (iSelectName != 2) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                zNextBoolean = jsonReader.nextBoolean();
            }
        }
        return new MergePaths(strNextString, mergePathsModeForId, zNextBoolean);
    }
}
