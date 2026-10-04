package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.google.protobuf.ByteString;
import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import com.samsung.android.mcf.continuity.common.Utils;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import org.apache.commons.beanutils.C13661a;
import p004A2.RunnableC0015b;
import p035H2.RunnableC0117b;
import p122b2.RunnableC4186i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityReceiveFile extends ContinuityFile {
    private static final String TAG = "ContinuityReceiveFile";

    @Nullable
    private ContinuitySessionFileManager.FileInfoListener mFileInfoListenerWrapper;

    @Nullable
    private FileOutputStream mFileOutputStream;
    private long mReceivedFileLength;

    @NonNull
    private final String mSrcBtMac;
    private long mTotalFileLength;

    public ContinuityReceiveFile(@NonNull Socket socket, @NonNull String str, @NonNull ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        super(socket);
        this.mSrcBtMac = str;
        this.mFileInfoListenerWrapper = fileInfoListener;
    }

    @NonNull
    private NetworkUtil.SocketCallback createFileSocketCallback() {
        return new NetworkUtil.SocketCallback() { // from class: com.samsung.android.mcf.continuity.impl.ContinuityReceiveFile.1
            @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
            public void onDisconnected() {
                synchronized (ContinuityReceiveFile.this.mLock) {
                    try {
                        ContinuityReceiveFile continuityReceiveFile = ContinuityReceiveFile.this;
                        if (continuityReceiveFile.mStatus == 61) {
                            continuityReceiveFile.nextFileStatusUpdated(70, 100.0d);
                        } else {
                            continuityReceiveFile.nextFileStatusUpdated(62, 100.0d);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
            public void onPacketReceived(@NonNull ProtoContinuityPacket.ContinuityPacket continuityPacket) {
                int type = continuityPacket.getType();
                int id = continuityPacket.getId();
                byte[] byteArray = continuityPacket.getPayload().toByteArray();
                if (type == 21) {
                    ContinuityReceiveFile.this.handleFileTransferRequestPacket(id, byteArray);
                } else {
                    if (type == 23) {
                        ContinuityReceiveFile.this.handleFileTransferDataPacket(id, byteArray);
                        return;
                    }
                    DLog.m5611w(ContinuityReceiveFile.TAG, "onPacketReceived", "invalid type : " + type);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFileTransferDataPacket(int i, @NonNull byte[] bArr) {
        double d;
        synchronized (this.mLock) {
            try {
                if (this.mSequence != i) {
                    DLog.m5611w(TAG, "handleFileTransferDataPacket", "invalid id : " + i + SQLKeyword.COMMA + this.mSequence + SQLKeyword.COMMA + DLog.secureMac(this.mSrcBtMac));
                    return;
                }
                if (this.mStatus != 51) {
                    DLog.m5611w(TAG, "handleFileTransferDataPacket", "invalid status = " + this.mStatus + SQLKeyword.COMMA + this.mSequence + SQLKeyword.COMMA + DLog.secureMac(this.mSrcBtMac));
                    return;
                }
                double d2 = (this.mReceivedFileLength / this.mTotalFileLength) * 100.0d;
                FileOutputStream fileOutputStream = this.mFileOutputStream;
                if (fileOutputStream == null) {
                    DLog.m5611w(TAG, "handleFileTransferDataPacket", "null mFileOutputStream " + DLog.secureMac(this.mSrcBtMac));
                    nextFileStatusUpdated(62, d2);
                    return;
                }
                DLog.m5608d(TAG, "handleFileTransferDataPacket", new C13661a(this, i, 2));
                try {
                    fileOutputStream.write(bArr);
                    synchronized (this.mLock) {
                        long length = this.mReceivedFileLength + ((long) bArr.length);
                        this.mReceivedFileLength = length;
                        d = (length / this.mTotalFileLength) * 100.0d;
                    }
                    nextFileStatusUpdated(51, d);
                    if (d == 100.0d) {
                        DLog.m5610i(TAG, "handleFileTransferDataPacket", "success : " + DLog.secureMac(this.mSrcBtMac));
                        nextFileStatusUpdated(61, d);
                    }
                } catch (IOException e) {
                    DLog.m5611w(TAG, "handleFileTransferDataPacket", "write IOException " + e.getMessage());
                    nextFileStatusUpdated(62, d2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFileTransferRequestPacket(int i, @NonNull byte[] bArr) {
        if (bArr.length < 8) {
            DLog.m5611w(TAG, "handleTransferRequestPacket", "invalid payload = " + bArr.length + SQLKeyword.COMMA + DLog.secureMac(this.mSrcBtMac));
            return;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 8);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 8, bArr.length);
        synchronized (this.mLock) {
            try {
                if (this.mStatus != 30) {
                    DLog.m5611w(TAG, "handleTransferRequestPacket", "invalid status = " + this.mStatus);
                } else {
                    this.mTotalFileLength = Utils.bytesToLong(bArrCopyOfRange);
                    this.mSequence = i;
                    ContinuityFileIdImpl continuityFileIdImpl = new ContinuityFileIdImpl(this.mSrcBtMac, ContinuityFileId.THIS_DEVICE, i);
                    DLog.m5610i(TAG, "handleFileTransferRequestPacket", i + SQLKeyword.COMMA + this.mTotalFileLength + SQLKeyword.COMMA + DLog.secureMac(this.mSrcBtMac));
                    nextFileInfoReceived(continuityFileIdImpl, bArrCopyOfRange2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$handleFileTransferDataPacket$2(int i) {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, SQLKeyword.COMMA);
        sbM1322o.append(DLog.secureMac(this.mSrcBtMac));
        return sbM1322o.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$read$3() {
        NetworkUtil.readSocket(this.mSocket, createFileSocketCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendFileTransferResponse$0(int i, int i2) {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, SQLKeyword.COMMA);
        sbM1322o.append(DLog.secureMac(this.mSrcBtMac));
        DLog.m5610i(TAG, "sendFileTransferResponse", sbM1322o.toString());
        try {
            ProtoContinuityPacket.ContinuityPacket.newBuilder().setType(22).setId(i).setPayload(ByteString.copyFrom(Utils.intToBytes(i2))).build().writeDelimitedTo(this.mSocket.getOutputStream());
            nextFileStatusUpdated(51, 0.0d);
        } catch (IOException e) {
            DLog.m5611w(TAG, "sendFileTransferResponse", "IOException : " + e.getMessage());
            nextFileStatusUpdated(62, 0.0d);
        }
    }

    private void nextFileInfoReceived(@NonNull ContinuityFileId continuityFileId, @NonNull byte[] bArr) {
        ContinuitySessionFileManager.FileInfoListener fileInfoListener;
        synchronized (this.mLock) {
            this.mStatus = 50;
            fileInfoListener = this.mFileInfoListenerWrapper;
        }
        if (fileInfoListener != null) {
            ExecutorUtil.executeOnMain(new RunnableC4186i(fileInfoListener, continuityFileId, bArr, 0));
        }
    }

    private void sendFileTransferResponse(int i) {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mSequence;
        }
        ExecutorUtil.executeOnIO(new RunnableC0117b(this, i2, i, 1));
    }

    private boolean setFile(@Nullable File file, @Nullable ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        if (file == null || fileStatusListener == null) {
            DLog.m5611w(TAG, "setFile", "null file or fileStatusListenerWrapper");
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            synchronized (this.mLock) {
                this.mFile = file;
                this.mFileStatusListenerWrapper = fileStatusListener;
                this.mFileOutputStream = fileOutputStream;
            }
            return true;
        } catch (FileNotFoundException e) {
            DLog.m5611w(TAG, "setFile", "FileOutputStream FileNotFoundException : " + e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.mcf.continuity.impl.ContinuityFile
    public void close() {
        synchronized (this.mLock) {
            this.mFileInfoListenerWrapper = null;
            FileOutputStream fileOutputStream = this.mFileOutputStream;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    this.mFileOutputStream = null;
                } catch (IOException e) {
                    DLog.m5611w(TAG, "close", "close IOException : " + e.getMessage());
                }
            }
        }
        super.close();
    }

    @Override // com.samsung.android.mcf.continuity.impl.ContinuityFile
    public void read() {
        ExecutorUtil.executeOnIO(new RunnableC0015b(this, 27));
    }

    public boolean responseReceiveFile(int i, @Nullable File file, @Nullable ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        if (i == -1) {
            sendFileTransferResponse(i);
            return true;
        }
        if (i != 0) {
            DLog.m5611w(TAG, "handleTransferRequestPacket", "invalid confirm = " + i);
            return false;
        }
        if (!setFile(file, fileStatusListener)) {
            return false;
        }
        sendFileTransferResponse(i);
        return true;
    }
}
