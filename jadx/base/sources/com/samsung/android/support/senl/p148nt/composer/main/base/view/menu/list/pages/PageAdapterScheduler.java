package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PageAdapterScheduler implements IPageAdapter {
    private static final String TAG = Logger.createTag("PageAdapterScheduler");
    private final DefaultItemAnimator mDefaultItemAnimator;
    private final Handler mHandler;
    private boolean mIsPendingDataSetChanged;
    private ItemAnimatorFinishedListenerImpl mItemAnimatorFinishedListener;
    private PageAdapter mPageAdapter;
    private final Queue<ChangeInfo> mPendingItemChangedQueue = new LinkedList();
    private final RecyclerView mRecyclerView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ChangeInfo {
        private final int mPosition;

        public ChangeInfo(int i) {
            this.mPosition = i;
        }

        public int getPosition() {
            return this.mPosition;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ItemAnimatorFinishedListenerImpl implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {
        public /* synthetic */ ItemAnimatorFinishedListenerImpl(PageAdapterScheduler pageAdapterScheduler, int i) {
            this();
        }

        private void runPendingDataSetChange() {
            PageAdapterScheduler.this.mIsPendingDataSetChanged = false;
            PageAdapterScheduler.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageAdapterScheduler.ItemAnimatorFinishedListenerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(PageAdapterScheduler.TAG, "runPendingDataSetChange#post");
                    if (PageAdapterScheduler.this.mPageAdapter == null || PageAdapterScheduler.this.mDefaultItemAnimator.isRunning()) {
                        Logger.m10999d(PageAdapterScheduler.TAG, "runPendingDataSetChange#post: skip");
                    } else {
                        PageAdapterScheduler.this.notifyDataSetChanged();
                    }
                }
            });
            PageAdapterScheduler.this.mPendingItemChangedQueue.clear();
        }

        private void runPendingItemChanged() {
            if (PageAdapterScheduler.this.mPendingItemChangedQueue.isEmpty()) {
                return;
            }
            if (PageAdapterScheduler.this.mRecyclerView.isComputingLayout()) {
                Logger.m10999d(PageAdapterScheduler.TAG, "runPendingItemChanged#post");
                PageAdapterScheduler.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageAdapterScheduler.ItemAnimatorFinishedListenerImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.m10999d(PageAdapterScheduler.TAG, "runPendingItemChanged#post: " + PageAdapterScheduler.this.mPendingItemChangedQueue.size());
                        if (PageAdapterScheduler.this.mPendingItemChangedQueue.isEmpty()) {
                            return;
                        }
                        if (!PageAdapterScheduler.this.mRecyclerView.isComputingLayout()) {
                            PageAdapterScheduler.this.disableAnimation();
                        }
                        LinkedList linkedList = new LinkedList(PageAdapterScheduler.this.mPendingItemChangedQueue);
                        PageAdapterScheduler.this.mPendingItemChangedQueue.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            PageAdapterScheduler.this.notifyItemChanged(((ChangeInfo) it.next()).getPosition());
                        }
                    }
                });
                return;
            }
            PageAdapterScheduler.this.disableAnimation();
            Iterator it = PageAdapterScheduler.this.mPendingItemChangedQueue.iterator();
            while (it.hasNext()) {
                PageAdapterScheduler.this.callNotifyItemChanged(((ChangeInfo) it.next()).getPosition());
            }
            PageAdapterScheduler.this.mPendingItemChangedQueue.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            PageAdapterScheduler.this.mItemAnimatorFinishedListener = null;
            if (PageAdapterScheduler.this.mIsPendingDataSetChanged) {
                runPendingDataSetChange();
            } else {
                runPendingItemChanged();
            }
        }

        private ItemAnimatorFinishedListenerImpl() {
        }
    }

    public PageAdapterScheduler(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        this.mDefaultItemAnimator = defaultItemAnimator;
        recyclerView.setItemAnimator(defaultItemAnimator);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void callNotifyDataSetChanged() {
        Logger.m10999d(TAG, "callNotifyItemChanged# ");
        this.mPageAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callNotifyItemChanged(int i) {
        AbstractC0000a.m3D(i, "callNotifyItemChanged# ", TAG);
        this.mPageAdapter.notifyItemChanged(i);
    }

    private void setListener() {
        if (this.mItemAnimatorFinishedListener == null) {
            ItemAnimatorFinishedListenerImpl itemAnimatorFinishedListenerImpl = new ItemAnimatorFinishedListenerImpl(this, 0);
            this.mItemAnimatorFinishedListener = itemAnimatorFinishedListenerImpl;
            this.mDefaultItemAnimator.isRunning(itemAnimatorFinishedListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter
    public void disableAnimation() {
        try {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.getItemAnimator() == null) {
                return;
            }
            this.mRecyclerView.setItemAnimator(null);
        } catch (Exception e) {
            AbstractC8014b.m7207i("disableAnimation# ex ", e, TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter
    public void enableAnimation() {
        if (this.mRecyclerView.getItemAnimator() == null) {
            this.mRecyclerView.setItemAnimator(this.mDefaultItemAnimator);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter
    public void notifyDataSetChanged() {
        notifyDataSetChanged(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter
    public void notifyDataSetChangedWithNoAnimation() {
        notifyDataSetChanged(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter
    public void notifyItemChanged(int i) {
        AbstractC0000a.m3D(i, "notifyItemChanged# ", TAG);
        if (this.mIsPendingDataSetChanged) {
            this.mPendingItemChangedQueue.clear();
        } else if (!this.mDefaultItemAnimator.isRunning()) {
            callNotifyItemChanged(i);
        } else {
            this.mPendingItemChangedQueue.add(new ChangeInfo(i));
            setListener();
        }
    }

    public void setPageAdapter(PageAdapter pageAdapter) {
        this.mPageAdapter = pageAdapter;
        if (pageAdapter == null) {
            this.mPendingItemChangedQueue.clear();
            this.mIsPendingDataSetChanged = false;
        }
    }

    private void notifyDataSetChanged(boolean z) {
        Logger.m10999d(TAG, "notifyDataSetChanged# " + this.mDefaultItemAnimator.isRunning());
        if (this.mRecyclerView.getItemAnimator() == null) {
            callNotifyDataSetChanged();
            this.mIsPendingDataSetChanged = false;
            this.mPendingItemChangedQueue.clear();
        } else {
            if (this.mIsPendingDataSetChanged) {
                return;
            }
            if (!this.mDefaultItemAnimator.isRunning()) {
                callNotifyDataSetChanged();
            } else {
                this.mIsPendingDataSetChanged = true;
                setListener();
            }
        }
    }
}
