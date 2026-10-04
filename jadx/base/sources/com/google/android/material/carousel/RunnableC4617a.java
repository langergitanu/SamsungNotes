package com.google.android.material.carousel;

import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.firebase.installations.FirebaseInstallations;
import com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCacheWithMemoryCache;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingBgShapeView;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingBgShapeView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceBgShapeView;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.VibrationHelper;
import com.samsung.android.sdk.composer.SpenComposerImpl;
import com.samsung.android.sdk.pen.control.SpenControlObjectManager;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopHWUI;
import com.samsung.android.sdk.pen.engine.writingview.SpenWritingView;
import com.samsung.android.sdk.pen.recogengine.SpenHwrResourceManager;
import com.samsung.android.sdk.pen.setting.SpenBrushDragAreaHelper;
import com.samsung.android.sdk.pen.setting.SpenBrushGuideControl;
import com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenBrushPaletteView;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPalette;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteView;
import com.samsung.android.sdk.pen.setting.common.SPenSeekBarView;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarSizeView;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl;
import com.samsung.android.sdk.pen.setting.handwriting.SpenLineSizeView;

/* JADX INFO: renamed from: com.google.android.material.carousel.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4617a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2241a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2242b;

    public /* synthetic */ RunnableC4617a(Object obj, int i) {
        this.f2241a = i;
        this.f2242b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2241a) {
            case 0:
                ((CarouselLayoutManager) this.f2242b).refreshKeylineState();
                break;
            case 1:
                ((MaterialBackOrchestrator) this.f2242b).startListeningForBackCallbacksWithPriorityOverlay();
                break;
            case 2:
                RectFSpringAnimation.onUpdate$lambda$16((RectFSpringAnimation) this.f2242b);
                break;
            case 3:
                FloatingToolbarLayout.onLayout$lambda$5$lambda$4$lambda$1((FloatingToolbarLayout) this.f2242b);
                break;
            case 4:
                ((FirebaseInstallations) this.f2242b).lambda$getId$1();
                break;
            case 5:
                ((SharedPreferencesAccountCredentialCacheWithMemoryCache) this.f2242b).lambda$new$0();
                break;
            case 6:
                PopupNoteService.isAllowedStartCase$lambda$2((PopupNoteService) this.f2242b);
                break;
            case 7:
                WidgetListGlanceSettingBgShapeView.updateRippleMask$lambda$5((WidgetListGlanceSettingBgShapeView) this.f2242b);
                break;
            case 8:
                WidgetCreatorSettingBgShapeView.updateRippleMask$lambda$5((WidgetCreatorSettingBgShapeView) this.f2242b);
                break;
            case 9:
                WidgetSingleGlanceBgShapeView.updateRippleMask$lambda$5((WidgetSingleGlanceBgShapeView) this.f2242b);
                break;
            case 10:
                VibrationHelper.doVibrate$lambda$0((VibrationHelper) this.f2242b);
                break;
            case 11:
                SpenComposerImpl.mRemoveTwinViewRunnable$lambda$3((SpenComposerImpl) this.f2242b);
                break;
            case 12:
                ((SpenControlObjectManager) this.f2242b).updateObjectRuntimePos();
                break;
            case 13:
                SpenDrawLoopHWUI.postDestroyRendererAdapter$lambda$3((SpenDrawLoopHWUI) this.f2242b);
                break;
            case 14:
                SpenWritingView.setDocument$lambda$6((SpenWritingView) this.f2242b);
                break;
            case 15:
                SpenHwrResourceManager.downloadUpdatableLanguages$lambda$3((SpenHwrResourceManager) this.f2242b);
                break;
            case 16:
                SpenBrushDragAreaHelper.startAlphaAnimation$lambda$0((SpenBrushDragAreaHelper) this.f2242b);
                break;
            case 17:
                SpenBrushGuideControl._set_orientation_$lambda$0((SpenBrushGuideControl) this.f2242b);
                break;
            case 18:
                SpenSettingLaserPenLayout.initBottomView$lambda$3((SpenSettingLaserPenLayout) this.f2242b);
                break;
            case 19:
                SpenSettingRemoverLayout.access$notifyEraseAll((SpenSettingRemoverLayout) this.f2242b);
                break;
            case 20:
                ((SpenBrushPaletteView) this.f2242b).requestLayout();
                break;
            case 21:
                ((SpenColorView) this.f2242b).requestLayout();
                break;
            case 22:
                ((SpenPalette) this.f2242b).requestLayout();
                break;
            case 23:
                ((SpenPaletteView) this.f2242b).requestLayout();
                break;
            case 24:
                SPenSeekBarView.onVisibilityChanged$lambda$4((SPenSeekBarView) this.f2242b);
                break;
            case 25:
                ((SpenSeekBarSizeView) this.f2242b).updateValuePosition();
                break;
            case 26:
                ((SpenSlider) this.f2242b).updateThumbViewPosition();
                break;
            case 27:
                SpenBrushPensView.onSizeChanged$lambda$7((SpenBrushPensView) this.f2242b);
                break;
            case 28:
                SpenFavoritePenLayoutControl.C75752.onAnimationEnd$lambda$0((SpenFavoritePenLayoutControl) this.f2242b);
                break;
            default:
                SpenLineSizeView.updateView$lambda$5((SpenLineSizeView) this.f2242b);
                break;
        }
    }
}
