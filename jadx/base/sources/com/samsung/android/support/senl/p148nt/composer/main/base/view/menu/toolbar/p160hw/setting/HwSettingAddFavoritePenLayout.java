package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common.ColorSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.animation.QTAddFavoritePenAnimation;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingAddFavoritePenLayout extends HwSettingPenLayoutCommon {
    private static final String TAG = Logger.createTag("HwSettingAddFavoritePenLayout");
    private View mContainer;
    private SettingFavoritePenData.FavoritePenInfoChangeListener mFavoritePenInfoChangeListener;
    private boolean mIsAddType;
    private boolean mIsRight;
    protected SpenSettingUIPenInfo mPenInfo;

    public HwSettingAddFavoritePenLayout() {
        this.mIsAddType = true;
        this.mIsSupportEyedropper = true;
    }

    private void changeParentTo(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) this.mSpenSettingLayout.getParent();
        if (viewGroup2 != viewGroup) {
            viewGroup2.removeView(this.mSpenSettingLayout);
            viewGroup.addView(this.mSpenSettingLayout);
        }
    }

    private void initPenType() {
        this.mSpenSettingLayout.setInfo(this.mSettingViewManager.getSelectedPenInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hide$0() {
        this.mSpenSettingLayout.setVisibility(8);
        this.mSpenSettingLayout.setAlpha(1.0f);
        this.mSpenSettingLayout.setScaleX(1.0f);
        this.mSpenSettingLayout.setScaleY(1.0f);
        changeParentTo(this.mFloatingContainer);
    }

    private void placeCenterInHalfParent(@NonNull final ViewGroup viewGroup, final boolean z) {
        this.mIsRight = z;
        changeParentTo(viewGroup);
        this.mSpenSettingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int left;
                int left2;
                float width;
                int width2;
                HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int top = viewGroup.getTop() - HwSettingAddFavoritePenLayout.this.mFloatingContainer.getTop();
                if (viewGroup.getLayoutDirection() == 0) {
                    left = viewGroup.getLeft();
                    left2 = HwSettingAddFavoritePenLayout.this.mFloatingContainer.getLeft();
                } else {
                    left = HwSettingAddFavoritePenLayout.this.mFloatingContainer.getLeft();
                    left2 = viewGroup.getLeft();
                }
                int i = left - left2;
                if (z) {
                    width = HwSettingAddFavoritePenLayout.this.mFloatingContainer.getWidth() * 0.75f;
                    width2 = HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.getWidth();
                } else {
                    width = HwSettingAddFavoritePenLayout.this.mFloatingContainer.getWidth() * 0.25f;
                    width2 = HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.getWidth();
                }
                float f = width - (width2 * 0.5f);
                HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.setX(f + i);
                HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.setY(((HwSettingAddFavoritePenLayout.this.mFloatingContainer.getHeight() - HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.getHeight()) * 0.5f) + top);
                new QTAddFavoritePenAnimation().show(HwSettingAddFavoritePenLayout.this.mSpenSettingLayout);
            }
        });
        setLayoutOrientation();
        settingVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnToPrevious() {
        View view = this.mContainer;
        if (view != null && view.getId() == C9086R.id.qt_container) {
            hide(true);
        } else if (isVisible()) {
            hide(false);
            if (getCallerType() != 0) {
                this.mSettingViewManager.show(getCallerType(), 1, null, false);
            }
        }
    }

    private void setListener() {
        this.mSpenSettingLayout.addActionButton(this.mFloatingContainer.getContext().getResources().getString(C9086R.string.composer_string_cancel), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingAddFavoritePenLayout.this.returnToPrevious();
                SpenSettingPenLayout spenSettingPenLayout = HwSettingAddFavoritePenLayout.this.mSpenSettingLayout;
                if (spenSettingPenLayout == null || !ResourceUtils.isTabletLayout(spenSettingPenLayout.getContext())) {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ADD_FAVORITE_PEN_CANCEL);
                } else {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_FAVORITE_CANCEL);
                }
            }
        });
        this.mSpenSettingLayout.addActionButton(this.mFloatingContainer.getContext().getResources().getString(C9086R.string.dialog_done), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpenSettingPenLayout spenSettingPenLayout = HwSettingAddFavoritePenLayout.this.mSpenSettingLayout;
                if (spenSettingPenLayout == null) {
                    return;
                }
                SpenSettingUIPenInfo info = spenSettingPenLayout.getInfo();
                if (HwSettingAddFavoritePenLayout.this.mIsAddType) {
                    HwSettingAddFavoritePenLayout.this.mSettingViewManager.setSkipHideFavoriteList(HwSettingAddFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getPenType(info) != HwSettingAddFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getSelectedPenType());
                    HwSettingAddFavoritePenLayout.this.addFavoritePenInfo(info);
                } else {
                    HwSettingAddFavoritePenLayout.this.mSettingViewManager.getSettingInstance().changeFavoritePenInfo(HwSettingAddFavoritePenLayout.this.mSettingViewManager.getSettingInstance().getSelectedPenInfo(), info);
                }
                HwSettingAddFavoritePenLayout.this.returnToPrevious();
                if (ResourceUtils.isTabletLayout(HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.getContext())) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_FAVORITE_DONE);
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_ADD_FAVORITE_PEN_ADD);
                }
            }
        });
        this.mSpenSettingLayout.setPenSpuitActionListener(new SpenSettingPenLayout.SpenPenSpuitViewActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.4
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.EyedropperActionListener
            public void onCloseClicked() {
                HwSettingAddFavoritePenLayout.this.showByEyedropperColor();
            }
        });
        this.mSpenSettingLayout.setPaletteActionListener(new SpenSettingPenLayout.PaletteActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.5
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteActionListener
            public void onPageChanged(int i) {
            }
        });
        this.mSpenSettingLayout.setVisibilityChangedListener(new SpenSettingPenLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.6
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.ViewListener
            public void onVisibilityChanged(int i) {
                HwSettingAddFavoritePenLayout hwSettingAddFavoritePenLayout = HwSettingAddFavoritePenLayout.this;
                hwSettingAddFavoritePenLayout.mSettingViewManager.updateShowState(hwSettingAddFavoritePenLayout.getCallerType(), HwSettingAddFavoritePenLayout.this.getViewId(), i == 0, HwSettingAddFavoritePenLayout.this.mSpenSettingLayout.isEyedropperVisible());
                if (i == 0) {
                    HwSettingAddFavoritePenLayout.this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().registerFavoriteInfoChangeListener(HwSettingAddFavoritePenLayout.this.mFavoritePenInfoChangeListener);
                } else {
                    HwSettingAddFavoritePenLayout.this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().unregisterFavoriteInfoChangeListener(HwSettingAddFavoritePenLayout.this.mFavoritePenInfoChangeListener);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showByEyedropperColor() {
        SpenSettingUIPenInfo info = this.mSpenSettingLayout.getInfo();
        if (info == null) {
            Logger.m11000e(TAG, "showByEyedropperColor info is null");
            return;
        }
        info.color = this.mSpenSettingLayout.getEyedropperColor();
        info.colorUIInfo = 0;
        showSelf();
        this.mSpenSettingLayout.setInfo(info);
    }

    private boolean showCommon(int i, View view, boolean z) {
        super.show(i, view, z);
        if (isCalledFromToolbarInPenMiniMode(i)) {
            return false;
        }
        init();
        if (this.mSpenSettingLayout.getVisibility() == 0) {
            return false;
        }
        if (this.mIsAddType && !this.mSettingViewManager.getSettingInfoManager().getFavoritePenData().canAddFavoriteInfo()) {
            ToastHandler.show(this.mFloatingContainer.getContext(), C9086R.string.hw_toolbar_list_full_favorite_pen, 0);
        }
        if (this.mIsSupportEyedropper) {
            this.mSpenSettingLayout.setEyedropperEnabled(this.mSettingViewManager.getSettingInfoManager().isEyeDropperEnabled());
        }
        inOutVI(this.mSpenSettingLayout, z);
        this.mSpenSettingLayout.setVisibility(0);
        this.mSpenSettingLayout.requestFocus();
        this.mSpenSettingLayout.bringToFront();
        this.mContainer = view;
        return true;
    }

    private void showSelf() {
        if (isVisible()) {
            return;
        }
        show(getCallerType(), this.mContainer, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        View view = this.mContainer;
        if (view == null || view.getId() != C9086R.id.qt_container) {
            super.hide(z);
            return;
        }
        hideSettingCommon();
        if (isVisible() && z) {
            new QTAddFavoritePenAnimation().hide(this.mSpenSettingLayout, new RunnableC9767a(this, 8));
        } else {
            changeParentTo(this.mFloatingContainer);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    @SuppressLint({"StringFormatInvalid"})
    public void init() {
        if (this.mSpenSettingLayout != null) {
            initPenType();
            restoreData();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(Default.Pen.getNames()));
        arrayList.addAll(Arrays.asList(Default.Highlighter.getNames()));
        super.init(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.mSettingViewManager.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoList());
        arrayList2.addAll(this.mSettingViewManager.getSettingInfoManager().getPenInfoData().getSettingPenInfoList());
        this.mSpenSettingLayout.setPenInfoList(arrayList2);
        this.mFavoritePenInfoChangeListener = new SettingFavoritePenData.FavoritePenInfoChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoriteIndexChanged(int i) {
                AbstractC8014b.m7217s(i, "onFavoriteIndexChanged ", HwSettingAddFavoritePenLayout.TAG);
                HwSettingAddFavoritePenLayout.this.returnToPrevious();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoritePenInfoChanged(ArrayList<SpenSettingUIPenInfo> arrayList3) {
                Logger.m11003i(HwSettingAddFavoritePenLayout.TAG, "onFavoritePenInfoChanged");
                HwSettingAddFavoritePenLayout.this.returnToPrevious();
            }
        };
        initPenType();
        restoreData();
        if (this.mSettingViewManager.isTabletLayout()) {
            if (this.mIsAddType) {
                this.mSpenSettingLayout.setTitle(this.mFloatingContainer.getContext().getResources().getString(C9086R.string.hw_toolbar_add_favorite_pen));
            } else {
                this.mSpenSettingLayout.setTitle(this.mFloatingContainer.getContext().getResources().getString(C9086R.string.composer_string_change, this.mFloatingContainer.getContext().getResources().getString(C9086R.string.hw_toolbar_item_menu_favorite_pen)));
            }
            this.mSpenSettingLayout.setHeaderVisibility(true);
        } else {
            this.mSpenSettingLayout.setHeaderVisibility(false);
        }
        this.mSpenSettingLayout.setViewMode(7);
        setListener();
        setLayoutOrientation();
        this.mFloatingContainer.addView(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void onPenInfoChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        SpenSettingPenLayout spenSettingPenLayout;
        Logger.m10999d(TAG, String.format("ColorChanged() color=#%08X HSV[%f,%f,%f] colorUIInfo=%d", Integer.valueOf(spenSettingUIPenInfo.color), Float.valueOf(spenSettingUIPenInfo.hsv[0]), Float.valueOf(spenSettingUIPenInfo.hsv[1]), Float.valueOf(spenSettingUIPenInfo.hsv[2]), Integer.valueOf(spenSettingUIPenInfo.colorUIInfo)));
        if (this.mPenInfo != null && (spenSettingPenLayout = this.mSpenSettingLayout) != null) {
            String str = ResourceUtils.isTabletLayout(spenSettingPenLayout.getContext()) ? "403" : "411";
            int i = this.mPenInfo.sizeLevel;
            if (i != spenSettingUIPenInfo.sizeLevel) {
                ComposerSA.insertLog(str, HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_FAVORITE_PEN_SIZE, i);
            }
            if (this.mPenInfo.color != spenSettingUIPenInfo.color) {
                ComposerSA.insertLog(str, HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_FAVORITE_PEN_COLOR, ColorSettingUtil.getColorName(this.mSpenSettingLayout.getContext(), spenSettingUIPenInfo.color));
            }
        }
        this.mPenInfo = spenSettingUIPenInfo;
    }

    public void restoreState(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable(TAG);
        if (parcelable != null) {
            SpenSettingUIPenInfo penInfo = ((FavoritePenState) parcelable).getPenInfo();
            this.mPenInfo = penInfo;
            if (penInfo != null) {
                this.mSpenSettingLayout.setInfo(penInfo);
            }
        }
    }

    public void saveInstanceState(Bundle bundle) {
        if (this.mPenInfo != null) {
            bundle.putParcelable(TAG, new FavoritePenState(this.mPenInfo));
        }
    }

    public void setEyedropperPosition(int i, int i2) {
        View view;
        if (this.mSpenSettingLayout == null || (view = this.mContainer) == null || view.getId() != C9086R.id.qt_container) {
            return;
        }
        this.mSpenSettingLayout.setColorSpoidPosition(i, i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        if (showCommon(i, view, z)) {
            if (view == null || view.getId() != C9086R.id.qt_container) {
                updatePosition(i, view, z);
            } else {
                placeCenterInHalfParent((ViewGroup) view, this.mIsRight);
            }
        }
    }

    public void showCenterInHalfParent(int i, @NonNull ViewGroup viewGroup, boolean z) {
        if (showCommon(i, viewGroup, false)) {
            placeCenterInHalfParent(viewGroup, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FavoritePenState implements Parcelable {
        public static final Parcelable.Creator<FavoritePenState> CREATOR = new Parcelable.Creator<FavoritePenState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAddFavoritePenLayout.FavoritePenState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FavoritePenState createFromParcel(Parcel parcel) {
                return new FavoritePenState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FavoritePenState[] newArray(int i) {
                return new FavoritePenState[i];
            }
        };
        SpenSettingUIPenInfo mPenInfo;

        public FavoritePenState(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            this.mPenInfo = spenSettingUIPenInfo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SpenSettingUIPenInfo getPenInfo() {
            return this.mPenInfo;
        }

        public void setPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            this.mPenInfo = spenSettingUIPenInfo;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mPenInfo.name);
            parcel.writeFloat(this.mPenInfo.size);
            parcel.writeInt(this.mPenInfo.color);
            parcel.writeInt(this.mPenInfo.isCurvable ? 1 : 0);
            parcel.writeString(this.mPenInfo.advancedSetting);
            parcel.writeInt(this.mPenInfo.isEraserEnabled ? 1 : 0);
            parcel.writeInt(this.mPenInfo.sizeLevel);
            parcel.writeInt(this.mPenInfo.particleDensity);
        }

        public FavoritePenState(Parcel parcel) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
            this.mPenInfo = spenSettingUIPenInfo;
            spenSettingUIPenInfo.name = parcel.readString();
            this.mPenInfo.size = parcel.readFloat();
            this.mPenInfo.color = parcel.readInt();
            this.mPenInfo.isCurvable = parcel.readInt() != 0;
            this.mPenInfo.advancedSetting = parcel.readString();
            this.mPenInfo.isEraserEnabled = parcel.readInt() != 0;
            this.mPenInfo.sizeLevel = parcel.readInt();
            this.mPenInfo.particleDensity = parcel.readInt();
        }
    }

    public HwSettingAddFavoritePenLayout(boolean z) {
        this();
        this.mIsAddType = z;
    }
}
