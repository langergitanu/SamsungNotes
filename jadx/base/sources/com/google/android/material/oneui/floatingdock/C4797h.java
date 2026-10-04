package com.google.android.material.oneui.floatingdock;

import android.widget.PopupWindow;
import com.samsung.android.sdk.pen.text.SpenSuggestionPopup;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandOptionMenu;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4797h implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2344a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2345b;

    public /* synthetic */ C4797h(Object obj, int i) {
        this.f2344a = i;
        this.f2345b = obj;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        switch (this.f2344a) {
            case 0:
                FloatingPaneView.showPopup$lambda$15$lambda$12((FloatingPaneView) this.f2345b);
                break;
            case 1:
                SpenSuggestionPopup.createPopupWindow$lambda$7$lambda$6((SpenSuggestionPopup) this.f2345b);
                break;
            case 2:
                OptionMenuPopupWindowHelper.lambda$getPopupWindowNewStyleLayout$0((GuidingLightEffect) this.f2345b);
                break;
            default:
                VoiceRecordExpandOptionMenu.initOptionView$lambda$0((VoiceRecordExpandOptionMenu) this.f2345b);
                break;
        }
    }
}
