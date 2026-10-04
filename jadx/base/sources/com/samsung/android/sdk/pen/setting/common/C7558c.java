package com.samsung.android.sdk.pen.setting.common;

import android.widget.RadioGroup;
import com.samsung.android.sdk.pen.setting.laserpen.SpenLaserColorOptionLayout;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout;
import com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.SpeakerRenameDialog;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.common.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7558c implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5031a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5032b;

    public /* synthetic */ C7558c(Object obj, int i) {
        this.f5031a = i;
        this.f5032b = obj;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (this.f5031a) {
            case 0:
                SpenRadioListLayout.mRadioBtnListener$lambda$1((SpenRadioListLayout) this.f5032b, radioGroup, i);
                break;
            case 1:
                SpenLaserColorOptionLayout.mRadioBtnListener$lambda$0((SpenLaserColorOptionLayout) this.f5032b, radioGroup, i);
                break;
            case 2:
                SpenRemoverLayout.mRadioBtnListener$lambda$0((SpenRemoverLayout) this.f5032b, radioGroup, i);
                break;
            case 3:
                SpenSelectionLayout.mRadioBtnListener$lambda$0((SpenSelectionLayout) this.f5032b, radioGroup, i);
                break;
            case 4:
                BaseWidgetSettingView.initRadioButtonsOneUiOld$lambda$6((BaseWidgetSettingView) this.f5032b, radioGroup, i);
                break;
            default:
                SpeakerRenameDialog.setButtonClickListener$lambda$9((SpeakerRenameDialog) this.f5032b, radioGroup, i);
                break;
        }
    }
}
