package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToCmsManager;", "", "<init>", "()V", "mRequestCmsContract", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestCmsContract;", "setRequestCmsContract", "", "requestCmsContract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RequestToCmsManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "RequestToCmsManager";

    @Nullable
    private static RequestToCmsManager mInstance;

    @Nullable
    private RequestCmsContract mRequestCmsContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToCmsManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToCmsManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/sync/RequestToCmsManager;", "request", "", "serverConsentListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/ServerConsentListener;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "serverResultListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/ServerResultListener;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized RequestToCmsManager getInstance() {
            RequestToCmsManager requestToCmsManager;
            try {
                if (RequestToCmsManager.mInstance == null) {
                    RequestToCmsManager.mInstance = new RequestToCmsManager();
                }
                requestToCmsManager = RequestToCmsManager.mInstance;
                Intrinsics.checkNotNull(requestToCmsManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.sync.RequestToCmsManager");
            } catch (Throwable th) {
                throw th;
            }
            return requestToCmsManager;
        }

        public final void request(@NotNull ServerConsentListener serverConsentListener) {
            RequestCmsContract requestCmsContract;
            Intrinsics.checkNotNullParameter(serverConsentListener, "serverConsentListener");
            if (getInstance().mRequestCmsContract == null || (requestCmsContract = getInstance().mRequestCmsContract) == null) {
                return;
            }
            requestCmsContract.request(serverConsentListener);
        }

        private Companion() {
        }

        public final void request(boolean set, @NotNull ServerResultListener serverResultListener) {
            RequestCmsContract requestCmsContract;
            Intrinsics.checkNotNullParameter(serverResultListener, "serverResultListener");
            if (getInstance().mRequestCmsContract == null || (requestCmsContract = getInstance().mRequestCmsContract) == null) {
                return;
            }
            requestCmsContract.request(set, serverResultListener);
        }
    }

    public final void setRequestCmsContract(@Nullable RequestCmsContract requestCmsContract) {
        this.mRequestCmsContract = requestCmsContract;
    }
}
