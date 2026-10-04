package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.PopupWindowHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatTypePopupWindow {
    private View mAutoFormatMeetingButton;
    private View mAutoFormatNormalButton;
    private Handler mHandler;
    private PopupWindow mPopupWindow;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnItemClickListener {
        void onItemClick(AutoFormat.FormatType formatType);
    }

    public AutoFormatTypePopupWindow(Handler handler) {
        this.mHandler = handler;
    }

    public void hide() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    public void initAutoFormatTypePopupWindow(Context context, final OnItemClickListener onItemClickListener) {
        final ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_auto_format_layout, (ViewGroup) null, false);
        View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_context_auto_format_normal);
        this.mAutoFormatNormalButton = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onItemClickListener.onItemClick(AutoFormat.FormatType.Normal);
                AutoFormatTypePopupWindow.this.hide();
            }
        });
        View viewFindViewById2 = viewGroup.findViewById(C9086R.id.ai_menu_context_auto_format_meeting);
        this.mAutoFormatMeetingButton = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onItemClickListener.onItemClick(AutoFormat.FormatType.Meeting);
                AutoFormatTypePopupWindow.this.hide();
            }
        });
        if (Build.VERSION.SDK_INT < 33 || !AiViewUtils.isAtLeastOneUI7()) {
            PopupWindow popupWindow = new PopupWindow(viewGroup, -2, -2);
            this.mPopupWindow = popupWindow;
            OptionMenuPopupWindowHelper.setDefaultState(popupWindow, viewGroup.getContext());
        } else {
            this.mPopupWindow = OptionMenuPopupWindowHelper.getPopupWindowNewStyleLayout(context, viewGroup, this.mHandler);
            viewGroup.setBackgroundResource(C9086R.drawable.ai_menu_toolbar_bg_oneui_85);
            viewGroup.setClipToOutline(true);
        }
        if (this.mAutoFormatNormalButton.isLaidOut()) {
            PopupWindowHelper.updateContainerWidth((ViewGroup) this.mPopupWindow.getContentView().findViewById(C9086R.id.ai_menu_context_auto_format));
        } else {
            this.mAutoFormatNormalButton.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypePopupWindow.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (AutoFormatTypePopupWindow.this.mAutoFormatNormalButton.getMeasuredWidth() > 0) {
                        AutoFormatTypePopupWindow.this.mAutoFormatNormalButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        PopupWindowHelper.updateContainerWidth((ViewGroup) AutoFormatTypePopupWindow.this.mPopupWindow.getContentView().findViewById(C9086R.id.ai_menu_context_auto_format));
                    }
                }
            });
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void show(View view) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.getContentView().measure(0, 0);
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(view.getContext(), 12.0f);
        int height = view.getHeight() + iConvertDpToPixel;
        if ((rect.height() / 2) + rect.top < rect2.top) {
            height = (this.mPopupWindow.getContentView().getMeasuredHeight() + iConvertDpToPixel) * (-1);
        }
        this.mPopupWindow.showAsDropDown(view, (view.getWidth() - this.mPopupWindow.getContentView().getMeasuredWidth()) / 2, height);
    }
}
