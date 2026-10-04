package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.task.CoeditSpaceThumbnailTask;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;
import p075S.AbstractC0256h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditFirstJoinDialogFragment extends AbsDialogFragment implements DialogInterface.OnClickListener {
    public static final String TAG = "CoeditFirstJoinDialogFragment";
    private static final Executor THUMBNAIL_EXECUTOR = AbstractC4539a.m3201k(TAG);
    private int mDescriptionID;
    private DialogResultListener mDialogResultListener;
    private int mMessageResID;
    private int mTitleID;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DialogResultListener {
        void onDecline();

        void onJoin();
    }

    public CoeditFirstJoinDialogFragment() {
        this.mTitleID = C8003R.string.gcs_invitations_join_dialog_title;
        this.mDescriptionID = C8003R.string.gcs_invitations_join_shared_note_dialog_body_1;
        this.mMessageResID = C8003R.string.gcs_invitations_join_shared_note_dialog_body_2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.mDialogResultListener.onDecline();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.mDialogResultListener.onJoin();
        } else {
            this.mDialogResultListener.onDecline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e2  */
    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        TextView textView;
        TextView textView2;
        Bundle bundleCall;
        super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mTitleID = bundle.getInt(NotesConstants.DialogTag.KEY_SINGLE_MESSAGE);
            this.mDescriptionID = bundle.getInt(NotesConstants.DialogTag.KEY_DESCRIPTION_ID);
            this.mMessageResID = bundle.getInt("message_id");
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setTitle(this.mTitleID).setMessage(getString(this.mDescriptionID)).setCancelable(false).setPositiveButton(C8003R.string.base_string_join, this).setNegativeButton(C8003R.string.dialog_cancel, this).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (this.mMessageResID != 0) {
            String strM542b = AbstractC0256h.m542b();
            try {
                ContentResolver contentResolver = getContext().getContentResolver();
                bundleCall = Build.VERSION.SDK_INT >= 29 ? contentResolver.call("com.samsung.android.mobileservice.profileProvider", "getProfile", (String) null, (Bundle) null) : contentResolver.call(Uri.parse("content://com.samsung.android.mobileservice.profileProvider"), "getProfile", (String) null, (Bundle) null);
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("getUserImageFromProvider exception "), "SesCoeditProfileApi");
            }
            if (bundleCall != null) {
                Uri uri = !bundleCall.getBoolean("isSingleDataEmpty") ? Uri.parse(((ContentValues) bundleCall.getParcelable("singleData")).getAsString("profile_image_file_uri")) : null;
                if (uri != null) {
                    string = uri.toString();
                }
                CoeditResolverContract.MemberInfo memberInfo = new CoeditResolverContract.MemberInfo("", strM542b, "", string, 0L, 0, "");
                View viewInflate = alertDialogCreate.getLayoutInflater().inflate(C8003R.layout.first_join_dialog_layout, (ViewGroup) null);
                ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(C8003R.id.user_thumbnail);
                textView = (TextView) viewInflate.findViewById(C8003R.id.user_name);
                if (textView != null) {
                    textView.setText(strM542b);
                }
                textView2 = (TextView) viewInflate.findViewById(C8003R.id.message2);
                if (textView2 != null) {
                    textView2.setText(getString(this.mMessageResID));
                }
                alertDialogCreate.setView(viewInflate);
                new CoeditSpaceThumbnailTask(viewGroup, Collections.singletonList(memberInfo)).executeOnExecutor(THUMBNAIL_EXECUTOR, new Void[0]);
            }
            string = null;
            CoeditResolverContract.MemberInfo memberInfo2 = new CoeditResolverContract.MemberInfo("", strM542b, "", string, 0L, 0, "");
            View viewInflate2 = alertDialogCreate.getLayoutInflater().inflate(C8003R.layout.first_join_dialog_layout, (ViewGroup) null);
            ViewGroup viewGroup2 = (ViewGroup) viewInflate2.findViewById(C8003R.id.user_thumbnail);
            textView = (TextView) viewInflate2.findViewById(C8003R.id.user_name);
            if (textView != null) {
            }
            textView2 = (TextView) viewInflate2.findViewById(C8003R.id.message2);
            if (textView2 != null) {
            }
            alertDialogCreate.setView(viewInflate2);
            new CoeditSpaceThumbnailTask(viewGroup2, Collections.singletonList(memberInfo2)).executeOnExecutor(THUMBNAIL_EXECUTOR, new Void[0]);
        }
        return alertDialogCreate;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("title_id", this.mTitleID);
        bundle.putInt(NotesConstants.DialogTag.KEY_DESCRIPTION_ID, this.mDescriptionID);
        bundle.putInt("message_id", this.mMessageResID);
    }

    public void setResultListener(DialogResultListener dialogResultListener) {
        this.mDialogResultListener = dialogResultListener;
    }

    public CoeditFirstJoinDialogFragment(int i, int i2, int i4) {
        this.mTitleID = i;
        this.mDescriptionID = i2;
        this.mMessageResID = i4;
    }
}
