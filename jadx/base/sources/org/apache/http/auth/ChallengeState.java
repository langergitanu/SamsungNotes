package org.apache.http.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum ChallengeState {
    TARGET,
    PROXY;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ChallengeState[] valuesCustom() {
        ChallengeState[] challengeStateArrValuesCustom = values();
        int length = challengeStateArrValuesCustom.length;
        ChallengeState[] challengeStateArr = new ChallengeState[length];
        System.arraycopy(challengeStateArrValuesCustom, 0, challengeStateArr, 0, length);
        return challengeStateArr;
    }
}
