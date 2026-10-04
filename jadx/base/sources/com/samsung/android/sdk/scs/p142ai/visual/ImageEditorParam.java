package com.samsung.android.sdk.scs.p142ai.visual;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.visual.MultiModalParam;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ImageEditorParam {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AiEraserModeBuilder<T> extends Builder {
        public AiEraserModeBuilder(Builder builder) {
            super(builder.params);
            priority(0);
        }

        public AiEraserModeBuilder<T> dilationRadius(int i) {
            this.params.putInt(ImageEditorConst.KEY_PARAM_DILATION_RADIUS, i);
            return this;
        }

        public AiEraserModeBuilder<T> mask(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable("alphaBitmap", (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable("alphaPfd", (Parcelable) t);
            }
            return this;
        }

        public AiEraserModeBuilder<T> priority(int i) {
            this.params.putInt("priority", i);
            return this;
        }

        public AiEraserModeBuilder<T> safetyFilter(boolean z) {
            this.params.putBoolean(ImageEditorConst.KEY_PARAM_SAFETY_FILTER, z);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BitmapBuilder extends InputBuilder<Bitmap> {
        public BitmapBuilder(@NonNull Builder builder) {
            super(builder, "bitmap");
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public AiEraserModeBuilder<Bitmap> asAiEraserMode() {
            return super.asAiEraserMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public GenEditModeBuilder<Bitmap> asGenEditMode() {
            return super.asGenEditMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public HarmonizationModeBuilder<Bitmap> asHarmonizationMode() {
            return super.asHarmonizationMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ImageConversionModeBuilder<Bitmap> asImageConversion() {
            return super.asImageConversion();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public PetPortraitModeBuilder<Bitmap> asPetPortraitMode() {
            return super.asPetPortraitMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public PortraitModeBuilder<Bitmap> asPortraitMode() {
            return super.asPortraitMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public RestylingBuilder<Bitmap> asRestylingMode() {
            return super.asRestylingMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public Sketch2ImageModeBuilder<Bitmap> asSketch2ImageMode() {
            return super.asSketch2ImageMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public SketchGuidedEditingModeBuilder<Bitmap> asSketchGuidedEditingMode() {
            return super.asSketchGuidedEditingMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public WallpaperModeBuilder<Bitmap> asWallpaperMode() {
            return super.asWallpaperMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public BitmapBuilder input(Bitmap bitmap) {
            this.params.putParcelable("inputBitmap", bitmap);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: sampleCount, reason: merged with bridge method [inline-methods] */
        public InputBuilder<Bitmap> sampleCount2(int i) {
            this.params.putInt("sampleCount", i);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: serviceVersion, reason: merged with bridge method [inline-methods] */
        public InputBuilder<Bitmap> serviceVersion2(String str) {
            this.params.putString("serviceVersion", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BitmapTextBuilder extends InputBuilder<Bitmap> {
        public BitmapTextBuilder(@NonNull Builder builder) {
            super(builder, ImageEditorConst.PARAM_TYPE_BITMAP_TEXT);
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ImageConversionModeBuilder<Bitmap> asImageConversion() {
            return super.asImageConversion();
        }

        public BitmapTextBuilder input(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_INPUT_TEXT, str);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: sampleCount */
        public InputBuilder<Bitmap> sampleCount2(int i) {
            this.params.putInt("sampleCount", i);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: serviceVersion */
        public InputBuilder<Bitmap> serviceVersion2(String str) {
            this.params.putString("serviceVersion", str);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public BitmapTextBuilder input(Bitmap bitmap) {
            this.params.putParcelable("inputBitmap", bitmap);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GenEditModeBuilder<T> extends Builder {
        public GenEditModeBuilder(Builder builder) {
            super(builder.params);
            priority(0);
        }

        public GenEditModeBuilder<T> mask(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable("alphaBitmap", (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable("alphaPfd", (Parcelable) t);
            }
            return this;
        }

        public GenEditModeBuilder<T> priority(int i) {
            this.params.putInt("priority", i);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GenStickerModeBuilder<T> extends Builder {
        public GenStickerModeBuilder(Builder builder) {
            super(builder.params);
        }

        public GenStickerModeBuilder<T> style(String str) {
            this.params.putString("style", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HarmonizationModeBuilder<T> extends Builder {
        public HarmonizationModeBuilder(Builder builder) {
            super(builder.params);
            priority(0);
        }

        public HarmonizationModeBuilder<T> mask(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable("alphaBitmap", (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable("alphaPfd", (Parcelable) t);
            }
            return this;
        }

        public HarmonizationModeBuilder<T> priority(int i) {
            this.params.putInt("priority", i);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageConversionModeBuilder<T> extends Builder {
        public ImageConversionModeBuilder(Builder builder) {
            super(builder.params);
        }

        public ImageConversionModeBuilder<T> conversionInputType(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_CONVERSION_INPUT_TYPE, str);
            return this;
        }

        public ImageConversionModeBuilder<T> personDetection(boolean z) {
            this.params.putBoolean(ImageEditorConst.KEY_PARAM_PERSON_DETECTION, z);
            return this;
        }

        public ImageConversionModeBuilder<T> personGeneration(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_PERSON_GENERATION, str);
            return this;
        }

        public ImageConversionModeBuilder<T> style(String str) {
            this.params.putString("style", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class InputBuilder<T> extends Builder {
        protected final ArrayList<Parcelable> outputs;

        public InputBuilder(@NonNull Builder builder, @NonNull String str) {
            super(builder.params);
            this.outputs = new ArrayList<>();
            this.params.putString("inputType", str);
        }

        public void addOutputParcelable(Parcelable parcelable) {
            this.outputs.add(parcelable);
        }

        public AiEraserModeBuilder<T> asAiEraserMode() {
            return new AiEraserModeBuilder<>(this);
        }

        public GenEditModeBuilder<T> asGenEditMode() {
            return new GenEditModeBuilder<>(this);
        }

        public GenStickerModeBuilder<T> asGenSticker() {
            return new GenStickerModeBuilder<>(this);
        }

        public HarmonizationModeBuilder<T> asHarmonizationMode() {
            return new HarmonizationModeBuilder<>(this);
        }

        public ImageConversionModeBuilder<T> asImageConversion() {
            return new ImageConversionModeBuilder<>(this);
        }

        public PetPortraitModeBuilder<T> asPetPortraitMode() {
            return new PetPortraitModeBuilder<>(this);
        }

        public PortraitModeBuilder<T> asPortraitMode() {
            return new PortraitModeBuilder<>(this);
        }

        public RestylingBuilder<T> asRestylingMode() {
            return new RestylingBuilder<>(this);
        }

        public Sketch2ImageModeBuilder<T> asSketch2ImageMode() {
            return new Sketch2ImageModeBuilder<>(this);
        }

        public SketchGuidedEditingModeBuilder<T> asSketchGuidedEditingMode() {
            return new SketchGuidedEditingModeBuilder<>(this);
        }

        public WallpaperModeBuilder<T> asWallpaperMode() {
            return new WallpaperModeBuilder<>(this);
        }

        public abstract InputBuilder<T> input(T t);

        /* JADX INFO: renamed from: sampleCount */
        public abstract InputBuilder<T> sampleCount2(int i);

        /* JADX INFO: renamed from: serviceVersion */
        public abstract InputBuilder<T> serviceVersion2(String str);

        public void addOutputParcelable(List<? extends Parcelable> list) {
            this.outputs.addAll(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParamBuilder extends Builder {
        public ParamBuilder() {
        }

        public BitmapBuilder asBitmap() {
            return new BitmapBuilder(this);
        }

        public BitmapTextBuilder asBitmapText() {
            return new BitmapTextBuilder(this);
        }

        public MultiModalParam.MultiModalModeBuilder asMultiModal() {
            return new MultiModalParam.MultiModalModeBuilder(this);
        }

        public ParcelFileDescriptorBuilder asParcelFileDescriptor() {
            return new ParcelFileDescriptorBuilder(this);
        }

        public ParcelFileDescriptorTextBuilder asParcelFileDescriptorText() {
            return new ParcelFileDescriptorTextBuilder(this);
        }

        public TextBuilder asText() {
            return new TextBuilder(this);
        }

        public ParamBuilder(@NonNull Bundle bundle) {
            super(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParcelFileDescriptorBuilder extends InputBuilder<ParcelFileDescriptor> {
        public ParcelFileDescriptorBuilder(@NonNull Builder builder) {
            super(builder, "file");
        }

        public ParcelFileDescriptorBuilder addOutput(ParcelFileDescriptor parcelFileDescriptor) {
            super.addOutputParcelable(parcelFileDescriptor);
            this.params.putParcelableArrayList("outputPfdList", this.outputs);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public AiEraserModeBuilder<ParcelFileDescriptor> asAiEraserMode() {
            return super.asAiEraserMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public GenEditModeBuilder<ParcelFileDescriptor> asGenEditMode() {
            return super.asGenEditMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public HarmonizationModeBuilder<ParcelFileDescriptor> asHarmonizationMode() {
            return super.asHarmonizationMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ImageConversionModeBuilder<ParcelFileDescriptor> asImageConversion() {
            return super.asImageConversion();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public PetPortraitModeBuilder<ParcelFileDescriptor> asPetPortraitMode() {
            return super.asPetPortraitMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public PortraitModeBuilder<ParcelFileDescriptor> asPortraitMode() {
            return super.asPortraitMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public RestylingBuilder<ParcelFileDescriptor> asRestylingMode() {
            return new RestylingBuilder<>(this);
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public Sketch2ImageModeBuilder<ParcelFileDescriptor> asSketch2ImageMode() {
            return super.asSketch2ImageMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public SketchGuidedEditingModeBuilder<ParcelFileDescriptor> asSketchGuidedEditingMode() {
            return super.asSketchGuidedEditingMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public WallpaperModeBuilder<ParcelFileDescriptor> asWallpaperMode() {
            return super.asWallpaperMode();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ParcelFileDescriptorBuilder input(ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("inputPfd", parcelFileDescriptor);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: sampleCount, reason: avoid collision after fix types in other method */
        public InputBuilder<ParcelFileDescriptor> sampleCount2(int i) {
            this.params.putInt("sampleCount", i);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: serviceVersion, reason: avoid collision after fix types in other method */
        public InputBuilder<ParcelFileDescriptor> serviceVersion2(String str) {
            this.params.putString("serviceVersion", str);
            return this;
        }

        public ParcelFileDescriptorBuilder addOutput(List<ParcelFileDescriptor> list) {
            super.addOutputParcelable(list);
            this.params.putParcelableArrayList("outputPfdList", this.outputs);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParcelFileDescriptorTextBuilder extends InputBuilder<ParcelFileDescriptor> {
        public ParcelFileDescriptorTextBuilder(@NonNull Builder builder) {
            super(builder, ImageEditorConst.PARAM_TYPE_FILE_TEXT);
        }

        public ParcelFileDescriptorTextBuilder addOutput(ParcelFileDescriptor parcelFileDescriptor) {
            super.addOutputParcelable(parcelFileDescriptor);
            this.params.putParcelableArrayList("outputPfdList", this.outputs);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ImageConversionModeBuilder<ParcelFileDescriptor> asImageConversion() {
            return super.asImageConversion();
        }

        public ParcelFileDescriptorTextBuilder input(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_INPUT_TEXT, str);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: sampleCount, reason: avoid collision after fix types in other method */
        public InputBuilder<ParcelFileDescriptor> sampleCount2(int i) {
            this.params.putInt("sampleCount", i);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: serviceVersion, reason: avoid collision after fix types in other method */
        public InputBuilder<ParcelFileDescriptor> serviceVersion2(String str) {
            this.params.putString("serviceVersion", str);
            return this;
        }

        public ParcelFileDescriptorTextBuilder addOutput(List<ParcelFileDescriptor> list) {
            super.addOutputParcelable(list);
            this.params.putParcelableArrayList("outputPfdList", this.outputs);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ParcelFileDescriptorTextBuilder input(ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("inputPfd", parcelFileDescriptor);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PetPortraitModeBuilder<T> extends Builder {
        public PetPortraitModeBuilder(@NonNull Builder builder) {
            super(builder.params);
        }

        public PetPortraitModeBuilder<T> aspectRatio(String str) {
            this.params.putString("aspectRatio", str);
            return this;
        }

        public PetPortraitModeBuilder<T> petPortraitInputType(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_PET_PORTRAIT_INPUT_TYPE, str);
            return this;
        }

        public PetPortraitModeBuilder<T> regionOfInterest(Rect rect) {
            this.params.putParcelable(ImageEditorConst.KEY_PARAM_REGION_OF_INTEREST, rect);
            return this;
        }

        public PetPortraitModeBuilder<T> seedIndex(int i) {
            this.params.putInt(ImageEditorConst.KEY_PARAM_SEED_INDEX, i);
            return this;
        }

        public PetPortraitModeBuilder<T> style(String str) {
            this.params.putString("style", str);
            return this;
        }

        public PetPortraitModeBuilder<T> userInput(String str) {
            this.params.putString("userInput", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PortraitModeBuilder<T> extends Builder {
        public PortraitModeBuilder(@NonNull Builder builder) {
            super(builder.params);
        }

        public PortraitModeBuilder<T> aspectRatio(String str) {
            this.params.putString("aspectRatio", str);
            return this;
        }

        public PortraitModeBuilder<T> faceRect(Rect rect) {
            this.params.putParcelable(ImageEditorConst.KEY_PARAM_PORTRAIT_FACE_RECT_BY_USER, rect);
            return this;
        }

        public PortraitModeBuilder<T> identityControl(float f) {
            this.params.putFloat("portraitIdentityControl", f);
            return this;
        }

        public PortraitModeBuilder<T> portraitInputType(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_PORTRAIT_INPUT_TYPE, str);
            return this;
        }

        public PortraitModeBuilder<T> seedIndex(int i) {
            this.params.putInt(ImageEditorConst.KEY_PARAM_SEED_INDEX, i);
            return this;
        }

        public PortraitModeBuilder<T> structureControl(float f) {
            this.params.putFloat("portraitStructureControl", f);
            return this;
        }

        public PortraitModeBuilder<T> style(@NonNull String str) {
            this.params.putString("portraitStyle", str);
            return this;
        }

        public PortraitModeBuilder<T> userInput(String str) {
            this.params.putString("userInput", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RestylingBuilder<T> extends Builder {
        public RestylingBuilder(@NonNull Builder builder) {
            super(builder.params);
        }

        public RestylingBuilder<T> aspectRatio(String str) {
            this.params.putString("aspectRatio", str);
            return this;
        }

        public RestylingBuilder<T> restylingInputType(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_RESTYLING_INPUT_TYPE, str);
            return this;
        }

        public RestylingBuilder<T> seedIndex(int i) {
            this.params.putInt(ImageEditorConst.KEY_PARAM_SEED_INDEX, i);
            return this;
        }

        public RestylingBuilder<T> style(String str) {
            this.params.putString("style", str);
            return this;
        }

        public RestylingBuilder<T> userInput(String str) {
            this.params.putString("userInput", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Sketch2ImageModeBuilder<T> extends Builder {
        public Sketch2ImageModeBuilder(@NonNull Builder builder) {
            super(builder.params);
            followSketchStrength("strong");
        }

        public Sketch2ImageModeBuilder<T> followSketchStrength(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_FOLLOW_SKETCH_STRENGTH, str);
            return this;
        }

        public Sketch2ImageModeBuilder<T> style(String str) {
            this.params.putString("style", str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextBuilder extends InputBuilder<String> {
        public TextBuilder(@NonNull Builder builder) {
            super(builder, "text");
        }

        public TextBuilder addOutput(ParcelFileDescriptor parcelFileDescriptor) {
            super.addOutputParcelable(parcelFileDescriptor);
            this.params.putParcelableArrayList("outputPfdList", this.outputs);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public GenStickerModeBuilder<String> asGenSticker() {
            return super.asGenSticker();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public ImageConversionModeBuilder<String> asImageConversion() {
            return super.asImageConversion();
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        public TextBuilder input(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_INPUT_TEXT, str);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: sampleCount, reason: avoid collision after fix types in other method */
        public InputBuilder<String> sampleCount2(int i) {
            this.params.putInt("sampleCount", i);
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.visual.ImageEditorParam.InputBuilder
        /* JADX INFO: renamed from: serviceVersion, reason: avoid collision after fix types in other method */
        public InputBuilder<String> serviceVersion2(String str) {
            this.params.putString("serviceVersion", str);
            return this;
        }

        public TextBuilder addOutput(List<ParcelFileDescriptor> list) {
            super.addOutputParcelable(list);
            this.params.putParcelableArrayList("outputPfdList", this.outputs);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WallpaperModeBuilder<T> extends Builder {
        public WallpaperModeBuilder(Builder builder) {
            super(builder.params);
            mode(ImageConst.PARAM_MODE_WALLPAPER_MASK);
            priority(0);
        }

        public WallpaperModeBuilder<T> input2(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable("alphaBitmap", (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable("alphaPfd", (Parcelable) t);
            }
            return this;
        }

        public WallpaperModeBuilder<T> mode(String str) {
            this.params.putString(ImageConst.KEY_PARAM_GENERATE_MODE, str);
            return this;
        }

        public WallpaperModeBuilder<T> priority(int i) {
            this.params.putInt("priority", i);
            return this;
        }

        public WallpaperModeBuilder<T> time(String str) {
            this.params.putString("time", str);
            return this;
        }

        public WallpaperModeBuilder<T> weather(String str) {
            this.params.putString(ImageConst.KEY_PARAM_WEATHER, str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        protected Bundle params;

        public Builder() {
            this.params = new Bundle();
        }

        public Bundle build() {
            return this.params;
        }

        public Builder(@NonNull Bundle bundle) {
            new Bundle();
            this.params = bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SketchGuidedEditingModeBuilder<T> extends Builder {
        public SketchGuidedEditingModeBuilder(Builder builder) {
            super(builder.params);
        }

        public SketchGuidedEditingModeBuilder<T> assistance(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable(ImageEditorConst.KEY_PARAM_ASSISTANCE_BITMAP, (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable(ImageEditorConst.KEY_PARAM_ASSISTANCE_PFD, (Parcelable) t);
            }
            return this;
        }

        public SketchGuidedEditingModeBuilder<T> base(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable(ImageEditorConst.KEY_PARAM_BASE_BITMAP, (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable(ImageEditorConst.KEY_PARAM_BASE_PFD, (Parcelable) t);
            }
            return this;
        }

        public SketchGuidedEditingModeBuilder<T> levelType(int i) {
            this.params.putInt(ImageEditorConst.KEY_PARAM_LEVEL_TYPE, i);
            return this;
        }

        public SketchGuidedEditingModeBuilder<T> mask(T t) {
            if (t instanceof Bitmap) {
                this.params.putParcelable("alphaBitmap", (Parcelable) t);
                return this;
            }
            if (t instanceof ParcelFileDescriptor) {
                this.params.putParcelable("alphaPfd", (Parcelable) t);
            }
            return this;
        }

        public SketchGuidedEditingModeBuilder<T> mask(Rect rect) {
            this.params.putParcelable(ImageEditorConst.KEY_PARAM_ALPHA_RECT, rect);
            return this;
        }

        public SketchGuidedEditingModeBuilder<T> mask(ArrayList<Rect> arrayList) {
            this.params.putParcelableArrayList(ImageEditorConst.KEY_PARAM_ALPHA_RECT_LIST, arrayList);
            return this;
        }
    }
}
