package com.samsung.android.support.senl.p148nt.model.converter.task.service.job;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.WConvertQueueItem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class JobRunner implements Runnable {
    protected WConvertQueueItem mItem;
    private final int mTaskType;

    public JobRunner(WConvertQueueItem wConvertQueueItem, int i) {
        this.mItem = wConvertQueueItem;
        this.mTaskType = i;
    }

    public abstract void cancel();

    public boolean cancel(int i) {
        if (this.mItem.getInfo().getCallerId() != i) {
            return false;
        }
        String tag = getTag();
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "cancel#, callerId : ", " / type : ");
        sbM778t.append(this.mTaskType);
        sbM778t.append(" / path : ");
        sbM778t.append(DataLogger.getEncode(this.mItem.getPath()));
        DataLogger.m12307i(tag, sbM778t.toString());
        cancel();
        return true;
    }

    public abstract String getTag();

    public int getTaskType() {
        return this.mTaskType;
    }
}
