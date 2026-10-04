package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.common.InputEventChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageIndexInfoView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class BaseModeTopLayout {
    private static final String TAG = Logger.createTag("BaseModeTopLayout");
    private View mBookmarkBtn;
    private final View mButtonContainer;
    private CompListPresenter mCompListPresenter;
    private final Contract mContract;
    private TextView mEditBtn;
    private final InputEventChecker mInputEventChecker;
    private final boolean mIsTablet;
    private final View mLayout;
    private PageIndexInfoView mPageIndexInfoView;
    private PageListPresenter mPresenter;
    private View mSearchBtn;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        PageAdapter getAdapter();

        void showSearchMode();
    }

    public BaseModeTopLayout(View view, boolean z, Contract contract) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_page_list_base_mode_toolbar);
        this.mLayout = viewFindViewById;
        this.mButtonContainer = viewFindViewById.findViewById(C9086R.id.comp_page_list_btn_container);
        this.mInputEventChecker = new InputEventChecker();
        this.mIsTablet = z;
        this.mContract = contract;
    }

    private void initCloseButton(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_page_list_close_btn);
        if (ResourceUtils.isTabletLayout(view.getContext())) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BaseModeTopLayout.this.mPresenter.onClose();
                    BaseModeTopLayout.this.mCompListPresenter.hide(false);
                }
            });
            setButtonToolTipVoiceAssist(viewFindViewById);
        }
    }

    private void initPageIndexView(View view) {
        PageIndexInfoView pageIndexInfoView = new PageIndexInfoView(new PageIndexInfoView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageIndexInfoView.Contract
            public int getCurrentPageIndex() {
                if (BaseModeTopLayout.this.mContract.getAdapter() == null) {
                    return 0;
                }
                return BaseModeTopLayout.this.mContract.getAdapter().getCurrentPageIndex();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageIndexInfoView.Contract
            public View getNextView() {
                return BaseModeTopLayout.this.mButtonContainer;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageIndexInfoView.Contract
            public int getTotalPageCount() {
                if (BaseModeTopLayout.this.mContract.getAdapter() == null) {
                    return 0;
                }
                return BaseModeTopLayout.this.mContract.getAdapter().getOriginalItemCount();
            }
        }, this.mPresenter, this.mIsTablet);
        this.mPageIndexInfoView = pageIndexInfoView;
        pageIndexInfoView.init(view);
        this.mButtonContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (i6 == i || BaseModeTopLayout.this.mContract.getAdapter() == null) {
                    return;
                }
                BaseModeTopLayout.this.mPageIndexInfoView.updatePageCountView(BaseModeTopLayout.this.mContract.getAdapter().getOriginalItemCount() - 1, true);
            }
        });
    }

    private void initSearchButton(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_list_search_btn);
        this.mSearchBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseModeTopLayout.this.mContract.showSearchMode();
                if (BaseModeTopLayout.this.mIsTablet) {
                    ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_SEARCH);
                } else {
                    ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_SEARCH_MODE);
                }
            }
        });
        setButtonToolTipVoiceAssist(this.mSearchBtn);
    }

    private void setButtonToolTipVoiceAssist(View view) {
        ViewCompat.getInstance().setTooltipText(view);
        view.setAccessibilityDelegate(new VoiceAssistAsButton());
    }

    public View getBookmarkBtn() {
        return this.mBookmarkBtn;
    }

    public PageIndexInfoView getPageIndexInfoView() {
        return this.mPageIndexInfoView;
    }

    public View getSearchBtn() {
        return this.mSearchBtn;
    }

    public View getView() {
        return this.mLayout;
    }

    public void init(View view) {
        initPageIndexView(view);
        initEditButton(view);
        initBookmarkButton(view);
        initCloseButton(view);
        initSearchButton(view);
    }

    public void initBookmarkButton(View view) {
        this.mBookmarkBtn = view.findViewById(C9086R.id.comp_page_list_bookmark_btn);
        if (!this.mPresenter.isEditable() || !this.mPresenter.isEnabledBookmark()) {
            this.mBookmarkBtn.setVisibility(8);
            return;
        }
        this.mBookmarkBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Logger.m11003i(BaseModeTopLayout.TAG, "setBookmarkEnabled# selected: " + view2.isSelected());
                BaseModeTopLayout.this.mPresenter.hideSoftInput(view2);
                BaseModeTopLayout.this.mPresenter.setMode(view2.isSelected() ? 0 : 3);
            }
        });
        setButtonToolTipVoiceAssist(this.mBookmarkBtn);
        this.mBookmarkBtn.setVisibility(0);
    }

    public void initEditButton(View view) {
        Context context = view.getContext();
        TextView textView = (TextView) view.findViewById(C9086R.id.comp_page_list_edit_btn);
        this.mEditBtn = textView;
        if (textView == null) {
            Logger.m11000e(TAG, "initEditButton: edit button is null! ");
            return;
        }
        textView.setAccessibilityDelegate(new VoiceAssistAsButton());
        ButtonShapeUtil.setButtonShapeEnabled(this.mEditBtn);
        if (!this.mPresenter.isEditable() || this.mPresenter.hasUnknownObject() || this.mPresenter.getComponentFactory().getConfig().isOnlyDeletableInPageList()) {
            this.mEditBtn.setVisibility(8);
            return;
        }
        this.mEditBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseModeTopLayout.this.mPresenter.onEditClicked(BaseModeTopLayout.this.mInputEventChecker.getToolType());
            }
        });
        this.mEditBtn.setOnTouchListener(this.mInputEventChecker);
        CharUtils.applyTextSizeUntilLargeSize(context, this.mEditBtn, com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils.convertPixelToSp(context, context.getResources().getDimension(C9086R.dimen.comp_page_list_toolbar_menu_text_size)));
        setButtonToolTipVoiceAssist(this.mEditBtn);
        this.mEditBtn.setVisibility(0);
    }

    public void setPresenter(CompListPresenter compListPresenter) {
        this.mCompListPresenter = compListPresenter;
        this.mPresenter = compListPresenter.getPageListPresenter();
    }

    public void setVisibility(int i) {
        this.mLayout.setVisibility(i);
    }

    public void updateNotEditableState() {
        if (this.mPresenter.isEditable()) {
            return;
        }
        this.mEditBtn.setVisibility(8);
        this.mBookmarkBtn.setVisibility(8);
    }

    public void updateView(View view) {
        boolean z = false;
        boolean z2 = this.mBookmarkBtn.getVisibility() == 0;
        if (this.mPresenter.isEditable() && this.mPresenter.isEnabledBookmark()) {
            z = true;
        }
        if (z2 != z) {
            initBookmarkButton(view);
        }
    }
}
