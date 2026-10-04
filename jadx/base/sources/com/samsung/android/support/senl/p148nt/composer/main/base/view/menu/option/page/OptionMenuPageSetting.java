package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPageSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.PageRatioSettingView;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuPageSetting {
    private static final String TAG = Logger.createTag("OptionMenuPageSetting");
    private final Activity mActivity;
    private PageBackgroundColorSettingView mPageBackgroundColorSettingView;
    private PageRatioSettingView mPageRatioSettingView;
    private PageScrollDirectionSettingView mPageScrollDirectionSettingView;
    private PopupWindow mPopupWindow;
    private final OptionMenuPageSettingPresenter mPresenter;

    public OptionMenuPageSetting(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter.getOptionMenuPageSettingPresenter();
    }

    private PageRatioSettingView.Presenter createPageRatioSettingViewPresenter() {
        return new PageRatioSettingView.Presenter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.OptionMenuPageSetting.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.PageRatioSettingView.Presenter
            public DocumentPageRatio.PageRatioType getPageRatio() {
                return OptionMenuPageSetting.this.mPresenter.getPageRatio();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.PageRatioSettingView.Presenter
            public void setPageRatio(DocumentPageRatio.PageRatioType pageRatioType) {
                OptionMenuPageSetting.this.mPresenter.setPageRatio(pageRatioType);
            }
        };
    }

    public void hidePopup() {
        Logger.m11003i(TAG, "hidePopup#");
        PageRatioSettingView pageRatioSettingView = this.mPageRatioSettingView;
        if (pageRatioSettingView != null) {
            pageRatioSettingView.release();
        }
        PageScrollDirectionSettingView pageScrollDirectionSettingView = this.mPageScrollDirectionSettingView;
        if (pageScrollDirectionSettingView != null) {
            pageScrollDirectionSettingView.release();
        }
        PageBackgroundColorSettingView pageBackgroundColorSettingView = this.mPageBackgroundColorSettingView;
        if (pageBackgroundColorSettingView != null) {
            pageBackgroundColorSettingView.release();
        }
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    public void show(boolean z) {
        View viewInflate = View.inflate(this.mActivity, C9086R.layout.comp_page_setting_container_layout, null);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(C9086R.id.page_setting_top_container);
        if (this.mPresenter.isPageRatioAvailable()) {
            PageRatioSettingView pageRatioSettingView = new PageRatioSettingView();
            this.mPageRatioSettingView = pageRatioSettingView;
            pageRatioSettingView.init(this.mActivity, viewGroup, createPageRatioSettingViewPresenter());
        }
        if (this.mPresenter.isNotSinglePageNote()) {
            PageScrollDirectionSettingView pageScrollDirectionSettingView = new PageScrollDirectionSettingView();
            this.mPageScrollDirectionSettingView = pageScrollDirectionSettingView;
            pageScrollDirectionSettingView.init(this.mActivity, viewGroup, this.mPresenter);
        }
        if (!z && this.mPresenter.isEnabledBgColor()) {
            PageBackgroundColorSettingView pageBackgroundColorSettingView = new PageBackgroundColorSettingView();
            this.mPageBackgroundColorSettingView = pageBackgroundColorSettingView;
            pageBackgroundColorSettingView.init(this.mActivity, viewGroup, this.mPresenter);
        }
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        this.mPopupWindow = popupWindow;
        OptionMenuPopupWindowHelper.setDefaultState(popupWindow, this.mActivity, C9086R.drawable.comp_page_setting_popup_bg);
        this.mPopupWindow.showAtLocation(this.mActivity.getWindow().getDecorView(), 81, 0, InputMethodCompat.getInstance().getNavigationBarHeight(this.mActivity) + this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.popup_window_y_location_offset));
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.OptionMenuPageSetting.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                OptionMenuPageSetting.this.mPopupWindow = null;
                if (OptionMenuPageSetting.this.mPageRatioSettingView != null) {
                    OptionMenuPageSetting.this.mPageRatioSettingView.release();
                }
                if (OptionMenuPageSetting.this.mPageScrollDirectionSettingView != null) {
                    OptionMenuPageSetting.this.mPageScrollDirectionSettingView.release();
                }
                if (OptionMenuPageSetting.this.mPageBackgroundColorSettingView != null) {
                    OptionMenuPageSetting.this.mPageBackgroundColorSettingView.release();
                }
                OptionMenuPageSetting.this.mPresenter.showKeyboard();
            }
        });
        this.mPresenter.hideKeyboard();
    }
}
