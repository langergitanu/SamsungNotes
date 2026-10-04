package com.samsung.android.support.senl.p148nt.base.composer.text.checker.span;

import android.annotation.SuppressLint;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SpanChecker {
    private final Comparator<SpenTextSpanBase> mComparator = new Comparator<SpenTextSpanBase>() { // from class: com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.1
        @Override // java.util.Comparator
        public int compare(SpenTextSpanBase spenTextSpanBase, SpenTextSpanBase spenTextSpanBase2) {
            return spenTextSpanBase.getStart() - spenTextSpanBase2.getStart();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbsSpanChecker {
        SpanState spanState = new SpanState();
        LinkedList<SpenTextSpanBase> spans = new LinkedList<>();

        public void addSpan(SpenTextSpanBase spenTextSpanBase) {
            this.spans.add(spenTextSpanBase);
        }

        public abstract SpanState checkSpans(LinkedList<SpenTextSpanBase> linkedList, int i, int i2);

        public void checkSpans(int i, int i2) {
            SpanState spanStateCheckSpans = checkSpans(this.spans, i, i2);
            SpanState spanState = this.spanState;
            spanState.enabled = spanStateCheckSpans.enabled;
            spanState.value = spanStateCheckSpans.value;
        }

        public Object getSpanStateValue() {
            return this.spanState.value;
        }

        public void releaseList() {
            this.spans.clear();
        }

        public abstract void updateSpanState(SpanStates spanStates);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BackgroundColorSingleCursorSpanChecker extends ValueSingleCursorSpanChecker {
        public BackgroundColorSingleCursorSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ValueSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Integer.valueOf(((SpenBackgroundColorSpan) spenTextSpanBase).getColor());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getFontBgColor().setValue(((Integer) getSpanStateValue()).intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BackgroundColorSpanChecker extends ColorSpanChecker {
        public BackgroundColorSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ColorSpanChecker
        public int getColor(SpenTextSpanBase spenTextSpanBase) {
            return ((SpenBackgroundColorSpan) spenTextSpanBase).getColor();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            if (this.spanState.enabled) {
                spanStates.getFontBgColor().setValue(((Integer) getSpanStateValue()).intValue());
            } else {
                spanStates.getFontBgColor().setValue(spanStates.getFontBgColor().getDefaultValue());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BoldSingleCursorSpanChecker extends OnOffSingleCursorSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Boolean.valueOf(((SpenBoldSpan) spenTextSpanBase).getIsBoldStyleEnabled());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getBold().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BoldSpanChecker extends OnOffSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSpanChecker
        public boolean isEnabled(SpenTextSpanBase spenTextSpanBase) {
            return ((SpenBoldSpan) spenTextSpanBase).getIsBoldStyleEnabled();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getBold().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ColorSpanChecker extends ValueSpanChecker {
        public ColorSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ValueSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public SpanState checkSpans(LinkedList<SpenTextSpanBase> linkedList, int i, int i2) {
            boolean z;
            if (linkedList.isEmpty()) {
                return new SpanState(false, Integer.valueOf(this.mDefaultValue));
            }
            int color = this.mDefaultValue;
            int end = i;
            for (SpenTextSpanBase spenTextSpanBase : linkedList) {
                if (spenTextSpanBase.getEnd() > i || i == 0) {
                    if (spenTextSpanBase.getStart() > i) {
                        int color2 = getColor(spenTextSpanBase);
                        if (color2 != color || spenTextSpanBase.getStart() != end) {
                            if (color2 != color || spenTextSpanBase.getStart() != end) {
                                z = false;
                                break;
                            }
                        } else {
                            end = spenTextSpanBase.getEnd();
                        }
                    } else {
                        color = getColor(spenTextSpanBase);
                        end = spenTextSpanBase.getEnd();
                    }
                }
            }
            z = true;
            return new SpanState((color == this.mDefaultValue || end >= i2) ? z : false, Integer.valueOf(color));
        }

        public abstract int getColor(SpenTextSpanBase spenTextSpanBase);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FontSizeSingleCursorSpanChecker extends ValueSingleCursorSpanChecker {
        public FontSizeSingleCursorSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ValueSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Integer.valueOf((int) ((SpenFontSizeSpan) spenTextSpanBase).getSize());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getFontSize().setEnable(true);
            spanStates.getFontSize().setValue(((Integer) getSpanStateValue()).intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FontSpanChecker extends ValueSpanChecker {
        public FontSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void addSpan(SpenTextSpanBase spenTextSpanBase) {
            if (((SpenFontSizeSpan) spenTextSpanBase).getSize() != this.mDefaultValue) {
                super.addSpan(spenTextSpanBase);
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ValueSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public SpanState checkSpans(LinkedList<SpenTextSpanBase> linkedList, int i, int i2) {
            boolean z;
            float size = this.mDefaultValue;
            Iterator<SpenTextSpanBase> it = linkedList.iterator();
            int end = i;
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                SpenTextSpanBase next = it.next();
                if (next.getEnd() > i || i == 0) {
                    if (next.getStart() <= i) {
                        size = ((SpenFontSizeSpan) next).getSize();
                        end = next.getEnd();
                    } else {
                        SpenFontSizeSpan spenFontSizeSpan = (SpenFontSizeSpan) next;
                        if (spenFontSizeSpan.getSize() != size || next.getStart() != end) {
                            break;
                        }
                        if (spenFontSizeSpan.getSize() == size && next.getStart() == end) {
                            end = next.getEnd();
                        }
                    }
                }
            }
            z = false;
            return new SpanState((size == ((float) this.mDefaultValue) || end >= i2) ? z : false, Integer.valueOf((int) size));
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getFontSize().setEnable(this.spanState.enabled);
            if (this.spanState.enabled) {
                spanStates.getFontSize().setValue(((Integer) getSpanStateValue()).intValue());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ForegroundColorSingleCursorSpanChecker extends ValueSingleCursorSpanChecker {
        public ForegroundColorSingleCursorSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ValueSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Integer.valueOf(((SpenForegroundColorSpan) spenTextSpanBase).getColor());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getFontColor().setValue(((Integer) getSpanStateValue()).intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ForegroundColorSpanChecker extends ColorSpanChecker {
        public ForegroundColorSpanChecker(int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.ColorSpanChecker
        public int getColor(SpenTextSpanBase spenTextSpanBase) {
            return ((SpenForegroundColorSpan) spenTextSpanBase).getColor();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            if (this.spanState.enabled) {
                spanStates.getFontColor().setValue(((Integer) getSpanStateValue()).intValue());
            } else {
                spanStates.getFontColor().setValue(spanStates.getFontColor().getDefaultValue());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItalicSingleCursorSpanChecker extends OnOffSingleCursorSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Boolean.valueOf(((SpenItalicSpan) spenTextSpanBase).getIsItalicStyleEnabled());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getItalic().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItalicSpanChecker extends OnOffSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSpanChecker
        public boolean isEnabled(SpenTextSpanBase spenTextSpanBase) {
            return ((SpenItalicSpan) spenTextSpanBase).getIsItalicStyleEnabled();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getItalic().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class OnOffSingleCursorSpanChecker extends SingleCursorSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getSpanStateValue() {
            SpanState spanState = this.spanState;
            return spanState == null ? Boolean.FALSE : spanState.value;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public abstract Object getValue(SpenTextSpanBase spenTextSpanBase);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class OnOffSpanChecker extends AbsSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public SpanState checkSpans(LinkedList<SpenTextSpanBase> linkedList, int i, int i2) {
            boolean z;
            int end = i;
            boolean zIsEnabled = false;
            for (SpenTextSpanBase spenTextSpanBase : linkedList) {
                if (spenTextSpanBase.getEnd() > i || i == 0) {
                    if (spenTextSpanBase.getStart() <= i) {
                        zIsEnabled = isEnabled(spenTextSpanBase);
                        end = spenTextSpanBase.getEnd();
                    } else if (spenTextSpanBase.getStart() != end) {
                        if (zIsEnabled != isEnabled(spenTextSpanBase)) {
                            z = false;
                            zIsEnabled = false;
                            break;
                        }
                    } else {
                        if (zIsEnabled != isEnabled(spenTextSpanBase)) {
                            z = false;
                            zIsEnabled = false;
                            break;
                        }
                        end = spenTextSpanBase.getEnd();
                    }
                }
            }
            z = true;
            return new SpanState((!zIsEnabled || end >= i2) ? z : false, Boolean.valueOf(zIsEnabled));
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public Object getSpanStateValue() {
            Object obj;
            SpanState spanState = this.spanState;
            return Boolean.valueOf(spanState.enabled && (obj = spanState.value) != null && ((Boolean) obj).booleanValue());
        }

        public abstract boolean isEnabled(SpenTextSpanBase spenTextSpanBase);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SingleCursorSpanChecker {
        SpanState spanState;

        public void checkSpan(SpenTextSpanBase spenTextSpanBase, int i) {
            if (spenTextSpanBase.getStart() == spenTextSpanBase.getEnd() || spenTextSpanBase.getEnd() == i) {
                if (spenTextSpanBase.getExpansion() == 0 || spenTextSpanBase.getExpansion() == 2) {
                    return;
                }
            } else if (spenTextSpanBase.getStart() == i && (spenTextSpanBase.getExpansion() == 2 || spenTextSpanBase.getExpansion() == 3)) {
                return;
            }
            setSpanState(spenTextSpanBase);
        }

        public abstract Object getSpanStateValue();

        public abstract Object getValue(SpenTextSpanBase spenTextSpanBase);

        public boolean isDone() {
            return this.spanState != null;
        }

        public void setSpanState(SpenTextSpanBase spenTextSpanBase) {
            SpanState spanState = new SpanState();
            this.spanState = spanState;
            spanState.value = getValue(spenTextSpanBase);
        }

        public abstract void updateSpanState(SpanStates spanStates);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StrikethroughSingleCursorSpanChecker extends OnOffSingleCursorSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Boolean.valueOf(((SpenStrikethroughSpan) spenTextSpanBase).getIsStrikethroughStyleEnabled());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getStrikethrough().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StrikethroughSpanChecker extends OnOffSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSpanChecker
        public boolean isEnabled(SpenTextSpanBase spenTextSpanBase) {
            return ((SpenStrikethroughSpan) spenTextSpanBase).getIsStrikethroughStyleEnabled();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getStrikethrough().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnderlineSingleCursorSpanChecker extends OnOffSingleCursorSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSingleCursorSpanChecker, com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getValue(SpenTextSpanBase spenTextSpanBase) {
            return Boolean.valueOf(((SpenUnderlineSpan) spenTextSpanBase).getIsUnderlineStyleEnabled());
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getUnderline().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnderlineSpanChecker extends OnOffSpanChecker {
        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.OnOffSpanChecker
        public boolean isEnabled(SpenTextSpanBase spenTextSpanBase) {
            return ((SpenUnderlineSpan) spenTextSpanBase).getIsUnderlineStyleEnabled();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public void updateSpanState(SpanStates spanStates) {
            spanStates.getUnderline().setValue(((Boolean) getSpanStateValue()).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ValueSingleCursorSpanChecker extends SingleCursorSpanChecker {
        int defaultValue;

        public ValueSingleCursorSpanChecker(int i) {
            this.defaultValue = i;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public Object getSpanStateValue() {
            SpanState spanState = this.spanState;
            return spanState == null ? Integer.valueOf(this.defaultValue) : spanState.value;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public abstract Object getValue(SpenTextSpanBase spenTextSpanBase);

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.SingleCursorSpanChecker
        public void setSpanState(SpenTextSpanBase spenTextSpanBase) {
            super.setSpanState(spenTextSpanBase);
            this.spanState.value = getValue(spenTextSpanBase);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ValueSpanChecker extends AbsSpanChecker {
        int mDefaultValue;

        public ValueSpanChecker(int i) {
            this.mDefaultValue = i;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public abstract SpanState checkSpans(LinkedList<SpenTextSpanBase> linkedList, int i, int i2);

        @Override // com.samsung.android.support.senl.nt.base.composer.text.checker.span.SpanChecker.AbsSpanChecker
        public Object getSpanStateValue() {
            Object obj = this.spanState.value;
            return obj == null ? Integer.valueOf(this.mDefaultValue) : obj;
        }
    }

    private void updateSpanState(int i, int i2, SpanStates spanStates, Collection<AbsSpanChecker> collection) {
        for (AbsSpanChecker absSpanChecker : collection) {
            absSpanChecker.checkSpans(i, i2);
            absSpanChecker.releaseList();
            absSpanChecker.updateSpanState(spanStates);
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public SpanStates updateRtSpans(SpenObjectShape spenObjectShape, int i, SpanStates spanStates) {
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = spenObjectShape.findTextSpan(i, i);
        if (arrayListFindTextSpan == null || arrayListFindTextSpan.isEmpty()) {
            spanStates.getFontSize().setEnable(true);
            spanStates.resetToDefault();
            return spanStates;
        }
        HashMap map = new HashMap(7);
        map.put(5, new BoldSingleCursorSpanChecker());
        map.put(6, new ItalicSingleCursorSpanChecker());
        map.put(20, new StrikethroughSingleCursorSpanChecker());
        map.put(7, new UnderlineSingleCursorSpanChecker());
        map.put(1, new ForegroundColorSingleCursorSpanChecker(spanStates.getFontColor().getDefaultValue()));
        map.put(17, new BackgroundColorSingleCursorSpanChecker(0));
        map.put(3, new FontSizeSingleCursorSpanChecker(spanStates.getFontSize().getDefaultValue()));
        for (int size = arrayListFindTextSpan.size() - 1; size >= 0; size--) {
            SpenTextSpanBase spenTextSpanBase = arrayListFindTextSpan.get(size);
            SingleCursorSpanChecker singleCursorSpanChecker = (SingleCursorSpanChecker) map.get(Integer.valueOf(spenTextSpanBase.getType()));
            if (singleCursorSpanChecker != null && !singleCursorSpanChecker.isDone()) {
                singleCursorSpanChecker.checkSpan(spenTextSpanBase, i);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((SingleCursorSpanChecker) it.next()).updateSpanState(spanStates);
        }
        return spanStates;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpanState {
        boolean enabled;
        Object value;

        public SpanState() {
            this.enabled = true;
        }

        public SpanState(boolean z, Object obj) {
            this.enabled = z;
            this.value = obj;
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public SpanStates updateRtSpans(SpenObjectShape spenObjectShape, int i, int i2, SpanStates spanStates) {
        HashMap map = new HashMap();
        map.put(5, new BoldSpanChecker());
        map.put(6, new ItalicSpanChecker());
        map.put(20, new StrikethroughSpanChecker());
        map.put(7, new UnderlineSpanChecker());
        map.put(1, new ForegroundColorSpanChecker(spanStates.getFontColor().getValue()));
        map.put(17, new BackgroundColorSpanChecker(spanStates.getFontBgColor().getValue()));
        map.put(3, new FontSpanChecker(spanStates.getFontSize().getValue()));
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = spenObjectShape.findTextSpan(i, i2);
        if (arrayListFindTextSpan == null) {
            updateSpanState(i, i2, spanStates, map.values());
            return spanStates;
        }
        Collections.sort(arrayListFindTextSpan, this.mComparator);
        for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
            if (spenTextSpanBase.getStart() != i2 || i2 <= 0) {
                AbsSpanChecker absSpanChecker = (AbsSpanChecker) map.get(Integer.valueOf(spenTextSpanBase.getType()));
                if (absSpanChecker != null) {
                    absSpanChecker.addSpan(spenTextSpanBase);
                }
            }
        }
        updateSpanState(i, i2, spanStates, map.values());
        return spanStates;
    }
}
