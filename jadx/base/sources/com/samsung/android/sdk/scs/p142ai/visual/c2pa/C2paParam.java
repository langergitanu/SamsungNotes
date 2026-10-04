package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class C2paParam {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class C2paExistParamBuilder extends Builder {
        public C2paExistParamBuilder() {
        }

        public C2paExistParamBuilder setExtensionType(@NonNull String str) {
            this.params.putString("mimeType", str);
            return this;
        }

        public C2paExistParamBuilder setPfd(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("Pfd", parcelFileDescriptor);
            return this;
        }

        public C2paExistParamBuilder(@NonNull Bundle bundle) {
            super(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmbedParamBuilder extends Builder {
        public EmbedParamBuilder() {
        }

        public EmbedParamBuilder setIngredientExtensionTypes(@Nullable List<String> list) {
            if (list == null) {
                this.params.putStringArrayList("ingredientMimeTypes", null);
                return this;
            }
            this.params.putStringArrayList("ingredientMimeTypes", new ArrayList<>(list));
            return this;
        }

        public EmbedParamBuilder setIngredientPFD(@Nullable List<ParcelFileDescriptor> list) {
            if (list == null) {
                this.params.putParcelableArrayList("ingredientPfds", null);
                return this;
            }
            this.params.putParcelableArrayList("ingredientPfds", new ArrayList<>(list));
            return this;
        }

        public EmbedParamBuilder setIngredientPaths(@Nullable List<String> list) {
            if (list == null) {
                this.params.putStringArrayList("ingredientPaths", null);
                return this;
            }
            this.params.putStringArrayList("ingredientPaths", new ArrayList<>(list));
            return this;
        }

        public EmbedParamBuilder setManifestJson(@NonNull String str) {
            this.params.putString("jsonStr", str);
            return this;
        }

        public EmbedParamBuilder setParentExtensionType(@Nullable String str) {
            this.params.putString("parentMimeType", str);
            return this;
        }

        public EmbedParamBuilder setParentPFD(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("parentPfd", parcelFileDescriptor);
            return this;
        }

        public EmbedParamBuilder setParentPath(@Nullable String str) {
            this.params.putString("parentPath", str);
            return this;
        }

        public EmbedParamBuilder setTargetExtensionType(@NonNull String str) {
            this.params.putString("targetMimeType", str);
            return this;
        }

        public EmbedParamBuilder setTargetPFD(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("targetPfd", parcelFileDescriptor);
            return this;
        }

        public EmbedParamBuilder setTargetPath(@NonNull String str) {
            this.params.putString("targetPath", str);
            return this;
        }

        public EmbedParamBuilder(@NonNull Bundle bundle) {
            super(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExtractParamBuilder extends Builder {
        public ExtractParamBuilder() {
        }

        public ExtractParamBuilder setExtensionType(@NonNull String str) {
            this.params.putString("mimeType", str);
            return this;
        }

        public ExtractParamBuilder setFilePath(@NonNull String str) {
            this.params.putString("filePath", str);
            return this;
        }

        public ExtractParamBuilder setPfd(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("Pfd", parcelFileDescriptor);
            return this;
        }

        public ExtractParamBuilder(@NonNull Bundle bundle) {
            super(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SaveToCacheParamBuilder extends Builder {
        public SaveToCacheParamBuilder() {
        }

        public SaveToCacheParamBuilder setExtensionType(@NonNull String str) {
            this.params.putString("mimeType", str);
            return this;
        }

        public SaveToCacheParamBuilder setFilePath(@NonNull String str) {
            this.params.putString("filePath", str);
            return this;
        }

        public SaveToCacheParamBuilder setPfd(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            this.params.putParcelable("Pfd", parcelFileDescriptor);
            return this;
        }

        public SaveToCacheParamBuilder(@NonNull Bundle bundle) {
            super(bundle);
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
}
