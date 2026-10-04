package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.guide;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.guide.AiDrawingGuide;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingGuidePresenter {
    private static final String KEY_GUIDE_MESSAGE = "ai_drawing_key_guide_message";
    private static final String TAG = "AiDrawingGuidePresenter";
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private AiDrawingGuide mGuide;
    private final Handler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void release();
    }

    public AiDrawingGuidePresenter(Handler handler, ComposerViewPresenter composerViewPresenter, Contract contract) {
        this.mHandler = handler;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismiss$1() {
        this.mGuide = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismiss$2() {
        AiDrawingGuide aiDrawingGuide = this.mGuide;
        if (aiDrawingGuide == null) {
            return;
        }
        aiDrawingGuide.dismiss(new RunnableC9391a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(int i) {
        if (this.mGuide == null) {
            AiDrawingGuide aiDrawingGuide = new AiDrawingGuide(this.mComposerViewPresenter.getActivity());
            this.mGuide = aiDrawingGuide;
            aiDrawingGuide.init(this.mHandler, new AiDrawingGuide.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.guide.AiDrawingGuidePresenter.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.Contract
                public int getBackgroundThemeColor() {
                    return AiDrawingGuidePresenter.this.mComposerViewPresenter.getBackgroundThemeColor();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.Contract
                public ViewGroup getComposerDecorView() {
                    return (ViewGroup) AiDrawingGuidePresenter.this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.comp_view_decor_layout);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.Contract
                public View getComposerView() {
                    return AiDrawingGuidePresenter.this.mComposerViewPresenter.getView();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.Contract
                public void release() {
                    AiDrawingGuidePresenter.this.mContract.release();
                }
            });
        }
        this.mGuide.setGuideMessageRes(i);
        this.mGuide.show();
        Logger.m10999d(TAG, "show, " + this.mGuide.getGuideMessage());
    }

    public void dismiss() {
        this.mHandler.post(new RunnableC9391a(this, 0));
    }

    public boolean isShowing() {
        AiDrawingGuide aiDrawingGuide = this.mGuide;
        return aiDrawingGuide != null && aiDrawingGuide.isShowing();
    }

    public void restoreGuideInstanceState(Bundle bundle) {
        AiDrawingGuide aiDrawingGuide = this.mGuide;
        if (aiDrawingGuide == null) {
            return;
        }
        aiDrawingGuide.setGuideMessageRes(bundle.getInt(KEY_GUIDE_MESSAGE));
    }

    public void saveGuideInstanceState(Bundle bundle) {
        AiDrawingGuide aiDrawingGuide = this.mGuide;
        if (aiDrawingGuide == null) {
            return;
        }
        bundle.putInt(KEY_GUIDE_MESSAGE, aiDrawingGuide.getGuideMessageRes());
    }

    public void show() {
        show(Features.isCreativeStudioSupported() ? C9086R.string.ai_drawing_select_the_drawing_or_image_you_would_like_to_stylize : C9086R.string.ai_drawing_select_the_drawing_you_want_to_turn_into_an_image);
    }

    public void showRetry() {
        show(Features.isCreativeStudioSupported() ? C9086R.string.ai_drawing_no_drawings_or_images_found_in_selected_area : C9086R.string.ai_drawing_no_drawing_found_in_selected_area);
    }

    public void updateGuideLayout() {
        this.mGuide.updateGuideLayout();
    }

    public void show(@StringRes int i) {
        this.mHandler.post(new RunnableC0050f(this, i, 17));
    }
}
