package com.samsung.android.spen.libse;

import android.view.inputmethod.InputMethodManager;
import com.samsung.android.spen.libinterface.InputMethodManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeInputMethodManager implements InputMethodManagerInterface {
    InputMethodManager instance;

    public SeInputMethodManager(InputMethodManager inputMethodManager) {
        this.instance = inputMethodManager;
    }

    @Override // com.samsung.android.spen.libinterface.InputMethodManagerInterface
    public boolean isAccessoryKeyboardState() {
        return this.instance.semIsAccessoryKeyboard();
    }
}
