package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;", "", "boundary", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;", "chunkSize", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;)V", "getBoundary", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;", "getChunkSize", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", "Builder", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InputChunkingPolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final BoundaryPolicy boundary;

    @NotNull
    private final ChunkSizePolicy chunkSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy$Builder;", "", "<init>", "()V", "boundary", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;", "chunkSize", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", VPathDataCmd.RCurveTo, "build", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nInputChunkingPolicy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputChunkingPolicy.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
    public static final class Builder {

        @NotNull
        private BoundaryPolicy boundary = DefaultBoundaryPolicy.INSTANCE;

        @NotNull
        private ChunkSizePolicy chunkSize = ChunkSizePolicy.INSTANCE.m9735of(200, 5000, 500, false);

        @NotNull
        public final Builder boundary(@NotNull BoundaryPolicy v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.boundary = v;
            return this;
        }

        @NotNull
        public final InputChunkingPolicy build() {
            return new InputChunkingPolicy(this.boundary, this.chunkSize, null);
        }

        @NotNull
        public final Builder chunkSize(@NotNull ChunkSizePolicy v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.chunkSize = v;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy$Companion;", "", "<init>", "()V", "builder", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy$Builder;", "of", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;", "boundary", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;", "chunkSize", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Builder builder() {
            return new Builder();
        }

        @JvmStatic
        @NotNull
        /* JADX INFO: renamed from: of */
        public final InputChunkingPolicy m9737of(@NotNull BoundaryPolicy boundary, @NotNull ChunkSizePolicy chunkSize) {
            Intrinsics.checkNotNullParameter(boundary, "boundary");
            Intrinsics.checkNotNullParameter(chunkSize, "chunkSize");
            return builder().boundary(boundary).chunkSize(chunkSize).build();
        }

        private Companion() {
        }
    }

    public /* synthetic */ InputChunkingPolicy(BoundaryPolicy boundaryPolicy, ChunkSizePolicy chunkSizePolicy, DefaultConstructorMarker defaultConstructorMarker) {
        this(boundaryPolicy, chunkSizePolicy);
    }

    @JvmStatic
    @NotNull
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    @JvmStatic
    @NotNull
    /* JADX INFO: renamed from: of */
    public static final InputChunkingPolicy m9736of(@NotNull BoundaryPolicy boundaryPolicy, @NotNull ChunkSizePolicy chunkSizePolicy) {
        return INSTANCE.m9737of(boundaryPolicy, chunkSizePolicy);
    }

    @NotNull
    public final BoundaryPolicy getBoundary() {
        return this.boundary;
    }

    @NotNull
    public final ChunkSizePolicy getChunkSize() {
        return this.chunkSize;
    }

    private InputChunkingPolicy(BoundaryPolicy boundaryPolicy, ChunkSizePolicy chunkSizePolicy) {
        this.boundary = boundaryPolicy;
        this.chunkSize = chunkSizePolicy;
    }
}
