package com.yubico.yubikit.piv;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PinMetadata {
    private final int attemptsRemaining;
    private final boolean defaultValue;
    private final int totalAttempts;

    public PinMetadata(boolean z, int i, int i2) {
        this.defaultValue = z;
        this.totalAttempts = i;
        this.attemptsRemaining = i2;
    }

    public int getAttemptsRemaining() {
        return this.attemptsRemaining;
    }

    public int getTotalAttempts() {
        return this.totalAttempts;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }
}
