package com.nimbusds.jose;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ActionRequiredForJWSCompletionException extends JOSEException {
    private final CompletableJWSObjectSigning completableSigning;
    private final JWSSignerOption option;

    public ActionRequiredForJWSCompletionException(String str, JWSSignerOption jWSSignerOption, CompletableJWSObjectSigning completableJWSObjectSigning) {
        super(str);
        if (jWSSignerOption == null) {
            throw new IllegalArgumentException("The triggering option must not be null");
        }
        this.option = jWSSignerOption;
        if (completableJWSObjectSigning == null) {
            throw new IllegalArgumentException("The completable signing must not be null");
        }
        this.completableSigning = completableJWSObjectSigning;
    }

    public CompletableJWSObjectSigning getCompletableJWSObjectSigning() {
        return this.completableSigning;
    }

    public JWSSignerOption getTriggeringOption() {
        return this.option;
    }
}
