package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath;

import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathFailCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.renderer.FormulaRenderer;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SolveMathManager {
    private static final String TAG = Logger.createTag("SolveMathManager", AiConstants.PREFIX_TAG);
    private ComposerViewPresenter mComposerViewPresenter;
    private OnSolveMathEventListener mSolveMathEventListener;
    private SpenIMathManager mSpenIMathManager;
    private RectF mContentRectF = new RectF();
    private final SpenHwrMathListener mSpenHwrMathListener = new SpenHwrMathListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.SolveMathManager.1
        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onClosed() {
            Logger.m10999d(SolveMathManager.TAG, "onClosed");
            SolveMathManager.this.mSolveMathEventListener.onHideRecognitionResult();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onControlVisibleChanged(boolean z) {
            RectF rectFConvertContentRectIntoViewRect = SolveMathManager.this.getNoteZoomScroller().convertContentRectIntoViewRect(SolveMathManager.this.mContentRectF);
            String str = SolveMathManager.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("onControlVisibleChanged# isVisible/contentRect/viewRectF ", "/", z);
            sbM3200j.append(SolveMathManager.this.mContentRectF);
            sbM3200j.append("/");
            sbM3200j.append(rectFConvertContentRectIntoViewRect);
            Logger.m10999d(str, sbM3200j.toString());
            if (!z || (rectFConvertContentRectIntoViewRect.left >= 0.0f && rectFConvertContentRectIntoViewRect.right >= 0.0f)) {
                SolveMathManager.this.mSolveMathEventListener.onUpdateRecognitionResultPosition(rectFConvertContentRectIntoViewRect);
                SolveMathManager.this.mSolveMathEventListener.onControlVisibilityChanged(z);
            }
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onMathExpressionFailed(@Nullable RectF rectF, @Nullable String str, SpenMathFailCode spenMathFailCode) {
            if (rectF == null || str == null) {
                return;
            }
            SolveMathManager.this.mContentRectF.set(rectF);
            RectF rectFConvertContentRectIntoViewRect = SolveMathManager.this.getNoteZoomScroller().convertContentRectIntoViewRect(SolveMathManager.this.mContentRectF);
            Bitmap bitmapRender = FormulaRenderer.render(str, SolveMathManager.this.mSpenIMathManager.getFontPath());
            Logger.m10999d(SolveMathManager.TAG, "onMathExpressionFailed# contentRect/viewRect/latexResult/latexBitmap/failCode " + SolveMathManager.this.mContentRectF + "/" + rectFConvertContentRectIntoViewRect + "/" + str + "/" + bitmapRender + "/" + spenMathFailCode);
            SolveMathManager.this.mSolveMathEventListener.onUpdateRecognitionResultContent(bitmapRender);
            SolveMathManager.this.mSolveMathEventListener.onUpdateRecognitionResultPosition(rectFConvertContentRectIntoViewRect);
            SolveMathManager.this.mSolveMathEventListener.onShowRecognitionResult();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onMathExpressionUpdated(@Nullable RectF rectF, @Nullable String str, boolean z) {
            if (rectF == null || str == null) {
                return;
            }
            SolveMathManager.this.mContentRectF.set(rectF);
            RectF rectFConvertContentRectIntoViewRect = SolveMathManager.this.getNoteZoomScroller().convertContentRectIntoViewRect(SolveMathManager.this.mContentRectF);
            Bitmap bitmapRender = FormulaRenderer.render(str, SolveMathManager.this.mSpenIMathManager.getFontPath());
            Logger.m10999d(SolveMathManager.TAG, "onMathExpressionUpdated# contentRect/viewRect/latexResult/latexBitmap " + SolveMathManager.this.mContentRectF + "/" + rectFConvertContentRectIntoViewRect + "/" + str + "/" + bitmapRender);
            SolveMathManager.this.mSolveMathEventListener.onUpdateRecognitionResultContent(bitmapRender);
            SolveMathManager.this.mSolveMathEventListener.onUpdateRecognitionResultPosition(rectFConvertContentRectIntoViewRect);
            SolveMathManager.this.mSolveMathEventListener.onShowRecognitionResult();
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onMathResultAppended(@NotNull ArrayList<RectF> arrayList) {
            ComposerSA.insertLog(ComposerSAConstants.PAGE_SOLVE_MATH, ComposerSAConstants.EVENT_SOLVE_MATH_CALCULATION_RESULT);
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onProgressStart() {
        }

        @Override // com.samsung.android.sdk.pen.recoguifeature.math.SpenHwrMathListener
        public void onProgressStop() {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSolveMathEventListener {
        void onControlVisibilityChanged(boolean z);

        void onHideRecognitionResult();

        void onShowRecognitionResult();

        void onUpdateRecognitionResultContent(Bitmap bitmap);

        void onUpdateRecognitionResultPosition(RectF rectF);
    }

    public SolveMathManager(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSpenIMathManager = ((SpenComposer) composerViewPresenter.getView()).getMathManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ISpenNoteZoomScroller getNoteZoomScroller() {
        return this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller();
    }

    public void release() {
        this.mSpenIMathManager.setHwrMathListener(null);
    }

    public void restore() {
        Logger.m10999d(TAG, "restore#");
        this.mSpenIMathManager = ((SpenComposer) this.mComposerViewPresenter.getView()).getMathManager();
    }

    public void setAnswerColor(int i) {
        this.mSpenIMathManager.setAnswerColor(i);
    }

    public void setEnabled(boolean z) {
        boolean hwrMathEnabled = this.mSpenIMathManager.setHwrMathEnabled(z);
        Logger.m10999d(TAG, "setEnabled# enabled/ret " + z + "/" + hwrMathEnabled);
        if (hwrMathEnabled) {
            this.mSpenIMathManager.setHwrMathListener(this.mSpenHwrMathListener);
        } else {
            this.mSpenIMathManager.setHwrMathListener(null);
        }
    }

    public void setLocale(String str) {
        this.mSpenIMathManager.setLocale(str);
    }

    public void setSolveMathEventListener(OnSolveMathEventListener onSolveMathEventListener) {
        this.mSolveMathEventListener = onSolveMathEventListener;
    }
}
