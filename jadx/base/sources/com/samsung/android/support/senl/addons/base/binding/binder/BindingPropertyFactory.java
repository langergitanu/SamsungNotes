package com.samsung.android.support.senl.addons.base.binding.binder;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IVMCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand;", "<init>", "()V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BindingPropertyFactory implements IVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion;", "", "<init>", "()V", "createBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "holder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "VisibilityBinding", "ContentDescriptionBinding", "ButtonContentDescriptionBinding", "ProgressBarBinding", "ClickableBinding", "TextBinding", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion$ButtonContentDescriptionBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ButtonContentDescriptionBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data == null) {
                    return;
                }
                String string = view.getResources().getString(data.intValue());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (PlatformUtil.isVoiceAssistantEnabled()) {
                    String string2 = view.getResources().getString(C7944R.string.string_button_t_tts);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    string = AbstractC2322a.m1624n(string2, new Object[]{string}, 1, "format(...)");
                }
                view.setContentDescription(string);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion$ClickableBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ClickableBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    view.setClickable(data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion$ContentDescriptionBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ContentDescriptionBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data == null) {
                    return;
                }
                String string = view.getResources().getString(data.intValue());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                view.setContentDescription(string);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion$ProgressBarBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ProgressBarBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (!(view instanceof SeekBar) || data == null) {
                    return;
                }
                ((SeekBar) view).setProgress(data.intValue());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion$TextBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsStringExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class TextBinding extends AbsStringExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable String data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view instanceof TextView) {
                    ((TextView) view).setText(data);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingPropertyFactory$Companion$VisibilityBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class VisibilityBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    view.setVisibility(data.intValue());
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final IBinding createBinding(@NotNull IViewBind bind, @Nullable IViewModelHolder holder) {
            IBinding emptyBinding;
            Intrinsics.checkNotNullParameter(bind, "bind");
            String mPropertyId = bind.getMPropertyId();
            if (mPropertyId != null) {
                switch (mPropertyId.hashCode()) {
                    case -1411266756:
                        emptyBinding = !mPropertyId.equals("pr_content") ? new IBinding.EmptyBinding() : new ContentDescriptionBinding();
                        break;
                    case -1233352758:
                        if (mPropertyId.equals("pr_progress")) {
                            emptyBinding = new ProgressBarBinding();
                            break;
                        }
                        break;
                    case -575257371:
                        if (mPropertyId.equals("pr_clickable")) {
                            emptyBinding = new ClickableBinding();
                            break;
                        }
                        break;
                    case -383644599:
                        if (mPropertyId.equals("pr_button_content")) {
                            emptyBinding = new ButtonContentDescriptionBinding();
                            break;
                        }
                        break;
                    case -323788470:
                        if (mPropertyId.equals("pr_text")) {
                            emptyBinding = new TextBinding();
                            break;
                        }
                        break;
                    case 2063807855:
                        if (mPropertyId.equals("pr_visibility")) {
                            emptyBinding = new VisibilityBinding();
                            break;
                        }
                        break;
                }
            }
            emptyBinding.setValues(bind, holder);
            return emptyBinding;
        }

        private Companion() {
        }
    }
}
