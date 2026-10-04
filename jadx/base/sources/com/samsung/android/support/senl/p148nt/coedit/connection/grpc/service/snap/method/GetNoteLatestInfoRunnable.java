package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.method;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.StatusRuntimeException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import noteSnapMessage.NoteInfoRequest;
import noteSnapMessage.NoteInfoResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GetNoteLatestInfoRunnable extends GrpcRunnable {
    private static final String TAG = "GetNoteLatestInfoRunnable";
    private final SnapGrpcData mData;
    private final SimpleDateFormat mDateFormat;

    public GetNoteLatestInfoRunnable(@NonNull SnapGrpcData snapGrpcData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = snapGrpcData;
        this.mDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault());
    }

    private void printResponse(NoteInfoResponse noteInfoResponse) {
        if (noteInfoResponse == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("Response# checkpoint: [");
        sb.append(noteInfoResponse.getCheckpoint());
        sb.append("], modifiedTime: [");
        sb.append(this.mDateFormat.format(new Date(noteInfoResponse.getModifiedtime())));
        sb.append("], commitId: [");
        sb.append(noteInfoResponse.getCommitId());
        sb.append("]}");
        if (noteInfoResponse.hasResponseResult()) {
            sb.append(SQLKeyword.COMMA);
            sb.append(OtDetectionLogger.getResponseResultLog(noteInfoResponse.getResponseResult()));
        }
        CoeditLogger.m8923i(getTag(), sb.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() throws Throwable {
        long j;
        long j2;
        super.run();
        try {
            try {
                NoteInfoRequest noteInfoRequestBuild = NoteInfoRequest.newBuilder().build();
                String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                CoeditLogger.m8919d(TAG, "request, requestId: [" + requestNumber + "]");
                NoteInfoResponse latestNoteInfo = this.mData.getLatestNoteInfo(requestNumber, noteInfoRequestBuild);
                printResponse(latestNoteInfo);
                setResultCode(latestNoteInfo.getResponseResult().getCode());
                long checkpoint = latestNoteInfo.getCheckpoint();
                try {
                    long modifiedtime = latestNoteInfo.getModifiedtime();
                    try {
                        String commitId = latestNoteInfo.getCommitId();
                        this.mData.setResultCode(getResultCode());
                        this.mData.updateSnapNoteLatestInfo(checkpoint, modifiedtime, commitId);
                    } catch (StatusRuntimeException e) {
                        e = e;
                        j2 = checkpoint;
                        j = modifiedtime;
                        setResultCode(e.getStatus().getCode().value());
                        this.mData.setResultCode(getResultCode());
                        this.mData.updateSnapNoteLatestInfo(j2, j, "");
                    } catch (Exception e2) {
                        e = e2;
                        j2 = checkpoint;
                        j = modifiedtime;
                        CoeditLogger.m8920e(TAG, "request, Exception: [" + e.getMessage() + "]");
                        this.mData.setResultCode(getResultCode());
                        this.mData.updateSnapNoteLatestInfo(j2, j, "");
                    } catch (Throwable th) {
                        th = th;
                        j2 = checkpoint;
                        j = modifiedtime;
                        this.mData.setResultCode(getResultCode());
                        this.mData.updateSnapNoteLatestInfo(j2, j, "");
                        throw th;
                    }
                } catch (StatusRuntimeException e3) {
                    e = e3;
                    j = 0;
                    j2 = checkpoint;
                } catch (Exception e5) {
                    e = e5;
                    j = 0;
                    j2 = checkpoint;
                } catch (Throwable th2) {
                    th = th2;
                    j = 0;
                    j2 = checkpoint;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (StatusRuntimeException e6) {
            e = e6;
            j = 0;
            j2 = -1;
        } catch (Exception e7) {
            e = e7;
            j = 0;
            j2 = -1;
        } catch (Throwable th4) {
            th = th4;
            j = 0;
            j2 = -1;
        }
    }
}
