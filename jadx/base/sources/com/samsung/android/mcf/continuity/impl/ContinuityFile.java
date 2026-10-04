package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import java.io.File;
import java.net.Socket;
import p122b2.RunnableC4185h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ContinuityFile {

    @Nullable
    public File mFile;

    @Nullable
    public byte[] mFileInfo;

    @Nullable
    public ContinuitySessionFileManager.FileStatusListener mFileStatusListenerWrapper;
    public int mSequence;

    @NonNull
    public final Socket mSocket;

    @NonNull
    public final Object mLock = new Object();
    public int mStatus = 30;

    public ContinuityFile(@NonNull Socket socket) {
        this.mSocket = socket;
    }

    public void close() {
        synchronized (this.mLock) {
            this.mFileInfo = null;
            this.mFile = null;
            this.mFileStatusListenerWrapper = null;
        }
        NetworkUtil.closeSocket(this.mSocket);
    }

    public int getSequence() {
        int i;
        synchronized (this.mLock) {
            i = this.mSequence;
        }
        return i;
    }

    public void nextFileStatusUpdated(int i, double d) {
        ContinuitySessionFileManager.FileStatusListener fileStatusListener;
        synchronized (this.mLock) {
            this.mStatus = i;
            fileStatusListener = this.mFileStatusListenerWrapper;
        }
        if (fileStatusListener != null) {
            ExecutorUtil.executeOnMain(new RunnableC4185h(i, 0, d, fileStatusListener));
        }
    }

    public abstract void read();
}
