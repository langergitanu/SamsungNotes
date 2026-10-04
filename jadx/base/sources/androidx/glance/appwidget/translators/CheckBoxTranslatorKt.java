package androidx.glance.appwidget.translators;

import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.C2902R;
import androidx.glance.appwidget.EmittableCheckBox;
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
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, m13886d2 = {"translateEmittableCheckBox", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "Landroidx/glance/appwidget/EmittableCheckBox;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCheckBoxTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckBoxTranslator.kt\nandroidx/glance/appwidget/translators/CheckBoxTranslatorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class CheckBoxTranslatorKt {
    public static final void translateEmittableCheckBox(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableCheckBox element) {
        int iInflateViewStub$default;
        int i;
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        int i2 = Build.VERSION.SDK_INT;
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, i2 >= 31 ? LayoutType.CheckBox : LayoutType.CheckBoxBackport, element.getModifier());
        if (i2 >= 31) {
            iInflateViewStub$default = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.checkBox, 0, null, 12, null);
            CompoundButtonApi31Impl.INSTANCE.setCompoundButtonChecked(remoteViews, iInflateViewStub$default, element.getChecked());
            CheckableColorProvider checkBox$glance_appwidget_release = element.getColors().getCheckBox$glance_appwidget_release();
            if (checkBox$glance_appwidget_release instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateList = CompoundButtonTranslatorKt.toDayNightColorStateList((CheckedUncheckedColorProvider) checkBox$glance_appwidget_release, translationContext.getContext());
                RemoteViewsCompat.setCompoundButtonTintList(remoteViews, iInflateViewStub$default, dayNightColorStateList.getDay(), dayNightColorStateList.getNight());
            } else {
                if (!(checkBox$glance_appwidget_release instanceof ResourceCheckableColorProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                RemoteViewsCompat.setCompoundButtonTintList(remoteViews, iInflateViewStub$default, ((ResourceCheckableColorProvider) checkBox$glance_appwidget_release).getResId());
            }
            Unit unit = Unit.INSTANCE;
            i = iInflateViewStub$default;
        } else {
            int iInflateViewStub$default2 = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.checkBoxIcon, 0, null, 12, null);
            iInflateViewStub$default = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.checkBoxText, 0, null, 12, null);
            int mainViewId = insertedViewInfoInsertView.getMainViewId();
            UtilsKt.setViewEnabled(remoteViews, iInflateViewStub$default2, element.getChecked());
            CompoundButtonTranslatorKt.m21398setImageViewColorFiltermxwnekA(remoteViews, iInflateViewStub$default2, CompoundButtonTranslatorKt.getColor(element.getColors().getCheckBox$glance_appwidget_release(), translationContext.getContext(), element.getChecked()));
            i = mainViewId;
        }
        TextTranslatorKt.setText$default(remoteViews, translationContext, iInflateViewStub$default, element.getText(), element.getStyle(), element.getMaxLines(), 16, 0.0f, 0, 192, null);
        ApplyModifiersKt.applyModifiers$default(translationContext.forActionTargetId(i), remoteViews, element.getModifier(), insertedViewInfoInsertView, null, 16, null);
    }
}
