package com.samsung.scsp.pam.kps.lite;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9478c;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KpsPolicies {

    @SerializedName("policies")
    public Policy[] policies;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Policy {

        @SerializedName("contents")
        public Content[] contents;

        @SerializedName("groupId")
        public String groupId;

        @SerializedName("groupName")
        public String groupName;

        @SerializedName("serviceId")
        public String serviceId;

        @SerializedName("serviceName")
        public String serviceName;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Content {

            /* JADX INFO: renamed from: id */
            @SerializedName("id")
            public String f8251id;

            @SerializedName("tableName")
            public String tableName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPolicy$0(String str, Policy policy) {
        return StringUtil.equals(policy.groupId, str);
    }

    @Nullable
    public Policy getPolicy(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        return (Policy) Arrays.stream(this.policies).filter(new C9478c(str, 1)).findFirst().orElse(null);
    }
}
