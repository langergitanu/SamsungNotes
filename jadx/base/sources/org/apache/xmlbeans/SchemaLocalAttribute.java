package org.apache.xmlbeans;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaLocalAttribute extends SchemaField, SchemaAnnotated {
    public static final int OPTIONAL = 2;
    public static final int PROHIBITED = 1;
    public static final int REQUIRED = 3;

    int getUse();
}
