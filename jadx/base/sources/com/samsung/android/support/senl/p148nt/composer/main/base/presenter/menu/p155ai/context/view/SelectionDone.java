package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionDone {
    private static final String TAG = Logger.createTag("SelectionDone");
    private AiContextMenuPresenter mAiContextMenuPresenter;
    private View mContainerSelectNext;

    public SelectionDone(Activity activity, AiContextMenuPresenter aiContextMenuPresenter) {
        this.mContainerSelectNext = activity.findViewById(C9086R.id.comp_next_scroll_button_container);
        this.mAiContextMenuPresenter = aiContextMenuPresenter;
    }

    private void initNextPageButtons() {
        View view = this.mContainerSelectNext;
        if (view == null) {
            return;
        }
        view.findViewById(C9086R.id.comp_select_maximum).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.SelectionDone.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getAlpha() < 1.0f) {
                    Logger.m10999d(SelectionDone.TAG, "selectMaximum# view is dim");
                } else {
                    SelectionDone.this.mAiContextMenuPresenter.selectMaximumContent();
                }
            }
        });
        this.mContainerSelectNext.findViewById(C9086R.id.comp_select_next_page).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.SelectionDone.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getAlpha() < 1.0f) {
                    Logger.m10999d(SelectionDone.TAG, "nextPage# view is dim");
                } else {
                    SelectionDone.this.mAiContextMenuPresenter.selectNextPageForText();
                }
            }
        });
        this.mContainerSelectNext.findViewById(C9086R.id.comp_ai_done).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.SelectionDone.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SelectionDone.this.mAiContextMenuPresenter.setAiSALogToGenerate();
                SelectionDone.this.mContainerSelectNext.setVisibility(8);
                SelectionDone.this.mAiContextMenuPresenter.executeAiMenuDone();
            }
        });
    }

    public View getContainerSelectNext() {
        return this.mContainerSelectNext;
    }

    public void init() {
        initNextPageButtons();
    }

    public void setDoneButton(int i) {
        TextView textView = (TextView) this.mContainerSelectNext.findViewById(C9086R.id.comp_ai_done_text);
        if (i == 3 || i == 4) {
            textView.setText(textView.getResources().getString(C9086R.string.composer_generate_text_layouts));
            return;
        }
        if (i == 2) {
            textView.setText(textView.getResources().getString(C9086R.string.composer_generate_summary));
        } else if (i == 5) {
            textView.setText(textView.getResources().getString(C9086R.string.composer_show_corrections));
        } else if (i == 1) {
            textView.setText(textView.getResources().getString(C9086R.string.composer_generate_translation));
        }
    }
}
