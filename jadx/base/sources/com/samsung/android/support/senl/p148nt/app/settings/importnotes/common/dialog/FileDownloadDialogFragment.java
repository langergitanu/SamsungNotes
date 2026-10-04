package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.ImportDialogResultListener;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/FileDownloadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "<init>", "()V", "mResultListener", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/ImportDialogResultListener$Downloading;", "setData", "", "appName", "", "type", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", ExternalDataConstants.Column.BODY_TEXT, "getBodyText", "()Ljava/lang/String;", "setOnResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onClick", "dialog", "Landroid/content/DialogInterface;", "which", "", "onCancel", "onDismiss", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FileDownloadDialogFragment extends DialogFragment implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

    @NotNull
    private static final String KEY_APP_NAME = "key_app_name";

    @NotNull
    public static final String TAG = "FileDownloadDialogFragment";

    @Nullable
    private ImportDialogResultListener.Downloading mResultListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DocTypeConstants> entries$0 = EnumEntriesKt.enumEntries(DocTypeConstants.values());
    }

    private final String getBodyText() {
        DocTypeConstants docTypeConstants = EntriesMappings.entries$0.get(requireArguments().getInt(ImportConstants.KEY_TYPE));
        String string = requireArguments().getString(KEY_APP_NAME);
        if (docTypeConstants == DocTypeConstants.SNOTE_LOCAL || docTypeConstants == DocTypeConstants.MEMO_LOCAL || docTypeConstants == DocTypeConstants.SDOC) {
            String string2 = getString(C8003R.string.settings_import_loading_contents_list_from_device, string);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        if (docTypeConstants == DocTypeConstants.SNOTE_GOOGLEDRIVE) {
            String string3 = getString(C8003R.string.settings_import_loading_contents_list_from_google_drive, string);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
        String string4 = getString(C8003R.string.settings_import_downloading_dialog_body, string);
        Intrinsics.checkNotNull(string4);
        return string4;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        CommonSamsungAnalytics.INSTANCE.insertLog("717", "7171");
        ImportDialogResultListener.Downloading downloading = this.mResultListener;
        if (downloading != null) {
            downloading.onCancel();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(@NotNull DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        ImportDialogResultListener.Downloading downloading = this.mResultListener;
        if (downloading != null) {
            downloading.onCancel();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).setTitle(C8003R.string.settings_import_downloading_dialog_title).setNegativeButton(C8003R.string.dialog_cancel, this).setCancelable(true).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCanceledOnTouchOutside(false);
        try {
            View viewInflate = getLayoutInflater().inflate(C8003R.layout.notes_progress_text_view, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(C8003R.id.progress_text_view);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) viewFindViewById).setText(getBodyText());
            alertDialogCreate.setView(viewInflate);
            return alertDialogCreate;
        } catch (Resources.NotFoundException e) {
            AbstractC6670b.m4738C("onCreateDialog, NotFoundException: ", e.getMessage(), TAG);
            alertDialogCreate.setMessage(getBodyText());
            return alertDialogCreate;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ImportDialogResultListener.Downloading downloading = this.mResultListener;
        if (downloading != null) {
            downloading.onDismiss();
        }
    }

    public final void setData(@Nullable String appName, @NotNull DocTypeConstants type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Bundle bundle = new Bundle();
        bundle.putString(KEY_APP_NAME, appName);
        bundle.putInt(ImportConstants.KEY_TYPE, type.ordinal());
        setArguments(bundle);
    }

    public final void setOnResultListener(@Nullable ImportDialogResultListener.Downloading listener) {
        this.mResultListener = listener;
    }
}
