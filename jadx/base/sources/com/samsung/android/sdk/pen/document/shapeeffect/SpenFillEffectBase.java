package com.samsung.android.sdk.pen.document.shapeeffect;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "", "type", "", "<init>", "(I)V", "value", "getType", "()I", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFillEffectBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFillEffectBase.kt\ncom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
public class SpenFillEffectBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_COLOR = 1;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_PATTERN = 3;
    private int type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase$Companion;", "", "<init>", "()V", "TYPE_COLOR", "", "TYPE_IMAGE", "TYPE_PATTERN", "createFillEffect", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "type", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final SpenFillEffectBase createFillEffect(int type) {
            if (type == 1) {
                return new SpenFillColorEffect();
            }
            if (type == 2) {
                return new SpenFillImageEffect();
            }
            if (type != 3) {
                return null;
            }
            return new SpenFillPatternEffect();
        }

        private Companion() {
        }
    }

    public SpenFillEffectBase(int i) {
        this.type = 1;
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException("Type is not valid");
        }
        this.type = i;
    }

    @JvmStatic
    @Nullable
    public static final SpenFillEffectBase createFillEffect(int i) {
        return INSTANCE.createFillEffect(i);
    }

    public final int getType() {
        return this.type;
    }
}
