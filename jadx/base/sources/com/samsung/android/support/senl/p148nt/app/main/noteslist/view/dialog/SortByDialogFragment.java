package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p054M1.DialogInterfaceOnClickListenerC0174a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/SortByDialogFragment;", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsDialogFragment;", "<init>", "()V", NotesConstants.DialogTag.KEY_SORT_BY, "", "orderBy", "(II)V", "mSortBy", "mOrderBy", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SortByDialogFragment extends AbsDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SortByDialogFragment";
    private int mOrderBy;
    private int mSortBy;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/SortByDialogFragment$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG$annotations", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getTAG$annotations() {
        }

        private Companion() {
        }
    }

    public SortByDialogFragment() {
        this.mSortBy = 5;
        this.mOrderBy = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(DialogInterface dialogInterface, int i) {
        MainLogger.m7254d(TAG, "Cancel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(View view, SortByDialogFragment sortByDialogFragment, DialogInterface dialogInterface, int i) {
        int checkedRadioButtonId = ((RadioGroup) view.findViewById(C8003R.id.sortby_group)).getCheckedRadioButtonId();
        if (checkedRadioButtonId == C8003R.id.sortby_date_created_asc) {
            sortByDialogFragment.mSortBy = 1;
            sortByDialogFragment.mOrderBy = 4;
        } else if (checkedRadioButtonId == C8003R.id.sortby_date_created_desc) {
            sortByDialogFragment.mSortBy = 1;
            sortByDialogFragment.mOrderBy = 5;
        } else if (checkedRadioButtonId == C8003R.id.sortby_date_modified_asc) {
            sortByDialogFragment.mSortBy = 2;
            sortByDialogFragment.mOrderBy = 4;
        } else if (checkedRadioButtonId == C8003R.id.sortby_date_modified_desc) {
            sortByDialogFragment.mSortBy = 2;
            sortByDialogFragment.mOrderBy = 5;
        } else if (checkedRadioButtonId == C8003R.id.sortby_name_asc) {
            sortByDialogFragment.mSortBy = 0;
            sortByDialogFragment.mOrderBy = 4;
        } else if (checkedRadioButtonId == C8003R.id.sortby_name_desc) {
            sortByDialogFragment.mSortBy = 0;
            sortByDialogFragment.mOrderBy = 5;
        }
        NotesUtils.setSortType(sortByDialogFragment.mSortBy);
        NotesUtils.setOrderType(sortByDialogFragment.mOrderBy);
        MainLogger.m7254d(TAG, "Done - sortBy " + sortByDialogFragment.mSortBy + " / orderBy " + sortByDialogFragment.mOrderBy);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mSortBy = savedInstanceState.getInt(NotesConstants.DialogTag.KEY_SORT_BY);
            this.mOrderBy = savedInstanceState.getInt("orderBy");
        }
        View viewInflate = View.inflate(requireContext(), C8003R.layout.notes_sortby_dialog, null);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(C8003R.id.sortby_date_created_asc);
        RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(C8003R.id.sortby_date_created_desc);
        RadioButton radioButton3 = (RadioButton) viewInflate.findViewById(C8003R.id.sortby_date_modified_asc);
        RadioButton radioButton4 = (RadioButton) viewInflate.findViewById(C8003R.id.sortby_date_modified_desc);
        RadioButton radioButton5 = (RadioButton) viewInflate.findViewById(C8003R.id.sortby_name_asc);
        RadioButton radioButton6 = (RadioButton) viewInflate.findViewById(C8003R.id.sortby_name_desc);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(requireContext(), 0, 2, null).create();
        alertDialogCreate.setTitle(C8003R.string.action_sortby);
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setButton(-2, requireContext().getString(C8003R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(4));
        alertDialogCreate.setButton(-1, requireContext().getString(C8003R.string.dialog_done), new DialogInterfaceOnClickListenerC0174a(viewInflate, this, 3));
        if (this.mOrderBy == 4) {
            int i = this.mSortBy;
            if (i == 0) {
                radioButton5.setChecked(true);
                return alertDialogCreate;
            }
            if (i == 1) {
                radioButton.setChecked(true);
                return alertDialogCreate;
            }
            if (i == 2) {
                radioButton3.setChecked(true);
                return alertDialogCreate;
            }
        } else {
            int i2 = this.mSortBy;
            if (i2 == 0) {
                radioButton6.setChecked(true);
                return alertDialogCreate;
            }
            if (i2 == 1) {
                radioButton2.setChecked(true);
                return alertDialogCreate;
            }
            if (i2 == 2) {
                radioButton4.setChecked(true);
                return alertDialogCreate;
            }
        }
        return alertDialogCreate;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(NotesConstants.DialogTag.KEY_SORT_BY, this.mSortBy);
        outState.putInt("orderBy", this.mOrderBy);
    }

    public SortByDialogFragment(int i, int i2) {
        this();
        this.mSortBy = i;
        this.mOrderBy = i2;
    }
}
