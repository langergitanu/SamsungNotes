package com.samsung.android.sdk.mobileservice.social.share;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.social.IMobileServiceSocial;
import com.samsung.android.sdk.mobileservice.social.share.IShareStatusCallback;
import com.samsung.android.sdk.mobileservice.util.SdkLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareController {
    public static final int SHARE_COMPLETE = 2;
    public static final int SHARE_IN_PROGRESS = 100;
    public static final int SHARE_NONE = -1;
    public static final int SHARE_PAUSED = 1;
    private static final String TAG = "ShareController";
    private final ShareControllerApiPicker mApi;
    private ShareStatusListener mListener;
    private String mRequestId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ShareControllerApiPicker {
        String getAppId();

        String getReference();

        IMobileServiceSocial getSocialService();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ShareStatusListener {
        void onComplete(ShareSnapshot shareSnapshot);

        void onPause(ShareSnapshot shareSnapshot);

        void onResume(ShareSnapshot shareSnapshot);
    }

    public ShareController(ShareControllerApiPicker shareControllerApiPicker, String str) {
        SdkLog.m5782d(TAG, "ShareController " + shareControllerApiPicker.getReference());
        this.mApi = shareControllerApiPicker;
        this.mRequestId = str;
    }

    @Deprecated
    public int cancel() {
        SdkLog.m5782d(TAG, "cancel : mRequestId=[" + this.mRequestId + "] " + SdkLog.getReference(this.mListener));
        if (this.mApi.getAppId() == null) {
            SdkLog.m5782d(TAG, "app id is null " + this.mApi.getReference());
            return -1;
        }
        try {
            this.mApi.getSocialService().cancelShare(this.mApi.getAppId(), this.mRequestId);
            return 1;
        } catch (RemoteException e) {
            SdkLog.m5785s(e);
            return -1;
        } catch (NotConnectedException e2) {
            SdkLog.m5785s(e2);
            return -8;
        }
    }

    @Deprecated
    public int getStatus() {
        if (this.mApi.getAppId() == null) {
            SdkLog.m5782d(TAG, "app id is null " + this.mApi.getReference());
            return -1;
        }
        try {
            int shareStatus = this.mApi.getSocialService().getShareStatus(this.mApi.getAppId(), this.mRequestId);
            StringBuilder sbM778t = AbstractC0541b.m778t(shareStatus, "getStatus : status=[", "], mRequestId=[");
            sbM778t.append(this.mRequestId);
            sbM778t.append("] ");
            sbM778t.append(SdkLog.getReference(this.mListener));
            SdkLog.m5782d(TAG, sbM778t.toString());
            return shareStatus;
        } catch (RemoteException e) {
            SdkLog.m5785s(e);
            return -1;
        } catch (NotConnectedException e2) {
            SdkLog.m5785s(e2);
            return -8;
        }
    }

    @Deprecated
    public int pause() {
        SdkLog.m5782d(TAG, "pause : mRequestId=[" + this.mRequestId + "] " + SdkLog.getReference(this.mListener));
        if (this.mApi.getAppId() == null) {
            SdkLog.m5782d(TAG, "app id is null " + this.mApi.getReference());
            return -1;
        }
        try {
            this.mApi.getSocialService().pauseShare(this.mApi.getAppId(), this.mRequestId);
            return 1;
        } catch (RemoteException e) {
            SdkLog.m5785s(e);
            return -1;
        } catch (NotConnectedException e2) {
            SdkLog.m5785s(e2);
            return -8;
        }
    }

    @Deprecated
    public int resume() {
        SdkLog.m5782d(TAG, "resume : mRequestId=[" + this.mRequestId + "] " + SdkLog.getReference(this.mListener));
        if (this.mApi.getAppId() == null) {
            SdkLog.m5782d(TAG, "app id is null " + this.mApi.getReference());
            return -1;
        }
        try {
            this.mApi.getSocialService().resumeShare(this.mApi.getAppId(), this.mRequestId);
            return 1;
        } catch (RemoteException e) {
            SdkLog.m5785s(e);
            return -1;
        } catch (NotConnectedException e2) {
            SdkLog.m5785s(e2);
            return -8;
        }
    }

    @Deprecated
    public int setShareStatusListener(ShareStatusListener shareStatusListener) {
        SdkLog.m5782d(TAG, "setShareStatusListener : mRequestId=[" + this.mRequestId + "] " + SdkLog.getReference(this.mListener));
        if (this.mApi.getAppId() == null) {
            SdkLog.m5782d(TAG, "app id is null " + this.mApi.getReference());
            return -1;
        }
        if (shareStatusListener == null || this.mListener != null) {
            this.mListener = shareStatusListener;
            return 1;
        }
        IShareStatusCallback.Stub stub = new IShareStatusCallback.Stub() { // from class: com.samsung.android.sdk.mobileservice.social.share.ShareController.1
            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareStatusCallback
            public void onComplete(Bundle bundle) {
                SdkLog.m5782d(ShareController.TAG, "setShareStatusListener onComplete : mRequestId=[" + ShareController.this.mRequestId + "] " + SdkLog.getReference(ShareController.this.mListener));
                if (ShareController.this.mListener != null) {
                    ShareController.this.mListener.onComplete(new ShareSnapshot(bundle.getLong(BundleKey.totalBytes, 0L), bundle.getLong(BundleKey.totalBytesTransferred, 0L), bundle.getInt(BundleKey.totalFileCount, 0), bundle.getInt(BundleKey.totalFileCountTransferred, 0), bundle.getLong(BundleKey.currentFileBytes, 0L), bundle.getLong(BundleKey.currentFileBytesTransferred, 0L), bundle.getInt(BundleKey.currentFileIndex, 0)));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareStatusCallback
            public void onPause(Bundle bundle) {
                SdkLog.m5782d(ShareController.TAG, "setShareStatusListener onPause : mRequestId=[" + ShareController.this.mRequestId + "] " + SdkLog.getReference(ShareController.this.mListener));
                if (ShareController.this.mListener != null) {
                    ShareController.this.mListener.onPause(new ShareSnapshot(bundle.getLong(BundleKey.totalBytes, 0L), bundle.getLong(BundleKey.totalBytesTransferred, 0L), bundle.getInt(BundleKey.totalFileCount, 0), bundle.getInt(BundleKey.totalFileCountTransferred, 0), bundle.getLong(BundleKey.currentFileBytes, 0L), bundle.getLong(BundleKey.currentFileBytesTransferred, 0L), bundle.getInt(BundleKey.currentFileIndex, 0)));
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.social.share.IShareStatusCallback
            public void onResume(Bundle bundle) {
                SdkLog.m5782d(ShareController.TAG, "setShareStatusListener onResume : mRequestId=[" + ShareController.this.mRequestId + "] " + SdkLog.getReference(ShareController.this.mListener));
                if (ShareController.this.mListener != null) {
                    ShareController.this.mListener.onResume(new ShareSnapshot(bundle.getLong(BundleKey.totalBytes, 0L), bundle.getLong(BundleKey.totalBytesTransferred, 0L), bundle.getInt(BundleKey.totalFileCount, 0), bundle.getInt(BundleKey.totalFileCountTransferred, 0), bundle.getLong(BundleKey.currentFileBytes, 0L), bundle.getLong(BundleKey.currentFileBytesTransferred, 0L), bundle.getInt(BundleKey.currentFileIndex, 0)));
                }
            }
        };
        this.mListener = shareStatusListener;
        try {
            this.mApi.getSocialService().setShareStatusListener(this.mApi.getAppId(), this.mRequestId, stub);
            return 1;
        } catch (RemoteException e) {
            SdkLog.m5785s(e);
            return -1;
        } catch (NotConnectedException e2) {
            SdkLog.m5785s(e2);
            return -8;
        }
    }
}
