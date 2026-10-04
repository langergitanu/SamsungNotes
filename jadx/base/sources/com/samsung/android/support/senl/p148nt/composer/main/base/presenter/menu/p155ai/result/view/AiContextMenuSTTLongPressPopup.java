package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextMenuSTTLongPressPopup {
    private static final int ELEVATION = 8;
    private static final String TAG = "AiContextMenuSTTLongPressPopup";
    private View mAnchorView;
    private OnItemClickListener mOnItemClickListener;
    private OnPopupListener mOnPopupListener;
    private View mPopupView;
    private PopupWindow mPopupWindow;
    private ViewGroup mRootView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnItemClickListener {
        void onItemClick(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPopupListener {
        void onDismiss();

        void onShow();
    }

    public AiContextMenuSTTLongPressPopup(ViewGroup viewGroup, float f, float f4) {
        if (viewGroup == null) {
            return;
        }
        this.mRootView = viewGroup;
        this.mPopupView = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_context_result_stt_long_press_popup_layout, (ViewGroup) null);
        this.mPopupWindow = new PopupWindow(this.mPopupView, -2, -2, true);
        Log.d(TAG, "root width : " + viewGroup.getWidth() + " / root height :" + viewGroup.getHeight());
        View view = new View(viewGroup.getContext());
        this.mAnchorView = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        this.mAnchorView.setBackgroundColor(0);
        viewGroup.addView(this.mAnchorView);
        this.mAnchorView.setX(f);
        this.mAnchorView.setY(f4);
    }

    private void applyOnItemClickListener() {
        int childCount = ((ViewGroup) this.mPopupView).getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((ViewGroup) this.mPopupView).getChildAt(i).setOnClickListener(new ViewOnClickListenerC9704a(this, 0));
        }
    }

    private void applyOnPopupListener() {
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTLongPressPopup.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AiContextMenuSTTLongPressPopup.this.mRootView.removeView(AiContextMenuSTTLongPressPopup.this.mAnchorView);
                if (AiContextMenuSTTLongPressPopup.this.mOnPopupListener != null) {
                    AiContextMenuSTTLongPressPopup.this.mOnPopupListener.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyOnItemClickListener$0(View view) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view);
        }
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    public View getView() {
        return this.mPopupView;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnPopupListener(OnPopupListener onPopupListener) {
        this.mOnPopupListener = onPopupListener;
    }

    public void show() {
        applyOnItemClickListener();
        applyOnPopupListener();
        float x = this.mAnchorView.getX();
        float y2 = this.mAnchorView.getY();
        this.mPopupWindow.getContentView().measure(0, 0);
        Log.d(TAG, "popupWindow: " + this.mPopupWindow.getContentView().getMeasuredWidth() + " / " + this.mPopupWindow.getContentView().getMeasuredHeight() + " x/y " + x + "/" + y2);
        this.mPopupWindow.setElevation(8.0f);
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mAnchorView.getContext(), 12.0f);
        PopupWindow popupWindow = this.mPopupWindow;
        View view = this.mAnchorView;
        popupWindow.showAsDropDown(view, (view.getWidth() - this.mPopupWindow.getContentView().getMeasuredWidth()) / 2, (-this.mPopupWindow.getContentView().getMeasuredHeight()) - iConvertDpToPixel);
        OnPopupListener onPopupListener = this.mOnPopupListener;
        if (onPopupListener != null) {
            onPopupListener.onShow();
        }
    }
}
