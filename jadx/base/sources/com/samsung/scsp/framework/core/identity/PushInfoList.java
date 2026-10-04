package com.samsung.scsp.framework.core.identity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PushInfoList {

    /* JADX INFO: renamed from: ID */
    private static final String f8197ID = "id";
    private static final String TOKEN = "token";
    private static final String TYPE = "type";
    private List<PushInfo> pushInfoList;

    public PushInfoList(PushInfo[] pushInfoArr) {
        ArrayList arrayList = new ArrayList();
        this.pushInfoList = arrayList;
        if (pushInfoArr != null) {
            arrayList.addAll(Arrays.asList(pushInfoArr));
        }
    }

    private List<PushInfo> jsonArrayToArrayList(JsonArray jsonArray) {
        final ArrayList arrayList = new ArrayList();
        final Gson gson = new Gson();
        jsonArray.iterator().forEachRemaining(new Consumer() { // from class: com.samsung.scsp.framework.core.identity.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PushInfoList.lambda$jsonArrayToArrayList$1(arrayList, gson, (JsonElement) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$jsonArrayToArrayList$1(List list, Gson gson, JsonElement jsonElement) {
        list.add((PushInfo) gson.fromJson(jsonElement.toString(), PushInfo.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toJsonArray$0(JsonArray jsonArray, PushInfo pushInfo) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", pushInfo.getId());
        jsonObject.addProperty("type", pushInfo.getType());
        jsonObject.addProperty("token", pushInfo.getToken());
        jsonArray.add(jsonObject);
    }

    public void add(PushInfo pushInfo) {
        this.pushInfoList.add(pushInfo);
    }

    public List<PushInfo> getPushInfoList() {
        return this.pushInfoList;
    }

    public JsonArray toJsonArray() {
        JsonArray jsonArray = new JsonArray();
        this.pushInfoList.forEach(new C11664i(jsonArray, 1));
        return jsonArray;
    }

    public PushInfoList(String str) {
        this.pushInfoList = new ArrayList();
        this.pushInfoList = jsonArrayToArrayList((JsonArray) new Gson().fromJson(str, JsonArray.class));
    }

    public PushInfoList(List<PushInfo> list) {
        new ArrayList();
        this.pushInfoList = list;
    }
}
