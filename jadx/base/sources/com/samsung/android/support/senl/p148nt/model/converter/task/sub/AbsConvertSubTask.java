package com.samsung.android.support.senl.p148nt.model.converter.task.sub;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.nt.model.converter.task.sub.IConvertSubTask.ISubTaskCallback;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskResult;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsConvertSubTask<T extends IConvertSubTask.ISubTaskCallback> implements IConvertSubTask {
    T mCallback;
    private final int mDstType;
    private final int mSrcType;
    ConvertTaskResult mTaskResult;

    public AbsConvertSubTask(int i, int i2, T t) {
        this.mSrcType = i;
        this.mDstType = i2;
        this.mTaskResult = new ConvertTaskResult(i, i2);
        this.mCallback = t;
    }

    public abstract long getSrcSize();

    public void postConvert() {
        T t = this.mCallback;
        if (t != null) {
            t.onPostConvert(this.mTaskResult);
        }
    }

    public void preConvert() {
        T t = this.mCallback;
        if (t != null) {
            t.onPreConvert(this.mTaskResult);
        }
    }

    @Override // java.lang.Runnable
    public abstract void run();

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask
    public abstract void setParams(IConvertSubTask.IConvertParams iConvertParams);

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask
    @NonNull
    public String toString() {
        return this.mSrcType + " -> " + this.mDstType;
    }
}
