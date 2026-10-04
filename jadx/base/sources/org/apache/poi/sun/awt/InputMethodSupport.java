package org.apache.poi.sun.awt;

import java.util.Locale;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.im.spi.InputMethodDescriptor;
import org.apache.poi.sun.awt.im.InputContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface InputMethodSupport {
    Window createInputMethodWindow(String str, InputContext inputContext);

    boolean enableInputMethodsForTextComponent();

    Locale getDefaultKeyboardLocale();

    InputMethodDescriptor getInputMethodAdapterDescriptor();
}
