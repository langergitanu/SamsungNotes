package com.samsung.scsp.framework.core.util;

import com.samsung.android.support.senl.p148nt.stt.presenter.C11523b;
import com.samsung.scsp.error.FaultBarrier;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UrlUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static StringBuilder addUrlParameter(StringBuilder sb, String str, String str2, boolean z) {
        return (StringBuilder) FaultBarrier.get(new C11523b(sb, str, str2, z), sb).obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StringBuilder lambda$addUrlParameter$0(boolean z, StringBuilder sb, String str, String str2) {
        if (z) {
            sb.append(URLEncoder.encode(str, "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(str2, "UTF-8"));
            return sb;
        }
        sb.append(Typography.amp);
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
        return sb;
    }

    public static StringBuilder addUrlParameter(StringBuilder sb, Map<String, String> map) {
        if (map.size() != 0) {
            sb.append('?');
        }
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            addUrlParameter(sb, entry.getKey(), entry.getValue(), z);
            z = false;
        }
        return sb;
    }
}
