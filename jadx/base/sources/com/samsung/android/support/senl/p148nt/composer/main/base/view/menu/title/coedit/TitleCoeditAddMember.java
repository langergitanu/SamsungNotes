package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit;

import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditAddMember {
    private static final String TAG = Logger.createTag("TitleCoeditAddMember");
    private final TitleEditorPresenter mPresenter;
    private final ImageView mView;

    public TitleCoeditAddMember(View view, TitleEditorPresenter titleEditorPresenter) {
        this.mView = (ImageView) view.findViewById(C9086R.id.comp_title_coedit_add_member);
        this.mPresenter = titleEditorPresenter;
    }

    public void attachView() {
        if (this.mPresenter.isCoeditNote() && this.mPresenter.isStandAlone()) {
            this.mView.setVisibility(0);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void init(float f) {
        this.mView.setAlpha(f);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditAddMember.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TitleCoeditAddMember.this.mView.getAlpha() != 1.0f) {
                    Logger.m10999d(TitleCoeditAddMember.TAG, "onClick# The title is being hidden. skip group member click event.");
                    return;
                }
                Logger.m11003i(TitleCoeditAddMember.TAG, "onClick#");
                TitleCoeditAddMember.this.mPresenter.showCoeditMemberManage();
                ComposerSA.insertLog(TitleCoeditAddMember.this.mPresenter.isEditMode() ? "683" : "682", ComposerSAConstants.EVENT_COEDIT_STANDALONE_NOTE_GROUP);
            }
        });
        if (this.mPresenter.isCoeditNote() && this.mPresenter.isStandAlone()) {
            return;
        }
        this.mView.setVisibility(8);
    }

    public void setEnable(boolean z) {
        this.mView.setEnabled(z);
    }
}
