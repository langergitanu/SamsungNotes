package com.samsung.scsp.error;

import java.util.function.Supplier;
import p122b2.C4194q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LoggerConfig {
    public final Supplier<String> tag;

    public LoggerConfig(String str) {
        this.tag = new C4194q(str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(String str) {
        return str;
    }
}
