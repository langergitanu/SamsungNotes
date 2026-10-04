package com.samsung.context.sdk.samsunganalytics.internal.sender.DMA;

import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.sender.SimpleLog;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.p168sa.IDMAInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SendLogTask implements AsyncTaskClient {
    private Configuration configuration;
    private IDMAInterface dmaInterface;
    private SimpleLog log;

    public SendLogTask(IDMAInterface iDMAInterface, Configuration configuration, SimpleLog simpleLog) {
        this.log = simpleLog;
        this.dmaInterface = iDMAInterface;
        this.configuration = configuration;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() {
        return 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        try {
            this.dmaInterface.sendLog(this.configuration.isEnableUseInAppLogging() ? 1 : 0, this.configuration.getTrackingId(), this.log.getType().getAbbrev(), this.log.getTimestamp(), this.log.getData());
        } catch (Exception e) {
            Debug.logwingW("failed to send log" + e.getMessage());
        }
    }
}
