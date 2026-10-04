package com.samsung.android.sdk.pen.setting.handwriting;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverPreviewControl;
import com.samsung.android.sdk.scs.p142ai.extension.lts.LongTextSummarizer;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightControl;
import com.samsung.android.sesl.widget.TurbulentView;
import com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer;
import com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mColorMenuCallback$1;
import com.samsung.android.support.senl.addons.brush.view.menu.control.BrushTabletMenuControl;
import com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsHandler;
import com.samsung.android.support.senl.p148nt.app.inapp.view.item.InAppToolbarItemManager;
import com.samsung.android.support.senl.p148nt.app.labs.actionbar.NotesCustomAppbar;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.VerifyForConvertStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.VerifyStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyIrisView;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderWorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.GradientView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SearchFilterHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.OldCategoryMode;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.handwriting.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7599e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5069a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5070b;

    public /* synthetic */ RunnableC7599e(Object obj, int i) {
        this.f5069a = i;
        this.f5070b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5069a) {
            case 0:
                SpenUserLabelSlider.initStateRunnable$lambda$0((SpenUserLabelSlider) this.f5070b);
                break;
            case 1:
                ((SpringAnimation) this.f5070b).start();
                break;
            case 2:
                ((SpenCurvedSwitchLayout) this.f5070b).setVisibility(8);
                break;
            case 3:
                SpenRemoverPreviewControl.initHandler$lambda$1((SpenRemoverPreviewControl) this.f5070b);
                break;
            case 4:
                ((LongTextSummarizer) this.f5070b).lambda$request$3();
                break;
            case 5:
                ((Animator) this.f5070b).resume();
                break;
            case 6:
                ProcessingLightEffect.stopEffectWithAnimation$lambda$2((ProcessingLightEffect) this.f5070b);
                break;
            case 7:
                ((TransitionLightControl) this.f5070b).stop();
                break;
            case 8:
                TurbulentView._init_$lambda$0((TurbulentView) this.f5070b);
                break;
            case 9:
                BrushMenuContainer$mColorMenuCallback$1.onUpdate$lambda$0((BrushMenuContainer) this.f5070b);
                break;
            case 10:
                BrushTabletMenuControl.setSmartTipPopup$lambda$0((BrushTabletMenuControl) this.f5070b);
                break;
            case 11:
                ((CameraPresenter) this.f5070b).startPreviewRepeating();
                break;
            case 12:
                AddonsHandler.C80111.onAddonsCalled$lambda$0((AddonsHandler) this.f5070b);
                break;
            case 13:
                InAppToolbarItemManager.restoreHwToolbarState$lambda$0((InAppToolbarItemManager) this.f5070b);
                break;
            case 14:
                ((NotesCustomAppbar) this.f5070b).updateMenu();
                break;
            case 15:
                VerifyForConvertStrategy.execute$lambda$0((VerifyForConvertStrategy) this.f5070b);
                break;
            case 16:
                VerifyStrategy.verifyWithGUID$lambda$1((VerifyStrategy) this.f5070b);
                break;
            case 17:
                ((AbsBaseBiometricView) this.f5070b).authenticate();
                break;
            case 18:
                ((AbsBaseOldBiometricView) this.f5070b).authenticate();
                break;
            case 19:
                ((VerifyIrisView) this.f5070b).finishCancel();
                break;
            case 20:
                FolderWorkerTask.execute$lambda$0((FolderWorkerTask.TaskParams) this.f5070b);
                break;
            case 21:
                ((ActionMenuController) this.f5070b).lambda$updateCheckInfoText$2();
                break;
            case 22:
                ((GradientView) this.f5070b).applyInternal();
                break;
            case 23:
                SearchFilterHolder.updateEmptyViewHeight$lambda$0((SearchFilterHolder) this.f5070b);
                break;
            case 24:
                SubFolderHolder.showSubFolderHolderList$lambda$11((SubFolderHolderInfo) this.f5070b);
                break;
            case 25:
                ((SearchHandler) this.f5070b).lambda$searchTag$5();
                break;
            case 26:
                ((AnimatorSet) this.f5070b).start();
                break;
            case 27:
                ((CoeditSearchMode) this.f5070b).lambda$onBackKeyDown$0();
                break;
            case 28:
                ((OldCategoryMode) this.f5070b).removeOldCategoryFragment();
                break;
            default:
                ((RunnableC7599e) this.f5070b).run();
                break;
        }
    }
}
