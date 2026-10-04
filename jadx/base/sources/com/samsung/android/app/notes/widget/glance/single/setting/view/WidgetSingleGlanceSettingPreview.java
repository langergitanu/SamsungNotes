package com.samsung.android.app.notes.widget.glance.single.setting.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.BlurKt;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.text.PlatformTextStyle;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.LineHeightStyle;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.text.style.TextMotion;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.color.ColorProviders;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ActionButtonData;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.WelcomePageData;
import androidx.glance.oneui.template.WelcomePageTemplateKt;
import androidx.glance.oneui.template.layout.TopLevelLayoutKt;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.glance.common.WidgetGlanceUtils;
import com.samsung.android.app.notes.widget.glance.single.C6993b;
import com.samsung.android.app.notes.widget.glance.single.common.WidgetSingleGlanceUtils;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.glance.single.theme.WidgetSingleGlanceTheme;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u0019H\u0002J\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\rH\u0007¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001eJ\u000f\u0010#\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020(J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020/H\u0002J\u0017\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0007¢\u0006\u0004\b6\u00107R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingPreview;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingPresenter;", "<init>", "(Landroid/view/View;Lcom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingPresenter;)V", "setContent", "", "requestTime", "", "typeWidgetView", "", "(JLjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "getTitleBarPreview", "Landroidx/glance/oneui/template/TitleBarData;", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/TitleBarData;", "ContentWidget", "themeManager", "Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;", "widgetUtils", "Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils;", "(Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Lcom/samsung/android/app/notes/widget/glance/single/common/WidgetSingleGlanceUtils;Landroidx/compose/runtime/Composer;I)V", "getImageBitmap", "", "Landroidx/compose/ui/graphics/ImageBitmap;", "bitmaps", "Landroid/graphics/Bitmap;", "ViewMore", "(Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "TextContentWidgetTemplate", "textContent", "(Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "WidgetEmpty", "getSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getSize-rx25Pp4", "()I", "isMediumOrLarger", "", "getShape", "Landroidx/glance/oneui/template/Shape;", "shapeBG", "", "backgroundOnOff", "getValueForSize", "", "value", "getValueForSizeForPreview", "dpToSp", "Landroidx/compose/ui/unit/TextUnit;", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "dpToSp-ybKWxLE", "(FLandroidx/compose/runtime/Composer;I)J", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSingleGlanceSettingPreview.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlanceSettingPreview.kt\ncom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingPreview\n+ 2 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 8 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,409:1\n71#2:410\n69#2,5:411\n74#2:444\n71#2:448\n68#2,6:449\n74#2:483\n71#2:484\n67#2,7:485\n74#2:520\n78#2:524\n78#2:528\n78#2:532\n71#2:624\n69#2,5:625\n74#2:658\n71#2:661\n69#2,5:662\n74#2:695\n78#2:701\n78#2:705\n71#2:707\n69#2,5:708\n74#2:741\n78#2:747\n71#2:748\n68#2,6:749\n74#2:783\n78#2:787\n79#3,6:416\n86#3,4:431\n90#3,2:441\n79#3,6:455\n86#3,4:470\n90#3,2:480\n79#3,6:492\n86#3,4:507\n90#3,2:517\n94#3:523\n94#3:527\n94#3:531\n79#3,6:547\n86#3,4:562\n90#3,2:572\n79#3,6:584\n86#3,4:599\n90#3,2:609\n94#3:618\n94#3:622\n79#3,6:630\n86#3,4:645\n90#3,2:655\n79#3,6:667\n86#3,4:682\n90#3,2:692\n94#3:700\n94#3:704\n79#3,6:713\n86#3,4:728\n90#3,2:738\n94#3:746\n79#3,6:755\n86#3,4:770\n90#3,2:780\n94#3:786\n368#4,9:422\n377#4:443\n368#4,9:461\n377#4:482\n368#4,9:498\n377#4:519\n378#4,2:521\n378#4,2:525\n378#4,2:529\n368#4,9:553\n377#4:574\n368#4,9:590\n377#4:611\n378#4,2:616\n378#4,2:620\n368#4,9:636\n377#4:657\n368#4,9:673\n377#4:694\n378#4,2:698\n378#4,2:702\n368#4,9:719\n377#4:740\n378#4,2:744\n368#4,9:761\n377#4:782\n378#4,2:784\n4034#5,6:435\n4034#5,6:474\n4034#5,6:511\n4034#5,6:566\n4034#5,6:603\n4034#5,6:649\n4034#5,6:686\n4034#5,6:732\n4034#5,6:774\n149#6:445\n149#6:446\n149#6:447\n169#6:533\n169#6:534\n149#6:535\n169#6:536\n169#6:537\n169#6:538\n169#6:539\n169#6:613\n169#6:614\n169#6:615\n169#6:659\n169#6:660\n169#6:696\n169#6:697\n169#6:706\n169#6:742\n86#7:540\n83#7,6:541\n89#7:575\n86#7:576\n82#7,7:577\n89#7:612\n93#7:619\n93#7:623\n77#8:743\n77#8:788\n1#9:789\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlanceSettingPreview.kt\ncom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingPreview\n*L\n89#1:410\n89#1:411,5\n89#1:444\n110#1:448\n110#1:449,6\n110#1:483\n115#1:484\n115#1:485,7\n115#1:520\n115#1:524\n110#1:528\n89#1:532\n251#1:624\n251#1:625,5\n251#1:658\n257#1:661\n257#1:662,5\n257#1:695\n257#1:701\n251#1:705\n296#1:707\n296#1:708,5\n296#1:741\n296#1:747\n320#1:748\n320#1:749,6\n320#1:783\n320#1:787\n89#1:416,6\n89#1:431,4\n89#1:441,2\n110#1:455,6\n110#1:470,4\n110#1:480,2\n115#1:492,6\n115#1:507,4\n115#1:517,2\n115#1:523\n110#1:527\n89#1:531\n172#1:547,6\n172#1:562,4\n172#1:572,2\n203#1:584,6\n203#1:599,4\n203#1:609,2\n203#1:618\n172#1:622\n251#1:630,6\n251#1:645,4\n251#1:655,2\n257#1:667,6\n257#1:682,4\n257#1:692,2\n257#1:700\n251#1:704\n296#1:713,6\n296#1:728,4\n296#1:738,2\n296#1:746\n320#1:755,6\n320#1:770,4\n320#1:780,2\n320#1:786\n89#1:422,9\n89#1:443\n110#1:461,9\n110#1:482\n115#1:498,9\n115#1:519\n115#1:521,2\n110#1:525,2\n89#1:529,2\n172#1:553,9\n172#1:574\n203#1:590,9\n203#1:611\n203#1:616,2\n172#1:620,2\n251#1:636,9\n251#1:657\n257#1:673,9\n257#1:694\n257#1:698,2\n251#1:702,2\n296#1:719,9\n296#1:740\n296#1:744,2\n320#1:761,9\n320#1:782\n320#1:784,2\n89#1:435,6\n110#1:474,6\n115#1:511,6\n172#1:566,6\n203#1:603,6\n251#1:649,6\n257#1:686,6\n296#1:732,6\n320#1:774,6\n104#1:445\n105#1:446\n113#1:447\n177#1:533\n179#1:534\n181#1:535\n184#1:536\n186#1:537\n188#1:538\n189#1:539\n207#1:613\n213#1:614\n218#1:615\n262#1:659\n264#1:660\n272#1:696\n273#1:697\n299#1:706\n305#1:742\n172#1:540\n172#1:541,6\n172#1:575\n203#1:576\n203#1:577,7\n203#1:612\n203#1:619\n172#1:623\n310#1:743\n408#1:788\n*E\n"})
public final class WidgetSingleGlanceSettingPreview {
    public static final int $stable = 8;

    @NotNull
    private final View parent;

    @NotNull
    private final WidgetSingleGlanceSettingPresenter presenter;

    public WidgetSingleGlanceSettingPreview(@NotNull View parent, @NotNull WidgetSingleGlanceSettingPresenter presenter) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.parent = parent;
        this.presenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWidget$lambda$4(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, WidgetSingleGlanceUtils widgetSingleGlanceUtils, int i, Composer composer, int i2) {
        widgetSingleGlanceSettingPreview.ContentWidget(widgetSingleGlanceTheme, widgetSingleGlanceUtils, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWidget$lambda$7(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, WidgetSingleGlanceUtils widgetSingleGlanceUtils, int i, Composer composer, int i2) {
        widgetSingleGlanceSettingPreview.ContentWidget(widgetSingleGlanceTheme, widgetSingleGlanceUtils, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextContentWidgetTemplate$lambda$12(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i, Composer composer, int i2) {
        widgetSingleGlanceSettingPreview.TextContentWidgetTemplate(widgetSingleGlanceTheme, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewMore$lambda$10(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, int i, Composer composer, int i2) {
        widgetSingleGlanceSettingPreview.ViewMore(widgetSingleGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WidgetEmpty$lambda$14(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, WidgetSingleGlanceTheme widgetSingleGlanceTheme, int i, Composer composer, int i2) {
        widgetSingleGlanceSettingPreview.WidgetEmpty(widgetSingleGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private final List<ImageBitmap> getImageBitmap(List<Bitmap> bitmaps) {
        ArrayList arrayList = new ArrayList();
        if (bitmaps == null) {
            bitmaps = new ArrayList<>();
        }
        for (Bitmap bitmap : bitmaps) {
            if (bitmap != null) {
                arrayList.add(AndroidImageBitmap_androidKt.asImageBitmap(bitmap));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getSize-rx25Pp4, reason: not valid java name */
    private final int m22144getSizerx25Pp4() {
        int column = this.presenter.getMModel().getColumn();
        int row = this.presenter.getMModel().getRow();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        Context context = this.parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.m21564getKiq_Kzg(context, column, row);
    }

    private final float getValueForSize(float value) {
        double d;
        double d2;
        if (this.presenter.getMModel().getColumn() <= 2) {
            return value;
        }
        if (this.presenter.getMModel().getRow() <= 4) {
            d = value;
            d2 = 0.8d;
        } else {
            d = value;
            d2 = 0.6d;
        }
        return (float) (d * d2);
    }

    private final float getValueForSizeForPreview() {
        if (this.presenter.getMModel().getColumn() <= 2) {
            return 7.0f;
        }
        return this.presenter.getMModel().getRow() <= 4 ? 9.6f : 7.2f;
    }

    private final boolean isMediumOrLarger() {
        int iM22144getSizerx25Pp4 = m22144getSizerx25Pp4();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(iM22144getSizerx25Pp4, companion.m21572getUnknownrx25Pp4()) || AppWidgetSize.m21546compareToL2j3NV4(m22144getSizerx25Pp4(), companion.m21569getMediumrx25Pp4()) < 0) {
            return this.presenter.getMModel().getColumn() >= 2 && this.presenter.getMModel().getRow() >= 2;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setContent$lambda$3(WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview, long j, String str, int i, Composer composer, int i2) {
        widgetSingleGlanceSettingPreview.setContent(j, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void ContentWidget(@NotNull final WidgetSingleGlanceTheme themeManager, @NotNull final WidgetSingleGlanceUtils widgetUtils, @Nullable Composer composer, final int i) {
        int i2;
        float fM20968constructorimpl;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(widgetUtils, "widgetUtils");
        Composer composerStartRestartGroup = composer.startRestartGroup(-43390422);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(widgetUtils) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43390422, i2, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.ContentWidget (WidgetSingleGlanceSettingPreview.kt:157)");
            }
            List<Bitmap> listCreateContent = widgetUtils.createContent(themeManager.isPageDark());
            composerStartRestartGroup.startReplaceGroup(1251484008);
            List<Bitmap> list = listCreateContent;
            if (list == null || list.isEmpty()) {
                int i4 = i2;
                String string = this.parent.getContext().getResources().getString(C11391R.string.widget_text_loading);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                TextContentWidgetTemplate(themeManager, string, composerStartRestartGroup, i4 & SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i5 = 0;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2(this) { // from class: com.samsung.android.app.notes.widget.glance.single.setting.view.a

                        /* JADX INFO: renamed from: b */
                        public final /* synthetic */ WidgetSingleGlanceSettingPreview f4701b;

                        {
                            this.f4701b = this;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            switch (i5) {
                                case 0:
                                    int iIntValue = ((Integer) obj2).intValue();
                                    return WidgetSingleGlanceSettingPreview.ContentWidget$lambda$4(this.f4701b, themeManager, widgetUtils, i, (Composer) obj, iIntValue);
                                default:
                                    int iIntValue2 = ((Integer) obj2).intValue();
                                    return WidgetSingleGlanceSettingPreview.ContentWidget$lambda$7(this.f4701b, themeManager, widgetUtils, i, (Composer) obj, iIntValue2);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            composerStartRestartGroup.endReplaceGroup();
            List<ImageBitmap> imageBitmap = getImageBitmap(listCreateContent);
            long jColor = ColorKt.Color(themeManager.isWhiteTextColor() ? 4292730333L : 4282400832L);
            float valueForSize = getValueForSize(14.0f);
            float valueForSize2 = getValueForSize(7.0f);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            int iM22144getSizerx25Pp4 = m22144getSizerx25Pp4();
            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21546compareToL2j3NV4(iM22144getSizerx25Pp4, companion2.m21570getSmallrx25Pp4()) <= 0) {
                fM20968constructorimpl = C2256Dp.m20968constructorimpl(valueForSize2);
            } else {
                String title = this.presenter.getTitle();
                fM20968constructorimpl = (title == null || title.length() == 0) ? C2256Dp.m20968constructorimpl(valueForSize) : C2256Dp.m20968constructorimpl(0);
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m15857paddingqDBjuR0(modifierFillMaxSize$default, C2256Dp.m20968constructorimpl(valueForSize), fM20968constructorimpl, C2256Dp.m20968constructorimpl(valueForSize), AppWidgetSize.m21546compareToL2j3NV4(m22144getSizerx25Pp4(), companion2.m21570getSmallrx25Pp4()) <= 0 ? C2256Dp.m20968constructorimpl(valueForSize2) : C2256Dp.m20968constructorimpl(valueForSize)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
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
            Function2 function2M1177w = AbstractC0622a.m1177w(companion4, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ImageBitmap imageBitmap2 = imageBitmap.get(0);
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
            ContentScale.Companion companion5 = ContentScale.INSTANCE;
            int i6 = i2;
            ImageKt.m15465Image5hnEew(imageBitmap2, "image content description", modifierWrapContentHeight$default, null, companion5.getFillWidth(), 0.0f, null, 0, composerStartRestartGroup, 25008, JPEG.APP8);
            composerStartRestartGroup.startReplaceGroup(34672690);
            if (imageBitmap.size() > 1) {
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composerStartRestartGroup, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
                Function2 function2M1177w2 = AbstractC0622a.m1177w(companion4, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy2, composerM18018constructorimpl2, currentCompositionLocalMap2);
                if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                }
                Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                SpacerKt.Spacer(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(1.0f))), jColor, null, 2, null), composerStartRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(5.0f))), composerStartRestartGroup, 0);
                SpacerKt.Spacer(BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(1.0f))), jColor, null, 2, null), composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ImageKt.m15465Image5hnEew(imageBitmap.get(1), "image content description", SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null), null, companion5.getFillWidth(), 0.0f, null, 0, composerStartRestartGroup, 25008, JPEG.APP8);
                if (widgetUtils.getViewMore()) {
                    ViewMore(themeManager, composerStartRestartGroup, (i6 & 14) | ((i6 >> 3) & 112));
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final int i7 = 1;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2(this) { // from class: com.samsung.android.app.notes.widget.glance.single.setting.view.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ WidgetSingleGlanceSettingPreview f4701b;

                {
                    this.f4701b = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    switch (i7) {
                        case 0:
                            int iIntValue = ((Integer) obj2).intValue();
                            return WidgetSingleGlanceSettingPreview.ContentWidget$lambda$4(this.f4701b, themeManager, widgetUtils, i, (Composer) obj, iIntValue);
                        default:
                            int iIntValue2 = ((Integer) obj2).intValue();
                            return WidgetSingleGlanceSettingPreview.ContentWidget$lambda$7(this.f4701b, themeManager, widgetUtils, i, (Composer) obj, iIntValue2);
                    }
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void TextContentWidgetTemplate(@NotNull WidgetSingleGlanceTheme themeManager, @NotNull String textContent, @Nullable Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-565794657);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textContent) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-565794657, i2, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.TextContentWidgetTemplate (WidgetSingleGlanceSettingPreview.kt:288)");
            }
            long jM18524copywmQWz5c$default = themeManager.isBlackBackground() ? Color.m18524copywmQWz5c$default(ColorKt.Color(4294967295L), 0.4f, 0.0f, 0.0f, 0.0f, 14, null) : Color.m18524copywmQWz5c$default(ColorKt.Color(1711276032), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
            Modifier modifierM15854padding3ABfNKs = PaddingKt.m15854padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(getValueForSize(14.0f)));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15854padding3ABfNKs);
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
            int i4 = i2 >> 3;
            composer2 = composerStartRestartGroup;
            TextKt.m17400TextfLXpl1I(textContent, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4()) ? 1 : 3, null, new TextStyle(jM18524copywmQWz5c$default, m22145dpToSpybKWxLE(C2256Dp.m20968constructorimpl(getValueForSize(12.0f)), composerStartRestartGroup, i4 & 112), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.INSTANCE.m20862getStarte0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744440, (DefaultConstructorMarker) null), composer2, i4 & 14, 0, 24574);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C6993b(this, themeManager, textContent, i));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void ViewMore(@NotNull WidgetSingleGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        Composer composer2;
        int i4;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(958825430);
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
            composer2 = composerStartRestartGroup;
            i4 = 1;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(958825430, i2, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.ViewMore (WidgetSingleGlanceSettingPreview.kt:249)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getBottomCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentHeight$default);
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
            Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m15858paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.wrapContentWidth$default(companion, null, false, 3, null), null, false, 3, null), 0.0f, C2256Dp.m20968constructorimpl(getValueForSize(4.0f)), 0.0f, 0.0f, 13, null), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(getValueForSize(18.0f)))), themeManager.m22147updateViewMoreBackgroundColor0d7_KjU(), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
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
            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl2, currentCompositionLocalMap2);
            if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            Modifier modifierM15855paddingVpY3zN4 = PaddingKt.m15855paddingVpY3zN4(SizeKt.wrapContentSize$default(companion, null, false, 3, null), C2256Dp.m20968constructorimpl(getValueForSize(6.0f)), C2256Dp.m20968constructorimpl(getValueForSize(6.0f)));
            String string = this.parent.getContext().getString(C11391R.string.to_view_more);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            composer2 = composerStartRestartGroup;
            i4 = 1;
            TextKt.m17400TextfLXpl1I(string, modifierM15855paddingVpY3zN4, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, null, new TextStyle(themeManager.m22146updateTitleTextColor0d7_KjU(), TextUnitKt.getSp(getValueForSizeForPreview()), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.INSTANCE.m20857getCentere0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744440, (DefaultConstructorMarker) null), composer2, 0, 3072, 24572);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C7001b(this, themeManager, i, i4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void WidgetEmpty(@NotNull WidgetSingleGlanceTheme themeManager, @Nullable Composer composer, int i) {
        int i2;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(1802870403);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(themeManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        int i6 = 0;
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1802870403, i2, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.WidgetEmpty (WidgetSingleGlanceSettingPreview.kt:318)");
            }
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default);
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
            boolean z = false;
            boolean z2 = false;
            ImageButtonData imageButtonData = new ImageButtonData(androidx.glance.ImageKt.ImageProvider(C11391R.drawable.ic_induce_app_icon), null, null, null, C11391R.drawable.container_new, null, null, null, z, z2, 1006, null);
            TextData textData = new TextData(WidgetGlanceUtils.INSTANCE.m22122getWelcomePageTitleL2j3NV4(m22144getSizerx25Pp4()), themeManager.updateWelcomePageTextColor(), 0, (androidx.glance.text.TextDecoration) null, 0, (androidx.glance.text.FontFamily) (0 == true ? 1 : 0), 0, z, z2, (TextShadowStyle) null, (String) (0 == true ? 1 : 0), (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null);
            TextData textData2 = isMediumOrLarger() ? new TextData(C11391R.string.tap_to_choose_a_note, themeManager.updateWelcomePageTextColor(), 0, (androidx.glance.text.TextDecoration) null, 0, (androidx.glance.text.FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32764, (DefaultConstructorMarker) null) : null;
            int iM22144getSizerx25Pp4 = m22144getSizerx25Pp4();
            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21546compareToL2j3NV4(iM22144getSizerx25Pp4, companion2.m21568getLargerx25Pp4()) >= 0) {
                i5 = ContextUtils.isNightMode(this.parent.getContext()) ? C11391R.drawable.notes_fg_graphic_large_dark : C11391R.drawable.notes_fg_graphic_large;
            } else if (AppWidgetSize.m21550equalsimpl0(m22144getSizerx25Pp4(), companion2.m21569getMediumrx25Pp4())) {
                i5 = ContextUtils.isNightMode(this.parent.getContext()) ? C11391R.drawable.notes_fg_graphic_medium_dark : C11391R.drawable.notes_fg_graphic_medium;
            } else {
                i4 = 0;
                WelcomePageTemplateKt.WelcomePageTemplate(new WelcomePageData(imageButtonData, textData, textData2, 0, i4, 8, null), composerStartRestartGroup, WelcomePageData.$stable);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i4 = i5;
            WelcomePageTemplateKt.WelcomePageTemplate(new WelcomePageData(imageButtonData, textData, textData2, 0, i4, 8, null), composerStartRestartGroup, WelcomePageData.$stable);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C7001b(this, themeManager, i, i6));
        }
    }

    @Composable
    /* JADX INFO: renamed from: dpToSp-ybKWxLE, reason: not valid java name */
    public final long m22145dpToSpybKWxLE(float f, @Nullable Composer composer, int i) {
        composer.startReplaceGroup(-948613558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-948613558, i, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.dpToSp (WidgetSingleGlanceSettingPreview.kt:407)");
        }
        long jMo15548toSp0xMU5do = ((Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity())).mo15548toSp0xMU5do(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return jMo15548toSp0xMU5do;
    }

    @NotNull
    public final Shape getShape(int shapeBG, boolean backgroundOnOff) {
        return (isMediumOrLarger() && backgroundOnOff) ? shapeBG != 1 ? shapeBG != 2 ? shapeBG != 3 ? shapeBG != 4 ? Shape.None : Shape.RightSpeechBalloon : Shape.LeftSpeechBalloon : Shape.LeftLeaf : Shape.RightLeaf : Shape.None;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Composable
    @Nullable
    public final TitleBarData getTitleBarPreview(@Nullable Composer composer, int i) {
        composer.startReplaceGroup(-544487715);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-544487715, i, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.getTitleBarPreview (WidgetSingleGlanceSettingPreview.kt:147)");
        }
        String title = this.presenter.getTitle();
        if (title == null || title.length() == 0) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        String recommendTitle = this.presenter.getRecommendTitle();
        Intrinsics.checkNotNull(recommendTitle);
        TextData textData = null;
        ActionButtonData actionButtonData = null;
        boolean z = false;
        Object[] objArr = 0 == true ? 1 : 0;
        TitleBarData titleBarData = new TitleBarData(new TextData(recommendTitle, (ColorProvider) null, 0, (androidx.glance.text.TextDecoration) null, 0, (androidx.glance.text.FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null), textData, objArr, actionButtonData, z, 30, 0 == true ? 1 : 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return titleBarData;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x038c  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setContent(final long j, @NotNull final String typeWidgetView, @Nullable Composer composer, final int i) {
        int i2;
        int i4;
        String str;
        String str2;
        final WidgetSingleGlanceTheme widgetSingleGlanceTheme;
        ComposeUiNode.Companion companion;
        Alignment alignment;
        Composer composer2;
        ?? r2;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        int currentCompositeKeyHash2;
        Composer composerM18018constructorimpl2;
        Function2 function2M1177w2;
        Composer composer3;
        Intrinsics.checkNotNullParameter(typeWidgetView, "typeWidgetView");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1401279423);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(typeWidgetView) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer3 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401279423, i2, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.setContent (WidgetSingleGlanceSettingPreview.kt:64)");
            }
            SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(j), null, 2, null);
            final MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(typeWidgetView, null, 2, null);
            Context context = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            WidgetSingleGlanceTheme widgetSingleGlanceTheme2 = new WidgetSingleGlanceTheme(context, this.presenter.getWidgetId(), String.valueOf(this.presenter.getMModel().getUUID()), this.presenter.getMModel().getTransparency(), this.presenter.getMModel().getBackgroundColor(), this.presenter.getMModel().getDarkMode(), this.presenter.getMModel().getMatchSetting(), this.presenter.getMModel().getBackgroundOnOff(), (String) mutableStateMutableStateOf$default.getValue(), this.presenter.getMModel().getProviderName());
            Context context2 = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            final WidgetSingleGlanceUtils widgetSingleGlanceUtils = new WidgetSingleGlanceUtils(context2, this.presenter.getWidgetId(), String.valueOf(this.presenter.getMModel().getUUID()), this.presenter.getMModel().getProviderName());
            String string = this.parent.getContext().getResources().getString(C11391R.string.widget_text_loading);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = this.parent.getContext().getResources().getString(C11391R.string.widget_convert_document);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w3 = AbstractC0622a.m1177w(companion4, composerM18018constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl3, currentCompositionLocalMap);
            if (composerM18018constructorimpl3.getInserting()) {
                i4 = i2;
            } else {
                i4 = i2;
                if (!Intrinsics.areEqual(composerM18018constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                }
                Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                String providerName = this.presenter.getMModel().getProviderName();
                composerStartRestartGroup.startReplaceGroup(1311593425);
                if (Build.VERSION.SDK_INT >= 28 || !(Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) || Intrinsics.areEqual(providerName, "WidgetSingleLargeCoverProvider"))) {
                    str = string;
                    str2 = string2;
                    widgetSingleGlanceTheme = widgetSingleGlanceTheme2;
                    companion = companion4;
                    alignment = null;
                    composer2 = composerStartRestartGroup;
                    r2 = 0;
                } else {
                    Bitmap wallpaperBitmap = this.presenter.getWallpaperBitmap(this.parent.getContext());
                    ImageBitmap imageBitmapAsImageBitmap = wallpaperBitmap != null ? AndroidImageBitmap_androidKt.asImageBitmap(wallpaperBitmap) : null;
                    Intrinsics.checkNotNull(imageBitmapAsImageBitmap, "null cannot be cast to non-null type androidx.compose.ui.graphics.ImageBitmap");
                    str2 = string2;
                    widgetSingleGlanceTheme = widgetSingleGlanceTheme2;
                    r2 = 0;
                    str = string;
                    alignment = null;
                    companion = companion4;
                    ImageKt.m15465Image5hnEew(imageBitmapAsImageBitmap, "sd", BlurKt.m18162blurF8QBwvs$default(ClipKt.clip(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(24))), C2256Dp.m20968constructorimpl(10), null, 2, null), null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composerStartRestartGroup, 24624, JPEG.APP8);
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceGroup();
                float f = 20;
                float f4 = 22;
                Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(SizeKt.wrapContentSize$default(companion2, alignment, r2, 3, alignment), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), r2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, r2);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM15857paddingqDBjuR0);
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.useNode();
                } else {
                    composer2.createNode(constructor2);
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
                if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                }
                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion.getSetModifier());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), r2);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, r2);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion2);
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.useNode();
                } else {
                    composer2.createNode(constructor3);
                }
                composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                function2M1177w2 = AbstractC0622a.m1177w(companion, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM18018constructorimpl2, currentCompositionLocalMap3);
                if (!composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                }
                Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier3, companion.getSetModifier());
                final String str3 = str2;
                final String str4 = str;
                composer3 = composer2;
                TopLevelLayoutKt.m21789TopLevelLayoutqgZcuA0(this.presenter.getWidgetId(), m22144getSizerx25Pp4(), "Preview", widgetSingleGlanceTheme.getAppWidgetBackground(getShape(this.presenter.getMModel().getBackgroundShape(), this.presenter.getMModel().getBackgroundOnOff())), widgetSingleGlanceTheme.updateBackground(this.presenter.getOneUiWidgetSource()), getTitleBarPreview(composer2, (i4 >> 6) & 14), ComposableLambdaKt.rememberComposableLambda(1393699615, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview$setContent$1$1$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(Composer composer4, int i5) {
                        if ((i5 & 3) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1393699615, i5, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.setContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlanceSettingPreview.kt:123)");
                        }
                        String value = mutableStateMutableStateOf$default.getValue();
                        int iHashCode = value.hashCode();
                        if (iHashCode != -1792757780) {
                            if (iHashCode != -1203338670) {
                                if (iHashCode == 885763291 && value.equals(WidgetConstant.LOADING_VIEW)) {
                                    composer4.startReplaceGroup(256497711);
                                    this.TextContentWidgetTemplate(widgetSingleGlanceTheme, str4, composer4, 0);
                                    composer4.endReplaceGroup();
                                } else {
                                    composer4.startReplaceGroup(256972507);
                                    this.ContentWidget(widgetSingleGlanceTheme, widgetSingleGlanceUtils, composer4, 0);
                                    composer4.endReplaceGroup();
                                }
                            } else if (value.equals(WidgetConstant.CONVERT_VIEW)) {
                                composer4.startReplaceGroup(256820111);
                                this.TextContentWidgetTemplate(widgetSingleGlanceTheme, str3, composer4, 0);
                                composer4.endReplaceGroup();
                            }
                        } else if (value.equals(WidgetConstant.EMPTY_VIEW)) {
                            composer4.startReplaceGroup(256670474);
                            this.WidgetEmpty(widgetSingleGlanceTheme, composer4, 0);
                            composer4.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer3, (AppWidgetBackground.$stable << 9) | 1573248 | (ColorProviders.$stable << 12) | (TitleBarData.$stable << 15), 0);
                composer3.endNode();
                composer3.endNode();
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            AbstractC0622a.m1178x(currentCompositeKeyHash3, function2M1177w3, composerM18018constructorimpl3, currentCompositeKeyHash3);
            Updater.m18025setimpl(composerM18018constructorimpl3, modifierMaterializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            String providerName2 = this.presenter.getMModel().getProviderName();
            composerStartRestartGroup.startReplaceGroup(1311593425);
            if (Build.VERSION.SDK_INT >= 28) {
                str = string;
                str2 = string2;
                widgetSingleGlanceTheme = widgetSingleGlanceTheme2;
                companion = companion4;
                alignment = null;
                composer2 = composerStartRestartGroup;
                r2 = 0;
                composer2.endReplaceGroup();
                float f5 = 20;
                float f42 = 22;
                Modifier modifierM15857paddingqDBjuR02 = PaddingKt.m15857paddingqDBjuR0(SizeKt.wrapContentSize$default(companion2, alignment, r2, 3, alignment), C2256Dp.m20968constructorimpl(f42), C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f42), C2256Dp.m20968constructorimpl(f5));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), r2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, r2);
                CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer2, modifierM15857paddingqDBjuR02);
                Function0<ComposeUiNode> constructor22 = companion.getConstructor();
                if (composer2.getApplier() == null) {
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy22, composerM18018constructorimpl, currentCompositionLocalMap22);
                if (!composerM18018constructorimpl.getInserting()) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier22, companion.getSetModifier());
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy32 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), r2);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, r2);
                    CompositionLocalMap currentCompositionLocalMap32 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier32 = ComposedModifierKt.materializeModifier(composer2, companion2);
                    Function0<ComposeUiNode> constructor32 = companion.getConstructor();
                    if (composer2.getApplier() == null) {
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                    }
                    composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                    function2M1177w2 = AbstractC0622a.m1177w(companion, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy32, composerM18018constructorimpl2, currentCompositionLocalMap32);
                    if (!composerM18018constructorimpl2.getInserting()) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                        Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier32, companion.getSetModifier());
                        final String str32 = str2;
                        final String str42 = str;
                        composer3 = composer2;
                        TopLevelLayoutKt.m21789TopLevelLayoutqgZcuA0(this.presenter.getWidgetId(), m22144getSizerx25Pp4(), "Preview", widgetSingleGlanceTheme.getAppWidgetBackground(getShape(this.presenter.getMModel().getBackgroundShape(), this.presenter.getMModel().getBackgroundOnOff())), widgetSingleGlanceTheme.updateBackground(this.presenter.getOneUiWidgetSource()), getTitleBarPreview(composer2, (i4 >> 6) & 14), ComposableLambdaKt.rememberComposableLambda(1393699615, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview$setContent$1$1$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke(Composer composer4, int i5) {
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1393699615, i5, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingPreview.setContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WidgetSingleGlanceSettingPreview.kt:123)");
                                }
                                String value = mutableStateMutableStateOf$default.getValue();
                                int iHashCode = value.hashCode();
                                if (iHashCode != -1792757780) {
                                    if (iHashCode != -1203338670) {
                                        if (iHashCode == 885763291 && value.equals(WidgetConstant.LOADING_VIEW)) {
                                            composer4.startReplaceGroup(256497711);
                                            this.TextContentWidgetTemplate(widgetSingleGlanceTheme, str42, composer4, 0);
                                            composer4.endReplaceGroup();
                                        } else {
                                            composer4.startReplaceGroup(256972507);
                                            this.ContentWidget(widgetSingleGlanceTheme, widgetSingleGlanceUtils, composer4, 0);
                                            composer4.endReplaceGroup();
                                        }
                                    } else if (value.equals(WidgetConstant.CONVERT_VIEW)) {
                                        composer4.startReplaceGroup(256820111);
                                        this.TextContentWidgetTemplate(widgetSingleGlanceTheme, str32, composer4, 0);
                                        composer4.endReplaceGroup();
                                    }
                                } else if (value.equals(WidgetConstant.EMPTY_VIEW)) {
                                    composer4.startReplaceGroup(256670474);
                                    this.WidgetEmpty(widgetSingleGlanceTheme, composer4, 0);
                                    composer4.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer3, (AppWidgetBackground.$stable << 9) | 1573248 | (ColorProviders.$stable << 12) | (TitleBarData.$stable << 15), 0);
                        composer3.endNode();
                        composer3.endNode();
                        composer3.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.single.setting.view.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetSingleGlanceSettingPreview.setContent$lambda$3(this.f4709a, j, typeWidgetView, i, (Composer) obj, iIntValue);
                }
            });
        }
    }
}
