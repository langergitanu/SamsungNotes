package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.method;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ByteArrayInOutStream;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.ByteUtils;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.control.util.DownSyncUtil;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import noteSnapMessage.DownloadResponse;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadNoteRunnable extends GrpcRunnable {
    private static final int DELAYS_FOR_RETRY_TIME_MILLIS = 2000;
    private static final int HTTP_RESULT_CODE_OK = 200;
    private static final int MAX_DOWNLOAD_RETRY_COUNT = 5;
    private static final String TAG = "NT/DownloadNoteRunnable";
    private final SnapGrpcData mData;

    public DownloadNoteRunnable(@NonNull SnapGrpcData snapGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = snapGrpcData;
    }

    private void checkRetryDownloadNote() {
        if (getResultCode() == Status.Code.OK.value()) {
            return;
        }
        if (isInterrupt()) {
            CoeditLogger.m8924w(TAG, "checkRetryDownloadNote, invalid result, but retry ignore, already interrupted");
            return;
        }
        if (5 < getRetryCount()) {
            return;
        }
        CoeditLogger.m8919d(TAG, "checkRetryDownloadNote, retry DownloadNote");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            CoeditLogger.m8924w(TAG, "checkRetryDownloadNote, InterruptedException: " + e.getMessage());
        }
        increaseRetryCount();
        downloadNote();
    }

    private void downloadNote() {
        final ByteArrayInOutStream byteArrayInOutStream = new ByteArrayInOutStream();
        try {
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.mData.setDownloadXmlData(null);
                this.mData.setDownloadXmlDataSize(-1L);
                setResultCode(0);
                StreamObserver<DownloadResponse> streamObserver = new StreamObserver<DownloadResponse>() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.snap.method.DownloadNoteRunnable.1
                    @Override // io.grpc.stub.StreamObserver
                    public void onCompleted() {
                        CoeditLogger.m8919d(DownloadNoteRunnable.TAG, "NoteSnapDownloadResponse, onCompleted");
                        DownloadNoteRunnable.this.requestDownSync(byteArrayInOutStream);
                        countDownLatch.countDown();
                    }

                    @Override // io.grpc.stub.StreamObserver
                    public void onError(Throwable th) {
                        StringBuilder sb = new StringBuilder("NoteSnapDownloadResponse, onError: ");
                        sb.append(th == null ? "null" : th.getMessage());
                        CoeditLogger.m8920e(DownloadNoteRunnable.TAG, sb.toString());
                        OtDetectionLogger.printCancellationCause(DownloadNoteRunnable.this);
                        DownloadNoteRunnable.this.setResultCode(Status.Code.UNAVAILABLE.value());
                        countDownLatch.countDown();
                    }

                    @Override // io.grpc.stub.StreamObserver
                    public void onNext(DownloadResponse downloadResponse) throws IOException {
                        if (DownloadNoteRunnable.this.isInterrupt()) {
                            DownloadNoteRunnable.this.setResultCode(Status.Code.UNAVAILABLE.value());
                            onError(new InterruptedException("NT/DownloadNoteRunnable onNext interrupted, download note ignored"));
                            return;
                        }
                        DownloadNoteRunnable.this.printResponse(downloadResponse);
                        if (downloadResponse.hasBinary()) {
                            byteArrayInOutStream.write(downloadResponse.getBinary().getChunk().toByteArray(), 0, downloadResponse.getBinary().getReadSize());
                        }
                        if (downloadResponse.hasResponseResult()) {
                            if (downloadResponse.getResponseResult().getCode() == 200) {
                                DownloadNoteRunnable.this.setResultCode(Status.Code.OK.value());
                            } else {
                                DownloadNoteRunnable downloadNoteRunnable = DownloadNoteRunnable.this;
                                Status.Code code = Status.Code.NOT_FOUND;
                                downloadNoteRunnable.setResultCode(code.value());
                                onError(new Throwable(code.name()));
                            }
                            DownloadNoteRunnable.this.mData.setDownloadXmlDataSize(downloadResponse.getResponseResult().getSize());
                            DownloadNoteRunnable.this.mData.setResultCode(DownloadNoteRunnable.this.getResultCode());
                        }
                    }
                };
                String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                printRequest(requestNumber);
                this.mData.asyncDownloadNote(requestNumber, streamObserver);
                while (true) {
                    if (!this.mData.isFinished() && 0 >= countDownLatch.getCount()) {
                        break;
                    }
                    if (isInterrupt()) {
                        setResultCode(Status.Code.UNAVAILABLE.value());
                        throw new InterruptedException("NT/DownloadNoteRunnable pending interrupted, download note ignored");
                    }
                    Thread.sleep(10L);
                }
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "[CS7-2] Failed to download note. " + e.getMessage());
                showToast("download note error. " + e.getMessage());
            }
        } finally {
            releaseByteArrayInOutStream(byteArrayInOutStream);
            checkRetryDownloadNote();
        }
    }

    private void printRequest(String str) {
        String tag = getTag();
        StringBuilder sbM15l = AbstractC0000a.m15l("Request# RequestId: [", str, "], uuid: [");
        sbM15l.append(this.mData.getNoteId());
        sbM15l.append("]");
        CoeditLogger.m8923i(tag, sbM15l.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printResponse(DownloadResponse downloadResponse) {
        StringBuilder sb = new StringBuilder("Response# ");
        if (downloadResponse.hasBinaryInfo()) {
            sb.append("{binaryInfo: name: [");
            sb.append(downloadResponse.getBinaryInfo().getName());
            sb.append("], type: [");
            sb.append(downloadResponse.getBinaryInfo().getType());
            sb.append("], length: [");
            sb.append(downloadResponse.getBinaryInfo().getLength());
            sb.append("]} ");
        }
        if (downloadResponse.hasBinary()) {
            sb.append("{binary: size: [");
            sb.append(downloadResponse.getBinary().getReadSize());
            sb.append("], chunk: [");
            sb.append(downloadResponse.getBinary().getChunk());
            sb.append("]}");
        }
        if (downloadResponse.hasResponseResult()) {
            sb.append(" uuid: [");
            sb.append(this.mData.getNoteId());
            sb.append("] , workspaceId: [");
            sb.append(this.mData.getWorkspaceId());
            sb.append("] , ");
            sb.append(OtDetectionLogger.getResponseResultLog(downloadResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    private void releaseByteArrayInOutStream(ByteArrayInOutStream byteArrayInOutStream) {
        if (byteArrayInOutStream == null) {
            return;
        }
        try {
            ByteUtils.releaseByteArrayOutputStream(byteArrayInOutStream);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("[CS7-2] releaseByteArrayInOutStream, Exception :"), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestDownSync(ByteArrayInOutStream byteArrayInOutStream) {
        if (byteArrayInOutStream == null) {
            return;
        }
        int resultCode = getResultCode();
        if (resultCode == Status.Code.OK.value()) {
            DownSyncUtil.requestDownSync(BaseUtils.getApplicationContext(), byteArrayInOutStream.getInputStream(), new DownSyncUtil.ResponseHandler() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.snap.method.DownloadNoteRunnable.2
                @Override // com.samsung.android.support.senl.nt.coedit.control.util.DownSyncUtil.ResponseHandler
                public void handleBinaryBody(String str, byte[] bArr) {
                    DownloadNoteRunnable.this.mData.putDownloadStrokeData(str, bArr);
                }

                @Override // com.samsung.android.support.senl.nt.coedit.control.util.DownSyncUtil.ResponseHandler
                public void handleDownloadUrlMap(Map<String, String> map) {
                    DownloadNoteRunnable.this.mData.handleDownloadUrlMap(map);
                }

                @Override // com.samsung.android.support.senl.nt.coedit.control.util.DownSyncUtil.ResponseHandler
                public void handleDownloadXmlData(String str) {
                    DownloadNoteRunnable.this.mData.setDownloadXmlData(str);
                }
            });
            return;
        }
        CoeditLogger.m8919d(TAG, "requestDownSync, ignore, resultCode: " + resultCode);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        long jCurrentTimeMillis = System.currentTimeMillis();
        CoeditLogger.m8923i(TAG, "run, start");
        downloadNote();
        CoeditLogger.m8923i(TAG, "streaming, end, duration: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", try Count: " + getRetryCount());
    }
}
