package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.cms.ExternalLinkUtil;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\u001a\u001d \u0018\u0000 32\u00020\u0001:\u00013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B;\b\u0016\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u0014J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010%H\u0016J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0016R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010+\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "targetUuids", "", "", "isConvertAll", "", "hasConvertedNotes", "isConvertedNotesMissed", "lockedNotesCount", "", "(Ljava/util/List;ZZZI)V", "mTargetUuids", "mIsConvertAll", "mHasConvertedNotes", "mIsConvertedNotesMissed", "mLockedNotesCount", "mContract", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/dialog/DialogViewContract$IConvertDialog;", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "mConvertedNoteOption", "Landroid/widget/RadioGroup;", "mRequestConvertClickListener", "com/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment$mRequestConvertClickListener$1", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment$mRequestConvertClickListener$1;", "mRequestCancelClickListener", "com/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment$mRequestCancelClickListener$1", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment$mRequestCancelClickListener$1;", "mRequestDeleteClickListener", "com/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment$mRequestDeleteClickListener$1", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/ConvertConfirmDialogFragment$mRequestDeleteClickListener$1;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "setContract", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "titleResId", "getTitleResId", "()I", "messageResId", "getMessageResId", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConvertConfirmDialogFragment extends DialogFragment {

    @NotNull
    public static final String KEY_HAS_CONVERTED_NOTES = "key_has_converted_notes";

    @NotNull
    public static final String KEY_IS_CONVERTED_NOTES_MISSED = "key_is_converted_notes_missed";

    @NotNull
    public static final String KEY_IS_CONVERT_ALL = "key_is_convert_all";

    @NotNull
    public static final String KEY_LOCKED_NOTES_COUNT = "key_locked_notes_count";

    @NotNull
    public static final String KEY_TARGET_UUIDS = "key_target_uuids";

    @Nullable
    private AlertDialog mAlertDialog;

    @Nullable
    private DialogViewContract.IConvertDialog mContract;

    @Nullable
    private RadioGroup mConvertedNoteOption;
    private boolean mHasConvertedNotes;
    private boolean mIsConvertAll;
    private boolean mIsConvertedNotesMissed;
    private int mLockedNotesCount;

    @NotNull
    private final ConvertConfirmDialogFragment$mRequestCancelClickListener$1 mRequestCancelClickListener;

    @NotNull
    private final ConvertConfirmDialogFragment$mRequestConvertClickListener$1 mRequestConvertClickListener;

    @NotNull
    private final ConvertConfirmDialogFragment$mRequestDeleteClickListener$1 mRequestDeleteClickListener;

    @Nullable
    private List<String> mTargetUuids;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestConvertClickListener$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestCancelClickListener$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestDeleteClickListener$1] */
    public ConvertConfirmDialogFragment() {
        this.mTargetUuids = new ArrayList();
        this.mRequestConvertClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestConvertClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                RadioGroup radioGroup;
                CommonSamsungAnalytics.INSTANCE.insertLog("764", "7910");
                boolean z = this.this$0.mIsConvertAll && this.this$0.mHasConvertedNotes && (radioGroup = this.this$0.mConvertedNoteOption) != null && radioGroup.getCheckedRadioButtonId() == C8003R.id.converted_note_skip_option;
                DialogViewContract.IConvertDialog iConvertDialog = this.this$0.mContract;
                if (iConvertDialog != null) {
                    iConvertDialog.requestConvertOldNotes(this.this$0.mTargetUuids, z);
                }
                this.this$0.dismissAllowingStateLoss();
            }
        };
        this.mRequestCancelClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestCancelClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CommonSamsungAnalytics.INSTANCE.insertLog("764", "7909");
                DialogViewContract.IConvertDialog iConvertDialog = this.this$0.mContract;
                if (iConvertDialog != null) {
                    iConvertDialog.onCancel();
                }
                this.this$0.dismissAllowingStateLoss();
            }
        };
        this.mRequestDeleteClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestDeleteClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DialogViewContract.IConvertDialog iConvertDialog = this.this$0.mContract;
                if (iConvertDialog != null) {
                    iConvertDialog.onDelete(this.this$0.mTargetUuids, this.this$0.mLockedNotesCount > 0);
                }
                this.this$0.dismissAllowingStateLoss();
            }
        };
    }

    private final int getMessageResId() {
        return this.mIsConvertedNotesMissed ? C8003R.string.converted_note_missing_msg : (this.mHasConvertedNotes && this.mIsConvertAll) ? C8003R.string.convert_old_note_again_msg : C8003R.string.convert_old_note_dialog_msg;
    }

    private final int getTitleResId() {
        if (this.mIsConvertedNotesMissed) {
            return C8003R.string.converted_note_missing_q;
        }
        if (this.mHasConvertedNotes) {
            return C8003R.string.convert_old_note_again_q;
        }
        if (this.mIsConvertAll) {
            return C8003R.string.convert_all_your_old_format_notes_q;
        }
        List<String> list = this.mTargetUuids;
        return (list == null || list.size() != 1) ? C8003R.string.convert_selected_notes_q : C8003R.string.convert_this_note_q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1$lambda$0(ConvertConfirmDialogFragment convertConfirmDialogFragment, View view) {
        convertConfirmDialogFragment.dismissAllowingStateLoss();
        DialogViewContract.IConvertDialog iConvertDialog = convertConfirmDialogFragment.mContract;
        if (iConvertDialog != null) {
            iConvertDialog.requestMoveToConvertedNotes();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        DialogViewContract.IConvertDialog iConvertDialog = this.mContract;
        if (iConvertDialog != null) {
            iConvertDialog.onCancel();
        }
        super.onCancel(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mTargetUuids = savedInstanceState.getStringArrayList(KEY_TARGET_UUIDS);
            this.mIsConvertAll = savedInstanceState.getBoolean(KEY_IS_CONVERT_ALL);
            this.mHasConvertedNotes = savedInstanceState.getBoolean(KEY_HAS_CONVERTED_NOTES);
            this.mIsConvertedNotesMissed = savedInstanceState.getBoolean(KEY_IS_CONVERTED_NOTES_MISSED);
            this.mLockedNotesCount = savedInstanceState.getInt(KEY_LOCKED_NOTES_COUNT);
        }
        String string = getResources().getString(getTitleResId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(getMessageResId());
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 0;
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.convert_confirm_dialog_layout, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.confirm_message);
        if (textView != null) {
            textView.setText(string2);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(C8003R.id.link_data);
        int i2 = 8;
        if (textView2 != null) {
            if (this.mHasConvertedNotes && this.mIsConvertAll) {
                textView2.setOnClickListener(new ViewOnClickListenerC8556a(this, 3));
                SpannableString spannableString = new SpannableString(getResources().getString(C8003R.string.convert_old_note_again_link));
                spannableString.setSpan(ExternalLinkUtil.getLinkTypefaceSpan(), 0, spannableString.length(), 33);
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(textView2.getContext().getColor(C8003R.color.convert_confirm_dialog_link_color)), 0, spannableString.length(), 33);
                textView2.setText(spannableString);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(C8003R.id.converted_note_option);
        this.mConvertedNoteOption = radioGroup;
        if (radioGroup != null) {
            if (this.mIsConvertAll && this.mHasConvertedNotes) {
                i2 = 0;
            }
            radioGroup.setVisibility(i2);
        }
        AlertDialog.Builder cancelable = new AlertDialogBuilderForAppCompat(getActivity(), i, 2, defaultConstructorMarker).setTitle(string).setView(viewInflate).setCancelable(true);
        if (!this.mHasConvertedNotes || this.mIsConvertAll) {
            cancelable.setPositiveButton(C8003R.string.convert, this.mRequestConvertClickListener).setNegativeButton(C8003R.string.dialog_cancel, this.mRequestCancelClickListener);
        } else {
            cancelable.setPositiveButton(C8003R.string.convert, this.mRequestConvertClickListener).setNegativeButton(C8003R.string.dialog_delete, this.mRequestDeleteClickListener).setNeutralButton(C8003R.string.dialog_cancel, this.mRequestCancelClickListener);
        }
        AlertDialog alertDialogCreate = cancelable.create();
        this.mAlertDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment.onCreateDialog.2
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    DialogViewContract.IConvertDialog iConvertDialog;
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (keyCode != 4 || event.getAction() != 1 || (iConvertDialog = ConvertConfirmDialogFragment.this.mContract) == null) {
                        return false;
                    }
                    iConvertDialog.onBackPressed();
                    return false;
                }
            });
        }
        AlertDialog alertDialog = this.mAlertDialog;
        Intrinsics.checkNotNull(alertDialog);
        return alertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(KEY_TARGET_UUIDS, (ArrayList) this.mTargetUuids);
        outState.putBoolean(KEY_IS_CONVERT_ALL, this.mIsConvertAll);
        outState.putBoolean(KEY_HAS_CONVERTED_NOTES, this.mHasConvertedNotes);
        outState.putBoolean(KEY_IS_CONVERTED_NOTES_MISSED, this.mIsConvertedNotesMissed);
        outState.putInt(KEY_LOCKED_NOTES_COUNT, this.mLockedNotesCount);
    }

    public final void setContract(@Nullable DialogViewContract.IConvertDialog listener) {
        this.mContract = listener;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestConvertClickListener$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestCancelClickListener$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestDeleteClickListener$1] */
    public ConvertConfirmDialogFragment(@Nullable List<String> list, boolean z, boolean z2, boolean z3, int i) {
        this.mTargetUuids = new ArrayList();
        this.mRequestConvertClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestConvertClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                RadioGroup radioGroup;
                CommonSamsungAnalytics.INSTANCE.insertLog("764", "7910");
                boolean z4 = this.this$0.mIsConvertAll && this.this$0.mHasConvertedNotes && (radioGroup = this.this$0.mConvertedNoteOption) != null && radioGroup.getCheckedRadioButtonId() == C8003R.id.converted_note_skip_option;
                DialogViewContract.IConvertDialog iConvertDialog = this.this$0.mContract;
                if (iConvertDialog != null) {
                    iConvertDialog.requestConvertOldNotes(this.this$0.mTargetUuids, z4);
                }
                this.this$0.dismissAllowingStateLoss();
            }
        };
        this.mRequestCancelClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestCancelClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CommonSamsungAnalytics.INSTANCE.insertLog("764", "7909");
                DialogViewContract.IConvertDialog iConvertDialog = this.this$0.mContract;
                if (iConvertDialog != null) {
                    iConvertDialog.onCancel();
                }
                this.this$0.dismissAllowingStateLoss();
            }
        };
        this.mRequestDeleteClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment$mRequestDeleteClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DialogViewContract.IConvertDialog iConvertDialog = this.this$0.mContract;
                if (iConvertDialog != null) {
                    iConvertDialog.onDelete(this.this$0.mTargetUuids, this.this$0.mLockedNotesCount > 0);
                }
                this.this$0.dismissAllowingStateLoss();
            }
        };
        this.mTargetUuids = list;
        this.mIsConvertAll = z;
        this.mHasConvertedNotes = z2;
        this.mIsConvertedNotesMissed = z3;
        this.mLockedNotesCount = i;
    }
}
