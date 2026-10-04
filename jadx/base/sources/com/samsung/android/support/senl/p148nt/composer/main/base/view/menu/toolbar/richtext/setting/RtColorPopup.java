package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.setting;

import android.R;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPicker;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSetting;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.setting.color.ColorPalette;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtColorPopup implements View.OnClickListener, ColorPicker.Contract, BaseColorPalette.Contract {
    private static final String TAG = Logger.createTag("RtColorPopup");
    private Activity mActivity;
    private final ColorPalette mColorPalette;
    private ColorPicker mColorPicker;
    private ColorPopupViewListener mColorPopupVisibilityListener;
    private final ColorSetting mColorSetting;
    public Contract mContract;
    private View mDialogContainer;
    private boolean mIsTabletLayout;
    private OnColorChangedListener mOnColorChangedListener;
    private View mParentView;
    private PopupWindow mPopupWindow;
    private RtToolbarPresenter mPresenter;
    private RtSettingPresenter mRtSettingPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ColorPopupViewListener {
        void onVisibilityChanged(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        Point getAnchorPosition();

        @Nullable
        View getSpecifiedAnchorView();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnColorChangedListener {
        void onSetChangedColor(int i);

        void setChangePaletteId(int i);
    }

    public RtColorPopup(Activity activity, View view, Contract contract) {
        this.mActivity = activity;
        this.mParentView = view;
        this.mColorPicker = new ColorPicker(activity, view, this);
        this.mColorSetting = new ColorSetting(this.mActivity);
        this.mColorPalette = new ColorPalette(this.mActivity, this);
        this.mContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissSubPopup() {
        this.mColorPicker.dismissColorPicker();
        this.mColorSetting.dismissColorSetting();
    }

    private void initPopupWindow(PopupWindow popupWindow) {
        popupWindow.setTouchable(true);
        if (!DeviceInfo.isVSTModel()) {
            popupWindow.setOutsideTouchable(true);
        }
        popupWindow.setClippingEnabled(false);
        popupWindow.setFocusable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this.mActivity, R.color.transparent)));
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                Logger.m11003i(RtColorPopup.TAG, "onDismiss()");
                RtColorPopup.this.dismissSubPopup();
                if (RtColorPopup.this.mColorPopupVisibilityListener != null) {
                    RtColorPopup.this.mColorPopupVisibilityListener.onVisibilityChanged(8);
                }
            }
        });
    }

    public void dismiss() {
        Logger.m11003i(TAG, "dismiss()");
        dismissSubPopup();
        this.mPopupWindow.dismiss();
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
    public int getBackgroundColor() {
        return this.mPresenter.getBackgroundColor();
    }

    public void init(int i, int i2, boolean z, RtToolbarPresenter rtToolbarPresenter, boolean z2) {
        View viewInflate = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_rt_font_color_popup, (ViewGroup) null);
        this.mDialogContainer = viewInflate;
        viewInflate.measure(0, 0);
        this.mPresenter = rtToolbarPresenter;
        RtSettingPresenter rtSettingPresenter = rtToolbarPresenter.getRtSettingPresenter();
        this.mRtSettingPresenter = rtSettingPresenter;
        this.mIsTabletLayout = z2;
        this.mColorPalette.initPalette(z ? rtSettingPresenter.getPaletteList() : null, i, i2, z);
        this.mColorPalette.initPresetLayout((RelativeLayout) this.mDialogContainer.findViewById(C9086R.id.preset_color_layout));
        ViewCompat.getInstance().setShadowAlpha(this.mDialogContainer.findViewById(C9086R.id.comp_rt_text_setting_scroll_view), 0.5f);
        TextView textView = (TextView) this.mDialogContainer.findViewById(C9086R.id.dialog_title);
        textView.setTextSize(0, FontUtils.getMaxTextSize(this.mActivity, 1.3f, textView.getTextSize()));
        View viewFindViewById = this.mDialogContainer.findViewById(C9086R.id.done_button);
        viewFindViewById.setOnClickListener(this);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        View viewFindViewById2 = this.mDialogContainer.findViewById(C9086R.id.color_settings_button);
        viewFindViewById2.setOnClickListener(this);
        ToolbarUtil.setTooltipText(viewFindViewById2, viewFindViewById2.getContentDescription());
        ToolbarUtil.setBgRippleToolbar(viewFindViewById2);
        if (!z) {
            viewFindViewById2.setVisibility(8);
        }
        PopupWindow popupWindow = new PopupWindow(this.mDialogContainer, -2, this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.comp_rt_popup_text_style_dialog_margin) + this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.composer_colorpicker_dialog_height));
        this.mPopupWindow = popupWindow;
        initPopupWindow(popupWindow);
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
    public boolean isDarkTheme() {
        return this.mPresenter.isComposerViewDarkTheme();
    }

    public boolean isShowing() {
        boolean zIsShowing = this.mPopupWindow.isShowing();
        AbstractC8014b.m7220v("isShowing() : ", TAG, zIsShowing);
        return zIsShowing;
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
    public void notifyChangedColor(int i) {
        OnColorChangedListener onColorChangedListener = this.mOnColorChangedListener;
        if (onColorChangedListener != null) {
            onColorChangedListener.onSetChangedColor(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
    public void notifyChangedPaletteId(int i) {
        OnColorChangedListener onColorChangedListener = this.mOnColorChangedListener;
        if (onColorChangedListener != null) {
            onColorChangedListener.setChangePaletteId(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C9086R.id.done_button) {
            release();
            return;
        }
        if (id == C9086R.id.color_settings_button) {
            showColorSettingPopup();
            if (this.mPresenter.isCoeditNote()) {
                ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_FONT_COLOR_SHOW_COLOR_SETS);
            } else {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_FONT_COLOR_SHOW_COLOR_SETS);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
    public void onColorChangedByPicker(int i) {
        notifyChangedColor(i);
        this.mColorPalette.onColorChangedByPicker(i);
    }

    public void onOrientationChanged(int i) {
        this.mColorPicker.setOrientationMode(i);
    }

    public void onPaletteListChanged(List<Integer> list) {
        Logger.m11003i(TAG, "onPaletteListChanged " + list.toString());
        this.mColorPalette.changeTable(list);
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
    public void release() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            dismiss();
        }
        ColorPicker colorPicker = this.mColorPicker;
        if (colorPicker != null) {
            colorPicker.close();
            this.mColorPicker = null;
        }
        this.mDialogContainer = null;
        this.mActivity = null;
        this.mParentView = null;
    }

    public void setColorPickerVisibilityListener(ColorPicker.ColorPickerViewListener colorPickerViewListener) {
        this.mColorPicker.setColorPickerVisibilityListener(colorPickerViewListener);
    }

    public void setColorPopupVisibilityListener(ColorPopupViewListener colorPopupViewListener) {
        this.mColorPopupVisibilityListener = colorPopupViewListener;
    }

    public void setColorSettingVisibilityListener(ColorSetting.ColorSettingViewListener colorSettingViewListener) {
        this.mColorSetting.setColorSettingViewListener(colorSettingViewListener);
    }

    public boolean setCurrentColor(int i) {
        return this.mColorPalette.setCurrentColor(i);
    }

    public void setOnTextColorChangedListener(OnColorChangedListener onColorChangedListener) {
        this.mOnColorChangedListener = onColorChangedListener;
    }

    public void setPaletteActionListener(BaseColorPalette.OnPaletteActionListener onPaletteActionListener) {
        this.mColorPalette.setPaletteActionListener(onPaletteActionListener);
    }

    public void setSelectedColor(int i, int i2, boolean z) {
        this.mColorPalette.setSelectedColor(i, i2, z);
    }

    public void setTitle(@StringRes int i) {
        ((TextView) this.mDialogContainer.findViewById(C9086R.id.dialog_title)).setText(i);
    }

    public void show() {
        String str = TAG;
        Logger.m10999d(str, "show()");
        if (!this.mColorPalette.checkColorPaletteData()) {
            Logger.m10999d(str, "show# mColorPaletteData is null or size is 0. release PopupWindow");
            release();
            return;
        }
        if (this.mContract.getSpecifiedAnchorView() != null) {
            this.mPopupWindow.setClippingEnabled(true);
            this.mPopupWindow.showAsDropDown(this.mContract.getSpecifiedAnchorView(), (-this.mDialogContainer.getMeasuredWidth()) / 2, 0, 48);
        } else {
            this.mPopupWindow.setClippingEnabled(false);
            Point offset = ToolbarUtil.getOffset(this.mParentView, this.mDialogContainer, this.mContract.getAnchorPosition(), this.mIsTabletLayout);
            this.mPopupWindow.showAsDropDown(this.mParentView, offset.x, offset.y);
        }
        this.mPopupWindow.update();
        ColorPopupViewListener colorPopupViewListener = this.mColorPopupVisibilityListener;
        if (colorPopupViewListener != null) {
            colorPopupViewListener.onVisibilityChanged(0);
        }
        this.mPopupWindow.getContentView().getRootView().setContentDescription(UnicodeUtils.NBSP);
        this.mPopupWindow.getContentView().requestFocus();
    }

    public void showColorPickerPopup(int i) {
        ColorPicker colorPicker = this.mColorPicker;
        if (colorPicker == null || colorPicker.isShowingColorPicker()) {
            return;
        }
        this.mColorPicker.showColorPickerPopup(this.mDialogContainer, i, getBackgroundColor(), this.mPresenter.getColorTheme(), false);
    }

    public void showColorSettingPopup() {
        ColorSetting colorSetting = this.mColorSetting;
        if (colorSetting == null || colorSetting.isShowingColorSetting()) {
            return;
        }
        this.mColorSetting.showColorSettingPopup(this.mRtSettingPresenter.getPaletteList(), this.mPresenter.getColorTheme());
    }

    public void update() {
        Logger.m10999d(TAG, "update()");
        if (this.mPopupWindow != null && isShowing()) {
            if (this.mContract.getSpecifiedAnchorView() == null) {
                Point offset = ToolbarUtil.getOffset(this.mParentView, this.mDialogContainer, this.mContract.getAnchorPosition(), this.mIsTabletLayout);
                this.mPopupWindow.update(this.mParentView, offset.x, offset.y, -1, -1);
            }
            this.mColorPicker.setOrientationMode(this.mActivity.getResources().getConfiguration().orientation);
            return;
        }
        ColorPicker colorPicker = this.mColorPicker;
        if (colorPicker == null || !colorPicker.isShowingColorPicker()) {
            return;
        }
        this.mColorPicker.setOrientationMode(this.mActivity.getResources().getConfiguration().orientation);
    }
}
