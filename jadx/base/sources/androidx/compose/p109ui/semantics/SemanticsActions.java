package androidx.compose.p109ui.semantics;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR/\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR/\u0010\u001d\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR,\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR#\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR#\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\tR#\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR#\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR#\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR#\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR#\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\tR#\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\tR.\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0002\u001a\u0004\b7\u0010\tR#\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\tRM\u0010:\u001a>\u0012:\u00128\u00124\u00122\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00070;0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\tRB\u0010A\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110B¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(C\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0D\u0012\u0006\u0012\u0004\u0018\u00010\u00010;0\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\tR)\u0010F\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\tR8\u0010I\u001a)\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\tR5\u0010L\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070M0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\tR)\u0010O\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\tR)\u0010Q\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\tR)\u0010S\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\t¨\u0006U"}, m13886d2 = {"Landroidx/compose/ui/semantics/SemanticsActions;", "", "()V", "ClearTextSubstitution", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function0;", "", "getClearTextSubstitution", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Collapse", "getCollapse", "CopyText", "getCopyText", "CustomActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "getCustomActions", "CutText", "getCutText", "Dismiss", "getDismiss", "Expand", "getExpand", "GetScrollViewportLength", "Lkotlin/Function1;", "", "", "getGetScrollViewportLength", "GetTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getGetTextLayoutResult", "InsertTextAtCursor", "Landroidx/compose/ui/text/AnnotatedString;", "getInsertTextAtCursor", "OnAutofillText", "getOnAutofillText$ui_release", "OnClick", "getOnClick", "OnImeAction", "getOnImeAction", "OnLongClick", "getOnLongClick", "PageDown", "getPageDown", "PageLeft", "getPageLeft", "PageRight", "getPageRight", "PageUp", "getPageUp", "PasteText", "getPasteText", "PerformImeAction", "getPerformImeAction$annotations", "getPerformImeAction", "RequestFocus", "getRequestFocus", "ScrollBy", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "x", "y", "getScrollBy", "ScrollByOffset", "Landroidx/compose/ui/geometry/Offset;", TypedValues.Cycle.S_WAVE_OFFSET, "Lkotlin/coroutines/Continuation;", "getScrollByOffset", "ScrollToIndex", "", "getScrollToIndex", "SetProgress", "progress", "getSetProgress", "SetSelection", "Lkotlin/Function3;", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSemanticsProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticsProperties.kt\nandroidx/compose/ui/semantics/SemanticsActions\n+ 2 SemanticsProperties.kt\nandroidx/compose/ui/semantics/SemanticsPropertiesKt\n*L\n1#1,1614:1\n607#2:1615\n606#2,9:1616\n607#2:1625\n606#2,9:1626\n607#2:1635\n606#2,9:1636\n607#2:1645\n606#2,9:1646\n607#2:1655\n606#2,9:1656\n607#2:1665\n606#2,9:1666\n607#2:1675\n606#2,9:1676\n607#2:1685\n606#2,9:1686\n607#2:1695\n606#2,9:1696\n607#2:1705\n606#2,9:1706\n607#2:1715\n606#2,9:1716\n607#2:1725\n606#2,9:1726\n607#2:1735\n606#2,9:1736\n607#2:1745\n606#2,9:1746\n607#2:1755\n606#2,9:1756\n607#2:1765\n606#2,9:1766\n607#2:1775\n606#2,9:1776\n607#2:1785\n606#2,9:1786\n607#2:1795\n606#2,9:1796\n607#2:1805\n606#2,9:1806\n607#2:1815\n606#2,9:1816\n607#2:1825\n606#2,9:1826\n607#2:1835\n606#2,9:1836\n607#2:1845\n606#2,9:1846\n607#2:1855\n606#2,9:1856\n607#2:1865\n606#2,9:1866\n607#2:1875\n606#2,9:1876\n*S KotlinDebug\n*F\n+ 1 SemanticsProperties.kt\nandroidx/compose/ui/semantics/SemanticsActions\n*L\n305#1:1615\n305#1:1616,9\n310#1:1625\n310#1:1626,9\n315#1:1635\n315#1:1636,9\n320#1:1645\n320#1:1646,9\n330#1:1655\n330#1:1656,9\n337#1:1665\n337#1:1666,9\n342#1:1675\n342#1:1676,9\n347#1:1685\n347#1:1686,9\n352#1:1695\n352#1:1696,9\n357#1:1705\n357#1:1706,9\n362#1:1715\n362#1:1716,9\n367#1:1725\n367#1:1726,9\n372#1:1735\n372#1:1736,9\n377#1:1745\n377#1:1746,9\n389#1:1755\n389#1:1756,9\n394#1:1765\n394#1:1766,9\n399#1:1775\n399#1:1776,9\n404#1:1785\n404#1:1786,9\n409#1:1795\n409#1:1796,9\n414#1:1805\n414#1:1806,9\n419#1:1815\n419#1:1816,9\n424#1:1825\n424#1:1826,9\n435#1:1835\n435#1:1836,9\n440#1:1845\n440#1:1846,9\n445#1:1855\n445#1:1856,9\n450#1:1865\n450#1:1866,9\n456#1:1875\n456#1:1876,9\n*E\n"})
public final class SemanticsActions {
    public static final int $stable;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> ClearTextSubstitution;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Collapse;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CopyText;

    @NotNull
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CutText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Dismiss;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Expand;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<Float>, Boolean>>> GetScrollViewportLength;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult;

    @NotNull
    public static final SemanticsActions INSTANCE = new SemanticsActions();

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> InsertTextAtCursor;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> OnAutofillText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnClick;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnImeAction;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnLongClick;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageDown;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageLeft;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageRight;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageUp;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PasteText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PerformImeAction;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> RequestFocus;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy;

    @NotNull
    private static final SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> ScrollByOffset;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> SetProgress;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetTextSubstitution;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> ShowTextSubstitution;

    static {
        SemanticsPropertiesKt.C22251 c22251 = SemanticsPropertiesKt.C22251.INSTANCE;
        GetTextLayoutResult = SemanticsPropertiesKt.AccessibilityKey("GetTextLayoutResult", c22251);
        OnClick = SemanticsPropertiesKt.AccessibilityKey("OnClick", c22251);
        OnLongClick = SemanticsPropertiesKt.AccessibilityKey("OnLongClick", c22251);
        ScrollBy = SemanticsPropertiesKt.AccessibilityKey("ScrollBy", c22251);
        ScrollByOffset = new SemanticsPropertyKey<>("ScrollByOffset", null, 2, null);
        ScrollToIndex = SemanticsPropertiesKt.AccessibilityKey("ScrollToIndex", c22251);
        OnAutofillText = SemanticsPropertiesKt.AccessibilityKey("OnAutofillText", c22251);
        SetProgress = SemanticsPropertiesKt.AccessibilityKey("SetProgress", c22251);
        SetSelection = SemanticsPropertiesKt.AccessibilityKey("SetSelection", c22251);
        SetText = SemanticsPropertiesKt.AccessibilityKey("SetText", c22251);
        SetTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("SetTextSubstitution", c22251);
        ShowTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ShowTextSubstitution", c22251);
        ClearTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ClearTextSubstitution", c22251);
        InsertTextAtCursor = SemanticsPropertiesKt.AccessibilityKey("InsertTextAtCursor", c22251);
        OnImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", c22251);
        PerformImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", c22251);
        CopyText = SemanticsPropertiesKt.AccessibilityKey("CopyText", c22251);
        CutText = SemanticsPropertiesKt.AccessibilityKey("CutText", c22251);
        PasteText = SemanticsPropertiesKt.AccessibilityKey("PasteText", c22251);
        Expand = SemanticsPropertiesKt.AccessibilityKey("Expand", c22251);
        Collapse = SemanticsPropertiesKt.AccessibilityKey("Collapse", c22251);
        Dismiss = SemanticsPropertiesKt.AccessibilityKey("Dismiss", c22251);
        RequestFocus = SemanticsPropertiesKt.AccessibilityKey("RequestFocus", c22251);
        CustomActions = SemanticsPropertiesKt.AccessibilityKey("CustomActions");
        PageUp = SemanticsPropertiesKt.AccessibilityKey("PageUp", c22251);
        PageLeft = SemanticsPropertiesKt.AccessibilityKey("PageLeft", c22251);
        PageDown = SemanticsPropertiesKt.AccessibilityKey("PageDown", c22251);
        PageRight = SemanticsPropertiesKt.AccessibilityKey("PageRight", c22251);
        GetScrollViewportLength = SemanticsPropertiesKt.AccessibilityKey("GetScrollViewportLength", c22251);
        $stable = 8;
    }

    private SemanticsActions() {
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getClearTextSubstitution() {
        return ClearTextSubstitution;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCollapse() {
        return Collapse;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCopyText() {
        return CopyText;
    }

    @NotNull
    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCutText() {
        return CutText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getDismiss() {
        return Dismiss;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getExpand() {
        return Expand;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<Float>, Boolean>>> getGetScrollViewportLength() {
        return GetScrollViewportLength;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getOnAutofillText$ui_release() {
        return OnAutofillText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnClick() {
        return OnClick;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnImeAction() {
        return OnImeAction;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnLongClick() {
        return OnLongClick;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageDown() {
        return PageDown;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageLeft() {
        return PageLeft;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageRight() {
        return PageRight;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageUp() {
        return PageUp;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPasteText() {
        return PasteText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPerformImeAction() {
        return PerformImeAction;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getRequestFocus() {
        return RequestFocus;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> getScrollBy() {
        return ScrollBy;
    }

    @NotNull
    public final SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> getScrollByOffset() {
        return ScrollByOffset;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> getScrollToIndex() {
        return ScrollToIndex;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> getSetProgress() {
        return SetProgress;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SetSelection;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetText() {
        return SetText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetTextSubstitution() {
        return SetTextSubstitution;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> getShowTextSubstitution() {
        return ShowTextSubstitution;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `SemanticsActions.OnImeAction` instead.", replaceWith = @ReplaceWith(expression = "OnImeAction", imports = {"androidx.compose.ui.semantics.SemanticsActions.OnImeAction"}))
    public static /* synthetic */ void getPerformImeAction$annotations() {
    }
}
