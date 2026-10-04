package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageItemView extends FrameLayout implements PageDragListenerImpl.IPageItemView {
    private int mIndex;
    private String mPageId;

    public PageItemView(@NonNull Context context) {
        super(context);
        this.mIndex = -1;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.IPageItemView
    public int getIndex() {
        return this.mIndex;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.IPageItemView
    public String getPageId() {
        return this.mPageId;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setPageId(String str) {
        this.mPageId = str;
    }

    public PageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndex = -1;
    }

    public PageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mIndex = -1;
    }
}
