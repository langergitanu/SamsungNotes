package com.samsung.android.app.notes.widget.glance.single.setting.view;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.FloatingTextResult;
import com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingButtons;
import com.samsung.android.sdk.pen.recoguifeature.math.floating.FloatingMathEditor;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsProgressController;
import com.samsung.android.support.senl.p148nt.app.inapp.InAppCollaborationActivity;
import com.samsung.android.support.senl.p148nt.app.inapp.view.item.InAppToolbarItemManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoverEditorDialogFragment;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandMenu;
import com.samsung.android.support.senl.p148nt.composer.main.cover.CoverCreator;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.setting.view.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnTouchListenerC7005f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4718a;

    public /* synthetic */ ViewOnTouchListenerC7005f(int i) {
        this.f4718a = i;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f4718a) {
            case 0:
                return WidgetSingleGlanceSettingView.initBackgroundOnOff$lambda$8(view, motionEvent);
            case 1:
                return FloatingTextResult.showGuideView$lambda$16(view, motionEvent);
            case 2:
                return FloatingTextResult.updateLayout$lambda$2$lambda$0(view, motionEvent);
            case 3:
                return FloatingButtons.init$lambda$5$lambda$0(view, motionEvent);
            case 4:
                return FloatingMathEditor.updateLayout$lambda$1$lambda$0(view, motionEvent);
            case 5:
                return SpenColorSettingPopup.initView$lambda$3(view, motionEvent);
            case 6:
                return SpenColorSpoidLayout.mOnConsumedTouchListener$lambda$3(view, motionEvent);
            case 7:
                return AddonsProgressController.showProgress$lambda$2$lambda$1$lambda$0(view, motionEvent);
            case 8:
                return InAppCollaborationActivity.mBlockTouchListener$lambda$0(view, motionEvent);
            case 9:
                return InAppToolbarItemManager.applyToolbarEnabledState$lambda$2(view, motionEvent);
            case 10:
                return CoverEditorDialogFragment.lambda$enableEditor$2(view, motionEvent);
            case 11:
                return SmProgressControl.init$lambda$0(view, motionEvent);
            case 12:
                return NoteStyleActivity.updateActivityContainer$lambda$7$lambda$6(view, motionEvent);
            case 13:
                return NoteStyleActivity.enableEditor$lambda$2(view, motionEvent);
            case 14:
                return TitleEditor.lambda$init$4(view, motionEvent);
            case 15:
                return HwToolbarItemManager.lambda$applyToolbarEnabledState$1(view, motionEvent);
            case 16:
                return RtToolbarMenu.lambda$enableToolbar$5(view, motionEvent);
            case 17:
                return VoiceRecordControlMenu.initControlMenu$lambda$0(view, motionEvent);
            case 18:
                return VoiceRecordExpandMenu.initMenuList$lambda$0(view, motionEvent);
            default:
                return CoverCreator.lambda$setViewListener$6(view, motionEvent);
        }
    }
}
