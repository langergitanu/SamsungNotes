package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GroupNameDialogFragment extends NameDialogFragment {
    protected String mSpaceId;

    public GroupNameDialogFragment() {
        this.mSpaceId = null;
        this.mDialogType = 7;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void checkDialogStatus(String str) {
        if (str == null) {
            str = "";
        }
        boolean z = false;
        this.mPositiveCheckErrorType = 0;
        checkEmptyString(str);
        setMessageErrorType(this.mStringInfoErrorType);
        if (this.mPositiveCheckErrorType != 6 && !isPreModificationName()) {
            z = true;
        }
        positiveButtonEnable(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public String getDefaultTitle() {
        List<String> defaultNotebooksName = SesShareReadResolver.getInstance().getDefaultNotebooksName(getString(C8003R.string.gcs_group_rename_dialog_default_title).replace(TimeModel.NUMBER_FORMAT, "%").trim());
        int i = 1;
        while (true) {
            if (i > defaultNotebooksName.size() + 1) {
                i = 0;
                break;
            }
            if (!defaultNotebooksName.contains(getString(C8003R.string.gcs_group_rename_dialog_default_title, Integer.valueOf(i)))) {
                break;
            }
            i++;
        }
        return getString(C8003R.string.gcs_group_rename_dialog_default_title, Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void initInputText() {
        super.initInputText();
        this.mInputText.setFilters(new InputFilter[]{new NameDialogFragment.EditorInputFilter(), new NameDialogFragment.LimitLengthInputFilter(30)});
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void negativeClickSALog() {
        CommonSamsungAnalytics.insertLog("746", "7462");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mDialogType = bundle.getInt(NotesConstants.DialogTag.KEY_DIALOG_TYPE);
            this.mSpaceId = bundle.getString("spaceId");
        }
        this.mInputText.setHint(C8003R.string.gcs_group_rename_dialog_hint);
        return this.mAlertDialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment, com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("spaceId", this.mSpaceId);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void onShowDialog() {
        super.onShowDialog();
        setButton((this.mPositiveCheckErrorType == 6 || isPreModificationName()) ? false : true);
        this.mInputText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.dialog.GroupNameDialogFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                GroupNameDialogFragment.this.checkDialogStatus(editable.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                ((NameDialogFragment) GroupNameDialogFragment.this).mTextInputLayout.setContentDescription(((Object) ((NameDialogFragment) GroupNameDialogFragment.this).EDIT_BOX_TEXT) + "," + ((Object) charSequence) + "," + ((Object) ((NameDialogFragment) GroupNameDialogFragment.this).EDITING));
                CommonSamsungAnalytics.insertLog("746", "7461");
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void positiveClickSALog() {
        CommonSamsungAnalytics.insertLog("746", "7463");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void sendResult() {
        IEditDialogResult iEditDialogResult;
        int i = this.mDialogType;
        if (i != 7) {
            if (i == 8 && (iEditDialogResult = this.mEditDialogResultListener) != null) {
                iEditDialogResult.onEditDialogResult(8, this.mSpaceId, textChecker(this.mInputText.getText().toString()), -1);
                return;
            }
            return;
        }
        IEditDialogResult iEditDialogResult2 = this.mEditDialogResultListener;
        if (iEditDialogResult2 != null) {
            iEditDialogResult2.onEditDialogResult(7, null, textChecker(this.mInputText.getText().toString()), -1);
        }
    }

    public GroupNameDialogFragment(String str, String str2) {
        super(str2);
        this.mSpaceId = str;
        this.mDialogType = 8;
    }
}
