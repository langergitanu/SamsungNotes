package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class CliTelemInfo implements Serializable {
    private static final Pattern HEADER_FORMAT_REGULAR_EXPRESSION = Pattern.compile("^[1-9]+\\.?[0-9|\\.]*,[0-9|\\.]*,[0-9|\\.]*,[^,]*[0-9\\.]*,[^,]*$");
    private static final String TAG = "CliTelemInfo";
    private static final long serialVersionUID = -7200606162774338466L;
    private String mRefreshTokenAge;
    private String mServerErrorCode;
    private String mServerSubErrorCode;
    private String mSpeRing;
    private String mVersion;

    public CliTelemInfo() {
    }

    @Nullable
    public static CliTelemInfo fromXMsCliTelemHeader(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 0) {
            Logger.warn(TAG, "SPE Ring header missing version field.");
            return null;
        }
        String str2 = strArrSplit[0];
        CliTelemInfo cliTelemInfo = new CliTelemInfo();
        cliTelemInfo.setVersion(str2);
        if (!str2.equals("1")) {
            Logger.warn(TAG, "Unrecognized x-ms-clitelem header version");
            return null;
        }
        if (!HEADER_FORMAT_REGULAR_EXPRESSION.matcher(str).matches()) {
            Logger.warn(TAG, "Malformed x-ms-clitelem header");
            return null;
        }
        String[] strArrSplit2 = str.split(",", 5);
        cliTelemInfo.setServerErrorCode(strArrSplit2[1]);
        cliTelemInfo.setServerSubErrorCode(strArrSplit2[2]);
        cliTelemInfo.setRefreshTokenAge(strArrSplit2[3]);
        cliTelemInfo.setSpeRing(strArrSplit2[4]);
        return cliTelemInfo;
    }

    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    public String getServerErrorCode() {
        return this.mServerErrorCode;
    }

    public String getServerSubErrorCode() {
        return this.mServerSubErrorCode;
    }

    public String getSpeRing() {
        return this.mSpeRing;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setRefreshTokenAge(String str) {
        this.mRefreshTokenAge = str;
    }

    public void setServerErrorCode(String str) {
        this.mServerErrorCode = str;
    }

    public void setServerSubErrorCode(String str) {
        this.mServerSubErrorCode = str;
    }

    public void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public CliTelemInfo(CliTelemInfo cliTelemInfo) {
        if (cliTelemInfo != null) {
            this.mVersion = cliTelemInfo.mVersion;
            this.mServerErrorCode = cliTelemInfo.mServerErrorCode;
            this.mServerSubErrorCode = cliTelemInfo.mServerSubErrorCode;
            this.mRefreshTokenAge = cliTelemInfo.mRefreshTokenAge;
            this.mSpeRing = cliTelemInfo.mSpeRing;
        }
    }
}
