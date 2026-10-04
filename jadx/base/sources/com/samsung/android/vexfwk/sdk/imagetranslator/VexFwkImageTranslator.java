package com.samsung.android.vexfwk.sdk.imagetranslator;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.util.Size;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.firebase.messaging.Constants;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.samsung.android.app.sdk.deepsky.search.C7027b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.imagetranslation.LanguagePackInstaller;
import com.samsung.android.vexfwk.imagetranslation.VexFwkAvailableLanguage;
import com.samsung.android.vexfwk.imagetranslation.VexFwkIImageTranslatorCapabilities;
import com.samsung.android.vexfwk.imagetranslation.VexFwkLanguagePackInfo;
import com.samsung.android.vexfwk.imagetranslation.VexFwkTranslationCommandType;
import com.samsung.android.vexfwk.imagetranslation.VexFwkTranslationResultCode;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkLanguageCapabilities;
import com.samsung.android.vexfwk.param.VexFwkLanguageDirection;
import com.samsung.android.vexfwk.param.VexFwkLanguageDirections;
import com.samsung.android.vexfwk.param.VexFwkOcrResult;
import com.samsung.android.vexfwk.param.VexFwkRequiredLanguages;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkProvider;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0000J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\n2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ6\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\n2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020%J=\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\n\"\u0004\b\u0000\u0010'2\u0006\u0010(\u001a\u0002H'2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u000e2\u0006\u0010+\u001a\u00020%H\u0002¢\u0006\u0002\u0010,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "availableSize", "Landroid/util/Size;", "defaultAvailableSize", "sizeLimitation", "", "configure", "getAvailableLanguages", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities;", "getAvailableSourceLanguageTo", "targetLang", "", "getAvailableTargetLanguageFrom", "sourceLang", "isAvailableSize", "", "width", "height", "showInstallPopup", "", "activityContext", "Landroid/content/Context;", "requiredLanguagePack", "", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkLanguagePackInfo;", "showInstallPopupAsync", "Ljava/lang/Void;", "translate", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult;", "image", "Landroid/graphics/Bitmap;", "fromLang", "toLang", "vexFwkOcrResult", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "translateImpl", "T", "buffer", Constants.MessagePayloadKeys.FROM, "to", "ocrResult", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;)Ljava/util/concurrent/CompletableFuture;", "Companion", "TranslationResult", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkImageTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageTranslator.kt\ncom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,380:1\n1#2:381\n766#3:382\n857#3,2:383\n766#3:385\n857#3,2:386\n*S KotlinDebug\n*F\n+ 1 VexFwkImageTranslator.kt\ncom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator\n*L\n269#1:382\n269#1:383,2\n314#1:385\n314#1:386,2\n*E\n"})
public final class VexFwkImageTranslator extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_IMAGE = 1;

    @NotNull
    private Size availableSize;

    @NotNull
    private final Size defaultAvailableSize;
    private int sizeLimitation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkImageTranslator";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.IMAGE_TRANSLATION);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkImageTranslator.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult;", "", "()V", "Error", "Success", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Success;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static abstract class TranslationResult {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult;", "()V", "InvalidDirection", "LanguagePackRequired", "Others", "UnsupportedImageSize", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$InvalidDirection;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$LanguagePackRequired;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$Others;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$UnsupportedImageSize;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static abstract class Error extends TranslationResult {

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$InvalidDirection;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
            public static final /* data */ class InvalidDirection extends Error {

                @NotNull
                private final String message;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public InvalidDirection(@NotNull String message) {
                    super(null);
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.message = message;
                }

                public static /* synthetic */ InvalidDirection copy$default(InvalidDirection invalidDirection, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = invalidDirection.message;
                    }
                    return invalidDirection.copy(str);
                }

                @NotNull
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getMessage() {
                    return this.message;
                }

                @NotNull
                public final InvalidDirection copy(@NotNull String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    return new InvalidDirection(message);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof InvalidDirection) && Intrinsics.areEqual(this.message, ((InvalidDirection) other).message);
                }

                @NotNull
                public final String getMessage() {
                    return this.message;
                }

                public int hashCode() {
                    return this.message.hashCode();
                }

                @NotNull
                public String toString() {
                    return AbstractC0541b.m773o("InvalidDirection(message=", this.message, ")");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$LanguagePackRequired;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error;", "requiredLanguages", "", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkLanguagePackInfo;", "(Ljava/util/List;)V", "getRequiredLanguages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
            public static final /* data */ class LanguagePackRequired extends Error {

                @NotNull
                private final List<VexFwkLanguagePackInfo> requiredLanguages;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public LanguagePackRequired(@NotNull List<VexFwkLanguagePackInfo> requiredLanguages) {
                    super(null);
                    Intrinsics.checkNotNullParameter(requiredLanguages, "requiredLanguages");
                    this.requiredLanguages = requiredLanguages;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ LanguagePackRequired copy$default(LanguagePackRequired languagePackRequired, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = languagePackRequired.requiredLanguages;
                    }
                    return languagePackRequired.copy(list);
                }

                @NotNull
                public final List<VexFwkLanguagePackInfo> component1() {
                    return this.requiredLanguages;
                }

                @NotNull
                public final LanguagePackRequired copy(@NotNull List<VexFwkLanguagePackInfo> requiredLanguages) {
                    Intrinsics.checkNotNullParameter(requiredLanguages, "requiredLanguages");
                    return new LanguagePackRequired(requiredLanguages);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof LanguagePackRequired) && Intrinsics.areEqual(this.requiredLanguages, ((LanguagePackRequired) other).requiredLanguages);
                }

                @NotNull
                public final List<VexFwkLanguagePackInfo> getRequiredLanguages() {
                    return this.requiredLanguages;
                }

                public int hashCode() {
                    return this.requiredLanguages.hashCode();
                }

                @NotNull
                public String toString() {
                    return "LanguagePackRequired(requiredLanguages=" + this.requiredLanguages + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$Others;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
            public static final /* data */ class Others extends Error {

                @NotNull
                private final String message;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Others(@NotNull String message) {
                    super(null);
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.message = message;
                }

                public static /* synthetic */ Others copy$default(Others others, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = others.message;
                    }
                    return others.copy(str);
                }

                @NotNull
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getMessage() {
                    return this.message;
                }

                @NotNull
                public final Others copy(@NotNull String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    return new Others(message);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Others) && Intrinsics.areEqual(this.message, ((Others) other).message);
                }

                @NotNull
                public final String getMessage() {
                    return this.message;
                }

                public int hashCode() {
                    return this.message.hashCode();
                }

                @NotNull
                public String toString() {
                    return AbstractC0541b.m773o("Others(message=", this.message, ")");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error$UnsupportedImageSize;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Error;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
            public static final /* data */ class UnsupportedImageSize extends Error {

                @NotNull
                private final String message;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public UnsupportedImageSize(@NotNull String message) {
                    super(null);
                    Intrinsics.checkNotNullParameter(message, "message");
                    this.message = message;
                }

                public static /* synthetic */ UnsupportedImageSize copy$default(UnsupportedImageSize unsupportedImageSize, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = unsupportedImageSize.message;
                    }
                    return unsupportedImageSize.copy(str);
                }

                @NotNull
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getMessage() {
                    return this.message;
                }

                @NotNull
                public final UnsupportedImageSize copy(@NotNull String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    return new UnsupportedImageSize(message);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof UnsupportedImageSize) && Intrinsics.areEqual(this.message, ((UnsupportedImageSize) other).message);
                }

                @NotNull
                public final String getMessage() {
                    return this.message;
                }

                public int hashCode() {
                    return this.message.hashCode();
                }

                @NotNull
                public String toString() {
                    return AbstractC0541b.m773o("UnsupportedImageSize(message=", this.message, ")");
                }
            }

            public /* synthetic */ Error(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Success;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult;", "image", "Landroid/graphics/Bitmap;", "translatedDirections", "", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageDirection;", "vexFwkOcrResult", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "(Landroid/graphics/Bitmap;Ljava/util/List;Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;)V", "getImage", "()Landroid/graphics/Bitmap;", "getTranslatedDirections", "()Ljava/util/List;", "getVexFwkOcrResult", "()Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final /* data */ class Success extends TranslationResult {

            @NotNull
            private final Bitmap image;

            @NotNull
            private final List<VexFwkLanguageDirection> translatedDirections;

            @NotNull
            private final VexFwkOcrResult vexFwkOcrResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(@NotNull Bitmap image, @NotNull List<VexFwkLanguageDirection> translatedDirections, @NotNull VexFwkOcrResult vexFwkOcrResult) {
                super(null);
                Intrinsics.checkNotNullParameter(image, "image");
                Intrinsics.checkNotNullParameter(translatedDirections, "translatedDirections");
                Intrinsics.checkNotNullParameter(vexFwkOcrResult, "vexFwkOcrResult");
                this.image = image;
                this.translatedDirections = translatedDirections;
                this.vexFwkOcrResult = vexFwkOcrResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, Bitmap bitmap, List list, VexFwkOcrResult vexFwkOcrResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    bitmap = success.image;
                }
                if ((i & 2) != 0) {
                    list = success.translatedDirections;
                }
                if ((i & 4) != 0) {
                    vexFwkOcrResult = success.vexFwkOcrResult;
                }
                return success.copy(bitmap, list, vexFwkOcrResult);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Bitmap getImage() {
                return this.image;
            }

            @NotNull
            public final List<VexFwkLanguageDirection> component2() {
                return this.translatedDirections;
            }

            @NotNull
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final VexFwkOcrResult getVexFwkOcrResult() {
                return this.vexFwkOcrResult;
            }

            @NotNull
            public final Success copy(@NotNull Bitmap image, @NotNull List<VexFwkLanguageDirection> translatedDirections, @NotNull VexFwkOcrResult vexFwkOcrResult) {
                Intrinsics.checkNotNullParameter(image, "image");
                Intrinsics.checkNotNullParameter(translatedDirections, "translatedDirections");
                Intrinsics.checkNotNullParameter(vexFwkOcrResult, "vexFwkOcrResult");
                return new Success(image, translatedDirections, vexFwkOcrResult);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.image, success.image) && Intrinsics.areEqual(this.translatedDirections, success.translatedDirections) && Intrinsics.areEqual(this.vexFwkOcrResult, success.vexFwkOcrResult);
            }

            @NotNull
            public final Bitmap getImage() {
                return this.image;
            }

            @NotNull
            public final List<VexFwkLanguageDirection> getTranslatedDirections() {
                return this.translatedDirections;
            }

            @NotNull
            public final VexFwkOcrResult getVexFwkOcrResult() {
                return this.vexFwkOcrResult;
            }

            public int hashCode() {
                return this.vexFwkOcrResult.hashCode() + AbstractC0622a.m1159e(this.translatedDirections, this.image.hashCode() * 31, 31);
            }

            @NotNull
            public String toString() {
                return "Success(image=" + this.image + ", translatedDirections=" + this.translatedDirections + ", vexFwkOcrResult=" + this.vexFwkOcrResult + ")";
            }
        }

        public /* synthetic */ TranslationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TranslationResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VexFwkTranslationResultCode.values().length];
            try {
                iArr[VexFwkTranslationResultCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VexFwkTranslationResultCode.INVALID_DIRECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VexFwkTranslationResultCode.LANGUAGE_PACK_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VexFwkImageTranslator() {
        Size size = new Size(5000, 5000);
        this.defaultAvailableSize = size;
        this.sizeLimitation = size.getHeight() * size.getWidth();
        this.availableSize = new Size(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkLanguageCapabilities getAvailableLanguages$lambda$38(VexFwkImageTranslator this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.i(str, "get available languages E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(new VexFwkSessionRequest.Sync.Builder(), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator$getAvailableLanguages$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkMetadataNative vexFwkMetadataNative) {
                invoke2(vexFwkMetadataNative);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkMetadataNative setSettingMetadata) {
                Intrinsics.checkNotNullParameter(setSettingMetadata, "$this$setSettingMetadata");
                setSettingMetadata.set(VexFwkMetadataKey.TRANSLATION_COMMAND_TYPE.INSTANCE, Integer.valueOf(VexFwkTranslationCommandType.COMMAND_TYPE_LANGUAGE_LIST.getValue()));
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.TRANSLATION_UTIL).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                VexFwkLanguageCapabilities vexFwkLanguageCapabilities = (VexFwkLanguageCapabilities) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.TRANSLATION_CAPABILITIES.INSTANCE);
                if (vexFwkLanguageCapabilities == null) {
                    vexFwkLanguageCapabilities = new VexFwkLanguageCapabilities(new LinkedList());
                }
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                Log.i(str, "get available languages X");
                return vexFwkLanguageCapabilities;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkLanguageCapabilities getAvailableSourceLanguageTo$lambda$31(final String targetLang, VexFwkImageTranslator this$0) throws Throwable {
        VexFwkLanguageCapabilities vexFwkLanguageCapabilities;
        Intrinsics.checkNotNullParameter(targetLang, "$targetLang");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.i(str, "get available languages to " + targetLang + " E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(new VexFwkSessionRequest.Sync.Builder(), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator$getAvailableSourceLanguageTo$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkMetadataNative vexFwkMetadataNative) {
                invoke2(vexFwkMetadataNative);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkMetadataNative setSettingMetadata) {
                Intrinsics.checkNotNullParameter(setSettingMetadata, "$this$setSettingMetadata");
                setSettingMetadata.set(VexFwkMetadataKey.TRANSLATION_COMMAND_TYPE.INSTANCE, Integer.valueOf(VexFwkTranslationCommandType.COMMAND_TYPE_LANGUAGE_LIST.getValue()));
                setSettingMetadata.set(VexFwkMetadataKey.OUTPUT_PATH.INSTANCE, targetLang);
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.TRANSLATION_UTIL).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                VexFwkLanguageCapabilities vexFwkLanguageCapabilities2 = (VexFwkLanguageCapabilities) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.TRANSLATION_CAPABILITIES.INSTANCE);
                if (vexFwkLanguageCapabilities2 == null) {
                    vexFwkLanguageCapabilities = new VexFwkLanguageCapabilities(new LinkedList());
                } else {
                    List listDistinct = CollectionsKt.distinct(vexFwkLanguageCapabilities2);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listDistinct) {
                        if (!Intrinsics.areEqual(((VexFwkAvailableLanguage) obj).getLang(), targetLang)) {
                            arrayList.add(obj);
                        }
                    }
                    vexFwkLanguageCapabilities = new VexFwkLanguageCapabilities(new LinkedList(arrayList));
                }
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                AbstractC4539a.m3207q("get available languages to ", targetLang, " X", TAG);
                return vexFwkLanguageCapabilities;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkLanguageCapabilities getAvailableTargetLanguageFrom$lambda$23(final String sourceLang, VexFwkImageTranslator this$0) throws Throwable {
        VexFwkLanguageCapabilities vexFwkLanguageCapabilities;
        Intrinsics.checkNotNullParameter(sourceLang, "$sourceLang");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.i(str, "get available languages from " + sourceLang + " E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(new VexFwkSessionRequest.Sync.Builder(), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator$getAvailableTargetLanguageFrom$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkMetadataNative vexFwkMetadataNative) {
                invoke2(vexFwkMetadataNative);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkMetadataNative setSettingMetadata) {
                Intrinsics.checkNotNullParameter(setSettingMetadata, "$this$setSettingMetadata");
                setSettingMetadata.set(VexFwkMetadataKey.TRANSLATION_COMMAND_TYPE.INSTANCE, Integer.valueOf(VexFwkTranslationCommandType.COMMAND_TYPE_LANGUAGE_LIST.getValue()));
                setSettingMetadata.set(VexFwkMetadataKey.INPUT_PATH.INSTANCE, sourceLang);
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.TRANSLATION_UTIL).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                VexFwkLanguageCapabilities vexFwkLanguageCapabilities2 = (VexFwkLanguageCapabilities) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.TRANSLATION_CAPABILITIES.INSTANCE);
                if (vexFwkLanguageCapabilities2 == null) {
                    vexFwkLanguageCapabilities = new VexFwkLanguageCapabilities(new LinkedList());
                } else {
                    List listDistinct = CollectionsKt.distinct(vexFwkLanguageCapabilities2);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listDistinct) {
                        if (!Intrinsics.areEqual(((VexFwkAvailableLanguage) obj).getLang(), sourceLang)) {
                            arrayList.add(obj);
                        }
                    }
                    vexFwkLanguageCapabilities = new VexFwkLanguageCapabilities(new LinkedList(arrayList));
                }
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                AbstractC4539a.m3207q("get available languages from ", sourceLang, " X", TAG);
                return vexFwkLanguageCapabilities;
            } finally {
            }
        } finally {
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    private final boolean isAvailableSize(int width, int height) {
        if (this.availableSize.getWidth() == 0 || this.availableSize.getHeight() == 0) {
            VexFwkIImageTranslatorCapabilities vexFwkIImageTranslatorCapabilities = (VexFwkIImageTranslatorCapabilities) VexFwkProvider.INSTANCE.fetchProperties(VexFwkUsecase.IMAGE_TRANSLATION).getOrElse(VexFwkMetadataKey.PROPERTY_IMAGE_TRANSLATION_CAPABILITIES.INSTANCE, new C8416h(13));
            Log.d(TAG, "imageTranslatorCapabilities : " + vexFwkIImageTranslatorCapabilities);
            Integer num = vexFwkIImageTranslatorCapabilities.get(0);
            Intrinsics.checkNotNullExpressionValue(num, "get(...)");
            int iIntValue = num.intValue();
            Integer num2 = vexFwkIImageTranslatorCapabilities.get(1);
            Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
            Size size = new Size(iIntValue, num2.intValue());
            this.availableSize = size;
            if (size.getWidth() != 0 && this.availableSize.getHeight() != 0) {
                this.sizeLimitation = this.availableSize.getHeight() * this.availableSize.getWidth();
            }
        }
        return width * height <= this.sizeLimitation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkIImageTranslatorCapabilities isAvailableSize$lambda$41$lambda$39() {
        return new VexFwkIImageTranslatorCapabilities(new int[]{0, 0});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showInstallPopupAsync$lambda$14(VexFwkImageTranslator this$0) throws Throwable {
        final String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = TAG;
        Log.i(str2, "showInstallPopupAsync E");
        str = "translate";
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(new VexFwkSessionRequest.Sync.Builder(), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator$showInstallPopupAsync$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkMetadataNative vexFwkMetadataNative) {
                invoke2(vexFwkMetadataNative);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkMetadataNative setSettingMetadata) {
                Intrinsics.checkNotNullParameter(setSettingMetadata, "$this$setSettingMetadata");
                setSettingMetadata.set(VexFwkMetadataKey.TRANSLATION_COMMAND_TYPE.INSTANCE, Integer.valueOf(VexFwkTranslationCommandType.COMMAND_TYPE_STRING_RESOURCE.getValue()));
                setSettingMetadata.set(VexFwkMetadataKey.STRING_RESOURCE_NAME.INSTANCE, str);
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.TRANSLATION_UTIL).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str2, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                String str3 = (String) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.STRING_RESOURCE.INSTANCE);
                str = str3 != null ? str3 : "translate";
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                return str;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInstallPopupAsync$lambda$15(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ CompletableFuture translate$default(VexFwkImageTranslator vexFwkImageTranslator, Bitmap bitmap, String str, String str2, VexFwkOcrResult vexFwkOcrResult, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            vexFwkOcrResult = new VexFwkOcrResult(CollectionsKt.emptyList());
        }
        return vexFwkImageTranslator.translate(bitmap, str, str2, vexFwkOcrResult);
    }

    private final <T> CompletableFuture<TranslationResult> translateImpl(final T buffer, final String from, final String to, final VexFwkOcrResult ocrResult) {
        CompletableFuture<TranslationResult> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new Supplier() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return VexFwkImageTranslator.translateImpl$lambda$8(buffer, this, from, to, ocrResult);
            }
        });
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TranslationResult translateImpl$lambda$8(Object obj, VexFwkImageTranslator this$0, final String str, final String str2, final VexFwkOcrResult ocrResult) throws Throwable {
        Size size;
        TranslationResult success;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ocrResult, "$ocrResult");
        String str3 = TAG;
        Log.i(str3, "image translation E");
        if (obj instanceof Image) {
            Image image = (Image) obj;
            size = new Size(image.getWidth(), image.getHeight());
        } else {
            if (!(obj instanceof Bitmap)) {
                throw new IllegalArgumentException("Unsupported image type");
            }
            Bitmap bitmap = (Bitmap) obj;
            size = new Size(bitmap.getWidth(), bitmap.getHeight());
        }
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(size.getWidth(), size.getHeight(), 1, null);
        boolean zIsAvailableSize = this$0.isAvailableSize(vexFwkBitmapHardware.getWidth(), vexFwkBitmapHardware.getHeight());
        if (!zIsAvailableSize) {
            Log.w(str3, "Maximum pixel size: " + this$0.sizeLimitation);
            success = new TranslationResult.Error.UnsupportedImageSize(AbstractC0000a.m11h(this$0.sizeLimitation, "Maximum pixel size: "));
        } else {
            if (!zIsAvailableSize) {
                throw new NoWhenBranchMatchedException();
            }
            VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj), 1, vexFwkBitmapHardware.getBitmap()), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator$translateImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VexFwkMetadataNative vexFwkMetadataNative) {
                    invoke2(vexFwkMetadataNative);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull VexFwkMetadataNative setSettingMetadata) {
                    Intrinsics.checkNotNullParameter(setSettingMetadata, "$this$setSettingMetadata");
                    String str4 = str;
                    if (str4 != null) {
                        setSettingMetadata.set(VexFwkMetadataKey.INPUT_PATH.INSTANCE, str4);
                    }
                    String str5 = str2;
                    if (str5 != null) {
                        setSettingMetadata.set(VexFwkMetadataKey.OUTPUT_PATH.INSTANCE, str5);
                    }
                    setSettingMetadata.set(VexFwkMetadataKey.OCR_RESULT.INSTANCE, ocrResult);
                }
            })).build();
            try {
                Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.IMAGE_TRANSLATION).m22200processRequestIoAF18A(syncBuild);
                AutoCloseableKt.closeFinally(syncBuild, null);
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.e(str3, "Failed to process request : " + thM22218exceptionOrNullimpl);
                    throw thM22218exceptionOrNullimpl;
                }
                VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
                try {
                    Object obj2 = vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.TRANSLATION_RESULT_CODE.INSTANCE);
                    Intrinsics.checkNotNull(obj2);
                    int i = WhenMappings.$EnumSwitchMapping$0[VexFwkTranslationResultCode.INSTANCE.fromInt(((Number) obj2).intValue()).ordinal()];
                    if (i != 1) {
                        String str4 = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                        if (i == 2) {
                            String str5 = (String) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.TRANSLATION_ERROR_MESSAGE.INSTANCE);
                            if (str5 != null) {
                                str4 = str5;
                            }
                            success = new TranslationResult.Error.InvalidDirection(str4);
                        } else if (i != 3) {
                            String str6 = (String) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.TRANSLATION_ERROR_MESSAGE.INSTANCE);
                            if (str6 != null) {
                                str4 = str6;
                            }
                            success = new TranslationResult.Error.Others(str4);
                        } else {
                            List listEmptyList = (VexFwkRequiredLanguages) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.REQUIRED_LANGUAGES.INSTANCE);
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            success = new TranslationResult.Error.LanguagePackRequired(listEmptyList);
                        }
                    } else {
                        Bitmap bitmapCropped = vexFwkBitmapHardware.toBitmapCropped(0, 0, vexFwkBitmapHardware.getWidth(), vexFwkBitmapHardware.getHeight(), Bitmap.Config.ARGB_8888);
                        List listEmptyList2 = (VexFwkLanguageDirections) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.LANGUAGE_DIRECTIONS.INSTANCE);
                        if (listEmptyList2 == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        VexFwkOcrResult vexFwkOcrResult = (VexFwkOcrResult) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.OCR_RESULT.INSTANCE);
                        if (vexFwkOcrResult == null) {
                            vexFwkOcrResult = new VexFwkOcrResult(CollectionsKt.emptyList());
                        }
                        success = new TranslationResult.Success(bitmapCropped, listEmptyList2, vexFwkOcrResult);
                    }
                    AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                    Log.i(str3, "image translation X");
                } finally {
                }
            } finally {
            }
        }
        vexFwkBitmapHardware.close();
        return success;
    }

    @NotNull
    public final VexFwkImageTranslator configure() {
        return (VexFwkImageTranslator) configureWith(this, new Function1<VexFwkImageTranslator, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkImageTranslator vexFwkImageTranslator) {
                invoke2(vexFwkImageTranslator);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkImageTranslator configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.IMAGE_TRANSLATION, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator.configure.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                        VexFwkStreamType vexFwkStreamType = VexFwkStreamType.BUFFER;
                        VexFwkStreamUsage vexFwkStreamUsage = VexFwkStreamUsage.IMAGE;
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 0, vexFwkStreamType, vexFwkStreamUsage, 0, 0, 0, null, 120, null);
                        VexFwkSessionConfigRequest.Builder.addOutputStream$default(createSession, 1, vexFwkStreamType, vexFwkStreamUsage, 0, 0, 0, null, 120, null);
                    }
                });
                configureWith.createSession(VexFwkUsecase.TRANSLATION_UTIL, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator.configure.1.2
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
    }

    @NotNull
    public final CompletableFuture<VexFwkLanguageCapabilities> getAvailableLanguages() {
        CompletableFuture<VexFwkLanguageCapabilities> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11586c(this, 0));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    @NotNull
    public final CompletableFuture<VexFwkLanguageCapabilities> getAvailableSourceLanguageTo(@NotNull String targetLang) {
        Intrinsics.checkNotNullParameter(targetLang, "targetLang");
        CompletableFuture<VexFwkLanguageCapabilities> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11585b(targetLang, this, 1));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    @NotNull
    public final CompletableFuture<VexFwkLanguageCapabilities> getAvailableTargetLanguageFrom(@NotNull String sourceLang) {
        Intrinsics.checkNotNullParameter(sourceLang, "sourceLang");
        CompletableFuture<VexFwkLanguageCapabilities> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11585b(sourceLang, this, 0));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    public final void showInstallPopup(@NotNull Context activityContext, @NotNull List<VexFwkLanguagePackInfo> requiredLanguagePack) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(requiredLanguagePack, "requiredLanguagePack");
        try {
            showInstallPopupAsync(activityContext, requiredLanguagePack).get(5L, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.w(TAG, "showInstallPopup: ", e);
        }
    }

    @NotNull
    public final CompletableFuture<Void> showInstallPopupAsync(@NotNull final Context activityContext, @NotNull final List<VexFwkLanguagePackInfo> requiredLanguagePack) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(requiredLanguagePack, "requiredLanguagePack");
        CompletableFuture<Void> completableFutureThenAccept = CompletableFuture.supplyAsync(new C11586c(this, 1)).thenAccept((Consumer) new C7027b(new Function1<String, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator.showInstallPopupAsync.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) throws IOException {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) throws IOException {
                List<VexFwkLanguagePackInfo> list = requiredLanguagePack;
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((VexFwkLanguagePackInfo) it.next()).getLanguagePackCode());
                }
                List listDistinct = CollectionsKt.distinct(arrayList);
                if (listDistinct.size() > 2) {
                    new LanguagePackInstaller(activityContext).goToLangPackDownload((ArrayList) CollectionsKt___CollectionsKt.toCollection(listDistinct, new ArrayList()));
                    return;
                }
                LanguagePackInstaller languagePackInstaller = new LanguagePackInstaller(activityContext);
                String strM13955n = CollectionsKt.m13955n(listDistinct, ",", null, null, null, 62);
                Intrinsics.checkNotNull(str);
                languagePackInstaller.requestLangPackDownload(strM13955n, str);
            }
        }, 1));
        Intrinsics.checkNotNullExpressionValue(completableFutureThenAccept, "thenAccept(...)");
        return completableFutureThenAccept;
    }

    @NotNull
    public final CompletableFuture<TranslationResult> translate(@NotNull Bitmap image, @Nullable String fromLang, @Nullable String toLang, @NotNull VexFwkOcrResult vexFwkOcrResult) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(vexFwkOcrResult, "vexFwkOcrResult");
        return translateImpl(image, fromLang, toLang, vexFwkOcrResult);
    }
}
