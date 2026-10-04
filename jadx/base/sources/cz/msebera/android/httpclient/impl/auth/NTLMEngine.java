package cz.msebera.android.httpclient.impl.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NTLMEngine {
    String generateType1Msg(String str, String str2);

    String generateType3Msg(String str, String str2, String str3, String str4, String str5);
}
