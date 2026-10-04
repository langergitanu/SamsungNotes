package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPageSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.widget.CompScrollDirectionSettingsView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageScrollDirectionSettingView {
    private static final String TAG = Logger.createTag("PageScrollDirectionSettingView");
    private Activity mActivity;
    private CompScrollDirectionSettingsView mCompScrollDirectionSettingsView;
    private OptionMenuPageSettingPresenter mPresenter;

    private void initViewType(View view) {
        CompScrollDirectionSettingsView compScrollDirectionSettingsView = (CompScrollDirectionSettingsView) view.findViewById(C9086R.id.comp_scroll_direction_setting_view);
        this.mCompScrollDirectionSettingsView = compScrollDirectionSettingsView;
        compScrollDirectionSettingsView.setContract(new CompScrollDirectionSettingsView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.PageScrollDirectionSettingView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompScrollDirectionSettingsView.Contract
            public boolean isSinglePage() {
                return !PageScrollDirectionSettingView.this.mPresenter.isTwoPage();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompScrollDirectionSettingsView.Contract
            public boolean isTwoPageButtonVisible() {
                return PageScrollDirectionSettingView.this.mPresenter.isTwoPageEnabled(PageScrollDirectionSettingView.this.mActivity);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompScrollDirectionSettingsView.Contract
            public boolean isVerticalScroll() {
                return PageScrollDirectionSettingView.this.mPresenter.isScrollVertical();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompScrollDirectionSettingsView.Contract
            public void onClick(@Nullable View view2) {
                if (view2 == null) {
                    return;
                }
                int id = view2.getId();
                if (id == C9086R.id.page_scroll_vertical_radio_button) {
                    PageScrollDirectionSettingView.this.mPresenter.setVerticalOnePage(true);
                    if (PageScrollDirectionSettingView.this.mPresenter.isCoeditNote()) {
                        ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_VERTICAL_SCROLL);
                    } else {
                        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_VERTICAL_SCROLL);
                    }
                    PageScrollDirectionSettingView.this.mPresenter.setVerticalOnePage(true);
                    PageScrollDirectionSettingView.this.updateViewTypeState();
                    return;
                }
                if (id == C9086R.id.page_scroll_horizontal_radio_button) {
                    if (PageScrollDirectionSettingView.this.mPresenter.isCoeditNote()) {
                        ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_HORIZONTAL_SCROLL);
                    } else {
                        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_HORIZONTAL_SCROLL);
                    }
                    PageScrollDirectionSettingView.this.mPresenter.setVerticalOnePage(false);
                    PageScrollDirectionSettingView.this.updateViewTypeState();
                    return;
                }
                if (id == C9086R.id.page_scroll_two_page_radio_button) {
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_TWO_PAGE);
                    PageScrollDirectionSettingView.this.mPresenter.setTwoPage();
                    PageScrollDirectionSettingView.this.updateViewTypeState();
                }
            }
        });
        updateViewTypeState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewTypeState() {
        this.mCompScrollDirectionSettingsView.updatePageScrollStyle();
    }

    public void init(Activity activity, ViewGroup viewGroup, OptionMenuPageSettingPresenter optionMenuPageSettingPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPageSettingPresenter;
        initViewType(View.inflate(activity, C9086R.layout.comp_page_scroll_direction_setting_layout, viewGroup));
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
    }
}
