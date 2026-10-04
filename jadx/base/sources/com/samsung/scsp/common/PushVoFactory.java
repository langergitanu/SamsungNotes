package com.samsung.scsp.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.HashMap;
import java.util.Map;
import p006B.C0017a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PushVoFactory {
    private static final PushVo DEFAULT_PUSH_VO;

    static {
        PushVo pushVo = new PushVo();
        DEFAULT_PUSH_VO = pushVo;
        pushVo.category = "none";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PushVo create(String str) {
        return (PushVo) FaultBarrier.get(new C0017a(str, 2), DEFAULT_PUSH_VO).obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$create$0(PushVo pushVo) {
        return (JsonObject) new Gson().fromJson(pushVo.dataValue, JsonObject.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushVo lambda$create$1(String str) {
        PushVo pushVo = (PushVo) new Gson().fromJson(str, PushVo.class);
        if (!StringUtil.isEmpty(pushVo.dataValue)) {
            pushVo.data = (JsonObject) FaultBarrier.get(new C11624c(pushVo), null).obj;
        }
        return pushVo;
    }

    public static PushVo create(Map<String, String> map) {
        return create(new Gson().toJson(new HashMap(map)));
    }
}
