package com.samsung.android.sdk.composer.document.sdoc;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002J\u0011\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!H\u0082 J\u001b\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020!H\u0082 J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020!H\u0082 J\u001b\u0010(\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010)\u001a\u00020\u00052\u0006\u0010#\u001a\u00020!H\u0082 J\u0019\u0010*\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082 J\u0011\u0010+\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!H\u0082 J\u001b\u0010,\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0082 J\u0011\u0010-\u001a\u00020\u00052\u0006\u0010#\u001a\u00020!H\u0082 J#\u0010.\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!2\u0006\u0010/\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0082 R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR(\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\n¨\u00060"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentVoice;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", "time", "", DBSchema.DocumentThumbnail.PLAY_TIME, "getPlayTime", "()Ljava/lang/String;", "setPlayTime", "(Ljava/lang/String;)V", "hashCode", "getHashCode", "setHashCode", "id", "bookmarkID", "getBookmarkID", "setBookmarkID", "isRecorded", "", "()Z", "setRecorded", "(Z)V", "path", "attachedFile", "getAttachedFile", "setAttachedFile", "attachFile", "", "copy", "source", "throwUncheckedException", "errno", "", "ContentVoice_init", "handle", "ContentVoice_setPlayTime", "ContentVoice_getPlayTime", "ContentVoice_setHashCode", "ContentVoice_getHashCode", "ContentVoice_setBookmarkID", "ContentVoice_getBookmarkID", "ContentVoice_setRecorded", "ContentVoice_isRecorded", "ContentVoice_attachFile", "ContentVoice_getAttachedFile", "ContentVoice_copy", "sourceHandle", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentVoice extends SpenContentBase {
    public SpenContentVoice() {
        super(7);
    }

    private final native boolean ContentVoice_attachFile(int handle, String path);

    private final native boolean ContentVoice_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native String ContentVoice_getAttachedFile(int handle);

    private final native String ContentVoice_getBookmarkID(int handle);

    private final native String ContentVoice_getHashCode(int handle);

    private final native String ContentVoice_getPlayTime(int handle);

    private final native boolean ContentVoice_init(int handle);

    private final native boolean ContentVoice_isRecorded(int handle);

    private final native boolean ContentVoice_setBookmarkID(int handle, String id);

    private final native boolean ContentVoice_setHashCode(int handle, String hashCode);

    private final native boolean ContentVoice_setPlayTime(int handle, String time);

    private final native boolean ContentVoice_setRecorded(int handle, boolean isRecorded);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentVoice(" + this + ") is already closed");
    }

    @Deprecated(message = "Please use [.attachedFile] instead.")
    public final void attachFile(@Nullable String path) {
        if (ContentVoice_attachFile(getMHandle(), path)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 7) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentVoice_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final String getAttachedFile() {
        return ContentVoice_getAttachedFile(getMHandle());
    }

    @Nullable
    public final String getBookmarkID() {
        return ContentVoice_getBookmarkID(getMHandle());
    }

    @Nullable
    public final String getHashCode() {
        return ContentVoice_getHashCode(getMHandle());
    }

    @Nullable
    public final String getPlayTime() {
        return ContentVoice_getPlayTime(getMHandle());
    }

    public final boolean isRecorded() {
        return ContentVoice_isRecorded(getMHandle());
    }

    public final void setAttachedFile(@Nullable String str) {
        if (ContentVoice_attachFile(getMHandle(), str)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IllegalArgumentException("E_FILE_CAN_NOT_OPEN");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBookmarkID(@Nullable String str) {
        if (ContentVoice_setBookmarkID(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHashCode(@Nullable String str) {
        if (ContentVoice_setHashCode(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPlayTime(@Nullable String str) {
        if (ContentVoice_setPlayTime(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRecorded(boolean z) {
        if (ContentVoice_setRecorded(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
