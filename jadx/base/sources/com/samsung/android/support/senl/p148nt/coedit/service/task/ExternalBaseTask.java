package com.samsung.android.support.senl.p148nt.coedit.service.task;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ExternalBaseTask implements Runnable {
    protected UpDownloadCallback mCallback;
    protected final Context mContext;
    protected Contract mContract;
    protected final String mGroupId;
    protected final String mUuid;
    protected final String mWorkspaceId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void releaseHandler(String str, String str2, @Nullable Runnable runnable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ExternalBaseCallback implements ExternalControlCallback {
        final UpDownloadCallback callback;
        Contract contract;

        public ExternalBaseCallback(UpDownloadCallback upDownloadCallback, Contract contract) {
            this.callback = upDownloadCallback;
            this.contract = contract;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface UpDownloadCallback {
        void onCompleted();

        void onError(int i);
    }

    public ExternalBaseTask(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull UpDownloadCallback upDownloadCallback) {
        this.mContext = context;
        this.mUuid = str;
        this.mGroupId = str2;
        this.mWorkspaceId = str3;
        this.mCallback = upDownloadCallback;
    }

    public void closeDoc(String str, @Nullable SpenWNote spenWNote, String str2) {
        try {
            CoeditLogger.m8923i(getTag(), "closeDoc: " + str2);
            DocumentFileManager.getInstance().close(str, spenWNote, true);
        } catch (IOException e) {
            String tag = getTag();
            StringBuilder sbM15l = AbstractC0000a.m15l("closeDoc: ", str2, ", fail to close doc, e : ");
            sbM15l.append(e.getMessage());
            CoeditLogger.m8920e(tag, sbM15l.toString());
        }
    }

    public abstract void execute();

    public int getSnapResult(String str) {
        if (CoeditServiceConstants.SnapError.UPLOAD_FAIL_LARGE_XML_SIZE.equals(str)) {
            return 205;
        }
        if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning()) {
            return 204;
        }
        return !CoeditUtils.isCoeditDataNetworkAvailable() ? 203 : 202;
    }

    public abstract String getTag();

    public void release() {
        this.mContract = null;
        this.mCallback = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        execute();
        release();
    }

    public ExternalBaseTask setContract(@NonNull Contract contract) {
        this.mContract = contract;
        return this;
    }
}
