package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.richtext.SettingPaletteData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtSettingPresenter {
    private ObjectManager mObjectManager;
    protected RtToolbarContract.IPresenter mRtPresenter;
    private SettingPaletteData mSettingPaletteData;
    private TextManager mTextManager;
    private WritingToolManager mWritingToolManager;

    public RtSettingPresenter() {
    }

    private void setDirectWriteBgColor(int i) {
        setDirectWriteColor(this.mTextManager.getTextColor(), i);
    }

    private void setDirectWriteColor(int i, int i2) {
        if (this.mRtPresenter.isDirectWriteUsing()) {
            this.mWritingToolManager.setSPenToTextTextColor(i, i2);
        }
    }

    private void setDirectWriteTextColor(int i) {
        setDirectWriteColor(i, this.mTextManager.getTextBgColor());
    }

    public int getBackgroundColor() {
        return this.mRtPresenter.getBackgroundColor();
    }

    public int getFontBgColor() {
        return this.mRtPresenter.getLastRtState().getFontBgColor().getValue();
    }

    public int getFontColor() {
        return this.mRtPresenter.getLastRtState().getFontColor().getValue();
    }

    public boolean getIsViewDarkTheme() {
        return this.mRtPresenter.isComposerViewDarkTheme();
    }

    public List<Integer> getPaletteList() {
        return this.mSettingPaletteData.getPaletteList();
    }

    public void setEnableMenus(boolean z, List<Integer> list) {
        if (this.mRtPresenter.getView() != null) {
            this.mRtPresenter.getView().enableMenus(z, list);
        }
    }

    public void setPaletteList(List<Integer> list) {
        if (this.mSettingPaletteData.isEquals(list)) {
            return;
        }
        this.mSettingPaletteData.setPaletteList(list);
        if (this.mRtPresenter.getView() != null) {
            this.mRtPresenter.getView().onPaletteListChanged(list);
        }
    }

    public void setTextBgColor(int i) {
        ObjectManager objectManager = this.mObjectManager;
        if (objectManager == null || this.mTextManager == null) {
            return;
        }
        objectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setTextBgColor(i);
        this.mObjectManager.commitHistory();
        setDirectWriteBgColor(i);
    }

    public void setTextColor(int i) {
        ObjectManager objectManager = this.mObjectManager;
        if (objectManager == null || this.mTextManager == null) {
            return;
        }
        objectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setTextColor(i);
        this.mObjectManager.commitHistory();
        setDirectWriteTextColor(i);
    }

    public void updateBackgroundColor(int i) {
    }

    public void updateFontBgColor(int i) {
    }

    public void updateFontColor(int i) {
    }

    public void updateViewTheme(boolean z) {
    }

    public RtSettingPresenter(ComposerViewContract.IPresenter iPresenter, RtToolbarContract.IPresenter iPresenter2) {
        this.mTextManager = iPresenter.getTextManager();
        this.mObjectManager = iPresenter.getObjectManager();
        this.mWritingToolManager = iPresenter.getWritingToolManager();
        this.mRtPresenter = iPresenter2;
        this.mSettingPaletteData = new SettingPaletteData(iPresenter.getActivity());
    }
}
