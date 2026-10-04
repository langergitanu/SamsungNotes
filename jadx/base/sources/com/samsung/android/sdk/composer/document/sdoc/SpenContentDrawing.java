package com.samsung.android.sdk.composer.document.sdoc;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0082 J\u0019\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001eH\u0082 J\u001b\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0082 J\u0011\u0010%\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001eH\u0082 J#\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0082 J\u0019\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0082 J\u0011\u0010)\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001eH\u0082 R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentDrawing;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", "rect", "Landroid/graphics/RectF;", "objectRect", "getObjectRect", "()Landroid/graphics/RectF;", "setObjectRect", "(Landroid/graphics/RectF;)V", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "path", "", "attachedFile", "getAttachedFile", "()Ljava/lang/String;", "setAttachedFile", "(Ljava/lang/String;)V", "attachFile", "", "copy", "source", "throwUncheckedException", "errno", "", "ContentDrawing_init", "", "handle", "ContentDrawing_setObjectRect", "ContentDrawing_getObjectRect", "ContentDrawing_attachFile", "ContentDrawing_getAttachedFile", "ContentDrawing_copy", "sourceHandle", "ContentDrawing_setRatio", "ContentDrawing_getRatio", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentDrawing extends SpenContentBase {
    public SpenContentDrawing() {
        super(4);
    }

    private final native boolean ContentDrawing_attachFile(int handle, String path);

    private final native boolean ContentDrawing_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native String ContentDrawing_getAttachedFile(int handle);

    private final native RectF ContentDrawing_getObjectRect(int handle);

    private final native float ContentDrawing_getRatio(int handle);

    private final native boolean ContentDrawing_init(int handle);

    private final native boolean ContentDrawing_setObjectRect(int handle, RectF rect);

    private final native boolean ContentDrawing_setRatio(int handle, float ratio);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentDrawing(" + this + ") is already closed");
    }

    @Deprecated(message = "Please use [attachedFile] instead.")
    public final void attachFile(@Nullable String path) {
        if (ContentDrawing_attachFile(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 4) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentDrawing_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final String getAttachedFile() {
        return ContentDrawing_getAttachedFile(getMHandle());
    }

    @NotNull
    public final RectF getObjectRect() {
        return ContentDrawing_getObjectRect(getMHandle());
    }

    public final float getRatio() {
        return ContentDrawing_getRatio(getMHandle());
    }

    public final void setAttachedFile(@Nullable String str) {
        if (ContentDrawing_attachFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setObjectRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ContentDrawing_setObjectRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRatio(float f) {
        if (ContentDrawing_setRatio(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
