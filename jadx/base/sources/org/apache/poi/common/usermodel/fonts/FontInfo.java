package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface FontInfo {
    FontCharset getCharset();

    FontFamily getFamily();

    Integer getIndex();

    FontPitch getPitch();

    String getTypeface();

    void setCharset(FontCharset fontCharset);

    void setFamily(FontFamily fontFamily);

    void setIndex(int i);

    void setPitch(FontPitch fontPitch);

    void setTypeface(String str);
}
