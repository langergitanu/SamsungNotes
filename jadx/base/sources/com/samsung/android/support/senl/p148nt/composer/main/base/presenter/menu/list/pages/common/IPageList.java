package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IPageList {
    int getAllPageCount();

    PageId getItem(int i);

    int getItemCount();

    PageInfo getPageInfo(String str);
}
