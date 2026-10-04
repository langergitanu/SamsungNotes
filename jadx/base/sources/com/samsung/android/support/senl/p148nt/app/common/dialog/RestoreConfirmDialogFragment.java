package com.samsung.android.support.senl.p148nt.app.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/dialog/RestoreConfirmDialogFragment;", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsDialogFragment;", "mUuid", "", "mRestoredDate", "", "mIsAvailable", "", "<init>", "(Ljava/lang/String;JZ)V", "mDialogListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/RestoreConfirmDialogFragment$DialogListener;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "setDialogListener", "dialogListener", DynamicActionBarProvider.METHOD_GET_DATA, "getMessage", "setPositiveButtonText", "setSavedNoteDate", "restoredDate", "DialogListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RestoreConfirmDialogFragment extends AbsDialogFragment {

    @NotNull
    private static final String TAG = "RestoreConfirmDialogFragment";

    @Nullable
    private DialogListener mDialogListener;
    private boolean mIsAvailable;
    private long mRestoredDate;

    @NotNull
    private String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/dialog/RestoreConfirmDialogFragment$DialogListener;", "", "onPositiveButton", "", "uuid", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DialogListener {
        void onPositiveButton(@Nullable String uuid);
    }

    public RestoreConfirmDialogFragment(@NotNull String mUuid, long j, boolean z) {
        Intrinsics.checkNotNullParameter(mUuid, "mUuid");
        this.mUuid = mUuid;
        this.mRestoredDate = j;
        this.mIsAvailable = z;
    }

    private final String getMessage() {
        if (this.mIsAvailable) {
            String string = getString(C8003R.string.restore_corrupt_note_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return AbstractC2322a.m1624n(string, new Object[]{setSavedNoteDate(this.mRestoredDate)}, 1, "format(...)");
        }
        String string2 = getString(C8003R.string.restore_corrupt_note_unavailable_message);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    private final String getTitle() {
        if (this.mIsAvailable) {
            String string = getString(C8003R.string.restore_corrupt_note_title);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = getString(C8003R.string.restore_corrupt_note_unavailable_title);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(RestoreConfirmDialogFragment restoreConfirmDialogFragment, DialogInterface dialogInterface, int i) {
        CommonSamsungAnalytics.INSTANCE.insertLog("101", NotesSAConstants.EVENT_RESTORE_NOTE_BY_LAST_VERSION, "c");
        restoreConfirmDialogFragment.dismiss();
        if (restoreConfirmDialogFragment.mDialogListener == null) {
            MainLogger.m7255e(TAG, "onCreateDialog: DialogListener is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(RestoreConfirmDialogFragment restoreConfirmDialogFragment, DialogInterface dialogInterface, int i) {
        restoreConfirmDialogFragment.dismiss();
        DialogListener dialogListener = restoreConfirmDialogFragment.mDialogListener;
        if (dialogListener == null) {
            MainLogger.m7255e(TAG, "onCreateDialog: DialogListener is null");
        } else {
            dialogListener.onPositiveButton(restoreConfirmDialogFragment.mUuid);
        }
    }

    private final String setPositiveButtonText() {
        if (this.mIsAvailable) {
            String string = getString(C8003R.string.action_restore);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = getString(C8003R.string.action_delete);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    private final String setSavedNoteDate(long restoredDate) {
        return ContentUtils.getDate(getContext(), restoredDate);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String string = savedInstanceState.getString("sdocx_uuid", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.mUuid = string;
            this.mRestoredDate = savedInstanceState.getLong(NotesConstants.DialogTag.KEY_SERVER_SAVED_DATE);
            this.mIsAvailable = savedInstanceState.getBoolean(NotesConstants.DialogTag.KEY_IS_RESTORE_AVAILABLE);
        }
        if (this.mUuid.length() == 0) {
            MainLogger.m7255e(TAG, "note uuid is empty");
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).create();
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setTitle(getTitle());
        alertDialogCreate.setMessage(getMessage());
        final int i = 0;
        alertDialogCreate.setButton(-2, getString(C8003R.string.dialog_cancel), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.common.dialog.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RestoreConfirmDialogFragment f6068b;

            {
                this.f6068b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        RestoreConfirmDialogFragment.onCreateDialog$lambda$0(this.f6068b, dialogInterface, i2);
                        break;
                    default:
                        RestoreConfirmDialogFragment.onCreateDialog$lambda$1(this.f6068b, dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        alertDialogCreate.setButton(-1, setPositiveButtonText(), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.common.dialog.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RestoreConfirmDialogFragment f6068b;

            {
                this.f6068b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        RestoreConfirmDialogFragment.onCreateDialog$lambda$0(this.f6068b, dialogInterface, i22);
                        break;
                    default:
                        RestoreConfirmDialogFragment.onCreateDialog$lambda$1(this.f6068b, dialogInterface, i22);
                        break;
                }
            }
        });
        return alertDialogCreate;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("sdocx_uuid", this.mUuid);
        outState.putLong(NotesConstants.DialogTag.KEY_SERVER_SAVED_DATE, this.mRestoredDate);
        outState.putBoolean(NotesConstants.DialogTag.KEY_IS_RESTORE_AVAILABLE, this.mIsAvailable);
    }

    public final void setDialogListener(@Nullable DialogListener dialogListener) {
        this.mDialogListener = dialogListener;
    }
}
