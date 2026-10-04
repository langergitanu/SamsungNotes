package com.samsung.android.support.senl.p148nt.model.contextawareness;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.IContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.worker.ContextAwarenessWorker;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessController {
    private static final String TAG = CALogger.createTag("ContextAwarenessController");
    private static final List<Integer> sCallerList = new ArrayList();
    private static ContextAwarenessController sInstance;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.contextawareness.ContextAwarenessController$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114321 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$contextawareness$common$param$IContextAwarenessParam$Type */
        static final /* synthetic */ int[] f7697x6cb89fd2;

        static {
            int[] iArr = new int[IContextAwarenessParam.Type.values().length];
            f7697x6cb89fd2 = iArr;
            try {
                iArr[IContextAwarenessParam.Type.SUBSCRIBE_SUGGESTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7697x6cb89fd2[IContextAwarenessParam.Type.UNSUBSCRIBE_SUGGESTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ContextAwarenessController() {
    }

    public static ContextAwarenessController getInstance() {
        ContextAwarenessController contextAwarenessController;
        synchronized (ContextAwarenessController.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ContextAwarenessController();
                }
                contextAwarenessController = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return contextAwarenessController;
    }

    private void postSubscribeTask(ContextAwarenessParam contextAwarenessParam) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("postSubscribeTask listSize/callerId ");
        List<Integer> list = sCallerList;
        sb.append(list.size());
        sb.append("/");
        sb.append(contextAwarenessParam.getCaller());
        DataLogger.m12302d(str, sb.toString());
        if (list.isEmpty()) {
            ContextAwarenessWorker.getInstance().runContextAwareness(contextAwarenessParam);
        }
        list.add(Integer.valueOf(contextAwarenessParam.getCaller()));
    }

    private void postUnsubscribeTask(ContextAwarenessParam contextAwarenessParam) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("postUnsubscribeTask listSize/callerId ");
        List<Integer> list = sCallerList;
        sb.append(list.size());
        sb.append("/");
        sb.append(contextAwarenessParam.getCaller());
        DataLogger.m12302d(str, sb.toString());
        list.remove(Integer.valueOf(contextAwarenessParam.getCaller()));
        if (list.isEmpty()) {
            ContextAwarenessWorker.getInstance().runContextAwareness(contextAwarenessParam);
        }
    }

    public void postContextAwarenessTask(@NonNull ContextAwarenessParam contextAwarenessParam) {
        DataLogger.m12302d(TAG, "postContextAwarenessTask " + contextAwarenessParam.getType());
        int i = C114321.f7697x6cb89fd2[contextAwarenessParam.getType().ordinal()];
        if (i == 1) {
            postSubscribeTask(contextAwarenessParam);
        } else if (i != 2) {
            ContextAwarenessWorker.getInstance().runContextAwareness(contextAwarenessParam);
        } else {
            postUnsubscribeTask(contextAwarenessParam);
        }
    }
}
