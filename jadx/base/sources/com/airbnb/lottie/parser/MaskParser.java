package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class MaskParser {
    private MaskParser() {
    }

    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strNextName;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue shapeData = null;
        AnimatableIntegerValue integer = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case "pt":
                    shapeData = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.getClass();
                    switch (strNextString) {
                        case "a":
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case "i":
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            Logger.warning("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, shapeData, integer, zNextBoolean);
    }
}
