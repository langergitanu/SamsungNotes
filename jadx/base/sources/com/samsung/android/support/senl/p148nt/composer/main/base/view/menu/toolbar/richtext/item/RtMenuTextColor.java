package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
public class RtMenuTextColor extends RtMenuColor {
    private static final String TAG = Logger.createTag("RtMenuTextColor");

    public RtMenuTextColor(Activity activity, View view, View view2) {
        super(view2);
        this.mActivity = activity;
        this.mContainer = view;
        this.mColorView = (ImageView) view2.findViewById(C9086R.id.richtext_textColor);
        this.mState = new RtMenuColor.State();
        this.mHasColorSetting = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShowPopupRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextColor.1
            @Override // java.lang.Runnable
            public void run() {
                RtMenuTextColor.this.showPopup();
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_FONT_COLOR);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor
    public void onHidedPopup() {
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_FONT_COLOR_CLOSE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle, TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void restore(Bundle bundle) {
        super.restore(bundle, TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor
    public void setColor(int i) {
        this.mPresenter.setTextColor(i);
        ComposerSA.insertLog(this.mPresenter.isCoeditNote() ? "683" : "401", ComposerSAConstants.EVENT_EDIT_FONT_COLOR_FONT_COLOR, ColorSettingUtil.getColorName(this.mActivity, i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor
    public void setTitle() {
        this.mColorPopup.setTitle(C9086R.string.composer_font_color);
    }

    public void updateFontColor() {
        if (isSkipUpdateDuringDirectWriteRecognizing()) {
            return;
        }
        this.mColorView.setImageTintList(ColorStateList.valueOf(getColorTheme(removeAlpha(this.mState.getColor()))));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuColor, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(@NonNull SpanStates spanStates) {
        int value = spanStates.getFontColor().getValue();
        this.mState.setColor(value);
        if (isSkipUpdateDuringDirectWriteRecognizing()) {
            return;
        }
        this.mColorView.setImageTintList(ColorStateList.valueOf(getColorTheme(removeAlpha(value))));
        setSettingPopupColor(value);
    }
}
