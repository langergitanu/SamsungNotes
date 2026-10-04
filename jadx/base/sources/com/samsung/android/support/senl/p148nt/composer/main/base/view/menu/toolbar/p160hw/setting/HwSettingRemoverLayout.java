package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.LazyUpdateHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingRemoverLayout extends HwSettingLayout {
    private static final int ERASE_ALL_RESULT_FIRST = 0;
    private static final int ERASE_ALL_RESULT_SECOND = 1;
    private static final int ERASE_ALL_RESULT_THIRD = 2;
    private static final int ERASE_ALL_TYPE_CURRENT_PAGE = 1;
    private static final int ERASE_ALL_TYPE_NONE = 0;
    private static final int ERASE_ALL_TYPE_TWO_PAGE = 2;
    private static final String TAG = Logger.createTag("HwSettingRemoverLayout");
    private int mEraseAllType;
    private final boolean mIsCoeditNote;
    private boolean mIsSkipRemoverInfoChanged = false;
    private final LazyUpdateHelper mLazyUpdateHelper = new LazyUpdateHelper(new LazyUpdateHelper.Callback<SpenSettingRemoverInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingRemoverLayout.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.LazyUpdateHelper.Callback
        public void onLazyUpdate(SpenSettingRemoverInfo spenSettingRemoverInfo) {
            Logger.m11003i(HwSettingRemoverLayout.TAG, "onLazyUpdate");
            HwSettingRemoverLayout.this.mSettingViewManager.getSettingInstance().setRemoverSettingInfo(spenSettingRemoverInfo);
            if (spenSettingRemoverInfo.type == 1) {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASE_AREA, "1");
            } else {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASE_AREA, "2");
            }
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASE_HIGHLIGHTER_ONLY, spenSettingRemoverInfo.target == 2 ? "a" : "b");
        }
    });
    protected SpenSettingRemoverLayout mSpenSettingRemoverLayout;

    public HwSettingRemoverLayout(boolean z) {
        this.mIsCoeditNote = z;
    }

    private boolean internalHide(boolean z) {
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        if (spenSettingRemoverLayout == null) {
            return false;
        }
        inOutVI(spenSettingRemoverLayout, z);
        this.mSpenSettingRemoverLayout.setVisibility(8);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        if (spenSettingRemoverLayout != null) {
            spenSettingRemoverLayout.close();
            this.mSpenSettingRemoverLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (internalHide(z)) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_ERASER_SETTINGS_OPEN_AND_CLOSE, "3");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingRemoverLayout != null) {
            return;
        }
        SpenSettingRemoverLayout spenSettingRemoverLayout = new SpenSettingRemoverLayout(this.mFloatingContainer.getContext(), true, !this.mIsCoeditNote);
        this.mSpenSettingRemoverLayout = spenSettingRemoverLayout;
        spenSettingRemoverLayout.setInfo(this.mSettingViewManager.getSettingInfoManager().getRemoverInfoData().getSettingRemoverInfoSelected());
        this.mSpenSettingRemoverLayout.setRemoverInfoChangedListener(new SpenSettingRemoverLayout.RemoverInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingRemoverLayout.2
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.RemoverInfoChangedListener
            public void onRemoverInfoChanged(SpenSettingRemoverInfo spenSettingRemoverInfo) {
                Logger.m11003i(HwSettingRemoverLayout.TAG, "onRemoverInfoChanged");
                if (!HwSettingRemoverLayout.this.mIsSkipRemoverInfoChanged) {
                    HwSettingRemoverLayout.this.mLazyUpdateHelper.updateValue(spenSettingRemoverInfo);
                } else {
                    Logger.m11003i(HwSettingRemoverLayout.TAG, "skip onRemoverInfoChanged, it's occur by UI Update");
                    HwSettingRemoverLayout.this.mIsSkipRemoverInfoChanged = false;
                }
            }
        });
        addViewToFloatingContainer(this.mSpenSettingRemoverLayout);
        if (!this.mIsCoeditNote) {
            this.mSpenSettingRemoverLayout.setEraseAllListener(new SpenSettingRemoverLayout.EraseAllListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingRemoverLayout.3
                @Override // com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.EraseAllListener
                public void onEraseAll(int i, int i2) {
                    String str = HwSettingRemoverLayout.TAG;
                    StringBuilder sb = new StringBuilder("onEraseAll# mEraseAllType = ");
                    sb.append(HwSettingRemoverLayout.this.mEraseAllType);
                    sb.append("/");
                    sb.append(i);
                    sb.append(" / index = ");
                    AbstractC8014b.m7195A(sb, str, i2);
                    if (i == 0) {
                        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASE_ALL_HANDWRITING_ALL);
                        HwSettingRemoverLayout.this.mSettingViewManager.executeEraseAllOnAllPages();
                        return;
                    }
                    if (i == 1) {
                        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASE_ALL_HANDWRITING_CURRENT_PAGE);
                        if (HwSettingRemoverLayout.this.mEraseAllType == 1) {
                            if (i2 == 0) {
                                HwSettingRemoverLayout.this.mSettingViewManager.executeEraseAllOnAllPages();
                                return;
                            } else {
                                if (i2 == 1) {
                                    HwSettingRemoverLayout.this.mSettingViewManager.executeEraseAllOnCurrentPage(0);
                                    return;
                                }
                                return;
                            }
                        }
                        if (HwSettingRemoverLayout.this.mEraseAllType == 2) {
                            if (i2 == 0) {
                                HwSettingRemoverLayout.this.mSettingViewManager.executeEraseAllOnAllPages();
                            } else if (i2 == 1) {
                                HwSettingRemoverLayout.this.mSettingViewManager.executeEraseAllOnCurrentPage(1);
                            } else if (i2 == 2) {
                                HwSettingRemoverLayout.this.mSettingViewManager.executeEraseAllOnCurrentPage(2);
                            }
                        }
                    }
                }
            });
        }
        this.mSpenSettingRemoverLayout.setVisibilityChangedListener(new SpenPopupLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingRemoverLayout.4
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int i) {
                HwSettingRemoverLayout hwSettingRemoverLayout = HwSettingRemoverLayout.this;
                hwSettingRemoverLayout.mSettingViewManager.updateShowState(hwSettingRemoverLayout.getCallerType(), HwSettingRemoverLayout.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingRemoverLayout.setLoggingListener(new SpenSettingRemoverLayout.LoggingListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingRemoverLayout.5
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.LoggingListener
            public void onClosed() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASER_SETTING_CLOSE);
                ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_ERASER_SETTINGS_OPEN_AND_CLOSE, "1");
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.LoggingListener
            public void onSeekbarChanged(int i) {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ERASER_SIZE, i);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        return spenSettingRemoverLayout != null && spenSettingRemoverLayout.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean onTouchOutside() {
        if (internalHide(true)) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_ERASER_SETTINGS_OPEN_AND_CLOSE, "2");
        }
        return true;
    }

    public void setEraserHighlighterOnlyEnabled(boolean z) {
        AbstractC8014b.m7220v("setConnectionStickyMemo# ", TAG, z);
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        if (spenSettingRemoverLayout != null) {
            spenSettingRemoverLayout.setVisibilityHighlighterOption(z ? 0 : 8);
        }
    }

    public void setSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        if (spenSettingRemoverLayout == null || CommonUtil.compareRemoverInfo(spenSettingRemoverLayout.getInfo(), spenSettingRemoverInfo)) {
            return;
        }
        this.mIsSkipRemoverInfoChanged = true;
        this.mSpenSettingRemoverLayout.setInfo(spenSettingRemoverInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSpenSettingRemoverLayout.getVisibility() == 0) {
            return;
        }
        updateEraseAllLayout();
        if (!this.mSettingViewManager.getSettingInstance().isNotStickyMemoConnected()) {
            setEraserHighlighterOnlyEnabled(false);
        }
        inOutVI(this.mSpenSettingRemoverLayout, z);
        this.mSpenSettingRemoverLayout.setVisibility(0);
        this.mSpenSettingRemoverLayout.requestFocus();
        updatePosition(i, view, z);
    }

    public void updateEraseAllLayout() {
        Context context = this.mFloatingContainer.getContext();
        boolean z = this.mSettingViewManager.isSupportEraseCurrentPage() && this.mSettingViewManager.getSettingInstance().isNotStickyMemoConnected();
        if (!z) {
            this.mEraseAllType = 0;
            this.mSpenSettingRemoverLayout.setPageMenu(z, "");
            return;
        }
        String string = context.getResources().getString(C9086R.string.hw_toolbar_setting_all_page);
        if (this.mSettingViewManager.isEraseCurrentTwoPage()) {
            this.mEraseAllType = 2;
            this.mSpenSettingRemoverLayout.setPageMenu(z, string, context.getResources().getString(C9086R.string.change_template_left_page), context.getResources().getString(C9086R.string.change_template_right_page));
            return;
        }
        this.mEraseAllType = 1;
        String string2 = context.getResources().getString(C9086R.string.change_template_current_page);
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        StringBuilder sbM1324q = AbstractC1974b.m1324q(string2);
        sbM1324q.append(this.mSettingViewManager.getCurrentPageInfo());
        spenSettingRemoverLayout.setPageMenu(z, string, sbM1324q.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(i, this.mSpenSettingRemoverLayout);
    }
}
