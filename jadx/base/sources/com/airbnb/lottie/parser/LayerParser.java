package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LayerParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m3057of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");
    private static final JsonReader.Options TEXT_NAMES = JsonReader.Options.m3057of("d", "a");
    private static final JsonReader.Options EFFECTS_NAMES = JsonReader.Options.m3057of("ty", "nm");

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.LayerParser$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C43461 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        List list = Collections.EMPTY_LIST;
        return new Layer(list, lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, list, new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, list, Layer.MatteType.NONE, null, false, null, null, LBlendMode.NORMAL);
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        Float f;
        boolean z;
        float f4;
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        Layer.MatteType matteType = Layer.MatteType.NONE;
        LBlendMode lBlendMode = LBlendMode.NORMAL;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        boolean z2 = false;
        Layer.MatteType matteType2 = matteType;
        LBlendMode lBlendMode2 = lBlendMode;
        float fNextDouble = 0.0f;
        float endFrame = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        String strNextString = null;
        AnimatableTextFrame documentData = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        BlurEffect blurEffect = null;
        DropShadowEffect dropShadowEffect = null;
        long jNextInt = 0;
        int iDpScale = 0;
        int iDpScale2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        long jNextInt2 = -1;
        float fNextDouble5 = 1.0f;
        String strNextString2 = TelemetryEventStrings.Value.UNSET;
        String strNextString3 = null;
        AnimatableTransform animatableTransform = null;
        Layer.LayerType layerType = null;
        boolean z3 = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    strNextString2 = jsonReader.nextString();
                    z2 = false;
                    break;
                case 1:
                    jNextInt = jsonReader.nextInt();
                    z2 = false;
                    break;
                case 2:
                    strNextString = jsonReader.nextString();
                    z2 = false;
                    break;
                case 3:
                    f4 = fNextDouble5;
                    int iNextInt = jsonReader.nextInt();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (iNextInt < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iNextInt];
                    }
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 4:
                    jNextInt2 = jsonReader.nextInt();
                    z2 = false;
                    break;
                case 5:
                    iDpScale = (int) (Utils.dpScale() * jsonReader.nextInt());
                    z2 = false;
                    break;
                case 6:
                    iDpScale2 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    z2 = false;
                    break;
                case 7:
                    color = Color.parseColor(jsonReader.nextString());
                    z2 = false;
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    z2 = false;
                    break;
                case 9:
                    f4 = fNextDouble5;
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 >= Layer.MatteType.values().length) {
                        lottieComposition.addWarning("Unsupported matte type: " + iNextInt2);
                    } else {
                        matteType2 = Layer.MatteType.values()[iNextInt2];
                        int i = C43461.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[matteType2.ordinal()];
                        if (i == 1) {
                            lottieComposition.addWarning("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            lottieComposition.addWarning("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.incrementMatteOrMaskCount(1);
                    }
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 10:
                    f4 = fNextDouble5;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    lottieComposition.incrementMatteOrMaskCount(arrayList.size());
                    jsonReader.endArray();
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 11:
                    f4 = fNextDouble5;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (contentModel != null) {
                            arrayList2.add(contentModel);
                        }
                    }
                    jsonReader.endArray();
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 12:
                    f4 = fNextDouble5;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int iSelectName = jsonReader.selectName(TEXT_NAMES);
                        if (iSelectName == 0) {
                            documentData = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        } else if (iSelectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 13:
                    f4 = fNextDouble5;
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            int iSelectName2 = jsonReader.selectName(EFFECTS_NAMES);
                            if (iSelectName2 == 0) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    blurEffect = BlurEffectParser.parse(jsonReader, lottieComposition);
                                } else if (iNextInt3 == 25) {
                                    dropShadowEffect = new DropShadowEffectParser().parse(jsonReader, lottieComposition);
                                }
                            } else if (iSelectName2 != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                arrayList3.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 14:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    z2 = false;
                    break;
                case 15:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    z2 = false;
                    break;
                case 16:
                    f4 = fNextDouble5;
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) Utils.dpScale()));
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 17:
                    f4 = fNextDouble5;
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) Utils.dpScale()));
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
                case 18:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 19:
                    endFrame = (float) jsonReader.nextDouble();
                    break;
                case 20:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z2);
                    break;
                case 21:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 22:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 23:
                    z3 = jsonReader.nextInt() != 1 ? z2 : true;
                    break;
                case 24:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= LBlendMode.values().length) {
                        lottieComposition.addWarning("Unsupported Blend Mode: " + iNextInt4);
                        lBlendMode2 = LBlendMode.NORMAL;
                    } else {
                        lBlendMode2 = LBlendMode.values()[iNextInt4];
                    }
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    f4 = fNextDouble5;
                    fNextDouble5 = f4;
                    z2 = false;
                    break;
            }
        }
        float f5 = fNextDouble5;
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble > 0.0f) {
            z = z3;
            f = fValueOf;
            arrayList4.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble)));
        } else {
            f = fValueOf;
            z = z3;
        }
        if (endFrame <= 0.0f) {
            endFrame = lottieComposition.getEndFrame();
        }
        arrayList4.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, fNextDouble, Float.valueOf(endFrame)));
        arrayList4.add(new Keyframe(lottieComposition, f, f, null, endFrame, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        if (z) {
            if (animatableTransform == null) {
                animatableTransform = new AnimatableTransform();
            }
            animatableTransform.setAutoOrient(z);
        }
        return new Layer(arrayList2, lottieComposition, strNextString2, jNextInt, layerType, jNextInt2, strNextString, arrayList, animatableTransform, iDpScale, iDpScale2, color, f5, fNextDouble4, fNextDouble2, fNextDouble3, documentData, animatableTextProperties, arrayList4, matteType2, animatableFloatValue, zNextBoolean, blurEffect, dropShadowEffect, lBlendMode2);
    }
}
