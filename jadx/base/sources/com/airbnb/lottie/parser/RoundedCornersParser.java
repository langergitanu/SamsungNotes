package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class RoundedCornersParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("nm", "r", "hd");

    private RoundedCornersParser() {
    }

    @Nullable
    public static RoundedCorners parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        boolean zNextBoolean = false;
        String strNextString = null;
        AnimatableFloatValue animatableFloatValue = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, true);
            } else if (iSelectName != 2) {
                jsonReader.skipValue();
            } else {
                zNextBoolean = jsonReader.nextBoolean();
            }
        }
        if (zNextBoolean) {
            return null;
        }
        return new RoundedCorners(strNextString, animatableFloatValue);
    }
}
