package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatTypeListWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextMenuPopup {
    OnClickListener mClickListener;
    AutoFormatTypeListWindow mListPopupWindow;
    PopupWindow mPopupWindow;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickListener {
        boolean checkLimitationAutoFormat();

        void onClickAutoFormatMeeting();

        void onClickAutoFormatNormal();

        void onClickSpellingCorrection();

        void onClickSummarize();

        void onClickTranslate();
    }

    private void initView(ViewGroup viewGroup) {
        viewGroup.findViewById(C9086R.id.ai_menu_btn_autoformat).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiContextMenuPopup.this.mClickListener.checkLimitationAutoFormat()) {
                    AiContextMenuPopup aiContextMenuPopup = AiContextMenuPopup.this;
                    if (aiContextMenuPopup.mListPopupWindow == null) {
                        aiContextMenuPopup.mListPopupWindow = new AutoFormatTypeListWindow(true);
                        AiContextMenuPopup.this.mListPopupWindow.initAutoFormatTypeListWindow(view, new AutoFormatTypeListWindow.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuPopup.1.1
                            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypeListWindow.OnItemClickListener
                            public void onItemClick(AutoFormat.FormatType formatType) {
                                if (formatType.equals(AutoFormat.FormatType.Meeting)) {
                                    AiContextMenuPopup.this.mClickListener.onClickAutoFormatMeeting();
                                } else {
                                    AiContextMenuPopup.this.mClickListener.onClickAutoFormatNormal();
                                }
                                AiContextMenuPopup.this.hide();
                            }
                        });
                    }
                    AiContextMenuPopup.this.mListPopupWindow.show(null);
                }
            }
        });
        viewGroup.findViewById(C9086R.id.ai_menu_btn_spelling_correction).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuPopup.this.mClickListener.onClickSpellingCorrection();
                AiContextMenuPopup.this.hide();
            }
        });
        viewGroup.findViewById(C9086R.id.ai_menu_btn_summarize).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuPopup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuPopup.this.mClickListener.onClickSummarize();
                AiContextMenuPopup.this.hide();
            }
        });
        View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_btn_translate);
        if (FeatureInfo.isSupportNeuralTranslationFunction()) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuPopup.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AiContextMenuPopup.this.mClickListener.onClickTranslate();
                    AiContextMenuPopup.this.hide();
                }
            });
        } else {
            viewFindViewById.setVisibility(8);
        }
        updateTopBottomPadding((ViewGroup) viewGroup.findViewById(C9086R.id.ai_context_inner_container));
    }

    private void initWindow(Context context, View view) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        this.mPopupWindow = popupWindow;
        popupWindow.setTouchable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setClippingEnabled(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setInputMethodMode(2);
        this.mPopupWindow.setOverlapAnchor(true);
        this.mPopupWindow.setBackgroundDrawable(context.getDrawable(C9086R.drawable.ai_menu_toolbar_bg));
        this.mPopupWindow.setElevation(8.0f);
        this.mPopupWindow.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
    }

    public static void updateTopBottomPadding(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view = null;
        View view2 = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (view == null) {
                    view = childAt;
                }
                view2 = childAt;
            }
        }
        updateTopBottomPadding(view, view2);
    }

    public void hide() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public void init(Context context, OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_style_layout, (ViewGroup) null, false);
        initView(viewGroup);
        initWindow(context, viewGroup);
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    public void show(View view) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.getContentView().measure(0, 0);
        int measuredWidth = this.mPopupWindow.getContentView().getMeasuredWidth();
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(view.getContext(), 12.0f);
        this.mPopupWindow.showAtLocation(view.getRootView(), 0, (rect.right + ((int) ResourceUtils.convertDpToPixel(view.getContext(), 10.0f))) - measuredWidth, rect.top - iConvertDpToPixel);
    }

    private static void updateTopBottomPadding(View view, View view2) {
        if (view == null) {
            return;
        }
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_top_bottom_padding);
        view.setPadding(view.getPaddingLeft(), dimensionPixelSize, view.getPaddingRight(), view.getPaddingBottom());
        if (view2 != null) {
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), dimensionPixelSize);
        }
    }
}
