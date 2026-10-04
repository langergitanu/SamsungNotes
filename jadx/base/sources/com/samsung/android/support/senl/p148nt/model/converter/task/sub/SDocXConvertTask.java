package com.samsung.android.support.senl.p148nt.model.converter.task.sub;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.IServiceRequestor;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.ServiceMsg;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask;
import com.samsung.android.support.senl.p148nt.model.converter.utils.ConvertingUtils;
import com.samsung.android.support.senl.p148nt.model.domain.note.DeleteNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SDocXConvertTask extends AbsConvertSubTask<ISDocXConvertTaskCallback> {
    private static final String TAG = ModelLogger.createConverterTag("SDocXConvertTask");
    private final List<String> mDstPathList;
    private final List<String> mDstUuidList;
    private boolean mIsSrcFileStoredInDB;
    private final IServiceRequestor.IServiceListener mListener;
    private final List<String> mSrcPathList;
    private String mSrcUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISDocXConvertTaskCallback extends IConvertSubTask.ISubTaskCallback {
        void convertDocument(List<String> list, long j, IServiceRequestor.IServiceListener iServiceListener);
    }

    public SDocXConvertTask(ISDocXConvertTaskCallback iSDocXConvertTaskCallback) {
        super(8, 9, iSDocXConvertTaskCallback);
        this.mSrcPathList = new LinkedList();
        this.mDstPathList = new ArrayList();
        this.mDstUuidList = new ArrayList();
        this.mIsSrcFileStoredInDB = true;
        this.mListener = new IServiceRequestor.IServiceListener() { // from class: com.samsung.android.support.senl.nt.model.converter.task.sub.SDocXConvertTask.1
            private int mSuccessCount = 0;
            private int mFailedCount = 0;

            private void deleteSrcFile(ServiceMsg serviceMsg, boolean z) {
                Context applicationContext;
                if (!SDocXConvertTask.this.mIsSrcFileStoredInDB) {
                    FileUtils.deleteFile(serviceMsg.getSrcPath());
                    return;
                }
                if (!FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING || !z || TextUtils.isEmpty(SDocXConvertTask.this.mSrcUuid) || SDocXConvertTask.this.isOldNoteInTrash(serviceMsg.getDstPath()) || serviceMsg.isContentEmpty() || (applicationContext = BaseUtils.getApplicationContext()) == null) {
                    return;
                }
                new DeleteNoteUseCase().invoke(new DeleteNoteUseCase.Param(applicationContext, Collections.singletonList(SDocXConvertTask.this.mSrcUuid), 0, 1, SDocXConvertTask.TAG));
            }

            private void onEnd() {
                if (SDocXConvertTask.this.mSrcPathList.size() == this.mSuccessCount + this.mFailedCount) {
                    SDocXConvertTask.this.postConvert();
                }
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.service.listener.IServiceRequestor.IServiceListener
            public void onFailed(int i, ServiceMsg serviceMsg) {
                this.mFailedCount++;
                if (i != 3) {
                    deleteSrcFile(serviceMsg, false);
                }
                if (!serviceMsg.isMemoryAvailable()) {
                    SDocXConvertTask.this.mTaskResult.setState(6);
                }
                onEnd();
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.service.listener.IServiceRequestor.IServiceListener
            public void onSuccess(int i, ServiceMsg serviceMsg) {
                if (i == 3) {
                    onEnd();
                    return;
                }
                if (i != 1) {
                    if (i == 2) {
                        this.mSuccessCount++;
                        deleteSrcFile(serviceMsg, false);
                        onEnd();
                        return;
                    }
                    return;
                }
                DataLogger.m12307i(SDocXConvertTask.TAG, "onSuccess - src : + " + DataLogger.getEncode(serviceMsg.getSrcPath()) + " >>> dst : " + DataLogger.getEncode(serviceMsg.getDstPath()));
                this.mSuccessCount = this.mSuccessCount + 1;
                SDocXConvertTask.this.mDstUuidList.add(serviceMsg.getUuid());
                SDocXConvertTask.this.mDstPathList.add(serviceMsg.getDstPath());
                deleteSrcFile(serviceMsg, true);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOldNoteInTrash(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = File.separator;
        sb.append(str2);
        sb.append("converted");
        sb.append(str2);
        return str.contains(sb.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask
    public long getSrcSize() {
        Context applicationContext = BaseUtils.getApplicationContext();
        long j = 0;
        if (applicationContext == null) {
            DataLogger.m12303e(TAG, "getSrcSize, context is null");
        } else {
            Iterator<String> it = this.mSrcPathList.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                long targetFileSize = getTargetFileSize(applicationContext, it.next());
                if (targetFileSize > 0) {
                    j2 += targetFileSize;
                }
            }
            j = j2;
        }
        DataLogger.m12307i(TAG, "getSrcSize, totalSize = " + j);
        return j;
    }

    public long getTargetFileSize(@NonNull Context context, String str) {
        return ConvertingUtils.getUncompressedSDocSize(context, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask
    public void postConvert() {
        this.mTaskResult.setUuidList(this.mDstUuidList);
        this.mTaskResult.setPathList(this.mDstPathList);
        super.postConvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask, java.lang.Runnable
    public void run() {
        preConvert();
        ((ISDocXConvertTaskCallback) this.mCallback).convertDocument(this.mSrcPathList, ConvertingUtils.getRequiredSizeForConverting(getSrcSize()), this.mListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask, com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask
    public void setParams(IConvertSubTask.IConvertParams iConvertParams) {
        this.mSrcPathList.addAll(iConvertParams.getPathList());
        this.mIsSrcFileStoredInDB = iConvertParams.isSrcFileStoredInDB();
    }

    public SDocXConvertTask(String str, String str2, ISDocXConvertTaskCallback iSDocXConvertTaskCallback) {
        this(iSDocXConvertTaskCallback);
        this.mSrcUuid = str;
        this.mSrcPathList.add(str2);
    }

    public SDocXConvertTask(int i, String str, ISDocXConvertTaskCallback iSDocXConvertTaskCallback) {
        super(i, 9, iSDocXConvertTaskCallback);
        LinkedList linkedList = new LinkedList();
        this.mSrcPathList = linkedList;
        this.mDstPathList = new ArrayList();
        this.mDstUuidList = new ArrayList();
        this.mIsSrcFileStoredInDB = true;
        this.mListener = new IServiceRequestor.IServiceListener() { // from class: com.samsung.android.support.senl.nt.model.converter.task.sub.SDocXConvertTask.1
            private int mSuccessCount = 0;
            private int mFailedCount = 0;

            private void deleteSrcFile(ServiceMsg serviceMsg, boolean z) {
                Context applicationContext;
                if (!SDocXConvertTask.this.mIsSrcFileStoredInDB) {
                    FileUtils.deleteFile(serviceMsg.getSrcPath());
                    return;
                }
                if (!FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING || !z || TextUtils.isEmpty(SDocXConvertTask.this.mSrcUuid) || SDocXConvertTask.this.isOldNoteInTrash(serviceMsg.getDstPath()) || serviceMsg.isContentEmpty() || (applicationContext = BaseUtils.getApplicationContext()) == null) {
                    return;
                }
                new DeleteNoteUseCase().invoke(new DeleteNoteUseCase.Param(applicationContext, Collections.singletonList(SDocXConvertTask.this.mSrcUuid), 0, 1, SDocXConvertTask.TAG));
            }

            private void onEnd() {
                if (SDocXConvertTask.this.mSrcPathList.size() == this.mSuccessCount + this.mFailedCount) {
                    SDocXConvertTask.this.postConvert();
                }
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.service.listener.IServiceRequestor.IServiceListener
            public void onFailed(int i2, ServiceMsg serviceMsg) {
                this.mFailedCount++;
                if (i2 != 3) {
                    deleteSrcFile(serviceMsg, false);
                }
                if (!serviceMsg.isMemoryAvailable()) {
                    SDocXConvertTask.this.mTaskResult.setState(6);
                }
                onEnd();
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.service.listener.IServiceRequestor.IServiceListener
            public void onSuccess(int i2, ServiceMsg serviceMsg) {
                if (i2 == 3) {
                    onEnd();
                    return;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.mSuccessCount++;
                        deleteSrcFile(serviceMsg, false);
                        onEnd();
                        return;
                    }
                    return;
                }
                DataLogger.m12307i(SDocXConvertTask.TAG, "onSuccess - src : + " + DataLogger.getEncode(serviceMsg.getSrcPath()) + " >>> dst : " + DataLogger.getEncode(serviceMsg.getDstPath()));
                this.mSuccessCount = this.mSuccessCount + 1;
                SDocXConvertTask.this.mDstUuidList.add(serviceMsg.getUuid());
                SDocXConvertTask.this.mDstPathList.add(serviceMsg.getDstPath());
                deleteSrcFile(serviceMsg, true);
            }
        };
        linkedList.add(str);
    }
}
