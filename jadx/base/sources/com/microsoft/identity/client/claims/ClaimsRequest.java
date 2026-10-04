package com.microsoft.identity.client.claims;

import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ClaimsRequest {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String ID_TOKEN = "id_token";
    public static final String USERINFO = "userinfo";
    private List<RequestedClaim> mUserInfoClaimsRequested = new ArrayList();
    private List<RequestedClaim> mAccessTokenClaimsRequested = new ArrayList();
    private List<RequestedClaim> mIdTokenClaimsRequested = new ArrayList();

    private static ClaimsRequest deserializeClaimsRequest(@Nullable String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ClaimsRequest.class, new ClaimsRequestDeserializer());
        return (ClaimsRequest) gsonBuilder.create().fromJson(str, ClaimsRequest.class);
    }

    public static ClaimsRequest getClaimsRequestFromJsonString(String str) {
        return deserializeClaimsRequest(str);
    }

    public static String getJsonStringFromClaimsRequest(@Nullable ClaimsRequest claimsRequest) {
        return serializeClaimsRequest(claimsRequest);
    }

    private void requestClaimIn(List<RequestedClaim> list, String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        RequestedClaim requestedClaim = new RequestedClaim();
        requestedClaim.setName(str);
        requestedClaim.setAdditionalInformation(requestedClaimAdditionalInformation);
        list.add(requestedClaim);
    }

    private static String serializeClaimsRequest(@Nullable ClaimsRequest claimsRequest) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        ClaimsRequestSerializer claimsRequestSerializer = new ClaimsRequestSerializer();
        RequestClaimAdditionalInformationSerializer requestClaimAdditionalInformationSerializer = new RequestClaimAdditionalInformationSerializer();
        gsonBuilder.registerTypeAdapter(ClaimsRequest.class, claimsRequestSerializer);
        gsonBuilder.registerTypeAdapter(RequestedClaimAdditionalInformation.class, requestClaimAdditionalInformationSerializer);
        gsonBuilder.serializeNulls();
        Gson gsonCreate = gsonBuilder.create();
        if (claimsRequest != null) {
            return gsonCreate.toJson(claimsRequest);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClaimsRequest)) {
            return false;
        }
        ClaimsRequest claimsRequest = (ClaimsRequest) obj;
        List<RequestedClaim> list = this.mUserInfoClaimsRequested;
        if (list == null ? claimsRequest.mUserInfoClaimsRequested != null : !list.equals(claimsRequest.mUserInfoClaimsRequested)) {
            return false;
        }
        List<RequestedClaim> list2 = this.mAccessTokenClaimsRequested;
        if (list2 == null ? claimsRequest.mAccessTokenClaimsRequested != null : !list2.equals(claimsRequest.mAccessTokenClaimsRequested)) {
            return false;
        }
        List<RequestedClaim> list3 = this.mIdTokenClaimsRequested;
        List<RequestedClaim> list4 = claimsRequest.mIdTokenClaimsRequested;
        return list3 != null ? list3.equals(list4) : list4 == null;
    }

    public List<RequestedClaim> getAccessTokenClaimsRequested() {
        return this.mAccessTokenClaimsRequested;
    }

    public List<RequestedClaim> getIdTokenClaimsRequested() {
        return this.mIdTokenClaimsRequested;
    }

    public List<RequestedClaim> getUserInfoClaimsRequested() {
        return this.mUserInfoClaimsRequested;
    }

    public int hashCode() {
        List<RequestedClaim> list = this.mUserInfoClaimsRequested;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<RequestedClaim> list2 = this.mAccessTokenClaimsRequested;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<RequestedClaim> list3 = this.mIdTokenClaimsRequested;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public void requestClaimInAccessToken(String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        requestClaimIn(this.mAccessTokenClaimsRequested, str, requestedClaimAdditionalInformation);
    }

    public void requestClaimInIdToken(String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        requestClaimIn(this.mIdTokenClaimsRequested, str, requestedClaimAdditionalInformation);
    }

    public void requestClaimInUserInfo(String str, RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        requestClaimIn(this.mUserInfoClaimsRequested, str, requestedClaimAdditionalInformation);
    }
}
