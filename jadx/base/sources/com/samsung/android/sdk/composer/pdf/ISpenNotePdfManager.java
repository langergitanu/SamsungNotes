package com.samsung.android.sdk.composer.pdf;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Pair;
import com.samsung.android.sdk.pdf.SpenPdfBookmark;
import com.samsung.android.sdk.pdf.SpenPdfParagraph;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\b\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001J\b\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0007H&J\u001c\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H&J \u0010*\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020!H&J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010/\u001a\u0004\u0018\u00010)H&J$\u00100\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u00020)H&J.\u00101\u001a\u0004\u0018\u00010%2\u0006\u00102\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u000104H&J6\u00101\u001a\u0004\u0018\u00010%2\u0006\u00102\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u000bH&J\b\u00106\u001a\u00020\u001eH&J\"\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u00109\u001a\u00020\u0007H&J\u0012\u0010:\u001a\u00020\u001e2\b\u0010;\u001a\u0004\u0018\u00010<H&J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0003H&J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0003H&J(\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u0003H&J\b\u0010E\u001a\u00020\u000bH&J\b\u0010F\u001a\u00020\u000bH&J\b\u0010G\u001a\u00020\u001eH&J \u0010H\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H&J\u001c\u0010H\u001a\u00020\u001e2\b\u0010K\u001a\u0004\u0018\u00010\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000eH&J1\u0010M\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u00032\u0010\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010QJ\u001a\u0010R\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00032\b\u0010P\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u00102\u001a\u00020\u0003H&J\u0018\u0010U\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010V\u001a\u00020TH&J\u0010\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u000bH&J\b\u0010Y\u001a\u00020\u001eH&J\b\u0010Z\u001a\u00020\u001eH&J\b\u0010[\u001a\u00020\u001eH&J\b\u0010\\\u001a\u00020\u001eH&J\b\u0010]\u001a\u00020\u001eH&J\b\u0010^\u001a\u00020\u001eH&J\b\u0010_\u001a\u00020\u000bH&J\u0010\u0010`\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H&J\u0010\u0010a\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H&J\u001f\u0010b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010O2\u0006\u00102\u001a\u00020\u0003H&¢\u0006\u0002\u0010cJ\u001f\u0010d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010O2\u0006\u00102\u001a\u00020\u0003H&¢\u0006\u0002\u0010cJ\u001a\u0010e\u001a\u0004\u0018\u00010T2\u0006\u00102\u001a\u00020\u00032\u0006\u0010f\u001a\u00020gH&J\b\u0010h\u001a\u00020\u000bH&J\u0012\u0010i\u001a\u00020\u000b2\b\u0010j\u001a\u0004\u0018\u00010TH&J\b\u0010k\u001a\u00020\u000bH&J\u0010\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u0003H&J\u0018\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u00032\u0006\u0010n\u001a\u00020\u0003H&J\b\u0010o\u001a\u00020\u000bH&J\b\u0010p\u001a\u00020\u000bH&J6\u0010q\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00032\u001a\u0010r\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010t0sj\n\u0012\u0006\u0012\u0004\u0018\u00010t`u2\b\u0010P\u001a\u0004\u0018\u00010\u0007H&J>\u0010v\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00032\u001a\u0010r\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010t0sj\n\u0012\u0006\u0012\u0004\u0018\u00010t`u2\b\u0010P\u001a\u0004\u0018\u00010\u0007H&J(\u0010x\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010t\u0018\u00010sj\f\u0012\u0006\u0012\u0004\u0018\u00010t\u0018\u0001`u2\u0006\u00102\u001a\u00020\u0003H&J\b\u0010y\u001a\u00020\u000bH&J\u0010\u0010z\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0003H&J\u0012\u0010{\u001a\u0004\u0018\u00010|2\u0006\u00102\u001a\u00020\u0003H&J\u001c\u0010}\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010~2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0016H&J&\u0010\u0080\u0001\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0081\u00012\b\u0010\u007f\u001a\u0004\u0018\u00010\u0016H&J\u0013\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u00020\u0003H&J!\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00162\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH&J)\u0010\u0086\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010~2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH&J-\u0010\u0087\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0088\u00010sj\t\u0012\u0005\u0012\u00030\u0088\u0001`u2\u0006\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u001c¨\u0006\u008d\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "", "pageCount", "", "getPageCount", "()I", "selectedText", "", "getSelectedText", "()Ljava/lang/String;", "isOverlayTextEnabled", "", "()Z", "startSelectionCursorPosition", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "getStartSelectionCursorPosition", "()Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "endSelectionCursorPosition", "getEndSelectionCursorPosition", "textLengthOnScreen", "getTextLengthOnScreen", "selectedImageRect", "Landroid/graphics/RectF;", "getSelectedImageRect", "()Landroid/graphics/RectF;", "cursorSelectionMaxLength", "getCursorSelectionMaxLength", "setCursorSelectionMaxLength", "(I)V", "close", "", "setNativeHandle", "nativeHandle", "", "hasPassword", "filePath", "verifyPassword", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$ResultType;", "password", "hasOwnerPermission", "getPageMode", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$PageMode;", "setPreLoadPdfFilePath", "fd", "fileSize", "getNoteOrientation", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$NoteOrientation;", DBSchema.Document.PAGE_MODE, "copyNoteCustomData", "attachFile", "pageIndex", "option", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$AttachOption;", "isReadOnlyAppData", "cancelAttachFile", "copyFile", "srcPath", "dstPath", "setListener", "l", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfListener;", "onLoadPdfPage", "pdfPageIndex", "onUnLoadPdfPage", "onCursorChanged", "startPageIndex", "startCursorIndex", "endPageIndex", "endCursorIndex", "hasContentsCopyPermission", "hasSelectedText", "clearSelection", "setTextSelection", "startCharIndex", "endCharIndex", "start", "end", "setOverlayText", "overlayText", "", "dstLanguageTag", "(I[Ljava/lang/String;Ljava/lang/String;)V", "isSetOverlayText", "getOverlayImage", "Landroid/graphics/Bitmap;", "setOverlayImage", "overlayImage", "setOverlayTextEnable", "enable", "requestReloadOverlayPages", "clearAllOverlayText", "clearAllOverlayImage", "startAiTextFormat", "stopAiTextFormat", "selectTextOnScreen", "hasPdfOnScreen", "getPageTextLength", "getOverlayTextLength", "getPageTextList", "(I)[Ljava/lang/String;", "getOverlayText", "getPageImage", "ratio", "", "hasSelectedImage", "getSelectedImage", "bitmap", "hasAnnotationPermission", "setAnnotation", "type", "color", "hasSelectedAnnotation", "removeSelectedAnnotation", "setOverlayRichText", "listTextParagraph", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "setStreamingOverlayRichText", "startParagraphIndex", "getPageRichTextList", "updateAttachedFile", "hasInputField", "getPageCorruptedTextObjectIndexs", "", "getTextByRect", "", "rect", "getCursorRangeByRect", "Landroid/util/Pair;", "getPdfPageSize", "getRectByCursorRange", "startCursor", "endCursor", "getStringListByCursorRange", "getBookmarkObject", "Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "ResultType", "PageMode", "AttachOption", "NoteOrientation", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenNotePdfManager {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$AttachOption;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "APPLY_TEMPLATE", "APPLY_BACKGROUND_COLOR", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AttachOption {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AttachOption[] $VALUES;
        public static final AttachOption NONE = new AttachOption(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final AttachOption APPLY_TEMPLATE = new AttachOption("APPLY_TEMPLATE", 1);
        public static final AttachOption APPLY_BACKGROUND_COLOR = new AttachOption("APPLY_BACKGROUND_COLOR", 2);

        private static final /* synthetic */ AttachOption[] $values() {
            return new AttachOption[]{NONE, APPLY_TEMPLATE, APPLY_BACKGROUND_COLOR};
        }

        static {
            AttachOption[] attachOptionArr$values = $values();
            $VALUES = attachOptionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(attachOptionArr$values);
        }

        private AttachOption(String str, int i) {
        }

        @NotNull
        public static EnumEntries<AttachOption> getEntries() {
            return $ENTRIES;
        }

        public static AttachOption valueOf(String str) {
            return (AttachOption) Enum.valueOf(AttachOption.class, str);
        }

        public static AttachOption[] values() {
            return (AttachOption[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$NoteOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "NOTE_ORIENTATION_NONE", "NOTE_ORIENTATION_PORTRAIT", "NOTE_ORIENTATION_LANDSCAPE", "NOTE_ORIENTATION_LANDSCAPE_NEW", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class NoteOrientation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NoteOrientation[] $VALUES;
        public static final NoteOrientation NOTE_ORIENTATION_NONE = new NoteOrientation("NOTE_ORIENTATION_NONE", 0);
        public static final NoteOrientation NOTE_ORIENTATION_PORTRAIT = new NoteOrientation("NOTE_ORIENTATION_PORTRAIT", 1);
        public static final NoteOrientation NOTE_ORIENTATION_LANDSCAPE = new NoteOrientation("NOTE_ORIENTATION_LANDSCAPE", 2);
        public static final NoteOrientation NOTE_ORIENTATION_LANDSCAPE_NEW = new NoteOrientation("NOTE_ORIENTATION_LANDSCAPE_NEW", 3);

        private static final /* synthetic */ NoteOrientation[] $values() {
            return new NoteOrientation[]{NOTE_ORIENTATION_NONE, NOTE_ORIENTATION_PORTRAIT, NOTE_ORIENTATION_LANDSCAPE, NOTE_ORIENTATION_LANDSCAPE_NEW};
        }

        static {
            NoteOrientation[] noteOrientationArr$values = $values();
            $VALUES = noteOrientationArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(noteOrientationArr$values);
        }

        private NoteOrientation(String str, int i) {
        }

        @NotNull
        public static EnumEntries<NoteOrientation> getEntries() {
            return $ENTRIES;
        }

        public static NoteOrientation valueOf(String str) {
            return (NoteOrientation) Enum.valueOf(NoteOrientation.class, str);
        }

        public static NoteOrientation[] values() {
            return (NoteOrientation[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$PageMode;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE_MODE_NONE", "PAGE_MODE_LIST", "PAGE_MODE_SINGLE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class PageMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PageMode[] $VALUES;
        public static final PageMode PAGE_MODE_NONE = new PageMode("PAGE_MODE_NONE", 0);
        public static final PageMode PAGE_MODE_LIST = new PageMode("PAGE_MODE_LIST", 1);
        public static final PageMode PAGE_MODE_SINGLE = new PageMode("PAGE_MODE_SINGLE", 2);

        private static final /* synthetic */ PageMode[] $values() {
            return new PageMode[]{PAGE_MODE_NONE, PAGE_MODE_LIST, PAGE_MODE_SINGLE};
        }

        static {
            PageMode[] pageModeArr$values = $values();
            $VALUES = pageModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pageModeArr$values);
        }

        private PageMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PageMode> getEntries() {
            return $ENTRIES;
        }

        public static PageMode valueOf(String str) {
            return (PageMode) Enum.valueOf(PageMode.class, str);
        }

        public static PageMode[] values() {
            return (PageMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$ResultType;", "", "<init>", "(Ljava/lang/String;I)V", "RESULT_TYPE_SUCCESS", "RESULT_TYPE_ERROR_IO", "RESULT_TYPE_ERROR_PASSWORD", "RESULT_TYPE_ERROR_FORMAT", "RESULT_TYPE_ERROR_MEMORY", "RESULT_TYPE_ERROR_OUT_OF_RANGE", "RESULT_TYPE_ERROR_PROTECTED", "RESULT_TYPE_ERROR_UNSUPPORTED_NOTE_VERSION", "RESULT_TYPE_CANCEL", "RESULT_TYPE_ERROR_UNKNOWN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ResultType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResultType[] $VALUES;
        public static final ResultType RESULT_TYPE_SUCCESS = new ResultType("RESULT_TYPE_SUCCESS", 0);
        public static final ResultType RESULT_TYPE_ERROR_IO = new ResultType("RESULT_TYPE_ERROR_IO", 1);
        public static final ResultType RESULT_TYPE_ERROR_PASSWORD = new ResultType("RESULT_TYPE_ERROR_PASSWORD", 2);
        public static final ResultType RESULT_TYPE_ERROR_FORMAT = new ResultType("RESULT_TYPE_ERROR_FORMAT", 3);
        public static final ResultType RESULT_TYPE_ERROR_MEMORY = new ResultType("RESULT_TYPE_ERROR_MEMORY", 4);
        public static final ResultType RESULT_TYPE_ERROR_OUT_OF_RANGE = new ResultType("RESULT_TYPE_ERROR_OUT_OF_RANGE", 5);
        public static final ResultType RESULT_TYPE_ERROR_PROTECTED = new ResultType("RESULT_TYPE_ERROR_PROTECTED", 6);
        public static final ResultType RESULT_TYPE_ERROR_UNSUPPORTED_NOTE_VERSION = new ResultType("RESULT_TYPE_ERROR_UNSUPPORTED_NOTE_VERSION", 7);
        public static final ResultType RESULT_TYPE_CANCEL = new ResultType("RESULT_TYPE_CANCEL", 8);
        public static final ResultType RESULT_TYPE_ERROR_UNKNOWN = new ResultType("RESULT_TYPE_ERROR_UNKNOWN", 9);

        private static final /* synthetic */ ResultType[] $values() {
            return new ResultType[]{RESULT_TYPE_SUCCESS, RESULT_TYPE_ERROR_IO, RESULT_TYPE_ERROR_PASSWORD, RESULT_TYPE_ERROR_FORMAT, RESULT_TYPE_ERROR_MEMORY, RESULT_TYPE_ERROR_OUT_OF_RANGE, RESULT_TYPE_ERROR_PROTECTED, RESULT_TYPE_ERROR_UNSUPPORTED_NOTE_VERSION, RESULT_TYPE_CANCEL, RESULT_TYPE_ERROR_UNKNOWN};
        }

        static {
            ResultType[] resultTypeArr$values = $values();
            $VALUES = resultTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(resultTypeArr$values);
        }

        private ResultType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ResultType> getEntries() {
            return $ENTRIES;
        }

        public static ResultType valueOf(String str) {
            return (ResultType) Enum.valueOf(ResultType.class, str);
        }

        public static ResultType[] values() {
            return (ResultType[]) $VALUES.clone();
        }
    }

    @Nullable
    ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password, @Nullable AttachOption option);

    @Nullable
    ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password, @Nullable AttachOption option, boolean isReadOnlyAppData);

    void cancelAttachFile();

    void clearAllOverlayImage();

    void clearAllOverlayText();

    void clearSelection();

    void close();

    boolean copyFile(@NotNull String srcPath, @Nullable String password, @NotNull String dstPath);

    @Nullable
    String copyNoteCustomData(@NotNull String filePath, @Nullable String password, @NotNull PageMode pageMode);

    @NotNull
    ArrayList<SpenPdfBookmark> getBookmarkObject(@NotNull String filePath, @Nullable String password);

    @Nullable
    Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> getCursorRangeByRect(@Nullable RectF rect);

    int getCursorSelectionMaxLength();

    @Nullable
    SpenNotePdfCursorPosition getEndSelectionCursorPosition();

    @Nullable
    NoteOrientation getNoteOrientation(@NotNull String filePath, @Nullable String password, @Nullable PageMode pageMode);

    @Nullable
    Bitmap getOverlayImage(int pageIndex);

    @Nullable
    String[] getOverlayText(int pageIndex);

    int getOverlayTextLength(int pageIndex);

    @Nullable
    int[] getPageCorruptedTextObjectIndexs(int pageIndex);

    int getPageCount();

    int getPageCount(@NotNull String filePath, @Nullable String password);

    @Nullable
    Bitmap getPageImage(int pageIndex, float ratio);

    @Nullable
    PageMode getPageMode(@NotNull String filePath, @Nullable String password);

    @Nullable
    ArrayList<SpenPdfParagraph> getPageRichTextList(int pageIndex);

    int getPageTextLength(int pageIndex);

    @Nullable
    String[] getPageTextList(int pageIndex);

    @Nullable
    RectF getPdfPageSize(int pageIndex);

    @Nullable
    RectF getRectByCursorRange(@Nullable SpenNotePdfCursorPosition startCursor, @Nullable SpenNotePdfCursorPosition endCursor);

    boolean getSelectedImage(@Nullable Bitmap bitmap);

    @Nullable
    RectF getSelectedImageRect();

    @Nullable
    String getSelectedText();

    @Nullable
    SpenNotePdfCursorPosition getStartSelectionCursorPosition();

    @Nullable
    List<String> getStringListByCursorRange(@Nullable SpenNotePdfCursorPosition startCursor, @Nullable SpenNotePdfCursorPosition endCursor);

    @Nullable
    List<String> getTextByRect(@Nullable RectF rect);

    int getTextLengthOnScreen();

    boolean hasAnnotationPermission();

    boolean hasContentsCopyPermission();

    boolean hasInputField(int pageIndex);

    @Nullable
    ResultType hasOwnerPermission(@NotNull String filePath, @Nullable String password);

    boolean hasPassword(@NotNull String filePath);

    boolean hasPdfOnScreen();

    boolean hasSelectedAnnotation();

    boolean hasSelectedImage();

    boolean hasSelectedText();

    boolean isOverlayTextEnabled();

    boolean isSetOverlayText(int pdfPageIndex, @Nullable String dstLanguageTag);

    void onCursorChanged(int startPageIndex, int startCursorIndex, int endPageIndex, int endCursorIndex);

    void onLoadPdfPage(int pdfPageIndex);

    void onUnLoadPdfPage(int pdfPageIndex);

    boolean removeSelectedAnnotation();

    void requestReloadOverlayPages();

    void selectTextOnScreen();

    boolean setAnnotation(int type);

    boolean setAnnotation(int type, int color);

    void setCursorSelectionMaxLength(int i);

    void setListener(@Nullable SpenNotePdfListener l);

    void setNativeHandle(long nativeHandle);

    boolean setOverlayImage(int pdfPageIndex, @NotNull Bitmap overlayImage);

    void setOverlayRichText(int pageIndex, @NotNull ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag);

    void setOverlayText(int pdfPageIndex, @Nullable String[] overlayText, @Nullable String dstLanguageTag);

    void setOverlayTextEnable(boolean enable);

    void setPreLoadPdfFilePath(@NotNull String filePath, int fd, long fileSize);

    void setStreamingOverlayRichText(int pageIndex, int startParagraphIndex, @NotNull ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag);

    void setTextSelection(int pageIndex, int startCharIndex, int endCharIndex);

    void setTextSelection(@Nullable SpenNotePdfCursorPosition start, @Nullable SpenNotePdfCursorPosition end);

    void startAiTextFormat();

    void stopAiTextFormat();

    boolean updateAttachedFile();

    @Nullable
    ResultType verifyPassword(@NotNull String filePath, @Nullable String password);
}
