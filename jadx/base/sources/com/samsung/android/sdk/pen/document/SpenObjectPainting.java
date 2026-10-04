package com.samsung.android.sdk.pen.document;

import android.graphics.Rect;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.base.SpenRectD;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0017J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u001bH\u0002J\u0019\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001b\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u00101\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u001bH\u0082 J\u001b\u00102\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u00103\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u001bH\u0082 J\u0019\u00104\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082 J\u0011\u00105\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001bH\u0082 J\u0019\u00106\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082 J\u0011\u00107\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001bH\u0082 J\u001b\u00108\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0082 J\u0011\u00109\u001a\u00020!2\u0006\u0010/\u001a\u00020\u001bH\u0082 J\u001b\u0010:\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0082 J\u0011\u0010;\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001bH\u0082 R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectPainting;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "path", "", "attachedFile", "getAttachedFile", "()Ljava/lang/String;", "setAttachedFile", "(Ljava/lang/String;)V", "attachFile", "", "filePath", "thumbnailPath", "getThumbnailPath", "setThumbnailPath", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "state", "", "getState", "()I", "setState", "(I)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "originalRect", "Lcom/samsung/android/sdk/pen/base/SpenRectD;", "getOriginalRect", "()Lcom/samsung/android/sdk/pen/base/SpenRectD;", "setOriginalRect", "(Lcom/samsung/android/sdk/pen/base/SpenRectD;)V", "throwUncheckedException", "errno", "ObjectPainting_init", "handle", "ObjectPainting_attachFile", "ObjectPainting_getAttachedFile", "ObjectPainting_setThumbnailPath", "ObjectPainting_getThumbnailPath", "ObjectPainting_setRatio", "ObjectPainting_getRatio", "ObjectPainting_setState", "ObjectPainting_getState", "ObjectPainting_setCropRect", "ObjectPainting_getCropRect", "ObjectPainting_setOriginalRect", "ObjectPainting_getOriginalRect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectPainting extends SpenObjectBase {
    public SpenObjectPainting() {
        super(14);
    }

    private final native boolean ObjectPainting_attachFile(int handle, String path);

    private final native String ObjectPainting_getAttachedFile(int handle);

    private final native Rect ObjectPainting_getCropRect(int handle);

    private final native SpenRectD ObjectPainting_getOriginalRect(int handle);

    private final native float ObjectPainting_getRatio(int handle);

    private final native int ObjectPainting_getState(int handle);

    private final native String ObjectPainting_getThumbnailPath(int handle);

    private final native boolean ObjectPainting_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectPainting_setCropRect(int handle, Rect cropRect);

    private final native boolean ObjectPainting_setOriginalRect(int handle, SpenRectD originalRect);

    private final native boolean ObjectPainting_setRatio(int handle, float ratio);

    private final native boolean ObjectPainting_setState(int handle, int state);

    private final native boolean ObjectPainting_setThumbnailPath(int handle, String path);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectPainting(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @Deprecated(message = "Use attachedFile instead.")
    public void attachFile(@Nullable String filePath) {
        setAttachedFile(filePath);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @Nullable
    public String getAttachedFile() {
        return ObjectPainting_getAttachedFile(getMHandle());
    }

    @Nullable
    public final Rect getCropRect() {
        return ObjectPainting_getCropRect(getMHandle());
    }

    @Nullable
    public final SpenRectD getOriginalRect() {
        return ObjectPainting_getOriginalRect(getMHandle());
    }

    public final float getRatio() {
        return ObjectPainting_getRatio(getMHandle());
    }

    public final int getState() {
        return ObjectPainting_getState(getMHandle());
    }

    @Nullable
    public final String getThumbnailPath() {
        return ObjectPainting_getThumbnailPath(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setAttachedFile(@Nullable String str) {
        if (ObjectPainting_attachFile(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCropRect(@Nullable Rect rect) {
        if (ObjectPainting_setCropRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setOriginalRect(@Nullable SpenRectD spenRectD) {
        if (ObjectPainting_setOriginalRect(getMHandle(), spenRectD)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRatio(float f) {
        if (ObjectPainting_setRatio(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setState(int i) {
        if (ObjectPainting_setState(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (ObjectPainting_setThumbnailPath(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectPainting(boolean z) {
        super(14);
        if (ObjectPainting_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
