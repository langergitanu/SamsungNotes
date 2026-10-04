package com.samsung.context.sdk.samsunganalytics.internal.sender;

import android.content.Context;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.Manager;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import com.sec.android.diagmonagent.common.util.executor.Executor;
import com.sec.android.diagmonagent.common.util.executor.SingleThreadExecutor;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseLogSender implements LogSender {
    protected Configuration configuration;
    protected Context context;
    protected Executor executor = SingleThreadExecutor.getInstance();
    protected Manager manager;

    public BaseLogSender(Context context, Configuration configuration) {
        this.context = context.getApplicationContext();
        this.configuration = configuration;
        this.manager = Manager.getInstance(context, configuration);
    }

    public LogType getLogType(Map<String, String> map) {
        return Utils.getTypeForServer(map.get("t"));
    }

    public void insert(Map<String, String> map) {
        this.manager.insert(new SimpleLog(map.get("t"), Long.parseLong(map.get(DBContract.AckColumns.TIMESTAMP)), makeBodyString(setCommonParamToLog(map)), getLogType(map)));
    }

    public String makeBodyString(Map<String, String> map) {
        return Utils.makeDelimiterString(map, Utils.Depth.ONE_DEPTH);
    }

    public abstract Map<String, String> setCommonParamToLog(Map<String, String> map);
}
