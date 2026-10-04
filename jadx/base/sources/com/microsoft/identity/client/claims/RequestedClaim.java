package com.microsoft.identity.client.claims;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RequestedClaim {
    private RequestedClaimAdditionalInformation mInformation;
    private String mName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestedClaim)) {
            return false;
        }
        RequestedClaim requestedClaim = (RequestedClaim) obj;
        if (!this.mName.equals(requestedClaim.mName)) {
            return false;
        }
        RequestedClaimAdditionalInformation requestedClaimAdditionalInformation = this.mInformation;
        RequestedClaimAdditionalInformation requestedClaimAdditionalInformation2 = requestedClaim.mInformation;
        return requestedClaimAdditionalInformation != null ? requestedClaimAdditionalInformation.equals(requestedClaimAdditionalInformation2) : requestedClaimAdditionalInformation2 == null;
    }

    public RequestedClaimAdditionalInformation getAdditionalInformation() {
        return this.mInformation;
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        int iHashCode = this.mName.hashCode() * 31;
        RequestedClaimAdditionalInformation requestedClaimAdditionalInformation = this.mInformation;
        return iHashCode + (requestedClaimAdditionalInformation != null ? requestedClaimAdditionalInformation.hashCode() : 0);
    }

    public void setAdditionalInformation(RequestedClaimAdditionalInformation requestedClaimAdditionalInformation) {
        this.mInformation = requestedClaimAdditionalInformation;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
