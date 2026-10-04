package com.microsoft.identity.common.java.marker;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CodeMarkerManager {
    private static final int MAX_SIZE_CODE_MARKER = 1000;
    private static final String TAG = "CodeMarkerManager";
    private long baseMilliSeconds;
    private final List<CodeMarker> codeMarkers;
    private boolean enableCodeMarker;
    private String scenarioCode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CodeMarkerHolder {
        static final CodeMarkerManager INSTANCE = new CodeMarkerManager();

        private CodeMarkerHolder() {
        }
    }

    public static CodeMarkerManager getInstance() {
        return CodeMarkerHolder.INSTANCE;
    }

    public void clearAll() {
        clearMarkers();
        this.scenarioCode = null;
    }

    public void clearMarkers() {
        this.codeMarkers.clear();
    }

    public boolean codeMarkerIsEnabled() {
        return this.enableCodeMarker;
    }

    public String getCsvContent() {
        if (this.codeMarkers.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.codeMarkers.get(0).getCsvHeader());
        synchronized (this.codeMarkers) {
            try {
                for (CodeMarker codeMarker : this.codeMarkers) {
                    sb.append('\n');
                    sb.append(codeMarker.getCsvLine());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    public String getFileContent() {
        return getCsvContent();
    }

    public void markCode(String str) {
        if (this.enableCodeMarker) {
            Logger.info(AbstractC0622a.m1170p(TAG, ":markCode", new StringBuilder()), "Marking code with " + str);
            if (this.codeMarkers.size() >= 1000) {
                clearMarkers();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.codeMarkers.size() == 0) {
                this.baseMilliSeconds = jCurrentTimeMillis;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            StringBuilder sb = new StringBuilder();
            String str2 = this.scenarioCode;
            if (str2 == null) {
                str2 = "";
            }
            this.codeMarkers.add(new CodeMarker(AbstractC0622a.m1170p(str2, str, sb), jCurrentTimeMillis - this.baseMilliSeconds, simpleDateFormat.format(new Date()), Thread.currentThread().getId()));
        }
    }

    public void setEnableCodeMarker(boolean z) {
        this.enableCodeMarker = z;
    }

    public void setPrefixScenarioCode(String str) {
        this.scenarioCode = str;
    }

    private CodeMarkerManager() {
        this.enableCodeMarker = false;
        this.codeMarkers = Collections.synchronizedList(new ArrayList());
        this.baseMilliSeconds = 0L;
        this.scenarioCode = null;
    }
}
