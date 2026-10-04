package com.samsung.android.support.senl.p148nt.coedit.control.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.ntnl.coedit.CoeditManager;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.CancelRequest;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.GetJwtItem;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudGetJwt;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudServerConstants;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudJwtManager {
    private static final String TAG = "NT/SCloudJwtManager";
    private static SCloudJwtManager mInstance;
    private String mAccessToken;
    private String mAuthorization;
    private String mErrorCodeForAccessToken;
    private String mErrorMsgForAccessToken;
    private final ExecutorService mExecutor = AbstractC4539a.m3201k(TAG);
    private String mUserId;

    private SCloudJwtManager() {
    }

    private GetJwtItem checkValidPreCondition(String str) {
        if (TextUtils.isEmpty(str)) {
            CoeditLogger.m8920e(TAG, "[CS3-2] isValidPreCondition() : groupId is empty!");
            return new GetJwtItem(10);
        }
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            CoeditLogger.m8920e(TAG, "[CS3-2] isValidPreCondition() : DataNetwork is not available!");
            return new GetJwtItem(11);
        }
        handleAccessToken();
        if (ErrorCodeConvertor.AUTH_TOKEN_EXPIRED.equals(this.mErrorCodeForAccessToken)) {
            CoeditLogger.m8920e(TAG, "[CS3-2] isValidPreCondition() : " + this.mErrorMsgForAccessToken + " <- Need to log in SA again!");
            return new GetJwtItem(13);
        }
        if (TextUtils.isEmpty(this.mAccessToken) || TextUtils.isEmpty(this.mUserId)) {
            CoeditLogger.m8920e(TAG, "[CS3-2] isValidPreCondition() : Access Token is not available!");
            return new GetJwtItem(12);
        }
        String authorizationSync = RequestToSCloudManager.INSTANCE.getInstance().getAuthorizationSync(this.mAccessToken, this.mUserId);
        this.mAuthorization = authorizationSync;
        if (!TextUtils.isEmpty(authorizationSync)) {
            return null;
        }
        CoeditLogger.m8920e(TAG, "[CS3-2] isValidPreCondition() : Authorization is not available!");
        return new GetJwtItem(14);
    }

    public static synchronized SCloudJwtManager getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new SCloudJwtManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private static String getJson(String str) {
        return new String(Base64.decode(str, 8), StandardCharsets.UTF_8);
    }

    private String getWorkSpaceId(String str) {
        try {
            return new JSONObject(getJson(str.split(RemoteConstant.VERSION_DIVIDE)[1])).getString(SCloudServerConstants.WORKSPACEID_PARM);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("[CS3-2] Failed to getWorkSpaceId : "), TAG);
            return null;
        }
    }

    private void handleAccessToken() {
        this.mAccessToken = null;
        this.mUserId = null;
        this.mErrorCodeForAccessToken = null;
        this.mErrorMsgForAccessToken = null;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        RequestToSamsungAccountManager.INSTANCE.requestAuthInfo(new IAuthInfoReqListener() { // from class: com.samsung.android.support.senl.nt.coedit.control.util.SCloudJwtManager.2
            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
            public void onError(String str, String str2) {
                CoeditLogger.m8920e(SCloudJwtManager.TAG, "[CS3-2] requestAuthInfo fail : errCode = " + str2 + " , errMsg = " + str2);
                SCloudJwtManager.this.mErrorCodeForAccessToken = str;
                SCloudJwtManager.this.mErrorMsgForAccessToken = str2;
                countDownLatch.countDown();
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
            public void onReceived(String str, String str2) {
                CoeditLogger.m8923i(SCloudJwtManager.TAG, "[CS3-1] requestAuthInfo onReceived()");
                SCloudJwtManager.this.mAccessToken = str;
                SCloudJwtManager.this.mUserId = str2;
                countDownLatch.countDown();
            }
        });
        try {
            if (Thread.currentThread().isInterrupted() || countDownLatch.await(30L, TimeUnit.SECONDS)) {
                return;
            }
            CoeditLogger.m8920e(TAG, "[CS3-2] requestAuthInfo fail to await");
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(TAG, "[CS3-2] requestAuthInfo fail : InterruptedException = " + e.getMessage());
        }
    }

    private void handleWorkSpaceId(String str, String str2) {
        if (TextUtils.isEmpty(new NoteDbResolver(str).getWorkspaceId())) {
            String workSpaceId = getWorkSpaceId(str2);
            if (TextUtils.isEmpty(workSpaceId)) {
                CoeditLogger.m8920e(TAG, "[CS3-2] handleWorkSpaceId() : fail to get workSpaceId!");
            } else {
                AbstractC8014b.m7223y("[CS3-1] handleWorkSpaceId() : ", workSpaceId, TAG);
            }
        }
    }

    @SuppressLint({WarningType.NewApi})
    public GetJwtItem getJWT(String str, String str2, String str3, CancelRequest cancelRequest) {
        final SCloudGetJwt sCloudGetJwt;
        CoeditLogger.m8923i(TAG, "[CS3] getJWT()");
        GetJwtItem getJwtItemCheckValidPreCondition = checkValidPreCondition(str2);
        if (getJwtItemCheckValidPreCondition != null) {
            return getJwtItemCheckValidPreCondition;
        }
        if (TextUtils.isEmpty(str3)) {
            CoeditLogger.m8923i(TAG, "[CS3] getJWT() : No workSpaceId");
            sCloudGetJwt = new SCloudGetJwt(this.mAuthorization, str, str2);
        } else {
            sCloudGetJwt = new SCloudGetJwt(this.mAuthorization, str, str3, str2);
        }
        final CompletableFuture<Object> completableFuture = new CompletableFuture<>();
        if (cancelRequest == null) {
            cancelRequest = new CancelRequest();
        }
        cancelRequest.setFuture(completableFuture);
        this.mExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.util.SCloudJwtManager.1
            @Override // java.lang.Runnable
            public void run() {
                completableFuture.complete(sCloudGetJwt.perform());
            }
        });
        try {
            try {
                try {
                    try {
                        Object obj = cancelRequest.get(30L, TimeUnit.SECONDS);
                        if (obj != null) {
                            getJwtItemCheckValidPreCondition = (GetJwtItem) obj;
                        }
                        if (getJwtItemCheckValidPreCondition == null) {
                            getJwtItemCheckValidPreCondition = new GetJwtItem(20);
                        }
                    } catch (TimeoutException e) {
                        CoeditLogger.m8920e(TAG, "[CS3-2] getJWT() TimeoutException: fail to getJwtItem!" + e);
                        if (getJwtItemCheckValidPreCondition == null) {
                            getJwtItemCheckValidPreCondition = new GetJwtItem(20);
                        }
                    }
                } catch (ExecutionException e2) {
                    CoeditLogger.m8920e(TAG, "[CS3-2] getJWT() ExecutionException: fail to getJwtItem!" + e2);
                    if (getJwtItemCheckValidPreCondition == null) {
                        getJwtItemCheckValidPreCondition = new GetJwtItem(20);
                    }
                }
            } catch (InterruptedException e3) {
                CoeditLogger.m8920e(TAG, "[CS3-2] getJWT() InterruptedException: fail to getJwtItem!" + e3);
                if (getJwtItemCheckValidPreCondition == null) {
                    getJwtItemCheckValidPreCondition = new GetJwtItem(20);
                }
            } catch (CancellationException e5) {
                CoeditLogger.m8920e(TAG, "[CS3-2] getJWT() CancellationException: fail to getJwtItem!" + e5);
                if (getJwtItemCheckValidPreCondition == null) {
                    getJwtItemCheckValidPreCondition = new GetJwtItem(20);
                }
            }
            if (getJwtItemCheckValidPreCondition.isError()) {
                CoeditLogger.m8920e(TAG, "[CS3-2] getJWT() : fail to getJwtItem!");
                return getJwtItemCheckValidPreCondition;
            }
            CoeditLogger.m8919d(TAG, "[CS3-1] getJWT() : succeed to getJwtItem");
            handleWorkSpaceId(str, getJwtItemCheckValidPreCondition.getJwt());
            return getJwtItemCheckValidPreCondition;
        } catch (Throwable th) {
            if (getJwtItemCheckValidPreCondition == null) {
                new GetJwtItem(20);
            }
            throw th;
        }
    }

    public int getJwtMode(String str) {
        return TextUtils.isEmpty(new NoteDbResolver(str).getWorkspaceId()) ? CoeditManager.MODE_UPLOAD : CoeditManager.MODE_DOWNLOAD;
    }
}
