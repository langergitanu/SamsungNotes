package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuTextStyle extends AbsRtMenuPopupWindow {
    private static final String TAG = Logger.createTag("RtMenuTextSetting");

    public RtMenuTextStyle(View view, View view2) {
        super(view, view2);
    }

    private void initAlignButtons(final View view, SpanStates spanStates) {
        initButton(view, C9086R.id.comp_rt_btn_align_left, spanStates.getAlign().getValue() == 0, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.updateAlignBtnState(view, view2, 0, new int[]{C9086R.id.comp_rt_btn_align_center, C9086R.id.comp_rt_btn_align_right});
                RtMenuTextStyle.this.setSALogAlignment("a");
            }
        });
        initButton(view, C9086R.id.comp_rt_btn_align_center, spanStates.getAlign().getValue() == 2, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.updateAlignBtnState(view, view2, 2, new int[]{C9086R.id.comp_rt_btn_align_left, C9086R.id.comp_rt_btn_align_right});
                RtMenuTextStyle.this.setSALogAlignment("b");
            }
        });
        initButton(view, C9086R.id.comp_rt_btn_align_right, spanStates.getAlign().getValue() == 1, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.updateAlignBtnState(view, view2, 1, new int[]{C9086R.id.comp_rt_btn_align_center, C9086R.id.comp_rt_btn_align_left});
                RtMenuTextStyle.this.setSALogAlignment("c");
            }
        });
    }

    private void initBulletButton(final View view, SpanStates spanStates) {
        initButton(view, C9086R.id.comp_rt_btn_dot, spanStates.getTask().getValue() == 8, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean zReverseViewSelectionState = RtMenuTextStyle.this.reverseViewSelectionState(view2);
                RtMenuTextStyle.this.mPresenter.setTask(8, zReverseViewSelectionState);
                view.findViewById(C9086R.id.comp_rt_btn_numbering).setSelected(false);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_BULLET_LIST, zReverseViewSelectionState ? "1" : "0");
            }
        });
    }

    private void initButton(View view, @IdRes int i, boolean z, View.OnClickListener onClickListener) {
        View viewFindViewById = view.findViewById(i);
        viewFindViewById.setOnClickListener(onClickListener);
        viewFindViewById.setSelected(z);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    private void initFontStyleButtons(View view, SpanStates spanStates) {
        initButton(view, C9086R.id.comp_rt_btn_bold, spanStates.getBold().getValue(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean zReverseViewSelectionState = RtMenuTextStyle.this.reverseViewSelectionState(view2);
                RtMenuTextStyle.this.mPresenter.setTextStyle(5, zReverseViewSelectionState);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_BOLD, zReverseViewSelectionState ? "1" : "0");
            }
        });
        initButton(view, C9086R.id.comp_rt_btn_italic, spanStates.getItalic().getValue(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean zReverseViewSelectionState = RtMenuTextStyle.this.reverseViewSelectionState(view2);
                RtMenuTextStyle.this.mPresenter.setTextStyle(6, zReverseViewSelectionState);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_ITALIC, zReverseViewSelectionState ? "1" : "0");
            }
        });
        initButton(view, C9086R.id.comp_rt_btn_underline, spanStates.getUnderline().getValue(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean zReverseViewSelectionState = RtMenuTextStyle.this.reverseViewSelectionState(view2);
                RtMenuTextStyle.this.mPresenter.setTextStyle(7, zReverseViewSelectionState);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_UNDERLINE, zReverseViewSelectionState ? "1" : "0");
            }
        });
        initButton(view, C9086R.id.comp_rt_btn_strikethrough, spanStates.getStrikethrough().getValue(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean zReverseViewSelectionState = RtMenuTextStyle.this.reverseViewSelectionState(view2);
                RtMenuTextStyle.this.mPresenter.setTextStyle(20, zReverseViewSelectionState);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_STRIKETHROUGH, zReverseViewSelectionState ? "1" : "0");
            }
        });
    }

    private void initIndentButton(View view, @IdRes int i, boolean z, View.OnClickListener onClickListener) {
        View viewFindViewById = view.findViewById(i);
        viewFindViewById.setOnClickListener(onClickListener);
        viewFindViewById.setEnabled(z);
        if (z) {
            viewFindViewById.setAlpha(1.0f);
        } else {
            viewFindViewById.setAlpha(0.3f);
        }
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    private void initIndentButtons(View view, SpanStates spanStates) {
        initIndentButton(view, C9086R.id.comp_rt_btn_indent, spanStates.getIndent().getValue() >= 0 && spanStates.getIndent().getValue() < spanStates.getIndent().getIndentMax(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.mPresenter.setIndent(true);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_TEXT_INDENT);
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(view2.getResources().getString(C9086R.string.composer_indent));
            }
        });
        initIndentButton(view, C9086R.id.comp_rt_btn_outdent, spanStates.getIndent().getValue() > 0, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.mPresenter.setIndent(false);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_TEXT_OUTDENT);
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(view2.getResources().getString(C9086R.string.composer_outdent));
            }
        });
    }

    private void initNumberingButton(final View view, SpanStates spanStates) {
        initButton(view, C9086R.id.comp_rt_btn_numbering, spanStates.getTask().getValue() == 4, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.mPresenter.setTask(4, RtMenuTextStyle.this.reverseViewSelectionState(view2));
                view.findViewById(C9086R.id.comp_rt_btn_dot).setSelected(false);
                ComposerSA.insertLog(ComposerSA.getScreenID(true, false, RtMenuTextStyle.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_NUMBERED_LIST, RtMenuTextStyle.this.mView.isSelected() ? "1" : "0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reverseViewSelectionState(View view) {
        boolean z = !view.isSelected();
        view.setSelected(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSALogAlignment(String str) {
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_ALIGNMENT_SELECTION, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAlignBtnState(View view, View view2, int i, @IdRes int[] iArr) {
        if (view2.isSelected()) {
            return;
        }
        view2.setSelected(true);
        this.mPresenter.setAlign(i);
        for (int i2 : iArr) {
            view.findViewById(i2).setSelected(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public /* bridge */ /* synthetic */ boolean hidePopup() {
        return super.hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public View inflateView(Context context) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_rt_popup_text_style, (ViewGroup) null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public void initButtons(View view, SpanStates spanStates) {
        ViewCompat.getInstance().setShadowAlpha(view.findViewById(C9086R.id.text_style_scroll_view), 0.5f);
        View viewFindViewById = view.findViewById(C9086R.id.close_btn);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuTextStyle.this.hidePopup();
                if (RtMenuTextStyle.this.mPresenter.isCoeditNote()) {
                    ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_TEXT_STYLE_CLOSE);
                } else {
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_TEXT_STYLE_CLOSE);
                }
            }
        });
        initBulletButton(view, spanStates);
        initNumberingButton(view, spanStates);
        initAlignButtons(view, spanStates);
        initFontStyleButtons(view, spanStates);
        initIndentButtons(view, spanStates);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public /* bridge */ /* synthetic */ void initPopupWindow(Context context) {
        super.initPopupWindow(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_TEXT_STYLE);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_TEXT_STYLE);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public /* bridge */ /* synthetic */ void showPopup() {
        super.showPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        if (isPopupShowing()) {
            View viewFindViewById = this.mDialogContainer.findViewById(C9086R.id.comp_rt_btn_indent);
            View viewFindViewById2 = this.mDialogContainer.findViewById(C9086R.id.comp_rt_btn_outdent);
            if (spanStates.getIndent().getValue() < 0) {
                viewFindViewById.setEnabled(false);
                viewFindViewById.setAlpha(0.3f);
                viewFindViewById2.setEnabled(false);
                viewFindViewById2.setAlpha(0.3f);
            } else if (spanStates.getIndent().getValue() >= 16) {
                viewFindViewById.setEnabled(false);
                viewFindViewById.setAlpha(0.3f);
                viewFindViewById2.setEnabled(true);
                viewFindViewById2.setAlpha(1.0f);
            } else if (spanStates.getIndent().getValue() == 0) {
                viewFindViewById.setEnabled(true);
                viewFindViewById.setAlpha(1.0f);
                viewFindViewById2.setEnabled(false);
                viewFindViewById2.setAlpha(0.3f);
            } else {
                viewFindViewById.setEnabled(true);
                viewFindViewById.setAlpha(1.0f);
                viewFindViewById2.setEnabled(true);
                viewFindViewById2.setAlpha(1.0f);
            }
            updateBtnState(C9086R.id.comp_rt_btn_numbering, spanStates.getTask().isNumbering());
            updateBtnState(C9086R.id.comp_rt_btn_dot, spanStates.getTask().isBullet());
            updateBtnState(C9086R.id.comp_rt_btn_align_left, spanStates.getAlign().isLeft());
            updateBtnState(C9086R.id.comp_rt_btn_align_center, spanStates.getAlign().isCenter());
            updateBtnState(C9086R.id.comp_rt_btn_align_right, spanStates.getAlign().isRight());
            updateBtnState(C9086R.id.comp_rt_btn_bold, spanStates.getBold().getValue());
            updateBtnState(C9086R.id.comp_rt_btn_italic, spanStates.getItalic().getValue());
            updateBtnState(C9086R.id.comp_rt_btn_underline, spanStates.getUnderline().getValue());
            updateBtnState(C9086R.id.comp_rt_btn_strikethrough, spanStates.getStrikethrough().getValue());
        }
    }
}
