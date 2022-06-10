Problem of view--view-controller--controller: TODO: put it into separate file

When we implement our GUI classes (no matter, if it is a application
window, some dialog or a panel, which groups several standard gui
elements we always have this situation: Normally we want to split
the code of the gui element into two parts (especially in swing,
where we implement graphical layout directly in Java code and not
with help of e.g. XML or so. First part is "view", which is responsible
for graphical part. Second part is "view-controller", which is
basically the logical part of the GUI - it's interface to the
rest of the code.