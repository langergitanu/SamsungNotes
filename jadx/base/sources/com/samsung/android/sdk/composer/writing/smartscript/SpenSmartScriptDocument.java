package com.samsung.android.sdk.composer.writing.smartscript;

import android.content.Context;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.recoguifeature.hwrgen.SpenHwrGenResourceExtractor;
import java.io.Closeable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J6\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"J.\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tJ\u0016\u0010&\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0019\u0010'\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001eH\u0086 J\u0011\u0010)\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0086 J\u0011\u0010*\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086 J\u0019\u0010+\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010,\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086 J\u0019\u0010-\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010.\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086 J\u0019\u0010/\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086 JA\u00100\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0086 J9\u00101\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0086 J!\u00102\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086 J!\u00103\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "Ljava/io/Closeable;", "nativeHandle", "", "context", "Landroid/content/Context;", "<init>", "(JLandroid/content/Context;)V", "value", "", "selectionStart", "getSelectionStart", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd", "setSelectionEnd", "cursorIndex", "getCursorIndex", "setCursorIndex", "isClosed", "", "close", "", "insertText", "x", "", "y", "text", "", "spanList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "Lkotlin/collections/ArrayList;", "removeText", "start", "end", "getCursorIndexAtPosition", "Native_init", "modelPath", "Native_finalize", "Native_getCursorIndex", "Native_setCursorIndex", "Native_getSelectionStart", "Native_setSelectionStart", "Native_getSelectionEnd", "Native_setSelectionEnd", "Native_insertTextToPoint", "Native_insertTextToIndex", "Native_removeText", "Native_getCursorIndexAtPosition", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSmartScriptDocument implements Closeable {

    @NotNull
    public static final String TAG = "SpenSmartScriptDocument";
    private long nativeHandle;

    public SpenSmartScriptDocument(long j, @NotNull Context context) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        this.nativeHandle = j;
        Native_init(this.nativeHandle, String.valueOf(SpenHwrGenResourceExtractor.INSTANCE.copyModelFilesFromAssets(context)));
    }

    public final native void Native_finalize(long nativeHandle);

    public final native int Native_getCursorIndex(long nativeHandle);

    public final native int Native_getCursorIndexAtPosition(long nativeHandle, float x, float y2);

    public final native int Native_getSelectionEnd(long nativeHandle);

    public final native int Native_getSelectionStart(long nativeHandle);

    public final native void Native_init(long nativeHandle, @NotNull String modelPath);

    public final native boolean Native_insertTextToIndex(long nativeHandle, int cursorIndex, @NotNull String text, @NotNull ArrayList<SpenTextSpanBase> spanList);

    public final native boolean Native_insertTextToPoint(long nativeHandle, float x, float y2, @NotNull String text, @NotNull ArrayList<SpenTextSpanBase> spanList);

    public final native boolean Native_removeText(long nativeHandle, int start, int end);

    public final native void Native_setCursorIndex(long nativeHandle, int value);

    public final native void Native_setSelectionEnd(long nativeHandle, int value);

    public final native void Native_setSelectionStart(long nativeHandle, int value);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isClosed()) {
            return;
        }
        Native_finalize(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    public final int getCursorIndex() {
        if (isClosed()) {
            return -1;
        }
        return Native_getCursorIndex(this.nativeHandle);
    }

    public final int getCursorIndexAtPosition(float x, float y2) {
        if (isClosed()) {
            return -1;
        }
        return Native_getCursorIndexAtPosition(this.nativeHandle, x, y2);
    }

    public final int getSelectionEnd() {
        if (isClosed()) {
            return -1;
        }
        return Native_getSelectionEnd(this.nativeHandle);
    }

    public final int getSelectionStart() {
        if (isClosed()) {
            return -1;
        }
        return Native_getSelectionStart(this.nativeHandle);
    }

    public final boolean insertText(float x, float y2, @NotNull String text, @NotNull ArrayList<SpenTextSpanBase> spanList) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanList, "spanList");
        if (isClosed()) {
            return false;
        }
        return Native_insertTextToPoint(this.nativeHandle, x, y2, text, spanList);
    }

    public final boolean isClosed() {
        return this.nativeHandle == 0;
    }

    public final boolean removeText(int start, int end) {
        if (isClosed()) {
            return false;
        }
        return Native_removeText(this.nativeHandle, start, end);
    }

    public final void setCursorIndex(int i) {
        if (isClosed()) {
            return;
        }
        Native_setCursorIndex(this.nativeHandle, i);
    }

    public final void setSelectionEnd(int i) {
        if (isClosed()) {
            return;
        }
        Native_setSelectionEnd(this.nativeHandle, i);
    }

    public final void setSelectionStart(int i) {
        if (isClosed()) {
            return;
        }
        Native_setSelectionStart(this.nativeHandle, i);
    }

    public final boolean insertText(int cursorIndex, @NotNull String text, @NotNull ArrayList<SpenTextSpanBase> spanList) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanList, "spanList");
        if (isClosed()) {
            return false;
        }
        return Native_insertTextToIndex(this.nativeHandle, cursorIndex, text, spanList);
    }
}
