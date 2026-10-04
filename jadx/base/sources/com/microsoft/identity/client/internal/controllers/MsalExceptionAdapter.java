package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.client.exception.MsalArgumentException;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.client.exception.MsalServiceException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.microsoft.identity.client.exception.MsalUnsupportedBrokerException;
import com.microsoft.identity.client.exception.MsalUserCancelException;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;
import com.microsoft.identity.common.java.exception.UserCancelException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalExceptionAdapter {
    public static MsalException msalExceptionFromBaseException(BaseException baseException) {
        if (baseException instanceof MsalException) {
            return (MsalException) baseException;
        }
        if (baseException instanceof ClientException) {
            ClientException clientException = (ClientException) baseException;
            return new MsalClientException(clientException.getErrorCode(), clientException.getMessage(), clientException);
        }
        if (baseException instanceof ArgumentException) {
            ArgumentException argumentException = (ArgumentException) baseException;
            return new MsalArgumentException(argumentException.getArgumentName(), argumentException.getOperationName(), argumentException.getMessage(), argumentException);
        }
        if (baseException instanceof UiRequiredException) {
            UiRequiredException uiRequiredException = (UiRequiredException) baseException;
            return new MsalUiRequiredException(uiRequiredException.getErrorCode(), uiRequiredException.getOAuthSubErrorCode(), uiRequiredException.getMessage());
        }
        if (baseException instanceof IntuneAppProtectionPolicyRequiredException) {
            return new MsalIntuneAppProtectionPolicyRequiredException((IntuneAppProtectionPolicyRequiredException) baseException);
        }
        if (baseException instanceof UnsupportedBrokerException) {
            return new MsalUnsupportedBrokerException((UnsupportedBrokerException) baseException);
        }
        if (!(baseException instanceof ServiceException)) {
            return baseException instanceof UserCancelException ? new MsalUserCancelException() : new MsalClientException("unknown_error", baseException.getMessage(), baseException);
        }
        ServiceException serviceException = (ServiceException) baseException;
        return new MsalServiceException(serviceException.getErrorCode(), serviceException.getMessage(), serviceException.getHttpStatusCode(), serviceException);
    }
}
