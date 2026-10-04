package com.samsung.android.sdk.composer.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.pdf.SpenPdfBookmark;
import com.samsung.android.sdk.pdf.SpenPdfParagraph;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000fH\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0007H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010)\u001a\u00020'2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010*\u001a\u00020+2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010,\u001a\u00020 2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0007H\u0016J$\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u00101\u001a\u0004\u0018\u00010+H\u0016J$\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u00020+H\u0016J,\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u000106H\u0016J4\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020 H\u0016J\"\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010;\u001a\u00020\u000fH\u0016J\u0012\u0010<\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010>\u001a\u00020\u0013H\u0016J\b\u0010?\u001a\u00020 H\u0016J \u0010@\u001a\u00020 2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0016J\u001c\u0010@\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010\u00162\b\u0010D\u001a\u0004\u0018\u00010\u0016H\u0016J1\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u000b2\u0010\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010JJ\u001a\u0010K\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u000b2\b\u0010I\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010L\u001a\u0004\u0018\u00010M2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0018\u0010N\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020MH\u0016J\u0010\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020\u0013H\u0016J\b\u0010R\u001a\u00020 H\u0016J\b\u0010S\u001a\u00020 H\u0016J\b\u0010T\u001a\u00020 H\u0016J\b\u0010U\u001a\u00020 H\u0016J\b\u0010V\u001a\u00020 H\u0016J\b\u0010W\u001a\u00020 H\u0016J\b\u0010X\u001a\u00020\u0013H\u0016J\u0010\u0010Y\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0010\u0010Z\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0016J\u001f\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010H2\u0006\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\\J\u001f\u0010]\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010H2\u0006\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\\J\u001a\u0010^\u001a\u0004\u0018\u00010M2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020\u0013H\u0016J\u0012\u0010f\u001a\u00020\u00132\b\u0010g\u001a\u0004\u0018\u00010MH\u0016J\b\u0010h\u001a\u00020\u0013H\u0016J\u0010\u0010i\u001a\u00020\u00132\u0006\u0010j\u001a\u00020\u000bH\u0016J\u0018\u0010i\u001a\u00020\u00132\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\u000bH\u0016J\b\u0010l\u001a\u00020\u0013H\u0016J\b\u0010m\u001a\u00020\u0013H\u0016J6\u0010s\u001a\u00020 2\u0006\u00104\u001a\u00020\u000b2\u001a\u0010t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010v0uj\n\u0012\u0006\u0012\u0004\u0018\u00010v`w2\b\u0010I\u001a\u0004\u0018\u00010\u000fH\u0016J>\u0010x\u001a\u00020 2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u001a\u0010t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010v0uj\n\u0012\u0006\u0012\u0004\u0018\u00010v`w2\b\u0010I\u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010z\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010v\u0018\u00010uj\f\u0012\u0006\u0012\u0004\u0018\u00010v\u0018\u0001`w2\u0006\u00104\u001a\u00020\u000bH\u0016J\b\u0010{\u001a\u00020\u0013H\u0016J\u0010\u0010|\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u000bH\u0016J\u0012\u0010}\u001a\u0004\u0018\u00010~2\u0006\u00104\u001a\u00020\u000bH\u0016J\u001e\u0010\u007f\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0080\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010cH\u0016J'\u0010\u0082\u0001\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0083\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010cH\u0016J\u0013\u0010\u0084\u0001\u001a\u0004\u0018\u00010c2\u0006\u00104\u001a\u00020\u000bH\u0016J!\u0010\u0085\u0001\u001a\u0004\u0018\u00010c2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00162\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J*\u0010\u0088\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0080\u00012\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00162\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J-\u0010\u0089\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u00010uj\t\u0012\u0005\u0012\u00030\u008a\u0001`w2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J.\u0010\u008b\u0001\u001a\u00020'2\u0006\u0010#\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u00101\u001a\u0004\u0018\u00010+2\u0007\u0010\u008c\u0001\u001a\u00020\u000fH\u0002J\u0011\u0010\u008d\u0001\u001a\u00020 2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020 2\u0007\u0010\u008f\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0090\u0001\u001a\u00020 H\u0002J\t\u0010\u0091\u0001\u001a\u00020 H\u0002J\u0011\u0010\u0092\u0001\u001a\u00020 2\u0006\u0010F\u001a\u00020\u000bH\u0016J\u0011\u0010\u0093\u0001\u001a\u00020 2\u0006\u0010F\u001a\u00020\u000bH\u0016J-\u0010\u0094\u0001\u001a\u00020 2\u0007\u0010\u0095\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020\u000b2\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0099\u0001\u001a\u00020 H\u0002J(\u0010\u009a\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0080\u00012\u0006\u0010%\u001a\u00020\u00072\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010cH\u0082 R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0014\u0010\u001d\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0016\u0010b\u001a\u0004\u0018\u00010c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR$\u0010o\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bp\u0010\r\"\u0004\bq\u0010r¨\u0006\u009c\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfManager;", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeHandle", "", "mListener", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfListener;", "pageCount", "", "getPageCount", "()I", "selectedText", "", "getSelectedText", "()Ljava/lang/String;", "isOverlayTextEnabled", "", "()Z", "startSelectionCursorPosition", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "getStartSelectionCursorPosition", "()Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "endSelectionCursorPosition", "getEndSelectionCursorPosition", "textLengthOnScreen", "getTextLengthOnScreen", "tempFile", "getTempFile", "close", "", "hasSelectedText", "hasPassword", "filePath", "setNativeHandle", "nativeHandle", "verifyPassword", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$ResultType;", "password", "hasOwnerPermission", "getPageMode", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$PageMode;", "setPreLoadPdfFilePath", "fd", "fileSize", "getNoteOrientation", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$NoteOrientation;", DBSchema.Document.PAGE_MODE, "copyNoteCustomData", "attachFile", "pageIndex", "option", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$AttachOption;", "isReadOnlyAppData", "cancelAttachFile", "copyFile", "srcPath", "dstPath", "setListener", "l", "hasContentsCopyPermission", "clearSelection", "setTextSelection", "startCharIndex", "endCharIndex", "start", "end", "setOverlayText", "pdfPageIndex", "overlayText", "", "dstLanguageTag", "(I[Ljava/lang/String;Ljava/lang/String;)V", "isSetOverlayText", "getOverlayImage", "Landroid/graphics/Bitmap;", "setOverlayImage", "overlayImage", "setOverlayTextEnable", "enable", "requestReloadOverlayPages", "clearAllOverlayText", "clearAllOverlayImage", "startAiTextFormat", "stopAiTextFormat", "selectTextOnScreen", "hasPdfOnScreen", "getPageTextLength", "getOverlayTextLength", "getPageTextList", "(I)[Ljava/lang/String;", "getOverlayText", "getPageImage", "ratio", "", "hasSelectedImage", "selectedImageRect", "Landroid/graphics/RectF;", "getSelectedImageRect", "()Landroid/graphics/RectF;", "getSelectedImage", "bitmap", "hasAnnotationPermission", "setAnnotation", "type", "color", "hasSelectedAnnotation", "removeSelectedAnnotation", "length", "cursorSelectionMaxLength", "getCursorSelectionMaxLength", "setCursorSelectionMaxLength", "(I)V", "setOverlayRichText", "listTextParagraph", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "setStreamingOverlayRichText", "startParagraphIndex", "getPageRichTextList", "updateAttachedFile", "hasInputField", "getPageCorruptedTextObjectIndexs", "", "getTextByRect", "", "rect", "getCursorRangeByRect", "Landroid/util/Pair;", "getPdfPageSize", "getRectByCursorRange", "startCursor", "endCursor", "getStringListByCursorRange", "getBookmarkObject", "Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "getAppData", "outPath", "removeTempFile", "onProgressChanged", "p", "onCompleted", "onMaxSelectionTextLengthReached", "onLoadPdfPage", "onUnLoadPdfPage", "onCursorChanged", "startPageIndex", "startCursorIndex", "endPageIndex", "endCursorIndex", "onSelectionAreaLongPressed", "Native_getTextByRect", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenNotePdfManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenNotePdfManager.kt\ncom/samsung/android/sdk/composer/pdf/SpenNotePdfManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,864:1\n1#2:865\n*E\n"})
public final class SpenNotePdfManager implements ISpenNotePdfManager {
    public static final int ANNOTATION_HIGHLIGHT = 0;
    public static final int ANNOTATION_STRIKEOUT = 2;
    public static final int ANNOTATION_UNDERLINE = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNotePdfManager";

    @Nullable
    private Context mContext;

    @Nullable
    private SpenNotePdfListener mListener;
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0083 J#\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0083 J)\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\rH\u0083 JC\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0013H\u0083 J+\u0010\"\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0005H\u0083 J\u0011\u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010&\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010'\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0013\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010)\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J1\u0010*\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0083 J5\u0010/\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0083 J\u001b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J!\u00106\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u00107\u001a\u000205H\u0083 J\u0019\u00108\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0013H\u0083 J\u0011\u0010:\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010;\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010<\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010=\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010>\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010?\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010@\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010A\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010B\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0013H\u0083 J\u0011\u0010C\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010D\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010E\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u0019\u0010F\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J#\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J#\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J#\u0010I\u001a\u0004\u0018\u0001052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010J\u001a\u00020KH\u0083 J#\u0010L\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010M\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0013\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u001b\u0010P\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\b\u0010Q\u001a\u0004\u0018\u000105H\u0083 J\u0011\u0010R\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010S\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u0007H\u0083 J!\u0010U\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0083 J\u0011\u0010W\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010X\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010Y\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\u0007H\u0083 J\u0011\u0010[\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J?\u0010\\\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u001a\u0010]\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010_0^j\n\u0012\u0006\u0012\u0004\u0018\u00010_``2\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0083 JG\u0010a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u001a\u0010]\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010_0^j\n\u0012\u0006\u0012\u0004\u0018\u00010_``2\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0083 J1\u0010c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010_\u0018\u00010^j\f\u0012\u0006\u0012\u0004\u0018\u00010_\u0018\u0001``2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u0011\u0010d\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010e\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u001b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u0011\u0010h\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0083 J\u001b\u0010i\u001a\u0004\u0018\u00010O2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J-\u0010j\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010l\u0012\u0006\u0012\u0004\u0018\u00010l\u0018\u00010k2\u0006\u0010\f\u001a\u00020\r2\b\u0010m\u001a\u0004\u0018\u00010OH\u0083 J3\u0010n\u001a\u0004\u0018\u00010O2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0083 J3\u0010o\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u0005H\u0083 J;\u0010r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010s2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0083 J1\u0010t\u001a\b\u0012\u0004\u0012\u00020u0^2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006v"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ANNOTATION_HIGHLIGHT", "", "ANNOTATION_UNDERLINE", "ANNOTATION_STRIKEOUT", "Native_init", "", "nativeHandle", "", "manager", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfManager;", "Native_finalize", "Native_getPdfPageCount", "Native_hasPassword", "", "filePath", "Native_verifyPassword", "password", "Native_hasOwnerPermission", "Native_getPageCount", "mNativeHandle", "Native_setPreLoadPdfFilePath", "fd", "fileSize", "Native_attachFile", "cacheDirPath", "pageIndex", "option", "isReadOnlyAppData", "Native_copyFile", "srcPath", "dstPath", "Native_cancelAttachFile", "Native_hasContentsCopyPermission", "Native_hasSelectedText", "Native_getSelectedText", "Native_clearSelection", "Native_setTextSelection", "startPageIndex", "startTextIndex", "endPageIndex", "endTextIndex", "Native_setOverlayText", "overlayText", "", "dstLanguageTag", "Native_isSetOverlayText", "Native_getOverlayImage", "Landroid/graphics/Bitmap;", "Native_setOverlayImage", "overlayImage", "Native_setOverlayTextEnable", "enable", "Native_isOverlayTextEnabled", "Native_requestReloadPages", "Native_clearAllOverlayText", "Native_clearAllOverlayImage", "Native_getStartSelectionPageIndex", "Native_getStartSelectionTextIndex", "Native_getEndSelectionPageIndex", "Native_getEndSelectionTextIndex", "Native_setAiTextFormat", "Native_selectTextOnScreen", "Native_getTextLengthOnScreen", "Native_getPageTextLength", "Native_getOverlayTextLength", "Native_getPageTextList", "Native_getOverlayText", "Native_getPageImage", "ratio", "", "Native_getPageMode", "Native_hasSelectedImage", "Native_getSelectedImageRect", "Landroid/graphics/RectF;", "Native_getSelectedImage", "bitmap", "Native_hasAnnotationPermission", "Native_setAnnotation", "type", "Native_setColorAnnotation", "color", "Native_hasSelectedAnnotation", "Native_removeSelectedAnnotation", "Native_setCursorSelectionMaxLength", "len", "Native_getCursorSelectionMaxLength", "Native_setOverlayRichText", "pdfParagraphList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "Native_setStreamingOverlayRichText", "startParagraphIndex", "Native_getPageRichTextList", "Native_updateAttachedFile", "Native_hasInputField", "Native_getPageCorruptedTextObjectIndexs", "", "Native_hasPdfOnScreen", "Native_getPdfPageSize", "Native_getCursorRangeByRect", "Landroid/util/Pair;", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "rect", "Native_getRectByCursorRange", "Native_getAppData", DBSchema.Document.PAGE_MODE, "outPath", "Native_getStringListByCursorRange", "", "Native_getBookmarkObject", "Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_attachFile(long nativeHandle, String cacheDirPath, int pageIndex, String filePath, String password, int option, boolean isReadOnlyAppData) {
            return SpenNotePdfManager.Native_attachFile(nativeHandle, cacheDirPath, pageIndex, filePath, password, option, isReadOnlyAppData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_cancelAttachFile(long nativeHandle) {
            SpenNotePdfManager.Native_cancelAttachFile(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearAllOverlayImage(long nativeHandle) {
            SpenNotePdfManager.Native_clearAllOverlayImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearAllOverlayText(long nativeHandle) {
            SpenNotePdfManager.Native_clearAllOverlayText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearSelection(long nativeHandle) {
            SpenNotePdfManager.Native_clearSelection(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_copyFile(long nativeHandle, String srcPath, String password, String dstPath) {
            return SpenNotePdfManager.Native_copyFile(nativeHandle, srcPath, password, dstPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenNotePdfManager.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getAppData(long nativeHandle, String filePath, String password, int pageMode, String outPath) {
            return SpenNotePdfManager.Native_getAppData(nativeHandle, filePath, password, pageMode, outPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenPdfBookmark> Native_getBookmarkObject(long nativeHandle, String cacheDirPath, String filePath, String password) {
            return SpenNotePdfManager.Native_getBookmarkObject(nativeHandle, cacheDirPath, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> Native_getCursorRangeByRect(long nativeHandle, RectF rect) {
            return SpenNotePdfManager.Native_getCursorRangeByRect(nativeHandle, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getCursorSelectionMaxLength(long nativeHandle) {
            return SpenNotePdfManager.Native_getCursorSelectionMaxLength(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getEndSelectionPageIndex(long nativeHandle) {
            return SpenNotePdfManager.Native_getEndSelectionPageIndex(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getEndSelectionTextIndex(long nativeHandle) {
            return SpenNotePdfManager.Native_getEndSelectionTextIndex(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_getOverlayImage(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_getOverlayImage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] Native_getOverlayText(long j, int i) {
            return SpenNotePdfManager.Native_getOverlayText(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getOverlayTextLength(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_getOverlayTextLength(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] Native_getPageCorruptedTextObjectIndexs(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_getPageCorruptedTextObjectIndexs(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long mNativeHandle, String filePath, String password) {
            return SpenNotePdfManager.Native_getPageCount(mNativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_getPageImage(long nativeHandle, int pageIndex, float ratio) {
            return SpenNotePdfManager.Native_getPageImage(nativeHandle, pageIndex, ratio);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageMode(long nativeHandle, String filePath, String password) {
            return SpenNotePdfManager.Native_getPageMode(nativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenPdfParagraph> Native_getPageRichTextList(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_getPageRichTextList(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageTextLength(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_getPageTextLength(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] Native_getPageTextList(long j, int i) {
            return SpenNotePdfManager.Native_getPageTextList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPdfPageCount(long nativeHandle) {
            return SpenNotePdfManager.Native_getPdfPageCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getPdfPageSize(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_getPdfPageSize(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getRectByCursorRange(long nativeHandle, int startPageIndex, int startTextIndex, int endPageIndex, int endTextIndex) {
            return SpenNotePdfManager.Native_getRectByCursorRange(nativeHandle, startPageIndex, startTextIndex, endPageIndex, endTextIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_getSelectedImage(long nativeHandle, Bitmap bitmap) {
            return SpenNotePdfManager.Native_getSelectedImage(nativeHandle, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getSelectedImageRect(long nativeHandle) {
            return SpenNotePdfManager.Native_getSelectedImageRect(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getSelectedText(long nativeHandle) {
            return SpenNotePdfManager.Native_getSelectedText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getStartSelectionPageIndex(long nativeHandle) {
            return SpenNotePdfManager.Native_getStartSelectionPageIndex(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getStartSelectionTextIndex(long nativeHandle) {
            return SpenNotePdfManager.Native_getStartSelectionTextIndex(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final List<String> Native_getStringListByCursorRange(long nativeHandle, int startPageIndex, int startTextIndex, int endPageIndex, int endTextIndex) {
            return SpenNotePdfManager.Native_getStringListByCursorRange(nativeHandle, startPageIndex, startTextIndex, endPageIndex, endTextIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getTextLengthOnScreen(long nativeHandle) {
            return SpenNotePdfManager.Native_getTextLengthOnScreen(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasAnnotationPermission(long nativeHandle) {
            return SpenNotePdfManager.Native_hasAnnotationPermission(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasContentsCopyPermission(long nativeHandle) {
            return SpenNotePdfManager.Native_hasContentsCopyPermission(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasInputField(long nativeHandle, int pageIndex) {
            return SpenNotePdfManager.Native_hasInputField(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_hasOwnerPermission(long nativeHandle, String filePath, String password) {
            return SpenNotePdfManager.Native_hasOwnerPermission(nativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasPassword(long nativeHandle, String filePath) {
            return SpenNotePdfManager.Native_hasPassword(nativeHandle, filePath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasPdfOnScreen(long nativeHandle) {
            return SpenNotePdfManager.Native_hasPdfOnScreen(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasSelectedAnnotation(long nativeHandle) {
            return SpenNotePdfManager.Native_hasSelectedAnnotation(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasSelectedImage(long nativeHandle) {
            return SpenNotePdfManager.Native_hasSelectedImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasSelectedText(long nativeHandle) {
            return SpenNotePdfManager.Native_hasSelectedText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHandle, SpenNotePdfManager manager) {
            SpenNotePdfManager.Native_init(nativeHandle, manager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isOverlayTextEnabled(long nativeHandle) {
            return SpenNotePdfManager.Native_isOverlayTextEnabled(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isSetOverlayText(long nativeHandle, int pageIndex, String dstLanguageTag) {
            return SpenNotePdfManager.Native_isSetOverlayText(nativeHandle, pageIndex, dstLanguageTag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_removeSelectedAnnotation(long nativeHandle) {
            return SpenNotePdfManager.Native_removeSelectedAnnotation(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_requestReloadPages(long nativeHandle) {
            SpenNotePdfManager.Native_requestReloadPages(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_selectTextOnScreen(long nativeHandle) {
            SpenNotePdfManager.Native_selectTextOnScreen(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAiTextFormat(long nativeHandle, boolean enable) {
            SpenNotePdfManager.Native_setAiTextFormat(nativeHandle, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setAnnotation(long nativeHandle, int type) {
            return SpenNotePdfManager.Native_setAnnotation(nativeHandle, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setColorAnnotation(long nativeHandle, int type, int color) {
            return SpenNotePdfManager.Native_setColorAnnotation(nativeHandle, type, color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCursorSelectionMaxLength(long nativeHandle, int len) {
            SpenNotePdfManager.Native_setCursorSelectionMaxLength(nativeHandle, len);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setOverlayImage(long nativeHandle, int pageIndex, Bitmap overlayImage) {
            return SpenNotePdfManager.Native_setOverlayImage(nativeHandle, pageIndex, overlayImage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayRichText(long nativeHandle, int pageIndex, ArrayList<SpenPdfParagraph> pdfParagraphList, String dstLanguageTag) {
            SpenNotePdfManager.Native_setOverlayRichText(nativeHandle, pageIndex, pdfParagraphList, dstLanguageTag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayText(long j, int i, String[] strArr, String str) {
            SpenNotePdfManager.Native_setOverlayText(j, i, strArr, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayTextEnable(long nativeHandle, boolean enable) {
            SpenNotePdfManager.Native_setOverlayTextEnable(nativeHandle, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPreLoadPdfFilePath(long mNativeHandle, String filePath, int fd, long fileSize) {
            SpenNotePdfManager.Native_setPreLoadPdfFilePath(mNativeHandle, filePath, fd, fileSize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setStreamingOverlayRichText(long nativeHandle, int pageIndex, int startParagraphIndex, ArrayList<SpenPdfParagraph> pdfParagraphList, String dstLanguageTag) {
            SpenNotePdfManager.Native_setStreamingOverlayRichText(nativeHandle, pageIndex, startParagraphIndex, pdfParagraphList, dstLanguageTag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTextSelection(long nativeHandle, int startPageIndex, int startTextIndex, int endPageIndex, int endTextIndex) {
            SpenNotePdfManager.Native_setTextSelection(nativeHandle, startPageIndex, startTextIndex, endPageIndex, endTextIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_updateAttachedFile(long nativeHandle) {
            return SpenNotePdfManager.Native_updateAttachedFile(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_verifyPassword(long nativeHandle, String filePath, String password) {
            return SpenNotePdfManager.Native_verifyPassword(nativeHandle, filePath, password);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenWNote.Orientation.values().length];
            try {
                iArr[SpenWNote.Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenWNote.Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpenWNote.Orientation.LANDSCAPE_NEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpenNotePdfManager(@Nullable Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_attachFile(long j, String str, int i, String str2, String str3, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_cancelAttachFile(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_clearAllOverlayImage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_clearAllOverlayText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_clearSelection(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_copyFile(long j, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getAppData(long j, String str, String str2, int i, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenPdfBookmark> Native_getBookmarkObject(long j, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> Native_getCursorRangeByRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getCursorSelectionMaxLength(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getEndSelectionPageIndex(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getEndSelectionTextIndex(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Bitmap Native_getOverlayImage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String[] Native_getOverlayText(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getOverlayTextLength(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int[] Native_getPageCorruptedTextObjectIndexs(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Bitmap Native_getPageImage(long j, int i, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageMode(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenPdfParagraph> Native_getPageRichTextList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageTextLength(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String[] Native_getPageTextList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPdfPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getPdfPageSize(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getRectByCursorRange(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_getSelectedImage(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getSelectedImageRect(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getSelectedText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getStartSelectionPageIndex(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getStartSelectionTextIndex(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native List<String> Native_getStringListByCursorRange(long j, int i, int i2, int i4, int i5);

    private final native List<String> Native_getTextByRect(long nativeHandle, RectF rect);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getTextLengthOnScreen(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasAnnotationPermission(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasContentsCopyPermission(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasInputField(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_hasOwnerPermission(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasPassword(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasPdfOnScreen(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasSelectedAnnotation(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasSelectedImage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasSelectedText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenNotePdfManager spenNotePdfManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isOverlayTextEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isSetOverlayText(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_removeSelectedAnnotation(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_requestReloadPages(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_selectTextOnScreen(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAiTextFormat(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setAnnotation(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setColorAnnotation(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCursorSelectionMaxLength(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setOverlayImage(long j, int i, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOverlayRichText(long j, int i, ArrayList<SpenPdfParagraph> arrayList, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOverlayText(long j, int i, String[] strArr, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOverlayTextEnable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPreLoadPdfFilePath(long j, String str, int i, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setStreamingOverlayRichText(long j, int i, int i2, ArrayList<SpenPdfParagraph> arrayList, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTextSelection(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_updateAttachedFile(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_verifyPassword(long j, String str, String str2);

    private final ISpenNotePdfManager.ResultType getAppData(String filePath, String password, ISpenNotePdfManager.PageMode pageMode, String outPath) {
        ISpenNotePdfManager.ResultType resultType;
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        Companion companion = INSTANCE;
        Intrinsics.checkNotNull(pageMode);
        int iNative_getAppData = companion.Native_getAppData(j, filePath, password, pageMode.ordinal(), outPath);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_getAppData) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    private final String getTempFile() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        String str = context.getFilesDir().getAbsolutePath() + "/" + System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    private final void onCompleted() {
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onCompleted();
        }
    }

    private final void onMaxSelectionTextLengthReached() {
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onMaxSelectionTextLengthReached();
        }
    }

    private final void onProgressChanged(int p) {
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onProgressChanged(p);
        }
    }

    private final void onSelectionAreaLongPressed() {
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onSelectionAreaLongPressed();
        }
    }

    private final void removeTempFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.delete()) {
            return;
        }
        AbstractC4539a.m3207q("fail to delete file[", filePath, "]", TAG);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ISpenNotePdfManager.ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password, @Nullable ISpenNotePdfManager.AttachOption option) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        Companion companion = INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        Intrinsics.checkNotNull(option);
        int iNative_attachFile = companion.Native_attachFile(j, absolutePath, pageIndex, filePath, password, option.ordinal(), false);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_attachFile) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void cancelAttachFile() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_cancelAttachFile(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void clearAllOverlayImage() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_clearAllOverlayImage(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void clearAllOverlayText() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_clearAllOverlayText(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void clearSelection() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_clearSelection(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void close() {
        INSTANCE.Native_finalize(this.mNativeHandle);
        this.mNativeHandle = 0L;
        this.mContext = null;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean copyFile(@NotNull String srcPath, @Nullable String password, @NotNull String dstPath) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(dstPath, "dstPath");
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_copyFile(j, srcPath, password, dstPath);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String copyNoteCustomData(@NotNull String filePath, @Nullable String password, @NotNull ISpenNotePdfManager.PageMode pageMode) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(pageMode, "pageMode");
        if (this.mNativeHandle == 0) {
            return null;
        }
        String tempFile = getTempFile();
        if (getAppData(filePath, password, pageMode, tempFile) != ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS) {
            return null;
        }
        String appCustomData = SpenWNoteFile.getAppCustomData(tempFile);
        removeTempFile(tempFile);
        return appCustomData;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ArrayList<SpenPdfBookmark> getBookmarkObject(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Log.d("bookmark", "getBookmarkObject started");
        Companion companion = INSTANCE;
        long j = this.mNativeHandle;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return companion.Native_getBookmarkObject(j, absolutePath, filePath, password);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public Pair<SpenNotePdfCursorPosition, SpenNotePdfCursorPosition> getCursorRangeByRect(@Nullable RectF rect) {
        return INSTANCE.Native_getCursorRangeByRect(this.mNativeHandle, rect);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getCursorSelectionMaxLength() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getCursorSelectionMaxLength(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public SpenNotePdfCursorPosition getEndSelectionCursorPosition() {
        Companion companion = INSTANCE;
        return new SpenNotePdfCursorPosition(companion.Native_getEndSelectionPageIndex(this.mNativeHandle), companion.Native_getEndSelectionTextIndex(this.mNativeHandle));
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ISpenNotePdfManager.NoteOrientation getNoteOrientation(@NotNull String filePath, @Nullable String password, @Nullable ISpenNotePdfManager.PageMode pageMode) {
        ISpenNotePdfManager.NoteOrientation noteOrientation;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        ISpenNotePdfManager.NoteOrientation noteOrientation2 = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_NONE;
        if (this.mNativeHandle != 0) {
            String tempFile = getTempFile();
            if (getAppData(filePath, password, pageMode, tempFile) == ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS) {
                int i = WhenMappings.$EnumSwitchMapping$0[SpenWNoteFile.getOrientation(tempFile).ordinal()];
                if (i == 1) {
                    noteOrientation = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_PORTRAIT;
                } else if (i == 2) {
                    noteOrientation = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE;
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    noteOrientation = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE_NEW;
                }
                removeTempFile(tempFile);
                return noteOrientation;
            }
        }
        return noteOrientation2;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public Bitmap getOverlayImage(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getOverlayImage(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String[] getOverlayText(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getOverlayText(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getOverlayTextLength(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getOverlayTextLength(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public int[] getPageCorruptedTextObjectIndexs(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageCorruptedTextObjectIndexs(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getPageCount() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPdfPageCount(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public Bitmap getPageImage(int pageIndex, float ratio) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageImage(j, pageIndex, ratio);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ISpenNotePdfManager.PageMode getPageMode(@NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.PageMode pageMode;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.PageMode.PAGE_MODE_NONE;
        }
        int iNative_getPageMode = INSTANCE.Native_getPageMode(j, filePath, password);
        ISpenNotePdfManager.PageMode[] pageModeArrValues = ISpenNotePdfManager.PageMode.values();
        int length = pageModeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                pageMode = null;
                break;
            }
            pageMode = pageModeArrValues[i];
            if (pageMode.ordinal() == iNative_getPageMode) {
                break;
            }
            i++;
        }
        return pageMode == null ? ISpenNotePdfManager.PageMode.PAGE_MODE_NONE : pageMode;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public ArrayList<SpenPdfParagraph> getPageRichTextList(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageRichTextList(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getPageTextLength(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageTextLength(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String[] getPageTextList(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageTextList(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public RectF getPdfPageSize(int pageIndex) {
        long j = this.mNativeHandle;
        return j == 0 ? new RectF() : INSTANCE.Native_getPdfPageSize(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public RectF getRectByCursorRange(@Nullable SpenNotePdfCursorPosition startCursor, @Nullable SpenNotePdfCursorPosition endCursor) {
        Companion companion = INSTANCE;
        long j = this.mNativeHandle;
        Intrinsics.checkNotNull(startCursor);
        int pageIndex = startCursor.getPageIndex();
        int cursorIndex = startCursor.getCursorIndex();
        Intrinsics.checkNotNull(endCursor);
        return companion.Native_getRectByCursorRange(j, pageIndex, cursorIndex, endCursor.getPageIndex(), endCursor.getCursorIndex());
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean getSelectedImage(@Nullable Bitmap bitmap) {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_getSelectedImage(j, bitmap);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public RectF getSelectedImageRect() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getSelectedImageRect(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public String getSelectedText() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getSelectedText(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public SpenNotePdfCursorPosition getStartSelectionCursorPosition() {
        Companion companion = INSTANCE;
        return new SpenNotePdfCursorPosition(companion.Native_getStartSelectionPageIndex(this.mNativeHandle), companion.Native_getStartSelectionTextIndex(this.mNativeHandle));
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public List<String> getStringListByCursorRange(@Nullable SpenNotePdfCursorPosition startCursor, @Nullable SpenNotePdfCursorPosition endCursor) {
        Companion companion = INSTANCE;
        long j = this.mNativeHandle;
        Intrinsics.checkNotNull(startCursor);
        int pageIndex = startCursor.getPageIndex();
        int cursorIndex = startCursor.getCursorIndex();
        Intrinsics.checkNotNull(endCursor);
        return companion.Native_getStringListByCursorRange(j, pageIndex, cursorIndex, endCursor.getPageIndex(), endCursor.getCursorIndex());
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @Nullable
    public List<String> getTextByRect(@Nullable RectF rect) {
        return Native_getTextByRect(this.mNativeHandle, rect);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getTextLengthOnScreen() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getTextLengthOnScreen(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasAnnotationPermission() {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_hasAnnotationPermission(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasContentsCopyPermission() {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_hasContentsCopyPermission(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasInputField(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_hasInputField(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ISpenNotePdfManager.ResultType hasOwnerPermission(@NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        int iNative_hasOwnerPermission = INSTANCE.Native_hasOwnerPermission(j, filePath, password);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_hasOwnerPermission) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasPassword(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_hasPassword(j, filePath);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasPdfOnScreen() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_hasPdfOnScreen(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasSelectedAnnotation() {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_hasSelectedAnnotation(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasSelectedImage() {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_hasSelectedImage(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean hasSelectedText() {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_hasSelectedText(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean isOverlayTextEnabled() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isOverlayTextEnabled(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean isSetOverlayText(int pdfPageIndex, @Nullable String dstLanguageTag) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isSetOverlayText(j, pdfPageIndex, dstLanguageTag);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void onCursorChanged(int startPageIndex, int startCursorIndex, int endPageIndex, int endCursorIndex) {
        Log.i(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(startPageIndex, startCursorIndex, "onCursorChanged start(", "/", ") end("), endPageIndex, endCursorIndex, "/", ")"));
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onCursorChanged(new SpenNotePdfCursorPosition(startPageIndex, startCursorIndex), new SpenNotePdfCursorPosition(endPageIndex, endCursorIndex));
        }
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void onLoadPdfPage(int pdfPageIndex) {
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onLoadPdfPage(pdfPageIndex);
        }
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void onUnLoadPdfPage(int pdfPageIndex) {
        SpenNotePdfListener spenNotePdfListener = this.mListener;
        if (spenNotePdfListener != null) {
            spenNotePdfListener.onUnLoadPdfPage(pdfPageIndex);
        }
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean removeSelectedAnnotation() {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_removeSelectedAnnotation(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void requestReloadOverlayPages() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_requestReloadPages(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void selectTextOnScreen() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_selectTextOnScreen(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean setAnnotation(int type) {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_setAnnotation(j, type);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setCursorSelectionMaxLength(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setCursorSelectionMaxLength(j, i);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setListener(@Nullable SpenNotePdfListener l) {
        this.mListener = l;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setNativeHandle(long nativeHandle) {
        this.mNativeHandle = nativeHandle;
        INSTANCE.Native_init(nativeHandle, this);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean setOverlayImage(int pdfPageIndex, @NotNull Bitmap overlayImage) {
        Intrinsics.checkNotNullParameter(overlayImage, "overlayImage");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setOverlayImage(j, pdfPageIndex, overlayImage);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setOverlayRichText(int pageIndex, @NotNull ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag) {
        Intrinsics.checkNotNullParameter(listTextParagraph, "listTextParagraph");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayRichText(j, pageIndex, listTextParagraph, dstLanguageTag);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setOverlayText(int pdfPageIndex, @Nullable String[] overlayText, @Nullable String dstLanguageTag) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayText(j, pdfPageIndex, overlayText, dstLanguageTag);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setOverlayTextEnable(boolean enable) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayTextEnable(j, enable);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setPreLoadPdfFilePath(@NotNull String filePath, int fd, long fileSize) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setPreLoadPdfFilePath(j, filePath, fd, fileSize);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setStreamingOverlayRichText(int pageIndex, int startParagraphIndex, @NotNull ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag) {
        Intrinsics.checkNotNullParameter(listTextParagraph, "listTextParagraph");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setStreamingOverlayRichText(j, pageIndex, startParagraphIndex, listTextParagraph, dstLanguageTag);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setTextSelection(int pageIndex, int startCharIndex, int endCharIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setTextSelection(j, pageIndex, startCharIndex, pageIndex, endCharIndex);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void startAiTextFormat() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setAiTextFormat(j, true);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void stopAiTextFormat() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setAiTextFormat(j, false);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean updateAttachedFile() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_updateAttachedFile(j);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ISpenNotePdfManager.ResultType verifyPassword(@NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        int iNative_verifyPassword = INSTANCE.Native_verifyPassword(j, filePath, password);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_verifyPassword) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public boolean setAnnotation(int type, int color) {
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_setColorAnnotation(j, type, color);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public int getPageCount(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getPageCount(j, filePath, password);
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    public void setTextSelection(@Nullable SpenNotePdfCursorPosition start, @Nullable SpenNotePdfCursorPosition end) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        Companion companion = INSTANCE;
        Intrinsics.checkNotNull(start);
        int pageIndex = start.getPageIndex();
        int cursorIndex = start.getCursorIndex();
        Intrinsics.checkNotNull(end);
        companion.Native_setTextSelection(j, pageIndex, cursorIndex, end.getPageIndex(), end.getCursorIndex());
    }

    @Override // com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager
    @NotNull
    public ISpenNotePdfManager.ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password, @Nullable ISpenNotePdfManager.AttachOption option, boolean isReadOnlyAppData) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        Companion companion = INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        Intrinsics.checkNotNull(option);
        int iNative_attachFile = companion.Native_attachFile(j, absolutePath, pageIndex, filePath, password, option.ordinal(), isReadOnlyAppData);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_attachFile) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }
}
