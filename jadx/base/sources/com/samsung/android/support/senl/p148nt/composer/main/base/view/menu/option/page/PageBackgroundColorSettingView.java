package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPageSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageBackgroundColorSettingView {
    private static final String TAG = Logger.createTag("PageBackgroundColorSettingView");
    private OptionMenuPageSettingPresenter mPresenter;

    private void initViewType(View view) {
        CompBackgroundColorSettingsView compBackgroundColorSettingsView = (CompBackgroundColorSettingsView) view.findViewById(C9086R.id.comp_background_color_setting_view);
        compBackgroundColorSettingsView.setContract(new CompBackgroundColorSettingsView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.PageBackgroundColorSettingView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public boolean canEnableInvertLayout() {
                return PageBackgroundColorSettingView.this.mPresenter.getBackgroundColorInvertPresenter().canEnableInvertLayout();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public int getBackgroundColor() {
                return PageBackgroundColorSettingView.this.mPresenter.getBackgroundColor();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public void invertBackgroundColor(boolean z) {
                PageBackgroundColorSettingView.this.mPresenter.getBackgroundColorInvertPresenter().invertBackgroundColor(z);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public boolean isBackgroundColorInverted() {
                return PageBackgroundColorSettingView.this.mPresenter.getBackgroundColorInvertPresenter().isBackgroundColorInverted();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public boolean isCoeditNote() {
                return PageBackgroundColorSettingView.this.mPresenter.isCoeditNote();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public void loggingOnInvertChanged(boolean z) {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_BACKGROUND_COLOR_DARK_MODE, z ? "1" : "0");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public void loggingOnPaletteClicked() {
                if (isCoeditNote()) {
                    ComposerSA.insertLog("683", "3521");
                } else {
                    ComposerSA.insertLog("401", "3521");
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public void notifyChanged() {
                PageBackgroundColorSettingView.this.mPresenter.notifyChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.Contract
            public void setBackgroundColor(int i) {
                PageBackgroundColorSettingView.this.mPresenter.setBackgroundColor(i);
            }
        });
        compBackgroundColorSettingsView.initStatus();
    }

    public void init(Activity activity, ViewGroup viewGroup, OptionMenuPageSettingPresenter optionMenuPageSettingPresenter) {
        this.mPresenter = optionMenuPageSettingPresenter;
        initViewType(View.inflate(activity, C9086R.layout.comp_page_background_color_setting_layout, viewGroup));
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
    }
}
