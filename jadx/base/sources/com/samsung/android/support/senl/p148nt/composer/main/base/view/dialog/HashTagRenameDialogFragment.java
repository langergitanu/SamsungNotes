package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.HashTagHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.HashTagRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagRenameDialogFragment extends DialogFragment {
    private static final int BUTTON_STATE_ANIM_DURATION = 300;
    private static final float BUTTON_STATE_DISABLE_ALPHA = 0.4f;
    private static final float BUTTON_STATE_ENABLE_ALPHA = 1.0f;
    private static final String ERROR_ENABLED = "error_enabled";
    private static final String ERROR_TEXT = "error_text";
    protected static final int ERROR_TYPE_ALREADY_IN_USE = 3;
    protected static final int ERROR_TYPE_INVALID_CHARACTERS_TAGS = 1;
    protected static final int ERROR_TYPE_MAXIMUM_CHARACTERS_TAGS = 2;
    protected static final int ERROR_TYPE_NONE = 0;
    private static final String POSITIVE_BUTTON_ENABLED = "positive_button_enabled";
    private static final String TAG = "HashTagRenameDialogFragment";
    private AlertDialog mAlertDialog;
    private int mMaxCharacterCount;
    private HashTagRenameDialogPresenter mPresenter;
    private TextInputLayout mTextInputLayout;
    private String mInitHashTagName = "";
    private int mErrorType = 0;
    private boolean mIsShow = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void checkErrorWithInputText(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            showEmptyCharacter();
        } else if (str.equals(this.mInitHashTagName)) {
            if (this.mErrorType == 0) {
                showEmptyCharacter();
            }
            this.mErrorType = 3;
        } else {
            if (this.mErrorType == 0) {
                showEmptyCharacter();
                this.mErrorType = 0;
            }
            z = true;
        }
        setPositiveButtonEnabled(z, true);
    }

    private void initEditText(final EditText editText, String str) {
        HashTagHelper.initEditTextInputOption(editText);
        editText.setHint(C9086R.string.tag_name);
        editText.setText(str);
        editText.setSelection(0, str != null ? str.length() : 0);
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                HashTagRenameDialogFragment.this.mErrorType = 0;
                if (charSequence.toString().trim().length() == 0 && i2 > i) {
                    HashTagRenameDialogFragment.this.showInvalidCharacter();
                    return "";
                }
                if (HashTagHelper.removeInvalidCharacterForTag(charSequence, i, i2)) {
                    HashTagRenameDialogFragment.this.showInvalidCharacter();
                    return spanned.subSequence(i4, i5);
                }
                if (!HashTagHelper.isInvalidCharacterForTag(charSequence)) {
                    return charSequence;
                }
                HashTagRenameDialogFragment.this.showInvalidCharacter();
                return "";
            }
        }, new InputFilter.LengthFilter(this.mMaxCharacterCount) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.6
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                String strRemoveExceptLetterOrDigit = HashTagHelper.removeExceptLetterOrDigit(charSequence.toString());
                CharSequence charSequenceFilter = super.filter(strRemoveExceptLetterOrDigit, i, strRemoveExceptLetterOrDigit.length(), spanned, i4, i5);
                if (charSequenceFilter != null) {
                    HashTagRenameDialogFragment.this.mErrorType = 2;
                    if (!HashTagRenameDialogFragment.this.mTextInputLayout.isErrorEnabled()) {
                        HashTagRenameDialogFragment.this.mTextInputLayout.setErrorEnabled(true);
                        HashTagRenameDialogFragment.this.mTextInputLayout.setError(String.format(HashTagRenameDialogFragment.this.getContext().getString(C9086R.string.ss_maximum_number_of_characters_exceeded), Integer.valueOf(HashTagRenameDialogFragment.this.mMaxCharacterCount)));
                    }
                }
                return charSequenceFilter;
            }
        }});
        editText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String strRemoveExceptLetterOrDigit = HashTagHelper.removeExceptLetterOrDigit(editable.toString());
                if (!editable.toString().equals(strRemoveExceptLetterOrDigit)) {
                    editText.setText(strRemoveExceptLetterOrDigit);
                    EditText editText2 = editText;
                    editText2.setSelection(editText2.getText().length());
                    if (!Character.isLetterOrDigit(editable.toString().charAt(editable.length() - 1))) {
                        HashTagRenameDialogFragment.this.showInvalidCharacter();
                    }
                }
                HashTagRenameDialogFragment.this.checkErrorWithInputText(editText.getText().toString().trim());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            }
        });
    }

    private void initialize(final Bundle bundle) {
        final Bundle arguments = getArguments();
        if (arguments != null) {
            this.mInitHashTagName = arguments.getString(ComposerConstants.HASHTAG_NAME);
        }
        final View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C9086R.layout.memolist_editdialog, (ViewGroup) null);
        this.mTextInputLayout = (TextInputLayout) viewInflate.findViewById(C9086R.id.text_input_layout);
        final EditText editText = (EditText) viewInflate.findViewById(C9086R.id.text_input_dialog);
        initEditText(editText, this.mInitHashTagName);
        editText.setOnClickListener(new ViewOnClickListenerC7602a(7));
        ViewCompat.getInstance().setSemSetActionModeAutoFillEnabled(editText, false);
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        alertDialogBuilderForAppCompat.setPositiveButton(getContext().getString(C9086R.string.rename), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HashTagRenameDialogPresenter presenter = HashTagRenameDialogFragment.this.getPresenter();
                if (presenter != null) {
                    presenter.rename(HashTagRenameDialogFragment.this.mInitHashTagName, editText.getText().toString().trim());
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TAG_RENAME, "7908");
                }
            }
        }).setNegativeButton(getContext().getString(C9086R.string.string_cancel), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TAG_RENAME, "7907");
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setView(viewInflate);
        this.mAlertDialog.setCancelable(false);
        this.mAlertDialog.setCanceledOnTouchOutside(false);
        this.mAlertDialog.setTitle(C9086R.string.tag_dialog_rename_title);
        this.mAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Logger.m10999d(HashTagRenameDialogFragment.TAG, "onRenameDismiss");
                editText.clearFocus();
                HashTagRenameDialogFragment.this.mTextInputLayout.clearFocus();
                viewInflate.clearFocus();
                HashTagRenameDialogFragment.this.mIsShow = false;
            }
        });
        this.mAlertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.HashTagRenameDialogFragment.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                boolean z;
                if (editText == null) {
                    return;
                }
                HashTagRenameDialogFragment.this.mIsShow = true;
                editText.requestFocus();
                if (arguments == null || HashTagRenameDialogFragment.this.mTextInputLayout == null) {
                    return;
                }
                if (bundle != null) {
                    HashTagRenameDialogFragment.this.mTextInputLayout.setErrorEnabled(bundle.getBoolean(HashTagRenameDialogFragment.ERROR_ENABLED));
                    HashTagRenameDialogFragment.this.mTextInputLayout.setError(bundle.getCharSequence(HashTagRenameDialogFragment.ERROR_TEXT));
                    z = bundle.getBoolean(HashTagRenameDialogFragment.POSITIVE_BUTTON_ENABLED);
                } else {
                    z = false;
                }
                HashTagRenameDialogFragment.this.setPositiveButtonEnabled(z, false);
            }
        });
        if (this.mAlertDialog.getWindow() != null) {
            this.mAlertDialog.getWindow().setSoftInputMode(37);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPositiveButtonEnabled(boolean z, boolean z2) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null) {
            return;
        }
        int i = z2 ? 300 : 0;
        Button button = alertDialog.getButton(-1);
        button.setEnabled(z);
        if (z) {
            button.animate().alpha(1.0f).setDuration(i).start();
        } else {
            button.animate().alpha(0.4f).setDuration(i).start();
        }
    }

    private void showEmptyCharacter() {
        TextInputLayout textInputLayout = this.mTextInputLayout;
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(false);
            this.mTextInputLayout.setError(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInvalidCharacter() {
        this.mErrorType = 1;
        TextInputLayout textInputLayout = this.mTextInputLayout;
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(true);
            this.mTextInputLayout.setError(getContext().getString(C9086R.string.string_tags_invalid_character));
        }
    }

    public HashTagRenameDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (HashTagRenameDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(3);
        }
        return this.mPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.mMaxCharacterCount = getResources().getInteger(C9086R.integer.tag_input_max);
        initialize(bundle);
        return this.mAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        InputMethodCompat.getInstance().forceHideSoftInput(getContext());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextInputLayout textInputLayout = this.mTextInputLayout;
        if (textInputLayout != null) {
            textInputLayout.requestFocus();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(ERROR_ENABLED, this.mTextInputLayout.isErrorEnabled());
        bundle.putCharSequence(ERROR_TEXT, this.mTextInputLayout.getError());
        AlertDialog alertDialog = this.mAlertDialog;
        bundle.putBoolean(POSITIVE_BUTTON_ENABLED, alertDialog != null && this.mIsShow && alertDialog.getButton(-1).isEnabled());
    }
}
