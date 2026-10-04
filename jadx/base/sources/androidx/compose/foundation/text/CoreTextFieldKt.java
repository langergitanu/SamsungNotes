package androidx.compose.foundation.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.focus.FocusManager;
import androidx.compose.p109ui.focus.FocusRequester;
import androidx.compose.p109ui.focus.FocusState;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.hapticfeedback.HapticFeedback;
import androidx.compose.p109ui.input.key.KeyEvent;
import androidx.compose.p109ui.input.key.KeyInputModifierKt;
import androidx.compose.p109ui.input.pointer.PointerIconKt;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.AlignmentLineKt;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.ClipboardManager;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.SoftwareKeyboardController;
import androidx.compose.p109ui.platform.TextToolbar;
import androidx.compose.p109ui.platform.WindowInfo;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.input.CommitTextCommand;
import androidx.compose.p109ui.text.input.DeleteAllCommand;
import androidx.compose.p109ui.text.input.EditCommand;
import androidx.compose.p109ui.text.input.FinishComposingTextCommand;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.p109ui.text.input.ImeOptions;
import androidx.compose.p109ui.text.input.KeyboardType;
import androidx.compose.p109ui.text.input.OffsetMapping;
import androidx.compose.p109ui.text.input.PasswordVisualTransformation;
import androidx.compose.p109ui.text.input.TextFieldValue;
import androidx.compose.p109ui.text.input.TextInputService;
import androidx.compose.p109ui.text.input.TextInputSession;
import androidx.compose.p109ui.text.input.TransformedText;
import androidx.compose.p109ui.text.input.VisualTransformation;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a2\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0080@¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u008a\u0084\u0002"}, m13886d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", Constants.IntentExtraValue.SHOW, "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCoreTextField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoreTextField.kt\nandroidx/compose/foundation/text/CoreTextFieldKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 5 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 6 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 7 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 8 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 9 Composer.kt\nandroidx/compose/runtime/Updater\n+ 10 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 11 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 12 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,1252:1\n1225#2,6:1253\n1225#2,6:1259\n1225#2,6:1265\n1225#2,6:1277\n1225#2,6:1283\n1225#2,6:1289\n1225#2,6:1295\n1225#2,6:1301\n1225#2,3:1315\n1228#2,3:1321\n1225#2,6:1325\n1225#2,6:1331\n1225#2,6:1337\n1225#2,6:1343\n1225#2,6:1349\n1225#2,6:1355\n1225#2,6:1361\n1225#2,6:1367\n1225#2,6:1373\n1225#2,6:1379\n1225#2,6:1385\n1225#2,6:1432\n1225#2,6:1439\n1225#2,6:1445\n1225#2,6:1451\n77#3:1271\n77#3:1272\n77#3:1273\n77#3:1274\n77#3:1275\n77#3:1276\n77#3:1307\n77#3:1308\n77#3:1309\n77#3:1438\n481#4:1310\n480#4,4:1311\n484#4,2:1318\n488#4:1324\n480#5:1320\n71#6:1391\n68#6,6:1392\n74#6:1426\n78#6:1430\n79#7,6:1398\n86#7,4:1413\n90#7,2:1423\n94#7:1429\n368#8,9:1404\n377#8:1425\n378#8,2:1427\n4034#9,6:1417\n1#10:1431\n602#11,8:1457\n81#12:1465\n*S KotlinDebug\n*F\n+ 1 CoreTextField.kt\nandroidx/compose/foundation/text/CoreTextFieldKt\n*L\n222#1:1253,6\n223#1:1259,6\n224#1:1265,6\n242#1:1277,6\n245#1:1283,6\n259#1:1289,6\n288#1:1295,6\n291#1:1301,6\n304#1:1315,3\n304#1:1321,3\n305#1:1325,6\n312#1:1331,6\n354#1:1337,6\n380#1:1343,6\n381#1:1349,6\n409#1:1355,6\n426#1:1361,6\n463#1:1367,6\n617#1:1373,6\n621#1:1379,6\n648#1:1385,6\n1192#1:1432,6\n1195#1:1439,6\n1197#1:1445,6\n1209#1:1451,6\n229#1:1271\n230#1:1272\n231#1:1273\n232#1:1274\n233#1:1275\n234#1:1276\n297#1:1307\n298#1:1308\n299#1:1309\n1193#1:1438\n304#1:1310\n304#1:1311,4\n304#1:1318,2\n304#1:1324\n304#1:1320\n803#1:1391\n803#1:1392,6\n803#1:1426\n803#1:1430\n803#1:1398,6\n803#1:1413,4\n803#1:1423,2\n803#1:1429\n803#1:1404,9\n803#1:1425\n803#1:1427,2\n803#1:1417,6\n1237#1:1457,8\n353#1:1465\n*E\n"})
public final class CoreTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x07c2  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x07f5  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0837  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x08b1  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x08cc  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x08e8  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0958  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x09ba  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0a0f  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0a35  */
    /* JADX WARN: Removed duplicated region for block: B:488:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(@NotNull final TextFieldValue textFieldValue, @NotNull final Function1<? super TextFieldValue, Unit> function1, @Nullable Modifier modifier, @Nullable TextStyle textStyle, @Nullable VisualTransformation visualTransformation, @Nullable Function1<? super TextLayoutResult, Unit> function12, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Brush brush, boolean z, int i, int i2, @Nullable ImeOptions imeOptions, @Nullable KeyboardActions keyboardActions, boolean z2, boolean z3, @Nullable Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        TextStyle textStyle2;
        int i10;
        VisualTransformation visualTransformation2;
        int i11;
        Function1<? super TextLayoutResult, Unit> function13;
        int i12;
        MutableInteractionSource mutableInteractionSource2;
        int i13;
        final Brush solidColor;
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
        boolean z4;
        int i27;
        int i28;
        ImeOptions imeOptions2;
        KeyboardActions keyboardActions2;
        VisualTransformation visualTransformation3;
        Modifier modifier3;
        boolean z5;
        Brush brush2;
        ImeOptions imeOptions3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z6;
        final Function1<? super TextLayoutResult, Unit> function14;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M16163getLambda1$foundation_release;
        int i29;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        boolean zChanged;
        Modifier modifier4;
        boolean z7;
        TextRange composition;
        WindowInfo windowInfo;
        int i30;
        AnnotatedString annotatedString;
        TextStyle textStyle3;
        Density density;
        FontFamily.Resolver resolver;
        FocusManager focusManager;
        final ImeOptions imeOptions4;
        boolean z8;
        boolean zChangedInstance;
        Object objRememberedValue4;
        boolean z9;
        final TextInputService textInputService;
        final TextFieldValue textFieldValue2;
        ImeOptions imeOptions5;
        final OffsetMapping offsetMapping;
        BringIntoViewRequester bringIntoViewRequester;
        VisualTransformation visualTransformation4;
        TransformedText transformedText;
        final LegacyTextFieldState legacyTextFieldState;
        TextFieldSelectionManager textFieldSelectionManager;
        ImeOptions imeOptions6;
        boolean z10;
        boolean z11;
        Object objRememberedValue5;
        State state;
        final ImeOptions imeOptions7;
        boolean zChangedInstance2;
        Object objRememberedValue6;
        boolean zChangedInstance3;
        Object objRememberedValue7;
        FocusRequester focusRequester;
        boolean z12;
        TextFieldSelectionManager textFieldSelectionManager2;
        final boolean z13;
        final FocusRequester focusRequester2;
        boolean zChangedInstance4;
        Object objRememberedValue8;
        final WindowInfo windowInfo2;
        final TextFieldSelectionManager textFieldSelectionManager3;
        boolean zChangedInstance5;
        Object objRememberedValue9;
        boolean z14;
        WindowInfo windowInfo3;
        TextFieldSelectionManager textFieldSelectionManager4;
        final boolean z15;
        boolean zChangedInstance6;
        Object objRememberedValue10;
        boolean z16;
        final TextFieldSelectionManager textFieldSelectionManager5;
        final FocusRequester focusRequester3;
        final LegacyTextFieldState legacyTextFieldState2;
        boolean zChangedInstance7;
        Object objRememberedValue11;
        boolean zChangedInstance8;
        Object objRememberedValue12;
        boolean zChangedInstance9;
        Object objRememberedValue13;
        boolean z17;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final int i31;
        Composer composer2;
        final Function1<? super TextLayoutResult, Unit> function15;
        final ImeOptions imeOptions8;
        final boolean z18;
        final MutableInteractionSource mutableInteractionSource4;
        final KeyboardActions keyboardActions3;
        final int i32;
        final Modifier modifier5;
        final boolean z19;
        final TextStyle textStyle4;
        final VisualTransformation visualTransformation5;
        final boolean z20;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-958708118);
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                i7 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    modifier2 = modifier;
                    i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        textStyle2 = textStyle;
                        i7 |= composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            visualTransformation2 = visualTransformation;
                            i7 |= composerStartRestartGroup.changed(visualTransformation2) ? 16384 : 8192;
                        }
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                            function13 = function12;
                        } else {
                            function13 = function12;
                            if ((i4 & 196608) == 0) {
                                i7 |= composerStartRestartGroup.changedInstance(function13) ? 131072 : 65536;
                            }
                        }
                        i12 = i6 & 64;
                        if (i12 != 0) {
                            i7 |= 1572864;
                            mutableInteractionSource2 = mutableInteractionSource;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if ((i4 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                            }
                        }
                        i13 = i6 & 128;
                        if (i13 != 0) {
                            i7 |= 12582912;
                            solidColor = brush;
                        } else {
                            solidColor = brush;
                            if ((i4 & 12582912) == 0) {
                                i7 |= composerStartRestartGroup.changed(solidColor) ? 8388608 : 4194304;
                            }
                        }
                        i14 = i6 & 256;
                        if (i14 != 0) {
                            i7 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i7 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i15 = i6 & 512;
                        if (i15 == 0) {
                            if ((i4 & DriveFile.MODE_READ_WRITE) == 0) {
                                i16 = i15;
                                i7 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                            }
                            i17 = i6 & 1024;
                            if (i17 == 0) {
                                i19 = i5 | 6;
                                i18 = i17;
                            } else if ((i5 & 6) == 0) {
                                i18 = i17;
                                i19 = i5 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                            } else {
                                i18 = i17;
                                i19 = i5;
                            }
                            if ((i5 & 48) == 0) {
                                i19 |= ((i6 & 2048) == 0 && composerStartRestartGroup.changed(imeOptions)) ? 32 : 16;
                            }
                            int i33 = i19;
                            i20 = i6 & 4096;
                            if (i20 == 0) {
                                i21 = i33 | 384;
                            } else if ((i5 & 384) == 0) {
                                i21 = i33 | (composerStartRestartGroup.changed(keyboardActions) ? 256 : 128);
                            } else {
                                i21 = i33;
                            }
                            i22 = i6 & 8192;
                            if (i22 == 0) {
                                i23 = i21 | 3072;
                            } else {
                                int i34 = i21;
                                if ((i5 & 3072) == 0) {
                                    i23 = i34 | (composerStartRestartGroup.changed(z2) ? 2048 : 1024);
                                } else {
                                    i23 = i34;
                                }
                            }
                            i24 = i6 & 16384;
                            if (i24 == 0) {
                                i25 = i23 | 24576;
                            } else {
                                int i35 = i23;
                                if ((i5 & 24576) == 0) {
                                    i25 = i35 | (composerStartRestartGroup.changed(z3) ? 16384 : 8192);
                                } else {
                                    i25 = i35;
                                }
                            }
                            i26 = i6 & 32768;
                            if (i26 == 0) {
                                i25 |= 196608;
                            } else if ((i5 & 196608) == 0) {
                                i25 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                            }
                            if ((i7 & 306783379) != 306783378 && (i25 & 74899) == 74898 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z18 = z;
                                imeOptions8 = imeOptions;
                                z20 = z2;
                                function32 = function3;
                                composer2 = composerStartRestartGroup;
                                visualTransformation5 = visualTransformation2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                function15 = function13;
                                textStyle4 = textStyle2;
                                modifier5 = modifier2;
                                i32 = i;
                                i31 = i2;
                                keyboardActions3 = keyboardActions;
                                z19 = z3;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i8 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i9 != 0) {
                                        textStyle2 = TextStyle.INSTANCE.getDefault();
                                    }
                                    VisualTransformation none = i10 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation2;
                                    Function1<? super TextLayoutResult, Unit> function16 = i11 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull TextLayoutResult textLayoutResult) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }
                                    } : function13;
                                    if (i12 != 0) {
                                        mutableInteractionSource2 = null;
                                    }
                                    if (i13 != 0) {
                                        solidColor = new SolidColor(Color.INSTANCE.m18561getUnspecified0d7_KjU(), null);
                                    }
                                    z4 = i14 == 0 ? true : z;
                                    i27 = i16 == 0 ? Integer.MAX_VALUE : i;
                                    i28 = i18 == 0 ? 1 : i2;
                                    if ((i6 & 2048) == 0) {
                                        imeOptions2 = ImeOptions.INSTANCE.getDefault();
                                        i25 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    } else {
                                        imeOptions2 = imeOptions;
                                    }
                                    keyboardActions2 = i20 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                    boolean z21 = i22 == 0 ? true : z2;
                                    boolean z22 = i24 == 0 ? false : z3;
                                    if (i26 == 0) {
                                        function3M16163getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m16163getLambda1$foundation_release();
                                        Brush brush3 = solidColor;
                                        visualTransformation3 = none;
                                        modifier3 = modifier2;
                                        z5 = z22;
                                        brush2 = brush3;
                                        Function1<? super TextLayoutResult, Unit> function17 = function16;
                                        imeOptions3 = imeOptions2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z6 = z21;
                                        function14 = function17;
                                    } else {
                                        Brush brush4 = solidColor;
                                        visualTransformation3 = none;
                                        modifier3 = modifier2;
                                        z5 = z22;
                                        brush2 = brush4;
                                        Function1<? super TextLayoutResult, Unit> function18 = function16;
                                        imeOptions3 = imeOptions2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z6 = z21;
                                        function14 = function18;
                                        function3M16163getLambda1$foundation_release = function3;
                                    }
                                    i29 = i25;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i6 & 2048) != 0) {
                                        i25 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    }
                                    i27 = i;
                                    i28 = i2;
                                    keyboardActions2 = keyboardActions;
                                    function3M16163getLambda1$foundation_release = function3;
                                    brush2 = solidColor;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    function14 = function13;
                                    modifier3 = modifier2;
                                    i29 = i25;
                                    z4 = z;
                                    z6 = z2;
                                    z5 = z3;
                                    visualTransformation3 = visualTransformation2;
                                    imeOptions3 = imeOptions;
                                }
                                composerStartRestartGroup.endDefaults();
                                Brush brush5 = brush2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-958708118, i7, i29, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:220)");
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                int i36 = i7;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                final FocusRequester focusRequester4 = (FocusRequester) objRememberedValue;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == companion.getEmpty()) {
                                    objRememberedValue2 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter = (LegacyPlatformTextInputServiceAdapter) objRememberedValue2;
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                boolean z23 = z4;
                                if (objRememberedValue3 == companion.getEmpty()) {
                                    objRememberedValue3 = new TextInputService(legacyPlatformTextInputServiceAdapter);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                final TextInputService textInputService2 = (TextInputService) objRememberedValue3;
                                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                FontFamily.Resolver resolver2 = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                long backgroundColor = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor();
                                FocusManager focusManager2 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                WindowInfo windowInfo4 = (WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                                TextStyle textStyle5 = textStyle2;
                                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                final int i37 = i28;
                                final Orientation orientation = (i27 == 1 || z23 || !imeOptions3.getSingleLine()) ? Orientation.Vertical : Orientation.Horizontal;
                                Object[] objArr = {orientation};
                                Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
                                zChanged = composerStartRestartGroup.changed(orientation);
                                final boolean z24 = z5;
                                Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                                if (zChanged) {
                                    modifier4 = modifier3;
                                    if (objRememberedValue14 == companion.getEmpty()) {
                                    }
                                    final TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) objRememberedValue14, composerStartRestartGroup, 0, 4);
                                    int i38 = i36 & 14;
                                    z7 = (i38 == 4) | ((i36 & 57344) == 16384);
                                    Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                                    if (z7 || objRememberedValue15 == companion.getEmpty()) {
                                        TransformedText transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                        composition = textFieldValue.getComposition();
                                        windowInfo = windowInfo4;
                                        i30 = i27;
                                        if (composition == null) {
                                            TransformedText transformedTextM16238applyCompositionDecoration72CqOWE = TextFieldDelegate.INSTANCE.m16238applyCompositionDecoration72CqOWE(composition.getPackedValue(), transformedTextFilterWithValidation);
                                            objRememberedValue15 = transformedTextM16238applyCompositionDecoration72CqOWE == null ? transformedTextFilterWithValidation : transformedTextM16238applyCompositionDecoration72CqOWE;
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                                        }
                                    } else {
                                        windowInfo = windowInfo4;
                                        i30 = i27;
                                    }
                                    TransformedText transformedText2 = (TransformedText) objRememberedValue15;
                                    AnnotatedString text = transformedText2.getText();
                                    final OffsetMapping offsetMapping2 = transformedText2.getOffsetMapping();
                                    RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                                    boolean zChanged2 = composerStartRestartGroup.changed(softwareKeyboardController);
                                    Object objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2 || objRememberedValue16 == companion.getEmpty()) {
                                        TextDelegate textDelegate = new TextDelegate(text, textStyle5, 0, 0, z23, 0, density2, resolver2, null, 300, null);
                                        annotatedString = text;
                                        textStyle3 = textStyle5;
                                        density = density2;
                                        resolver = resolver2;
                                        z23 = z23;
                                        objRememberedValue16 = new LegacyTextFieldState(textDelegate, currentRecomposeScope, softwareKeyboardController);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                                    } else {
                                        annotatedString = text;
                                        density = density2;
                                        resolver = resolver2;
                                        textStyle3 = textStyle5;
                                    }
                                    final LegacyTextFieldState legacyTextFieldState3 = (LegacyTextFieldState) objRememberedValue16;
                                    boolean z25 = z23;
                                    KeyboardActions keyboardActions4 = keyboardActions2;
                                    legacyTextFieldState3.m16194updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle3, z25, density, resolver, function1, keyboardActions4, focusManager2, backgroundColor);
                                    legacyTextFieldState3.getProcessor().reset(textFieldValue, legacyTextFieldState3.getInputSession());
                                    Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue17 == companion.getEmpty()) {
                                        focusManager = focusManager2;
                                        objRememberedValue17 = new UndoManager(0, 1, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                                    } else {
                                        focusManager = focusManager2;
                                    }
                                    UndoManager undoManager = (UndoManager) objRememberedValue17;
                                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                                    Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue18 == companion.getEmpty()) {
                                        objRememberedValue18 = new TextFieldSelectionManager(undoManager);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                                    }
                                    final TextFieldSelectionManager textFieldSelectionManager6 = (TextFieldSelectionManager) objRememberedValue18;
                                    textFieldSelectionManager6.setOffsetMapping$foundation_release(offsetMapping2);
                                    textFieldSelectionManager6.setVisualTransformation$foundation_release(visualTransformation3);
                                    textFieldSelectionManager6.setOnValueChange$foundation_release(legacyTextFieldState3.getOnValueChange());
                                    textFieldSelectionManager6.setState$foundation_release(legacyTextFieldState3);
                                    textFieldSelectionManager6.setValue$foundation_release(textFieldValue);
                                    textFieldSelectionManager6.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                                    textFieldSelectionManager6.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                                    textFieldSelectionManager6.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                                    textFieldSelectionManager6.setFocusRequester(focusRequester4);
                                    textFieldSelectionManager6.setEditable(!z24);
                                    textFieldSelectionManager6.setEnabled(z6);
                                    Object objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue19 == companion.getEmpty()) {
                                        objRememberedValue19 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                                    }
                                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue19).getCoroutineScope();
                                    Object objRememberedValue20 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue20 == companion.getEmpty()) {
                                        objRememberedValue20 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue20);
                                    }
                                    final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) objRememberedValue20;
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    final boolean z26 = z6;
                                    int i39 = i29 & 7168;
                                    int i40 = i29;
                                    int i41 = i40 & 57344;
                                    boolean zChangedInstance10 = (i38 == 4) | composerStartRestartGroup.changedInstance(legacyTextFieldState3) | (i39 == 2048) | (i41 == 16384) | composerStartRestartGroup.changedInstance(textInputService2);
                                    int i42 = (i40 & 112) ^ 48;
                                    if (i42 <= 32 || !composerStartRestartGroup.changed(imeOptions3)) {
                                        imeOptions4 = imeOptions3;
                                        if ((i40 & 48) != 32) {
                                            z8 = false;
                                        }
                                        zChangedInstance = zChangedInstance10 | z8 | composerStartRestartGroup.changedInstance(offsetMapping2) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(bringIntoViewRequester2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager6);
                                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                        if (!zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                                            objRememberedValue4 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                    invoke2(focusState);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@NotNull FocusState focusState) {
                                                    TextLayoutResultProxy layoutResult;
                                                    if (legacyTextFieldState3.getHasFocus() == focusState.isFocused()) {
                                                        return;
                                                    }
                                                    legacyTextFieldState3.setHasFocus(focusState.isFocused());
                                                    if (legacyTextFieldState3.getHasFocus() && z26 && !z24) {
                                                        CoreTextFieldKt.startInputSession(textInputService2, legacyTextFieldState3, textFieldValue, imeOptions4, offsetMapping2);
                                                    } else {
                                                        CoreTextFieldKt.endInputSession(legacyTextFieldState3);
                                                    }
                                                    if (focusState.isFocused() && (layoutResult = legacyTextFieldState3.getLayoutResult()) != null) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester2, textFieldValue, legacyTextFieldState3, layoutResult, offsetMapping2, null), 3, null);
                                                    }
                                                    if (focusState.isFocused()) {
                                                        return;
                                                    }
                                                    TextFieldSelectionManager.m16563deselect_kEHs6E$foundation_release$default(textFieldSelectionManager6, null, 1, null);
                                                }
                                            };
                                            z9 = z26;
                                            textInputService = textInputService2;
                                            textFieldValue2 = textFieldValue;
                                            imeOptions5 = imeOptions4;
                                            offsetMapping = offsetMapping2;
                                            bringIntoViewRequester = bringIntoViewRequester2;
                                            visualTransformation4 = visualTransformation3;
                                            transformedText = transformedText2;
                                            legacyTextFieldState = legacyTextFieldState3;
                                            textFieldSelectionManager = textFieldSelectionManager6;
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                        } else {
                                            textFieldValue2 = textFieldValue;
                                            z9 = z26;
                                            visualTransformation4 = visualTransformation3;
                                            bringIntoViewRequester = bringIntoViewRequester2;
                                            transformedText = transformedText2;
                                            legacyTextFieldState = legacyTextFieldState3;
                                            textFieldSelectionManager = textFieldSelectionManager6;
                                            offsetMapping = offsetMapping2;
                                            textInputService = textInputService2;
                                            imeOptions5 = imeOptions4;
                                        }
                                        Modifier modifierTextFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z9, focusRequester4, mutableInteractionSource3, (Function1) objRememberedValue4);
                                        final boolean z27 = z9;
                                        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z9 || z24) ? false : true), composerStartRestartGroup, 0);
                                        Unit unit = Unit.INSTANCE;
                                        boolean zChanged3 = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                                        if (i42 > 32 || !composerStartRestartGroup.changed(imeOptions5)) {
                                            imeOptions6 = imeOptions5;
                                            if ((i40 & 48) != 32) {
                                                z10 = false;
                                            }
                                            z11 = zChanged3 | z10;
                                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                            if (z11 || objRememberedValue5 == companion.getEmpty()) {
                                                ImeOptions imeOptions9 = imeOptions6;
                                                objRememberedValue5 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, stateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions9, null);
                                                state = stateRememberUpdatedState;
                                                imeOptions7 = imeOptions9;
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                            } else {
                                                state = stateRememberUpdatedState;
                                                imeOptions7 = imeOptions6;
                                            }
                                            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composerStartRestartGroup, 6);
                                            zChangedInstance2 = composerStartRestartGroup.changedInstance(legacyTextFieldState);
                                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                            if (!zChangedInstance2 || objRememberedValue6 == companion.getEmpty()) {
                                                objRememberedValue6 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                        invoke(bool.booleanValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(boolean z28) {
                                                        legacyTextFieldState.setInTouchMode(z28);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                            }
                                            Modifier modifierUpdateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) objRememberedValue6);
                                            zChangedInstance3 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i41 != 16384) | (i39 != 2048) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                            if (!zChangedInstance3 || objRememberedValue7 == companion.getEmpty()) {
                                                final TextFieldSelectionManager textFieldSelectionManager7 = textFieldSelectionManager;
                                                final OffsetMapping offsetMapping3 = offsetMapping;
                                                final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                                objRememberedValue7 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                        m16164invokek4lQ0M(offset.getPackedValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                                    public final void m16164invokek4lQ0M(long j) {
                                                        CoreTextFieldKt.tapToFocus(legacyTextFieldState4, focusRequester4, !z24);
                                                        if (legacyTextFieldState4.getHasFocus() && z27) {
                                                            if (legacyTextFieldState4.getHandleState() == HandleState.Selection) {
                                                                textFieldSelectionManager7.m16567deselect_kEHs6E$foundation_release(Offset.m18273boximpl(j));
                                                                return;
                                                            }
                                                            TextLayoutResultProxy layoutResult = legacyTextFieldState4.getLayoutResult();
                                                            if (layoutResult != null) {
                                                                LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                TextFieldDelegate.INSTANCE.m16241setCursorOffsetULxng0E$foundation_release(j, layoutResult, legacyTextFieldState5.getProcessor(), offsetMapping3, legacyTextFieldState5.getOnValueChange());
                                                                if (legacyTextFieldState5.getTextDelegate().getText().length() > 0) {
                                                                    legacyTextFieldState5.setHandleState(HandleState.Cursor);
                                                                }
                                                            }
                                                        }
                                                    }
                                                };
                                                focusRequester = focusRequester4;
                                                z12 = z27;
                                                textFieldSelectionManager2 = textFieldSelectionManager7;
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                            } else {
                                                textFieldSelectionManager2 = textFieldSelectionManager;
                                                z12 = z27;
                                                focusRequester = focusRequester4;
                                            }
                                            z13 = z12;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                            focusRequester2 = focusRequester;
                                            Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifierUpdateSelectionTouchMode, mutableInteractionSource3, z12, (Function1) objRememberedValue7), textFieldSelectionManager2.getMouseSelectionObserver(), textFieldSelectionManager2.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                            zChangedInstance4 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i38 != 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                            if (!zChangedInstance4 || objRememberedValue8 == companion.getEmpty()) {
                                                objRememberedValue8 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                        invoke2(drawScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull DrawScope drawScope) {
                                                        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                                                        if (layoutResult != null) {
                                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                                            LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                                            OffsetMapping offsetMapping4 = offsetMapping;
                                                            TextFieldDelegate.INSTANCE.m16239drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue3, legacyTextFieldState5.m16189getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState5.m16186getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping4, layoutResult.getValue(), legacyTextFieldState5.getHighlightPaint(), legacyTextFieldState5.getSelectionBackgroundColor());
                                                        }
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                            }
                                            final Modifier modifierDrawBehind = DrawModifierKt.drawBehind(companion2, (Function1) objRememberedValue8);
                                            windowInfo2 = windowInfo;
                                            textFieldSelectionManager3 = textFieldSelectionManager2;
                                            zChangedInstance5 = (i38 != 4) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i39 != 2048) | composerStartRestartGroup.changed(windowInfo2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager3) | composerStartRestartGroup.changedInstance(offsetMapping);
                                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                            if (!zChangedInstance5 || objRememberedValue9 == companion.getEmpty()) {
                                                final OffsetMapping offsetMapping4 = offsetMapping;
                                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                                objRememberedValue9 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                        invoke2(layoutCoordinates);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull LayoutCoordinates layoutCoordinates) {
                                                        legacyTextFieldState5.setLayoutCoordinates(layoutCoordinates);
                                                        TextLayoutResultProxy layoutResult = legacyTextFieldState5.getLayoutResult();
                                                        if (layoutResult != null) {
                                                            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                        }
                                                        if (z13) {
                                                            if (legacyTextFieldState5.getHandleState() == HandleState.Selection) {
                                                                if (legacyTextFieldState5.getShowFloatingToolbar() && windowInfo2.isWindowFocused()) {
                                                                    textFieldSelectionManager3.showSelectionToolbar$foundation_release();
                                                                } else {
                                                                    textFieldSelectionManager3.hideSelectionToolbar$foundation_release();
                                                                }
                                                                legacyTextFieldState5.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager3, true));
                                                                legacyTextFieldState5.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager3, false));
                                                                legacyTextFieldState5.setShowCursorHandle(TextRange.m20450getCollapsedimpl(textFieldValue.getSelection()));
                                                            } else if (legacyTextFieldState5.getHandleState() == HandleState.Cursor) {
                                                                legacyTextFieldState5.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager3, true));
                                                            }
                                                            CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState5, textFieldValue, offsetMapping4);
                                                            TextLayoutResultProxy layoutResult2 = legacyTextFieldState5.getLayoutResult();
                                                            if (layoutResult2 != null) {
                                                                LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState5;
                                                                TextFieldValue textFieldValue3 = textFieldValue;
                                                                OffsetMapping offsetMapping5 = offsetMapping4;
                                                                TextInputSession inputSession = legacyTextFieldState6.getInputSession();
                                                                if (inputSession == null || !legacyTextFieldState6.getHasFocus()) {
                                                                    return;
                                                                }
                                                                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue3, offsetMapping5, layoutResult2);
                                                            }
                                                        }
                                                    }
                                                };
                                                z14 = z13;
                                                windowInfo3 = windowInfo2;
                                                textFieldSelectionManager4 = textFieldSelectionManager3;
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                            } else {
                                                z14 = z13;
                                                windowInfo3 = windowInfo2;
                                                textFieldSelectionManager4 = textFieldSelectionManager3;
                                            }
                                            final Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue9);
                                            final VisualTransformation visualTransformation6 = visualTransformation4;
                                            z15 = visualTransformation6 instanceof PasswordVisualTransformation;
                                            zChangedInstance6 = composerStartRestartGroup.changedInstance(transformedText) | (i38 != 4) | (i39 != 2048) | composerStartRestartGroup.changed(z15) | (i41 != 16384) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager4) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32);
                                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance6 || objRememberedValue10 == companion.getEmpty()) {
                                                final TransformedText transformedText3 = transformedText;
                                                final ImeOptions imeOptions10 = imeOptions7;
                                                final TextFieldSelectionManager textFieldSelectionManager8 = textFieldSelectionManager4;
                                                final OffsetMapping offsetMapping5 = offsetMapping;
                                                final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                                final boolean z28 = z14;
                                                objRememberedValue10 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        invoke2(semanticsPropertyReceiver);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        SemanticsPropertyReceiver semanticsPropertyReceiver2 = semanticsPropertyReceiver;
                                                        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, transformedText3.getText());
                                                        SemanticsPropertiesKt.m20286setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                                        if (!z28) {
                                                            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                                        }
                                                        if (z15) {
                                                            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                        }
                                                        boolean z29 = z28 && !z24;
                                                        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z29);
                                                        final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState6;
                                                        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            @NotNull
                                                            public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
                                                                boolean z30;
                                                                if (legacyTextFieldState7.getLayoutResult() != null) {
                                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState7.getLayoutResult();
                                                                    Intrinsics.checkNotNull(layoutResult);
                                                                    list.add(layoutResult.getValue());
                                                                    z30 = true;
                                                                } else {
                                                                    z30 = false;
                                                                }
                                                                return Boolean.valueOf(z30);
                                                            }
                                                        }, 1, null);
                                                        if (z29) {
                                                            final LegacyTextFieldState legacyTextFieldState8 = legacyTextFieldState6;
                                                            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                @NotNull
                                                                public final Boolean invoke(@NotNull AnnotatedString annotatedString2) {
                                                                    Unit unit2;
                                                                    TextInputSession inputSession = legacyTextFieldState8.getInputSession();
                                                                    if (inputSession != null) {
                                                                        LegacyTextFieldState legacyTextFieldState9 = legacyTextFieldState8;
                                                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), legacyTextFieldState9.getProcessor(), legacyTextFieldState9.getOnValueChange(), inputSession);
                                                                        unit2 = Unit.INSTANCE;
                                                                    } else {
                                                                        unit2 = null;
                                                                    }
                                                                    if (unit2 == null) {
                                                                        legacyTextFieldState8.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                    }
                                                                    return Boolean.TRUE;
                                                                }
                                                            }, 1, null);
                                                            final boolean z30 = z24;
                                                            final boolean z31 = z28;
                                                            final LegacyTextFieldState legacyTextFieldState9 = legacyTextFieldState6;
                                                            final TextFieldValue textFieldValue3 = textFieldValue;
                                                            semanticsPropertyReceiver2 = semanticsPropertyReceiver;
                                                            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                @NotNull
                                                                public final Boolean invoke(@NotNull AnnotatedString annotatedString2) {
                                                                    Unit unit2;
                                                                    if (z30 || !z31) {
                                                                        return Boolean.FALSE;
                                                                    }
                                                                    TextInputSession inputSession = legacyTextFieldState9.getInputSession();
                                                                    if (inputSession != null) {
                                                                        LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), legacyTextFieldState10.getProcessor(), legacyTextFieldState10.getOnValueChange(), inputSession);
                                                                        unit2 = Unit.INSTANCE;
                                                                    } else {
                                                                        unit2 = null;
                                                                    }
                                                                    if (unit2 == null) {
                                                                        TextFieldValue textFieldValue4 = textFieldValue3;
                                                                        legacyTextFieldState9.getOnValueChange().invoke(new TextFieldValue(StringsKt__StringsKt.replaceRange((CharSequence) textFieldValue4.getText(), TextRange.m20456getStartimpl(textFieldValue4.getSelection()), TextRange.m20451getEndimpl(textFieldValue4.getSelection()), annotatedString2).toString(), TextRangeKt.TextRange(annotatedString2.length() + TextRange.m20456getStartimpl(textFieldValue4.getSelection())), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                    }
                                                                    return Boolean.TRUE;
                                                                }
                                                            }, 1, null);
                                                        }
                                                        final OffsetMapping offsetMapping6 = offsetMapping5;
                                                        final boolean z32 = z28;
                                                        final TextFieldValue textFieldValue4 = textFieldValue;
                                                        final TextFieldSelectionManager textFieldSelectionManager9 = textFieldSelectionManager8;
                                                        final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState6;
                                                        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                                            }

                                                            @NotNull
                                                            public final Boolean invoke(int i43, int i44, boolean z33) {
                                                                if (!z33) {
                                                                    i43 = offsetMapping6.transformedToOriginal(i43);
                                                                }
                                                                if (!z33) {
                                                                    i44 = offsetMapping6.transformedToOriginal(i44);
                                                                }
                                                                boolean z34 = false;
                                                                if (z32 && (i43 != TextRange.m20456getStartimpl(textFieldValue4.getSelection()) || i44 != TextRange.m20451getEndimpl(textFieldValue4.getSelection()))) {
                                                                    if (Math.min(i43, i44) < 0 || Math.max(i43, i44) > textFieldValue4.getAnnotatedString().length()) {
                                                                        textFieldSelectionManager9.exitSelectionMode$foundation_release();
                                                                    } else {
                                                                        if (z33 || i43 == i44) {
                                                                            textFieldSelectionManager9.exitSelectionMode$foundation_release();
                                                                        } else {
                                                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager9, false, 1, null);
                                                                        }
                                                                        legacyTextFieldState10.getOnValueChange().invoke(new TextFieldValue(textFieldValue4.getAnnotatedString(), TextRangeKt.TextRange(i43, i44), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                        z34 = true;
                                                                    }
                                                                }
                                                                return Boolean.valueOf(z34);
                                                            }
                                                        }, 1, null);
                                                        int imeAction = imeOptions10.getImeAction();
                                                        final LegacyTextFieldState legacyTextFieldState11 = legacyTextFieldState6;
                                                        final ImeOptions imeOptions11 = imeOptions10;
                                                        SemanticsPropertiesKt.m20281onImeAction9UiTYpY$default(semanticsPropertyReceiver2, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                legacyTextFieldState11.getOnImeActionPerformed().invoke(ImeAction.m20617boximpl(imeOptions11.getImeAction()));
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 2, null);
                                                        final LegacyTextFieldState legacyTextFieldState12 = legacyTextFieldState6;
                                                        final FocusRequester focusRequester5 = focusRequester2;
                                                        final boolean z33 = z24;
                                                        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                CoreTextFieldKt.tapToFocus(legacyTextFieldState12, focusRequester5, !z33);
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                        final TextFieldSelectionManager textFieldSelectionManager10 = textFieldSelectionManager8;
                                                        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager10, false, 1, null);
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                        if (!TextRange.m20450getCollapsedimpl(textFieldValue.getSelection()) && !z15) {
                                                            final TextFieldSelectionManager textFieldSelectionManager11 = textFieldSelectionManager8;
                                                            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                @Override // kotlin.jvm.functions.Function0
                                                                @NotNull
                                                                public final Boolean invoke() {
                                                                    TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager11, false, 1, null);
                                                                    return Boolean.TRUE;
                                                                }
                                                            }, 1, null);
                                                            if (z28 && !z24) {
                                                                final TextFieldSelectionManager textFieldSelectionManager12 = textFieldSelectionManager8;
                                                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    @NotNull
                                                                    public final Boolean invoke() {
                                                                        textFieldSelectionManager12.cut$foundation_release();
                                                                        return Boolean.TRUE;
                                                                    }
                                                                }, 1, null);
                                                            }
                                                        }
                                                        if (!z28 || z24) {
                                                            return;
                                                        }
                                                        final TextFieldSelectionManager textFieldSelectionManager13 = textFieldSelectionManager8;
                                                        SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                textFieldSelectionManager13.paste$foundation_release();
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                    }
                                                };
                                                z16 = z28;
                                                textFieldSelectionManager5 = textFieldSelectionManager8;
                                                focusRequester3 = focusRequester2;
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                            } else {
                                                textFieldSelectionManager5 = textFieldSelectionManager4;
                                                z16 = z14;
                                                focusRequester3 = focusRequester2;
                                            }
                                            Modifier modifierSemantics = SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue10);
                                            final OffsetMapping offsetMapping6 = offsetMapping;
                                            legacyTextFieldState2 = legacyTextFieldState;
                                            final Modifier modifierCursor = TextFieldCursorKt.cursor(companion2, legacyTextFieldState2, textFieldValue, offsetMapping6, brush5, (z16 || z24 || !windowInfo3.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                            zChangedInstance7 = composerStartRestartGroup.changedInstance(textFieldSelectionManager5);
                                            objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                            if (!zChangedInstance7 || objRememberedValue11 == companion.getEmpty()) {
                                                objRememberedValue11 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    @NotNull
                                                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                        final TextFieldSelectionManager textFieldSelectionManager9 = textFieldSelectionManager5;
                                                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                                            public void dispose() {
                                                                textFieldSelectionManager9.hideSelectionToolbar$foundation_release();
                                                            }
                                                        };
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                            }
                                            EffectsKt.DisposableEffect(textFieldSelectionManager5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue11, composerStartRestartGroup, 0);
                                            zChangedInstance8 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changedInstance(textInputService) | (i38 != 4) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32);
                                            objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance8 || objRememberedValue12 == companion.getEmpty()) {
                                                objRememberedValue12 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    @NotNull
                                                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                        if (legacyTextFieldState2.getHasFocus()) {
                                                            LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState2;
                                                            legacyTextFieldState7.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState7.getProcessor(), imeOptions7, legacyTextFieldState2.getOnValueChange(), legacyTextFieldState2.getOnImeActionPerformed()));
                                                        }
                                                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                                            public void dispose() {
                                                            }
                                                        };
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                            }
                                            EffectsKt.DisposableEffect(imeOptions7, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue12, composerStartRestartGroup, (i40 >> 3) & 14);
                                            final int i43 = i30;
                                            Modifier modifierM16248textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m16248textFieldKeyInput2WJ9YEU(companion2, legacyTextFieldState2, textFieldSelectionManager5, textFieldValue, legacyTextFieldState2.getOnValueChange(), !z24, i43 != 1, offsetMapping6, undoManager, imeOptions7.getImeAction());
                                            Modifier modifierTextFieldMagnifier = companion2;
                                            boolean zCoreTextField$lambda$11 = CoreTextField$lambda$11(state);
                                            zChangedInstance9 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                            objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance9 || objRememberedValue13 == companion.getEmpty()) {
                                                objRememberedValue13 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    @NotNull
                                                    public final Boolean invoke() {
                                                        if (!legacyTextFieldState2.getHasFocus()) {
                                                            focusRequester3.requestFocus();
                                                        }
                                                        int keyboardType = imeOptions7.getKeyboardType();
                                                        KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                                        if (!KeyboardType.m20673equalsimpl0(keyboardType, companion3.m20692getPasswordPjHm6EE()) && !KeyboardType.m20673equalsimpl0(imeOptions7.getKeyboardType(), companion3.m20691getNumberPasswordPjHm6EE())) {
                                                            legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
                                                        }
                                                        return Boolean.TRUE;
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                                            }
                                            Modifier modifier6 = modifier4;
                                            Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6, legacyPlatformTextInputServiceAdapter, legacyTextFieldState2, textFieldSelectionManager5).then(StylusHandwritingKt.stylusHandwriting(modifierTextFieldMagnifier, zCoreTextField$lambda$11, (Function0) objRememberedValue13)).then(modifierTextFieldFocusModifier), legacyTextFieldState2, focusManager), legacyTextFieldState2, textFieldSelectionManager5).then(modifierM16248textFieldKeyInput2WJ9YEU), textFieldScrollerPosition, mutableInteractionSource5, z16).then(modifierPointerHoverIcon$default).then(modifierSemantics), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@NotNull LayoutCoordinates layoutCoordinates) {
                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState2.getLayoutResult();
                                                    if (layoutResult == null) {
                                                        return;
                                                    }
                                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                }
                                            });
                                            z17 = !z16 && legacyTextFieldState2.getHasFocus() && legacyTextFieldState2.isInTouchMode() && windowInfo3.isWindowFocused();
                                            if (z17) {
                                                modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(modifierTextFieldMagnifier, textFieldSelectionManager5);
                                            }
                                            ImeOptions imeOptions11 = imeOptions7;
                                            final Modifier modifier7 = modifierTextFieldMagnifier;
                                            boolean z29 = z16;
                                            final TextFieldSelectionManager textFieldSelectionManager9 = textFieldSelectionManager5;
                                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = function3M16163getLambda1$foundation_release;
                                            final boolean z30 = z17;
                                            final TextStyle textStyle6 = textStyle3;
                                            final Density density3 = density;
                                            final BringIntoViewRequester bringIntoViewRequester3 = bringIntoViewRequester;
                                            CoreTextFieldRootBox(modifierOnGloballyPositioned2, textFieldSelectionManager9, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5
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
                                                public final void invoke(@Nullable Composer composer3, int i44) {
                                                    if ((i44 & 3) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-374338080, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                                    }
                                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function34 = function33;
                                                    final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState2;
                                                    final TextStyle textStyle7 = textStyle6;
                                                    final int i45 = i37;
                                                    final int i46 = i43;
                                                    final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                                    final TextFieldValue textFieldValue3 = textFieldValue;
                                                    final VisualTransformation visualTransformation7 = visualTransformation6;
                                                    final Modifier modifier8 = modifierCursor;
                                                    final Modifier modifier9 = modifierDrawBehind;
                                                    final Modifier modifier10 = modifierOnGloballyPositioned;
                                                    final Modifier modifier11 = modifier7;
                                                    final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester3;
                                                    final TextFieldSelectionManager textFieldSelectionManager10 = textFieldSelectionManager9;
                                                    final boolean z31 = z30;
                                                    final boolean z32 = z24;
                                                    final Function1<TextLayoutResult, Unit> function19 = function14;
                                                    final OffsetMapping offsetMapping7 = offsetMapping6;
                                                    final Density density4 = density3;
                                                    function34.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1
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

                                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                        @Composable
                                                        public final void invoke(@Nullable Composer composer4, int i47) {
                                                            if ((i47 & 3) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(2032502107, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                                            }
                                                            Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m15887heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState7.m16187getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle7, i45, i46);
                                                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                            TextFieldValue textFieldValue4 = textFieldValue3;
                                                            VisualTransformation visualTransformation8 = visualTransformation7;
                                                            boolean zChangedInstance11 = composer4.changedInstance(legacyTextFieldState7);
                                                            final LegacyTextFieldState legacyTextFieldState8 = legacyTextFieldState7;
                                                            Object objRememberedValue21 = composer4.rememberedValue();
                                                            if (zChangedInstance11 || objRememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                                objRememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    @Nullable
                                                                    public final TextLayoutResultProxy invoke() {
                                                                        return legacyTextFieldState8.getLayoutResult();
                                                                    }
                                                                };
                                                                composer4.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            Modifier modifierBringIntoViewRequester = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition3, textFieldValue4, visualTransformation8, (Function0) objRememberedValue21).then(modifier8).then(modifier9), textStyle7).then(modifier10).then(modifier11), bringIntoViewRequester4);
                                                            final TextFieldSelectionManager textFieldSelectionManager11 = textFieldSelectionManager10;
                                                            final LegacyTextFieldState legacyTextFieldState9 = legacyTextFieldState7;
                                                            final boolean z33 = z31;
                                                            final boolean z34 = z32;
                                                            final Function1<TextLayoutResult, Unit> function110 = function19;
                                                            final TextFieldValue textFieldValue5 = textFieldValue3;
                                                            final OffsetMapping offsetMapping8 = offsetMapping7;
                                                            final Density density5 = density4;
                                                            final int i48 = i46;
                                                            SimpleLayoutKt.SimpleLayout(modifierBringIntoViewRequester, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                                                /* JADX WARN: Removed duplicated region for block: B:33:0x00be  */
                                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                                @Composable
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final void invoke(@Nullable Composer composer5, int i49) {
                                                                    boolean z35;
                                                                    if ((i49 & 3) == 2 && composer5.getSkipping()) {
                                                                        composer5.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-363167407, i49, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                                    }
                                                                    final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                    final Function1<TextLayoutResult, Unit> function111 = function110;
                                                                    final TextFieldValue textFieldValue6 = textFieldValue5;
                                                                    final OffsetMapping offsetMapping9 = offsetMapping8;
                                                                    final Density density6 = density5;
                                                                    final int i50 = i48;
                                                                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                        @Override // androidx.compose.p109ui.layout.MeasurePolicy
                                                                        public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i51) {
                                                                            legacyTextFieldState10.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                            return legacyTextFieldState10.getTextDelegate().getMaxIntrinsicWidth();
                                                                        }

                                                                        @Override // androidx.compose.p109ui.layout.MeasurePolicy
                                                                        @NotNull
                                                                        /* JADX INFO: renamed from: measure-3p2s80s */
                                                                        public MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                                                                            Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                                            LegacyTextFieldState legacyTextFieldState11 = legacyTextFieldState10;
                                                                            Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                            Snapshot snapshotMakeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                                            try {
                                                                                TextLayoutResultProxy layoutResult = legacyTextFieldState11.getLayoutResult();
                                                                                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                Triple<Integer, Integer, TextLayoutResult> tripleM16240layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m16240layout_EkL_Y$foundation_release(legacyTextFieldState10.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                int iIntValue = tripleM16240layout_EkL_Y$foundation_release.component1().intValue();
                                                                                int iIntValue2 = tripleM16240layout_EkL_Y$foundation_release.component2().intValue();
                                                                                TextLayoutResult textLayoutResultComponent3 = tripleM16240layout_EkL_Y$foundation_release.component3();
                                                                                if (!Intrinsics.areEqual(value, textLayoutResultComponent3)) {
                                                                                    legacyTextFieldState10.setLayoutResult(new TextLayoutResultProxy(textLayoutResultComponent3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                    function111.invoke(textLayoutResultComponent3);
                                                                                    CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState10, textFieldValue6, offsetMapping9);
                                                                                }
                                                                                legacyTextFieldState10.m16191setMinHeightForSingleLineField0680j_4(density6.mo15543toDpu2uoSUM(i50 == 1 ? TextDelegateKt.ceilToIntPx(textLayoutResultComponent3.getLineBottom(0)) : 0));
                                                                                return measureScope.layout(iIntValue, iIntValue2, MapsKt.mapOf(TuplesKt.m13893to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResultComponent3.getFirstBaseline()))), TuplesKt.m13893to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResultComponent3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                        invoke2(placementScope);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            } finally {
                                                                                companion3.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                                                            }
                                                                        }
                                                                    };
                                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                    if (composer5.getApplier() == null) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer5);
                                                                    Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                                    Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                    if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                                                    }
                                                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                                                                    composer5.endNode();
                                                                    TextFieldSelectionManager textFieldSelectionManager12 = textFieldSelectionManager11;
                                                                    if (legacyTextFieldState9.getHandleState() == HandleState.None || legacyTextFieldState9.getLayoutCoordinates() == null) {
                                                                        z35 = false;
                                                                    } else {
                                                                        LayoutCoordinates layoutCoordinates = legacyTextFieldState9.getLayoutCoordinates();
                                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                                        if (layoutCoordinates.isAttached() && z33) {
                                                                            z35 = true;
                                                                        }
                                                                    }
                                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager12, z35, composer5, 0);
                                                                    if (legacyTextFieldState9.getHandleState() == HandleState.Cursor && !z34 && z33) {
                                                                        composer5.startReplaceGroup(-2032274);
                                                                        CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager11, composer5, 0);
                                                                        composer5.endReplaceGroup();
                                                                    } else {
                                                                        composer5.startReplaceGroup(-1955394);
                                                                        composer5.endReplaceGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, composer4, 54), composer4, 48, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, composer3, 54), composer3, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            function32 = function33;
                                            i31 = i37;
                                            composer2 = composerStartRestartGroup;
                                            function15 = function14;
                                            imeOptions8 = imeOptions11;
                                            z18 = z25;
                                            mutableInteractionSource4 = mutableInteractionSource5;
                                            keyboardActions3 = keyboardActions4;
                                            i32 = i43;
                                            solidColor = brush5;
                                            modifier5 = modifier6;
                                            z19 = z24;
                                            textStyle4 = textStyle3;
                                            visualTransformation5 = visualTransformation6;
                                            z20 = z29;
                                        } else {
                                            imeOptions6 = imeOptions5;
                                        }
                                        z10 = true;
                                        z11 = zChanged3 | z10;
                                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                        if (z11) {
                                            ImeOptions imeOptions92 = imeOptions6;
                                            objRememberedValue5 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, stateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions92, null);
                                            state = stateRememberUpdatedState;
                                            imeOptions7 = imeOptions92;
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composerStartRestartGroup, 6);
                                            zChangedInstance2 = composerStartRestartGroup.changedInstance(legacyTextFieldState);
                                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                            if (!zChangedInstance2) {
                                                objRememberedValue6 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                        invoke(bool.booleanValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(boolean z282) {
                                                        legacyTextFieldState.setInTouchMode(z282);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                                Modifier modifierUpdateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) objRememberedValue6);
                                                zChangedInstance3 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i41 != 16384) | (i39 != 2048) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                                                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance3) {
                                                    final TextFieldSelectionManager textFieldSelectionManager72 = textFieldSelectionManager;
                                                    final OffsetMapping offsetMapping32 = offsetMapping;
                                                    final LegacyTextFieldState legacyTextFieldState42 = legacyTextFieldState;
                                                    objRememberedValue7 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                            m16164invokek4lQ0M(offset.getPackedValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                                        public final void m16164invokek4lQ0M(long j) {
                                                            CoreTextFieldKt.tapToFocus(legacyTextFieldState42, focusRequester4, !z24);
                                                            if (legacyTextFieldState42.getHasFocus() && z27) {
                                                                if (legacyTextFieldState42.getHandleState() == HandleState.Selection) {
                                                                    textFieldSelectionManager72.m16567deselect_kEHs6E$foundation_release(Offset.m18273boximpl(j));
                                                                    return;
                                                                }
                                                                TextLayoutResultProxy layoutResult = legacyTextFieldState42.getLayoutResult();
                                                                if (layoutResult != null) {
                                                                    LegacyTextFieldState legacyTextFieldState52 = legacyTextFieldState42;
                                                                    TextFieldDelegate.INSTANCE.m16241setCursorOffsetULxng0E$foundation_release(j, layoutResult, legacyTextFieldState52.getProcessor(), offsetMapping32, legacyTextFieldState52.getOnValueChange());
                                                                    if (legacyTextFieldState52.getTextDelegate().getText().length() > 0) {
                                                                        legacyTextFieldState52.setHandleState(HandleState.Cursor);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    };
                                                    focusRequester = focusRequester4;
                                                    z12 = z27;
                                                    textFieldSelectionManager2 = textFieldSelectionManager72;
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                                    z13 = z12;
                                                    MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                                    focusRequester2 = focusRequester;
                                                    Modifier modifierPointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifierUpdateSelectionTouchMode2, mutableInteractionSource3, z12, (Function1) objRememberedValue7), textFieldSelectionManager2.getMouseSelectionObserver(), textFieldSelectionManager2.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                                    zChangedInstance4 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i38 != 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                                    if (!zChangedInstance4) {
                                                        objRememberedValue8 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                                invoke2(drawScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(@NotNull DrawScope drawScope) {
                                                                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                                                                if (layoutResult != null) {
                                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                                    LegacyTextFieldState legacyTextFieldState52 = legacyTextFieldState;
                                                                    OffsetMapping offsetMapping42 = offsetMapping;
                                                                    TextFieldDelegate.INSTANCE.m16239drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue3, legacyTextFieldState52.m16189getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState52.m16186getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping42, layoutResult.getValue(), legacyTextFieldState52.getHighlightPaint(), legacyTextFieldState52.getSelectionBackgroundColor());
                                                                }
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                                        final Modifier modifierDrawBehind2 = DrawModifierKt.drawBehind(companion2, (Function1) objRememberedValue8);
                                                        windowInfo2 = windowInfo;
                                                        textFieldSelectionManager3 = textFieldSelectionManager2;
                                                        zChangedInstance5 = (i38 != 4) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i39 != 2048) | composerStartRestartGroup.changed(windowInfo2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager3) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance5) {
                                                            final OffsetMapping offsetMapping42 = offsetMapping;
                                                            final LegacyTextFieldState legacyTextFieldState52 = legacyTextFieldState;
                                                            objRememberedValue9 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                    invoke2(layoutCoordinates);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(@NotNull LayoutCoordinates layoutCoordinates) {
                                                                    legacyTextFieldState52.setLayoutCoordinates(layoutCoordinates);
                                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState52.getLayoutResult();
                                                                    if (layoutResult != null) {
                                                                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                                    }
                                                                    if (z13) {
                                                                        if (legacyTextFieldState52.getHandleState() == HandleState.Selection) {
                                                                            if (legacyTextFieldState52.getShowFloatingToolbar() && windowInfo2.isWindowFocused()) {
                                                                                textFieldSelectionManager3.showSelectionToolbar$foundation_release();
                                                                            } else {
                                                                                textFieldSelectionManager3.hideSelectionToolbar$foundation_release();
                                                                            }
                                                                            legacyTextFieldState52.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager3, true));
                                                                            legacyTextFieldState52.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager3, false));
                                                                            legacyTextFieldState52.setShowCursorHandle(TextRange.m20450getCollapsedimpl(textFieldValue.getSelection()));
                                                                        } else if (legacyTextFieldState52.getHandleState() == HandleState.Cursor) {
                                                                            legacyTextFieldState52.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager3, true));
                                                                        }
                                                                        CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState52, textFieldValue, offsetMapping42);
                                                                        TextLayoutResultProxy layoutResult2 = legacyTextFieldState52.getLayoutResult();
                                                                        if (layoutResult2 != null) {
                                                                            LegacyTextFieldState legacyTextFieldState62 = legacyTextFieldState52;
                                                                            TextFieldValue textFieldValue3 = textFieldValue;
                                                                            OffsetMapping offsetMapping52 = offsetMapping42;
                                                                            TextInputSession inputSession = legacyTextFieldState62.getInputSession();
                                                                            if (inputSession == null || !legacyTextFieldState62.getHasFocus()) {
                                                                                return;
                                                                            }
                                                                            TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue3, offsetMapping52, layoutResult2);
                                                                        }
                                                                    }
                                                                }
                                                            };
                                                            z14 = z13;
                                                            windowInfo3 = windowInfo2;
                                                            textFieldSelectionManager4 = textFieldSelectionManager3;
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                                            final Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue9);
                                                            final VisualTransformation visualTransformation62 = visualTransformation4;
                                                            z15 = visualTransformation62 instanceof PasswordVisualTransformation;
                                                            if (i42 <= 32) {
                                                                zChangedInstance6 = composerStartRestartGroup.changedInstance(transformedText) | (i38 != 4) | (i39 != 2048) | composerStartRestartGroup.changed(z15) | (i41 != 16384) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager4) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32);
                                                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                                                if (zChangedInstance6) {
                                                                    final TransformedText transformedText32 = transformedText;
                                                                    final ImeOptions imeOptions102 = imeOptions7;
                                                                    final TextFieldSelectionManager textFieldSelectionManager82 = textFieldSelectionManager4;
                                                                    final OffsetMapping offsetMapping52 = offsetMapping;
                                                                    final LegacyTextFieldState legacyTextFieldState62 = legacyTextFieldState;
                                                                    final boolean z282 = z14;
                                                                    objRememberedValue10 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                            invoke2(semanticsPropertyReceiver);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(@NotNull final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                            SemanticsPropertyReceiver semanticsPropertyReceiver2 = semanticsPropertyReceiver;
                                                                            SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, transformedText32.getText());
                                                                            SemanticsPropertiesKt.m20286setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                                                            if (!z282) {
                                                                                SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                                                            }
                                                                            if (z15) {
                                                                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                                            }
                                                                            boolean z292 = z282 && !z24;
                                                                            SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z292);
                                                                            final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState62;
                                                                            SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                @NotNull
                                                                                public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
                                                                                    boolean z302;
                                                                                    if (legacyTextFieldState7.getLayoutResult() != null) {
                                                                                        TextLayoutResultProxy layoutResult = legacyTextFieldState7.getLayoutResult();
                                                                                        Intrinsics.checkNotNull(layoutResult);
                                                                                        list.add(layoutResult.getValue());
                                                                                        z302 = true;
                                                                                    } else {
                                                                                        z302 = false;
                                                                                    }
                                                                                    return Boolean.valueOf(z302);
                                                                                }
                                                                            }, 1, null);
                                                                            if (z292) {
                                                                                final LegacyTextFieldState legacyTextFieldState8 = legacyTextFieldState62;
                                                                                SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    @NotNull
                                                                                    public final Boolean invoke(@NotNull AnnotatedString annotatedString2) {
                                                                                        Unit unit2;
                                                                                        TextInputSession inputSession = legacyTextFieldState8.getInputSession();
                                                                                        if (inputSession != null) {
                                                                                            LegacyTextFieldState legacyTextFieldState9 = legacyTextFieldState8;
                                                                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), legacyTextFieldState9.getProcessor(), legacyTextFieldState9.getOnValueChange(), inputSession);
                                                                                            unit2 = Unit.INSTANCE;
                                                                                        } else {
                                                                                            unit2 = null;
                                                                                        }
                                                                                        if (unit2 == null) {
                                                                                            legacyTextFieldState8.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                                        }
                                                                                        return Boolean.TRUE;
                                                                                    }
                                                                                }, 1, null);
                                                                                final boolean z302 = z24;
                                                                                final boolean z31 = z282;
                                                                                final LegacyTextFieldState legacyTextFieldState9 = legacyTextFieldState62;
                                                                                final TextFieldValue textFieldValue3 = textFieldValue;
                                                                                semanticsPropertyReceiver2 = semanticsPropertyReceiver;
                                                                                SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    @NotNull
                                                                                    public final Boolean invoke(@NotNull AnnotatedString annotatedString2) {
                                                                                        Unit unit2;
                                                                                        if (z302 || !z31) {
                                                                                            return Boolean.FALSE;
                                                                                        }
                                                                                        TextInputSession inputSession = legacyTextFieldState9.getInputSession();
                                                                                        if (inputSession != null) {
                                                                                            LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), legacyTextFieldState10.getProcessor(), legacyTextFieldState10.getOnValueChange(), inputSession);
                                                                                            unit2 = Unit.INSTANCE;
                                                                                        } else {
                                                                                            unit2 = null;
                                                                                        }
                                                                                        if (unit2 == null) {
                                                                                            TextFieldValue textFieldValue4 = textFieldValue3;
                                                                                            legacyTextFieldState9.getOnValueChange().invoke(new TextFieldValue(StringsKt__StringsKt.replaceRange((CharSequence) textFieldValue4.getText(), TextRange.m20456getStartimpl(textFieldValue4.getSelection()), TextRange.m20451getEndimpl(textFieldValue4.getSelection()), annotatedString2).toString(), TextRangeKt.TextRange(annotatedString2.length() + TextRange.m20456getStartimpl(textFieldValue4.getSelection())), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                                        }
                                                                                        return Boolean.TRUE;
                                                                                    }
                                                                                }, 1, null);
                                                                            }
                                                                            final OffsetMapping offsetMapping62 = offsetMapping52;
                                                                            final boolean z32 = z282;
                                                                            final TextFieldValue textFieldValue4 = textFieldValue;
                                                                            final TextFieldSelectionManager textFieldSelectionManager92 = textFieldSelectionManager82;
                                                                            final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState62;
                                                                            SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                                                    return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                                                                }

                                                                                @NotNull
                                                                                public final Boolean invoke(int i432, int i44, boolean z33) {
                                                                                    if (!z33) {
                                                                                        i432 = offsetMapping62.transformedToOriginal(i432);
                                                                                    }
                                                                                    if (!z33) {
                                                                                        i44 = offsetMapping62.transformedToOriginal(i44);
                                                                                    }
                                                                                    boolean z34 = false;
                                                                                    if (z32 && (i432 != TextRange.m20456getStartimpl(textFieldValue4.getSelection()) || i44 != TextRange.m20451getEndimpl(textFieldValue4.getSelection()))) {
                                                                                        if (Math.min(i432, i44) < 0 || Math.max(i432, i44) > textFieldValue4.getAnnotatedString().length()) {
                                                                                            textFieldSelectionManager92.exitSelectionMode$foundation_release();
                                                                                        } else {
                                                                                            if (z33 || i432 == i44) {
                                                                                                textFieldSelectionManager92.exitSelectionMode$foundation_release();
                                                                                            } else {
                                                                                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager92, false, 1, null);
                                                                                            }
                                                                                            legacyTextFieldState10.getOnValueChange().invoke(new TextFieldValue(textFieldValue4.getAnnotatedString(), TextRangeKt.TextRange(i432, i44), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                                            z34 = true;
                                                                                        }
                                                                                    }
                                                                                    return Boolean.valueOf(z34);
                                                                                }
                                                                            }, 1, null);
                                                                            int imeAction = imeOptions102.getImeAction();
                                                                            final LegacyTextFieldState legacyTextFieldState11 = legacyTextFieldState62;
                                                                            final ImeOptions imeOptions112 = imeOptions102;
                                                                            SemanticsPropertiesKt.m20281onImeAction9UiTYpY$default(semanticsPropertyReceiver2, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                @NotNull
                                                                                public final Boolean invoke() {
                                                                                    legacyTextFieldState11.getOnImeActionPerformed().invoke(ImeAction.m20617boximpl(imeOptions112.getImeAction()));
                                                                                    return Boolean.TRUE;
                                                                                }
                                                                            }, 2, null);
                                                                            final LegacyTextFieldState legacyTextFieldState12 = legacyTextFieldState62;
                                                                            final FocusRequester focusRequester5 = focusRequester2;
                                                                            final boolean z33 = z24;
                                                                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                @NotNull
                                                                                public final Boolean invoke() {
                                                                                    CoreTextFieldKt.tapToFocus(legacyTextFieldState12, focusRequester5, !z33);
                                                                                    return Boolean.TRUE;
                                                                                }
                                                                            }, 1, null);
                                                                            final TextFieldSelectionManager textFieldSelectionManager10 = textFieldSelectionManager82;
                                                                            SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                @NotNull
                                                                                public final Boolean invoke() {
                                                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager10, false, 1, null);
                                                                                    return Boolean.TRUE;
                                                                                }
                                                                            }, 1, null);
                                                                            if (!TextRange.m20450getCollapsedimpl(textFieldValue.getSelection()) && !z15) {
                                                                                final TextFieldSelectionManager textFieldSelectionManager11 = textFieldSelectionManager82;
                                                                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    @NotNull
                                                                                    public final Boolean invoke() {
                                                                                        TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager11, false, 1, null);
                                                                                        return Boolean.TRUE;
                                                                                    }
                                                                                }, 1, null);
                                                                                if (z282 && !z24) {
                                                                                    final TextFieldSelectionManager textFieldSelectionManager12 = textFieldSelectionManager82;
                                                                                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        @NotNull
                                                                                        public final Boolean invoke() {
                                                                                            textFieldSelectionManager12.cut$foundation_release();
                                                                                            return Boolean.TRUE;
                                                                                        }
                                                                                    }, 1, null);
                                                                                }
                                                                            }
                                                                            if (!z282 || z24) {
                                                                                return;
                                                                            }
                                                                            final TextFieldSelectionManager textFieldSelectionManager13 = textFieldSelectionManager82;
                                                                            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                @NotNull
                                                                                public final Boolean invoke() {
                                                                                    textFieldSelectionManager13.paste$foundation_release();
                                                                                    return Boolean.TRUE;
                                                                                }
                                                                            }, 1, null);
                                                                        }
                                                                    };
                                                                    z16 = z282;
                                                                    textFieldSelectionManager5 = textFieldSelectionManager82;
                                                                    focusRequester3 = focusRequester2;
                                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                                                    Modifier modifierSemantics2 = SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue10);
                                                                    if (z16) {
                                                                        final OffsetMapping offsetMapping62 = offsetMapping;
                                                                        legacyTextFieldState2 = legacyTextFieldState;
                                                                        final Modifier modifierCursor2 = TextFieldCursorKt.cursor(companion2, legacyTextFieldState2, textFieldValue, offsetMapping62, brush5, (z16 || z24 || !windowInfo3.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                                                        zChangedInstance7 = composerStartRestartGroup.changedInstance(textFieldSelectionManager5);
                                                                        objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                                                        if (!zChangedInstance7) {
                                                                            objRememberedValue11 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                @NotNull
                                                                                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                                                    final TextFieldSelectionManager textFieldSelectionManager92 = textFieldSelectionManager5;
                                                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                                        public void dispose() {
                                                                                            textFieldSelectionManager92.hideSelectionToolbar$foundation_release();
                                                                                        }
                                                                                    };
                                                                                }
                                                                            };
                                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                                                            EffectsKt.DisposableEffect(textFieldSelectionManager5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue11, composerStartRestartGroup, 0);
                                                                            if (i42 <= 32) {
                                                                                zChangedInstance8 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changedInstance(textInputService) | (i38 != 4) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32);
                                                                                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                                                                if (zChangedInstance8) {
                                                                                    objRememberedValue12 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        @NotNull
                                                                                        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                                                            if (legacyTextFieldState2.getHasFocus()) {
                                                                                                LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState2;
                                                                                                legacyTextFieldState7.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState7.getProcessor(), imeOptions7, legacyTextFieldState2.getOnValueChange(), legacyTextFieldState2.getOnImeActionPerformed()));
                                                                                            }
                                                                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                                                                public void dispose() {
                                                                                                }
                                                                                            };
                                                                                        }
                                                                                    };
                                                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                                                                    EffectsKt.DisposableEffect(imeOptions7, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue12, composerStartRestartGroup, (i40 >> 3) & 14);
                                                                                    final int i432 = i30;
                                                                                    Modifier modifierM16248textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m16248textFieldKeyInput2WJ9YEU(companion2, legacyTextFieldState2, textFieldSelectionManager5, textFieldValue, legacyTextFieldState2.getOnValueChange(), !z24, i432 != 1, offsetMapping62, undoManager, imeOptions7.getImeAction());
                                                                                    Modifier modifierTextFieldMagnifier2 = companion2;
                                                                                    boolean zCoreTextField$lambda$112 = CoreTextField$lambda$11(state);
                                                                                    if (i42 <= 32) {
                                                                                        zChangedInstance9 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                                                                        objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                                                                        if (zChangedInstance9) {
                                                                                            objRememberedValue13 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                @NotNull
                                                                                                public final Boolean invoke() {
                                                                                                    if (!legacyTextFieldState2.getHasFocus()) {
                                                                                                        focusRequester3.requestFocus();
                                                                                                    }
                                                                                                    int keyboardType = imeOptions7.getKeyboardType();
                                                                                                    KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                                                                                    if (!KeyboardType.m20673equalsimpl0(keyboardType, companion3.m20692getPasswordPjHm6EE()) && !KeyboardType.m20673equalsimpl0(imeOptions7.getKeyboardType(), companion3.m20691getNumberPasswordPjHm6EE())) {
                                                                                                        legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
                                                                                                    }
                                                                                                    return Boolean.TRUE;
                                                                                                }
                                                                                            };
                                                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                                                                                            Modifier modifier62 = modifier4;
                                                                                            Modifier modifierOnGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier62, legacyPlatformTextInputServiceAdapter, legacyTextFieldState2, textFieldSelectionManager5).then(StylusHandwritingKt.stylusHandwriting(modifierTextFieldMagnifier2, zCoreTextField$lambda$112, (Function0) objRememberedValue13)).then(modifierTextFieldFocusModifier), legacyTextFieldState2, focusManager), legacyTextFieldState2, textFieldSelectionManager5).then(modifierM16248textFieldKeyInput2WJ9YEU2), textFieldScrollerPosition, mutableInteractionSource52, z16).then(modifierPointerHoverIcon$default2).then(modifierSemantics2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                                                    invoke2(layoutCoordinates);
                                                                                                    return Unit.INSTANCE;
                                                                                                }

                                                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                                public final void invoke2(@NotNull LayoutCoordinates layoutCoordinates) {
                                                                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState2.getLayoutResult();
                                                                                                    if (layoutResult == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                                                                }
                                                                                            });
                                                                                            if (z16) {
                                                                                                if (z17) {
                                                                                                }
                                                                                                ImeOptions imeOptions112 = imeOptions7;
                                                                                                final Modifier modifier72 = modifierTextFieldMagnifier2;
                                                                                                boolean z292 = z16;
                                                                                                final TextFieldSelectionManager textFieldSelectionManager92 = textFieldSelectionManager5;
                                                                                                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function332 = function3M16163getLambda1$foundation_release;
                                                                                                final boolean z302 = z17;
                                                                                                final TextStyle textStyle62 = textStyle3;
                                                                                                final Density density32 = density;
                                                                                                final BringIntoViewRequester bringIntoViewRequester32 = bringIntoViewRequester;
                                                                                                CoreTextFieldRootBox(modifierOnGloballyPositioned22, textFieldSelectionManager92, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5
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
                                                                                                    public final void invoke(@Nullable Composer composer3, int i44) {
                                                                                                        if ((i44 & 3) == 2 && composer3.getSkipping()) {
                                                                                                            composer3.skipToGroupEnd();
                                                                                                            return;
                                                                                                        }
                                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                                            ComposerKt.traceEventStart(-374338080, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                                                                                        }
                                                                                                        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function34 = function332;
                                                                                                        final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState2;
                                                                                                        final TextStyle textStyle7 = textStyle62;
                                                                                                        final int i45 = i37;
                                                                                                        final int i46 = i432;
                                                                                                        final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                                                                                        final TextFieldValue textFieldValue3 = textFieldValue;
                                                                                                        final VisualTransformation visualTransformation7 = visualTransformation62;
                                                                                                        final Modifier modifier8 = modifierCursor2;
                                                                                                        final Modifier modifier9 = modifierDrawBehind2;
                                                                                                        final Modifier modifier10 = modifierOnGloballyPositioned3;
                                                                                                        final Modifier modifier11 = modifier72;
                                                                                                        final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester32;
                                                                                                        final TextFieldSelectionManager textFieldSelectionManager10 = textFieldSelectionManager92;
                                                                                                        final boolean z31 = z302;
                                                                                                        final boolean z32 = z24;
                                                                                                        final Function1<? super TextLayoutResult, Unit> function19 = function14;
                                                                                                        final OffsetMapping offsetMapping7 = offsetMapping62;
                                                                                                        final Density density4 = density32;
                                                                                                        function34.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1
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

                                                                                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                                                                            @Composable
                                                                                                            public final void invoke(@Nullable Composer composer4, int i47) {
                                                                                                                if ((i47 & 3) == 2 && composer4.getSkipping()) {
                                                                                                                    composer4.skipToGroupEnd();
                                                                                                                    return;
                                                                                                                }
                                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                                    ComposerKt.traceEventStart(2032502107, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                                                                                                }
                                                                                                                Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m15887heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState7.m16187getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle7, i45, i46);
                                                                                                                TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                                                                                TextFieldValue textFieldValue4 = textFieldValue3;
                                                                                                                VisualTransformation visualTransformation8 = visualTransformation7;
                                                                                                                boolean zChangedInstance11 = composer4.changedInstance(legacyTextFieldState7);
                                                                                                                final LegacyTextFieldState legacyTextFieldState8 = legacyTextFieldState7;
                                                                                                                Object objRememberedValue21 = composer4.rememberedValue();
                                                                                                                if (zChangedInstance11 || objRememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                                                                                    objRememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                                                                        {
                                                                                                                            super(0);
                                                                                                                        }

                                                                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                                                        @Nullable
                                                                                                                        public final TextLayoutResultProxy invoke() {
                                                                                                                            return legacyTextFieldState8.getLayoutResult();
                                                                                                                        }
                                                                                                                    };
                                                                                                                    composer4.updateRememberedValue(objRememberedValue21);
                                                                                                                }
                                                                                                                Modifier modifierBringIntoViewRequester = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition3, textFieldValue4, visualTransformation8, (Function0) objRememberedValue21).then(modifier8).then(modifier9), textStyle7).then(modifier10).then(modifier11), bringIntoViewRequester4);
                                                                                                                final TextFieldSelectionManager textFieldSelectionManager11 = textFieldSelectionManager10;
                                                                                                                final LegacyTextFieldState legacyTextFieldState9 = legacyTextFieldState7;
                                                                                                                final boolean z33 = z31;
                                                                                                                final boolean z34 = z32;
                                                                                                                final Function1<? super TextLayoutResult, Unit> function110 = function19;
                                                                                                                final TextFieldValue textFieldValue5 = textFieldValue3;
                                                                                                                final OffsetMapping offsetMapping8 = offsetMapping7;
                                                                                                                final Density density5 = density4;
                                                                                                                final int i48 = i46;
                                                                                                                SimpleLayoutKt.SimpleLayout(modifierBringIntoViewRequester, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                                                                                                    /* JADX WARN: Removed duplicated region for block: B:33:0x00be  */
                                                                                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                                                                                    @Composable
                                                                                                                    /*
                                                                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                                                                    */
                                                                                                                    public final void invoke(@Nullable Composer composer5, int i49) {
                                                                                                                        boolean z35;
                                                                                                                        if ((i49 & 3) == 2 && composer5.getSkipping()) {
                                                                                                                            composer5.skipToGroupEnd();
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                                                            ComposerKt.traceEventStart(-363167407, i49, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                                                                                        }
                                                                                                                        final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                                                                        final Function1<? super TextLayoutResult, Unit> function111 = function110;
                                                                                                                        final TextFieldValue textFieldValue6 = textFieldValue5;
                                                                                                                        final OffsetMapping offsetMapping9 = offsetMapping8;
                                                                                                                        final Density density6 = density5;
                                                                                                                        final int i50 = i48;
                                                                                                                        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                                                                            @Override // androidx.compose.p109ui.layout.MeasurePolicy
                                                                                                                            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i51) {
                                                                                                                                legacyTextFieldState10.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                                                                                return legacyTextFieldState10.getTextDelegate().getMaxIntrinsicWidth();
                                                                                                                            }

                                                                                                                            @Override // androidx.compose.p109ui.layout.MeasurePolicy
                                                                                                                            @NotNull
                                                                                                                            /* JADX INFO: renamed from: measure-3p2s80s */
                                                                                                                            public MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                                                                                                                                Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                                                                                                LegacyTextFieldState legacyTextFieldState11 = legacyTextFieldState10;
                                                                                                                                Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                                                                                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                                                                                Snapshot snapshotMakeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                                                                                                try {
                                                                                                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState11.getLayoutResult();
                                                                                                                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                                                                    Triple<Integer, Integer, TextLayoutResult> tripleM16240layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m16240layout_EkL_Y$foundation_release(legacyTextFieldState10.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                                                                    int iIntValue = tripleM16240layout_EkL_Y$foundation_release.component1().intValue();
                                                                                                                                    int iIntValue2 = tripleM16240layout_EkL_Y$foundation_release.component2().intValue();
                                                                                                                                    TextLayoutResult textLayoutResultComponent3 = tripleM16240layout_EkL_Y$foundation_release.component3();
                                                                                                                                    if (!Intrinsics.areEqual(value, textLayoutResultComponent3)) {
                                                                                                                                        legacyTextFieldState10.setLayoutResult(new TextLayoutResultProxy(textLayoutResultComponent3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                                                                        function111.invoke(textLayoutResultComponent3);
                                                                                                                                        CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState10, textFieldValue6, offsetMapping9);
                                                                                                                                    }
                                                                                                                                    legacyTextFieldState10.m16191setMinHeightForSingleLineField0680j_4(density6.mo15543toDpu2uoSUM(i50 == 1 ? TextDelegateKt.ceilToIntPx(textLayoutResultComponent3.getLineBottom(0)) : 0));
                                                                                                                                    return measureScope.layout(iIntValue, iIntValue2, MapsKt.mapOf(TuplesKt.m13893to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResultComponent3.getFirstBaseline()))), TuplesKt.m13893to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResultComponent3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                                                                        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                                                                                                                        }

                                                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                                                                            invoke2(placementScope);
                                                                                                                                            return Unit.INSTANCE;
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                } finally {
                                                                                                                                    companion3.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        };
                                                                                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                                                                                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                                                                        Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                                                                        if (composer5.getApplier() == null) {
                                                                                                                            ComposablesKt.invalidApplier();
                                                                                                                        }
                                                                                                                        composer5.startReusableNode();
                                                                                                                        if (composer5.getInserting()) {
                                                                                                                            composer5.createNode(constructor);
                                                                                                                        } else {
                                                                                                                            composer5.useNode();
                                                                                                                        }
                                                                                                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer5);
                                                                                                                        Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                                                                                        Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                                                                        if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                                                                            AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                                                                                                                        }
                                                                                                                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                                                                                                                        composer5.endNode();
                                                                                                                        TextFieldSelectionManager textFieldSelectionManager12 = textFieldSelectionManager11;
                                                                                                                        if (legacyTextFieldState9.getHandleState() == HandleState.None || legacyTextFieldState9.getLayoutCoordinates() == null) {
                                                                                                                            z35 = false;
                                                                                                                        } else {
                                                                                                                            LayoutCoordinates layoutCoordinates = legacyTextFieldState9.getLayoutCoordinates();
                                                                                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                                                                                            if (layoutCoordinates.isAttached() && z33) {
                                                                                                                                z35 = true;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager12, z35, composer5, 0);
                                                                                                                        if (legacyTextFieldState9.getHandleState() == HandleState.Cursor && !z34 && z33) {
                                                                                                                            composer5.startReplaceGroup(-2032274);
                                                                                                                            CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager11, composer5, 0);
                                                                                                                            composer5.endReplaceGroup();
                                                                                                                        } else {
                                                                                                                            composer5.startReplaceGroup(-1955394);
                                                                                                                            composer5.endReplaceGroup();
                                                                                                                        }
                                                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                                                            ComposerKt.traceEventEnd();
                                                                                                                        }
                                                                                                                    }
                                                                                                                }, composer4, 54), composer4, 48, 0);
                                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                                    ComposerKt.traceEventEnd();
                                                                                                                }
                                                                                                            }
                                                                                                        }, composer3, 54), composer3, 6);
                                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                                            ComposerKt.traceEventEnd();
                                                                                                        }
                                                                                                    }
                                                                                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 384);
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                }
                                                                                                function32 = function332;
                                                                                                i31 = i37;
                                                                                                composer2 = composerStartRestartGroup;
                                                                                                function15 = function14;
                                                                                                imeOptions8 = imeOptions112;
                                                                                                z18 = z25;
                                                                                                mutableInteractionSource4 = mutableInteractionSource52;
                                                                                                keyboardActions3 = keyboardActions4;
                                                                                                i32 = i432;
                                                                                                solidColor = brush5;
                                                                                                modifier5 = modifier62;
                                                                                                z19 = z24;
                                                                                                textStyle4 = textStyle3;
                                                                                                visualTransformation5 = visualTransformation62;
                                                                                                z20 = z292;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        zChangedInstance9 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                                                                        objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                                                                        if (zChangedInstance9) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                zChangedInstance8 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changedInstance(textInputService) | (i38 != 4) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32);
                                                                                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                                                                if (zChangedInstance8) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                zChangedInstance6 = composerStartRestartGroup.changedInstance(transformedText) | (i38 != 4) | (i39 != 2048) | composerStartRestartGroup.changed(z15) | (i41 != 16384) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager4) | ((i42 <= 32 && composerStartRestartGroup.changed(imeOptions7)) || (i40 & 48) == 32);
                                                                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                                                if (zChangedInstance6) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        imeOptions4 = imeOptions3;
                                    }
                                    z8 = true;
                                    zChangedInstance = zChangedInstance10 | z8 | composerStartRestartGroup.changedInstance(offsetMapping2) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(bringIntoViewRequester2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager6);
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        objRememberedValue4 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                invoke2(focusState);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull FocusState focusState) {
                                                TextLayoutResultProxy layoutResult;
                                                if (legacyTextFieldState3.getHasFocus() == focusState.isFocused()) {
                                                    return;
                                                }
                                                legacyTextFieldState3.setHasFocus(focusState.isFocused());
                                                if (legacyTextFieldState3.getHasFocus() && z26 && !z24) {
                                                    CoreTextFieldKt.startInputSession(textInputService2, legacyTextFieldState3, textFieldValue, imeOptions4, offsetMapping2);
                                                } else {
                                                    CoreTextFieldKt.endInputSession(legacyTextFieldState3);
                                                }
                                                if (focusState.isFocused() && (layoutResult = legacyTextFieldState3.getLayoutResult()) != null) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester2, textFieldValue, legacyTextFieldState3, layoutResult, offsetMapping2, null), 3, null);
                                                }
                                                if (focusState.isFocused()) {
                                                    return;
                                                }
                                                TextFieldSelectionManager.m16563deselect_kEHs6E$foundation_release$default(textFieldSelectionManager6, null, 1, null);
                                            }
                                        };
                                        z9 = z26;
                                        textInputService = textInputService2;
                                        textFieldValue2 = textFieldValue;
                                        imeOptions5 = imeOptions4;
                                        offsetMapping = offsetMapping2;
                                        bringIntoViewRequester = bringIntoViewRequester2;
                                        visualTransformation4 = visualTransformation3;
                                        transformedText = transformedText2;
                                        legacyTextFieldState = legacyTextFieldState3;
                                        textFieldSelectionManager = textFieldSelectionManager6;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                        Modifier modifierTextFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z9, focusRequester4, mutableInteractionSource3, (Function1) objRememberedValue4);
                                        if (z9) {
                                            final boolean z272 = z9;
                                            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z9 || z24) ? false : true), composerStartRestartGroup, 0);
                                            Unit unit2 = Unit.INSTANCE;
                                            boolean zChanged32 = composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                                            if (i42 > 32) {
                                                imeOptions6 = imeOptions5;
                                                if ((i40 & 48) != 32) {
                                                    z10 = true;
                                                }
                                                z11 = zChanged32 | z10;
                                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                if (z11) {
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    modifier4 = modifier3;
                                }
                                objRememberedValue14 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final TextFieldScrollerPosition invoke() {
                                        return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                                final TextFieldScrollerPosition textFieldScrollerPosition2 = (TextFieldScrollerPosition) RememberSaveableKt.m18111rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) objRememberedValue14, composerStartRestartGroup, 0, 4);
                                int i382 = i36 & 14;
                                z7 = (i382 == 4) | ((i36 & 57344) == 16384);
                                Object objRememberedValue152 = composerStartRestartGroup.rememberedValue();
                                if (z7) {
                                    TransformedText transformedTextFilterWithValidation2 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                    composition = textFieldValue.getComposition();
                                    windowInfo = windowInfo4;
                                    i30 = i27;
                                    if (composition == null) {
                                    }
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.6
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

                                    public final void invoke(@Nullable Composer composer3, int i44) {
                                        CoreTextFieldKt.CoreTextField(textFieldValue, function1, modifier5, textStyle4, visualTransformation5, function15, mutableInteractionSource4, solidColor, z18, i32, i31, imeOptions8, keyboardActions3, z20, z19, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i7 |= DriveFile.MODE_READ_WRITE;
                        i16 = i15;
                        i17 = i6 & 1024;
                        if (i17 == 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        int i332 = i19;
                        i20 = i6 & 4096;
                        if (i20 == 0) {
                        }
                        i22 = i6 & 8192;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 16384;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 32768;
                        if (i26 == 0) {
                        }
                        if ((i7 & 306783379) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i4 & 1) != 0) {
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i13 != 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (i18 == 0) {
                                }
                                if ((i6 & 2048) == 0) {
                                }
                                if (i20 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i24 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                i29 = i25;
                                composerStartRestartGroup.endDefaults();
                                Brush brush52 = brush2;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                int i362 = i7;
                                if (objRememberedValue == companion.getEmpty()) {
                                }
                                final FocusRequester focusRequester42 = (FocusRequester) objRememberedValue;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == companion.getEmpty()) {
                                }
                                final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2 = (LegacyPlatformTextInputServiceAdapter) objRememberedValue2;
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                boolean z232 = z4;
                                if (objRememberedValue3 == companion.getEmpty()) {
                                }
                                final TextInputService textInputService22 = (TextInputService) objRememberedValue3;
                                Density density22 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                FontFamily.Resolver resolver22 = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                long backgroundColor2 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor();
                                FocusManager focusManager22 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                WindowInfo windowInfo42 = (WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                                TextStyle textStyle52 = textStyle2;
                                SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                final int i372 = i28;
                                if (i27 == 1) {
                                    Object[] objArr2 = {orientation};
                                    Saver<TextFieldScrollerPosition, Object> saver2 = TextFieldScrollerPosition.INSTANCE.getSaver();
                                    zChanged = composerStartRestartGroup.changed(orientation);
                                    final boolean z242 = z5;
                                    Object objRememberedValue142 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged) {
                                    }
                                    objRememberedValue142 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        @NotNull
                                        public final TextFieldScrollerPosition invoke() {
                                            return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue142);
                                    final TextFieldScrollerPosition textFieldScrollerPosition22 = (TextFieldScrollerPosition) RememberSaveableKt.m18111rememberSaveable(objArr2, (Saver) saver2, (String) null, (Function0) objRememberedValue142, composerStartRestartGroup, 0, 4);
                                    int i3822 = i362 & 14;
                                    z7 = (i3822 == 4) | ((i362 & 57344) == 16384);
                                    Object objRememberedValue1522 = composerStartRestartGroup.rememberedValue();
                                    if (z7) {
                                    }
                                }
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    visualTransformation2 = visualTransformation;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 128;
                    if (i13 != 0) {
                    }
                    i14 = i6 & 256;
                    if (i14 != 0) {
                    }
                    i15 = i6 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 1024;
                    if (i17 == 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    int i3322 = i19;
                    i20 = i6 & 4096;
                    if (i20 == 0) {
                    }
                    i22 = i6 & 8192;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 16384;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 32768;
                    if (i26 == 0) {
                    }
                    if ((i7 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                textStyle2 = textStyle;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                visualTransformation2 = visualTransformation;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                }
                i13 = i6 & 128;
                if (i13 != 0) {
                }
                i14 = i6 & 256;
                if (i14 != 0) {
                }
                i15 = i6 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i6 & 1024;
                if (i17 == 0) {
                }
                if ((i5 & 48) == 0) {
                }
                int i33222 = i19;
                i20 = i6 & 4096;
                if (i20 == 0) {
                }
                i22 = i6 & 8192;
                if (i22 == 0) {
                }
                i24 = i6 & 16384;
                if (i24 == 0) {
                }
                i26 = i6 & 32768;
                if (i26 == 0) {
                }
                if ((i7 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            textStyle2 = textStyle;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            visualTransformation2 = visualTransformation;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & 128;
            if (i13 != 0) {
            }
            i14 = i6 & 256;
            if (i14 != 0) {
            }
            i15 = i6 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 == 0) {
            }
            if ((i5 & 48) == 0) {
            }
            int i332222 = i19;
            i20 = i6 & 4096;
            if (i20 == 0) {
            }
            i22 = i6 & 8192;
            if (i22 == 0) {
            }
            i24 = i6 & 16384;
            if (i24 == 0) {
            }
            i26 = i6 & 32768;
            if (i26 == 0) {
            }
            if ((i7 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        textStyle2 = textStyle;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        visualTransformation2 = visualTransformation;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & 128;
        if (i13 != 0) {
        }
        i14 = i6 & 256;
        if (i14 != 0) {
        }
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 == 0) {
        }
        if ((i5 & 48) == 0) {
        }
        int i3322222 = i19;
        i20 = i6 & 4096;
        if (i20 == 0) {
        }
        i22 = i6 & 8192;
        if (i22 == 0) {
        }
        i24 = i6 & 16384;
        if (i24 == 0) {
        }
        i26 = i6 & 32768;
        if (i26 == 0) {
        }
        if ((i7 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-20551815);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20551815, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:801)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, composerStartRestartGroup, (i2 >> 3) & 126);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    CoreTextFieldKt.CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1286242594);
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    composerStartRestartGroup.startReplaceGroup(-1285984396);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1285984395);
                    if (TextRange.m20450getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                        composerStartRestartGroup.startReplaceGroup(-1679637798);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1680616096);
                        int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m20456getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m20451getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 == null || !state3.getShowSelectionHandleStart()) {
                            composerStartRestartGroup.startReplaceGroup(-1679975078);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1680216289);
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 == null || !state4.getShowSelectionHandleEnd()) {
                            composerStartRestartGroup.startReplaceGroup(-1679655654);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679895904);
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state5 = textFieldSelectionManager.getState();
                    if (state5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                            state5.setShowFloatingToolbar(false);
                        }
                        if (state5.getHasFocus()) {
                            if (state5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(651305535);
                composerStartRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles.2
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
                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldCursorHandle(@NotNull final TextFieldSelectionManager textFieldSelectionManager, @Nullable Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation_release;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1189)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state == null || !state.getShowCursorHandle() || (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) == null || transformedText$foundation_release.length() <= 0) {
                composerStartRestartGroup.startReplaceGroup(-284257090);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-285446808);
                boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                final long jM16569getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m16569getCursorPositiontuRUvjQ$foundation_release((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
                boolean zChanged2 = composerStartRestartGroup.changed(jM16569getCursorPositiontuRUvjQ$foundation_release);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo16143provideF1C5BW0() {
                            return jM16569getCursorPositiontuRUvjQ$foundation_release;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textDragObserver) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(textDragObserver, textFieldSelectionManager, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3);
                boolean zChanged3 = composerStartRestartGroup.changed(jM16569getCursorPositiontuRUvjQ$foundation_release);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, jM16569getCursorPositiontuRUvjQ$foundation_release, SelectionHandleAnchor.Middle, true, null));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                AndroidCursorHandle_androidKt.m16140CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue4, 1, null), 0L, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.4
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
                    CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Nullable
    public static final Object bringSelectionEndIntoView(@NotNull BringIntoViewRequester bringIntoViewRequester, @NotNull TextFieldValue textFieldValue, @NotNull TextDelegate textDelegate, @NotNull TextLayoutResult textLayoutResult, @NotNull OffsetMapping offsetMapping, @NotNull Continuation<? super Unit> continuation) {
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m20453getMaximpl(textFieldValue.getSelection()));
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length() ? textLayoutResult.getBoundingBox(iOriginalToTransformed) : iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, IntSize.m21137getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null))), continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                return;
            }
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession == null) {
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                return;
            }
            TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m16166invokeZmokQxo(keyEvent.m19573unboximpl());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m16166invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                boolean z;
                if (legacyTextFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m16168cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m16563deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }
}
