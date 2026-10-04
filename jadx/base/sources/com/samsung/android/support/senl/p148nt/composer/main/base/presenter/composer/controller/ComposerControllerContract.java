package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.samsung.android.sdk.pen.text.SpenTextScaleListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ComposerControllerContract extends ModelManager.IView {
    void alignmentContent(int i);

    void cancelSearch();

    void clearSearch();

    PointF getDelta();

    int getPageIndex(RectF rectF);

    PointF getPan();

    float getScale();

    int getScrollingDirection();

    View getView();

    View getViewShowPopup();

    void goToPage(int i);

    boolean isEnableTextOnlyMode();

    boolean isHyperTextEnabled();

    void moveScroll(boolean z, boolean z2);

    void onTextScaleChanged(float f);

    void pageScroll(boolean z);

    void pageZoom(boolean z);

    void requestResetZoomScaleToDefault();

    int search(String str, boolean z);

    int searchBackward();

    int searchForward();

    void setContentPan(float f, float f4, float f5, int i);

    void setEditMode();

    void setEditModeType(int i);

    void setEnableTextOnlyMode(boolean z, float f, SpenTextScaleListener spenTextScaleListener);

    void setHyperLinkAndActionLink(boolean z, boolean z2);

    void setModeOfSpenComposerView(boolean z, int i);

    void setPageLayoutAll(int i, int i2, boolean z, boolean z2);

    void setPan(PointF pointF);

    boolean setSearchFocus(int i);

    void setVoiceSyncPlayAutoScroll(boolean z);

    void setVoiceSyncPlayEnabled(boolean z);

    void smoothScrollToFitPage();

    void stopGestureAnimation();

    void updateDisallowTouchDownArea(boolean z, int i);
}
