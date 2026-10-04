package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.HashTagHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EditorInputFilter implements InputFilter {
    private static final int SUPPORT_TOAST_TEXT_LENGTH = 1;
    private Context mContext;

    public EditorInputFilter(Context context) {
        this.mContext = context;
    }

    public static int getGraphemeLength(String str) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        int i = 0;
        while (characterInstance.next() != -1) {
            i++;
        }
        return i;
    }

    private void showErrorToast() {
        Context context = this.mContext;
        ToastHandler.show(context, context.getText(C9086R.string.tag_editor_toast_input_error_not_allowed_input).toString(), 0);
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
        if (getGraphemeLength(charSequence.toString()) != 1 || Character.isIdentifierIgnorable(charSequence.charAt(0)) || !HashTagHelper.isSpecialCharacter(charSequence.charAt(0))) {
            return null;
        }
        showErrorToast();
        return "";
    }
}
