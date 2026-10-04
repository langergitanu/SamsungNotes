package com.samsung.android.support.senl.p148nt.coedit.control;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ICoeditHandler {
    public static final int STATE_CLOSED = 7;
    public static final int STATE_CLOSING = 6;
    public static final int STATE_INIT = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_RUNNING = 5;
    public static final int STATE_SNAP_DELAYED = 3;
    public static final int STATE_SNAP_END = 4;
    public static final int STATE_SNAP_RUNNING = 2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComposerContract {
        boolean canShowProgress();

        String getWorkspaceId();

        int getXmlDataWeight();

        void hideInitProgress(String str);

        boolean hideProgress(String str);

        boolean isCoeditUpdateListenerNonNull();

        boolean isDeleteOnlyMode();

        boolean isEditMode();

        boolean isEditModeWithReadOnly();

        boolean isFixedReadPermission();

        void onClickCloseComposer();

        void onEditorUpdate(String str, String str2);

        void onListUpdate(List<CoeditDeviceInfo> list);

        void requestReopen(String str, boolean z, String str2);

        void requestSaveToDevice(@StringRes int i);

        void setDeleteOnlyMode(boolean z);

        void setFixedReadPermission(boolean z, String str);

        void setRequestUpdate(boolean z);

        boolean showProgress(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HandlerMangeContract {
        void initUiThreadHandler(String str);

        boolean isMaxCounted(String str, long j, String str2);

        void releaseUiThreadHandler(String str);

        void runOnUIThread(Runnable runnable, String str);

        void runOnWorkerThread(Runnable runnable, String str);

        void runOnWorkerThread(Runnable runnable, String str, int i);
    }

    void checkDeleteOnlyMode();

    void externalChannelOpen(SpenWNote spenWNote, String str, String str2, ExternalControlCallback externalControlCallback);

    void externalSnapDownload(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback);

    void externalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback);

    void externalSnapUpload(SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback);

    int getState();

    CoeditConstants.User getUser();

    String getUuid();

    void initialize(String str);

    void internalChannelOpen(Activity activity, SpenWNote spenWNote, String str, String str2, CoeditControlCallback coeditControlCallback);

    void internalSnapRefresh();

    void internalSnapRestart(String str, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback);

    void internalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, SnapControlCallback snapControlCallback, ComposerContract composerContract);

    boolean isClosingState();

    boolean isInitializing();

    boolean isSnapEndState();

    boolean isWritePermissionGranted();

    int pauseConcurrency(String str);

    int pauseConcurrency(String str, Runnable runnable);

    void release(Runnable runnable, Runnable runnable2, String str);

    void requestReadPermission();

    int resumeConcurrency(String str);

    void saveCoeditCache();

    void setCancelled();
}
