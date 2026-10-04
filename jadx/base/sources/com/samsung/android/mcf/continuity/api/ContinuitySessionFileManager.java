package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuitySessionFileManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class FileInfoListener {
        public abstract void onFileInfoReceived(@NonNull ContinuityFileId continuityFileId, @NonNull byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class FileStatusListener {
        public abstract void onFileStatusUpdated(int i, double d);
    }

    void cancelFile(@NonNull ContinuityFileId continuityFileId);

    boolean registerFileInfoListener(@NonNull FileInfoListener fileInfoListener);

    boolean responseReceiveFile(int i, @NonNull ContinuityFileId continuityFileId, @Nullable File file, @Nullable FileStatusListener fileStatusListener);

    @Nullable
    ContinuityFileId sendFile(@NonNull String str, @NonNull byte[] bArr, @NonNull File file, @NonNull FileStatusListener fileStatusListener);

    void unregisterFileInfoListener();
}
