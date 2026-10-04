package com.samsung.android.support.senl.p148nt.app.lock.view.progress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class OptionMenuProgressView {
    private static final int DEFAULT_MARGIN_RIGHT = 32;
    private static final int DEFAULT_WIDTH = 186;
    private boolean mIsShowing = false;
    private final int mMenuIndex;
    private final Toolbar mToolbar;

    public OptionMenuProgressView(Toolbar toolbar, int i) {
        this.mToolbar = toolbar;
        this.mMenuIndex = i;
    }

    public void hide() {
        this.mToolbar.getMenu().getItem(this.mMenuIndex).setActionView((View) null);
        this.mIsShowing = false;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void show(Context context) {
        if (this.mToolbar.getMenu() == null || this.mToolbar.getMenu().size() == 0) {
            return;
        }
        MenuItem item = this.mToolbar.getMenu().getItem(this.mMenuIndex);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.mToolbar.findViewById(item.getItemId());
        View viewInflate = LayoutInflater.from(context).inflate(C8003R.layout.notes_progress_circle_small, (ViewGroup) null);
        if (actionMenuItemView != null) {
            viewInflate.setLayoutParams(actionMenuItemView.getLayoutParams());
        } else {
            viewInflate.setLayoutParams(new ViewGroup.LayoutParams(186, -2));
            viewInflate.setPadding(0, 0, 32, 0);
        }
        item.setActionView(viewInflate);
        this.mIsShowing = true;
    }
}
