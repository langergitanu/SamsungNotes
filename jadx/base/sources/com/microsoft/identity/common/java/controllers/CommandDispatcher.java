package com.microsoft.identity.common.java.controllers;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowAuthResultCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowTokenResultCommand;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.commands.InteractiveTokenCommand;
import com.microsoft.identity.common.java.commands.SilentTokenCommand;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightManager;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.logging.RequestContext;
import com.microsoft.identity.common.java.marker.CodeMarkerManager;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OtelContextExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.FinalizableResultFuture;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.result.VoidResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.util.BiConsumer;
import com.microsoft.identity.common.java.util.IPlatformUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommandDispatcher {
    private static final int DCF_REQUEST_THREAD_POOL_SIZE = 5;
    private static final int SILENT_REQUEST_THREAD_POOL_SIZE = 5;
    private static final String TAG = "CommandDispatcher";
    private static ExecutorService sInteractiveExecutor = Executors.newSingleThreadExecutor();
    private static ExecutorService sSilentExecutor = Executors.newFixedThreadPool(5);
    private static final ExecutorService sDCFExecutor = Executors.newFixedThreadPool(5);
    private static final Object sLock = new Object();
    private static InteractiveTokenCommand sCommand = null;
    private static final CommandResultCache sCommandResultCache = new CommandResultCache();
    private static final Object mapAccessLock = new Object();
    private static ConcurrentMap<BaseCommand, FinalizableResultFuture<CommandResult>> sExecutingCommandMap = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.controllers.CommandDispatcher$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C63846 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus */
        static final /* synthetic */ int[] f3592x184111ae;

        static {
            int[] iArr = new int[ICommandResult.ResultStatus.values().length];
            f3592x184111ae = iArr;
            try {
                iArr[ICommandResult.ResultStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3592x184111ae[ICommandResult.ResultStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3592x184111ae[ICommandResult.ResultStatus.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void beginInteractive(final InteractiveTokenCommand interactiveTokenCommand) {
        synchronized (sLock) {
            try {
                if (LibraryConfiguration.getInstance().isAuthorizationInCurrentTask() || (interactiveTokenCommand.getParameters() instanceof BrokerInteractiveTokenCommandParameters)) {
                    LocalBroadcaster localBroadcaster = LocalBroadcaster.INSTANCE;
                    if (localBroadcaster.hasReceivers(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST)) {
                        localBroadcaster.broadcast(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST, new PropertyBag());
                    } else if (localBroadcaster.hasReceivers(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT)) {
                        StringBuilder sb = new StringBuilder();
                        String str = TAG;
                        sb.append(str);
                        sb.append(":beginInteractive");
                        Logger.info(sb.toString(), "The previous interactive request was queued but never got processed and is blocking the interactive thread. Restarting the interactive executor service to enable processing interactive requests again.");
                        List<Runnable> listShutdownNow = sInteractiveExecutor.shutdownNow();
                        sInteractiveExecutor = Executors.newSingleThreadExecutor();
                        Logger.info(str + ":beginInteractive", "Cancelled execution of " + listShutdownNow.size() + " interactive requests.");
                    }
                }
                sInteractiveExecutor.execute(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.5
                    @Override // java.lang.Runnable
                    public void run() {
                        CommandParameters parameters = interactiveTokenCommand.getParameters();
                        String strInitializeDiagnosticContext = CommandDispatcher.initializeDiagnosticContext(parameters.getCorrelationId(), (parameters.getSdkType() == null ? SdkType.UNKNOWN : parameters.getSdkType()).getProductName(), parameters.getSdkVersion());
                        try {
                            parameters.setCorrelationId(strInitializeDiagnosticContext);
                            CommandDispatcher.logParameters(CommandDispatcher.TAG + ":beginInteractive", strInitializeDiagnosticContext, parameters, interactiveTokenCommand.getPublicApiId());
                            CommandDispatcher.initTelemetryForCommand(interactiveTokenCommand);
                            EstsTelemetry.getInstance().emitApiId(interactiveTokenCommand.getPublicApiId());
                            final BaseException[] baseExceptionArr = new BaseException[1];
                            LocalBroadcaster.IReceiverCallback iReceiverCallback = new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.5.1
                                @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
                                public void onReceive(@NonNull PropertyBag propertyBag) {
                                    if (propertyBag == null) {
                                        throw new NullPointerException("dataBag is marked non-null but is null");
                                    }
                                    try {
                                        CommandDispatcher.completeInteractive(propertyBag);
                                    } catch (Exception e) {
                                        baseExceptionArr[0] = ExceptionAdapter.baseExceptionFromException(e);
                                    }
                                }
                            };
                            LocalBroadcaster localBroadcaster2 = LocalBroadcaster.INSTANCE;
                            localBroadcaster2.registerCallback(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT, iReceiverCallback);
                            InteractiveTokenCommand unused = CommandDispatcher.sCommand = interactiveTokenCommand;
                            CommandResult commandResultExecuteCommand = CommandDispatcher.executeCommand(interactiveTokenCommand);
                            InteractiveTokenCommand unused2 = CommandDispatcher.sCommand = null;
                            localBroadcaster2.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT);
                            BaseException baseException = baseExceptionArr[0];
                            if (baseException != null) {
                                commandResultExecuteCommand = CommandResult.m4627of(ICommandResult.ResultStatus.ERROR, baseException, strInitializeDiagnosticContext);
                            }
                            Logger.info(CommandDispatcher.TAG + ":beginInteractive", "Completed interactive request for correlation id : **" + strInitializeDiagnosticContext + CommandDispatcher.statusMsg(commandResultExecuteCommand.getStatus().getLogStatus()));
                            EstsTelemetry.getInstance().flush(interactiveTokenCommand, commandResultExecuteCommand);
                            CommandDispatcher.returnCommandResult(interactiveTokenCommand, commandResultExecuteCommand);
                            DiagnosticContext.INSTANCE.clear();
                        } catch (Throwable th) {
                            DiagnosticContext.INSTANCE.clear();
                            throw th;
                        }
                    }
                }));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void cacheCommandResult(BaseCommand baseCommand, CommandResult commandResult) {
        if (baseCommand.isEligibleForCaching() && eligibleToCache(commandResult)) {
            sCommandResultCache.put(baseCommand, commandResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanMap(BaseCommand baseCommand) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<BaseCommand, FinalizableResultFuture<CommandResult>> entry : sExecutingCommandMap.entrySet()) {
            if (baseCommand != entry.getKey()) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        sExecutingCommandMap = concurrentHashMap;
    }

    public static void clearCommandCache() {
        sCommandResultCache.clear();
    }

    public static void clearState() throws IllegalAccessException, NoSuchFieldException {
        synchronized (mapAccessLock) {
            sExecutingCommandMap.clear();
        }
        sSilentExecutor.shutdownNow();
        sInteractiveExecutor.shutdownNow();
        Field declaredField = CommandDispatcher.class.getDeclaredField("sSilentExecutor");
        declaredField.setAccessible(true);
        declaredField.set(null, Executors.newFixedThreadPool(5));
        declaredField.setAccessible(false);
        Field declaredField2 = CommandDispatcher.class.getDeclaredField("sInteractiveExecutor");
        declaredField2.setAccessible(true);
        declaredField2.set(null, Executors.newSingleThreadExecutor());
        declaredField2.setAccessible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commandCallBackOnError(@NonNull BaseCommand baseCommand, Throwable th) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        baseCommand.getCallback().onError(ExceptionAdapter.baseExceptionFromException(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commandCallbackOnError(BaseCommand baseCommand, CommandResult commandResult) {
        baseCommand.getCallback().onError(ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commandCallbackOnTaskCompleted(BaseCommand baseCommand, CommandResult commandResult) {
        baseCommand.getCallback().onTaskCompleted(commandResult.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void completeInteractive(PropertyBag propertyBag) {
        int iIntValue = ((Integer) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, -1)).intValue();
        int iIntValue2 = ((Integer) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, -1)).intValue();
        InteractiveTokenCommand interactiveTokenCommand = sCommand;
        if (interactiveTokenCommand != null) {
            interactiveTokenCommand.onFinishAuthorizationSession(iIntValue, iIntValue2, propertyBag);
        } else {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":completeInteractive", "sCommand is null, No interactive call in progress to complete.");
        }
    }

    private static boolean eligibleToCache(@NonNull CommandResult commandResult) {
        if (commandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        int i = C63846.f3592x184111ae[commandResult.getStatus().ordinal()];
        if (i != 1) {
            return i == 2;
        }
        if (commandResult.getResult() instanceof BaseException) {
            return ((BaseException) commandResult.getResult()).isCacheable();
        }
        AbstractC4539a.m3189C(new StringBuilder(), TAG, ":eligibleToCache", "Get status ERROR, but result is not a BaseException");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CommandResult executeCommand(BaseCommand baseCommand) {
        Object objExecute;
        BaseException baseException = null;
        try {
            objExecute = baseCommand.execute();
        } catch (Exception e) {
            BaseException baseExceptionBaseExceptionFromException = e instanceof BaseException ? (BaseException) e : ExceptionAdapter.baseExceptionFromException(e);
            objExecute = null;
            baseException = baseExceptionBaseExceptionFromException;
        }
        String correlationId = baseCommand.getParameters().getCorrelationId();
        CommandResult<Void> commandResultOfNull = baseException != null ? baseException instanceof UserCancelException ? CommandResult.ofNull(ICommandResult.ResultStatus.CANCEL, correlationId) : CommandResult.m4627of(ICommandResult.ResultStatus.ERROR, baseException, correlationId) : (objExecute == null || !(objExecute instanceof AcquireTokenResult)) ? objExecute instanceof VoidResult ? new CommandResult<>(ICommandResult.ResultStatus.VOID, objExecute, baseCommand.getParameters().getCorrelationId()) : objExecute == null ? CommandResult.ofNull(ICommandResult.ResultStatus.COMPLETED, correlationId) : new CommandResult<>(ICommandResult.ResultStatus.COMPLETED, objExecute, correlationId) : getCommandResultFromTokenResult((AcquireTokenResult) objExecute, baseCommand.getParameters());
        setCorrelationIdOnResult(commandResultOfNull, correlationId);
        setTelemetryOnResultAndFlush(commandResultOfNull, correlationId);
        return commandResultOfNull;
    }

    public static int getCachedResultCount() {
        return sCommandResultCache.getSize();
    }

    private static BiConsumer<CommandResult, Throwable> getCommandResultConsumer(@NonNull final BaseCommand baseCommand) {
        if (baseCommand != null) {
            return new BiConsumer<CommandResult, Throwable>() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.3
                @Override // com.microsoft.identity.common.java.util.BiConsumer
                public void accept(CommandResult commandResult, final Throwable th) {
                    if (th != null) {
                        Logger.info(CommandDispatcher.TAG + ":getCommandResultConsumer", "Request encountered an exception (this maybe a duplicate request which caries the exception encountered by the original request)");
                        baseCommand.getParameters().getPlatformComponents().getPlatformUtil().postCommandResult(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CommandDispatcher.commandCallBackOnError(baseCommand, th);
                            }
                        });
                        return;
                    }
                    if (!StringUtil.isNullOrEmpty(commandResult.getCorrelationId()) && !baseCommand.getParameters().getCorrelationId().equals(commandResult.getCorrelationId())) {
                        Logger.info(CommandDispatcher.TAG + ":getCommandResultConsumer", "Completed duplicate request with correlation id : **" + baseCommand.getParameters().getCorrelationId() + ", having the same result as : " + commandResult.getCorrelationId() + ", with the status : " + commandResult.getStatus().getLogStatus());
                    }
                    CommandDispatcher.returnCommandResult(baseCommand, commandResult);
                }
            };
        }
        throw new NullPointerException("command is marked non-null but is null");
    }

    private static CommandResult getCommandResultFromTokenResult(@NonNull AcquireTokenResult acquireTokenResult, @NonNull CommandParameters commandParameters) {
        if (acquireTokenResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        if (commandParameters == null) {
            throw new NullPointerException("commandParameters is marked non-null but is null");
        }
        if (acquireTokenResult.getSucceeded().booleanValue()) {
            return new CommandResult(ICommandResult.ResultStatus.COMPLETED, acquireTokenResult.getLocalAuthenticationResult(), commandParameters.getCorrelationId());
        }
        BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResult, commandParameters);
        return baseExceptionExceptionFromAcquireTokenResult instanceof UserCancelException ? CommandResult.ofNull(ICommandResult.ResultStatus.CANCEL, commandParameters.getCorrelationId()) : new CommandResult(ICommandResult.ResultStatus.ERROR, baseExceptionExceptionFromAcquireTokenResult, commandParameters.getCorrelationId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initTelemetryForCommand(@NonNull BaseCommand<?> baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        EstsTelemetry.getInstance().setUp(baseCommand.getParameters().getPlatformComponents());
        EstsTelemetry.getInstance().initTelemetryForCommand(baseCommand);
    }

    public static String initializeDiagnosticContext(@Nullable String str, String str2, String str3) {
        if (StringUtil.isNullOrEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        RequestContext requestContext = new RequestContext();
        requestContext.put("correlation_id", str);
        requestContext.put("x-client-SKU", str2);
        requestContext.put("x-client-Ver", str3);
        DiagnosticContext.INSTANCE.setRequestContext(requestContext);
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":initializeDiagnosticContext", "Initialized new DiagnosticContext");
        return str;
    }

    public static boolean isCommandOutstanding(BaseCommand baseCommand) {
        synchronized (mapAccessLock) {
            try {
                Iterator<Map.Entry<BaseCommand, FinalizableResultFuture<CommandResult>>> it = sExecutingCommandMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getKey() == baseCommand) {
                        System.out.println("Command out there " + baseCommand);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean isDeviceCodeFlowRequest(BaseCommand baseCommand) {
        return (baseCommand instanceof DeviceCodeFlowCommand) || (baseCommand instanceof DeviceCodeFlowAuthResultCommand) || (baseCommand instanceof DeviceCodeFlowTokenResultCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logParameters(@NonNull String str, @NonNull String str2, @NonNull CommandParameters commandParameters, @Nullable String str3) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (commandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, ":");
        sbM781w.append(commandParameters.getClass().getSimpleName());
        String string = sbM781w.toString();
        Logger.info(string, "Starting request with request context: " + DiagnosticContext.INSTANCE.getRequestContext().toJsonString() + ", with PublicApiId: " + str3);
        commandParameters.logParameters(string, str2);
    }

    public static int outstandingCommands() {
        int size;
        synchronized (mapAccessLock) {
            size = sExecutingCommandMap.size();
        }
        return size;
    }

    public static void resetSilentRequestExecutor() {
        Logger.info(TAG + ":resetSilentRequestExecutor", "Resetting silent Executor");
        sSilentExecutor = Executors.newFixedThreadPool(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void returnCommandResult(@NonNull final BaseCommand baseCommand, @NonNull final CommandResult commandResult) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (commandResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        IPlatformUtil platformUtil = baseCommand.getParameters().getPlatformComponents().getPlatformUtil();
        platformUtil.onReturnCommandResult(baseCommand);
        platformUtil.postCommandResult(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.4
            @Override // java.lang.Runnable
            public void run() {
                int i = C63846.f3592x184111ae[commandResult.getStatus().ordinal()];
                if (i == 1) {
                    CommandDispatcher.commandCallbackOnError(baseCommand, commandResult);
                } else if (i == 2) {
                    CommandDispatcher.commandCallbackOnTaskCompleted(baseCommand, commandResult);
                } else {
                    if (i != 3) {
                        return;
                    }
                    baseCommand.getCallback().onCancel();
                }
            }
        });
    }

    private static void setCorrelationIdOnResult(@NonNull CommandResult commandResult, @NonNull String str) {
        if (commandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (commandResult.getResult() == null || !(commandResult.getResult() instanceof LocalAuthenticationResult)) {
            return;
        }
        ((LocalAuthenticationResult) commandResult.getResult()).setCorrelationId(str);
    }

    private static void setTelemetryOnResultAndFlush(@NonNull CommandResult commandResult, @NonNull String str) {
        if (commandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        List<Map<String, String>> map = Telemetry.getInstance().getMap(str);
        commandResult.setTelemetryMap(map);
        if (commandResult.getResult() instanceof LocalAuthenticationResult) {
            ((LocalAuthenticationResult) commandResult.getResult()).setTelemetry(map);
        } else if (commandResult.getResult() instanceof BaseException) {
            ((BaseException) commandResult.getResult()).setTelemetry(map);
        } else if (commandResult.getResult() != null) {
            Logger.verbose(AbstractC0622a.m1170p(TAG, ":setTelemetryOnResult", new StringBuilder()), "Not setting telemetry on result as result type is " + commandResult.getResult().getClass().getCanonicalName() + " and doesn't support telemetry at this time.");
        }
        Telemetry.getInstance().flush(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String statusMsg(String str) {
        return AbstractC0541b.m772n(", with the status : ", str);
    }

    public static void stopSilentRequestExecutor() {
        String str = TAG + ":stopSilentRequestExecutor";
        Logger.info(str, "shutting down..");
        sSilentExecutor.shutdown();
        try {
            if (sSilentExecutor.awaitTermination(1000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            Logger.warn(str, "terminating now");
            sSilentExecutor.shutdownNow();
        } catch (InterruptedException unused) {
            Logger.warn(str, "terminating again");
            sSilentExecutor.shutdownNow();
        }
    }

    public static ILocalAuthenticationResult submitAcquireTokenSilentSync(@NonNull SilentTokenCommand silentTokenCommand) throws BaseException {
        if (silentTokenCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        try {
            CommandResult commandResult = submitSilentReturningFuture(silentTokenCommand).get(CommonFlightManager.getIntValue(CommonFlight.ACQUIRE_TOKEN_SILENT_TIMEOUT_MILLISECONDS), TimeUnit.MILLISECONDS);
            if (commandResult.getStatus() == ICommandResult.ResultStatus.COMPLETED) {
                return (ILocalAuthenticationResult) commandResult.getResult();
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
                throw ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult());
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
                throw new UserCancelException(ErrorStrings.USER_CANCELLED, "Request cancelled by user");
            }
            throw new ClientException("unknown_error", "Unexpected CommandResult status");
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw ExceptionAdapter.baseExceptionFromException(e);
        }
    }

    public static void submitAndForget(@NonNull BaseCommand baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        submitAndForgetReturningFuture(baseCommand);
    }

    public static FinalizableResultFuture<CommandResult> submitAndForgetReturningFuture(@NonNull final BaseCommand baseCommand) {
        final FinalizableResultFuture<CommandResult> finalizableResultFuture;
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        final CommandParameters parameters = baseCommand.getParameters();
        final String strInitializeDiagnosticContext = initializeDiagnosticContext(parameters.getCorrelationId(), parameters.getSdkType() == null ? SdkType.UNKNOWN.getProductName() : parameters.getSdkType().getProductName(), parameters.getSdkVersion());
        parameters.setCorrelationId(strInitializeDiagnosticContext);
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        logParameters(AbstractC0622a.m1170p(str, ":submit", sb), strInitializeDiagnosticContext, parameters, baseCommand.getPublicApiId());
        Logger.info(str, "RefreshOnCommand with CorrelationId: " + strInitializeDiagnosticContext);
        synchronized (mapAccessLock) {
            finalizableResultFuture = new FinalizableResultFuture<>();
            finalizableResultFuture.whenComplete(getCommandResultConsumer(baseCommand));
            sSilentExecutor.execute(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CommandDispatcher.initializeDiagnosticContext(strInitializeDiagnosticContext, (parameters.getSdkType() == null ? SdkType.UNKNOWN : parameters.getSdkType()).getProductName(), parameters.getSdkVersion());
                        EstsTelemetry.getInstance().initTelemetryForCommand(baseCommand);
                        EstsTelemetry.getInstance().emitApiId(baseCommand.getPublicApiId());
                        CommandResult commandResultExecuteCommand = CommandDispatcher.executeCommand(baseCommand);
                        Logger.info(CommandDispatcher.TAG + ":submit", "Completed as owner for correlation id : **" + strInitializeDiagnosticContext + CommandDispatcher.statusMsg(commandResultExecuteCommand.getStatus().getLogStatus()) + " is cacheable : " + baseCommand.isEligibleForCaching());
                        EstsTelemetry.getInstance().flush(baseCommand, commandResultExecuteCommand);
                        finalizableResultFuture.setResult(commandResultExecuteCommand);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            }));
        }
        return finalizableResultFuture;
    }

    public static AuthorizationResult submitDcfAuthResultSilent(@NonNull DeviceCodeFlowAuthResultCommand deviceCodeFlowAuthResultCommand) throws BaseException {
        if (deviceCodeFlowAuthResultCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        try {
            CommandResult commandResult = submitSilentReturningFuture(deviceCodeFlowAuthResultCommand).get();
            if (commandResult.getStatus() == ICommandResult.ResultStatus.COMPLETED) {
                return (AuthorizationResult) commandResult.getResult();
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
                throw ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult());
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
                throw new UserCancelException(ErrorStrings.USER_CANCELLED, "Request cancelled by user");
            }
            throw new ClientException("unknown_error", "Unexpected CommandResult status");
        } catch (InterruptedException | ExecutionException e) {
            throw ExceptionAdapter.baseExceptionFromException(e);
        }
    }

    public static ILocalAuthenticationResult submitDcfTokenResultSilent(@NonNull DeviceCodeFlowTokenResultCommand deviceCodeFlowTokenResultCommand) throws BaseException {
        if (deviceCodeFlowTokenResultCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        try {
            CommandResult commandResult = submitSilentReturningFuture(deviceCodeFlowTokenResultCommand).get();
            if (commandResult.getStatus() == ICommandResult.ResultStatus.COMPLETED) {
                return (ILocalAuthenticationResult) commandResult.getResult();
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
                throw ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult());
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
                throw new UserCancelException(ErrorStrings.USER_CANCELLED, "Request cancelled by user");
            }
            throw new ClientException("unknown_error", "Unexpected CommandResult status");
        } catch (InterruptedException | ExecutionException e) {
            throw ExceptionAdapter.baseExceptionFromException(e);
        }
    }

    public static void submitSilent(@NonNull BaseCommand baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        submitSilentReturningFuture(baseCommand);
    }

    public static FinalizableResultFuture<CommandResult> submitSilentReturningFuture(@NonNull final BaseCommand baseCommand) {
        ExecutorService executorService;
        String str;
        FinalizableResultFuture<CommandResult> finalizableResultFuture;
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        final CodeMarkerManager codeMarkerManager = CodeMarkerManager.getInstance();
        final CommandParameters parameters = baseCommand.getParameters();
        final String strInitializeDiagnosticContext = initializeDiagnosticContext(parameters.getCorrelationId(), parameters.getSdkType() == null ? SdkType.UNKNOWN.getProductName() : parameters.getSdkType().getProductName(), parameters.getSdkVersion());
        parameters.setCorrelationId(strInitializeDiagnosticContext);
        final boolean zIsDeviceCodeFlowRequest = isDeviceCodeFlowRequest(baseCommand);
        if (zIsDeviceCodeFlowRequest) {
            executorService = sDCFExecutor;
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_START);
            str = ":submitDCF";
        } else {
            executorService = sSilentExecutor;
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_START);
            str = ":submitSilent";
        }
        ExecutorService executorService2 = executorService;
        final String str2 = str;
        logParameters(AbstractC0622a.m1170p(TAG, str2, new StringBuilder()), strInitializeDiagnosticContext, parameters, baseCommand.getPublicApiId());
        synchronized (mapAccessLock) {
            try {
                if (baseCommand.isEligibleForCaching()) {
                    FinalizableResultFuture<CommandResult> finalizableResultFuture2 = sExecutingCommandMap.get(baseCommand);
                    if (finalizableResultFuture2 != null) {
                        finalizableResultFuture2.whenComplete(getCommandResultConsumer(baseCommand));
                        return finalizableResultFuture2;
                    }
                    finalizableResultFuture = new FinalizableResultFuture<>();
                    FinalizableResultFuture<CommandResult> finalizableResultFuturePutIfAbsent = sExecutingCommandMap.putIfAbsent(baseCommand, finalizableResultFuture);
                    if (finalizableResultFuturePutIfAbsent != null) {
                        finalizableResultFuturePutIfAbsent.whenComplete(getCommandResultConsumer(baseCommand));
                        return finalizableResultFuturePutIfAbsent;
                    }
                    finalizableResultFuture.whenComplete(getCommandResultConsumer(baseCommand));
                } else {
                    finalizableResultFuture = new FinalizableResultFuture<>();
                    finalizableResultFuture.whenComplete(getCommandResultConsumer(baseCommand));
                }
                final FinalizableResultFuture<CommandResult> finalizableResultFuture3 = finalizableResultFuture;
                SpanExtension.current().setAttribute(AttributeName.num_concurrent_silent_requests.name(), sExecutingCommandMap.size());
                executorService2.execute(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.1
                    /* JADX WARN: Finally extract failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_EXECUTOR_START : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_EXECUTOR_START);
                        try {
                            CommandDispatcher.initializeDiagnosticContext(strInitializeDiagnosticContext, (parameters.getSdkType() == null ? SdkType.UNKNOWN : parameters.getSdkType()).getProductName(), parameters.getSdkVersion());
                            CommandDispatcher.initTelemetryForCommand(baseCommand);
                            EstsTelemetry.getInstance().emitApiId(baseCommand.getPublicApiId());
                            if (baseCommand.getParameters() instanceof SilentTokenCommandParameters) {
                                EstsTelemetry.getInstance().emitForceRefresh(((SilentTokenCommandParameters) baseCommand.getParameters()).isForceRefresh());
                            }
                            codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_COMMAND_EXECUTION_START : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_COMMAND_EXECUTION_START);
                            try {
                                CommandResult commandResultExecuteCommand = CommandDispatcher.executeCommand(baseCommand);
                                codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_COMMAND_EXECUTION_END : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_COMMAND_EXECUTION_END);
                                Logger.info(CommandDispatcher.TAG + str2, "Completed silent request as owner for correlation id : **" + strInitializeDiagnosticContext + ", with the status : " + commandResultExecuteCommand.getStatus().getLogStatus() + " is cacheable : " + baseCommand.isEligibleForCaching());
                                EstsTelemetry.getInstance().flush(baseCommand, commandResultExecuteCommand);
                                finalizableResultFuture3.setResult(commandResultExecuteCommand);
                                synchronized (CommandDispatcher.mapAccessLock) {
                                    try {
                                        if (baseCommand.isEligibleForCaching() && ((FinalizableResultFuture) CommandDispatcher.sExecutingCommandMap.remove(baseCommand)) == null) {
                                            Logger.error(CommandDispatcher.TAG, "The command in the map has mutated " + baseCommand.getClass().getCanonicalName() + " the calling application was " + baseCommand.getParameters().getApplicationName(), null);
                                            CommandDispatcher.cleanMap(baseCommand);
                                        }
                                        finalizableResultFuture3.setCleanedUp();
                                    } finally {
                                    }
                                }
                            } catch (Throwable th) {
                                codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_COMMAND_EXECUTION_END : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_COMMAND_EXECUTION_END);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                Logger.info(CommandDispatcher.TAG + str2, "Request encountered an exception with correlation id : **" + strInitializeDiagnosticContext);
                                finalizableResultFuture3.setException(new ExecutionException(th2));
                                synchronized (CommandDispatcher.mapAccessLock) {
                                    try {
                                        if (baseCommand.isEligibleForCaching() && ((FinalizableResultFuture) CommandDispatcher.sExecutingCommandMap.remove(baseCommand)) == null) {
                                            Logger.error(CommandDispatcher.TAG, "The command in the map has mutated " + baseCommand.getClass().getCanonicalName() + " the calling application was " + baseCommand.getParameters().getApplicationName(), null);
                                            CommandDispatcher.cleanMap(baseCommand);
                                        }
                                        finalizableResultFuture3.setCleanedUp();
                                    } finally {
                                    }
                                }
                            } catch (Throwable th3) {
                                synchronized (CommandDispatcher.mapAccessLock) {
                                    try {
                                        if (baseCommand.isEligibleForCaching() && ((FinalizableResultFuture) CommandDispatcher.sExecutingCommandMap.remove(baseCommand)) == null) {
                                            Logger.error(CommandDispatcher.TAG, "The command in the map has mutated " + baseCommand.getClass().getCanonicalName() + " the calling application was " + baseCommand.getParameters().getApplicationName(), null);
                                            CommandDispatcher.cleanMap(baseCommand);
                                        }
                                        finalizableResultFuture3.setCleanedUp();
                                        DiagnosticContext.INSTANCE.clear();
                                        throw th3;
                                    } finally {
                                    }
                                }
                            }
                        }
                        DiagnosticContext.INSTANCE.clear();
                        codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_FUTURE_OBJECT_CREATION_END : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_FUTURE_OBJECT_CREATION_END);
                    }
                }));
                return finalizableResultFuture3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
