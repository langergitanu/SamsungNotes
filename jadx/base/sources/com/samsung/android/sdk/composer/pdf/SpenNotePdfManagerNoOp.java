package com.samsung.android.sdk.composer.pdf;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Pair;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.pdf.SpenPdfBookmark;
import com.samsung.android.sdk.pdf.SpenPdfParagraph;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\tH\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016J \u0010-\u001a\u00020!2\u0006\u0010&\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020$H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010,H\u0016J$\u00103\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u00102\u001a\u00020,H\u0016J.\u00104\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u00106\u001a\u0004\u0018\u000107H\u0016J6\u00104\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\rH\u0016J\b\u00109\u001a\u00020!H\u0016J\"\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010<\u001a\u00020\tH\u0016J\u0012\u0010=\u001a\u00020!2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u0005H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010A\u001a\u00020\u0005H\u0016J(\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0016J\b\u0010H\u001a\u00020\rH\u0016J\b\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020!H\u0016J \u0010K\u001a\u00020!2\u0006\u00105\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0016J\u001c\u0010K\u001a\u00020!2\b\u0010N\u001a\u0004\u0018\u00010\u00102\b\u0010O\u001a\u0004\u0018\u00010\u0010H\u0016J1\u0010P\u001a\u00020!2\u0006\u0010A\u001a\u00020\u00052\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010TJ\u001a\u0010U\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u00105\u001a\u00020\u0005H\u0016J\u0018\u0010X\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020WH\u0016J\u0010\u0010Z\u001a\u00020!2\u0006\u0010[\u001a\u00020\rH\u0016J\b\u0010\\\u001a\u00020!H\u0016J\b\u0010]\u001a\u00020!H\u0016J\b\u0010^\u001a\u00020!H\u0016J\b\u0010_\u001a\u00020!H\u0016J\b\u0010`\u001a\u00020!H\u0016J\b\u0010a\u001a\u00020!H\u0016J\b\u0010b\u001a\u00020\rH\u0016J\u0010\u0010c\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0016J\u0010\u0010d\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0016J\u001f\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010R2\u0006\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010fJ\u001f\u0010g\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010R2\u0006\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010fJ\u001a\u0010h\u001a\u0004\u0018\u00010W2\u0006\u00105\u001a\u00020\u00052\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020\rH\u0016J\u0012\u0010l\u001a\u00020\r2\b\u0010m\u001a\u0004\u0018\u00010WH\u0016J\b\u0010n\u001a\u00020\rH\u0016J\u0010\u0010o\u001a\u00020\r2\u0006\u0010p\u001a\u00020\u0005H\u0016J\u0018\u0010o\u001a\u00020\r2\u0006\u0010p\u001a\u00020\u00052\u0006\u0010q\u001a\u00020\u0005H\u0016J\b\u0010r\u001a\u00020\rH\u0016J\b\u0010s\u001a\u00020\rH\u0016J6\u0010t\u001a\u00020!2\u0006\u00105\u001a\u00020\u00052\u001a\u0010u\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010w0vj\n\u0012\u0006\u0012\u0004\u0018\u00010w`x2\b\u0010S\u001a\u0004\u0018\u00010\tH\u0016J>\u0010y\u001a\u00020!2\u0006\u00105\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u00052\u001a\u0010u\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010w0vj\n\u0012\u0006\u0012\u0004\u0018\u00010w`x2\b\u0010S\u001a\u0004\u0018\u00010\tH\u0016J(\u0010{\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010w\u0018\u00010vj\f\u0012\u0006\u0012\u0004\u0018\u00010w\u0018\u0001`x2\u0006\u00105\u001a\u00020\u0005H\u0016J\b\u0010|\u001a\u00020\rH\u0016J\u0010\u0010}\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0005H\u0016J\u0012\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u00105\u001a\u00020\u0005H\u0016J\u001f\u0010\u0080\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0081\u00012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J'\u0010\u0083\u0001\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0084\u00012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J\u0013\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u00105\u001a\u00020\u0005H\u0016J!\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00102\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0089\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0081\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00102\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J-\u0010\u008a\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008b\u00010vj\t\u0012\u0005\u0012\u00030\u008b\u0001`x2\u0006\u0010&\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001f¨\u0006\u008c\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfManagerNoOp;", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "<init>", "()V", "pageCount", "", "getPageCount", "()I", "selectedText", "", "getSelectedText", "()Ljava/lang/String;", "isOverlayTextEnabled", "", "()Z", "startSelectionCursorPosition", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "getStartSelectionCursorPosition", "()Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "endSelectionCursorPosition", "getEndSelectionCursorPosition", "textLengthOnScreen", "getTextLengthOnScreen", "selectedImageRect", "Landroid/graphics/RectF;", "getSelectedImageRect", "()Landroid/graphics/RectF;", "length", "cursorSelectionMaxLength", "getCursorSelectionMaxLength", "setCursorSelectionMaxLength", "(I)V", "close", "", "setNativeHandle", "nativeHandle", "", "hasPassword", "filePath", "verifyPassword", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$ResultType;", "password", "hasOwnerPermission", "getPageMode", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$PageMode;", "setPreLoadPdfFilePath", "fd", "fileSize", "getNoteOrientation", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$NoteOrientation;", DBSchema.Document.PAGE_MODE, "copyNoteCustomData", "attachFile", "pageIndex", "option", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$AttachOption;", "isReadOnlyAppData", "cancelAttachFile", "copyFile", "srcPath", "dstPath", "setListener", "l", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfListener;", "onLoadPdfPage", "pdfPageIndex", "onUnLoadPdfPage", "onCursorChanged", "startPageIndex", "startCursorIndex", "endPageIndex", "endCursorIndex", "hasContentsCopyPermission", "hasSelectedText", "clearSelection", "setTextSelection", "startCharIndex", "endCharIndex", "start", "end", "setOverlayText", "overlayText", "", "dstLanguageTag", "(I[Ljava/lang/String;Ljava/lang/String;)V", "isSetOverlayText", "getOverlayImage", "Landroid/graphics/Bitmap;", "setOverlayImage", "overlayImage", "setOverlayTextEnable", "enable", "requestReloadOverlayPages", "clearAllOverlayText", "clearAllOverlayImage", "startAiTextFormat", "stopAiTextFormat", "selectTextOnScreen", "hasPdfOnScreen", "getPageTextLength", "getOverlayTextLength", "getPageTextList", "(I)[Ljava/lang/String;", "getOverlayText", "getPageImage", "ratio", "", "hasSelectedImage", "getSelectedImage", "bitmap", "hasAnnotationPermission", "setAnnotation", "type", "color", "hasSelectedAnnotation", "removeSelectedAnnotation", "setOverlayRichText", "listTextParagraph", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "setStreamingOverlayRichText", "startParagraphIndex", "getPageRichTextList", "updateAttachedFile", "hasInputField", "getPageCorruptedTextObjectIndexs", "", "getTextByRect", "", "rect", "getCursorRangeByRect", "Landroid/util/Pair;", "getPdfPageSize", "getRectByCursorRange", "startCursor", "endCursor", "getStringListByCursorRange", "getBookmarkObject", "Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNotePdfManagerNoOp implements ISpenNotePdfManager {
    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ISpenNotePdfManager.ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password, @Nullable ISpenNotePdfManager.AttachOption option) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void cancelAttachFile() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void clearAllOverlayImage() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void clearAllOverlayText() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void clearSelection() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean copyFile(@NotNull String srcPath, @Nullable String password, @NotNull String dstPath) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(dstPath, "dstPath");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String copyNoteCustomData(@NotNull String filePath, @Nullable String password, @NotNull ISpenNotePdfManager.PageMode pageMode) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(pageMode, "pageMode");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ArrayList<SpenPdfBookmark> getBookmarkObject(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new ArrayList<>();
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> getCursorRangeByRect(@Nullable RectF rect) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getCursorSelectionMaxLength() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public SpenNotePdfCursorPosition getEndSelectionCursorPosition() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ISpenNotePdfManager.NoteOrientation getNoteOrientation(@NotNull String filePath, @Nullable String password, @Nullable ISpenNotePdfManager.PageMode pageMode) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public Bitmap getOverlayImage(int pageIndex) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String[] getOverlayText(int pageIndex) {
        return new String[0];
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getOverlayTextLength(int pageIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public int[] getPageCorruptedTextObjectIndexs(int pageIndex) {
        return new int[0];
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getPageCount() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public Bitmap getPageImage(int pageIndex, float ratio) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ISpenNotePdfManager.PageMode getPageMode(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ArrayList<SpenPdfParagraph> getPageRichTextList(int pageIndex) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getPageTextLength(int pageIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String[] getPageTextList(int pageIndex) {
        return new String[0];
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public RectF getPdfPageSize(int pageIndex) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public RectF getRectByCursorRange(@Nullable SpenNotePdfCursorPosition startCursor, @Nullable SpenNotePdfCursorPosition endCursor) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean getSelectedImage(@Nullable Bitmap bitmap) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public RectF getSelectedImageRect() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public String getSelectedText() {
        return "";
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public SpenNotePdfCursorPosition getStartSelectionCursorPosition() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public List<String> getStringListByCursorRange(@Nullable SpenNotePdfCursorPosition startCursor, @Nullable SpenNotePdfCursorPosition endCursor) {
        return CollectionsKt.emptyList();
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public List<String> getTextByRect(@Nullable RectF rect) {
        return CollectionsKt.emptyList();
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getTextLengthOnScreen() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasAnnotationPermission() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasContentsCopyPermission() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasInputField(int pageIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ISpenNotePdfManager.ResultType hasOwnerPermission(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasPassword(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasPdfOnScreen() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasSelectedAnnotation() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasSelectedImage() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasSelectedText() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean isOverlayTextEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean isSetOverlayText(int pdfPageIndex, @Nullable String dstLanguageTag) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void onCursorChanged(int startPageIndex, int startCursorIndex, int endPageIndex, int endCursorIndex) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void onLoadPdfPage(int pdfPageIndex) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void onUnLoadPdfPage(int pdfPageIndex) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean removeSelectedAnnotation() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void requestReloadOverlayPages() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void selectTextOnScreen() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean setAnnotation(int type) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setCursorSelectionMaxLength(int i) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setListener(@Nullable SpenNotePdfListener l) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setNativeHandle(long nativeHandle) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean setOverlayImage(int pdfPageIndex, @NotNull Bitmap overlayImage) {
        Intrinsics.checkNotNullParameter(overlayImage, "overlayImage");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setOverlayRichText(int pageIndex, @NotNull ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag) {
        Intrinsics.checkNotNullParameter(listTextParagraph, "listTextParagraph");
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setOverlayText(int pdfPageIndex, @Nullable String[] overlayText, @Nullable String dstLanguageTag) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setOverlayTextEnable(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setPreLoadPdfFilePath(@NotNull String filePath, int fd, long fileSize) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setStreamingOverlayRichText(int pageIndex, int startParagraphIndex, @NotNull ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag) {
        Intrinsics.checkNotNullParameter(listTextParagraph, "listTextParagraph");
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setTextSelection(int pageIndex, int startCharIndex, int endCharIndex) {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void startAiTextFormat() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void stopAiTextFormat() {
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean updateAttachedFile() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ISpenNotePdfManager.ResultType verifyPassword(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ISpenNotePdfManager.ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password, @Nullable ISpenNotePdfManager.AttachOption option, boolean isReadOnlyAppData) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getPageCount(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean setAnnotation(int type, int color) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setTextSelection(@Nullable SpenNotePdfCursorPosition start, @Nullable SpenNotePdfCursorPosition end) {
    }
}
