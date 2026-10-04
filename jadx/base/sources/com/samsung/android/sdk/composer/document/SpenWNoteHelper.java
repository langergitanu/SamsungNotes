package com.samsung.android.sdk.composer.document;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aJ\"\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`#2\u0006\u0010$\u001a\u00020\u001eR\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "", "<init>", "()V", "isAutoUpdateBySelf", "", "(Z)V", "value", "", "nativeHandle", "getNativeHandle", "()J", "close", "", "setDocument", "wnote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getPageIndex", "", "wpage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getPageIndexById", "pageId", "", "getPageIndexByXY", "x", "", "y", "findClosestPageIndexByXY", "contentRectInView", "Landroid/graphics/RectF;", "getPageIndexClosedByX", "getPageIndexClosedByY", "getPageIndexListByRect", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rect", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWNoteHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0083 J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 J\u0019\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 J!\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0083 J)\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0083 J\u0019\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0083 J\u0019\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0083 J-\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0083 ¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper$Companion;", "", "<init>", "()V", "Native_init", "", "isAutoUpdateBySelf", "", "Native_finalize", "", "handle", "Native_setDocument", "nativeWNote", "Native_getPageIndex", "", "wpage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "Native_getPageIndexById", "pageId", "", "Native_getPageIndexByXY", "x", "", "y", "Native_findClosestPageIndexByXY", "rect", "Landroid/graphics/RectF;", "Native_getPageIndexClosedByX", "Native_getPageIndexClosedByY", "Native_getPageIndexListByRect", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenWNoteHelper.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_findClosestPageIndexByXY(long handle, float x, float y2, RectF rect) {
            return SpenWNoteHelper.Native_findClosestPageIndexByXY(handle, x, y2, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndex(long handle, SpenWPage wpage) {
            return SpenWNoteHelper.Native_getPageIndex(handle, wpage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndexById(long handle, String pageId) {
            return SpenWNoteHelper.Native_getPageIndexById(handle, pageId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndexByXY(long handle, float x, float y2) {
            return SpenWNoteHelper.Native_getPageIndexByXY(handle, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndexClosedByX(long handle, float x) {
            return SpenWNoteHelper.Native_getPageIndexClosedByX(handle, x);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndexClosedByY(long handle, float y2) {
            return SpenWNoteHelper.Native_getPageIndexClosedByY(handle, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<Integer> Native_getPageIndexListByRect(long handle, RectF rect) {
            return SpenWNoteHelper.Native_getPageIndexListByRect(handle, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(boolean isAutoUpdateBySelf) {
            return SpenWNoteHelper.Native_init(isAutoUpdateBySelf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDocument(long handle, long nativeWNote) {
            SpenWNoteHelper.Native_setDocument(handle, nativeWNote);
        }

        private Companion() {
        }
    }

    public SpenWNoteHelper() {
        this.nativeHandle = INSTANCE.Native_init(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_findClosestPageIndexByXY(long j, float f, float f4, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndex(long j, SpenWPage spenWPage);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndexById(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndexByXY(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndexClosedByX(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndexClosedByY(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<Integer> Native_getPageIndexListByRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDocument(long j, long j2);

    public final void close() {
        INSTANCE.Native_finalize(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    public final int findClosestPageIndexByXY(float x, float y2, @NotNull RectF contentRectInView) {
        Intrinsics.checkNotNullParameter(contentRectInView, "contentRectInView");
        return INSTANCE.Native_findClosestPageIndexByXY(this.nativeHandle, x, y2, contentRectInView);
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    public final int getPageIndex(@NotNull SpenWPage wpage) {
        Intrinsics.checkNotNullParameter(wpage, "wpage");
        return INSTANCE.Native_getPageIndex(this.nativeHandle, wpage);
    }

    public final int getPageIndexById(@NotNull String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        return INSTANCE.Native_getPageIndexById(this.nativeHandle, pageId);
    }

    public final int getPageIndexByXY(float x, float y2) {
        return INSTANCE.Native_getPageIndexByXY(this.nativeHandle, x, y2);
    }

    public final int getPageIndexClosedByX(float x) {
        return INSTANCE.Native_getPageIndexClosedByX(this.nativeHandle, x);
    }

    public final int getPageIndexClosedByY(float y2) {
        return INSTANCE.Native_getPageIndexClosedByY(this.nativeHandle, y2);
    }

    @Nullable
    public final ArrayList<Integer> getPageIndexListByRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return INSTANCE.Native_getPageIndexListByRect(this.nativeHandle, rect);
    }

    public final void setDocument(@Nullable SpenWNote wnote) {
        INSTANCE.Native_setDocument(this.nativeHandle, wnote != null ? wnote.getMHandle() : 0L);
    }

    public SpenWNoteHelper(boolean z) {
        this.nativeHandle = INSTANCE.Native_init(z);
    }
}
