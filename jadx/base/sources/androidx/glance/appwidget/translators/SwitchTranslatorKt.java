package androidx.glance.appwidget.translators;

import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.C2902R;
import androidx.glance.appwidget.EmittableSwitch;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.UtilsKt;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, m13886d2 = {"translateEmittableSwitch", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "Landroidx/glance/appwidget/EmittableSwitch;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSwitchTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SwitchTranslator.kt\nandroidx/glance/appwidget/translators/SwitchTranslatorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class SwitchTranslatorKt {
    public static final void translateEmittableSwitch(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableSwitch element) {
        int mainViewId;
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        int i = Build.VERSION.SDK_INT;
        LayoutType layoutType = i >= 31 ? LayoutType.Swtch : LayoutType.SwtchBackport;
        Context context = translationContext.getContext();
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, layoutType, element.getModifier());
        if (i >= 31) {
            mainViewId = insertedViewInfoInsertView.getMainViewId();
            CompoundButtonApi31Impl.INSTANCE.setCompoundButtonChecked(remoteViews, insertedViewInfoInsertView.getMainViewId(), element.getChecked());
            CheckableColorProvider thumb$glance_appwidget_release = element.getColors().getThumb$glance_appwidget_release();
            if (thumb$glance_appwidget_release instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateList = CompoundButtonTranslatorKt.toDayNightColorStateList((CheckedUncheckedColorProvider) thumb$glance_appwidget_release, context);
                RemoteViewsCompat.setSwitchThumbTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), dayNightColorStateList.getDay(), dayNightColorStateList.getNight());
            } else {
                if (!(thumb$glance_appwidget_release instanceof ResourceCheckableColorProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                RemoteViewsCompat.setSwitchThumbTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ((ResourceCheckableColorProvider) thumb$glance_appwidget_release).getResId());
            }
            Unit unit = Unit.INSTANCE;
            CheckableColorProvider track$glance_appwidget_release = element.getColors().getTrack$glance_appwidget_release();
            if (track$glance_appwidget_release instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateList2 = CompoundButtonTranslatorKt.toDayNightColorStateList((CheckedUncheckedColorProvider) track$glance_appwidget_release, context);
                RemoteViewsCompat.setSwitchTrackTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), dayNightColorStateList2.getDay(), dayNightColorStateList2.getNight());
            } else {
                if (!(track$glance_appwidget_release instanceof ResourceCheckableColorProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                RemoteViewsCompat.setSwitchTrackTintList(remoteViews, insertedViewInfoInsertView.getMainViewId(), ((ResourceCheckableColorProvider) track$glance_appwidget_release).getResId());
            }
        } else {
            int iInflateViewStub$default = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.switchText, 0, null, 12, null);
            int iInflateViewStub$default2 = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.switchThumb, 0, null, 12, null);
            int iInflateViewStub$default3 = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.switchTrack, 0, null, 12, null);
            UtilsKt.setViewEnabled(remoteViews, iInflateViewStub$default2, element.getChecked());
            UtilsKt.setViewEnabled(remoteViews, iInflateViewStub$default3, element.getChecked());
            CompoundButtonTranslatorKt.m21398setImageViewColorFiltermxwnekA(remoteViews, iInflateViewStub$default2, CompoundButtonTranslatorKt.getColor(element.getColors().getThumb$glance_appwidget_release(), context, element.getChecked()));
            CompoundButtonTranslatorKt.m21398setImageViewColorFiltermxwnekA(remoteViews, iInflateViewStub$default3, CompoundButtonTranslatorKt.getColor(element.getColors().getTrack$glance_appwidget_release(), context, element.getChecked()));
            mainViewId = iInflateViewStub$default;
        }
        TextTranslatorKt.setText$default(remoteViews, translationContext, mainViewId, element.getText(), element.getStyle(), element.getMaxLines(), 16, 0.0f, 0, 192, null);
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, element.getModifier(), insertedViewInfoInsertView, null, 16, null);
    }
}
