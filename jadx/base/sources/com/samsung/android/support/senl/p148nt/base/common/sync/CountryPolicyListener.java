package com.samsung.android.support.senl.p148nt.base.common.sync;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/CountryPolicyListener;", "", "onReceived", "", "countryPolicyItem", "Lcom/samsung/android/support/senl/nt/base/common/sync/CountryPolicyItem;", "onError", "errCode", "", "errMsg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface CountryPolicyListener {
    void onError(@Nullable String errCode, @Nullable String errMsg);

    void onReceived(@Nullable CountryPolicyItem countryPolicyItem);
}
