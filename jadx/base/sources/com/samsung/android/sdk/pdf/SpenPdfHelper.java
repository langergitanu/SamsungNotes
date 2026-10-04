package com.samsung.android.sdk.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 L2\u00020\u0001:\u0001LB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ \u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\fJ\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u0011J\u0016\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020&J\u0010\u00100\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020\u0015J\u0006\u00101\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u00103\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J\u001d\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0002\u00106J\u001d\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0002\u00106J\u0016\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u0015J-\u0010:\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00152\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013052\b\u0010<\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010=J&\u0010>\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u001e2\b\u0010<\u001a\u0004\u0018\u00010\u0013J\u000e\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0011J\u000e\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010C\u001a\u00020\u0011J\u0006\u0010D\u001a\u00020\fJ\u0010\u0010E\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0015H\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0015H\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020IH\u0002J\"\u0010J\u001a\u0004\u0018\u00010&2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u0015J\u001d\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0002\u00106R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010!\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010*\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeHandle", "", "mListener", "Lcom/samsung/android/sdk/pdf/SpenPdfListener;", "synchronizationLock", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setNativeHandle", "nativeHandle", "hasPassword", "", "filePath", "", "verifyPassword", "", "password", "hasOwnerPermission", "getPageCount", "setOCRData", "pageIndex", "data", "Lcom/samsung/android/sdk/pdf/SpenOcrData;", "getBookmarkObject", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "hasSelectedText", "selectedText", "getSelectedText", "()Ljava/lang/String;", "clearSelection", "getPageImage", "Landroid/graphics/Bitmap;", "ratio", "", "hasSelectedImage", "getSelectedImage", "getGetSelectedImage", "()Landroid/graphics/Bitmap;", "setOverlayImage", "pdfPageIndex", "overlayImage", "getOverlayImage", "clearAllOverlayImage", "getPageTextLength", "getOverlayTextLength", "getPageTextList", "", "(I)[Ljava/lang/String;", "getOverlayText", "getPageRichTextList", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "setOverlayText", "overlayTextList", "dstLanguageTag", "(I[Ljava/lang/String;Ljava/lang/String;)V", "setOverlayRichText", "pdfParagraphList", "setOverlayTextEnable", "enable", "setOCRTextEnable", "isOverlayTextEnabled", "clearAllOverlayText", "onLoadPdfPage", "onUnLoadPdfPage", "onScreenPages", "pages", "", "capturePage", "getFontNameList", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenPdfHelper";

    @Nullable
    private SpenPdfListener mListener;
    private long mNativeHandle;

    @NotNull
    private final Object synchronizationLock;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0083 J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u001b\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 J#\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0083 J\u0013\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J!\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001dH\u0083 J\u001b\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 J\u0011\u0010%\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010&\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 J\u0019\u0010'\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 J#\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010)2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 J#\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010)2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 J!\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 J3\u0010-\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050)2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0083 J1\u00100\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020,0\u00172\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0019\u00102\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0007H\u0083 J\u0019\u00104\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0007H\u0083 J\u0011\u00105\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u00106\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 J-\u00107\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\fH\u0083 J\u0019\u00108\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u00109\u001a\u00020:H\u0083 J#\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010)2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_hasPassword", "", "nativeHandle", "", "filePath", "Native_verifyPassword", "", "password", "Native_hasOwnerPermission", "Native_getPageCount", "mNativeHandle", "Native_setOCRData", "", "pageIndex", "ocrData", "Lcom/samsung/android/sdk/pdf/SpenOcrData;", "Native_getBookmarkObject", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfBookmark;", "Native_hasSelectedText", "Native_getSelectedText", "Native_clearSelection", "Native_getPageImage", "Landroid/graphics/Bitmap;", "ratio", "", "Native_getSelectedImage", "Native_hasSelectedImage", "Native_setOverlayImage", "overlayImage", "Native_getOverlayImage", "Native_clearAllOverlayImage", "Native_getPageTextLength", "Native_getOverlayTextLength", "Native_getPageTextList", "", "Native_getOverlayText", "Native_getPageRichTextList", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Native_setOverlayText", "overlayTextList", "dstLanguageTag", "Native_setOverlayRichText", "pdfParagraphList", "Native_setOverlayTextEnable", "enable", "Native_setOCRTextEnable", "Native_isOverlayTextEnabled", "Native_clearAllOverlayText", "Native_capturePage", "Native_init", "helper", "Lcom/samsung/android/sdk/pdf/SpenPdfHelper;", "Native_getFontNameList", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_capturePage(long nativeHandle, String filePath, String password, int pageIndex) {
            return SpenPdfHelper.Native_capturePage(nativeHandle, filePath, password, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearAllOverlayImage(long nativeHandle) {
            SpenPdfHelper.Native_clearAllOverlayImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearAllOverlayText(long nativeHandle) {
            SpenPdfHelper.Native_clearAllOverlayText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearSelection(long nativeHandle) {
            SpenPdfHelper.Native_clearSelection(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenPdfBookmark> Native_getBookmarkObject(long mNativeHandle, String filePath, String password) {
            return SpenPdfHelper.Native_getBookmarkObject(mNativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] Native_getFontNameList(long j, int i) {
            return SpenPdfHelper.Native_getFontNameList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_getOverlayImage(long nativeHandle, int pageIndex) {
            return SpenPdfHelper.Native_getOverlayImage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] Native_getOverlayText(long j, int i) {
            return SpenPdfHelper.Native_getOverlayText(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getOverlayTextLength(long nativeHandle, int pageIndex) {
            return SpenPdfHelper.Native_getOverlayTextLength(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long mNativeHandle, String filePath, String password) {
            return SpenPdfHelper.Native_getPageCount(mNativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_getPageImage(long nativeHandle, int pageIndex, float ratio) {
            return SpenPdfHelper.Native_getPageImage(nativeHandle, pageIndex, ratio);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenPdfParagraph> Native_getPageRichTextList(long nativeHandle, int pageIndex) {
            return SpenPdfHelper.Native_getPageRichTextList(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageTextLength(long nativeHandle, int pageIndex) {
            return SpenPdfHelper.Native_getPageTextLength(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] Native_getPageTextList(long j, int i) {
            return SpenPdfHelper.Native_getPageTextList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_getSelectedImage(long nativeHandle) {
            return SpenPdfHelper.Native_getSelectedImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getSelectedText(long nativeHandle) {
            return SpenPdfHelper.Native_getSelectedText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_hasOwnerPermission(long nativeHandle, String filePath, String password) {
            return SpenPdfHelper.Native_hasOwnerPermission(nativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasPassword(long nativeHandle, String filePath) {
            return SpenPdfHelper.Native_hasPassword(nativeHandle, filePath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasSelectedImage(long nativeHandle) {
            return SpenPdfHelper.Native_hasSelectedImage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasSelectedText(long nativeHandle) {
            return SpenPdfHelper.Native_hasSelectedText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHandle, SpenPdfHelper helper) {
            SpenPdfHelper.Native_init(nativeHandle, helper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isOverlayTextEnabled(long nativeHandle) {
            return SpenPdfHelper.Native_isOverlayTextEnabled(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOCRData(long nativeHandle, int pageIndex, SpenOcrData ocrData) {
            SpenPdfHelper.Native_setOCRData(nativeHandle, pageIndex, ocrData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOCRTextEnable(long nativeHandle, boolean enable) {
            SpenPdfHelper.Native_setOCRTextEnable(nativeHandle, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setOverlayImage(long nativeHandle, int pageIndex, Bitmap overlayImage) {
            return SpenPdfHelper.Native_setOverlayImage(nativeHandle, pageIndex, overlayImage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayRichText(long nativeHandle, int pageIndex, ArrayList<SpenPdfParagraph> pdfParagraphList, String dstLanguageTag) {
            SpenPdfHelper.Native_setOverlayRichText(nativeHandle, pageIndex, pdfParagraphList, dstLanguageTag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayText(long j, int i, String[] strArr, String str) {
            SpenPdfHelper.Native_setOverlayText(j, i, strArr, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayTextEnable(long nativeHandle, boolean enable) {
            SpenPdfHelper.Native_setOverlayTextEnable(nativeHandle, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_verifyPassword(long nativeHandle, String filePath, String password) {
            return SpenPdfHelper.Native_verifyPassword(nativeHandle, filePath, password);
        }

        private Companion() {
        }
    }

    public SpenPdfHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.synchronizationLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Bitmap Native_capturePage(long j, String str, String str2, int i);

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
    public static final native ArrayList<SpenPdfBookmark> Native_getBookmarkObject(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String[] Native_getFontNameList(long j, int i);

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
    public static final native int Native_getPageCount(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Bitmap Native_getPageImage(long j, int i, float f);

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
    public static final native Bitmap Native_getSelectedImage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getSelectedText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_hasOwnerPermission(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasPassword(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasSelectedImage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasSelectedText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenPdfHelper spenPdfHelper);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isOverlayTextEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOCRData(long j, int i, SpenOcrData spenOcrData);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOCRTextEnable(long j, boolean z);

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
    public static final native int Native_verifyPassword(long j, String str, String str2);

    public static /* synthetic */ Bitmap getPageImage$default(SpenPdfHelper spenPdfHelper, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        return spenPdfHelper.getPageImage(i, f);
    }

    private final void onLoadPdfPage(int pdfPageIndex) {
        SpenPdfListener spenPdfListener = this.mListener;
        if (spenPdfListener != null) {
            spenPdfListener.onLoadPdfPage(pdfPageIndex);
        }
    }

    private final void onScreenPages(int[] pages) {
        SpenPdfListener spenPdfListener = this.mListener;
        if (spenPdfListener != null) {
            spenPdfListener.onScreenPages(ArraysKt.toList(pages));
        }
    }

    private final void onUnLoadPdfPage(int pdfPageIndex) {
        SpenPdfListener spenPdfListener = this.mListener;
        if (spenPdfListener != null) {
            spenPdfListener.onUnLoadPdfPage(pdfPageIndex);
        }
    }

    @Nullable
    public final Bitmap capturePage(@NotNull String filePath, @Nullable String password, int pageIndex) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_capturePage(j, filePath, password, pageIndex);
    }

    public final void clearAllOverlayImage() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_clearAllOverlayImage(j);
    }

    public final void clearAllOverlayText() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_clearAllOverlayText(j);
    }

    public final void clearSelection() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_clearSelection(j);
    }

    @Nullable
    public final ArrayList<SpenPdfBookmark> getBookmarkObject(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_getBookmarkObject(j, filePath, password);
        }
        Log.e(TAG, "Native handle is not initialized. Call getBookmarkObject failed.");
        return null;
    }

    @Nullable
    public final String[] getFontNameList(int pageIndex) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_getFontNameList(j, pageIndex);
        }
        Log.e(TAG, "Native handle is not initialized. getFontNameList");
        return null;
    }

    @Nullable
    public final Bitmap getGetSelectedImage() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_getSelectedImage(j);
        }
        Log.e(TAG, "Native handle is not initialized. Call selectedImage failed.");
        return null;
    }

    @Nullable
    public final Bitmap getOverlayImage(int pdfPageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getOverlayImage(j, pdfPageIndex);
    }

    @Nullable
    public final String[] getOverlayText(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getOverlayText(j, pageIndex);
    }

    public final int getOverlayTextLength(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getOverlayTextLength(j, pageIndex);
    }

    public final int getPageCount(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_getPageCount(j, filePath, password);
        }
        Log.e(TAG, "Native handle is not initialized. Call getPageCount failed.");
        return -1;
    }

    @Nullable
    public final Bitmap getPageImage(int pageIndex, float ratio) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageImage(j, pageIndex, ratio);
    }

    @Nullable
    public final ArrayList<SpenPdfParagraph> getPageRichTextList(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageRichTextList(j, pageIndex);
    }

    public final int getPageTextLength(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageTextLength(j, pageIndex);
    }

    @Nullable
    public final String[] getPageTextList(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageTextList(j, pageIndex);
    }

    @Nullable
    public final String getSelectedText() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_getSelectedText(j);
        }
        Log.e(TAG, "Native handle is not initialized. Call selectedText failed.");
        return null;
    }

    public final int hasOwnerPermission(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_hasOwnerPermission(j, filePath, password);
        }
        Log.e(TAG, "Native handle is not initialized. Call hasOwnerPermission failed.");
        return -1;
    }

    public final boolean hasPassword(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_hasPassword(j, filePath);
        }
        Log.e(TAG, "Native handle is not initialized. Call hasPassword failed.");
        return false;
    }

    public final boolean hasSelectedImage() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_hasSelectedImage(j);
        }
        Log.e(TAG, "Native handle is not initialized. Call hasSelectedImage failed.");
        return false;
    }

    public final boolean hasSelectedText() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_hasSelectedText(j);
        }
        Log.e(TAG, "Native handle is not initialized. Call hasSelectedText failed.");
        return false;
    }

    public final boolean isOverlayTextEnabled() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isOverlayTextEnabled(j);
    }

    public final void setListener(@Nullable SpenPdfListener listener) {
        this.mListener = listener;
    }

    public final void setNativeHandle(long nativeHandle) {
        synchronized (this.synchronizationLock) {
            this.mNativeHandle = nativeHandle;
            INSTANCE.Native_init(nativeHandle, this);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setOCRData(int pageIndex, @Nullable SpenOcrData data) {
        synchronized (this.synchronizationLock) {
            long j = this.mNativeHandle;
            if (j == 0) {
                Log.e(TAG, "Native handle is not initialized. Call setOCRData failed.");
            } else if (pageIndex < 0) {
                Log.e(TAG, "Invalid page index. Call setOCRData failed.");
            } else {
                INSTANCE.Native_setOCRData(j, pageIndex, data);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void setOCRTextEnable(boolean enable) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOCRTextEnable(j, enable);
    }

    public final boolean setOverlayImage(int pdfPageIndex, @NotNull Bitmap overlayImage) {
        Intrinsics.checkNotNullParameter(overlayImage, "overlayImage");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setOverlayImage(j, pdfPageIndex, overlayImage);
    }

    public final void setOverlayRichText(int pageIndex, @NotNull ArrayList<SpenPdfParagraph> pdfParagraphList, @Nullable String dstLanguageTag) {
        Intrinsics.checkNotNullParameter(pdfParagraphList, "pdfParagraphList");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayRichText(j, pageIndex, pdfParagraphList, dstLanguageTag);
    }

    public final void setOverlayText(int pageIndex, @NotNull String[] overlayTextList, @Nullable String dstLanguageTag) {
        Intrinsics.checkNotNullParameter(overlayTextList, "overlayTextList");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayText(j, pageIndex, overlayTextList, dstLanguageTag);
    }

    public final void setOverlayTextEnable(boolean enable) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayTextEnable(j, enable);
    }

    public final int verifyPassword(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_verifyPassword(j, filePath, password);
        }
        Log.e(TAG, "Native handle is not initialized. Call verifyPassword failed.");
        return -1;
    }
}
