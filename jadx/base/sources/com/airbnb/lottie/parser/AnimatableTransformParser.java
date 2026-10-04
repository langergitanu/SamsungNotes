package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AnimatableTransformParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    private static final JsonReader.Options ANIMATABLE_NAMES = JsonReader.Options.m3057of("k");

    private AnimatableTransformParser() {
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        if (animatablePathValue != null) {
            return animatablePathValue.isStatic() && animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue != null) {
            return !(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null) {
            return animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        if (animatableScaleValue != null) {
            return animatableScaleValue.isStatic() && ((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null) {
            return animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null) {
            return animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableFloatValue animatableFloatValue;
        LottieComposition lottieComposition2 = lottieComposition;
        Float fValueOf = Float.valueOf(0.0f);
        boolean z = jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatablePathValue animatablePathValue = null;
        AnimatableValue<PointF, PointF> splitPath = null;
        AnimatableScaleValue scale = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableIntegerValue integer = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(ANIMATABLE_NAMES) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    lottieComposition2 = lottieComposition;
                    break;
                case 1:
                    splitPath = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    lottieComposition2 = lottieComposition;
                    break;
                case 2:
                    scale = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                    lottieComposition2 = lottieComposition;
                    break;
                case 3:
                    lottieComposition2.addWarning("Lottie doesn't support 3D layers.");
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    if (!animatableFloatValue.getKeyframes().isEmpty()) {
                        animatableFloatValue.getKeyframes().add(new Keyframe(lottieComposition2, fValueOf, fValueOf, null, 0.0f, Float.valueOf(lottieComposition2.getEndFrame())));
                    } else if (((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue == 0) {
                        animatableFloatValue.getKeyframes().set(0, new Keyframe(lottieComposition, fValueOf, fValueOf, null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
                    }
                    lottieComposition2 = lottieComposition;
                    animatableFloatValue2 = animatableFloatValue;
                    break;
                case 4:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    if (!animatableFloatValue.getKeyframes().isEmpty()) {
                    }
                    lottieComposition2 = lottieComposition;
                    animatableFloatValue2 = animatableFloatValue;
                    break;
                case 5:
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    break;
                case 7:
                    animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    break;
                case 8:
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    break;
                case 9:
                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition2, false);
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        if (z) {
            jsonReader.endObject();
        }
        AnimatablePathValue animatablePathValue2 = isAnchorPointIdentity(animatablePathValue) ? null : animatablePathValue;
        if (isPositionIdentity(splitPath)) {
            splitPath = null;
        }
        return new AnimatableTransform(animatablePathValue2, splitPath, isScaleIdentity(scale) ? null : scale, isRotationIdentity(animatableFloatValue2) ? null : animatableFloatValue2, integer, animatableFloatValue5, animatableFloatValue6, isSkewIdentity(animatableFloatValue3) ? null : animatableFloatValue3, isSkewAngleIdentity(animatableFloatValue4) ? null : animatableFloatValue4);
    }
}
