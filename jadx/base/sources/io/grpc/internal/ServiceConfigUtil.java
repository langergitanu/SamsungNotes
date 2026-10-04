package io.grpc.internal;

import androidx.collection.AbstractC0622a;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.RetriableStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ServiceConfigUtil {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LbConfig {
        private final String policyName;
        private final Map<String, ?> rawConfigValue;

        public LbConfig(String str, Map<String, ?> map) {
            this.policyName = (String) Preconditions.checkNotNull(str, "policyName");
            this.rawConfigValue = (Map) Preconditions.checkNotNull(map, "rawConfigValue");
        }

        public boolean equals(Object obj) {
            if (obj instanceof LbConfig) {
                LbConfig lbConfig = (LbConfig) obj;
                if (this.policyName.equals(lbConfig.policyName) && this.rawConfigValue.equals(lbConfig.rawConfigValue)) {
                    return true;
                }
            }
            return false;
        }

        public String getPolicyName() {
            return this.policyName;
        }

        public Map<String, ?> getRawConfigValue() {
            return this.rawConfigValue;
        }

        public int hashCode() {
            return Objects.hashCode(this.policyName, this.rawConfigValue);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("policyName", this.policyName).add("rawConfigValue", this.rawConfigValue).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PolicySelection {

        @Nullable
        final Object config;
        final LoadBalancerProvider provider;

        public PolicySelection(LoadBalancerProvider loadBalancerProvider, @Nullable Object obj) {
            this.provider = (LoadBalancerProvider) Preconditions.checkNotNull(loadBalancerProvider, "provider");
            this.config = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PolicySelection.class == obj.getClass()) {
                PolicySelection policySelection = (PolicySelection) obj;
                if (Objects.equal(this.provider, policySelection.provider) && Objects.equal(this.config, policySelection.config)) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        public LoadBalancerProvider getProvider() {
            return this.provider;
        }

        public int hashCode() {
            return Objects.hashCode(this.provider, this.config);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("provider", this.provider).add(ExternalDataConstants.EmbeddingConfig.KEY, this.config).toString();
        }
    }

    private ServiceConfigUtil() {
    }

    @Nullable
    public static Double getBackoffMultiplierFromRetryPolicy(Map<String, ?> map) {
        return JsonUtil.getNumberAsDouble(map, "backoffMultiplier");
    }

    @Nullable
    public static Map<String, ?> getHealthCheckedService(@Nullable Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return JsonUtil.getObject(map, "healthCheckConfig");
    }

    @Nullable
    public static String getHealthCheckedServiceName(@Nullable Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return JsonUtil.getString(map, "serviceName");
    }

    @Nullable
    public static Long getHedgingDelayNanosFromHedgingPolicy(Map<String, ?> map) {
        return JsonUtil.getStringAsDuration(map, "hedgingDelay");
    }

    @Nullable
    public static Map<String, ?> getHedgingPolicyFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getObject(map, "hedgingPolicy");
    }

    @Nullable
    public static Long getInitialBackoffNanosFromRetryPolicy(Map<String, ?> map) {
        return JsonUtil.getStringAsDuration(map, "initialBackoff");
    }

    private static Set<Status.Code> getListOfStatusCodesAsSet(Map<String, ?> map, String str) {
        List<?> list = JsonUtil.getList(map, str);
        if (list == null) {
            return null;
        }
        return getStatusCodesFromList(list);
    }

    @VisibleForTesting
    public static List<Map<String, ?>> getLoadBalancingConfigsFromServiceConfig(Map<String, ?> map) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(JsonUtil.getListOfObjects(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (string = JsonUtil.getString(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(string.toLowerCase(Locale.ROOT), Collections.EMPTY_MAP));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public static Integer getMaxAttemptsFromHedgingPolicy(Map<String, ?> map) {
        return JsonUtil.getNumberAsInteger(map, "maxAttempts");
    }

    @Nullable
    public static Integer getMaxAttemptsFromRetryPolicy(Map<String, ?> map) {
        return JsonUtil.getNumberAsInteger(map, "maxAttempts");
    }

    @Nullable
    public static Long getMaxBackoffNanosFromRetryPolicy(Map<String, ?> map) {
        return JsonUtil.getStringAsDuration(map, "maxBackoff");
    }

    @Nullable
    public static Integer getMaxRequestMessageBytesFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getNumberAsInteger(map, "maxRequestMessageBytes");
    }

    @Nullable
    public static Integer getMaxResponseMessageBytesFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getNumberAsInteger(map, "maxResponseMessageBytes");
    }

    @Nullable
    public static List<Map<String, ?>> getMethodConfigFromServiceConfig(Map<String, ?> map) {
        return JsonUtil.getListOfObjects(map, "methodConfig");
    }

    @Nullable
    public static String getMethodFromName(Map<String, ?> map) {
        return JsonUtil.getString(map, "method");
    }

    @Nullable
    public static List<Map<String, ?>> getNameListFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getListOfObjects(map, "name");
    }

    public static Set<Status.Code> getNonFatalStatusCodesFromHedgingPolicy(Map<String, ?> map) {
        Set<Status.Code> listOfStatusCodesAsSet = getListOfStatusCodesAsSet(map, "nonFatalStatusCodes");
        if (listOfStatusCodesAsSet == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(Status.Code.class));
        }
        Verify.verify(!listOfStatusCodesAsSet.contains(Status.Code.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return listOfStatusCodesAsSet;
    }

    @Nullable
    public static Long getPerAttemptRecvTimeoutNanosFromRetryPolicy(Map<String, ?> map) {
        return JsonUtil.getStringAsDuration(map, "perAttemptRecvTimeout");
    }

    @Nullable
    public static Map<String, ?> getRetryPolicyFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getObject(map, "retryPolicy");
    }

    public static Set<Status.Code> getRetryableStatusCodesFromRetryPolicy(Map<String, ?> map) {
        Set<Status.Code> listOfStatusCodesAsSet = getListOfStatusCodesAsSet(map, "retryableStatusCodes");
        Verify.verify(listOfStatusCodesAsSet != null, "%s is required in retry policy", "retryableStatusCodes");
        Verify.verify(true ^ listOfStatusCodesAsSet.contains(Status.Code.OK), "%s must not contain OK", "retryableStatusCodes");
        return listOfStatusCodesAsSet;
    }

    @Nullable
    public static String getServiceFromName(Map<String, ?> map) {
        return JsonUtil.getString(map, "service");
    }

    private static Set<Status.Code> getStatusCodesFromList(List<?> list) {
        Status.Code codeValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(Status.Code.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                int iIntValue = d.intValue();
                Verify.verify(((double) iIntValue) == d.doubleValue(), "Status code %s is not integral", obj);
                codeValueOf = Status.fromCodeValue(iIntValue).getCode();
                Verify.verify(codeValueOf.value() == d.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new VerifyException("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    codeValueOf = Status.Code.valueOf((String) obj);
                } catch (IllegalArgumentException e) {
                    throw new VerifyException(AbstractC0622a.m1165k(obj, "Status code ", " is not valid"), e);
                }
            }
            enumSetNoneOf.add(codeValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    @Nullable
    public static RetriableStream.Throttle getThrottlePolicy(@Nullable Map<String, ?> map) {
        Map<String, ?> object;
        if (map == null || (object = JsonUtil.getObject(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = JsonUtil.getNumberAsDouble(object, "maxTokens").floatValue();
        float fFloatValue2 = JsonUtil.getNumberAsDouble(object, "tokenRatio").floatValue();
        Preconditions.checkState(fFloatValue > 0.0f, "maxToken should be greater than zero");
        Preconditions.checkState(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new RetriableStream.Throttle(fFloatValue, fFloatValue2);
    }

    @Nullable
    public static Long getTimeoutFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getStringAsDuration(map, "timeout");
    }

    @Nullable
    public static Boolean getWaitForReadyFromMethodConfig(Map<String, ?> map) {
        return JsonUtil.getBoolean(map, "waitForReady");
    }

    public static NameResolver.ConfigOrError selectLbPolicyFromList(List<LbConfig> list, LoadBalancerRegistry loadBalancerRegistry) {
        ArrayList arrayList = new ArrayList();
        for (LbConfig lbConfig : list) {
            String policyName = lbConfig.getPolicyName();
            LoadBalancerProvider provider = loadBalancerRegistry.getProvider(policyName);
            if (provider != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(ServiceConfigUtil.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                NameResolver.ConfigOrError loadBalancingPolicyConfig = provider.parseLoadBalancingPolicyConfig(lbConfig.getRawConfigValue());
                return loadBalancingPolicyConfig.getError() != null ? loadBalancingPolicyConfig : NameResolver.ConfigOrError.fromConfig(new PolicySelection(provider, loadBalancingPolicyConfig.getConfig()));
            }
            arrayList.add(policyName);
        }
        return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("None of " + arrayList + " specified by Service Config are available."));
    }

    public static LbConfig unwrapLoadBalancingConfig(Map<String, ?> map) {
        if (map.size() == 1) {
            String key = map.entrySet().iterator().next().getKey();
            return new LbConfig(key, JsonUtil.getObject(map, key));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }

    public static List<LbConfig> unwrapLoadBalancingConfigList(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(unwrapLoadBalancingConfig(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
