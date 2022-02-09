# Skinny Cat #

* Unit: day menu
  * Title (text, unique, mandatory)
  * Menu name (text, opt)
  * Menu week (opt)
  * Menu day (opt)
  * Dishes (free text, opt)
  * Groceries list (reference to separate table)
  * (advanced) Scan of the page

* Groceries
  * Name
  * Quantity Unit

* Groceries list
  * Grocery ref
  * Quantity

* Active list
  * List ID
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