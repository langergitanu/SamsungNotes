package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class RectangleShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("nm", "p", "s", "r", "hd");

    private RectangleShapeParser() {
    }

    public static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strNextString = null;
        AnimatableValue<PointF, PointF> splitPath = null;
        AnimatablePointValue point = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                splitPath = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
            } else if (iSelectName == 2) {
                point = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
            } else if (iSelectName == 3) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (iSelectName != 4) {
                jsonReader.skipValue();
            } else {
                zNextBoolean = jsonReader.nextBoolean();
            }
        }
        return new RectangleShape(strNextString, splitPath, point, animatableFloatValue, zNextBoolean);
    }
}
