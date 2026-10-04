package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Layer {
    private final LBlendMode blendMode;

    @Nullable
    private final BlurEffect blurEffect;
    private final LottieComposition composition;

    @Nullable
    private final DropShadowEffect dropShadowEffect;
    private final boolean hidden;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final float preCompHeight;
    private final float preCompWidth;

    @Nullable
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;

    @Nullable
    private final AnimatableTextFrame text;

    @Nullable
    private final AnimatableTextProperties textProperties;

    @Nullable
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i, int i2, int i4, float f, float f4, float f5, float f6, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, @Nullable AnimatableFloatValue animatableFloatValue, boolean z, @Nullable BlurEffect blurEffect, @Nullable DropShadowEffect dropShadowEffect, LBlendMode lBlendMode) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j;
        this.layerType = layerType;
        this.parentId = j2;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = i;
        this.solidHeight = i2;
        this.solidColor = i4;
        this.timeStretch = f;
        this.startFrame = f4;
        this.preCompWidth = f5;
        this.preCompHeight = f6;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType;
        this.timeRemapping = animatableFloatValue;
        this.hidden = z;
        this.blurEffect = blurEffect;
        this.dropShadowEffect = dropShadowEffect;
        this.blendMode = lBlendMode;
    }

    @Nullable
    public LBlendMode getBlendMode() {
        return this.blendMode;
    }

    @Nullable
    public BlurEffect getBlurEffect() {
        return this.blurEffect;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    @Nullable
    public DropShadowEffect getDropShadowEffect() {
        return this.dropShadowEffect;
    }

    public long getId() {
        return this.layerId;
    }

    public List<Keyframe<Float>> getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    public List<Mask> getMasks() {
        return this.masks;
    }

    public MatteType getMatteType() {
        return this.matteType;
    }

    public String getName() {
        return this.layerName;
    }

    public long getParentId() {
        return this.parentId;
    }

    public float getPreCompHeight() {
        return this.preCompHeight;
    }

    public float getPreCompWidth() {
        return this.preCompWidth;
    }

    @Nullable
    public String getRefId() {
        return this.refId;
    }

    public List<ContentModel> getShapes() {
        return this.shapes;
    }

    public int getSolidColor() {
        return this.solidColor;
    }

    public int getSolidHeight() {
        return this.solidHeight;
    }

    public int getSolidWidth() {
        return this.solidWidth;
    }

    public float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    @Nullable
    public AnimatableTextFrame getText() {
        return this.text;
    }

    @Nullable
    public AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    @Nullable
    public AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    public float getTimeStretch() {
        return this.timeStretch;
    }

    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString(String str) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append(getName());
        sbM1324q.append("\n");
        Layer layerLayerModelForId = this.composition.layerModelForId(getParentId());
        if (layerLayerModelForId != null) {
            sbM1324q.append("\t\tParents: ");
            sbM1324q.append(layerLayerModelForId.getName());
            Layer layerLayerModelForId2 = this.composition.layerModelForId(layerLayerModelForId.getParentId());
            while (layerLayerModelForId2 != null) {
                sbM1324q.append("->");
                sbM1324q.append(layerLayerModelForId2.getName());
                layerLayerModelForId2 = this.composition.layerModelForId(layerLayerModelForId2.getParentId());
            }
            sbM1324q.append(str);
            sbM1324q.append("\n");
        }
        if (!getMasks().isEmpty()) {
            sbM1324q.append(str);
            sbM1324q.append("\tMasks: ");
            sbM1324q.append(getMasks().size());
            sbM1324q.append("\n");
        }
        if (getSolidWidth() != 0 && getSolidHeight() != 0) {
            sbM1324q.append(str);
            sbM1324q.append("\tBackground: ");
            sbM1324q.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor())));
        }
        if (!this.shapes.isEmpty()) {
            sbM1324q.append(str);
            sbM1324q.append("\tShapes:\n");
            for (ContentModel contentModel : this.shapes) {
                sbM1324q.append(str);
                sbM1324q.append("\t\t");
                sbM1324q.append(contentModel);
                sbM1324q.append("\n");
            }
        }
        return sbM1324q.toString();
    }

    public String toString() {
        return toString("");
    }
}
