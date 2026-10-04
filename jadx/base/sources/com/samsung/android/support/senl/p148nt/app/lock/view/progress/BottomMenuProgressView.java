package com.samsung.android.support.senl.p148nt.app.lock.view.progress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.navigation.NavigationBarItemView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class BottomMenuProgressView {
    private final NavigationBarItemView mItem;
    private boolean mIsShowing = false;
    private final List<View> mBackupViews = new ArrayList();

    public BottomMenuProgressView(NavigationBarItemView navigationBarItemView) {
        this.mItem = navigationBarItemView;
    }

    private void backupChildViews() {
        this.mBackupViews.clear();
        for (int i = 0; i < this.mItem.getChildCount(); i++) {
            this.mBackupViews.add(this.mItem.getChildAt(i));
        }
        this.mItem.removeAllViews();
    }

    private void restoreChildViews() {
        this.mItem.removeAllViews();
        if (this.mBackupViews.isEmpty()) {
            return;
        }
        Iterator<View> it = this.mBackupViews.iterator();
        while (it.hasNext()) {
            this.mItem.addView(it.next());
        }
    }

    public void hide() {
        restoreChildViews();
        this.mIsShowing = false;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void show(Context context) {
        backupChildViews();
        LayoutInflater.from(context).inflate(C8003R.layout.notes_progress_circle_small, (ViewGroup) this.mItem, true);
        this.mIsShowing = true;
    }
}
