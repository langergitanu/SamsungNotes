package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.CustomAccessibilityDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuAlign extends RtMenuItem {
    public RtMenuAlign(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        updateState(spanStates.getAlign().getValue());
    }

    public void updateState(int i) {
        String strM12i;
        if (i == 0) {
            ((ImageView) this.mView.findViewById(C9086R.id.richtext_align_spinner_name)).setImageResource(C9086R.drawable.comp_rt_toolbar_ic_align_left);
            this.mView.findViewById(C9086R.id.richtext_align_spinner_name).setVisibility(0);
            strM12i = AbstractC0000a.m12i(this.mView.getResources(), C9086R.string.composer_align_left, new StringBuilder(SQLKeyword.COMMA));
        } else if (i == 1) {
            ((ImageView) this.mView.findViewById(C9086R.id.richtext_align_spinner_name)).setImageResource(C9086R.drawable.comp_rt_toolbar_ic_align_right);
            this.mView.findViewById(C9086R.id.richtext_align_spinner_name).setVisibility(0);
            strM12i = AbstractC0000a.m12i(this.mView.getResources(), C9086R.string.composer_align_right, new StringBuilder(SQLKeyword.COMMA));
        } else if (i != 2) {
            this.mView.findViewById(C9086R.id.richtext_align_spinner_name).setVisibility(4);
            strM12i = "";
        } else {
            ((ImageView) this.mView.findViewById(C9086R.id.richtext_align_spinner_name)).setImageResource(C9086R.drawable.comp_rt_toolbar_ic_align_center);
            this.mView.findViewById(C9086R.id.richtext_align_spinner_name).setVisibility(0);
            strM12i = AbstractC0000a.m12i(this.mView.getResources(), C9086R.string.composer_align_center, new StringBuilder(SQLKeyword.COMMA));
        }
        this.mView.setAccessibilityDelegate(new CustomAccessibilityDelegate(this.mView.getContentDescription().toString(), this.mView.getResources().getString(C9086R.string.rich_text_dropdown_list) + strM12i));
    }
}
