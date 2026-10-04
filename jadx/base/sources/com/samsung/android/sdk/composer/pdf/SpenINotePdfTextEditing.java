package com.samsung.android.sdk.composer.pdf;

import android.graphics.Bitmap;
import android.graphics.RectF;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0017H&J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H&J\u001c\u0010\u0018\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u001e\u001a\u00020\u0017H&J\b\u0010\u001f\u001a\u00020\u0017H&J\b\u0010 \u001a\u00020\u0017H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H&J\u001f\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010#2\u0006\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H&J1\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00032\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010#2\b\u0010,\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H&J\u001f\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010#2\u0006\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0002\u0010$J\u001a\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0007H&J\u0012\u00101\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020\u0003H&J\u001a\u00102\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010&H&J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0013H&J\b\u00106\u001a\u00020\u0017H&J\b\u00107\u001a\u00020\u0017H&J\b\u00108\u001a\u00020\u0017H&J\u0010\u00109\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\u0019\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenINotePdfTextEditing;", "", "pageCount", "", "getPageCount", "()I", "selectedText", "", "getSelectedText", "()Ljava/lang/String;", "startSelectionCursorPosition", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "getStartSelectionCursorPosition", "()Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "endSelectionCursorPosition", "getEndSelectionCursorPosition", "textLengthOnScreen", "getTextLengthOnScreen", "isOverlayTextEnabled", "", "()Z", "hasSelectedText", "clearSelection", "", "setTextSelection", "pageIndex", "startCharIndex", "endCharIndex", "start", "end", "selectTextOnScreen", "startAiTextFormat", "stopAiTextFormat", "getPageTextLength", "getPageTextList", "", "(I)[Ljava/lang/String;", "getPageImage", "Landroid/graphics/Bitmap;", "ratio", "", "setOverlayText", "pdfPageIndex", "overlayText", "dstLanguageTag", "(I[Ljava/lang/String;Ljava/lang/String;)V", "getOverlayTextLength", "getOverlayText", "isSetOverlayText", "getOverlayImage", "setOverlayImage", "overlayImage", "setOverlayTextEnable", "enable", "requestReloadOverlayPages", "clearAllOverlayText", "clearAllOverlayImage", "hasInputField", "getPdfPageSize", "Landroid/graphics/RectF;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenINotePdfTextEditing {
    void clearAllOverlayImage();

    void clearAllOverlayText();

    void clearSelection();

    @Nullable
    SpenNotePdfCursorPosition getEndSelectionCursorPosition();

    @Nullable
    Bitmap getOverlayImage(int pageIndex);

    @Nullable
    String[] getOverlayText(int pageIndex);

    int getOverlayTextLength(int pageIndex);

    int getPageCount();

    @Nullable
    Bitmap getPageImage(int pageIndex, float ratio);

    int getPageTextLength(int pageIndex);

    @Nullable
    String[] getPageTextList(int pageIndex);

    @Nullable
    RectF getPdfPageSize(int pageIndex);

    @Nullable
    String getSelectedText();

    @Nullable
    SpenNotePdfCursorPosition getStartSelectionCursorPosition();

    int getTextLengthOnScreen();

    boolean hasInputField(int pageIndex);

    boolean hasSelectedText();

    boolean isOverlayTextEnabled();

    boolean isSetOverlayText(int pdfPageIndex, @Nullable String dstLanguageTag);

    void requestReloadOverlayPages();

    void selectTextOnScreen();

    boolean setOverlayImage(int pdfPageIndex, @Nullable Bitmap overlayImage);

    void setOverlayText(int pdfPageIndex, @Nullable String[] overlayText, @Nullable String dstLanguageTag);

    void setOverlayTextEnable(boolean enable);

    void setTextSelection(int pageIndex, int startCharIndex, int endCharIndex);

    void setTextSelection(@Nullable SpenNotePdfCursorPosition start, @Nullable SpenNotePdfCursorPosition end);

    void startAiTextFormat();

    void stopAiTextFormat();
}
