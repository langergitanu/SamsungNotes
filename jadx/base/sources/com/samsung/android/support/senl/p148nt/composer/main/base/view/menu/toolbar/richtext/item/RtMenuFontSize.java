package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.CustomAccessibilityDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuFontSize extends AbsRtMenuListPopupWindow<String> {
    private static final String TAG = Logger.createTag("RtMenuFontSize");
    private String mFontSizeString;
    private final boolean mIsTabletUX;
    private RtToolbarContract.OnClickValueListener mOnClickValueListener;
    private final int mTextColor;

    public RtMenuFontSize(Activity activity, View view, View view2) {
        super(activity, view, view2);
        this.mOnClickValueListener = null;
        this.mTextColor = view.getResources().getColor(C9086R.color.composer_default_text_color, null);
        this.mIsTabletUX = SpenConfiguration.isTabletUX(this.mActivity);
    }

    private void updateListSelection() {
        String[] stringArray = this.mActivity.getResources().getStringArray(this.mIsTabletUX ? C9086R.array.tablet_rich_text_hw_font_size : C9086R.array.rich_text_hw_font_size);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (LocaleUtils.convertToArabicNumber(Integer.valueOf(stringArray[i]).intValue()).equals(this.mFontSizeString)) {
                this.mListPopupWindow.setSelection(i);
                return;
            }
        }
    }

    private void updateRichTextPopup(int i) {
        String strConvertToArabicNumber = i > 0 ? LocaleUtils.convertToArabicNumber(i) : "";
        TextView textView = (TextView) this.mContainer.findViewById(C9086R.id.richtext_font_size_spinner_name);
        if (textView != null && !TextUtils.equals(textView.getText(), strConvertToArabicNumber)) {
            textView.setText(strConvertToArabicNumber);
        }
        this.mView.setAccessibilityDelegate(new CustomAccessibilityDelegate(this.mView.getContentDescription().toString(), this.mContainer.getResources().getString(C9086R.string.rich_text_dropdown_list) + SQLKeyword.COMMA + strConvertToArabicNumber));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public ArrayAdapter<String> getArrayAdapter() {
        return new ArrayAdapter<String>(this.mContainer.getContext(), C9086R.layout.comp_rt_menu_font_size_droplist_item, this.mContainer.getResources().getStringArray(this.mIsTabletUX ? C9086R.array.tablet_rich_text_hw_font_size : C9086R.array.rich_text_hw_font_size)) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFontSize.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
                String str;
                RelativeLayout relativeLayout = view instanceof RelativeLayout ? (RelativeLayout) view : (RelativeLayout) LayoutInflater.from(RtMenuFontSize.this.mContainer.getContext()).inflate(C9086R.layout.comp_rt_menu_font_size_droplist_item, (ViewGroup) null);
                TextView textView = (TextView) relativeLayout.findViewById(C9086R.id.item_text);
                textView.setText(LocaleUtils.convertToArabicNumber(Integer.valueOf((String) getItem(i)).intValue()));
                if (textView.getText().toString().equals(RtMenuFontSize.this.mFontSizeString)) {
                    textView.setTextColor(RtMenuFontSize.this.mContainer.getResources().getColor(C9086R.color.notes_primary_color, null));
                    relativeLayout.getChildAt(1).setVisibility(0);
                    str = RtMenuFontSize.this.mContainer.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) + SQLKeyword.COMMA;
                } else {
                    textView.setTextColor(RtMenuFontSize.this.mTextColor);
                    relativeLayout.getChildAt(1).setVisibility(4);
                    str = RtMenuFontSize.this.mContainer.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected) + SQLKeyword.COMMA;
                }
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                sbM1324q.append((Object) textView.getText());
                textView.setAccessibilityDelegate(new CustomAccessibilityDelegate(textView.getText().toString(), sbM1324q.toString()));
                return relativeLayout;
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        this.mOnClickValueListener = null;
        return super.hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = TAG;
        Logger.m10999d(str, "FontSize# click");
        if (this.mPresenter == null) {
            hidePopup();
            return;
        }
        String strValueOf = String.valueOf(((TextView) view.findViewById(C9086R.id.item_text)).getText());
        int iIntValue = Integer.valueOf(strValueOf).intValue();
        AbstractC0000a.m3D(iIntValue, "FontSize# ", str);
        RtToolbarContract.OnClickValueListener onClickValueListener = this.mOnClickValueListener;
        if (onClickValueListener != null) {
            onClickValueListener.apply(iIntValue);
        } else {
            this.mPresenter.setFontSizeWithTask(iIntValue);
            updateRichTextPopup(iIntValue);
            ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_FONT_SIZE_SELECTION, strValueOf);
        }
        hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void showPopup() {
        this.mFontSizeString = ((TextView) this.mContainer.findViewById(C9086R.id.richtext_font_size_spinner_name)).getText().toString();
        super.showPopup();
        updateListSelection();
    }

    public void showPopupAsDropDown(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        this.mOnClickValueListener = onClickValueListener;
        this.mFontSizeString = String.valueOf(view.getTag());
        initListPopupWindow(this.mView.getContext());
        this.mListPopupWindow.setAnchorView(view);
        try {
            this.mListPopupWindow.show();
        } catch (WindowManager.BadTokenException e) {
            Logger.m11000e(TAG, "showPopupAsDropDown : " + e.getMessage());
        }
        updateListSelection();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public void updatePopup() {
        if (this.mOnClickValueListener != null) {
            hidePopup();
        } else {
            super.updatePopup();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        if (!spanStates.getFontSize().isEnable()) {
            updateRichTextPopup(0);
        } else {
            updateRichTextPopup(spanStates.getFontSize().getDeltaSize() + spanStates.getFontSize().getValue());
        }
    }
}
