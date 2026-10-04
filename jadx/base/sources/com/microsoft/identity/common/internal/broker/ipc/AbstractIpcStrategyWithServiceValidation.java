package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/AbstractIpcStrategyWithServiceValidation;", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "shouldBypassSupportValidation", "", "(Z)V", "communicateToBroker", "Landroid/os/Bundle;", "bundle", "Lcom/microsoft/identity/common/internal/broker/ipc/BrokerOperationBundle;", "communicateToBrokerAfterValidation", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class AbstractIpcStrategyWithServiceValidation implements IIpcStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(AbstractIpcStrategyWithServiceValidation.class).getSimpleName();
    private final boolean shouldBypassSupportValidation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/AbstractIpcStrategyWithServiceValidation$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String getTAG() {
            return AbstractIpcStrategyWithServiceValidation.TAG;
        }

        private Companion() {
        }
    }

    public AbstractIpcStrategyWithServiceValidation() {
        this(false, 1, null);
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    @Nullable
    public Bundle communicateToBroker(@NotNull BrokerOperationBundle bundle) throws BrokerCommunicationException {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String strM1170p = AbstractC0622a.m1170p(TAG, ":communicateToBroker", new StringBuilder());
        if (!this.shouldBypassSupportValidation) {
            String str = bundle.targetBrokerAppPackageName;
            Intrinsics.checkNotNullExpressionValue(str, "bundle.targetBrokerAppPackageName");
            if (!isSupportedByTargetedBroker(str)) {
                String str2 = "Operation " + getType() + " is not supported on " + bundle.targetBrokerAppPackageName;
                Logger.info(strM1170p, str2);
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, getType(), str2, null);
            }
        }
        return communicateToBrokerAfterValidation(bundle);
    }

    @Nullable
    public abstract Bundle communicateToBrokerAfterValidation(@NotNull BrokerOperationBundle bundle);

    public AbstractIpcStrategyWithServiceValidation(boolean z) {
        this.shouldBypassSupportValidation = z;
    }

    public /* synthetic */ AbstractIpcStrategyWithServiceValidation(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
