package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class SearchResultUpdater {
    private static final String TAG = Logger.createTag("PageListSearchResultUpdater");
    private final Callback mCallback;
    private ThreadPoolExecutor mExecutorService;
    private ThumbnailCreator mThumbnailCreator;
    private final Handler mHandler = new Handler();
    private final List<BackgroundTask> mBackgroundTaskList = new LinkedList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BackgroundTask implements Runnable {
        private static final int STATE_CANCEL = 1000;
        private static final int STATE_END_ON_BACKGROUND = 2;
        private static final int STATE_FINISHED = 3;
        private static final int STATE_START = 1;
        private final AtomicBoolean mIsCanceled = new AtomicBoolean(false);
        private Future<?> mMyFuture;
        private SearchData mSearchData;

        public BackgroundTask(SearchData searchData) {
            this.mSearchData = searchData;
            InternalLogger.debugLog("created#" + getTaskInfoLog());
        }

        private void done() {
            SearchResultUpdater.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.SearchResultUpdater.BackgroundTask.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BackgroundTask.this.mIsCanceled.get()) {
                        BackgroundTask.this.release();
                        return;
                    }
                    BackgroundTask backgroundTask = BackgroundTask.this;
                    SearchResultUpdater.this.onDone(backgroundTask);
                    BackgroundTask.this.setState(3);
                    BackgroundTask.this.release();
                }
            });
        }

        private String getTaskInfoLog() {
            StringBuilder sb = new StringBuilder(" (");
            sb.append(hashCode());
            sb.append(" i: ");
            SearchData searchData = this.mSearchData;
            return AbstractC2821a.m2223n(sb, ")", searchData == null ? -1 : searchData.getPageIndex());
        }

        private void notifyResult(final PageId pageId) {
            SearchResultUpdater.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.SearchResultUpdater.BackgroundTask.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BackgroundTask.this.mIsCanceled.get()) {
                        return;
                    }
                    SearchResultUpdater.this.onThumbnailCreated(pageId);
                }
            });
        }

        private void onCanceled() {
            setState(1000);
            release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            this.mSearchData = null;
            this.mMyFuture = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void setState(int i) {
            InternalLogger.debugLog("setState# " + i + getTaskInfoLog());
        }

        public void cancel() {
            this.mIsCanceled.set(true);
            this.mMyFuture.cancel(true);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            setState(1);
            if (this.mIsCanceled.get()) {
                onCanceled();
                return;
            }
            SearchData searchData = this.mSearchData;
            try {
                SearchResultUpdater.this.mThumbnailCreator.createOriginalThumbnail(searchData.getPageIndex());
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("BackgroundTask# "), SearchResultUpdater.TAG);
            }
            if (this.mIsCanceled.get()) {
                onCanceled();
                return;
            }
            PageId pageIdCreateSearchThumbnail = SearchResultUpdater.this.mThumbnailCreator.createSearchThumbnail(searchData);
            if (pageIdCreateSearchThumbnail == null) {
                throw new Exception("fail");
            }
            if (this.mIsCanceled.get()) {
                onCanceled();
                return;
            }
            notifyResult(pageIdCreateSearchThumbnail);
            setState(2);
            done();
        }

        public void setMyFuture(Future<?> future) {
            this.mMyFuture = future;
            if (future == null) {
                Logger.m11000e(SearchResultUpdater.TAG, "setMyFuture# null");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onThumbnailCreated(PageId pageId);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InternalLogger {
        private static final boolean DEBUG = true;

        private InternalLogger() {
        }

        public static void debugLog(String str) {
            Logger.m10999d(SearchResultUpdater.TAG, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ThumbnailCreator {
        private String mCachePath;
        private NoteCaptureControl mCapture;
        private SpenWNote mNote;
        private PageManager mPageManager;

        public ThumbnailCreator(SpenWNote spenWNote, PageManager pageManager, NoteCaptureControl noteCaptureControl, String str) {
            this.mNote = spenWNote;
            this.mPageManager = pageManager;
            this.mCapture = noteCaptureControl;
            this.mCachePath = str;
        }

        public void createOriginalThumbnail(int i) throws Exception {
            PageInfo pageInfo = this.mPageManager.getPageInfo(i);
            if (TextUtils.isEmpty(pageInfo.getThumbnailFilePath()) || pageInfo.isDirty()) {
                SpenWPage page = this.mNote.getPage(i);
                PageManager pageManager = this.mPageManager;
                NoteCaptureControl noteCaptureControl = this.mCapture;
                SpenWNote spenWNote = this.mNote;
                pageManager.setThumbnail(noteCaptureControl, spenWNote, page, spenWNote.getBodyText(), i, false);
            }
        }

        public PageId createSearchThumbnail(SearchData searchData) throws Throwable {
            SpenObjectTextBox bodyText = this.mNote.getBodyText();
            Paint paint = new Paint();
            PageInfo pageInfo = this.mPageManager.getPageInfo(searchData.getPageIndex());
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(pageInfo.getThumbnailFilePath());
            if (bitmapDecodeFile == null) {
                Logger.m11000e(SearchResultUpdater.TAG, "createSearchThumbnail# thumbnailBitmap is null");
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), bitmapDecodeFile.getConfig());
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapDecodeFile, 0.0f, 0.0f, paint);
            SpenWPage page = this.mNote.getPage(searchData.getPageIndex());
            this.mCapture.setContents(page, bodyText, searchData.getPageIndex());
            Bitmap drawRect = getDrawRect(page.getWidth(), page.getHeight(), this.mPageManager.getThumbnailRatio(), searchData.getRects(), searchData.getIsFills());
            if (drawRect == null) {
                Logger.m11000e(SearchResultUpdater.TAG, "createSearchThumbnail# rectBitmap is null");
                return null;
            }
            if (bitmapCreateBitmap.getWidth() != drawRect.getWidth()) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(drawRect, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), true), 0.0f, 0.0f, paint);
            } else {
                canvas.drawBitmap(drawRect, 0.0f, 0.0f, paint);
            }
            String str = this.mCachePath + File.separator + searchData.getPageIndex();
            ImageUtils.makeJpg(bitmapCreateBitmap, str, 100, true);
            bitmapCreateBitmap.recycle();
            drawRect.recycle();
            bitmapDecodeFile.recycle();
            return new PageId(pageInfo.getPageId(), str);
        }

        public Bitmap getDrawRect(int i, int i2, float f, ArrayList<RectF> arrayList, ArrayList<Boolean> arrayList2) {
            if (f > 5.0f || i <= 0) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (i * f), (int) (i2 * f), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColor(1308393318);
            int size = arrayList.size();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                RectF rectF = arrayList.get(i4);
                rectF.left *= f;
                rectF.top *= f;
                rectF.right *= f;
                rectF.bottom *= f;
                if (i4 < size2) {
                    paint.setStyle(arrayList2.get(i4).booleanValue() ? Paint.Style.FILL : Paint.Style.STROKE);
                } else {
                    paint.setStyle(Paint.Style.STROKE);
                }
                canvas.drawRect(rectF, paint);
            }
            return bitmapCreateBitmap;
        }

        public void release() {
            this.mNote = null;
            this.mPageManager = null;
            this.mCapture.close();
            this.mCapture = null;
            this.mCachePath = null;
        }
    }

    public SearchResultUpdater(Callback callback) {
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void onDone(BackgroundTask backgroundTask) {
        InternalLogger.debugLog("onDone");
        synchronized (this.mBackgroundTaskList) {
            this.mBackgroundTaskList.remove(backgroundTask);
            InternalLogger.debugLog("onDone# remain size: " + this.mBackgroundTaskList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void onThumbnailCreated(PageId pageId) {
        InternalLogger.debugLog("onThumbnailCreated# " + pageId);
        this.mCallback.onThumbnailCreated(pageId);
    }

    public void cancel() {
        Logger.m10999d(TAG, "cancel#");
        if (this.mExecutorService == null) {
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        synchronized (this.mBackgroundTaskList) {
            try {
                Iterator<BackgroundTask> it = this.mBackgroundTaskList.iterator();
                while (it.hasNext()) {
                    it.next().cancel();
                    it.remove();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mExecutorService.shutdownNow();
    }

    public void init(Context context, SpenWNote spenWNote, PageManager pageManager, String str) {
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(context);
        noteCaptureControl.setWNote(spenWNote);
        this.mThumbnailCreator = new ThumbnailCreator(spenWNote, pageManager, noteCaptureControl, str);
    }

    public void ready() {
        String str = TAG;
        Logger.m10999d(str, "ready#");
        if (!this.mBackgroundTaskList.isEmpty()) {
            Logger.m11000e(str, "ready# task list is not empty");
            this.mBackgroundTaskList.clear();
        }
        this.mExecutorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1, new SenlThreadFactory(str));
    }

    public void release() {
        cancel();
        this.mBackgroundTaskList.clear();
        ThumbnailCreator thumbnailCreator = this.mThumbnailCreator;
        if (thumbnailCreator != null) {
            thumbnailCreator.release();
        }
    }

    public void submit(SearchData searchData) {
        if (this.mExecutorService.isShutdown()) {
            Logger.m10999d(TAG, "submit# shutdown: " + searchData.getPageIndex());
            return;
        }
        BackgroundTask backgroundTask = new BackgroundTask(searchData);
        backgroundTask.setMyFuture(this.mExecutorService.submit(backgroundTask));
        synchronized (this.mBackgroundTaskList) {
            this.mBackgroundTaskList.add(backgroundTask);
            InternalLogger.debugLog("submit#" + searchData.getPageIndex() + " size " + this.mBackgroundTaskList.size());
        }
    }

    public void waitToFinish() {
        if (this.mExecutorService == null) {
            return;
        }
        while (!this.mBackgroundTaskList.isEmpty()) {
            Logger.m10999d(TAG, "waiting# remain: " + this.mBackgroundTaskList.size());
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                Logger.m10999d(TAG, "waiting# " + e);
                cancel();
            }
        }
        Logger.m11003i(TAG, "waitToFinish# done");
    }
}
