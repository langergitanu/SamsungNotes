package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import kotlin.Metadata;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "", "communicateToBroker", "Landroid/os/Bundle;", "bundle", "Lcom/microsoft/identity/common/internal/broker/ipc/BrokerOperationBundle;", "getType", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "isSupportedByTargetedBroker", "", "targetedBrokerPackageName", "", PackageRelationship.TYPE_ATTRIBUTE_NAME, "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface IIpcStrategy {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "BOUND_SERVICE", "ACCOUNT_MANAGER_ADD_ACCOUNT", "CONTENT_PROVIDER", "LEGACY_ACCOUNT_AUTHENTICATOR_FOR_WPJ_API", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public enum Type {
        BOUND_SERVICE(TelemetryEventStrings.Value.BOUND_SERVICE),
        ACCOUNT_MANAGER_ADD_ACCOUNT("account_manager_add_account"),
        CONTENT_PROVIDER(TelemetryEventStrings.Value.CONTENT_PROVIDER),
        LEGACY_ACCOUNT_AUTHENTICATOR_FOR_WPJ_API("legacy_account_authenticator_for_wpj_api");


        @NotNull
        private final String value;

        Type(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            return this.value;
        }
    }

    @Nullable
    Bundle communicateToBroker(@NotNull BrokerOperationBundle bundle);

    @NotNull
    Type getType();

    boolean isSupportedByTargetedBroker(@NotNull String targetedBrokerPackageName);
}
