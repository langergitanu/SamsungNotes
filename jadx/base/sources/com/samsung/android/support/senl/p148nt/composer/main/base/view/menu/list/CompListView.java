package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.ListPhoneAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.ListTabletAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CompListView implements CompListContract {
    private IListAnimator mAnimator;
    private final View mCompListViewBorder;
    private final ViewGroup mComposerAppBarContainer;
    private final ViewGroup mComposerContainer;
    private final boolean mIsTabletLayout;
    private final IListAnimator.IAnimatorListener mListener = new IListAnimator.IAnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.CompListView.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.IListAnimator.IAnimatorListener
        public void onHidingAnimationEnd() {
            CompListView.this.hideWithoutAnim();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.IListAnimator.IAnimatorListener
        public void onShowingAnimationEnd() {
            CompListView.this.setVisibleOfComposerContainer(false);
            CompListView.this.mPresenter.getPageListPresenter().setBlockThumbnailUpdate(false);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.IListAnimator.IAnimatorListener
        public void onShowingAnimationStart() {
            CompListView.this.mPresenter.getPageListPresenter().setBlockThumbnailUpdate(true);
        }
    };
    private PageListView mPageList;
    private CompListPresenter mPresenter;
    private final ViewGroup mViewContainer;

    public CompListView(Activity activity) {
        boolean zIsTabletLayout = ResourceUtils.isTabletLayout(activity);
        this.mIsTabletLayout = zIsTabletLayout;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(C9086R.id.comp_list_container);
        this.mViewContainer = viewGroup;
        this.mCompListViewBorder = activity.findViewById(C9086R.id.comp_list_container_border);
        this.mComposerContainer = (ViewGroup) activity.findViewById(C9086R.id.composer_fragment_content);
        this.mComposerAppBarContainer = (ViewGroup) activity.findViewById(C9086R.id.appbar_layout);
        BackgroundColorUtil.updateAntiGreenishColor(activity.getLayoutInflater().inflate(C9086R.layout.comp_list_menu_layout, viewGroup));
        if (zIsTabletLayout) {
            initTabletLayout(activity);
        } else {
            initPhoneLayout(activity);
        }
    }

    private void addPageList(Activity activity, ViewGroup viewGroup) {
        PageListResourceUtils.setDescriptions(activity);
        this.mPageList = new PageListView(activity, this.mViewContainer, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideWithoutAnim() {
        this.mAnimator.hideAnimationView();
        this.mViewContainer.setVisibility(8);
        View view = this.mCompListViewBorder;
        if (view != null) {
            view.setVisibility(8);
        }
        this.mPresenter.onPostHide();
    }

    private void initPhoneLayout(Activity activity) {
        addPageList(activity, this.mViewContainer);
        this.mAnimator = new ListPhoneAnimator(this.mViewContainer, activity.findViewById(C9086R.id.comp_list_background_view), this.mListener);
    }

    private void initTabletLayout(Activity activity) {
        addPageList(activity, (ViewGroup) this.mViewContainer.findViewById(C9086R.id.comp_list_internal_container));
        this.mAnimator = new ListTabletAnimator(this.mViewContainer, this.mListener, new ListTabletAnimator.IContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.CompListView.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListTabletAnimator.IContract
            public int getListWidth() {
                return CompListView.this.mPageList.getWidth();
            }
        });
    }

    private boolean isVisibleOfComposerContainer() {
        ViewGroup viewGroup = this.mComposerContainer;
        return viewGroup == null || viewGroup.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibleOfComposerContainer(boolean z) {
        ViewGroup viewGroup = this.mComposerContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 4);
            ViewGroup viewGroup2 = this.mComposerAppBarContainer;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(z ? 0 : 4);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListContract
    public void hide(boolean z) {
        this.mPresenter.onPreHide();
        setVisibleOfComposerContainer(true);
        if (z || SettingsCompat.getInstance().isRemoveAnimation(this.mViewContainer.getContext())) {
            hideWithoutAnim();
        } else {
            this.mAnimator.startHidingAnim();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListContract
    public boolean hideForActivityResult() {
        if (this.mIsTabletLayout || isVisibleOfComposerContainer()) {
            return false;
        }
        hide(false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListContract
    public boolean isShown() {
        return this.mViewContainer.isShown();
    }

    public boolean onBackPressed() {
        return this.mPresenter.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mPresenter.onConfigurationChanged(configuration);
    }

    public void setPresenter(CompListPresenter compListPresenter) {
        this.mPresenter = compListPresenter;
        compListPresenter.setView(this);
        this.mPageList.setPresenter(this.mPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListContract
    public void show(boolean z) {
        this.mViewContainer.setVisibility(0);
        View view = this.mCompListViewBorder;
        if (view != null) {
            view.setVisibility(0);
        }
        if (z || SettingsCompat.getInstance().isRemoveAnimation(this.mViewContainer.getContext())) {
            setVisibleOfComposerContainer(false);
        } else {
            this.mAnimator.startShowingAnim();
        }
    }

    public void updateView() {
        this.mPageList.updateView();
    }
}
