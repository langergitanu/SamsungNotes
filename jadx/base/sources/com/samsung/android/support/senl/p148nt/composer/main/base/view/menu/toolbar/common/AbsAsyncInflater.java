package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsAsyncInflater {
    private final AsyncLayoutInflater mAsyncLayoutInflater;
    private final ArrayList<Runnable> mPendingActionList = new ArrayList<>();
    private AtomicBoolean mIsInflated = new AtomicBoolean(false);

    public AbsAsyncInflater(Context context) {
        this.mAsyncLayoutInflater = new AsyncLayoutInflater(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumeAllPendingAction() {
        Iterator<Runnable> it = this.mPendingActionList.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.mPendingActionList.clear();
    }

    public void addPendingActionAfterInflate(Runnable runnable) {
        this.mPendingActionList.add(runnable);
    }

    public void asyncInflate(@LayoutRes int i, ViewGroup viewGroup) {
        this.mAsyncLayoutInflater.inflate(i, viewGroup, new AsyncLayoutInflater.OnInflateFinishedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater.1
            @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
            public void onInflateFinished(@NonNull View view, int i2, @Nullable ViewGroup viewGroup2) {
                AbsAsyncInflater.this.mIsInflated.set(true);
                if (viewGroup2 != null) {
                    viewGroup2.addView(view);
                }
                AbsAsyncInflater.this.onInflated(view);
                AbsAsyncInflater.this.consumeAllPendingAction();
            }
        });
    }

    public boolean isInflated() {
        return this.mIsInflated.get();
    }

    public abstract void onInflated(View view);

    public void release() {
        this.mPendingActionList.clear();
    }
}
