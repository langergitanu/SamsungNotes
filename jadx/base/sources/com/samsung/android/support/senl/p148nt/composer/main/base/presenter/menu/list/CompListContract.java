package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface CompListContract {
    public static final int MODE_NOTE_LIST = 2;
    public static final int MODE_PAGE_LIST = 1;

    void hide(boolean z);

    boolean hideForActivityResult();

    boolean isShown();

    void show(boolean z);
}
