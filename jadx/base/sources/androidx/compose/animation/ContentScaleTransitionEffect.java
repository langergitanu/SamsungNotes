package androidx.compose.animation;

import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"Landroidx/compose/animation/ContentScaleTransitionEffect;", "Landroidx/compose/animation/TransitionEffect;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "key", "Landroidx/compose/animation/TransitionEffectKey;", "getKey$animation_release", "()Landroidx/compose/animation/TransitionEffectKey;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Key", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class ContentScaleTransitionEffect extends TransitionEffect {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Alignment alignment;

    @NotNull
    private final ContentScale contentScale;

    /* JADX INFO: renamed from: androidx.compose.animation.ContentScaleTransitionEffect$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Landroidx/compose/animation/ContentScaleTransitionEffect$Key;", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/ContentScaleTransitionEffect;", "()V", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion implements TransitionEffectKey<ContentScaleTransitionEffect> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ContentScaleTransitionEffect(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
        super(null);
        this.contentScale = contentScale;
        this.alignment = alignment;
    }

    public static /* synthetic */ ContentScaleTransitionEffect copy$default(ContentScaleTransitionEffect contentScaleTransitionEffect, ContentScale contentScale, Alignment alignment, int i, Object obj) {
        if ((i & 1) != 0) {
            contentScale = contentScaleTransitionEffect.contentScale;
        }
        if ((i & 2) != 0) {
            alignment = contentScaleTransitionEffect.alignment;
        }
        return contentScaleTransitionEffect.copy(contentScale, alignment);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final ContentScaleTransitionEffect copy(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
        return new ContentScaleTransitionEffect(contentScale, alignment);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentScaleTransitionEffect)) {
            return false;
        }
        ContentScaleTransitionEffect contentScaleTransitionEffect = (ContentScaleTransitionEffect) other;
        return Intrinsics.areEqual(this.contentScale, contentScaleTransitionEffect.contentScale) && Intrinsics.areEqual(this.alignment, contentScaleTransitionEffect.alignment);
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @Override // androidx.compose.animation.TransitionEffect
    @NotNull
    public TransitionEffectKey<?> getKey$animation_release() {
        return INSTANCE;
    }

    public int hashCode() {
        return this.alignment.hashCode() + (this.contentScale.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "ContentScaleTransitionEffect(contentScale=" + this.contentScale + ", alignment=" + this.alignment + PropertyUtils.MAPPED_DELIM2;
    }
}
