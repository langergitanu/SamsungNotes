package com.vladsch.flexmark.html.renderer;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkStatus {
    private final String myName;
    public static final LinkStatus UNKNOWN = new LinkStatus("UNKNOWN");
    public static final LinkStatus VALID = new LinkStatus("VALID");
    public static final LinkStatus INVALID = new LinkStatus("INVALID");
    public static final LinkStatus UNCHECKED = new LinkStatus("UNCHECKED");
    public static final LinkStatus NOT_FOUND = new LinkStatus(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_NOT_FOUND);

    public LinkStatus(@NotNull String str) {
        this.myName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LinkStatus) {
            return this.myName.equals(((LinkStatus) obj).myName);
        }
        return false;
    }

    @NotNull
    public String getName() {
        return this.myName;
    }

    public int hashCode() {
        return this.myName.hashCode();
    }

    public boolean isStatus(CharSequence charSequence) {
        return this.myName.equals(charSequence instanceof String ? (String) charSequence : String.valueOf(charSequence));
    }
}
