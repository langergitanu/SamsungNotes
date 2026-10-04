package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.DeveloperMode;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Favorite {
    private static final String TAG = Logger.createTag(FolderConstants.Favorite.DISPLAY_NAME);
    private TitleEditorPresenter mPresenter;
    private int mThemeColor;
    private ImageView mView;

    public Favorite(View view, TitleEditorPresenter titleEditorPresenter) {
        this.mView = (ImageView) view.findViewById(C9086R.id.comp_title_favorite);
        this.mPresenter = titleEditorPresenter;
    }

    public View getView() {
        return this.mView;
    }

    public void init(float f) {
        this.mView.setAlpha(f);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.Favorite.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeveloperMode.checkOnDeveloperMode();
                if (Favorite.this.mView.getAlpha() != 1.0f) {
                    Logger.m10999d(Favorite.TAG, "onClick# The title is being hidden. skip favorite click event.");
                    return;
                }
                Favorite.this.mPresenter.setFavorite(!Favorite.this.mPresenter.isFavorite());
                if (Favorite.this.mPresenter.isFavorite()) {
                    ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_FAVORITES, "0");
                } else {
                    ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_FAVORITES, "1");
                }
            }
        });
        this.mView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.Favorite.2
            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                if ((i == 1 || i == 32768) && Favorite.this.mPresenter != null) {
                    if (Favorite.this.mPresenter.isFavorite()) {
                        view.setContentDescription(Favorite.this.mView.getResources().getString(C9086R.string.composer_remove_from_favorite));
                    } else {
                        view.setContentDescription(Favorite.this.mView.getResources().getString(C9086R.string.composer_add_to_favorite));
                    }
                }
                super.sendAccessibilityEvent(view, i);
            }
        });
        updateState();
    }

    public void setEnable(boolean z) {
        this.mView.setEnabled(z);
    }

    public void setThemeColor(int i) {
        this.mThemeColor = i;
    }

    public void setVisible(boolean z) {
        this.mView.setVisibility(z ? 0 : 8);
    }

    public void updateState() {
        if (this.mPresenter.isMde()) {
            this.mView.setVisibility(8);
        } else {
            updateState(this.mPresenter.isFavorite(), false);
        }
    }

    public void updateState(boolean z, boolean z2) {
        int i;
        String string;
        String string2;
        Resources resources = this.mView.getResources();
        if (z) {
            i = C9086R.drawable.comp_title_ic_favorite_on;
            string = resources.getString(C9086R.string.composer_favorite_note_added);
            string2 = resources.getString(C9086R.string.composer_remove_from_favorite);
        } else {
            i = C9086R.drawable.comp_title_ic_favorite_off;
            string = resources.getString(C9086R.string.composer_favorite_note_removed);
            string2 = resources.getString(C9086R.string.composer_add_to_favorite);
        }
        this.mView.setImageResource(i);
        this.mView.setTag(Integer.valueOf(i));
        if (z) {
            this.mView.clearColorFilter();
        } else {
            this.mView.setColorFilter(this.mThemeColor);
        }
        if (z2) {
            this.mView.announceForAccessibility(string);
        }
        ViewCompat.getInstance().setTooltipText(this.mView, string2);
    }
}
