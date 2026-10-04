package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContentSwitcherMenu {
    private static final String TAG = Logger.createTag("ContentSwitcherMenu");
    private AiContextMenuPresenter mAiContextMenuPresenter;
    private View mContainerSwitchContent;
    private PopupWindow mSwitchedTypePopupWindow;

    public ContentSwitcherMenu(Activity activity, AiContextMenuPresenter aiContextMenuPresenter) {
        this.mContainerSwitchContent = activity.findViewById(C9086R.id.comp_ai_switch_button_container);
        this.mAiContextMenuPresenter = aiContextMenuPresenter;
    }

    private void initSwitchContentButton() {
        View view = this.mContainerSwitchContent;
        if (view == null) {
            return;
        }
        view.findViewById(C9086R.id.comp_ai_switch_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.ContentSwitcherMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ContentSwitcherMenu.this.showSwitchedTypePopup(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSwitchedTypePopup(View view) {
        List<Integer> listNextSwitchContent = this.mAiContextMenuPresenter.getContentSwitcher().getListNextSwitchContent();
        if (listNextSwitchContent.isEmpty()) {
            Logger.m11000e(TAG, "showSwitchedTypePopup# typeList is null");
            this.mContainerSwitchContent.findViewById(C9086R.id.comp_ai_switch_button).setVisibility(8);
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(view.getContext()).inflate(C9086R.layout.ai_menu_selecti_type_layout, (ViewGroup) null, false);
        for (Integer num : listNextSwitchContent) {
            if (num.intValue() == 0) {
                View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_select_pdf);
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.ContentSwitcherMenu.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ContentSwitcherMenu.this.mSwitchedTypePopupWindow.dismiss();
                        ContentSwitcherMenu.this.mAiContextMenuPresenter.switchContents(0);
                    }
                });
                viewFindViewById.setVisibility(0);
            } else if (num.intValue() == 1) {
                View viewFindViewById2 = viewGroup.findViewById(C9086R.id.ai_menu_select_body_text);
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.ContentSwitcherMenu.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ContentSwitcherMenu.this.mSwitchedTypePopupWindow.dismiss();
                        ContentSwitcherMenu.this.mAiContextMenuPresenter.switchContents(1);
                    }
                });
                viewFindViewById2.setVisibility(0);
            } else if (num.intValue() == 2) {
                View viewFindViewById3 = viewGroup.findViewById(C9086R.id.ai_menu_select_handwriting);
                viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.ContentSwitcherMenu.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ContentSwitcherMenu.this.mSwitchedTypePopupWindow.dismiss();
                        ContentSwitcherMenu.this.mAiContextMenuPresenter.switchContents(2);
                    }
                });
                viewFindViewById3.setVisibility(0);
            }
        }
        PopupWindow popupWindow = new PopupWindow(viewGroup, -2, -2);
        this.mSwitchedTypePopupWindow = popupWindow;
        OptionMenuPopupWindowHelper.setDefaultState(popupWindow, viewGroup.getContext());
        this.mSwitchedTypePopupWindow.getContentView().measure(0, 0);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(viewGroup.findViewById(C9086R.id.ai_menu_select_pdf));
        arrayList.add(viewGroup.findViewById(C9086R.id.ai_menu_select_body_text));
        arrayList.add(viewGroup.findViewById(C9086R.id.ai_menu_select_handwriting));
        if (viewGroup.isLaidOut()) {
            updateContainerWidth(arrayList, viewGroup.getWidth());
        } else {
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.ContentSwitcherMenu.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (viewGroup.getMeasuredWidth() > 0) {
                        viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ContentSwitcherMenu.this.updateContainerWidth(arrayList, viewGroup.getWidth());
                    }
                }
            });
        }
        if (view.getRootView() != null) {
            view.getRootView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.ContentSwitcherMenu.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (i4 - i == i8 - i6 && i5 - i2 == i9 - i7) {
                        return;
                    }
                    view2.removeOnLayoutChangeListener(this);
                    if (ContentSwitcherMenu.this.mSwitchedTypePopupWindow == null || !ContentSwitcherMenu.this.mSwitchedTypePopupWindow.isShowing()) {
                        return;
                    }
                    ContentSwitcherMenu.this.mSwitchedTypePopupWindow.dismiss();
                }
            });
        }
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(view.getContext(), 8.0f);
        this.mSwitchedTypePopupWindow.showAsDropDown(view, ((int) ResourceUtils.convertDpToPixel(view.getContext(), 8.0f)) * (-1), (this.mSwitchedTypePopupWindow.getContentView().getMeasuredHeight() + iConvertDpToPixel) * (-1));
    }

    public View getContainerSwitchContent() {
        return this.mContainerSwitchContent;
    }

    public void init() {
        initSwitchContentButton();
    }

    public void updateContainerWidth(List<View> list, int i) {
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            if (view.getVisibility() == 0 && i < view.getMeasuredWidth()) {
                i = view.getMeasuredWidth();
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = list.get(i4);
            if (view2.getVisibility() == 0 && view2.getMeasuredWidth() < i) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.width = i;
                view2.setLayoutParams(layoutParams);
            }
        }
    }
}
