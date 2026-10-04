package com.samsung.android.support.senl.p148nt.model.converter.task.service.listener;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CancelListener extends BaseDocListener {
    private static final String TAG = ModelLogger.createConverterTag("CancelListener");

    public CancelListener(WConvertQueueItem wConvertQueueItem) {
        super(wConvertQueueItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.BaseDocListener, com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
    public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
        super.completed(notesDocument, str);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("cancel completed : ");
        AbstractC11014a.m12336u(this.mSrcPath, sb, " ");
        sb.append(this.mTakenTime);
        sb.append("ms");
        DataLogger.m12307i(str2, sb.toString());
        this.mListener.onSuccess(2, new ServiceMsg(this.mSrcPath));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public void failed(Throwable th, String str) {
        DataLogger.m12302d(TAG, "cancel failed : " + DataLogger.getEncode(this.mSrcPath) + "," + th.getMessage());
        this.mListener.onFailed(2, new ServiceMsg(this.mSrcPath));
    }
}
