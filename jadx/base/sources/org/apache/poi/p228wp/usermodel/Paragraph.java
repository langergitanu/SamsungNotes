package org.apache.poi.p228wp.usermodel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Paragraph {
    int getFirstLineIndent();

    int getFontAlignment();

    int getIndentFromLeft();

    int getIndentFromRight();

    boolean isWordWrapped();

    void setFirstLineIndent(int i);

    void setFontAlignment(int i);

    void setIndentFromLeft(int i);

    void setIndentFromRight(int i);

    void setWordWrapped(boolean z);
}
