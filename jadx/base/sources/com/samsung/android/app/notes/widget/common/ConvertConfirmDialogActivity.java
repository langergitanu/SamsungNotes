package com.samsung.android.app.notes.widget.common;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p054M1.DialogInterfaceOnClickListenerC0174a;
import p054M1.DialogInterfaceOnDismissListenerC0177d;
import p054M1.DialogInterfaceOnKeyListenerC0175b;
import p054M1.DialogInterfaceOnShowListenerC0176c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/common/ConvertConfirmDialogActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mUUid", "", "mPath", "mWidgetId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ConvertConfirmsDialogFragment", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConvertConfirmDialogActivity extends AppCompatActivity {
    public static final int $stable = 8;

    @Nullable
    private String mPath;

    @Nullable
    private String mUUid;
    private int mWidgetId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/common/ConvertConfirmDialogActivity$ConvertConfirmsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mListener", "Landroid/content/DialogInterface$OnClickListener;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "onPause", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nConvertConfirmDialogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConvertConfirmDialogActivity.kt\ncom/samsung/android/app/notes/widget/common/ConvertConfirmDialogActivity$ConvertConfirmsDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
    public static final class ConvertConfirmsDialogFragment extends DialogFragment {
        public static final int $stable = 8;

        @Nullable
        private DialogInterface.OnClickListener mListener;

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreateDialog$lambda$2(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCreateDialog$lambda$3(ConvertConfirmsDialogFragment convertConfirmsDialogFragment, DialogInterface dialogInterface) {
            Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
            AlertDialog alertDialog = (AlertDialog) dialogInterface;
            alertDialog.getButton(-2).setTextColor(convertConfirmsDialogFragment.getResources().getColor(C11391R.color.notes_primary_color, null));
            alertDialog.getButton(-1).setTextColor(convertConfirmsDialogFragment.getResources().getColor(C11391R.color.notes_primary_color, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCreateDialog$lambda$4(ConvertConfirmsDialogFragment convertConfirmsDialogFragment, DialogInterface dialogInterface) {
            if (convertConfirmsDialogFragment.getActivity() != null) {
                convertConfirmsDialogFragment.requireActivity().finish();
            }
        }

        @Override // androidx.fragment.app.Fragment
        @Nullable
        public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            if (getActivity() != null) {
                requireActivity().finish();
            }
            super.onPause();
        }

        public final void setListener(@Nullable DialogInterface.OnClickListener listener) {
            this.mListener = listener;
        }

        @Override // androidx.fragment.app.DialogFragment
        @NotNull
        public AlertDialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            if (getContext() == null) {
                throw new IllegalStateException(("ConvertConfirmsDialogFragment " + this + " not attached to a context.").toString());
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle(C11391R.string.convert_note_title).setMessage(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C11391R.string.convert_note_jp_desctiption : C11391R.string.convert_note_description).setPositiveButton(C11391R.string.base_convert, this.mListener).setNegativeButton(C11391R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0140a(1)).setOnKeyListener(new DialogInterfaceOnKeyListenerC0175b(0));
            AlertDialog alertDialogCreate = builder.create();
            Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
            int i = 0;
            alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC0176c(this, i));
            alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, i));
            return alertDialogCreate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ConvertConfirmsDialogFragment convertConfirmsDialogFragment, ConvertConfirmDialogActivity convertConfirmDialogActivity, DialogInterface dialogInterface, int i) {
        if (DocumentAccessHandler.getContract() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        DocumentAccessHandler.DocumentAccessContract contract = DocumentAccessHandler.getContract();
        if (contract != null) {
            Intent intent = new Intent(convertConfirmsDialogFragment.getActivity(), contract.getDocOpenTriggerClass());
            intent.setAction(WidgetConstant.ACTION_MEMO_CONVERT);
            intent.putExtra("sdoc_uuid", convertConfirmDialogActivity.mUUid);
            intent.putExtra("doc_path", convertConfirmDialogActivity.mPath);
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, convertConfirmDialogActivity.mWidgetId);
            intent.setFlags(402653184);
            convertConfirmDialogActivity.startActivity(intent);
        }
        dialogInterface.dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(8192);
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_CONVERT, getIntent().getAction())) {
            this.mUUid = getIntent().getStringExtra("sdoc_uuid");
            this.mPath = getIntent().getStringExtra("doc_path");
            if (TextUtils.isEmpty(this.mUUid)) {
                this.mUUid = BaseWidgetConstant.NONE;
            }
            if (TextUtils.isEmpty(this.mPath)) {
                this.mPath = BaseWidgetConstant.NONE;
            }
            this.mWidgetId = getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            ConvertConfirmsDialogFragment convertConfirmsDialogFragment = new ConvertConfirmsDialogFragment();
            convertConfirmsDialogFragment.setListener(new DialogInterfaceOnClickListenerC0174a(convertConfirmsDialogFragment, this, 0));
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.add(convertConfirmsDialogFragment, convertConfirmsDialogFragment.getTag()).commit();
        }
    }
}
