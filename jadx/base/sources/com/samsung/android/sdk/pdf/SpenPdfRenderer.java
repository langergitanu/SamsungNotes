package com.samsung.android.sdk.pdf;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\"\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@DX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfRenderer;", "", "input", "Landroid/os/ParcelFileDescriptor;", "<init>", "(Landroid/os/ParcelFileDescriptor;)V", "getInput", "()Landroid/os/ParcelFileDescriptor;", "setInput", "nativeHandle", "", "getNativeHandle", "()J", "setNativeHandle", "(J)V", "pageCount", "", "getPageCount", "()I", "setPageCount", "(I)V", "initalize", "", "size", "close", "getPageWidth", "pageIndex", "getPageHeight", "renderPage", "bitmap", "Landroid/graphics/Bitmap;", "ignoreTag", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPdfRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Object sPdfiumLock = new Object();

    @NotNull
    private ParcelFileDescriptor input;
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0083 J\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0083 J\u0019\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nH\u0083 J#\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0083 J-\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0083 R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfRenderer$Companion;", "", "<init>", "()V", "sPdfiumLock", "getSPdfiumLock", "()Ljava/lang/Object;", "Native_init", "", "fd", "", "size", "Native_close", "", "nativeHandle", "Native_getPageCount", "Native_getPageWidth", "pageIndex", "Native_getPageHeight", "Native_renderPage", "bitmap", "Landroid/graphics/Bitmap;", "Native_renderPageExceptTag", "ignoreTag", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_close(long nativeHandle) {
            SpenPdfRenderer.Native_close(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long nativeHandle) {
            return SpenPdfRenderer.Native_getPageCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageHeight(long nativeHandle, int pageIndex) {
            return SpenPdfRenderer.Native_getPageHeight(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageWidth(long nativeHandle, int pageIndex) {
            return SpenPdfRenderer.Native_getPageWidth(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(int fd, long size) {
            return SpenPdfRenderer.Native_init(fd, size);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_renderPage(long nativeHandle, int pageIndex, Bitmap bitmap) {
            SpenPdfRenderer.Native_renderPage(nativeHandle, pageIndex, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_renderPageExceptTag(long nativeHandle, int pageIndex, String ignoreTag, Bitmap bitmap) {
            SpenPdfRenderer.Native_renderPageExceptTag(nativeHandle, pageIndex, ignoreTag, bitmap);
        }

        @NotNull
        public final Object getSPdfiumLock() {
            return SpenPdfRenderer.sPdfiumLock;
        }

        private Companion() {
        }
    }

    public SpenPdfRenderer(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            throw new NullPointerException("input cannot be null");
        }
        setPageCount(0);
        try {
            Os.lseek(parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
            long j = Os.fstat(parcelFileDescriptor.getFileDescriptor()).st_size;
            this.input = parcelFileDescriptor;
            synchronized (sPdfiumLock) {
                initalize(j);
                try {
                    setPageCount(INSTANCE.Native_getPageCount(this.nativeHandle));
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    INSTANCE.Native_close(this.nativeHandle);
                    this.nativeHandle = 0L;
                    throw th;
                }
            }
        } catch (ErrnoException unused) {
            throw new IllegalArgumentException("file descriptor not seekable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_close(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageHeight(long j, int i);

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
    public static final native void Native_renderPageExceptTag(long j, int i, String str, Bitmap bitmap);

    public void close() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_close(j);
        this.nativeHandle = 0L;
    }

    @NotNull
    public final ParcelFileDescriptor getInput() {
        return this.input;
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
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

    public final int getPageWidth(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageWidth(j, pageIndex);
    }

    public void initalize(long size) {
        this.nativeHandle = INSTANCE.Native_init(this.input.getFd(), size);
    }

    public final void renderPage(int pageIndex, @Nullable Bitmap bitmap) {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_renderPage(j, pageIndex, bitmap);
    }

    public final void setInput(@NotNull ParcelFileDescriptor parcelFileDescriptor) {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "<set-?>");
        this.input = parcelFileDescriptor;
    }

    public final void setNativeHandle(long j) {
        this.nativeHandle = j;
    }

    public final void setPageCount(int i) {
    }

    public final void renderPage(int pageIndex, @Nullable String ignoreTag, @Nullable Bitmap bitmap) {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_renderPageExceptTag(j, pageIndex, ignoreTag, bitmap);
    }
}
