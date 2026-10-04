package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextBoxMoreDialog extends Dialog {
    public static final String TAG = Logger.createTag("TextBoxMoreDialog");

    public TextBoxMoreDialog(Activity activity, String str, String str2, DialogContract.IPresenter iPresenter) {
        Logger.m10999d(TAG, "TextBoxMoreDialog");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
        if (layoutInflaterFrom == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C9086R.style.NoteAlertDialogThemeForAppCompat);
        View viewInflate = layoutInflaterFrom.inflate(C9086R.layout.comp_text_box_more, (ViewGroup) null);
        builder.setView(viewInflate).setCancelable(true);
        builder.setPositiveButton(activity.getResources().getString(C9086R.string.f6715OK), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TextBoxMoreDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        try {
            TextView textView = (TextView) viewInflate.findViewById(C9086R.id.more_text);
            if (TextUtils.isEmpty(str2)) {
                textView.setText(str);
            } else {
                int color = textView.getContext().getResources().getColor(C9086R.color.notes_search_highlight_selected_color, null);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                Matcher matcher = Pattern.compile(str2.toLowerCase()).matcher(str.toLowerCase());
                spannableStringBuilder.append((CharSequence) str);
                while (matcher.find()) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(color), matcher.start(), matcher.end(), 33);
                }
                textView.setText(SpannableString.valueOf(spannableStringBuilder));
            }
            textView.setTextColor(activity.getResources().getColor(C9086R.color.text_recognition_body_text_color, null));
        } catch (Exception e) {
            AbstractC8014b.m7207i("TextBoxMoreDialog# error = ", e, TAG);
        }
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(getDefaultDismissListener(iPresenter));
    }
}
