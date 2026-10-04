package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float availableSpace;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        public Builder(float f, float f4) {
            this.itemSize = f;
            this.availableSpace = f4;
        }

        private static float calculateKeylineLocationForItemPosition(float f, float f4, int i, int i2) {
            return (i2 * f4) + (f - (i * f4));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addAnchorKeyline(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5) {
            return addKeyline(f, f4, f5, false, true);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5, boolean z) {
            return addKeyline(f, f4, f5, z, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5, int i) {
            return addKeylineRange(f, f4, f5, i, false);
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.tmpKeylines.size(); i++) {
                Keyline keyline = this.tmpKeylines.get(i);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5) {
            return addKeyline(f, f4, f5, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5, int i, boolean z) {
            if (i > 0 && f5 > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    addKeyline((i2 * f5) + f, f4, f5, z);
                }
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5, boolean z, boolean z2, float f6, float f7, float f8) {
            if (f5 <= 0.0f) {
                return this;
            }
            if (z2) {
                if (!z) {
                    int i = this.latestAnchorKeylineIndex;
                    if (i != -1 && i != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f, f4, f5, z2, f6, f7, f8);
            if (z) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f5 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = keyline;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5, boolean z, boolean z2, float f6) {
            return addKeyline(f, f4, f5, z, z2, f6, 0.0f, 0.0f);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, float f5, boolean z, boolean z2) {
            float fAbs;
            float f6 = f5 / 2.0f;
            float f7 = f - f6;
            float f8 = f6 + f;
            float f9 = this.availableSpace;
            if (f8 > f9) {
                fAbs = Math.abs(f8 - Math.max(f8 - f5, f9));
            } else {
                fAbs = 0.0f;
                if (f7 < 0.0f) {
                    fAbs = Math.abs(f7 - Math.min(f7 + f5, 0.0f));
                }
            }
            return addKeyline(f, f4, f5, z, z2, fAbs);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float f, float f4, float f5, float f6) {
            this(f, f4, f5, f6, false, 0.0f, 0.0f, 0.0f);
        }

        public static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f), AnimationUtils.lerp(keyline.mask, keyline2.mask, f), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f));
        }

        public Keyline(float f, float f4, float f5, float f6, boolean z, float f7, float f8, float f9) {
            this.loc = f;
            this.locOffset = f4;
            this.mask = f5;
            this.maskedItemSize = f6;
            this.isAnchor = z;
            this.cutoff = f7;
            this.leftOrTopPaddingShift = f8;
            this.rightOrBottomPaddingShift = f9;
        }
    }

    public static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            arrayList.add(Keyline.lerp(keylines.get(i), keylines2.get(i), f));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f));
    }

    public static KeylineState reverse(KeylineState keylineState, float f) {
        Builder builder = new Builder(keylineState.getItemSize(), f);
        float f4 = (f - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f4, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f4 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i = 0; i < this.keylines.size(); i++) {
            Keyline keyline = this.keylines.get(i);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return (Keyline) AbstractC0000a.m10g(this.keylines, 1);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i++;
            }
        }
        return this.keylines.size() - i;
    }

    private KeylineState(float f, List<Keyline> list, int i, int i2) {
        this.itemSize = f;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i;
        this.lastFocalKeylineIndex = i2;
    }
}
