package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0003\u000f\u0010\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker;", "", "policy", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;)V", "chunk", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/Chunk;", "input", "", "spans", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObject;", "computeRanges", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker$Range;", "Builder", "Companion", "Range", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nModelInputChunker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelInputChunker.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1056#2:118\n*S KotlinDebug\n*F\n+ 1 ModelInputChunker.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker\n*L\n33#1:118\n*E\n"})
public final class ModelInputChunker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final InputChunkingPolicy policy;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker$Builder;", "", "<init>", "()V", "policy", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;", VPathDataCmd.RCurveTo, "boundary", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;", "chunkSize", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ChunkSizePolicy;", "build", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nModelInputChunker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelInputChunker.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    public static final class Builder {

        @NotNull
        private InputChunkingPolicy policy = InputChunkingPolicy.INSTANCE.builder().build();

        @NotNull
        public final Builder boundary(@NotNull BoundaryPolicy v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.policy = InputChunkingPolicy.INSTANCE.m9737of(v, this.policy.getChunkSize());
            return this;
        }

        @NotNull
        public final ModelInputChunker build() {
            return new ModelInputChunker(this.policy, null);
        }

        @NotNull
        public final Builder chunkSize(@NotNull ChunkSizePolicy v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.policy = InputChunkingPolicy.INSTANCE.m9737of(this.policy.getBoundary(), v);
            return this;
        }

        @NotNull
        public final Builder policy(@NotNull InputChunkingPolicy v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.policy = v;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J.\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker$Companion;", "", "<init>", "()V", "builder", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker$Builder;", "chunk", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/Chunk;", "input", "", "spans", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObject;", "policy", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/InputChunkingPolicy;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List chunk$default(Companion companion, String str, List list, InputChunkingPolicy inputChunkingPolicy, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return companion.chunk(str, list, inputChunkingPolicy);
        }

        @JvmStatic
        @NotNull
        public final Builder builder() {
            return new Builder();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final List<Chunk> chunk(@NotNull String input, @NotNull InputChunkingPolicy policy) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(policy, "policy");
            return chunk$default(this, input, null, policy, 2, null);
        }

        private Companion() {
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final List<Chunk> chunk(@NotNull String input, @NotNull List<ResolvableSpanObject> spans, @NotNull InputChunkingPolicy policy) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(spans, "spans");
            Intrinsics.checkNotNullParameter(policy, "policy");
            return builder().policy(policy).build().chunk(input, spans);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/ModelInputChunker$Range;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Range {
        private final int end;
        private final int start;

        public Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public static /* synthetic */ Range copy$default(Range range, int i, int i2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = range.start;
            }
            if ((i4 & 2) != 0) {
                i2 = range.end;
            }
            return range.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        @NotNull
        public final Range copy(int start, int end) {
            return new Range(start, end);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return this.start == range.start && this.end == range.end;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return Integer.hashCode(this.end) + (Integer.hashCode(this.start) * 31);
        }

        @NotNull
        public String toString() {
            return AbstractC0622a.m1164j(this.start, this.end, "Range(start=", ", end=", ")");
        }
    }

    public /* synthetic */ ModelInputChunker(InputChunkingPolicy inputChunkingPolicy, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputChunkingPolicy);
    }

    @JvmStatic
    @NotNull
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List chunk$default(ModelInputChunker modelInputChunker, String str, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return modelInputChunker.chunk(str, (List<ResolvableSpanObject>) list);
    }

    private final List<Range> computeRanges(String input) {
        int i;
        int i2;
        String str = input;
        ArrayList arrayList = new ArrayList();
        if (str.length() != 0) {
            int unitMinLength = this.policy.getChunkSize().getUnitMinLength();
            int unitMaxLength = this.policy.getChunkSize().getUnitMaxLength();
            int extraLength = this.policy.getChunkSize().getExtraLength();
            boolean splitLastIfExceedsMax = this.policy.getChunkSize().getSplitLastIfExceedsMax();
            int i4 = unitMinLength + 1;
            int i5 = unitMaxLength - 1;
            int length = str.length();
            int i6 = 0;
            while (i6 < length) {
                int i7 = length - i6;
                if (i7 <= unitMaxLength + unitMinLength) {
                    if (!splitLastIfExceedsMax || i7 <= unitMaxLength) {
                        computeRanges$addRange(arrayList, i6, length);
                        return arrayList;
                    }
                    int iCoerceAtLeast = RangesKt.coerceAtLeast(i7 / 2, 1) + i6;
                    computeRanges$addRange(arrayList, i6, iCoerceAtLeast);
                    computeRanges$addRange(arrayList, iCoerceAtLeast, length);
                    return arrayList;
                }
                int iMin = Math.min(i5, i7);
                int iMax = Math.max(unitMaxLength - extraLength, i4);
                if (iMax > iMin) {
                    iMax = iMin;
                }
                if (iMax <= iMin) {
                    int i8 = iMin;
                    while (true) {
                        i2 = i6 + i8;
                        if (i2 < length) {
                            i = unitMinLength;
                            if (this.policy.getBoundary().isSentenceEnd(str.charAt(i2 - 1), str.charAt(i2))) {
                                break;
                            }
                        } else {
                            i = unitMinLength;
                        }
                        if (i8 == iMax) {
                            break;
                        }
                        i8--;
                        str = input;
                        unitMinLength = i;
                    }
                } else {
                    i = unitMinLength;
                }
                i2 = -1;
                if (i2 == -1) {
                    i2 = i6 + iMin;
                }
                int i9 = i6 + i + 1;
                int i10 = iMin + i6;
                if (i2 >= i9) {
                    i9 = i2;
                } else if (i9 > i10) {
                    i9 = i10;
                }
                computeRanges$addRange(arrayList, i6, i9);
                str = input;
                i6 = i9;
                unitMinLength = i;
            }
        }
        return arrayList;
    }

    private static final void computeRanges$addRange(ArrayList<Range> arrayList, int i, int i2) {
        if (i2 > i) {
            arrayList.add(new Range(i, i2));
        }
    }

    @JvmOverloads
    @NotNull
    public final List<Chunk> chunk(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return chunk$default(this, input, null, 2, null);
    }

    private ModelInputChunker(InputChunkingPolicy inputChunkingPolicy) {
        this.policy = inputChunkingPolicy;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<Chunk> chunk(@NotNull String str, @NotNull InputChunkingPolicy inputChunkingPolicy) {
        return INSTANCE.chunk(str, inputChunkingPolicy);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<Chunk> chunk(@NotNull String str, @NotNull List<ResolvableSpanObject> list, @NotNull InputChunkingPolicy inputChunkingPolicy) {
        return INSTANCE.chunk(str, list, inputChunkingPolicy);
    }

    @JvmOverloads
    @NotNull
    public final List<Chunk> chunk(@NotNull String input, @NotNull List<ResolvableSpanObject> spans) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(spans, "spans");
        if (input.length() == 0) {
            return CollectionsKt.emptyList();
        }
        List<Range> listComputeRanges = computeRanges(input);
        List listSortedWith = CollectionsKt.sortedWith(spans, new Comparator() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.modelinput.chunking.ModelInputChunker$chunk$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ResolvableSpanObject) t).getPosition()), Integer.valueOf(((ResolvableSpanObject) t2).getPosition()));
            }
        });
        ArrayList arrayList = new ArrayList(listComputeRanges.size());
        int i = 0;
        for (Range range : listComputeRanges) {
            int start = range.getStart();
            int end = range.getEnd();
            String strSubstring = input.substring(start, end);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            while (i < listSortedWith.size() && ((ResolvableSpanObject) listSortedWith.get(i)).getPosition() < start) {
                i++;
            }
            ArrayList arrayList2 = new ArrayList();
            while (i < listSortedWith.size()) {
                ResolvableSpanObject resolvableSpanObject = (ResolvableSpanObject) listSortedWith.get(i);
                if (resolvableSpanObject.getPosition() < end) {
                    arrayList2.add(resolvableSpanObject);
                    i++;
                }
            }
            arrayList.add(new Chunk(start, strSubstring, arrayList2));
        }
        return arrayList;
    }
}
