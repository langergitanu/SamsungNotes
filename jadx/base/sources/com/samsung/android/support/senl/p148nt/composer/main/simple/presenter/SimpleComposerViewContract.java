package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import android.graphics.PointF;
import com.samsung.android.sdk.composer.listener.SpenComposerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface SimpleComposerViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void initView(SpenWNote spenWNote);

        void release();

        void setActionListener(SpenComposerActionListener spenComposerActionListener);

        void setContentPan(float f, float f4, float f5, int i);

        void setPan(PointF pointF);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ZoomScrollPresenter {
        void onScroll(PagePanInfo pagePanInfo, float f);
    }
}
