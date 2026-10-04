package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.ScrapbookScloudSync;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ScrapbookCloudImportHelper extends ImportHelper implements IAuthInfoReqListener {
    private static final String TAG = "ScrapbookCloudImportHelper";

    public ScrapbookCloudImportHelper(Context context) {
        super(context, DocTypeConstants.MEMO_SCLOUD, true);
        setAccountListener(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onError(String str, String str2) {
        synchronized (this) {
            try {
                switch (str.hashCode()) {
                    case -1810065010:
                        if (!str.equals(ErrorCodeConvertor.NETWORK_NOT_AVAILABLE)) {
                            onImportError(this.mType, 106, "errCode = " + str + " errMsg = " + str2, null);
                        }
                        break;
                    case -1810065009:
                        if (str.equals(ErrorCodeConvertor.SSL_CONNECTION_ERROR)) {
                        }
                        onImportError(this.mType, 106, "errCode = " + str + " errMsg = " + str2, null);
                        break;
                    default:
                        onImportError(this.mType, 106, "errCode = " + str + " errMsg = " + str2, null);
                        break;
                }
                onImportError(this.mType, 101, "errCode = " + str + " errMsg = " + str2, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onReceived(String str, String str2) {
        Debugger.m8615i(TAG, "onReceived()");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C14433b.m15033p(this.mContext).m15038n(str, str2, new IAuthorizationListener() { // from class: com.samsung.android.app.notes.sync.importing.core.ScrapbookCloudImportHelper.1
                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
                public void onError(String str3, String str4) {
                    ScrapbookCloudImportHelper scrapbookCloudImportHelper = ScrapbookCloudImportHelper.this;
                    scrapbookCloudImportHelper.onImportError(scrapbookCloudImportHelper.mType, 122, AbstractC0541b.m774p("errCode = ", str3, " errMsg = ", str4), null);
                }

                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
                public void onReceived(String str3) {
                    synchronized (ScrapbookCloudImportHelper.this) {
                        try {
                            ScrapbookCloudImportHelper scrapbookCloudImportHelper = ScrapbookCloudImportHelper.this;
                            int i = scrapbookCloudImportHelper.mRequestType;
                            if (i == 1) {
                                ScrapbookCloudImportHelper scrapbookCloudImportHelper2 = ScrapbookCloudImportHelper.this;
                                scrapbookCloudImportHelper.mSync = new ScrapbookScloudSync(scrapbookCloudImportHelper2.mContext, str3, scrapbookCloudImportHelper2, 2);
                            } else {
                                if (i != 2) {
                                    scrapbookCloudImportHelper.mSync = null;
                                    throw new UnsupportedOperationException();
                                }
                                ScrapbookCloudImportHelper scrapbookCloudImportHelper3 = ScrapbookCloudImportHelper.this;
                                scrapbookCloudImportHelper.mSync = new ScrapbookScloudSync(scrapbookCloudImportHelper3.mContext, str3, scrapbookCloudImportHelper3, 3, scrapbookCloudImportHelper3.mDownloadList);
                            }
                            ScrapbookCloudImportHelper scrapbookCloudImportHelper4 = ScrapbookCloudImportHelper.this;
                            ImportBaseTask importBaseTask = scrapbookCloudImportHelper4.mSync;
                            if (importBaseTask != null) {
                                scrapbookCloudImportHelper4.mState = 3;
                                importBaseTask.executeOnExecutor(scrapbookCloudImportHelper4.mExecutor, new Void[0]);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        } else {
            Debugger.m8609e(TAG, "onReceived() : userToken or userId is empty!");
            onImportError(this.mType, 106, "userToken or userId is empty", null);
        }
    }
}
