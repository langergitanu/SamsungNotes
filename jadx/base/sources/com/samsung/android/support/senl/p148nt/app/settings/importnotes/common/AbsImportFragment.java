package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportViewContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/AbsImportFragment;", "Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;", "<init>", "()V", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setBackPressedListener", "onStart", "onStop", "prepareOptionsMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "handleOptionsItemSelected", "item", "Landroid/view/MenuItem;", "getFragment", "getTAG", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsImportFragment extends AbsFragment implements ImportViewContract {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private OnBackPressedCallback backPressedCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/AbsImportFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/AbsImportFragment;", "mode", "", "accountName", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AbsImportFragment newInstance(int mode, @Nullable String accountName) {
            AbsImportFragment absImportFragment = new AbsImportFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ImportConstants.KEY_TYPE, mode);
            if (accountName != null) {
                bundle.putString("account_name", accountName);
            }
            absImportFragment.setArguments(bundle);
            return absImportFragment;
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final AbsImportFragment newInstance(int mode) {
            AbsImportFragment absImportFragment = new AbsImportFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ImportConstants.KEY_TYPE, mode);
            absImportFragment.setArguments(bundle);
            return absImportFragment;
        }
    }

    @JvmStatic
    @NotNull
    public static final AbsImportFragment newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    private final void setBackPressedListener() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.common.AbsImportFragment.setBackPressedListener.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                setEnabled(false);
                FragmentActivity activity = AbsImportFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        };
        this.backPressedCallback = onBackPressedCallback;
        FragmentActivity activity = getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportViewContract
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return getActivity();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportViewContract
    @NotNull
    public AbsFragment getFragment() {
        return this;
    }

    @NotNull
    public String getTAG() {
        return "ST$AbsImportFragment";
    }

    public boolean handleOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C8003R.layout.import_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainLogger.m7258i(getTAG(), "onStart()");
        OnBackPressedCallback onBackPressedCallback = this.backPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MainLogger.m7258i(getTAG(), "onStop()");
        OnBackPressedCallback onBackPressedCallback = this.backPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MainLogger.m7258i(getTAG(), "onViewCreated");
        setBackPressedListener();
    }

    public boolean prepareOptionsMenu(@Nullable Menu menu) {
        return true;
    }

    @JvmStatic
    @NotNull
    public static final AbsImportFragment newInstance(int i, @Nullable String str) {
        return INSTANCE.newInstance(i, str);
    }
}
