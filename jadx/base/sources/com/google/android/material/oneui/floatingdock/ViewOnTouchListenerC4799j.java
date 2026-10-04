package com.google.android.material.oneui.floatingdock;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingView;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPalette;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorValueSeekBar;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTCircleConsumer;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.TouchInteractionHandler;
import com.samsung.android.support.senl.p148nt.app.inapp.view.InAppView;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingChangeStyleLayout;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingDimView;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingLaserPenLayout;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemHolder;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.PageBackgroundColorStyleView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.search.SearchModeView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircleConsumer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCurvedSwitchLayout;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingPenColor;
import com.samsung.android.support.senl.p148nt.stt.picker.view.SearchFragment;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ViewOnTouchListenerC4799j implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2348a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2349b;

    public /* synthetic */ ViewOnTouchListenerC4799j(Object obj, int i) {
        this.f2348a = i;
        this.f2349b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f2348a) {
            case 0:
                return FloatingPaneView.dragHandlerController$lambda$6((FloatingPaneView) this.f2349b, view, motionEvent);
            case 1:
                return WidgetListGlanceSettingView.initBackgroundOnOff$lambda$8((WidgetListGlanceSettingView) this.f2349b, view, motionEvent);
            case 2:
                return WidgetCreatorRecycleViewActivity.onCreate$lambda$2((WidgetCreatorRecycleViewActivity) this.f2349b, view, motionEvent);
            case 3:
                return WidgetCreatorSettingView.initBackgroundOnOff$lambda$2((WidgetCreatorSettingView) this.f2349b, view, motionEvent);
            case 4:
                return WidgetSingleGlanceSettingView.initBackgroundOnOff$lambda$11((WidgetSingleGlanceSettingView) this.f2349b, view, motionEvent);
            case 5:
                return SpenPalette.mTouchListener$lambda$0((SpenPalette) this.f2349b, view, motionEvent);
            case 6:
                return SpenColorValueSeekBar.mSeekBarOnTouchListener$lambda$4((SpenColorValueSeekBar) this.f2349b, view, motionEvent);
            case 7:
                return SpenColorSpoidLayout.mSpoidSettingListener$lambda$2((SpenColorSpoidLayout) this.f2349b, view, motionEvent);
            case 8:
                return SpenConsumedListener.mOnConsumedTouchListener$lambda$0((SpenConsumedListener) this.f2349b, view, motionEvent);
            case 9:
                return SpenQTCircleConsumer.mOnConsumedTouchListener$lambda$0((SpenQTCircleConsumer) this.f2349b, view, motionEvent);
            case 10:
                return TouchInteractionHandler.createTouchListener$lambda$0((TouchInteractionHandler) this.f2349b, view, motionEvent);
            case 11:
                return InAppView.setOnTouchListenerToHideInAppPopups$lambda$1((InAppView) this.f2349b, view, motionEvent);
            case 12:
                return InAppSettingChangeStyleLayout.setCloseButtonTouchEvent$lambda$0((InAppSettingChangeStyleLayout) this.f2349b, view, motionEvent);
            case 13:
                return InAppSettingDimView.setTouchListenerToDim$lambda$0((InAppSettingDimView) this.f2349b, view, motionEvent);
            case 14:
                return InAppSettingLaserPenLayout.setCloseButtonTouchEvent$lambda$0((InAppSettingLaserPenLayout) this.f2349b, view, motionEvent);
            case 15:
                return CustomToolbarItemHolder._init_$lambda$0((CustomToolbarItemHolder) this.f2349b, view, motionEvent);
            case 16:
                return PageBackgroundColorStyleView.initInvertSwitch$lambda$3$lambda$1((PageBackgroundColorStyleView) this.f2349b, view, motionEvent);
            case 17:
                return ((SoftInputManager) this.f2349b).lambda$setLockView$2(view, motionEvent);
            case 18:
                return CoverPreviewLayout.setSummaryView$lambda$5((CoverPreviewLayout) this.f2349b, view, motionEvent);
            case 19:
                return ((SearchModeView) this.f2349b).lambda$initSearchText$0(view, motionEvent);
            case 20:
                return QuickTool.initQuickTool$lambda$1((QuickTool) this.f2349b, view, motionEvent);
            case 21:
                return QTCircleConsumer.mOnConsumedTouchListener$lambda$0((QTCircleConsumer) this.f2349b, view, motionEvent);
            case 22:
                return QTCurvedSwitchLayout.addThumbView$lambda$1$lambda$0((QTCurvedSwitchLayout) this.f2349b, view, motionEvent);
            case 23:
                return SettingPenColor.update$lambda$0((SettingPenColor) this.f2349b, view, motionEvent);
            default:
                return SearchFragment.initView$lambda$2((SearchFragment) this.f2349b, view, motionEvent);
        }
    }
}
