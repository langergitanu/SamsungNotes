package com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper;

import com.samsung.android.sdk.ocr.OCRLanguage;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u00020\bH ¢\u0006\u0002\b\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/TextExtractionOCRLanguage;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "getConvertedId", "Lcom/samsung/android/sdk/ocr/OCRLanguage;", "getConvertedId$deepsky_sdk_textextraction_8_0_19_release", CategoryConstants.All.DISPLAY_NAME, "English", "Korean", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public enum TextExtractionOCRLanguage {
    All { // from class: com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage.All
        @Override // com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage
        @NotNull
        public OCRLanguage getConvertedId$deepsky_sdk_textextraction_8_0_19_release() {
            return OCRLanguage.AUTO;
        }
    },
    English { // from class: com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage.English
        @Override // com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage
        @NotNull
        public OCRLanguage getConvertedId$deepsky_sdk_textextraction_8_0_19_release() {
            return OCRLanguage.ENGLISH;
        }
    },
    Korean { // from class: com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage.Korean
        @Override // com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage
        @NotNull
        public OCRLanguage getConvertedId$deepsky_sdk_textextraction_8_0_19_release() {
            return OCRLanguage.KOREAN;
        }
    };


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int id;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/TextExtractionOCRLanguage$Companion;", "", "()V", "getByValue", "Lcom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/TextExtractionOCRLanguage;", "value", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTextExtractionOCRLanguage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextExtractionOCRLanguage.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/TextExtractionOCRLanguage$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,21:1\n1#2:22\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TextExtractionOCRLanguage getByValue(int value) {
            TextExtractionOCRLanguage textExtractionOCRLanguage;
            TextExtractionOCRLanguage[] textExtractionOCRLanguageArrValues = TextExtractionOCRLanguage.values();
            int length = textExtractionOCRLanguageArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    textExtractionOCRLanguage = null;
                    break;
                }
                textExtractionOCRLanguage = textExtractionOCRLanguageArrValues[i];
                if (textExtractionOCRLanguage.getId() == value) {
                    break;
                }
                i++;
            }
            return textExtractionOCRLanguage == null ? TextExtractionOCRLanguage.All : textExtractionOCRLanguage;
        }

        private Companion() {
        }
    }

    /* synthetic */ TextExtractionOCRLanguage(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    @NotNull
    public abstract OCRLanguage getConvertedId$deepsky_sdk_textextraction_8_0_19_release();

    public final int getId() {
        return this.id;
    }

    TextExtractionOCRLanguage(int i) {
        this.id = i;
    }
}
