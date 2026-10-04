package com.samsung.android.support.senl.p148nt.app.settings.advanced.restore;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainSALoggingHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u000b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002R\u001c\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/restore/SettingsOldNotesHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "mOldDocLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "mOldDocLiveDataObserver", "com/samsung/android/support/senl/nt/app/settings/advanced/restore/SettingsOldNotesHelper$mOldDocLiveDataObserver$1", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/restore/SettingsOldNotesHelper$mOldDocLiveDataObserver$1;", "initialize", "", "initializeWithLifeCycleOwner", "releaseWithLifeCycleOwner", "updatePreference", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "initImportData", "updateImportNotes", "initConvertYourNote", "updateCategoryVisibility", "updateConvertYourNote", "oldDocLiveData", "getOldDocLiveData", "()Landroidx/lifecycle/LiveData;", "tag", "", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsOldNotesHelper extends AbsSettingsHelper {

    @NotNull
    private static final String TAG = "SettingsRestoreNotesHelper";

    @Nullable
    private LiveData<List<MainListDocumentData>> mOldDocLiveData;

    @NotNull
    private final SettingsOldNotesHelper$mOldDocLiveDataObserver$1 mOldDocLiveDataObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.samsung.android.support.senl.nt.app.settings.advanced.restore.SettingsOldNotesHelper$mOldDocLiveDataObserver$1] */
    public SettingsOldNotesHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mOldDocLiveDataObserver = new Observer<List<? extends MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.restore.SettingsOldNotesHelper$mOldDocLiveDataObserver$1
            @Override // androidx.lifecycle.Observer
            public void onChanged(List<? extends MainListDocumentData> value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (SettingsMenuUtils.isConvertYourNoteEnabled()) {
                    this.this$0.updateConvertYourNote();
                }
                if (value.isEmpty()) {
                    this.this$0.getOldDocLiveData().removeObserver(this);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<List<MainListDocumentData>> getOldDocLiveData() {
        if (this.mOldDocLiveData == null) {
            this.mOldDocLiveData = NotesDataRepositoryFactory.newInstance(getFragment().requireContext()).createNotesOldDocumentRepository().getAll_OldNotes_LiveData(0, new SortParam.SortParamBuilder().build());
        }
        LiveData<List<MainListDocumentData>> liveData = this.mOldDocLiveData;
        Intrinsics.checkNotNull(liveData);
        return liveData;
    }

    private final void initConvertYourNote() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES);
        Context context = getFragment().getContext();
        if (preferenceFindPreference == null || context == null) {
            return;
        }
        preferenceFindPreference.setVisible(SettingsMenuUtils.isConvertYourNoteVisible(context));
        preferenceFindPreference.setEnabled(SettingsMenuUtils.isConvertYourNoteEnabled());
        preferenceFindPreference.setOnPreferenceClickListener(this);
    }

    private final void initImportData() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_IMPORT_NOTES);
        Context context = getFragment().getContext();
        if (preferenceFindPreference == null || context == null) {
            return;
        }
        if (SettingsMenuUtils.isImportDataSupported(context)) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
        } else {
            removePreference(preferenceFindPreference);
        }
    }

    private final void updateCategoryVisibility() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_OLD_NOTES_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES);
        boolean z = preferenceFindPreference != null && preferenceFindPreference.isVisible();
        Preference preferenceFindPreference2 = getFragment().findPreference(SettingsConstants.SETTINGS_IMPORT_NOTES);
        preferenceCategory.setVisible(z || (preferenceFindPreference2 != null && preferenceFindPreference2.isVisible()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateConvertYourNote() {
        Context context = getFragment().getContext();
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES);
        if (preferenceFindPreference == null || context == null) {
            return;
        }
        preferenceFindPreference.setVisible(SettingsMenuUtils.isConvertYourNoteVisible(context));
        preferenceFindPreference.setEnabled(SettingsMenuUtils.isConvertYourNoteEnabled());
    }

    private final void updateImportNotes() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_IMPORT_NOTES);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setVisible(!UserManagerCompat.INSTANCE.getInstance().isDigitalLegacyMode(getFragment().getContext()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        initImportData();
        initConvertYourNote();
        updateCategoryVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initializeWithLifeCycleOwner() {
        super.initializeWithLifeCycleOwner();
        getOldDocLiveData().observe(getFragment().getViewLifecycleOwner(), this.mOldDocLiveDataObserver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SettingsMain;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        String key = preference.getKey();
        if (key != null) {
            MainLogger.m7258i(TAG, "onPreferenceClick# key : ".concat(key));
            if (!preference.isEnabled()) {
                MainLogger.m7258i(TAG, "onPreferenceClick# preference is disabled ");
                return false;
            }
            SettingsMainSALoggingHelper.advancedSettingClickedSALogging(key);
            if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES) || Intrinsics.areEqual(key, SettingsConstants.SETTINGS_IMPORT_NOTES)) {
                getFragment().startSettingsActivity(key);
            } else {
                MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            }
        }
        return super.onPreferenceClick(preference);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void releaseWithLifeCycleOwner() {
        if (getOldDocLiveData().hasObservers()) {
            getOldDocLiveData().removeObserver(this.mOldDocLiveDataObserver);
        }
        super.releaseWithLifeCycleOwner();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateImportNotes();
        updateConvertYourNote();
        updateCategoryVisibility();
    }
}
