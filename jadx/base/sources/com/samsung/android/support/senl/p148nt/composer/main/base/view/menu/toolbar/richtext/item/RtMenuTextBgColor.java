package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common.ColorSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuTextBgColor extends RtMenuColor {
    private static final String TAG = Logger.createTag("RtMenuTextBgColor");

    public RtMenuTextBgColor(Activity activity, View view, View view2) {
        super(view2);
        this.mActivity = activity;
        this.mContainer = view;
        this.mColorView = (ImageView) view2.findViewById(C9086R.id.richtext_textBgColor);
        this.mState = new RtMenuColor.State();
        this.mHasColorSetting = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShowPopupRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextBgColor.1
            @Override // java.lang.Runnable
            public void run() {
                RtMenuTextBgColor.this.showPopup();
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_FONT_BACKGROUND_COLOR);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor
    public void onHidedPopup() {
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_FONT_BG_COLOR_CLOSE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(TAG, new RtMenuColor.State(this.mState));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void restore(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable(TAG);
        if (parcelable != null) {
            this.mState.copyData((RtMenuColor.State) parcelable);
            if (this.mState.isPopupEnable()) {
                onRestored();
            }
        }
    }

    public void setButtonBgColor(int i) {
        int color = this.mState.getColor();
        if (color == 0) {
            this.mColorView.setColorFilter(this.mPresenter.getBackgroundColor(), PorterDuff.Mode.SRC_IN);
        } else if (Color.alpha(color) == 255 || Color.alpha(color) == 0) {
            this.mColorView.setColorFilter(getColorTheme(i), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor
    public void setColor(int i) {
        this.mPresenter.setTextBgColor(i);
        setButtonBgColor(i);
        String colorName = ColorSettingUtil.getColorName(this.mActivity, i);
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_FONT_BACKGROUND_COLOR);
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_FONT_BG_COLOR_FONT_COLOR, colorName);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_FONT_BG_COLOR_FONT_COLOR, colorName);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor
    public void setTitle() {
        this.mColorPopup.setTitle(C9086R.string.composer_font_bg_color);
    }

    public void updateFontBgColor() {
        if (isSkipUpdateDuringDirectWriteRecognizing()) {
            return;
        }
        if (this.mState.getColor() == 0) {
            this.mColorView.setColorFilter(this.mPresenter.getBackgroundColor(), PorterDuff.Mode.SRC_IN);
        }
        setButtonBgColor(this.mState.getColor());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(@NonNull SpanStates spanStates) {
        int value = spanStates.getFontBgColor().getValue();
        this.mState.setColor(value);
        if (isSkipUpdateDuringDirectWriteRecognizing()) {
            return;
        }
        setButtonBgColor(value);
        setSettingPopupColor(value);
    }
}
