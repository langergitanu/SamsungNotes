package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolderLast;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolderVariable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageAdapter extends RecyclerView.Adapter<PageHolder> {
    private static final String TAG = Logger.createTag("PageAdapter");
    private final PageHolderVariable mPageHolderVariable;
    private IPageList mPageList;
    private PageListPresenter mPageListPresenter;

    public PageAdapter(PageHolderVariable pageHolderVariable) {
        this.mPageHolderVariable = pageHolderVariable;
    }

    private Bitmap loadPageThumbnail(PageHolder pageHolder, PageInfo pageInfo, PageId pageId, int i) {
        if (!pageId.getId().equals(pageHolder.getPageId()) || pageInfo.getThumbnailCreatedTime() > pageHolder.getLastThumbnailCreatedTime()) {
            return loadPageThumbnail(pageInfo, pageId, i);
        }
        Bitmap bitmap = pageHolder.getThumbnailView().getDrawable() instanceof BitmapDrawable ? ((BitmapDrawable) pageHolder.getThumbnailView().getDrawable()).getBitmap() : null;
        return (bitmap == null || pageId.getSearchThumbnailPath() != null) ? loadPageThumbnail(pageInfo, pageId, i) : bitmap;
    }

    private void onBind(PageHolder pageHolder, int i, PageInfo pageInfo, Bitmap bitmap) {
        String pageId = pageInfo.getPageId();
        pageHolder.resize(pageInfo.getRatio());
        pageHolder.onBind(pageId, this.mPageListPresenter.getDataIndex(pageId), i, this.mPageListPresenter.isBookmarked(pageId), this.mPageListPresenter.isChecked(pageId), pageInfo.getThumbnailFilePath(), this.mPageHolderVariable.getBackgroundColor());
        pageHolder.setThumbnailLayout(bitmap, pageInfo.getThumbnailWidth(), pageInfo.getThumbnailHeight(), pageInfo.getRatio(), pageInfo.getThumbnailCreatedTime());
        this.mPageHolderVariable.getPageReorderController().setDragLayout(pageHolder, i);
    }

    public int getCurrentPageIndex() {
        return this.mPageHolderVariable.getCurrentPageIndex();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mPageList.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.mPageList.getItemCount() > i) {
            return this.mPageList.getItem(i).getId().hashCode();
        }
        Logger.m11000e(TAG, "getItemId# size: " + this.mPageList.getItemCount() + " position : " + i);
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mPageList.getAllPageCount() - 1 <= i ? 1 : 0;
    }

    public int getMode() {
        return this.mPageHolderVariable.getMode();
    }

    public int getOriginalItemCount() {
        return this.mPageList.getAllPageCount();
    }

    public void onOrientationChanged() {
        notifyDataSetChanged();
    }

    public void setBackgroundColor(int i) {
        this.mPageHolderVariable.setBackgroundColor(i);
    }

    public void setCurrentPageIndex(int i) {
        this.mPageHolderVariable.setCurrentPageIndex(i);
    }

    public void setDisableAddPage(boolean z) {
        this.mPageHolderVariable.setDisableAddPage(z);
    }

    public void setItemList(IPageList iPageList) {
        this.mPageList = iPageList;
    }

    public void setMode(int i, Resources resources) {
        this.mPageHolderVariable.setMode(i, resources);
    }

    public void setPresenter(PageListPresenter pageListPresenter) {
        this.mPageListPresenter = pageListPresenter;
        this.mPageHolderVariable.getPageReorderController().setPageDragListener(pageListPresenter.getDragListener());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull PageHolder pageHolder, int i) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "info: ", " ");
        sbM778t.append(pageHolder.hashCode());
        sbM778t.append(" ");
        StringBuilder sb = new StringBuilder(sbM778t.toString());
        String str = TAG;
        Logger.m10999d(str, "onBindViewHolder#start " + ((Object) sb));
        PageId item = this.mPageList.getItem(i);
        PageInfo pageInfo = this.mPageList.getPageInfo(item.getId());
        sb.append(pageInfo);
        if (pageInfo == null) {
            pageHolder.setNoInfoState();
            Logger.m11000e(str, "onBindViewHolder# pageInfo is null. " + ((Object) sb));
            return;
        }
        onBind(pageHolder, i, pageInfo, loadPageThumbnail(pageHolder, pageInfo, item, i));
        Logger.m10999d(str, "onBindViewHolder#end " + ((Object) sb));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public PageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_item_layout, viewGroup, false);
        return i == 1 ? new PageHolderLast(viewInflate, this.mPageListPresenter.getPageHolderPresenter(), this.mPageHolderVariable) : new PageHolder(viewInflate, this.mPageListPresenter.getPageHolderPresenter(), this.mPageHolderVariable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull PageHolder pageHolder) {
        Logger.m10999d(TAG, "onFailedToRecycleView " + pageHolder.getIndex());
        return super.onFailedToRecycleView(pageHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull PageHolder pageHolder) {
        String str = TAG;
        Logger.m10999d(str, "onViewRecycled# " + pageHolder.getIndex() + " / " + pageHolder.itemView.getId() + " " + this.mPageHolderVariable.getMode() + " " + pageHolder.hashCode());
        this.mPageListPresenter.hideMoreListPopup(pageHolder.getPageId());
        super.onViewRecycled(pageHolder);
        pageHolder.clearThumbnailView();
        StringBuilder sb = new StringBuilder("onViewRecycled#end ");
        sb.append(pageHolder.getIndex());
        Logger.m10999d(str, sb.toString());
    }

    private Bitmap loadPageThumbnail(PageInfo pageInfo, PageId pageId, int i) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "loadPageThumbnail# pos: ", " pId: ");
        sbM778t.append(pageId.getId());
        StringBuilder sb = new StringBuilder(sbM778t.toString());
        String thumbnailFilePath = pageInfo.getThumbnailFilePath();
        if (thumbnailFilePath == null) {
            this.mPageListPresenter.requestMakeThumbnail(i);
            return null;
        }
        if (pageInfo.isDirty()) {
            this.mPageListPresenter.requestMakeThumbnail(i);
        }
        if (pageId.getSearchThumbnailPath() != null) {
            sb.append("searchPath# ");
            sb.append(pageId.getSearchThumbnailPath());
            sb.append(Constant.WHITE_SPACE_FOR_LINK_ICON);
            thumbnailFilePath = pageId.getSearchThumbnailPath();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        sb.append("  path: ");
        sb.append(thumbnailFilePath);
        Bitmap bitmapDecodeFile = TextUtils.isEmpty(thumbnailFilePath) ? null : BitmapFactory.decodeFile(thumbnailFilePath, options);
        Logger.m10999d(TAG, sb.toString());
        return bitmapDecodeFile;
    }
}
