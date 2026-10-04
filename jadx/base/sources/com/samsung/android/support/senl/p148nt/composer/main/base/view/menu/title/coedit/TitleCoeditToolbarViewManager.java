package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditToolbarViewManager {
    private static final String TAG = Logger.createTag("TitleCoeditToolbarViewManager");
    private final View mCoeditGroupCountView;
    private final Contract mContract;
    private TitleCoeditGuideTip mTitleCoeditGuideTip;
    private final View mToolbarView;
    private int previousMemberCount = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TitleCoeditToolbarViewManager(View view, Contract contract) {
        this.mToolbarView = view;
        this.mContract = contract;
        View viewInflateCoeditGroupCountView = inflateCoeditGroupCountView(contract.getActivity());
        this.mCoeditGroupCountView = viewInflateCoeditGroupCountView;
        if (view instanceof ICustomToolbar) {
            ((ICustomToolbar) view).addCustomView(viewInflateCoeditGroupCountView, 8388611);
        }
    }

    private View inflateCoeditGroupCountView(Activity activity) {
        return LayoutInflater.from(activity).inflate(C9086R.layout.comp_title_coedit_group_count_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupCountMeetButtonBgWidth() {
        int dimensionPixelSize = this.mToolbarView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_coedit_meet_width);
        View viewFindViewById = this.mToolbarView.findViewById(C9086R.id.coedit_group_count_button);
        if (viewFindViewById != null) {
            dimensionPixelSize = Math.max(dimensionPixelSize, viewFindViewById.getWidth() + this.mToolbarView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_coedit_meet_stroke_size));
        }
        View viewFindViewById2 = this.mToolbarView.findViewById(C9086R.id.coedit_group_count_meet);
        if (viewFindViewById2 != null) {
            viewFindViewById2.getLayoutParams().width = dimensionPixelSize;
        }
    }

    private void updateCoeditMeetBadge() {
        View viewFindViewById = this.mToolbarView.findViewById(C9086R.id.coedit_group_count_meet);
        if (viewFindViewById == null) {
            Logger.m11003i(TAG, "updateCoeditMeetBadge# groupCountMeet is empty");
            return;
        }
        boolean zIsMeetNote = this.mContract.getPresenter().isMeetNote();
        Logger.m11003i(TAG, "updateCoeditMeetBadge# isMeetNote:" + zIsMeetNote);
        viewFindViewById.setVisibility(8);
        final View viewFindViewById2 = this.mCoeditGroupCountView.findViewById(C9086R.id.comp_title_coedit_group_count_container);
        if (!zIsMeetNote || viewFindViewById2 == null) {
            return;
        }
        viewFindViewById2.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditToolbarViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (CommonUtil.isNotAvailableActivity(TitleCoeditToolbarViewManager.this.mContract.getActivity())) {
                    Logger.m11000e(TitleCoeditToolbarViewManager.TAG, "updateCoeditMeetBadge# isNotAvailableActivity");
                } else {
                    TitleCoeditToolbarViewManager.this.setGroupCountMeetButtonBgWidth();
                    TitleCoeditToolbarViewManager.this.getTitleCoeditGuideTip().showMeetGuideTip(viewFindViewById2);
                }
            }
        }, 500L);
    }

    private void updateGroupCountWriter() {
        ImageView imageView = (ImageView) this.mCoeditGroupCountView.findViewById(C9086R.id.coedit_group_count_writer);
        if (imageView == null) {
            Logger.m11003i(TAG, "updateGroupCountWriter# groupCountWriter is empty");
            return;
        }
        boolean zHasWriterMember = this.mContract.getPresenter().getTitleCoeditMemberListPresenter().hasWriterMember();
        AbstractC8014b.m7224z("updateGroupCountWriter# groupCountWriter:", TAG, zHasWriterMember);
        if ((zHasWriterMember && imageView.getVisibility() != 0) || (!zHasWriterMember && imageView.getVisibility() == 0)) {
            imageView.setVisibility(zHasWriterMember ? 0 : 8);
            ComposerSA.insertLog(this.mContract.getPresenter().getComposerModel().getModeManager().isEditModeWithReadOnly() ? "683" : "682", ComposerSAConstants.EVENT_COEDIT_COEDITING_WITH, this.mContract.getPresenter().isStandAlone() ? "a" : "b");
        }
        final View viewFindViewById = this.mCoeditGroupCountView.findViewById(C9086R.id.comp_title_coedit_group_count_container);
        if (!zHasWriterMember || viewFindViewById == null) {
            return;
        }
        viewFindViewById.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditToolbarViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                TitleCoeditToolbarViewManager.this.getTitleCoeditGuideTip().showWriterGuideTip(viewFindViewById);
            }
        });
    }

    public TitleCoeditGuideTip getTitleCoeditGuideTip() {
        if (this.mTitleCoeditGuideTip == null) {
            this.mTitleCoeditGuideTip = new TitleCoeditGuideTip();
        }
        return this.mTitleCoeditGuideTip;
    }

    public void setTheme(int[] iArr, boolean z) {
        ImageView imageView;
        if (this.mContract.getPresenter().isCoeditNote()) {
            if (this.mContract.getPresenter().isMeetNote() && (imageView = (ImageView) this.mToolbarView.findViewById(C9086R.id.coedit_group_count_meet_button_bg)) != null) {
                imageView.setColorFilter(iArr[0]);
            }
            View viewFindViewById = this.mToolbarView.findViewById(C9086R.id.coedit_group_count_button);
            if (viewFindViewById != null) {
                viewFindViewById.setBackground(this.mContract.getActivity().getDrawable(z ? C9086R.drawable.comp_title_coedit_group_count_bg_dark : C9086R.drawable.comp_title_coedit_group_count_bg));
            }
            ImageView imageView2 = (ImageView) this.mToolbarView.findViewById(C9086R.id.coedit_group_count_writer);
            if (imageView2 != null) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.mContract.getActivity().getDrawable(C9086R.drawable.comp_title_coedit_writer);
                gradientDrawable.setStroke(imageView2.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_coedit_writer_stroke_size), iArr[0]);
                imageView2.setImageDrawable(gradientDrawable);
            }
        }
    }

    public void updateCoeditGroupCount() {
        if (this.mCoeditGroupCountView == null) {
            Logger.m11003i(TAG, "updateCoeditGroupCount# mCoeditGroupCountView is empty");
            return;
        }
        boolean zIsCoeditNote = this.mContract.getPresenter().isCoeditNote();
        this.mCoeditGroupCountView.setVisibility(zIsCoeditNote ? 0 : 8);
        if (zIsCoeditNote) {
            TextView textView = (TextView) this.mCoeditGroupCountView.findViewById(C9086R.id.coedit_group_count_text);
            if (textView != null) {
                int coeditMemberCount = this.mContract.getPresenter().getTitleCoeditMemberListPresenter().getCoeditMemberCount();
                textView.setText(LocaleUtils.convertToArabicNumber(coeditMemberCount));
                if (this.previousMemberCount < 2 && coeditMemberCount >= 2) {
                    ComposerSA.insertLog("683", this.mContract.getPresenter().isStandAlone() ? "a" : "b");
                }
                this.previousMemberCount = coeditMemberCount;
            }
            updateCoeditMeetBadge();
            updateGroupCountWriter();
        }
    }
}
