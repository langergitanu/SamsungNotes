package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.CustomAccessibilityDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DwMenuItem {
    protected static final float DISABLED_ALPHA = 0.4f;
    protected static final float ENABLED_ALPHA = 1.0f;
    private static final String TAG = Logger.createTag("DwMenuItem");
    protected DwToolbarPresenter mPresenter;
    protected View mView;

    public DwMenuItem(View view) {
        this.mView = view;
    }

    public int getColorTheme(int i) {
        return 1;
    }

    public View getView() {
        return this.mView;
    }

    public int getViewCenterPosition() {
        int[] iArr = new int[2];
        this.mView.getLocationInWindow(iArr);
        return (this.mView.getWidth() / 2) + iArr[0];
    }

    public void init(DwToolbarPresenter dwToolbarPresenter) {
        this.mPresenter = dwToolbarPresenter;
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(DwMenuItem.TAG, "onClick ");
                DwMenuItem.this.onClicked();
            }
        });
        ViewCompat viewCompat = ViewCompat.getInstance();
        View view = this.mView;
        viewCompat.setTooltipText(view, view.getContentDescription());
    }

    public void initAccessibilityDelegate() {
        Resources resources = this.mView.getResources();
        View view = this.mView;
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(resources, C9086R.string.rich_text_font_color_popup_selected, sb, SQLKeyword.COMMA);
        sb.append((Object) this.mView.getContentDescription());
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        AbstractC8014b.m7202d(resources, C9086R.string.rich_text_font_color_popup_not_selected, sb2, SQLKeyword.COMMA);
        sb2.append((Object) this.mView.getContentDescription());
        view.setAccessibilityDelegate(new CustomAccessibilityDelegate(string, sb2.toString()));
    }

    public boolean onBackPressed() {
        return false;
    }

    public abstract void onClicked();

    public void onDetach() {
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    public void onUpdate() {
    }

    public void release() {
    }

    public void restore(@NonNull Bundle bundle) {
    }

    public void setEnable(boolean z) {
        if (z == this.mView.isEnabled()) {
            return;
        }
        this.mView.setEnabled(z);
        this.mView.setAlpha(z ? 1.0f : 0.4f);
    }
}
