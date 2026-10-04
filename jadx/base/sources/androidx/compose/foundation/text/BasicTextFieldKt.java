package androidx.compose.foundation.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.hapticfeedback.HapticFeedback;
import androidx.compose.p109ui.input.pointer.PointerIconKt;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.ClipboardManager;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.TextToolbar;
import androidx.compose.p109ui.platform.WindowInfo;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.input.ImeOptions;
import androidx.compose.p109ui.text.input.TextFieldValue;
import androidx.compose.p109ui.text.input.VisualTransformation;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÛ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001añ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020\fH\u0001¢\u0006\u0002\u0010.\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010=\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010>\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010?\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010A\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010>\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010B\u001a\u0015\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\u001a\u0015\u0010G\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006H²\u0006\n\u0010I\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010M\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020@X\u008a\u008e\u0002"}, m13886d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicTextField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicTextField.kt\nandroidx/compose/foundation/text/BasicTextFieldKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 10 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,867:1\n77#2:868\n77#2:869\n77#2:870\n77#2:896\n77#2:897\n77#2:898\n1225#3,6:871\n1225#3,3:877\n1228#3,3:881\n1225#3,6:884\n1225#3,6:890\n1225#3,6:899\n1225#3,6:905\n1225#3,6:951\n1225#3,6:957\n1225#3,6:963\n1225#3,6:969\n1225#3,6:975\n1225#3,6:981\n1225#3,6:987\n1225#3,6:993\n1225#3,6:999\n1225#3,6:1005\n1225#3,6:1011\n1225#3,6:1017\n1225#3,6:1023\n1225#3,6:1029\n1225#3,6:1035\n1225#3,6:1041\n1#4:880\n71#5:911\n68#5,6:912\n74#5:946\n78#5:950\n79#6,6:918\n86#6,4:933\n90#6,2:943\n94#6:949\n368#7,9:924\n377#7:945\n378#7,2:947\n4034#8,6:937\n81#9:1047\n81#9:1048\n81#9:1049\n81#9:1050\n107#9,2:1051\n81#9:1053\n107#9,2:1054\n149#10:1056\n*S KotlinDebug\n*F\n+ 1 BasicTextField.kt\nandroidx/compose/foundation/text/BasicTextFieldKt\n*L\n240#1:868\n241#1:869\n242#1:870\n285#1:896\n286#1:897\n287#1:898\n246#1:871,6\n252#1:877,3\n252#1:881,3\n272#1:884,6\n274#1:890,6\n288#1:899,6\n304#1:905,6\n418#1:951,6\n423#1:957,6\n429#1:963,6\n442#1:969,6\n449#1:975,6\n457#1:981,6\n465#1:987,6\n472#1:993,6\n480#1:999,6\n614#1:1005,6\n620#1:1011,6\n629#1:1017,6\n633#1:1023,6\n766#1:1029,6\n803#1:1035,6\n843#1:1041,6\n343#1:911\n343#1:912,6\n343#1:946\n343#1:950\n343#1:918,6\n343#1:933,4\n343#1:943,2\n343#1:949\n343#1:924,9\n343#1:945\n343#1:947,2\n343#1:937,6\n418#1:1047\n442#1:1048\n465#1:1049\n614#1:1050\n614#1:1051,2\n629#1:1053\n629#1:1054,2\n499#1:1056\n*E\n"})
public final class BasicTextFieldKt {

    @NotNull
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
    private static final long MinTouchTargetSizeForHandles;

    static {
        float f = 40;
        MinTouchTargetSizeForHandles = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(@NotNull final TextFieldState textFieldState, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable InputTransformation inputTransformation, @Nullable TextStyle textStyle, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActionHandler keyboardActionHandler, @Nullable TextFieldLineLimits textFieldLineLimits, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Brush brush, @Nullable OutputTransformation outputTransformation, @Nullable TextFieldDecorator textFieldDecorator, @Nullable ScrollState scrollState, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        int i8;
        InputTransformation inputTransformation2;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        KeyboardOptions keyboardOptions3;
        TextFieldLineLimits textFieldLineLimits2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        TextFieldDecorator textFieldDecorator2;
        TextStyle textStyle3;
        KeyboardActionHandler keyboardActionHandler2;
        MutableInteractionSource mutableInteractionSource2;
        OutputTransformation outputTransformation2;
        Brush brush2;
        ScrollState scrollStateRememberScrollState;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final boolean z6;
        final InputTransformation inputTransformation3;
        final TextStyle textStyle4;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActionHandler keyboardActionHandler3;
        final TextFieldLineLimits textFieldLineLimits3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush3;
        final OutputTransformation outputTransformation3;
        final TextFieldDecorator textFieldDecorator3;
        final ScrollState scrollState2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(469439921);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        int i25 = i4 & 2;
        if (i25 != 0) {
            i5 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z3 = z;
                    i5 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        i5 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    int i26 = 8192;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            inputTransformation2 = inputTransformation;
                            i5 |= composerStartRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= 196608;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i & 196608) == 0) {
                                i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else {
                            if ((i & 100663296) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                            }
                            i14 = i4 & 512;
                            if (i14 != 0) {
                                if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                    i15 = i14;
                                    i5 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                                }
                                i16 = i4 & 1024;
                                if (i16 != 0) {
                                    i18 = i2 | 6;
                                    i17 = i16;
                                } else if ((i2 & 6) == 0) {
                                    i17 = i16;
                                    i18 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i17 = i16;
                                    i18 = i2;
                                }
                                i19 = i4 & 2048;
                                if (i19 != 0) {
                                    i18 |= 48;
                                    i20 = i19;
                                } else if ((i2 & 48) == 0) {
                                    i20 = i19;
                                    i18 |= composerStartRestartGroup.changed(brush) ? 32 : 16;
                                } else {
                                    i20 = i19;
                                }
                                int i27 = i18;
                                i21 = i4 & 4096;
                                if (i21 != 0) {
                                    i22 = i27 | 384;
                                } else if ((i2 & 384) == 0) {
                                    i22 = i27 | (composerStartRestartGroup.changed(outputTransformation) ? 256 : 128);
                                } else {
                                    i22 = i27;
                                }
                                i23 = i4 & 8192;
                                if (i23 != 0) {
                                    i24 = i22 | 3072;
                                } else {
                                    int i28 = i22;
                                    if ((i2 & 3072) == 0) {
                                        i24 = i28 | ((i2 & 4096) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 2048 : 1024);
                                    } else {
                                        i24 = i28;
                                    }
                                }
                                if ((i2 & 24576) == 0) {
                                    if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(scrollState)) {
                                        i26 = 16384;
                                    }
                                    i24 |= i26;
                                }
                                if ((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    textFieldLineLimits3 = textFieldLineLimits;
                                    function23 = function2;
                                    textFieldDecorator3 = textFieldDecorator;
                                    composer2 = composerStartRestartGroup;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation3 = inputTransformation2;
                                    textStyle4 = textStyle2;
                                    modifier3 = modifier2;
                                    keyboardOptions4 = keyboardOptions2;
                                    keyboardActionHandler3 = keyboardActionHandler;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    brush3 = brush;
                                    outputTransformation3 = outputTransformation;
                                    scrollState2 = scrollState;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i25 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i6 != 0) {
                                            z3 = true;
                                        }
                                        if (i7 != 0) {
                                            z4 = false;
                                        }
                                        if (i8 != 0) {
                                            inputTransformation2 = null;
                                        }
                                        if (i9 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        keyboardOptions3 = i10 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                                        KeyboardActionHandler keyboardActionHandler4 = i11 == 0 ? null : keyboardActionHandler;
                                        textFieldLineLimits2 = i13 == 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                        function22 = i15 == 0 ? null : function2;
                                        MutableInteractionSource mutableInteractionSource4 = i17 == 0 ? null : mutableInteractionSource;
                                        Brush cursorBrush = i20 == 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : brush;
                                        OutputTransformation outputTransformation4 = i21 == 0 ? null : outputTransformation;
                                        TextFieldDecorator textFieldDecorator4 = i23 == 0 ? textFieldDecorator : null;
                                        if ((i4 & 16384) == 0) {
                                            i24 &= -57345;
                                            Brush brush4 = cursorBrush;
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                            outputTransformation2 = outputTransformation4;
                                            brush2 = brush4;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            textFieldDecorator2 = textFieldDecorator4;
                                            textStyle3 = textStyle2;
                                            keyboardActionHandler2 = keyboardActionHandler4;
                                            mutableInteractionSource2 = mutableInteractionSource5;
                                        } else {
                                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                            textFieldDecorator2 = textFieldDecorator4;
                                            textStyle3 = textStyle2;
                                            keyboardActionHandler2 = keyboardActionHandler4;
                                            mutableInteractionSource2 = mutableInteractionSource6;
                                            outputTransformation2 = outputTransformation4;
                                            brush2 = cursorBrush;
                                            scrollStateRememberScrollState = scrollState;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 16384) != 0) {
                                            i24 &= -57345;
                                        }
                                        textFieldLineLimits2 = textFieldLineLimits;
                                        function22 = function2;
                                        brush2 = brush;
                                        outputTransformation2 = outputTransformation;
                                        textFieldDecorator2 = textFieldDecorator;
                                        scrollStateRememberScrollState = scrollState;
                                        textStyle3 = textStyle2;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActionHandler2 = keyboardActionHandler;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(469439921, i5, i24, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:187)");
                                    }
                                    int i29 = (i24 & 14) | 384 | (i24 & 112);
                                    int i30 = i24 << 3;
                                    Modifier modifier4 = modifier2;
                                    TextFieldLineLimits textFieldLineLimits4 = textFieldLineLimits2;
                                    composer2 = composerStartRestartGroup;
                                    InputTransformation inputTransformation4 = inputTransformation2;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = function22;
                                    OutputTransformation outputTransformation5 = outputTransformation2;
                                    BasicTextField(textFieldState, modifier4, z3, z4, inputTransformation4, textStyle3, keyboardOptions5, keyboardActionHandler2, textFieldLineLimits4, function24, mutableInteractionSource2, brush2, null, outputTransformation5, textFieldDecorator2, scrollStateRememberScrollState, false, composer2, i5 & 2147483646, i29 | (i30 & 7168) | (57344 & i30) | (i30 & 458752), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation3 = inputTransformation4;
                                    textStyle4 = textStyle3;
                                    keyboardOptions4 = keyboardOptions5;
                                    keyboardActionHandler3 = keyboardActionHandler2;
                                    textFieldLineLimits3 = textFieldLineLimits4;
                                    function23 = function24;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    brush3 = brush2;
                                    outputTransformation3 = outputTransformation5;
                                    textFieldDecorator3 = textFieldDecorator2;
                                    scrollState2 = scrollStateRememberScrollState;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
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

                                        public final void invoke(@Nullable Composer composer3, int i31) {
                                            BasicTextFieldKt.BasicTextField(textFieldState, modifier3, z5, z6, inputTransformation3, textStyle4, keyboardOptions4, keyboardActionHandler3, textFieldLineLimits3, function23, mutableInteractionSource3, brush3, outputTransformation3, textFieldDecorator3, scrollState2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i4);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i5 |= DriveFile.MODE_READ_WRITE;
                            i15 = i14;
                            i16 = i4 & 1024;
                            if (i16 != 0) {
                            }
                            i19 = i4 & 2048;
                            if (i19 != 0) {
                            }
                            int i272 = i18;
                            i21 = i4 & 4096;
                            if (i21 != 0) {
                            }
                            i23 = i4 & 8192;
                            if (i23 != 0) {
                            }
                            if ((i2 & 24576) == 0) {
                            }
                            if ((i5 & 306783379) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0) {
                                    if (i25 != 0) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    if (i7 != 0) {
                                    }
                                    if (i8 != 0) {
                                    }
                                    if (i9 != 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i11 == 0) {
                                    }
                                    if (i13 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if (i21 == 0) {
                                    }
                                    if (i23 == 0) {
                                    }
                                    if ((i4 & 16384) == 0) {
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i292 = (i24 & 14) | 384 | (i24 & 112);
                                    int i302 = i24 << 3;
                                    Modifier modifier42 = modifier2;
                                    TextFieldLineLimits textFieldLineLimits42 = textFieldLineLimits2;
                                    composer2 = composerStartRestartGroup;
                                    InputTransformation inputTransformation42 = inputTransformation2;
                                    KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                    Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function242 = function22;
                                    OutputTransformation outputTransformation52 = outputTransformation2;
                                    BasicTextField(textFieldState, modifier42, z3, z4, inputTransformation42, textStyle3, keyboardOptions52, keyboardActionHandler2, textFieldLineLimits42, function242, mutableInteractionSource2, brush2, null, outputTransformation52, textFieldDecorator2, scrollStateRememberScrollState, false, composer2, i5 & 2147483646, i292 | (i302 & 7168) | (57344 & i302) | (i302 & 458752), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier3 = modifier42;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation3 = inputTransformation42;
                                    textStyle4 = textStyle3;
                                    keyboardOptions4 = keyboardOptions52;
                                    keyboardActionHandler3 = keyboardActionHandler2;
                                    textFieldLineLimits3 = textFieldLineLimits42;
                                    function23 = function242;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    brush3 = brush2;
                                    outputTransformation3 = outputTransformation52;
                                    textFieldDecorator3 = textFieldDecorator2;
                                    scrollState2 = scrollStateRememberScrollState;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i4 & 512;
                        if (i14 != 0) {
                        }
                        i15 = i14;
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                        }
                        i19 = i4 & 2048;
                        if (i19 != 0) {
                        }
                        int i2722 = i18;
                        i21 = i4 & 4096;
                        if (i21 != 0) {
                        }
                        i23 = i4 & 8192;
                        if (i23 != 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i5 & 306783379) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    inputTransformation2 = inputTransformation;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 != 0) {
                    }
                    int i27222 = i18;
                    i21 = i4 & 4096;
                    if (i21 != 0) {
                    }
                    i23 = i4 & 8192;
                    if (i23 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i5 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z4 = z2;
                i8 = i4 & 16;
                int i262 = 8192;
                if (i8 == 0) {
                }
                inputTransformation2 = inputTransformation;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                }
                int i272222 = i18;
                i21 = i4 & 4096;
                if (i21 != 0) {
                }
                i23 = i4 & 8192;
                if (i23 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i5 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z4 = z2;
            i8 = i4 & 16;
            int i2622 = 8192;
            if (i8 == 0) {
            }
            inputTransformation2 = inputTransformation;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
            }
            int i2722222 = i18;
            i21 = i4 & 4096;
            if (i21 != 0) {
            }
            i23 = i4 & 8192;
            if (i23 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i5 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z3 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z4 = z2;
        i8 = i4 & 16;
        int i26222 = 8192;
        if (i8 == 0) {
        }
        inputTransformation2 = inputTransformation;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
        }
        int i27222222 = i18;
        i21 = i4 & 4096;
        if (i21 != 0) {
        }
        i23 = i4 & 8192;
        if (i23 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i5 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$21(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$25(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldCursorHandle(@NotNull final TextFieldSelectionState textFieldSelectionState, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1991581797);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:414)");
            }
            boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final TextFieldHandleState invoke() {
                        return textFieldSelectionState.getCursorHandleState$foundation_release(false);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            if (TextFieldCursorHandle$lambda$9((State) objRememberedValue).getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-317096444);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo16143provideF1C5BW0() {
                            return textFieldSelectionState.getCursorHandleState$foundation_release(true).m16413getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new BasicTextFieldKt$TextFieldCursorHandle$2$1(textFieldSelectionState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                AndroidCursorHandle_androidKt.m16140CursorHandleUSBMPiE(offsetProvider, SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3), MinTouchTargetSizeForHandles, composerStartRestartGroup, 384, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-316671682);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.TextFieldCursorHandle.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$9(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldSelectionHandles(@NotNull final TextFieldSelectionState textFieldSelectionState, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2025287684);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025287684, i2, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:439)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final TextFieldHandleState invoke() {
                        return textFieldSelectionState.getSelectionHandleState$foundation_release(true, false);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            if (TextFieldSelectionHandles$lambda$13(state).getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-1353974139);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo16143provideF1C5BW0() {
                            return textFieldSelectionState.getSelectionHandleState$foundation_release(true, true).m16413getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                ResolvedTextDirection direction = TextFieldSelectionHandles$lambda$13(state).getDirection();
                boolean handlesCrossed = TextFieldSelectionHandles$lambda$13(state).getHandlesCrossed();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new BasicTextFieldKt$TextFieldSelectionHandles$2$1(textFieldSelectionState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                AndroidSelectionHandles_androidKt.m16492SelectionHandlepzduO1o(offsetProvider, true, direction, handlesCrossed, MinTouchTargetSizeForHandles, SuspendingPointerInputFilterKt.pointerInput(companion2, textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3), composerStartRestartGroup, 24624, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1353397539);
                composerStartRestartGroup.endReplaceGroup();
            }
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final TextFieldHandleState invoke() {
                        return textFieldSelectionState.getSelectionHandleState$foundation_release(false, false);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            State state2 = (State) objRememberedValue4;
            if (TextFieldSelectionHandles$lambda$17(state2).getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-1353104186);
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo16143provideF1C5BW0() {
                            return textFieldSelectionState.getSelectionHandleState$foundation_release(false, true).m16413getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                OffsetProvider offsetProvider2 = (OffsetProvider) objRememberedValue5;
                ResolvedTextDirection direction2 = TextFieldSelectionHandles$lambda$17(state2).getDirection();
                boolean handlesCrossed2 = TextFieldSelectionHandles$lambda$17(state2).getHandlesCrossed();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new BasicTextFieldKt$TextFieldSelectionHandles$4$1(textFieldSelectionState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                AndroidSelectionHandles_androidKt.m16492SelectionHandlepzduO1o(offsetProvider2, false, direction2, handlesCrossed2, MinTouchTargetSizeForHandles, SuspendingPointerInputFilterKt.pointerInput(companion3, textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6), composerStartRestartGroup, 24624, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1352528547);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.TextFieldSelectionHandles.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$13(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$17(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:360:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(@NotNull final TextFieldState textFieldState, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable InputTransformation inputTransformation, @Nullable TextStyle textStyle, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActionHandler keyboardActionHandler, @Nullable TextFieldLineLimits textFieldLineLimits, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Brush brush, @Nullable CodepointTransformation codepointTransformation, @Nullable OutputTransformation outputTransformation, @Nullable TextFieldDecorator textFieldDecorator, @Nullable ScrollState scrollState, boolean z3, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        int i8;
        InputTransformation inputTransformation2;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        TextFieldLineLimits textFieldLineLimits2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        MutableInteractionSource mutableInteractionSource2;
        Brush cursorBrush;
        CodepointTransformation codepointTransformation2;
        ScrollState scrollStateRememberScrollState;
        int i28;
        TextFieldDecorator textFieldDecorator2;
        OutputTransformation outputTransformation2;
        boolean z6;
        int i29;
        KeyboardActionHandler keyboardActionHandler2;
        Density density;
        MutableInteractionSource mutableInteractionSource3;
        boolean z7;
        final boolean zBooleanValue;
        final boolean zIsWindowFocused;
        boolean z8;
        Object objRememberedValue;
        CodepointTransformation codepointTransformation3;
        TransformedTextFieldState transformedTextFieldState;
        boolean zChanged;
        Object objRememberedValue2;
        TextLayoutState textLayoutState;
        boolean zChanged2;
        Object objRememberedValue3;
        boolean z9;
        TextLayoutState textLayoutState2;
        Density density2;
        boolean z10;
        int i30;
        TransformedTextFieldState transformedTextFieldState2;
        final TextFieldSelectionState textFieldSelectionState;
        final HapticFeedback hapticFeedback;
        final boolean z11;
        final ClipboardManager clipboardManager;
        final TextToolbar textToolbar;
        final TransformedTextFieldState transformedTextFieldState3;
        boolean zChanged3;
        Object objRememberedValue4;
        TransformedTextFieldState transformedTextFieldState4;
        final TextFieldSelectionState textFieldSelectionState2;
        boolean z12;
        boolean z13;
        boolean zChangedInstance;
        Object objRememberedValue5;
        KeyboardActionHandler keyboardActionHandler3;
        Composer composerM18018constructorimpl;
        ComposeUiNode.Companion companion;
        final TextFieldDecorator textFieldDecorator3;
        final InputTransformation inputTransformation3;
        Composer composer2;
        final boolean z14;
        final KeyboardOptions keyboardOptions3;
        final TextStyle textStyle3;
        final boolean z15;
        final Modifier modifier3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final MutableInteractionSource mutableInteractionSource4;
        final Brush brush2;
        final CodepointTransformation codepointTransformation4;
        final ScrollState scrollState2;
        final boolean z16;
        final KeyboardActionHandler keyboardActionHandler4;
        final OutputTransformation outputTransformation3;
        final TextFieldLineLimits textFieldLineLimits3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(965149429);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        int i31 = i4 & 2;
        if (i31 != 0) {
            i5 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z4 = z;
                    i5 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z5 = z2;
                        i5 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            inputTransformation2 = inputTransformation;
                            i5 |= composerStartRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= 196608;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i & 196608) == 0) {
                                i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else {
                            if ((i & 100663296) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                            }
                            i14 = i4 & 512;
                            if (i14 != 0) {
                                if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                    i15 = i14;
                                    i5 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                                }
                                i16 = i4 & 1024;
                                if (i16 != 0) {
                                    i18 = i2 | 6;
                                    i17 = i16;
                                } else if ((i2 & 6) == 0) {
                                    i17 = i16;
                                    i18 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i17 = i16;
                                    i18 = i2;
                                }
                                i19 = i4 & 2048;
                                if (i19 != 0) {
                                    i18 |= 48;
                                    i20 = i19;
                                } else if ((i2 & 48) == 0) {
                                    i20 = i19;
                                    i18 |= composerStartRestartGroup.changed(brush) ? 32 : 16;
                                } else {
                                    i20 = i19;
                                }
                                int i32 = i18;
                                i21 = i4 & 4096;
                                if (i21 != 0) {
                                    i22 = i32 | 384;
                                } else if ((i2 & 384) == 0) {
                                    i22 = i32 | (composerStartRestartGroup.changed(codepointTransformation) ? 256 : 128);
                                } else {
                                    i22 = i32;
                                }
                                i23 = i4 & 8192;
                                if (i23 != 0) {
                                    i24 = i22 | 3072;
                                } else {
                                    int i33 = i22;
                                    if ((i2 & 3072) == 0) {
                                        i24 = i33 | (composerStartRestartGroup.changed(outputTransformation) ? 2048 : 1024);
                                    } else {
                                        i24 = i33;
                                    }
                                }
                                i25 = i4 & 16384;
                                if (i25 != 0) {
                                    i26 = i24 | 24576;
                                } else {
                                    int i34 = i24;
                                    if ((i2 & 24576) == 0) {
                                        i26 = i34 | ((i2 & 32768) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 16384 : 8192);
                                    } else {
                                        i26 = i34;
                                    }
                                }
                                if ((i2 & 196608) == 0) {
                                    i26 |= ((i4 & 32768) == 0 && composerStartRestartGroup.changed(scrollState)) ? 131072 : 65536;
                                }
                                i27 = i4 & 65536;
                                if (i27 != 0) {
                                    i26 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i26 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
                                }
                                int i35 = i26;
                                if ((i5 & 306783379) == 306783378 && (i35 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function23 = function2;
                                    outputTransformation3 = outputTransformation;
                                    scrollState2 = scrollState;
                                    z16 = z3;
                                    composer2 = composerStartRestartGroup;
                                    z14 = z5;
                                    keyboardOptions3 = keyboardOptions2;
                                    textStyle3 = textStyle2;
                                    z15 = z4;
                                    modifier3 = modifier2;
                                    inputTransformation3 = inputTransformation2;
                                    keyboardActionHandler4 = keyboardActionHandler;
                                    textFieldLineLimits3 = textFieldLineLimits;
                                    mutableInteractionSource4 = mutableInteractionSource;
                                    brush2 = brush;
                                    codepointTransformation4 = codepointTransformation;
                                    textFieldDecorator3 = textFieldDecorator;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 32768) != 0) {
                                            textFieldLineLimits2 = textFieldLineLimits;
                                            function22 = function2;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            cursorBrush = brush;
                                            codepointTransformation2 = codepointTransformation;
                                            outputTransformation2 = outputTransformation;
                                            textFieldDecorator2 = textFieldDecorator;
                                            scrollStateRememberScrollState = scrollState;
                                            z6 = z3;
                                            i29 = i35 & (-458753);
                                            keyboardActionHandler2 = keyboardActionHandler;
                                        } else {
                                            keyboardActionHandler2 = keyboardActionHandler;
                                            textFieldLineLimits2 = textFieldLineLimits;
                                            function22 = function2;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            cursorBrush = brush;
                                            codepointTransformation2 = codepointTransformation;
                                            outputTransformation2 = outputTransformation;
                                            textFieldDecorator2 = textFieldDecorator;
                                            scrollStateRememberScrollState = scrollState;
                                            z6 = z3;
                                            i29 = i35;
                                        }
                                    } else {
                                        if (i31 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i6 != 0) {
                                            z4 = true;
                                        }
                                        if (i7 != 0) {
                                            z5 = false;
                                        }
                                        if (i8 != 0) {
                                            inputTransformation2 = null;
                                        }
                                        if (i9 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        KeyboardOptions keyboardOptions4 = i10 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                                        KeyboardActionHandler keyboardActionHandler5 = i11 == 0 ? null : keyboardActionHandler;
                                        textFieldLineLimits2 = i13 == 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                        function22 = i15 == 0 ? null : function2;
                                        mutableInteractionSource2 = i17 == 0 ? null : mutableInteractionSource;
                                        cursorBrush = i20 == 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : brush;
                                        codepointTransformation2 = i21 == 0 ? null : codepointTransformation;
                                        OutputTransformation outputTransformation4 = i23 == 0 ? null : outputTransformation;
                                        TextFieldDecorator textFieldDecorator4 = i25 == 0 ? null : textFieldDecorator;
                                        KeyboardOptions keyboardOptions5 = keyboardOptions4;
                                        if ((i4 & 32768) == 0) {
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                            i28 = i35 & (-458753);
                                        } else {
                                            scrollStateRememberScrollState = scrollState;
                                            i28 = i35;
                                        }
                                        OutputTransformation outputTransformation5 = outputTransformation4;
                                        textFieldDecorator2 = textFieldDecorator4;
                                        outputTransformation2 = outputTransformation5;
                                        if (i27 == 0) {
                                            i29 = i28;
                                            keyboardActionHandler2 = keyboardActionHandler5;
                                            z6 = false;
                                        } else {
                                            z6 = z3;
                                            i29 = i28;
                                            keyboardActionHandler2 = keyboardActionHandler5;
                                        }
                                        keyboardOptions2 = keyboardOptions5;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    KeyboardActionHandler keyboardActionHandler6 = keyboardActionHandler2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(965149429, i5, i29, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:238)");
                                    }
                                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    WindowInfo windowInfo = (WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                                    final boolean zAreEqual = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                                    if (mutableInteractionSource2 != null) {
                                        composerStartRestartGroup.startReplaceGroup(96938805);
                                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue6 = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                        }
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue6;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-1243799582);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    }
                                    Orientation orientation = !zAreEqual ? Orientation.Horizontal : Orientation.Vertical;
                                    z7 = z5;
                                    zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, composerStartRestartGroup, 0).getValue().booleanValue();
                                    final boolean zBooleanValue2 = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource3, composerStartRestartGroup, 0).getValue().booleanValue();
                                    zIsWindowFocused = windowInfo.isWindowFocused();
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    z8 = ((i5 & 14) != 4) | ((i29 & 896) != 256) | ((i29 & 7168) != 2048);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        if (codepointTransformation2 != null) {
                                            codepointTransformation3 = SingleLineCodepointTransformation.INSTANCE;
                                            if (!zAreEqual) {
                                                codepointTransformation3 = null;
                                            }
                                        } else {
                                            codepointTransformation3 = codepointTransformation2;
                                        }
                                        objRememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, codepointTransformation3, outputTransformation2);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    transformedTextFieldState = (TransformedTextFieldState) objRememberedValue;
                                    zChanged = composerStartRestartGroup.changed(transformedTextFieldState);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new TextLayoutState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    textLayoutState = (TextLayoutState) objRememberedValue2;
                                    zChanged2 = composerStartRestartGroup.changed(transformedTextFieldState);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        boolean z17 = z4;
                                        z9 = z6;
                                        objRememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState, density, z17, z7, !zBooleanValue && zIsWindowFocused, z9);
                                        textLayoutState2 = textLayoutState;
                                        density2 = density;
                                        z4 = z17;
                                        z10 = z7;
                                        i30 = i29;
                                        transformedTextFieldState2 = transformedTextFieldState;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    } else {
                                        textLayoutState2 = textLayoutState;
                                        density2 = density;
                                        z9 = z6;
                                        i30 = i29;
                                        transformedTextFieldState2 = transformedTextFieldState;
                                        z10 = z7;
                                    }
                                    textFieldSelectionState = (TextFieldSelectionState) objRememberedValue3;
                                    OutputTransformation outputTransformation6 = outputTransformation2;
                                    hapticFeedback = (HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
                                    z11 = z10;
                                    clipboardManager = (ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
                                    KeyboardOptions keyboardOptions6 = keyboardOptions2;
                                    textToolbar = (TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
                                    transformedTextFieldState3 = transformedTextFieldState2;
                                    final TextFieldLineLimits textFieldLineLimits4 = textFieldLineLimits2;
                                    zChanged3 = ((i5 & 896) != 256) | composerStartRestartGroup.changed(transformedTextFieldState2) | ((i5 & 57344) != 16384) | composerStartRestartGroup.changedInstance(textFieldSelectionState) | composerStartRestartGroup.changedInstance(hapticFeedback) | composerStartRestartGroup.changedInstance(clipboardManager) | composerStartRestartGroup.changedInstance(textToolbar) | composerStartRestartGroup.changed(density2) | ((i5 & 7168) != 2048) | ((i30 & 3670016) != 1048576);
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        final boolean z18 = z9;
                                        final Density density3 = density2;
                                        final boolean z19 = z4;
                                        final InputTransformation inputTransformation4 = inputTransformation2;
                                        objRememberedValue4 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                transformedTextFieldState3.update(inputTransformation4);
                                                textFieldSelectionState.update(hapticFeedback, clipboardManager, textToolbar, density3, z19, z11, z18);
                                            }
                                        };
                                        transformedTextFieldState4 = transformedTextFieldState3;
                                        textFieldSelectionState2 = textFieldSelectionState;
                                        z12 = z11;
                                        z13 = z18;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    } else {
                                        transformedTextFieldState4 = transformedTextFieldState3;
                                        textFieldSelectionState2 = textFieldSelectionState;
                                        z12 = z11;
                                        z13 = z9;
                                    }
                                    EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
                                    zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState2);
                                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (!zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            @NotNull
                                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                final TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1$invoke$$inlined$onDispose$1
                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                    public void dispose() {
                                                        textFieldSelectionState3.dispose();
                                                    }
                                                };
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                    }
                                    EffectsKt.DisposableEffect(textFieldSelectionState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
                                    final TransformedTextFieldState transformedTextFieldState5 = transformedTextFieldState4;
                                    final TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
                                    boolean z20 = z13;
                                    Modifier modifierFocusable = FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState5, textLayoutState2, textFieldSelectionState3, inputTransformation2, z4, z12, keyboardOptions6, keyboardActionHandler6, zAreEqual, mutableInteractionSource5)), z4, mutableInteractionSource5);
                                    if (z4) {
                                        keyboardActionHandler3 = keyboardActionHandler6;
                                    } else {
                                        keyboardActionHandler3 = keyboardActionHandler6;
                                        boolean z21 = textFieldSelectionState3.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None;
                                        final Orientation orientation2 = orientation;
                                        Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(modifierFocusable, scrollStateRememberScrollState, orientation2, z21, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection, orientation, false), null, mutableInteractionSource5, 16, null), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerHoverIcon$default);
                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                        if (composerStartRestartGroup.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composerStartRestartGroup.startReusableNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                            composerStartRestartGroup.createNode(constructor);
                                        } else {
                                            composerStartRestartGroup.useNode();
                                        }
                                        composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                        Function2 function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                        if (composerM18018constructorimpl.getInserting()) {
                                            companion = companion2;
                                        } else {
                                            companion = companion2;
                                            if (!Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            }
                                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            final boolean z22 = z12;
                                            final TextStyle textStyle4 = textStyle2;
                                            final boolean z23 = z4;
                                            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = function22;
                                            final Brush brush3 = cursorBrush;
                                            final TextFieldDecorator textFieldDecorator5 = textFieldDecorator2;
                                            final ScrollState scrollState3 = scrollStateRememberScrollState;
                                            final TextLayoutState textLayoutState3 = textLayoutState2;
                                            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState3, z4, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
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
                                                public final void invoke(@Nullable Composer composer3, int i36) {
                                                    if ((i36 & 3) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-673241599, i36, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:344)");
                                                    }
                                                    TextFieldDecorator textFieldDecorator6 = textFieldDecorator5;
                                                    if (textFieldDecorator6 == null) {
                                                        textFieldDecorator6 = BasicTextFieldKt.DefaultTextFieldDecorator;
                                                    }
                                                    final TextFieldLineLimits textFieldLineLimits5 = textFieldLineLimits4;
                                                    final TextLayoutState textLayoutState4 = textLayoutState3;
                                                    final TextStyle textStyle5 = textStyle4;
                                                    final boolean z24 = zBooleanValue;
                                                    final boolean z25 = zIsWindowFocused;
                                                    final boolean z26 = zBooleanValue2;
                                                    final TransformedTextFieldState transformedTextFieldState6 = transformedTextFieldState5;
                                                    final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState3;
                                                    final Brush brush4 = brush3;
                                                    final boolean z27 = z23;
                                                    final boolean z28 = z22;
                                                    final ScrollState scrollState4 = scrollState3;
                                                    final Orientation orientation3 = orientation2;
                                                    final boolean z29 = zAreEqual;
                                                    final Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function24;
                                                    textFieldDecorator6.Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1.1
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

                                                        /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
                                                        /* JADX WARN: Removed duplicated region for block: B:56:0x015d  */
                                                        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                        @Composable
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final void invoke(@Nullable Composer composer4, int i37) {
                                                            int minHeightInLines;
                                                            int maxHeightInLines;
                                                            ComposeUiNode.Companion companion3;
                                                            if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1969169726, i37, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:346)");
                                                            }
                                                            TextFieldLineLimits textFieldLineLimits6 = textFieldLineLimits5;
                                                            if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                                                minHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                                                maxHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits5).getMaxHeightInLines();
                                                            } else {
                                                                minHeightInLines = 1;
                                                                maxHeightInLines = 1;
                                                            }
                                                            Modifier.Companion companion4 = Modifier.INSTANCE;
                                                            Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m15887heightInVpY3zN4$default(companion4, textLayoutState4.m16384getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle5, minHeightInLines, maxHeightInLines), textStyle5)).then(new TextFieldCoreModifier(z24 && z25, z26, textLayoutState4, transformedTextFieldState6, textFieldSelectionState4, brush4, z27 && !z28, scrollState4, orientation3));
                                                            TextLayoutState textLayoutState5 = textLayoutState4;
                                                            TransformedTextFieldState transformedTextFieldState7 = transformedTextFieldState6;
                                                            TextStyle textStyle6 = textStyle5;
                                                            boolean z30 = z29;
                                                            Function2<Density, Function0<TextLayoutResult>, Unit> function26 = function25;
                                                            boolean z31 = z27;
                                                            boolean z32 = z24;
                                                            boolean z33 = z25;
                                                            TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState4;
                                                            boolean z34 = z28;
                                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierThen);
                                                            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                            Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                                            if (composer4.getApplier() == null) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer4.startReusableNode();
                                                            if (composer4.getInserting()) {
                                                                composer4.createNode(constructor2);
                                                            } else {
                                                                composer4.useNode();
                                                            }
                                                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                                            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl2, currentCompositionLocalMap2);
                                                            if (!composerM18018constructorimpl2.getInserting()) {
                                                                companion3 = companion5;
                                                                if (!Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                }
                                                                Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                                BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                                if (!z31 && z32 && z33 && textFieldSelectionState5.isInTouchMode()) {
                                                                    composer4.startReplaceGroup(-1325530694);
                                                                    BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState5, composer4, 0);
                                                                    if (z34) {
                                                                        composer4.startReplaceGroup(-1325177728);
                                                                        composer4.endReplaceGroup();
                                                                    } else {
                                                                        composer4.startReplaceGroup(-1325351669);
                                                                        BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState5, composer4, 0);
                                                                        composer4.endReplaceGroup();
                                                                    }
                                                                    composer4.endReplaceGroup();
                                                                } else {
                                                                    composer4.startReplaceGroup(-1325155904);
                                                                    composer4.endReplaceGroup();
                                                                }
                                                                composer4.endNode();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    return;
                                                                }
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            companion3 = companion5;
                                                            AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                                                            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                                                            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                                            BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                            if (!z31) {
                                                                composer4.startReplaceGroup(-1325155904);
                                                                composer4.endReplaceGroup();
                                                            }
                                                            composer4.endNode();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                        }
                                                    }, composer3, 54), composer3, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 3) & 112) | 384);
                                            composerStartRestartGroup.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            InputTransformation inputTransformation5 = inputTransformation2;
                                            textFieldDecorator3 = textFieldDecorator5;
                                            inputTransformation3 = inputTransformation5;
                                            composer2 = composerStartRestartGroup;
                                            z14 = z12;
                                            keyboardOptions3 = keyboardOptions6;
                                            textStyle3 = textStyle2;
                                            z15 = z4;
                                            modifier3 = modifier2;
                                            function23 = function22;
                                            mutableInteractionSource4 = mutableInteractionSource2;
                                            brush2 = cursorBrush;
                                            codepointTransformation4 = codepointTransformation2;
                                            scrollState2 = scrollStateRememberScrollState;
                                            z16 = z20;
                                            keyboardActionHandler4 = keyboardActionHandler3;
                                            outputTransformation3 = outputTransformation6;
                                            textFieldLineLimits3 = textFieldLineLimits4;
                                        }
                                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        final boolean z222 = z12;
                                        final TextStyle textStyle42 = textStyle2;
                                        final boolean z232 = z4;
                                        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function242 = function22;
                                        final Brush brush32 = cursorBrush;
                                        final TextFieldDecorator textFieldDecorator52 = textFieldDecorator2;
                                        final ScrollState scrollState32 = scrollStateRememberScrollState;
                                        final TextLayoutState textLayoutState32 = textLayoutState2;
                                        ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState3, z4, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
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
                                            public final void invoke(@Nullable Composer composer3, int i36) {
                                                if ((i36 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-673241599, i36, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:344)");
                                                }
                                                TextFieldDecorator textFieldDecorator6 = textFieldDecorator52;
                                                if (textFieldDecorator6 == null) {
                                                    textFieldDecorator6 = BasicTextFieldKt.DefaultTextFieldDecorator;
                                                }
                                                final TextFieldLineLimits textFieldLineLimits5 = textFieldLineLimits4;
                                                final TextLayoutState textLayoutState4 = textLayoutState32;
                                                final TextStyle textStyle5 = textStyle42;
                                                final boolean z24 = zBooleanValue;
                                                final boolean z25 = zIsWindowFocused;
                                                final boolean z26 = zBooleanValue2;
                                                final TransformedTextFieldState transformedTextFieldState6 = transformedTextFieldState5;
                                                final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState3;
                                                final Brush brush4 = brush32;
                                                final boolean z27 = z232;
                                                final boolean z28 = z222;
                                                final ScrollState scrollState4 = scrollState32;
                                                final Orientation orientation3 = orientation2;
                                                final boolean z29 = zAreEqual;
                                                final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25 = function242;
                                                textFieldDecorator6.Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1.1
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

                                                    /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
                                                    /* JADX WARN: Removed duplicated region for block: B:56:0x015d  */
                                                    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final void invoke(@Nullable Composer composer4, int i37) {
                                                        int minHeightInLines;
                                                        int maxHeightInLines;
                                                        ComposeUiNode.Companion companion3;
                                                        if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1969169726, i37, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:346)");
                                                        }
                                                        TextFieldLineLimits textFieldLineLimits6 = textFieldLineLimits5;
                                                        if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                                            minHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                                            maxHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits5).getMaxHeightInLines();
                                                        } else {
                                                            minHeightInLines = 1;
                                                            maxHeightInLines = 1;
                                                        }
                                                        Modifier.Companion companion4 = Modifier.INSTANCE;
                                                        Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m15887heightInVpY3zN4$default(companion4, textLayoutState4.m16384getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle5, minHeightInLines, maxHeightInLines), textStyle5)).then(new TextFieldCoreModifier(z24 && z25, z26, textLayoutState4, transformedTextFieldState6, textFieldSelectionState4, brush4, z27 && !z28, scrollState4, orientation3));
                                                        TextLayoutState textLayoutState5 = textLayoutState4;
                                                        TransformedTextFieldState transformedTextFieldState7 = transformedTextFieldState6;
                                                        TextStyle textStyle6 = textStyle5;
                                                        boolean z30 = z29;
                                                        Function2<Density, Function0<TextLayoutResult>, Unit> function26 = function25;
                                                        boolean z31 = z27;
                                                        boolean z32 = z24;
                                                        boolean z33 = z25;
                                                        TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState4;
                                                        boolean z34 = z28;
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierThen);
                                                        ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                                                        if (composer4.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor2);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                                        Function2 function2M1177w2 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl2, currentCompositionLocalMap2);
                                                        if (!composerM18018constructorimpl2.getInserting()) {
                                                            companion3 = companion5;
                                                            if (!Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            }
                                                            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                                                            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                                            BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                            if (!z31 && z32 && z33 && textFieldSelectionState5.isInTouchMode()) {
                                                                composer4.startReplaceGroup(-1325530694);
                                                                BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState5, composer4, 0);
                                                                if (z34) {
                                                                    composer4.startReplaceGroup(-1325177728);
                                                                    composer4.endReplaceGroup();
                                                                } else {
                                                                    composer4.startReplaceGroup(-1325351669);
                                                                    BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState5, composer4, 0);
                                                                    composer4.endReplaceGroup();
                                                                }
                                                                composer4.endReplaceGroup();
                                                            } else {
                                                                composer4.startReplaceGroup(-1325155904);
                                                                composer4.endReplaceGroup();
                                                            }
                                                            composer4.endNode();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                return;
                                                            }
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        companion3 = companion5;
                                                        AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                                                        Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                                                        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                                                        BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                        if (!z31) {
                                                            composer4.startReplaceGroup(-1325155904);
                                                            composer4.endReplaceGroup();
                                                        }
                                                        composer4.endNode();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                        }
                                                    }
                                                }, composer3, 54), composer3, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 3) & 112) | 384);
                                        composerStartRestartGroup.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        InputTransformation inputTransformation52 = inputTransformation2;
                                        textFieldDecorator3 = textFieldDecorator52;
                                        inputTransformation3 = inputTransformation52;
                                        composer2 = composerStartRestartGroup;
                                        z14 = z12;
                                        keyboardOptions3 = keyboardOptions6;
                                        textStyle3 = textStyle2;
                                        z15 = z4;
                                        modifier3 = modifier2;
                                        function23 = function22;
                                        mutableInteractionSource4 = mutableInteractionSource2;
                                        brush2 = cursorBrush;
                                        codepointTransformation4 = codepointTransformation2;
                                        scrollState2 = scrollStateRememberScrollState;
                                        z16 = z20;
                                        keyboardActionHandler4 = keyboardActionHandler3;
                                        outputTransformation3 = outputTransformation6;
                                        textFieldLineLimits3 = textFieldLineLimits4;
                                    }
                                    final Orientation orientation22 = orientation;
                                    Modifier modifierPointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(modifierFocusable, scrollStateRememberScrollState, orientation22, z21, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection, orientation, false), null, mutableInteractionSource5, 16, null), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerHoverIcon$default2);
                                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                                    if (composerStartRestartGroup.getApplier() == null) {
                                    }
                                    composerStartRestartGroup.startReusableNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                    }
                                    composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                    Function2 function2M1177w2 = AbstractC0622a.m1177w(companion22, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
                                    if (composerM18018constructorimpl.getInserting()) {
                                    }
                                    AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl, currentCompositeKeyHash2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion.getSetModifier());
                                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                    final boolean z2222 = z12;
                                    final TextStyle textStyle422 = textStyle2;
                                    final boolean z2322 = z4;
                                    final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2422 = function22;
                                    final Brush brush322 = cursorBrush;
                                    final TextFieldDecorator textFieldDecorator522 = textFieldDecorator2;
                                    final ScrollState scrollState322 = scrollStateRememberScrollState;
                                    final TextLayoutState textLayoutState322 = textLayoutState2;
                                    ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState3, z4, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
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
                                        public final void invoke(@Nullable Composer composer3, int i36) {
                                            if ((i36 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-673241599, i36, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:344)");
                                            }
                                            TextFieldDecorator textFieldDecorator6 = textFieldDecorator522;
                                            if (textFieldDecorator6 == null) {
                                                textFieldDecorator6 = BasicTextFieldKt.DefaultTextFieldDecorator;
                                            }
                                            final TextFieldLineLimits textFieldLineLimits5 = textFieldLineLimits4;
                                            final TextLayoutState textLayoutState4 = textLayoutState322;
                                            final TextStyle textStyle5 = textStyle422;
                                            final boolean z24 = zBooleanValue;
                                            final boolean z25 = zIsWindowFocused;
                                            final boolean z26 = zBooleanValue2;
                                            final TransformedTextFieldState transformedTextFieldState6 = transformedTextFieldState5;
                                            final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState3;
                                            final Brush brush4 = brush322;
                                            final boolean z27 = z2322;
                                            final boolean z28 = z2222;
                                            final ScrollState scrollState4 = scrollState322;
                                            final Orientation orientation3 = orientation22;
                                            final boolean z29 = zAreEqual;
                                            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25 = function2422;
                                            textFieldDecorator6.Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1.1
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

                                                /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
                                                /* JADX WARN: Removed duplicated region for block: B:56:0x015d  */
                                                /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final void invoke(@Nullable Composer composer4, int i37) {
                                                    int minHeightInLines;
                                                    int maxHeightInLines;
                                                    ComposeUiNode.Companion companion3;
                                                    if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1969169726, i37, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:346)");
                                                    }
                                                    TextFieldLineLimits textFieldLineLimits6 = textFieldLineLimits5;
                                                    if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                                        minHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                                        maxHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits5).getMaxHeightInLines();
                                                    } else {
                                                        minHeightInLines = 1;
                                                        maxHeightInLines = 1;
                                                    }
                                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                                    Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m15887heightInVpY3zN4$default(companion4, textLayoutState4.m16384getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle5, minHeightInLines, maxHeightInLines), textStyle5)).then(new TextFieldCoreModifier(z24 && z25, z26, textLayoutState4, transformedTextFieldState6, textFieldSelectionState4, brush4, z27 && !z28, scrollState4, orientation3));
                                                    TextLayoutState textLayoutState5 = textLayoutState4;
                                                    TransformedTextFieldState transformedTextFieldState7 = transformedTextFieldState6;
                                                    TextStyle textStyle6 = textStyle5;
                                                    boolean z30 = z29;
                                                    Function2<Density, Function0<TextLayoutResult>, Unit> function26 = function25;
                                                    boolean z31 = z27;
                                                    boolean z32 = z24;
                                                    boolean z33 = z25;
                                                    TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState4;
                                                    boolean z34 = z28;
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                    int currentCompositeKeyHash22 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap22 = composer4.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer4, modifierThen);
                                                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor22 = companion5.getConstructor();
                                                    if (composer4.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor22);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                                    Function2 function2M1177w22 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy22, composerM18018constructorimpl2, currentCompositionLocalMap22);
                                                    if (!composerM18018constructorimpl2.getInserting()) {
                                                        companion3 = companion5;
                                                        if (!Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash22))) {
                                                        }
                                                        Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier22, companion3.getSetModifier());
                                                        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                                                        BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                        if (!z31 && z32 && z33 && textFieldSelectionState5.isInTouchMode()) {
                                                            composer4.startReplaceGroup(-1325530694);
                                                            BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState5, composer4, 0);
                                                            if (z34) {
                                                                composer4.startReplaceGroup(-1325177728);
                                                                composer4.endReplaceGroup();
                                                            } else {
                                                                composer4.startReplaceGroup(-1325351669);
                                                                BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState5, composer4, 0);
                                                                composer4.endReplaceGroup();
                                                            }
                                                            composer4.endReplaceGroup();
                                                        } else {
                                                            composer4.startReplaceGroup(-1325155904);
                                                            composer4.endReplaceGroup();
                                                        }
                                                        composer4.endNode();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            return;
                                                        }
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    companion3 = companion5;
                                                    AbstractC0622a.m1178x(currentCompositeKeyHash22, function2M1177w22, composerM18018constructorimpl2, currentCompositeKeyHash22);
                                                    Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier22, companion3.getSetModifier());
                                                    BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                                                    BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                    if (!z31) {
                                                        composer4.startReplaceGroup(-1325155904);
                                                        composer4.endReplaceGroup();
                                                    }
                                                    composer4.endNode();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                }
                                            }, composer3, 54), composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 3) & 112) | 384);
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    InputTransformation inputTransformation522 = inputTransformation2;
                                    textFieldDecorator3 = textFieldDecorator522;
                                    inputTransformation3 = inputTransformation522;
                                    composer2 = composerStartRestartGroup;
                                    z14 = z12;
                                    keyboardOptions3 = keyboardOptions6;
                                    textStyle3 = textStyle2;
                                    z15 = z4;
                                    modifier3 = modifier2;
                                    function23 = function22;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    brush2 = cursorBrush;
                                    codepointTransformation4 = codepointTransformation2;
                                    scrollState2 = scrollStateRememberScrollState;
                                    z16 = z20;
                                    keyboardActionHandler4 = keyboardActionHandler3;
                                    outputTransformation3 = outputTransformation6;
                                    textFieldLineLimits3 = textFieldLineLimits4;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
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

                                        public final void invoke(@Nullable Composer composer3, int i36) {
                                            BasicTextFieldKt.BasicTextField(textFieldState, modifier3, z15, z14, inputTransformation3, textStyle3, keyboardOptions3, keyboardActionHandler4, textFieldLineLimits3, function23, mutableInteractionSource4, brush2, codepointTransformation4, outputTransformation3, textFieldDecorator3, scrollState2, z16, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i4);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i5 |= DriveFile.MODE_READ_WRITE;
                            i15 = i14;
                            i16 = i4 & 1024;
                            if (i16 != 0) {
                            }
                            i19 = i4 & 2048;
                            if (i19 != 0) {
                            }
                            int i322 = i18;
                            i21 = i4 & 4096;
                            if (i21 != 0) {
                            }
                            i23 = i4 & 8192;
                            if (i23 != 0) {
                            }
                            i25 = i4 & 16384;
                            if (i25 != 0) {
                            }
                            if ((i2 & 196608) == 0) {
                            }
                            i27 = i4 & 65536;
                            if (i27 != 0) {
                            }
                            int i352 = i26;
                            if ((i5 & 306783379) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) == 0) {
                                    if (i31 != 0) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    if (i7 != 0) {
                                    }
                                    if (i8 != 0) {
                                    }
                                    if (i9 != 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i11 == 0) {
                                    }
                                    if (i13 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if (i21 == 0) {
                                    }
                                    if (i23 == 0) {
                                    }
                                    if (i25 == 0) {
                                    }
                                    KeyboardOptions keyboardOptions52 = keyboardOptions4;
                                    if ((i4 & 32768) == 0) {
                                    }
                                    OutputTransformation outputTransformation52 = outputTransformation4;
                                    textFieldDecorator2 = textFieldDecorator4;
                                    outputTransformation2 = outputTransformation52;
                                    if (i27 == 0) {
                                    }
                                    keyboardOptions2 = keyboardOptions52;
                                    composerStartRestartGroup.endDefaults();
                                    KeyboardActionHandler keyboardActionHandler62 = keyboardActionHandler2;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    WindowInfo windowInfo2 = (WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                                    final boolean zAreEqual2 = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                                    if (mutableInteractionSource2 != null) {
                                    }
                                    if (!zAreEqual2) {
                                    }
                                    z7 = z5;
                                    zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, composerStartRestartGroup, 0).getValue().booleanValue();
                                    final boolean zBooleanValue22 = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource3, composerStartRestartGroup, 0).getValue().booleanValue();
                                    zIsWindowFocused = windowInfo2.isWindowFocused();
                                    MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                    z8 = ((i5 & 14) != 4) | ((i29 & 896) != 256) | ((i29 & 7168) != 2048);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!z8) {
                                        if (codepointTransformation2 != null) {
                                        }
                                        objRememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, codepointTransformation3, outputTransformation2);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        transformedTextFieldState = (TransformedTextFieldState) objRememberedValue;
                                        zChanged = composerStartRestartGroup.changed(transformedTextFieldState);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged) {
                                            objRememberedValue2 = new TextLayoutState();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            textLayoutState = (TextLayoutState) objRememberedValue2;
                                            zChanged2 = composerStartRestartGroup.changed(transformedTextFieldState);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (zChanged2) {
                                                if (zBooleanValue) {
                                                    boolean z172 = z4;
                                                    z9 = z6;
                                                    objRememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState, density, z172, z7, !zBooleanValue && zIsWindowFocused, z9);
                                                    textLayoutState2 = textLayoutState;
                                                    density2 = density;
                                                    z4 = z172;
                                                    z10 = z7;
                                                    i30 = i29;
                                                    transformedTextFieldState2 = transformedTextFieldState;
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                    textFieldSelectionState = (TextFieldSelectionState) objRememberedValue3;
                                                    OutputTransformation outputTransformation62 = outputTransformation2;
                                                    hapticFeedback = (HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
                                                    z11 = z10;
                                                    clipboardManager = (ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
                                                    KeyboardOptions keyboardOptions62 = keyboardOptions2;
                                                    textToolbar = (TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
                                                    transformedTextFieldState3 = transformedTextFieldState2;
                                                    final TextFieldLineLimits textFieldLineLimits42 = textFieldLineLimits2;
                                                    zChanged3 = ((i5 & 896) != 256) | composerStartRestartGroup.changed(transformedTextFieldState2) | ((i5 & 57344) != 16384) | composerStartRestartGroup.changedInstance(textFieldSelectionState) | composerStartRestartGroup.changedInstance(hapticFeedback) | composerStartRestartGroup.changedInstance(clipboardManager) | composerStartRestartGroup.changedInstance(textToolbar) | composerStartRestartGroup.changed(density2) | ((i5 & 7168) != 2048) | ((i30 & 3670016) != 1048576);
                                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                    if (zChanged3) {
                                                        final boolean z182 = z9;
                                                        final Density density32 = density2;
                                                        final boolean z192 = z4;
                                                        final InputTransformation inputTransformation42 = inputTransformation2;
                                                        objRememberedValue4 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$2$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                                invoke2();
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2() {
                                                                transformedTextFieldState3.update(inputTransformation42);
                                                                textFieldSelectionState.update(hapticFeedback, clipboardManager, textToolbar, density32, z192, z11, z182);
                                                            }
                                                        };
                                                        transformedTextFieldState4 = transformedTextFieldState3;
                                                        textFieldSelectionState2 = textFieldSelectionState;
                                                        z12 = z11;
                                                        z13 = z182;
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                        EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
                                                        zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState2);
                                                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                        if (!zChangedInstance) {
                                                            objRememberedValue5 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                @NotNull
                                                                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                                    final TextFieldSelectionState textFieldSelectionState32 = textFieldSelectionState2;
                                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1$invoke$$inlined$onDispose$1
                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                        public void dispose() {
                                                                            textFieldSelectionState32.dispose();
                                                                        }
                                                                    };
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                                            EffectsKt.DisposableEffect(textFieldSelectionState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
                                                            final TransformedTextFieldState transformedTextFieldState52 = transformedTextFieldState4;
                                                            final TextFieldSelectionState textFieldSelectionState32 = textFieldSelectionState2;
                                                            boolean z202 = z13;
                                                            Modifier modifierFocusable2 = FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState52, textLayoutState2, textFieldSelectionState32, inputTransformation2, z4, z12, keyboardOptions62, keyboardActionHandler62, zAreEqual2, mutableInteractionSource52)), z4, mutableInteractionSource52);
                                                            if (z4) {
                                                            }
                                                            final Orientation orientation222 = orientation;
                                                            Modifier modifierPointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(modifierFocusable2, scrollStateRememberScrollState, orientation222, z21, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection2, orientation, false), null, mutableInteractionSource52, 16, null), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                            int currentCompositeKeyHash22 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                            CompositionLocalMap currentCompositionLocalMap22 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                            Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerHoverIcon$default22);
                                                            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                                                            Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
                                                            if (composerStartRestartGroup.getApplier() == null) {
                                                            }
                                                            composerStartRestartGroup.startReusableNode();
                                                            if (composerStartRestartGroup.getInserting()) {
                                                            }
                                                            composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                                            Function2 function2M1177w22 = AbstractC0622a.m1177w(companion222, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy22, composerM18018constructorimpl, currentCompositionLocalMap22);
                                                            if (composerM18018constructorimpl.getInserting()) {
                                                            }
                                                            AbstractC0622a.m1178x(currentCompositeKeyHash22, function2M1177w22, composerM18018constructorimpl, currentCompositeKeyHash22);
                                                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier22, companion.getSetModifier());
                                                            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                                                            final boolean z22222 = z12;
                                                            final TextStyle textStyle4222 = textStyle2;
                                                            final boolean z23222 = z4;
                                                            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24222 = function22;
                                                            final Brush brush3222 = cursorBrush;
                                                            final TextFieldDecorator textFieldDecorator5222 = textFieldDecorator2;
                                                            final ScrollState scrollState3222 = scrollStateRememberScrollState;
                                                            final TextLayoutState textLayoutState3222 = textLayoutState2;
                                                            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState32, z4, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
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
                                                                public final void invoke(@Nullable Composer composer3, int i36) {
                                                                    if ((i36 & 3) == 2 && composer3.getSkipping()) {
                                                                        composer3.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-673241599, i36, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:344)");
                                                                    }
                                                                    TextFieldDecorator textFieldDecorator6 = textFieldDecorator5222;
                                                                    if (textFieldDecorator6 == null) {
                                                                        textFieldDecorator6 = BasicTextFieldKt.DefaultTextFieldDecorator;
                                                                    }
                                                                    final TextFieldLineLimits textFieldLineLimits5 = textFieldLineLimits42;
                                                                    final TextLayoutState textLayoutState4 = textLayoutState3222;
                                                                    final TextStyle textStyle5 = textStyle4222;
                                                                    final boolean z24 = zBooleanValue;
                                                                    final boolean z25 = zIsWindowFocused;
                                                                    final boolean z26 = zBooleanValue22;
                                                                    final TransformedTextFieldState transformedTextFieldState6 = transformedTextFieldState52;
                                                                    final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState32;
                                                                    final Brush brush4 = brush3222;
                                                                    final boolean z27 = z23222;
                                                                    final boolean z28 = z22222;
                                                                    final ScrollState scrollState4 = scrollState3222;
                                                                    final Orientation orientation3 = orientation222;
                                                                    final boolean z29 = zAreEqual2;
                                                                    final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25 = function24222;
                                                                    textFieldDecorator6.Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1.1
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

                                                                        /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
                                                                        /* JADX WARN: Removed duplicated region for block: B:56:0x015d  */
                                                                        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                                        @Composable
                                                                        /*
                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                        */
                                                                        public final void invoke(@Nullable Composer composer4, int i37) {
                                                                            int minHeightInLines;
                                                                            int maxHeightInLines;
                                                                            ComposeUiNode.Companion companion3;
                                                                            if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                                                                composer4.skipToGroupEnd();
                                                                                return;
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1969169726, i37, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:346)");
                                                                            }
                                                                            TextFieldLineLimits textFieldLineLimits6 = textFieldLineLimits5;
                                                                            if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                                                                minHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                                                                maxHeightInLines = ((TextFieldLineLimits.MultiLine) textFieldLineLimits5).getMaxHeightInLines();
                                                                            } else {
                                                                                minHeightInLines = 1;
                                                                                maxHeightInLines = 1;
                                                                            }
                                                                            Modifier.Companion companion4 = Modifier.INSTANCE;
                                                                            Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m15887heightInVpY3zN4$default(companion4, textLayoutState4.m16384getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle5, minHeightInLines, maxHeightInLines), textStyle5)).then(new TextFieldCoreModifier(z24 && z25, z26, textLayoutState4, transformedTextFieldState6, textFieldSelectionState4, brush4, z27 && !z28, scrollState4, orientation3));
                                                                            TextLayoutState textLayoutState5 = textLayoutState4;
                                                                            TransformedTextFieldState transformedTextFieldState7 = transformedTextFieldState6;
                                                                            TextStyle textStyle6 = textStyle5;
                                                                            boolean z30 = z29;
                                                                            Function2<Density, Function0<TextLayoutResult>, Unit> function26 = function25;
                                                                            boolean z31 = z27;
                                                                            boolean z32 = z24;
                                                                            boolean z33 = z25;
                                                                            TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState4;
                                                                            boolean z34 = z28;
                                                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                                            int currentCompositeKeyHash222 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                            CompositionLocalMap currentCompositionLocalMap222 = composer4.getCurrentCompositionLocalMap();
                                                                            Modifier modifierMaterializeModifier222 = ComposedModifierKt.materializeModifier(composer4, modifierThen);
                                                                            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                                                                            Function0<ComposeUiNode> constructor222 = companion5.getConstructor();
                                                                            if (composer4.getApplier() == null) {
                                                                                ComposablesKt.invalidApplier();
                                                                            }
                                                                            composer4.startReusableNode();
                                                                            if (composer4.getInserting()) {
                                                                                composer4.createNode(constructor222);
                                                                            } else {
                                                                                composer4.useNode();
                                                                            }
                                                                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer4);
                                                                            Function2 function2M1177w222 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy222, composerM18018constructorimpl2, currentCompositionLocalMap222);
                                                                            if (!composerM18018constructorimpl2.getInserting()) {
                                                                                companion3 = companion5;
                                                                                if (!Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash222))) {
                                                                                }
                                                                                Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier222, companion3.getSetModifier());
                                                                                BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                                                                                BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                                                if (!z31 && z32 && z33 && textFieldSelectionState5.isInTouchMode()) {
                                                                                    composer4.startReplaceGroup(-1325530694);
                                                                                    BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState5, composer4, 0);
                                                                                    if (z34) {
                                                                                        composer4.startReplaceGroup(-1325177728);
                                                                                        composer4.endReplaceGroup();
                                                                                    } else {
                                                                                        composer4.startReplaceGroup(-1325351669);
                                                                                        BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState5, composer4, 0);
                                                                                        composer4.endReplaceGroup();
                                                                                    }
                                                                                    composer4.endReplaceGroup();
                                                                                } else {
                                                                                    composer4.startReplaceGroup(-1325155904);
                                                                                    composer4.endReplaceGroup();
                                                                                }
                                                                                composer4.endNode();
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    return;
                                                                                }
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            companion3 = companion5;
                                                                            AbstractC0622a.m1178x(currentCompositeKeyHash222, function2M1177w222, composerM18018constructorimpl2, currentCompositeKeyHash222);
                                                                            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier222, companion3.getSetModifier());
                                                                            BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
                                                                            BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(companion4, textLayoutState5.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState5, transformedTextFieldState7, textStyle6, z30, function26)), composer4, 0);
                                                                            if (!z31) {
                                                                                composer4.startReplaceGroup(-1325155904);
                                                                                composer4.endReplaceGroup();
                                                                            }
                                                                            composer4.endNode();
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                            }
                                                                        }
                                                                    }, composer3, 54), composer3, 6);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 3) & 112) | 384);
                                                            composerStartRestartGroup.endNode();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                            InputTransformation inputTransformation5222 = inputTransformation2;
                                                            textFieldDecorator3 = textFieldDecorator5222;
                                                            inputTransformation3 = inputTransformation5222;
                                                            composer2 = composerStartRestartGroup;
                                                            z14 = z12;
                                                            keyboardOptions3 = keyboardOptions62;
                                                            textStyle3 = textStyle2;
                                                            z15 = z4;
                                                            modifier3 = modifier2;
                                                            function23 = function22;
                                                            mutableInteractionSource4 = mutableInteractionSource2;
                                                            brush2 = cursorBrush;
                                                            codepointTransformation4 = codepointTransformation2;
                                                            scrollState2 = scrollStateRememberScrollState;
                                                            z16 = z202;
                                                            keyboardActionHandler4 = keyboardActionHandler3;
                                                            outputTransformation3 = outputTransformation62;
                                                            textFieldLineLimits3 = textFieldLineLimits42;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i4 & 512;
                        if (i14 != 0) {
                        }
                        i15 = i14;
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                        }
                        i19 = i4 & 2048;
                        if (i19 != 0) {
                        }
                        int i3222 = i18;
                        i21 = i4 & 4096;
                        if (i21 != 0) {
                        }
                        i23 = i4 & 8192;
                        if (i23 != 0) {
                        }
                        i25 = i4 & 16384;
                        if (i25 != 0) {
                        }
                        if ((i2 & 196608) == 0) {
                        }
                        i27 = i4 & 65536;
                        if (i27 != 0) {
                        }
                        int i3522 = i26;
                        if ((i5 & 306783379) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    inputTransformation2 = inputTransformation;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 != 0) {
                    }
                    int i32222 = i18;
                    i21 = i4 & 4096;
                    if (i21 != 0) {
                    }
                    i23 = i4 & 8192;
                    if (i23 != 0) {
                    }
                    i25 = i4 & 16384;
                    if (i25 != 0) {
                    }
                    if ((i2 & 196608) == 0) {
                    }
                    i27 = i4 & 65536;
                    if (i27 != 0) {
                    }
                    int i35222 = i26;
                    if ((i5 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                inputTransformation2 = inputTransformation;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                }
                int i322222 = i18;
                i21 = i4 & 4096;
                if (i21 != 0) {
                }
                i23 = i4 & 8192;
                if (i23 != 0) {
                }
                i25 = i4 & 16384;
                if (i25 != 0) {
                }
                if ((i2 & 196608) == 0) {
                }
                i27 = i4 & 65536;
                if (i27 != 0) {
                }
                int i352222 = i26;
                if ((i5 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z5 = z2;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            inputTransformation2 = inputTransformation;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
            }
            int i3222222 = i18;
            i21 = i4 & 4096;
            if (i21 != 0) {
            }
            i23 = i4 & 8192;
            if (i23 != 0) {
            }
            i25 = i4 & 16384;
            if (i25 != 0) {
            }
            if ((i2 & 196608) == 0) {
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
            }
            int i3522222 = i26;
            if ((i5 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z4 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z5 = z2;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        inputTransformation2 = inputTransformation;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
        }
        int i32222222 = i18;
        i21 = i4 & 4096;
        if (i21 != 0) {
        }
        i23 = i4 & 8192;
        if (i23 != 0) {
        }
        i25 = i4 & 16384;
        if (i25 != 0) {
        }
        if ((i2 & 196608) == 0) {
        }
        i27 = i4 & 65536;
        if (i27 != 0) {
        }
        int i35222222 = i26;
        if ((i5 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:277:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(@NotNull final String str, @NotNull final Function1<? super String, Unit> function1, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z3, int i, int i2, @Nullable VisualTransformation visualTransformation, @Nullable Function1<? super TextLayoutResult, Unit> function12, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Brush brush, @Nullable Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        int i10;
        TextStyle textStyle2;
        int i11;
        KeyboardOptions keyboardOptions2;
        int i12;
        KeyboardActions keyboardActions2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        VisualTransformation none;
        Function1<? super TextLayoutResult, Unit> function13;
        KeyboardActions keyboardActions3;
        boolean z6;
        Brush solidColor;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M16159getLambda1$foundation_release;
        int i28;
        int i29;
        KeyboardOptions keyboardOptions3;
        boolean z7;
        TextStyle textStyle3;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource2;
        KeyboardActions keyboardActions4;
        Brush brush2;
        boolean z8;
        Object objRememberedValue;
        Composer.Companion companion;
        int i30;
        final MutableState mutableState;
        final TextFieldValue textFieldValueM20698copy3r_uNRQ$default;
        boolean zChanged;
        Object objRememberedValue2;
        boolean z9;
        Object objRememberedValue3;
        final MutableState mutableState2;
        boolean zChanged2;
        Object objRememberedValue4;
        Composer composer2;
        final TextStyle textStyle4;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush3;
        final boolean z10;
        final boolean z11;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final KeyboardOptions keyboardOptions4;
        final boolean z12;
        final Modifier modifier4;
        final VisualTransformation visualTransformation2;
        final Function1<? super TextLayoutResult, Unit> function14;
        final KeyboardActions keyboardActions5;
        final int i31;
        final int i32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(945255183);
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i33 = i6 & 4;
        if (i33 != 0) {
            i7 |= 384;
        } else {
            if ((i4 & 384) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i4 & 3072) == 0) {
                    z4 = z;
                    i7 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else {
                    if ((i4 & 24576) == 0) {
                        z5 = z2;
                        i7 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i4 & 196608) == 0) {
                            i7 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i11 = i6 & 64;
                    if (i11 == 0) {
                        i7 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i4 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i12 = i6 & 128;
                    if (i12 == 0) {
                        i7 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i4 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i13 = i6 & 256;
                    if (i13 == 0) {
                        i7 |= 100663296;
                    } else if ((i4 & 100663296) == 0) {
                        i7 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
                        i7 |= ((i6 & 512) == 0 && composerStartRestartGroup.changed(i)) ? 536870912 : 268435456;
                    }
                    i14 = i6 & 1024;
                    if (i14 == 0) {
                        i16 = i5 | 6;
                        i15 = i14;
                    } else if ((i5 & 6) == 0) {
                        i15 = i14;
                        i16 = i5 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i15 = i14;
                        i16 = i5;
                    }
                    i17 = i6 & 2048;
                    if (i17 == 0) {
                        i16 |= 48;
                        i18 = i17;
                    } else if ((i5 & 48) == 0) {
                        i18 = i17;
                        i16 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                    } else {
                        i18 = i17;
                    }
                    int i34 = i16;
                    i19 = i6 & 4096;
                    if (i19 == 0) {
                        i20 = i34 | 384;
                    } else if ((i5 & 384) == 0) {
                        i20 = i34 | (composerStartRestartGroup.changedInstance(function12) ? 256 : 128);
                    } else {
                        i20 = i34;
                    }
                    i21 = i6 & 8192;
                    if (i21 == 0) {
                        i22 = i20 | 3072;
                    } else {
                        int i35 = i20;
                        if ((i5 & 3072) == 0) {
                            i22 = i35 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024);
                        } else {
                            i22 = i35;
                        }
                    }
                    i23 = i6 & 16384;
                    if (i23 != 0) {
                        i24 = i22;
                        if ((i5 & 24576) == 0) {
                            i24 |= composerStartRestartGroup.changed(brush) ? 16384 : 8192;
                        }
                        i25 = i6 & 32768;
                        if (i25 != 0) {
                            i24 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i24 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        i26 = i24;
                        if ((i7 & 306783379) == 306783378 && (74899 & i26) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i32 = i;
                            function32 = function3;
                            composer2 = composerStartRestartGroup;
                            keyboardActions5 = keyboardActions2;
                            z10 = z4;
                            keyboardOptions4 = keyboardOptions2;
                            z11 = z5;
                            textStyle4 = textStyle2;
                            modifier4 = modifier2;
                            z12 = z3;
                            i31 = i2;
                            visualTransformation2 = visualTransformation;
                            function14 = function12;
                            mutableInteractionSource3 = mutableInteractionSource;
                            brush3 = brush;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i4 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i6 & 512) != 0) {
                                    i7 &= -1879048193;
                                }
                                keyboardActions4 = keyboardActions2;
                                textStyle3 = textStyle2;
                                z8 = z3;
                                i28 = i;
                                i29 = i2;
                                none = visualTransformation;
                                function13 = function12;
                                function3M16159getLambda1$foundation_release = function3;
                                keyboardOptions3 = keyboardOptions2;
                                z7 = z5;
                                modifier3 = modifier2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                            } else {
                                if (i33 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i8 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i10 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i11 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                KeyboardActions keyboardActions6 = i12 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i13 == 0 ? false : z3;
                                if ((i6 & 512) == 0) {
                                    i27 = z13 ? 1 : Integer.MAX_VALUE;
                                    i7 &= -1879048193;
                                } else {
                                    i27 = i;
                                }
                                int i36 = i15 == 0 ? 1 : i2;
                                none = i18 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                function13 = i19 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                MutableInteractionSource mutableInteractionSource4 = i21 == 0 ? null : mutableInteractionSource;
                                if (i23 == 0) {
                                    z6 = z13;
                                    keyboardActions3 = keyboardActions6;
                                    solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
                                } else {
                                    keyboardActions3 = keyboardActions6;
                                    z6 = z13;
                                    solidColor = brush;
                                }
                                function3M16159getLambda1$foundation_release = i25 == 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m16159getLambda1$foundation_release() : function3;
                                i28 = i27;
                                i29 = i36;
                                keyboardOptions3 = keyboardOptions2;
                                z7 = z5;
                                textStyle3 = textStyle2;
                                modifier3 = modifier2;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                keyboardActions4 = keyboardActions3;
                                brush2 = solidColor;
                                z8 = z6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(945255183, i7, i26, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:610)");
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue != companion.getEmpty()) {
                                i30 = i28;
                                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                                objRememberedValue = mutableStateMutableStateOf$default;
                            } else {
                                i30 = i28;
                            }
                            mutableState = (MutableState) objRememberedValue;
                            textFieldValueM20698copy3r_uNRQ$default = TextFieldValue.m20698copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState), str, 0L, (TextRange) null, 6, (Object) null);
                            zChanged = composerStartRestartGroup.changed(textFieldValueM20698copy3r_uNRQ$default);
                            int i37 = i29;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            Modifier modifier5 = modifier3;
                            if (!zChanged || objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        if (TextRange.m20449equalsimpl0(textFieldValueM20698copy3r_uNRQ$default.getSelection(), BasicTextFieldKt.BasicTextField$lambda$21(mutableState).getSelection()) && Intrinsics.areEqual(textFieldValueM20698copy3r_uNRQ$default.getComposition(), BasicTextFieldKt.BasicTextField$lambda$21(mutableState).getComposition())) {
                                            return;
                                        }
                                        mutableState.setValue(textFieldValueM20698copy3r_uNRQ$default);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                            z9 = (i7 & 14) != 4;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z9 || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z8);
                            boolean z14 = !z8;
                            boolean z15 = z4;
                            Function1<? super TextLayoutResult, Unit> function15 = function13;
                            int i38 = !z8 ? 1 : i37;
                            int i39 = !z8 ? 1 : i30;
                            KeyboardOptions keyboardOptions5 = keyboardOptions3;
                            zChanged2 = composerStartRestartGroup.changed(mutableState2) | ((i7 & 112) != 32);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                                objRememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                        invoke2(textFieldValue);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextFieldValue textFieldValue) {
                                        mutableState.setValue(textFieldValue);
                                        boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.BasicTextField$lambda$25(mutableState2), textFieldValue.getText());
                                        mutableState2.setValue(textFieldValue.getText());
                                        if (zAreEqual) {
                                            return;
                                        }
                                        function1.invoke(textFieldValue.getText());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            int i40 = i26 << 9;
                            composer2 = composerStartRestartGroup;
                            CoreTextFieldKt.CoreTextField(textFieldValueM20698copy3r_uNRQ$default, (Function1) objRememberedValue4, modifier5, textStyle3, none, function15, mutableInteractionSource2, brush2, z14, i39, i38, imeOptions$foundation_release, keyboardActions4, z15, z7, function3M16159getLambda1$foundation_release, composer2, (i7 & 896) | ((i7 >> 6) & 7168) | (57344 & i40) | (458752 & i40) | (3670016 & i40) | (i40 & 29360128), ((i7 >> 15) & 896) | (i7 & 7168) | (i7 & 57344) | (i26 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            textStyle4 = textStyle3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            brush3 = brush2;
                            z10 = z15;
                            z11 = z7;
                            function32 = function3M16159getLambda1$foundation_release;
                            keyboardOptions4 = keyboardOptions5;
                            z12 = z8;
                            modifier4 = modifier5;
                            visualTransformation2 = none;
                            function14 = function15;
                            keyboardActions5 = keyboardActions4;
                            i31 = i37;
                            i32 = i30;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.9
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

                                public final void invoke(@Nullable Composer composer3, int i41) {
                                    BasicTextFieldKt.BasicTextField(str, function1, modifier4, z10, z11, textStyle4, keyboardOptions4, keyboardActions5, z12, i32, i31, visualTransformation2, function14, mutableInteractionSource3, brush3, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i24 = i22 | 24576;
                    i25 = i6 & 32768;
                    if (i25 != 0) {
                    }
                    i26 = i24;
                    if ((i7 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i4 & 1) == 0) {
                            if (i33 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if ((i6 & 512) == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if (i25 == 0) {
                            }
                            i28 = i27;
                            i29 = i36;
                            keyboardOptions3 = keyboardOptions2;
                            z7 = z5;
                            textStyle3 = textStyle2;
                            modifier3 = modifier2;
                            mutableInteractionSource2 = mutableInteractionSource4;
                            keyboardActions4 = keyboardActions3;
                            brush2 = solidColor;
                            z8 = z6;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue != companion.getEmpty()) {
                            }
                            mutableState = (MutableState) objRememberedValue;
                            textFieldValueM20698copy3r_uNRQ$default = TextFieldValue.m20698copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState), str, 0L, (TextRange) null, 6, (Object) null);
                            zChanged = composerStartRestartGroup.changed(textFieldValueM20698copy3r_uNRQ$default);
                            int i372 = i29;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            Modifier modifier52 = modifier3;
                            if (!zChanged) {
                                objRememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        if (TextRange.m20449equalsimpl0(textFieldValueM20698copy3r_uNRQ$default.getSelection(), BasicTextFieldKt.BasicTextField$lambda$21(mutableState).getSelection()) && Intrinsics.areEqual(textFieldValueM20698copy3r_uNRQ$default.getComposition(), BasicTextFieldKt.BasicTextField$lambda$21(mutableState).getComposition())) {
                                            return;
                                        }
                                        mutableState.setValue(textFieldValueM20698copy3r_uNRQ$default);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                                if ((i7 & 14) != 4) {
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z9) {
                                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    mutableState2 = (MutableState) objRememberedValue3;
                                    ImeOptions imeOptions$foundation_release2 = keyboardOptions3.toImeOptions$foundation_release(z8);
                                    boolean z142 = !z8;
                                    boolean z152 = z4;
                                    Function1<? super TextLayoutResult, Unit> function152 = function13;
                                    if (!z8) {
                                    }
                                    if (!z8) {
                                    }
                                    KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                    zChanged2 = composerStartRestartGroup.changed(mutableState2) | ((i7 & 112) != 32);
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged2) {
                                        objRememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                                invoke2(textFieldValue);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull TextFieldValue textFieldValue) {
                                                mutableState.setValue(textFieldValue);
                                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.BasicTextField$lambda$25(mutableState2), textFieldValue.getText());
                                                mutableState2.setValue(textFieldValue.getText());
                                                if (zAreEqual) {
                                                    return;
                                                }
                                                function1.invoke(textFieldValue.getText());
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                        int i402 = i26 << 9;
                                        composer2 = composerStartRestartGroup;
                                        CoreTextFieldKt.CoreTextField(textFieldValueM20698copy3r_uNRQ$default, (Function1) objRememberedValue4, modifier52, textStyle3, none, function152, mutableInteractionSource2, brush2, z142, i39, i38, imeOptions$foundation_release2, keyboardActions4, z152, z7, function3M16159getLambda1$foundation_release, composer2, (i7 & 896) | ((i7 >> 6) & 7168) | (57344 & i402) | (458752 & i402) | (3670016 & i402) | (i402 & 29360128), ((i7 >> 15) & 896) | (i7 & 7168) | (i7 & 57344) | (i26 & 458752), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle4 = textStyle3;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        brush3 = brush2;
                                        z10 = z152;
                                        z11 = z7;
                                        function32 = function3M16159getLambda1$foundation_release;
                                        keyboardOptions4 = keyboardOptions52;
                                        z12 = z8;
                                        modifier4 = modifier52;
                                        visualTransformation2 = none;
                                        function14 = function152;
                                        keyboardActions5 = keyboardActions4;
                                        i31 = i372;
                                        i32 = i30;
                                    }
                                }
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                i11 = i6 & 64;
                if (i11 == 0) {
                }
                i12 = i6 & 128;
                if (i12 == 0) {
                }
                i13 = i6 & 256;
                if (i13 == 0) {
                }
                if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
                }
                i14 = i6 & 1024;
                if (i14 == 0) {
                }
                i17 = i6 & 2048;
                if (i17 == 0) {
                }
                int i342 = i16;
                i19 = i6 & 4096;
                if (i19 == 0) {
                }
                i21 = i6 & 8192;
                if (i21 == 0) {
                }
                i23 = i6 & 16384;
                if (i23 != 0) {
                }
                i25 = i6 & 32768;
                if (i25 != 0) {
                }
                i26 = i24;
                if ((i7 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z5 = z2;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            i11 = i6 & 64;
            if (i11 == 0) {
            }
            i12 = i6 & 128;
            if (i12 == 0) {
            }
            i13 = i6 & 256;
            if (i13 == 0) {
            }
            if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
            }
            i14 = i6 & 1024;
            if (i14 == 0) {
            }
            i17 = i6 & 2048;
            if (i17 == 0) {
            }
            int i3422 = i16;
            i19 = i6 & 4096;
            if (i19 == 0) {
            }
            i21 = i6 & 8192;
            if (i21 == 0) {
            }
            i23 = i6 & 16384;
            if (i23 != 0) {
            }
            i25 = i6 & 32768;
            if (i25 != 0) {
            }
            i26 = i24;
            if ((i7 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z4 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z5 = z2;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        i11 = i6 & 64;
        if (i11 == 0) {
        }
        i12 = i6 & 128;
        if (i12 == 0) {
        }
        i13 = i6 & 256;
        if (i13 == 0) {
        }
        if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
        }
        i14 = i6 & 1024;
        if (i14 == 0) {
        }
        i17 = i6 & 2048;
        if (i17 == 0) {
        }
        int i34222 = i16;
        i19 = i6 & 4096;
        if (i19 == 0) {
        }
        i21 = i6 & 8192;
        if (i21 == 0) {
        }
        i23 = i6 & 16384;
        if (i23 != 0) {
        }
        i25 = i6 & 32768;
        if (i25 != 0) {
        }
        i26 = i24;
        if ((i7 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(@NotNull final TextFieldValue textFieldValue, @NotNull final Function1<? super TextFieldValue, Unit> function1, @Nullable Modifier modifier, boolean z, boolean z2, @Nullable TextStyle textStyle, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActions keyboardActions, boolean z3, int i, int i2, @Nullable VisualTransformation visualTransformation, @Nullable Function1<? super TextLayoutResult, Unit> function12, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Brush brush, @Nullable Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        int i10;
        TextStyle textStyle2;
        int i11;
        KeyboardOptions keyboardOptions2;
        int i12;
        KeyboardActions keyboardActions2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        VisualTransformation none;
        Function1<? super TextLayoutResult, Unit> function13;
        MutableInteractionSource mutableInteractionSource2;
        KeyboardActions keyboardActions3;
        int i27;
        Brush solidColor;
        Brush brush2;
        boolean z6;
        int i28;
        int i29;
        TextStyle textStyle3;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions4;
        int i30;
        boolean z7;
        boolean z8;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M16160getLambda2$foundation_release;
        boolean z9;
        Object objRememberedValue;
        final KeyboardActions keyboardActions5;
        Composer composer2;
        final int i31;
        final int i32;
        final boolean z10;
        final VisualTransformation visualTransformation2;
        final boolean z11;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final Function1<? super TextLayoutResult, Unit> function14;
        final Brush brush3;
        final boolean z12;
        final KeyboardOptions keyboardOptions4;
        final MutableInteractionSource mutableInteractionSource3;
        final TextStyle textStyle4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1804514146);
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i33 = i6 & 4;
        if (i33 != 0) {
            i7 |= 384;
        } else {
            if ((i4 & 384) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i4 & 3072) == 0) {
                    z4 = z;
                    i7 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else {
                    if ((i4 & 24576) == 0) {
                        z5 = z2;
                        i7 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i4 & 196608) == 0) {
                            i7 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i11 = i6 & 64;
                    if (i11 == 0) {
                        i7 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i4 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i12 = i6 & 128;
                    if (i12 == 0) {
                        i7 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i4 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i13 = i6 & 256;
                    if (i13 == 0) {
                        i7 |= 100663296;
                    } else if ((i4 & 100663296) == 0) {
                        i7 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
                        i7 |= ((i6 & 512) == 0 && composerStartRestartGroup.changed(i)) ? 536870912 : 268435456;
                    }
                    i14 = i6 & 1024;
                    if (i14 == 0) {
                        i16 = i5 | 6;
                        i15 = i14;
                    } else if ((i5 & 6) == 0) {
                        i15 = i14;
                        i16 = i5 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i15 = i14;
                        i16 = i5;
                    }
                    i17 = i6 & 2048;
                    if (i17 == 0) {
                        i16 |= 48;
                        i18 = i17;
                    } else if ((i5 & 48) == 0) {
                        i18 = i17;
                        i16 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                    } else {
                        i18 = i17;
                    }
                    int i34 = i16;
                    i19 = i6 & 4096;
                    if (i19 == 0) {
                        i20 = i34 | 384;
                    } else if ((i5 & 384) == 0) {
                        i20 = i34 | (composerStartRestartGroup.changedInstance(function12) ? 256 : 128);
                    } else {
                        i20 = i34;
                    }
                    i21 = i6 & 8192;
                    if (i21 == 0) {
                        i22 = i20 | 3072;
                    } else {
                        int i35 = i20;
                        if ((i5 & 3072) == 0) {
                            i22 = i35 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024);
                        } else {
                            i22 = i35;
                        }
                    }
                    i23 = i6 & 16384;
                    if (i23 != 0) {
                        i24 = i22;
                        if ((i5 & 24576) == 0) {
                            i24 |= composerStartRestartGroup.changed(brush) ? 16384 : 8192;
                        }
                        i25 = i6 & 32768;
                        if (i25 != 0) {
                            i24 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i24 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        int i36 = i24;
                        if ((i7 & 306783379) == 306783378 && (74899 & i36) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i31 = i;
                            visualTransformation2 = visualTransformation;
                            function32 = function3;
                            composer2 = composerStartRestartGroup;
                            z11 = z4;
                            keyboardActions5 = keyboardActions2;
                            z12 = z5;
                            textStyle4 = textStyle2;
                            keyboardOptions4 = keyboardOptions2;
                            modifier3 = modifier2;
                            z10 = z3;
                            i32 = i2;
                            function14 = function12;
                            mutableInteractionSource3 = mutableInteractionSource;
                            brush3 = brush;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i4 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i6 & 512) != 0) {
                                    i7 &= -1879048193;
                                }
                                z6 = z3;
                                i28 = i;
                                i29 = i2;
                                none = visualTransformation;
                                function13 = function12;
                                mutableInteractionSource2 = mutableInteractionSource;
                                keyboardActions4 = keyboardActions2;
                                textStyle3 = textStyle2;
                                keyboardOptions3 = keyboardOptions2;
                                i30 = i7;
                                z7 = z4;
                                z8 = z5;
                                brush2 = brush;
                            } else {
                                if (i33 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i8 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i10 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i11 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                KeyboardActions keyboardActions6 = i12 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i13 == 0 ? false : z3;
                                if ((i6 & 512) == 0) {
                                    i26 = z13 ? 1 : Integer.MAX_VALUE;
                                    i7 &= -1879048193;
                                } else {
                                    i26 = i;
                                }
                                int i37 = i15 == 0 ? 1 : i2;
                                none = i18 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                function13 = i19 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                mutableInteractionSource2 = i21 == 0 ? null : mutableInteractionSource;
                                if (i23 == 0) {
                                    keyboardActions3 = keyboardActions6;
                                    i27 = i7;
                                    solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
                                } else {
                                    keyboardActions3 = keyboardActions6;
                                    i27 = i7;
                                    solidColor = brush;
                                }
                                if (i25 == 0) {
                                    boolean z14 = z4;
                                    function3M16160getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m16160getLambda2$foundation_release();
                                    textStyle3 = textStyle2;
                                    z7 = z14;
                                    brush2 = solidColor;
                                    z6 = z13;
                                    i28 = i26;
                                    i29 = i37;
                                    keyboardOptions3 = keyboardOptions2;
                                    keyboardActions4 = keyboardActions3;
                                    i30 = i27;
                                    z8 = z5;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1804514146, i30, i36, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:762)");
                                    }
                                    ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z6);
                                    Modifier modifier4 = modifier2;
                                    Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = function3M16160getLambda2$foundation_release;
                                    boolean z15 = !z6;
                                    int i38 = !z6 ? 1 : i29;
                                    int i39 = !z6 ? 1 : i28;
                                    TextStyle textStyle5 = textStyle3;
                                    z9 = ((i30 & 14) != 4) | ((i30 & 112) == 32);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!z9 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$11$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                                                invoke2(textFieldValue2);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull TextFieldValue textFieldValue2) {
                                                if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
                                                    return;
                                                }
                                                function1.invoke(textFieldValue2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    int i40 = i36 << 9;
                                    int i41 = ((i30 >> 6) & 7168) | (i30 & SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK) | (i40 & 57344) | (i40 & 458752) | (i40 & 3670016) | (i40 & 29360128);
                                    int i42 = (i30 & 7168) | ((i30 >> 15) & 896) | (57344 & i30) | (i36 & 458752);
                                    boolean z16 = z6;
                                    Function1<? super TextLayoutResult, Unit> function15 = function13;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    VisualTransformation visualTransformation3 = none;
                                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) objRememberedValue, modifier4, textStyle5, visualTransformation3, function15, mutableInteractionSource4, brush2, z15, i39, i38, imeOptions$foundation_release, keyboardActions4, z7, z8, function33, composerStartRestartGroup, i41, i42, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    keyboardActions5 = keyboardActions4;
                                    composer2 = composerStartRestartGroup;
                                    i31 = i28;
                                    i32 = i29;
                                    z10 = z16;
                                    visualTransformation2 = visualTransformation3;
                                    z11 = z7;
                                    function32 = function33;
                                    function14 = function15;
                                    brush3 = brush2;
                                    z12 = z8;
                                    keyboardOptions4 = keyboardOptions5;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    textStyle4 = textStyle5;
                                    modifier3 = modifier4;
                                } else {
                                    brush2 = solidColor;
                                    z6 = z13;
                                    i28 = i26;
                                    i29 = i37;
                                    textStyle3 = textStyle2;
                                    keyboardOptions3 = keyboardOptions2;
                                    keyboardActions4 = keyboardActions3;
                                    i30 = i27;
                                    z7 = z4;
                                    z8 = z5;
                                }
                            }
                            function3M16160getLambda2$foundation_release = function3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ImeOptions imeOptions$foundation_release2 = keyboardOptions3.toImeOptions$foundation_release(z6);
                            Modifier modifier42 = modifier2;
                            Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function332 = function3M16160getLambda2$foundation_release;
                            boolean z152 = !z6;
                            if (!z6) {
                            }
                            if (!z6) {
                            }
                            TextStyle textStyle52 = textStyle3;
                            z9 = ((i30 & 14) != 4) | ((i30 & 112) == 32);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z9) {
                                objRememberedValue = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$11$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                                        invoke2(textFieldValue2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextFieldValue textFieldValue2) {
                                        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
                                            return;
                                        }
                                        function1.invoke(textFieldValue2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                int i402 = i36 << 9;
                                int i412 = ((i30 >> 6) & 7168) | (i30 & SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK) | (i402 & 57344) | (i402 & 458752) | (i402 & 3670016) | (i402 & 29360128);
                                int i422 = (i30 & 7168) | ((i30 >> 15) & 896) | (57344 & i30) | (i36 & 458752);
                                boolean z162 = z6;
                                Function1<? super TextLayoutResult, Unit> function152 = function13;
                                KeyboardOptions keyboardOptions52 = keyboardOptions3;
                                VisualTransformation visualTransformation32 = none;
                                MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) objRememberedValue, modifier42, textStyle52, visualTransformation32, function152, mutableInteractionSource42, brush2, z152, i39, i38, imeOptions$foundation_release2, keyboardActions4, z7, z8, function332, composerStartRestartGroup, i412, i422, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                keyboardActions5 = keyboardActions4;
                                composer2 = composerStartRestartGroup;
                                i31 = i28;
                                i32 = i29;
                                z10 = z162;
                                visualTransformation2 = visualTransformation32;
                                z11 = z7;
                                function32 = function332;
                                function14 = function152;
                                brush3 = brush2;
                                z12 = z8;
                                keyboardOptions4 = keyboardOptions52;
                                mutableInteractionSource3 = mutableInteractionSource42;
                                textStyle4 = textStyle52;
                                modifier3 = modifier42;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.12
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

                                public final void invoke(@Nullable Composer composer3, int i43) {
                                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifier3, z11, z12, textStyle4, keyboardOptions4, keyboardActions5, z10, i31, i32, visualTransformation2, function14, mutableInteractionSource3, brush3, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i24 = i22 | 24576;
                    i25 = i6 & 32768;
                    if (i25 != 0) {
                    }
                    int i362 = i24;
                    if ((i7 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i4 & 1) == 0) {
                            if (i33 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if ((i6 & 512) == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if (i25 == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                i11 = i6 & 64;
                if (i11 == 0) {
                }
                i12 = i6 & 128;
                if (i12 == 0) {
                }
                i13 = i6 & 256;
                if (i13 == 0) {
                }
                if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
                }
                i14 = i6 & 1024;
                if (i14 == 0) {
                }
                i17 = i6 & 2048;
                if (i17 == 0) {
                }
                int i342 = i16;
                i19 = i6 & 4096;
                if (i19 == 0) {
                }
                i21 = i6 & 8192;
                if (i21 == 0) {
                }
                i23 = i6 & 16384;
                if (i23 != 0) {
                }
                i25 = i6 & 32768;
                if (i25 != 0) {
                }
                int i3622 = i24;
                if ((i7 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z5 = z2;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            i11 = i6 & 64;
            if (i11 == 0) {
            }
            i12 = i6 & 128;
            if (i12 == 0) {
            }
            i13 = i6 & 256;
            if (i13 == 0) {
            }
            if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
            }
            i14 = i6 & 1024;
            if (i14 == 0) {
            }
            i17 = i6 & 2048;
            if (i17 == 0) {
            }
            int i3422 = i16;
            i19 = i6 & 4096;
            if (i19 == 0) {
            }
            i21 = i6 & 8192;
            if (i21 == 0) {
            }
            i23 = i6 & 16384;
            if (i23 != 0) {
            }
            i25 = i6 & 32768;
            if (i25 != 0) {
            }
            int i36222 = i24;
            if ((i7 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z4 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z5 = z2;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        i11 = i6 & 64;
        if (i11 == 0) {
        }
        i12 = i6 & 128;
        if (i12 == 0) {
        }
        i13 = i6 & 256;
        if (i13 == 0) {
        }
        if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
        }
        i14 = i6 & 1024;
        if (i14 == 0) {
        }
        i17 = i6 & 2048;
        if (i17 == 0) {
        }
        int i34222 = i16;
        i19 = i6 & 4096;
        if (i19 == 0) {
        }
        i21 = i6 & 8192;
        if (i21 == 0) {
        }
        i23 = i6 & 16384;
        if (i23 != 0) {
        }
        i25 = i6 & 32768;
        if (i25 != 0) {
        }
        int i362222 = i24;
        if ((i7 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i4, final int i5) {
        String str2;
        int i6;
        Function1 function13;
        int i7;
        Modifier modifier2;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        int i10;
        TextStyle textStyle2;
        int i11;
        KeyboardOptions keyboardOptions2;
        int i12;
        KeyboardActions keyboardActions2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z7;
        int i27;
        Brush solidColor;
        Composer composer2;
        final Modifier modifier3;
        final boolean z8;
        final boolean z9;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z10;
        final int i28;
        final VisualTransformation visualTransformation2;
        final Function1 function14;
        final MutableInteractionSource mutableInteractionSource4;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-454732590);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
            str2 = str;
        } else if ((i2 & 6) == 0) {
            str2 = str;
            i6 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i2;
        } else {
            str2 = str;
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                function13 = function1;
                i6 |= composerStartRestartGroup.changedInstance(function13) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    modifier2 = modifier;
                    i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        z4 = z;
                        i6 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            z5 = z2;
                            i6 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i2 & 196608) == 0) {
                                i6 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i2 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                            }
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                            keyboardActions2 = keyboardActions;
                        } else {
                            keyboardActions2 = keyboardActions;
                            if ((i2 & 12582912) == 0) {
                                i6 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i5 & 256;
                        if (i13 != 0) {
                            i6 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i6 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                        }
                        i14 = i5 & 512;
                        if (i14 == 0) {
                            if ((i2 & DriveFile.MODE_READ_WRITE) == 0) {
                                i15 = i14;
                                i6 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                            }
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changed(visualTransformation) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i5 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i29 = i18;
                            i21 = i5 & 4096;
                            if (i21 == 0) {
                                i22 = i29 | 384;
                            } else {
                                int i30 = i29;
                                if ((i4 & 384) == 0) {
                                    i30 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                                }
                                i22 = i30;
                            }
                            i23 = i5 & 8192;
                            if (i23 == 0) {
                                i24 = i22 | 3072;
                            } else {
                                int i31 = i22;
                                if ((i4 & 3072) == 0) {
                                    i24 = i31 | (composerStartRestartGroup.changed(brush) ? 2048 : 1024);
                                } else {
                                    i24 = i31;
                                }
                            }
                            i25 = i5 & 16384;
                            if (i25 == 0) {
                                i26 = i24 | 24576;
                            } else {
                                int i32 = i24;
                                if ((i4 & 24576) == 0) {
                                    i32 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                                }
                                i26 = i32;
                            }
                            if ((i6 & 306783379) != 306783378 && (i26 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z10 = z3;
                                function14 = function12;
                                mutableInteractionSource4 = mutableInteractionSource;
                                composer2 = composerStartRestartGroup;
                                z8 = z4;
                                z9 = z5;
                                textStyle3 = textStyle2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                modifier3 = modifier2;
                                i28 = i;
                                visualTransformation2 = visualTransformation;
                                brush2 = brush;
                                function32 = function3;
                            } else {
                                if (i7 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                boolean z11 = i8 == 0 ? true : z4;
                                boolean z12 = i9 == 0 ? false : z5;
                                TextStyle textStyle4 = i10 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                KeyboardOptions keyboardOptions4 = i11 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                                KeyboardActions keyboardActions4 = i12 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i13 == 0 ? false : z3;
                                int i33 = i15 == 0 ? Integer.MAX_VALUE : i;
                                VisualTransformation none = i17 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                Function1 function15 = i20 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.13
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                if (i21 == 0) {
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    z6 = z11;
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    z6 = z11;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if (i23 == 0) {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z7 = z12;
                                    i27 = i25;
                                    solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z7 = z12;
                                    i27 = i25;
                                    solidColor = brush;
                                }
                                Function3 function3M16161getLambda3$foundation_release = i27 == 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m16161getLambda3$foundation_release() : function3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-454732590, i6, i26, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:806)");
                                }
                                int i34 = i26 << 3;
                                boolean z14 = z7;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                composer2 = composerStartRestartGroup;
                                String str3 = str2;
                                Function1 function16 = function13;
                                TextStyle textStyle5 = textStyle4;
                                Modifier modifier4 = modifier2;
                                VisualTransformation visualTransformation3 = none;
                                boolean z15 = z6;
                                BasicTextField(str3, (Function1<? super String, Unit>) function16, modifier4, z15, z14, textStyle5, keyboardOptions4, keyboardActions4, z13, i33, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource5, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3M16161getLambda3$foundation_release, composer2, i6 & 2147483646, (i34 & 112) | 6 | (i34 & 896) | (i34 & 7168) | (57344 & i34) | (i34 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z8 = z15;
                                z9 = z14;
                                textStyle3 = textStyle5;
                                keyboardOptions3 = keyboardOptions4;
                                keyboardActions3 = keyboardActions4;
                                z10 = z13;
                                i28 = i33;
                                visualTransformation2 = visualTransformation3;
                                function14 = function15;
                                mutableInteractionSource4 = mutableInteractionSource5;
                                brush2 = solidColor;
                                function32 = function3M16161getLambda3$foundation_release;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.15
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

                                    public final void invoke(@Nullable Composer composer3, int i35) {
                                        BasicTextFieldKt.BasicTextField(str, function1, modifier3, z8, z9, textStyle3, keyboardOptions3, keyboardActions3, z10, i28, visualTransformation2, function14, mutableInteractionSource4, brush2, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= DriveFile.MODE_READ_WRITE;
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i5 & 2048;
                        if (i19 == 0) {
                        }
                        int i292 = i18;
                        i21 = i5 & 4096;
                        if (i21 == 0) {
                        }
                        i23 = i5 & 8192;
                        if (i23 == 0) {
                        }
                        i25 = i5 & 16384;
                        if (i25 == 0) {
                        }
                        if ((i6 & 306783379) != 306783378) {
                            if (i7 != 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i9 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if (i20 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if (i27 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i342 = i26 << 3;
                            boolean z142 = z7;
                            MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                            composer2 = composerStartRestartGroup;
                            String str32 = str2;
                            Function1 function162 = function13;
                            TextStyle textStyle52 = textStyle4;
                            Modifier modifier42 = modifier2;
                            VisualTransformation visualTransformation32 = none;
                            boolean z152 = z6;
                            BasicTextField(str32, (Function1<? super String, Unit>) function162, modifier42, z152, z142, textStyle52, keyboardOptions4, keyboardActions4, z13, i33, 1, visualTransformation32, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource52, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3M16161getLambda3$foundation_release, composer2, i6 & 2147483646, (i342 & 112) | 6 | (i342 & 896) | (i342 & 7168) | (57344 & i342) | (i342 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            z8 = z152;
                            z9 = z142;
                            textStyle3 = textStyle52;
                            keyboardOptions3 = keyboardOptions4;
                            keyboardActions3 = keyboardActions4;
                            z10 = z13;
                            i28 = i33;
                            visualTransformation2 = visualTransformation32;
                            function14 = function15;
                            mutableInteractionSource4 = mutableInteractionSource52;
                            brush2 = solidColor;
                            function32 = function3M16161getLambda3$foundation_release;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z5 = z2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i5 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i5 & 512;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i5 & 2048;
                    if (i19 == 0) {
                    }
                    int i2922 = i18;
                    i21 = i5 & 4096;
                    if (i21 == 0) {
                    }
                    i23 = i5 & 8192;
                    if (i23 == 0) {
                    }
                    i25 = i5 & 16384;
                    if (i25 == 0) {
                    }
                    if ((i6 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z4 = z;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                z5 = z2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                i13 = i5 & 256;
                if (i13 != 0) {
                }
                i14 = i5 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                i19 = i5 & 2048;
                if (i19 == 0) {
                }
                int i29222 = i18;
                i21 = i5 & 4096;
                if (i21 == 0) {
                }
                i23 = i5 & 8192;
                if (i23 == 0) {
                }
                i25 = i5 & 16384;
                if (i25 == 0) {
                }
                if ((i6 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            z4 = z;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            z5 = z2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            i13 = i5 & 256;
            if (i13 != 0) {
            }
            i14 = i5 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            i19 = i5 & 2048;
            if (i19 == 0) {
            }
            int i292222 = i18;
            i21 = i5 & 4096;
            if (i21 == 0) {
            }
            i23 = i5 & 8192;
            if (i23 == 0) {
            }
            i25 = i5 & 16384;
            if (i25 == 0) {
            }
            if ((i6 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function13 = function1;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        modifier2 = modifier;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        z4 = z;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        z5 = z2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        i13 = i5 & 256;
        if (i13 != 0) {
        }
        i14 = i5 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        i19 = i5 & 2048;
        if (i19 == 0) {
        }
        int i2922222 = i18;
        i21 = i5 & 4096;
        if (i21 == 0) {
        }
        i23 = i5 & 8192;
        if (i23 == 0) {
        }
        i25 = i5 & 16384;
        if (i25 == 0) {
        }
        if ((i6 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i4, final int i5) {
        TextFieldValue textFieldValue2;
        int i6;
        Function1 function13;
        int i7;
        Modifier modifier2;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        int i10;
        TextStyle textStyle2;
        int i11;
        KeyboardOptions keyboardOptions2;
        int i12;
        KeyboardActions keyboardActions2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z7;
        int i27;
        Brush solidColor;
        Composer composer2;
        final Modifier modifier3;
        final boolean z8;
        final boolean z9;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z10;
        final int i28;
        final VisualTransformation visualTransformation2;
        final Function1 function14;
        final MutableInteractionSource mutableInteractionSource4;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-560482651);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
            textFieldValue2 = textFieldValue;
        } else if ((i2 & 6) == 0) {
            textFieldValue2 = textFieldValue;
            i6 = (composerStartRestartGroup.changed(textFieldValue2) ? 4 : 2) | i2;
        } else {
            textFieldValue2 = textFieldValue;
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                function13 = function1;
                i6 |= composerStartRestartGroup.changedInstance(function13) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    modifier2 = modifier;
                    i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        z4 = z;
                        i6 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            z5 = z2;
                            i6 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i2 & 196608) == 0) {
                                i6 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i2 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                            }
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                            keyboardActions2 = keyboardActions;
                        } else {
                            keyboardActions2 = keyboardActions;
                            if ((i2 & 12582912) == 0) {
                                i6 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i5 & 256;
                        if (i13 != 0) {
                            i6 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i6 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                        }
                        i14 = i5 & 512;
                        if (i14 == 0) {
                            if ((i2 & DriveFile.MODE_READ_WRITE) == 0) {
                                i15 = i14;
                                i6 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                            }
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changed(visualTransformation) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i5 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i29 = i18;
                            i21 = i5 & 4096;
                            if (i21 == 0) {
                                i22 = i29 | 384;
                            } else {
                                int i30 = i29;
                                if ((i4 & 384) == 0) {
                                    i30 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                                }
                                i22 = i30;
                            }
                            i23 = i5 & 8192;
                            if (i23 == 0) {
                                i24 = i22 | 3072;
                            } else {
                                int i31 = i22;
                                if ((i4 & 3072) == 0) {
                                    i24 = i31 | (composerStartRestartGroup.changed(brush) ? 2048 : 1024);
                                } else {
                                    i24 = i31;
                                }
                            }
                            i25 = i5 & 16384;
                            if (i25 == 0) {
                                i26 = i24 | 24576;
                            } else {
                                int i32 = i24;
                                if ((i4 & 24576) == 0) {
                                    i32 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                                }
                                i26 = i32;
                            }
                            if ((i6 & 306783379) != 306783378 && (i26 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z10 = z3;
                                function14 = function12;
                                mutableInteractionSource4 = mutableInteractionSource;
                                composer2 = composerStartRestartGroup;
                                z8 = z4;
                                z9 = z5;
                                textStyle3 = textStyle2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                modifier3 = modifier2;
                                i28 = i;
                                visualTransformation2 = visualTransformation;
                                brush2 = brush;
                                function32 = function3;
                            } else {
                                if (i7 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                boolean z11 = i8 == 0 ? true : z4;
                                boolean z12 = i9 == 0 ? false : z5;
                                TextStyle textStyle4 = i10 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                KeyboardOptions keyboardOptions4 = i11 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                                KeyboardActions keyboardActions4 = i12 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i13 == 0 ? false : z3;
                                int i33 = i15 == 0 ? Integer.MAX_VALUE : i;
                                VisualTransformation none = i17 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                Function1 function15 = i20 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.16
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                if (i21 == 0) {
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    z6 = z11;
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    z6 = z11;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if (i23 == 0) {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z7 = z12;
                                    i27 = i25;
                                    solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z7 = z12;
                                    i27 = i25;
                                    solidColor = brush;
                                }
                                Function3 function3M16162getLambda4$foundation_release = i27 == 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m16162getLambda4$foundation_release() : function3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-560482651, i6, i26, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:846)");
                                }
                                int i34 = i26 << 3;
                                boolean z14 = z7;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                composer2 = composerStartRestartGroup;
                                TextFieldValue textFieldValue3 = textFieldValue2;
                                Function1 function16 = function13;
                                TextStyle textStyle5 = textStyle4;
                                Modifier modifier4 = modifier2;
                                VisualTransformation visualTransformation3 = none;
                                boolean z15 = z6;
                                BasicTextField(textFieldValue3, (Function1<? super TextFieldValue, Unit>) function16, modifier4, z15, z14, textStyle5, keyboardOptions4, keyboardActions4, z13, i33, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource5, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3M16162getLambda4$foundation_release, composer2, i6 & 2147483646, (i34 & 112) | 6 | (i34 & 896) | (i34 & 7168) | (57344 & i34) | (i34 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z8 = z15;
                                z9 = z14;
                                textStyle3 = textStyle5;
                                keyboardOptions3 = keyboardOptions4;
                                keyboardActions3 = keyboardActions4;
                                z10 = z13;
                                i28 = i33;
                                visualTransformation2 = visualTransformation3;
                                function14 = function15;
                                mutableInteractionSource4 = mutableInteractionSource5;
                                brush2 = solidColor;
                                function32 = function3M16162getLambda4$foundation_release;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.18
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

                                    public final void invoke(@Nullable Composer composer3, int i35) {
                                        BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifier3, z8, z9, textStyle3, keyboardOptions3, keyboardActions3, z10, i28, visualTransformation2, function14, mutableInteractionSource4, brush2, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= DriveFile.MODE_READ_WRITE;
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i5 & 2048;
                        if (i19 == 0) {
                        }
                        int i292 = i18;
                        i21 = i5 & 4096;
                        if (i21 == 0) {
                        }
                        i23 = i5 & 8192;
                        if (i23 == 0) {
                        }
                        i25 = i5 & 16384;
                        if (i25 == 0) {
                        }
                        if ((i6 & 306783379) != 306783378) {
                            if (i7 != 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i9 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if (i20 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if (i27 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i342 = i26 << 3;
                            boolean z142 = z7;
                            MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                            composer2 = composerStartRestartGroup;
                            TextFieldValue textFieldValue32 = textFieldValue2;
                            Function1 function162 = function13;
                            TextStyle textStyle52 = textStyle4;
                            Modifier modifier42 = modifier2;
                            VisualTransformation visualTransformation32 = none;
                            boolean z152 = z6;
                            BasicTextField(textFieldValue32, (Function1<? super TextFieldValue, Unit>) function162, modifier42, z152, z142, textStyle52, keyboardOptions4, keyboardActions4, z13, i33, 1, visualTransformation32, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource52, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3M16162getLambda4$foundation_release, composer2, i6 & 2147483646, (i342 & 112) | 6 | (i342 & 896) | (i342 & 7168) | (57344 & i342) | (i342 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            z8 = z152;
                            z9 = z142;
                            textStyle3 = textStyle52;
                            keyboardOptions3 = keyboardOptions4;
                            keyboardActions3 = keyboardActions4;
                            z10 = z13;
                            i28 = i33;
                            visualTransformation2 = visualTransformation32;
                            function14 = function15;
                            mutableInteractionSource4 = mutableInteractionSource52;
                            brush2 = solidColor;
                            function32 = function3M16162getLambda4$foundation_release;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z5 = z2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i5 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i5 & 512;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i5 & 2048;
                    if (i19 == 0) {
                    }
                    int i2922 = i18;
                    i21 = i5 & 4096;
                    if (i21 == 0) {
                    }
                    i23 = i5 & 8192;
                    if (i23 == 0) {
                    }
                    i25 = i5 & 16384;
                    if (i25 == 0) {
                    }
                    if ((i6 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z4 = z;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                z5 = z2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                i13 = i5 & 256;
                if (i13 != 0) {
                }
                i14 = i5 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                i19 = i5 & 2048;
                if (i19 == 0) {
                }
                int i29222 = i18;
                i21 = i5 & 4096;
                if (i21 == 0) {
                }
                i23 = i5 & 8192;
                if (i23 == 0) {
                }
                i25 = i5 & 16384;
                if (i25 == 0) {
                }
                if ((i6 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            z4 = z;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            z5 = z2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            i13 = i5 & 256;
            if (i13 != 0) {
            }
            i14 = i5 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            i19 = i5 & 2048;
            if (i19 == 0) {
            }
            int i292222 = i18;
            i21 = i5 & 4096;
            if (i21 == 0) {
            }
            i23 = i5 & 8192;
            if (i23 == 0) {
            }
            i25 = i5 & 16384;
            if (i25 == 0) {
            }
            if ((i6 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function13 = function1;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        modifier2 = modifier;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        z4 = z;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        z5 = z2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        i13 = i5 & 256;
        if (i13 != 0) {
        }
        i14 = i5 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        i19 = i5 & 2048;
        if (i19 == 0) {
        }
        int i2922222 = i18;
        i21 = i5 & 4096;
        if (i21 == 0) {
        }
        i23 = i5 & 8192;
        if (i23 == 0) {
        }
        i25 = i5 & 16384;
        if (i25 == 0) {
        }
        if ((i6 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
