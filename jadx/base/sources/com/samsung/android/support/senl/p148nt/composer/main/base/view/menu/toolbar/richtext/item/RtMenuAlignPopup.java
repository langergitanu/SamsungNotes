package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuAlignPopup extends AbsRtMenuPopupWindow {
    private static final String TAG = Logger.createTag("RtMenuAlignPopup");
    private RtToolbarContract.OnClickValueListener mOnClickValueListener;
    Map<Integer, Integer> mResIdMap;

    public RtMenuAlignPopup(View view, View view2) {
        super(view, view2);
        this.mOnClickValueListener = null;
        HashMap map = new HashMap(3);
        this.mResIdMap = map;
        map.put(0, Integer.valueOf(C9086R.id.comp_rt_btn_align_left));
        this.mResIdMap.put(2, Integer.valueOf(C9086R.id.comp_rt_btn_align_center));
        this.mResIdMap.put(1, Integer.valueOf(C9086R.id.comp_rt_btn_align_right));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alignSA(String str) {
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_ALIGNMENT_SELECTION, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAlignBtnState(View view, View view2, int i) {
        if (view2.isSelected()) {
            return;
        }
        Iterator<Map.Entry<Integer, Integer>> it = this.mResIdMap.entrySet().iterator();
        while (it.hasNext()) {
            View viewFindViewById = view.findViewById(it.next().getValue().intValue());
            viewFindViewById.setSelected(viewFindViewById.equals(view2));
        }
        RtToolbarContract.OnClickValueListener onClickValueListener = this.mOnClickValueListener;
        if (onClickValueListener == null) {
            this.mPresenter.setAlign(i);
        } else {
            onClickValueListener.apply(i);
            hidePopup();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        this.mOnClickValueListener = null;
        return super.hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public View inflateView(Context context) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_rt_popup_align_popup, (ViewGroup) null);
        ViewCompat.getInstance().setShadowAlpha(viewInflate.findViewById(C9086R.id.align_scroll_view), 0.5f);
        return viewInflate;
    }

    public void initButton(View view, int i, SpanStates spanStates, View.OnClickListener onClickListener) {
        View viewFindViewById = view.findViewById(this.mResIdMap.get(Integer.valueOf(i)).intValue());
        viewFindViewById.setOnClickListener(onClickListener);
        viewFindViewById.setSelected(spanStates.getAlign().getValue() == i);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public void initButtons(final View view, SpanStates spanStates) {
        initButton(view, 0, spanStates, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAlignPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuAlignPopup.this.updateAlignBtnState(view, view2, 0);
                RtMenuAlignPopup.this.alignSA("a");
            }
        });
        initButton(view, 2, spanStates, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAlignPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuAlignPopup.this.updateAlignBtnState(view, view2, 2);
                RtMenuAlignPopup.this.alignSA("b");
            }
        });
        initButton(view, 1, spanStates, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAlignPopup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RtMenuAlignPopup.this.updateAlignBtnState(view, view2, 1);
                RtMenuAlignPopup.this.alignSA("c");
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public /* bridge */ /* synthetic */ void initPopupWindow(Context context) {
        super.initPopupWindow(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void onUpdatePopup() {
        if (this.mOnClickValueListener != null) {
            hidePopup();
        } else {
            super.onUpdatePopup();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public /* bridge */ /* synthetic */ void showPopup() {
        super.showPopup();
    }

    public void showPopupAsDropDown(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        this.mOnClickValueListener = onClickValueListener;
        initPopupWindow(this.mView.getContext());
        int iIntValue = ((Integer) view.getTag()).intValue();
        updateBtnState(C9086R.id.comp_rt_btn_align_left, iIntValue == 0);
        updateBtnState(C9086R.id.comp_rt_btn_align_center, iIntValue == 2);
        updateBtnState(C9086R.id.comp_rt_btn_align_right, iIntValue == 1);
        this.mPopupWindow.setClippingEnabled(true);
        this.mPopupWindow.showAsDropDown(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        if (isPopupShowing()) {
            updateBtnState(C9086R.id.comp_rt_btn_align_left, spanStates.getAlign().isLeft());
            updateBtnState(C9086R.id.comp_rt_btn_align_center, spanStates.getAlign().isCenter());
            updateBtnState(C9086R.id.comp_rt_btn_align_right, spanStates.getAlign().isRight());
        }
    }
}
