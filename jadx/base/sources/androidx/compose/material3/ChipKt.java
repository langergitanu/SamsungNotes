package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a¦\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a¼\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0097\u0001\u0010(\u001a\u00020\b2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0001H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a¦\u0001\u0010.\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a®\u0001\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00104\u001a\u008f\u0001\u00105\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00107\u001a®\u0001\u00108\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00104\u001aÅ\u0001\u00109\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u0002012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001032\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010:\u001aÑ\u0001\u0010;\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\u0006\u0010\u001f\u001a\u00020 2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u0002012\b\u0010\u0017\u001a\u0004\u0018\u0001022\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u008f\u0001\u0010>\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u00107\u001a&\u0010?\u001a\u00020\u00012\b\b\u0002\u0010@\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020\u00102\b\b\u0002\u0010B\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006C"}, m13886d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "SuggestionChipPadding", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/material3/ChipBorder;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/foundation/BorderStroke;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "Landroidx/compose/material3/SelectableChipBorder;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/material3/SelectableChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/material3/SelectableChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ChipKt {

    @NotNull
    private static final PaddingValues AssistChipPadding;

    @NotNull
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;

    @NotNull
    private static final PaddingValues SuggestionChipPadding;

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(8);
        HorizontalElementsPadding = fM20968constructorimpl;
        AssistChipPadding = PaddingKt.m15849PaddingValuesYgX7TsA$default(fM20968constructorimpl, 0.0f, 2, null);
        FilterChipPadding = PaddingKt.m15849PaddingValuesYgX7TsA$default(fM20968constructorimpl, 0.0f, 2, null);
        SuggestionChipPadding = PaddingKt.m15849PaddingValuesYgX7TsA$default(fM20968constructorimpl, 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0367 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AssistChip(@NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, @Nullable ChipColors chipColors, @Nullable ChipElevation chipElevation, @Nullable ChipBorder chipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i8;
        Shape shape2;
        ChipColors chipColors2;
        int i9;
        int i10;
        int i11;
        Modifier modifier3;
        int i12;
        Composer composer2;
        int i13;
        ChipColors chipColorsM16998assistChipColorsoq7We08;
        ChipElevation chipElevationM16999assistChipElevationaqJV_2Y;
        ChipBorder chipBorderM16997assistChipBorderd_3_b6Q;
        Shape shape3;
        ChipBorder chipBorder2;
        ChipColors chipColors3;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer3;
        final Modifier modifier4;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource3;
        final ChipBorder chipBorder3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1932300596);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        int i14 = i4 & 4;
        if (i14 != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 == 0) {
                    if ((i & 57344) == 0) {
                        function23 = function2;
                        i5 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 196608;
                    } else if ((i & 458752) == 0) {
                        i5 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
                    }
                    if ((i & 3670016) != 0) {
                        shape2 = shape;
                        i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(shape2)) ? 1048576 : 524288;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        if ((i4 & 128) == 0) {
                            chipColors2 = chipColors;
                            int i15 = composerStartRestartGroup.changed(chipColors2) ? 8388608 : 4194304;
                            i5 |= i15;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i5 |= i15;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 234881024) == 0) {
                        i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(chipElevation)) ? 67108864 : 33554432;
                    }
                    if ((i & 1879048192) == 0) {
                        i5 |= ((i4 & 512) == 0 && composerStartRestartGroup.changed(chipBorder)) ? 536870912 : 268435456;
                    }
                    i9 = i4 & 1024;
                    if (i9 == 0) {
                        i10 = i9;
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        i10 = i9;
                        i11 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i10 = i9;
                        i11 = i2;
                    }
                    if ((i5 & 1533916891) != 306783378 && (i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function27 = function22;
                        chipBorder3 = chipBorder;
                        chipColors4 = chipColors2;
                        modifier4 = modifier2;
                        composer3 = composerStartRestartGroup;
                        function26 = function23;
                        chipElevation2 = chipElevation;
                        mutableInteractionSource3 = mutableInteractionSource;
                        shape4 = shape2;
                        z4 = z2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i6 == 0 ? true : z2;
                            Function2<? super Composer, ? super Integer, Unit> function28 = i7 == 0 ? null : function23;
                            Function2<? super Composer, ? super Integer, Unit> function29 = i8 == 0 ? null : function22;
                            if ((i4 & 64) != 0) {
                                shape2 = AssistChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i5 &= -3670017;
                            }
                            int i16 = i5;
                            if ((i4 & 128) == 0) {
                                composer2 = composerStartRestartGroup;
                                i13 = i10;
                                i12 = i11;
                                i16 &= -29360129;
                                chipColorsM16998assistChipColorsoq7We08 = AssistChipDefaults.INSTANCE.m16998assistChipColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, 255);
                            } else {
                                i12 = i11;
                                composer2 = composerStartRestartGroup;
                                i13 = i10;
                                chipColorsM16998assistChipColorsoq7We08 = chipColors2;
                            }
                            if ((i4 & 256) == 0) {
                                i16 &= -234881025;
                                chipElevationM16999assistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m16999assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                            } else {
                                chipElevationM16999assistChipElevationaqJV_2Y = chipElevation;
                            }
                            if ((i4 & 512) == 0) {
                                composerStartRestartGroup = composer2;
                                chipBorderM16997assistChipBorderd_3_b6Q = AssistChipDefaults.INSTANCE.m16997assistChipBorderd_3_b6Q(0L, 0L, 0.0f, composerStartRestartGroup, 3072, 7);
                                i16 &= -1879048193;
                            } else {
                                composerStartRestartGroup = composer2;
                                chipBorderM16997assistChipBorderd_3_b6Q = chipBorder;
                            }
                            if (i13 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                shape3 = shape2;
                                chipBorder2 = chipBorderM16997assistChipBorderd_3_b6Q;
                                chipColors3 = chipColorsM16998assistChipColorsoq7We08;
                                z3 = z5;
                                function24 = function28;
                                function25 = function29;
                                i5 = i16;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                shape3 = shape2;
                                chipBorder2 = chipBorderM16997assistChipBorderd_3_b6Q;
                                chipColors3 = chipColorsM16998assistChipColorsoq7We08;
                                z3 = z5;
                                function24 = function28;
                                function25 = function29;
                                i5 = i16;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 64) != 0) {
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                i5 &= -29360129;
                            }
                            if ((i4 & 256) != 0) {
                                i5 &= -234881025;
                            }
                            if ((i4 & 512) != 0) {
                                i5 &= -1879048193;
                            }
                            function25 = function22;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i12 = i11;
                            chipColors3 = chipColors2;
                            modifier3 = modifier2;
                            z3 = z2;
                            function24 = function23;
                            chipElevationM16999assistChipElevationaqJV_2Y = chipElevation;
                            shape3 = shape2;
                            chipBorder2 = chipBorder;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1932300596, i5, i12, "androidx.compose.material3.AssistChip (Chip.kt:104)");
                        }
                        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                        int i17 = (i5 >> 9) & 14;
                        long jM18535unboximpl = chipColors3.labelColor$material3_release(z3, composerStartRestartGroup, ((i5 >> 18) & 112) | i17).getValue().m18535unboximpl();
                        State<BorderStroke> stateBorderStroke$material3_release = chipBorder2 != null ? null : chipBorder2.borderStroke$material3_release(z3, composerStartRestartGroup, i17 | ((i5 >> 24) & 112));
                        composer3 = composerStartRestartGroup;
                        ChipElevation chipElevation3 = chipElevationM16999assistChipElevationaqJV_2Y;
                        Modifier modifier5 = modifier3;
                        int i18 = i5 << 6;
                        ChipBorder chipBorder4 = chipBorder2;
                        m17029ChipnkUnTEs(modifier5, onClick, z3, label, textStyleFromToken, jM18535unboximpl, function24, function25, shape3, chipColors3, chipElevation3, stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m17002getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, composer3, (i18 & 1879048192) | ((i5 >> 6) & 14) | ((i5 << 3) & 112) | ((i5 >> 3) & 896) | (i18 & 7168) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024), ((i5 >> 24) & 14) | 3456 | ((i12 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier5;
                        z4 = z3;
                        function26 = function24;
                        function27 = function25;
                        shape4 = shape3;
                        chipColors4 = chipColors3;
                        chipElevation2 = chipElevation3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        chipBorder3 = chipBorder4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.AssistChip.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer4, int i19) {
                            ChipKt.AssistChip(onClick, label, modifier4, z4, function26, function27, shape4, chipColors4, chipElevation2, chipBorder3, mutableInteractionSource3, composer4, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i5 |= 24576;
                function23 = function2;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) != 0) {
                }
                if ((i & 234881024) == 0) {
                }
                if ((i & 1879048192) == 0) {
                }
                i9 = i4 & 1024;
                if (i9 == 0) {
                }
                if ((i5 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i4 & 64) != 0) {
                        }
                        int i162 = i5;
                        if ((i4 & 128) == 0) {
                        }
                        if ((i4 & 256) == 0) {
                        }
                        if ((i4 & 512) == 0) {
                        }
                        if (i13 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                        int i172 = (i5 >> 9) & 14;
                        long jM18535unboximpl2 = chipColors3.labelColor$material3_release(z3, composerStartRestartGroup, ((i5 >> 18) & 112) | i172).getValue().m18535unboximpl();
                        if (chipBorder2 != null) {
                        }
                        composer3 = composerStartRestartGroup;
                        ChipElevation chipElevation32 = chipElevationM16999assistChipElevationaqJV_2Y;
                        Modifier modifier52 = modifier3;
                        int i182 = i5 << 6;
                        ChipBorder chipBorder42 = chipBorder2;
                        m17029ChipnkUnTEs(modifier52, onClick, z3, label, textStyleFromToken2, jM18535unboximpl2, function24, function25, shape3, chipColors3, chipElevation32, stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m17002getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, composer3, (i182 & 1879048192) | ((i5 >> 6) & 14) | ((i5 << 3) & 112) | ((i5 >> 3) & 896) | (i182 & 7168) | (i182 & 3670016) | (i182 & 29360128) | (i182 & 234881024), ((i5 >> 24) & 14) | 3456 | ((i12 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier52;
                        z4 = z3;
                        function26 = function24;
                        function27 = function25;
                        shape4 = shape3;
                        chipColors4 = chipColors3;
                        chipElevation2 = chipElevation32;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        chipBorder3 = chipBorder42;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 == 0) {
            }
            function23 = function2;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) != 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            i9 = i4 & 1024;
            if (i9 == 0) {
            }
            if ((i5 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        function23 = function2;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        i9 = i4 & 1024;
        if (i9 == 0) {
        }
        if ((i5 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Chip-nkUnTEs, reason: not valid java name */
    public static final void m17029ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1400504719);
        if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            function24 = function2;
            i4 |= composerStartRestartGroup.changed(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        if ((i & 57344) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 1048576 : 524288;
        }
        if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changed(function23) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(chipColors) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(chipElevation) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(borderStroke) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i2 & 57344) == 0) {
            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
        }
        final int i6 = i5;
        if ((i4 & 1533916891) == 306783378 && (46811 & i6) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, i4, i6, "androidx.compose.material3.Chip (Chip.kt:1308)");
            }
            int i7 = (i4 >> 6) & 14;
            long jM18535unboximpl = chipColors.containerColor$material3_release(z, composerStartRestartGroup, ((i4 >> 24) & 112) | i7).getValue().m18535unboximpl();
            composerStartRestartGroup.startReplaceableGroup(64019101);
            State<C2256Dp> state = chipElevation == null ? null : chipElevation.tonalElevation$material3_release(z, mutableInteractionSource, composerStartRestartGroup, i7 | ((i6 >> 9) & 112) | ((i6 << 6) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            float fM20982unboximpl = state != null ? state.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0);
            State<C2256Dp> stateShadowElevation$material3_release = chipElevation == null ? null : chipElevation.shadowElevation$material3_release(z, mutableInteractionSource, composerStartRestartGroup, i7 | ((i6 >> 9) & 112) | ((i6 << 6) & 896));
            composer2 = composerStartRestartGroup;
            final int i8 = i4;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            SurfaceKt.m17328Surfaceo_FOJdg(function0, modifier, z, shape, jM18535unboximpl, 0L, fM20982unboximpl, stateShadowElevation$material3_release != null ? stateShadowElevation$material3_release.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0), borderStroke, mutableInteractionSource, ComposableLambdaKt.composableLambda(composer2, -1985962652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer3, int i9) {
                    if ((i9 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1985962652, i9, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1335)");
                    }
                    Function2<Composer, Integer, Unit> function26 = function25;
                    TextStyle textStyle2 = textStyle;
                    long j2 = j;
                    Function2<Composer, Integer, Unit> function27 = function22;
                    Function2<Composer, Integer, Unit> function28 = function23;
                    ChipColors chipColors2 = chipColors;
                    boolean z2 = z;
                    int i10 = i8;
                    long jM18535unboximpl2 = chipColors2.leadingIconContentColor$material3_release(z2, composer3, ((i10 >> 24) & 112) | ((i10 >> 6) & 14)).getValue().m18535unboximpl();
                    ChipColors chipColors3 = chipColors;
                    boolean z3 = z;
                    int i11 = i8;
                    long jM18535unboximpl3 = chipColors3.trailingIconContentColor$material3_release(z3, composer3, ((i11 >> 24) & 112) | ((i11 >> 6) & 14)).getValue().m18535unboximpl();
                    float f4 = f;
                    PaddingValues paddingValues2 = paddingValues;
                    int i12 = i8;
                    int i13 = ((i12 >> 9) & 896) | ((i12 >> 9) & 14) | 24576 | ((i12 >> 9) & 112) | ((i12 >> 9) & 7168) | ((i12 >> 6) & 458752);
                    int i14 = i6;
                    ChipKt.m17030ChipContentfe0OD_I(function26, textStyle2, j2, function27, null, function28, jM18535unboximpl2, jM18535unboximpl3, f4, paddingValues2, composer3, i13 | ((i14 << 18) & 234881024) | ((i14 << 18) & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, ((i8 >> 3) & 14) | ((i8 << 3) & 112) | (i8 & 896) | ((i8 >> 15) & 7168) | ((i6 << 21) & 234881024) | ((i6 << 15) & 1879048192), 6, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer3, int i9) {
                ChipKt.m17029ChipnkUnTEs(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer3, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m17030ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j5;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-782878228);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            function25 = function22;
            i2 |= composerStartRestartGroup.changed(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((57344 & i) == 0) {
            function26 = function23;
            i2 |= composerStartRestartGroup.changed(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((458752 & i) == 0) {
            function27 = function24;
            i2 |= composerStartRestartGroup.changed(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((3670016 & i) == 0) {
            j5 = j2;
            i2 |= composerStartRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((29360128 & i) == 0) {
            j6 = j3;
            i2 |= composerStartRestartGroup.changed(j6) ? 8388608 : 4194304;
        } else {
            j6 = j3;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if ((i2 & 1533916891) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, i2, -1, "androidx.compose.material3.ChipContent (Chip.kt:1402)");
            }
            final int i4 = i2;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final long j7 = j5;
            final long j8 = j6;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i5) {
                    if ((i5 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1748799148, i5, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:1417)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m15884defaultMinSizeVpY3zN4$default(companion, 0.0f, f, 1, null), paddingValues);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function2<Composer, Integer, Unit> function211 = function29;
                    int i6 = i4;
                    Function2<Composer, Integer, Unit> function212 = function28;
                    long j9 = j7;
                    Function2<Composer, Integer, Unit> function213 = function2;
                    Function2<Composer, Integer, Unit> function214 = function210;
                    long j10 = j8;
                    composer2.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                    composer2.startReplaceableGroup(-678309503);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(827638800);
                    if (function211 != null) {
                        composer2.startReplaceableGroup(650988385);
                        AbstractC1038a.m1198C(composer2, (i6 >> 12) & 14, function211);
                    } else if (function212 != null) {
                        composer2.startReplaceableGroup(650988456);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j9))}, function212, composer2, ((i6 >> 6) & 112) | 8);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(650988618);
                        composer2.endReplaceableGroup();
                    }
                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.HorizontalElementsPadding), composer2, 6);
                    function213.invoke(composer2, Integer.valueOf(i6 & 14));
                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, ChipKt.HorizontalElementsPadding), composer2, 6);
                    if (function214 != null) {
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j10))}, function214, composer2, ((i6 >> 12) & 112) | 8);
                    }
                    if (AbstractC1038a.m1225z(composer2)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i5) {
                ChipKt.m17030ChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0365 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedAssistChip(@NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, @Nullable ChipColors chipColors, @Nullable ChipElevation chipElevation, @Nullable ChipBorder chipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i8;
        Shape shape2;
        ChipColors chipColors2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier3;
        int i14;
        Composer composer2;
        int i15;
        int i16;
        ChipColors chipColorsM17000elevatedAssistChipColorsoq7We08;
        ChipElevation chipElevationM17001elevatedAssistChipElevationaqJV_2Y;
        Shape shape3;
        ChipElevation chipElevation2;
        ChipBorder chipBorder2;
        ChipColors chipColors3;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer3;
        final Modifier modifier4;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation3;
        final MutableInteractionSource mutableInteractionSource3;
        final ChipBorder chipBorder3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(1295844802);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        int i17 = i4 & 4;
        if (i17 != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i & 57344) == 0) {
                        function23 = function2;
                        i5 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 196608;
                    } else if ((i & 458752) == 0) {
                        i5 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
                    }
                    if ((i & 3670016) != 0) {
                        shape2 = shape;
                        i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(shape2)) ? 1048576 : 524288;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        if ((i4 & 128) == 0) {
                            chipColors2 = chipColors;
                            int i18 = composerStartRestartGroup.changed(chipColors2) ? 8388608 : 4194304;
                            i5 |= i18;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i5 |= i18;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 234881024) == 0) {
                        i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(chipElevation)) ? 67108864 : 33554432;
                    }
                    i9 = i4 & 512;
                    if (i9 != 0) {
                        if ((i & 1879048192) == 0) {
                            i10 = i9;
                            i5 |= composerStartRestartGroup.changed(chipBorder) ? 536870912 : 268435456;
                        }
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i12 = i11;
                            i13 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            i12 = i11;
                            i13 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        if ((i5 & 1533916891) == 306783378 && (i13 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function27 = function22;
                            chipBorder3 = chipBorder;
                            chipColors4 = chipColors2;
                            modifier4 = modifier2;
                            composer3 = composerStartRestartGroup;
                            function26 = function23;
                            chipElevation3 = chipElevation;
                            shape4 = shape2;
                            z4 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i17 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i6 == 0 ? true : z2;
                                Function2<? super Composer, ? super Integer, Unit> function28 = i7 == 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function29 = i8 == 0 ? null : function22;
                                if ((i4 & 64) != 0) {
                                    shape2 = AssistChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i5 &= -3670017;
                                }
                                int i19 = i5;
                                if ((i4 & 128) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i15 = i10;
                                    i16 = i12;
                                    i14 = i13;
                                    i19 &= -29360129;
                                    chipColorsM17000elevatedAssistChipColorsoq7We08 = AssistChipDefaults.INSTANCE.m17000elevatedAssistChipColorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, 255);
                                } else {
                                    i14 = i13;
                                    composer2 = composerStartRestartGroup;
                                    i15 = i10;
                                    i16 = i12;
                                    chipColorsM17000elevatedAssistChipColorsoq7We08 = chipColors2;
                                }
                                if ((i4 & 256) == 0) {
                                    composerStartRestartGroup = composer2;
                                    chipElevationM17001elevatedAssistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m17001elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                    i19 &= -234881025;
                                } else {
                                    composerStartRestartGroup = composer2;
                                    chipElevationM17001elevatedAssistChipElevationaqJV_2Y = chipElevation;
                                }
                                ChipBorder chipBorder4 = i15 == 0 ? null : chipBorder;
                                if (i16 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    shape3 = shape2;
                                    chipElevation2 = chipElevationM17001elevatedAssistChipElevationaqJV_2Y;
                                    chipBorder2 = chipBorder4;
                                    chipColors3 = chipColorsM17000elevatedAssistChipColorsoq7We08;
                                    z3 = z5;
                                    function25 = function29;
                                    i5 = i19;
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    function24 = function28;
                                } else {
                                    shape3 = shape2;
                                    chipElevation2 = chipElevationM17001elevatedAssistChipElevationaqJV_2Y;
                                    chipBorder2 = chipBorder4;
                                    chipColors3 = chipColorsM17000elevatedAssistChipColorsoq7We08;
                                    z3 = z5;
                                    function24 = function28;
                                    function25 = function29;
                                    i5 = i19;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 64) != 0) {
                                    i5 &= -3670017;
                                }
                                if ((i4 & 128) != 0) {
                                    i5 &= -29360129;
                                }
                                if ((i4 & 256) != 0) {
                                    i5 &= -234881025;
                                }
                                function25 = function22;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i14 = i13;
                                chipColors3 = chipColors2;
                                modifier3 = modifier2;
                                z3 = z2;
                                function24 = function23;
                                chipElevation2 = chipElevation;
                                shape3 = shape2;
                                chipBorder2 = chipBorder;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1295844802, i5, i14, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:176)");
                            }
                            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                            int i20 = (i5 >> 9) & 14;
                            long jM18535unboximpl = chipColors3.labelColor$material3_release(z3, composerStartRestartGroup, ((i5 >> 18) & 112) | i20).getValue().m18535unboximpl();
                            float fM17002getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m17002getHeightD9Ej5fM();
                            PaddingValues paddingValues = AssistChipPadding;
                            Modifier modifier5 = modifier3;
                            composerStartRestartGroup.startReplaceableGroup(-227039467);
                            State<BorderStroke> stateBorderStroke$material3_release = chipBorder2 != null ? null : chipBorder2.borderStroke$material3_release(z3, composerStartRestartGroup, i20 | ((i5 >> 24) & 112));
                            composerStartRestartGroup.endReplaceableGroup();
                            BorderStroke value = stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null;
                            int i21 = i5 << 6;
                            ChipBorder chipBorder5 = chipBorder2;
                            Composer composer4 = composerStartRestartGroup;
                            m17029ChipnkUnTEs(modifier5, onClick, z3, label, textStyleFromToken, jM18535unboximpl, function24, function25, shape3, chipColors3, chipElevation2, value, fM17002getHeightD9Ej5fM, paddingValues, mutableInteractionSource2, composer4, (i21 & 1879048192) | ((i5 >> 6) & 14) | ((i5 << 3) & 112) | ((i5 >> 3) & 896) | (i21 & 7168) | (i21 & 3670016) | (i21 & 29360128) | (i21 & 234881024), ((i5 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            z4 = z3;
                            function26 = function24;
                            function27 = function25;
                            shape4 = shape3;
                            chipColors4 = chipColors3;
                            chipElevation3 = chipElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            chipBorder3 = chipBorder5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedAssistChip.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer5, int i22) {
                                ChipKt.ElevatedAssistChip(onClick, label, modifier4, z4, function26, function27, shape4, chipColors4, chipElevation3, chipBorder3, mutableInteractionSource3, composer5, i | 1, i2, i4);
                            }
                        });
                        return;
                    }
                    i5 |= DriveFile.MODE_READ_WRITE;
                    i10 = i9;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i17 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if ((i4 & 64) != 0) {
                            }
                            int i192 = i5;
                            if ((i4 & 128) == 0) {
                            }
                            if ((i4 & 256) == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                            int i202 = (i5 >> 9) & 14;
                            long jM18535unboximpl2 = chipColors3.labelColor$material3_release(z3, composerStartRestartGroup, ((i5 >> 18) & 112) | i202).getValue().m18535unboximpl();
                            float fM17002getHeightD9Ej5fM2 = AssistChipDefaults.INSTANCE.m17002getHeightD9Ej5fM();
                            PaddingValues paddingValues2 = AssistChipPadding;
                            Modifier modifier52 = modifier3;
                            composerStartRestartGroup.startReplaceableGroup(-227039467);
                            if (chipBorder2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateBorderStroke$material3_release != null) {
                            }
                            int i212 = i5 << 6;
                            ChipBorder chipBorder52 = chipBorder2;
                            Composer composer42 = composerStartRestartGroup;
                            m17029ChipnkUnTEs(modifier52, onClick, z3, label, textStyleFromToken2, jM18535unboximpl2, function24, function25, shape3, chipColors3, chipElevation2, value, fM17002getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource2, composer42, (i212 & 1879048192) | ((i5 >> 6) & 14) | ((i5 << 3) & 112) | ((i5 >> 3) & 896) | (i212 & 7168) | (i212 & 3670016) | (i212 & 29360128) | (i212 & 234881024), ((i5 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            z4 = z3;
                            function26 = function24;
                            function27 = function25;
                            shape4 = shape3;
                            chipColors4 = chipColors3;
                            chipElevation3 = chipElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            chipBorder3 = chipBorder52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function23 = function2;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) != 0) {
                }
                if ((i & 234881024) == 0) {
                }
                i9 = i4 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i4 & 1024;
                if (i11 != 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            function23 = function2;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) != 0) {
            }
            if ((i & 234881024) == 0) {
            }
            i9 = i4 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 1024;
            if (i11 != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        function23 = function2;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if ((i & 234881024) == 0) {
        }
        i9 = i4 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 1024;
        if (i11 != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0398 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedFilterChip(final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, @Nullable SelectableChipColors selectableChipColors, @Nullable SelectableChipElevation selectableChipElevation, @Nullable SelectableChipBorder selectableChipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        SelectableChipElevation selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier3;
        Shape shape3;
        int i14;
        Composer composer2;
        int i15;
        int i16;
        SelectableChipColors selectableChipColorsM17168elevatedFilterChipColorsXqyqHi0;
        int i17;
        MutableInteractionSource mutableInteractionSource2;
        SelectableChipElevation selectableChipElevation2;
        SelectableChipBorder selectableChipBorder2;
        SelectableChipColors selectableChipColors3;
        boolean z4;
        Shape shape4;
        int i18;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        Composer composer3;
        final Modifier modifier4;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape5;
        final SelectableChipColors selectableChipColors4;
        final SelectableChipElevation selectableChipElevation3;
        final MutableInteractionSource mutableInteractionSource3;
        final SelectableChipBorder selectableChipBorder3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(1904578605);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(label) ? 256 : 128;
        }
        int i19 = i4 & 8;
        if (i19 != 0) {
            i5 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i6 = i4 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z2;
                    i5 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                } else if ((i & 458752) == 0) {
                    i5 |= composerStartRestartGroup.changed(function2) ? 131072 : 65536;
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                    i5 |= 1572864;
                    function23 = function22;
                } else {
                    function23 = function22;
                    if ((i & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(function23) ? 1048576 : 524288;
                    }
                }
                if ((i & 29360128) == 0) {
                    if ((i4 & 128) == 0) {
                        shape2 = shape;
                        int i20 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                        i5 |= i20;
                    } else {
                        shape2 = shape;
                    }
                    i5 |= i20;
                } else {
                    shape2 = shape;
                }
                if ((i & 234881024) == 0) {
                    if ((i4 & 256) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        int i21 = composerStartRestartGroup.changed(selectableChipColors2) ? 67108864 : 33554432;
                        i5 |= i21;
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i5 |= i21;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 1879048192) == 0) {
                    if ((i4 & 512) == 0) {
                        selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y = selectableChipElevation;
                        int i22 = composerStartRestartGroup.changed(selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y) ? 536870912 : 268435456;
                        i5 |= i22;
                    } else {
                        selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y = selectableChipElevation;
                    }
                    i5 |= i22;
                } else {
                    selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y = selectableChipElevation;
                }
                i9 = i4 & 1024;
                if (i9 != 0) {
                    i11 = i2 | 6;
                    i10 = i9;
                } else if ((i2 & 14) == 0) {
                    i10 = i9;
                    i11 = i2 | (composerStartRestartGroup.changed(selectableChipBorder) ? 4 : 2);
                } else {
                    i10 = i9;
                    i11 = i2;
                }
                i12 = i4 & 2048;
                if (i12 != 0) {
                    i11 |= 48;
                    i13 = i12;
                } else if ((i2 & 112) == 0) {
                    i13 = i12;
                    i11 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
                } else {
                    i13 = i12;
                }
                int i23 = i11;
                if ((i5 & 1533916891) == 306783378 && (i23 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function24 = function2;
                    function25 = function23;
                    shape5 = shape2;
                    selectableChipColors4 = selectableChipColors2;
                    modifier4 = modifier2;
                    composer3 = composerStartRestartGroup;
                    selectableChipBorder3 = selectableChipBorder;
                    mutableInteractionSource3 = mutableInteractionSource;
                    selectableChipElevation3 = selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y;
                    z5 = z3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i19 == 0 ? Modifier.INSTANCE : modifier2;
                        boolean z6 = i6 == 0 ? true : z3;
                        Function2<? super Composer, ? super Integer, Unit> function26 = i7 == 0 ? null : function2;
                        Function2<? super Composer, ? super Integer, Unit> function27 = i8 == 0 ? null : function23;
                        if ((i4 & 128) == 0) {
                            i5 &= -29360129;
                            shape3 = FilterChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            shape3 = shape2;
                        }
                        int i24 = i5;
                        if ((i4 & 256) == 0) {
                            i16 = i13;
                            i15 = i10;
                            i14 = i23;
                            composer2 = composerStartRestartGroup;
                            i24 &= -234881025;
                            selectableChipColorsM17168elevatedFilterChipColorsXqyqHi0 = FilterChipDefaults.INSTANCE.m17168elevatedFilterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 384, 4095);
                        } else {
                            i14 = i23;
                            composer2 = composerStartRestartGroup;
                            i15 = i10;
                            i16 = i13;
                            selectableChipColorsM17168elevatedFilterChipColorsXqyqHi0 = selectableChipColors2;
                        }
                        if ((i4 & 512) == 0) {
                            composerStartRestartGroup = composer2;
                            selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y = FilterChipDefaults.INSTANCE.m17169elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i17 = i24 & (-1879048193);
                        } else {
                            composerStartRestartGroup = composer2;
                            i17 = i24;
                        }
                        SelectableChipBorder selectableChipBorder4 = i15 == 0 ? null : selectableChipBorder;
                        if (i16 == 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            selectableChipElevation2 = selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y;
                            selectableChipBorder2 = selectableChipBorder4;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            selectableChipElevation2 = selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y;
                            selectableChipBorder2 = selectableChipBorder4;
                        }
                        selectableChipColors3 = selectableChipColorsM17168elevatedFilterChipColorsXqyqHi0;
                        z4 = z6;
                        function23 = function27;
                        shape4 = shape3;
                        i18 = i17;
                        function24 = function26;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i4 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        if ((i4 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        if ((i4 & 512) != 0) {
                            i5 &= -1879048193;
                        }
                        i14 = i23;
                        shape4 = shape2;
                        selectableChipColors3 = selectableChipColors2;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource2 = mutableInteractionSource;
                        selectableChipElevation2 = selectableChipElevationM17169elevatedFilterChipElevationaqJV_2Y;
                        i18 = i5;
                        function24 = function2;
                        selectableChipBorder2 = selectableChipBorder;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904578605, i18, i14, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:337)");
                    }
                    TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
                    float fM17173getHeightD9Ej5fM = FilterChipDefaults.INSTANCE.m17173getHeightD9Ej5fM();
                    PaddingValues paddingValues = FilterChipPadding;
                    Modifier modifier5 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(-790769726);
                    State<BorderStroke> stateBorderStroke$material3_release = selectableChipBorder2 != null ? null : selectableChipBorder2.borderStroke$material3_release(z4, z, composerStartRestartGroup, ((i18 >> 12) & 14) | ((i18 << 3) & 112) | ((i14 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    int i25 = i18 << 3;
                    BorderStroke value = stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null;
                    int i26 = i18 << 6;
                    int i27 = ((i18 >> 3) & 7168) | (i18 & 14) | 12582912 | ((i18 >> 6) & 112) | (i25 & 896) | (i26 & 57344) | (i25 & 3670016) | (i26 & 234881024) | (i26 & 1879048192);
                    int i28 = i18 >> 24;
                    composer3 = composerStartRestartGroup;
                    SelectableChipBorder selectableChipBorder5 = selectableChipBorder2;
                    m17031SelectableChipu0RnIRE(z, modifier5, onClick, z4, label, textStyleFromToken, function24, null, function23, shape4, selectableChipColors3, selectableChipElevation2, value, fM17173getHeightD9Ej5fM, paddingValues, mutableInteractionSource2, composer3, i27, (i28 & 112) | (i28 & 14) | 27648 | ((i14 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier5;
                    z5 = z4;
                    function25 = function23;
                    shape5 = shape4;
                    selectableChipColors4 = selectableChipColors3;
                    selectableChipElevation3 = selectableChipElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    selectableChipBorder3 = selectableChipBorder5;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedFilterChip.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer4, int i29) {
                        ChipKt.ElevatedFilterChip(z, onClick, label, modifier4, z5, function24, function25, shape5, selectableChipColors4, selectableChipElevation3, selectableChipBorder3, mutableInteractionSource3, composer4, i | 1, i2, i4);
                    }
                });
                return;
            }
            i5 |= 24576;
            z3 = z2;
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            i9 = i4 & 1024;
            if (i9 != 0) {
            }
            i12 = i4 & 2048;
            if (i12 != 0) {
            }
            int i232 = i11;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i4 & 128) == 0) {
                    }
                    int i242 = i5;
                    if ((i4 & 256) == 0) {
                    }
                    if ((i4 & 512) == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    selectableChipColors3 = selectableChipColorsM17168elevatedFilterChipColorsXqyqHi0;
                    z4 = z6;
                    function23 = function27;
                    shape4 = shape3;
                    i18 = i17;
                    function24 = function26;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
                    float fM17173getHeightD9Ej5fM2 = FilterChipDefaults.INSTANCE.m17173getHeightD9Ej5fM();
                    PaddingValues paddingValues2 = FilterChipPadding;
                    Modifier modifier52 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(-790769726);
                    if (selectableChipBorder2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i252 = i18 << 3;
                    BorderStroke value2 = stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null;
                    int i262 = i18 << 6;
                    int i272 = ((i18 >> 3) & 7168) | (i18 & 14) | 12582912 | ((i18 >> 6) & 112) | (i252 & 896) | (i262 & 57344) | (i252 & 3670016) | (i262 & 234881024) | (i262 & 1879048192);
                    int i282 = i18 >> 24;
                    composer3 = composerStartRestartGroup;
                    SelectableChipBorder selectableChipBorder52 = selectableChipBorder2;
                    m17031SelectableChipu0RnIRE(z, modifier52, onClick, z4, label, textStyleFromToken2, function24, null, function23, shape4, selectableChipColors3, selectableChipElevation2, value2, fM17173getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource2, composer3, i272, (i282 & 112) | (i282 & 14) | 27648 | ((i14 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier52;
                    z5 = z4;
                    function25 = function23;
                    shape5 = shape4;
                    selectableChipColors4 = selectableChipColors3;
                    selectableChipElevation3 = selectableChipElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    selectableChipBorder3 = selectableChipBorder52;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 16;
        if (i6 != 0) {
        }
        z3 = z2;
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        i9 = i4 & 1024;
        if (i9 != 0) {
        }
        i12 = i4 & 2048;
        if (i12 != 0) {
        }
        int i2322 = i11;
        if ((i5 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0311 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedSuggestionChip(@NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Shape shape, @Nullable ChipColors chipColors, @Nullable ChipElevation chipElevation, @Nullable ChipBorder chipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Shape shape2;
        ChipColors chipColors2;
        ChipElevation chipElevation2;
        int i7;
        int i8;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Shape shape3;
        Composer composer2;
        int i11;
        ChipColors chipColorsM17318elevatedSuggestionChipColors5tl4gsc;
        ChipElevation chipElevationM17319elevatedSuggestionChipElevationaqJV_2Y;
        int i12;
        ChipBorder chipBorder2;
        ChipElevation chipElevation3;
        ChipColors chipColors3;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape4;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        final Modifier modifier4;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape5;
        final ChipColors chipColors4;
        final ChipElevation chipElevation4;
        final MutableInteractionSource mutableInteractionSource4;
        final ChipBorder chipBorder3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(1668751803);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 57344) == 0) {
                        function22 = function2;
                        i4 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i14 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i4 |= i14;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            int i15 = composerStartRestartGroup.changed(chipColors2) ? 1048576 : 524288;
                            i4 |= i15;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i4 |= i15;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((29360128 & i) != 0) {
                        if ((i2 & 128) == 0) {
                            chipElevation2 = chipElevation;
                            int i16 = composerStartRestartGroup.changed(chipElevation2) ? 8388608 : 4194304;
                            i4 |= i16;
                        } else {
                            chipElevation2 = chipElevation;
                        }
                        i4 |= i16;
                    } else {
                        chipElevation2 = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i4 |= 100663296;
                        i8 = i13;
                    } else {
                        i8 = i13;
                        if ((i & 234881024) == 0) {
                            i4 |= composerStartRestartGroup.changed(chipBorder) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i2 & 512;
                    if (i9 != 0) {
                        if ((i & 1879048192) == 0) {
                            i10 = i9;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        }
                        if ((i4 & 1533916891) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            mutableInteractionSource4 = mutableInteractionSource2;
                            modifier4 = modifier2;
                            z4 = z2;
                            function24 = function22;
                            composer3 = composerStartRestartGroup;
                            shape5 = shape2;
                            chipColors4 = chipColors2;
                            chipElevation4 = chipElevation2;
                            chipBorder3 = chipBorder;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i5 == 0 ? true : z2;
                                Function2<? super Composer, ? super Integer, Unit> function25 = i6 == 0 ? null : function22;
                                if ((i2 & 32) == 0) {
                                    i4 &= -458753;
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                int i17 = i4;
                                if ((i2 & 64) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    i11 = i10;
                                    i17 &= -3670017;
                                    chipColorsM17318elevatedSuggestionChipColors5tl4gsc = SuggestionChipDefaults.INSTANCE.m17318elevatedSuggestionChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composer2, 1572864, 63);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i11 = i10;
                                    chipColorsM17318elevatedSuggestionChipColors5tl4gsc = chipColors2;
                                }
                                if ((i2 & 128) == 0) {
                                    composerStartRestartGroup = composer2;
                                    chipElevationM17319elevatedSuggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m17319elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                    i12 = i17 & (-29360129);
                                } else {
                                    composerStartRestartGroup = composer2;
                                    chipElevationM17319elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                                    i12 = i17;
                                }
                                chipBorder2 = i7 == 0 ? null : chipBorder;
                                if (i11 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    chipElevation3 = chipElevationM17319elevatedSuggestionChipElevationaqJV_2Y;
                                    i4 = i12;
                                    chipColors3 = chipColorsM17318elevatedSuggestionChipColors5tl4gsc;
                                    z3 = z5;
                                    shape4 = shape3;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    function23 = function25;
                                } else {
                                    chipElevation3 = chipElevationM17319elevatedSuggestionChipElevationaqJV_2Y;
                                    i4 = i12;
                                    chipColors3 = chipColorsM17318elevatedSuggestionChipColors5tl4gsc;
                                    z3 = z5;
                                    function23 = function25;
                                    shape4 = shape3;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                chipBorder2 = chipBorder;
                                modifier3 = modifier2;
                                z3 = z2;
                                function23 = function22;
                                shape4 = shape2;
                                chipColors3 = chipColors2;
                                chipElevation3 = chipElevation2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1668751803, i4, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:589)");
                            }
                            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                            int i18 = (i4 >> 9) & 14;
                            int i19 = i4 >> 15;
                            long jM18535unboximpl = chipColors3.labelColor$material3_release(z3, composerStartRestartGroup, (i19 & 112) | i18).getValue().m18535unboximpl();
                            float fM17320getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m17320getHeightD9Ej5fM();
                            int i20 = i4;
                            PaddingValues paddingValues = SuggestionChipPadding;
                            Modifier modifier5 = modifier3;
                            composerStartRestartGroup.startReplaceableGroup(-1455593643);
                            State<BorderStroke> stateBorderStroke$material3_release = chipBorder2 != null ? null : chipBorder2.borderStroke$material3_release(z3, composerStartRestartGroup, i18 | ((i20 >> 21) & 112));
                            composerStartRestartGroup.endReplaceableGroup();
                            BorderStroke value = stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null;
                            int i21 = i20 << 6;
                            int i22 = i20 << 9;
                            ChipBorder chipBorder4 = chipBorder2;
                            Composer composer4 = composerStartRestartGroup;
                            m17029ChipnkUnTEs(modifier5, onClick, z3, label, textStyleFromToken, jM18535unboximpl, function23, null, shape4, chipColors3, chipElevation3, value, fM17320getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, composer4, (i21 & 3670016) | ((i20 >> 6) & 14) | 12582912 | ((i20 << 3) & 112) | ((i20 >> 3) & 896) | (i21 & 7168) | (i22 & 234881024) | (i22 & 1879048192), ((i20 >> 21) & 14) | 3456 | (i19 & 57344));
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            z4 = z3;
                            function24 = function23;
                            shape5 = shape4;
                            chipColors4 = chipColors3;
                            chipElevation4 = chipElevation3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            chipBorder3 = chipBorder4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedSuggestionChip.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer5, int i23) {
                                ChipKt.ElevatedSuggestionChip(onClick, label, modifier4, z4, function24, shape5, chipColors4, chipElevation4, chipBorder3, mutableInteractionSource4, composer5, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= DriveFile.MODE_READ_WRITE;
                    i10 = i9;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            int i172 = i4;
                            if ((i2 & 64) == 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                            int i182 = (i4 >> 9) & 14;
                            int i192 = i4 >> 15;
                            long jM18535unboximpl2 = chipColors3.labelColor$material3_release(z3, composerStartRestartGroup, (i192 & 112) | i182).getValue().m18535unboximpl();
                            float fM17320getHeightD9Ej5fM2 = SuggestionChipDefaults.INSTANCE.m17320getHeightD9Ej5fM();
                            int i202 = i4;
                            PaddingValues paddingValues2 = SuggestionChipPadding;
                            Modifier modifier52 = modifier3;
                            composerStartRestartGroup.startReplaceableGroup(-1455593643);
                            if (chipBorder2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateBorderStroke$material3_release != null) {
                            }
                            int i212 = i202 << 6;
                            int i222 = i202 << 9;
                            ChipBorder chipBorder42 = chipBorder2;
                            Composer composer42 = composerStartRestartGroup;
                            m17029ChipnkUnTEs(modifier52, onClick, z3, label, textStyleFromToken2, jM18535unboximpl2, function23, null, shape4, chipColors3, chipElevation3, value, fM17320getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource3, composer42, (i212 & 3670016) | ((i202 >> 6) & 14) | 12582912 | ((i202 << 3) & 112) | ((i202 >> 3) & 896) | (i212 & 7168) | (i222 & 234881024) | (i222 & 1879048192), ((i202 >> 21) & 14) | 3456 | (i192 & 57344));
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            z4 = z3;
                            function24 = function23;
                            shape5 = shape4;
                            chipColors4 = chipColors3;
                            chipElevation4 = chipElevation3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            chipBorder3 = chipBorder42;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function22 = function2;
                if ((458752 & i) != 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((29360128 & i) != 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i9 = i2 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i4 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            function22 = function2;
            if ((458752 & i) != 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((29360128 & i) != 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i9 = i2 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i4 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        function22 = function2;
        if ((458752 & i) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((29360128 & i) != 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i9 = i2 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i4 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Shape shape, @Nullable SelectableChipColors selectableChipColors, @Nullable SelectableChipElevation selectableChipElevation, @Nullable SelectableChipBorder selectableChipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        SelectableChipElevation selectableChipElevationM17172filterChipElevationaqJV_2Y;
        int i9;
        int i10;
        int i11;
        MutableInteractionSource mutableInteractionSource2;
        int i12;
        Modifier modifier3;
        Shape shape3;
        Composer composer2;
        int i13;
        SelectableChipColors selectableChipColorsM17171filterChipColorsXqyqHi0;
        SelectableChipBorder selectableChipBorderM17170filterChipBordergHcDVlo;
        MutableInteractionSource mutableInteractionSource3;
        SelectableChipElevation selectableChipElevation2;
        SelectableChipBorder selectableChipBorder2;
        SelectableChipColors selectableChipColors3;
        int i14;
        boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape4;
        int i15;
        Composer composer3;
        final Modifier modifier4;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape5;
        final SelectableChipColors selectableChipColors4;
        final SelectableChipElevation selectableChipElevation3;
        final MutableInteractionSource mutableInteractionSource4;
        final SelectableChipBorder selectableChipBorder3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1878072905);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(label) ? 256 : 128;
        }
        int i16 = i4 & 8;
        if (i16 != 0) {
            i5 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i6 = i4 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z2;
                    i5 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                } else if ((i & 458752) == 0) {
                    i5 |= composerStartRestartGroup.changed(function2) ? 131072 : 65536;
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                    i5 |= 1572864;
                    function23 = function22;
                } else {
                    function23 = function22;
                    if ((i & 3670016) == 0) {
                        i5 |= composerStartRestartGroup.changed(function23) ? 1048576 : 524288;
                    }
                }
                if ((i & 29360128) == 0) {
                    if ((i4 & 128) == 0) {
                        shape2 = shape;
                        int i17 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                        i5 |= i17;
                    } else {
                        shape2 = shape;
                    }
                    i5 |= i17;
                } else {
                    shape2 = shape;
                }
                if ((i & 234881024) == 0) {
                    if ((i4 & 256) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        int i18 = composerStartRestartGroup.changed(selectableChipColors2) ? 67108864 : 33554432;
                        i5 |= i18;
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i5 |= i18;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 1879048192) == 0) {
                    if ((i4 & 512) == 0) {
                        selectableChipElevationM17172filterChipElevationaqJV_2Y = selectableChipElevation;
                        int i19 = composerStartRestartGroup.changed(selectableChipElevationM17172filterChipElevationaqJV_2Y) ? 536870912 : 268435456;
                        i5 |= i19;
                    } else {
                        selectableChipElevationM17172filterChipElevationaqJV_2Y = selectableChipElevation;
                    }
                    i5 |= i19;
                } else {
                    selectableChipElevationM17172filterChipElevationaqJV_2Y = selectableChipElevation;
                }
                if ((i2 & 14) == 0) {
                    i9 = i2 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(selectableChipBorder)) ? 4 : 2);
                } else {
                    i9 = i2;
                }
                i10 = i4 & 2048;
                if (i10 != 0) {
                    i11 = i10;
                    i12 = i9 | 48;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i2 & 112) == 0) {
                        i11 = i10;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i9 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 32 : 16;
                    } else {
                        i11 = i10;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i12 = i9;
                }
                if ((i5 & 1533916891) == 306783378 && (i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function24 = function2;
                    selectableChipColors4 = selectableChipColors2;
                    modifier4 = modifier2;
                    composer3 = composerStartRestartGroup;
                    selectableChipBorder3 = selectableChipBorder;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    function25 = function23;
                    shape5 = shape2;
                    selectableChipElevation3 = selectableChipElevationM17172filterChipElevationaqJV_2Y;
                    z5 = z3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i16 == 0 ? Modifier.INSTANCE : modifier2;
                        boolean z6 = i6 == 0 ? true : z3;
                        Function2<? super Composer, ? super Integer, Unit> function26 = i7 == 0 ? null : function2;
                        Function2<? super Composer, ? super Integer, Unit> function27 = i8 == 0 ? null : function23;
                        if ((i4 & 128) == 0) {
                            i5 &= -29360129;
                            shape3 = FilterChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            shape3 = shape2;
                        }
                        int i20 = i5;
                        if ((i4 & 256) == 0) {
                            i13 = i11;
                            composer2 = composerStartRestartGroup;
                            i20 &= -234881025;
                            selectableChipColorsM17171filterChipColorsXqyqHi0 = FilterChipDefaults.INSTANCE.m17171filterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 384, 4095);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i13 = i11;
                            selectableChipColorsM17171filterChipColorsXqyqHi0 = selectableChipColors2;
                        }
                        if ((i4 & 512) != 0) {
                            selectableChipElevationM17172filterChipElevationaqJV_2Y = FilterChipDefaults.INSTANCE.m17172filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                            i20 &= -1879048193;
                        }
                        if ((i4 & 1024) == 0) {
                            Composer composer4 = composer2;
                            selectableChipBorderM17170filterChipBordergHcDVlo = FilterChipDefaults.INSTANCE.m17170filterChipBordergHcDVlo(0L, 0L, 0L, 0L, 0.0f, 0.0f, composer4, 1572864, 63);
                            composerStartRestartGroup = composer4;
                            i12 &= -15;
                        } else {
                            composerStartRestartGroup = composer2;
                            selectableChipBorderM17170filterChipBordergHcDVlo = selectableChipBorder;
                        }
                        if (i13 == 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            selectableChipElevation2 = selectableChipElevationM17172filterChipElevationaqJV_2Y;
                            selectableChipBorder2 = selectableChipBorderM17170filterChipBordergHcDVlo;
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            selectableChipElevation2 = selectableChipElevationM17172filterChipElevationaqJV_2Y;
                            selectableChipBorder2 = selectableChipBorderM17170filterChipBordergHcDVlo;
                        }
                        selectableChipColors3 = selectableChipColorsM17171filterChipColorsXqyqHi0;
                        i14 = i12;
                        z4 = z6;
                        function24 = function26;
                        function23 = function27;
                        shape4 = shape3;
                        i15 = i20;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i4 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        if ((i4 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        if ((i4 & 512) != 0) {
                            i5 &= -1879048193;
                        }
                        if ((i4 & 1024) != 0) {
                            i12 &= -15;
                        }
                        shape4 = shape2;
                        selectableChipColors3 = selectableChipColors2;
                        modifier3 = modifier2;
                        z4 = z3;
                        i14 = i12;
                        selectableChipElevation2 = selectableChipElevationM17172filterChipElevationaqJV_2Y;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        selectableChipBorder2 = selectableChipBorder;
                        i15 = i5;
                        function24 = function2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1878072905, i15, i14, "androidx.compose.material3.FilterChip (Chip.kt:257)");
                    }
                    TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
                    float fM17173getHeightD9Ej5fM = FilterChipDefaults.INSTANCE.m17173getHeightD9Ej5fM();
                    PaddingValues paddingValues = FilterChipPadding;
                    Modifier modifier5 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(276171483);
                    State<BorderStroke> stateBorderStroke$material3_release = selectableChipBorder2 != null ? null : selectableChipBorder2.borderStroke$material3_release(z4, z, composerStartRestartGroup, ((i15 >> 12) & 14) | ((i15 << 3) & 112) | ((i14 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    int i21 = i15 << 3;
                    BorderStroke value = stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null;
                    int i22 = i15 << 6;
                    int i23 = ((i15 >> 3) & 7168) | (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i21 & 896) | (i22 & 57344) | (i21 & 3670016) | (i22 & 234881024) | (i22 & 1879048192);
                    int i24 = i15 >> 24;
                    composer3 = composerStartRestartGroup;
                    SelectableChipBorder selectableChipBorder4 = selectableChipBorder2;
                    m17031SelectableChipu0RnIRE(z, modifier5, onClick, z4, label, textStyleFromToken, function24, null, function23, shape4, selectableChipColors3, selectableChipElevation2, value, fM17173getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, composer3, i23, (i24 & 112) | (i24 & 14) | 27648 | ((i14 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier5;
                    z5 = z4;
                    function25 = function23;
                    shape5 = shape4;
                    selectableChipColors4 = selectableChipColors3;
                    selectableChipElevation3 = selectableChipElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    selectableChipBorder3 = selectableChipBorder4;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.FilterChip.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                        invoke(composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer5, int i25) {
                        ChipKt.FilterChip(z, onClick, label, modifier4, z5, function24, function25, shape5, selectableChipColors4, selectableChipElevation3, selectableChipBorder3, mutableInteractionSource4, composer5, i | 1, i2, i4);
                    }
                });
                return;
            }
            i5 |= 24576;
            z3 = z2;
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            if ((i2 & 14) == 0) {
            }
            i10 = i4 & 2048;
            if (i10 != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i4 & 128) == 0) {
                    }
                    int i202 = i5;
                    if ((i4 & 256) == 0) {
                    }
                    if ((i4 & 512) != 0) {
                    }
                    if ((i4 & 1024) == 0) {
                    }
                    if (i13 == 0) {
                    }
                    selectableChipColors3 = selectableChipColorsM17171filterChipColorsXqyqHi0;
                    i14 = i12;
                    z4 = z6;
                    function24 = function26;
                    function23 = function27;
                    shape4 = shape3;
                    i15 = i202;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont());
                    float fM17173getHeightD9Ej5fM2 = FilterChipDefaults.INSTANCE.m17173getHeightD9Ej5fM();
                    PaddingValues paddingValues2 = FilterChipPadding;
                    Modifier modifier52 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(276171483);
                    if (selectableChipBorder2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i212 = i15 << 3;
                    BorderStroke value2 = stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null;
                    int i222 = i15 << 6;
                    int i232 = ((i15 >> 3) & 7168) | (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i212 & 896) | (i222 & 57344) | (i212 & 3670016) | (i222 & 234881024) | (i222 & 1879048192);
                    int i242 = i15 >> 24;
                    composer3 = composerStartRestartGroup;
                    SelectableChipBorder selectableChipBorder42 = selectableChipBorder2;
                    m17031SelectableChipu0RnIRE(z, modifier52, onClick, z4, label, textStyleFromToken2, function24, null, function23, shape4, selectableChipColors3, selectableChipElevation2, value2, fM17173getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource3, composer3, i232, (i242 & 112) | (i242 & 14) | 27648 | ((i14 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier52;
                    z5 = z4;
                    function25 = function23;
                    shape5 = shape4;
                    selectableChipColors4 = selectableChipColors3;
                    selectableChipElevation3 = selectableChipElevation2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    selectableChipBorder3 = selectableChipBorder42;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 16;
        if (i6 != 0) {
        }
        z3 = z2;
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        if ((i2 & 14) == 0) {
        }
        i10 = i4 & 2048;
        if (i10 != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0444 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputChip(final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Shape shape, @Nullable SelectableChipColors selectableChipColors, @Nullable SelectableChipElevation selectableChipElevation, @Nullable SelectableChipBorder selectableChipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape2;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        Composer composer2;
        int i14;
        int i15;
        SelectableChipColors selectableChipColorsM17204inputChipColorskwJvTHA;
        SelectableChipElevation selectableChipElevationM17205inputChipElevationaqJV_2Y;
        SelectableChipBorder selectableChipBorderM17203inputChipBordergHcDVlo;
        int i16;
        MutableInteractionSource mutableInteractionSource2;
        final Shape shape3;
        SelectableChipBorder selectableChipBorder2;
        int i17;
        final SelectableChipColors selectableChipColors2;
        final SelectableChipElevation selectableChipElevation2;
        boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final int i18;
        ComposableLambda composableLambda;
        ComposableLambda composableLambda2;
        State<BorderStroke> stateBorderStroke$material3_release;
        Composer composer3;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final SelectableChipBorder selectableChipBorder3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1599030387);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(label) ? 256 : 128;
        }
        int i19 = i4 & 8;
        if (i19 == 0) {
            if ((i & 7168) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
            }
            i6 = i4 & 16;
            if (i6 == 0) {
                i5 |= 24576;
                z3 = z2;
            } else {
                z3 = z2;
                if ((i & 57344) == 0) {
                    i5 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                }
            }
            i7 = i4 & 32;
            if (i7 == 0) {
                i5 |= 196608;
                function24 = function2;
            } else {
                function24 = function2;
                if ((i & 458752) == 0) {
                    i5 |= composerStartRestartGroup.changed(function24) ? 131072 : 65536;
                }
            }
            i8 = i4 & 64;
            if (i8 == 0) {
                i5 |= 1572864;
                function25 = function22;
            } else {
                function25 = function22;
                if ((i & 3670016) == 0) {
                    i5 |= composerStartRestartGroup.changed(function25) ? 1048576 : 524288;
                }
            }
            i9 = i4 & 128;
            if (i9 == 0) {
                i5 |= 12582912;
                function26 = function23;
            } else {
                function26 = function23;
                if ((i & 29360128) == 0) {
                    i5 |= composerStartRestartGroup.changed(function26) ? 8388608 : 4194304;
                }
            }
            if ((i & 234881024) != 0) {
                if ((i4 & 256) == 0) {
                    shape2 = shape;
                    int i20 = composerStartRestartGroup.changed(shape2) ? 67108864 : 33554432;
                    i5 |= i20;
                } else {
                    shape2 = shape;
                }
                i5 |= i20;
            } else {
                shape2 = shape;
            }
            if ((i & 1879048192) == 0) {
                i5 |= ((i4 & 512) == 0 && composerStartRestartGroup.changed(selectableChipColors)) ? 536870912 : 268435456;
            }
            if ((i2 & 14) != 0) {
                i10 = i2 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(selectableChipElevation)) ? 4 : 2);
            } else {
                i10 = i2;
            }
            if ((i2 & 112) == 0) {
                i10 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(selectableChipBorder)) ? 32 : 16;
            }
            int i21 = i10;
            i11 = i4 & 4096;
            if (i11 == 0) {
                i12 = i11;
                i13 = i21 | 384;
            } else {
                int i22 = i21;
                if ((i2 & 896) == 0) {
                    i22 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                }
                i12 = i11;
                i13 = i22;
            }
            if ((i5 & 1533916891) != 306783378 && (i13 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier;
                selectableChipColors2 = selectableChipColors;
                mutableInteractionSource3 = mutableInteractionSource;
                z5 = z3;
                function210 = function25;
                composer3 = composerStartRestartGroup;
                function29 = function26;
                selectableChipBorder3 = selectableChipBorder;
                shape3 = shape2;
                function27 = function24;
                selectableChipElevation2 = selectableChipElevation;
            } else {
                composerStartRestartGroup.startDefaults();
                int i23 = i13;
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    modifier2 = i19 == 0 ? Modifier.INSTANCE : modifier;
                    boolean z6 = i6 == 0 ? true : z3;
                    Function2<? super Composer, ? super Integer, Unit> function211 = i7 == 0 ? null : function24;
                    Function2<? super Composer, ? super Integer, Unit> function212 = i8 == 0 ? null : function25;
                    Function2<? super Composer, ? super Integer, Unit> function213 = i9 == 0 ? null : function26;
                    if ((i4 & 256) != 0) {
                        shape2 = InputChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i5 &= -234881025;
                    }
                    int i24 = i5;
                    if ((i4 & 512) == 0) {
                        i14 = i23;
                        i15 = i12;
                        composer2 = composerStartRestartGroup;
                        selectableChipColorsM17204inputChipColorskwJvTHA = InputChipDefaults.INSTANCE.m17204inputChipColorskwJvTHA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 3072, 8191);
                        i24 &= -1879048193;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i14 = i23;
                        i15 = i12;
                        selectableChipColorsM17204inputChipColorskwJvTHA = selectableChipColors;
                    }
                    if ((i4 & 1024) == 0) {
                        Composer composer4 = composer2;
                        composer2 = composer4;
                        selectableChipElevationM17205inputChipElevationaqJV_2Y = InputChipDefaults.INSTANCE.m17205inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer4, 1572864, 63);
                        i14 &= -15;
                    } else {
                        selectableChipElevationM17205inputChipElevationaqJV_2Y = selectableChipElevation;
                    }
                    if ((i4 & 2048) == 0) {
                        Composer composer5 = composer2;
                        selectableChipBorderM17203inputChipBordergHcDVlo = InputChipDefaults.INSTANCE.m17203inputChipBordergHcDVlo(0L, 0L, 0L, 0L, 0.0f, 0.0f, composer5, 1572864, 63);
                        composerStartRestartGroup = composer5;
                        i16 = i14 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    } else {
                        composerStartRestartGroup = composer2;
                        selectableChipBorderM17203inputChipBordergHcDVlo = selectableChipBorder;
                        i16 = i14;
                    }
                    if (i15 == 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        selectableChipBorder2 = selectableChipBorderM17203inputChipBordergHcDVlo;
                        i17 = i16;
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        selectableChipColors2 = selectableChipColorsM17204inputChipColorskwJvTHA;
                        selectableChipElevation2 = selectableChipElevationM17205inputChipElevationaqJV_2Y;
                        z4 = z6;
                        function28 = function212;
                        function29 = function213;
                        i18 = i24;
                        shape3 = shape2;
                        function27 = function211;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        shape3 = shape2;
                        selectableChipBorder2 = selectableChipBorderM17203inputChipBordergHcDVlo;
                        i17 = i16;
                        selectableChipColors2 = selectableChipColorsM17204inputChipColorskwJvTHA;
                        selectableChipElevation2 = selectableChipElevationM17205inputChipElevationaqJV_2Y;
                        z4 = z6;
                        function27 = function211;
                        function28 = function212;
                        function29 = function213;
                        i18 = i24;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i4 & 256) != 0) {
                        i5 &= -234881025;
                    }
                    if ((i4 & 512) != 0) {
                        i5 &= -1879048193;
                    }
                    int i25 = (i4 & 1024) != 0 ? i23 & (-15) : i23;
                    if ((i4 & 2048) != 0) {
                        i25 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    }
                    selectableChipColors2 = selectableChipColors;
                    i17 = i25;
                    i18 = i5;
                    z4 = z3;
                    function28 = function25;
                    function29 = function26;
                    modifier2 = modifier;
                    selectableChipBorder2 = selectableChipBorder;
                    mutableInteractionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    function27 = function24;
                    selectableChipElevation2 = selectableChipElevation;
                }
                composerStartRestartGroup.endDefaults();
                Modifier modifier4 = modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1599030387, i18, i17, "androidx.compose.material3.InputChip (Chip.kt:421)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1372002035);
                if (function28 == null) {
                    final float f = z4 ? 1.0f : 0.38f;
                    final Shape shape4 = ShapesKt.toShape(InputChipTokens.INSTANCE.getAvatarShape(), composerStartRestartGroup, 6);
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -352359235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.InputChip.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                            invoke(composer6, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer6, int i26) {
                            if ((i26 & 11) == 2 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-352359235, i26, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:442)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Object objValueOf = Float.valueOf(f);
                            final Shape shape5 = shape4;
                            final float f4 = f;
                            composer6.startReplaceableGroup(511388516);
                            boolean zChanged = composer6.changed(objValueOf) | composer6.changed(shape5);
                            Object objRememberedValue2 = composer6.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                        invoke2(graphicsLayerScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
                                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                                        graphicsLayer.setAlpha(f4);
                                        graphicsLayer.setShape(shape5);
                                        graphicsLayer.setClip(true);
                                    }
                                };
                                composer6.updateRememberedValue(objRememberedValue2);
                            }
                            composer6.endReplaceableGroup();
                            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue2);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function214 = function28;
                            int i27 = i18;
                            composer6.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer6, 6);
                            Density density = (Density) AbstractC1038a.m1211l(composer6, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierGraphicsLayer);
                            if (composer6.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer6.startReusableNode();
                            if (composer6.getInserting()) {
                                composer6.createNode(constructor);
                            } else {
                                composer6.useNode();
                            }
                            composer6.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer6);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer6, composer6), composer6, 2058660585);
                            composer6.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer6.startReplaceableGroup(1586835523);
                            if (AbstractC1038a.m1199D(composer6, (i27 >> 18) & 14, function214)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), InputChipTokens.INSTANCE.getLabelTextFont());
                if (selectableChipBorder2 != null) {
                    composableLambda2 = composableLambda;
                    stateBorderStroke$material3_release = null;
                } else {
                    composableLambda2 = composableLambda;
                    stateBorderStroke$material3_release = selectableChipBorder2.borderStroke$material3_release(z4, z, composerStartRestartGroup, ((i17 << 3) & 896) | ((i18 >> 12) & 14) | ((i18 << 3) & 112));
                }
                int i26 = i18;
                int i27 = i26 << 3;
                Function2<? super Composer, ? super Integer, Unit> function214 = function28;
                SelectableChipBorder selectableChipBorder4 = selectableChipBorder2;
                composer3 = composerStartRestartGroup;
                m17031SelectableChipu0RnIRE(z, modifier4, onClick, z4, label, textStyleFromToken, function27, composableLambda2, function29, shape3, selectableChipColors2, selectableChipElevation2, stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null, InputChipDefaults.INSTANCE.m17201getHeightD9Ej5fM(), inputChipPadding(composableLambda2 == null, function27 == null, function29 == null), mutableInteractionSource2, composer3, (i27 & 896) | (i26 & 14) | ((i26 >> 6) & 112) | ((i26 >> 3) & 7168) | ((i26 << 6) & 57344) | (3670016 & i27) | (234881024 & i27) | (1879048192 & i27), ((i26 >> 27) & 14) | 3072 | ((i17 << 3) & 112) | ((i17 << 9) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z5 = z4;
                mutableInteractionSource3 = mutableInteractionSource2;
                selectableChipBorder3 = selectableChipBorder4;
                function210 = function214;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.InputChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                    invoke(composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer6, int i28) {
                    ChipKt.InputChip(z, onClick, label, modifier3, z5, function27, function210, function29, shape3, selectableChipColors2, selectableChipElevation2, selectableChipBorder3, mutableInteractionSource3, composer6, i | 1, i2, i4);
                }
            });
            return;
        }
        i5 |= 3072;
        i6 = i4 & 16;
        if (i6 == 0) {
        }
        i7 = i4 & 32;
        if (i7 == 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        if ((i & 234881024) != 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        if ((i2 & 14) != 0) {
        }
        if ((i2 & 112) == 0) {
        }
        int i212 = i10;
        i11 = i4 & 4096;
        if (i11 == 0) {
        }
        if ((i5 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            int i232 = i13;
            if ((i & 1) != 0) {
                if (i19 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if ((i4 & 256) != 0) {
                }
                int i242 = i5;
                if ((i4 & 512) == 0) {
                }
                if ((i4 & 1024) == 0) {
                }
                if ((i4 & 2048) == 0) {
                }
                if (i15 == 0) {
                }
                composerStartRestartGroup.endDefaults();
                Modifier modifier42 = modifier2;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-1372002035);
                if (function28 == null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), InputChipTokens.INSTANCE.getLabelTextFont());
                if (selectableChipBorder2 != null) {
                }
                if (stateBorderStroke$material3_release == null) {
                }
                int i262 = i18;
                int i272 = i262 << 3;
                Function2<? super Composer, ? super Integer, Unit> function2142 = function28;
                SelectableChipBorder selectableChipBorder42 = selectableChipBorder2;
                composer3 = composerStartRestartGroup;
                m17031SelectableChipu0RnIRE(z, modifier42, onClick, z4, label, textStyleFromToken2, function27, composableLambda2, function29, shape3, selectableChipColors2, selectableChipElevation2, stateBorderStroke$material3_release == null ? stateBorderStroke$material3_release.getValue() : null, InputChipDefaults.INSTANCE.m17201getHeightD9Ej5fM(), inputChipPadding(composableLambda2 == null, function27 == null, function29 == null), mutableInteractionSource2, composer3, (i272 & 896) | (i262 & 14) | ((i262 >> 6) & 112) | ((i262 >> 3) & 7168) | ((i262 << 6) & 57344) | (3670016 & i272) | (234881024 & i272) | (1879048192 & i272), ((i262 >> 27) & 14) | 3072 | ((i17 << 3) & 112) | ((i17 << 9) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
                z5 = z4;
                mutableInteractionSource3 = mutableInteractionSource2;
                selectableChipBorder3 = selectableChipBorder42;
                function210 = function2142;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    public static final void m17031SelectableChipu0RnIRE(final boolean z, final Modifier modifier, final Function0<Unit> function0, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(402951308);
        if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            function25 = function2;
            i4 |= composerStartRestartGroup.changed(function25) ? 16384 : 8192;
        } else {
            function25 = function2;
        }
        if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 1048576 : 524288;
        }
        if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changed(function23) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(function24) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(selectableChipColors) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(borderStroke) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 57344) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & 458752) == 0) {
            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        final int i6 = i5;
        if ((i4 & 1533916891) == 306783378 && (374491 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, i4, i6, "androidx.compose.material3.SelectableChip (Chip.kt:1353)");
            }
            final int i7 = i4;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                }
            }, 1, null);
            int i8 = (i7 >> 9) & 14;
            long jM18535unboximpl = selectableChipColors.containerColor$material3_release(z2, z, composerStartRestartGroup, ((i7 << 3) & 112) | i8 | ((i6 << 6) & 896)).getValue().m18535unboximpl();
            composerStartRestartGroup.startReplaceableGroup(1036661290);
            State<C2256Dp> state = selectableChipElevation == null ? null : selectableChipElevation.tonalElevation$material3_release(z2, mutableInteractionSource, composerStartRestartGroup, ((i6 >> 12) & 112) | i8 | ((i6 << 3) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            float fM20982unboximpl = state != null ? state.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0);
            State<C2256Dp> stateShadowElevation$material3_release = selectableChipElevation == null ? null : selectableChipElevation.shadowElevation$material3_release(z2, mutableInteractionSource, composerStartRestartGroup, i8 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
            composer2 = composerStartRestartGroup;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
            SurfaceKt.m17326Surfaced85dljk(z, function0, modifierSemantics$default, z2, shape, jM18535unboximpl, 0L, fM20982unboximpl, stateShadowElevation$material3_release != null ? stateShadowElevation$material3_release.getValue().m20982unboximpl() : C2256Dp.m20968constructorimpl(0), borderStroke, mutableInteractionSource, ComposableLambdaKt.composableLambda(composer2, -577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer3, int i9) {
                    if ((i9 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-577614814, i9, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1385)");
                    }
                    SelectableChipColors selectableChipColors2 = selectableChipColors;
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i10 = i7;
                    long jM18535unboximpl2 = selectableChipColors2.labelColor$material3_release(z3, z4, composer3, ((i10 << 3) & 112) | ((i10 >> 9) & 14) | ((i6 << 6) & 896)).getValue().m18535unboximpl();
                    SelectableChipColors selectableChipColors3 = selectableChipColors;
                    boolean z5 = z2;
                    boolean z6 = z;
                    int i11 = i7;
                    long jM18535unboximpl3 = selectableChipColors3.leadingIconContentColor$material3_release(z5, z6, composer3, ((i11 << 3) & 112) | ((i11 >> 9) & 14) | ((i6 << 6) & 896)).getValue().m18535unboximpl();
                    SelectableChipColors selectableChipColors4 = selectableChipColors;
                    boolean z7 = z2;
                    boolean z8 = z;
                    int i12 = i7;
                    long jM18535unboximpl4 = selectableChipColors4.trailingIconContentColor$material3_release(z7, z8, composer3, ((i12 << 3) & 112) | ((i12 >> 9) & 14) | ((i6 << 6) & 896)).getValue().m18535unboximpl();
                    Function2<Composer, Integer, Unit> function27 = function26;
                    TextStyle textStyle2 = textStyle;
                    Function2<Composer, Integer, Unit> function28 = function22;
                    Function2<Composer, Integer, Unit> function29 = function23;
                    Function2<Composer, Integer, Unit> function210 = function24;
                    float f4 = f;
                    PaddingValues paddingValues2 = paddingValues;
                    int i13 = i7;
                    int i14 = ((i13 >> 12) & 14) | ((i13 >> 12) & 112) | ((i13 >> 9) & 7168) | ((i13 >> 9) & 57344) | ((i13 >> 9) & 458752);
                    int i15 = i6;
                    ChipKt.m17030ChipContentfe0OD_I(function27, textStyle2, jM18535unboximpl2, function28, function29, function210, jM18535unboximpl3, jM18535unboximpl4, f4, paddingValues2, composer3, ((i15 << 15) & 1879048192) | i14 | ((i15 << 15) & 234881024));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, (i7 & 14) | ((i7 >> 3) & 112) | (i7 & 7168) | ((i7 >> 15) & 57344) | ((i6 << 21) & 1879048192), ((i6 >> 15) & 14) | 48, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer3, int i9) {
                ChipKt.m17031SelectableChipu0RnIRE(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer3, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010f  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SuggestionChip(@NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> label, @Nullable Modifier modifier, boolean z, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Shape shape, @Nullable ChipColors chipColors, @Nullable ChipElevation chipElevation, @Nullable ChipBorder chipBorder, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Shape shape2;
        ChipColors chipColors2;
        ChipElevation chipElevation2;
        ChipBorder chipBorderM17322suggestionChipBorderd_3_b6Q;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Shape shape3;
        Composer composer2;
        int i9;
        ChipColors chipColorsM17323suggestionChipColors5tl4gsc;
        ChipElevation chipElevationM17324suggestionChipElevationaqJV_2Y;
        ChipElevation chipElevation3;
        ChipColors chipColors3;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape4;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        final Modifier modifier4;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape5;
        final ChipColors chipColors4;
        final ChipElevation chipElevation4;
        final MutableInteractionSource mutableInteractionSource4;
        final ChipBorder chipBorder2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(170629701);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 57344) == 0) {
                        function22 = function2;
                        i4 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i11 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i4 |= i11;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            int i12 = composerStartRestartGroup.changed(chipColors2) ? 1048576 : 524288;
                            i4 |= i12;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i4 |= i12;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((29360128 & i) != 0) {
                        if ((i2 & 128) == 0) {
                            chipElevation2 = chipElevation;
                            int i13 = composerStartRestartGroup.changed(chipElevation2) ? 8388608 : 4194304;
                            i4 |= i13;
                        } else {
                            chipElevation2 = chipElevation;
                        }
                        i4 |= i13;
                    } else {
                        chipElevation2 = chipElevation;
                    }
                    if ((i & 234881024) != 0) {
                        if ((i2 & 256) == 0) {
                            chipBorderM17322suggestionChipBorderd_3_b6Q = chipBorder;
                            int i14 = composerStartRestartGroup.changed(chipBorderM17322suggestionChipBorderd_3_b6Q) ? 67108864 : 33554432;
                            i4 |= i14;
                        } else {
                            chipBorderM17322suggestionChipBorderd_3_b6Q = chipBorder;
                        }
                        i4 |= i14;
                    } else {
                        chipBorderM17322suggestionChipBorderd_3_b6Q = chipBorder;
                    }
                    i7 = i2 & 512;
                    if (i7 != 0) {
                        if ((i & 1879048192) == 0) {
                            i8 = i7;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        }
                        if ((i4 & 1533916891) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            boolean z5 = z2;
                            chipBorder2 = chipBorderM17322suggestionChipBorderd_3_b6Q;
                            z4 = z5;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            modifier4 = modifier2;
                            function24 = function22;
                            shape5 = shape2;
                            chipColors4 = chipColors2;
                            chipElevation4 = chipElevation2;
                            composer3 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z6 = i5 == 0 ? true : z2;
                                Function2<? super Composer, ? super Integer, Unit> function25 = i6 == 0 ? null : function22;
                                if ((i2 & 32) == 0) {
                                    i4 &= -458753;
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                int i15 = i4;
                                if ((i2 & 64) == 0) {
                                    i9 = i8;
                                    composer2 = composerStartRestartGroup;
                                    i15 &= -3670017;
                                    chipColorsM17323suggestionChipColors5tl4gsc = SuggestionChipDefaults.INSTANCE.m17323suggestionChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i9 = i8;
                                    chipColorsM17323suggestionChipColors5tl4gsc = chipColors2;
                                }
                                if ((i2 & 128) == 0) {
                                    i15 &= -29360129;
                                    chipElevationM17324suggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m17324suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                                } else {
                                    chipElevationM17324suggestionChipElevationaqJV_2Y = chipElevation;
                                }
                                if ((i2 & 256) == 0) {
                                    Composer composer4 = composer2;
                                    chipBorderM17322suggestionChipBorderd_3_b6Q = SuggestionChipDefaults.INSTANCE.m17322suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, composer4, 3072, 7);
                                    composer2 = composer4;
                                    i4 = i15 & (-234881025);
                                } else {
                                    i4 = i15;
                                }
                                if (i9 == 0) {
                                    composer2.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    composer2.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    chipElevation3 = chipElevationM17324suggestionChipElevationaqJV_2Y;
                                    chipColors3 = chipColorsM17323suggestionChipColors5tl4gsc;
                                    z3 = z6;
                                    function23 = function25;
                                    shape4 = shape3;
                                } else {
                                    chipElevation3 = chipElevationM17324suggestionChipElevationaqJV_2Y;
                                    chipColors3 = chipColorsM17323suggestionChipColors5tl4gsc;
                                    z3 = z6;
                                    function23 = function25;
                                    shape4 = shape3;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(170629701, i4, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:520)");
                                    }
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                                    int i16 = (i4 >> 9) & 14;
                                    int i17 = i4 >> 15;
                                    long jM18535unboximpl = chipColors3.labelColor$material3_release(z3, composer2, (i17 & 112) | i16).getValue().m18535unboximpl();
                                    State<BorderStroke> stateBorderStroke$material3_release = chipBorderM17322suggestionChipBorderd_3_b6Q != null ? null : chipBorderM17322suggestionChipBorderd_3_b6Q.borderStroke$material3_release(z3, composer2, i16 | ((i4 >> 21) & 112));
                                    int i18 = i4;
                                    Modifier modifier5 = modifier3;
                                    int i19 = i18 << 6;
                                    int i20 = i18 << 9;
                                    ChipBorder chipBorder3 = chipBorderM17322suggestionChipBorderd_3_b6Q;
                                    Composer composer5 = composer2;
                                    m17029ChipnkUnTEs(modifier5, onClick, z3, label, textStyleFromToken, jM18535unboximpl, function23, null, shape4, chipColors3, chipElevation3, stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null, SuggestionChipDefaults.INSTANCE.m17320getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer5, (i19 & 3670016) | ((i18 >> 6) & 14) | 12582912 | ((i18 << 3) & 112) | ((i18 >> 3) & 896) | (i19 & 7168) | (i20 & 234881024) | (i20 & 1879048192), ((i18 >> 21) & 14) | 3456 | (i17 & 57344));
                                    composer3 = composer5;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier5;
                                    z4 = z3;
                                    function24 = function23;
                                    shape5 = shape4;
                                    chipColors4 = chipColors3;
                                    chipElevation4 = chipElevation3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    chipBorder2 = chipBorder3;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                modifier3 = modifier2;
                                z3 = z2;
                                function23 = function22;
                                shape4 = shape2;
                                chipColors3 = chipColors2;
                                composer2 = composerStartRestartGroup;
                                chipElevation3 = chipElevation2;
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            TextStyle textStyleFromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                            int i162 = (i4 >> 9) & 14;
                            int i172 = i4 >> 15;
                            long jM18535unboximpl2 = chipColors3.labelColor$material3_release(z3, composer2, (i172 & 112) | i162).getValue().m18535unboximpl();
                            if (chipBorderM17322suggestionChipBorderd_3_b6Q != null) {
                            }
                            int i182 = i4;
                            Modifier modifier52 = modifier3;
                            int i192 = i182 << 6;
                            int i202 = i182 << 9;
                            ChipBorder chipBorder32 = chipBorderM17322suggestionChipBorderd_3_b6Q;
                            Composer composer52 = composer2;
                            m17029ChipnkUnTEs(modifier52, onClick, z3, label, textStyleFromToken2, jM18535unboximpl2, function23, null, shape4, chipColors3, chipElevation3, stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null, SuggestionChipDefaults.INSTANCE.m17320getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer52, (i192 & 3670016) | ((i182 >> 6) & 14) | 12582912 | ((i182 << 3) & 112) | ((i182 >> 3) & 896) | (i192 & 7168) | (i202 & 234881024) | (i202 & 1879048192), ((i182 >> 21) & 14) | 3456 | (i172 & 57344));
                            composer3 = composer52;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            z4 = z3;
                            function24 = function23;
                            shape5 = shape4;
                            chipColors4 = chipColors3;
                            chipElevation4 = chipElevation3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            chipBorder2 = chipBorder32;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.SuggestionChip.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                invoke(composer6, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer6, int i21) {
                                ChipKt.SuggestionChip(onClick, label, modifier4, z4, function24, shape5, chipColors4, chipElevation4, chipBorder2, mutableInteractionSource4, composer6, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= DriveFile.MODE_READ_WRITE;
                    i8 = i7;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i10 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            int i152 = i4;
                            if ((i2 & 64) == 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if ((i2 & 256) == 0) {
                            }
                            if (i9 == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function22 = function2;
                if ((458752 & i) != 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((29360128 & i) != 0) {
                }
                if ((i & 234881024) != 0) {
                }
                i7 = i2 & 512;
                if (i7 != 0) {
                }
                i8 = i7;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i4 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            function22 = function2;
            if ((458752 & i) != 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((29360128 & i) != 0) {
            }
            if ((i & 234881024) != 0) {
            }
            i7 = i2 & 512;
            if (i7 != 0) {
            }
            i8 = i7;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i4 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        function22 = function2;
        if ((458752 & i) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((29360128 & i) != 0) {
        }
        if ((i & 234881024) != 0) {
        }
        i7 = i2 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i4 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m15851PaddingValuesa9UjIt4$default(C2256Dp.m20968constructorimpl((z || !z2) ? 4 : 8), 0.0f, C2256Dp.m20968constructorimpl(z3 ? 8 : 4), 0.0f, 10, null);
    }

    public static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }
}
