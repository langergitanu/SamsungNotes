package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
interface ITitleEditorLayout {
    boolean hide(boolean z);

    void hideAfterToolbarSetTitle();

    boolean isAnimating();

    boolean isShowing();

    void release();

    void show();

    boolean updateFavorite(boolean z);

    void updateTitleAndFolderWidth();

    void updateTitleWidth(int i);
}
