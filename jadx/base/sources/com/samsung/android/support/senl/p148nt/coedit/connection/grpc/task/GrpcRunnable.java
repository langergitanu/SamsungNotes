package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task;

import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import io.grpc.Status;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GrpcRunnable implements Runnable, OtDetectionListener {
    public static final long INFINITE_LOOP_SLEEP_DELAY = 10;
    private final Contract mContract;
    private int mResultCode;
    private int mRetryCount = 0;
    private boolean mIsInterrupted = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean isClosing();

        void onError(String str);

        void showToast(String str);
    }

    public GrpcRunnable(Contract contract) {
        this.mContract = contract;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public int getRetryCount() {
        CoeditLogger.m8919d(getTag(), "getRetryCount : " + this.mRetryCount);
        return this.mRetryCount;
    }

    public abstract String getTag();

    public void increaseRetryCount() {
        this.mRetryCount++;
        CoeditLogger.m8919d(getTag(), "increaseRetryCount : " + this.mRetryCount);
    }

    public synchronized void interrupt() {
        this.mIsInterrupted = true;
    }

    public boolean isClosing() {
        Contract contract = this.mContract;
        if (contract == null) {
            return true;
        }
        return contract.isClosing();
    }

    public synchronized boolean isInterrupt() {
        return this.mIsInterrupted;
    }

    public void onError(String str) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.onError(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mResultCode = Status.Code.UNKNOWN.value();
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public void showToast(String str) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.showToast(str);
    }
}
