package com.samsung.scsp.framework.core.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.util.JsonUtil;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class Response {
    public static final String RCODE = "rcode";
    public static final String RMSG = "rmsg";
    public InputStream inputStream;
    private String string = null;
    private JsonObject json = null;
    private int rcode = -1;

    public Response(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0() {
        JsonObject jsonObject = this.json;
        if (jsonObject != null) {
            this.string = jsonObject.toString();
        } else {
            this.string = StreamParser.parseString(this.inputStream);
        }
    }

    public <T> T create(Class<T> cls) throws ScspException {
        try {
            Gson gson = new Gson();
            String str = this.string;
            if (str != null) {
                return (T) gson.fromJson(str, (Class) cls);
            }
            JsonObject jsonObject = this.json;
            return jsonObject != null ? (T) gson.fromJson((JsonElement) jsonObject, (Class) cls) : (T) gson.fromJson(new JsonReader(new InputStreamReader(this.inputStream)), cls);
        } catch (JsonIOException e) {
            e = e;
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "An error occurred in the process of Json parsing.", e);
        } catch (JsonSyntaxException e2) {
            e = e2;
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "An error occurred in the process of Json parsing.", e);
        }
    }

    public int getRcode() {
        if (this.rcode == -1) {
            if (this.json == null) {
                toJson();
            }
            this.rcode = this.json.get("rcode").getAsInt();
        }
        return this.rcode;
    }

    public JsonObject toJson() {
        if (this.json == null) {
            String str = this.string;
            if (str != null) {
                this.json = JsonUtil.toJson(str);
            } else {
                this.json = JsonUtil.toJson(this.inputStream);
            }
        }
        return this.json;
    }

    public String toString() {
        if (this.string == null) {
            FaultBarrier.run(new C11637a(this, 3));
        }
        return this.string;
    }
}
