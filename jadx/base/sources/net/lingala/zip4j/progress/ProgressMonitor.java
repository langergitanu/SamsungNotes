package net.lingala.zip4j.progress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProgressMonitor {
    public static final int OPERATION_ADD = 0;
    public static final int OPERATION_CALC_CRC = 3;
    public static final int OPERATION_EXTRACT = 1;
    public static final int OPERATION_MERGE = 4;
    public static final int OPERATION_NONE = -1;
    public static final int OPERATION_REMOVE = 2;
    public static final int RESULT_CANCELLED = 3;
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_WORKING = 1;
    public static final int STATE_BUSY = 1;
    public static final int STATE_READY = 0;
    private boolean cancelAllTasks;
    private int currentOperation;
    private Throwable exception;
    private String fileName;
    private boolean pause;
    private int percentDone;
    private int result;
    private int state;
    private long totalWork;
    private long workCompleted;

    public ProgressMonitor() {
        reset();
        this.percentDone = 0;
    }

    public void cancelAllTasks() {
        this.cancelAllTasks = true;
    }

    public void endProgressMonitorError(Throwable th) {
        reset();
        this.result = 2;
        this.exception = th;
    }

    public void endProgressMonitorSuccess() {
        reset();
        this.result = 0;
    }

    public void fullReset() {
        reset();
        this.exception = null;
        this.result = 0;
        this.percentDone = 0;
    }

    public int getCurrentOperation() {
        return this.currentOperation;
    }

    public Throwable getException() {
        return this.exception;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public int getResult() {
        return this.result;
    }

    public int getState() {
        return this.state;
    }

    public long getTotalWork() {
        return this.totalWork;
    }

    public long getWorkCompleted() {
        return this.workCompleted;
    }

    public boolean isCancelAllTasks() {
        return this.cancelAllTasks;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void reset() {
        this.currentOperation = -1;
        this.state = 0;
        this.fileName = null;
        this.totalWork = 0L;
        this.workCompleted = 0L;
    }

    public void setCurrentOperation(int i) {
        this.currentOperation = i;
    }

    public void setException(Throwable th) {
        this.exception = th;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setPause(boolean z) {
        this.pause = z;
    }

    public void setPercentDone(int i) {
        this.percentDone = i;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTotalWork(long j) {
        this.totalWork = j;
    }

    public void updateWorkCompleted(long j) {
        long j2 = this.workCompleted + j;
        this.workCompleted = j2;
        int i = (int) ((j2 * 100) / this.totalWork);
        this.percentDone = i;
        if (i > 100) {
            this.percentDone = 100;
        }
        while (this.pause) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
