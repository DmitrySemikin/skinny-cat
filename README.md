# Skinny Cat #

Some diagrams are available on https://online.visual-paradigm.com


* Unit: day menu
  * Title (text, unique, mandatory)
  * Menu name (text, opt)
  * Menu week (opt)
  * Menu day (opt)
  * Dishes-line (free text, opt)
  * Groceries list (reference to separate table)
  * (advanced) Scan of the page

* Foodstuff
  * Name
  * Quantity Unit

* Foodstuff list
  * Grocery ref
  * Quantity

* Menu list
  * List Name (generated from date)
  * References to day menus


Wildfly (REST) + H2 + GUI (Desktop? Android? HTML?)


* Create Day Menu
* Delete Day Menu
* Update Day Menu
* Get all Day Menus

* Create Grocery
* Delete Grocery
* Get all Groceries

* Create active list
* Delete active list
* Get all active lists
* Add day to active list
* Remove day from active list
* Move day menu up
* Move day menu down

* Create list of all groceries for some active list



# Structure of the GUI

"Main window" is a bad control name. It does not describe the purpose of it.

Probably we need to first specify functions, which we want to implement
and correspondingly relations between those functions.

Functionality:
* manage foodstuffs - separate window. Invoked with the button.
* manage individual day-menus (it's content - foodstuffs and quanities)
* manage list of day-menus - CRUD operations
* manage lit of selected day-menus - those are references to existing day-menus.

We could organize the GUI like this:

* Day Menu Manager - root element - main purpose: managing day menus. It connects it's subcomponents
  * All day-menus list: provides CRUD operatoins and selection
  * Active day-menus: provides operations to manage list and selection
  * Only one of "all day-menus" and "active day-menus" may have selection
  * Day-menu details list (list of foodstuffs of day-menu). It shows details for selected day-menu - either from "all" or from "active"
  * Button to add reference to day-menu into active-day menus (it is not part of "active day menus", because it relates also to the second list)
  * Button to start management of foodstuffs.

Now the complicated part is: to understand the boundaries of view, view-controller and controller...

In fact, also the boundary between "presentation" and "logic" is not that trivial.
If the "presentation" is the function of the application, then where should the
logic belong, which prepares this presentation?..

Which signals may come from the elements of day-menu-manager:
* all-day-menus: selection changed       <- does not change model, only the view
* active-day-menus: selection changed    <- does not change model, only the view
* day-menu-details: no signals
* add-active-day-menu-button: triggered  <- DOES change model!
* manage-foodstuffs-button: triggered    <- starts new gui (i.e. does not directly change model)

What changes can we do on the views:
* all-day-menus: none
* active-day-menus: add element (with button). ? Is it done via changing model and refresh, or via it's controller?
* day-menu-details: set current day-menu - does not change the persistent model, but it kind of changes the state of the aplication (here we have this blurry boundary between presentation and business logic).
* add-active-day-menu-button: activate/deactivate (depending on selection) - no changes to model
* manage-foodstuff-button: none

It looks like the question with ownership and circular references in views and
controllers goes further. Assumming, that views and view-controllers are not allowed
to change the model, then we naturally need controllers, which would do it.

but now the question is: on which "layer" should be create the hierarchy of ownership,
and classes of which "layers" will just "hang" on it? For example, will the views form
a hierarchy of ownership (so that main window has it's pane etc) and then each view
will have a reference to the corresponding controller? Or will it be other way around.

In fact, since we decided, that the controllers and views may have circular references,
this question is not really so important... but technically it is probably easier, if
we create structure of views, because we anyway need to maintain this structure from
graphical point of view.



