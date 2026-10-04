package com.yubico.yubikit.core.smartcard;

import com.yubico.yubikit.core.application.CommandException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ApduException extends CommandException {
    static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: sw */
    private final short f8447sw;

    public ApduException(short s) {
        this(s, String.format(Locale.ROOT, "APDU error: 0x%04x", Short.valueOf(s)));
    }

    public short getSw() {
        return this.f8447sw;
    }

    public ApduException(short s, String str) {
        super(str);
        this.f8447sw = s;
    }
}
