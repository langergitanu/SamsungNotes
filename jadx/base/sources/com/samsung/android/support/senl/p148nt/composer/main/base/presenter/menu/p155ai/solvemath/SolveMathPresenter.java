package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ClipboardUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.SolveMathManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.view.SolveMathResult;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BitmapUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;
import java.util.Locale;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SolveMathPresenter implements SolveMathManager.OnSolveMathEventListener {
    private static final String TAG = Logger.createTag("SolveMathPresenter", AiConstants.PREFIX_TAG);
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private SolveMathManager mSolveMathManager;
    private SolveMathResult mSolveMathResult;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Callbacks implements SolveMathResult.Callback {
        public /* synthetic */ Callbacks(SolveMathPresenter solveMathPresenter, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.SolveMathResult.Callback
        public void onCopyResult(Bitmap bitmap, int i) {
            SolveMathPresenter.this.onCopyResult(bitmap, i);
        }

        private Callbacks() {
        }
    }

    public SolveMathPresenter(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        initMenu();
        initManager();
        setEnabled(isEnabled());
        setAnswerColor();
        setLocale();
    }

    private void initManager() {
        SolveMathManager solveMathManager = new SolveMathManager(this.mComposerViewPresenter);
        this.mSolveMathManager = solveMathManager;
        solveMathManager.setSolveMathEventListener(this);
    }

    private void initMenu() {
        SolveMathResult solveMathResult = new SolveMathResult();
        this.mSolveMathResult = solveMathResult;
        solveMathResult.init(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getKeyguardPresenter(), new Callbacks(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHideRecognitionResult$1() {
        if (this.mSolveMathResult.getVisibility() == 0) {
            this.mSolveMathResult.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShowRecognitionResult$0() {
        if (8 == this.mSolveMathResult.getVisibility()) {
            this.mSolveMathResult.show(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecognitionResultContent$2(Bitmap bitmap) {
        this.mSolveMathResult.setResultContent(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecognitionResultContentPosition$4(RectF rectF) {
        this.mSolveMathResult.updatePosition(rectF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecognitionResultContentVisibility$3(boolean z) {
        int visibility = this.mSolveMathResult.getVisibility();
        if (z) {
            if (4 == visibility) {
                this.mSolveMathResult.show(false);
            }
        } else if (visibility == 0) {
            this.mSolveMathResult.invisible();
        }
    }

    private void releaseManager() {
        Logger.m10999d(TAG, "releaseManager#");
        this.mSolveMathManager.release();
    }

    private void releaseMenu() {
        Logger.m10999d(TAG, "releaseMenu#");
        this.mSolveMathResult.release();
    }

    private void updateRecognitionResultContent(Bitmap bitmap) {
        this.mHandler.post(new RunnableC8515c(this, bitmap, 26));
    }

    private void updateRecognitionResultContentPosition(RectF rectF) {
        this.mHandler.post(new RunnableC8515c(this, rectF, 25));
    }

    private void updateRecognitionResultContentVisibility(boolean z) {
        this.mHandler.post(new RunnableC0116a(15, this, z));
    }

    public boolean isEnabled() {
        boolean z = this.mComposerViewPresenter.getComposerModel().getNotesDocEntityManager().getNotesDocumentEntity().getMathMode() == 1;
        AbstractC8014b.m7220v("isEnabled# ", TAG, z);
        return z && FeatureUtils.isSolveMathSupported();
    }

    public boolean isSupportState() {
        boolean z = false;
        try {
            ComposerModel composerModel = this.mComposerViewPresenter.getComposerModel();
            boolean zIsCoeditMode = composerModel.getMdeManager().getCoeditAdapter().isCoeditMode();
            boolean zIsMde = composerModel.getMdeManager().getMdeInfo().isMde();
            if (FeatureUtils.isSolveMathSupported() && !zIsCoeditMode && !zIsMde) {
                z = true;
            }
        } catch (NullPointerException e) {
            Logger.m11000e(TAG, "isSupportState# " + e.getMessage());
        }
        AbstractC8014b.m7220v("isSupportState ", TAG, z);
        return z;
    }

    public void onConfigurationChanged() {
        Logger.m10999d(TAG, "onConfigurationChanged#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.SolveMathManager.OnSolveMathEventListener
    public void onControlVisibilityChanged(boolean z) {
        updateRecognitionResultContentVisibility(z);
    }

    public void onCopyResult(Bitmap bitmap, int i) {
        Logger.m10999d(TAG, "onCopyResult");
        ClipboardUtil.copyImageToClipboard(BitmapUtil.createPaddedBitmap(bitmap, i, 200, 100));
    }

    public void onDetachView() {
        Logger.m10999d(TAG, "onDetachView#");
        releaseMenu();
    }

    public void onHideContextMenu() {
        Logger.m10999d(TAG, "onHideContextMenu#");
        onHideRecognitionResult();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.SolveMathManager.OnSolveMathEventListener
    public void onHideRecognitionResult() {
        this.mHandler.post(new RunnableC9742a(this, 1));
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m10999d(TAG, "onSaveInstanceState#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.SolveMathManager.OnSolveMathEventListener
    public void onShowRecognitionResult() {
        this.mHandler.post(new RunnableC9742a(this, 0));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.SolveMathManager.OnSolveMathEventListener
    public void onUpdateRecognitionResultContent(Bitmap bitmap) {
        updateRecognitionResultContent(bitmap);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.SolveMathManager.OnSolveMathEventListener
    public void onUpdateRecognitionResultPosition(RectF rectF) {
        updateRecognitionResultContentPosition(rectF);
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
        releaseManager();
        onDetachView();
    }

    public void restore(Bundle bundle) {
        Logger.m10999d(TAG, "restore#");
        initMenu();
        this.mSolveMathManager.restore();
        setEnabled(isEnabled());
    }

    public void setAnswerColor() {
        this.mSolveMathManager.setAnswerColor(this.mComposerViewPresenter.getActivity().getResources().getColor(C9086R.color.solve_math_answer_color, null));
    }

    public void setEnabled(boolean z) {
        Logger.m10999d(TAG, "setEnabled# " + z);
        if (isSupportState()) {
            this.mComposerViewPresenter.getComposerModel().getNotesDocEntityManager().getNotesDocumentEntity().setMathMode(z ? 1 : 0);
            this.mSolveMathManager.setEnabled(z);
        }
    }

    public void setEnabledTemporarily(boolean z) {
        AbstractC8014b.m7220v("setEnabledTemporarily# ", TAG, z);
        this.mSolveMathManager.setEnabled(z);
    }

    public void setLocale() {
        this.mSolveMathManager.setLocale(Locale.getDefault().toString());
    }
}
