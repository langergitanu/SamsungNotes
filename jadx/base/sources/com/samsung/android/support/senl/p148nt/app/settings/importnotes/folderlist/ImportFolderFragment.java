package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderViewContract;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J+\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020'H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/ImportFolderFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/AbsImportFragment;", "Lcom/samsung/android/support/senl/nt/app/common/listener/OnCustomKeyListener;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderViewContract;", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/ImportFolderView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onDestroyView", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onViewStateRestored", "onResume", "onDestroy", "prepareOptionsMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "handleOptionsItemSelected", "item", "Landroid/view/MenuItem;", "startGoogleDriveActivity", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "startRequestAuthorizationActivity", "startMyfilesPickerActivity", "startSNBAKPickerActivity", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "onCustomKeyEvent", "keyCode", "event", "Landroid/view/KeyEvent;", "getTAG", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportFolderFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFolderFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/ImportFolderFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
public final class ImportFolderFragment extends AbsImportFragment implements OnCustomKeyListener, ImportFolderViewContract {

    @NotNull
    public static final String TAG = "ST$ImportFolderFragment";

    @Nullable
    private ImportFolderView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DocTypeConstants> entries$0 = EnumEntriesKt.enumEntries(DocTypeConstants.values());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment
    @NotNull
    public String getTAG() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment
    public boolean handleOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (!UserInputSkipper.INSTANCE.setDefaultSkipEventTime(true)) {
            return false;
        }
        if (item.getItemId() == C8003R.id.action_import) {
            ImportFolderView importFolderView = this.mView;
            if (importFolderView != null) {
                importFolderView.onActionDoneOptionsItemSelected();
            }
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_SNOTE_PICKER, SettingsSAConstants.EVENT_IMPORT_SNOTE_PICKER_DONE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ImportFolderView importFolderView = this.mView;
        Intrinsics.checkNotNull(importFolderView);
        if (importFolderView.onActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        MainLogger.m7258i(TAG, "onCreate# ");
        ImportFolderView importFolderView = new ImportFolderView(EntriesMappings.entries$0.get(requireArguments().getInt(ImportConstants.KEY_TYPE)), requireArguments().getString("account_name", null), this, this);
        this.mView = importFolderView;
        importFolderView.onCreate(savedInstanceState);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener
    public boolean onCustomKeyEvent(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ImportFolderView importFolderView = this.mView;
        Intrinsics.checkNotNull(importFolderView);
        return importFolderView.onCustomKeyEvent(keyCode, event);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MainLogger.m7258i(getTAG(), "onDestroy");
        super.onDestroy();
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            importFolderView.onDestroy();
        }
        this.mView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MainLogger.m7258i(getTAG(), "onDestroyView");
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            importFolderView.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode != 302) {
            if (requestCode == 308) {
                if (ContentPickerUtils.INSTANCE.isStoragePermissionGranted(this, 3, 308, "onRequestPermissionsResult(SNBAK)")) {
                    startSNBAKPickerActivity();
                } else {
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
        } else if (ContentPickerUtils.INSTANCE.isStoragePermissionGranted(this, 3, 302, "onRequestPermissionsResult(SNote_Local)")) {
            startMyfilesPickerActivity();
        } else {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            importFolderView.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            importFolderView.onSaveInstanceState(outState);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            importFolderView.onViewCreated();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            importFolderView.onViewStateRestored(savedInstanceState);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment
    public boolean prepareOptionsMenu(@Nullable Menu menu) {
        ImportFolderView importFolderView = this.mView;
        if (importFolderView != null) {
            return importFolderView.prepareOptionsMenu(menu);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderViewContract
    public void startGoogleDriveActivity(@Nullable Intent intent) {
        MainLogger.m7258i(TAG, "startGoogleDriveActivity()");
        PackageManager packageManager = requireActivity().getPackageManager();
        if (intent != null) {
            Intrinsics.checkNotNullExpressionValue(packageManager.queryIntentActivities(intent, 0), "queryIntentActivities(...)");
            if (!r0.isEmpty()) {
                startActivityForResult(intent, 1);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderViewContract
    public void startMyfilesPickerActivity() {
        if (!EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(getActivity())) {
            ContentPickerUtils.INSTANCE.startMyfilesPickerActivityForResult(this, 302, 3, Constants.MIME_SPD, Constants.MIME_SNB);
            return;
        }
        String string = getString(C8003R.string.app_chooser_emergency_mode_unable_to_use_attach, getString(C8003R.string.settings_import_data_title, getString(C8003R.string.settings_import_downloading_dialog_snote)));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ToastHandler.show(getActivity(), string, 1, false);
        requireActivity().finish();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderViewContract
    public void startRequestAuthorizationActivity(@Nullable Intent intent) {
        if (intent != null) {
            startActivityForResult(intent, 2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.ImportFolderViewContract
    public void startSNBAKPickerActivity() {
        if (!EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(getActivity())) {
            ContentPickerUtils.INSTANCE.startSNBAKPickerActivityForResult(this, 308, 4);
            return;
        }
        String string = getString(C8003R.string.app_chooser_emergency_mode_unable_to_use_attach, getString(C8003R.string.settings_import_data_title, "SDocx"));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ToastHandler.show(getActivity(), string, 1, false);
        requireActivity().finish();
    }
}
