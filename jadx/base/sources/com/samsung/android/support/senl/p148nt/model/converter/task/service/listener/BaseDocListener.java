package com.samsung.android.support.senl.p148nt.model.converter.task.service.listener;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.IServiceRequestor;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseDocListener extends NotesDocumentCompletionListener<ISpenDocument> {
    public static final int SDOCX_CANCEL = 2;
    public static final int SDOCX_CLOSE = 3;
    public static final int SDOCX_OPEN = 0;
    public static final int SDOCX_SAVE = 1;
    protected IConvertInfo mInfo;
    protected IServiceRequestor.IServiceListener mListener;
    protected long mRequestTime = System.currentTimeMillis();
    protected long mResponseTime;
    protected String mSrcPath;
    protected long mTakenTime;

    public BaseDocListener(WConvertQueueItem wConvertQueueItem) {
        this.mInfo = wConvertQueueItem.getInfo();
        this.mSrcPath = wConvertQueueItem.getPath();
        this.mListener = wConvertQueueItem.getListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
    public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mResponseTime = jCurrentTimeMillis;
        this.mTakenTime = jCurrentTimeMillis - this.mRequestTime;
    }
}
