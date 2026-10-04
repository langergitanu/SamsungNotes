package com.samsung.android.sdk.composer.document.sdoc;

import android.content.Context;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenPdfDoc;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020&2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010'\u001a\u00020&2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010+\u001a\u00020&J\u000e\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020\u0016J\u0012\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0016J \u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016J\u0006\u00105\u001a\u00020&J\u0006\u00106\u001a\u00020&J\u0006\u00107\u001a\u00020&J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u0016H\u0002J\u0011\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u0019\u0010<\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010=\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u001b\u0010>\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0082 J\u0011\u0010?\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u001b\u0010@\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0082 J\u0011\u0010A\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0016H\u0082 J#\u0010B\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0082 J-\u0010D\u001a\u0004\u0018\u00010\u001d2\u0006\u0010;\u001a\u00020\u00162\b\u0010E\u001a\u0004\u0018\u00010\f2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0082 J\u0011\u0010F\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u0011\u0010G\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u0019\u0010H\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0011\u0010I\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u0019\u0010J\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0082 J\u0019\u0010K\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0082 J\u0011\u0010L\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0016H\u0082 J%\u0010M\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\"2\u0006\u0010;\u001a\u00020\u0016H\u0082 J\u0019\u0010N\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0082 J\u0019\u0010O\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010P\u001a\u00020-H\u0082 J\u0011\u0010Q\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0016H\u0082 R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR%\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentPdf;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", "rect", "Landroid/graphics/RectF;", "objectRect", "getObjectRect", "()Landroid/graphics/RectF;", "setObjectRect", "(Landroid/graphics/RectF;)V", "path", "", "attachedPdfFile", "getAttachedPdfFile", "()Ljava/lang/String;", "setAttachedPdfFile", "(Ljava/lang/String;)V", "attachedSpdFile", "getAttachedSpdFile", "setAttachedSpdFile", "count", "", "pdfPageCount", "getPdfPageCount", "()I", "setPdfPageCount", "(I)V", "pdfDoc", "Lcom/samsung/android/sdk/pen/document/SpenPdfDoc;", "getPdfDoc", "()Lcom/samsung/android/sdk/pen/document/SpenPdfDoc;", "bookmarkList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBookmarkList", "()Ljava/util/ArrayList;", "attachPdfFile", "", "attachSpdFile", "addBookmark", "index", "removeBookmark", "removeAllBookmark", "hasBookmark", "", "copy", "source", "createPdfDoc", "context", "Landroid/content/Context;", "width", "height", "deletePdfDoc", "closePdfDoc", "discardPdfDoc", "throwUncheckedException", "errno", "ContentPdf_init", "handle", "ContentPdf_setObjectRect", "ContentPdf_getObjectRect", "ContentPdf_attachPdfFile", "ContentPdf_getAttachedPdfFile", "ContentPdf_attachSpdFile", "ContentPdf_getAttachedSpdFile", "ContentPdf_copy", "sourceHandle", "ContentPdf_createPdfDoc", "appDir", "ContentPdf_getPdfDoc", "ContentPdf_deletePdfDoc", "ContentPdf_setPdfPageCount", "ContentPdf_getPdfPageCount", "ContentPdf_addBookmark", "ContentPdf_removeBookmark", "ContentPdf_removeAllBookmark", "ContentPdf_getBookmarkList", "ContentPdf_hasBookmark", "ContentPdf_closePdfDoc", "clearCache", "ContentPdf_discardPdfDoc", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentPdf extends SpenContentBase {
    public SpenContentPdf() {
        super(8);
        if (ContentPdf_init(getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    private final native boolean ContentPdf_addBookmark(int handle, int index);

    private final native boolean ContentPdf_attachPdfFile(int handle, String path);

    private final native boolean ContentPdf_attachSpdFile(int handle, String path);

    private final native boolean ContentPdf_closePdfDoc(int handle, boolean clearCache);

    private final native boolean ContentPdf_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native SpenPdfDoc ContentPdf_createPdfDoc(int handle, String appDir, int width, int height);

    private final native boolean ContentPdf_deletePdfDoc(int handle);

    private final native boolean ContentPdf_discardPdfDoc(int handle);

    private final native String ContentPdf_getAttachedPdfFile(int handle);

    private final native String ContentPdf_getAttachedSpdFile(int handle);

    private final native ArrayList<Integer> ContentPdf_getBookmarkList(int handle);

    private final native RectF ContentPdf_getObjectRect(int handle);

    private final native SpenPdfDoc ContentPdf_getPdfDoc(int handle);

    private final native int ContentPdf_getPdfPageCount(int handle);

    private final native boolean ContentPdf_hasBookmark(int handle, int index);

    private final native boolean ContentPdf_init(int handle);

    private final native boolean ContentPdf_removeAllBookmark(int handle);

    private final native boolean ContentPdf_removeBookmark(int handle, int index);

    private final native boolean ContentPdf_setObjectRect(int handle, RectF rect);

    private final native boolean ContentPdf_setPdfPageCount(int handle, int count);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentPdf(" + this + ") is already closed");
    }

    public final void addBookmark(int index) {
        if (ContentPdf_addBookmark(getMHandle(), index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "Please use [.attachedPdfFile] instead.")
    public final void attachPdfFile(@Nullable String path) {
        if (ContentPdf_attachPdfFile(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "Please use [.attachedSpdFile] instead.")
    public final void attachSpdFile(@Nullable String path) {
        if (ContentPdf_attachSpdFile(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void closePdfDoc() throws IOException {
        if (ContentPdf_closePdfDoc(getMHandle(), false)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 11) {
            throw new IOException();
        }
        if (error != 19) {
            SpenError.ThrowUncheckedException(SpenError.getError());
            return;
        }
        throw new SpenAlreadyClosedException("PdfDoc(" + this + ") is already closed.");
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 8) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentPdf_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SpenPdfDoc createPdfDoc(@NotNull Context context, int width, int height) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenPdfDoc spenPdfDocContentPdf_createPdfDoc = ContentPdf_createPdfDoc(getMHandle(), context.getFilesDir().getAbsolutePath(), width, height);
        if (spenPdfDocContentPdf_createPdfDoc == null) {
            int error = SpenError.getError();
            if (error == 5) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            } else {
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 19) {
                    throw new SpenAlreadyClosedException("SpenPdfDoc(" + this + ") is already closed.");
                }
                if (error == 7 || error == 8) {
                }
            }
        }
        return spenPdfDocContentPdf_createPdfDoc;
    }

    public final void deletePdfDoc() {
        if (ContentPdf_deletePdfDoc(getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void discardPdfDoc() throws IOException {
        if (ContentPdf_discardPdfDoc(getMHandle())) {
            return;
        }
        int error = SpenError.getError();
        if (error == 11) {
            throw new IOException();
        }
        if (error != 19) {
            SpenError.ThrowUncheckedException(SpenError.getError());
            return;
        }
        throw new SpenAlreadyClosedException("PdfDoc(" + this + ") is already closed.");
    }

    @Nullable
    public final String getAttachedPdfFile() {
        return ContentPdf_getAttachedPdfFile(getMHandle());
    }

    @Nullable
    public final String getAttachedSpdFile() {
        return ContentPdf_getAttachedSpdFile(getMHandle());
    }

    @Nullable
    public final ArrayList<Integer> getBookmarkList() {
        return ContentPdf_getBookmarkList(getMHandle());
    }

    @NotNull
    public final RectF getObjectRect() {
        return ContentPdf_getObjectRect(getMHandle());
    }

    @Nullable
    public final SpenPdfDoc getPdfDoc() {
        return ContentPdf_getPdfDoc(getMHandle());
    }

    public final int getPdfPageCount() {
        return ContentPdf_getPdfPageCount(getMHandle());
    }

    public final boolean hasBookmark(int index) {
        return ContentPdf_hasBookmark(getMHandle(), index);
    }

    public final void removeAllBookmark() {
        if (ContentPdf_removeAllBookmark(getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeBookmark(int index) {
        if (ContentPdf_removeBookmark(getMHandle(), index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAttachedPdfFile(@Nullable String str) {
        if (ContentPdf_attachPdfFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAttachedSpdFile(@Nullable String str) {
        if (ContentPdf_attachSpdFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setObjectRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ContentPdf_setObjectRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPdfPageCount(int i) {
        if (ContentPdf_setPdfPageCount(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
