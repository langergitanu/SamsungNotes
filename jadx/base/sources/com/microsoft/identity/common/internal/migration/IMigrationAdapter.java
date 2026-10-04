package com.microsoft.identity.common.internal.migration;

import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IMigrationAdapter<T extends BaseAccount, U extends RefreshToken> {
    List<Map.Entry<T, U>> adapt(Map<String, String> map);
}
