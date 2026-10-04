package com.samsung.android.sdk.scs.p142ai.visual;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.opencsv.bean.C6618c;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorParam;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MultiModalParam {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContentDataBuilder {
        private final Bundle mParam = new Bundle();

        public Bundle build() {
            return this.mParam;
        }

        public ContentDataBuilder contentName(String str) {
            this.mParam.putString(ImageEditorConst.KEY_PARAM_CD_CONTENT_NAME, str);
            return this;
        }

        public ContentDataBuilder image(ParcelFileDescriptor parcelFileDescriptor) {
            this.mParam.putParcelable(ImageEditorConst.KEY_PARAM_CD_PFD, parcelFileDescriptor);
            return this;
        }

        public ContentDataBuilder mimeType(String str) {
            this.mParam.putString(ImageEditorConst.KEY_PARAM_CD_MIME_TYPE, str);
            return this;
        }

        public ContentDataBuilder text(String str) {
            this.mParam.putString(ImageEditorConst.KEY_PARAM_CD_TEXT, str);
            return this;
        }

        public ContentDataBuilder type(String str) {
            this.mParam.putString(ImageEditorConst.KEY_PARAM_CD_TYPE, str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DesignImageModeBuilder extends ImageEditorParam.Builder {
        private final Bundle mDesignImage;

        public DesignImageModeBuilder(@NonNull ImageEditorParam.Builder builder) {
            super(builder.params);
            Bundle bundle = new Bundle();
            this.mDesignImage = bundle;
            this.params.putString(ImageEditorConst.KEY_PARAM_MM_REQUEST_TYPE, "designImage");
            this.params.putBundle(ImageEditorConst.KEY_PARAM_MM_DESIGN_IMAGE, bundle);
        }

        public DesignImageModeBuilder category(String str) {
            this.mDesignImage.putString(ImageEditorConst.KEY_PARAM_DESIGN_IMAGE_CATEGORY, str);
            return this;
        }

        public DesignImageModeBuilder imageParam(Bundle bundle) {
            this.mDesignImage.putBundle(ImageEditorConst.KEY_PARAM_DESIGN_IMAGE_IMAGE_PARAM, bundle);
            return this;
        }

        public DesignImageModeBuilder inputTypes(ArrayList<String> arrayList) {
            this.mDesignImage.putStringArrayList(ImageEditorConst.KEY_PARAM_DESIGN_IMAGE_INPUT_TYPES, arrayList);
            return this;
        }

        public DesignImageModeBuilder style(String str) {
            this.mDesignImage.putString(ImageEditorConst.KEY_PARAM_DESIGN_IMAGE_STYLE, str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DesignStickerModeBuilder extends ImageEditorParam.Builder {
        private final Bundle mDesignSticker;

        public DesignStickerModeBuilder(@NonNull ImageEditorParam.Builder builder) {
            super(builder.params);
            Bundle bundle = new Bundle();
            this.mDesignSticker = bundle;
            this.params.putString(ImageEditorConst.KEY_PARAM_MM_REQUEST_TYPE, "designSticker");
            this.params.putBundle(ImageEditorConst.KEY_PARAM_MM_DESIGN_STICKER, bundle);
        }

        public DesignStickerModeBuilder category(String str) {
            this.mDesignSticker.putString(ImageEditorConst.KEY_PARAM_DESIGN_STICKER_CATEGORY, str);
            return this;
        }

        public DesignStickerModeBuilder imageParam(Bundle bundle) {
            this.mDesignSticker.putBundle(ImageEditorConst.KEY_PARAM_DESIGN_STICKER_IMAGE_PARAM, bundle);
            return this;
        }

        public DesignStickerModeBuilder inputTypes(ArrayList<String> arrayList) {
            this.mDesignSticker.putStringArrayList(ImageEditorConst.KEY_PARAM_DESIGN_STICKER_INPUT_TYPES, arrayList);
            return this;
        }

        public DesignStickerModeBuilder style(String str) {
            this.mDesignSticker.putString(ImageEditorConst.KEY_PARAM_DESIGN_STICKER_STYLE, str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MultiModalModeBuilder extends ImageEditorParam.Builder {
        public MultiModalModeBuilder(@NonNull ImageEditorParam.Builder builder) {
            super(builder.params);
        }

        public DesignImageModeBuilder asDesignImageMode() {
            return new DesignImageModeBuilder(this);
        }

        public DesignStickerModeBuilder asDesignStickerMode() {
            return new DesignStickerModeBuilder(this);
        }

        public MultiModalModeBuilder contentData(ArrayList<Bundle> arrayList) {
            this.params.putParcelableArrayList(ImageEditorConst.KEY_PARAM_MM_CONTENT_LIST, arrayList);
            return this;
        }

        public MultiModalModeBuilder outputs(ArrayList<ParcelFileDescriptor> arrayList) {
            this.params.putParcelableArrayList("outputPfdList", arrayList);
            return this;
        }

        public MultiModalModeBuilder promptParam(Bundle bundle) {
            this.params.putBundle(ImageEditorConst.KEY_PARAM_MM_PROMPT_PARAM, bundle);
            return this;
        }

        public MultiModalModeBuilder requestType(String str) {
            this.params.putString(ImageEditorConst.KEY_PARAM_MM_REQUEST_TYPE, str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PromptParamBuilder {
        private final Bundle mParam = new Bundle();

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$param$0(Bundle bundle, Map map, String str) {
            bundle.putString(str, (String) map.get(str));
        }

        public Bundle build() {
            return this.mParam;
        }

        public PromptParamBuilder param(Map<String, String> map) {
            if (map == null) {
                this.mParam.putBundle(ImageEditorConst.KEY_PARAM_PP_PARAM, null);
                return this;
            }
            Bundle bundle = new Bundle();
            map.keySet().forEach(new C6618c(bundle, map, 5));
            this.mParam.putBundle(ImageEditorConst.KEY_PARAM_PP_PARAM, bundle);
            return this;
        }
    }
}
