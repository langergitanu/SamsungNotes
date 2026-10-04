package com.samsung.android.sdk.pen.worddoc;

import android.graphics.RectF;
import androidx.annotation.ColorInt;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00107\u001a\u000208J\b\u00109\u001a\u000208H\u0004J\u0010\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0013\u0010<\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0011\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0011\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u001b\u0010A\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0082 J\u0011\u0010B\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010C\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH\u0082 J\u0011\u0010D\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010E\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 J\u0011\u0010F\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010G\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 J\u0011\u0010H\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010I\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0082 J\u0011\u0010J\u001a\u00020 2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0082 J\u0011\u0010M\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0011\u0010N\u001a\u00020 2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0011\u0010O\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u001b\u0010P\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0082 J\u0013\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010R\u001a\u0002082\u0006\u0010?\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0082 J\u0011\u0010S\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0082 J\u0019\u0010T\u001a\u0002082\u0006\u0010?\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0082 J\u0011\u0010U\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0082 R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010*R(\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R$\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010*R$\u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010*R\u0011\u00105\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b6\u0010\u000f¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "", "<init>", "()V", "value", "", "mHandle", "getMHandle", "()I", "type", "getType", "path", "", "attachedFile", "getAttachedFile", "()Ljava/lang/String;", "setAttachedFile", "(Ljava/lang/String;)V", "data", "customData", "getCustomData", "setCustomData", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "setRect", "(Landroid/graphics/RectF;)V", "collapseRect", "getCollapseRect", "setCollapseRect", "isVisible", "", "visible", "getVisible", "()Z", "setVisible", "(Z)V", "color", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "(I)V", "thumbnailPath", "getThumbnailPath", "setThumbnailPath", "version", DBSchema.DocumentExtra.FORMAT_VERSION, "getFormatVersion", "setFormatVersion", "minFormatVersion", "getMinFormatVersion", "setMinFormatVersion", "id", "getId", "detachFile", "", "finalize", "throwUncheckedException", "errno", "equals", "o", "CustomObject_finalize", "handle", "CustomObject_getType", "CustomObject_attachFile", "CustomObject_getAttachedFile", "CustomObject_setCustomData", "CustomObject_getCustomData", "CustomObject_setRect", "CustomObject_getRect", "CustomObject_setCollapseRect", "CustomObject_getCollapseRect", "CustomObject_setVisibility", "CustomObject_isVisible", "CustomObject_setBackgroundColor", "nativeHandle", "CustomObject_getBackgroundColor", "CustomObject_detachFile", "CustomObject_getId", "CustomObject_setThumbnailPath", "CustomObject_getThumbnailPath", "CustomObject_setFormatVersion", "CustomObject_getFormatVersion", "CustomObject_setMinFormatVersion", "CustomObject_getMinFormatVersion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenCustomObject {
    private int mHandle = -1;

    private final native boolean CustomObject_attachFile(int handle, String path);

    private final native boolean CustomObject_detachFile(int handle);

    private final native boolean CustomObject_finalize(int handle);

    private final native String CustomObject_getAttachedFile(int handle);

    private final native int CustomObject_getBackgroundColor(int handle);

    private final native RectF CustomObject_getCollapseRect(int handle);

    private final native String CustomObject_getCustomData(int handle);

    private final native int CustomObject_getFormatVersion(int handle);

    private final native String CustomObject_getId(int handle);

    private final native int CustomObject_getMinFormatVersion(int handle);

    private final native RectF CustomObject_getRect(int handle);

    private final native String CustomObject_getThumbnailPath(int handle);

    private final native int CustomObject_getType(int handle);

    private final native boolean CustomObject_isVisible(int handle);

    private final native boolean CustomObject_setBackgroundColor(int nativeHandle, int color);

    private final native boolean CustomObject_setCollapseRect(int handle, RectF rect);

    private final native boolean CustomObject_setCustomData(int handle, String data);

    private final native void CustomObject_setFormatVersion(int handle, int version);

    private final native void CustomObject_setMinFormatVersion(int handle, int version);

    private final native boolean CustomObject_setRect(int handle, RectF rect);

    private final native boolean CustomObject_setThumbnailPath(int handle, String path);

    private final native boolean CustomObject_setVisibility(int handle, boolean visible);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenCustomObject(" + this + ") is already closed");
    }

    public final void detachFile() {
        if (CustomObject_detachFile(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public boolean equals(@Nullable Object o) {
        return (o instanceof SpenCustomObject) && this.mHandle == ((SpenCustomObject) o).mHandle;
    }

    public final void finalize() {
        CustomObject_finalize(this.mHandle);
        this.mHandle = -1;
    }

    @Nullable
    public final String getAttachedFile() {
        return CustomObject_getAttachedFile(this.mHandle);
    }

    @ColorInt
    public int getBackgroundColor() {
        return CustomObject_getBackgroundColor(this.mHandle);
    }

    @NotNull
    public RectF getCollapseRect() {
        return CustomObject_getCollapseRect(this.mHandle);
    }

    @NotNull
    public final String getCustomData() {
        return CustomObject_getCustomData(this.mHandle);
    }

    public final int getFormatVersion() {
        return CustomObject_getFormatVersion(this.mHandle);
    }

    @NotNull
    public final String getId() {
        return CustomObject_getId(this.mHandle);
    }

    public final int getMHandle() {
        return this.mHandle;
    }

    public final int getMinFormatVersion() {
        return CustomObject_getMinFormatVersion(this.mHandle);
    }

    @NotNull
    public final RectF getRect() {
        return CustomObject_getRect(this.mHandle);
    }

    @Nullable
    public final String getThumbnailPath() {
        return CustomObject_getThumbnailPath(this.mHandle);
    }

    public final int getType() {
        return CustomObject_getType(this.mHandle);
    }

    public final boolean getVisible() {
        return CustomObject_isVisible(this.mHandle);
    }

    public final void setAttachedFile(@Nullable String str) {
        if (CustomObject_attachFile(this.mHandle, str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setBackgroundColor(int i) {
        if (CustomObject_setBackgroundColor(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setCollapseRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (CustomObject_setCollapseRect(this.mHandle, rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCustomData(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (CustomObject_setCustomData(this.mHandle, data)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFormatVersion(int i) {
        CustomObject_setFormatVersion(this.mHandle, i);
    }

    public final void setMinFormatVersion(int i) {
        CustomObject_setMinFormatVersion(this.mHandle, i);
    }

    public final void setRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (CustomObject_setRect(this.mHandle, rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (CustomObject_setThumbnailPath(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setVisible(boolean z) {
        if (CustomObject_setVisibility(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
