# Problem of view - controller ownership

Statement 1: creating circular references is not good. It should normally
be avoided. The need to create circular reference means, that
 - either one (or more) of the classes contains multiple functions, which could
   be separated to different classes.
 - or the two (or more) classes just represent single entity, which is not
   really separable and should be present by single class.

Now to our situation with the GUI:

When we implement our GUI classes (no matter, if it is a application
window, some dialog or a panel, which groups several standard gui
elements we always have this situation: Normally we want to split
the code of the gui element into two parts (especially in swing,
where we implement graphical layout directly in Java code and not
with help of e.g. XML or so). First part is "view", which is responsible
for graphical part. Second part is "view-controller", which is
basically the logical part of the GUI - it's interface to the
rest of the code.

Now, GUI components are special (compared to e.g. with "business-logic components")
in that it has multiple triggers/entry points (or even better to say:
entry directions): first, some activity can be triggered by the user.
Normally this kind of trigger activates then some "activity" in some
"business logic component", i.e. it should call some method in controller.
To make this possible gui need to have to be able to access controller.
On the other hand, some business component may need to change the state
of the GUI (e.g. triggering some other GUI function make change of state
of the applicaiton, which needs to disable certain GUI elements). For this
to happen business logic component needs to be able to access the GUI.

Easy solution for this is "circular dependency". Then we have bi-directional
communication channel. But at the beginning we told, that it is not good
to have it.

So what would be the alternative:

We could instead build the tree of all gui elements and make each element
available from the root. And then make the root available either to all
controllers via e.g. injection (but in this case we would still have circular
dependency - just the circle would be much larger and it would be less obvious).
Alternatively we could make root gui element available globally (e.g. as Singleton).
This would make "circulr reference problem" go away. But it has another significant
problem: to use this solution we would need each controller, which needs
to access some GUI element to know exact path to this GUI element. This
make the structure of the GUI hardcoded to the controller code, which makes
it very non-flexible.

After giving this whole thing some thought, I came to the conclusion, that
having circular reference in this case is "less evil", then hardcoding the
GUI structure.

Of course, the reference form GUI to controller should be done in the form
of registering listeners. And then, if we think about it, when we register
some listener, we don't need to "keep it alive", so we may just keep the
weak references to the listeners and only call the callbacks of the objects,
which are still alive.

This is the way, I am going to continue with this project.

Probably I could create some helper object, which would do the housekeeping
of working with weak references.
