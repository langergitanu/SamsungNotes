package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.content.ClipData;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleView extends AppCompatEditText {
    private static final String TAG = Logger.createTag("TitleView");

    public TitleView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setPrivateImeOptions("disableImage=true");
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322 && i != 16908337) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        ClipData primaryClip = companion.getInstance().getPrimaryClip(getContext(), companion.getInstance().getTypeText());
        if (primaryClip == null) {
            Logger.m10999d(TAG, "ClipData is null");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < primaryClip.getItemCount(); i2++) {
            CharSequence text = primaryClip.getItemAt(i2).getText();
            if (!TextUtils.isEmpty(text)) {
                sb.append(text);
            }
        }
        if (getSelectionStart() == getSelectionEnd()) {
            getText().insert(getSelectionStart(), sb.toString());
            return true;
        }
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (selectionStart > selectionEnd) {
            selectionEnd = selectionStart;
            selectionStart = selectionEnd;
        }
        getText().replace(selectionStart, selectionEnd, sb.toString());
        return true;
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
