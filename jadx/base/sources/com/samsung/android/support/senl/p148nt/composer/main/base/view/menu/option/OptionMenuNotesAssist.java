package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuNotesAssistPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuNotesAssist {
    private PopupWindow mPopupWindow;
    private final OptionMenuNotesAssistPresenter mPresenter;

    public OptionMenuNotesAssist(OptionMenuPresenter optionMenuPresenter) {
        this.mPresenter = optionMenuPresenter.getOptionMenuNotesAssistPresenter();
    }

    private int getXOffset(View view) {
        this.mPopupWindow.getContentView().measure(0, 0);
        return LocaleUtils.isRTLMode() ? view.getWidth() - this.mPopupWindow.getContentView().getMeasuredWidth() : (view.getWidth() - this.mPopupWindow.getContentView().getMeasuredWidth()) / 2;
    }

    private int getYOffset(View view) {
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        return (rect.height() / 2) + rect.top < rect2.top ? this.mPopupWindow.getContentView().getMeasuredHeight() * (-1) : (view.getHeight() - this.mPopupWindow.getContentView().getMeasuredHeight()) / 2;
    }

    private void initSubMenu(Context context) {
        final int i = 0;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_style_layout_pdf_reader, (ViewGroup) null, false);
        viewGroup.findViewById(C9086R.id.ai_menu_btn_summarize).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ OptionMenuNotesAssist f7177b;

            {
                this.f7177b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        this.f7177b.lambda$initSubMenu$1(view);
                        break;
                    default:
                        this.f7177b.lambda$initSubMenu$2(view);
                        break;
                }
            }
        });
        View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_btn_translate);
        if (FeatureInfo.isSupportNeuralTranslationFunction()) {
            final int i2 = 1;
            viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ OptionMenuNotesAssist f7177b;

                {
                    this.f7177b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f7177b.lambda$initSubMenu$1(view);
                            break;
                        default:
                            this.f7177b.lambda$initSubMenu$2(view);
                            break;
                    }
                }
            });
        } else {
            viewFindViewById.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT < 33 || !AiViewUtils.isAtLeastOneUI7()) {
            PopupWindow popupWindow = new PopupWindow(viewGroup, -2, -2);
            this.mPopupWindow = popupWindow;
            OptionMenuPopupWindowHelper.setDefaultState(popupWindow, viewGroup.getContext());
        } else {
            this.mPopupWindow = OptionMenuPopupWindowHelper.getPopupWindowNewStyleLayout(context, viewGroup, this.mPresenter.getHandler());
            viewGroup.setBackgroundResource(C9086R.drawable.ai_menu_toolbar_bg_oneui_85);
            viewGroup.setClipToOutline(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSubMenu$1(View view) {
        hidePopup();
        this.mPresenter.summarize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSubMenu$2(View view) {
        hidePopup();
        this.mPresenter.translate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopup$0(Activity activity) {
        initSubMenu(activity);
        showSubMenu(OptionMenuPopupWindowHelper.getAnchorViewInToolbar(activity, C9086R.id.action_notes_assist));
    }

    public void hidePopup() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.mPopupWindow = null;
        }
    }

    public void showPopup(Activity activity) {
        AiCommonUtil.executeActionByOndevice(activity, new RunnableC9844c(this, activity, 21), null);
    }

    public void showSubMenu(View view) {
        this.mPresenter.hideAiResultView();
        this.mPopupWindow.showAsDropDown(view, getXOffset(view), getYOffset(view));
        this.mPresenter.setAiSALogForPdfReader();
    }
}
