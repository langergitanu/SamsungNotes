package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PageIndexInfoView {
    private static final int ADJUST_TEXT_WIDTH = 3;
    private static final String TAG = Logger.createTag("PageIndexInfoView");
    private final Contract mContract;
    private final boolean mIsTablet;
    private TextView mPageCountView;
    private EditText mPageIndexView;
    private PageIndexViewTextWatcher mPageIndexViewTextWatcher;
    private View mPageInfoLayout;
    private final PageListPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getCurrentPageIndex();

        View getNextView();

        int getTotalPageCount();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PageIndexViewTextWatcher implements TextWatcher {
        public /* synthetic */ PageIndexViewTextWatcher(PageIndexInfoView pageIndexInfoView, int i) {
            this();
        }

        private int getIntFromString(String str) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                Logger.m11000e(PageIndexInfoView.TAG, "getIntFromString : " + e + "/" + str);
                return -1;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int displayPageCount;
            int intFromString;
            String strConvertToArabicNumber;
            int length = editable.length();
            if (length != 0 && (displayPageCount = PageIndexInfoView.this.getDisplayPageCount()) > 0) {
                String string = editable.toString();
                if (string.startsWith("0")) {
                    if (length == 1) {
                        strConvertToArabicNumber = "";
                    } else {
                        int intFromString2 = getIntFromString(string.substring(1));
                        intFromString = intFromString2 >= 0 ? intFromString2 : 0;
                        strConvertToArabicNumber = LocaleUtils.convertToArabicNumber(intFromString);
                    }
                    PageIndexInfoView.this.mPageIndexView.setText(strConvertToArabicNumber);
                } else {
                    intFromString = getIntFromString(string);
                    if (intFromString > displayPageCount || intFromString < 0) {
                        PageIndexInfoView.this.mPageIndexView.setText(LocaleUtils.convertToArabicNumber(displayPageCount));
                        PageIndexInfoView.this.mPageIndexView.setSelection(PageIndexInfoView.this.mPageIndexView.getText().toString().length());
                        intFromString = displayPageCount;
                    }
                }
                updateLayoutForAutoResize();
                PageIndexInfoView.this.updatePageInfoVoiceAssistant(intFromString, displayPageCount);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            Logger.m10999d(PageIndexInfoView.TAG, "beforeTextChanged# " + ((Object) charSequence));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
        }

        public void updateLayoutForAutoResize() {
            if (PageIndexInfoView.this.mPageIndexView.getLayoutParams().width != -2) {
                PageIndexInfoView.this.mPageIndexView.getLayoutParams().width = -2;
                PageIndexInfoView.this.mPageIndexView.requestLayout();
            }
        }

        private PageIndexViewTextWatcher() {
        }
    }

    public PageIndexInfoView(@NonNull Contract contract, PageListPresenter pageListPresenter, boolean z) {
        this.mContract = contract;
        this.mPresenter = pageListPresenter;
        this.mIsTablet = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDisplayPageCount() {
        return this.mContract.getTotalPageCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDisplayPageIndex() {
        return this.mContract.getCurrentPageIndex() + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageIndexShown(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        return Math.min(Integer.parseInt(str), getDisplayPageCount());
    }

    private boolean isTextMeasureCase(TextView textView, CharSequence charSequence, boolean z) {
        if (this.mIsTablet) {
            return z || textView.getLayoutParams().width == -2 || !charSequence.equals(textView.getText().toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updatePageIndexView(int i) {
        String strConvertToArabicNumber = LocaleUtils.convertToArabicNumber(i);
        boolean zIsTextMeasureCase = isTextMeasureCase(this.mPageIndexView, strConvertToArabicNumber, false);
        this.mPageIndexView.setText(strConvertToArabicNumber);
        if (!zIsTextMeasureCase) {
            return false;
        }
        this.mPageIndexView.getLayoutParams().width = ((int) Math.ceil(this.mPageIndexView.getPaint().measureText(strConvertToArabicNumber))) + 3;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StringFormatInvalid"})
    public void updatePageInfoVoiceAssistant(int i, int i2) {
        this.mPageInfoLayout.setContentDescription(this.mPageInfoLayout.getContext().getResources().getString(C9086R.string.composer_list_page_info, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public EditText getPageIndexView() {
        return this.mPageIndexView;
    }

    public void init(View view) {
        Context context = view.getContext();
        this.mPageInfoLayout = view.findViewById(C9086R.id.comp_page_list_page_info_layout);
        EditText editText = (EditText) view.findViewById(C9086R.id.comp_page_list_page_index_view);
        this.mPageIndexView = editText;
        editText.setImeOptions(268435462);
        ViewCompat.getInstance().setAutoHandwritingEnabled(this.mPageIndexView, false);
        CharUtils.applyTextSizeUntilLargeSize(context, this.mPageIndexView, ResourceUtils.convertPixelToSp(context, context.getResources().getDimension(C9086R.dimen.comp_page_list_toolbar_menu_text_size)));
        this.mPageIndexView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageIndexInfoView.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && (i != 0 || keyEvent == null || keyEvent.getKeyCode() != 66)) {
                    return false;
                }
                PageIndexInfoView pageIndexInfoView = PageIndexInfoView.this;
                int pageIndexShown = pageIndexInfoView.getPageIndexShown(pageIndexInfoView.mPageIndexView.getText().toString());
                PageIndexInfoView.this.mPageIndexView.setText(LocaleUtils.convertToArabicNumber(pageIndexShown));
                PageIndexInfoView.this.mPresenter.onPageIndexChanged(textView, pageIndexShown - 1);
                if (PageIndexInfoView.this.mIsTablet) {
                    ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_PAGE_NUMBER);
                }
                return true;
            }
        });
        this.mPageIndexViewTextWatcher = new PageIndexViewTextWatcher(this, 0);
        this.mPageIndexView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageIndexInfoView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                AbstractC8014b.m7220v("pageIndexView, onFocusChange# ", PageIndexInfoView.TAG, z);
                PageIndexInfoView.this.mPresenter.onFocusChanged(view2, z);
                if (z) {
                    PageIndexInfoView.this.mPageIndexView.setSelection(PageIndexInfoView.this.mPageIndexView.getText().toString().length());
                    PageIndexInfoView.this.mPageIndexView.addTextChangedListener(PageIndexInfoView.this.mPageIndexViewTextWatcher);
                } else {
                    PageIndexInfoView.this.mPageIndexView.removeTextChangedListener(PageIndexInfoView.this.mPageIndexViewTextWatcher);
                    PageIndexInfoView pageIndexInfoView = PageIndexInfoView.this;
                    pageIndexInfoView.updatePageIndexView(pageIndexInfoView.getDisplayPageIndex());
                }
            }
        });
        TextView textView = (TextView) view.findViewById(C9086R.id.comp_page_list_count_view);
        this.mPageCountView = textView;
        CharUtils.applyTextSizeUntilLargeSize(context, textView, ResourceUtils.convertPixelToSp(context, context.getResources().getDimension(C9086R.dimen.comp_page_list_toolbar_menu_text_size)));
        this.mPageCountView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageIndexInfoView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!PageIndexInfoView.this.mPageIndexView.hasFocus()) {
                    PageIndexInfoView.this.mPageIndexView.requestFocus();
                }
                PageIndexInfoView.this.mPageIndexView.setSelection(Math.max(PageIndexInfoView.this.mPageIndexView.getText().length(), 0));
                PageIndexInfoView.this.mPresenter.showSoftInput(PageIndexInfoView.this.mPageIndexView);
                return false;
            }
        });
    }

    public void setVisibility(int i) {
        this.mPageIndexView.setVisibility(i);
        this.mPageCountView.setVisibility(i);
    }

    public void updatePageCountInfo() {
        int displayPageIndex = getDisplayPageIndex();
        int displayPageCount = getDisplayPageCount();
        updatePageCountView(displayPageCount, updatePageIndexView(displayPageIndex));
        updatePageInfoVoiceAssistant(displayPageIndex, displayPageCount);
    }

    public void updatePageCountView(int i, boolean z) {
        SpannableString spannableString = new SpannableString(AbstractC0541b.m772n("/", LocaleUtils.convertToArabicNumber(i)));
        spannableString.setSpan(new ForegroundColorSpan(this.mPageIndexView.getCurrentTextColor()), 0, 1, 33);
        boolean zIsTextMeasureCase = isTextMeasureCase(this.mPageCountView, spannableString, z);
        this.mPageCountView.setText(spannableString);
        if (!zIsTextMeasureCase || this.mContract.getNextView().getLeft() <= 0) {
            return;
        }
        float fMeasureText = this.mPageIndexView.getPaint().measureText(spannableString.toString());
        this.mPageCountView.getLayoutParams().width = Math.min(((int) Math.ceil(fMeasureText)) + 3, Math.abs((this.mContract.getNextView().getLeft() - this.mPageInfoLayout.getLeft()) - this.mPageIndexView.getLayoutParams().width));
    }
}
