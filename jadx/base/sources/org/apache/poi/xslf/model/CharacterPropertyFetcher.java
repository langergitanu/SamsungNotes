package org.apache.poi.xslf.model;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class CharacterPropertyFetcher<T> extends ParagraphPropertyFetcher<T> {
    public CharacterPropertyFetcher(int i) {
        super(i);
    }

    public abstract boolean fetch(CTTextCharacterProperties cTTextCharacterProperties);

    @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
    public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
        if (cTTextParagraphProperties == null || !cTTextParagraphProperties.isSetDefRPr()) {
            return false;
        }
        return fetch(cTTextParagraphProperties.getDefRPr());
    }
}
