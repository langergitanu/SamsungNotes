package com.samsung.android.support.senl.p148nt.app.settings.hwr;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter.HWRLanguagePresenter;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter.PresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.view.HWRLanguageHolderDividerDecoration;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\"\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/SettingsHWRFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/presenter/PresenterContract;", "<init>", "()V", "mHWRLanguagePresenter", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/presenter/HWRLanguagePresenter;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "initRecyclerView", "rootView", "onCreateRecyclerView", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onResume", "onDestroy", "onDataLoadFinished", "itemCount", "", "getContext", "Landroid/content/Context;", "getGetContext", "()Landroid/content/Context;", "setFastScrollerEnabled", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsHWRFragment extends SettingsBaseFragment implements PresenterContract {
    private static final int FAST_SCROLLER_ENABLED = 70;

    @NotNull
    public static final String TAG = "ST$SettingsHWRFragment";

    @NotNull
    private final HWRLanguagePresenter mHWRLanguagePresenter = new HWRLanguagePresenter(this);

    @Nullable
    private RecyclerView mRecyclerView;

    private final void initRecyclerView(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(C8003R.id.recycler_view);
        if (recyclerView == null) {
            return;
        }
        this.mRecyclerView = recyclerView;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.mHWRLanguagePresenter.getHwrLanguageAdapter());
        RecyclerView recyclerView2 = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        RecyclerView recyclerView3 = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView3);
        RecyclerView recyclerView4 = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView4);
        Context context = recyclerView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        recyclerView3.addItemDecoration(new HWRLanguageHolderDividerDecoration(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateRecyclerView$lambda$0(RecyclerView recyclerView) {
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_HANDWRITING_LANGUAGE, SettingsSAConstants.EVENT_HANDWRITING_LANGUAGE_GO_TO_TOP);
        return false;
    }

    private final void setFastScrollerEnabled(int itemCount) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.seslSetFastScrollerEnabled(itemCount >= 70);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter.PresenterContract
    @Nullable
    public Context getGetContext() {
        return requireContext();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainLogger.m7258i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        this.mHWRLanguagePresenter.initialize();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        MainLogger.m7258i(TAG, "onCreatePreferences");
        getPreferenceManager().setSharedPreferencesName("Settings");
        addPreferencesFromResource(C8003R.xml.settings_hwr_language_preference);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat
    @NotNull
    public RecyclerView onCreateRecyclerView(@NotNull LayoutInflater inflater, @NotNull ViewGroup parent, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView recyclerViewOnCreateRecyclerView = super.onCreateRecyclerView(inflater, parent, savedInstanceState);
        recyclerViewOnCreateRecyclerView.seslSetGoToTopEnabled(true);
        recyclerViewOnCreateRecyclerView.seslSetOnGoToTopClickListener(new C0347a(0));
        return recyclerViewOnCreateRecyclerView;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter.PresenterContract
    public void onDataLoadFinished(int itemCount) {
        setFastScrollerEnabled(itemCount);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHWRLanguagePresenter.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mHWRLanguagePresenter.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.mHWRLanguagePresenter.onSaveInstanceState(outState);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        MainLogger.m7258i(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        this.mHWRLanguagePresenter.onRestoreInstanceState(savedInstanceState);
        if (getArguments() != null) {
            HWRLanguagePresenter hWRLanguagePresenter = this.mHWRLanguagePresenter;
            String string = requireArguments().getString(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_SETTINGS);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            hWRLanguagePresenter.setCaller(string);
            HWRLanguagePresenter hWRLanguagePresenter2 = this.mHWRLanguagePresenter;
            String string2 = requireArguments().getString(SettingsConstants.KEY_LANGUAGE_LIST_FILTER, "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            hWRLanguagePresenter2.setLanguageListFilter(string2);
        }
        initRecyclerView(view);
    }
}
