package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.google.protobuf.ByteString;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.NetworkUtil;
import com.samsung.android.mcf.continuity.common.Utils;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import p122b2.RunnableC4187j;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuitySendFile extends ContinuityFile {
    private static final int READ_BUF_SIZE = 102400;
    private static final String TAG = "ContinuitySendFile";

    @NonNull
    private final String mTargetBtMac;

    public ContinuitySendFile(@NonNull Socket socket, @NonNull String str, int i, @NonNull byte[] bArr, @NonNull File file, @NonNull ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        super(socket);
        this.mTargetBtMac = str;
        this.mSequence = i;
        this.mFileInfo = bArr;
        this.mFile = file;
        this.mFileStatusListenerWrapper = fileStatusListener;
    }

    @NonNull
    private NetworkUtil.SocketCallback createFileSocketCallback() {
        return new NetworkUtil.SocketCallback() { // from class: com.samsung.android.mcf.continuity.impl.ContinuitySendFile.1
            @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
            public void onDisconnected() {
                synchronized (ContinuitySendFile.this.mLock) {
                    try {
                        ContinuitySendFile continuitySendFile = ContinuitySendFile.this;
                        if (continuitySendFile.mStatus == 61) {
                            continuitySendFile.nextFileStatusUpdated(70, 100.0d);
                        } else {
                            continuitySendFile.nextFileStatusUpdated(62, 0.0d);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.samsung.android.mcf.continuity.common.NetworkUtil.SocketCallback
            public void onPacketReceived(@NonNull ProtoContinuityPacket.ContinuityPacket continuityPacket) {
                int id = continuityPacket.getId();
                synchronized (ContinuitySendFile.this.mLock) {
                    try {
                        if (id != ContinuitySendFile.this.mSequence) {
                            DLog.m5611w(ContinuitySendFile.TAG, "onPacketReceived", "invalid id : " + id + SQLKeyword.COMMA + ContinuitySendFile.this.mSequence + SQLKeyword.COMMA + DLog.secureMac(ContinuitySendFile.this.mTargetBtMac));
                            return;
                        }
                        int type = continuityPacket.getType();
                        byte[] byteArray = continuityPacket.getPayload().toByteArray();
                        if (type == 22) {
                            ContinuitySendFile.this.handleFileTransferResponsePacket(byteArray);
                            return;
                        }
                        DLog.m5611w(ContinuitySendFile.TAG, "onPacketReceived", "invalid type : " + type);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFileTransferResponsePacket(@NonNull byte[] bArr) {
        int iBytesToInt = Utils.bytesToInt(bArr);
        synchronized (this.mLock) {
            DLog.m5610i(TAG, "handleFileTransferAcceptPacket", this.mSequence + SQLKeyword.COMMA + iBytesToInt + SQLKeyword.COMMA + DLog.secureMac(this.mTargetBtMac));
            if (this.mStatus != 40) {
                DLog.m5611w(TAG, "handleFileTransferAcceptPacket", "invalid status = " + this.mStatus);
                return;
            }
            if (iBytesToInt == -1) {
                nextFileStatusUpdated(42, 0.0d);
            } else if (iBytesToInt != 0) {
                DLog.m5611w(TAG, "handleFileTransferDenyPacket", "invalid confirm = " + iBytesToInt);
            } else {
                nextFileStatusUpdated(41, 0.0d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$read$2() {
        NetworkUtil.readSocket(this.mSocket, createFileSocketCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendFileData$1() throws Throwable {
        int i;
        synchronized (this.mLock) {
            try {
                i = this.mSequence;
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, SQLKeyword.COMMA);
        sbM1322o.append(DLog.secureMac(this.mTargetBtMac));
        DLog.m5610i(TAG, "sendFileData", sbM1322o.toString());
        try {
            OutputStream outputStream = this.mSocket.getOutputStream();
            synchronized (this.mLock) {
                try {
                    if (this.mFile == null) {
                        DLog.m5611w(TAG, "sendFileData", "null mFile");
                        nextFileStatusUpdated(62, 0.0d);
                        return;
                    }
                    try {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(this.mFile);
                            long length = this.mFile.length();
                            if (length == 0) {
                                DLog.m5611w(TAG, "sendFileData", "empty file");
                                nextFileStatusUpdated(62, 0.0d);
                                return;
                            }
                            sendFileData(i, length, fileInputStream, outputStream);
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                DLog.m5611w(TAG, "sendFileData", "close IOException : " + e.getMessage());
                            }
                        } catch (FileNotFoundException e2) {
                            DLog.m5611w(TAG, "sendFileData", "FileInputStream FileNotFoundException : " + e2.getMessage());
                            nextFileStatusUpdated(62, 0.0d);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (IOException e3) {
            DLog.m5611w(TAG, "sendFileData", "getOutputStream IOException : " + e3.getMessage());
            nextFileStatusUpdated(62, 0.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendFileInfo$0() {
        synchronized (this.mLock) {
            try {
                File file = this.mFile;
                if (file == null) {
                    DLog.m5611w(TAG, "sendFileInfo", "null mFile " + DLog.secureMac(this.mTargetBtMac));
                    nextFileStatusUpdated(62, 0.0d);
                    return;
                }
                long length = file.length();
                if (length == 0) {
                    DLog.m5611w(TAG, "sendFileInfo", "empty file " + DLog.secureMac(this.mTargetBtMac));
                    nextFileStatusUpdated(62, 0.0d);
                    return;
                }
                byte[] bArr = this.mFileInfo;
                if (bArr != null && bArr.length != 0) {
                    byte[] bArrLongToBytes = Utils.longToBytes(length);
                    byte[] bArr2 = new byte[this.mFileInfo.length + 8];
                    System.arraycopy(bArrLongToBytes, 0, bArr2, 0, bArrLongToBytes.length);
                    byte[] bArr3 = this.mFileInfo;
                    System.arraycopy(bArr3, 0, bArr2, bArrLongToBytes.length, bArr3.length);
                    int i = this.mSequence;
                    ByteString byteStringCopyFrom = ByteString.copyFrom(bArr2);
                    StringBuilder sbM1322o = AbstractC1974b.m1322o(i, SQLKeyword.COMMA);
                    sbM1322o.append(DLog.secureMac(this.mTargetBtMac));
                    DLog.m5610i(TAG, "sendFileInfo", sbM1322o.toString());
                    try {
                        ProtoContinuityPacket.ContinuityPacket.newBuilder().setType(21).setId(i).setPayload(byteStringCopyFrom).build().writeDelimitedTo(this.mSocket.getOutputStream());
                        nextFileStatusUpdated(40, 0.0d);
                        return;
                    } catch (IOException e) {
                        DLog.m5611w(TAG, "sendFileInfo", "IOException : " + e.getMessage());
                        nextFileStatusUpdated(62, 0.0d);
                        return;
                    }
                }
                DLog.m5611w(TAG, "sendFileInfo", "invalid fileInfo " + DLog.secureMac(this.mTargetBtMac));
                nextFileStatusUpdated(62, 0.0d);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    private void sendFileData(int i, long j, @NonNull FileInputStream fileInputStream, @NonNull OutputStream outputStream) {
        ProtoContinuityPacket.ContinuityPacket.Builder builderNewBuilder = ProtoContinuityPacket.ContinuityPacket.newBuilder();
        byte[] bArr = new byte[READ_BUF_SIZE];
        long size = 0;
        double d = 0.0d;
        do {
            try {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    DLog.m5611w(TAG, "sendFileData", "readLen is -1");
                    nextFileStatusUpdated(62, d);
                    return;
                }
                ByteString byteStringCopyFrom = ByteString.copyFrom(bArr, 0, i2);
                if (byteStringCopyFrom.isEmpty()) {
                    DLog.m5611w(TAG, "sendFileData", "empty byteString");
                    nextFileStatusUpdated(62, d);
                    return;
                }
                try {
                    builderNewBuilder.setType(23).setId(i).setPayload(byteStringCopyFrom).build().writeDelimitedTo(outputStream);
                    size += (long) byteStringCopyFrom.size();
                    d = (size / j) * 100.0d;
                    DLog.m5607d(TAG, "sendFileData", String.valueOf(Math.round(d * 100.0d) / 100.0d));
                    nextFileStatusUpdated(43, d);
                } catch (IOException e) {
                    DLog.m5611w(TAG, "sendFileData", "writeDelimitedTo IOException : " + e.getMessage());
                    nextFileStatusUpdated(62, d);
                    return;
                }
            } catch (IOException e2) {
                DLog.m5611w(TAG, "sendFileData", "read IOException : " + e2.getMessage());
                nextFileStatusUpdated(62, d);
                return;
            }
        } while (size < j);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "success : ", SQLKeyword.COMMA);
        sbM778t.append(DLog.secureMac(this.mTargetBtMac));
        DLog.m5610i(TAG, "sendFileData", sbM778t.toString());
        nextFileStatusUpdated(61, d);
    }

    @Override // com.samsung.android.mcf.continuity.impl.ContinuityFile
    public void read() {
        ExecutorUtil.executeOnIO(new RunnableC4187j(this, 0));
    }

    public void sendFileInfo() {
        ExecutorUtil.executeOnIO(new RunnableC4187j(this, 1));
    }

    public void sendFileData() {
        ExecutorUtil.executeOnIO(new RunnableC4187j(this, 2));
    }
}
