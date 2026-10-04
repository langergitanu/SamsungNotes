package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.framework.support.ActivityManagerUtil;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p032H.C0110a;
import p041J.AbstractC0142a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PollingHandler {
    private static final String TAG = "PollingHandler";
    private static final long UPDATE_TITLE_AND_DATE_POLLING_DELAY_MILLS = 30000;
    private final AtomicBoolean mIsRunningUpdate = new AtomicBoolean(false);
    private final Executor mPollingExecutor = AbstractC4539a.m3201k("PollingHandler_polling");
    private final Handler mPollingHandler = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.PollingHandler.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (ActivityManagerUtil.isAppInBackground(BaseUtils.getApplicationContext())) {
                CoeditLogger.m8919d(PollingHandler.TAG, "[CS6-1] pause polling coedit");
                return;
            }
            int i = message.what;
            if (i == 2) {
                CoeditLogger.m8919d(PollingHandler.TAG, "[CS6-1] EXIT polling coedit");
                removeMessages(0);
            } else if (i == 0) {
                CoeditLogger.m8919d(PollingHandler.TAG, "[CS6] REQUEST polling coedit");
                String str = (String) message.obj;
                if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                    PollingHandler.this.requestUpdateTitleAndDate(str);
                } else {
                    CoeditLogger.m8923i(PollingHandler.TAG, "[CS6-2] REQUEST polling coedit failed : wifi only mode restrict");
                }
                removeMessages(0);
                sendMessageDelayed(Message.obtain(PollingHandler.this.mPollingHandler, 0, str), 30000L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUpdateTitleAndDate(final String str) {
        AbstractC8014b.m7219u("[CS6] requestUpdateTitleAndDate : spaceId = ", str, TAG);
        if (this.mIsRunningUpdate.get()) {
            return;
        }
        this.mPollingExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.PollingHandler.2
            @Override // java.lang.Runnable
            public void run() {
                C0110a c0110a;
                PollingHandler.this.mIsRunningUpdate.set(true);
                String str2 = str;
                if (str2 == null) {
                    synchronized (C0110a.class) {
                        try {
                            if (C0110a.f358a == null) {
                                C0110a.f358a = new C0110a();
                            }
                            c0110a = C0110a.f358a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    c0110a.getClass();
                    List<Space> listRequestCoEditStandAloneSpaceList = SesCoeditShareReadResolver.getInstance().requestCoEditStandAloneSpaceList();
                    if (listRequestCoEditStandAloneSpaceList != null && !listRequestCoEditStandAloneSpaceList.isEmpty()) {
                        Iterator<Space> it = listRequestCoEditStandAloneSpaceList.iterator();
                        while (it.hasNext()) {
                            AbstractC0142a.m291c(it.next().getSpaceId());
                        }
                    }
                } else {
                    AbstractC0142a.m291c(str2);
                }
                PollingHandler.this.mIsRunningUpdate.set(false);
            }
        });
    }

    public void finishPolling() {
        this.mPollingHandler.removeMessages(0);
        CoeditLogger.m8919d(TAG, "[CS6] finishPolling()");
        this.mPollingHandler.sendEmptyMessage(2);
    }

    public void startPolling(String str) {
        this.mPollingHandler.removeMessages(0);
        this.mPollingHandler.removeMessages(2);
        CoeditLogger.m8919d(TAG, "[CS6] startPolling() : spaceId = " + str);
        Handler handler = this.mPollingHandler;
        handler.sendMessageDelayed(Message.obtain(handler, 0, str), 30000L);
    }
}
