package net.lingala.zip4j.crypto.PBKDF2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class PBKDF2HexFormatter {
    public boolean fromString(PBKDF2Parameters pBKDF2Parameters, String str) {
        String[] strArrSplit;
        if (pBKDF2Parameters == null || str == null || (strArrSplit = str.split(":")) == null || strArrSplit.length != 3) {
            return true;
        }
        byte[] bArrHex2bin = BinTools.hex2bin(strArrSplit[0]);
        int i = Integer.parseInt(strArrSplit[1]);
        byte[] bArrHex2bin2 = BinTools.hex2bin(strArrSplit[2]);
        pBKDF2Parameters.setSalt(bArrHex2bin);
        pBKDF2Parameters.setIterationCount(i);
        pBKDF2Parameters.setDerivedKey(bArrHex2bin2);
        return false;
    }

    public String toString(PBKDF2Parameters pBKDF2Parameters) {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(BinTools.bin2hex(pBKDF2Parameters.getSalt())));
        stringBuffer.append(":");
        stringBuffer.append(String.valueOf(pBKDF2Parameters.getIterationCount()));
        stringBuffer.append(":");
        stringBuffer.append(BinTools.bin2hex(pBKDF2Parameters.getDerivedKey()));
        return stringBuffer.toString();
    }
}
