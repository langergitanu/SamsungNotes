package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import android.graphics.PointF;
import com.samsung.android.sdk.composer.util.SpenPagePan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.ComposerStateManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCVScrollZoomController implements SimpleComposerViewContract.ZoomScrollPresenter {
    private static final String TAG = Logger.createTag("ScrollZoomController", SimpleComposerConstant.TAG_PREFIX);
    private ComposerStateManager mComposerStateManager;
    private NoteInfoManager mNoteInfoManager;
    private SimpleComposerViewContract.IView mView;

    public SCVScrollZoomController(ComposerStateManager composerStateManager) {
        this.mComposerStateManager = composerStateManager;
    }

    private void checkIsNaNAndChange(PointF pointF) {
        if (Float.isNaN(pointF.x)) {
            pointF.x = 0.0f;
        }
        if (Float.isNaN(pointF.y)) {
            pointF.y = 0.0f;
        }
    }

    public void init(NoteInfoManager noteInfoManager) {
        this.mNoteInfoManager = noteInfoManager;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerViewContract.ZoomScrollPresenter
    public void onScroll(PagePanInfo pagePanInfo, float f) {
        ComposerState composerState = this.mComposerStateManager.getComposerState();
        if (composerState.isReadyRestore()) {
            return;
        }
        composerState.setPosition(pagePanInfo, f);
    }

    public void restoreLastPosition() {
        ComposerState composerState = this.mComposerStateManager.getComposerState();
        if (composerState.isReadyRestore()) {
            composerState.setReadyRestore(false);
            try {
                SpenPagePan spenPagePanConvertToSpenPagePan = PagePanInfo.convertToSpenPagePan(composerState.getPagePanInfo());
                SpenWNote note = this.mNoteInfoManager.getNote();
                int pageCount = note.getPageCount();
                int i = spenPagePanConvertToSpenPagePan.pageIndex;
                if (pageCount <= i) {
                    Logger.m11000e(TAG, "restoreLastPosition IndexOutOfBoundsException : " + note.getPageCount() + "<=" + spenPagePanConvertToSpenPagePan.pageIndex);
                    return;
                }
                PointF pointFConvertPagePanToContentPan = SpenPagePan.convertPagePanToContentPan(note, spenPagePanConvertToSpenPagePan);
                if (pointFConvertPagePanToContentPan == null) {
                    Logger.m11000e(TAG, "restoreLastPosition# contentPan is null");
                    return;
                }
                checkIsNaNAndChange(pointFConvertPagePanToContentPan);
                float zoomRatio = this.mComposerStateManager.getComposerState().getZoomRatio();
                setContentPan(zoomRatio, pointFConvertPagePanToContentPan.x, pointFConvertPagePanToContentPan.y, i);
                Logger.m11003i(TAG, "restoreLastPosition first setContentPan : " + zoomRatio + "/" + pointFConvertPagePanToContentPan.x + "/" + pointFConvertPagePanToContentPan.y + "/" + i);
            } catch (Exception e) {
                AbstractC8014b.m7207i("restoreLastPosition ", e, TAG);
            }
        }
    }

    public void setContentPan(float f, float f4, float f5, int i) {
        SimpleComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            try {
                iView.setContentPan(f, f4, f5, i);
            } catch (Exception e) {
                AbstractC8014b.m7207i("setContentPan# ", e, TAG);
            }
        }
    }

    public void setView(SimpleComposerViewContract.IView iView) {
        this.mView = iView;
    }
}
