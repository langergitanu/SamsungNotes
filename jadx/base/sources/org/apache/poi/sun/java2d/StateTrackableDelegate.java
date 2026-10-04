package org.apache.poi.sun.java2d;

import org.apache.poi.sun.java2d.StateTrackable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class StateTrackableDelegate implements StateTrackable {
    private int numDynamicAgents;
    private StateTrackable.State theState;
    StateTracker theTracker;
    public static final StateTrackableDelegate UNTRACKABLE_DELEGATE = new StateTrackableDelegate(StateTrackable.State.UNTRACKABLE);
    public static final StateTrackableDelegate IMMUTABLE_DELEGATE = new StateTrackableDelegate(StateTrackable.State.IMMUTABLE);

    /* JADX INFO: renamed from: org.apache.poi.sun.java2d.StateTrackableDelegate$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140962 {
        static final /* synthetic */ int[] $SwitchMap$sun$java2d$StateTrackable$State;

        static {
            int[] iArr = new int[StateTrackable.State.values().length];
            $SwitchMap$sun$java2d$StateTrackable$State = iArr;
            try {
                iArr[StateTrackable.State.UNTRACKABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$sun$java2d$StateTrackable$State[StateTrackable.State.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$sun$java2d$StateTrackable$State[StateTrackable.State.DYNAMIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$sun$java2d$StateTrackable$State[StateTrackable.State.IMMUTABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private StateTrackableDelegate(StateTrackable.State state) {
        this.theState = state;
    }

    public static StateTrackableDelegate createInstance(StateTrackable.State state) {
        int i = C140962.$SwitchMap$sun$java2d$StateTrackable$State[state.ordinal()];
        if (i == 1) {
            return UNTRACKABLE_DELEGATE;
        }
        if (i == 2) {
            return new StateTrackableDelegate(StateTrackable.State.STABLE);
        }
        if (i == 3) {
            return new StateTrackableDelegate(StateTrackable.State.DYNAMIC);
        }
        if (i == 4) {
            return IMMUTABLE_DELEGATE;
        }
        throw new InternalError("unknown state");
    }

    public synchronized void addDynamicAgent() {
        StateTrackable.State state = this.theState;
        if (state == StateTrackable.State.IMMUTABLE) {
            throw new IllegalStateException("Cannot change state from IMMUTABLE");
        }
        this.numDynamicAgents++;
        if (state == StateTrackable.State.STABLE) {
            this.theState = StateTrackable.State.DYNAMIC;
            this.theTracker = null;
        }
    }

    @Override // org.apache.poi.sun.java2d.StateTrackable
    public StateTrackable.State getState() {
        return this.theState;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0027 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0001, B:5:0x0005, B:19:0x0029, B:14:0x001c, B:17:0x0021, B:18:0x0027), top: B:24:0x0001 }] */
    @Override // org.apache.poi.sun.java2d.StateTrackable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized StateTracker getStateTracker() {
        StateTracker stateTracker;
        try {
            stateTracker = this.theTracker;
            if (stateTracker == null) {
                int i = C140962.$SwitchMap$sun$java2d$StateTrackable$State[this.theState.ordinal()];
                if (i == 1) {
                    stateTracker = StateTracker.NEVER_CURRENT;
                    this.theTracker = stateTracker;
                } else {
                    if (i == 2) {
                        stateTracker = new StateTracker() { // from class: org.apache.poi.sun.java2d.StateTrackableDelegate.1
                            @Override // org.apache.poi.sun.java2d.StateTracker
                            public boolean isCurrent() {
                                return StateTrackableDelegate.this.theTracker == this;
                            }
                        };
                    } else if (i != 3) {
                        if (i == 4) {
                            stateTracker = StateTracker.ALWAYS_CURRENT;
                        }
                    }
                    this.theTracker = stateTracker;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return stateTracker;
    }

    public final void markDirty() {
        this.theTracker = null;
    }

    public synchronized void removeDynamicAgent() {
        int i = this.numDynamicAgents - 1;
        this.numDynamicAgents = i;
        if (i == 0 && this.theState == StateTrackable.State.DYNAMIC) {
            this.theState = StateTrackable.State.STABLE;
            this.theTracker = null;
        }
    }

    public synchronized void setImmutable() {
        StateTrackable.State state = this.theState;
        if (state == StateTrackable.State.UNTRACKABLE || state == StateTrackable.State.DYNAMIC) {
            throw new IllegalStateException("UNTRACKABLE or DYNAMIC objects cannot become IMMUTABLE");
        }
        this.theState = StateTrackable.State.IMMUTABLE;
        this.theTracker = null;
    }

    public synchronized void setUntrackable() {
        if (this.theState == StateTrackable.State.IMMUTABLE) {
            throw new IllegalStateException("IMMUTABLE objects cannot become UNTRACKABLE");
        }
        this.theState = StateTrackable.State.UNTRACKABLE;
        this.theTracker = null;
    }
}
