package org.ccil.cowan.tagsoup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ScanHandler {
    void adup(char[] cArr, int i, int i2);

    void aname(char[] cArr, int i, int i2);

    void aval(char[] cArr, int i, int i2);

    void cdsect(char[] cArr, int i, int i2);

    void cmnt(char[] cArr, int i, int i2);

    void decl(char[] cArr, int i, int i2);

    void entity(char[] cArr, int i, int i2);

    void eof(char[] cArr, int i, int i2);

    void etag(char[] cArr, int i, int i2);

    int getEntity();

    /* JADX INFO: renamed from: gi */
    void mo14972gi(char[] cArr, int i, int i2);

    void pcdata(char[] cArr, int i, int i2);

    /* JADX INFO: renamed from: pi */
    void mo14973pi(char[] cArr, int i, int i2);

    void pitarget(char[] cArr, int i, int i2);

    void stagc(char[] cArr, int i, int i2);

    void stage(char[] cArr, int i, int i2);
}
