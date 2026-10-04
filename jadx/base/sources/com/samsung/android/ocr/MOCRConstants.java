package com.samsung.android.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCRConstants {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MOCREngineType {
        None(-1),
        Stride(0);

        private final int value;

        MOCREngineType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MOCRImageType {
        Generic(0),
        SPenInput(1),
        HorizontalDocument(2);

        private final int value;

        MOCRImageType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MOCRLanguageMode {
        Auto(0),
        ImageLevel(1),
        LineLevel(2);

        private final int value;

        MOCRLanguageMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MOCRPxlFmt {
        ARGB8888(0),
        NV21(1),
        RGBA8888(2),
        RGB(3);

        private final int value;

        MOCRPxlFmt(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MOCRSTRBackbone {
        Auto(0),
        CRNN(1),
        ViT(2);

        private final int value;

        MOCRSTRBackbone(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MOCRStatus {
        MOCRSuccess(0),
        MOCRModelReadError(1),
        MOCRModelPropertiesError(2),
        MOCRModelCharsetError(3),
        MOCRModelNotInitError(4),
        MOCRModelConfigureError(1),
        MOCRModelExecutionError(2),
        MOCRUnsupportedFormat(3),
        MOCRNoResultText(11),
        MOCRNoTextDetection(12),
        MOCRActiveEngineError(13),
        MOCRUnknownError(-1);

        private final int value;

        MOCRStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
