package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextMenuSTTPopup {
    View mAddToButton;
    private OnClickListener mClickListener;
    private Context mContext;
    View mCopyButton;
    View mEditButton;
    private OnPopupListener mPopupListener;
    private PopupType mPopupType;
    private PopupWindow mPopupWindow;
    View mRemoveTranscribeButton;
    View mSearchButton;
    View mSpeakerLabel;
    TextView mSpeakerLabelText;
    View mSummarizeAgainButton;
    View mSummaryStyleButton;
    View mTranscribeAgainButton;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup$11 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C949411 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$presenter$menu$ai$result$view$AiContextMenuSTTPopup$PopupType */
        static final /* synthetic */ int[] f6911x51948c4b;

        static {
            int[] iArr = new int[PopupType.values().length];
            f6911x51948c4b = iArr;
            try {
                iArr[PopupType.IN_ORIGINAL_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6911x51948c4b[PopupType.IN_SUMMARY_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickListener {
        void onClickAddToNode();

        void onClickCopy();

        default void onClickEdit() {
        }

        default void onClickRemoveTranscribe() {
        }

        default void onClickSearch() {
        }

        default void onClickSpeakerLabel(boolean z) {
        }

        default void onClickSummarizeAgain() {
        }

        default void onClickSummaryStyle() {
        }

        default void onClickTranscribeAgain() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPopupListener {
        void onDismiss();

        void onShow();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PopupType {
        IN_ORIGINAL_PAGE,
        IN_SUMMARY_PAGE
    }

    private void initView(ViewGroup viewGroup) {
        View viewFindViewById = viewGroup.findViewById(C9086R.id.ai_menu_btn_search);
        this.mSearchButton = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickSearch();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById2 = viewGroup.findViewById(C9086R.id.ai_menu_btn_copy);
        this.mCopyButton = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickCopy();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById3 = viewGroup.findViewById(C9086R.id.ai_menu_btn_add_to);
        this.mAddToButton = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickAddToNode();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById4 = viewGroup.findViewById(C9086R.id.ai_menu_btn_edit);
        this.mEditButton = viewFindViewById4;
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickEdit();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        this.mSpeakerLabel = viewGroup.findViewById(C9086R.id.ai_menu_btn_hide_speaker_label);
        this.mSpeakerLabelText = (TextView) viewGroup.findViewById(C9086R.id.ai_menu_speaker_label_text);
        this.mSpeakerLabel.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickSpeakerLabel(AiContextMenuSTTPopup.this.mSpeakerLabelText.getText().toString().equals(AiContextMenuSTTPopup.this.mContext.getString(C9086R.string.show_speaker_labels)));
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById5 = viewGroup.findViewById(C9086R.id.ai_menu_btn_transcribe_again);
        this.mTranscribeAgainButton = viewFindViewById5;
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickTranscribeAgain();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById6 = viewGroup.findViewById(C9086R.id.ai_menu_btn_remove_transcribe);
        this.mRemoveTranscribeButton = viewFindViewById6;
        viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickRemoveTranscribe();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById7 = viewGroup.findViewById(C9086R.id.ai_menu_btn_sumary_style);
        this.mSummaryStyleButton = viewFindViewById7;
        viewFindViewById7.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickSummaryStyle();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        View viewFindViewById8 = viewGroup.findViewById(C9086R.id.ai_menu_btn_summarize_again);
        this.mSummarizeAgainButton = viewFindViewById8;
        viewFindViewById8.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiContextMenuSTTPopup.this.mClickListener.onClickSummarizeAgain();
                AiContextMenuSTTPopup.this.hide();
            }
        });
        this.mEditButton.setVisibility(0);
        int i = C949411.f6911x51948c4b[this.mPopupType.ordinal()];
        if (i == 1) {
            this.mEditButton.setVisibility(0);
            this.mSpeakerLabel.setVisibility(0);
            this.mTranscribeAgainButton.setVisibility(0);
            this.mRemoveTranscribeButton.setVisibility(0);
            this.mSearchButton.setVisibility(0);
            this.mSummaryStyleButton.setVisibility(8);
        } else if (i == 2) {
            this.mEditButton.setVisibility(8);
            this.mSpeakerLabel.setVisibility(8);
            this.mTranscribeAgainButton.setVisibility(8);
            this.mRemoveTranscribeButton.setVisibility(8);
            this.mSearchButton.setVisibility(8);
            if (!FeatureInfo.isSupportSTTSummaryGroupBySubject() || CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                this.mSummaryStyleButton.setVisibility(8);
            } else {
                this.mSummaryStyleButton.setVisibility(0);
            }
        }
        AiContextMenuPopup.updateTopBottomPadding((ViewGroup) viewGroup.findViewById(C9086R.id.ai_context_inner_container));
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
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.10
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AiContextMenuSTTPopup.this.mPopupListener != null) {
                    AiContextMenuSTTPopup.this.mPopupListener.onDismiss();
                }
            }
        });
    }

    public void disableCopyText() {
        this.mCopyButton.setEnabled(false);
        this.mAddToButton.setEnabled(false);
        this.mCopyButton.setAlpha(0.5f);
        this.mAddToButton.setAlpha(0.5f);
    }

    public void disableSummaryStyle() {
        this.mSummaryStyleButton.setEnabled(false);
        this.mSummaryStyleButton.setAlpha(0.5f);
    }

    public void enableCopyText() {
        this.mCopyButton.setEnabled(true);
        this.mAddToButton.setEnabled(true);
        this.mCopyButton.setAlpha(1.0f);
        this.mAddToButton.setAlpha(1.0f);
    }

    public void enableSummaryStyle() {
        this.mSummaryStyleButton.setEnabled(true);
        this.mSummaryStyleButton.setAlpha(1.0f);
    }

    public void hide() {
        if (this.mPopupWindow == null) {
            return;
        }
        OnPopupListener onPopupListener = this.mPopupListener;
        if (onPopupListener != null) {
            onPopupListener.onDismiss();
        }
        this.mPopupWindow.dismiss();
    }

    public void init(Context context, PopupType popupType, OnClickListener onClickListener) {
        this.mContext = context;
        this.mClickListener = onClickListener;
        this.mPopupType = popupType;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_result_stt_layout, (ViewGroup) null, false);
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

    public void setPopupListener(OnPopupListener onPopupListener) {
        this.mPopupListener = onPopupListener;
    }

    public void show(View view) {
        if (isShowing()) {
            hide();
        }
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
        OnPopupListener onPopupListener = this.mPopupListener;
        if (onPopupListener != null) {
            onPopupListener.onShow();
        }
    }

    public void updateShowSpeakerLabelText(boolean z) {
        if (z) {
            this.mSpeakerLabelText.setText(this.mContext.getString(C9086R.string.hide_speaker_labels));
        } else {
            this.mSpeakerLabelText.setText(this.mContext.getString(C9086R.string.show_speaker_labels));
        }
    }

    public void updateTranslateMode(boolean z) {
        if (z) {
            disableCopyText();
        } else {
            enableCopyText();
        }
    }
}
