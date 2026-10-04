package com.sec.android.diagmonagent.log.provider.threadExecutor;

import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.dma.aperf.Operation;
import com.sec.android.diagmonagent.log.provider.DiagMonConfig;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AppPerfReportExecutor implements AsyncTaskClient {
    private final DiagMonConfig config;
    private final Operation operation;

    public AppPerfReportExecutor(DiagMonConfig diagMonConfig, Operation operation) {
        this.config = diagMonConfig;
        this.operation = operation;
    }

    private void ReportAppPerfData() {
        if (this.config == null) {
            AppLog.m13144w("Configuration is null");
            return;
        }
        Operation operation = this.operation;
        if (operation == null) {
            AppLog.m13144w("operation is null");
            return;
        }
        Bundle bundleMakeAppPerfData = makeAppPerfData(operation);
        if (bundleMakeAppPerfData == null) {
            AppLog.m13144w("It can't make AppPerfData");
            return;
        }
        try {
            AppLog.m13142i("Report AppPerf: " + this.operation.getOpName() + "(" + this.operation.getOpId() + ")");
            printResult(this.config.getContext().getContentResolver().call(DiagMonUtil.URI, "report_aperf", "aperf", bundleMakeAppPerfData));
        } catch (Exception unused) {
            AppLog.m13144w("Fail to app perf Data");
        }
    }

    private Bundle makeAppPerfData(Operation operation) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("sdkVersion", DiagMonUtil.getSdkVersion());
            bundle.putString("serviceId", this.config.getServiceId());
            bundle.putParcelable("theOperation", operation);
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    private void printResult(Bundle bundle) {
        try {
            String string = bundle.getString("result");
            String string2 = bundle.getString("cause");
            if (string2 == null) {
                AppLog.m13142i("Results : " + string + SQLKeyword.COMMA + this.operation.getOpName() + "(" + this.operation.getOpId() + ")");
                return;
            }
            AppLog.m13142i("Results : " + string + ", Cause : " + string2 + SQLKeyword.COMMA + this.operation.getOpName() + "(" + this.operation.getOpId() + ")");
        } catch (Exception e) {
            AppLog.m13142i("Results : Failed, Cause : The result might be null");
            AppLog.m13144w(e.getMessage());
        }
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() {
        return 0;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        ReportAppPerfData();
    }
}
