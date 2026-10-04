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
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.PopupWindowHelper;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DrawingAssistTypePopupWindow {
    private View mDrawingAssistGreetingCardButton;
    private View mDrawingAssistImageButton;
    private View mDrawingAssistInvitationButton;
    private View mDrawingAssistStickerButton;
    private Handler mHandler;
    private PopupWindow mPopupWindow;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnItemClickListener {
        void onItemClick(StudioType studioType);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum StudioType {
        Image(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_IMAGE),
        Sticker("sticker"),
        Invitation(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_INVITATION),
        GreetingCard(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_GREETING_CARD);

        final String mStr;

        StudioType(@NotNull String str) {
            this.mStr = str;
        }

        public String getStr() {
            return this.mStr;
        }
    }

    public DrawingAssistTypePopupWindow(Handler handler) {
        this.mHandler = handler;
    }

    public void hide() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    public void initDrawingAssistTypePopupWindow(Context context, boolean z, final OnItemClickListener onItemClickListener) {
        final ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_drawing_assist_layout, (ViewGroup) null, false);
        View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_context_list_item_divider);
        List<String> creativeStudioMetaData = Features.getCreativeStudioMetaData();
        View viewFindViewById2 = viewGroup.findViewById(C9086R.id.ai_menu_context_drawing_assist_image);
        this.mDrawingAssistImageButton = viewFindViewById2;
        if (z) {
            viewFindViewById2.setVisibility(0);
            this.mDrawingAssistImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.DrawingAssistTypePopupWindow.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onItemClickListener.onItemClick(StudioType.Image);
                    DrawingAssistTypePopupWindow.this.hide();
                }
            });
            if (creativeStudioMetaData == null || creativeStudioMetaData.contains("sticker") || creativeStudioMetaData.contains(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_INVITATION) || creativeStudioMetaData.contains(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_GREETING_CARD)) {
                viewFindViewById.setVisibility(0);
            } else {
                viewFindViewById.setVisibility(8);
            }
        } else {
            viewFindViewById2.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        this.mDrawingAssistStickerButton = viewGroup.findViewById(C9086R.id.ai_menu_context_drawing_assist_sticker);
        if (creativeStudioMetaData == null || !creativeStudioMetaData.contains("sticker")) {
            this.mDrawingAssistStickerButton.setVisibility(8);
        } else {
            this.mDrawingAssistStickerButton.setVisibility(0);
            this.mDrawingAssistStickerButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.DrawingAssistTypePopupWindow.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onItemClickListener.onItemClick(StudioType.Sticker);
                    DrawingAssistTypePopupWindow.this.hide();
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "l");
                }
            });
        }
        this.mDrawingAssistInvitationButton = viewGroup.findViewById(C9086R.id.ai_menu_context_drawing_assist_invitation);
        if (creativeStudioMetaData == null || !creativeStudioMetaData.contains(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_INVITATION)) {
            this.mDrawingAssistInvitationButton.setVisibility(8);
        } else {
            this.mDrawingAssistInvitationButton.setVisibility(0);
            this.mDrawingAssistInvitationButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.DrawingAssistTypePopupWindow.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onItemClickListener.onItemClick(StudioType.Invitation);
                    DrawingAssistTypePopupWindow.this.hide();
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "m");
                }
            });
        }
        this.mDrawingAssistGreetingCardButton = viewGroup.findViewById(C9086R.id.ai_menu_context_drawing_assist_greeting_card);
        if (creativeStudioMetaData == null || !creativeStudioMetaData.contains(Constant.DRAWING_TOOLKIT_KEY_STUDIO_TYPE_GREETING_CARD)) {
            this.mDrawingAssistGreetingCardButton.setVisibility(8);
        } else {
            this.mDrawingAssistGreetingCardButton.setVisibility(0);
            this.mDrawingAssistGreetingCardButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.DrawingAssistTypePopupWindow.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onItemClickListener.onItemClick(StudioType.GreetingCard);
                    DrawingAssistTypePopupWindow.this.hide();
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "n");
                }
            });
        }
        if (Build.VERSION.SDK_INT < 33 || !AiViewUtils.isAtLeastOneUI7()) {
            PopupWindow popupWindow = new PopupWindow(viewGroup, -2, -2);
            this.mPopupWindow = popupWindow;
            OptionMenuPopupWindowHelper.setDefaultState(popupWindow, viewGroup.getContext());
        } else {
            this.mPopupWindow = OptionMenuPopupWindowHelper.getPopupWindowNewStyleLayout(context, viewGroup, this.mHandler);
            viewGroup.setBackgroundResource(C9086R.drawable.ai_menu_toolbar_bg_oneui_85);
            viewGroup.setClipToOutline(true);
        }
        if (this.mDrawingAssistGreetingCardButton.isLaidOut()) {
            PopupWindowHelper.updateContainerWidth((ViewGroup) this.mPopupWindow.getContentView().findViewById(C9086R.id.ai_menu_context_drawing_assist));
        } else {
            this.mDrawingAssistGreetingCardButton.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.DrawingAssistTypePopupWindow.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (DrawingAssistTypePopupWindow.this.mDrawingAssistGreetingCardButton.getMeasuredWidth() > 0) {
                        DrawingAssistTypePopupWindow.this.mDrawingAssistGreetingCardButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        PopupWindowHelper.updateContainerWidth((ViewGroup) DrawingAssistTypePopupWindow.this.mPopupWindow.getContentView().findViewById(C9086R.id.ai_menu_context_drawing_assist));
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
