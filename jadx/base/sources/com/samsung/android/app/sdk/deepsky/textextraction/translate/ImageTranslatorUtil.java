package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LanguageUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationData;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationModel;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslatorUtil;", "", "()V", SearchConstants.TargetContents.TAG, "", "isAutoTranslationMode", "", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "trimInvalidSourceLanguage", "", "resultList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationData;", "model", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationModel;", "trimSameSourceAndTargetLanguage", "trimSkippingCases", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageTranslatorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTranslatorUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslatorUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n766#2:69\n857#2,2:70\n766#2:72\n857#2,2:73\n*S KotlinDebug\n*F\n+ 1 ImageTranslatorUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslatorUtil\n*L\n31#1:69\n31#1:70,2\n51#1:72\n51#1:73,2\n*E\n"})
public final class ImageTranslatorUtil {

    @NotNull
    public static final ImageTranslatorUtil INSTANCE = new ImageTranslatorUtil();

    @NotNull
    private static final String TAG = "ImageTranslatorUtil";

    private ImageTranslatorUtil() {
    }

    private final boolean isAutoTranslationMode(TextTranslator textTranslator) {
        return Intrinsics.areEqual(textTranslator.getSourceLanguage(), LangPackConfigConstants.LANGUAGE_CODE_AUTO);
    }

    private final void trimInvalidSourceLanguage(List<ImageTranslationData> resultList, ImageTranslationModel model) {
        int size = resultList.size();
        List listZip = CollectionsKt.zip(model.getTargetBlockInfoList(), resultList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZip) {
            if (LanguageUtil.INSTANCE.isNormalLanguage(((ImageTranslationData) ((Pair) obj).getSecond()).getSourceLang())) {
                arrayList.add(obj);
            }
        }
        Pair pairUnzip = CollectionsKt__IterablesKt.unzip(arrayList);
        model.getTargetBlockInfoList().clear();
        model.getTargetBlockInfoList().addAll(CollectionsKt.toMutableList((Collection) pairUnzip.getFirst()));
        resultList.clear();
        resultList.addAll(CollectionsKt.toMutableList((Collection) pairUnzip.getSecond()));
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(size - resultList.size(), resultList.size(), "trimInvalidSourceLanguage: ", " results trimmed, ", " left"));
    }

    private final void trimSameSourceAndTargetLanguage(TextTranslator textTranslator, List<ImageTranslationData> resultList, ImageTranslationModel model) {
        int size = resultList.size();
        if (isAutoTranslationMode(textTranslator)) {
            List listZip = CollectionsKt.zip(model.getTargetBlockInfoList(), resultList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listZip) {
                ImageTranslationData imageTranslationData = (ImageTranslationData) ((Pair) obj).getSecond();
                if (!Intrinsics.areEqual(imageTranslationData.getSourceLang(), imageTranslationData.getTargetLang())) {
                    arrayList.add(obj);
                }
            }
            Pair pairUnzip = CollectionsKt__IterablesKt.unzip(arrayList);
            model.getTargetBlockInfoList().clear();
            model.getTargetBlockInfoList().addAll(CollectionsKt.toMutableList((Collection) pairUnzip.getFirst()));
            resultList.clear();
            resultList.addAll(CollectionsKt.toMutableList((Collection) pairUnzip.getSecond()));
        }
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(size - resultList.size(), resultList.size(), "trimSameSourceAndTargetLanguage: ", " results trimmed, ", " left"));
    }

    public final void trimSkippingCases(@NotNull TextTranslator textTranslator, @NotNull List<ImageTranslationData> resultList, @NotNull ImageTranslationModel model) {
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        Intrinsics.checkNotNullParameter(model, "model");
        trimSameSourceAndTargetLanguage(textTranslator, resultList, model);
        trimInvalidSourceLanguage(resultList, model);
    }
}
