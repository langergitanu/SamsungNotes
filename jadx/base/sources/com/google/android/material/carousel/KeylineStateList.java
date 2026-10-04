package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f = ((KeylineState) AbstractC0000a.m10g(list, 1)).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f4 = keylineState.getLastKeyline().loc - ((KeylineState) AbstractC0000a.m10g(list2, 1)).getLastKeyline().loc;
        this.endShiftRange = f4;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f4, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            if (!keylineState.getKeylines().get(i).isAnchor) {
                return i;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f, float f4, float f5) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f, f4), getStateStepsEnd(carousel, keylineState, f, f5));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z) {
        int size = list.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            KeylineState keylineState = list.get(i2);
            KeylineState keylineState2 = list.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i2] + ((z ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f);
            i++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && iFindLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = iFindLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f5 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f5 - keylineState.getLastFocalKeyline().cutoff, containerWidth));
                return arrayList;
            }
            int i = 0;
            float f6 = 0.0f;
            while (i < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) AbstractC1974b.m1313f(1, arrayList);
                int i2 = iFindLastNonAnchorKeylineIndex - i;
                float f7 = f6 + keylineState.getKeylines().get(i2).cutoff;
                int i4 = i2 + 1;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindLastNonAnchorKeylineIndex, i4 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i4).mask) + 1 : 0, f5 - f7, keylineState.getFirstFocalKeylineIndex() + i + 1, keylineState.getLastFocalKeylineIndex() + i + 1, containerWidth);
                if (i == lastFocalKeylineIndex - 1 && f4 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f4, containerWidth, false, f);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i++;
                f6 = f7;
            }
        } else if (f4 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f4, containerWidth, false, f));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f4 = fArr[0];
        int i = 1;
        while (i < size) {
            float f5 = fArr[i];
            if (f <= f5) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f4, f5, f), i - 1, i};
            }
            i++;
            f4 = f5;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && iFindFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - iFindFirstNonAnchorKeylineIndex;
            float f5 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f5 + keylineState.getFirstFocalKeyline().cutoff, containerWidth));
                return arrayList;
            }
            int i = 0;
            float f6 = 0.0f;
            while (i < firstFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) AbstractC1974b.m1313f(1, arrayList);
                int i2 = iFindFirstNonAnchorKeylineIndex + i;
                int size = keylineState.getKeylines().size() - 1;
                float f7 = f6 + keylineState.getKeylines().get(i2).cutoff;
                int i4 = i2 - 1;
                if (i4 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i4).mask) - 1;
                }
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindFirstNonAnchorKeylineIndex, size, f5 + f7, (keylineState.getFirstFocalKeylineIndex() - i) - 1, (keylineState.getLastFocalKeylineIndex() - i) - 1, containerWidth);
                if (i == firstFocalKeylineIndex - 1 && f4 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f4, containerWidth, true, f);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i++;
                f6 = f7;
            }
        } else if (f4 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f4, containerWidth, true, f));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i, int i2, float f, int i4, int i5, float f4) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i2, (KeylineState.Keyline) arrayList.remove(i));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f4);
        int i6 = 0;
        while (i6 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            float f5 = keyline.maskedItemSize;
            builder.addKeyline((f5 / 2.0f) + f, keyline.mask, f5, i6 >= i4 && i6 <= i5, keyline.isAnchor, keyline.cutoff);
            f += keyline.maskedItemSize;
            i6++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState keylineState, float f, float f4, boolean z, float f5) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f4);
        float numberOfNonAnchorKeylines = f / keylineState.getNumberOfNonAnchorKeylines();
        float f6 = z ? f : 0.0f;
        int i = 0;
        while (i < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z2 = i >= keylineState.getFirstFocalKeylineIndex() && i <= keylineState.getLastFocalKeylineIndex();
                float f7 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f7, keylineState.getItemSize(), f5);
                float f8 = (f7 / 2.0f) + f6;
                float f9 = f8 - keyline.locOffset;
                builder.addKeyline(f8, childMaskPercentage, f7, z2, false, keyline.cutoff, z ? f9 : 0.0f, z ? 0.0f : f9);
                f6 += f7;
            }
            i++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, float f4) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), f4);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return (KeylineState) AbstractC0000a.m10g(this.endStateSteps, 1);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i, int i2, int i4, boolean z) {
        float itemSize = this.defaultState.getItemSize();
        HashMap map = new HashMap();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= i) {
                break;
            }
            int i7 = z ? (i - i5) - 1 : i5;
            if (i7 * itemSize * (z ? -1 : 1) > i4 - this.endShiftRange || i5 >= i - this.endStateSteps.size()) {
                Integer numValueOf = Integer.valueOf(i7);
                List<KeylineState> list = this.endStateSteps;
                map.put(numValueOf, list.get(MathUtils.clamp(i6, 0, list.size() - 1)));
                i6++;
            }
            i5++;
        }
        int i8 = 0;
        for (int i9 = i - 1; i9 >= 0; i9--) {
            int i10 = z ? (i - i9) - 1 : i9;
            if (i10 * itemSize * (z ? -1 : 1) < i2 + this.startShiftRange || i9 < this.startStateSteps.size()) {
                Integer numValueOf2 = Integer.valueOf(i10);
                List<KeylineState> list2 = this.startStateSteps;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i8, 0, list2.size() - 1)));
                i8++;
            }
        }
        return map;
    }

    public KeylineState getShiftedState(float f, float f4, float f5) {
        return getShiftedState(f, f4, f5, false);
    }

    public KeylineState getStartState() {
        return (KeylineState) AbstractC0000a.m10g(this.startStateSteps, 1);
    }

    public KeylineState getShiftedState(float f, float f4, float f5, boolean z) {
        float fLerp;
        List<KeylineState> list;
        float[] fArr;
        float f6 = this.startShiftRange + f4;
        float f7 = f5 - this.endShiftRange;
        float f8 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f9 = getEndState().getLastFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f8) {
            f6 += f8;
        }
        if (this.endShiftRange == f9) {
            f7 -= f9;
        }
        if (f < f6) {
            fLerp = AnimationUtils.lerp(1.0f, 0.0f, f4, f6, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f <= f7) {
                return this.defaultState;
            }
            fLerp = AnimationUtils.lerp(0.0f, 1.0f, f7, f5, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z ? closestStateStepFromInterpolation(list, fLerp, fArr) : lerp(list, fLerp, fArr);
    }
}
