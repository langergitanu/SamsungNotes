package com.samsung.android.sdk.pdf.debug;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\tJ+\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J!\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001b\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0010J\u000e\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010'\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/debug/SpenPdfDebugRenderer;", "", "input", "Landroid/os/ParcelFileDescriptor;", "<init>", "(Landroid/os/ParcelFileDescriptor;)V", "nativeHandle", "", "initialize", "", "size", "close", "getPageTextPositionList", "", "Landroid/graphics/RectF;", "pageIndex", "", "enableAnalayzer", "", "isSplitTextObject", "(IZZ)[Landroid/graphics/RectF;", "getPageParagraphPositionList", "(I)[Landroid/graphics/RectF;", "getPageLinePositionList", "getPageMaxWidthParagraphPositionList", "getPageMaxHeightParagraphPositionList", "getPageParagraphExcludingList", "(I)[[Landroid/graphics/RectF;", "setAnalyzerConfig", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sdk/pdf/debug/SpenPdfDebugRenderer$AnalayzerConfig;", "getAnalyzerConfig", "", "getInferenceList", "Lcom/samsung/android/sdk/pdf/debug/SpenPdfInferenceResult;", "(I)[Lcom/samsung/android/sdk/pdf/debug/SpenPdfInferenceResult;", "getPageCount", "getPageWidth", "getPageHeight", "renderPage", "bitmap", "Landroid/graphics/Bitmap;", "AnalayzerConfig", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfDebugRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private ParcelFileDescriptor input;
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/debug/SpenPdfDebugRenderer$AnalayzerConfig;", "", "<init>", "()V", "relDevP", "", "getRelDevP", "()F", "setRelDevP", "(F)V", "relDevL", "getRelDevL", "setRelDevL", "isSplitTextObject", "", "()Z", "setSplitTextObject", "(Z)V", "isAIModel", "setAIModel", "isProcList", "setProcList", "isSplitToC", "setSplitToC", "isPostToC", "setPostToC", "isPostParagraph", "setPostParagraph", "isSplitPeriod", "setSplitPeriod", "isSplitContent", "setSplitContent", "isSplitPath", "setSplitPath", "isSplitHeaders", "setSplitHeaders", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AnalayzerConfig {
        private boolean isAIModel;
        private boolean isPostParagraph;
        private boolean isPostToC;
        private boolean isProcList;
        private boolean isSplitContent;
        private boolean isSplitHeaders;
        private boolean isSplitPath;
        private boolean isSplitPeriod;
        private boolean isSplitToC;
        private float relDevP = 0.075f;
        private float relDevL = 0.075f;
        private boolean isSplitTextObject = true;

        @NotNull
        private String filePath = "";

        @NotNull
        public final String getFilePath() {
            return this.filePath;
        }

        public final float getRelDevL() {
            return this.relDevL;
        }

        public final float getRelDevP() {
            return this.relDevP;
        }

        /* JADX INFO: renamed from: isAIModel, reason: from getter */
        public final boolean getIsAIModel() {
            return this.isAIModel;
        }

        /* JADX INFO: renamed from: isPostParagraph, reason: from getter */
        public final boolean getIsPostParagraph() {
            return this.isPostParagraph;
        }

        /* JADX INFO: renamed from: isPostToC, reason: from getter */
        public final boolean getIsPostToC() {
            return this.isPostToC;
        }

        /* JADX INFO: renamed from: isProcList, reason: from getter */
        public final boolean getIsProcList() {
            return this.isProcList;
        }

        /* JADX INFO: renamed from: isSplitContent, reason: from getter */
        public final boolean getIsSplitContent() {
            return this.isSplitContent;
        }

        /* JADX INFO: renamed from: isSplitHeaders, reason: from getter */
        public final boolean getIsSplitHeaders() {
            return this.isSplitHeaders;
        }

        /* JADX INFO: renamed from: isSplitPath, reason: from getter */
        public final boolean getIsSplitPath() {
            return this.isSplitPath;
        }

        /* JADX INFO: renamed from: isSplitPeriod, reason: from getter */
        public final boolean getIsSplitPeriod() {
            return this.isSplitPeriod;
        }

        /* JADX INFO: renamed from: isSplitTextObject, reason: from getter */
        public final boolean getIsSplitTextObject() {
            return this.isSplitTextObject;
        }

        /* JADX INFO: renamed from: isSplitToC, reason: from getter */
        public final boolean getIsSplitToC() {
            return this.isSplitToC;
        }

        public final void setAIModel(boolean z) {
            this.isAIModel = z;
        }

        public final void setFilePath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.filePath = str;
        }

        public final void setPostParagraph(boolean z) {
            this.isPostParagraph = z;
        }

        public final void setPostToC(boolean z) {
            this.isPostToC = z;
        }

        public final void setProcList(boolean z) {
            this.isProcList = z;
        }

        public final void setRelDevL(float f) {
            this.relDevL = f;
        }

        public final void setRelDevP(float f) {
            this.relDevP = f;
        }

        public final void setSplitContent(boolean z) {
            this.isSplitContent = z;
        }

        public final void setSplitHeaders(boolean z) {
            this.isSplitHeaders = z;
        }

        public final void setSplitPath(boolean z) {
            this.isSplitPath = z;
        }

        public final void setSplitPeriod(boolean z) {
            this.isSplitPeriod = z;
        }

        public final void setSplitTextObject(boolean z) {
            this.isSplitTextObject = z;
        }

        public final void setSplitToC(boolean z) {
            this.isSplitToC = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0083 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0083 J1\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0083 J!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J'\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J{\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010&H\u0083 J\u0013\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u000b\u001a\u00020\u0005H\u0083 J!\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J\u0011\u0010+\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0083 J\u0019\u0010,\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J\u0019\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J#\u0010.\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0083 ¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/debug/SpenPdfDebugRenderer$Companion;", "", "<init>", "()V", "Native_init", "", "fd", "", "size", "Native_close", "", "nativeHandle", "Native_getPageTextPositionList", "", "Landroid/graphics/RectF;", "pageIndex", "enableAnalayzer", "", "isSplitTextObject", "Native_getPageParagraphPositionList", "Native_getPageLinePositionList", "Native_getPageMaxWidthParagraphPositionList", "Native_getPageMaxHeightParagraphPositionList", "Native_getPageParagraphExcludingList", "Native_setAnalyzerConfig", "relDevP", "", "relDevL", "isAIModel", "isProcList", "isSplitToC", "isPostToC", "isPostParagraph", "isSplitPeriod", "isSplitContent", "isSplitPath", "isSplitHeaders", "modelPath", "", "Native_getAnalyzerConfig", "", "Native_getInferenceList", "Lcom/samsung/android/sdk/pdf/debug/SpenPdfInferenceResult;", "Native_getPageCount", "Native_getPageWidth", "Native_getPageHeight", "Native_renderPage", "bitmap", "Landroid/graphics/Bitmap;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_close(long nativeHandle) {
            SpenPdfDebugRenderer.Native_close(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean[] Native_getAnalyzerConfig(long nativeHandle) {
            return SpenPdfDebugRenderer.Native_getAnalyzerConfig(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenPdfInferenceResult[] Native_getInferenceList(long j, int i) {
            return SpenPdfDebugRenderer.Native_getInferenceList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long nativeHandle) {
            return SpenPdfDebugRenderer.Native_getPageCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageHeight(long nativeHandle, int pageIndex) {
            return SpenPdfDebugRenderer.Native_getPageHeight(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF[] Native_getPageLinePositionList(long j, int i) {
            return SpenPdfDebugRenderer.Native_getPageLinePositionList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF[] Native_getPageMaxHeightParagraphPositionList(long j, int i) {
            return SpenPdfDebugRenderer.Native_getPageMaxHeightParagraphPositionList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF[] Native_getPageMaxWidthParagraphPositionList(long j, int i) {
            return SpenPdfDebugRenderer.Native_getPageMaxWidthParagraphPositionList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF[][] Native_getPageParagraphExcludingList(long j, int i) {
            return SpenPdfDebugRenderer.Native_getPageParagraphExcludingList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF[] Native_getPageParagraphPositionList(long j, int i) {
            return SpenPdfDebugRenderer.Native_getPageParagraphPositionList(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF[] Native_getPageTextPositionList(long j, int i, boolean z, boolean z2) {
            return SpenPdfDebugRenderer.Native_getPageTextPositionList(j, i, z, z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageWidth(long nativeHandle, int pageIndex) {
            return SpenPdfDebugRenderer.Native_getPageWidth(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(int fd, long size) {
            return SpenPdfDebugRenderer.Native_init(fd, size);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_renderPage(long nativeHandle, int pageIndex, Bitmap bitmap) {
            SpenPdfDebugRenderer.Native_renderPage(nativeHandle, pageIndex, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAnalyzerConfig(long nativeHandle, float relDevP, float relDevL, boolean isSplitTextObject, boolean isAIModel, boolean isProcList, boolean isSplitToC, boolean isPostToC, boolean isPostParagraph, boolean isSplitPeriod, boolean isSplitContent, boolean isSplitPath, boolean isSplitHeaders, String modelPath) {
            SpenPdfDebugRenderer.Native_setAnalyzerConfig(nativeHandle, relDevP, relDevL, isSplitTextObject, isAIModel, isProcList, isSplitToC, isPostToC, isPostParagraph, isSplitPeriod, isSplitContent, isSplitPath, isSplitHeaders, modelPath);
        }

        private Companion() {
        }
    }

    public SpenPdfDebugRenderer(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            throw new NullPointerException("input cannot be null");
        }
        try {
            Os.lseek(parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
            long j = Os.fstat(parcelFileDescriptor.getFileDescriptor()).st_size;
            this.input = parcelFileDescriptor;
            initialize(j);
        } catch (ErrnoException unused) {
            throw new IllegalArgumentException("file descriptor not seekable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_close(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean[] Native_getAnalyzerConfig(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenPdfInferenceResult[] Native_getInferenceList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageHeight(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF[] Native_getPageLinePositionList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF[] Native_getPageMaxHeightParagraphPositionList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF[] Native_getPageMaxWidthParagraphPositionList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF[][] Native_getPageParagraphExcludingList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF[] Native_getPageParagraphPositionList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF[] Native_getPageTextPositionList(long j, int i, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageWidth(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_renderPage(long j, int i, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAnalyzerConfig(long j, float f, float f4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str);

    private final void initialize(long size) {
        this.nativeHandle = INSTANCE.Native_init(this.input.getFd(), size);
    }

    public final void close() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_close(j);
        this.nativeHandle = 0L;
    }

    @Nullable
    public final boolean[] getAnalyzerConfig() {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getAnalyzerConfig(j);
    }

    @Nullable
    public final SpenPdfInferenceResult[] getInferenceList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getInferenceList(j, pageIndex);
    }

    public final int getPageCount() {
        long j = this.nativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageCount(j);
    }

    public final int getPageHeight(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageHeight(j, pageIndex);
    }

    @Nullable
    public final RectF[] getPageLinePositionList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageLinePositionList(j, pageIndex);
    }

    @Nullable
    public final RectF[] getPageMaxHeightParagraphPositionList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageMaxHeightParagraphPositionList(j, pageIndex);
    }

    @Nullable
    public final RectF[] getPageMaxWidthParagraphPositionList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageMaxWidthParagraphPositionList(j, pageIndex);
    }

    @Nullable
    public final RectF[][] getPageParagraphExcludingList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageParagraphExcludingList(j, pageIndex);
    }

    @Nullable
    public final RectF[] getPageParagraphPositionList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageParagraphPositionList(j, pageIndex);
    }

    @Nullable
    public final RectF[] getPageTextPositionList(int pageIndex, boolean enableAnalayzer, boolean isSplitTextObject) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageTextPositionList(j, pageIndex, enableAnalayzer, isSplitTextObject);
    }

    public final int getPageWidth(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageWidth(j, pageIndex);
    }

    public final void renderPage(int pageIndex, @Nullable Bitmap bitmap) {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_renderPage(j, pageIndex, bitmap);
    }

    public final void setAnalyzerConfig(@Nullable AnalayzerConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setAnalyzerConfig(j, config.getRelDevP(), config.getRelDevL(), config.getIsSplitTextObject(), config.getIsAIModel(), config.getIsProcList(), config.getIsSplitToC(), config.getIsPostToC(), config.getIsPostParagraph(), config.getIsSplitPeriod(), config.getIsSplitContent(), config.getIsSplitPath(), config.getIsSplitHeaders(), config.getFilePath());
    }
}
