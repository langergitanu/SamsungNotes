package com.samsung.android.support.senl.p148nt.app.settings.advanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.hwr.SettingsHWRHelper;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.interfaces.SettingsInterfacesHelper;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.objects.SettingsObjectsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.restore.SettingsOldNotesHelper;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.tools.SettingsToolsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\"\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/SettingsAdvancedFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mToolsHelper", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/tools/SettingsToolsHelper;", "mInterfaceHelper", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/interfaces/SettingsInterfacesHelper;", "mObjectsHelper", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/objects/SettingsObjectsHelper;", "mHWRHelper", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/hwr/SettingsHWRHelper;", "mRestoreNotesHelper", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/restore/SettingsOldNotesHelper;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "onResume", "onDestroyView", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsAdvancedFragment extends SettingsBaseFragment {

    @NotNull
    public static final String TAG = "SettingsAdvancedFragment";

    @NotNull
    private SettingsToolsHelper mToolsHelper = new SettingsToolsHelper(this);

    @NotNull
    private SettingsInterfacesHelper mInterfaceHelper = new SettingsInterfacesHelper(this);

    @NotNull
    private SettingsObjectsHelper mObjectsHelper = new SettingsObjectsHelper(this);

    @NotNull
    private SettingsHWRHelper mHWRHelper = new SettingsHWRHelper(this);

    @NotNull
    private SettingsOldNotesHelper mRestoreNotesHelper = new SettingsOldNotesHelper(this);

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (this.mToolsHelper.handleActivityResults(requestCode, resultCode, data) || this.mObjectsHelper.handleActivityResults(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        super.onCreatePreferences(savedInstanceState, rootKey);
        this.mInterfaceHelper.initDefaultPreference();
        getPreferenceManager().setSharedPreferencesName("Settings");
        getPreferenceManager().setSharedPreferencesMode(0);
        addPreferencesFromResource(C8003R.xml.settings_advanced_preference);
        this.mToolsHelper.initialize();
        this.mInterfaceHelper.initialize();
        this.mObjectsHelper.initialize();
        this.mHWRHelper.initialize();
        this.mRestoreNotesHelper.initialize();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mToolsHelper.release();
        this.mInterfaceHelper.release();
        this.mObjectsHelper.release();
        this.mHWRHelper.release();
        this.mRestoreNotesHelper.release();
        super.onDestroy();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mRestoreNotesHelper.releaseWithLifeCycleOwner();
        super.onDestroyView();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mToolsHelper.updatePreference();
        this.mInterfaceHelper.updatePreference();
        this.mObjectsHelper.updatePreference();
        this.mHWRHelper.updatePreference();
        this.mRestoreNotesHelper.updatePreference();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mRestoreNotesHelper.initializeWithLifeCycleOwner();
    }
}
