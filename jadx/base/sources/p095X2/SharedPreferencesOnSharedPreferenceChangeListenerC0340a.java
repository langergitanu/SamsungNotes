package p095X2;

import android.content.SharedPreferences;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsAutoTranscribePrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSearchFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter.CustomToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.PageStyleLayout;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.DefaultTemplateStylePresenter;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.PageBackgroundColorStyleView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.PageLayoutSettingsView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.PageScrollDirectionSettingsView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.PageStyleView;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter.HWRLanguagePresenter;

/* JADX INFO: renamed from: X2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SharedPreferencesOnSharedPreferenceChangeListenerC0340a implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f860a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f861b;

    public /* synthetic */ SharedPreferencesOnSharedPreferenceChangeListenerC0340a(Object obj, int i) {
        this.f860a = i;
        this.f861b = obj;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        switch (this.f860a) {
            case 0:
                CustomToolbarPresenter.onResume$lambda$5((CustomToolbarPresenter) this.f861b, sharedPreferences, str);
                break;
            case 1:
                SettingsAutoTranscribePrefFragment.mPreferenceChangeListener$lambda$0((SettingsAutoTranscribePrefFragment) this.f861b, sharedPreferences, str);
                break;
            case 2:
                SettingsNotesAssistPrefFragment.mPreferenceChangeListener$lambda$2((SettingsNotesAssistPrefFragment) this.f861b, sharedPreferences, str);
                break;
            case 3:
                SettingsSearchFragment.mPreferenceChangeListener$lambda$0((SettingsSearchFragment) this.f861b, sharedPreferences, str);
                break;
            case 4:
                PageStyleLayout.mSharedPreferenceChangeListener$lambda$0((PageStyleLayout) this.f861b, sharedPreferences, str);
                break;
            case 5:
                DefaultTemplateStylePresenter.mSharedPreferenceChangeListener$lambda$0((DefaultTemplateStylePresenter) this.f861b, sharedPreferences, str);
                break;
            case 6:
                PageBackgroundColorStyleView.mPreferenceChangeListener$lambda$0((PageBackgroundColorStyleView) this.f861b, sharedPreferences, str);
                break;
            case 7:
                PageLayoutSettingsView.mSharedPreferenceChangeListener$lambda$0((PageLayoutSettingsView) this.f861b, sharedPreferences, str);
                break;
            case 8:
                PageScrollDirectionSettingsView.mSharedPreferenceChangeListener$lambda$0((PageScrollDirectionSettingsView) this.f861b, sharedPreferences, str);
                break;
            case 9:
                PageStyleView.mSharedPreferenceChangeListener$lambda$0((PageStyleView) this.f861b, sharedPreferences, str);
                break;
            default:
                HWRLanguagePresenter.mHWRLanguageChangeListener$lambda$0((HWRLanguagePresenter) this.f861b, sharedPreferences, str);
                break;
        }
    }
}
