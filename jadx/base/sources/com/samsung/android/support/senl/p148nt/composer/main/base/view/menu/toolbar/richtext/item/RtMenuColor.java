package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPicker;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSetting;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RtMenuColor extends RtMenuItem {
    private static final String TAG = Logger.createTag("RtMenuColor");
    protected Activity mActivity;
    protected RtColorPopup mColorPopup;
    protected ImageView mColorView;
    protected View mContainer;
    protected Handler mHandler;
    protected boolean mHasColorSetting;
    private RtToolbarContract.OnClickValueListener mOnClickValueListener;
    protected Runnable mShowPopupRunnable;
    protected State mState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorPickerVisibilityListener implements ColorPicker.ColorPickerViewListener {
        public ColorPickerVisibilityListener() {
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.ColorPickerViewListener
        public void onVisibilityChanged(int i) {
            RtMenuColor.this.mState.setColorPickerEnable(i == 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorPopupChangedListener implements RtColorPopup.OnColorChangedListener {
        public ColorPopupChangedListener() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.OnColorChangedListener
        public void onSetChangedColor(int i) {
            RtMenuColor.this.mState.setColor(i);
            RtMenuColor.this.setColor(i);
            RtMenuColor rtMenuColor = RtMenuColor.this;
            rtMenuColor.mColorView.setImageTintList(ColorStateList.valueOf(rtMenuColor.getColorTheme(i)));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.OnColorChangedListener
        public void setChangePaletteId(int i) {
            RtMenuColor.this.mState.setPaletteId(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorPopupVisibilityListener implements RtColorPopup.ColorPopupViewListener {
        public ColorPopupVisibilityListener() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.ColorPopupViewListener
        public void onVisibilityChanged(int i) {
            RtMenuColor.this.mState.setPopupEnable(i == 0);
            if (i == 8) {
                RtMenuColor.this.onHidedPopup();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorSettingVisibilityListener implements ColorSetting.ColorSettingViewListener {
        public ColorSettingVisibilityListener() {
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
        public void onCancel() {
            if (RtMenuColor.this.mPresenter.isCoeditNote()) {
                ComposerSA.insertLog("683", HWToolbarSAConstants.EVENT_WRITING_COLOR_SETTING_CANCEL);
            } else {
                ComposerSA.insertLog("401", HWToolbarSAConstants.EVENT_WRITING_COLOR_SETTING_CANCEL);
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
        public void onChangeSelected(List<Integer> list) {
            RtMenuColor.this.mPresenter.getRtSettingPresenter().setPaletteList(list);
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
        public void onDone() {
            if (RtMenuColor.this.mPresenter.isCoeditNote()) {
                ComposerSA.insertLog("683", HWToolbarSAConstants.EVENT_WRITING_COLOR_SETTING_DONE);
            } else {
                ComposerSA.insertLog("401", HWToolbarSAConstants.EVENT_WRITING_COLOR_SETTING_DONE);
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
        public void onSelectItemChanged(int i, boolean z) {
            if (RtMenuColor.this.mPresenter.isCoeditNote()) {
                ComposerSA.insertLog("683", "0101");
            } else {
                ComposerSA.insertLog("401", "0101");
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
        public void onVisibilityChanged(int i) {
            RtMenuColor.this.mState.setColorSettingEnable(i == 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PaletteActionListener implements BaseColorPalette.OnPaletteActionListener {
        public PaletteActionListener() {
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
        public void onButtonClick(int i, int i2, boolean z) {
            AbstractC8014b.m7215q(AbstractC0622a.m1173s(i, i2, "PaletteView. onButtonClick index=", " childAt=", " selected="), z, RtMenuColor.TAG);
            if (i2 != 8) {
                if (i2 == 9) {
                    RtMenuColor.this.mColorPopup.showColorSettingPopup();
                    return;
                } else {
                    RtMenuColor.this.mColorPopup.setSelectedColor(i, i2, z);
                    return;
                }
            }
            String str = RtMenuColor.this.mPresenter.isCoeditNote() ? "683" : "401";
            if (RtMenuColor.this.mHasColorSetting) {
                ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_FONT_COLOR_SHOW_COLOR_PICKER);
            } else {
                ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_FONT_BG_COLOR_SHOW_COLOR_PICKER);
            }
            RtMenuColor rtMenuColor = RtMenuColor.this;
            rtMenuColor.mColorPopup.showColorPickerPopup(rtMenuColor.mState.getColor());
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
        public void onPaletteSwipe(int i, int i2) {
            RtMenuColor.this.mState.setPaletteId(i);
            if (i2 == 1) {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_FONT_COLOR_SWIPE_LEFT);
            } else {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_FONT_COLOR_SWIPE_RIGHT);
            }
        }
    }

    public RtMenuColor(View view) {
        super(view);
        this.mHasColorSetting = false;
        this.mOnClickValueListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        Logger.m11003i(TAG, "hidePopup");
        RtToolbarContract.OnClickValueListener onClickValueListener = this.mOnClickValueListener;
        if (onClickValueListener != null) {
            onClickValueListener.apply(this.mState.getColor());
        }
        this.mOnClickValueListener = null;
        RtColorPopup rtColorPopup = this.mColorPopup;
        if (rtColorPopup == null || !rtColorPopup.isShowing()) {
            return false;
        }
        this.mColorPopup.release();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        this.mPresenter.consumeCursorEvent();
        showPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onDetach() {
        releasePopup();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
    }

    public abstract void onHidedPopup();

    public void onPaletteListChanged(List<Integer> list) {
        RtColorPopup rtColorPopup = this.mColorPopup;
        if (rtColorPopup == null) {
            return;
        }
        rtColorPopup.onPaletteListChanged(list);
    }

    public void onRestored() {
        this.mHandler.removeCallbacks(this.mShowPopupRunnable);
        this.mHandler.post(this.mShowPopupRunnable);
    }

    public void onSaveInstanceState(Bundle bundle, String str) {
        bundle.putParcelable(str, new State(this.mState));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onUpdate() {
        RtColorPopup rtColorPopup = this.mColorPopup;
        if (rtColorPopup != null) {
            rtColorPopup.update();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void release() {
        Logger.m11003i(TAG, "release");
        releasePopup();
    }

    public void releasePopup() {
        Logger.m11003i(TAG, "releasePopup");
        RtColorPopup rtColorPopup = this.mColorPopup;
        if (rtColorPopup != null) {
            rtColorPopup.release();
        }
    }

    public int removeAlpha(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    public void restore(Bundle bundle, String str) {
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable != null) {
            this.mState.copyData((State) parcelable);
            if (this.mState.isPopupEnable()) {
                onRestored();
            }
        }
    }

    public abstract void setColor(int i);

    public void setSettingPopupColor(int i) {
        String str = TAG;
        AbstractC8014b.m7217s(i, "setSettingPopupColor# ", str);
        RtColorPopup rtColorPopup = this.mColorPopup;
        if (rtColorPopup == null || !rtColorPopup.isShowing() || !this.mState.isPopupEnable() || this.mColorPopup.setCurrentColor(i)) {
            return;
        }
        Logger.m11003i(str, "setSettingPopupColor# hidePopup");
        hidePopup();
    }

    public abstract void setTitle();

    public void showPopup() {
        showPopup(null);
    }

    public void showPopupWithListener(RtColorPopup.Contract contract, RtToolbarContract.OnClickValueListener onClickValueListener) {
        this.mOnClickValueListener = onClickValueListener;
        showPopup(contract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public abstract void updateState(@NonNull SpanStates spanStates);

    public void showPopup(RtColorPopup.Contract contract) {
        releasePopup();
        if (this.mActivity.isFinishing() || this.mActivity.isDestroyed()) {
            return;
        }
        if (contract == null) {
            contract = new RtColorPopup.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.Contract
                public Point getAnchorPosition() {
                    return RtMenuColor.super.getViewCenterPosition();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.Contract
                public View getSpecifiedAnchorView() {
                    return null;
                }
            };
        }
        RtColorPopup rtColorPopup = new RtColorPopup(this.mActivity, this.mContainer, contract);
        this.mColorPopup = rtColorPopup;
        rtColorPopup.init(this.mState.getColor(), -1, this.mHasColorSetting, this.mPresenter, this.mIsTabletLayout);
        setTitle();
        this.mColorPopup.setOnTextColorChangedListener(new ColorPopupChangedListener());
        this.mColorPopup.setPaletteActionListener(new PaletteActionListener());
        this.mColorPopup.setColorPopupVisibilityListener(new ColorPopupVisibilityListener());
        this.mColorPopup.setColorPickerVisibilityListener(new ColorPickerVisibilityListener());
        this.mColorPopup.setColorSettingVisibilityListener(new ColorSettingVisibilityListener());
        this.mColorPopup.show();
        this.mPresenter.onShowWindow();
        if (this.mColorPopup.isShowing()) {
            if (this.mState.isColorPickerEnable()) {
                this.mColorPopup.showColorPickerPopup(this.mState.getColor());
            }
            if (this.mState.isColorSettingEnable()) {
                this.mColorPopup.showColorSettingPopup();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor.State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public State[] newArray(int i) {
                return new State[i];
            }
        };
        private ColorSettingState mColorSettingState;
        private int mPopup;

        public State() {
            this.mPopup = 0;
            this.mColorSettingState = new ColorSettingState();
        }

        public void copyData(State state) {
            this.mPopup = state.mPopup;
            this.mColorSettingState.copyData(state.mColorSettingState);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getColor() {
            return this.mColorSettingState.getColor();
        }

        public int getPaletteId() {
            return this.mColorSettingState.getPaletteId();
        }

        public boolean isColorPickerEnable() {
            return this.mColorSettingState.isColorPickerEnable();
        }

        public boolean isColorSettingEnable() {
            return this.mColorSettingState.isColorSettingEnable();
        }

        public boolean isPopupEnable() {
            return this.mPopup == 1;
        }

        public void setColor(int i) {
            this.mColorSettingState.setColor(i);
        }

        public void setColorPickerEnable(boolean z) {
            this.mColorSettingState.setColorPickerEnable(z);
        }

        public void setColorSettingEnable(boolean z) {
            this.mColorSettingState.setColorSettingEnable(z);
        }

        public void setColorSettingState() {
            this.mColorSettingState = new ColorSettingState();
        }

        public void setPaletteId(int i) {
            this.mColorSettingState.setPaletteId(i);
        }

        public void setPopupEnable(boolean z) {
            AbstractC8014b.m7220v("setPopupEnable# ", RtMenuColor.TAG, z);
            this.mPopup = z ? 1 : 0;
        }

        public String toString() {
            return "mPopup: " + this.mPopup + "\n-@    mColorSettingState: " + this.mColorSettingState;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mPopup);
            parcel.writeParcelable(this.mColorSettingState, i);
        }

        public State(State state) {
            this.mPopup = 0;
            this.mColorSettingState = new ColorSettingState();
            copyData(state);
        }

        public State(Parcel parcel) {
            this.mPopup = 0;
            this.mColorSettingState = new ColorSettingState();
            this.mPopup = parcel.readInt();
            ColorSettingState colorSettingState = (ColorSettingState) parcel.readParcelable(ColorSettingState.class.getClassLoader());
            this.mColorSettingState = colorSettingState;
            if (colorSettingState == null) {
                this.mColorSettingState = new ColorSettingState();
            }
        }
    }
}
