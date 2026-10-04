package com.samsung.android.app.sdk.deepsky.textextraction.translate.data;

import android.graphics.Point;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JF\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationData;", "", "poly", "", "Landroid/graphics/Point;", "sourceText", "", "sourceLang", "targetText", "targetLang", "([Landroid/graphics/Point;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getSourceLang", "()Ljava/lang/String;", "setSourceLang", "(Ljava/lang/String;)V", "getSourceText", "getTargetLang", "setTargetLang", "getTargetText", "setTargetText", "component1", "component2", "component3", "component4", "component5", "copy", "([Landroid/graphics/Point;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationData;", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class ImageTranslationData {

    @NotNull
    private final Point[] poly;

    @NotNull
    private String sourceLang;

    @NotNull
    private final String sourceText;

    @NotNull
    private String targetLang;

    @NotNull
    private String targetText;

    public ImageTranslationData(@NotNull Point[] poly, @NotNull String sourceText, @NotNull String sourceLang, @NotNull String targetText, @NotNull String targetLang) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(sourceLang, "sourceLang");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(targetLang, "targetLang");
        this.poly = poly;
        this.sourceText = sourceText;
        this.sourceLang = sourceLang;
        this.targetText = targetText;
        this.targetLang = targetLang;
    }

    public static /* synthetic */ ImageTranslationData copy$default(ImageTranslationData imageTranslationData, Point[] pointArr, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            pointArr = imageTranslationData.poly;
        }
        if ((i & 2) != 0) {
            str = imageTranslationData.sourceText;
        }
        if ((i & 4) != 0) {
            str2 = imageTranslationData.sourceLang;
        }
        if ((i & 8) != 0) {
            str3 = imageTranslationData.targetText;
        }
        if ((i & 16) != 0) {
            str4 = imageTranslationData.targetLang;
        }
        String str5 = str4;
        String str6 = str2;
        return imageTranslationData.copy(pointArr, str, str6, str3, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Point[] getPoly() {
        return this.poly;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSourceText() {
        return this.sourceText;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSourceLang() {
        return this.sourceLang;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTargetText() {
        return this.targetText;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTargetLang() {
        return this.targetLang;
    }

    @NotNull
    public final ImageTranslationData copy(@NotNull Point[] poly, @NotNull String sourceText, @NotNull String sourceLang, @NotNull String targetText, @NotNull String targetLang) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(sourceLang, "sourceLang");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(targetLang, "targetLang");
        return new ImageTranslationData(poly, sourceText, sourceLang, targetText, targetLang);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageTranslationData)) {
            return false;
        }
        ImageTranslationData imageTranslationData = (ImageTranslationData) other;
        return Intrinsics.areEqual(this.poly, imageTranslationData.poly) && Intrinsics.areEqual(this.sourceText, imageTranslationData.sourceText) && Intrinsics.areEqual(this.sourceLang, imageTranslationData.sourceLang) && Intrinsics.areEqual(this.targetText, imageTranslationData.targetText) && Intrinsics.areEqual(this.targetLang, imageTranslationData.targetLang);
    }

    @NotNull
    public final Point[] getPoly() {
        return this.poly;
    }

    @NotNull
    public final String getSourceLang() {
        return this.sourceLang;
    }

    @NotNull
    public final String getSourceText() {
        return this.sourceText;
    }

    @NotNull
    public final String getTargetLang() {
        return this.targetLang;
    }

    @NotNull
    public final String getTargetText() {
        return this.targetText;
    }

    public int hashCode() {
        return this.targetLang.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(Arrays.hashCode(this.poly) * 31, 31, this.sourceText), 31, this.sourceLang), 31, this.targetText);
    }

    public final void setSourceLang(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceLang = str;
    }

    public final void setTargetLang(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetLang = str;
    }

    public final void setTargetText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetText = str;
    }

    @NotNull
    public String toString() {
        String string = Arrays.toString(this.poly);
        String str = this.sourceText;
        String str2 = this.sourceLang;
        String str3 = this.targetText;
        String str4 = this.targetLang;
        StringBuilder sbM16m = AbstractC0000a.m16m("ImageTranslationData(poly=", string, ", sourceText=", str, ", sourceLang=");
        AbstractC2821a.m2207B(sbM16m, str2, ", targetText=", str3, ", targetLang=");
        return AbstractC0622a.m1170p(str4, ")", sbM16m);
    }
}
