package com.samsung.android.app.notes.widget.glance.list.setting.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.painter.Painter;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.res.PainterResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.color.ColorProviders;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ActionButtonData;
import androidx.glance.oneui.template.ActionIcon;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.component.TextKt;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.glance.list.common.WidgetListGlanceItem;
import com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceTheme;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0012H\u0002J5\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010(J\u001d\u0010)\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010*J\u001d\u0010+\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010*J\u0015\u0010,\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010(J#\u0010-\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0007¢\u0006\u0002\u0010.J4\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u00020%0\"H\u0002J#\u00102\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0007¢\u0006\u0002\u0010.J\u001d\u00104\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0003¢\u0006\u0002\u00107J\u001d\u00108\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u000206H\u0003¢\u0006\u0002\u00107J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0002J\u0015\u0010<\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010(J/\u0010=\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010\u001a\u001a\u00020\u0012H\u0007¢\u0006\u0004\bA\u0010BJ'\u0010C\u001a\u00020\t2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010\u001a\u001a\u00020\u0012H\u0007¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\t2\u0006\u0010@\u001a\u00020?2\u0006\u0010\u001a\u001a\u00020\u0012H\u0007¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingPreview;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/samsung/android/app/notes/widget/glance/list/setting/presenter/WidgetListGlanceSettingPresenter;", "<init>", "(Landroid/view/View;Lcom/samsung/android/app/notes/widget/glance/list/setting/presenter/WidgetListGlanceSettingPresenter;)V", "setContent", "", "requestTime", "", "(JLandroidx/compose/runtime/Composer;I)V", "getShape", "Landroidx/glance/oneui/template/Shape;", "shapeBG", "", "backgrounOnOff", "", "size", "Landroidx/glance/oneui/common/AppWidgetSize;", "getShape-nwm-oUQ", "(IZI)Landroidx/glance/oneui/template/Shape;", "getSize", "getSize-rx25Pp4", "()I", "isMediumOrLarger", "getTitleBarPreview", "Landroidx/glance/oneui/template/TitleBarData;", "context", "Landroid/content/Context;", "themeManager", "Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;", "buildItemList", "", "Lcom/samsung/android/app/notes/widget/glance/list/common/WidgetListGlanceItem;", "providerName", "", "(Landroid/content/Context;Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/util/List;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/TitleBarData;", "WidgetListEmpty", "(Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "WidgetEmptyMedium", "(Landroid/content/Context;Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "WidgetEmptySmall", "WidgetListExtraLargeCoverEmpty", "ListCustom", "(Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "ListItem", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "uuidList", "ComposeListItem", "listData", "titleText", "mainText", "Landroidx/glance/oneui/template/TypedTextData;", "(Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Landroidx/glance/oneui/template/TypedTextData;Landroidx/compose/runtime/Composer;I)V", "timeText", "getValueForSize", "", "value", "WidgetListSettingLoading", "WidgetListSettingContentLoading", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "itemColor", "WidgetListSettingContentLoading-RIQooxk", "(IJJZLandroidx/compose/runtime/Composer;I)V", "WidgetListSettingContentLoadingSmall", "WidgetListSettingContentLoadingSmall-dgg9oW8", "(JJZLandroidx/compose/runtime/Composer;I)V", "ListSettingItemView", "ListSettingItemView-Iv8Zu3U", "(JZLandroidx/compose/runtime/Composer;I)V", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListGlanceSettingPreview.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlanceSettingPreview.kt\ncom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingPreview\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 8 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 9 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 10 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 11 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,678:1\n149#2:679\n149#2:719\n169#2:721\n149#2:722\n169#2:723\n149#2:724\n149#2:801\n149#2:880\n169#2:949\n149#2:954\n169#2:991\n149#2:1006\n169#2:1007\n169#2:1008\n149#2:1041\n149#2:1121\n169#2:1193\n169#2:1238\n169#2:1274\n149#2:1283\n169#2:1284\n169#2:1285\n169#2:1402\n169#2:1403\n169#2:1404\n169#2:1441\n169#2:1442\n169#2:1483\n169#2:1488\n169#2:1489\n169#2:1576\n169#2:1577\n169#2:1650\n169#2:1651\n169#2:1692\n169#2:1693\n169#2:1694\n169#2:1743\n71#3:680\n69#3,5:681\n74#3:714\n78#3:718\n71#3:725\n68#3,6:726\n74#3:760\n71#3:761\n68#3,6:762\n74#3:796\n78#3:800\n71#3:802\n69#3,5:803\n74#3:836\n71#3:837\n69#3,5:838\n74#3:871\n78#3:875\n78#3:879\n71#3:913\n68#3,6:914\n74#3:948\n78#3:953\n71#3:955\n68#3,6:956\n74#3:990\n78#3:995\n78#3:1003\n71#3:1042\n69#3,5:1043\n74#3:1076\n71#3:1077\n68#3,6:1078\n74#3:1112\n78#3:1116\n78#3:1120\n71#3:1122\n69#3,5:1123\n74#3:1156\n71#3:1157\n68#3,6:1158\n74#3:1192\n78#3:1197\n78#3:1201\n71#3:1239\n69#3,5:1240\n74#3:1273\n78#3:1278\n71#3:1286\n69#3,5:1287\n74#3:1320\n78#3:1330\n71#3:1331\n68#3,6:1332\n74#3:1366\n71#3:1443\n68#3,6:1444\n74#3:1478\n78#3:1482\n78#3:1497\n71#3:1498\n69#3,5:1499\n74#3:1532\n78#3:1575\n71#3:1652\n68#3,6:1653\n74#3:1687\n78#3:1691\n71#3:1695\n68#3,6:1696\n74#3:1730\n78#3:1734\n79#4,6:686\n86#4,4:701\n90#4,2:711\n94#4:717\n79#4,6:732\n86#4,4:747\n90#4,2:757\n79#4,6:768\n86#4,4:783\n90#4,2:793\n94#4:799\n79#4,6:808\n86#4,4:823\n90#4,2:833\n79#4,6:843\n86#4,4:858\n90#4,2:868\n94#4:874\n94#4:878\n79#4,6:884\n86#4,4:899\n90#4,2:909\n79#4,6:920\n86#4,4:935\n90#4,2:945\n94#4:952\n79#4,6:962\n86#4,4:977\n90#4,2:987\n94#4:994\n94#4:998\n94#4:1002\n79#4,6:1012\n86#4,4:1027\n90#4,2:1037\n79#4,6:1048\n86#4,4:1063\n90#4,2:1073\n79#4,6:1084\n86#4,4:1099\n90#4,2:1109\n94#4:1115\n94#4:1119\n79#4,6:1128\n86#4,4:1143\n90#4,2:1153\n79#4,6:1164\n86#4,4:1179\n90#4,2:1189\n94#4:1196\n94#4:1200\n94#4:1204\n79#4,6:1209\n86#4,4:1224\n90#4,2:1234\n79#4,6:1245\n86#4,4:1260\n90#4,2:1270\n94#4:1277\n94#4:1281\n79#4,6:1292\n86#4,4:1307\n90#4,2:1317\n94#4:1329\n79#4,6:1338\n86#4,4:1353\n90#4,2:1363\n79#4,6:1373\n86#4,4:1388\n90#4,2:1398\n79#4,6:1412\n86#4,4:1427\n90#4,2:1437\n79#4,6:1450\n86#4,4:1465\n90#4,2:1475\n94#4:1481\n94#4:1486\n94#4:1492\n94#4:1496\n79#4,6:1504\n86#4,4:1519\n90#4,2:1529\n79#4,6:1539\n86#4,4:1554\n90#4,2:1564\n94#4:1570\n94#4:1574\n79#4,6:1585\n86#4,4:1600\n90#4,2:1610\n79#4,6:1621\n86#4,4:1636\n90#4,2:1646\n79#4,6:1659\n86#4,4:1674\n90#4,2:1684\n94#4:1690\n79#4,6:1702\n86#4,4:1717\n90#4,2:1727\n94#4:1733\n94#4:1737\n94#4:1741\n368#5,9:692\n377#5:713\n378#5,2:715\n368#5,9:738\n377#5:759\n368#5,9:774\n377#5:795\n378#5,2:797\n368#5,9:814\n377#5:835\n368#5,9:849\n377#5:870\n378#5,2:872\n378#5,2:876\n368#5,9:890\n377#5:911\n368#5,9:926\n377#5:947\n378#5,2:950\n368#5,9:968\n377#5:989\n378#5,2:992\n378#5,2:996\n378#5,2:1000\n368#5,9:1018\n377#5:1039\n368#5,9:1054\n377#5:1075\n368#5,9:1090\n377#5:1111\n378#5,2:1113\n378#5,2:1117\n368#5,9:1134\n377#5:1155\n368#5,9:1170\n377#5:1191\n378#5,2:1194\n378#5,2:1198\n378#5,2:1202\n368#5,9:1215\n377#5:1236\n368#5,9:1251\n377#5:1272\n378#5,2:1275\n378#5,2:1279\n368#5,9:1298\n377#5:1319\n378#5,2:1327\n368#5,9:1344\n377#5:1365\n368#5,9:1379\n377#5:1400\n368#5,9:1418\n377#5:1439\n368#5,9:1456\n377#5:1477\n378#5,2:1479\n378#5,2:1484\n378#5,2:1490\n378#5,2:1494\n368#5,9:1510\n377#5:1531\n368#5,9:1545\n377#5:1566\n378#5,2:1568\n378#5,2:1572\n368#5,9:1591\n377#5:1612\n368#5,9:1627\n377#5:1648\n368#5,9:1665\n377#5:1686\n378#5,2:1688\n368#5,9:1708\n377#5:1729\n378#5,2:1731\n378#5,2:1735\n378#5,2:1739\n4034#6,6:705\n4034#6,6:751\n4034#6,6:787\n4034#6,6:827\n4034#6,6:862\n4034#6,6:903\n4034#6,6:939\n4034#6,6:981\n4034#6,6:1031\n4034#6,6:1067\n4034#6,6:1103\n4034#6,6:1147\n4034#6,6:1183\n4034#6,6:1228\n4034#6,6:1264\n4034#6,6:1311\n4034#6,6:1357\n4034#6,6:1392\n4034#6,6:1431\n4034#6,6:1469\n4034#6,6:1523\n4034#6,6:1558\n4034#6,6:1604\n4034#6,6:1640\n4034#6,6:1678\n4034#6,6:1721\n77#7:720\n77#7:1004\n77#7:1005\n86#8,3:881\n89#8:912\n93#8:999\n86#8,3:1206\n89#8:1237\n93#8:1282\n86#8:1367\n84#8,5:1368\n89#8:1401\n93#8:1493\n86#8:1533\n84#8,5:1534\n89#8:1567\n93#8:1571\n86#8:1614\n83#8,6:1615\n89#8:1649\n93#8:1738\n99#9,3:1009\n102#9:1040\n106#9:1205\n99#9:1405\n96#9,6:1406\n102#9:1440\n106#9:1487\n99#9:1578\n96#9,6:1579\n102#9:1613\n106#9:1742\n1225#10,6:1321\n179#11,12:1744\n*S KotlinDebug\n*F\n+ 1 WidgetListGlanceSettingPreview.kt\ncom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingPreview\n*L\n78#1:679\n163#1:719\n182#1:721\n183#1:722\n185#1:723\n187#1:724\n211#1:801\n233#1:880\n251#1:949\n259#1:954\n278#1:991\n292#1:1006\n294#1:1007\n295#1:1008\n306#1:1041\n326#1:1121\n343#1:1193\n362#1:1238\n371#1:1274\n432#1:1283\n432#1:1284\n433#1:1285\n600#1:1402\n601#1:1403\n602#1:1404\n609#1:1441\n610#1:1442\n613#1:1483\n615#1:1488\n619#1:1489\n649#1:1576\n650#1:1577\n659#1:1650\n660#1:1651\n663#1:1692\n667#1:1693\n668#1:1694\n675#1:1743\n74#1:680\n74#1:681,5\n74#1:714\n74#1:718\n190#1:725\n190#1:726,6\n190#1:760\n194#1:761\n194#1:762,6\n194#1:796\n194#1:800\n208#1:802\n208#1:803,5\n208#1:836\n214#1:837\n214#1:838,5\n214#1:871\n214#1:875\n208#1:879\n237#1:913\n237#1:914,6\n237#1:948\n237#1:953\n262#1:955\n262#1:956,6\n262#1:990\n262#1:995\n190#1:1003\n303#1:1042\n303#1:1043,5\n303#1:1076\n309#1:1077\n309#1:1078,6\n309#1:1112\n309#1:1116\n303#1:1120\n323#1:1122\n323#1:1123,5\n323#1:1156\n329#1:1157\n329#1:1158,6\n329#1:1192\n329#1:1197\n323#1:1201\n359#1:1239\n359#1:1240,5\n359#1:1273\n359#1:1278\n427#1:1286\n427#1:1287,5\n427#1:1320\n427#1:1330\n587#1:1331\n587#1:1332,6\n587#1:1366\n606#1:1443\n606#1:1444,6\n606#1:1478\n606#1:1482\n587#1:1497\n627#1:1498\n627#1:1499,5\n627#1:1532\n627#1:1575\n656#1:1652\n656#1:1653,6\n656#1:1687\n656#1:1691\n664#1:1695\n664#1:1696,6\n664#1:1730\n664#1:1734\n74#1:686,6\n74#1:701,4\n74#1:711,2\n74#1:717\n190#1:732,6\n190#1:747,4\n190#1:757,2\n194#1:768,6\n194#1:783,4\n194#1:793,2\n194#1:799\n208#1:808,6\n208#1:823,4\n208#1:833,2\n214#1:843,6\n214#1:858,4\n214#1:868,2\n214#1:874\n208#1:878\n230#1:884,6\n230#1:899,4\n230#1:909,2\n237#1:920,6\n237#1:935,4\n237#1:945,2\n237#1:952\n262#1:962,6\n262#1:977,4\n262#1:987,2\n262#1:994\n230#1:998\n190#1:1002\n297#1:1012,6\n297#1:1027,4\n297#1:1037,2\n303#1:1048,6\n303#1:1063,4\n303#1:1073,2\n309#1:1084,6\n309#1:1099,4\n309#1:1109,2\n309#1:1115\n303#1:1119\n323#1:1128,6\n323#1:1143,4\n323#1:1153,2\n329#1:1164,6\n329#1:1179,4\n329#1:1189,2\n329#1:1196\n323#1:1200\n297#1:1204\n353#1:1209,6\n353#1:1224,4\n353#1:1234,2\n359#1:1245,6\n359#1:1260,4\n359#1:1270,2\n359#1:1277\n353#1:1281\n427#1:1292,6\n427#1:1307,4\n427#1:1317,2\n427#1:1329\n587#1:1338,6\n587#1:1353,4\n587#1:1363,2\n592#1:1373,6\n592#1:1388,4\n592#1:1398,2\n596#1:1412,6\n596#1:1427,4\n596#1:1437,2\n606#1:1450,6\n606#1:1465,4\n606#1:1475,2\n606#1:1481\n596#1:1486\n592#1:1492\n587#1:1496\n627#1:1504,6\n627#1:1519,4\n627#1:1529,2\n633#1:1539,6\n633#1:1554,4\n633#1:1564,2\n633#1:1570\n627#1:1574\n645#1:1585,6\n645#1:1600,4\n645#1:1610,2\n653#1:1621,6\n653#1:1636,4\n653#1:1646,2\n656#1:1659,6\n656#1:1674,4\n656#1:1684,2\n656#1:1690\n664#1:1702,6\n664#1:1717,4\n664#1:1727,2\n664#1:1733\n653#1:1737\n645#1:1741\n74#1:692,9\n74#1:713\n74#1:715,2\n190#1:738,9\n190#1:759\n194#1:774,9\n194#1:795\n194#1:797,2\n208#1:814,9\n208#1:835\n214#1:849,9\n214#1:870\n214#1:872,2\n208#1:876,2\n230#1:890,9\n230#1:911\n237#1:926,9\n237#1:947\n237#1:950,2\n262#1:968,9\n262#1:989\n262#1:992,2\n230#1:996,2\n190#1:1000,2\n297#1:1018,9\n297#1:1039\n303#1:1054,9\n303#1:1075\n309#1:1090,9\n309#1:1111\n309#1:1113,2\n303#1:1117,2\n323#1:1134,9\n323#1:1155\n329#1:1170,9\n329#1:1191\n329#1:1194,2\n323#1:1198,2\n297#1:1202,2\n353#1:1215,9\n353#1:1236\n359#1:1251,9\n359#1:1272\n359#1:1275,2\n353#1:1279,2\n427#1:1298,9\n427#1:1319\n427#1:1327,2\n587#1:1344,9\n587#1:1365\n592#1:1379,9\n592#1:1400\n596#1:1418,9\n596#1:1439\n606#1:1456,9\n606#1:1477\n606#1:1479,2\n596#1:1484,2\n592#1:1490,2\n587#1:1494,2\n627#1:1510,9\n627#1:1531\n633#1:1545,9\n633#1:1566\n633#1:1568,2\n627#1:1572,2\n645#1:1591,9\n645#1:1612\n653#1:1627,9\n653#1:1648\n656#1:1665,9\n656#1:1686\n656#1:1688,2\n664#1:1708,9\n664#1:1729\n664#1:1731,2\n653#1:1735,2\n645#1:1739,2\n74#1:705,6\n190#1:751,6\n194#1:787,6\n208#1:827,6\n214#1:862,6\n230#1:903,6\n237#1:939,6\n262#1:981,6\n297#1:1031,6\n303#1:1067,6\n309#1:1103,6\n323#1:1147,6\n329#1:1183,6\n353#1:1228,6\n359#1:1264,6\n427#1:1311,6\n587#1:1357,6\n592#1:1392,6\n596#1:1431,6\n606#1:1469,6\n627#1:1523,6\n633#1:1558,6\n645#1:1604,6\n653#1:1640,6\n656#1:1678,6\n664#1:1721,6\n165#1:720\n288#1:1004\n289#1:1005\n230#1:881,3\n230#1:912\n230#1:999\n353#1:1206,3\n353#1:1237\n353#1:1282\n592#1:1367\n592#1:1368,5\n592#1:1401\n592#1:1493\n633#1:1533\n633#1:1534,5\n633#1:1567\n633#1:1571\n653#1:1614\n653#1:1615,6\n653#1:1649\n653#1:1738\n297#1:1009,3\n297#1:1040\n297#1:1205\n596#1:1405\n596#1:1406,6\n596#1:1440\n596#1:1487\n645#1:1578\n645#1:1579,6\n645#1:1613\n645#1:1742\n441#1:1321,6\n442#1:1744,12\n*E\n"})
public final class WidgetListGlanceSettingPreview {
    public static final int $stable = 8;

    @NotNull
    private final View parent;

    @NotNull
    private final WidgetListGlanceSettingPresenter presenter;

    public WidgetListGlanceSettingPreview(@NotNull View parent, @NotNull WidgetListGlanceSettingPresenter presenter) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.parent = parent;
        this.presenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComposeListItem$lambda$33$lambda$32$lambda$31(final List list, final int i, final boolean z, final WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, final long j, final float f, final WidgetListGlanceTheme widgetListGlanceTheme, final long j2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final C6955h c6955h = new C6955h(0);
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview$ComposeListItem$lambda$33$lambda$32$lambda$31$$inlined$itemsIndexed$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Object invoke(int i2) {
                return c6955h.invoke(Integer.valueOf(i2), list.get(i2));
            }
        }, new Function1<Integer, Object>() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview$ComposeListItem$lambda$33$lambda$32$lambda$31$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final Object invoke(int i2) {
                list.get(i2);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview$ComposeListItem$lambda$33$lambda$32$lambda$31$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@NotNull LazyItemScope lazyItemScope, int i2, @Nullable Composer composer, int i4) {
                Modifier.Companion companion;
                ComposeUiNode.Companion companion2;
                boolean z2;
                float f4;
                int i5;
                WidgetListGlanceSettingPreview widgetListGlanceSettingPreview2;
                float f5;
                int i6 = (i4 & 6) == 0 ? i4 | (composer.changed(lazyItemScope) ? 4 : 2) : i4;
                if ((i4 & 48) == 0) {
                    i6 |= composer.changed(i2) ? 32 : 16;
                }
                if ((i6 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1091073711, i6, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                }
                WidgetListGlanceItem widgetListGlanceItem = (WidgetListGlanceItem) list.get(i2);
                composer.startReplaceGroup(408154124);
                composer.startMovableGroup(1121544919, Integer.valueOf(i2));
                int i7 = i;
                boolean z3 = i7 > 1 && i2 < i7 - 1;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion4.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion3);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion5.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
                Function2 function2M1177w = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                }
                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion3, C2256Dp.m20968constructorimpl(z ? widgetListGlanceSettingPreview.getValueForSize(14.0f) : widgetListGlanceSettingPreview.getValueForSize(15.0f)), 0.0f, C2256Dp.m20968constructorimpl(z ? widgetListGlanceSettingPreview.getValueForSize(14.0f) : widgetListGlanceSettingPreview.getValueForSize(15.0f)), C2256Dp.m20968constructorimpl(0), 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM15858paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
                Function2 function2M1177w2 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
                if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                }
                Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composer, 48);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion3);
                Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer);
                Function2 function2M1177w3 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, currentCompositionLocalMap3);
                if (composerM18018constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash3, function2M1177w3, composerM18018constructorimpl3, currentCompositeKeyHash3);
                }
                Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composer.startReplaceGroup(-361875348);
                if (widgetListGlanceItem.getIconBitmap() != null) {
                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(BorderKt.m15420borderxT4_qwU(ClipKt.clip(companion3, RoundedCornerShapeKt.getCircleShape()), C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(1.0f)), j, RoundedCornerShapeKt.getCircleShape()), C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(f)));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM15899size3ABfNKs);
                    Function0<ComposeUiNode> constructor4 = companion5.getConstructor();
                    if (composer.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor4);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composer);
                    Function2 function2M1177w4 = AbstractC0622a.m1177w(companion5, composerM18018constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl4, currentCompositionLocalMap4);
                    if (composerM18018constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash4, function2M1177w4, composerM18018constructorimpl4, currentCompositeKeyHash4);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                    Bitmap iconBitmap = widgetListGlanceItem.getIconBitmap();
                    ImageBitmap imageBitmapAsImageBitmap = iconBitmap != null ? AndroidImageBitmap_androidKt.asImageBitmap(iconBitmap) : null;
                    Intrinsics.checkNotNull(imageBitmapAsImageBitmap);
                    companion2 = companion5;
                    companion = companion3;
                    f4 = 3.0f;
                    i5 = 3;
                    ImageKt.m15465Image5hnEew(imageBitmapAsImageBitmap, "ds", SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composer, 25008, JPEG.APP8);
                    composer.endNode();
                    z2 = false;
                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, z ? C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(8.0f)) : i < 3 ? C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(4.0f)) : C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(3.0f))), composer, 0);
                } else {
                    companion = companion3;
                    companion2 = companion5;
                    z2 = false;
                    f4 = 3.0f;
                    i5 = 3;
                }
                composer.endReplaceGroup();
                Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, z2, i5, null);
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(7.0f));
                if (z) {
                    widgetListGlanceSettingPreview2 = widgetListGlanceSettingPreview;
                    f5 = 7.2f;
                } else {
                    widgetListGlanceSettingPreview2 = widgetListGlanceSettingPreview;
                    f5 = 5.2f;
                }
                Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(modifierWrapContentHeight$default, 0.0f, fM20968constructorimpl, 0.0f, C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview2.getValueForSize(f5)), 5, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composer, 0);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM15858paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor5 = companion2.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor5);
                } else {
                    composer.useNode();
                }
                Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composer);
                ComposeUiNode.Companion companion6 = companion2;
                Function2 function2M1177w5 = AbstractC0622a.m1177w(companion6, composerM18018constructorimpl5, measurePolicyColumnMeasurePolicy2, composerM18018constructorimpl5, currentCompositionLocalMap5);
                if (composerM18018constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash5, function2M1177w5, composerM18018constructorimpl5, currentCompositeKeyHash5);
                }
                Updater.m18025setimpl(composerM18018constructorimpl5, modifierMaterializeModifier5, companion6.getSetModifier());
                WidgetListGlanceSettingPreview widgetListGlanceSettingPreview3 = widgetListGlanceSettingPreview;
                WidgetListGlanceTheme widgetListGlanceTheme2 = widgetListGlanceTheme;
                TypedTextData title = widgetListGlanceItem.getTitle();
                int i8 = TypedTextData.$stable;
                widgetListGlanceSettingPreview3.titleText(widgetListGlanceTheme2, title, composer, i8 << 3);
                SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(0.8f))), composer, 0);
                Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(companion, null, false, i5, null);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getCenterVertically(), composer, 48);
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer, modifierWrapContentSize$default);
                Function0<ComposeUiNode> constructor6 = companion6.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor6);
                } else {
                    composer.useNode();
                }
                Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composer);
                Function2 function2M1177w6 = AbstractC0622a.m1177w(companion6, composerM18018constructorimpl6, measurePolicyRowMeasurePolicy2, composerM18018constructorimpl6, currentCompositionLocalMap6);
                if (composerM18018constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash6, function2M1177w6, composerM18018constructorimpl6, currentCompositeKeyHash6);
                }
                Updater.m18025setimpl(composerM18018constructorimpl6, modifierMaterializeModifier6, companion6.getSetModifier());
                widgetListGlanceSettingPreview.timeText(widgetListGlanceTheme, widgetListGlanceItem.getTime(), composer, i8 << i5);
                List<ImageData> iconVoiceAndFavorite = widgetListGlanceItem.getIconVoiceAndFavorite(widgetListGlanceTheme.updateListItemIconVoiceColor());
                composer.startReplaceGroup(-306840178);
                int size = iconVoiceAndFavorite.size();
                for (int i9 = 0; i9 < size; i9++) {
                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(f4))), composer, 0);
                    androidx.glance.oneui.template.component.ImageKt.m21705TemplateImage73KfpEQ(iconVoiceAndFavorite.get(i9), C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(13.0f)), C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(13.0f)), composer, ImageData.$stable);
                }
                composer.endReplaceGroup();
                composer.endNode();
                composer.endNode();
                composer.endNode();
                composer.endNode();
                composer.startReplaceGroup(-356424190);
                if (z3) {
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(PaddingKt.m15858paddingqDBjuR0$default(companion7, C2256Dp.m20968constructorimpl(DeviceUtils.isTabletModel() ? 57 : 46), 0.0f, C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(14.0f)), 0.0f, 10, null), 0.0f, 1, null), null, false, i5, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, modifierWrapContentHeight$default2);
                    ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor7 = companion8.getConstructor();
                    if (composer.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor7);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM18018constructorimpl7 = Updater.m18018constructorimpl(composer);
                    Function2 function2M1177w7 = AbstractC0622a.m1177w(companion8, composerM18018constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM18018constructorimpl7, currentCompositionLocalMap7);
                    if (composerM18018constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash7, function2M1177w7, composerM18018constructorimpl7, currentCompositeKeyHash7);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl7, modifierMaterializeModifier7, companion8.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    SpacerKt.Spacer(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), C2256Dp.m20968constructorimpl(widgetListGlanceSettingPreview.getValueForSize(1.0f))), j2, null, 2, null), composer, 0);
                    composer.endNode();
                }
                composer.endReplaceGroup();
                composer.endNode();
                composer.endMovableGroup();
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ComposeListItem$lambda$33$lambda$32$lambda$31$lambda$21(int i, WidgetListGlanceItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Integer.valueOf(item.getMUuid().hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComposeListItem$lambda$34(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, List list, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.ComposeListItem(widgetListGlanceTheme, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListCustom$lambda$20(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, List list, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.ListCustom(widgetListGlanceTheme, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private final List<WidgetListGlanceItem> ListItem(Context context, int appWidgetId, WidgetListGlanceTheme themeManager, List<String> uuidList) {
        ArrayList arrayList = new ArrayList();
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository();
        boolean zIsBlackBackground = themeManager.isBlackBackground();
        for (String str : uuidList) {
            MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(str);
            if (mainListDocumentData != null) {
                arrayList.add(new WidgetListGlanceItem(context, appWidgetId, mainListDocumentData, str, mainListDocumentData.getIsLock() != 5, zIsBlackBackground));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListSettingItemView_Iv8Zu3U$lambda$50(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, long j, boolean z, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.m22128ListSettingItemViewIv8Zu3U(j, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmptyMedium$lambda$10(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, Context context, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.WidgetEmptyMedium(context, widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmptySmall$lambda$16(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, Context context, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.WidgetEmptySmall(context, widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListEmpty$lambda$2(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.WidgetListEmpty(widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListExtraLargeCoverEmpty$lambda$19(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.WidgetListExtraLargeCoverEmpty(widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListSettingContentLoadingSmall_dgg9oW8$lambda$45(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, long j, long j2, boolean z, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.m22130WidgetListSettingContentLoadingSmalldgg9oW8(j, j2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListSettingContentLoading_RIQooxk$lambda$42(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, int i, long j, long j2, boolean z, int i2, Composer composer, int i4) {
        widgetListGlanceSettingPreview.m22129WidgetListSettingContentLoadingRIQooxk(i, j, j2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetListSettingLoading$lambda$37(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.WidgetListSettingLoading(widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getSize-rx25Pp4, reason: not valid java name */
    private final int m22127getSizerx25Pp4() {
        int column = this.presenter.getMModel().getColumn();
        int row = this.presenter.getMModel().getRow();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        Context context = this.parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.m21564getKiq_Kzg(context, column, row);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getValueForSize(float value) {
        return value;
    }

    private final boolean isMediumOrLarger() {
        int iM22127getSizerx25Pp4 = m22127getSizerx25Pp4();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(iM22127getSizerx25Pp4, companion.m21572getUnknownrx25Pp4()) || AppWidgetSize.m21546compareToL2j3NV4(m22127getSizerx25Pp4(), companion.m21569getMediumrx25Pp4()) < 0) {
            return this.presenter.getMModel().getColumn() >= 2 && this.presenter.getMModel().getRow() >= 2;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setContent$lambda$1(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, long j, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.setContent(j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public final void timeText(WidgetListGlanceTheme widgetListGlanceTheme, TypedTextData typedTextData, Composer composer, int i) {
        WidgetListGlanceTheme widgetListGlanceTheme2;
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-321013855);
        if ((i & 6) == 0) {
            widgetListGlanceTheme2 = widgetListGlanceTheme;
            i2 = (composerStartRestartGroup.changedInstance(widgetListGlanceTheme2) ? 4 : 2) | i;
        } else {
            widgetListGlanceTheme2 = widgetListGlanceTheme;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(typedTextData) : composerStartRestartGroup.changedInstance(typedTextData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-321013855, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.timeText (WidgetListGlanceSettingPreview.kt:556)");
            }
            TextKt.m21709TemplateText3SkNqBk(new TextData(String.valueOf(typedTextData.getText()), widgetListGlanceTheme2.updateListItemTimeColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(getValueForSize(12.0f)), FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, composerStartRestartGroup, TextData.$stable, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6950c(this, widgetListGlanceTheme2, typedTextData, i, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit timeText$lambda$36(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, TypedTextData typedTextData, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.timeText(widgetListGlanceTheme, typedTextData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public final void titleText(WidgetListGlanceTheme widgetListGlanceTheme, TypedTextData typedTextData, Composer composer, int i) {
        WidgetListGlanceTheme widgetListGlanceTheme2;
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1097149422);
        if ((i & 6) == 0) {
            widgetListGlanceTheme2 = widgetListGlanceTheme;
            i2 = (composerStartRestartGroup.changedInstance(widgetListGlanceTheme2) ? 4 : 2) | i;
        } else {
            widgetListGlanceTheme2 = widgetListGlanceTheme;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(typedTextData) : composerStartRestartGroup.changedInstance(typedTextData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1097149422, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.titleText (WidgetListGlanceSettingPreview.kt:544)");
            }
            TextKt.m21709TemplateText3SkNqBk(new TextData(String.valueOf(typedTextData.getText()), widgetListGlanceTheme2.updateListItemTitleColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(getValueForSize(14.0f)), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, composerStartRestartGroup, TextData.$stable, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6950c(this, widgetListGlanceTheme2, typedTextData, i, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit titleText$lambda$35(WidgetListGlanceSettingPreview widgetListGlanceSettingPreview, WidgetListGlanceTheme widgetListGlanceTheme, TypedTextData typedTextData, int i, Composer composer, int i2) {
        widgetListGlanceSettingPreview.titleText(widgetListGlanceTheme, typedTextData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d4  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ComposeListItem(@NotNull final WidgetListGlanceTheme themeManager, @NotNull final List<WidgetListGlanceItem> listData, @Nullable Composer composer, int i) {
        int i2;
        ComposeUiNode.Companion companion;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composer2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(listData, "listData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1415059329);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(listData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415059329, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.ComposeListItem (WidgetListGlanceSettingPreview.kt:417)");
            }
            final int size = listData.size();
            long jColor = themeManager.isBlackBackground() ? ColorKt.Color(654311423) : ColorKt.Color(436207616);
            final long jColor2 = themeManager.isBlackBackground() ? ColorKt.Color(654311423) : ColorKt.Color(637534208);
            final boolean zIsMediumOrLarger = isMediumOrLarger();
            float f = 28.0f;
            if (Build.VERSION.SDK_INT >= 31 && DeviceUtils.isTabletModel()) {
                f = 34.0f;
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, 1, null), 0.0f, zIsMediumOrLarger ? C2256Dp.m20968constructorimpl(0) : C2256Dp.m20968constructorimpl(getValueForSize(7.0f)), 0.0f, C2256Dp.m20968constructorimpl(getValueForSize(zIsMediumOrLarger ? 14.0f : 7.0f)), 5, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(zIsMediumOrLarger ? companion3.getTopStart() : companion3.getCenterStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15858paddingqDBjuR0$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion4, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting()) {
                companion = companion4;
            } else {
                companion = companion4;
                if (!Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), null, false, 3, null);
                composerStartRestartGroup.startReplaceGroup(-1224400529);
                zChangedInstance = composerStartRestartGroup.changedInstance(listData) | composerStartRestartGroup.changed(size) | composerStartRestartGroup.changed(zIsMediumOrLarger) | composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(jColor) | composerStartRestartGroup.changed(f) | composerStartRestartGroup.changedInstance(themeManager) | composerStartRestartGroup.changed(jColor2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final long j = jColor;
                    final float f4 = f;
                    Function1 function1 = new Function1() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WidgetListGlanceSettingPreview.ComposeListItem$lambda$33$lambda$32$lambda$31(listData, size, zIsMediumOrLarger, this, j, f4, themeManager, jColor2, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function1);
                    objRememberedValue = function1;
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierWrapContentHeight$default, null, null, false, null, null, null, false, (Function1) objRememberedValue, composer2, 6, JPEG.COM);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), null, false, 3, null);
            composerStartRestartGroup.startReplaceGroup(-1224400529);
            zChangedInstance = composerStartRestartGroup.changedInstance(listData) | composerStartRestartGroup.changed(size) | composerStartRestartGroup.changed(zIsMediumOrLarger) | composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(jColor) | composerStartRestartGroup.changed(f) | composerStartRestartGroup.changedInstance(themeManager) | composerStartRestartGroup.changed(jColor2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                final long j2 = jColor;
                final float f42 = f;
                Function1 function12 = new Function1() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WidgetListGlanceSettingPreview.ComposeListItem$lambda$33$lambda$32$lambda$31(listData, size, zIsMediumOrLarger, this, j2, f42, themeManager, jColor2, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function12);
                objRememberedValue = function12;
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierWrapContentHeight$default2, null, null, false, null, null, null, false, (Function1) objRememberedValue, composer2, 6, JPEG.COM);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6954g(this, themeManager, listData, i, 0));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void ListCustom(@NotNull WidgetListGlanceTheme themeManager, @NotNull List<WidgetListGlanceItem> buildItemList, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(buildItemList, "buildItemList");
        Composer composerStartRestartGroup = composer.startRestartGroup(1568374087);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(buildItemList) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1568374087, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.ListCustom (WidgetListGlanceSettingPreview.kt:396)");
            }
            ComposeListItem(themeManager, buildItemList, composerStartRestartGroup, i2 & Event.CAPS_LOCK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6954g(this, themeManager, buildItemList, i, 1));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ListSettingItemView-Iv8Zu3U, reason: not valid java name */
    public final void m22128ListSettingItemViewIv8Zu3U(final long j, final boolean z, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1601085014);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1601085014, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.ListSettingItemView (WidgetListGlanceSettingPreview.kt:643)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(46.0f)), 0.0f, C2256Dp.m20968constructorimpl(getValueForSize(18.0f)), 0.0f, 10, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15858paddingqDBjuR0$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(ClipKt.clip(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(10.0f))), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(getValueForSize(6.0f)))), j, null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15409backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w3 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl3, currentCompositionLocalMap3);
            if (composerM18018constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash3, function2M1177w3, composerM18018constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, C2256Dp.m20968constructorimpl(getValueForSize(6.0f))), composerStartRestartGroup, 0);
            Modifier modifierM15409backgroundbw27NRU$default2 = BackgroundKt.m15409backgroundbw27NRU$default(ClipKt.clip(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(10.0f))), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(getValueForSize(6.0f)))), j, null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15409backgroundbw27NRU$default2);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w4 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl4, currentCompositionLocalMap4);
            if (composerM18018constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash4, function2M1177w4, composerM18018constructorimpl4, currentCompositeKeyHash4);
            }
            Updater.m18025setimpl(composerM18018constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (z) {
                SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, C2256Dp.m20968constructorimpl(getValueForSize(20.0f))), composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceSettingPreview.ListSettingItemView_Iv8Zu3U$lambda$50(this.f4588a, j, z, i, (Composer) obj, iIntValue);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void WidgetEmptyMedium(@NotNull Context context, @NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1053110773);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(context) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(themeManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1053110773, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetEmptyMedium (WidgetListGlanceSettingPreview.kt:160)");
            }
            composerStartRestartGroup.startReplaceGroup(1572833243);
            float fM21064getHeightD9Ej5fM = (this.presenter.getMModel().getRow() <= 2 || this.presenter.getMModel().getColumn() < 4) ? DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) : C2256Dp.m20968constructorimpl(180);
            composerStartRestartGroup.endReplaceGroup();
            int i4 = (this.presenter.getMModel().getRow() < 2 || this.presenter.getMModel().getColumn() < 4) ? ContextUtils.isNightMode(context) ? C11391R.drawable.notes_fg_graphic_medium_dark : C11391R.drawable.notes_fg_graphic_medium : ContextUtils.isNightMode(context) ? C11391R.drawable.notes_fg_graphic_large_dark : C11391R.drawable.notes_fg_graphic_large;
            float fM20968constructorimpl = C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_medium_icon_size_with_title));
            float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(56);
            float fM20968constructorimpl3 = context.getResources().getConfiguration().orientation == 2 ? C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_medium_sub_title_margin_bottom)) : C2256Dp.m20968constructorimpl(16);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM21064getHeightD9Ej5fM);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15885height3ABfNKs);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Painter painterPainterResource = PainterResources_androidKt.painterResource(i4, composerStartRestartGroup, 0);
            String string = context.getResources().getString(C11391R.string.widget_welcome_page_title_start);
            float f = fM20968constructorimpl3;
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            ContentScale.Companion companion4 = ContentScale.INSTANCE;
            ImageKt.Image(painterPainterResource, string, modifierFillMaxSize$default2, (Alignment) null, companion4.getCrop(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24960, 104);
            composerStartRestartGroup.endNode();
            float f4 = 14;
            Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(SizeKt.wrapContentSize$default(companion, null, false, 3, null), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(0));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15857paddingqDBjuR0);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w3 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM18018constructorimpl3, currentCompositionLocalMap3);
            if (composerM18018constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash3, function2M1177w3, composerM18018constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(companion, fM20968constructorimpl);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15899size3ABfNKs);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w4 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, composerM18018constructorimpl4, currentCompositionLocalMap4);
            if (composerM18018constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash4, function2M1177w4, composerM18018constructorimpl4, currentCompositeKeyHash4);
            }
            Updater.m18025setimpl(composerM18018constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            ImageKt.Image(PainterResources_androidKt.painterResource(C11391R.drawable.ic_widget_note_512, composerStartRestartGroup, 0), context.getResources().getString(C11391R.string.widget_welcome_page_title_start), SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), (Alignment) null, companion4.getCrop(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24960, 104);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            float f5 = 16;
            Modifier modifierM15857paddingqDBjuR02 = PaddingKt.m15857paddingqDBjuR0(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(f5), fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f5), f);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getBottom(), companion2.getStart(), composerStartRestartGroup, 54);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15857paddingqDBjuR02);
            Function0<ComposeUiNode> constructor5 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w5 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl5, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl5, currentCompositionLocalMap5);
            if (composerM18018constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash5, function2M1177w5, composerM18018constructorimpl5, currentCompositeKeyHash5);
            }
            Updater.m18025setimpl(composerM18018constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentHeight$default);
            Function0<ComposeUiNode> constructor6 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w6 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy5, composerM18018constructorimpl6, currentCompositionLocalMap6);
            if (composerM18018constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash6, function2M1177w6, composerM18018constructorimpl6, currentCompositeKeyHash6);
            }
            Updater.m18025setimpl(composerM18018constructorimpl6, modifierMaterializeModifier6, companion3.getSetModifier());
            boolean z = false;
            int i5 = 0;
            TextData textData = new TextData(C11391R.string.widget_welcome_page_title_get_started, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, z, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, i5, 32766, (DefaultConstructorMarker) null);
            int i6 = C11391R.string.widget_welcome_page_title_get_started;
            TextAlign.Companion companion5 = TextAlign.INSTANCE;
            TextData textData2 = new TextData(i6, themeManager.updateWelcomePageTextColor(), companion5.m22011getStartROrN78o(), (TextDecoration) null, 0, textData.getFontFamily(), 1, z, false, (TextShadowStyle) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), (RemoteAnimation) null, (boolean) (0 == true ? 1 : 0), i5, 0, 32664, (DefaultConstructorMarker) null);
            float fM20968constructorimpl4 = C2256Dp.m20968constructorimpl(14.0f);
            FontWeight.Companion companion6 = FontWeight.INSTANCE;
            int iM21999getSemiBoldWjrlUT0 = companion6.m21999getSemiBoldWjrlUT0();
            int i7 = TextData.$stable | 48;
            TextKt.m21710TemplateTextGUlxjmo(textData2, fM20968constructorimpl4, iM21999getSemiBoldWjrlUT0, composerStartRestartGroup, i7);
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(1)), composerStartRestartGroup, 6);
            Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentHeight$default2);
            Function0<ComposeUiNode> constructor7 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor7);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl7 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w7 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy6, composerM18018constructorimpl7, currentCompositionLocalMap7);
            if (composerM18018constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash7, function2M1177w7, composerM18018constructorimpl7, currentCompositeKeyHash7);
            }
            Updater.m18025setimpl(composerM18018constructorimpl7, modifierMaterializeModifier7, companion3.getSetModifier());
            boolean z2 = false;
            int i8 = 0;
            TextData textData3 = new TextData(C11391R.string.widget_preview_note_list_tap_to_add_notes, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, z2, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, i8, 32766, (DefaultConstructorMarker) null);
            TextKt.m21710TemplateTextGUlxjmo(new TextData(C11391R.string.widget_preview_note_list_tap_to_add_notes, themeManager.updateWelcomePageTextColor(), companion5.m22011getStartROrN78o(), textData3.getTextDecoration(), textData3.getTextDirection(), textData3.getFontFamily(), 2, z2, false, (TextShadowStyle) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), (RemoteAnimation) null, (boolean) (0 == true ? 1 : 0), i8, 0, 32640, (DefaultConstructorMarker) null), C2256Dp.m20968constructorimpl(12.0f), companion6.m21998getNormalWjrlUT0(), composerStartRestartGroup, i7);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6956i(this, context, themeManager, i, 0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void WidgetEmptySmall(@NotNull Context context, @NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        float fM20968constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(2119695119);
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(context) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(themeManager) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2119695119, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetEmptySmall (WidgetListGlanceSettingPreview.kt:286)");
            }
            Object[] objArr = ((TemplateState) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalTemplateState())).getIconLabelOn() && ((TemplateState) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalTemplateState())).getWidgetLabelOn();
            if (context.getResources().getConfiguration().orientation == 2) {
                fM20968constructorimpl = C2256Dp.m20968constructorimpl(objArr != false ? 28 : 34);
            } else {
                fM20968constructorimpl = objArr != false ? C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_with_title)) : C2256Dp.m20968constructorimpl(context.getResources().getDimension(C11391R.dimen.widget_glance_small_icon_size_without_title));
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f = 0;
            float f4 = 8;
            Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(SizeKt.wrapContentSize$default(companion, null, false, 3, null), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15857paddingqDBjuR0);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(companion, fM20968constructorimpl);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15899size3ABfNKs);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w3 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl3, currentCompositionLocalMap3);
            if (composerM18018constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash3, function2M1177w3, composerM18018constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            ImageKt.Image(PainterResources_androidKt.painterResource(C11391R.drawable.ic_widget_note_512, composerStartRestartGroup, 0), context.getResources().getString(C11391R.string.widget_welcome_page_title_start), SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), (Alignment) null, ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24960, 104);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.wrapContentSize$default(companion, null, false, 3, null), 0.0f, 0.0f, C2256Dp.m20968constructorimpl(f4), 0.0f, 11, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15858paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w4 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM18018constructorimpl4, currentCompositionLocalMap4);
            if (composerM18018constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash4, function2M1177w4, composerM18018constructorimpl4, currentCompositeKeyHash4);
            }
            Updater.m18025setimpl(composerM18018constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentHeight$default);
            Function0<ComposeUiNode> constructor5 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w5 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, composerM18018constructorimpl5, currentCompositionLocalMap5);
            if (composerM18018constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash5, function2M1177w5, composerM18018constructorimpl5, currentCompositeKeyHash5);
            }
            Updater.m18025setimpl(composerM18018constructorimpl5, modifierMaterializeModifier5, companion3.getSetModifier());
            boolean z = false;
            int i4 = 0;
            TextKt.m21710TemplateTextGUlxjmo(new TextData(C11391R.string.widget_welcome_page_title_start, themeManager.updateWelcomePageTextColor(), TextAlign.INSTANCE.m22011getStartROrN78o(), (TextDecoration) null, 0, new TextData(C11391R.string.widget_welcome_page_title_start, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, z, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, i4, 32766, (DefaultConstructorMarker) null).getFontFamily(), 1, z, false, (TextShadowStyle) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), (RemoteAnimation) null, (boolean) (0 == true ? 1 : 0), i4, 0, 32664, (DefaultConstructorMarker) null), C2256Dp.m20968constructorimpl(15.0f), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), composerStartRestartGroup, TextData.$stable | 48);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6956i(this, context, themeManager, i, 1));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void WidgetListEmpty(@NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(2085187969);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085187969, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetListEmpty (WidgetListGlanceSettingPreview.kt:150)");
            }
            Context context = this.parent.getContext();
            if (this.presenter.getMModel().getRow() < 2) {
                composerStartRestartGroup.startReplaceGroup(1722932194);
                Intrinsics.checkNotNull(context);
                WidgetEmptySmall(context, themeManager, composerStartRestartGroup, (i2 << 3) & 1008);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1723000673);
                Intrinsics.checkNotNull(context);
                WidgetEmptyMedium(context, themeManager, composerStartRestartGroup, (i2 << 3) & 1008);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6951d(this, themeManager, i, 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void WidgetListExtraLargeCoverEmpty(@NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-790768787);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-790768787, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetListExtraLargeCoverEmpty (WidgetListGlanceSettingPreview.kt:351)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion2.getCenterHorizontally(), composerStartRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15899size3ABfNKs(ClipKt.clip(companion, RoundedCornerShapeKt.getCircleShape()), C2256Dp.m20968constructorimpl(getValueForSize(38.0f))), ColorKt.Color(4294917180L), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15409backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(C11391R.drawable.ic_induce_app_icon, composerStartRestartGroup, 0), Privacy.KEY_NOTES, PaddingKt.m15854padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(6.3f))), (Alignment) null, ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            boolean z = false;
            int i4 = 0;
            TextData textData = new TextData(C11391R.string.app_name_simple, themeManager.updateListItemTitleColor(), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, z, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, i4, 32764, (DefaultConstructorMarker) null);
            long sp = TextUnitKt.getSp(getValueForSize(14.0f));
            FontWeight.Companion companion4 = FontWeight.INSTANCE;
            int iM21996getBoldWjrlUT0 = companion4.m21996getBoldWjrlUT0();
            int i5 = TextData.$stable;
            TextKt.m21709TemplateText3SkNqBk(textData, sp, iM21996getBoldWjrlUT0, 0.0f, composerStartRestartGroup, i5, 8);
            TextKt.m21709TemplateText3SkNqBk(new TextData(C11391R.string.widget_preview_note_list_tap_to_add_notes, themeManager.updateBodyTextColor(), 0, (TextDecoration) null, 0, (FontFamily) null, (int) (0 == true ? 1 : 0), z, false, (TextShadowStyle) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), (RemoteAnimation) null, (boolean) (0 == true ? 1 : 0), i4, 0, 32764, (DefaultConstructorMarker) null), TextUnitKt.getSp(getValueForSize(12.0f)), companion4.m21998getNormalWjrlUT0(), 0.0f, composerStartRestartGroup, i5, 8);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6951d(this, themeManager, i, 2));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: WidgetListSettingContentLoading-RIQooxk, reason: not valid java name */
    public final void m22129WidgetListSettingContentLoadingRIQooxk(final int i, final long j, final long j2, final boolean z, @Nullable Composer composer, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-390181131);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        boolean z2 = z;
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(this) ? 16384 : 8192;
        }
        int i5 = i4;
        if ((i5 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-390181131, i5, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetListSettingContentLoading (WidgetListGlanceSettingPreview.kt:585)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), j, null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15409backgroundbw27NRU$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(18.0f)), C2256Dp.m20968constructorimpl(getValueForSize(21.0f)), C2256Dp.m20968constructorimpl(getValueForSize(18.0f)), 0.0f, 8, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15858paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w3 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl3, measurePolicyRowMeasurePolicy, composerM18018constructorimpl3, currentCompositionLocalMap3);
            if (composerM18018constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash3, function2M1177w3, composerM18018constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            int i6 = 0;
            Modifier modifierM15409backgroundbw27NRU$default2 = BackgroundKt.m15409backgroundbw27NRU$default(ClipKt.clip(SizeKt.m15885height3ABfNKs(RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), C2256Dp.m20968constructorimpl(getValueForSize(17.0f))), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(getValueForSize(6.0f)))), j2, null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15409backgroundbw27NRU$default2);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w4 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl4, currentCompositionLocalMap4);
            if (composerM18018constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash4, function2M1177w4, composerM18018constructorimpl4, currentCompositeKeyHash4);
            }
            Updater.m18025setimpl(composerM18018constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(getValueForSize(26.0f))), composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, C2256Dp.m20968constructorimpl(getValueForSize(18.0f))), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceGroup(1821411432);
            int i7 = 0;
            while (i7 < i) {
                m22128ListSettingItemViewIv8Zu3U(j2, z2, composerStartRestartGroup, (i5 >> 6) & Event.CAPS_LOCK);
                i7++;
                i6 = i6;
                z2 = z;
            }
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(getValueForSize(24.0f))), composerStartRestartGroup, i6);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceSettingPreview.WidgetListSettingContentLoading_RIQooxk$lambda$42(this.f4553a, i, j, j2, z, i2, (Composer) obj, iIntValue);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: WidgetListSettingContentLoadingSmall-dgg9oW8, reason: not valid java name */
    public final void m22130WidgetListSettingContentLoadingSmalldgg9oW8(final long j, final long j2, final boolean z, @Nullable Composer composer, final int i) {
        int i2;
        long j3;
        boolean z2;
        WidgetListGlanceSettingPreview widgetListGlanceSettingPreview;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1638065065);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            j3 = j2;
            i2 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
        } else {
            j3 = j2;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            widgetListGlanceSettingPreview = this;
            i2 |= composerStartRestartGroup.changedInstance(widgetListGlanceSettingPreview) ? 2048 : 1024;
        } else {
            widgetListGlanceSettingPreview = this;
        }
        if ((i2 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1638065065, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetListSettingContentLoadingSmall (WidgetListGlanceSettingPreview.kt:625)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int i4 = i2;
            Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), j, null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15409backgroundbw27NRU$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion2.getStart(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            widgetListGlanceSettingPreview.m22128ListSettingItemViewIv8Zu3U(j3, z2, composerStartRestartGroup, (i4 >> 3) & Event.CAPS_LOCK);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceSettingPreview.WidgetListSettingContentLoadingSmall_dgg9oW8$lambda$45(this.f4568a, j, j2, z, i, (Composer) obj, iIntValue);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void WidgetListSettingLoading(@NotNull WidgetListGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        ?? r7;
        ?? r02;
        ?? r72;
        ?? r03;
        ?? r04 = this;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        ?? StartRestartGroup = composer.startRestartGroup(-1378232766);
        if ((i & 6) == 0) {
            i2 = (StartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= StartRestartGroup.changedInstance(r04) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && StartRestartGroup.getSkipping()) {
            StartRestartGroup.skipToGroupEnd();
            r72 = StartRestartGroup;
            r03 = r04;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378232766, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.WidgetListSettingLoading (WidgetListGlanceSettingPreview.kt:572)");
            }
            long jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(themeManager.isBlackBackground() ? ColorKt.Color(1711341826) : ColorKt.Color(4294769919L), themeManager.getAlphaBackground(), 0.0f, 0.0f, 0.0f, 14, null);
            long jColor = ColorKt.Color(themeManager.isBlackBackground() ? 352321535 : 335544320);
            if (r04.isMediumOrLarger()) {
                StartRestartGroup.startReplaceGroup(955486824);
                ?? r73 = StartRestartGroup;
                r04.m22129WidgetListSettingContentLoadingRIQooxk(r04.presenter.getMModel().getNoteList().size(), jM18524copywmQWz5c$default, jColor, true, r73, ((i2 << 9) & 57344) | 3072);
                r73.endReplaceGroup();
                r02 = this;
                r7 = r73;
            } else {
                StartRestartGroup.startReplaceGroup(955611041);
                ?? r05 = this;
                r05.m22130WidgetListSettingContentLoadingSmalldgg9oW8(jM18524copywmQWz5c$default, jColor, false, StartRestartGroup, ((i2 << 6) & 7168) | 384);
                ?? r74 = StartRestartGroup;
                r74.endReplaceGroup();
                r02 = r05;
                r7 = r74;
            }
            r03 = r02;
            r72 = r7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                r03 = r02;
                r72 = r7;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = r72.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6951d(r03, themeManager, i, 0));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getShape-nwm-oUQ, reason: not valid java name */
    public final Shape m22131getShapenwmoUQ(int shapeBG, boolean backgrounOnOff, int size) {
        return (AppWidgetSize.m21550equalsimpl0(size, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) && backgrounOnOff) ? shapeBG != 1 ? shapeBG != 2 ? shapeBG != 3 ? shapeBG != 4 ? Shape.None : Shape.RightSpeechBalloon : Shape.LeftSpeechBalloon : Shape.LeftLeaf : Shape.RightLeaf : Shape.None;
    }

    @Composable
    @Nullable
    public final TitleBarData getTitleBarPreview(@NotNull Context context, @NotNull WidgetListGlanceTheme themeManager, @NotNull List<WidgetListGlanceItem> buildItemList, @NotNull String providerName, @Nullable Composer composer, int i) {
        ActionButtonData actionButtonData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(buildItemList, "buildItemList");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        composer.startReplaceGroup(598698372);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(598698372, i, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.getTitleBarPreview (WidgetListGlanceSettingPreview.kt:134)");
        }
        if (buildItemList.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        String string = context.getResources().getString(C11391R.string.app_name_simple);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextData textData = new TextData(string, ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18551getBlack0d7_KjU()), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null);
        if (buildItemList.size() < 10) {
            actionButtonData = new ActionButtonData(Intrinsics.areEqual(providerName, "WidgetListProvider") ? ActionIcon.Add : ActionIcon.MoreOptions, "Add button", null, themeManager.updateListItemTitleColor(), false, false, 52, null);
        } else {
            actionButtonData = null;
        }
        TitleBarData titleBarData = new TitleBarData(textData, null, actionButtonData, null, false, 26, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return titleBarData;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void setContent(long j, @Nullable Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1069406454);
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(j) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1069406454, i2, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.setContent (WidgetListGlanceSettingPreview.kt:67)");
            }
            SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(j), null, 2, null);
            Context context = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            final WidgetListGlanceTheme widgetListGlanceTheme = new WidgetListGlanceTheme(context, this.presenter.getWidgetId(), this.presenter.getMModel().getTransparency(), this.presenter.getMModel().getBackgroundColor(), this.presenter.getMModel().getDarkMode(), this.presenter.getMModel().getMatchSetting(), this.presenter.getMModel().getBackgroundOnOff());
            Context context2 = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            final List<WidgetListGlanceItem> listListItem = ListItem(context2, this.presenter.getWidgetId(), widgetListGlanceTheme, this.presenter.getMModel().getNoteList());
            float f = 20;
            float f4 = 22;
            Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15857paddingqDBjuR0);
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
            int widgetId = this.presenter.getWidgetId();
            ColorProviders colorProvidersUpdateBackground = widgetListGlanceTheme.updateBackground();
            AppWidgetBackground appWidgetBackground = widgetListGlanceTheme.getAppWidgetBackground(this.presenter.getMModel().getNoteList(), m22131getShapenwmoUQ(this.presenter.getMModel().getBackgroundShape(), this.presenter.getMModel().getBackgroundOnOff(), m22127getSizerx25Pp4()), this.presenter.getMModel().getProviderName());
            Context context3 = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            TopLevelLayoutKt.m21789TopLevelLayoutqgZcuA0(widgetId, m22127getSizerx25Pp4(), "Preview", appWidgetBackground, colorProvidersUpdateBackground, getTitleBarPreview(context3, widgetListGlanceTheme, listListItem, this.presenter.getMModel().getProviderName(), composerStartRestartGroup, 57344 & (i2 << 9)), ComposableLambdaKt.rememberComposableLambda(1953969272, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview$setContent$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1953969272, i4, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingPreview.setContent.<anonymous>.<anonymous> (WidgetListGlanceSettingPreview.kt:88)");
                    }
                    if (!this.this$0.presenter.getMModel().getNoteList().isEmpty() && !listListItem.isEmpty()) {
                        composer2.startReplaceGroup(1006906080);
                        this.this$0.ListCustom(widgetListGlanceTheme, listListItem, composer2, 0);
                        composer2.endReplaceGroup();
                    } else if (this.this$0.presenter.getMModel().getNoteList().isEmpty()) {
                        composer2.startReplaceGroup(1007117035);
                        if (Intrinsics.areEqual(this.this$0.presenter.getMModel().getProviderName(), WidgetListExtraLargeCoverProvider.TAG)) {
                            composer2.startReplaceGroup(1007204238);
                            this.this$0.WidgetListExtraLargeCoverEmpty(widgetListGlanceTheme, composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1007300989);
                            this.this$0.WidgetListEmpty(widgetListGlanceTheme, composer2, 0);
                            composer2.endReplaceGroup();
                        }
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1007027228);
                        this.this$0.WidgetListSettingLoading(widgetListGlanceTheme, composer2, 0);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (AppWidgetBackground.$stable << 9) | 1573248 | (ColorProviders.$stable << 12) | (TitleBarData.$stable << 15), 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6953f(this, j, i, 0));
        }
    }
}
