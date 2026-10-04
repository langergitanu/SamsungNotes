package com.microsoft.identity.client.exception;

import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalUnsupportedBrokerException extends MsalException {

    @NonNull
    private final String mActiveBrokerPackageName;

    @SuppressFBWarnings(justification = "Lombok inserts more null checks than we need", value = {SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public MsalUnsupportedBrokerException(@NonNull UnsupportedBrokerException unsupportedBrokerException) {
        super(unsupportedBrokerException.getErrorCode(), unsupportedBrokerException.getMessage());
        this.mActiveBrokerPackageName = unsupportedBrokerException.getActiveBrokerPackageName();
    }

    @NonNull
    public String getActiveBrokerPackageName() {
        return this.mActiveBrokerPackageName;
    }
}
