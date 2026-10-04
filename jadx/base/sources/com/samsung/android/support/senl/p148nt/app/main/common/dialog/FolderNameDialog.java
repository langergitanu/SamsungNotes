package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.FolderMarkColorPalette;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderNameDialog extends NameDialogFragment {
    private static final String TAG = "FolderNameDialog";
    private List<String> mFolderDisplayNames;
    private int mMode;
    private String mParentUuid = null;
    private String mSelectedUuid = null;
    private int mSelectedColor = -1;

    public FolderNameDialog() {
    }

    private void checkCurrentStatus(String str) {
        boolean zIsExistFolderName = FolderModel.isExistFolderName(getContext(), str, this.mParentUuid, this.mFolderDisplayNames, false);
        this.mPositiveCheckErrorType = 0;
        checkEmptyString(str);
        if (zIsExistFolderName) {
            if (this.mDialogType != 2) {
                this.mPositiveCheckErrorType = 5;
            } else if (isPreModificationName()) {
                this.mPositiveCheckErrorType = 6;
            } else {
                this.mPositiveCheckErrorType = 5;
            }
        }
    }

    private String getDefaultFolderName(Context context) {
        List<String> foldersDisplayName = this.mFolderDisplayNames;
        if (foldersDisplayName == null) {
            foldersDisplayName = DataManager.getInstance().getFoldersDisplayName(this.mParentUuid, null);
        }
        int i = 1;
        while (true) {
            if (i > foldersDisplayName.size() + 1) {
                i = 0;
                break;
            }
            if (!foldersDisplayName.contains(context.getString(C8003R.string.default_folder, Integer.valueOf(i)))) {
                break;
            }
            i++;
        }
        return context.getString(C8003R.string.default_folder, Integer.valueOf(i));
    }

    private boolean isEditSameFolder(String str) {
        if (this.mDialogType != 2) {
            return false;
        }
        if (str == null) {
            str = this.mInputText.getText().toString();
        }
        return str.equals(this.mEditModeInitString);
    }

    private boolean isPositiveButtonEnable() {
        int i = this.mPositiveCheckErrorType;
        if (i == 5 || i == 6 || i == 7) {
            return false;
        }
        return (this.mStringInfoErrorType == 1 && isEditSameFolder(null)) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void checkDialogStatus(String str) {
        if (str == null) {
            str = "";
        }
        checkCurrentStatus(str);
        int i = this.mStringInfoErrorType;
        if (i != 0) {
            setMessageErrorType(i);
        } else {
            setMessageErrorType(this.mPositiveCheckErrorType);
        }
        positiveButtonEnable(isPositiveButtonEnable());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public String getDefaultTitle() {
        return getDefaultFolderName(getContext());
    }

    public void initAddFolder(String str, int i) {
        this.mDialogType = i;
        this.mParentUuid = str;
        this.mSelectedUuid = str;
        this.mSelectedColor = -1;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void initInputText() {
        super.initInputText();
        this.mInputText.setFilters(new InputFilter[]{new NameDialogFragment.EditorInputFilter(), new NameDialogFragment.LimitLengthInputFilter(30)});
        checkDialogStatus(this.mInputText.getText().toString());
    }

    public void initRenameFolder(String str, String str2, String str3, int i, int i2) {
        this.mDialogType = i;
        this.mSelectedUuid = str2;
        this.mSelectedColor = i2;
        if (str3 != null) {
            this.mParentUuid = str;
            initRenameText(str3);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void negativeClickSALog() {
        int i = this.mDialogType;
        if ((i == 1 || i == 3) && this.mMode == 2) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, "7041");
        } else if (i == 2) {
            CommonSamsungAnalytics.insertLog("705", "7051");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        MainLogger.m7254d(TAG, "onCreateDialog");
        if (bundle != null) {
            this.mDialogType = bundle.getInt(NotesConstants.DialogTag.KEY_DIALOG_TYPE);
            this.mParentUuid = bundle.getString(NotesConstants.DialogTag.KEY_PARENT_UUID);
            this.mSelectedUuid = bundle.getString(NotesConstants.DialogTag.KEY_SELECTED_UUID);
            this.mSelectedColor = bundle.getInt(NotesConstants.DialogTag.KEY_SELECTED_COLOR);
        }
        super.onCreateDialog(bundle);
        int i = this.mDialogType;
        if (i == 1 || i == 3) {
            new FolderMarkColorPalette(getContext(), this.mDialogView, this.mSelectedColor, false).setOnColorChangeListener(new FolderMarkColorPalette.OnColorChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.FolderNameDialog.1
                @Override // com.samsung.android.support.senl.nt.app.main.common.dialog.FolderMarkColorPalette.OnColorChangeListener
                public void onColorChanged(int i2) {
                    FolderNameDialog.this.mSelectedColor = i2;
                    FolderNameDialog folderNameDialog = FolderNameDialog.this;
                    int i4 = folderNameDialog.mPositiveCheckErrorType;
                    folderNameDialog.positiveButtonEnable((i4 == 5 || i4 == 6) ? false : true);
                }
            });
        }
        this.mInputText.setHint(C8003R.string.enter_category);
        return this.mAlertDialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment, com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(NotesConstants.DialogTag.KEY_PARENT_UUID, this.mParentUuid);
        bundle.putString(NotesConstants.DialogTag.KEY_SELECTED_UUID, this.mSelectedUuid);
        bundle.putInt(NotesConstants.DialogTag.KEY_SELECTED_COLOR, this.mSelectedColor);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void onShowDialog() {
        super.onShowDialog();
        int i = this.mPositiveCheckErrorType;
        setButton(isEditSameFolder(null) ? false : (i == 5 || i == 6 || i == 7) ? false : true);
        this.mInputText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.FolderNameDialog.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FolderNameDialog.this.checkDialogStatus(editable.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
                FolderNameDialog.this.mTextInputLayout.setContentDescription(((Object) FolderNameDialog.this.EDIT_BOX_TEXT) + "," + ((Object) charSequence) + "," + ((Object) FolderNameDialog.this.EDITING));
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void positiveClickSALog() {
        int i = this.mDialogType;
        if ((i == 1 || i == 3) && this.mMode == 2) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, "7042");
        } else if (i == 2) {
            CommonSamsungAnalytics.insertLog("705", "7052");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public void sendResult() {
        MainLogger.m7258i(TAG, "sendResult#");
        int i = this.mDialogType;
        if (i != 1) {
            if (i == 2) {
                IEditDialogResult iEditDialogResult = this.mEditDialogResultListener;
                if (iEditDialogResult != null) {
                    iEditDialogResult.onEditDialogResult(2, this.mSelectedUuid, textChecker(this.mInputText.getText().toString()), this.mSelectedColor);
                    return;
                } else if (getParentFragment() instanceof IEditDialogResult) {
                    ((IEditDialogResult) getParentFragment()).onEditDialogResult(-1, this.mSelectedUuid, textChecker(this.mInputText.getText().toString()), this.mSelectedColor);
                    return;
                } else {
                    if (getActivity() instanceof IEditDialogResult) {
                        ((IEditDialogResult) getActivity()).onEditDialogResult(-1, this.mSelectedUuid, textChecker(this.mInputText.getText().toString()), this.mSelectedColor);
                        return;
                    }
                    return;
                }
            }
            if (i != 3) {
                return;
            }
        }
        IEditDialogResult iEditDialogResult2 = this.mEditDialogResultListener;
        if (iEditDialogResult2 != null) {
            iEditDialogResult2.onEditDialogResult(i, this.mSelectedUuid, textChecker(this.mInputText.getText().toString()), this.mSelectedColor);
        } else if (getParentFragment() instanceof IEditDialogResult) {
            ((IEditDialogResult) getParentFragment()).onEditDialogResult(-1, this.mSelectedUuid, textChecker(this.mInputText.getText().toString()), this.mSelectedColor);
        } else if (getActivity() instanceof IEditDialogResult) {
            ((IEditDialogResult) getActivity()).onEditDialogResult(-1, this.mSelectedUuid, textChecker(this.mInputText.getText().toString()), this.mSelectedColor);
        }
    }

    public FolderNameDialog(String str, String str2, String str3, int i, List<String> list, int i2) {
        initRenameFolder(str, str2, str3, i, i2);
        this.mFolderDisplayNames = list;
    }

    public FolderNameDialog(String str, int i, List<String> list, int i2) {
        initAddFolder(str, i);
        this.mFolderDisplayNames = list;
        this.mMode = i2;
    }

    public FolderNameDialog(String str, int i, List<String> list) {
        initAddFolder(str, i);
        this.mFolderDisplayNames = list;
    }

    public FolderNameDialog(String str, int i) {
        initAddFolder(str, i);
    }
}
