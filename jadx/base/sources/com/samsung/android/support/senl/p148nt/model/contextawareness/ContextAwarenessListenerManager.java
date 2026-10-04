package com.samsung.android.support.senl.p148nt.model.contextawareness;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessListenerManager {
    private static final int LIST_CAPACITY = 10;
    private static final int MESSAGE_NOTIFY_FINISHED = 1;
    private static final long SCHEDULING_INTERVAL_TIME = 300;
    private static final String TAG = CALogger.createTag("ContextAwarenessListenerManager");
    private static ContextAwarenessListenerManager sInstance;
    private final ConcurrentHashMap<Integer, ContextAwarenessListener> mListenerMap = new ConcurrentHashMap<>();
    private final List<Pair<Long, IContextAwarenessResult>> mSchedulingResultList = Collections.synchronizedList(new ArrayList());
    private final MessageHandler mHandler = new MessageHandler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MessageHandler extends Handler {
        public MessageHandler(@NonNull Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                DataLogger.m12302d(ContextAwarenessListenerManager.TAG, "handleMessage MESSAGE_NOTIFY_FINISHED");
                Pair pair = (Pair) ContextAwarenessListenerManager.this.mSchedulingResultList.get(0);
                IContextAwarenessResult iContextAwarenessResult = (IContextAwarenessResult) pair.second;
                if (((Integer) message.obj).intValue() == pair.hashCode()) {
                    ContextAwarenessListenerManager.this.notifyContextAwarenessFinishedImmediately(iContextAwarenessResult);
                    ContextAwarenessListenerManager.this.mSchedulingResultList.remove(pair);
                }
            }
        }
    }

    private ContextAwarenessListenerManager() {
    }

    public static synchronized ContextAwarenessListenerManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new ContextAwarenessListenerManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyContextAwarenessFinishedImmediately(@NonNull IContextAwarenessResult iContextAwarenessResult) {
        DataLogger.m12302d(TAG, "notifyContextAwarenessFinishedImmediately");
        Iterator<Map.Entry<Integer, ContextAwarenessListener>> it = this.mListenerMap.entrySet().iterator();
        while (it.hasNext()) {
            ContextAwarenessListener value = it.next().getValue();
            if (value != null) {
                value.onContextAwarenessFinished(iContextAwarenessResult);
            }
        }
    }

    private void notifyContextAwarenessFinishedScheduling(@NonNull IContextAwarenessResult iContextAwarenessResult) {
        this.mSchedulingResultList.add(0, new Pair<>(Long.valueOf(System.currentTimeMillis()), iContextAwarenessResult));
        if (this.mSchedulingResultList.size() > 10) {
            List<Pair<Long, IContextAwarenessResult>> list = this.mSchedulingResultList;
            list.remove(list.size() - 1);
        }
        Pair<Long, IContextAwarenessResult> pair = this.mSchedulingResultList.get(0);
        IContextAwarenessResult iContextAwarenessResult2 = (IContextAwarenessResult) pair.second;
        if (this.mSchedulingResultList.size() == 1) {
            notifyContextAwarenessFinishedImmediately(iContextAwarenessResult2);
            return;
        }
        Pair<Long, IContextAwarenessResult> pair2 = this.mSchedulingResultList.get(1);
        IContextAwarenessResult iContextAwarenessResult3 = (IContextAwarenessResult) pair2.second;
        String id = iContextAwarenessResult2.getSuggestionInfoList().get(0).getId();
        String id2 = iContextAwarenessResult3.getSuggestionInfoList().get(0).getId();
        long jLongValue = ((Long) pair.first).longValue();
        long jLongValue2 = ((Long) pair2.first).longValue();
        String str = TAG;
        StringBuilder sb = new StringBuilder("notifyContextAwarenessFinishedScheduling first/second ");
        sb.append(id);
        sb.append("(");
        sb.append(jLongValue);
        AbstractC1974b.m1332y(sb, ")", id2, "(");
        sb.append(jLongValue2);
        sb.append(")");
        DataLogger.m12302d(str, sb.toString());
        if (id.equals(id2)) {
            this.mSchedulingResultList.remove(pair2);
        }
        if (jLongValue - jLongValue2 >= 300) {
            notifyContextAwarenessFinishedImmediately(iContextAwarenessResult2);
            return;
        }
        Message messageObtain = Message.obtain(this.mHandler, 1, Integer.valueOf(pair.hashCode()));
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(messageObtain, 300L);
    }

    public void addListener(int i, ContextAwarenessListener contextAwarenessListener) {
        if (contextAwarenessListener == null || this.mListenerMap.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.mListenerMap.put(Integer.valueOf(i), contextAwarenessListener);
    }

    public void notifyContextAwarenessFinished(@NonNull IContextAwarenessResult iContextAwarenessResult) {
        DataLogger.m12302d(TAG, "notifyContextAwarenessFinished");
        if (this.mListenerMap.isEmpty()) {
            return;
        }
        if (iContextAwarenessResult.getRequest() != IContextAwarenessResult.Request.DRAW_SUGGESTION) {
            notifyContextAwarenessFinishedImmediately(iContextAwarenessResult);
        } else if (iContextAwarenessResult.getResponse() == IContextAwarenessResult.Response.DRAW_SUGGESTION_SUCCESS) {
            notifyContextAwarenessFinishedScheduling(iContextAwarenessResult);
        } else {
            notifyContextAwarenessFinishedImmediately(iContextAwarenessResult);
        }
    }

    public void notifyContextAwarenessStarted() {
        if (this.mListenerMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<Integer, ContextAwarenessListener>> it = this.mListenerMap.entrySet().iterator();
        while (it.hasNext()) {
            ContextAwarenessListener value = it.next().getValue();
            if (value != null) {
                value.onContextAwarenessStarted();
                return;
            }
        }
    }

    public void removeListener(int i) {
        if (this.mListenerMap.containsKey(Integer.valueOf(i))) {
            this.mListenerMap.remove(Integer.valueOf(i));
        }
    }
}
