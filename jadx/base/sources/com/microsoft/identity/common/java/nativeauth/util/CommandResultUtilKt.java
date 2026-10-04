package com.microsoft.identity.common.java.nativeauth.util;

import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"UNSUCCESSFUL_COMMAND_ERROR", "", "checkAndWrapCommandResultType", "ExpectedType", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/controllers/CommandResult;", "", "(Lcom/microsoft/identity/common/java/controllers/CommandResult;)Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "common4j"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CommandResultUtilKt {

    @NotNull
    public static final String UNSUCCESSFUL_COMMAND_ERROR = "unsuccessful_command";

    public static final /* synthetic */ <ExpectedType extends INativeAuthCommandResult> ExpectedType checkAndWrapCommandResultType(CommandResult<Object> commandResult) {
        Exception exc;
        String message;
        Intrinsics.checkNotNullParameter(commandResult, "<this>");
        if (commandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
            if (commandResult.getResult() instanceof Exception) {
                Object result = commandResult.getResult();
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                exc = (Exception) result;
                message = exc.getMessage();
            } else {
                exc = null;
                message = "";
            }
            Exception exc2 = exc;
            String str = message;
            String correlationId = commandResult.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
            INativeAuthCommandResult.UnknownError unknownError = new INativeAuthCommandResult.UnknownError(UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId, null, exc2, 20, null);
            Intrinsics.reifiedOperationMarker(1, "ExpectedType");
            return unknownError;
        }
        Object result2 = commandResult.getResult();
        if (result2 instanceof Exception) {
            String correlationId2 = commandResult.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
            INativeAuthCommandResult.UnknownError unknownError2 = new INativeAuthCommandResult.UnknownError(UNSUCCESSFUL_COMMAND_ERROR, "Type casting error: result of " + commandResult + " is of type Exception, even though the command was marked as COMPLETED", null, correlationId2, null, null, 52, null);
            Intrinsics.reifiedOperationMarker(1, "ExpectedType");
            return unknownError2;
        }
        try {
            Intrinsics.reifiedOperationMarker(1, "ExpectedType");
            return (ExpectedType) result2;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder("Type casting error: result of ");
            sb.append(commandResult);
            sb.append(" is not of type ");
            Intrinsics.reifiedOperationMarker(4, "ExpectedType");
            sb.append(Reflection.getOrCreateKotlinClass(INativeAuthCommandResult.class));
            sb.append(", but of type ");
            sb.append(Reflection.getOrCreateKotlinClass(result2.getClass()));
            sb.append(", even though the command was marked as COMPLETED");
            String string = sb.toString();
            String correlationId3 = commandResult.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
            INativeAuthCommandResult.UnknownError unknownError3 = new INativeAuthCommandResult.UnknownError(UNSUCCESSFUL_COMMAND_ERROR, string, null, correlationId3, null, null, 52, null);
            Intrinsics.reifiedOperationMarker(1, "ExpectedType");
            return unknownError3;
        }
    }
}
