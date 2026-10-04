package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface RtSettingContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISettingView {
        void createPalette(List<Integer> list, int i, boolean z);

        void onPaletteListChanged(List<Integer> list);

        void updateBackgroundColor(int i);

        void updateFontBgColor(int i);

        void updateFontColor(int i);

        void updateViewTheme(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NullSettingView implements ISettingView {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
        public void createPalette(List<Integer> list, int i, boolean z) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
        public void onPaletteListChanged(List<Integer> list) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
        public void updateBackgroundColor(int i) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
        public void updateFontBgColor(int i) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
        public void updateFontColor(int i) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
        public void updateViewTheme(boolean z) {
        }
    }
}
