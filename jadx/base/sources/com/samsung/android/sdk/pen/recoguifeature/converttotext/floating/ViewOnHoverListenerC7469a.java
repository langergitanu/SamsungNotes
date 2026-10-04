package com.samsung.android.sdk.pen.recoguifeature.converttotext.floating;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingButtons;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenListLayout;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewHover;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnHoverListenerC7469a implements View.OnHoverListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4989a;

    public /* synthetic */ ViewOnHoverListenerC7469a(int i) {
        this.f4989a = i;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        switch (this.f4989a) {
            case 0:
                return FloatingTextResult.showGuideView$lambda$17(view, motionEvent);
            case 1:
                return FloatingTextResult.updateLayout$lambda$2$lambda$1(view, motionEvent);
            case 2:
                return FloatingButtons.init$lambda$5$lambda$1(view, motionEvent);
            case 3:
                return SpenColorSpoidLayout.mOnConsumedHoverListener$lambda$4(view, motionEvent);
            case 4:
                return SpenConsumedListener.mOnConsumedHoverListener$lambda$1(view, motionEvent);
            case 5:
                return SpenSettingQTPenListLayout.initView$lambda$1(view, motionEvent);
            case 6:
                return BAViewHover.setHoverListenerForConsuming$lambda$0(view, motionEvent);
            case 7:
                return TitleViewShowHideAnimator.lambda$new$0(view, motionEvent);
            default:
                return SettingQTPenListDockingLayout.initView$lambda$2(view, motionEvent);
        }
    }
}
