package com.samsung.android.sdk.pen.ocr;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrModelLoaderFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MODEL_LOADER {
        PROVIDER_LATEST,
        PROVIDER_ONEUI411,
        ONEUI41,
        ASSETS
    }

    public static SpenIOcrModelLoader createModelLoader(Context context, SpenIOcrModelManager spenIOcrModelManager, MODEL_LOADER model_loader) {
        return model_loader == MODEL_LOADER.PROVIDER_LATEST ? new SpenOcrModelLoaderForDataProvider_Dynamic(context, spenIOcrModelManager) : model_loader == MODEL_LOADER.PROVIDER_ONEUI411 ? new SpenOcrModelLoaderForDataProvider(context, spenIOcrModelManager) : model_loader == MODEL_LOADER.ONEUI41 ? new SpenOcrModelLoaderForDataProvider_OneUI41(context, spenIOcrModelManager) : new SpenOcrModelLoaderForLocalAssetFile(context, spenIOcrModelManager);
    }
}
