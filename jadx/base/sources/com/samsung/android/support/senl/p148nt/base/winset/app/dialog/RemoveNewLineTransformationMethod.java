package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/RemoveNewLineTransformationMethod;", "Landroid/text/method/HideReturnsTransformationMethod;", "<init>", "()V", "getTransformation", "", "source", "view", "Landroid/view/View;", "SimpleCharSequence", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RemoveNewLineTransformationMethod extends HideReturnsTransformationMethod {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static RemoveNewLineTransformationMethod mSelf;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/RemoveNewLineTransformationMethod$Companion;", "", "<init>", "()V", "mSelf", "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/RemoveNewLineTransformationMethod;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/RemoveNewLineTransformationMethod;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @Nullable
        public final RemoveNewLineTransformationMethod getInstance() {
            if (RemoveNewLineTransformationMethod.mSelf == null) {
                RemoveNewLineTransformationMethod.mSelf = new RemoveNewLineTransformationMethod();
            }
            return RemoveNewLineTransformationMethod.mSelf;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0002J\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/RemoveNewLineTransformationMethod$SimpleCharSequence;", "", "mSource", "<init>", "(Ljava/lang/CharSequence;)V", "length", "", "getLength", "()I", "get", "", "index", "subSequence", "start", "end", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SimpleCharSequence implements CharSequence {

        @NotNull
        private final CharSequence mSource;

        public SimpleCharSequence(@NotNull CharSequence mSource) {
            Intrinsics.checkNotNullParameter(mSource, "mSource");
            this.mSource = mSource;
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i) {
            return get(i);
        }

        public char get(int index) {
            char cCharAt = this.mSource.charAt(index);
            if (cCharAt == '\n') {
                return ' ';
            }
            return cCharAt;
        }

        public int getLength() {
            return this.mSource.length();
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return getLength();
        }

        @Override // java.lang.CharSequence
        @NotNull
        public CharSequence subSequence(int start, int end) {
            return this.mSource.subSequence(start, end);
        }
    }

    @Nullable
    public static final RemoveNewLineTransformationMethod getInstance() {
        return INSTANCE.getInstance();
    }

    @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
    @NotNull
    public CharSequence getTransformation(@NotNull CharSequence source, @NotNull View view) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(view, "view");
        CharSequence transformation = super.getTransformation(source, view);
        Intrinsics.checkNotNull(transformation);
        return new SimpleCharSequence(transformation);
    }
}
