package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import java.io.File;
import java.util.Objects;
import p014C3.RunnableC0054a;
import p122b2.RunnableC4185h;
import p122b2.RunnableC4186i;
import p122b2.RunnableC4195r;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuitySessionFileManagerImpl implements ContinuitySessionFileManager {
    private static final String TAG = "ContinuitySessionFileManagerImpl";

    @NonNull
    private final ContinuitySession mContinuitySession;

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionFileManagerImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72001 extends ContinuitySessionFileManager.FileInfoListener {
        public final /* synthetic */ ContinuitySessionFileManager.FileInfoListener val$fileInfoListener;

        public C72001(ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
            this.val$fileInfoListener = fileInfoListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager.FileInfoListener
        public void onFileInfoReceived(@NonNull ContinuityFileId continuityFileId, @NonNull byte[] bArr) {
            ExecutorUtil.executeOnCallback(new RunnableC4186i(this.val$fileInfoListener, continuityFileId, bArr, 1));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionFileManagerImpl$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72012 extends ContinuitySessionFileManager.FileStatusListener {
        public final /* synthetic */ ContinuitySessionFileManager.FileStatusListener val$fileStatusListener;

        public C72012(ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
            this.val$fileStatusListener = fileStatusListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager.FileStatusListener
        public void onFileStatusUpdated(int i, double d) {
            ExecutorUtil.executeOnCallback(new RunnableC4185h(i, 1, d, this.val$fileStatusListener));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionFileManagerImpl$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72023 extends ContinuitySessionFileManager.FileStatusListener {
        public final /* synthetic */ ContinuitySessionFileManager.FileStatusListener val$fileStatusListener;

        public C72023(ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
            this.val$fileStatusListener = fileStatusListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager.FileStatusListener
        public void onFileStatusUpdated(int i, double d) {
            ExecutorUtil.executeOnCallback(new RunnableC4185h(i, 2, d, this.val$fileStatusListener));
        }
    }

    public ContinuitySessionFileManagerImpl(@NonNull ContinuitySession continuitySession) {
        this.mContinuitySession = continuitySession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerFileInfoListener$0(ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        this.mContinuitySession.registerFileInfoListener(new C72001(fileInfoListener));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager
    public void cancelFile(@NonNull ContinuityFileId continuityFileId) {
    }

    @MainThread
    public void destroy() {
        this.mContinuitySession.unregisterFileInfoListener();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager
    public boolean registerFileInfoListener(@NonNull ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        return ExecutorUtil.executeOnMain(new RunnableC0054a(this, fileInfoListener, 27));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager
    public boolean responseReceiveFile(int i, @NonNull ContinuityFileId continuityFileId, @Nullable File file, @Nullable ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        return this.mContinuitySession.responseReceiveFile(i, continuityFileId, file, fileStatusListener == null ? null : new C72023(fileStatusListener));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager
    @Nullable
    public ContinuityFileId sendFile(@NonNull String str, @NonNull byte[] bArr, @NonNull File file, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        return this.mContinuitySession.sendFile(str, bArr, file, new C72012(fileStatusListener));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager
    public void unregisterFileInfoListener() {
        ContinuitySession continuitySession = this.mContinuitySession;
        Objects.requireNonNull(continuitySession);
        ExecutorUtil.executeOnMain(new RunnableC4195r(continuitySession, 1));
    }
}
