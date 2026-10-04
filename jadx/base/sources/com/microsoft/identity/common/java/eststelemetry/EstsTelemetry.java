package com.microsoft.identity.common.java.eststelemetry;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.commands.ICommand;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.eststelemetry.SchemaConstants;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.InMemoryStorage;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EstsTelemetry {
    private static final String LAST_REQUEST_TELEMETRY_STORAGE_FILE = "com.microsoft.identity.client.last_request_telemetry";
    private static final String SUPPLEMENTAL_TELEMETRY_DATA_CACHE_FILE_NAME = "com.microsoft.identity.client.supplemental_telemetry_data_cache";
    private static final String TAG = "EstsTelemetry";
    private static volatile EstsTelemetry sEstsTelemetryInstance;
    private LastRequestTelemetryCache mLastRequestTelemetryCache;
    private final INameValueStorage<Set<FailedRequest>> mSentFailedRequests;
    private INameValueStorage<String> mSupplementalTelemetryDataCache;
    private final INameValueStorage<CurrentRequestTelemetry> mTelemetryMap;

    public EstsTelemetry() {
        this(new InMemoryStorage(), new InMemoryStorage());
    }

    private synchronized void addFromSupplementalTelemetryToCurrentTelemetry() {
        if (this.mSupplementalTelemetryDataCache != null) {
            getInstance().emit(this.mSupplementalTelemetryDataCache.getAll());
        }
    }

    private synchronized void emitToSupplementalTelemetryCache(@NonNull String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (this.mSupplementalTelemetryDataCache != null && SchemaConstants.isOfflineEmitAllowedForThisField(str)) {
            this.mSupplementalTelemetryDataCache.put(str, str2);
        }
    }

    @Nullable
    private String getCurrentTelemetryHeaderString() {
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id");
        if (str == null) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getCurrentTelemetryHeaderString", "correlation ID is null.");
            return null;
        }
        CurrentRequestTelemetry currentRequestTelemetry = this.mTelemetryMap.get(str);
        if (currentRequestTelemetry != null) {
            addFromSupplementalTelemetryToCurrentTelemetry();
            return currentRequestTelemetry.getCompleteHeaderString();
        }
        Logger.warn(AbstractC0622a.m1170p(TAG, ":getCurrentTelemetryHeaderString", new StringBuilder()), "currentTelemetry for correlation ID:" + str + " is null.");
        return null;
    }

    @Nullable
    private CurrentRequestTelemetry getCurrentTelemetryInstance(String str) {
        if (this.mTelemetryMap == null || str == null || str.equals(TelemetryEventStrings.Value.UNSET)) {
            return null;
        }
        return this.mTelemetryMap.get(str);
    }

    @Nullable
    private String getErrorCodeFromCommandResult(@NonNull ICommandResult iCommandResult) {
        if (iCommandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
            return ((BaseException) iCommandResult.getResult()).getErrorCode();
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
            return "user_cancel";
        }
        return null;
    }

    public static synchronized EstsTelemetry getInstance() {
        try {
            if (sEstsTelemetryInstance == null) {
                sEstsTelemetryInstance = new EstsTelemetry();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sEstsTelemetryInstance;
    }

    @Nullable
    private synchronized String getLastTelemetryHeaderString() {
        if (this.mLastRequestTelemetryCache == null) {
            Logger.warn(TAG + ":getLastTelemetryHeaderString", "mLastRequestTelemetryCache is null.");
            return null;
        }
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id");
        if (str == null) {
            Logger.warn(TAG + ":getLastTelemetryHeaderString", "correlation ID is null.");
            return null;
        }
        LastRequestTelemetry requestTelemetryFromCache = this.mLastRequestTelemetryCache.getRequestTelemetryFromCache();
        if (requestTelemetryFromCache == null) {
            CurrentRequestTelemetry currentRequestTelemetry = this.mTelemetryMap.get(str);
            if (currentRequestTelemetry != null) {
                LastRequestTelemetry lastRequestTelemetry = new LastRequestTelemetry(currentRequestTelemetry.getSchemaVersion());
                lastRequestTelemetry.copySharedValues(currentRequestTelemetry);
                lastRequestTelemetry.putInPlatformTelemetry(SchemaConstants.Key.ALL_TELEMETRY_DATA_SENT, "1");
                return lastRequestTelemetry.getCompleteHeaderString();
            }
            Logger.warn(TAG + ":getLastTelemetryHeaderString", "currentTelemetry for correlation ID:" + str + " is null.");
            return null;
        }
        LastRequestTelemetry lastRequestTelemetry2 = new LastRequestTelemetry(requestTelemetryFromCache.getSchemaVersion());
        lastRequestTelemetry2.copySharedValues(requestTelemetryFromCache);
        List<FailedRequest> failedRequests = requestTelemetryFromCache.getFailedRequests();
        Set<FailedRequest> set = this.mSentFailedRequests.get(str);
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= failedRequests.size()) {
                z = true;
                break;
            }
            if (lastRequestTelemetry2.getCompleteHeaderString().length() >= 3800) {
                break;
            }
            FailedRequest failedRequest = failedRequests.get(i);
            lastRequestTelemetry2.appendFailedRequest(failedRequest);
            if (set != null) {
                set.add(failedRequest);
            }
            i++;
        }
        lastRequestTelemetry2.putInPlatformTelemetry(SchemaConstants.Key.ALL_TELEMETRY_DATA_SENT, TelemetryUtils.getSchemaCompliantStringFromBoolean(z));
        return lastRequestTelemetry2.getCompleteHeaderString();
    }

    private boolean isCurrentTelemetryAvailable() {
        return getCurrentTelemetryInstance(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id")) != null;
    }

    private boolean isTelemetryLoggedByServer(@NonNull ICommand<?> iCommand, @NonNull ICommandResult iCommandResult) {
        int httpStatusCode;
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (iCommandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (!iCommand.willReachTokenEndpoint()) {
            return false;
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
            BaseException baseException = (BaseException) iCommandResult.getResult();
            return (baseException instanceof ServiceException) && (httpStatusCode = ((ServiceException) baseException).getHttpStatusCode()) != 0 && httpStatusCode != 429 && httpStatusCode < 500;
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
            return false;
        }
        return iCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED || ((iCommandResult.getResult() instanceof ILocalAuthenticationResult) && !((ILocalAuthenticationResult) iCommandResult.getResult()).isServicedFromCache());
    }

    @Nullable
    private LastRequestTelemetry loadLastRequestTelemetryFromCache() {
        LastRequestTelemetryCache lastRequestTelemetryCache = this.mLastRequestTelemetryCache;
        if (lastRequestTelemetryCache != null) {
            return lastRequestTelemetryCache.getRequestTelemetryFromCache();
        }
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":loadLastRequestTelemetry", "Last Request Telemetry Cache has not been initialized. Cannot load Last Request Telemetry data from cache.");
        return null;
    }

    public synchronized void clear() {
        this.mTelemetryMap.clear();
        this.mSentFailedRequests.clear();
        LastRequestTelemetryCache lastRequestTelemetryCache = this.mLastRequestTelemetryCache;
        if (lastRequestTelemetryCache != null) {
            lastRequestTelemetryCache.clear();
        }
    }

    public void emit(@Nullable Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            emit(entry.getKey(), entry.getValue());
        }
    }

    public void emitApiId(@Nullable String str) {
        emit("Microsoft.MSAL.api_id", str);
    }

    public void emitForceRefresh(boolean z) {
        emit("Microsoft.MSAL.force_refresh", TelemetryUtils.getSchemaCompliantStringFromBoolean(z));
    }

    public synchronized void flush(@NonNull ICommand<?> iCommand, @NonNull ICommandResult iCommandResult) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (iCommandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        String correlationId = iCommand.getCorrelationId();
        if (correlationId == null) {
            Logger.info(TAG + ":flush", "correlation ID is null. Nothing to flush.");
            return;
        }
        CurrentRequestTelemetry currentRequestTelemetry = this.mTelemetryMap.get(correlationId);
        if (currentRequestTelemetry == null) {
            Logger.info(TAG + ":flush", "currentTelemetry is null. Nothing to flush.");
            return;
        }
        LastRequestTelemetry lastRequestTelemetryLoadLastRequestTelemetryFromCache = loadLastRequestTelemetryFromCache();
        if (lastRequestTelemetryLoadLastRequestTelemetryFromCache == null) {
            lastRequestTelemetryLoadLastRequestTelemetryFromCache = (LastRequestTelemetry) new LastRequestTelemetry(currentRequestTelemetry.getSchemaVersion()).copySharedValues(currentRequestTelemetry);
        }
        if (isTelemetryLoggedByServer(iCommand, iCommandResult)) {
            lastRequestTelemetryLoadLastRequestTelemetryFromCache.resetSilentSuccessCount();
            lastRequestTelemetryLoadLastRequestTelemetryFromCache.wipeFailedRequestAndErrorForSubList(this.mSentFailedRequests.get(correlationId));
            INameValueStorage<String> iNameValueStorage = this.mSupplementalTelemetryDataCache;
            if (iNameValueStorage != null) {
                iNameValueStorage.clear();
            }
        }
        String errorCodeFromCommandResult = getErrorCodeFromCommandResult(iCommandResult);
        if (errorCodeFromCommandResult != null) {
            lastRequestTelemetryLoadLastRequestTelemetryFromCache.appendFailedRequest(currentRequestTelemetry.getApiId(), correlationId, errorCodeFromCommandResult);
        } else if (iCommandResult.getResult() != null && (iCommandResult.getResult() instanceof ILocalAuthenticationResult) && ((ILocalAuthenticationResult) iCommandResult.getResult()).isServicedFromCache()) {
            lastRequestTelemetryLoadLastRequestTelemetryFromCache.incrementSilentSuccessCount();
        }
        this.mTelemetryMap.remove(correlationId);
        this.mSentFailedRequests.remove(correlationId);
        LastRequestTelemetryCache lastRequestTelemetryCache = this.mLastRequestTelemetryCache;
        if (lastRequestTelemetryCache != null) {
            lastRequestTelemetryCache.saveRequestTelemetryToCache(lastRequestTelemetryLoadLastRequestTelemetryFromCache);
        } else {
            Logger.warn(TAG + ":flush", "Last Request Telemetry Cache object was null. Unable to save request telemetry to cache.");
        }
    }

    @NonNull
    public Map<String, String> getTelemetryHeaders() {
        HashMap map = new HashMap();
        if (!isCurrentTelemetryAvailable()) {
            return map;
        }
        String currentTelemetryHeaderString = getCurrentTelemetryHeaderString();
        String lastTelemetryHeaderString = getLastTelemetryHeaderString();
        if (currentTelemetryHeaderString != null) {
            map.put(SchemaConstants.CURRENT_REQUEST_HEADER_NAME, currentTelemetryHeaderString);
        } else {
            AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getTelemetryHeaders", "Current Request Telemetry Header is null");
        }
        if (lastTelemetryHeaderString != null) {
            map.put(SchemaConstants.LAST_REQUEST_HEADER_NAME, lastTelemetryHeaderString);
        } else {
            AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getTelemetryHeaders", "Last Request Telemetry Header is null");
        }
        return Collections.unmodifiableMap(map);
    }

    public void initTelemetryForCommand(@NonNull ICommand<?> iCommand) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (iCommand.isEligibleForEstsTelemetry()) {
            this.mTelemetryMap.put(iCommand.getCorrelationId(), new CurrentRequestTelemetry());
            this.mSentFailedRequests.put(iCommand.getCorrelationId(), new HashSet());
        }
    }

    public synchronized void setUp(@NonNull LastRequestTelemetryCache lastRequestTelemetryCache) {
        if (lastRequestTelemetryCache == null) {
            throw new NullPointerException("lastRequestTelemetryCache is marked non-null but is null");
        }
        if (this.mLastRequestTelemetryCache == null) {
            this.mLastRequestTelemetryCache = lastRequestTelemetryCache;
        }
    }

    public EstsTelemetry(@NonNull INameValueStorage<CurrentRequestTelemetry> iNameValueStorage, @NonNull INameValueStorage<Set<FailedRequest>> iNameValueStorage2) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("telemetryMap is marked non-null but is null");
        }
        if (iNameValueStorage2 == null) {
            throw new NullPointerException("sentFailedRequestsMap is marked non-null but is null");
        }
        this.mTelemetryMap = iNameValueStorage;
        this.mSentFailedRequests = iNameValueStorage2;
    }

    public void emit(@Nullable String str, String str2) {
        if (StringUtil.isNullOrEmpty(str)) {
            return;
        }
        String str3 = DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id");
        String schemaCompliantString = TelemetryUtils.getSchemaCompliantString(str2);
        CurrentRequestTelemetry currentTelemetryInstance = getCurrentTelemetryInstance(str3);
        if (currentTelemetryInstance != null) {
            currentTelemetryInstance.put(str, schemaCompliantString);
        } else {
            emitToSupplementalTelemetryCache(str, schemaCompliantString);
        }
    }

    public synchronized void setUp(@NonNull IPlatformComponents iPlatformComponents) {
        try {
            if (iPlatformComponents != null) {
                if (this.mLastRequestTelemetryCache == null) {
                    this.mLastRequestTelemetryCache = new LastRequestTelemetryCache(iPlatformComponents.getStorageSupplier().getUnencryptedNameValueStore(LAST_REQUEST_TELEMETRY_STORAGE_FILE, String.class));
                }
                if (this.mSupplementalTelemetryDataCache == null) {
                    this.mSupplementalTelemetryDataCache = iPlatformComponents.getStorageSupplier().getUnencryptedNameValueStore(SUPPLEMENTAL_TELEMETRY_DATA_CACHE_FILE_NAME, String.class);
                }
            } else {
                throw new NullPointerException("platformComponents is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void emit(@Nullable String str, int i) {
        emit(str, String.valueOf(i));
    }

    public void emit(@Nullable String str, long j) {
        emit(str, String.valueOf(j));
    }

    public void emit(@Nullable String str, boolean z) {
        emit(str, TelemetryUtils.getSchemaCompliantStringFromBoolean(z));
    }
}
