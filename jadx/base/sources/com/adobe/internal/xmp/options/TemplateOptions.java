package com.adobe.internal.xmp.options;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class TemplateOptions extends Options {
    public static final int ADD_NEW_PROPERTIES = 64;
    public static final int CLEAR_UNNAMED_PROPERTIES = 2;
    public static final int INCLUDE_INTERNAL_PROPERTIES = 32;
    public static final int REPLACE_EXISTING_PROPERTIES = 16;
    public static final int REPLACE_WITH_DELETE_EMPTY = 128;

    public TemplateOptions() {
    }

    @Override // com.adobe.internal.xmp.options.Options
    public String defineOptionName(int i) {
        if (i == 2) {
            return "CLEAR_UNNAMED_PROPERTIES";
        }
        if (i == 16) {
            return "REPLACE_EXISTING_PROPERTIES";
        }
        if (i == 32) {
            return "INCLUDE_INTERNAL_PROPERTIES";
        }
        if (i == 64) {
            return "ADD_NEW_PROPERTIES";
        }
        if (i != 128) {
            return null;
        }
        return "REPLACE_WITH_DELETE_EMPTY";
    }

    @Override // com.adobe.internal.xmp.options.Options
    public int getValidOptions() {
        return 242;
    }

    public TemplateOptions(int i) {
        super(i);
    }
}
