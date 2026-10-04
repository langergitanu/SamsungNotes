package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.common;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Utils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LimitLengthInputFilter extends InputFilter.LengthFilter {
        private Context mContext;

        public LimitLengthInputFilter(Context context, int i) {
            super(i);
            this.mContext = context;
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
            String strRemoveExceptLetterOrDigit = Utils.removeExceptLetterOrDigit(charSequence.toString());
            CharSequence charSequenceFilter = super.filter(strRemoveExceptLetterOrDigit, i, strRemoveExceptLetterOrDigit.length(), spanned, i4, i5);
            if (charSequenceFilter != null) {
                ToastHandler.show(this.mContext, this.mContext.getResources().getQuantityString(C9086R.plurals.input_max_length_toast, super.getMax(), Integer.valueOf(super.getMax())), 0);
            }
            return charSequenceFilter;
        }
    }

    public static String removeExceptLetterOrDigit(String str) {
        return str.replaceAll("\\W", "");
    }

    public static void setStatusBarForLandscape(@NonNull Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 2) {
            activity.getWindow().setFlags(1024, 1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }
}
