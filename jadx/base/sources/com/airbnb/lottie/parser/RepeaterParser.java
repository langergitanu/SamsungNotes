package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class RepeaterParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    public static Repeater parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strNextString = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (iSelectName == 2) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (iSelectName == 3) {
                animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
            } else if (iSelectName != 4) {
                jsonReader.skipValue();
            } else {
                zNextBoolean = jsonReader.nextBoolean();
            }
        }
        return new Repeater(strNextString, animatableFloatValue, animatableFloatValue2, animatableTransform, zNextBoolean);
    }
}
