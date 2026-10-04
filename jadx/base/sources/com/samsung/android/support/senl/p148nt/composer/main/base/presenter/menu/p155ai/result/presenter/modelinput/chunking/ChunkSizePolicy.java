package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", "", "unitMinLength", "", "unitMaxLength", "extraLength", "splitLastIfExceedsMax", "", "<init>", "(IIIZ)V", "getUnitMinLength", "()I", "getUnitMaxLength", "getExtraLength", "getSplitLastIfExceedsMax", "()Z", "copy", "Builder", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ChunkSizePolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int extraLength;
    private final boolean splitLastIfExceedsMax;
    private final int unitMaxLength;
    private final int unitMinLength;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy$Builder;", "", "<init>", "()V", "unitMinLength", "", "Ljava/lang/Integer;", "unitMaxLength", "extraLength", "splitLastIfExceedsMax", "", VPathDataCmd.RCurveTo, "build", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nInputChunkingPolicy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputChunkingPolicy.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
    public static final class Builder {

        @Nullable
        private Integer extraLength;
        private boolean splitLastIfExceedsMax;

        @Nullable
        private Integer unitMaxLength;

        @Nullable
        private Integer unitMinLength;

        @NotNull
        public final ChunkSizePolicy build() {
            Integer num = this.unitMinLength;
            if (num == null) {
                throw new IllegalStateException("unitMinLength is required");
            }
            int iIntValue = num.intValue();
            Integer num2 = this.unitMaxLength;
            if (num2 == null) {
                throw new IllegalStateException("unitMaxLength is required");
            }
            int iIntValue2 = num2.intValue();
            Integer num3 = this.extraLength;
            if (num3 == null) {
                throw new IllegalStateException("extraLength is required");
            }
            int iIntValue3 = num3.intValue();
            if (iIntValue < 0 || iIntValue2 <= 0 || iIntValue + 1 > iIntValue2) {
                throw new IllegalArgumentException(AbstractC1038a.m1214o(iIntValue, iIntValue2, "Invalid min/max lengths: min=", ", max=").toString());
            }
            if (iIntValue3 >= 0) {
                return new ChunkSizePolicy(iIntValue, iIntValue2, iIntValue3, this.splitLastIfExceedsMax, null);
            }
            throw new IllegalArgumentException("extraLength must be >= 0");
        }

        @NotNull
        public final Builder extraLength(int v) {
            this.extraLength = Integer.valueOf(v);
            return this;
        }

        @NotNull
        public final Builder splitLastIfExceedsMax(boolean v) {
            this.splitLastIfExceedsMax = v;
            return this;
        }

        @NotNull
        public final Builder unitMaxLength(int v) {
            this.unitMaxLength = Integer.valueOf(v);
            return this;
        }

        @NotNull
        public final Builder unitMinLength(int v) {
            this.unitMinLength = Integer.valueOf(v);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy$Companion;", "", "<init>", "()V", "builder", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy$Builder;", "of", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", VElementFormulasCmd.FMIN, "", VElementFormulasCmd.FMAX, "extra", "splitLastIfExceedsMax", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ChunkSizePolicy of$default(Companion companion, int i, int i2, int i4, boolean z, int i5, Object obj) {
            if ((i5 & 8) != 0) {
                z = false;
            }
            return companion.m9735of(i, i2, i4, z);
        }

        @JvmStatic
        @NotNull
        public final Builder builder() {
            return new Builder();
        }

        @JvmStatic
        @NotNull
        /* JADX INFO: renamed from: of */
        public final ChunkSizePolicy m9735of(int min, int max, int extra, boolean splitLastIfExceedsMax) {
            return builder().unitMinLength(min).unitMaxLength(max).extraLength(extra).splitLastIfExceedsMax(splitLastIfExceedsMax).build();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ChunkSizePolicy(int i, int i2, int i4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i4, z);
    }

    @JvmStatic
    @NotNull
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public static /* synthetic */ ChunkSizePolicy copy$default(ChunkSizePolicy chunkSizePolicy, int i, int i2, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = chunkSizePolicy.unitMinLength;
        }
        if ((i5 & 2) != 0) {
            i2 = chunkSizePolicy.unitMaxLength;
        }
        if ((i5 & 4) != 0) {
            i4 = chunkSizePolicy.extraLength;
        }
        if ((i5 & 8) != 0) {
            z = chunkSizePolicy.splitLastIfExceedsMax;
        }
        return chunkSizePolicy.copy(i, i2, i4, z);
    }

    @JvmStatic
    @NotNull
    /* JADX INFO: renamed from: of */
    public static final ChunkSizePolicy m9734of(int i, int i2, int i4, boolean z) {
        return INSTANCE.m9735of(i, i2, i4, z);
    }

    @NotNull
    public final ChunkSizePolicy copy(int unitMinLength, int unitMaxLength, int extraLength, boolean splitLastIfExceedsMax) {
        return new ChunkSizePolicy(unitMinLength, unitMaxLength, extraLength, splitLastIfExceedsMax);
    }

    public final int getExtraLength() {
        return this.extraLength;
    }

    public final boolean getSplitLastIfExceedsMax() {
        return this.splitLastIfExceedsMax;
    }

    public final int getUnitMaxLength() {
        return this.unitMaxLength;
    }

    public final int getUnitMinLength() {
        return this.unitMinLength;
    }

    private ChunkSizePolicy(int i, int i2, int i4, boolean z) {
        this.unitMinLength = i;
        this.unitMaxLength = i2;
        this.extraLength = i4;
        this.splitLastIfExceedsMax = z;
    }
}
