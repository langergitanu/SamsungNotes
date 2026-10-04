package com.samsung.android.support.senl.p148nt.app.settings.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.common.dialog.AllowAppPermissionDialogFragment;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/dialog/AllowAppPermissionDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mCallback", "Lcom/samsung/android/support/senl/nt/app/settings/common/dialog/AllowAppPermissionDialogFragment$AllowAppPermissionDialogCallback;", "setAllowAppPermissionDialogCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "permissionAlertMessage", "", "getPermissionAlertMessage", "()Ljava/lang/String;", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "AllowAppPermissionDialogCallback", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AllowAppPermissionDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "AllowAppPermissionDialogFragment";

    @Nullable
    private AllowAppPermissionDialogCallback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/dialog/AllowAppPermissionDialogFragment$AllowAppPermissionDialogCallback;", "", "onAppPermissionCancel", "", "onAppPermissionConfirm", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AllowAppPermissionDialogCallback {
        void onAppPermissionCancel();

        void onAppPermissionConfirm();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/dialog/AllowAppPermissionDialogFragment$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "newInstance", "Lcom/samsung/android/support/senl/nt/app/settings/common/dialog/AllowAppPermissionDialogFragment;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AllowAppPermissionDialogFragment newInstance() {
            return new AllowAppPermissionDialogFragment();
        }

        private Companion() {
        }
    }

    private final String getPermissionAlertMessage() {
        String string = getString(C8003R.string.app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C8003R.string.message_china_data_popup, string);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    @JvmStatic
    @NotNull
    public static final AllowAppPermissionDialogFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(AllowAppPermissionDialogFragment allowAppPermissionDialogFragment, DialogInterface dialogInterface, int i) {
        AllowAppPermissionDialogCallback allowAppPermissionDialogCallback = allowAppPermissionDialogFragment.mCallback;
        if (allowAppPermissionDialogCallback != null) {
            Intrinsics.checkNotNull(allowAppPermissionDialogCallback);
            allowAppPermissionDialogCallback.onAppPermissionCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(AllowAppPermissionDialogFragment allowAppPermissionDialogFragment, DialogInterface dialogInterface, int i) {
        AllowAppPermissionDialogCallback allowAppPermissionDialogCallback = allowAppPermissionDialogFragment.mCallback;
        if (allowAppPermissionDialogCallback != null) {
            Intrinsics.checkNotNull(allowAppPermissionDialogCallback);
            allowAppPermissionDialogCallback.onAppPermissionConfirm();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        AllowAppPermissionDialogCallback allowAppPermissionDialogCallback = this.mCallback;
        if (allowAppPermissionDialogCallback != null) {
            Intrinsics.checkNotNull(allowAppPermissionDialogCallback);
            allowAppPermissionDialogCallback.onAppPermissionCancel();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View viewInflate = getLayoutInflater().inflate(C8003R.layout.fragment_allow_app_permission_dialog, (ViewGroup) null);
        String permissionAlertMessage = getPermissionAlertMessage();
        View viewFindViewById = viewInflate.findViewById(C8003R.id.dialog_body_text);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setText(permissionAlertMessage);
        final int i = 0;
        final int i2 = 1;
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null).setNegativeButton(C8003R.string.permission_deny_button, new DialogInterface.OnClickListener(this) { // from class: T2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AllowAppPermissionDialogFragment f774b;

            {
                this.f774b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                switch (i) {
                    case 0:
                        AllowAppPermissionDialogFragment.onCreateDialog$lambda$0(this.f774b, dialogInterface, i4);
                        break;
                    default:
                        AllowAppPermissionDialogFragment.onCreateDialog$lambda$1(this.f774b, dialogInterface, i4);
                        break;
                }
            }
        }).setPositiveButton(C8003R.string.permission_allow_button, new DialogInterface.OnClickListener(this) { // from class: T2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AllowAppPermissionDialogFragment f774b;

            {
                this.f774b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                switch (i2) {
                    case 0:
                        AllowAppPermissionDialogFragment.onCreateDialog$lambda$0(this.f774b, dialogInterface, i4);
                        break;
                    default:
                        AllowAppPermissionDialogFragment.onCreateDialog$lambda$1(this.f774b, dialogInterface, i4);
                        break;
                }
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setView(viewInflate);
        return alertDialogCreate;
    }

    public final void setAllowAppPermissionDialogCallback(@Nullable AllowAppPermissionDialogCallback callback) {
        this.mCallback = callback;
    }

    public final void showAllowingStateLoss(@Nullable FragmentManager fragmentManager, @Nullable String tag) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(tag);
        if (dialogFragment == null || !dialogFragment.isAdded()) {
            fragmentManager.beginTransaction().add(this, tag).commitAllowingStateLoss();
        } else {
            Logger.m8697d(TAG, "showAllowingStateLoss# already added");
        }
    }
}
