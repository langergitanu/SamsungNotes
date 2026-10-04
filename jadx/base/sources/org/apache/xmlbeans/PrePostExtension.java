package org.apache.xmlbeans;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface PrePostExtension {
    public static final int OPERATION_INSERT = 2;
    public static final int OPERATION_REMOVE = 3;
    public static final int OPERATION_SET = 1;

    String getStaticHandler();

    boolean hasPostCall();

    boolean hasPreCall();
}
