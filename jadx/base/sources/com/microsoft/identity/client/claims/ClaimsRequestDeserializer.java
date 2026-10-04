package com.microsoft.identity.client.claims;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class ClaimsRequestDeserializer implements JsonDeserializer<ClaimsRequest> {
    private void addProperties(List<RequestedClaim> list, JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonObject == null) {
            return;
        }
        for (String str : jsonObject.keySet()) {
            RequestedClaim requestedClaim = new RequestedClaim();
            requestedClaim.setName(str);
            if (!(jsonObject.get(str) instanceof JsonNull)) {
                requestedClaim.setAdditionalInformation((RequestedClaimAdditionalInformation) jsonDeserializationContext.deserialize(jsonObject.getAsJsonObject(str), RequestedClaimAdditionalInformation.class));
            }
            list.add(requestedClaim);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ClaimsRequest deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        ClaimsRequest claimsRequest = new ClaimsRequest();
        addProperties(claimsRequest.getAccessTokenClaimsRequested(), jsonElement.getAsJsonObject().getAsJsonObject("access_token"), jsonDeserializationContext);
        addProperties(claimsRequest.getIdTokenClaimsRequested(), jsonElement.getAsJsonObject().getAsJsonObject("id_token"), jsonDeserializationContext);
        addProperties(claimsRequest.getUserInfoClaimsRequested(), jsonElement.getAsJsonObject().getAsJsonObject(ClaimsRequest.USERINFO), jsonDeserializationContext);
        return claimsRequest;
    }
}
