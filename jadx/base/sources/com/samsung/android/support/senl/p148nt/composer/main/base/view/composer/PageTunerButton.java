package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageTunerButton {
    private static final float DISABLE_ALPHA = 0.4f;
    private static final float ENABLE_ALPHA = 1.0f;
    private static final String TAG = Logger.createTag("PageTunerButton");
    private boolean isPageScrollVertical;
    private ComposerViewState mComposerViewState;
    private Contract mContract;
    private DecoratorLayout mDecoratorLayout;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private ImageView mNextPageBtn;
    private ImageView mPrevPageBtn;
    private TextView pageIndicator;
    private View pageTunerButtonLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        ComposerModel getComposerModel();

        void goToPage(int i);
    }

    private void goToPage(int i) {
        this.mContract.goToPage(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0() {
        int lastPageIndex = this.mComposerViewState.getLastPageIndex() + 1;
        int lastPageCount = this.mComposerViewState.getLastPageCount() - 1;
        updatePageIndicator(lastPageIndex, lastPageCount);
        updatePageButtonEnable(lastPageIndex, lastPageCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickNextPageBtn() {
        Logger.m10999d(TAG, "clickNextPageBtn# ");
        goToPage(this.mComposerViewState.getLastPageIndex() + (this.mComposerViewState.isTwoPageView() ? 2 : 1));
        if (DeviceInfo.isVSTModel()) {
            ComposerSA.insertLog(ComposerSA.getScreenID(this.mContract.getComposerModel().getModeManager().isEditMode(), this.mContract.getComposerModel().getModeManager().isMode(Mode.Writing), this.mContract.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_NEXT_PAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickPrevPageBtn() {
        Logger.m10999d(TAG, "clickPrevPageBtn# ");
        goToPage(this.mComposerViewState.getLastPageIndex() - 1);
        if (DeviceInfo.isVSTModel()) {
            ComposerSA.insertLog(ComposerSA.getScreenID(this.mContract.getComposerModel().getModeManager().isEditMode(), this.mContract.getComposerModel().getModeManager().isMode(Mode.Writing), this.mContract.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_PREVIOUS_PAGE);
        }
    }

    private void setButtonEnable(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.4f);
        view.setEnabled(z);
    }

    private void update() {
        this.mHandler.post(new RunnableC9767a(this, 6));
    }

    private void updatePageButtonEnable(int i, int i2) {
        setButtonEnable(this.mPrevPageBtn, i > 1);
        if (this.mComposerViewState.isTwoPageView() && i2 % 2 == 0) {
            setButtonEnable(this.mNextPageBtn, i + 1 < i2);
        } else {
            setButtonEnable(this.mNextPageBtn, i < i2);
        }
    }

    private void updatePageIndicator(int i, int i2) {
        this.pageIndicator.setText(i + "/" + i2);
    }

    public void init(ViewGroup viewGroup, ComposerViewState composerViewState, Contract contract) {
        this.mContract = contract;
        this.mComposerViewState = composerViewState;
        this.isPageScrollVertical = true;
        DecoratorLayout decoratorLayout = (DecoratorLayout) viewGroup.findViewById(C9086R.id.comp_view_decor_layout);
        this.mDecoratorLayout = decoratorLayout;
        View viewFindViewById = decoratorLayout.findViewById(C9086R.id.vst_comp_page_tuner_button_container);
        this.pageTunerButtonLayout = viewFindViewById;
        this.pageIndicator = (TextView) viewFindViewById.findViewById(C9086R.id.page_tuner_page_indicator);
        this.mPrevPageBtn = (ImageView) this.pageTunerButtonLayout.findViewById(C9086R.id.page_tuner_up_btn);
        this.mNextPageBtn = (ImageView) this.pageTunerButtonLayout.findViewById(C9086R.id.page_tuner_down_btn);
        this.mPrevPageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageTunerButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageTunerButton.this.onClickPrevPageBtn();
            }
        });
        this.mNextPageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageTunerButton.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageTunerButton.this.onClickNextPageBtn();
            }
        });
        updateButtonImg();
        this.pageTunerButtonLayout.setVisibility(0);
    }

    public void updateButtonImg() {
        boolean zIsVertical = this.mComposerViewState.isVertical();
        if (zIsVertical == this.isPageScrollVertical) {
            return;
        }
        if (zIsVertical) {
            this.mPrevPageBtn.setImageResource(C9086R.drawable.comp_vst_page_controller_ic_page_up);
            this.mNextPageBtn.setImageResource(C9086R.drawable.comp_vst_page_controller_ic_page_down);
        } else {
            this.mPrevPageBtn.setImageResource(C9086R.drawable.comp_vst_page_controller_ic_page_prev);
            this.mNextPageBtn.setImageResource(C9086R.drawable.comp_vst_page_controller_ic_page_next);
        }
        this.isPageScrollVertical = zIsVertical;
    }

    public void updateCurrentPageIndex(int i) {
        update();
    }

    public void updatePageCount(int i) {
        update();
    }
}
