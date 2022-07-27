package xyz.dsemikin.skinnycat.guiswing.logic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ListenersWithArg<ArgumentType> {

    private final List<WeakReference<ListenerWithArg<ArgumentType>>> listeners;

    public ListenersWithArg() {
        listeners = new ArrayList<>();
    }

    public void add(final ListenerWithArg<ArgumentType> listener) {
        listeners.add(new WeakReference<>(listener));
    }

    public void notifyListeners(ArgumentType arg) {
        for (var listenerWeakRef : listeners) {
            final ListenerWithArg<ArgumentType> listener = listenerWeakRef.get();
            if (listener != null) {
                listener.onEvent(arg);
            } else {
                listeners.remove(listenerWeakRef);
            }
        }
    }
}
