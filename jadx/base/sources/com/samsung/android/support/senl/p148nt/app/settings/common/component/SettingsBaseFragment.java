package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.dialog.SettingsConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 I2\u00020\u0001:\u0002HIB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u0016H\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\u000e\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\nJ\u0012\u00103\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0004J\u000e\u00108\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0005J\u0012\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\bH\u0002J\u000e\u0010>\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\bJ\u000e\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u0005J\u0016\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020\u0016H\u0002J\b\u0010G\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u0010;\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010?\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b?\u0010=¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/preference/PreferenceFragmentCompatCustom;", "<init>", "()V", "mHighlightKey", "", "mCallee", "mHasFocus", "", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment$Contract;", "getMContract", "()Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment$Contract;", "setMContract", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment$Contract;)V", "mActivityContainer", "Landroid/view/View;", "mAnimationCallback", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$AnimationCallback;", "mApplyInsetListener", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$ApplyInsetListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreatePreferences", "rootKey", "onCreateRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onResume", "setFadingEdgeEnabled", "isEnabled", "updateListView", "updateDummyPreferenceForEdgeToEdge", "getFloatingBottomLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout;", "updateListForVst", "updateListForMobile", "setContract", "contract", "callee", "getCallee", "()Ljava/lang/String;", "applyHighlight", "preferenceKey", "swapOtherFragment", "fragmentType", "", "startSettingsActivity", "isCallFromOtherApps", "includeTips", "hasFocus", "getHasFocus", "()Z", "onWindowFocusChanged", "isMsSignInRequested", "compareIntentAction", "actionConstant", "showSettingsConfirmDialog", "type", "dialogListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/SettingsConfirmDialogFragment$DialogListener;", "registerWindowInsetManager", "unregisterWindowInsetManager", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SettingsBaseFragment extends PreferenceFragmentCompatCustom {
    public static final long DELAY_COLLAPSE_DURATION_MILLIS = 300;
    public static final long DELAY_HIGHLIGHT_DURATION_MILLIS = 600;

    @NotNull
    private static final String KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE1 = "key_dummy_pref_category_for_edge_to_edge1";

    @NotNull
    private static final String KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE2 = "key_dummy_pref_category_for_edge_to_edge2";

    @NotNull
    public static final String TAG = "ST$SettingsBaseFragment";

    @Nullable
    private View mActivityContainer;

    @Nullable
    private String mCallee;

    @Nullable
    private Contract mContract;

    @Nullable
    private String mHighlightKey;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long DELAY_HIGHLIGHT_START_DURATION_MILLIS = 900;
    private static final long DELAY_HIGHLIGHT_END_DURATION_MILLIS = 900 + 4000;
    private boolean mHasFocus = true;

    @NotNull
    private final WindowInsetsManager.AnimationCallback mAnimationCallback = new WindowInsetsManager.AnimationCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.SettingsBaseFragment$mAnimationCallback$1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onEnd(WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.this$0.updateListView();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onProgress(WindowInsetsCompat windowInsets, List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        }
    };

    @NotNull
    private final WindowInsetsManager.ApplyInsetListener mApplyInsetListener = new WindowInsetsManager.ApplyInsetListener() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.SettingsBaseFragment$mApplyInsetListener$1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.ApplyInsetListener
        public void onApplyInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
            this.this$0.updateListView();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE1", "KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE2", "DELAY_HIGHLIGHT_DURATION_MILLIS", "", "DELAY_COLLAPSE_DURATION_MILLIS", "DELAY_HIGHLIGHT_START_DURATION_MILLIS", "getDELAY_HIGHLIGHT_START_DURATION_MILLIS", "()J", "DELAY_HIGHLIGHT_END_DURATION_MILLIS", "getDELAY_HIGHLIGHT_END_DURATION_MILLIS", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getDELAY_HIGHLIGHT_END_DURATION_MILLIS() {
            return SettingsBaseFragment.DELAY_HIGHLIGHT_END_DURATION_MILLIS;
        }

        public final long getDELAY_HIGHLIGHT_START_DURATION_MILLIS() {
            return SettingsBaseFragment.DELAY_HIGHLIGHT_START_DURATION_MILLIS;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment$Contract;", "", "swapSettingFragment", "", "fragmentType", "", "startSettingsActivity", "key", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void startSettingsActivity(@NotNull String key);

        void swapSettingFragment(int fragmentType);
    }

    private final void applyHighlight(String preferenceKey) {
        RecyclerView listView = getListView();
        if (listView == null || listView.getAdapter() == null || preferenceKey == null) {
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new RunnableC0218a(listView, preferenceKey, handler, this, 11), 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHighlight$lambda$9(RecyclerView recyclerView, String str, Handler handler, SettingsBaseFragment settingsBaseFragment) {
        PreferenceGroup.PreferencePositionCallback preferencePositionCallback = (PreferenceGroup.PreferencePositionCallback) recyclerView.getAdapter();
        if (preferencePositionCallback == null) {
            return;
        }
        int preferenceAdapterPosition = preferencePositionCallback.getPreferenceAdapterPosition(str);
        AbstractC0000a.m3D(preferenceAdapterPosition, "applyHighlight, scrollTo ", TAG);
        if (preferenceAdapterPosition >= 0) {
            recyclerView.smoothScrollToPosition(preferenceAdapterPosition);
        }
        handler.postDelayed(new RunnableC0218a(settingsBaseFragment, str, preferencePositionCallback, recyclerView, 10), 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHighlight$lambda$9$lambda$8(SettingsBaseFragment settingsBaseFragment, String str, PreferenceGroup.PreferencePositionCallback preferencePositionCallback, RecyclerView recyclerView) {
        Preference preferenceFindPreference = settingsBaseFragment.findPreference(str);
        if (preferenceFindPreference == null) {
            return;
        }
        int preferenceAdapterPosition = preferencePositionCallback.getPreferenceAdapterPosition(preferenceFindPreference);
        Logger.m10999d(TAG, "applyHighlight, post, realPosition, " + preferenceAdapterPosition);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(preferenceAdapterPosition);
        if (viewHolderFindViewHolderForAdapterPosition == null) {
            viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(preferenceAdapterPosition - 1);
        }
        if (viewHolderFindViewHolderForAdapterPosition == null) {
            return;
        }
        View itemView = viewHolderFindViewHolderForAdapterPosition.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        if (itemView.getBackground() != null) {
            itemView.getBackground().setHotspot(itemView.getWidth() / 2, itemView.getHeight() / 2);
        }
        itemView.setPressed(true);
        itemView.postDelayed(new RunnableC4587a(itemView, 10), DELAY_HIGHLIGHT_END_DURATION_MILLIS);
    }

    private final FloatingBottomLayout getFloatingBottomLayout() {
        return null;
    }

    private final boolean isCallFromOtherApps(boolean includeTips) {
        return includeTips ? Intrinsics.areEqual(getCallee(), SettingsConstants.CALLEE_TIPS) : Intrinsics.areEqual(getCallee(), SettingsConstants.CALLEE_NONE);
    }

    public static /* synthetic */ boolean isCallFromOtherApps$default(SettingsBaseFragment settingsBaseFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isCallFromOtherApps");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return settingsBaseFragment.isCallFromOtherApps(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateRecyclerView$lambda$0(RecyclerView recyclerView, SettingsBaseFragment settingsBaseFragment) {
        recyclerView.setBackgroundColor(settingsBaseFragment.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(DeviceInfo.isVSTModel() ? C8003R.color.settings_list_background_color_for_vst : C8003R.color.settings_list_background_color), null));
    }

    private final void registerWindowInsetManager() {
        if (CommonUtil.isNotAvailableActivity(getActivity())) {
            return;
        }
        if (this.mActivityContainer == null) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            this.mActivityContainer = activity.findViewById(C8003R.id.activity_container);
        }
        if (this.mActivityContainer != null) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            companion.getInstance().registerAnimationCallback(this.mActivityContainer, this.mAnimationCallback);
            companion.getInstance().registerApplyListener(this.mActivityContainer, this.mApplyInsetListener);
        }
    }

    private final void setFadingEdgeEnabled(boolean isEnabled) {
        RecyclerView listView = getListView();
        if (listView == null) {
            return;
        }
        listView.seslSetFadingEdgeEnabled(isEnabled);
        Context context = getContext();
        if (context != null) {
            listView.seslSetFadingEdgeColor(context.getColor(C8003R.color.window_background_color));
        }
    }

    private final void unregisterWindowInsetManager() {
        if (this.mActivityContainer != null) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            companion.getInstance().unregisterAnimationCallback(this.mActivityContainer);
            companion.getInstance().unregisterApplyListener(this.mActivityContainer);
        }
    }

    private final void updateDummyPreferenceForEdgeToEdge() {
        if (getContext() == null) {
            return;
        }
        boolean z = getResources().getConfiguration().orientation == 2;
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        WindowManagerCompat companion2 = companion.getInstance();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
        boolean zIsPopOver = companion2.isPopOver(activity);
        boolean z2 = companion.getInstance().getMultiWindowMode(getResources().getConfiguration()) == 0;
        PreferenceCategory preferenceCategory = (PreferenceCategory) getPreferenceScreen().findPreference(KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE1);
        PreferenceCategory preferenceCategory2 = (PreferenceCategory) getPreferenceScreen().findPreference(KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE2);
        if (!z2 || z || zIsPopOver) {
            if (preferenceCategory != null) {
                getPreferenceScreen().removePreference(preferenceCategory);
            }
            if (preferenceCategory2 != null) {
                getPreferenceScreen().removePreference(preferenceCategory2);
                return;
            }
            return;
        }
        if (preferenceCategory == null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            PreferenceCategory preferenceCategory3 = new PreferenceCategory(context);
            preferenceCategory3.setKey(KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE1);
            getPreferenceScreen().addPreference(preferenceCategory3);
        }
        if (preferenceCategory2 == null) {
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2);
            PreferenceCategory preferenceCategory4 = new PreferenceCategory(context2);
            preferenceCategory4.setKey(KEY_DUMMY_PREF_CATEGORY_FOR_EDGE_TO_EDGE2);
            getPreferenceScreen().addPreference(preferenceCategory4);
        }
    }

    private final void updateListForMobile() {
        View view;
        if (isAdded() && (view = getView()) != null) {
            view.setPadding(0, 0, 0, 0);
            RecyclerView listView = getListView();
            if (listView == null) {
                return;
            }
            listView.seslSetFadingEdgeEnabled(true);
            Context applicationContext = BaseUtils.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext);
            listView.seslSetFadingEdgeColor(applicationContext.getColor(C8003R.color.window_background_color));
            view.post(new RunnableC8760a(this, view, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateListForMobile$lambda$6$lambda$5(SettingsBaseFragment settingsBaseFragment, View view) {
        if (settingsBaseFragment.isAdded()) {
            int spaceForFlexibleSpacing = DisplayUtils.getSpaceForFlexibleSpacing(view);
            RecyclerView listView = settingsBaseFragment.getListView();
            if (listView == null) {
                return;
            }
            listView.setPaddingRelative(spaceForFlexibleSpacing, 0, spaceForFlexibleSpacing, 0);
            ViewCompat.Companion companion = ViewCompat.INSTANCE;
            ViewCompat companion2 = companion.getInstance();
            Pair<Integer, Integer> pairCreate = Pair.create(Integer.valueOf(listView.getPaddingStart()), Integer.valueOf(listView.getPaddingEnd()));
            Intrinsics.checkNotNullExpressionValue(pairCreate, "create(...)");
            companion2.setRoundedCorners(listView, 12, pairCreate);
            companion.getInstance().setRoundedCornerColor(listView, 12, settingsBaseFragment.getResources().getColor(C8003R.color.window_background_color, null));
        }
    }

    private final void updateListForVst() {
        View view = getView();
        if (view != null) {
            view.post(new RunnableC8760a(this, view, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateListForVst$lambda$4$lambda$3(SettingsBaseFragment settingsBaseFragment, View view) {
        DisplayUtils.updateViewPaddingByFlexibleSpacingForVst(settingsBaseFragment.getActivity(), view, isCallFromOtherApps$default(settingsBaseFragment, false, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateListView() {
        if (this.mActivityContainer != null) {
            if (DeviceInfo.isVSTModel()) {
                WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(this.mActivityContainer);
                updateListForVst();
                return;
            }
            updateListForMobile();
            if (!WidgetInsetUtils.getCanUseWindowInsets()) {
                WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(this.mActivityContainer);
                return;
            }
            FragmentActivity activity = getActivity();
            Window window = activity != null ? activity.getWindow() : null;
            View view = this.mActivityContainer;
            RecyclerView listView = getListView();
            FragmentActivity activity2 = getActivity();
            AppBarLayout appBarLayout = activity2 != null ? (AppBarLayout) activity2.findViewById(C8003R.id.appbar_layout) : null;
            FragmentActivity activity3 = getActivity();
            WidgetInsetUtils.applyWindowInsetsForSetting(window, view, listView, appBarLayout, activity3 != null ? (FloatingToolbarLayout) activity3.findViewById(C8003R.id.sesl_floating_toolbar_layout) : null, getFloatingBottomLayout());
            updateDummyPreferenceForEdgeToEdge();
        }
    }

    public final boolean compareIntentAction(@NotNull String actionConstant) {
        Intent intent;
        Intrinsics.checkNotNullParameter(actionConstant, "actionConstant");
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return Intrinsics.areEqual(actionConstant, intent.getAction());
    }

    @NotNull
    public final String getCallee() {
        if (this.mCallee == null) {
            if (getArguments() == null) {
                return SettingsConstants.CALLEE_COMPOSER;
            }
            this.mCallee = requireArguments().getString(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_SETTINGS);
        }
        String str = this.mCallee;
        return str == null ? SettingsConstants.CALLEE_SETTINGS : str;
    }

    /* JADX INFO: renamed from: getHasFocus, reason: from getter */
    public final boolean getMHasFocus() {
        return this.mHasFocus;
    }

    @Nullable
    public final Contract getMContract() {
        return this.mContract;
    }

    public final boolean isMsSignInRequested() {
        return compareIntentAction(Constants.ACTION_START_MS_SETTINGS);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateListView();
        setFadingEdgeEnabled(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mHighlightKey = requireArguments().getString(SettingsConstants.KEY_TARGET_PREFERENCE);
        }
        registerWindowInsetManager();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    @NotNull
    public RecyclerView onCreateRecyclerView(@NotNull LayoutInflater inflater, @NotNull ViewGroup parent, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView recyclerViewOnCreateRecyclerView = super.onCreateRecyclerView(inflater, parent, savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(recyclerViewOnCreateRecyclerView, "onCreateRecyclerView(...)");
        recyclerViewOnCreateRecyclerView.post(new RunnableC8515c(recyclerViewOnCreateRecyclerView, this, 4));
        return recyclerViewOnCreateRecyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterWindowInsetManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateListView();
        applyHighlight(this.mHighlightKey);
        this.mHighlightKey = null;
        setFadingEdgeEnabled(true);
    }

    public final void onWindowFocusChanged(boolean hasFocus) {
        this.mHasFocus = hasFocus;
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void setMContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void showSettingsConfirmDialog(int type, @NotNull SettingsConfirmDialogFragment.DialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        SettingsConfirmDialogFragment settingsConfirmDialogFragment = new SettingsConfirmDialogFragment(type);
        settingsConfirmDialogFragment.setDialogListener(dialogListener);
        settingsConfirmDialogFragment.showAllowingStateLoss(getChildFragmentManager(), SettingsConfirmDialogFragment.TAG);
    }

    public final void startSettingsActivity(@NotNull String preferenceKey) {
        Intrinsics.checkNotNullParameter(preferenceKey, "preferenceKey");
        Contract contract = this.mContract;
        if (contract != null) {
            contract.startSettingsActivity(preferenceKey);
        }
    }

    public final void swapOtherFragment(int fragmentType) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.swapSettingFragment(fragmentType);
        }
    }
}
