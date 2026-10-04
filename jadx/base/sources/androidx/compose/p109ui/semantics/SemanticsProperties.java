package androidx.compose.p109ui.semantics;

import androidx.compose.p109ui.autofill.ContentDataType;
import androidx.compose.p109ui.autofill.ContentType;
import androidx.compose.p109ui.state.ToggleableState;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R#\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020*0)0\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u0010\u0007R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020*0\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0007R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u001d\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0007R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0007R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0007R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020#0\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0007¨\u0006a"}, m13886d2 = {"Landroidx/compose/ui/semantics/SemanticsProperties;", "", "()V", "CollectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "CollectionItemInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "getCollectionItemInfo", "ContentDataType", "Landroidx/compose/ui/autofill/ContentDataType;", "getContentDataType$ui_release", "ContentDescription", "", "", "getContentDescription", "ContentType", "Landroidx/compose/ui/autofill/ContentType;", "getContentType$ui_release", "Disabled", "", "getDisabled", "EditableText", "Landroidx/compose/ui/text/AnnotatedString;", "getEditableText", "Error", "getError", "Focused", "", "getFocused", "Heading", "getHeading", "HorizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "ImeAction", "Landroidx/compose/ui/text/input/ImeAction;", "getImeAction", "IndexForKey", "Lkotlin/Function1;", "", "getIndexForKey", "InvisibleToUser", "getInvisibleToUser", "IsContainer", "getIsContainer$annotations", "getIsContainer", "IsDialog", "getIsDialog", "IsEditable", "getIsEditable", "IsPopup", "getIsPopup", "IsShowingTextSubstitution", "getIsShowingTextSubstitution", "IsTraversalGroup", "getIsTraversalGroup", "LiveRegion", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "MaxTextLength", "getMaxTextLength", "PaneTitle", "getPaneTitle", "Password", "getPassword", "ProgressBarRangeInfo", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getProgressBarRangeInfo", "Role", "Landroidx/compose/ui/semantics/Role;", "getRole", "SelectableGroup", "getSelectableGroup", "Selected", "getSelected", "StateDescription", "getStateDescription", "TestTag", "getTestTag", Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, "getText", "TextSelectionRange", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "TextSubstitution", "getTextSubstitution", "ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", "getToggleableState", "TraversalIndex", "", "getTraversalIndex", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SemanticsProperties {

    @NotNull
    public static final SemanticsProperties INSTANCE = new SemanticsProperties();

    @NotNull
    private static final SemanticsPropertyKey<List<String>> ContentDescription = SemanticsPropertiesKt.AccessibilityKey("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends String> invoke(List<? extends String> list, List<? extends String> list2) {
            return invoke2((List<String>) list, (List<String>) list2);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<String> invoke2(@Nullable List<String> list, @NotNull List<String> list2) {
            List<String> mutableList;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return list2;
            }
            mutableList.addAll(list2);
            return mutableList;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<String> StateDescription = SemanticsPropertiesKt.AccessibilityKey("StateDescription");

    @NotNull
    private static final SemanticsPropertyKey<ProgressBarRangeInfo> ProgressBarRangeInfo = SemanticsPropertiesKt.AccessibilityKey("ProgressBarRangeInfo");

    @NotNull
    private static final SemanticsPropertyKey<String> PaneTitle = SemanticsPropertiesKt.AccessibilityKey("PaneTitle", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final String invoke(@Nullable String str, @NotNull String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<Unit> SelectableGroup = SemanticsPropertiesKt.AccessibilityKey("SelectableGroup");

    @NotNull
    private static final SemanticsPropertyKey<CollectionInfo> CollectionInfo = SemanticsPropertiesKt.AccessibilityKey("CollectionInfo");

    @NotNull
    private static final SemanticsPropertyKey<CollectionItemInfo> CollectionItemInfo = SemanticsPropertiesKt.AccessibilityKey("CollectionItemInfo");

    @NotNull
    private static final SemanticsPropertyKey<Unit> Heading = SemanticsPropertiesKt.AccessibilityKey("Heading");

    @NotNull
    private static final SemanticsPropertyKey<Unit> Disabled = SemanticsPropertiesKt.AccessibilityKey("Disabled");

    @NotNull
    private static final SemanticsPropertyKey<LiveRegionMode> LiveRegion = SemanticsPropertiesKt.AccessibilityKey("LiveRegion");

    @NotNull
    private static final SemanticsPropertyKey<Boolean> Focused = SemanticsPropertiesKt.AccessibilityKey("Focused");

    @NotNull
    private static final SemanticsPropertyKey<Boolean> IsTraversalGroup = SemanticsPropertiesKt.AccessibilityKey("IsTraversalGroup");

    @NotNull
    private static final SemanticsPropertyKey<Unit> InvisibleToUser = new SemanticsPropertyKey<>("InvisibleToUser", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Unit invoke(@Nullable Unit unit, @NotNull Unit unit2) {
            return unit;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<ContentType> ContentType = new SemanticsPropertyKey<>("ContentType", new Function2<ContentType, ContentType, ContentType>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentType$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final ContentType invoke(@Nullable ContentType contentType, @NotNull ContentType contentType2) {
            return contentType;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<ContentDataType> ContentDataType = new SemanticsPropertyKey<>("ContentDataType", new Function2<ContentDataType, ContentDataType, ContentDataType>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDataType$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ContentDataType invoke(ContentDataType contentDataType, ContentDataType contentDataType2) {
            return m20278invokex33U9Dw(contentDataType, contentDataType2.m18148unboximpl());
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-x33U9Dw, reason: not valid java name */
        public final ContentDataType m20278invokex33U9Dw(@Nullable ContentDataType contentDataType, int i) {
            return contentDataType;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<Float> TraversalIndex = SemanticsPropertiesKt.AccessibilityKey("TraversalIndex", new Function2<Float, Float, Float>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        @Nullable
        public final Float invoke(@Nullable Float f, float f4) {
            return f;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Float invoke(Float f, Float f4) {
            return invoke(f, f4.floatValue());
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<ScrollAxisRange> HorizontalScrollAxisRange = SemanticsPropertiesKt.AccessibilityKey("HorizontalScrollAxisRange");

    @NotNull
    private static final SemanticsPropertyKey<ScrollAxisRange> VerticalScrollAxisRange = SemanticsPropertiesKt.AccessibilityKey("VerticalScrollAxisRange");

    @NotNull
    private static final SemanticsPropertyKey<Unit> IsPopup = SemanticsPropertiesKt.AccessibilityKey("IsPopup", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Unit invoke(@Nullable Unit unit, @NotNull Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<Unit> IsDialog = SemanticsPropertiesKt.AccessibilityKey("IsDialog", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Unit invoke(@Nullable Unit unit, @NotNull Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<Role> Role = SemanticsPropertiesKt.AccessibilityKey("Role", new Function2<Role, Role, Role>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Role invoke(Role role, Role role2) {
            return m20279invokeqtAw6s(role, role2.getValue());
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-qtA-w6s, reason: not valid java name */
        public final Role m20279invokeqtAw6s(@Nullable Role role, int i) {
            return role;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<String> TestTag = new SemanticsPropertyKey<>("TestTag", false, new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final String invoke(@Nullable String str, @NotNull String str2) {
            return str;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<List<AnnotatedString>> Text = SemanticsPropertiesKt.AccessibilityKey(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, new Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends AnnotatedString> invoke(List<? extends AnnotatedString> list, List<? extends AnnotatedString> list2) {
            return invoke2((List<AnnotatedString>) list, (List<AnnotatedString>) list2);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<AnnotatedString> invoke2(@Nullable List<AnnotatedString> list, @NotNull List<AnnotatedString> list2) {
            List<AnnotatedString> mutableList;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return list2;
            }
            mutableList.addAll(list2);
            return mutableList;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<AnnotatedString> TextSubstitution = new SemanticsPropertyKey<>("TextSubstitution", null, 2, null);

    @NotNull
    private static final SemanticsPropertyKey<Boolean> IsShowingTextSubstitution = new SemanticsPropertyKey<>("IsShowingTextSubstitution", null, 2, null);

    @NotNull
    private static final SemanticsPropertyKey<AnnotatedString> EditableText = SemanticsPropertiesKt.AccessibilityKey("EditableText");

    @NotNull
    private static final SemanticsPropertyKey<TextRange> TextSelectionRange = SemanticsPropertiesKt.AccessibilityKey("TextSelectionRange");

    @NotNull
    private static final SemanticsPropertyKey<ImeAction> ImeAction = SemanticsPropertiesKt.AccessibilityKey("ImeAction");

    @NotNull
    private static final SemanticsPropertyKey<Boolean> Selected = SemanticsPropertiesKt.AccessibilityKey("Selected");

    @NotNull
    private static final SemanticsPropertyKey<ToggleableState> ToggleableState = SemanticsPropertiesKt.AccessibilityKey("ToggleableState");

    @NotNull
    private static final SemanticsPropertyKey<Unit> Password = SemanticsPropertiesKt.AccessibilityKey("Password");

    @NotNull
    private static final SemanticsPropertyKey<String> Error = SemanticsPropertiesKt.AccessibilityKey("Error");

    @NotNull
    private static final SemanticsPropertyKey<Function1<Object, Integer>> IndexForKey = new SemanticsPropertyKey<>("IndexForKey", null, 2, null);

    @NotNull
    private static final SemanticsPropertyKey<Boolean> IsEditable = new SemanticsPropertyKey<>("IsEditable", null, 2, null);

    @NotNull
    private static final SemanticsPropertyKey<Integer> MaxTextLength = new SemanticsPropertyKey<>("MaxTextLength", null, 2, null);
    public static final int $stable = 8;

    private SemanticsProperties() {
    }

    @NotNull
    public final SemanticsPropertyKey<CollectionInfo> getCollectionInfo() {
        return CollectionInfo;
    }

    @NotNull
    public final SemanticsPropertyKey<CollectionItemInfo> getCollectionItemInfo() {
        return CollectionItemInfo;
    }

    @NotNull
    public final SemanticsPropertyKey<ContentDataType> getContentDataType$ui_release() {
        return ContentDataType;
    }

    @NotNull
    public final SemanticsPropertyKey<List<String>> getContentDescription() {
        return ContentDescription;
    }

    @NotNull
    public final SemanticsPropertyKey<ContentType> getContentType$ui_release() {
        return ContentType;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getDisabled() {
        return Disabled;
    }

    @NotNull
    public final SemanticsPropertyKey<AnnotatedString> getEditableText() {
        return EditableText;
    }

    @NotNull
    public final SemanticsPropertyKey<String> getError() {
        return Error;
    }

    @NotNull
    public final SemanticsPropertyKey<Boolean> getFocused() {
        return Focused;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getHeading() {
        return Heading;
    }

    @NotNull
    public final SemanticsPropertyKey<ScrollAxisRange> getHorizontalScrollAxisRange() {
        return HorizontalScrollAxisRange;
    }

    @NotNull
    public final SemanticsPropertyKey<ImeAction> getImeAction() {
        return ImeAction;
    }

    @NotNull
    public final SemanticsPropertyKey<Function1<Object, Integer>> getIndexForKey() {
        return IndexForKey;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getInvisibleToUser() {
        return InvisibleToUser;
    }

    @NotNull
    public final SemanticsPropertyKey<Boolean> getIsContainer() {
        return IsTraversalGroup;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getIsDialog() {
        return IsDialog;
    }

    @NotNull
    public final SemanticsPropertyKey<Boolean> getIsEditable() {
        return IsEditable;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getIsPopup() {
        return IsPopup;
    }

    @NotNull
    public final SemanticsPropertyKey<Boolean> getIsShowingTextSubstitution() {
        return IsShowingTextSubstitution;
    }

    @NotNull
    public final SemanticsPropertyKey<Boolean> getIsTraversalGroup() {
        return IsTraversalGroup;
    }

    @NotNull
    public final SemanticsPropertyKey<LiveRegionMode> getLiveRegion() {
        return LiveRegion;
    }

    @NotNull
    public final SemanticsPropertyKey<Integer> getMaxTextLength() {
        return MaxTextLength;
    }

    @NotNull
    public final SemanticsPropertyKey<String> getPaneTitle() {
        return PaneTitle;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getPassword() {
        return Password;
    }

    @NotNull
    public final SemanticsPropertyKey<ProgressBarRangeInfo> getProgressBarRangeInfo() {
        return ProgressBarRangeInfo;
    }

    @NotNull
    public final SemanticsPropertyKey<Role> getRole() {
        return Role;
    }

    @NotNull
    public final SemanticsPropertyKey<Unit> getSelectableGroup() {
        return SelectableGroup;
    }

    @NotNull
    public final SemanticsPropertyKey<Boolean> getSelected() {
        return Selected;
    }

    @NotNull
    public final SemanticsPropertyKey<String> getStateDescription() {
        return StateDescription;
    }

    @NotNull
    public final SemanticsPropertyKey<String> getTestTag() {
        return TestTag;
    }

    @NotNull
    public final SemanticsPropertyKey<List<AnnotatedString>> getText() {
        return Text;
    }

    @NotNull
    public final SemanticsPropertyKey<TextRange> getTextSelectionRange() {
        return TextSelectionRange;
    }

    @NotNull
    public final SemanticsPropertyKey<AnnotatedString> getTextSubstitution() {
        return TextSubstitution;
    }

    @NotNull
    public final SemanticsPropertyKey<ToggleableState> getToggleableState() {
        return ToggleableState;
    }

    @NotNull
    public final SemanticsPropertyKey<Float> getTraversalIndex() {
        return TraversalIndex;
    }

    @NotNull
    public final SemanticsPropertyKey<ScrollAxisRange> getVerticalScrollAxisRange() {
        return VerticalScrollAxisRange;
    }

    @Deprecated(message = "Use `isTraversalGroup` instead.", replaceWith = @ReplaceWith(expression = "IsTraversalGroup", imports = {}))
    public static /* synthetic */ void getIsContainer$annotations() {
    }
}
