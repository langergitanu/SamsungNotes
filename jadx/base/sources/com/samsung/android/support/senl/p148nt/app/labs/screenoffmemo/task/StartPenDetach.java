package com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo.task;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class StartPenDetach extends Task {
    private static final String EXTRA_VALUE_PEN_DETACH = "pen_detach";
    private static final String TAG = "StartPenDetach";

    @Override // java.lang.Runnable
    public void run() {
        Logger.m7100d(TAG, "run");
        final int penDetectMode = getPenDetectMode();
        setPenDetectMode(0);
        turnOffScreen();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.labs.screenoffmemo.task.StartPenDetach.1
            @Override // java.lang.Runnable
            public void run() {
                ServiceManager.INSTANCE.getInstance().startServiceAsUser(BaseUtils.getApplicationContext(), StartPenDetach.this.createIntent(new ComponentName("com.samsung.android.app.notes", "com.samsung.android.app.notes.screenoffmemo.ScreenOffMemoService"), Constants.StringExtraKey.PEN_INTENT_COM, "pen_detach"));
                StartPenDetach.this.setPenDetectMode(penDetectMode);
            }
        }, AiSTTListView.USER_SCROLL_INTERVAL);
    }
}
