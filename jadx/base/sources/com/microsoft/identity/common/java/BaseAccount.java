package com.microsoft.identity.common.java;

import com.microsoft.identity.common.java.dto.IAccountRecord;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseAccount implements IAccountRecord {
    public abstract List<String> getCacheIdentifiers();

    public abstract String getUniqueIdentifier();
}
