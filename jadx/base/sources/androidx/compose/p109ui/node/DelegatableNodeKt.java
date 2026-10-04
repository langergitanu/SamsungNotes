package androidx.compose.p109ui.node;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a5\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0007H\u0000\u001aA\u0010\u0012\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u0005*\u00020\u0002\u001a3\u0010\u001c\u001a\u0004\u0018\u0001H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u001d*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0000\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u0007*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u001a\"\u0010#\u001a\u00020$*\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\rH\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\n\u0010'\u001a\u00020(*\u00020\u0002\u001a\n\u0010)\u001a\u00020**\u00020\u0002\u001a\n\u0010+\u001a\u00020,*\u00020\u0002\u001a\n\u0010-\u001a\u00020.*\u00020\u0002\u001a\f\u0010/\u001a\u000200*\u00020\u0002H\u0000\u001a\f\u00101\u001a\u000202*\u00020\u0002H\u0000\u001aK\u00103\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\b\b\u0002\u00104\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a3\u00103\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\b\u0002\u00104\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\b\u001aA\u00107\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a)\u00107\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\b\u001aA\u0010:\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b;\u00109\u001a)\u0010:\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\b\u001aA\u0010<\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b=\u00109\u001a)\u0010<\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\b\u001a3\u0010<\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\b\u0002\u00104\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\b\u001aM\u0010>\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aA\u0010B\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\bC\u00109\u001aA\u0010D\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\bE\u00109\u001aA\u0010F\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\bG\u00109\u001a)\u0010F\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\b\u001aA\u0010H\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\bI\u00109\u001a)\u0010H\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0015H\u0080\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, m13886d2 = {"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "ancestors", "", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "kind", "block", "Lkotlin/Function1;", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "invalidateSubtree", "nearestAncestor", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "pop", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "includeSelf", "visitAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalAncestors", "visitLocalAncestors-6rFNWt0", "visitLocalDescendants", "visitLocalDescendants-6rFNWt0", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "visitSelfAndChildren", "visitSelfAndChildren-6rFNWt0", "visitSelfAndLocalDescendants", "visitSelfAndLocalDescendants-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDelegatableNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 6 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 7 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 8 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n*L\n1#1,474:1\n204#1:515\n205#1,10:523\n204#1:547\n205#1,6:555\n432#1,6:561\n442#1,2:568\n444#1,8:573\n452#1,9:584\n461#1,8:596\n212#1,3:604\n193#1,12:607\n205#1,6:626\n432#1,6:632\n442#1,2:639\n444#1,8:644\n452#1,9:655\n461#1,8:667\n212#1,3:675\n197#1:678\n220#1:679\n221#1,4:687\n432#1,6:691\n442#1,2:698\n444#1,8:703\n452#1,9:714\n461#1,8:726\n226#1,3:734\n62#1:737\n63#1,8:739\n432#1,6:747\n442#1,2:754\n444#1,8:759\n452#1,9:770\n461#1,8:782\n72#1,7:790\n62#1,9:797\n432#1,12:806\n444#1,8:821\n452#1,9:832\n461#1,8:844\n72#1,7:852\n62#1:859\n63#1,8:861\n432#1,6:871\n442#1,2:878\n444#1,8:883\n452#1,9:894\n461#1,8:906\n72#1,7:914\n251#1,5:921\n62#1:926\n63#1,8:928\n432#1,6:936\n442#1,2:943\n444#1,8:948\n452#1,9:959\n461#1,8:971\n72#1,7:979\n251#1,5:986\n62#1:991\n63#1,8:993\n432#1,6:1001\n442#1,2:1008\n444#1,8:1013\n452#1,9:1024\n461#1,8:1036\n72#1,7:1044\n104#1:1051\n105#1,15:1059\n432#1,6:1074\n442#1,2:1081\n444#1,8:1086\n452#1,9:1097\n461#1,8:1109\n121#1,8:1117\n137#1:1125\n138#1:1127\n139#1,7:1131\n146#1,9:1139\n432#1,6:1148\n442#1,2:1155\n444#1,17:1160\n461#1,8:1180\n155#1,6:1188\n432#1,6:1194\n442#1,2:1201\n444#1,8:1206\n452#1,9:1217\n461#1,8:1229\n137#1:1237\n138#1:1239\n139#1,7:1243\n146#1,9:1251\n432#1,6:1260\n442#1,2:1267\n444#1,8:1272\n452#1,9:1283\n461#1,8:1295\n155#1,6:1303\n167#1:1309\n168#1:1317\n169#1,12:1321\n432#1,6:1333\n442#1,2:1340\n444#1,8:1345\n452#1,9:1356\n461#1,8:1368\n181#1,8:1376\n1#2:475\n1#2:738\n1#2:860\n1#2:927\n1#2:992\n1#2:1126\n1#2:1238\n42#3,7:476\n42#3,7:483\n42#3,7:505\n42#3,7:516\n42#3,7:533\n42#3,7:540\n42#3,7:548\n42#3,7:619\n42#3,7:680\n42#3,7:1052\n42#3,7:1310\n66#3,9:1384\n66#3,9:1393\n42#3,7:1402\n42#3,7:1410\n492#4,11:490\n48#4:504\n48#4:1138\n48#4:1250\n1208#5:501\n1187#5,2:502\n1208#5:512\n1187#5,2:513\n1208#5:581\n1187#5,2:582\n1208#5:652\n1187#5,2:653\n1208#5:711\n1187#5,2:712\n1208#5:767\n1187#5,2:768\n1208#5:829\n1187#5,2:830\n1208#5:891\n1187#5,2:892\n1208#5:956\n1187#5,2:957\n1208#5:1021\n1187#5,2:1022\n1208#5:1094\n1187#5,2:1095\n1208#5:1128\n1187#5,2:1129\n1208#5:1214\n1187#5,2:1215\n1208#5:1240\n1187#5,2:1241\n1208#5:1280\n1187#5,2:1281\n1208#5:1318\n1187#5,2:1319\n1208#5:1353\n1187#5,2:1354\n1208#5:1426\n1187#5,2:1427\n249#6:567\n249#6:638\n249#6:697\n249#6:753\n249#6:869\n249#6:870\n249#6:877\n249#6:942\n249#6:1007\n249#6:1080\n249#6:1154\n249#6:1200\n249#6:1266\n249#6:1339\n249#6:1418\n249#6:1420\n249#6:1421\n249#6:1425\n245#7,3:570\n248#7,3:593\n245#7,3:641\n248#7,3:664\n245#7,3:700\n248#7,3:723\n245#7,3:756\n248#7,3:779\n245#7,3:818\n248#7,3:841\n245#7,3:880\n248#7,3:903\n245#7,3:945\n248#7,3:968\n245#7,3:1010\n248#7,3:1033\n245#7,3:1083\n248#7,3:1106\n245#7,3:1157\n248#7,3:1177\n245#7,3:1203\n248#7,3:1226\n245#7,3:1269\n248#7,3:1292\n245#7,3:1342\n248#7,3:1365\n245#7,3:1422\n248#7,3:1429\n78#8:1409\n78#8:1417\n78#8:1419\n*S KotlinDebug\n*F\n+ 1 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n*L\n193#1:515\n193#1:523,10\n233#1:547\n233#1:555,6\n234#1:561,6\n234#1:568,2\n234#1:573,8\n234#1:584,9\n234#1:596,8\n233#1:604,3\n240#1:607,12\n240#1:626,6\n241#1:632,6\n241#1:639,2\n241#1:644,8\n241#1:655,9\n241#1:667,8\n240#1:675,3\n240#1:678\n247#1:679\n247#1:687,4\n248#1:691,6\n248#1:698,2\n248#1:703,8\n248#1:714,9\n248#1:726,8\n247#1:734,3\n255#1:737\n255#1:739,8\n255#1:747,6\n255#1:754,2\n255#1:759,8\n255#1:770,9\n255#1:782,8\n255#1:790,7\n255#1:797,9\n255#1:806,12\n255#1:821,8\n255#1:832,9\n255#1:844,8\n255#1:852,7\n263#1:859\n263#1:861,8\n266#1:871,6\n266#1:878,2\n266#1:883,8\n266#1:894,9\n266#1:906,8\n263#1:914,7\n275#1:921,5\n275#1:926\n275#1:928,8\n275#1:936,6\n275#1:943,2\n275#1:948,8\n275#1:959,9\n275#1:971,8\n275#1:979,7\n283#1:986,5\n283#1:991\n283#1:993,8\n283#1:1001,6\n283#1:1008,2\n283#1:1013,8\n283#1:1024,9\n283#1:1036,8\n283#1:1044,7\n292#1:1051\n292#1:1059,15\n292#1:1074,6\n292#1:1081,2\n292#1:1086,8\n292#1:1097,9\n292#1:1109,8\n292#1:1117,8\n297#1:1125\n297#1:1127\n297#1:1131,7\n297#1:1139,9\n297#1:1148,6\n297#1:1155,2\n297#1:1160,17\n297#1:1180,8\n297#1:1188,6\n303#1:1194,6\n303#1:1201,2\n303#1:1206,8\n303#1:1217,9\n303#1:1229,8\n304#1:1237\n304#1:1239\n304#1:1243,7\n304#1:1251,9\n304#1:1260,6\n304#1:1267,2\n304#1:1272,8\n304#1:1283,9\n304#1:1295,8\n304#1:1303,6\n310#1:1309\n310#1:1317\n310#1:1321,12\n311#1:1333,6\n311#1:1340,2\n311#1:1345,8\n311#1:1356,9\n311#1:1368,8\n310#1:1376,8\n255#1:738\n263#1:860\n275#1:927\n283#1:992\n297#1:1126\n304#1:1238\n82#1:476,7\n104#1:483,7\n167#1:505,7\n193#1:516,7\n204#1:533,7\n220#1:540,7\n233#1:548,7\n240#1:619,7\n247#1:680,7\n292#1:1052,7\n310#1:1310,7\n331#1:1384,9\n336#1:1393,9\n367#1:1402,7\n371#1:1410,7\n131#1:490,11\n145#1:504\n297#1:1138\n304#1:1250\n138#1:501\n138#1:502,2\n168#1:512\n168#1:513,2\n234#1:581\n234#1:582,2\n241#1:652\n241#1:653,2\n248#1:711\n248#1:712,2\n255#1:767\n255#1:768,2\n255#1:829\n255#1:830,2\n266#1:891\n266#1:892,2\n275#1:956\n275#1:957,2\n283#1:1021\n283#1:1022,2\n292#1:1094\n292#1:1095,2\n297#1:1128\n297#1:1129,2\n303#1:1214\n303#1:1215,2\n304#1:1240\n304#1:1241,2\n304#1:1280\n304#1:1281,2\n310#1:1318\n310#1:1319,2\n311#1:1353\n311#1:1354,2\n451#1:1426\n451#1:1427,2\n234#1:567\n241#1:638\n248#1:697\n255#1:753\n264#1:869\n265#1:870\n266#1:877\n275#1:942\n283#1:1007\n292#1:1080\n297#1:1154\n303#1:1200\n304#1:1266\n311#1:1339\n394#1:1418\n400#1:1420\n437#1:1421\n444#1:1425\n234#1:570,3\n234#1:593,3\n241#1:641,3\n241#1:664,3\n248#1:700,3\n248#1:723,3\n255#1:756,3\n255#1:779,3\n255#1:818,3\n255#1:841,3\n266#1:880,3\n266#1:903,3\n275#1:945,3\n275#1:968,3\n283#1:1010,3\n283#1:1033,3\n292#1:1083,3\n292#1:1106,3\n297#1:1157,3\n297#1:1177,3\n303#1:1203,3\n303#1:1226,3\n304#1:1269,3\n304#1:1292,3\n311#1:1342,3\n311#1:1365,3\n443#1:1422,3\n443#1:1429,3\n370#1:1409\n394#1:1417\n400#1:1419\n*E\n"})
public final class DelegatableNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node) {
        MutableVector<LayoutNode> mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i = size - 1;
            LayoutNode[] content = mutableVector2.getContent();
            do {
                mutableVector.add(content[i].getNodes().getHead());
                i--;
            } while (i >= 0);
        }
    }

    /* JADX INFO: renamed from: ancestors-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> List<T> m19973ancestors64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet() & i) != 0) {
                        for (Modifier.Node nodePop = parent$ui_release; nodePop != null; nodePop = pop(null)) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(nodePop);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final LayoutModifierNode asLayoutModifierNode(@NotNull Modifier.Node node) {
        if ((NodeKind.m20090constructorimpl(2) & node.getKindSet()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate();
                while (delegate$ui_release != 0) {
                    if (delegate$ui_release instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) delegate$ui_release;
                    }
                    delegate$ui_release = (!(delegate$ui_release instanceof DelegatingNode) || (NodeKind.m20090constructorimpl(2) & delegate$ui_release.getKindSet()) == 0) ? delegate$ui_release.getChild() : ((DelegatingNode) delegate$ui_release).getDelegate();
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: dispatchForKind-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19974dispatchForKind6rFNWt0(Modifier.Node node, int i, Function1<? super T, Unit> function1) {
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            function1.invoke(node);
            node = pop(null);
        }
    }

    /* JADX INFO: renamed from: has-64DMado, reason: not valid java name */
    public static final boolean m19975has64DMado(@NotNull DelegatableNode delegatableNode, int i) {
        return (delegatableNode.getNode().getAggregateChildKindSet() & i) != 0;
    }

    public static final void invalidateSubtree(@NotNull DelegatableNode delegatableNode) {
        if (delegatableNode.getNode().getIsAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode(delegatableNode), false, 1, null);
        }
    }

    public static final boolean isDelegationRoot(@NotNull DelegatableNode delegatableNode) {
        return delegatableNode.getNode() == delegatableNode;
    }

    @Nullable
    public static final Modifier.Node nearestAncestor(@NotNull DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("nearestAncestor called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet() & i) != 0) {
                        return parent$ui_release;
                    }
                    parent$ui_release = parent$ui_release.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX INFO: renamed from: nearestAncestor-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m19976nearestAncestor64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Object parent$ui_release = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent$ui_release != null) {
                    if ((((Modifier.Node) parent$ui_release).getKindSet() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        return (T) parent$ui_release;
                    }
                    parent$ui_release = (T) ((Modifier.Node) parent$ui_release).getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? (T) null : (T) nodes.getTail();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node pop(MutableVector<Modifier.Node> mutableVector) {
        if (mutableVector == null || mutableVector.isEmpty()) {
            return null;
        }
        return (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
    }

    @NotNull
    /* JADX INFO: renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m19977requireCoordinator64DMado(@NotNull DelegatableNode delegatableNode, int i) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() != delegatableNode || !NodeKindKt.m20099getIncludeSelfInTraversalH91voCI(i)) {
            return coordinator$ui_release;
        }
        NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    @NotNull
    public static final Density requireDensity(@NotNull DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getDensity();
    }

    @NotNull
    public static final GraphicsContext requireGraphicsContext(@NotNull DelegatableNode delegatableNode) {
        return requireOwner(delegatableNode).getGraphicsContext();
    }

    @NotNull
    public static final LayoutCoordinates requireLayoutCoordinates(@NotNull DelegatableNode delegatableNode) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        LayoutCoordinates coordinates = m19977requireCoordinator64DMado(delegatableNode, NodeKind.m20090constructorimpl(2)).getCoordinates();
        if (!coordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return coordinates;
    }

    @NotNull
    public static final LayoutDirection requireLayoutDirection(@NotNull DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getLayoutDirection();
    }

    @NotNull
    public static final LayoutNode requireLayoutNode(@NotNull DelegatableNode delegatableNode) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw AbstractC1974b.m1327t("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    @NotNull
    public static final Owner requireOwner(@NotNull DelegatableNode delegatableNode) {
        Owner owner = requireLayoutNode(delegatableNode).getOwner();
        if (owner != null) {
            return owner;
        }
        throw AbstractC1974b.m1327t("This node does not have an owner.");
    }

    public static final void visitAncestors(@NotNull DelegatableNode delegatableNode, int i, boolean z, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        function1.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    public static /* synthetic */ void visitAncestors$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        NodeChain nodes;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        function1.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX INFO: renamed from: visitAncestors-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m19978visitAncestorsYYKmho(DelegatableNode delegatableNode, int i, boolean z, Function1<? super T, Unit> function1) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        for (Modifier.Node nodePop = node; nodePop != null; nodePop = pop(null)) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(nodePop);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX INFO: renamed from: visitAncestors-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m19979visitAncestorsYYKmho$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        NodeChain nodes;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        for (Modifier.Node nodePop = node; nodePop != null; nodePop = pop(null)) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(nodePop);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    public static final void visitChildren(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node child$ui_release2 = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((child$ui_release2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child$ui_release2);
            } else {
                while (true) {
                    if (child$ui_release2 == null) {
                        break;
                    }
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        function1.invoke(child$ui_release2);
                        break;
                    }
                    child$ui_release2 = child$ui_release2.getChild();
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitChildren-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19980visitChildren6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((nodePop.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & i) != 0) {
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(nodePop);
                            nodePop = pop(null);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    public static final void visitLocalAncestors(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
            if ((parent$ui_release.getKindSet() & i) != 0) {
                function1.invoke(parent$ui_release);
            }
        }
    }

    /* JADX INFO: renamed from: visitLocalAncestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19981visitLocalAncestors6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
            if ((parent$ui_release.getKindSet() & i) != 0) {
                for (Modifier.Node nodePop = parent$ui_release; nodePop != null; nodePop = pop(null)) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    function1.invoke(nodePop);
                }
            }
        }
    }

    public static final void visitLocalDescendants(@NotNull DelegatableNode delegatableNode, int i, boolean z, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) == 0) {
            return;
        }
        if (!z) {
            node = node.getChild();
        }
        while (node != null) {
            if ((node.getKindSet() & i) != 0) {
                function1.invoke(node);
            }
            node = node.getChild();
        }
    }

    public static /* synthetic */ void visitLocalDescendants$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) == 0) {
            return;
        }
        if (!z) {
            node = node.getChild();
        }
        while (node != null) {
            if ((node.getKindSet() & i) != 0) {
                function1.invoke(node);
            }
            node = node.getChild();
        }
    }

    /* JADX INFO: renamed from: visitLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19982visitLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child$ui_release = node.getChild(); child$ui_release != null; child$ui_release = child$ui_release.getChild()) {
                if ((child$ui_release.getKindSet() & i) != 0) {
                    for (Modifier.Node nodePop = child$ui_release; nodePop != null; nodePop = pop(null)) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        function1.invoke(nodePop);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitSelfAndAncestors-5BbP62I, reason: not valid java name */
    public static final /* synthetic */ <T> void m19983visitSelfAndAncestors5BbP62I(DelegatableNode delegatableNode, int i, int i2, Function1<? super T, Unit> function1) {
        NodeChain nodes;
        Modifier.Node node = delegatableNode.getNode();
        int i4 = i | i2;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i4) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i4) != 0) {
                        if (node2 != node && (node2.getKindSet() & i2) != 0) {
                            return;
                        }
                        if ((node2.getKindSet() & i) != 0) {
                            for (Modifier.Node nodePop = node2; nodePop != null; nodePop = pop(null)) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                function1.invoke(nodePop);
                            }
                        }
                    }
                    node2 = node2.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node2 = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX INFO: renamed from: visitSelfAndChildren-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19984visitSelfAndChildren6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        for (Modifier.Node node = delegatableNode.getNode(); node != null; node = pop(null)) {
            Intrinsics.reifiedOperationMarker(3, "T");
            function1.invoke(node);
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((nodePop.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & i) != 0) {
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(nodePop);
                            nodePop = pop(null);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitSelfAndLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19985visitSelfAndLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            while (node != null) {
                if ((node.getKindSet() & i) != 0) {
                    for (Modifier.Node nodePop = node; nodePop != null; nodePop = pop(null)) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        function1.invoke(nodePop);
                    }
                }
                node = node.getChild();
            }
        }
    }

    public static final void visitSubtree(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layoutNodeRequireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = layoutNodeRequireLayoutNode.getNodes().getHead();
            }
            if ((child$ui_release.getAggregateChildKindSet() & i) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet() & i) != 0) {
                        function1.invoke(child$ui_release);
                    }
                    child$ui_release = child$ui_release.getChild();
                }
            }
            nestedVectorStack.push(layoutNodeRequireLayoutNode.get_children$ui_release());
            child$ui_release = null;
            layoutNodeRequireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
        }
    }

    /* JADX INFO: renamed from: visitSubtree-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19986visitSubtree6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layoutNodeRequireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = layoutNodeRequireLayoutNode.getNodes().getHead();
            }
            if ((child$ui_release.getAggregateChildKindSet() & i) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet() & i) != 0) {
                        for (Modifier.Node nodePop = child$ui_release; nodePop != null; nodePop = pop(null)) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(nodePop);
                        }
                    }
                    child$ui_release = child$ui_release.getChild();
                }
            }
            nestedVectorStack.push(layoutNodeRequireLayoutNode.get_children$ui_release());
            layoutNodeRequireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
            child$ui_release = null;
        }
    }

    public static final void visitSubtreeIf(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier.Node, Boolean> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) == 0 || function1.invoke(child$ui_release2).booleanValue()) {
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node);
        }
    }

    /* JADX INFO: renamed from: visitSubtreeIf-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m19987visitSubtreeIf6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Boolean> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        for (Modifier.Node nodePop = child$ui_release2; nodePop != null; nodePop = pop(null)) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (!function1.invoke(nodePop).booleanValue()) {
                                break;
                            }
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node);
        }
    }

    public static final void visitLocalDescendants(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child$ui_release = node.getChild(); child$ui_release != null; child$ui_release = child$ui_release.getChild()) {
                if ((child$ui_release.getKindSet() & i) != 0) {
                    function1.invoke(child$ui_release);
                }
            }
        }
    }
}
