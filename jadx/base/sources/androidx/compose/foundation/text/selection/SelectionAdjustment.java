package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/foundation/text/selection/Selection;", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface SelectionAdjustment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "()V", "Character", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getCharacter", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "None", "getNone", "Paragraph", "getParagraph", "Word", "getWord", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final SelectionAdjustment Character;

        @NotNull
        private static final SelectionAdjustment CharacterWithWordAccelerate;

        @NotNull
        private static final SelectionAdjustment None;

        @NotNull
        private static final SelectionAdjustment Paragraph;

        @NotNull
        private static final SelectionAdjustment Word;

        static {
            final int i = 0;
            None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.a
                @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
                public final Selection adjust(SelectionLayout selectionLayout) {
                    switch (i) {
                        case 0:
                            return SelectionAdjustment.Companion.None$lambda$0(selectionLayout);
                        case 1:
                            return SelectionAdjustment.Companion.Character$lambda$1(selectionLayout);
                        case 2:
                            return SelectionAdjustment.Companion.Word$lambda$2(selectionLayout);
                        case 3:
                            return SelectionAdjustment.Companion.Paragraph$lambda$3(selectionLayout);
                        default:
                            return SelectionAdjustment.Companion.CharacterWithWordAccelerate$lambda$4(selectionLayout);
                    }
                }
            };
            final int i2 = 1;
            Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.a
                @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
                public final Selection adjust(SelectionLayout selectionLayout) {
                    switch (i2) {
                        case 0:
                            return SelectionAdjustment.Companion.None$lambda$0(selectionLayout);
                        case 1:
                            return SelectionAdjustment.Companion.Character$lambda$1(selectionLayout);
                        case 2:
                            return SelectionAdjustment.Companion.Word$lambda$2(selectionLayout);
                        case 3:
                            return SelectionAdjustment.Companion.Paragraph$lambda$3(selectionLayout);
                        default:
                            return SelectionAdjustment.Companion.CharacterWithWordAccelerate$lambda$4(selectionLayout);
                    }
                }
            };
            final int i4 = 2;
            Word = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.a
                @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
                public final Selection adjust(SelectionLayout selectionLayout) {
                    switch (i4) {
                        case 0:
                            return SelectionAdjustment.Companion.None$lambda$0(selectionLayout);
                        case 1:
                            return SelectionAdjustment.Companion.Character$lambda$1(selectionLayout);
                        case 2:
                            return SelectionAdjustment.Companion.Word$lambda$2(selectionLayout);
                        case 3:
                            return SelectionAdjustment.Companion.Paragraph$lambda$3(selectionLayout);
                        default:
                            return SelectionAdjustment.Companion.CharacterWithWordAccelerate$lambda$4(selectionLayout);
                    }
                }
            };
            final int i5 = 3;
            Paragraph = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.a
                @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
                public final Selection adjust(SelectionLayout selectionLayout) {
                    switch (i5) {
                        case 0:
                            return SelectionAdjustment.Companion.None$lambda$0(selectionLayout);
                        case 1:
                            return SelectionAdjustment.Companion.Character$lambda$1(selectionLayout);
                        case 2:
                            return SelectionAdjustment.Companion.Word$lambda$2(selectionLayout);
                        case 3:
                            return SelectionAdjustment.Companion.Paragraph$lambda$3(selectionLayout);
                        default:
                            return SelectionAdjustment.Companion.CharacterWithWordAccelerate$lambda$4(selectionLayout);
                    }
                }
            };
            final int i6 = 4;
            CharacterWithWordAccelerate = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.a
                @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
                public final Selection adjust(SelectionLayout selectionLayout) {
                    switch (i6) {
                        case 0:
                            return SelectionAdjustment.Companion.None$lambda$0(selectionLayout);
                        case 1:
                            return SelectionAdjustment.Companion.Character$lambda$1(selectionLayout);
                        case 2:
                            return SelectionAdjustment.Companion.Word$lambda$2(selectionLayout);
                        case 3:
                            return SelectionAdjustment.Companion.Paragraph$lambda$3(selectionLayout);
                        default:
                            return SelectionAdjustment.Companion.CharacterWithWordAccelerate$lambda$4(selectionLayout);
                    }
                }
            };
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection Character$lambda$1(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(None.adjust(selectionLayout), selectionLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection CharacterWithWordAccelerate$lambda$4(SelectionLayout selectionLayout) {
            Selection.AnchorInfo end;
            Selection.AnchorInfo anchorInfoUpdateSelectionBoundary;
            Selection.AnchorInfo start;
            Selection.AnchorInfo end2;
            Selection previousSelection = selectionLayout.getPreviousSelection();
            if (previousSelection == null) {
                return Word.adjust(selectionLayout);
            }
            if (selectionLayout.isStartHandle()) {
                end = previousSelection.getStart();
                anchorInfoUpdateSelectionBoundary = SelectionAdjustmentKt.updateSelectionBoundary(selectionLayout, selectionLayout.getStartInfo(), end);
                end2 = previousSelection.getEnd();
                start = anchorInfoUpdateSelectionBoundary;
            } else {
                end = previousSelection.getEnd();
                anchorInfoUpdateSelectionBoundary = SelectionAdjustmentKt.updateSelectionBoundary(selectionLayout, selectionLayout.getEndInfo(), end);
                start = previousSelection.getStart();
                end2 = anchorInfoUpdateSelectionBoundary;
            }
            if (Intrinsics.areEqual(anchorInfoUpdateSelectionBoundary, end)) {
                return previousSelection;
            }
            return SelectionAdjustmentKt.ensureAtLeastOneChar(new Selection(start, end2, selectionLayout.getCrossStatus() == CrossStatus.CROSSED || (selectionLayout.getCrossStatus() == CrossStatus.COLLAPSED && start.getOffset() > end2.getOffset())), selectionLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection None$lambda$0(SelectionLayout selectionLayout) {
            return new Selection(selectionLayout.getStartInfo().anchorForOffset(selectionLayout.getStartInfo().getRawStartHandleOffset()), selectionLayout.getEndInfo().anchorForOffset(selectionLayout.getEndInfo().getRawEndHandleOffset()), selectionLayout.getCrossStatus() == CrossStatus.CROSSED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection Paragraph$lambda$3(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.adjustToBoundaries(selectionLayout, new BoundaryFunction() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1$1
                @Override // androidx.compose.foundation.text.selection.BoundaryFunction
                /* JADX INFO: renamed from: getBoundary-fzxv0v0 */
                public final long mo16496getBoundaryfzxv0v0(@NotNull SelectableInfo selectableInfo, int i) {
                    return StringHelpersKt.getParagraphBoundary(selectableInfo.getInputText(), i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection Word$lambda$2(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.adjustToBoundaries(selectionLayout, new BoundaryFunction() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1$1
                @Override // androidx.compose.foundation.text.selection.BoundaryFunction
                /* JADX INFO: renamed from: getBoundary-fzxv0v0 */
                public final long mo16496getBoundaryfzxv0v0(@NotNull SelectableInfo selectableInfo, int i) {
                    return selectableInfo.getTextLayoutResult().m20430getWordBoundaryjx7JFs(i);
                }
            });
        }

        @NotNull
        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        @NotNull
        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        @NotNull
        public final SelectionAdjustment getNone() {
            return None;
        }

        @NotNull
        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        @NotNull
        public final SelectionAdjustment getWord() {
            return Word;
        }
    }

    @NotNull
    Selection adjust(@NotNull SelectionLayout layout);
}
