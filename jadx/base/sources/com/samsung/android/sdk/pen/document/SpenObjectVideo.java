package com.samsung.android.sdk.pen.document;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u0019\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001b\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0082 J\u001b\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u0082 R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectVideo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "path", "", "attachedFile", "getAttachedFile", "()Ljava/lang/String;", "setAttachedFile", "(Ljava/lang/String;)V", "attachFile", "", "filePath", "thumbnailPath", "getThumbnailPath", "setThumbnailPath", "type", "", "getType", "()I", "throwUncheckedException", "errno", "ObjectVideo_init", "handle", "ObjectVideo_attachFile", "ObjectVideo_getAttachedFile", "ObjectVideo_setThumbnailPath", "ObjectVideo_getThumbnailPath", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectVideo extends SpenObjectBase {
    public SpenObjectVideo() {
        super(16);
    }

    private final native boolean ObjectVideo_attachFile(int handle, String path);

    private final native String ObjectVideo_getAttachedFile(int handle);

    private final native String ObjectVideo_getThumbnailPath(int handle);

    private final native boolean ObjectVideo_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectVideo_setThumbnailPath(int handle, String path);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectVideo(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @Deprecated(message = "Use attachedFile instead.")
    public void attachFile(@Nullable String filePath) {
        setAttachedFile(filePath);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @Nullable
    public String getAttachedFile() {
        return ObjectVideo_getAttachedFile(getMHandle());
    }

    @Nullable
    public final String getThumbnailPath() {
        return ObjectVideo_getThumbnailPath(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setAttachedFile(@Nullable String str) {
        if (ObjectVideo_attachFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPath(@Nullable String str) {
        if (ObjectVideo_setThumbnailPath(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectVideo(boolean z) {
        super(16);
        if (ObjectVideo_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
