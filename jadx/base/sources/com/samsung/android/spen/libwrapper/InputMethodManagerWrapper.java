package com.samsung.android.spen.libwrapper;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.samsung.android.spen.libinterface.InputMethodManagerInterface;
import com.samsung.android.spen.libsdl.SdlInputMethodManager;
import com.samsung.android.spen.libse.SeInputMethodManager;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InputMethodManagerWrapper {
    private InputMethodManagerInterface instance;

    private InputMethodManagerWrapper(InputMethodManagerInterface inputMethodManagerInterface) throws PlatformException {
        try {
            this.instance = inputMethodManagerInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static InputMethodManagerWrapper create(Context context, InputMethodManager inputMethodManager) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new InputMethodManagerWrapper(new SeInputMethodManager(inputMethodManager));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new InputMethodManagerWrapper(new SdlInputMethodManager(inputMethodManager));
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public boolean isAccessoryKeyboardState() throws PlatformException {
        try {
            return this.instance.isAccessoryKeyboardState();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
