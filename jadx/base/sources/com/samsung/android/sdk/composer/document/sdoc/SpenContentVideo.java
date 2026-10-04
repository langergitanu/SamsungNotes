package com.samsung.android.sdk.composer.document.sdoc;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0082 J#\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0082 J\u001b\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011H\u0082 R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentVideo;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", "path", "", "attachedFile", "getAttachedFile", "()Ljava/lang/String;", "setAttachedFile", "(Ljava/lang/String;)V", "attachFile", "", "copy", "source", "throwUncheckedException", "errno", "", "ContentVideo_init", "", "handle", "ContentVideo_copy", "sourceHandle", "ContentVideo_attachFile", "ContentVideo_getAttachedFile", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentVideo extends SpenContentBase {
    public SpenContentVideo() {
        super(9);
    }

    private final native boolean ContentVideo_attachFile(int handle, String path);

    private final native boolean ContentVideo_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native String ContentVideo_getAttachedFile(int handle);

    private final native boolean ContentVideo_init(int handle);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentVideo(" + this + ") is already closed");
    }

    @Deprecated(message = "Please use [.attachedFile] instead.")
    public final void attachFile(@Nullable String path) {
        if (ContentVideo_attachFile(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 9) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentVideo_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final String getAttachedFile() {
        return ContentVideo_getAttachedFile(getMHandle());
    }

    public final void setAttachedFile(@Nullable String str) {
        if (ContentVideo_attachFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
