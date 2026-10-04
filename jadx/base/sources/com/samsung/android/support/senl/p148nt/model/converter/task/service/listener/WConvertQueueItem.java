package com.samsung.android.support.senl.p148nt.model.converter.task.service.listener;

import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.IServiceRequestor;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WConvertQueueItem {
    private IConvertInfo mInfo;
    private final IServiceRequestor.IServiceListener mListener;
    private final String mPath;
    private NotesDocument<ISpenDocument> mState;

    public WConvertQueueItem(String str, IServiceRequestor.IServiceListener iServiceListener) {
        this.mPath = str;
        this.mListener = iServiceListener;
    }

    public IConvertInfo getInfo() {
        return this.mInfo;
    }

    public IServiceRequestor.IServiceListener getListener() {
        return this.mListener;
    }

    public String getPath() {
        return this.mPath;
    }

    public NotesDocument<ISpenDocument> getState() {
        return this.mState;
    }

    public WConvertQueueItem(String str, IServiceRequestor.IServiceListener iServiceListener, IConvertInfo iConvertInfo) {
        this(str, iServiceListener);
        this.mInfo = iConvertInfo;
    }

    public WConvertQueueItem(String str, IServiceRequestor.IServiceListener iServiceListener, IConvertInfo iConvertInfo, NotesDocument<ISpenDocument> notesDocument) {
        this(str, iServiceListener, iConvertInfo);
        this.mState = notesDocument;
    }
}
