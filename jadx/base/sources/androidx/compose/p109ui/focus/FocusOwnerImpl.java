package androidx.compose.p109ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusRequester;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.input.key.KeyEventType;
import androidx.compose.p109ui.input.key.KeyEvent_androidKt;
import androidx.compose.p109ui.input.key.KeyInputModifierNode;
import androidx.compose.p109ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.p109ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p109ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.node.DelegatableNode;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.node.NodeChain;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012:\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000eH\u0016J2\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0016J:\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\f2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010C\u001a\u00020\u0005H\u0002J\u001a\u0010D\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\b\u0010G\u001a\u00020\u0005H\u0016J$\u0010H\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0002\bIJ\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020MH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\"H\u0016J$\u0010N\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001a\u0010Q\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u00105J\u000e\u0010S\u001a\u0004\u0018\u00010T*\u00020UH\u0002J3\u0010V\u001a\u0004\u0018\u0001HW\"\n\b\u0000\u0010W\u0018\u0001*\u00020X*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0ZH\u0082\bø\u0001\u0000¢\u0006\u0004\b[\u0010\\Jg\u0010]\u001a\u00020\u0005\"\n\b\u0000\u0010W\u0018\u0001*\u00020U*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onRequestFocusForOwner", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Lkotlin/ParameterName;", "name", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "onLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", NotesSyncRpcProvider.FORCE_SYNC, "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "invalidateOwnerFocusState", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "requestFocusForOwner", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "nearestAncestorIncludingSelf", "T", "", "type", "Landroidx/compose/ui/node/NodeKind;", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "traverseAncestorsIncludingSelf", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusOwnerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusOwnerImpl.kt\nandroidx/compose/ui/focus/FocusOwnerImpl\n+ 2 FocusTransactionManager.kt\nandroidx/compose/ui/focus/FocusTransactionManager\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 6 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 7 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 8 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 9 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 10 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 11 NodeKind.kt\nandroidx/compose/ui/node/NodeKind\n+ 12 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,427:1\n368#1:454\n369#1:471\n371#1:517\n357#1:588\n358#1:660\n359#1:667\n360#1,2:714\n362#1:762\n363#1:769\n368#1:771\n369#1:788\n371#1:834\n357#1:836\n358#1:908\n359#1:915\n360#1,2:962\n362#1:1010\n363#1:1017\n368#1:1019\n369#1:1036\n371#1:1082\n357#1:1084\n358#1:1156\n359#1:1163\n360#1,2:1210\n362#1:1258\n363#1:1265\n59#2,5:428\n64#2,6:436\n43#2,4:442\n47#2,4:449\n1#3:433\n1#3:446\n1#3:457\n1#3:526\n1#3:597\n1#3:774\n1#3:845\n1#3:1022\n1#3:1093\n1#3:1274\n1#3:1437\n1#3:1535\n728#4,2:434\n728#4,2:447\n102#5:453\n102#5:518\n102#5:587\n110#5:770\n110#5:835\n104#5:1018\n104#5:1083\n96#5,7:1496\n96#5:1529\n255#6:455\n62#6:456\n63#6,8:458\n432#6,5:466\n437#6:472\n442#6,2:474\n444#6,8:479\n452#6,9:490\n461#6,8:502\n72#6,7:510\n283#6:519\n251#6,5:520\n62#6:525\n63#6,8:527\n432#6,5:535\n284#6:540\n437#6:541\n442#6,2:543\n444#6,8:548\n452#6,9:559\n461#6,8:571\n72#6,7:579\n286#6:586\n274#6,2:589\n251#6,5:591\n62#6:596\n63#6,8:598\n432#6,5:606\n276#6,3:611\n437#6:614\n442#6,2:616\n444#6,8:621\n452#6,9:632\n461#6,8:644\n72#6,7:652\n279#6:659\n432#6,12:668\n444#6,8:683\n452#6,9:694\n461#6,8:706\n432#6,12:716\n444#6,8:731\n452#6,9:742\n461#6,8:754\n255#6:772\n62#6:773\n63#6,8:775\n432#6,5:783\n437#6:789\n442#6,2:791\n444#6,8:796\n452#6,9:807\n461#6,8:819\n72#6,7:827\n274#6,2:837\n251#6,5:839\n62#6:844\n63#6,8:846\n432#6,5:854\n276#6,3:859\n437#6:862\n442#6,2:864\n444#6,8:869\n452#6,9:880\n461#6,8:892\n72#6,7:900\n279#6:907\n432#6,12:916\n444#6,8:931\n452#6,9:942\n461#6,8:954\n432#6,12:964\n444#6,8:979\n452#6,9:990\n461#6,8:1002\n255#6:1020\n62#6:1021\n63#6,8:1023\n432#6,5:1031\n437#6:1037\n442#6,2:1039\n444#6,8:1044\n452#6,9:1055\n461#6,8:1067\n72#6,7:1075\n274#6,2:1085\n251#6,5:1087\n62#6:1092\n63#6,8:1094\n432#6,5:1102\n276#6,3:1107\n437#6:1110\n442#6,2:1112\n444#6,8:1117\n452#6,9:1128\n461#6,8:1140\n72#6,7:1148\n279#6:1155\n432#6,12:1164\n444#6,8:1179\n452#6,9:1190\n461#6,8:1202\n432#6,12:1212\n444#6,8:1227\n452#6,9:1238\n461#6,8:1250\n274#6,2:1266\n251#6,5:1268\n62#6:1273\n63#6,8:1275\n432#6,5:1283\n276#6,3:1288\n437#6:1291\n442#6,2:1293\n444#6,8:1298\n452#6,9:1309\n461#6,8:1321\n72#6,7:1329\n279#6:1336\n432#6,6:1343\n442#6,2:1350\n444#6,8:1355\n452#6,9:1366\n461#6,8:1378\n432#6,6:1386\n442#6,2:1393\n444#6,8:1398\n452#6,9:1409\n461#6,8:1421\n255#6:1435\n62#6:1436\n63#6,8:1438\n432#6,6:1446\n442#6,2:1453\n444#6,8:1458\n452#6,9:1469\n461#6,8:1481\n72#6,7:1489\n193#6,12:1504\n205#6,6:1523\n212#6,3:1531\n197#6:1534\n249#7:473\n249#7:542\n249#7:615\n249#7:790\n249#7:863\n249#7:1038\n249#7:1111\n249#7:1292\n249#7:1349\n249#7:1392\n249#7:1452\n249#7:1530\n245#8,3:476\n248#8,3:499\n245#8,3:545\n248#8,3:568\n245#8,3:618\n248#8,3:641\n245#8,3:680\n248#8,3:703\n245#8,3:728\n248#8,3:751\n245#8,3:793\n248#8,3:816\n245#8,3:866\n248#8,3:889\n245#8,3:928\n248#8,3:951\n245#8,3:976\n248#8,3:999\n245#8,3:1041\n248#8,3:1064\n245#8,3:1114\n248#8,3:1137\n245#8,3:1176\n248#8,3:1199\n245#8,3:1224\n248#8,3:1247\n245#8,3:1295\n248#8,3:1318\n245#8,3:1352\n248#8,3:1375\n245#8,3:1395\n248#8,3:1418\n245#8,3:1455\n248#8,3:1478\n1208#9:487\n1187#9,2:488\n1208#9:556\n1187#9,2:557\n1208#9:629\n1187#9,2:630\n1208#9:691\n1187#9,2:692\n1208#9:739\n1187#9,2:740\n1208#9:804\n1187#9,2:805\n1208#9:877\n1187#9,2:878\n1208#9:939\n1187#9,2:940\n1208#9:987\n1187#9,2:988\n1208#9:1052\n1187#9,2:1053\n1208#9:1125\n1187#9,2:1126\n1208#9:1187\n1187#9,2:1188\n1208#9:1235\n1187#9,2:1236\n1208#9:1306\n1187#9,2:1307\n1208#9:1363\n1187#9,2:1364\n1208#9:1406\n1187#9,2:1407\n1208#9:1466\n1187#9,2:1467\n51#10,6:661\n33#10,6:763\n51#10,6:909\n33#10,6:1011\n51#10,6:1157\n33#10,6:1259\n51#10,6:1337\n33#10,6:1429\n53#11:1503\n42#12,7:1516\n*S KotlinDebug\n*F\n+ 1 FocusOwnerImpl.kt\nandroidx/compose/ui/focus/FocusOwnerImpl\n*L\n271#1:454\n271#1:471\n271#1:517\n274#1:588\n274#1:660\n274#1:667\n274#1:714,2\n274#1:762\n274#1:769\n295#1:771\n295#1:788\n295#1:834\n297#1:836\n297#1:908\n297#1:915\n297#1:962,2\n297#1:1010\n297#1:1017\n315#1:1019\n315#1:1036\n315#1:1082\n317#1:1084\n317#1:1156\n317#1:1163\n317#1:1210,2\n317#1:1258\n317#1:1265\n150#1:428,5\n150#1:436,6\n179#1:442,4\n179#1:449,4\n150#1:433\n179#1:446\n271#1:457\n272#1:526\n274#1:597\n295#1:774\n297#1:845\n315#1:1022\n317#1:1093\n357#1:1274\n368#1:1437\n150#1:434,2\n179#1:447,2\n271#1:453\n272#1:518\n275#1:587\n295#1:770\n298#1:835\n315#1:1018\n318#1:1083\n386#1:1496,7\n387#1:1529\n271#1:455\n271#1:456\n271#1:458,8\n271#1:466,5\n271#1:472\n271#1:474,2\n271#1:479,8\n271#1:490,9\n271#1:502,8\n271#1:510,7\n272#1:519\n272#1:520,5\n272#1:525\n272#1:527,8\n272#1:535,5\n272#1:540\n272#1:541\n272#1:543,2\n272#1:548,8\n272#1:559,9\n272#1:571,8\n272#1:579,7\n272#1:586\n274#1:589,2\n274#1:591,5\n274#1:596\n274#1:598,8\n274#1:606,5\n274#1:611,3\n274#1:614\n274#1:616,2\n274#1:621,8\n274#1:632,9\n274#1:644,8\n274#1:652,7\n274#1:659\n274#1:668,12\n274#1:683,8\n274#1:694,9\n274#1:706,8\n274#1:716,12\n274#1:731,8\n274#1:742,9\n274#1:754,8\n295#1:772\n295#1:773\n295#1:775,8\n295#1:783,5\n295#1:789\n295#1:791,2\n295#1:796,8\n295#1:807,9\n295#1:819,8\n295#1:827,7\n297#1:837,2\n297#1:839,5\n297#1:844\n297#1:846,8\n297#1:854,5\n297#1:859,3\n297#1:862\n297#1:864,2\n297#1:869,8\n297#1:880,9\n297#1:892,8\n297#1:900,7\n297#1:907\n297#1:916,12\n297#1:931,8\n297#1:942,9\n297#1:954,8\n297#1:964,12\n297#1:979,8\n297#1:990,9\n297#1:1002,8\n315#1:1020\n315#1:1021\n315#1:1023,8\n315#1:1031,5\n315#1:1037\n315#1:1039,2\n315#1:1044,8\n315#1:1055,9\n315#1:1067,8\n315#1:1075,7\n317#1:1085,2\n317#1:1087,5\n317#1:1092\n317#1:1094,8\n317#1:1102,5\n317#1:1107,3\n317#1:1110\n317#1:1112,2\n317#1:1117,8\n317#1:1128,9\n317#1:1140,8\n317#1:1148,7\n317#1:1155\n317#1:1164,12\n317#1:1179,8\n317#1:1190,9\n317#1:1202,8\n317#1:1212,12\n317#1:1227,8\n317#1:1238,9\n317#1:1250,8\n357#1:1266,2\n357#1:1268,5\n357#1:1273\n357#1:1275,8\n357#1:1283,5\n357#1:1288,3\n357#1:1291\n357#1:1293,2\n357#1:1298,8\n357#1:1309,9\n357#1:1321,8\n357#1:1329,7\n357#1:1336\n359#1:1343,6\n359#1:1350,2\n359#1:1355,8\n359#1:1366,9\n359#1:1378,8\n361#1:1386,6\n361#1:1393,2\n361#1:1398,8\n361#1:1409,9\n361#1:1421,8\n368#1:1435\n368#1:1436\n368#1:1438,8\n368#1:1446,6\n368#1:1453,2\n368#1:1458,8\n368#1:1469,9\n368#1:1481,8\n368#1:1489,7\n386#1:1504,12\n386#1:1523,6\n386#1:1531,3\n386#1:1534\n271#1:473\n272#1:542\n274#1:615\n295#1:790\n297#1:863\n315#1:1038\n317#1:1111\n357#1:1292\n359#1:1349\n361#1:1392\n368#1:1452\n387#1:1530\n271#1:476,3\n271#1:499,3\n272#1:545,3\n272#1:568,3\n274#1:618,3\n274#1:641,3\n274#1:680,3\n274#1:703,3\n274#1:728,3\n274#1:751,3\n295#1:793,3\n295#1:816,3\n297#1:866,3\n297#1:889,3\n297#1:928,3\n297#1:951,3\n297#1:976,3\n297#1:999,3\n315#1:1041,3\n315#1:1064,3\n317#1:1114,3\n317#1:1137,3\n317#1:1176,3\n317#1:1199,3\n317#1:1224,3\n317#1:1247,3\n357#1:1295,3\n357#1:1318,3\n359#1:1352,3\n359#1:1375,3\n361#1:1395,3\n361#1:1418,3\n368#1:1455,3\n368#1:1478,3\n271#1:487\n271#1:488,2\n272#1:556\n272#1:557,2\n274#1:629\n274#1:630,2\n274#1:691\n274#1:692,2\n274#1:739\n274#1:740,2\n295#1:804\n295#1:805,2\n297#1:877\n297#1:878,2\n297#1:939\n297#1:940,2\n297#1:987\n297#1:988,2\n315#1:1052\n315#1:1053,2\n317#1:1125\n317#1:1126,2\n317#1:1187\n317#1:1188,2\n317#1:1235\n317#1:1236,2\n357#1:1306\n357#1:1307,2\n359#1:1363\n359#1:1364,2\n361#1:1406\n361#1:1407,2\n368#1:1466\n368#1:1467,2\n274#1:661,6\n274#1:763,6\n297#1:909,6\n297#1:1011,6\n317#1:1157,6\n317#1:1259,6\n358#1:1337,6\n362#1:1429,6\n386#1:1503\n386#1:1516,7\n*E\n"})
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;

    @NotNull
    private final FocusInvalidationManager focusInvalidationManager;

    @Nullable
    private MutableLongSet keysCurrentlyDown;

    @NotNull
    private final Function0<Unit> onClearFocusForOwner;

    @NotNull
    private final Function0<Rect> onFocusRectInterop;

    @NotNull
    private final Function0<LayoutDirection> onLayoutDirection;

    @NotNull
    private final Function1<FocusDirection, Boolean> onMoveFocusInterop;

    @NotNull
    private final Function2<FocusDirection, Rect, Boolean> onRequestFocusForOwner;

    @NotNull
    private FocusTargetNode rootFocusNode = new FocusTargetNode();

    @NotNull
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();

    @NotNull
    private final Modifier modifier = FocusPropertiesKt.focusProperties(Modifier.INSTANCE, new Function1<FocusProperties, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
            invoke2(focusProperties);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull FocusProperties focusProperties) {
            focusProperties.setCanFocus(false);
        }
    }).then(new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public boolean equals(@Nullable Object other) {
            return other == this;
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public void update(@NotNull FocusTargetNode node) {
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        @NotNull
        /* JADX INFO: renamed from: create */
        public FocusTargetNode getNode() {
            return this.this$0.getRootFocusNode();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOwnerImpl(@NotNull Function1<? super Function0<Unit>, Unit> function1, @NotNull Function2<? super FocusDirection, ? super Rect, Boolean> function2, @NotNull Function1<? super FocusDirection, Boolean> function12, @NotNull Function0<Unit> function0, @NotNull Function0<Rect> function02, @NotNull Function0<? extends LayoutDirection> function03) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function12;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function02;
        this.onLayoutDirection = function03;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024) | NodeKind.m20090constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM20090constructorimpl) != 0) {
                    if ((NodeKind.m20090constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }

    /* JADX INFO: renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m18219nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Object node = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((((Modifier.Node) node).getKindSet() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        return (T) node;
                    }
                    node = (T) ((Modifier.Node) node).getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? (T) null : (T) nodes.getTail();
        }
        return null;
    }

    /* JADX INFO: renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m18220traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int size;
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        for (Modifier.Node nodePop = parent; nodePop != null; nodePop = DelegatableNodeKt.pop(null)) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(nodePop);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            while (true) {
                int i2 = size - 1;
                function1.invoke((Object) arrayList.get(size));
                if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        for (Modifier.Node node = delegatableNode.getNode(); node != null; node = DelegatableNodeKt.pop(null)) {
            Intrinsics.reifiedOperationMarker(3, "T");
            function1.invoke(node);
        }
        function0.invoke();
        for (Modifier.Node node2 = delegatableNode.getNode(); node2 != null; node2 = DelegatableNodeKt.pop(null)) {
            Intrinsics.reifiedOperationMarker(3, "T");
            function12.invoke(node2);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                function12.invoke((Object) arrayList.get(i4));
            }
        }
    }

    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m18221validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long jM19584getKeyZmokQxo = KeyEvent_androidKt.m19584getKeyZmokQxo(keyEvent);
        int iM19585getTypeZmokQxo = KeyEvent_androidKt.m19585getTypeZmokQxo(keyEvent);
        KeyEventType.Companion companion = KeyEventType.INSTANCE;
        if (KeyEventType.m19577equalsimpl0(iM19585getTypeZmokQxo, companion.m19581getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(jM19584getKeyZmokQxo);
        } else if (KeyEventType.m19577equalsimpl0(iM19585getTypeZmokQxo, companion.m19582getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(jM19584getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(jM19584getKeyZmokQxo);
            }
        }
        return true;
    }

    @Override // androidx.compose.p109ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo18213clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m18204getExitdhqQ8s());
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    /* JADX INFO: renamed from: clearFocus-I7lrPNg */
    public boolean mo18213clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean zClearFocus;
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                focusTransactionManager.cancellationListener.add(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!force) {
                int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m18231performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()];
                zClearFocus = (i == 1 || i == 2 || i == 3) ? false : FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
            }
            if (zClearFocus && clearOwnerFocus) {
                this.onClearFocusForOwner.invoke();
            }
            return zClearFocus;
        } finally {
            focusTransactionManager.commitTransaction();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // androidx.compose.p109ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo18214dispatchInterceptedSoftKeyboardEventZmokQxo(@NotNull KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int size;
        NodeChain nodes;
        ?? Pop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            int iM20090constructorimpl = NodeKind.m20090constructorimpl(131072);
            if (!focusTargetNodeFindActiveFocusNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNodeFindActiveFocusNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM20090constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet() & iM20090constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                                    int i = 0;
                                    Pop = Pop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Pop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        Pop = Pop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) Pop;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(131072);
            if (!softKeyboardInterceptionModifierNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = softKeyboardInterceptionModifierNode.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode2) & iM20090constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM20090constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet() & iM20090constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM20090constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(delegate2);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i4 = size - 1;
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).mo19272onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    size = i4;
                }
            }
            ?? node2 = softKeyboardInterceptionModifierNode.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node2).mo19272onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM20090constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate();
                    int i5 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM20090constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    mutableVector3.add(node2);
                                    node2 = 0;
                                }
                                mutableVector3.add(delegate3);
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i5 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            ?? node3 = softKeyboardInterceptionModifierNode.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node3).mo19271onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM20090constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = ((DelegatingNode) node3).getDelegate();
                    int i6 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM20090constructorimpl2) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.add(node3);
                                    node3 = 0;
                                }
                                mutableVector4.add(delegate4);
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i6 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i7)).mo19271onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d0  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r11v59 */
    /* JADX WARN: Type inference failed for: r11v60 */
    /* JADX WARN: Type inference failed for: r11v61 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v10 */
    @Override // androidx.compose.p109ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo18215dispatchKeyEventYhN2O0w(@NotNull KeyEvent keyEvent, @NotNull Function0<Boolean> onFocusedItem) {
        ?? Pop;
        Modifier.Node node;
        NodeChain nodes;
        ?? Pop2;
        NodeChain nodes2;
        NodeChain nodes3;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
            return false;
        }
        if (!m18221validateKeyEventZmokQxo(keyEvent)) {
            return false;
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode == null || (node = lastLocalKeyInputNode(focusTargetNodeFindActiveFocusNode)) == null) {
            if (focusTargetNodeFindActiveFocusNode != null) {
                int iM20090constructorimpl = NodeKind.m20090constructorimpl(8192);
                if (!focusTargetNodeFindActiveFocusNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node2 = focusTargetNodeFindActiveFocusNode.getNode();
                LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                loop10: while (true) {
                    if (layoutNodeRequireLayoutNode == null) {
                        Pop2 = 0;
                        break;
                    }
                    if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                        while (node2 != null) {
                            if ((node2.getKindSet() & iM20090constructorimpl) != 0) {
                                MutableVector mutableVector = null;
                                Pop2 = node2;
                                while (Pop2 != 0) {
                                    if (Pop2 instanceof KeyInputModifierNode) {
                                        break loop10;
                                    }
                                    if ((Pop2.getKindSet() & iM20090constructorimpl) != 0 && (Pop2 instanceof DelegatingNode)) {
                                        Modifier.Node delegate = ((DelegatingNode) Pop2).getDelegate();
                                        int i = 0;
                                        Pop2 = Pop2;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    Pop2 = delegate;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (Pop2 != 0) {
                                                        mutableVector.add(Pop2);
                                                        Pop2 = 0;
                                                    }
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                            delegate = delegate.getChild();
                                            Pop2 = Pop2;
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    Pop2 = DelegatableNodeKt.pop(mutableVector);
                                }
                            }
                            node2 = node2.getParent();
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                    node2 = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                }
                KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) Pop2;
                if (keyInputModifierNode != null) {
                    node = keyInputModifierNode.getNode();
                } else {
                    FocusTargetNode focusTargetNode = this.rootFocusNode;
                    int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(8192);
                    if (!focusTargetNode.getNode().getIsAttached()) {
                        throw new IllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent = focusTargetNode.getNode().getParent();
                    LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                    loop14: while (true) {
                        if (layoutNodeRequireLayoutNode2 == null) {
                            Pop = 0;
                            break;
                        }
                        if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode2) & iM20090constructorimpl2) != 0) {
                            while (parent != null) {
                                if ((parent.getKindSet() & iM20090constructorimpl2) != 0) {
                                    MutableVector mutableVector2 = null;
                                    Pop = parent;
                                    while (Pop != 0) {
                                        if (Pop instanceof KeyInputModifierNode) {
                                            break loop14;
                                        }
                                        if ((Pop.getKindSet() & iM20090constructorimpl2) != 0 && (Pop instanceof DelegatingNode)) {
                                            Modifier.Node delegate2 = ((DelegatingNode) Pop).getDelegate();
                                            int i2 = 0;
                                            Pop = Pop;
                                            while (delegate2 != null) {
                                                if ((delegate2.getKindSet() & iM20090constructorimpl2) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
                                                        Pop = delegate2;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (Pop != 0) {
                                                            mutableVector2.add(Pop);
                                                            Pop = 0;
                                                        }
                                                        mutableVector2.add(delegate2);
                                                    }
                                                }
                                                delegate2 = delegate2.getChild();
                                                Pop = Pop;
                                            }
                                            if (i2 == 1) {
                                            }
                                        }
                                        Pop = DelegatableNodeKt.pop(mutableVector2);
                                    }
                                }
                                parent = parent.getParent();
                            }
                        }
                        layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                        parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
                    }
                    KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) Pop;
                    node = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
                }
            }
        }
        if (node != null) {
            int iM20090constructorimpl3 = NodeKind.m20090constructorimpl(8192);
            if (!node.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent2 = node.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode3 != null) {
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode3) & iM20090constructorimpl3) != 0) {
                    while (parent2 != null) {
                        if ((parent2.getKindSet() & iM20090constructorimpl3) != 0) {
                            Modifier.Node nodePop = parent2;
                            MutableVector mutableVector3 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof KeyInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet() & iM20090constructorimpl3) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate3 = ((DelegatingNode) nodePop).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                                        if ((delegate3.getKindSet() & iM20090constructorimpl3) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                nodePop = delegate3;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector3.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector3.add(delegate3);
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector3);
                            }
                        }
                        parent2 = parent2.getParent();
                    }
                }
                layoutNodeRequireLayoutNode3 = layoutNodeRequireLayoutNode3.getParent$ui_release();
                parent2 = (layoutNodeRequireLayoutNode3 == null || (nodes3 = layoutNodeRequireLayoutNode3.getNodes()) == null) ? null : nodes3.getTail();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i5 = size - 1;
                        if (((KeyInputModifierNode) arrayList.get(size)).mo15383onPreKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                        if (i5 < 0) {
                            break;
                        }
                        size = i5;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            ?? node3 = node.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof KeyInputModifierNode) {
                    if (((KeyInputModifierNode) node3).mo15383onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM20090constructorimpl3) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = ((DelegatingNode) node3).getDelegate();
                    int i6 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM20090constructorimpl3) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.add(node3);
                                    node3 = 0;
                                }
                                mutableVector4.add(delegate4);
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i6 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (onFocusedItem.invoke().booleanValue()) {
                return true;
            }
            ?? node4 = node.getNode();
            MutableVector mutableVector5 = null;
            while (node4 != 0) {
                if (node4 instanceof KeyInputModifierNode) {
                    if (((KeyInputModifierNode) node4).mo15381onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet() & iM20090constructorimpl3) != 0 && (node4 instanceof DelegatingNode)) {
                    Modifier.Node delegate5 = ((DelegatingNode) node4).getDelegate();
                    int i7 = 0;
                    node4 = node4;
                    while (delegate5 != null) {
                        if ((delegate5.getKindSet() & iM20090constructorimpl3) != 0) {
                            i7++;
                            if (i7 == 1) {
                                node4 = delegate5;
                            } else {
                                if (mutableVector5 == null) {
                                    mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != 0) {
                                    mutableVector5.add(node4);
                                    node4 = 0;
                                }
                                mutableVector5.add(delegate5);
                            }
                        }
                        delegate5 = delegate5.getChild();
                        node4 = node4;
                    }
                    if (i7 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector5);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if (((KeyInputModifierNode) arrayList.get(i8)).mo15381onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // androidx.compose.p109ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(@NotNull RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodes;
        ?? Pop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching rotary event while focus system is invalidated.");
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            int iM20090constructorimpl = NodeKind.m20090constructorimpl(16384);
            if (!focusTargetNodeFindActiveFocusNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNodeFindActiveFocusNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM20090constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet() & iM20090constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                                    int i = 0;
                                    Pop = Pop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Pop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        Pop = Pop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) Pop;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(16384);
            if (!rotaryInputModifierNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = rotaryInputModifierNode.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode2) & iM20090constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM20090constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet() & iM20090constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM20090constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(delegate2);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i4 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    size = i4;
                }
            }
            ?? node2 = rotaryInputModifierNode.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node2).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM20090constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate();
                    int i5 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM20090constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    mutableVector3.add(node2);
                                    node2 = 0;
                                }
                                mutableVector3.add(delegate3);
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i5 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            ?? node3 = rotaryInputModifierNode.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM20090constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = ((DelegatingNode) node3).getDelegate();
                    int i6 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM20090constructorimpl2) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.add(node3);
                                    node3 = 0;
                                }
                                mutableVector4.add(delegate4);
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i6 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    if (((RotaryInputModifierNode) arrayList.get(i7)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    @Nullable
    /* JADX INFO: renamed from: focusSearch-ULY8qGw */
    public Boolean mo18216focusSearchULY8qGw(int focusDirection, @Nullable Rect focusedRect, @NotNull final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusRequester focusRequesterM18236customFocusSearchOMvw8 = FocusTraversalKt.m18236customFocusSearchOMvw8(focusTargetNodeFindActiveFocusNode, focusDirection, this.onLayoutDirection.invoke());
            FocusRequester.Companion companion = FocusRequester.INSTANCE;
            if (Intrinsics.areEqual(focusRequesterM18236customFocusSearchOMvw8, companion.getCancel())) {
                return null;
            }
            if (!Intrinsics.areEqual(focusRequesterM18236customFocusSearchOMvw8, companion.getDefault())) {
                return Boolean.valueOf(focusRequesterM18236customFocusSearchOMvw8.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            focusTargetNodeFindActiveFocusNode = null;
        }
        return FocusTraversalKt.m18237focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.onLayoutDirection.invoke(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(focusTargetNode, focusTargetNodeFindActiveFocusNode)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.");
                    }
                    zBooleanValue = onFound.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    @Nullable
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    @NotNull
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    @NotNull
    public Modifier getModifier() {
        return this.modifier;
    }

    @NotNull
    /* JADX INFO: renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    @NotNull
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.p109ui.focus.FocusManager
    /* JADX INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo18211moveFocus3ESFkO8(final int focusDirection) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Boolean.FALSE;
        Boolean boolMo18216focusSearchULY8qGw = mo18216focusSearchULY8qGw(focusDirection, this.onFocusRectInterop.invoke(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                objectRef.element = FocusTransactionsKt.m18235requestFocusMxy_nc0(focusTargetNode, focusDirection);
                Boolean bool = objectRef.element;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        if (boolMo18216focusSearchULY8qGw == null || objectRef.element == 0) {
            return false;
        }
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolMo18216focusSearchULY8qGw, bool) && Intrinsics.areEqual(objectRef.element, bool)) {
            return true;
        }
        return FocusOwnerImplKt.m18222is1dFocusSearch3ESFkO8(focusDirection) ? mo18213clearFocusI7lrPNg(false, true, false, focusDirection) && mo18218takeFocusaToIllA(focusDirection, null) : this.onMoveFocusInterop.invoke(FocusDirection.m18193boximpl(focusDirection)).booleanValue();
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        if (focusTransactionManager.ongoingTransaction) {
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
            return;
        }
        try {
            focusTransactionManager.beginTransaction();
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        } finally {
            focusTransactionManager.commitTransaction();
        }
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    /* JADX INFO: renamed from: requestFocusForOwner-7o62pno */
    public boolean mo18217requestFocusForOwner7o62pno(@Nullable FocusDirection focusDirection, @Nullable Rect previouslyFocusedRect) {
        return this.onRequestFocusForOwner.invoke(focusDirection, previouslyFocusedRect).booleanValue();
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    public final void setRootFocusNode$ui_release(@NotNull FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    /* JADX INFO: renamed from: takeFocus-aToIllA */
    public boolean mo18218takeFocusaToIllA(final int focusDirection, @Nullable Rect previouslyFocusedRect) {
        Boolean boolMo18216focusSearchULY8qGw = mo18216focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull FocusTargetNode focusTargetNode) {
                Boolean boolM18235requestFocusMxy_nc0 = FocusTransactionsKt.m18235requestFocusMxy_nc0(focusTargetNode, focusDirection);
                return Boolean.valueOf(boolM18235requestFocusMxy_nc0 != null ? boolM18235requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (boolMo18216focusSearchULY8qGw != null) {
            return boolMo18216focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.p109ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }
}
