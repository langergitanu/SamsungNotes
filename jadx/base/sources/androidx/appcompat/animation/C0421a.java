package androidx.appcompat.animation;

import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.SeslRecoilDrawable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarAnimation;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarProgressAnimation;
import com.samsung.android.sdk.pen.setting.common.SpenSliderThumbAnimator;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCircularRoundLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverPreviewControl;
import com.samsung.android.sdk.pen.setting.util.SpenRecoilAnimator;
import com.samsung.android.sdk.pen.setting.util.SpenRecoilDrawable;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleView;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomRecoilAnimator;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomRecoilDrawable;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.tablet.TabletDrawerView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterDelegate;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.animation.AiResultViewFlickAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolCustomBackground;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircularRoundLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu;

/* JADX INFO: renamed from: androidx.appcompat.animation.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0421a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f927a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f928b;

    public /* synthetic */ C0421a(Object obj, int i) {
        this.f927a = i;
        this.f928b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f927a) {
            case 0:
                ((SeslRecoilAnimator) this.f928b).lambda$new$0(valueAnimator);
                break;
            case 1:
                ((SeslRecoilDrawable) this.f928b).lambda$initAnimator$0(valueAnimator);
                break;
            case 2:
                MaterialMainContainerBackHelper.lambda$createCornerAnimator$0((ClippableRoundedCornerLayout) this.f928b, valueAnimator);
                break;
            case 3:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) this.f928b, valueAnimator);
                break;
            case 4:
                SpenSeekBarAnimation.setThumbAnimation$lambda$0((SpenSeekBarAnimation) this.f928b, valueAnimator);
                break;
            case 5:
                SpenSeekBarProgressAnimation.setLabelAnimator$lambda$6$lambda$5((SpenSeekBarProgressAnimation) this.f928b, valueAnimator);
                break;
            case 6:
                SpenSliderThumbAnimator.createBackgroundValueAnimator$lambda$0((SpenSliderThumbAnimator) this.f928b, valueAnimator);
                break;
            case 7:
                SpenCircularRoundLayout.startAnimation$lambda$0((SpenCircularRoundLayout) this.f928b, valueAnimator);
                break;
            case 8:
                SpenCurvedDialer.startVisibilityAnimation$lambda$0((SpenCurvedDialer) this.f928b, valueAnimator);
                break;
            case 9:
                SpenCurvedSlider.initAnimator$lambda$0((SpenCurvedSlider) this.f928b, valueAnimator);
                break;
            case 10:
                SpenQTPenItemVisibilityController.startAttrItemAlphaAnimation$lambda$15$lambda$12((SpenPenAttrMiniView) this.f928b, valueAnimator);
                break;
            case 11:
                SpenRemoverPreviewControl.initPreviewAnimator$lambda$0((SpenRemoverPreviewControl) this.f928b, valueAnimator);
                break;
            case 12:
                SpenRecoilAnimator._init_$lambda$0((SpenRecoilAnimator) this.f928b, valueAnimator);
                break;
            case 13:
                SpenRecoilDrawable.initAnimator$lambda$0((SpenRecoilDrawable) this.f928b, valueAnimator);
                break;
            case 14:
                RippleView.startRipple$lambda$1((RippleView) this.f928b, valueAnimator);
                break;
            case 15:
                CustomRecoilAnimator._init_$lambda$0((CustomRecoilAnimator) this.f928b, valueAnimator);
                break;
            case 16:
                CustomRecoilDrawable.initAnimator$lambda$0((CustomRecoilDrawable) this.f928b, valueAnimator);
                break;
            case 17:
                ((ActionMenuController) this.f928b).lambda$setFolderPathLayoutVisibleAnimation$4(valueAnimator);
                break;
            case 18:
                ((TabletDrawerView) this.f928b).lambda$updateNotesListLayoutWithAnimation$0(valueAnimator);
                break;
            case 19:
                FloaterDelegate.runRoundAnimation$lambda$0((FloaterDelegate) this.f928b, valueAnimator);
                break;
            case 20:
                AiResultViewFlickAnimation.createAnimator$lambda$0((AiResultViewFlickAnimation) this.f928b, valueAnimator);
                break;
            case 21:
                StickyMemoAnimation.getShowDecorViewAnimator$lambda$1((StickyMemoView) this.f928b, valueAnimator);
                break;
            case 22:
                ((TitleEditorShowHideAnimator) this.f928b).lambda$getInfoAlphaAnimator$1(valueAnimator);
                break;
            case 23:
                QuickToolCustomBackground.initBgAnimator$lambda$0((QuickToolCustomBackground) this.f928b, valueAnimator);
                break;
            case 24:
                CurvedDialer.startVisibilityAnimation$lambda$0((CurvedDialer) this.f928b, valueAnimator);
                break;
            case 25:
                CurvedSlider.initAnimator$lambda$0((CurvedSlider) this.f928b, valueAnimator);
                break;
            case 26:
                QTCircularRoundLayout.startAnimation$lambda$0((QTCircularRoundLayout) this.f928b, valueAnimator);
                break;
            default:
                VoiceRecordSimpleMenu.createBackgroundValueAnimator$lambda$10((VoiceRecordSimpleMenu) this.f928b, valueAnimator);
                break;
        }
    }
}
