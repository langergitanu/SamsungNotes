package androidx.compose.p109ui.focus;

import android.view.KeyEvent;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.input.rotary.RotaryScrollEvent;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H&ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH&ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H&J:\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0(H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010&H&J\b\u0010-\u001a\u00020.H&J$\u0010/\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u00100\u001a\u0004\u0018\u00010&H&ø\u0001\u0000¢\u0006\u0002\b1J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H&J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000205H&J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020)H&J$\u00106\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u00100\u001a\u0004\u0018\u00010&H&ø\u0001\u0000¢\u0006\u0004\b7\u00108R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u00069À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/focus/FocusManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "", NotesSyncRpcProvider.FORCE_SYNC, "refreshFocusEvents", "clearOwnerFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "Landroidx/compose/ui/geometry/Rect;", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "releaseFocus", "", "requestFocusForOwner", "previouslyFocusedRect", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface FocusOwner extends FocusManager {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w$default, reason: not valid java name */
    static /* synthetic */ boolean m18212dispatchKeyEventYhN2O0w$default(FocusOwner focusOwner, KeyEvent keyEvent, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.mo18215dispatchKeyEventYhN2O0w(keyEvent, function0);
    }

    /* JADX INFO: renamed from: clearFocus-I7lrPNg, reason: not valid java name */
    boolean mo18213clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection);

    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo, reason: not valid java name */
    boolean mo18214dispatchInterceptedSoftKeyboardEventZmokQxo(@NotNull KeyEvent keyEvent);

    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w, reason: not valid java name */
    boolean mo18215dispatchKeyEventYhN2O0w(@NotNull KeyEvent keyEvent, @NotNull Function0<Boolean> onFocusedItem);

    boolean dispatchRotaryEvent(@NotNull RotaryScrollEvent event);

    @Nullable
    /* JADX INFO: renamed from: focusSearch-ULY8qGw, reason: not valid java name */
    Boolean mo18216focusSearchULY8qGw(int focusDirection, @Nullable Rect focusedRect, @NotNull Function1<? super FocusTargetNode, Boolean> onFound);

    @Nullable
    Rect getFocusRect();

    @NotNull
    FocusTransactionManager getFocusTransactionManager();

    @NotNull
    Modifier getModifier();

    @NotNull
    FocusState getRootState();

    void releaseFocus();

    /* JADX INFO: renamed from: requestFocusForOwner-7o62pno, reason: not valid java name */
    boolean mo18217requestFocusForOwner7o62pno(@Nullable FocusDirection focusDirection, @Nullable Rect previouslyFocusedRect);

    void scheduleInvalidation(@NotNull FocusEventModifierNode node);

    void scheduleInvalidation(@NotNull FocusPropertiesModifierNode node);

    void scheduleInvalidation(@NotNull FocusTargetNode node);

    /* JADX INFO: renamed from: takeFocus-aToIllA, reason: not valid java name */
    boolean mo18218takeFocusaToIllA(int focusDirection, @Nullable Rect previouslyFocusedRect);
}
