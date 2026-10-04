package com.microsoft.identity.client;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CurrentAccountResult implements ICurrentAccountResult {
    private boolean mChanged;
    private IAccount mCurrentAccount;
    private IAccount mPriorAccount;

    public CurrentAccountResult(IAccount iAccount, IAccount iAccount2, boolean z) {
        this.mCurrentAccount = iAccount;
        this.mPriorAccount = iAccount2;
        this.mChanged = z;
    }

    @Override // com.microsoft.identity.client.ICurrentAccountResult
    public boolean didAccountChange() {
        return this.mChanged;
    }

    @Override // com.microsoft.identity.client.ICurrentAccountResult
    public IAccount getCurrentAccount() {
        return this.mCurrentAccount;
    }

    @Override // com.microsoft.identity.client.ICurrentAccountResult
    public IAccount getPriorAccount() {
        return this.mPriorAccount;
    }
}
