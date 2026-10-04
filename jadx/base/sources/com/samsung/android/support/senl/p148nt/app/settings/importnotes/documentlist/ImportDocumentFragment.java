package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.ImportDocumentView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.ImportDocumentViewContract;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/ImportDocumentFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/AbsImportFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentViewContract;", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentView;", "mImportType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onDestroyView", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "prepareOptionsMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "handleOptionsItemSelected", "item", "Landroid/view/MenuItem;", "activityFinish", "isFragmentAdded", "()Z", "dismissHoverPopup", "getTAG", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportDocumentFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportDocumentFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/ImportDocumentFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public final class ImportDocumentFragment extends AbsImportFragment implements ImportDocumentViewContract {

    @NotNull
    public static final String TAG = "ST$ImportDocumentFragment";

    @Nullable
    private DocTypeConstants mImportType;

    @Nullable
    private ImportDocumentView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DocTypeConstants> entries$0 = EnumEntriesKt.enumEntries(DocTypeConstants.values());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.ImportDocumentViewContract
    public void activityFinish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void dismissHoverPopup() {
        DocTypeConstants docTypeConstants = this.mImportType;
        if (docTypeConstants == DocTypeConstants.MEMO_LOCAL || docTypeConstants == DocTypeConstants.MEMO_SCLOUD) {
            MainLogger.m7258i(getTAG(), "dismissHoverPopup()");
            ImportDocumentView importDocumentView = this.mView;
            Intrinsics.checkNotNull(importDocumentView);
            importDocumentView.dismissHoverPopup();
        }
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
            ImportDocumentView importDocumentView = this.mView;
            Intrinsics.checkNotNull(importDocumentView);
            importDocumentView.onActionDoneOptionsItemSelected();
            Intent intent = new Intent();
            intent.setAction(NotesConstants.ACTION_IMPORT_NOTES);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                NotesUtils.INSTANCE.backToNoteList(activity, intent);
            }
            if (getActivity() != null) {
                requireActivity().finish();
            }
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_MEMO_PICKER, SettingsSAConstants.EVENT_IMPORT_MEMO_PICKER_DONE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.ImportDocumentViewContract
    public boolean isFragmentAdded() {
        return isAdded();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        MainLogger.m7258i(getTAG(), "onConfigurationChanged()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainLogger.m7258i(getTAG(), "onCreate()");
        this.mImportType = EntriesMappings.entries$0.get(requireArguments().getInt(ImportConstants.KEY_TYPE));
        ImportDocumentView importDocumentView = new ImportDocumentView(this.mImportType, this, this);
        this.mView = importDocumentView;
        Intrinsics.checkNotNull(importDocumentView);
        importDocumentView.onCreate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MainLogger.m7258i(getTAG(), "onDestroy()");
        super.onDestroy();
        ImportDocumentView importDocumentView = this.mView;
        if (importDocumentView != null) {
            importDocumentView.onDestroy();
        }
        this.mView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MainLogger.m7258i(getTAG(), "onDestroyView()");
        ImportDocumentView importDocumentView = this.mView;
        if (importDocumentView != null) {
            importDocumentView.onDestroyView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImportDocumentView importDocumentView = this.mView;
        if (importDocumentView != null) {
            importDocumentView.onViewCreated();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment
    public boolean prepareOptionsMenu(@Nullable Menu menu) {
        ImportDocumentView importDocumentView = this.mView;
        if (importDocumentView != null) {
            return importDocumentView.prepareOptionsMenu(menu);
        }
        return true;
    }
}
