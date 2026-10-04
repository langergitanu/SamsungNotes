package com.samsung.android.sdk.pen.widget;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenComposingTagSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.widget.SpenFloatingTagConfirmButton;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\f\n\u0002\b\u0012\b\u0000\u0018\u0000 }2\u00020\u0001:\u0003{|}B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010A\u001a\u00020BJ\u0010\u0010F\u001a\u00020B2\b\u0010G\u001a\u0004\u0018\u00010\rJ\"\u0010H\u001a\u00020B2\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*J\u0018\u0010J\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u0001002\u0006\u0010L\u001a\u00020<J\u0006\u0010J\u001a\u00020BJ\u0006\u0010M\u001a\u00020BJ\u0010\u0010N\u001a\u00020B2\b\u0010O\u001a\u0004\u0018\u00010PJ\u0006\u0010Q\u001a\u00020BJ\b\u0010R\u001a\u00020BH\u0002J\b\u0010S\u001a\u00020BH\u0002J\u001a\u0010T\u001a\u0004\u0018\u00010\u00192\b\u0010U\u001a\u0004\u0018\u00010)2\u0006\u0010V\u001a\u00020<J\u0006\u0010W\u001a\u00020BJ\u001a\u0010X\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u0001002\b\u0010Y\u001a\u0004\u0018\u00010\u0019J\u001a\u0010Z\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u0001002\b\u0010Y\u001a\u0004\u0018\u00010\u0019J\u0006\u0010[\u001a\u00020BJ\u000e\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u000203J\u0006\u0010^\u001a\u00020BJ\u000e\u0010_\u001a\u00020B2\u0006\u0010`\u001a\u000203J.\u0010a\u001a\u0002032\b\u0010b\u001a\u0004\u0018\u0001002\b\u0010c\u001a\u0004\u0018\u00010\u00192\b\u0010d\u001a\u0004\u0018\u0001002\b\u0010e\u001a\u0004\u0018\u00010\u0019J\u0012\u0010f\u001a\u0004\u0018\u00010)2\b\u0010g\u001a\u0004\u0018\u00010\u0019J\u0010\u0010h\u001a\u0002032\b\u0010g\u001a\u0004\u0018\u00010\u0019J\u0010\u0010i\u001a\u0002032\b\u0010U\u001a\u0004\u0018\u00010)J\u000e\u0010j\u001a\u0002032\u0006\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u0002032\u0006\u0010k\u001a\u00020lJ\u000e\u0010n\u001a\u0002032\u0006\u0010o\u001a\u00020lJ\u0010\u0010p\u001a\u0002032\u0006\u0010o\u001a\u00020lH\u0002J.\u0010q\u001a\u0002032\b\u0010b\u001a\u0004\u0018\u0001002\b\u0010c\u001a\u0004\u0018\u00010\u00192\b\u0010d\u001a\u0004\u0018\u0001002\b\u0010e\u001a\u0004\u0018\u00010\u0019J&\u0010q\u001a\u0002032\u0006\u0010r\u001a\u00020<2\u0006\u0010s\u001a\u00020<2\u0006\u0010t\u001a\u00020<2\u0006\u0010u\u001a\u00020<J\u001a\u0010v\u001a\u0002032\b\u0010K\u001a\u0004\u0018\u0001002\b\u0010g\u001a\u0004\u0018\u00010\u0019J\u0006\u0010w\u001a\u00020BJ\"\u0010x\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u0001002\b\u0010Y\u001a\u0004\u0018\u00010\u00192\u0006\u0010y\u001a\u000203J\"\u0010z\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u0001002\b\u0010Y\u001a\u0004\u0018\u00010\u00192\u0006\u0010y\u001a\u000203R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010'\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u0014\u0010;\u001a\u00020<X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020<X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R$\u0010D\u001a\u0002032\u0006\u0010C\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u00105\"\u0004\bE\u00107¨\u0006~"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenHashTag;", "", "mView", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/view/View;Landroid/content/Context;)V", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mListener", "Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagListener;", "getMListener", "()Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagListener;", "setMListener", "(Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagListener;)V", "mShowConfirmHandler", "Landroid/os/Handler;", "getMShowConfirmHandler", "()Landroid/os/Handler;", "setMShowConfirmHandler", "(Landroid/os/Handler;)V", "mTagInfo", "Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagInfo;", "getMTagInfo", "()Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagInfo;", "setMTagInfo", "(Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagInfo;)V", "mConfirmTagInfo", "getMConfirmTagInfo", "setMConfirmTagInfo", "mConfirmView", "Lcom/samsung/android/sdk/pen/widget/SpenFloatingTagConfirmButton;", "getMConfirmView", "()Lcom/samsung/android/sdk/pen/widget/SpenFloatingTagConfirmButton;", "setMConfirmView", "(Lcom/samsung/android/sdk/pen/widget/SpenFloatingTagConfirmButton;)V", "hashTagBubbleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getHashTagBubbleList", "()Ljava/util/ArrayList;", "setHashTagBubbleList", "(Ljava/util/ArrayList;)V", "mObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "mConfirmObject", "mSkipShowConfirm", "", "getMSkipShowConfirm", "()Z", "setMSkipShowConfirm", "(Z)V", "mIsEnabled", "getMIsEnabled", "setMIsEnabled", "MESSAGE_WHAT_SHOW_CONFIRM", "", "getMESSAGE_WHAT_SHOW_CONFIRM", "()I", "SHOW_CONFIRM_DELAY_TIME", "getSHOW_CONFIRM_DELAY_TIME", "close", "", "enable", "isEnabled", "setEnabled", "setHashTagListener", "l", "setTagList", XmlErrorCodes.LIST, "updateHashTag", "objectShape", "pos", "updateConfirmViewPosition", "onParentTouchEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "clearSpans", "addConfirmView", "findHashTag", "text", "position", "refreshTagInfo", "setTagInfo", "tagInfo", "setConfirmTagInfo", "requestToShowConfirm", "showConfirmView", Constants.IntentExtraValue.SHOW, "hideConfirmView", "setConfirmResult", "add", "checkIfTagConfirmed", "src", "srcInfo", "dst", "dstInfo", "getTagText", "info", "canTag", "isInTagList", "isBlank", "ch", "", "isNonTagChar", "isSpecialCharacter", "character", "isTagChar", "isOverlapped", "srcStart", "srcEnd", "dstStart", "dstEnd", "isValid", "removeAllSpans", "removeSpans", "isConfirmed", "appendSpans", "HashTagListener", "HashTagInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHashTag {
    private static final char CR_CHAR = '\r';
    private static final char LF_CHAR = '\n';
    private static final int MAX_CHARACTER = 50;
    private static final char SPACE_CHAR = ' ';
    private static final char TAB_CHAR = '\t';

    @NotNull
    private static final String TAG = "SpenHashTag";
    private final int MESSAGE_WHAT_SHOW_CONFIRM;
    private final int SHOW_CONFIRM_DELAY_TIME;

    @Nullable
    private ArrayList<String> hashTagBubbleList;

    @Nullable
    private SpenObjectShape mConfirmObject;

    @Nullable
    private HashTagInfo mConfirmTagInfo;

    @Nullable
    private SpenFloatingTagConfirmButton mConfirmView;
    private boolean mIsEnabled;

    @Nullable
    private HashTagListener mListener;

    @Nullable
    private SpenObjectShape mObject;

    @Nullable
    private Handler mShowConfirmHandler;
    private boolean mSkipShowConfirm;

    @Nullable
    private HashTagInfo mTagInfo;

    @Nullable
    private View mView;

    @NotNull
    private static final char[] TAG_CHARS = {'#', 65119, 65283};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagInfo;", "", "<init>", "()V", "text", "", "start", "", "end", "(Ljava/lang/String;II)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class HashTagInfo {
        private int end;
        private int start;

        @Nullable
        private String text;

        public HashTagInfo() {
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public final void setEnd(int i) {
            this.end = i;
        }

        public final void setStart(int i) {
            this.start = i;
        }

        public final void setText(@Nullable String str) {
            this.text = str;
        }

        public HashTagInfo(@Nullable String str, int i, int i2) {
            this.text = str;
            this.start = i;
            this.end = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenHashTag$HashTagListener;", "", "onHashTagAdded", "", "tagStr", "", "getScreenTextRect", "Landroid/graphics/RectF;", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "startPos", "", "endPos", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface HashTagListener {
        @NotNull
        RectF getScreenTextRect(@Nullable SpenObjectShape objectShape, int startPos, int endPos);

        void onHashTagAdded(@Nullable String tagStr);
    }

    public SpenHashTag(@Nullable View view, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mView = view;
        this.MESSAGE_WHAT_SHOW_CONFIRM = 1;
        this.SHOW_CONFIRM_DELAY_TIME = 500;
        SpenFloatingTagConfirmButton spenFloatingTagConfirmButton = new SpenFloatingTagConfirmButton(context);
        this.mConfirmView = spenFloatingTagConfirmButton;
        spenFloatingTagConfirmButton.setListener(new SpenFloatingTagConfirmButton.ActionListener() { // from class: com.samsung.android.sdk.pen.widget.SpenHashTag.1
            @Override // com.samsung.android.sdk.pen.widget.SpenFloatingTagConfirmButton.ActionListener
            public void onConfirmed(boolean allow) {
                SpenHashTag.this.setConfirmResult(allow);
            }
        });
        this.mShowConfirmHandler = new Handler() { // from class: com.samsung.android.sdk.pen.widget.SpenHashTag.2
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                if (msg.what == SpenHashTag.this.getMESSAGE_WHAT_SHOW_CONFIRM()) {
                    SpenHashTag.this.showConfirmView(true);
                }
            }
        };
    }

    private final void addConfirmView() {
        View view;
        SpenFloatingTagConfirmButton spenFloatingTagConfirmButton = this.mConfirmView;
        if (spenFloatingTagConfirmButton == null || (view = this.mView) == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        ViewParent parent2 = spenFloatingTagConfirmButton.getParent();
        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup2 != null) {
            if (viewGroup2 == viewGroup) {
                return;
            } else {
                viewGroup2.removeView(spenFloatingTagConfirmButton);
            }
        }
        if (viewGroup != null) {
            viewGroup.addView(spenFloatingTagConfirmButton);
        }
    }

    private final void clearSpans() {
        removeAllSpans();
        this.mObject = null;
        this.mConfirmObject = null;
        this.mTagInfo = null;
        this.mConfirmTagInfo = null;
        this.hashTagBubbleList = null;
    }

    private final boolean isTagChar(char character) {
        for (char c : TAG_CHARS) {
            if (character == c) {
                return true;
            }
        }
        return false;
    }

    public final void appendSpans(@Nullable SpenObjectShape objectShape, @Nullable HashTagInfo tagInfo, boolean isConfirmed) {
        if (objectShape == null || tagInfo == null) {
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(tagInfo.getStart(), tagInfo.getEnd(), "appendSpans tagPos(", ",", ") isConfirmed:");
        sbM1173s.append(isConfirmed);
        Log.d(TAG, sbM1173s.toString());
        boolean zIsChanged = objectShape.isChanged();
        objectShape.appendTextSpan(new SpenComposingTagSpan(tagInfo.getStart(), tagInfo.getEnd(), 3, isConfirmed));
        if (zIsChanged) {
            return;
        }
        objectShape.clearChangedFlag();
    }

    public final boolean canTag(@Nullable HashTagInfo info) {
        String tagText = getTagText(info);
        if (tagText == null || tagText.length() == 0) {
            return false;
        }
        return !isInTagList(tagText);
    }

    public final boolean checkIfTagConfirmed(@Nullable SpenObjectShape src, @Nullable HashTagInfo srcInfo, @Nullable SpenObjectShape dst, @Nullable HashTagInfo dstInfo) {
        if (isValid(src, srcInfo)) {
            return (isValid(dst, dstInfo) && isOverlapped(src, srcInfo, dst, dstInfo)) ? false : true;
        }
        return false;
    }

    public final void close() {
        Handler handler = this.mShowConfirmHandler;
        if (handler != null) {
            handler.removeMessages(this.MESSAGE_WHAT_SHOW_CONFIRM);
            this.mShowConfirmHandler = null;
        }
        SpenFloatingTagConfirmButton spenFloatingTagConfirmButton = this.mConfirmView;
        if (spenFloatingTagConfirmButton != null) {
            ViewParent parent = spenFloatingTagConfirmButton.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(spenFloatingTagConfirmButton);
            }
            spenFloatingTagConfirmButton.close();
            this.mConfirmView = null;
        }
        clearSpans();
        this.mView = null;
    }

    @Nullable
    public final HashTagInfo findHashTag(@Nullable String text, int position) {
        int length;
        if (text == null || (length = text.length()) <= 0 || position <= 0 || length < position) {
            return null;
        }
        for (int i = position - 1; i >= 0; i--) {
            char cCharAt = text.charAt(i);
            if (isTagChar(cCharAt)) {
                while (position < length) {
                    char cCharAt2 = text.charAt(position);
                    if (isNonTagChar(cCharAt2) || isTagChar(cCharAt2)) {
                        length = position;
                        break;
                    }
                    position++;
                }
                int i2 = (length - i) - 1;
                if (i2 > 50) {
                    AbstractC2322a.m1632v(i2, "tag(", ") is longer than Max(50)", TAG);
                    return null;
                }
                HashTagInfo hashTagInfo = new HashTagInfo();
                String strSubstring = text.substring(i, length);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                hashTagInfo.setText(strSubstring);
                hashTagInfo.setStart(i);
                hashTagInfo.setEnd(length);
                String text2 = hashTagInfo.getText();
                int start = hashTagInfo.getStart();
                int end = hashTagInfo.getEnd();
                StringBuilder sbM780v = AbstractC0541b.m780v("tagText =", start, text2, " start=", " end=");
                sbM780v.append(end);
                Log.d(TAG, sbM780v.toString());
                return hashTagInfo;
            }
            if (isNonTagChar(cCharAt)) {
                return null;
            }
        }
        return null;
    }

    @Nullable
    public final ArrayList<String> getHashTagBubbleList() {
        return this.hashTagBubbleList;
    }

    @Nullable
    public final HashTagInfo getMConfirmTagInfo() {
        return this.mConfirmTagInfo;
    }

    @Nullable
    public final SpenFloatingTagConfirmButton getMConfirmView() {
        return this.mConfirmView;
    }

    public final int getMESSAGE_WHAT_SHOW_CONFIRM() {
        return this.MESSAGE_WHAT_SHOW_CONFIRM;
    }

    public final boolean getMIsEnabled() {
        return this.mIsEnabled;
    }

    @Nullable
    public final HashTagListener getMListener() {
        return this.mListener;
    }

    @Nullable
    public final Handler getMShowConfirmHandler() {
        return this.mShowConfirmHandler;
    }

    public final boolean getMSkipShowConfirm() {
        return this.mSkipShowConfirm;
    }

    @Nullable
    public final HashTagInfo getMTagInfo() {
        return this.mTagInfo;
    }

    @Nullable
    public final View getMView() {
        return this.mView;
    }

    public final int getSHOW_CONFIRM_DELAY_TIME() {
        return this.SHOW_CONFIRM_DELAY_TIME;
    }

    @Nullable
    public final String getTagText(@Nullable HashTagInfo info) {
        String text;
        if (info == null || (text = info.getText()) == null || text.length() <= 1) {
            return null;
        }
        String strSubstring = text.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final void hideConfirmView() {
        SpenFloatingTagConfirmButton spenFloatingTagConfirmButton = this.mConfirmView;
        if (spenFloatingTagConfirmButton == null || !spenFloatingTagConfirmButton.getIsShowing()) {
            return;
        }
        showConfirmView(false);
    }

    public final boolean isBlank(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r';
    }

    public final boolean isEnabled() {
        return this.mIsEnabled;
    }

    public final boolean isInTagList(@Nullable String text) {
        ArrayList<String> arrayList;
        if (text == null || (arrayList = this.hashTagBubbleList) == null) {
            return false;
        }
        return arrayList.contains(text);
    }

    public final boolean isNonTagChar(char ch) {
        return isBlank(ch) || isSpecialCharacter(ch);
    }

    public final boolean isOverlapped(@Nullable SpenObjectShape src, @Nullable HashTagInfo srcInfo, @Nullable SpenObjectShape dst, @Nullable HashTagInfo dstInfo) {
        return (src == null || dst == null || srcInfo == null || dstInfo == null || !Intrinsics.areEqual(src, dst) || !isOverlapped(srcInfo.getStart(), srcInfo.getEnd(), dstInfo.getStart(), dstInfo.getEnd())) ? false : true;
    }

    public final boolean isSpecialCharacter(char character) {
        return 23 == Character.getType(character) || !Character.isUnicodeIdentifierPart(character);
    }

    public final boolean isValid(@Nullable SpenObjectShape objectShape, @Nullable HashTagInfo info) {
        if (objectShape != null && info != null && info.getText() != null) {
            String text = info.getText();
            Intrinsics.checkNotNull(text);
            if (text.length() != 0 && info.getStart() >= 0 && info.getEnd() > info.getStart()) {
                return true;
            }
        }
        return false;
    }

    public final void onAttachedToWindow() {
        addConfirmView();
    }

    public final void onParentTouchEvent(@Nullable MotionEvent event) {
        if (!this.mIsEnabled || event == null) {
            return;
        }
        if (event.getAction() == 0) {
            showConfirmView(false);
            this.mSkipShowConfirm = true;
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            this.mSkipShowConfirm = false;
        }
    }

    public final void refreshTagInfo() {
        HashTagInfo hashTagInfo;
        SpenObjectShape spenObjectShape = this.mObject;
        if (spenObjectShape == null || (hashTagInfo = this.mTagInfo) == null) {
            return;
        }
        this.mTagInfo = findHashTag(spenObjectShape.getText(), hashTagInfo.getStart() + 1);
    }

    public final void removeAllSpans() {
        ArrayList<SpenTextSpanBase> textSpan;
        ArrayList<SpenTextSpanBase> textSpan2;
        SpenObjectShape spenObjectShape = this.mObject;
        if (spenObjectShape != null && (textSpan2 = spenObjectShape.getTextSpan()) != null && textSpan2.size() > 0) {
            boolean zIsChanged = spenObjectShape.isChanged();
            Iterator<SpenTextSpanBase> it = textSpan2.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextSpanBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextSpanBase spenTextSpanBase = next;
                if (spenTextSpanBase.getType() == 18) {
                    spenObjectShape.removeTextSpan(spenTextSpanBase);
                }
            }
            if (!zIsChanged) {
                spenObjectShape.clearChangedFlag();
            }
        }
        SpenObjectShape spenObjectShape2 = this.mConfirmObject;
        if (spenObjectShape2 == null || spenObjectShape2 == this.mObject || (textSpan = spenObjectShape2.getTextSpan()) == null || textSpan.size() <= 0) {
            return;
        }
        boolean zIsChanged2 = spenObjectShape2.isChanged();
        Iterator<SpenTextSpanBase> it2 = textSpan.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            SpenTextSpanBase next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            SpenTextSpanBase spenTextSpanBase2 = next2;
            if (spenTextSpanBase2.getType() == 18) {
                spenObjectShape2.removeTextSpan(spenTextSpanBase2);
                Log.d(TAG, AbstractC0622a.m1164j(spenTextSpanBase2.getStart(), spenTextSpanBase2.getEnd(), "removeAllSpans >> (", ",", ") "));
            }
        }
        if (zIsChanged2) {
            return;
        }
        spenObjectShape2.clearChangedFlag();
    }

    public final void removeSpans(@Nullable SpenObjectShape objectShape, @Nullable HashTagInfo tagInfo, boolean isConfirmed) {
        if (objectShape == null || tagInfo == null) {
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(tagInfo.getStart(), tagInfo.getEnd(), "removeSpans tagPos(", ",", ") isConfirmed:");
        sbM1173s.append(isConfirmed);
        Log.d(TAG, sbM1173s.toString());
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = objectShape.findTextSpan(tagInfo.getStart(), tagInfo.getEnd());
        if (arrayListFindTextSpan == null || !(!arrayListFindTextSpan.isEmpty())) {
            return;
        }
        boolean zIsChanged = objectShape.isChanged();
        Iterator<SpenTextSpanBase> it = arrayListFindTextSpan.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenTextSpanBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextSpanBase spenTextSpanBase = next;
            if (spenTextSpanBase.getType() == 18 && ((SpenComposingTagSpan) spenTextSpanBase).getIsComposingTagBgPropertyEnabled() == isConfirmed) {
                objectShape.removeTextSpan(spenTextSpanBase);
                Log.d(TAG, AbstractC0622a.m1164j(spenTextSpanBase.getStart(), spenTextSpanBase.getEnd(), "removeSpans >> (", ",", ") "));
            }
        }
        if (zIsChanged) {
            return;
        }
        objectShape.clearChangedFlag();
    }

    public final void requestToShowConfirm() {
        Handler handler;
        if (this.mListener == null || (handler = this.mShowConfirmHandler) == null) {
            return;
        }
        handler.removeMessages(this.MESSAGE_WHAT_SHOW_CONFIRM);
        handler.sendEmptyMessageDelayed(this.MESSAGE_WHAT_SHOW_CONFIRM, this.SHOW_CONFIRM_DELAY_TIME);
    }

    public final void setConfirmResult(boolean add) {
        String tagText;
        HashTagListener hashTagListener;
        if (add && (tagText = getTagText(this.mConfirmTagInfo)) != null && tagText.length() != 0 && (hashTagListener = this.mListener) != null) {
            hashTagListener.onHashTagAdded(tagText);
        }
        removeSpans(this.mConfirmObject, this.mConfirmTagInfo, true);
        setConfirmTagInfo(null, null);
    }

    public final void setConfirmTagInfo(@Nullable SpenObjectShape objectShape, @Nullable HashTagInfo tagInfo) {
        this.mConfirmObject = objectShape;
        HashTagInfo hashTagInfo = tagInfo != null ? new HashTagInfo(tagInfo.getText(), tagInfo.getStart(), tagInfo.getEnd()) : null;
        this.mConfirmTagInfo = hashTagInfo;
        appendSpans(this.mConfirmObject, hashTagInfo, true);
    }

    public final void setEnabled(boolean z) {
        if (!z) {
            clearSpans();
        }
        this.mIsEnabled = z;
    }

    public final void setHashTagBubbleList(@Nullable ArrayList<String> arrayList) {
        this.hashTagBubbleList = arrayList;
    }

    public final void setHashTagListener(@Nullable HashTagListener l) {
        this.mListener = l;
    }

    public final void setMConfirmTagInfo(@Nullable HashTagInfo hashTagInfo) {
        this.mConfirmTagInfo = hashTagInfo;
    }

    public final void setMConfirmView(@Nullable SpenFloatingTagConfirmButton spenFloatingTagConfirmButton) {
        this.mConfirmView = spenFloatingTagConfirmButton;
    }

    public final void setMIsEnabled(boolean z) {
        this.mIsEnabled = z;
    }

    public final void setMListener(@Nullable HashTagListener hashTagListener) {
        this.mListener = hashTagListener;
    }

    public final void setMShowConfirmHandler(@Nullable Handler handler) {
        this.mShowConfirmHandler = handler;
    }

    public final void setMSkipShowConfirm(boolean z) {
        this.mSkipShowConfirm = z;
    }

    public final void setMTagInfo(@Nullable HashTagInfo hashTagInfo) {
        this.mTagInfo = hashTagInfo;
    }

    public final void setMView(@Nullable View view) {
        this.mView = view;
    }

    public final void setTagInfo(@Nullable SpenObjectShape objectShape, @Nullable HashTagInfo tagInfo) {
        this.mObject = objectShape;
        HashTagInfo hashTagInfo = tagInfo != null ? new HashTagInfo(tagInfo.getText(), tagInfo.getStart(), tagInfo.getEnd()) : null;
        this.mTagInfo = hashTagInfo;
        appendSpans(this.mObject, hashTagInfo, false);
    }

    public final void setTagList(@Nullable ArrayList<String> list) {
        this.hashTagBubbleList = list;
    }

    public final void showConfirmView(boolean show) {
        SpenObjectShape spenObjectShape;
        HashTagListener hashTagListener;
        HashTagInfo hashTagInfo;
        SpenFloatingTagConfirmButton spenFloatingTagConfirmButton = this.mConfirmView;
        if (spenFloatingTagConfirmButton != null) {
            if (show && (spenObjectShape = this.mConfirmObject) != null && (hashTagListener = this.mListener) != null && (hashTagInfo = this.mConfirmTagInfo) != null) {
                RectF screenTextRect = hashTagListener.getScreenTextRect(spenObjectShape, hashTagInfo.getStart(), hashTagInfo.getEnd());
                if (!screenTextRect.isEmpty()) {
                    addConfirmView();
                    spenFloatingTagConfirmButton.show(true, screenTextRect);
                    return;
                }
            }
            Handler handler = this.mShowConfirmHandler;
            if (handler != null) {
                handler.removeMessages(this.MESSAGE_WHAT_SHOW_CONFIRM);
            }
            spenFloatingTagConfirmButton.show(false, null);
        }
    }

    public final void updateConfirmViewPosition() {
        SpenFloatingTagConfirmButton spenFloatingTagConfirmButton = this.mConfirmView;
        if (spenFloatingTagConfirmButton == null || spenFloatingTagConfirmButton.getVisibility() != 0) {
            return;
        }
        requestToShowConfirm();
    }

    public final void updateHashTag(@Nullable SpenObjectShape objectShape, int pos) {
        if (this.mIsEnabled) {
            hideConfirmView();
            HashTagInfo hashTagInfoFindHashTag = objectShape != null ? findHashTag(objectShape.getText(), pos) : null;
            if (!isValid(objectShape, hashTagInfoFindHashTag)) {
                objectShape = null;
                hashTagInfoFindHashTag = null;
            }
            refreshTagInfo();
            removeAllSpans();
            if (!this.mSkipShowConfirm && checkIfTagConfirmed(this.mObject, this.mTagInfo, objectShape, hashTagInfoFindHashTag) && canTag(this.mTagInfo)) {
                setConfirmTagInfo(this.mObject, this.mTagInfo);
                requestToShowConfirm();
            } else {
                setConfirmTagInfo(null, null);
            }
            setTagInfo(objectShape, hashTagInfoFindHashTag);
        }
    }

    public final boolean isOverlapped(int srcStart, int srcEnd, int dstStart, int dstEnd) {
        boolean z = srcStart < dstEnd && dstStart < srcEnd;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(srcStart, srcEnd, "isOverlapped src(", ",", ") dst(");
        AbstractC2821a.m2235z(sbM1173s, dstStart, dstEnd, ",", ") :");
        sbM1173s.append(z);
        Log.d(TAG, sbM1173s.toString());
        return z;
    }

    public final void updateHashTag() {
        updateHashTag(null, -1);
    }
}
