package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SummaryOptionPopup implements DialogContract.IDialog {
    private static final String TAG = Logger.createTag("SummaryOptionPopup", AiConstants.PREFIX_TAG);
    private final Context mContext;
    private boolean mIsSTTMode;
    private PopupWindow mPopup;
    private final DialogContract.ISummaryOptionDialogPresenter mPresenter;
    private int mSelectedItem;

    public SummaryOptionPopup(Context context, int i, DialogContract.ISummaryOptionDialogPresenter iSummaryOptionDialogPresenter, boolean z) {
        this.mIsSTTMode = false;
        Logger.m10999d(TAG, "SummaryOptionPopup#");
        this.mContext = context;
        this.mPresenter = iSummaryOptionDialogPresenter;
        this.mIsSTTMode = z;
        this.mSelectedItem = i;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_result_summary_option_layout, (ViewGroup) null, false);
        initPopup(viewGroup);
        initItem(viewGroup);
    }

    private void initItem(ViewGroup viewGroup) {
        CharSequence[] charSequenceArr = this.mIsSTTMode ? new CharSequence[]{this.mContext.getString(C9086R.string.ai_summary_style_dialog_show_as_timeline), this.mContext.getString(C9086R.string.ai_summary_style_dialog_group_by_subject)} : new CharSequence[]{this.mContext.getString(C9086R.string.ai_summrize_option_dialog_standard), this.mContext.getString(C9086R.string.ai_summrize_option_dialog_detail)};
        viewGroup.findViewById(C9086R.id.ai_menu_btn_standard).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SummaryOptionPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SummaryOptionPopup.this.mSelectedItem = 0;
                SummaryOptionPopup.this.mPresenter.setOption(SummaryOptionPopup.this.mSelectedItem);
                SummaryOptionPopup.this.dismiss();
            }
        });
        TextView textView = (TextView) viewGroup.findViewById(C9086R.id.ai_menu_txt_standard);
        View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_icon_standard_checked);
        textView.setText(charSequenceArr[0]);
        viewGroup.findViewById(C9086R.id.ai_menu_btn_detail).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SummaryOptionPopup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SummaryOptionPopup.this.mSelectedItem = 1;
                SummaryOptionPopup.this.mPresenter.setOption(SummaryOptionPopup.this.mSelectedItem);
                SummaryOptionPopup.this.dismiss();
            }
        });
        TextView textView2 = (TextView) viewGroup.findViewById(C9086R.id.ai_menu_txt_detail);
        View viewFindViewById2 = viewGroup.findViewById(C9086R.id.ai_menu_icon_detail_checked);
        textView2.setText(charSequenceArr[1]);
        Typeface typeface = textView.getTypeface();
        if (Build.VERSION.SDK_INT >= 28) {
            typeface = Typeface.create(Typeface.create("sec", 0), 600, false);
        }
        int i = this.mSelectedItem;
        if (i == 0) {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            textView.setTypeface(typeface);
            textView.setTextColor(ContextCompat.getColor(this.mContext, C9086R.color.ai_ai_summary_style_text_item_selected));
            return;
        }
        if (i == 1) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(0);
            textView2.setTypeface(typeface);
            textView2.setTextColor(ContextCompat.getColor(this.mContext, C9086R.color.ai_ai_summary_style_text_item_selected));
            return;
        }
        Logger.m11000e(TAG, "initItem# mSelectedItem " + this.mSelectedItem);
    }

    private void initPopup(View view) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        this.mPopup = popupWindow;
        popupWindow.setTouchable(true);
        this.mPopup.setOutsideTouchable(true);
        this.mPopup.setOutsideTouchable(true);
        this.mPopup.setClippingEnabled(true);
        this.mPopup.setFocusable(true);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setOverlapAnchor(true);
        this.mPopup.setBackgroundDrawable(this.mContext.getDrawable(C9086R.drawable.ai_menu_toolbar_bg));
        this.mPopup.setElevation(8.0f);
        this.mPopup.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
        this.mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SummaryOptionPopup.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                SummaryOptionPopup.this.mPresenter.onDismiss();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void dismiss() {
        PopupWindow popupWindow = this.mPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopup;
        return popupWindow != null && popupWindow.isShowing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void show() {
        int[] location = this.mPresenter.getLocation();
        View anchorView = this.mPresenter.getAnchorView();
        if (location != null && anchorView != null) {
            this.mPopup.getContentView().measure(0, 0);
            this.mPopup.showAtLocation(anchorView, 0, location[0] - (this.mPopup.getContentView().getMeasuredWidth() / 2), location[1]);
        } else {
            Logger.m11000e(TAG, "show# can not show location " + Arrays.toString(location));
        }
    }
}
