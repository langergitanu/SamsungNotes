package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class InteractiveTokenCommand extends TokenCommand {
    private static final String TAG = "InteractiveTokenCommand";
    private BaseController mController;

    public InteractiveTokenCommand(@NonNull InteractiveTokenCommandParameters interactiveTokenCommandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull CommandCallback commandCallback, @NonNull String str) {
        super(interactiveTokenCommandParameters, iControllerFactory, commandCallback, str);
        if (interactiveTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
        if (commandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public boolean canEqual(Object obj) {
        return obj instanceof InteractiveTokenCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InteractiveTokenCommand)) {
            return false;
        }
        InteractiveTokenCommand interactiveTokenCommand = (InteractiveTokenCommand) obj;
        if (!interactiveTokenCommand.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        BaseController baseController = this.mController;
        BaseController baseController2 = interactiveTokenCommand.mController;
        return baseController != null ? baseController.equals(baseController2) : baseController2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        int iHashCode = super.hashCode();
        BaseController baseController = this.mController;
        return (iHashCode * 59) + (baseController == null ? 43 : baseController.hashCode());
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    public void onFinishAuthorizationSession(int i, int i2, @NonNull PropertyBag propertyBag) {
        if (propertyBag == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        this.mController.onFinishAuthorizationSession(i, i2, propertyBag);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public AcquireTokenResult execute() {
        Span spanCurrent = SpanExtension.current();
        spanCurrent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCurrent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCurrent);
            try {
                if (!(getParameters() instanceof InteractiveTokenCommandParameters)) {
                    throw new IllegalArgumentException("Invalid operation parameters");
                }
                Logger.info(TAG + ":execute", "Executing interactive token command...");
                this.mController = getControllerFactory().getDefaultController();
                spanCurrent.setAttribute(AttributeName.controller_name.name(), this.mController.getClass().getSimpleName());
                AcquireTokenResult acquireTokenResultAcquireToken = this.mController.acquireToken((InteractiveTokenCommandParameters) getParameters());
                if (acquireTokenResultAcquireToken == null) {
                    spanCurrent.setStatus(StatusCode.ERROR, "empty result");
                } else if (acquireTokenResultAcquireToken.getSucceeded().booleanValue()) {
                    spanCurrent.setStatus(StatusCode.OK);
                } else {
                    BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireToken, getParameters());
                    if (baseExceptionExceptionFromAcquireTokenResult != null) {
                        spanCurrent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                        spanCurrent.setStatus(StatusCode.ERROR);
                    } else {
                        spanCurrent.setStatus(StatusCode.ERROR, "empty exception");
                    }
                }
                if (scopeMakeCurrentSpan == null) {
                    return acquireTokenResultAcquireToken;
                }
                scopeMakeCurrentSpan.close();
                return acquireTokenResultAcquireToken;
            } finally {
            }
        } catch (Throwable th) {
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(th);
            throw th;
        }
    }
}
