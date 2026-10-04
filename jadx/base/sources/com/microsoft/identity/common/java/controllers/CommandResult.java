package com.microsoft.identity.common.java.controllers;

import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommandResult<T> implements ICommandResult<T> {
    private final String mCorrelationId;
    private final T mResult;
    private final Class<T> mResultClass;
    private final ICommandResult.ResultStatus mStatus;
    private List<Map<String, String>> mTelemetryMap;

    @Deprecated
    public CommandResult(ICommandResult.ResultStatus resultStatus, T t) {
        this(resultStatus, t, null);
    }

    /* JADX INFO: renamed from: of */
    public static <T> CommandResult<T> m4627of(@NonNull ICommandResult.ResultStatus resultStatus, @NonNull T t, @Nullable String str) {
        if (resultStatus == null) {
            throw new NullPointerException("status is marked non-null but is null");
        }
        if (t != null) {
            return new CommandResult<>(resultStatus, t, str);
        }
        throw new NullPointerException("result is marked non-null but is null");
    }

    public static CommandResult<Void> ofNull(@NonNull ICommandResult.ResultStatus resultStatus, @Nullable String str) {
        if (resultStatus != null) {
            return new CommandResult<>(resultStatus, str);
        }
        throw new NullPointerException("status is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.commands.ICommandResult
    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommandResult
    public T getResult() {
        return this.mResult;
    }

    public Class<T> getResultClass() {
        return this.mResultClass;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommandResult
    public ICommandResult.ResultStatus getStatus() {
        return this.mStatus;
    }

    public List<Map<String, String>> getTelemetryMap() {
        return this.mTelemetryMap;
    }

    public void setTelemetryMap(List<Map<String, String>> list) {
        this.mTelemetryMap = list;
    }

    public CommandResult(@NonNull ICommandResult.ResultStatus resultStatus, @NonNull T t, @Nullable String str) {
        this.mTelemetryMap = new ArrayList();
        if (resultStatus == null) {
            throw new NullPointerException("status is marked non-null but is null");
        }
        if (t == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        this.mStatus = resultStatus;
        this.mResult = t;
        this.mCorrelationId = str == null ? TelemetryEventStrings.Value.UNSET : str;
        this.mResultClass = (Class<T>) t.getClass();
    }

    private CommandResult(@NonNull ICommandResult.ResultStatus resultStatus, @Nullable String str) {
        this.mTelemetryMap = new ArrayList();
        if (resultStatus != null) {
            this.mStatus = resultStatus;
            this.mResult = null;
            this.mCorrelationId = str == null ? TelemetryEventStrings.Value.UNSET : str;
            this.mResultClass = Void.class;
            return;
        }
        throw new NullPointerException("status is marked non-null but is null");
    }
}
