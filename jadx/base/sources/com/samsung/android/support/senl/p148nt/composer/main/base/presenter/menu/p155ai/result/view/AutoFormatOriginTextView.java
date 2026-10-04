package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatTypeListWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatOriginTextView extends AiMenuResultViewOriginAbs {
    private final AutoFormat mAutoFormat;
    private final AutoFormatTypeListWindow mAutoFormatTypeListWindow;
    private View mContextBtn;

    public AutoFormatOriginTextView(AutoFormat autoFormat, AiMenuResultCommonViews aiMenuResultCommonViews) {
        super(aiMenuResultCommonViews);
        this.mAutoFormat = autoFormat;
        this.mAutoFormatTypeListWindow = new AutoFormatTypeListWindow();
    }

    private void initTopMenu(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_context_btn);
        this.mContextBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatOriginTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!AutoFormatOriginTextView.this.mAutoFormatTypeListWindow.isInitialized()) {
                    AutoFormatOriginTextView.this.mAutoFormatTypeListWindow.setCurrentFormatType(AutoFormatOriginTextView.this.mAutoFormat.getCurrentFormatType());
                    AutoFormatOriginTextView.this.mAutoFormatTypeListWindow.initAutoFormatTypeListWindow(view2, new AutoFormatTypeListWindow.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatOriginTextView.1.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypeListWindow.OnItemClickListener
                        public void onItemClick(AutoFormat.FormatType formatType) {
                            if (AutoFormatOriginTextView.this.mAutoFormat.setCurrentFormatType(formatType)) {
                                AutoFormatOriginTextView.this.mAutoFormat.execute();
                                AutoFormatOriginTextView.this.mCommonViews.showProgress(4);
                                AutoFormatOriginTextView.this.mAutoFormat.getSrcContentInfo().setSAForAIScenarioScreenID("802");
                                AutoFormatOriginTextView.this.mAutoFormat.getSrcContentInfo().setSAForAIScenario("c");
                                ComposerSA.insertLog(AutoFormatOriginTextView.this.mAutoFormat.getSrcContentInfo().getSAForAIScenarioScreenID(), formatType == AutoFormat.FormatType.Meeting ? ComposerSAConstants.EVENT_AI_MEETING_NOTES : ComposerSAConstants.EVENT_AI_HEADERS_AND_BULLETS, AutoFormatOriginTextView.this.mAutoFormat.getSrcContentInfo().getSAForAIScenario());
                            }
                        }
                    });
                }
                AutoFormatOriginTextView.this.mAutoFormatTypeListWindow.show(AutoFormatOriginTextView.this.mAutoFormat.getCurrentFormatType());
            }
        });
        if (this.mAutoFormat.isWaiting()) {
            this.mCommonViews.showProgress(4);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewOriginAbs, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mAutoFormat;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewOriginAbs
    public SpenWNote getReferenceNote() {
        return this.mAutoFormat.getTextOriginNote();
    }

    public void hideTypeListPopup() {
        AutoFormatTypeListWindow autoFormatTypeListWindow = this.mAutoFormatTypeListWindow;
        if (autoFormatTypeListWindow != null) {
            autoFormatTypeListWindow.hide();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewOriginAbs, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        super.initView(view, view2);
        initTopMenu(view);
        boolean z = view.getResources().getConfiguration().orientation == 2;
        View viewFindViewById = view.findViewById(C9086R.id.result_layout_content);
        updateLayout(z, viewFindViewById.getMeasuredWidth(), viewFindViewById.getMeasuredHeight());
        this.mRestoreSpenEditViewScroll = new AbsAiActionResultView.RestoreSpenEditViewScroll(this.mSimpleEditView, this.mAutoFormat.getHandler());
        setNote(this.mAutoFormat.getTextOriginNote(), this.mAutoFormat.getSrcContentInfo().mIsBGColorInverted);
        view2.setTag("first");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        List<Integer> listM1630t;
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews.getContinuesProgress().isShowing()) {
            listM1630t = null;
        } else {
            ArrayList arrayList = new ArrayList(1);
            Object obj = new Object[]{1}[0];
            listM1630t = AbstractC2322a.m1630t(obj, arrayList, obj, arrayList);
        }
        aiMenuResultCommonViews.setTopButtonsVisibility(listM1630t);
        if (isInitialized()) {
            this.mSimpleEditView.forceInvalidate();
        }
    }
}
