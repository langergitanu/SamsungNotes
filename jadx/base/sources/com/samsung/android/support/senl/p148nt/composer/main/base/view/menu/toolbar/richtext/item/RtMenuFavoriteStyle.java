package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPicker;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSetting;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSettingState;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.richtext.TextStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.setting.color.ColorPalette;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.setting.RtStyleListPopup;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuFavoriteStyle extends AbsRtMenuPopupWindow implements ColorPicker.Contract {
    private static final String TAG = Logger.createTag("RtMenuFavoriteStyle");
    private ColorPalette mBgColorPalette;
    private State mBgColorState;
    private final ColorPicker mColorPicker;
    private final ColorSetting mColorSetting;
    private ImageView mFavoriteBtnView;
    private ColorPalette mFgColorPalette;
    private State mFgColorState;
    private boolean mIsFgColorPicker;
    private TextView mPreviewTextView;
    private RtStyleListPopup mRtStyleListPopup;
    private TextStyle mTextStyle;
    private final int mTextStyleIndex;

    public RtMenuFavoriteStyle(View view, Integer num, View view2) {
        super(view, view2);
        this.mColorPicker = new ColorPicker(view.getContext(), view, this);
        this.mColorSetting = new ColorSetting(view.getContext());
        this.mTextStyleIndex = num.intValue();
    }

    private void initBgColorPalette(Context context) {
        this.mBgColorState = new State();
        this.mBgColorPalette = new ColorPalette(context, new BaseColorPalette.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.12
            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public int getBackgroundColor() {
                return RtMenuFavoriteStyle.this.mPresenter.getBackgroundColor();
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public boolean isDarkTheme() {
                return RtMenuFavoriteStyle.this.mPresenter.isComposerViewDarkTheme();
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public void notifyChangedColor(int i) {
                RtMenuFavoriteStyle.this.mTextStyle.setFontBgColorWithHSV(i);
                RtMenuFavoriteStyle.this.updatePreview();
                ((ImageView) RtMenuFavoriteStyle.this.mDialogContainer.findViewById(C9086R.id.richtext_textBgColor)).setImageTintList(ColorStateList.valueOf(RtMenuFavoriteStyle.this.getColorTheme(i)));
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public void notifyChangedPaletteId(int i) {
            }
        });
        final RtSettingPresenter rtSettingPresenter = this.mPresenter.getRtSettingPresenter();
        this.mBgColorPalette.initPalette(rtSettingPresenter.getPaletteList(), this.mTextStyle.getFontBgColor(), 0, false);
        this.mBgColorPalette.initPresetLayout((RelativeLayout) this.mDialogContainer.findViewById(C9086R.id.bg_color_preset_color_layout));
        this.mBgColorPalette.setPaletteActionListener(new BaseColorPalette.OnPaletteActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.13
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int i, int i2, boolean z) {
                if (i2 == 8) {
                    if (RtMenuFavoriteStyle.this.mColorPicker == null || RtMenuFavoriteStyle.this.mColorPicker.isShowingColorPicker()) {
                        return;
                    }
                    RtMenuFavoriteStyle.this.mIsFgColorPicker = false;
                    ColorPicker colorPicker = RtMenuFavoriteStyle.this.mColorPicker;
                    RtMenuFavoriteStyle rtMenuFavoriteStyle = RtMenuFavoriteStyle.this;
                    colorPicker.showColorPickerPopup(rtMenuFavoriteStyle.mDialogContainer, rtMenuFavoriteStyle.mTextStyle.getFontBgColor(), RtMenuFavoriteStyle.this.mPresenter.getBackgroundColor(), RtMenuFavoriteStyle.this.mPresenter.getColorTheme(), false);
                    return;
                }
                if (i2 != 9) {
                    RtMenuFavoriteStyle.this.mBgColorPalette.setSelectedColor(i, i2, z);
                } else {
                    if (RtMenuFavoriteStyle.this.mColorSetting == null || RtMenuFavoriteStyle.this.mColorSetting.isShowingColorSetting()) {
                        return;
                    }
                    RtMenuFavoriteStyle.this.mColorSetting.showColorSettingPopup(rtSettingPresenter.getPaletteList(), RtMenuFavoriteStyle.this.mPresenter.getColorTheme());
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int i, int i2) {
                RtMenuFavoriteStyle.this.mBgColorState.setPaletteId(i);
            }
        });
    }

    private void initBoldButton(final View view, final TextStyle textStyle) {
        initButton(view, C9086R.id.comp_rt_btn_bold, textStyle.isBold(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                textStyle.setBold(!r2.isBold());
                view.findViewById(C9086R.id.comp_rt_btn_bold).setSelected(textStyle.isBold());
                RtMenuFavoriteStyle.this.updatePreview();
            }
        });
    }

    private void initButton(View view, @IdRes int i, boolean z, View.OnClickListener onClickListener) {
        View viewFindViewById = view.findViewById(i);
        viewFindViewById.setOnClickListener(onClickListener);
        viewFindViewById.setSelected(z);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    private void initCloseButton(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.close_btn);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().saveData()) {
                    ToastHelper.show(view2.getContext(), "saved text styles", 0, false);
                    RtMenuFavoriteStyle.this.mPresenter.updateTextStyles();
                }
                RtMenuFavoriteStyle.this.hidePopup();
            }
        });
    }

    private void initFavoriteButton(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.favorite_btn);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().isContainTextStyleList(RtMenuFavoriteStyle.this.mTextStyle)) {
                    if (RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().getStyleCount() == 1) {
                        ToastHelper.show(view2.getContext(), "can not delete the last one text style", 0, false);
                        return;
                    }
                    RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().removeTextStyle(RtMenuFavoriteStyle.this.mTextStyle);
                    ToastHelper.show(view2.getContext(), "deleted the text style : " + RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().getStyleCount(), 0, false);
                } else {
                    if (RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().getStyleCount() >= 10) {
                        ToastHelper.show(view2.getContext(), "can not delete the last one text style", 0, false);
                        return;
                    }
                    RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().addTextStyle(RtMenuFavoriteStyle.this.mTextStyle);
                    ToastHelper.show(view2.getContext(), "added the text style : " + RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().getStyleCount(), 0, false);
                }
                RtMenuFavoriteStyle rtMenuFavoriteStyle = RtMenuFavoriteStyle.this;
                rtMenuFavoriteStyle.updateFavoriteButton(rtMenuFavoriteStyle.mFavoriteBtnView, RtMenuFavoriteStyle.this.mTextStyle);
                if (RtMenuFavoriteStyle.this.mPresenter.getRtTextStylePresenter().saveData()) {
                    RtMenuFavoriteStyle.this.mPresenter.updateTextStyles();
                }
            }
        });
    }

    private void initFavoriteListButton(final View view) {
        final View viewFindViewById = view.findViewById(C9086R.id.favorite_list_btn);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuFavoriteStyle.this.mRtStyleListPopup = new RtStyleListPopup(view.getContext());
                RtStyleListPopup rtStyleListPopup = RtMenuFavoriteStyle.this.mRtStyleListPopup;
                RtToolbarPresenter rtToolbarPresenter = RtMenuFavoriteStyle.this.mPresenter;
                rtStyleListPopup.init(rtToolbarPresenter, rtToolbarPresenter.getRtTextStylePresenter().getStyles());
                RtMenuFavoriteStyle.this.mRtStyleListPopup.show(viewFindViewById);
            }
        });
    }

    private void initFgColorPalette(Context context) {
        this.mFgColorState = new State();
        this.mFgColorPalette = new ColorPalette(context, new BaseColorPalette.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.10
            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public int getBackgroundColor() {
                return RtMenuFavoriteStyle.this.mPresenter.getBackgroundColor();
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public boolean isDarkTheme() {
                return RtMenuFavoriteStyle.this.mPresenter.isComposerViewDarkTheme();
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public void notifyChangedColor(int i) {
                RtMenuFavoriteStyle.this.mTextStyle.setFontColorWithHSV(i);
                RtMenuFavoriteStyle.this.updatePreview();
                ((ImageView) RtMenuFavoriteStyle.this.mDialogContainer.findViewById(C9086R.id.richtext_textColor)).setImageTintList(ColorStateList.valueOf(RtMenuFavoriteStyle.this.getColorTheme(i)));
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public void notifyChangedPaletteId(int i) {
                AbstractC0000a.m3D(i, "notifyChangedPaletteId# ", RtMenuFavoriteStyle.TAG);
            }
        });
        final RtSettingPresenter rtSettingPresenter = this.mPresenter.getRtSettingPresenter();
        this.mFgColorPalette.initPalette(rtSettingPresenter.getPaletteList(), this.mTextStyle.getFontColor(), 0, false);
        this.mFgColorPalette.initPresetLayout((RelativeLayout) this.mDialogContainer.findViewById(C9086R.id.fg_color_preset_color_layout));
        this.mFgColorPalette.setPaletteActionListener(new BaseColorPalette.OnPaletteActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.11
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int i, int i2, boolean z) {
                if (i2 == 8) {
                    if (RtMenuFavoriteStyle.this.mColorPicker == null || RtMenuFavoriteStyle.this.mColorPicker.isShowingColorPicker()) {
                        return;
                    }
                    RtMenuFavoriteStyle.this.mIsFgColorPicker = true;
                    ColorPicker colorPicker = RtMenuFavoriteStyle.this.mColorPicker;
                    RtMenuFavoriteStyle rtMenuFavoriteStyle = RtMenuFavoriteStyle.this;
                    colorPicker.showColorPickerPopup(rtMenuFavoriteStyle.mDialogContainer, rtMenuFavoriteStyle.mTextStyle.getFontColor(), RtMenuFavoriteStyle.this.mPresenter.getBackgroundColor(), RtMenuFavoriteStyle.this.mPresenter.getColorTheme(), false);
                    return;
                }
                if (i2 != 9) {
                    RtMenuFavoriteStyle.this.mFgColorPalette.setSelectedColor(i, i2, z);
                } else {
                    if (RtMenuFavoriteStyle.this.mColorSetting == null || RtMenuFavoriteStyle.this.mColorSetting.isShowingColorSetting()) {
                        return;
                    }
                    RtMenuFavoriteStyle.this.mColorSetting.showColorSettingPopup(rtSettingPresenter.getPaletteList(), RtMenuFavoriteStyle.this.mPresenter.getColorTheme());
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int i, int i2) {
                RtMenuFavoriteStyle.this.mFgColorState.setPaletteId(i);
            }
        });
    }

    private void initFontSizeMinusButton(final View view, final TextStyle textStyle) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_rt_fontsize_minus_btn);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                textStyle.setFontSize(Math.max(6, textStyle.getFontSize() - 1));
                RtMenuFavoriteStyle.this.updateFontSizePreview(view, textStyle);
                RtMenuFavoriteStyle.this.updatePreview();
            }
        });
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
    }

    private void initFontSizePlusButton(final View view, final TextStyle textStyle) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_rt_fontsize_plus_btn);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                textStyle.setFontSize(Math.min(64, textStyle.getFontSize() + 1));
                RtMenuFavoriteStyle.this.updateFontSizePreview(view, textStyle);
                RtMenuFavoriteStyle.this.updatePreview();
            }
        });
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
    }

    private void initItalicButton(final View view, final TextStyle textStyle) {
        initButton(view, C9086R.id.comp_rt_btn_italic, textStyle.isItalic(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                textStyle.setItalic(!r2.isItalic());
                view.findViewById(C9086R.id.comp_rt_btn_italic).setSelected(textStyle.isItalic());
                RtMenuFavoriteStyle.this.updatePreview();
            }
        });
    }

    private static void initScrollView(View view) {
        ViewCompat.getInstance().setShadowAlpha(view.findViewById(C9086R.id.text_style_scroll_view), 0.5f);
    }

    private void initStrikethroughButton(final View view, final TextStyle textStyle) {
        initButton(view, C9086R.id.comp_rt_btn_strikethrough, textStyle.isStrikethrough(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                textStyle.setStrikethrough(!r2.isStrikethrough());
                view.findViewById(C9086R.id.comp_rt_btn_strikethrough).setSelected(textStyle.isStrikethrough());
                RtMenuFavoriteStyle.this.updatePreview();
            }
        });
    }

    private void initUnderlineButton(final View view, final TextStyle textStyle) {
        initButton(view, C9086R.id.comp_rt_btn_underline, textStyle.isUnderline(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                textStyle.setUnderline(!r2.isUnderline());
                view.findViewById(C9086R.id.comp_rt_btn_underline).setSelected(textStyle.isUnderline());
                RtMenuFavoriteStyle.this.updatePreview();
            }
        });
    }

    private boolean isSame(TextStyle textStyle, SpanStates spanStates) {
        return textStyle.isBold() == spanStates.getBold().getValue() && textStyle.isItalic() == spanStates.getItalic().getValue() && textStyle.isUnderline() == spanStates.getUnderline().getValue() && textStyle.isStrikethrough() == spanStates.getStrikethrough().getValue() && textStyle.getFontSize() == spanStates.getFontSize().getViewValue() && textStyle.getFontColor() == spanStates.getFontColor().getValue() && textStyle.getFontBgColor() == spanStates.getFontBgColor().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFavoriteButton(View view, TextStyle textStyle) {
        View viewFindViewById = view.findViewById(C9086R.id.favorite_btn);
        viewFindViewById.setBackground(AppCompatResources.getDrawable(viewFindViewById.getContext(), this.mPresenter.getRtTextStylePresenter().isContainTextStyleList(textStyle) ? C9086R.drawable.comp_appbar_ic_favorite_on : C9086R.drawable.comp_appbar_ic_favorite_off));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFontSizePreview(View view, TextStyle textStyle) {
        ((TextView) view.findViewById(C9086R.id.comp_rt_fontsize_preview)).setText(String.valueOf(textStyle.getFontSize()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreview() {
        updateTextView(this.mPreviewTextView, this.mTextStyle, true);
        updateFavoriteButton(this.mFavoriteBtnView, this.mTextStyle);
    }

    private void updateTextView(TextView textView, TextStyle textStyle, boolean z) {
        if (textView == null) {
            return;
        }
        ViewCompat.getInstance().setAutoHandwritingEnabled(textView, false);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) textView.getText().toString());
        int length = spannableStringBuilder.length();
        if (textStyle.isBold()) {
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, length, 33);
        }
        if (textStyle.isItalic()) {
            spannableStringBuilder.setSpan(new StyleSpan(2), 0, length, 33);
        }
        if (textStyle.isUnderline()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), 0, length, 33);
        }
        if (textStyle.isStrikethrough()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), 0, length, 33);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(textStyle.getFontColor()), 0, length, 33);
        if (!z) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(textStyle.getFontSize()), 0, length, 33);
            spannableStringBuilder.setSpan(new BackgroundColorSpan(textStyle.getFontBgColor()), 0, length, 33);
        }
        textView.setText(spannableStringBuilder);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        if (!isPopupShowing()) {
            this.mPopupWindow = null;
            return false;
        }
        this.mPopupWindow.dismiss();
        this.mPopupWindow = null;
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public View inflateView(Context context) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_rt_popup_favorite_text_style_setting, (ViewGroup) null);
        this.mPreviewTextView = (TextView) viewInflate.findViewById(C9086R.id.preview_text);
        this.mFavoriteBtnView = (ImageView) viewInflate.findViewById(C9086R.id.favorite_btn);
        return viewInflate;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void init(RtToolbarPresenter rtToolbarPresenter, RtMenuItem.IRtToolbarMenu iRtToolbarMenu) {
        super.init(rtToolbarPresenter, iRtToolbarMenu);
        this.mTextStyle = new TextStyle(this.mPresenter.getRtTextStylePresenter().getStyle(this.mTextStyleIndex));
        updateTextView((TextView) this.mView.findViewById(C9086R.id.richtext_favorite_textStyle_text), this.mTextStyle, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public void initButtons(View view, SpanStates spanStates) {
        initScrollView(view);
        initCloseButton(view);
        initFavoriteListButton(view);
        initFavoriteButton(view);
        initBoldButton(view, this.mTextStyle);
        initItalicButton(view, this.mTextStyle);
        initUnderlineButton(view, this.mTextStyle);
        initStrikethroughButton(view, this.mTextStyle);
        initFontSizeMinusButton(view, this.mTextStyle);
        initFontSizePlusButton(view, this.mTextStyle);
        initFgColorPalette(this.mView.getContext());
        initBgColorPalette(this.mView.getContext());
        updatePreview();
        updateFontSizePreview(view, this.mTextStyle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public /* bridge */ /* synthetic */ void initPopupWindow(Context context) {
        super.initPopupWindow(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        boolean zIsSelected = this.mView.isSelected();
        boolean z = !zIsSelected;
        AbstractC8014b.m7220v("onClicked# ", TAG, z);
        if (zIsSelected) {
            this.mPresenter.hideSoftInput();
            super.onClicked();
        } else {
            this.mView.setSelected(z);
            this.mPresenter.getRtTextStylePresenter().applyStyle(this.mTextStyleIndex);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
    public void onColorChangedByPicker(int i) {
        AbstractC0000a.m3D(i, "onColorChangedByPicker# ", TAG);
        if (this.mIsFgColorPicker) {
            this.mFgColorPalette.onColorChangedByPicker(i);
            this.mTextStyle.setFontColor(i);
        } else {
            this.mBgColorPalette.onColorChangedByPicker(i);
            this.mTextStyle.setFontBgColor(i);
        }
        updatePreview();
    }

    public void onOrientationChanged(int i) {
        this.mColorPicker.setOrientationMode(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void release() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public /* bridge */ /* synthetic */ void showPopup() {
        super.showPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        if (isSame(this.mPresenter.getRtTextStylePresenter().getStyle(this.mTextStyleIndex), spanStates)) {
            if (this.mView.isSelected()) {
                return;
            }
            this.mView.setSelected(true);
        } else if (this.mView.isSelected()) {
            this.mView.setSelected(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle.State.1
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
            AbstractC8014b.m7220v("setPopupEnable# ", RtMenuFavoriteStyle.TAG, z);
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
