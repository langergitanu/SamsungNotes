package com.samsung.android.vexfwk.metadata;

import android.graphics.PointF;
import android.util.Size;
import com.samsung.android.vexfwk.docscan.VexFwkDocRefinerCapabilities;
import com.samsung.android.vexfwk.imageeffect.VexFwkImageEffectCapabilities;
import com.samsung.android.vexfwk.imagetranslation.VexFwkIImageTranslatorCapabilities;
import com.samsung.android.vexfwk.param.VexFwkBokehEffectParams;
import com.samsung.android.vexfwk.param.VexFwkDocumentCorners;
import com.samsung.android.vexfwk.param.VexFwkDocumentScanRect;
import com.samsung.android.vexfwk.param.VexFwkImageClipperInfo;
import com.samsung.android.vexfwk.param.VexFwkImageEffectParams;
import com.samsung.android.vexfwk.param.VexFwkImageTaggerResult;
import com.samsung.android.vexfwk.param.VexFwkLanguageCapabilities;
import com.samsung.android.vexfwk.param.VexFwkLanguageCodes;
import com.samsung.android.vexfwk.param.VexFwkLanguageDirection;
import com.samsung.android.vexfwk.param.VexFwkLanguageDirections;
import com.samsung.android.vexfwk.param.VexFwkNodeResultCode;
import com.samsung.android.vexfwk.param.VexFwkOcrResult;
import com.samsung.android.vexfwk.param.VexFwkParamBoolean;
import com.samsung.android.vexfwk.param.VexFwkParamInteger;
import com.samsung.android.vexfwk.param.VexFwkParamIntegerArray;
import com.samsung.android.vexfwk.param.VexFwkParamLong;
import com.samsung.android.vexfwk.param.VexFwkParamPointF;
import com.samsung.android.vexfwk.param.VexFwkParamSize;
import com.samsung.android.vexfwk.param.VexFwkParamString;
import com.samsung.android.vexfwk.param.VexFwkRequiredLanguages;
import com.samsung.android.vexfwk.param.VexFwkSegmentMap;
import com.samsung.android.vexfwk.param.VexFwkWineInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\u00020\u0002:(\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01234567B)\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001'89:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^¨\u0006_"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "T", "", "name", "", "converter", "Lcom/samsung/android/vexfwk/metadata/IVexFwkMetadataConverter;", "tag", "", "(Ljava/lang/String;Lcom/samsung/android/vexfwk/metadata/IVexFwkMetadataConverter;Ljava/lang/Integer;)V", "getConverter", "()Lcom/samsung/android/vexfwk/metadata/IVexFwkMetadataConverter;", "getName", "()Ljava/lang/String;", "getTag", "()I", "AILASSO_TOUCH_COORDINATE", "Companion", "DOCUMENT_DEWARP_MODE", "DOCUMENT_RECT", "DOCUMENT_REFINE_COLOR_FILTER_TYPE", "DOCUMENT_REFINE_ENHANCE", "DOCUMENT_SCAN_RECT", "DOCUMENT_SCAN_STABILITY", "FRAME_TIMESTAMP_NS", "IMAGE_CLIPPER_INFO", "IMAGE_EFFECT_PARAMS", "IMAGE_SIZE", "IMAGE_TAGGER_RESULT", "INPUT_PATH", "LANGUAGE_CODES", "LANGUAGE_DIRECTION", "LANGUAGE_DIRECTIONS", "MEDIA_SCAN", "OCR_RESULT", "OUTPUT_PATH", "PORTRAIT_BOKEH_EFFECT", "PROPERTY_DOC_REFINER_CAPABILITIES", "PROPERTY_IMAGE_EFFECT_CAPABILITIES", "PROPERTY_IMAGE_TRANSLATION_CAPABILITIES", "PROPERTY_IS_AVAILABLE", "REQUIRED_LANGUAGES", "RESULT_CODE", "ROTATION_DEGREE", "SEGMENT_CATEGORY_MAP", "SESSION_OPERATION_TYPE", "SESSION_SUPPORT_OPERATION_TYPES", "STRING_RESOURCE", "STRING_RESOURCE_NAME", "TRANSLATION_CAPABILITIES", "TRANSLATION_COMMAND_TYPE", "TRANSLATION_ERROR_MESSAGE", "TRANSLATION_RESULT_CODE", "UPSAMPLE_FACTOR", "VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS", "WINE_INFO", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$AILASSO_TOUCH_COORDINATE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_DEWARP_MODE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_RECT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_REFINE_COLOR_FILTER_TYPE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_REFINE_ENHANCE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_SCAN_RECT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_SCAN_STABILITY;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$FRAME_TIMESTAMP_NS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_CLIPPER_INFO;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_EFFECT_PARAMS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_SIZE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_TAGGER_RESULT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$INPUT_PATH;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$LANGUAGE_CODES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$LANGUAGE_DIRECTION;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$LANGUAGE_DIRECTIONS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$MEDIA_SCAN;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$OCR_RESULT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$OUTPUT_PATH;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PORTRAIT_BOKEH_EFFECT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_DOC_REFINER_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_IMAGE_EFFECT_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_IMAGE_TRANSLATION_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_IS_AVAILABLE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$REQUIRED_LANGUAGES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$RESULT_CODE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$ROTATION_DEGREE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$SEGMENT_CATEGORY_MAP;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$SESSION_OPERATION_TYPE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$SESSION_SUPPORT_OPERATION_TYPES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$STRING_RESOURCE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$STRING_RESOURCE_NAME;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_COMMAND_TYPE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_ERROR_MESSAGE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_RESULT_CODE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$UPSAMPLE_FACTOR;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$WINE_INFO;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class VexFwkMetadataKey<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAG_MESSAGE_START = 0;
    private static final int TAG_PROPERTY_START = 131072;
    private static final int TAG_SESSION_START = 65536;

    @NotNull
    private final IVexFwkMetadataConverter<T> converter;

    @NotNull
    private final String name;
    private final int tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$AILASSO_TOUCH_COORDINATE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Landroid/graphics/PointF;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class AILASSO_TOUCH_COORDINATE extends VexFwkMetadataKey<PointF> {

        @NotNull
        public static final AILASSO_TOUCH_COORDINATE INSTANCE = new AILASSO_TOUCH_COORDINATE();

        private AILASSO_TOUCH_COORDINATE() {
            super("vexfwk.message.touchCoordinate", VexFwkParamPointF.INSTANCE, 14, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof AILASSO_TOUCH_COORDINATE);
        }

        public int hashCode() {
            return -1486647658;
        }

        @NotNull
        public String toString() {
            return "AILASSO_TOUCH_COORDINATE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0086\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$Companion;", "", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "()V", "TAG_MESSAGE_START", "", "TAG_PROPERTY_START", "TAG_SESSION_START", "iterator", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkMetadataKey.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkMetadataKey.kt\ncom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1603#2,9:296\n1855#2:305\n1856#2:307\n1612#2:308\n1#3:306\n*S KotlinDebug\n*F\n+ 1 VexFwkMetadataKey.kt\ncom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$Companion\n*L\n282#1:296,9\n282#1:305\n282#1:307\n282#1:308\n282#1:306\n*E\n"})
    public static final class Companion implements Iterable<VexFwkMetadataKey<?>>, KMappedMarker {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<VexFwkMetadataKey<?>> iterator() {
            List<KClass<? extends T>> sealedSubclasses = Reflection.getOrCreateKotlinClass(VexFwkMetadataKey.class).getSealedSubclasses();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = sealedSubclasses.iterator();
            while (it.hasNext()) {
                VexFwkMetadataKey vexFwkMetadataKey = (VexFwkMetadataKey) ((KClass) it.next()).getObjectInstance();
                if (vexFwkMetadataKey != null) {
                    arrayList.add(vexFwkMetadataKey);
                }
            }
            return arrayList.iterator();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_DEWARP_MODE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DOCUMENT_DEWARP_MODE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final DOCUMENT_DEWARP_MODE INSTANCE = new DOCUMENT_DEWARP_MODE();

        private DOCUMENT_DEWARP_MODE() {
            super("vexfwk.message.documentDewarpMode", VexFwkParamInteger.INSTANCE, 13, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DOCUMENT_DEWARP_MODE);
        }

        public int hashCode() {
            return -129699450;
        }

        @NotNull
        public String toString() {
            return "DOCUMENT_DEWARP_MODE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_RECT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DOCUMENT_RECT extends VexFwkMetadataKey<VexFwkDocumentCorners> {

        @NotNull
        public static final DOCUMENT_RECT INSTANCE = new DOCUMENT_RECT();

        private DOCUMENT_RECT() {
            super("vexfwk.message.documentRect", VexFwkDocumentCorners.INSTANCE, 0, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DOCUMENT_RECT);
        }

        public int hashCode() {
            return -2058948969;
        }

        @NotNull
        public String toString() {
            return "DOCUMENT_RECT";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_REFINE_COLOR_FILTER_TYPE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DOCUMENT_REFINE_COLOR_FILTER_TYPE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final DOCUMENT_REFINE_COLOR_FILTER_TYPE INSTANCE = new DOCUMENT_REFINE_COLOR_FILTER_TYPE();

        private DOCUMENT_REFINE_COLOR_FILTER_TYPE() {
            super("vexfwk.message.documentRefineColorFilterType", VexFwkParamInteger.INSTANCE, 10, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DOCUMENT_REFINE_COLOR_FILTER_TYPE);
        }

        public int hashCode() {
            return 1830234246;
        }

        @NotNull
        public String toString() {
            return "DOCUMENT_REFINE_COLOR_FILTER_TYPE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_REFINE_ENHANCE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DOCUMENT_REFINE_ENHANCE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final DOCUMENT_REFINE_ENHANCE INSTANCE = new DOCUMENT_REFINE_ENHANCE();

        private DOCUMENT_REFINE_ENHANCE() {
            super("vexfwk.message.documentRefineEnhance", VexFwkParamInteger.INSTANCE, 9, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DOCUMENT_REFINE_ENHANCE);
        }

        public int hashCode() {
            return 79394735;
        }

        @NotNull
        public String toString() {
            return "DOCUMENT_REFINE_ENHANCE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_SCAN_RECT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkDocumentScanRect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DOCUMENT_SCAN_RECT extends VexFwkMetadataKey<VexFwkDocumentScanRect> {

        @NotNull
        public static final DOCUMENT_SCAN_RECT INSTANCE = new DOCUMENT_SCAN_RECT();

        private DOCUMENT_SCAN_RECT() {
            super("vexfwk.message.documentScanRect", VexFwkDocumentScanRect.INSTANCE, 1, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DOCUMENT_SCAN_RECT);
        }

        public int hashCode() {
            return 1331899795;
        }

        @NotNull
        public String toString() {
            return "DOCUMENT_SCAN_RECT";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$DOCUMENT_SCAN_STABILITY;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DOCUMENT_SCAN_STABILITY extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final DOCUMENT_SCAN_STABILITY INSTANCE = new DOCUMENT_SCAN_STABILITY();

        private DOCUMENT_SCAN_STABILITY() {
            super("vexfwk.message.documentScanStability", VexFwkParamInteger.INSTANCE, 11, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DOCUMENT_SCAN_STABILITY);
        }

        public int hashCode() {
            return -1048309446;
        }

        @NotNull
        public String toString() {
            return "DOCUMENT_SCAN_STABILITY";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$FRAME_TIMESTAMP_NS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class FRAME_TIMESTAMP_NS extends VexFwkMetadataKey<Long> {

        @NotNull
        public static final FRAME_TIMESTAMP_NS INSTANCE = new FRAME_TIMESTAMP_NS();

        private FRAME_TIMESTAMP_NS() {
            super("vexfwk.message.frameTimestampNs", VexFwkParamLong.INSTANCE, 2, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof FRAME_TIMESTAMP_NS);
        }

        public int hashCode() {
            return 911215793;
        }

        @NotNull
        public String toString() {
            return "FRAME_TIMESTAMP_NS";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_CLIPPER_INFO;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkImageClipperInfo;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class IMAGE_CLIPPER_INFO extends VexFwkMetadataKey<VexFwkImageClipperInfo> {

        @NotNull
        public static final IMAGE_CLIPPER_INFO INSTANCE = new IMAGE_CLIPPER_INFO();

        private IMAGE_CLIPPER_INFO() {
            super("vexfwk.message.imageClipperInfo", VexFwkImageClipperInfo.INSTANCE, 31, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof IMAGE_CLIPPER_INFO);
        }

        public int hashCode() {
            return 1813551061;
        }

        @NotNull
        public String toString() {
            return "IMAGE_CLIPPER_INFO";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_EFFECT_PARAMS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkImageEffectParams;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class IMAGE_EFFECT_PARAMS extends VexFwkMetadataKey<VexFwkImageEffectParams> {

        @NotNull
        public static final IMAGE_EFFECT_PARAMS INSTANCE = new IMAGE_EFFECT_PARAMS();

        private IMAGE_EFFECT_PARAMS() {
            super("vexfwk.property.imageEffectParams", VexFwkImageEffectParams.INSTANCE, 35, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof IMAGE_EFFECT_PARAMS);
        }

        public int hashCode() {
            return -1402868545;
        }

        @NotNull
        public String toString() {
            return "IMAGE_EFFECT_PARAMS";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_SIZE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Landroid/util/Size;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class IMAGE_SIZE extends VexFwkMetadataKey<Size> {

        @NotNull
        public static final IMAGE_SIZE INSTANCE = new IMAGE_SIZE();

        private IMAGE_SIZE() {
            super("vexfwk.message.imageSize", VexFwkParamSize.INSTANCE, 12, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof IMAGE_SIZE);
        }

        public int hashCode() {
            return 117134038;
        }

        @NotNull
        public String toString() {
            return "IMAGE_SIZE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$IMAGE_TAGGER_RESULT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkImageTaggerResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class IMAGE_TAGGER_RESULT extends VexFwkMetadataKey<VexFwkImageTaggerResult> {

        @NotNull
        public static final IMAGE_TAGGER_RESULT INSTANCE = new IMAGE_TAGGER_RESULT();

        private IMAGE_TAGGER_RESULT() {
            super("vexfwk.message.imageTaggerResult", VexFwkImageTaggerResult.INSTANCE, 33, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof IMAGE_TAGGER_RESULT);
        }

        public int hashCode() {
            return 1501035341;
        }

        @NotNull
        public String toString() {
            return "IMAGE_TAGGER_RESULT";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$INPUT_PATH;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class INPUT_PATH extends VexFwkMetadataKey<String> {

        @NotNull
        public static final INPUT_PATH INSTANCE = new INPUT_PATH();

        private INPUT_PATH() {
            super("vexfwk.message.inputPath", VexFwkParamString.INSTANCE, 17, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof INPUT_PATH);
        }

        public int hashCode() {
            return -1348479509;
        }

        @NotNull
        public String toString() {
            return "INPUT_PATH";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$LANGUAGE_CODES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageCodes;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class LANGUAGE_CODES extends VexFwkMetadataKey<VexFwkLanguageCodes> {

        @NotNull
        public static final LANGUAGE_CODES INSTANCE = new LANGUAGE_CODES();

        private LANGUAGE_CODES() {
            super("vexfwk.message.languageCodes", VexFwkLanguageCodes.INSTANCE, 23, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof LANGUAGE_CODES);
        }

        public int hashCode() {
            return -1220513232;
        }

        @NotNull
        public String toString() {
            return "LANGUAGE_CODES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$LANGUAGE_DIRECTION;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageDirection;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class LANGUAGE_DIRECTION extends VexFwkMetadataKey<VexFwkLanguageDirection> {

        @NotNull
        public static final LANGUAGE_DIRECTION INSTANCE = new LANGUAGE_DIRECTION();

        private LANGUAGE_DIRECTION() {
            super("vexfwk.message.languageDirection", VexFwkLanguageDirection.INSTANCE, 20, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof LANGUAGE_DIRECTION);
        }

        public int hashCode() {
            return 1765166217;
        }

        @NotNull
        public String toString() {
            return "LANGUAGE_DIRECTION";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$LANGUAGE_DIRECTIONS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageDirections;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class LANGUAGE_DIRECTIONS extends VexFwkMetadataKey<VexFwkLanguageDirections> {

        @NotNull
        public static final LANGUAGE_DIRECTIONS INSTANCE = new LANGUAGE_DIRECTIONS();

        private LANGUAGE_DIRECTIONS() {
            super("vexfwk.message.languageDirections", VexFwkLanguageDirections.INSTANCE, 21, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof LANGUAGE_DIRECTIONS);
        }

        public int hashCode() {
            return -1114422038;
        }

        @NotNull
        public String toString() {
            return "LANGUAGE_DIRECTIONS";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$MEDIA_SCAN;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class MEDIA_SCAN extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final MEDIA_SCAN INSTANCE = new MEDIA_SCAN();

        private MEDIA_SCAN() {
            super("vexfwk.message.mediaScan", VexFwkParamInteger.INSTANCE, 19, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof MEDIA_SCAN);
        }

        public int hashCode() {
            return -795205527;
        }

        @NotNull
        public String toString() {
            return "MEDIA_SCAN";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$OCR_RESULT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class OCR_RESULT extends VexFwkMetadataKey<VexFwkOcrResult> {

        @NotNull
        public static final OCR_RESULT INSTANCE = new OCR_RESULT();

        private OCR_RESULT() {
            super("vexfwk.message.ocrResult", VexFwkOcrResult.INSTANCE, 27, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof OCR_RESULT);
        }

        public int hashCode() {
            return -430836529;
        }

        @NotNull
        public String toString() {
            return "OCR_RESULT";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$OUTPUT_PATH;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class OUTPUT_PATH extends VexFwkMetadataKey<String> {

        @NotNull
        public static final OUTPUT_PATH INSTANCE = new OUTPUT_PATH();

        private OUTPUT_PATH() {
            super("vexfwk.message.outputPath", VexFwkParamString.INSTANCE, 18, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof OUTPUT_PATH);
        }

        public int hashCode() {
            return -597695374;
        }

        @NotNull
        public String toString() {
            return "OUTPUT_PATH";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PORTRAIT_BOKEH_EFFECT;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkBokehEffectParams;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class PORTRAIT_BOKEH_EFFECT extends VexFwkMetadataKey<VexFwkBokehEffectParams> {

        @NotNull
        public static final PORTRAIT_BOKEH_EFFECT INSTANCE = new PORTRAIT_BOKEH_EFFECT();

        private PORTRAIT_BOKEH_EFFECT() {
            super("vexfwk.message.portraitEffectParams", VexFwkBokehEffectParams.INSTANCE, 34, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof PORTRAIT_BOKEH_EFFECT);
        }

        public int hashCode() {
            return -1194818558;
        }

        @NotNull
        public String toString() {
            return "PORTRAIT_BOKEH_EFFECT";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_DOC_REFINER_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilities;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class PROPERTY_DOC_REFINER_CAPABILITIES extends VexFwkMetadataKey<VexFwkDocRefinerCapabilities> {

        @NotNull
        public static final PROPERTY_DOC_REFINER_CAPABILITIES INSTANCE = new PROPERTY_DOC_REFINER_CAPABILITIES();

        private PROPERTY_DOC_REFINER_CAPABILITIES() {
            super("vexfwk.property.docRefinerCapabilities", VexFwkDocRefinerCapabilities.INSTANCE, 131073, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof PROPERTY_DOC_REFINER_CAPABILITIES);
        }

        public int hashCode() {
            return -1720801104;
        }

        @NotNull
        public String toString() {
            return "PROPERTY_DOC_REFINER_CAPABILITIES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_IMAGE_EFFECT_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class PROPERTY_IMAGE_EFFECT_CAPABILITIES extends VexFwkMetadataKey<VexFwkImageEffectCapabilities> {

        @NotNull
        public static final PROPERTY_IMAGE_EFFECT_CAPABILITIES INSTANCE = new PROPERTY_IMAGE_EFFECT_CAPABILITIES();

        private PROPERTY_IMAGE_EFFECT_CAPABILITIES() {
            super("vexfwk.property.imageEffectCapabilities", VexFwkImageEffectCapabilities.INSTANCE, 131074, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof PROPERTY_IMAGE_EFFECT_CAPABILITIES);
        }

        public int hashCode() {
            return 17429511;
        }

        @NotNull
        public String toString() {
            return "PROPERTY_IMAGE_EFFECT_CAPABILITIES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_IMAGE_TRANSLATION_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkIImageTranslatorCapabilities;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class PROPERTY_IMAGE_TRANSLATION_CAPABILITIES extends VexFwkMetadataKey<VexFwkIImageTranslatorCapabilities> {

        @NotNull
        public static final PROPERTY_IMAGE_TRANSLATION_CAPABILITIES INSTANCE = new PROPERTY_IMAGE_TRANSLATION_CAPABILITIES();

        private PROPERTY_IMAGE_TRANSLATION_CAPABILITIES() {
            super("vexfwk.property.imageTranslatorCapabilities", VexFwkIImageTranslatorCapabilities.INSTANCE, 131075, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof PROPERTY_IMAGE_TRANSLATION_CAPABILITIES);
        }

        public int hashCode() {
            return 1385310241;
        }

        @NotNull
        public String toString() {
            return "PROPERTY_IMAGE_TRANSLATION_CAPABILITIES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$PROPERTY_IS_AVAILABLE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class PROPERTY_IS_AVAILABLE extends VexFwkMetadataKey<Boolean> {

        @NotNull
        public static final PROPERTY_IS_AVAILABLE INSTANCE = new PROPERTY_IS_AVAILABLE();

        private PROPERTY_IS_AVAILABLE() {
            super("vexfwk.property.isAvailable", VexFwkParamBoolean.INSTANCE, 131072, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof PROPERTY_IS_AVAILABLE);
        }

        public int hashCode() {
            return -322052851;
        }

        @NotNull
        public String toString() {
            return "PROPERTY_IS_AVAILABLE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$REQUIRED_LANGUAGES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkRequiredLanguages;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class REQUIRED_LANGUAGES extends VexFwkMetadataKey<VexFwkRequiredLanguages> {

        @NotNull
        public static final REQUIRED_LANGUAGES INSTANCE = new REQUIRED_LANGUAGES();

        private REQUIRED_LANGUAGES() {
            super("vexfwk.message.requiredLanguages", VexFwkRequiredLanguages.INSTANCE, 26, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof REQUIRED_LANGUAGES);
        }

        public int hashCode() {
            return 98846892;
        }

        @NotNull
        public String toString() {
            return "REQUIRED_LANGUAGES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$RESULT_CODE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkNodeResultCode;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class RESULT_CODE extends VexFwkMetadataKey<VexFwkNodeResultCode> {

        @NotNull
        public static final RESULT_CODE INSTANCE = new RESULT_CODE();

        private RESULT_CODE() {
            super("vexfwk.message.resultCode", VexFwkNodeResultCode.INSTANCE, 16, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof RESULT_CODE);
        }

        public int hashCode() {
            return -310734690;
        }

        @NotNull
        public String toString() {
            return "RESULT_CODE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$ROTATION_DEGREE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class ROTATION_DEGREE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final ROTATION_DEGREE INSTANCE = new ROTATION_DEGREE();

        private ROTATION_DEGREE() {
            super("vexfwk.message.rotationDegree", VexFwkParamInteger.INSTANCE, 4, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof ROTATION_DEGREE);
        }

        public int hashCode() {
            return 1721367292;
        }

        @NotNull
        public String toString() {
            return "ROTATION_DEGREE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$SEGMENT_CATEGORY_MAP;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "", "", "()V", "equals", "", "other", "", "hashCode", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class SEGMENT_CATEGORY_MAP extends VexFwkMetadataKey<Map<Integer, ? extends String>> {

        @NotNull
        public static final SEGMENT_CATEGORY_MAP INSTANCE = new SEGMENT_CATEGORY_MAP();

        private SEGMENT_CATEGORY_MAP() {
            super("vexfwk.message.segmentCategoryMap", VexFwkSegmentMap.INSTANCE, 32, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof SEGMENT_CATEGORY_MAP);
        }

        public int hashCode() {
            return -685743816;
        }

        @NotNull
        public String toString() {
            return "SEGMENT_CATEGORY_MAP";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$SESSION_OPERATION_TYPE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class SESSION_OPERATION_TYPE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final SESSION_OPERATION_TYPE INSTANCE = new SESSION_OPERATION_TYPE();

        private SESSION_OPERATION_TYPE() {
            super("vexfwk.session.operationType", VexFwkParamInteger.INSTANCE, 65536, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof SESSION_OPERATION_TYPE);
        }

        public int hashCode() {
            return 1537698028;
        }

        @NotNull
        public String toString() {
            return "SESSION_OPERATION_TYPE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$SESSION_SUPPORT_OPERATION_TYPES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class SESSION_SUPPORT_OPERATION_TYPES extends VexFwkMetadataKey<int[]> {

        @NotNull
        public static final SESSION_SUPPORT_OPERATION_TYPES INSTANCE = new SESSION_SUPPORT_OPERATION_TYPES();

        private SESSION_SUPPORT_OPERATION_TYPES() {
            super("vexfwk.session.supportOperationTypes", VexFwkParamIntegerArray.INSTANCE, 65537, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof SESSION_SUPPORT_OPERATION_TYPES);
        }

        public int hashCode() {
            return 1165161047;
        }

        @NotNull
        public String toString() {
            return "SESSION_SUPPORT_OPERATION_TYPES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$STRING_RESOURCE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class STRING_RESOURCE extends VexFwkMetadataKey<String> {

        @NotNull
        public static final STRING_RESOURCE INSTANCE = new STRING_RESOURCE();

        private STRING_RESOURCE() {
            super("vexfwk.message.stringResource", VexFwkParamString.INSTANCE, 28, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof STRING_RESOURCE);
        }

        public int hashCode() {
            return -1023936309;
        }

        @NotNull
        public String toString() {
            return "STRING_RESOURCE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$STRING_RESOURCE_NAME;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class STRING_RESOURCE_NAME extends VexFwkMetadataKey<String> {

        @NotNull
        public static final STRING_RESOURCE_NAME INSTANCE = new STRING_RESOURCE_NAME();

        private STRING_RESOURCE_NAME() {
            super("vexfwk.message.stringResourceName", VexFwkParamString.INSTANCE, 24, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof STRING_RESOURCE_NAME);
        }

        public int hashCode() {
            return 285866367;
        }

        @NotNull
        public String toString() {
            return "STRING_RESOURCE_NAME";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_CAPABILITIES;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkLanguageCapabilities;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class TRANSLATION_CAPABILITIES extends VexFwkMetadataKey<VexFwkLanguageCapabilities> {

        @NotNull
        public static final TRANSLATION_CAPABILITIES INSTANCE = new TRANSLATION_CAPABILITIES();

        private TRANSLATION_CAPABILITIES() {
            super("vexfwk.message.translationCapabilities", VexFwkLanguageCapabilities.INSTANCE, 22, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof TRANSLATION_CAPABILITIES);
        }

        public int hashCode() {
            return -768683211;
        }

        @NotNull
        public String toString() {
            return "TRANSLATION_CAPABILITIES";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_COMMAND_TYPE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class TRANSLATION_COMMAND_TYPE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final TRANSLATION_COMMAND_TYPE INSTANCE = new TRANSLATION_COMMAND_TYPE();

        private TRANSLATION_COMMAND_TYPE() {
            super("vexfwk.message.translationCommandType", VexFwkParamInteger.INSTANCE, 25, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof TRANSLATION_COMMAND_TYPE);
        }

        public int hashCode() {
            return -1590234291;
        }

        @NotNull
        public String toString() {
            return "TRANSLATION_COMMAND_TYPE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_ERROR_MESSAGE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class TRANSLATION_ERROR_MESSAGE extends VexFwkMetadataKey<String> {

        @NotNull
        public static final TRANSLATION_ERROR_MESSAGE INSTANCE = new TRANSLATION_ERROR_MESSAGE();

        private TRANSLATION_ERROR_MESSAGE() {
            super("vexfwk.message.errorMessage", VexFwkParamString.INSTANCE, 30, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof TRANSLATION_ERROR_MESSAGE);
        }

        public int hashCode() {
            return -1191888655;
        }

        @NotNull
        public String toString() {
            return "TRANSLATION_ERROR_MESSAGE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$TRANSLATION_RESULT_CODE;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class TRANSLATION_RESULT_CODE extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final TRANSLATION_RESULT_CODE INSTANCE = new TRANSLATION_RESULT_CODE();

        private TRANSLATION_RESULT_CODE() {
            super("vexfwk.message.translationResultCode", VexFwkParamInteger.INSTANCE, 29, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof TRANSLATION_RESULT_CODE);
        }

        public int hashCode() {
            return -623385232;
        }

        @NotNull
        public String toString() {
            return "TRANSLATION_RESULT_CODE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$UPSAMPLE_FACTOR;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class UPSAMPLE_FACTOR extends VexFwkMetadataKey<Integer> {

        @NotNull
        public static final UPSAMPLE_FACTOR INSTANCE = new UPSAMPLE_FACTOR();

        private UPSAMPLE_FACTOR() {
            super("vexfwk.message.upsampleFactor", VexFwkParamInteger.INSTANCE, 3, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof UPSAMPLE_FACTOR);
        }

        public int hashCode() {
            return -1564484840;
        }

        @NotNull
        public String toString() {
            return "UPSAMPLE_FACTOR";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS extends VexFwkMetadataKey<Long> {

        @NotNull
        public static final VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS INSTANCE = new VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS();

        private VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS() {
            super("vexfwk.message.maskFrameTimestampMs", VexFwkParamLong.INSTANCE, 15, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS);
        }

        public int hashCode() {
            return 1297462264;
        }

        @NotNull
        public String toString() {
            return "VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey$WINE_INFO;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "Lcom/samsung/android/vexfwk/param/VexFwkWineInfo;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class WINE_INFO extends VexFwkMetadataKey<VexFwkWineInfo> {

        @NotNull
        public static final WINE_INFO INSTANCE = new WINE_INFO();

        private WINE_INFO() {
            super("vexfwk.message.wineInfo", VexFwkWineInfo.INSTANCE, 5, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof WINE_INFO);
        }

        public int hashCode() {
            return 568104627;
        }

        @NotNull
        public String toString() {
            return "WINE_INFO";
        }
    }

    public /* synthetic */ VexFwkMetadataKey(String str, IVexFwkMetadataConverter iVexFwkMetadataConverter, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iVexFwkMetadataConverter, num);
    }

    @NotNull
    public final IVexFwkMetadataConverter<T> getConverter() {
        return this.converter;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getTag() {
        return this.tag;
    }

    private VexFwkMetadataKey(String str, IVexFwkMetadataConverter<T> iVexFwkMetadataConverter, Integer num) {
        this.name = str;
        this.converter = iVexFwkMetadataConverter;
        int iIntValue = num != null ? num.intValue() : VexFwkMetadataNative.INSTANCE.getTag(str);
        this.tag = iIntValue;
        if (iIntValue >= 0) {
            return;
        }
        throw new IllegalStateException(("Invalid tag(" + num + ") for " + str).toString());
    }

    public /* synthetic */ VexFwkMetadataKey(String str, IVexFwkMetadataConverter iVexFwkMetadataConverter, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iVexFwkMetadataConverter, (i & 4) != 0 ? null : num, null);
    }
}
