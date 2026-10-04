package com.samsung.android.smartswitchfileshare;

import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ProgressManager {
    protected final String TAG;

    /* JADX INFO: renamed from: cb */
    protected FileShareCallback f5428cb;
    protected boolean enableLog;
    protected int totalCount;
    protected long totalSize;
    protected long transferredSize = 0;
    protected int transferredCount = 0;
    protected long lastUpdateTime = SystemClock.elapsedRealtime();

    public ProgressManager(@Nullable FileShareCallback fileShareCallback, String str, boolean z) {
        this.TAG = AbstractC0541b.m772n(Constants.PREFIX, str);
        this.f5428cb = fileShareCallback;
        this.enableLog = z;
    }

    public void finish() {
        FileShareCallback fileShareCallback = this.f5428cb;
        if (fileShareCallback != null) {
            fileShareCallback.progress(this.transferredSize, this.totalSize);
            if (this.enableLog) {
                Log.w(this.TAG, String.format("finish! %d / %d", Integer.valueOf(this.transferredCount), Integer.valueOf(this.totalCount)));
            }
            this.f5428cb.finish(this.transferredCount, this.totalCount);
        }
    }

    public int getTransferredCount() {
        return this.transferredCount;
    }

    public boolean hasCallback() {
        return this.f5428cb != null;
    }

    public void updateTransferredCount(boolean z) {
        if (z) {
            this.transferredCount++;
        }
        if (!this.enableLog || this.f5428cb == null) {
            return;
        }
        Log.w(this.TAG, String.format("update count! (%b) %d / %d", Boolean.valueOf(z), Integer.valueOf(this.transferredCount), Integer.valueOf(this.totalCount)));
    }

    public void updateTransferredSize(long j) {
        this.transferredSize += j;
        if (this.f5428cb != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = jElapsedRealtime >= this.lastUpdateTime + 200;
            if (z) {
                this.f5428cb.progress(this.transferredSize, this.totalSize);
                this.lastUpdateTime = jElapsedRealtime;
            }
            if (this.enableLog) {
                Log.i(this.TAG, String.format("update size! update?[%b] [%s / %s] [%d / %d] lastUpdate[%d]", Boolean.valueOf(z), CommonUtil.getByteToCeilGiBString(this.transferredSize), CommonUtil.getByteToCeilGiBString(this.totalSize), Long.valueOf(this.transferredSize), Long.valueOf(this.totalSize), Long.valueOf(this.lastUpdateTime)));
            }
        }
    }
}
