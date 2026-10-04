package com.samsung.android.vexfwk.sdk.common.runtime;

import android.graphics.Bitmap;
import android.media.Image;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a/\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\b\u001a)\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b\u001a)\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e\u001a!\u0010\u000f\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a)\u0010\u000f\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0010\u001a)\u0010\u000f\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b\u001a)\u0010\u000f\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e\u001a2\u0010\u0011\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, m13886d2 = {"addInputBuffer", "T", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "streamId", "", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;I)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "B", "buffer", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;ILjava/lang/Object;)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "bitmap", "Landroid/graphics/Bitmap;", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;ILandroid/graphics/Bitmap;)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "image", "Landroid/media/Image;", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;ILandroid/media/Image;)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "addOutputBuffer", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;ILcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "setSettingMetadata", "action", "Lkotlin/Function1;", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;Lkotlin/jvm/functions/Function1;)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "vexfwk_sdk_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSessionRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSessionRequest.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequestKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
public final class VexFwkSessionRequestKt {
    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder, B> T addInputBuffer(@NotNull T t, int i, B b) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        t.getInputBuffers().add(VexFwkBuffer.INSTANCE.from(i, b));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addOutputBuffer(@NotNull T t, int i, @NotNull T buffer) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        t.getOutputBuffers().add(VexFwkBuffer.INSTANCE.from(i, buffer));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T setSettingMetadata(@NotNull T t, @NotNull Function1<? super VexFwkMetadataNative, Unit> action) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        VexFwkMetadataNative vexFwkMetadataNative = new VexFwkMetadataNative();
        action.invoke(vexFwkMetadataNative);
        t.setSettingMetadata(vexFwkMetadataNative);
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addInputBuffer(@NotNull T t, int i, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(image, "image");
        t.getInputBuffers().add(VexFwkBuffer.INSTANCE.from(i, image));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addOutputBuffer(@NotNull T t, int i, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(image, "image");
        t.getOutputBuffers().add(VexFwkBuffer.INSTANCE.from(i, image));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addInputBuffer(@NotNull T t, int i, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        t.getInputBuffers().add(VexFwkBuffer.INSTANCE.from(i, bitmap));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addOutputBuffer(@NotNull T t, int i, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        t.getOutputBuffers().add(VexFwkBuffer.INSTANCE.from(i, bitmap));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addInputBuffer(@NotNull T t, int i) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        t.getInputBuffers().add(VexFwkBuffer.INSTANCE.from(i));
        return t;
    }

    @NotNull
    public static final <T extends VexFwkSessionRequest.Builder> T addOutputBuffer(@NotNull T t, int i) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        t.getOutputBuffers().add(VexFwkBuffer.INSTANCE.from(i));
        return t;
    }
}
