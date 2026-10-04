package com.samsung.android.sdk.pdf;

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\bH&J(\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u00122\u0006\u0010\u000e\u001a\u00020\bH&J:\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\b2\u001e\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H&J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenIPdfWriter;", "", AbstractCircuitBreaker.PROPERTY_NAME, "", "fileName", "", "password", "documentWidth", "", "save", "outFileName", "getPageCount", "getPageSize", "Landroid/graphics/RectF;", "pageIndex", "getPageRichTextList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "setOverlayRichText", "", "listTextParagraph", "dstLanguageTag", "getPageImage", "Landroid/graphics/Bitmap;", "ratio", "", "setOverlayImage", "pdfPageIndex", "overlayImage", "setWatermarkString", "watermarkString", "lockFile", "unlockFile", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenIPdfWriter {
    int getPageCount();

    @Nullable
    Bitmap getPageImage(int pageIndex, float ratio);

    @Nullable
    ArrayList<SpenPdfParagraph> getPageRichTextList(int pageIndex);

    @Nullable
    RectF getPageSize(int pageIndex);

    boolean lockFile();

    boolean open(@Nullable String fileName, @Nullable String password, int documentWidth);

    boolean save(@Nullable String outFileName);

    boolean setOverlayImage(int pdfPageIndex, @Nullable Bitmap overlayImage);

    void setOverlayRichText(int pageIndex, @Nullable ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag);

    void setWatermarkString(@Nullable String watermarkString);

    boolean unlockFile();
}
