package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.core.smartcard.ApduException;
import com.yubico.yubikit.piv.InvalidPinException;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import com.yubico.yubikit.piv.jca.PivProvider;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class YubiKitSmartcardSession implements ISmartcardSession {
    private static final short APDU_EXCEPTION_ERROR_CODE_FILE_NOT_FOUND = 27266;
    private static final String TAG = "YubiKitSmartcardSession";
    private static final String YUBIKEY_PROVIDER = "YKPiv";
    private final PivSession piv;

    public YubiKitSmartcardSession(@NonNull PivSession pivSession) {
        this.piv = pivSession;
    }

    private void getAndPutCertDetailsInList(@NonNull Slot slot, @NonNull PivSession pivSession, @NonNull List<ICertDetails> list) throws ApduException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAndPutCertDetailsInList", new StringBuilder());
        try {
            list.add(new YubiKitCertDetails(pivSession.getCertificate(slot), slot));
        } catch (ApduException e) {
            if (e.getSw() != 27266) {
                throw e;
            }
            Logger.verbose(strM1170p, slot + " slot is empty.");
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ISmartcardSession
    @NonNull
    public List<ICertDetails> getCertDetailsList() throws ApduException {
        ArrayList arrayList = new ArrayList();
        getAndPutCertDetailsInList(Slot.AUTHENTICATION, this.piv, arrayList);
        getAndPutCertDetailsInList(Slot.SIGNATURE, this.piv, arrayList);
        getAndPutCertDetailsInList(Slot.KEY_MANAGEMENT, this.piv, arrayList);
        getAndPutCertDetailsInList(Slot.CARD_AUTH, this.piv, arrayList);
        return arrayList;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ISmartcardSession
    @NonNull
    public PrivateKey getKeyForAuth(@NonNull ICertDetails iCertDetails, @NonNull char[] cArr) throws Exception {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getKeyForAuth", new StringBuilder());
        if (!(iCertDetails instanceof YubiKitCertDetails)) {
            throw new Exception("certDetails is not of type YubiKitCertDetails.");
        }
        KeyStore keyStore = KeyStore.getInstance(YUBIKEY_PROVIDER, new PivProvider(this.piv));
        keyStore.load(null);
        Key key = keyStore.getKey(((YubiKitCertDetails) iCertDetails).getSlot().getStringAlias(), cArr);
        if (key instanceof PivPrivateKey) {
            return (PivPrivateKey) key;
        }
        Logger.error(strM1170p, "Private key retrieved from YKPiv keystore is not of type PivPrivateKey.", null);
        throw new Exception("Private key retrieved from YKPiv keystore is not of type PivPrivateKey.");
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ISmartcardSession
    public int getPinAttemptsRemaining() {
        return this.piv.getPinAttempts();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ISmartcardSession
    public boolean verifyPin(@NonNull char[] cArr) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":verifyPin", new StringBuilder());
        try {
            this.piv.verifyPin(cArr);
            return true;
        } catch (InvalidPinException unused) {
            Logger.info(strM1170p, "Incorrect PIN entered.");
            return false;
        }
    }
}
