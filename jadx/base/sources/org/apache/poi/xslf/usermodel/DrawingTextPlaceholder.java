package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class DrawingTextPlaceholder extends DrawingTextBody {
    private final CTPlaceholder placeholder;

    public DrawingTextPlaceholder(CTTextBody cTTextBody, CTPlaceholder cTPlaceholder) {
        super(cTTextBody);
        this.placeholder = cTPlaceholder;
    }

    public String getPlaceholderType() {
        return this.placeholder.getType().toString();
    }

    public STPlaceholderType.Enum getPlaceholderTypeEnum() {
        return this.placeholder.getType();
    }

    public boolean isPlaceholderCustom() {
        return this.placeholder.getHasCustomPrompt();
    }
}
