package com.samsung.scsp.pam.kps.lite;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C4512a;
import com.samsung.scsp.common.PushHandler;
import com.samsung.scsp.common.PushVo;
import com.samsung.scsp.error.FaultBarrier;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KpsServiceKeyReadyPushHandlerFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KpsServiceKeyReadyPushHandler implements PushHandler<ScspKpsLite> {
        private final AtomicBoolean canceled;
        private final Queue<CountDownLatch> queue;

        public boolean await(long j, TimeUnit timeUnit) {
            this.canceled.set(false);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.queue.add(countDownLatch);
            FaultBarrier.run(new C4512a(countDownLatch, j, timeUnit));
            return !this.canceled.get();
        }

        public void cancel() {
            this.canceled.set(true);
            Iterator<CountDownLatch> it = this.queue.iterator();
            while (it.hasNext()) {
                it.next().countDown();
            }
        }

        private KpsServiceKeyReadyPushHandler() {
            this.canceled = new AtomicBoolean(false);
            this.queue = new ConcurrentLinkedQueue();
        }

        @Override // com.samsung.scsp.common.PushHandler
        public boolean handle(ScspKpsLite scspKpsLite, PushVo pushVo) {
            Iterator<CountDownLatch> it = this.queue.iterator();
            while (it.hasNext()) {
                it.next().countDown();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final KpsServiceKeyReadyPushHandler INSTANCE = new KpsServiceKeyReadyPushHandler();

        private LazyHolder() {
        }
    }

    public static KpsServiceKeyReadyPushHandler get() {
        return LazyHolder.INSTANCE;
    }
}
