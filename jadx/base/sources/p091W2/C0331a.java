package p091W2;

import android.widget.CompoundButton;
import com.samsung.android.sdk.pen.setting.common.SpenSwitchView;
import com.samsung.android.sdk.pen.setting.handwriting.SpenDynamicPenSizeLayout;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.SearchFilterFolderView;
import com.samsung.android.support.senl.p148nt.app.settings.common.widget.SwitchPreferenceLayout;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsAutoTranscribePrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment;

/* JADX INFO: renamed from: W2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0331a implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f851a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f852b;

    public /* synthetic */ C0331a(Object obj, int i) {
        this.f851a = i;
        this.f852b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.f851a) {
            case 0:
                SwitchPreferenceLayout.init$lambda$1$lambda$0((SwitchPreferenceLayout) this.f852b, compoundButton, z);
                break;
            case 1:
                SpenSwitchView.initView$lambda$5((SpenSwitchView) this.f852b, compoundButton, z);
                break;
            case 2:
                SpenDynamicPenSizeLayout.construct$lambda$1((SpenDynamicPenSizeLayout) this.f852b, compoundButton, z);
                break;
            case 3:
                SpenRemoverLayout.mHighlighterOnlyChangeListener$lambda$1((SpenRemoverLayout) this.f852b, compoundButton, z);
                break;
            case 4:
                SearchFilterFolderView.initialize$lambda$0((SearchFilterFolderView) this.f852b, compoundButton, z);
                break;
            case 5:
                SettingsAutoTranscribePrefFragment.initAutoTranscribeSwitch$lambda$3((SettingsAutoTranscribePrefFragment) this.f852b, compoundButton, z);
                break;
            case 6:
                SettingsNotesAssistPrefFragment.initNotesAssistSwitch$lambda$9((SettingsNotesAssistPrefFragment) this.f852b, compoundButton, z);
                break;
            case 7:
                SettingsSyncToMicrosoftPrefFragment.initLayout$lambda$2((SettingsSyncToMicrosoftPrefFragment) this.f852b, compoundButton, z);
                break;
            case 8:
                SettingsSyncWithSamsungAccountPrefFragment.initLayout$lambda$17$lambda$16((SettingsSyncWithSamsungAccountPrefFragment) this.f852b, compoundButton, z);
                break;
            default:
                VerifyPasswordDialogFragment.initLayout$lambda$1((VerifyPasswordDialogFragment) this.f852b, compoundButton, z);
                break;
        }
    }
}
