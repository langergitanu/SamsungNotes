package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0012R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0005¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/ResultConsentData;", "", "consentInfo", "", "<init>", "(Ljava/lang/String;)V", "errorCode", NetworkConfig.ACK_ERROR_MSG, "(Ljava/lang/String;Ljava/lang/String;)V", "value", "getConsentInfo", "()Ljava/lang/String;", "consentList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/base/common/sync/ResultConsentData$ConsentItem;", "Lkotlin/collections/ArrayList;", "getConsentList", "()Ljava/util/ArrayList;", "", "isError", "()Z", "getErrorCode", "getErrorMsg", "setErrorMsg", "parse", "ConsentItem", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ResultConsentData {

    @NotNull
    private static final String TAG = "ResultConsentData";

    @Nullable
    private String consentInfo;

    @NotNull
    private final ArrayList<ConsentItem> consentList;

    @Nullable
    private String errorCode;

    @Nullable
    private String errorMsg;
    private boolean isError;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/ResultConsentData$ConsentItem;", "", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "mandatory", "", "getMandatory", "()Z", "setMandatory", "(Z)V", "passed", "getPassed", "setPassed", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConsentItem {
        private int id;
        private boolean mandatory;
        private boolean passed;

        @Nullable
        private String type;

        public final int getId() {
            return this.id;
        }

        public final boolean getMandatory() {
            return this.mandatory;
        }

        public final boolean getPassed() {
            return this.passed;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final void setMandatory(boolean z) {
            this.mandatory = z;
        }

        public final void setPassed(boolean z) {
            this.passed = z;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }
    }

    public ResultConsentData(@Nullable String str) {
        this.consentList = new ArrayList<>();
        this.consentInfo = str;
    }

    @Nullable
    public final String getConsentInfo() {
        return this.consentInfo;
    }

    @NotNull
    public final ArrayList<ConsentItem> getConsentList() {
        return this.consentList;
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* JADX INFO: renamed from: isError, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final boolean parse() {
        String str = this.consentInfo;
        if (str == null || StringsKt.isBlank(str)) {
            Debugger.INSTANCE.m8621e(TAG, "parse() : Empty!");
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.consentInfo);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                ConsentItem consentItem = new ConsentItem();
                consentItem.setId(jSONObject.getInt("id"));
                consentItem.setType(jSONObject.getString("type"));
                consentItem.setMandatory(jSONObject.getBoolean("mandatory"));
                consentItem.setPassed(jSONObject.getBoolean("passed"));
                this.consentList.add(consentItem);
            }
            Debugger.INSTANCE.m8627i(TAG, "parse() : # of ConsentItems = " + this.consentList.size());
            return true;
        } catch (JSONException e) {
            Debugger.Companion companion = Debugger.INSTANCE;
            companion.m8621e(TAG, "parse() : " + e);
            companion.m8621e(TAG, "parse() : # of ConsentItems = " + this.consentList.size());
            return false;
        }
    }

    public final void setErrorMsg(@Nullable String str) {
        this.errorMsg = str;
    }

    public ResultConsentData(@Nullable String str, @Nullable String str2) {
        this.consentList = new ArrayList<>();
        this.isError = true;
        this.errorCode = str;
        this.errorMsg = str2;
    }
}
