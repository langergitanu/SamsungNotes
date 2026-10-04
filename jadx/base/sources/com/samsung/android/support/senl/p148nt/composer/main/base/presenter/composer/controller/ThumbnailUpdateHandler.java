package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ThumbnailUpdateHandler extends Handler {
    private static final int DELAY_HEAVY_CONDITION = 5;
    private static final int DELAY_HEAVY_TIME = 300;
    private static final int DELAY_TIME_SAME_PAGE_ID = 1000;
    public static final int INVALID_INDEX = -1;
    private static final int MSG_MAKE_THUMBNAIL_END = 1;
    private static final int MSG_MAKE_THUMBNAIL_START = 0;
    private static final String TAG = Logger.createTag("ThumbnailUpdateHandler");
    private NoteCaptureControl mCapture;
    private ExecutorService mExecutorService;
    private String mLastPageId;
    private Future<Integer> mMakeThumbnailTaskFuture;
    private SpenWNote mNote;
    private PageManager mPageManager;
    private final List<String> mQueue = new ArrayList();
    private boolean mBlock = false;
    private final MakeThumbnailTask mMakeThumbnailTask = new MakeThumbnailTask();
    private final UpdateTargetRange mUpdateTargetRange = new UpdateTargetRange();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MakeThumbnailTask implements Callable<Integer> {
        String pageId;
        int pageIndex;
        boolean result;
        AtomicBoolean runningState = new AtomicBoolean(false);

        public MakeThumbnailTask() {
        }

        public void setInfo(String str, int i) {
            this.pageId = str;
            this.pageIndex = i;
            this.result = true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() {
            AbstractC8014b.m7221w(new StringBuilder("call# "), ThumbnailUpdateHandler.TAG, this.pageIndex);
            if (ThumbnailUpdateHandler.this.mNote != null) {
                try {
                    try {
                        int pageIndexById = ThumbnailUpdateHandler.this.mNote.getPageIndexById(this.pageId);
                        if (pageIndexById != this.pageIndex) {
                            Logger.m11004w(ThumbnailUpdateHandler.TAG, "call# page was changed " + this.pageIndex + " " + pageIndexById);
                            this.pageIndex = pageIndexById;
                        }
                        ThumbnailUpdateHandler.this.mPageManager.setThumbnail(ThumbnailUpdateHandler.this.mCapture, ThumbnailUpdateHandler.this.mNote, ThumbnailUpdateHandler.this.mNote.getPage(this.pageIndex), ThumbnailUpdateHandler.this.mNote.getBodyText(), this.pageIndex, false);
                        ThumbnailUpdateHandler.this.sendEmptyMessage(1);
                    } catch (Exception e) {
                        Logger.m11001e(ThumbnailUpdateHandler.TAG, "call# err", e);
                        this.result = false;
                        ThumbnailUpdateHandler.this.sendEmptyMessage(1);
                        return -1;
                    }
                } catch (Throwable th) {
                    ThumbnailUpdateHandler.this.sendEmptyMessage(1);
                    throw th;
                }
            }
            return Integer.valueOf(this.pageIndex);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NonSequentialRange implements RangeHelper {
        public /* synthetic */ NonSequentialRange(int i) {
            this();
        }

        private String pollFromQueue(int i, List<String> list, SpenWNote spenWNote) {
            try {
                String pageIdByIndex = spenWNote.getPageIdByIndex(i);
                if (!list.contains(pageIdByIndex)) {
                    return null;
                }
                list.remove(pageIdByIndex);
                return pageIdByIndex;
            } catch (RuntimeException e) {
                String str = ThumbnailUpdateHandler.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "findInRange# ", " e: ");
                sbM778t.append(e.getMessage());
                Logger.m11000e(str, sbM778t.toString());
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public void adjustEndRangeBiggerThan(List<Integer> list, int i) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (size >= 0 && list.get(size).intValue() >= i) {
                list.remove(list.get(size));
                size--;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public void adjustForciblyRange(List<Integer> list, int i) {
            if (((Integer) AbstractC0000a.m10g(list, 1)).intValue() < i) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public boolean containRange(List<Integer> list, int i) {
            return list.contains(Integer.valueOf(i));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public int getRangeSize(List<Integer> list) {
            return list.size();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public boolean isSequential() {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public boolean isValid(List<Integer> list) {
            return !list.isEmpty();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public String pollFromLargeSizeQueue(List<Integer> list, List<Integer> list2, List<String> list3, SpenWNote spenWNote) {
            ArrayList arrayList = new ArrayList(list.size());
            arrayList.addAll(list);
            for (Integer num : list2) {
                String strPollFromQueue = pollFromQueue(num.intValue(), list3, spenWNote);
                if (strPollFromQueue != null) {
                    return strPollFromQueue;
                }
                arrayList.remove(num);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String strPollFromQueue2 = pollFromQueue(((Integer) it.next()).intValue(), list3, spenWNote);
                if (strPollFromQueue2 != null) {
                    return strPollFromQueue2;
                }
            }
            return null;
        }

        private NonSequentialRange() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RangeHelper {
        void adjustEndRangeBiggerThan(List<Integer> list, int i);

        void adjustForciblyRange(List<Integer> list, int i);

        boolean containRange(List<Integer> list, int i);

        int getRangeSize(List<Integer> list);

        boolean isSequential();

        boolean isValid(List<Integer> list);

        String pollFromLargeSizeQueue(List<Integer> list, List<Integer> list2, List<String> list3, SpenWNote spenWNote);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SequentialRange implements RangeHelper {
        private static final int END = 1;
        private static final int START = 0;

        public /* synthetic */ SequentialRange(int i) {
            this();
        }

        private String findInRange(int i, int i2, List<String> list, SpenWNote spenWNote) {
            while (i < i2) {
                try {
                    String pageIdByIndex = spenWNote.getPageIdByIndex(i);
                    if (list.contains(pageIdByIndex)) {
                        list.remove(pageIdByIndex);
                        return pageIdByIndex;
                    }
                    continue;
                } catch (RuntimeException e) {
                    String str = ThumbnailUpdateHandler.TAG;
                    StringBuilder sbM778t = AbstractC0541b.m778t(i, "findInRange# ", " e: ");
                    sbM778t.append(e.getMessage());
                    Logger.m11000e(str, sbM778t.toString());
                }
                i++;
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public void adjustEndRangeBiggerThan(List<Integer> list, int i) {
            if (list.get(1).intValue() >= i) {
                Logger.m11000e(ThumbnailUpdateHandler.TAG, "adjustEndRangeSmaller# " + list.get(1));
                list.remove(1);
                list.add(Integer.valueOf(i - 1));
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public void adjustForciblyRange(List<Integer> list, int i) {
            if (list.get(1).intValue() < i) {
                Logger.m11000e(ThumbnailUpdateHandler.TAG, "adjustForciblyRange# " + list.get(1));
                list.remove(1);
                list.add(Integer.valueOf(i));
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public boolean containRange(List<Integer> list, int i) {
            return i >= list.get(0).intValue() && i <= list.get(1).intValue();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public int getRangeSize(List<Integer> list) {
            return (list.get(1).intValue() - list.get(0).intValue()) + 1;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public boolean isSequential() {
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public boolean isValid(List<Integer> list) {
            return list.get(1).intValue() > -1;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler.RangeHelper
        public String pollFromLargeSizeQueue(List<Integer> list, List<Integer> list2, List<String> list3, SpenWNote spenWNote) {
            String strFindInRange = findInRange(list2.get(0).intValue(), list2.get(1).intValue() + 1, list3, spenWNote);
            if (strFindInRange != null) {
                return strFindInRange;
            }
            String strFindInRange2 = findInRange(list.get(0).intValue(), list2.get(0).intValue() - 1, list3, spenWNote);
            return strFindInRange2 != null ? strFindInRange2 : findInRange(list2.get(1).intValue() + 1, list.get(1).intValue() + 1, list3, spenWNote);
        }

        private SequentialRange() {
        }
    }

    public ThumbnailUpdateHandler() {
        updateTargetRange(-1, -1, -1, -1);
    }

    private boolean isReadyToSendStartMessage() {
        return (this.mQueue.isEmpty() || isRunning()) ? false : true;
    }

    private boolean isRunning() {
        return this.mMakeThumbnailTask.runningState.get() || hasMessages(0) || hasMessages(1);
    }

    private boolean isSameLastPageId() {
        return this.mQueue.size() == 1 && this.mQueue.get(0).equals(this.mLastPageId);
    }

    private String poll() {
        if (this.mQueue.isEmpty()) {
            return null;
        }
        if (!this.mUpdateTargetRange.isValid()) {
            this.mQueue.clear();
            return null;
        }
        this.mUpdateTargetRange.adjustEndRangeBiggerThan(this.mNote.getPageCount());
        Logger.startTime(String.valueOf(hashCode()));
        String strPollFromLargeSizeQueue = this.mQueue.size() > this.mUpdateTargetRange.getTargetRangeSize() ? this.mUpdateTargetRange.pollFromLargeSizeQueue() : pollForSmallSize();
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        StringBuilder sb = new StringBuilder("poll# ");
        sb.append(strPollFromLargeSizeQueue != null);
        sb.append(" remain size ");
        sb.append(this.mQueue);
        Logger.endTime(strValueOf, str, sb.toString());
        if (strPollFromLargeSizeQueue != null) {
            this.mLastPageId = strPollFromLargeSizeQueue;
            return strPollFromLargeSizeQueue;
        }
        this.mQueue.clear();
        return null;
    }

    private String pollForSmallSize() {
        Iterator<String> it = this.mQueue.iterator();
        String str = null;
        while (it.hasNext()) {
            try {
                String next = it.next();
                int pageIndexById = this.mNote.getPageIndexById(next);
                if (this.mUpdateTargetRange.containDisplayRange(pageIndexById)) {
                    it.remove();
                    return next;
                }
                if (str == null) {
                    if (this.mUpdateTargetRange.containRange(pageIndexById)) {
                        str = next;
                    } else {
                        it.remove();
                    }
                }
            } catch (RuntimeException e) {
                Logger.m11000e(TAG, e.getMessage());
                it.remove();
            }
        }
        if (str != null) {
            this.mQueue.remove(str);
        }
        return str;
    }

    private void sendMessageForNext() {
        if (this.mQueue.isEmpty()) {
            return;
        }
        if (this.mQueue.size() > 5) {
            sendEmptyMessageDelayed(0, 300L);
        } else if (isSameLastPageId()) {
            sendEmptyMessageDelayed(0, 1000L);
        } else {
            sendEmptyMessage(0);
        }
    }

    public void clearTargetRange() {
        Logger.m10999d(TAG, "clearTargetRange#");
        this.mUpdateTargetRange.updateTargetRange(-1, -1, -1, -1);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("handleMessage# ");
        sb.append(message.what);
        sb.append(" ");
        AbstractC8014b.m7215q(sb, this.mBlock, str);
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            AbstractC8014b.m7221w(new StringBuilder("handleMessage#MSG_MAKE_THUMBNAIL_END# "), str, this.mMakeThumbnailTask.pageIndex);
            this.mMakeThumbnailTaskFuture = null;
            this.mMakeThumbnailTask.runningState.set(false);
            if (this.mMakeThumbnailTask.result && this.mPageManager != null && this.mUpdateTargetRange.isValid()) {
                try {
                    int pageIndexById = this.mNote.getPageIndexById(this.mMakeThumbnailTask.pageId);
                    this.mPageManager.notifyDataSetChanged(1, pageIndexById, pageIndexById);
                } catch (Exception e) {
                    Logger.m11000e(TAG, e.getMessage());
                }
            }
            sendMessageForNext();
            return;
        }
        if (this.mBlock || this.mNote == null) {
            return;
        }
        String strPoll = poll();
        if (TextUtils.isEmpty(strPoll)) {
            return;
        }
        try {
            int pageIndexById2 = this.mNote.getPageIndexById(strPoll);
            AbstractC0000a.m3D(pageIndexById2, "handleMessage#MSG_MAKE_THUMBNAIL_START#", str);
            if (this.mPageManager != null) {
                this.mMakeThumbnailTask.runningState.set(true);
                this.mMakeThumbnailTask.setInfo(strPoll, pageIndexById2);
                this.mMakeThumbnailTaskFuture = this.mExecutorService.submit(this.mMakeThumbnailTask);
            }
        } catch (Exception e2) {
            Logger.m11000e(TAG, e2.getMessage());
            sendMessageForNext();
        }
    }

    public void init(Context context, SpenWNote spenWNote, PageManager pageManager) {
        this.mNote = spenWNote;
        this.mPageManager = pageManager;
        this.mCapture = new NoteCaptureControl(context);
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        }
        sendMessageForNext();
    }

    public boolean isWorkingThread() {
        return this.mMakeThumbnailTaskFuture != null;
    }

    public synchronized void onDeletedPages(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.mQueue.remove(it.next());
        }
    }

    public void release() {
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            try {
                String str = TAG;
                Logger.m10999d(str, "release# await start");
                this.mExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
                Logger.m10999d(str, "release# await end");
            } catch (InterruptedException e) {
                Logger.m10999d(TAG, e.getMessage());
            }
            this.mExecutorService = null;
        }
        this.mNote = null;
        NoteCaptureControl noteCaptureControl = this.mCapture;
        if (noteCaptureControl != null) {
            noteCaptureControl.close();
            this.mCapture = null;
        }
        this.mBlock = false;
    }

    public synchronized boolean requestToMakeThumbnail(String str, int i, boolean z) {
        try {
            String str2 = TAG;
            Logger.m10999d(str2, "requestToMakeThumbnail# " + i);
            if (z) {
                this.mUpdateTargetRange.adjustRangeForce(i);
            } else if (!this.mUpdateTargetRange.containRange(i)) {
                Logger.m11004w(str2, "is not showing");
                return false;
            }
            if (!this.mQueue.contains(str)) {
                this.mQueue.add(str);
                Logger.m10999d(str2, "requestToMakeThumbnail# insert " + i);
            }
            if (isReadyToSendStartMessage()) {
                Logger.m10999d(str2, "requestToMakeThumbnail# send");
                sendEmptyMessageDelayed(0, 600L);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setBlockToUpdate(boolean z) {
        setBlockToUpdate(z, false);
    }

    public void updateTargetRange(int i, int i2, int i4, int i5) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "updateTargetRange# ", "/", " - ");
        sbM1173s.append(i4);
        sbM1173s.append("/");
        sbM1173s.append(i5);
        Logger.m10999d(str, sbM1173s.toString());
        this.mUpdateTargetRange.updateTargetRange(i, i2, i4, i5);
    }

    public void updateThumbnail(int i) {
        updateThumbnail(i, false);
    }

    public void updateThumbnailAll() {
        SpenWNote spenWNote = this.mNote;
        if (spenWNote == null) {
            Logger.m11000e(TAG, "updateThumbnailAll# mNote is null ");
            return;
        }
        int pageCount = spenWNote.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            updateThumbnail(i);
        }
    }

    public void setBlockToUpdate(boolean z, boolean z2) {
        if (this.mBlock && !z && isReadyToSendStartMessage()) {
            sendEmptyMessage(0);
        }
        this.mBlock = z;
        String str = TAG;
        StringBuilder sb = new StringBuilder("setBlockToUpdate# block: ");
        AbstractC2821a.m2208C(sb, this.mBlock, " wait: ", z2, " running: ");
        sb.append(this.mMakeThumbnailTask.runningState.get());
        sb.append(" ");
        sb.append(this.mMakeThumbnailTaskFuture);
        Logger.m10999d(str, sb.toString());
        if (z2 && this.mBlock && this.mMakeThumbnailTask.runningState.get() && !hasMessages(1) && this.mMakeThumbnailTaskFuture != null) {
            Logger.m10999d(str, "setBlockToUpdate# wait");
            try {
                this.mMakeThumbnailTaskFuture.get(1000L, TimeUnit.MILLISECONDS);
                Logger.m10999d(str, "setBlockToUpdate# wait task finish");
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e) {
                AbstractC8014b.m7205g(e, new StringBuilder("setBlockToUpdate# "), TAG);
            }
            Logger.m10999d(TAG, "setBlockToUpdate# wait end");
        }
    }

    public void updateThumbnail(int i, boolean z) {
        if (i < this.mPageManager.getPageCount()) {
            PageInfo pageInfo = this.mPageManager.getPageInfo(i);
            pageInfo.setDirty(true);
            requestToMakeThumbnail(pageInfo.getPageId(), i, z);
        } else {
            Logger.m11000e(TAG, "updateThumbnail# " + i);
        }
    }

    public void updateTargetRange(List<Integer> list, List<Integer> list2) {
        Logger.m10999d(TAG, "updateTargetRange# " + list + " // " + list2);
        this.mUpdateTargetRange.updateTargetRange(list, list2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class UpdateTargetRange {
        private RangeHelper mRange;
        private final List<Integer> mUpdateTargetList = new ArrayList();
        private final List<Integer> mDisplayList = new ArrayList();

        public UpdateTargetRange() {
            updateTargetRange(-1, -1, -1, -1);
        }

        private void clear() {
            this.mUpdateTargetList.clear();
            this.mDisplayList.clear();
        }

        public void adjustEndRangeBiggerThan(int i) {
            this.mRange.adjustEndRangeBiggerThan(this.mUpdateTargetList, i);
        }

        public void adjustRangeForce(int i) {
            this.mRange.adjustForciblyRange(this.mUpdateTargetList, i);
        }

        public boolean containDisplayRange(int i) {
            return this.mRange.containRange(this.mDisplayList, i);
        }

        public boolean containRange(int i) {
            return this.mRange.containRange(this.mUpdateTargetList, i);
        }

        public int getTargetRangeSize() {
            return this.mRange.getRangeSize(this.mUpdateTargetList);
        }

        public boolean isValid() {
            return this.mRange.isValid(this.mUpdateTargetList);
        }

        public String pollFromLargeSizeQueue() {
            return this.mRange.pollFromLargeSizeQueue(this.mUpdateTargetList, this.mDisplayList, ThumbnailUpdateHandler.this.mQueue, ThumbnailUpdateHandler.this.mNote);
        }

        public void updateTargetRange(int i, int i2, int i4, int i5) {
            String str = ThumbnailUpdateHandler.TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "updateTargetRange# ", "/", " - ");
            sbM1173s.append(i4);
            sbM1173s.append("/");
            sbM1173s.append(i5);
            Logger.m10999d(str, sbM1173s.toString());
            clear();
            this.mUpdateTargetList.add(Integer.valueOf(i));
            this.mUpdateTargetList.add(Integer.valueOf(i2));
            this.mDisplayList.add(Integer.valueOf(i4));
            this.mDisplayList.add(Integer.valueOf(i5));
            RangeHelper rangeHelper = this.mRange;
            if (rangeHelper == null || !rangeHelper.isSequential()) {
                this.mRange = new SequentialRange(0);
            }
        }

        public void updateTargetRange(List<Integer> list, List<Integer> list2) {
            clear();
            this.mUpdateTargetList.addAll(list);
            this.mDisplayList.addAll(list2);
            RangeHelper rangeHelper = this.mRange;
            if (rangeHelper == null || rangeHelper.isSequential()) {
                this.mRange = new NonSequentialRange(0);
            }
        }
    }
}
