package com.samsung.android.sdk.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum RecognizerApi {
    IS_PRINTED(0, "isPrinted"),
    IS_HANDWRITTEN(1, "isHandwritten"),
    HAS_TEXT1(2, "hasText1"),
    HAS_TEXT2(3, "hasText2"),
    DETECT_TEXT(4, "detectText"),
    DETECT(5, "detect"),
    DETECT_BLOCK2(6, "detectBlock2"),
    DETECT_BLOCK3(7, "detectBlock3"),
    RECOGNIZE(8, "recognize"),
    RECOGNIZE_BLOCK_AT(9, "recognizeBlockAt"),
    CANCEL(10, "cancel"),
    CLOSE(11, "close");

    private final int apiIndex;
    private final String apiName;

    RecognizerApi(int i, String str) {
        this.apiIndex = i;
        this.apiName = str;
    }

    public static RecognizerApi from(String str) {
        for (RecognizerApi recognizerApi : values()) {
            if (str.equals(recognizerApi.toName())) {
                return recognizerApi;
            }
        }
        return IS_HANDWRITTEN;
    }

    public int toIndex() {
        return this.apiIndex;
    }

    public String toName() {
        return this.apiName;
    }
}
