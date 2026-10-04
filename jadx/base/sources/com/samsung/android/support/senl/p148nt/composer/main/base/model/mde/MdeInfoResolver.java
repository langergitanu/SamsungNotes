package com.samsung.android.support.senl.p148nt.composer.main.base.model.mde;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.UserInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class MdeInfoResolver {
    private static final String TAG = Logger.createTag("MdeInfoResolver");
    private ICoeditDataResolver mCoeditDataResolver;
    private ICommonDataResolver mCommonDataResolver;
    private ConnectionCallback mConnectionCallback;
    private boolean mIsCoedit;
    private boolean mIsRequestedSessionConnection = false;
    private final AtomicBoolean mIsSessionConnected = new AtomicBoolean(false);
    private final SesUiListener mSesUiListener = new SesUiListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.1
        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onConnected() {
            Logger.m10999d(MdeInfoResolver.TAG, "onConnected#");
            MdeInfoResolver.this.mIsSessionConnected.set(true);
            if (MdeInfoResolver.this.mConnectionCallback != null) {
                MdeInfoResolver.this.mConnectionCallback.onConnected();
                MdeInfoResolver.this.mConnectionCallback = null;
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onDisConnected(int i) {
            AbstractC0000a.m3D(i, "onDisConnected# ", MdeInfoResolver.TAG);
            MdeInfoResolver.this.mIsSessionConnected.set(false);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback<T> {
        void onResult(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditCommonDataResolver implements ICommonDataResolver {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void deleteNote(Context context, String str, String str2) {
            RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().requestDeleteCoeditNote(str, str2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void getCreatorName(String str, String str2, String str3, String str4, final Callback<String> callback) {
            RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
            UserInfo coeditNoteUserInfo = companion.getInstance().getCoeditResolver().getCoeditNoteUserInfo(str3, str4);
            if (callback != null) {
                if (coeditNoteUserInfo == null || TextUtils.isEmpty(coeditNoteUserInfo.getCreatorName())) {
                    companion.getInstance().getCoeditResolver().updateWriterName(str, str2, new CoeditResolverContract.CoeditCallback<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.CoeditCommonDataResolver.1
                        @Override // com.samsung.android.support.senl.nt.base.common.sync.CoeditResolverContract.CoeditCallback
                        public void onResult(String str5) {
                            callback.onResult(str5);
                        }
                    });
                } else {
                    callback.onResult(coeditNoteUserInfo.getCreatorName());
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void requestConnectSessionAsync(SesUiListener sesUiListener) {
            RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().requestConnectSessionAsync(sesUiListener);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void requestDisConnectSessionAsync(SesUiListener sesUiListener) {
            RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().requestDisConnectSessionAsync(sesUiListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditDataResolverImpl implements ICoeditDataResolver {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public void deleteCoeditNoteDataAndDownload(Context context, String str, String str2) {
            RequestToSyncManager.INSTANCE.deleteCoeditDataAllAndDownload(context, str, str2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public void deleteSpace(String str, String str2) {
            RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().requestDeleteCoeditSpace(str, str2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public String getCurrentUserOwnerId() {
            return RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().getCurrentUserOwnerId();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public String getLeaderId(String str) {
            return RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().getLeaderId(str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public LiveData<List<CoeditResolverContract.MemberInfo>> getMemberListLiveData(Context context, String str) {
            return RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().getMemberListLiveData(context, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public String getSpaceName(Context context, String str) {
            return RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().getSpaceName(context, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public boolean isStandAlone(String str) {
            return RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().isStandaloneSpace(str).booleanValue();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public void leave(String str, String str2) {
            RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().requestLeaveCoeditSpace(str2, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConnectionCallback {
        void onConnected();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmptyCoeditDataResolver implements ICoeditDataResolver {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public void deleteCoeditNoteDataAndDownload(Context context, String str, String str2) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public void deleteSpace(String str, String str2) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public String getCurrentUserOwnerId() {
            return "";
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public String getLeaderId(String str) {
            return "";
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public LiveData<List<CoeditResolverContract.MemberInfo>> getMemberListLiveData(Context context, String str) {
            return null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public String getSpaceName(Context context, String str) {
            return "";
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public boolean isStandAlone(String str) {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICoeditDataResolver
        public void leave(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GscResolver implements ICommonDataResolver {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void deleteNote(Context context, String str, String str2) {
            RequestToSyncManager.INSTANCE.requestDelete(context, str, Arrays.asList(str2));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void getCreatorName(String str, String str2, String str3, String str4, final Callback<String> callback) {
            RequestToSyncManager.INSTANCE.getInstance().getGcsResolver().updateWriterName(str, str2, new GcsResolverContract.GcsCallback<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.GscResolver.1
                @Override // com.samsung.android.support.senl.nt.base.common.sync.GcsResolverContract.GcsCallback
                public void onResult(String str5) {
                    callback.onResult(str5);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void requestConnectSessionAsync(SesUiListener sesUiListener) {
            RequestToSyncManager.INSTANCE.getInstance().getGcsResolver().requestConnectSessionAsync(sesUiListener);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ICommonDataResolver
        public void requestDisConnectSessionAsync(SesUiListener sesUiListener) {
            RequestToSyncManager.INSTANCE.getInstance().getGcsResolver().requestDisConnectSessionAsync(sesUiListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICoeditDataResolver {
        void deleteCoeditNoteDataAndDownload(Context context, String str, String str2);

        void deleteSpace(String str, String str2);

        String getCurrentUserOwnerId();

        String getLeaderId(String str);

        LiveData<List<CoeditResolverContract.MemberInfo>> getMemberListLiveData(Context context, String str);

        String getSpaceName(Context context, String str);

        boolean isStandAlone(String str);

        void leave(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICommonDataResolver {
        void deleteNote(Context context, String str, String str2);

        void getCreatorName(String str, String str2, String str3, String str4, Callback<String> callback);

        void requestConnectSessionAsync(SesUiListener sesUiListener);

        void requestDisConnectSessionAsync(SesUiListener sesUiListener);
    }

    public void deleteCoeditNoteDataAndDownload(Context context, String str, String str2) {
        this.mCoeditDataResolver.deleteCoeditNoteDataAndDownload(context, str2, str);
    }

    public void deleteNote(Context context, String str, String str2) {
        this.mCommonDataResolver.deleteNote(context, str, str2);
    }

    public void deleteSpace(String str, String str2) {
        this.mCoeditDataResolver.deleteSpace(str, str2);
    }

    public void getCreatorName(String str, String str2, String str3, String str4, Callback<String> callback) {
        this.mCommonDataResolver.getCreatorName(str, str2, str3, str4, callback);
    }

    public String getCurrentUserOwnerId() {
        return this.mCoeditDataResolver.getCurrentUserOwnerId();
    }

    public String getLeaderId(String str) {
        return this.mCoeditDataResolver.getLeaderId(str);
    }

    public LiveData<List<CoeditResolverContract.MemberInfo>> getMemberListLiveData(Context context, String str) {
        return this.mCoeditDataResolver.getMemberListLiveData(context, str);
    }

    public String getSpaceName(Context context, String str) {
        return this.mCoeditDataResolver.getSpaceName(context, str);
    }

    public void init(boolean z) {
        if (this.mCommonDataResolver == null || this.mIsCoedit != z) {
            this.mIsCoedit = z;
            if (z) {
                this.mCommonDataResolver = new CoeditCommonDataResolver();
                this.mCoeditDataResolver = new CoeditDataResolverImpl();
            } else {
                this.mCommonDataResolver = new GscResolver();
                this.mCoeditDataResolver = new EmptyCoeditDataResolver();
            }
        }
    }

    public boolean isSessionConnected() {
        return this.mIsSessionConnected.get();
    }

    public boolean isStandAlone(String str) {
        return this.mCoeditDataResolver.isStandAlone(str);
    }

    public void leave(String str, String str2) {
        this.mCoeditDataResolver.leave(str, str2);
    }

    public void requestConnectSessionAsync() {
        requestConnectSessionAsync(null);
    }

    public void requestDisConnectSessionAsync() {
        if (this.mIsRequestedSessionConnection) {
            this.mCommonDataResolver.requestDisConnectSessionAsync(this.mSesUiListener);
            this.mIsRequestedSessionConnection = false;
            this.mIsSessionConnected.set(false);
        }
    }

    public void requestConnectSessionAsync(ConnectionCallback connectionCallback) {
        if (this.mConnectionCallback == null && connectionCallback != null) {
            this.mConnectionCallback = connectionCallback;
        }
        if (this.mIsRequestedSessionConnection) {
            return;
        }
        this.mIsRequestedSessionConnection = true;
        this.mCommonDataResolver.requestConnectSessionAsync(this.mSesUiListener);
    }
}
