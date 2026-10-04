package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.TextFormat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuTextFormat extends AbsRtMenuListPopupWindow<Integer> {
    private static final String TAG = Logger.createTag("RtMenuTextFormat");
    private int mFormat;

    public RtMenuTextFormat(Activity activity, View view, View view2) {
        super(activity, view, view2);
        this.mFormat = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFormatFromPos(int i) {
        if (i < 0) {
            return -1;
        }
        int[] iArr = TextFormat.TEXT_FORMAT_TYPES;
        if (i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    private List<Integer> getFormatTypeList() {
        return (List) Arrays.stream(TextFormat.TEXT_FORMAT_TYPES).boxed().collect(Collectors.toList());
    }

    private int getSelectedPos() {
        int length = TextFormat.TEXT_FORMAT_TYPES.length;
        for (int i = 0; i < length; i++) {
            if (TextFormat.TEXT_FORMAT_TYPES[i] == this.mFormat) {
                return i;
            }
        }
        return -1;
    }

    private void updateListSelection() {
        int selectedPos = getSelectedPos();
        if (selectedPos < 0) {
            this.mListPopupWindow.clearListSelection();
        } else {
            this.mListPopupWindow.setSelection(selectedPos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextView(TextView textView, int i) {
        if (i >= 0) {
            int[] iArr = TextFormat.TEXT_FORMAT_TYPES;
            if (i >= iArr.length || textView == null) {
                return;
            }
            int i2 = iArr[i];
            if (i2 == 0) {
                textView.setText(this.mActivity.getResources().getString(C9086R.string.comp_rt_menu_text_format_heading, 1));
                textView.setTextSize(2, 21.0f);
                textView.setTypeface(null, 1);
                return;
            }
            if (i2 == 1) {
                textView.setText(this.mActivity.getResources().getString(C9086R.string.comp_rt_menu_text_format_heading, 2));
                textView.setTextSize(2, 19.0f);
                textView.setTypeface(null, 1);
                return;
            }
            if (i2 == 2) {
                textView.setText(this.mActivity.getResources().getString(C9086R.string.comp_rt_menu_text_format_heading, 3));
                textView.setTextSize(2, 15.0f);
                textView.setTypeface(null, 1);
            } else if (i2 == 3) {
                textView.setText(this.mActivity.getResources().getString(C9086R.string.comp_rt_menu_text_format_body, 1));
                textView.setTextSize(2, 15.0f);
                textView.setTypeface(null, 0);
            } else if (i2 == -1) {
                textView.setText(this.mActivity.getResources().getString(C9086R.string.comp_rt_menu_text_format_body, 2));
                textView.setTextSize(2, 17.0f);
                textView.setTypeface(null, 0);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public ArrayAdapter<Integer> getArrayAdapter() {
        return new ArrayAdapter<Integer>(this.mContainer.getContext(), C9086R.layout.comp_rt_menu_text_format_list_item, getFormatTypeList()) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextFormat.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
                RelativeLayout relativeLayout = view instanceof RelativeLayout ? (RelativeLayout) view : (RelativeLayout) LayoutInflater.from(RtMenuTextFormat.this.mContainer.getContext()).inflate(C9086R.layout.comp_rt_menu_text_format_list_item, viewGroup, false);
                RtMenuTextFormat.this.updateTextView((TextView) relativeLayout.findViewById(C9086R.id.item_text), i);
                if (RtMenuTextFormat.this.getFormatFromPos(i) == RtMenuTextFormat.this.mFormat) {
                    relativeLayout.getChildAt(1).setVisibility(0);
                    return relativeLayout;
                }
                relativeLayout.getChildAt(1).setVisibility(4);
                return relativeLayout;
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public int getPopupWindowHeight() {
        return this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.composer_rich_text_menu_text_format_dropdown_list_popup_height);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public int getPopupWindowWidth() {
        return this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.composer_rich_text_menu_text_format_dropdown_list_popup_width);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        return super.hidePopup();
    }

    public void insertSALogging(int i) {
        String str = i == 0 ? "a" : i == 1 ? "b" : i == 2 ? "c" : i == 3 ? "d" : i == -1 ? "e" : "";
        if (str.isEmpty()) {
            return;
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_TEXT_FORMAT, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = TAG;
        Logger.m10999d(str, "TextFormat# click");
        if (this.mPresenter == null) {
            hidePopup();
            return;
        }
        int formatFromPos = getFormatFromPos(i);
        this.mPresenter.setTextFormat(formatFromPos);
        insertSALogging(formatFromPos);
        Logger.m10999d(str, "TextFormat# " + formatFromPos);
        hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuListPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void showPopup() {
        super.showPopup();
        updateListSelection();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        updateState(spanStates.getTextFormat().getValue());
    }

    public void updateState(int i) {
        for (int i2 : TextFormat.TEXT_FORMAT_TYPES) {
            if (i2 == i) {
                this.mFormat = i;
                return;
            }
        }
        this.mFormat = -1;
    }
}
