package com.samsung.android.support.senl.p148nt.base.common.sync;

import kotlin.Metadata;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestCmsContract;", "", "request", "", "serverConsentListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/ServerConsentListener;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "serverResultListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/ServerResultListener;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface RequestCmsContract {
    void request(@NotNull ServerConsentListener serverConsentListener);

    void request(boolean set, @NotNull ServerResultListener serverResultListener);
}
