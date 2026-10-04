package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.AddressStruct;
import com.google.zxing.client.result.NameStruct;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.TelParsedResult;
import com.samsung.android.app.sdk.deepsky.barcode.action.abstraction.Action;
import com.samsung.android.app.sdk.deepsky.barcode.result.ActionUIResource;
import com.samsung.android.app.sdk.deepsky.barcode.result.Barcode;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001dH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeDialogListener;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeDialogListener;)V", "barcode", "Lcom/samsung/android/app/sdk/deepsky/barcode/result/Barcode;", "getBarcode", "()Lcom/samsung/android/app/sdk/deepsky/barcode/result/Barcode;", "setBarcode", "(Lcom/samsung/android/app/sdk/deepsky/barcode/result/Barcode;)V", "getListener", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeDialogListener;", "txtQRContent", "Landroid/widget/TextView;", "txtQRHeading", "dismiss", "", "getCallIntent", "Landroid/content/Intent;", "parsedResult", "Lcom/google/zxing/client/result/ParsedResult;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "setContent", "view", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBarcodeDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BarcodeDialogFragment.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
public final class BarcodeDialogFragment extends DialogFragment {

    @NotNull
    private Barcode barcode;

    @NotNull
    private final Context context;

    @NotNull
    private final BarcodeDialogListener listener;
    private TextView txtQRContent;
    private TextView txtQRHeading;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ParsedResultType.values().length];
            try {
                iArr[ParsedResultType.TEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ParsedResultType.ADDRESSBOOK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BarcodeDialogFragment(@NotNull Context context, @NotNull BarcodeDialogListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.listener = listener;
        this.barcode = new Barcode((String) null, (Rect) null, (Point[]) null, (ActionUIResource) null, 15, (DefaultConstructorMarker) null);
    }

    private final Intent getCallIntent(ParsedResult parsedResult) {
        Uri uriFromParts;
        ParsedResultType type = parsedResult.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            Intrinsics.checkNotNull(parsedResult, "null cannot be cast to non-null type com.google.zxing.client.result.TelParsedResult");
            uriFromParts = Uri.parse(((TelParsedResult) parsedResult).getTelURI());
            Intrinsics.checkNotNullExpressionValue(uriFromParts, "{\n                Uri.pa…etTelURI())\n            }");
        } else if (i != 2) {
            uriFromParts = Uri.fromParts("tel", parsedResult.getDisplayResult(), null);
            Intrinsics.checkNotNullExpressionValue(uriFromParts, "{\n                Uri.fr…sult, null)\n            }");
        } else {
            Intrinsics.checkNotNull(parsedResult, "null cannot be cast to non-null type com.google.zxing.client.result.AddressBookParsedResult");
            uriFromParts = Uri.fromParts("tel", ((AddressBookParsedResult) parsedResult).getPhoneNumbers()[0], null);
            Intrinsics.checkNotNullExpressionValue(uriFromParts, "{\n                Uri.fr…          )\n            }");
        }
        Intent intent = new Intent("android.intent.action.DIAL", uriFromParts);
        intent.addFlags(268435456);
        return intent;
    }

    private final void setContent(View view) {
        View viewFindViewById = view.findViewById(C7039R.id.txtQRHeading);
        TextView textView = (TextView) viewFindViewById;
        textView.setText(this.barcode.getUiResource().getTitle());
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextVi…iResource.title\n        }");
        this.txtQRHeading = textView;
        View viewFindViewById2 = view.findViewById(C7039R.id.txtQRContent);
        TextView textView2 = (TextView) viewFindViewById2;
        textView2.setText(this.barcode.getUiResource().getBody());
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById<TextVi…uiResource.body\n        }");
        this.txtQRContent = textView2;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C7039R.id.layoutQRActions);
        for (final Action action : this.barcode.getUiResource().getActions()) {
            final TextView textView3 = new TextView(this.context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int dimension = (int) getResources().getDimension(C7039R.dimen.dialog_action_padding_vertical);
            textView3.setPadding(0, dimension, 0, dimension);
            textView3.setTextSize(0, textView3.getResources().getDimension(C7039R.dimen.dialog_action_text_size));
            textView3.setTextColor(requireContext().getColor(C7039R.color.textextraction_dialog_content_action_text_color));
            textView3.setMaxLines(1);
            textView3.setBackgroundResource(C7039R.drawable.qr_dialog_action_background);
            textView3.setClickable(true);
            textView3.setFocusable(true);
            textView3.setText(textView3.getResources().getString(action.getTitleId()));
            textView3.setLayoutParams(layoutParams);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BarcodeDialogFragment.setContent$lambda$7$lambda$6(action, textView3, this, view2);
                }
            });
            linearLayout.addView(textView3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setContent$lambda$7$lambda$6(Action action, TextView this_apply, BarcodeDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        action.execute();
        try {
            String str = action.getIntent().getPackage();
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullExpressionValue(this_apply.getContext().getPackageManager().getApplicationInfo(str, 0), "pkg!!.let { context.pack…tApplicationInfo(it, 0) }");
        } catch (Exception unused) {
            String string = this_apply.getResources().getString(action.getTitleId());
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(action.getTitleId())");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual(lowerCase, NotificationCompat.CATEGORY_CALL)) {
                this$0.context.startActivity(this$0.getCallIntent((ParsedResult) new AddressBookParsedResult(new String[0], new NameStruct[0], new String[0], new String[]{StringsKt__StringsKt.removePrefix(String.valueOf(action.getIntent().getData()), (CharSequence) "tel:")}, new String[]{"Home"}, new String[0], new String[0], new String[0], new String[0], new AddressStruct[0])));
            }
        }
        Dialog dialog = this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        this.listener.onDismiss();
        super.dismiss();
    }

    @NotNull
    public final Barcode getBarcode() {
        return this.barcode;
    }

    @NotNull
    public final BarcodeDialogListener getListener() {
        return this.listener;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = new Dialog(this.context);
        WindowManager.LayoutParams layoutParams = null;
        View viewInflate = LayoutInflater.from(dialog.getContext()).inflate(C7039R.layout.qr_dialog, (ViewGroup) null);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                Intrinsics.checkNotNullExpressionValue(attributes, "attributes");
                attributes.gravity = 81;
                attributes.windowAnimations = C7039R.style.DialogAnimation;
                layoutParams = attributes;
            }
            window.setAttributes(layoutParams);
        }
        dialog.setContentView(viewInflate);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(C7039R.layout.qr_dialog, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        setContent(view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    public final void setBarcode(@NotNull Barcode barcode) {
        Intrinsics.checkNotNullParameter(barcode, "<set-?>");
        this.barcode = barcode;
    }
}
