package com.samsung.android.sdk.pen.document;

import android.content.Context;
import com.samsung.android.sdk.pen.SpenError;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 :2\u00020\u0001:\u0001:B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0007H\u0002J\t\u0010%\u001a\u00020\u0019H\u0082 J!\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J)\u0010(\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0082 J\u0011\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0007H\u0082 J\u0011\u0010-\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0007H\u0082 J\t\u0010.\u001a\u00020\u0016H\u0082 J\u0011\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0082 J\u0013\u00101\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0082 J\t\u00102\u001a\u00020\u0007H\u0082 J\t\u00103\u001a\u00020\u0007H\u0082 J\t\u00104\u001a\u00020\u0007H\u0082 J\t\u00105\u001a\u00020\u0016H\u0082 J\u001b\u00106\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u0011\u00107\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0007H\u0082 J\t\u00108\u001a\u00020\u0016H\u0082 J\t\u00109\u001a\u00020\u0007H\u0082 R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPdfDoc;", "", "<init>", "()V", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "filePath", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "mContext", "mHandle", "", "getWidth", "()I", "getHeight", "lastEditedPageIndex", "getLastEditedPageIndex", "isChanged", "", "()Z", ClientCookie.DISCARD_ATTR, "", "close", "save", "getBlankPage", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "bindBlankPage", "pdfPageIndex", "removeBlankPage", "getPage", "removePage", "throwUncheckedException", "errno", "PdfDoc_finalize", "PdfDoc_construct1", "cacheDirPath", "PdfDoc_construct2", "filepath", "mode", "PdfDoc_getPage", "pageIndex", "PdfDoc_removePage", "PdfDoc_discard", "PdfDoc_close", "clearCache", "PdfDoc_save", "PdfDoc_getWidth", "PdfDoc_getHeight", "PdfDoc_getRotation", "PdfDoc_isChanged", "PdfDoc_getBlankPage", "PdfDoc_bindBlankPage", "PdfDoc_removeBlankPage", "PdfDoc_getLastEditedPageIndex", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfDoc {
    private static final int MODE_READ_ONLY = 0;
    private static final int MODE_WRITABLE = 1;

    @NotNull
    private static final String TAG = "SpenPdfDoc";

    @Nullable
    private Context mContext;
    private long mHandle;

    private SpenPdfDoc() {
    }

    private final native boolean PdfDoc_bindBlankPage(int pdfPageIndex);

    private final native boolean PdfDoc_close(boolean clearCache);

    private final native boolean PdfDoc_construct1(String cacheDirPath, int width, int height);

    private final native boolean PdfDoc_construct2(String cacheDirPath, String filepath, int width, int mode);

    private final native boolean PdfDoc_discard();

    private final native void PdfDoc_finalize();

    private final native SpenPageDoc PdfDoc_getBlankPage(int width, int height);

    private final native int PdfDoc_getHeight();

    private final native int PdfDoc_getLastEditedPageIndex();

    private final native SpenPageDoc PdfDoc_getPage(int pageIndex);

    private final native int PdfDoc_getRotation();

    private final native int PdfDoc_getWidth();

    private final native boolean PdfDoc_isChanged();

    private final native boolean PdfDoc_removeBlankPage();

    private final native boolean PdfDoc_removePage(int pageIndex);

    private final native boolean PdfDoc_save(String filePath);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenPdfDoc(" + this + ") is already closed");
    }

    public final void bindBlankPage(int pdfPageIndex) {
        if (PdfDoc_bindBlankPage(pdfPageIndex)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void close() throws IOException {
        if (this.mHandle == -1) {
            return;
        }
        if (!PdfDoc_close(false)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1L;
        this.mContext = null;
    }

    public final void discard() throws IOException {
        if (this.mHandle == -1) {
            return;
        }
        if (!PdfDoc_discard()) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1L;
        this.mContext = null;
    }

    @Nullable
    public final SpenPageDoc getBlankPage(int width, int height) {
        SpenPageDoc spenPageDocPdfDoc_getBlankPage = PdfDoc_getBlankPage(width, height);
        if (spenPageDocPdfDoc_getBlankPage == null) {
            throwUncheckedException(SpenError.getError());
        }
        return spenPageDocPdfDoc_getBlankPage;
    }

    public final int getHeight() {
        return PdfDoc_getHeight();
    }

    public final int getLastEditedPageIndex() {
        return PdfDoc_getLastEditedPageIndex();
    }

    @NotNull
    public final SpenPageDoc getPage(int pdfPageIndex) {
        return PdfDoc_getPage(pdfPageIndex);
    }

    public final int getWidth() {
        return PdfDoc_getWidth();
    }

    public final boolean isChanged() {
        return PdfDoc_isChanged();
    }

    public final void removeBlankPage() {
        if (PdfDoc_removeBlankPage()) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removePage(int pdfPageIndex) {
        if (PdfDoc_removePage(pdfPageIndex)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void save(@Nullable String filePath) throws IOException {
        if (PdfDoc_save(filePath)) {
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
        throw new SpenAlreadyClosedException("SpenPdfDoc(" + this + ") is already closed.");
    }

    public SpenPdfDoc(@NotNull Context context, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        if (PdfDoc_construct1(absolutePath, i, i2)) {
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
        throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
    }

    public SpenPdfDoc(@NotNull Context context, @NotNull String filePath, int i) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mContext = context;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        if (PdfDoc_construct2(absolutePath, filePath, i, 1)) {
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
        throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
    }
}
