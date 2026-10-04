package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputEmojiUtil;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RenameDialogCommonFragment extends DialogFragment {
    private static final int BUTTON_STATE_ANIM_DURATION = 300;
    private static final float BUTTON_STATE_DISABLE_ALPHA = 0.4f;
    private static final float BUTTON_STATE_ENABLE_ALPHA = 1.0f;
    private static final String ERROR_ENABLED = "error_enabled";
    private static final String POSITIVE_BUTTON_ENABLED = "positive_button_enabled";
    private static final String TAG = Logger.createTag("RenameDialogCommonFragment");
    public EditText mInputText;
    private final int mMaxCharacterCount;
    private ViewPropertyAnimator mPositiveButtonAnimator;
    public RenameDialogCommonPresenter mPresenter;
    public TextInputLayout mTextInputLayout;
    public String PATTERN_INVALID_CHARS = "[\\*/\\\\\\?:<>\\|\"]+";
    private final Handler mHandler = new Handler();
    private RenameType mRenameType = RenameType.DEFAULT;
    private final Queue<Runnable> mPendingTask = new ArrayDeque();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C101919 implements TextWatcher {
        public C101919() {
        }

        @Override // android.text.TextWatcher
        /* JADX INFO: renamed from: afterTextChanged, reason: merged with bridge method [inline-methods] */
        public void lambda$afterTextChanged$0(Editable editable) {
            RenameDialogCommonPresenter presenter = RenameDialogCommonFragment.this.getPresenter();
            if (presenter == null) {
                RenameDialogCommonFragment.this.addPendedTask(new RunnableC10244n(this, editable, 0));
                return;
            }
            String string = RenameDialogCommonFragment.this.mInputText.getText().toString();
            boolean zIsAvailableText = false;
            if (TextUtils.isEmpty(string.trim()) || editable.toString().length() == 0 || (!presenter.allowableDefaultName() && presenter.getDefaultName().equals(editable.toString()))) {
                RenameDialogCommonFragment.this.mTextInputLayout.setErrorEnabled(false);
                RenameDialogCommonFragment.this.mTextInputLayout.setError(null);
            } else if (presenter.isExistName(editable.toString())) {
                if (RenameDialogCommonFragment.this.mTextInputLayout.isErrorEnabled() && RenameDialogCommonFragment.this.mTextInputLayout.getError().toString().equals(RenameDialogCommonFragment.this.getExistNameError())) {
                    return;
                }
                RenameDialogCommonFragment renameDialogCommonFragment = RenameDialogCommonFragment.this;
                renameDialogCommonFragment.mTextInputLayout.setError(renameDialogCommonFragment.getExistNameError());
            } else if (RenameDialogCommonFragment.this.isMaximumText(string)) {
                Logger.m11003i(RenameDialogCommonFragment.TAG, "afterTextChanged# MaximumText:" + RenameDialogCommonFragment.this.getByteLength(string));
                String maxCharacterCountError = RenameDialogCommonFragment.this.getMaxCharacterCountError();
                if (RenameDialogCommonFragment.this.mTextInputLayout.getError() == null || !RenameDialogCommonFragment.this.mTextInputLayout.getError().toString().equals(maxCharacterCountError)) {
                    RenameDialogCommonFragment.this.mTextInputLayout.setError(maxCharacterCountError);
                }
                zIsAvailableText = RenameDialogCommonFragment.this.isAvailableText(string);
            } else {
                RenameDialogCommonFragment.this.mTextInputLayout.setErrorEnabled(false);
                RenameDialogCommonFragment.this.mTextInputLayout.setError(null);
                zIsAvailableText = true;
            }
            RenameDialogCommonFragment.this.setPositiveButtonEnabled(zIsAvailableText, true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RenameType {
        DEFAULT,
        FILE_NAME
    }

    public RenameDialogCommonFragment(int i) {
        this.mMaxCharacterCount = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPendedTask(Runnable runnable) {
        this.mPendingTask.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence bytesFilter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
        int byteLength = 200 - (getByteLength(spanned) - getByteLength(spanned.subSequence(i4, i5)));
        if (byteLength <= 0) {
            return "";
        }
        if (byteLength >= getByteLength(charSequence)) {
            return null;
        }
        do {
            i2--;
        } while (getByteLength(charSequence.subSequence(i, i2)) > byteLength);
        return charSequence.subSequence(i, i2);
    }

    private ActionMode.Callback getActionModeCallback() {
        return new ActionMode.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.10
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if (menuItem.getItemId() != 16908341) {
                    return false;
                }
                try {
                    new ShareToOtherAppHandler().sharePlainText(RenameDialogCommonFragment.this.getContext(), RenameDialogCommonFragment.this.mInputText.getText().subSequence(RenameDialogCommonFragment.this.mInputText.getSelectionStart(), RenameDialogCommonFragment.this.mInputText.getSelectionEnd()).toString(), 2);
                    EditText editText = RenameDialogCommonFragment.this.mInputText;
                    editText.setSelection(editText.getSelectionEnd());
                    return true;
                } catch (Exception e) {
                    Logger.m11001e(RenameDialogCommonFragment.TAG, "performActionItemClick", e);
                    return true;
                }
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }
        };
    }

    private DialogInterface.OnDismissListener getAlertDialogDismissListener(final View view) {
        return new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                RenameDialogCommonFragment.this.mPendingTask.clear();
                RenameDialogCommonPresenter presenter = RenameDialogCommonFragment.this.getPresenter();
                if (presenter == null) {
                    return;
                }
                Logger.m10999d(RenameDialogCommonFragment.TAG, "onRenameDismiss");
                presenter.dismiss(RenameDialogCommonFragment.this.mInputText);
                RenameDialogCommonFragment.this.mInputText.clearFocus();
                RenameDialogCommonFragment.this.mTextInputLayout.clearFocus();
                view.clearFocus();
            }
        };
    }

    private DialogInterface.OnShowListener getAlertDialogShowListener(final Bundle bundle) {
        return new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                String string;
                boolean z;
                RenameDialogCommonPresenter presenter = RenameDialogCommonFragment.this.getPresenter();
                if (presenter == null) {
                    Logger.m11000e(RenameDialogCommonFragment.TAG, "onShow()# Presenter is null. return");
                    RenameDialogCommonFragment.this.mPendingTask.clear();
                    RenameDialogCommonFragment.this.dismiss();
                    return;
                }
                RenameDialogCommonFragment renameDialogCommonFragment = RenameDialogCommonFragment.this;
                if (renameDialogCommonFragment.mTextInputLayout == null) {
                    return;
                }
                EditText editText = renameDialogCommonFragment.mInputText;
                if (editText != null) {
                    editText.requestFocus();
                }
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    RenameDialogCommonFragment.this.mTextInputLayout.setErrorEnabled(bundle2.getBoolean(RenameDialogCommonFragment.ERROR_ENABLED));
                    if (RenameDialogCommonFragment.this.mTextInputLayout.isErrorEnabled()) {
                        EditText editText2 = RenameDialogCommonFragment.this.mInputText;
                        string = editText2 != null ? editText2.getText().toString() : "";
                        if (presenter.isExistName(string)) {
                            RenameDialogCommonFragment renameDialogCommonFragment2 = RenameDialogCommonFragment.this;
                            renameDialogCommonFragment2.mTextInputLayout.setError(renameDialogCommonFragment2.getExistNameError());
                        } else if (RenameDialogCommonFragment.this.isMaximumText(string)) {
                            RenameDialogCommonFragment renameDialogCommonFragment3 = RenameDialogCommonFragment.this;
                            renameDialogCommonFragment3.mTextInputLayout.setError(renameDialogCommonFragment3.getMaxCharacterCountError());
                        } else {
                            RenameDialogCommonFragment.this.mTextInputLayout.setError(null);
                        }
                    } else {
                        RenameDialogCommonFragment.this.mTextInputLayout.setError(null);
                    }
                    z = bundle.getBoolean(RenameDialogCommonFragment.POSITIVE_BUTTON_ENABLED);
                } else {
                    RenameDialogCommonFragment.this.mTextInputLayout.setErrorEnabled(false);
                    EditText editText3 = RenameDialogCommonFragment.this.mInputText;
                    string = editText3 != null ? editText3.getText().toString() : "";
                    if (RenameDialogCommonFragment.this.validationCheck(string)) {
                        RenameDialogCommonFragment.this.mTextInputLayout.setError(null);
                        if (string.trim().length() > 0 && !presenter.isExistName(string)) {
                            z = true;
                        }
                    } else {
                        RenameDialogCommonFragment renameDialogCommonFragment4 = RenameDialogCommonFragment.this;
                        renameDialogCommonFragment4.mTextInputLayout.setError(renameDialogCommonFragment4.getInvalidNameError());
                    }
                    z = false;
                }
                RenameDialogCommonFragment.this.setPositiveButtonEnabled(z, false);
                RenameDialogCommonFragment.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RenameDialogCommonFragment.this.getDialog() != null) {
                            RenameDialogCommonFragment.this.getDialog().setCanceledOnTouchOutside(true);
                        }
                    }
                }, 100L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getByteLength(CharSequence charSequence) {
        try {
            return charSequence.toString().getBytes(StandardCharsets.UTF_8).length;
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("getByteLength# get the byte size : "), TAG);
            return 0;
        }
    }

    private InputFilter getInputInvalidFilter() {
        return new InputFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.7
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                if (RenameDialogCommonFragment.this.validationCheck(charSequence.toString())) {
                    return charSequence;
                }
                RenameDialogCommonFragment.this.showInvalidTitleToast();
                return spanned.subSequence(i4, i5);
            }
        };
    }

    private InputFilter.LengthFilter getLengthFilter() {
        return new InputFilter.LengthFilter(this.mMaxCharacterCount) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.8
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter == null && RenameDialogCommonFragment.this.mRenameType == RenameType.FILE_NAME) {
                    charSequenceFilter = RenameDialogCommonFragment.this.bytesFilter(charSequence, i, i2, spanned, i4, i5);
                }
                if (charSequenceFilter != null && !RenameDialogCommonFragment.this.mTextInputLayout.isErrorEnabled()) {
                    RenameDialogCommonFragment.this.mTextInputLayout.setErrorEnabled(true);
                    RenameDialogCommonFragment renameDialogCommonFragment = RenameDialogCommonFragment.this;
                    renameDialogCommonFragment.mTextInputLayout.setError(renameDialogCommonFragment.getMaxCharacterCountError());
                }
                return charSequenceFilter;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMaxCharacterCountError() {
        return this.mRenameType == RenameType.DEFAULT ? String.format(getContext().getString(C9086R.string.ss_maximum_number_of_characters_exceeded), Integer.valueOf(this.mMaxCharacterCount)) : getContext().getString(C9086R.string.maximum_number_of_characters_reached);
    }

    private DialogInterface.OnClickListener getNegativeButtonClickListener() {
        return new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RenameDialogCommonPresenter presenter = RenameDialogCommonFragment.this.getPresenter();
                if (presenter == null) {
                    return;
                }
                presenter.dismiss(RenameDialogCommonFragment.this.mInputText);
                RenameDialogCommonFragment.this.insertNegativeClickSALog();
            }
        };
    }

    private DialogInterface.OnClickListener getPositiveButtonClickListener() {
        return new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RenameDialogCommonPresenter presenter = RenameDialogCommonFragment.this.getPresenter();
                if (presenter == null) {
                    return;
                }
                if (presenter.isExistName(RenameDialogCommonFragment.this.mInputText.getText().toString())) {
                    RenameDialogCommonFragment renameDialogCommonFragment = RenameDialogCommonFragment.this;
                    renameDialogCommonFragment.mTextInputLayout.setError(renameDialogCommonFragment.getExistNameError());
                    RenameDialogCommonFragment.this.setPositiveButtonEnabled(false, true);
                    RenameDialogCommonFragment.this.mInputText.selectAll();
                } else {
                    String string = RenameDialogCommonFragment.this.mInputText.getText().toString();
                    if (string.contains(System.lineSeparator())) {
                        string = string.replaceAll(System.lineSeparator(), " ");
                    }
                    presenter.setNewName(string);
                    presenter.dismiss(RenameDialogCommonFragment.this.mInputText);
                    RenameDialogCommonFragment.this.dismiss();
                }
                RenameDialogCommonFragment.this.insertPositiveClickSALog();
            }
        };
    }

    private TextWatcher getTextWatcher() {
        return new C101919();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAvailableText(String str) {
        if (str.trim().length() != 0 && str.length() <= this.mMaxCharacterCount) {
            return this.mRenameType != RenameType.FILE_NAME || getByteLength(str) <= 200;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMaximumText(String str) {
        if (str.length() >= this.mMaxCharacterCount) {
            return true;
        }
        return this.mRenameType == RenameType.FILE_NAME && getByteLength(str) >= 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPositiveButtonEnabled(boolean z, boolean z2) {
        if (getDialog() == null) {
            return;
        }
        int i = z2 ? 300 : 0;
        Button button = ((AlertDialog) getDialog()).getButton(-1);
        if (button.isEnabled() == z) {
            return;
        }
        button.setEnabled(z);
        ViewPropertyAnimator viewPropertyAnimator = this.mPositiveButtonAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            this.mPositiveButtonAnimator = null;
            button.setAlpha(z ? 1.0f : 0.4f);
        } else {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = button.animate();
            this.mPositiveButtonAnimator = viewPropertyAnimatorAnimate;
            viewPropertyAnimatorAnimate.alpha(z ? 1.0f : 0.4f).setDuration(i).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    RenameDialogCommonFragment.this.mPositiveButtonAnimator = null;
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validationCheck(String str) {
        if (Pattern.compile(this.PATTERN_INVALID_CHARS).matcher(str).find() || SpenInputEmojiUtil.hasEmojiString(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (Character.getType(str.charAt(i)) == 19) {
                return false;
            }
        }
        return true;
    }

    public abstract String getExistNameError();

    public abstract String getHintText();

    public abstract String getInvalidNameError();

    public String getNegativeButtonText() {
        return getContext().getString(C9086R.string.string_cancel);
    }

    public String getPositiveButtonText() {
        return getContext().getString(C9086R.string.rename);
    }

    public abstract RenameDialogCommonPresenter getPresenter();

    public String getTitleText() {
        return getHintText();
    }

    public void handlePendedTasks() {
        while (!this.mPendingTask.isEmpty()) {
            Runnable runnablePoll = this.mPendingTask.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
            }
        }
    }

    public Dialog initAlertDialog(Bundle bundle, View view) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        alertDialogBuilderForAppCompat.setPositiveButton(getPositiveButtonText(), getPositiveButtonClickListener()).setNegativeButton(getNegativeButtonText(), getNegativeButtonClickListener());
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setView(view);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setTitle(getTitleText());
        alertDialogCreate.setOnDismissListener(getAlertDialogDismissListener(view));
        alertDialogCreate.setOnShowListener(getAlertDialogShowListener(bundle));
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setSoftInputMode(37);
        }
        return alertDialogCreate;
    }

    /* JADX INFO: renamed from: initEditText, reason: merged with bridge method [inline-methods] */
    public void lambda$initEditText$0(Bundle bundle) {
        RenameDialogCommonPresenter presenter = getPresenter();
        int i = 2;
        if (presenter == null) {
            addPendedTask(new RunnableC10244n(this, bundle, i));
            return;
        }
        String string = bundle != null ? bundle.getString("mInputText") : presenter.getDefaultName();
        this.mInputText.setPrivateImeOptions("inputType=filename;disableImage=true;disableLiveMessage=true;disableGifKeyboard=true;disableSticker=true");
        this.mInputText.setInputType(16385);
        this.mInputText.setHint(getHintText());
        this.mInputText.setText(string);
        this.mInputText.setSelection(0, string != null ? string.length() : 0);
        this.mInputText.setFilters(new InputFilter[]{getInputInvalidFilter(), getLengthFilter()});
        this.mInputText.addTextChangedListener(getTextWatcher());
        this.mInputText.setCustomSelectionActionModeCallback(getActionModeCallback());
        this.mInputText.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RenameDialogCommonFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RenameDialogCommonFragment.this.insertTextClickSALog();
            }
        });
    }

    public View initLayout(Bundle bundle) {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C9086R.layout.memolist_editdialog, (ViewGroup) null);
        this.mTextInputLayout = (TextInputLayout) viewInflate.findViewById(C9086R.id.text_input_layout);
        this.mInputText = (EditText) viewInflate.findViewById(C9086R.id.text_input_dialog);
        lambda$initEditText$0(bundle);
        ViewCompat.getInstance().setSemSetActionModeAutoFillEnabled(this.mInputText, false);
        return viewInflate;
    }

    public abstract void insertNegativeClickSALog();

    public abstract void insertPositiveClickSALog();

    public abstract void insertTextClickSALog();

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (getPresenter() != null) {
            return initAlertDialog(bundle, initLayout(bundle));
        }
        Logger.m11000e(TAG, "onCreateDialog()# Presenter is null. return null");
        return super.onCreateDialog(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Logger.m10999d(TAG, "onDetach#");
        this.mPresenter = null;
        super.onDetach();
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
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mInputText", this.mInputText.getText().toString());
        bundle.putBoolean(ERROR_ENABLED, this.mTextInputLayout.isErrorEnabled());
        bundle.putBoolean(POSITIVE_BUTTON_ENABLED, getDialog() != null && ((AlertDialog) getDialog()).getButton(-1).isEnabled());
    }

    public void setPatternInvalidChars(String str) {
        this.PATTERN_INVALID_CHARS = str;
    }

    public void setRenameType(RenameType renameType) {
        this.mRenameType = renameType;
    }

    public abstract void showInvalidTitleToast();
}
