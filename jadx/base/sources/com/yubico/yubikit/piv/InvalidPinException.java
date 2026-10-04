package com.yubico.yubikit.piv;

import com.yubico.yubikit.core.application.CommandException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InvalidPinException extends CommandException {
    private final int attemptsRemaining;

    public InvalidPinException(int i) {
        super(AbstractC0000a.m11h(i, "Invalid PIN/PUK. Remaining attempts: "));
        this.attemptsRemaining = i;
    }

    public int getAttemptsRemaining() {
        return this.attemptsRemaining;
    }
}
