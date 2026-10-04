package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class BlurEffectParser {
    private static final JsonReader.Options BLUR_EFFECT_NAMES = JsonReader.Options.m3057of("ef");
    private static final JsonReader.Options INNER_BLUR_EFFECT_NAMES = JsonReader.Options.m3057of("ty", VPathDataCmd.RCurveTo);

    @Nullable
    private static BlurEffect maybeParseInnerEffect(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        BlurEffect blurEffect = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                int iSelectName = jsonReader.selectName(INNER_BLUR_EFFECT_NAMES);
                if (iSelectName != 0) {
                    if (iSelectName != 1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else if (z) {
                        blurEffect = new BlurEffect(AnimatableValueParser.parseFloat(jsonReader, lottieComposition));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (jsonReader.nextInt() == 0) {
                    z = true;
                }
            }
            jsonReader.endObject();
            return blurEffect;
        }
    }

    @Nullable
    public static BlurEffect parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        BlurEffect blurEffect = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(BLUR_EFFECT_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    BlurEffect blurEffectMaybeParseInnerEffect = maybeParseInnerEffect(jsonReader, lottieComposition);
                    if (blurEffectMaybeParseInnerEffect != null) {
                        blurEffect = blurEffectMaybeParseInnerEffect;
                    }
                }
                jsonReader.endArray();
            }
        }
        return blurEffect;
    }
}
