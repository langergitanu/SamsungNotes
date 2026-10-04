package com.samsung.android.app.sdk.deepsky.textextraction.translate.data;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult;", "", "()V", "Error", "Success", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Success;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class ImageTranslationResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult;", "code", "", "(I)V", "getCode", "()I", "EmptyBlockList", "RendererFail", "RequestLanguagePackDownload", "Unknown", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static abstract class Error extends ImageTranslationResult {
        private final int code;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error$EmptyBlockList;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final /* data */ class EmptyBlockList extends Error {
            private final int code;

            public EmptyBlockList() {
                this(0, 1, null);
            }

            public static /* synthetic */ EmptyBlockList copy$default(EmptyBlockList emptyBlockList, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = emptyBlockList.getCode();
                }
                return emptyBlockList.copy(i);
            }

            public final int component1() {
                return getCode();
            }

            @NotNull
            public final EmptyBlockList copy(int code) {
                return new EmptyBlockList(code);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EmptyBlockList) && getCode() == ((EmptyBlockList) other).getCode();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult.Error
            public int getCode() {
                return this.code;
            }

            public int hashCode() {
                return Integer.hashCode(getCode());
            }

            @NotNull
            public String toString() {
                return AbstractC0541b.m767i(getCode(), "EmptyBlockList(code=", ")");
            }

            public EmptyBlockList(int i) {
                super(i);
                this.code = i;
            }

            public /* synthetic */ EmptyBlockList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? -200 : i);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error$RendererFail;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final /* data */ class RendererFail extends Error {
            private final int code;

            public RendererFail() {
                this(0, 1, null);
            }

            public static /* synthetic */ RendererFail copy$default(RendererFail rendererFail, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = rendererFail.getCode();
                }
                return rendererFail.copy(i);
            }

            public final int component1() {
                return getCode();
            }

            @NotNull
            public final RendererFail copy(int code) {
                return new RendererFail(code);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RendererFail) && getCode() == ((RendererFail) other).getCode();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult.Error
            public int getCode() {
                return this.code;
            }

            public int hashCode() {
                return Integer.hashCode(getCode());
            }

            @NotNull
            public String toString() {
                return AbstractC0541b.m767i(getCode(), "RendererFail(code=", ")");
            }

            public RendererFail(int i) {
                super(i);
                this.code = i;
            }

            public /* synthetic */ RendererFail(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? -300 : i);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error$RequestLanguagePackDownload;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final /* data */ class RequestLanguagePackDownload extends Error {
            private final int code;

            public RequestLanguagePackDownload() {
                this(0, 1, null);
            }

            public static /* synthetic */ RequestLanguagePackDownload copy$default(RequestLanguagePackDownload requestLanguagePackDownload, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = requestLanguagePackDownload.getCode();
                }
                return requestLanguagePackDownload.copy(i);
            }

            public final int component1() {
                return getCode();
            }

            @NotNull
            public final RequestLanguagePackDownload copy(int code) {
                return new RequestLanguagePackDownload(code);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RequestLanguagePackDownload) && getCode() == ((RequestLanguagePackDownload) other).getCode();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult.Error
            public int getCode() {
                return this.code;
            }

            public int hashCode() {
                return Integer.hashCode(getCode());
            }

            @NotNull
            public String toString() {
                return AbstractC0541b.m767i(getCode(), "RequestLanguagePackDownload(code=", ")");
            }

            public RequestLanguagePackDownload(int i) {
                super(i);
                this.code = i;
            }

            public /* synthetic */ RequestLanguagePackDownload(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? -100 : i);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error$Unknown;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final /* data */ class Unknown extends Error {
            private final int code;

            public Unknown() {
                this(0, 1, null);
            }

            public static /* synthetic */ Unknown copy$default(Unknown unknown, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = unknown.getCode();
                }
                return unknown.copy(i);
            }

            public final int component1() {
                return getCode();
            }

            @NotNull
            public final Unknown copy(int code) {
                return new Unknown(code);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Unknown) && getCode() == ((Unknown) other).getCode();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult.Error
            public int getCode() {
                return this.code;
            }

            public int hashCode() {
                return Integer.hashCode(getCode());
            }

            @NotNull
            public String toString() {
                return AbstractC0541b.m767i(getCode(), "Unknown(code=", ")");
            }

            public Unknown(int i) {
                super(i);
                this.code = i;
            }

            public /* synthetic */ Unknown(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? -400 : i);
            }
        }

        public Error(int i) {
            super(null);
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Success;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult;", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class Success extends ImageTranslationResult {
        private final int code;

        public Success() {
            this(0, 1, null);
        }

        public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = success.code;
            }
            return success.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final Success copy(int code) {
            return new Success(code);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && this.code == ((Success) other).code;
        }

        public final int getCode() {
            return this.code;
        }

        public int hashCode() {
            return Integer.hashCode(this.code);
        }

        @NotNull
        public String toString() {
            return AbstractC0541b.m767i(this.code, "Success(code=", ")");
        }

        public Success(int i) {
            super(null);
            this.code = i;
        }

        public /* synthetic */ Success(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 100 : i);
        }
    }

    public /* synthetic */ ImageTranslationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ImageTranslationResult() {
    }
}
