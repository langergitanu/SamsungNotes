package com.microsoft.identity.common.java.commands;

import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DeviceCodeFlowCommand extends TokenCommand {
    private static final String TAG = "DeviceCodeFlowCommand";

    public DeviceCodeFlowCommand(@NonNull DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull DeviceCodeFlowCommandCallback deviceCodeFlowCommandCallback, @NonNull String str) {
        super(deviceCodeFlowCommandParameters, iControllerFactory, deviceCodeFlowCommandCallback, str);
        if (deviceCodeFlowCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
        if (deviceCodeFlowCommandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public AcquireTokenResult execute() {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":execute", "Device Code Flow command initiating...");
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.AcquireTokenDcf.name(), getParameters().getSpanContext());
        spanCreateSpanFromParent.setAttribute(AttributeName.correlation_id.name(), getParameters().getCorrelationId());
        spanCreateSpanFromParent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCreateSpanFromParent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                BaseController defaultController = getControllerFactory().getDefaultController();
                spanCreateSpanFromParent.setAttribute(AttributeName.controller_name.name(), defaultController.getClass().getSimpleName());
                DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters = (DeviceCodeFlowCommandParameters) getParameters();
                AuthorizationResult authorizationResultDeviceCodeFlowAuthRequest = defaultController.deviceCodeFlowAuthRequest(deviceCodeFlowCommandParameters);
                MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse = (MicrosoftStsAuthorizationResponse) authorizationResultDeviceCodeFlowAuthRequest.getAuthorizationResponse();
                Date date = new Date();
                try {
                    date.setTime(date.getTime() + TimeUnit.SECONDS.toMillis(Long.parseLong(microsoftStsAuthorizationResponse.getExpiresIn())));
                } catch (NumberFormatException e) {
                    Logger.error(strM3199i, "Failed to parse authorizationResponse.getExpiresIn()", e);
                }
                ((DeviceCodeFlowCommandCallback) getCallback()).onUserCodeReceived(microsoftStsAuthorizationResponse.getVerificationUri(), microsoftStsAuthorizationResponse.getUserCode(), microsoftStsAuthorizationResponse.getMessage(), date);
                AcquireTokenResult acquireTokenResultAcquireDeviceCodeFlowToken = defaultController.acquireDeviceCodeFlowToken(authorizationResultDeviceCodeFlowAuthRequest, deviceCodeFlowCommandParameters);
                Logger.verbose(strM3199i, "Device Code Flow command exiting with token...");
                if (acquireTokenResultAcquireDeviceCodeFlowToken == null) {
                    spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty result");
                } else if (acquireTokenResultAcquireDeviceCodeFlowToken.getSucceeded().booleanValue()) {
                    spanCreateSpanFromParent.setStatus(StatusCode.OK);
                } else {
                    BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireDeviceCodeFlowToken, getParameters());
                    if (!baseExceptionExceptionFromAcquireTokenResult.getErrorCode().equals(ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_PENDING_ERROR_CODE)) {
                        spanCreateSpanFromParent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                        spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                    }
                }
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                return acquireTokenResultAcquireDeviceCodeFlowToken;
            } finally {
            }
        } finally {
        }
    }
}
