package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator;
import p047K3.ViewOnLayoutChangeListenerC0162a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleViewManager {
    private static final String TAG = Logger.createTag("TitleViewManager");
    private final AppCompatActivity mActivity;
    private final TitleAiCoverBtn mAiCoverBtn;
    private final TextView mFontSizeView;
    private boolean mIsCoverShowing;
    private final OnTitleChangedListener mOnTitleChangedListener;
    private final TitleEditorPresenter mPresenter;
    private final ViewGroup mTitleFolderContainer;
    private View.OnLayoutChangeListener mTitleOnLayoutChangeListener;
    private final ViewGroup mTitleTextContainer;
    private final EditText mTitleView;
    private TitleViewShowHideAnimator mTitleViewShowHideAnimator;
    private final ICustomToolbar mToolbar;
    private AppCompatTextView mToolbarTitle;
    private final TextView mToolbarTitleCopyView;
    private int prevTextLength = 0;
    private final TextWatcher mTextWatcher = new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewManager.1
        int startRegister = 0;
        int countRegister = 0;
        int prevLineCount = 0;
        int prevLines = 0;

        private void onChangedTitleText(Editable editable, int i, int i2) {
            if (i2 == 1 && i < editable.length()) {
                if (System.lineSeparator().equals(Character.toString(editable.charAt(i)))) {
                    TitleViewManager.this.removeTextChangedListener();
                    TitleViewManager.this.setTitle();
                    TitleViewManager.this.addTextChangedListener();
                    TitleViewManager.this.mPresenter.hide();
                    return;
                }
            }
            String string = editable.toString();
            int length = string.length();
            TitleViewManager.this.mPresenter.setTitle(string);
            if (TitleViewManager.this.mOnTitleChangedListener != null) {
                TitleViewManager.this.mOnTitleChangedListener.onTitleChanged();
            }
            updateLineCount(string, length);
        }

        private void setLines(int i) {
            if (i <= 2) {
                if (this.prevLines != 2) {
                    TitleViewManager.this.mTitleView.setTextSize(0, TitleViewManager.this.mTitleView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_two_line));
                    TitleViewManager.this.mTitleView.setLines(2);
                    this.prevLines = 2;
                    return;
                }
                return;
            }
            if (TitleViewManager.this.mIsCoverShowing) {
                if (this.prevLines != 4) {
                    TitleViewManager.this.mTitleView.setTextSize(0, TitleViewManager.this.mTitleView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_three_line));
                    TitleViewManager.this.mTitleView.setLines(4);
                    this.prevLines = 4;
                }
            } else if (this.prevLines != 3) {
                TitleViewManager.this.mTitleView.setTextSize(0, TitleViewManager.this.mTitleView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_three_line));
                TitleViewManager.this.mTitleView.setLines(3);
                this.prevLines = 3;
            }
            Logger.m11003i(TitleViewManager.TAG, "onChangedTitleText# " + this.prevLines + " / setLines = " + i);
        }

        private void updateLineCount(String str, int i) {
            int lineCount = TitleViewManager.this.mTitleView.getLineCount();
            AbstractC14516b.m15114b(lineCount, i, "onChangedTitleText# lineCount = ", "/ ", TitleViewManager.TAG);
            if (this.prevLineCount < lineCount && TitleViewManager.this.prevTextLength < i) {
                setLines(lineCount);
            } else if (TitleViewManager.this.prevTextLength > i) {
                TitleViewManager.this.mFontSizeView.setWidth(TitleViewManager.this.mTitleView.getWidth());
                if (lineCount <= 2) {
                    TitleViewManager.this.mFontSizeView.setTextSize(0, TitleViewManager.this.mTitleView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_two_line));
                } else {
                    TitleViewManager.this.mFontSizeView.setTextSize(0, TitleViewManager.this.mTitleView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_three_line));
                }
                TitleViewManager.this.mFontSizeView.setText(str);
                if (TitleViewManager.this.mFontSizeView.getLineCount() <= lineCount) {
                    setLines(lineCount);
                }
            }
            this.prevLineCount = lineCount;
            TitleViewManager.this.prevTextLength = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            onChangedTitleText(editable, this.startRegister, this.countRegister);
            this.startRegister = 0;
            this.countRegister = 0;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            this.startRegister = i;
            this.countRegister = i4;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTitleChangedListener {
        void onTitleChanged();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TitleContainerBottomCallback {
        void onBottomCalculated(int i);
    }

    public TitleViewManager(AppCompatActivity appCompatActivity, ICustomToolbar iCustomToolbar, View view, TitleEditorPresenter titleEditorPresenter, @Nullable OnTitleChangedListener onTitleChangedListener) {
        this.mActivity = appCompatActivity;
        this.mToolbar = iCustomToolbar;
        this.mPresenter = titleEditorPresenter;
        this.mTitleTextContainer = (ViewGroup) view.findViewById(C9086R.id.comp_title_text_container);
        this.mTitleView = (EditText) view.findViewById(C9086R.id.comp_title_text);
        this.mTitleFolderContainer = (ViewGroup) view.findViewById(C9086R.id.comp_title_folder_container);
        this.mToolbarTitleCopyView = (TextView) view.findViewById(C9086R.id.comp_title_toolbar_title_copy_view);
        this.mFontSizeView = (TextView) view.findViewById(C9086R.id.comp_title_toolbar_title_fontsize_view);
        this.mOnTitleChangedListener = onTitleChangedListener;
        this.mAiCoverBtn = new TitleAiCoverBtn(view, titleEditorPresenter.getAiCoverMenuViewPresenter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTextChangedListener() {
        this.mTitleView.addTextChangedListener(this.mTextWatcher);
    }

    private void changeMaxTitleLengthFilter() {
        for (InputFilter inputFilter : this.mTitleView.getFilters()) {
            if (inputFilter instanceof InputFilter.LengthFilter) {
                int max = ((InputFilter.LengthFilter) inputFilter).getMax();
                int titleMaxLength = this.mPresenter.getComposerModel().getComposerState().getTitleMaxLength();
                if (max < titleMaxLength) {
                    AbstractC14516b.m15114b(max, titleMaxLength, "changeMaxTitleLengthFilter# filterLength=", " / ", TAG);
                    setMaxTitleLengthFilter();
                    return;
                }
                return;
            }
        }
    }

    private String getHintString() {
        return (!this.mPresenter.isCoeditNote() || TextUtils.isEmpty(this.mPresenter.getCreator())) ? this.mActivity.getString(C9086R.string.composer_title_default_hint) : this.mActivity.getString(C9086R.string.coedit_note_auto_title, this.mPresenter.getCreator(), this.mPresenter.getCreatedDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTitleTextContainerBottom$3(Rect rect, TitleContainerBottomCallback titleContainerBottomCallback) {
        this.mTitleTextContainer.getHitRect(rect);
        if (rect.height() == 0) {
            titleContainerBottomCallback.onBottomCalculated(getTitleViewShowHideAnimator().getBottom());
        } else {
            titleContainerBottomCallback.onBottomCalculated(rect.bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view, boolean z) {
        if (z) {
            if (this.mPresenter.isCoeditNote()) {
                ComposerSA.insertLog(this.mPresenter.isEditMode() ? "683" : "682", ComposerSAConstants.EVENT_EDIT_CLICK_TITLE);
            } else if (this.mPresenter.isEditMode()) {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CLICK_TITLE);
            } else {
                ComposerSA.insertLog("301", ComposerSAConstants.EVENT_EDIT_CLICK_TITLE);
                ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_CHANGE_NOTE_TITLE, this.mPresenter.isTitleTextEmpty() ? "a" : "b");
            }
            if (this.mPresenter.checkNoServerPermission()) {
                view.clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$1(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && (keyEvent == null || 66 != keyEvent.getKeyCode())) {
            return false;
        }
        this.mPresenter.hide();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 - i != i8 - i6) {
            updateTextFontSize();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTextChangedListener() {
        this.mTitleView.removeTextChangedListener(this.mTextWatcher);
    }

    private void setDisableAiCoverBtn() {
        if (this.mPresenter.getAiCoverMenuViewPresenter().isCoverMenuEnabled(false)) {
            return;
        }
        this.mAiCoverBtn.setDisable();
    }

    private void setMaxTitleLengthFilter() {
        final int titleMaxLength = this.mPresenter.getComposerModel().getComposerState().getTitleMaxLength();
        this.mTitleView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(titleMaxLength) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewManager.2
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter == null) {
                    return charSequenceFilter;
                }
                if (TitleViewManager.this.mPresenter.isEditable()) {
                    ToastHandler.showContinuous(TitleViewManager.this.mActivity, TitleViewManager.this.mActivity.getString(C9086R.string.composer_maximum_input, Integer.valueOf(titleMaxLength)), 0);
                }
                return !CharUtils.isValidByteSymbol(charSequenceFilter, charSequence) ? "" : charSequenceFilter;
            }
        }});
    }

    private void updateTextFontSize() {
        this.mFontSizeView.setWidth(this.mTitleView.getWidth());
        this.mFontSizeView.setTextSize(0, this.mTitleView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_two_line));
        this.mFontSizeView.setText(this.mTitleView.getText());
        this.prevTextLength = this.mTitleView.getText().length();
        this.mFontSizeView.measure(0, 0);
        if (this.mFontSizeView.getLineCount() <= 2) {
            this.mTitleView.setTextSize(0, r0.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_two_line));
            this.mTitleView.setLines(2);
        } else {
            this.mIsCoverShowing = this.mPresenter.getAiCoverMenuViewPresenter().hasCover() && this.mPresenter.getAiCoverMenuViewPresenter().isCoverEnabled();
            this.mTitleView.setTextSize(0, r0.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_size_three_line));
            this.mTitleView.setLines(this.mIsCoverShowing ? 4 : 3);
        }
    }

    public AnimatorSet getHideAlphaAnimator() {
        return getTitleViewShowHideAnimator().getHideAlphaAnimator();
    }

    public AnimatorSet getShowAlphaAnimator() {
        return getTitleViewShowHideAnimator().getShowAlphaAnimator();
    }

    public String getTitleText() {
        return this.mTitleView.getText() == null ? "" : this.mTitleView.getText().toString();
    }

    public void getTitleTextContainerBottom(TitleContainerBottomCallback titleContainerBottomCallback) {
        this.mTitleTextContainer.post(new RunnableC8928b(this, 18, new Rect(), titleContainerBottomCallback));
    }

    public TitleViewShowHideAnimator getTitleViewShowHideAnimator() {
        if (this.mTitleViewShowHideAnimator == null) {
            this.mTitleViewShowHideAnimator = new TitleViewShowHideAnimator(this.mTitleTextContainer, this.mTitleView, this.mToolbarTitleCopyView, this.mTitleFolderContainer, new TitleViewShowHideAnimator.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewManager.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator.Contract
                public AppCompatActivity getActivity() {
                    return TitleViewManager.this.mActivity;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator.Contract
                public TitleEditorPresenter getPresenter() {
                    return TitleViewManager.this.mPresenter;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator.Contract
                public void onHide() {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator.Contract
                public void onShow() {
                    TitleViewManager.this.mTitleView.setSelection(TitleViewManager.this.mTitleView.getText().toString().length());
                }
            });
        }
        return this.mTitleViewShowHideAnimator;
    }

    public EditText getView() {
        return this.mTitleView;
    }

    public void init() {
        setTitle();
        this.mTitleView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(this, 7));
        addTextChangedListener();
        setMaxTitleLengthFilter();
        this.mTitleView.setOnEditorActionListener(new C10505d(this, 0));
        if (this.mTitleOnLayoutChangeListener == null) {
            this.mTitleOnLayoutChangeListener = new ViewOnLayoutChangeListenerC0162a(this, 8);
        }
        this.mTitleView.addOnLayoutChangeListener(this.mTitleOnLayoutChangeListener);
        setDisableAiCoverBtn();
        this.mAiCoverBtn.init();
        if (this.mPresenter.hasWritePermission()) {
            return;
        }
        updateEditableState(false);
    }

    public void initAnimationValueTitleView(int i, int i2, int i4, int i5) {
        getTitleViewShowHideAnimator().initAnimationValueTitleView(i, i2, i4, i5);
    }

    public void initAnimationValueToolbar(int i, int i2, int i4, int i5) {
        getTitleViewShowHideAnimator().initAnimationValueToolbar(this.mToolbarTitle, i, i2, i4, i5);
    }

    public void initCoverShowStatOneTitle() {
        this.mAiCoverBtn.initShowStateOnTitle();
    }

    public void initHideState(int i) {
        Logger.m10999d(TAG, "initHideState#");
        getTitleViewShowHideAnimator().initHideState(i);
    }

    public void initShowState(int i, int i2) {
        Logger.m10999d(TAG, "initShowState#");
        getTitleViewShowHideAnimator().initShowState(i, i2);
        this.mAiCoverBtn.initShowStateOnTitle();
    }

    public void setAiCoverBtnGoneState() {
        this.mAiCoverBtn.setVisibility(8);
    }

    public void setCoverAIIconColor(boolean z) {
        this.mAiCoverBtn.setCoverAIIconColor(z);
    }

    public void setTitle() {
        String title = this.mPresenter.getTitle();
        AbstractC8014b.m7195A(new StringBuilder("setTitle# length="), TAG, title != null ? title.length() : 0);
        if (this.mTitleView.getText() == null || !this.mTitleView.getText().toString().equals(title)) {
            changeMaxTitleLengthFilter();
            this.mTitleView.setText(title);
            title = getTitleText();
        }
        if (title != null) {
            this.mToolbar.setTitle(title);
        }
        updateTitleHint();
    }

    public void setToolbarTitle(AppCompatTextView appCompatTextView) {
        this.mToolbarTitle = appCompatTextView;
    }

    public void updateEditableState(boolean z) {
        if (this.mTitleView.isEnabled() == z) {
            return;
        }
        this.mTitleView.setEnabled(z);
        this.mTitleView.setInputType(z ? 16385 : 0);
        this.mTitleView.setFocusable(z);
        this.mTitleView.setFocusableInTouchMode(z);
    }

    public void updateTitle() {
        setDisableAiCoverBtn();
        setTitle();
    }

    public void updateTitleHint() {
        if (TextUtils.isEmpty(this.mPresenter.getTitle())) {
            int[] backgroundThemeColorTable = this.mPresenter.getBackgroundThemeColorTable();
            int alphaComponent = backgroundThemeColorTable[2] == 1 ? ColorUtils.setAlphaComponent(backgroundThemeColorTable[1], 102) : this.mActivity.getColor(C9086R.color.composer_light_title_color_hint);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(alphaComponent);
            SpannableString spannableString = new SpannableString(getHintString());
            spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
            this.mToolbar.setTitle(spannableString);
            this.mTitleView.setHint(spannableString);
            this.mTitleView.setHintTextColor(alphaComponent);
        }
    }

    public void updateViewByFraction(float f, boolean z) {
        getTitleViewShowHideAnimator().updateViewByFraction(f, z);
    }
}
