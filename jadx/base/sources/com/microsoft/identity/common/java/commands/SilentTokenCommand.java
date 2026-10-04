package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SilentTokenCommand extends TokenCommand {
    public static final int ACQUIRE_TOKEN_SILENT_DEFAULT_TIMEOUT_MILLISECONDS = 30000;
    private static final String TAG = "SilentTokenCommand";

    public SilentTokenCommand(@NonNull SilentTokenCommandParameters silentTokenCommandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull CommandCallback commandCallback, @NonNull String str) {
        super(silentTokenCommandParameters, iControllerFactory, commandCallback, str);
        if (silentTokenCommandParameters == null) {
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
        return obj instanceof SilentTokenCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SilentTokenCommand) && ((SilentTokenCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8 A[Catch: all -> 0x00e9, TryCatch #4 {all -> 0x00e9, blocks: (B:5:0x0036, B:7:0x003c, B:38:0x011c, B:24:0x00e8, B:27:0x00ec, B:30:0x00f0, B:32:0x00f8, B:34:0x0104, B:36:0x0110, B:39:0x0120, B:41:0x0123, B:42:0x012b, B:44:0x0135, B:45:0x013b, B:47:0x0145, B:48:0x014e, B:8:0x0053, B:10:0x0092), top: B:62:0x0036, outer: #5, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0120 A[SYNTHETIC] */
    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AcquireTokenResult execute() {
        Span spanCurrent = SpanExtension.current();
        spanCurrent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCurrent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        List<BaseController> allControllers = getControllerFactory().getAllControllers();
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCurrent);
            AcquireTokenResult acquireTokenResultAcquireTokenSilent = null;
            BaseException baseException = null;
            for (int i = 0; i < allControllers.size(); i++) {
                try {
                    BaseController baseController = allControllers.get(i);
                    spanCurrent.setAttribute(AttributeName.controller_name.name(), baseController.getClass().getSimpleName());
                    try {
                        StringBuilder sb = new StringBuilder();
                        String str = TAG;
                        sb.append(str);
                        sb.append(":execute");
                        Logger.verbose(sb.toString(), "Executing with controller: " + baseController.getClass().getSimpleName());
                        acquireTokenResultAcquireTokenSilent = baseController.acquireTokenSilent((SilentTokenCommandParameters) getParameters());
                        if (acquireTokenResultAcquireTokenSilent.getSucceeded().booleanValue()) {
                            Logger.verbose(str + ":execute", "Executing with controller: " + baseController.getClass().getSimpleName() + ": Succeeded");
                            spanCurrent.setAttribute(AttributeName.is_serviced_from_cache.name(), acquireTokenResultAcquireTokenSilent.getLocalAuthenticationResult().isServicedFromCache());
                            spanCurrent.setStatus(StatusCode.OK);
                            if (scopeMakeCurrentSpan != null) {
                                scopeMakeCurrentSpan.close();
                            }
                            return acquireTokenResultAcquireTokenSilent;
                        }
                        continue;
                    } catch (ClientException e) {
                        e = e;
                        if (i == 0) {
                            baseException = e;
                        }
                        if (i + 1 < allControllers.size()) {
                            throw baseException;
                        }
                        if ("invalid_grant".equals(e.getErrorCode()) || "no_tokens_found".equals(e.getErrorCode())) {
                            continue;
                        } else if (!"no_account_found".equals(e.getErrorCode())) {
                            throw baseException;
                        }
                    } catch (UiRequiredException e2) {
                        e = e2;
                        if (i == 0) {
                        }
                        if (i + 1 < allControllers.size()) {
                        }
                    } catch (Throwable th) {
                        if (baseException != null) {
                            throw baseException;
                        }
                        throw th;
                    }
                } finally {
                }
            }
            if (acquireTokenResultAcquireTokenSilent == null) {
                spanCurrent.setStatus(StatusCode.ERROR, "empty result");
            } else if (acquireTokenResultAcquireTokenSilent.getSucceeded().booleanValue()) {
                spanCurrent.setStatus(StatusCode.OK);
            } else {
                BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireTokenSilent, getParameters());
                if (baseExceptionExceptionFromAcquireTokenResult != null) {
                    spanCurrent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                    spanCurrent.setStatus(StatusCode.ERROR);
                } else {
                    spanCurrent.setStatus(StatusCode.ERROR, "empty exception");
                }
            }
            if (scopeMakeCurrentSpan != null) {
                scopeMakeCurrentSpan.close();
            }
            return acquireTokenResultAcquireTokenSilent;
        } catch (Throwable th2) {
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(th2);
            throw th2;
        }
    }
}
