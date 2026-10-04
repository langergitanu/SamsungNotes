package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ImportMultiplePdfDialogFragment extends AbsDialogFragment implements DialogInterface.OnClickListener {
    private static final String KEY_FOLDER_UUID = "key_folder_uuid";
    private static final String KEY_PDF_URIS = "key_pdf_uris";
    private static final String KEY_TOOL_TYPE = "key_tool_type";
    public static final String TAG = "ImportMultiplePdfDialogFragment";
    private Contract mContract;
    private String mFolderUuid;
    private List<Uri> mPdfUris;
    private int mToolType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void importPdfOnOneNote(String str, int i, List<Uri> list);

        void importPdfOnSeparateNotes(String str, List<Uri> list);
    }

    public ImportMultiplePdfDialogFragment() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        if (-2 == i) {
            contract.importPdfOnOneNote(this.mFolderUuid, this.mToolType, this.mPdfUris);
        } else if (-1 == i) {
            contract.importPdfOnSeparateNotes(this.mFolderUuid, this.mPdfUris);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mFolderUuid = bundle.getString(KEY_FOLDER_UUID);
            this.mToolType = bundle.getInt(KEY_TOOL_TYPE);
            this.mPdfUris = bundle.getParcelableArrayList(KEY_PDF_URIS);
        }
        return new AlertDialogBuilderForAppCompat(getContext()).setMessage(C8003R.string.import_multi_pdf_msg).setCancelable(true).setNegativeButton(C8003R.string.import_multi_pdf_on_one_note, this).setNeutralButton(C8003R.string.cancel_btn, (DialogInterface.OnClickListener) null).setPositiveButton(C8003R.string.import_multi_pdf_on_separate_notes, this).create();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(KEY_FOLDER_UUID, this.mFolderUuid);
        bundle.putInt(KEY_TOOL_TYPE, this.mToolType);
        bundle.putParcelableArrayList(KEY_PDF_URIS, (ArrayList) this.mPdfUris);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.mFolderUuid = bundle.getString(KEY_FOLDER_UUID);
            this.mToolType = bundle.getInt(KEY_TOOL_TYPE);
            this.mPdfUris = bundle.getParcelableArrayList(KEY_PDF_URIS);
        }
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public ImportMultiplePdfDialogFragment(String str, int i, List<Uri> list) {
        this.mFolderUuid = str;
        this.mToolType = i;
        this.mPdfUris = list;
    }
}
