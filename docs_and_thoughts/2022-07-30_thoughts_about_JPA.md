# Thoughts about JPA

One of the central concepts of JPA is "persistence context". Persistence
context is responsible to track correspondence of "managed entity objects"
to the rows of corresponding tables in the DB. Theoretically updates to
the objects via Java should be automatically synced to the DB (in fact
it is probably not that simple).

For more information about persistence context search in internet the term
"JPA entity lifecycle". One example of good description by Baeldung: 
[https://www.baeldung.com/hibernate-entity-lifecycle](https://www.baeldung.com/hibernate-entity-lifecycle).

This approach has the biggest benefit, if your persistence context is the only
thing, which updates the DB and at the same time, if you directly work with
the managed objects all across your application (directly use them in the
model of the GUI etc.). In this case you quasi don't need to care about
synchronisation of your objects to the DB. It will happen by magic. You
only need to create objects via JPA, so that you get managed objects.

TODO: It would be interesting to implement GUI, which works directly with
managed JPA objects and see, if it really reduces efforts for handling
persistence of the objects.

Now, the thing is, that usually the situation described above is not the case.
Instead, usually you get the objects (values of the fields) from the DB and
then copy them to some unmanaged objects via some mapper and then work
with unmanaged objects. This would be not bad on its own, but it gets worse,
when your application changes the object. Then usually the application
somehow records the changes applied to the object (e.g. it just changes
the values of the fields ot the object) and then you want to apply those
changes to the persisted data.

There are different ways to do it internally, for example you could just
change the field values of the entity object, or you could collect the
changes into "changes" object, or you could trigger update of the DB every
time the field of an entity (as part of the application state in memory)
is being updated. And here is why you need to think
about the design of your internal api in advance: if you want to do it via
managed objects, then JPA provides not so many ways to do it. An alternative
would be not to use entity objects for updates but instead use explicit
queries for updates (is it even JPA compatible, or is it hibernate specific?).

Let's consider the first approach, where we want to use managed objects to
update some data in the DB.

The change comes from the unmanaged objects, so you need to get the managed
one. For this one could use
* `EntityManager.merge()` method with "unmanaged" entity having the new state.
* Use `EntityManager.find()` to get the managed entity and then set changed
  fields on it.
* Like previous option, but the fields are updated using explicit query.

...

This topic is actually discussed in this StackOverflow question 
[https://stackoverflow.com/q/7434115/1014479](https://stackoverflow.com/q/7434115/1014479)
and answer
[https://stackoverflow.com/a/7453809/1014479](https://stackoverflow.com/a/7453809/1014479):

To summarise: there are two approaches: 
* first you always work with non-managed
  entities and for update just "merge" changed state.
* or you work with managed entities, change the state of entities using
  setters and then use "commit".

Both approaches are more or less equivalent. But there are some notes:
* In Web-Apps EntityManager is usually injected as an object, which
  lives one transaction long, so it anyway does not know anything
  about any entities from other transactions, thus it does not make
  sense (or is impossible) to work with managed entities.
* Thus, the most common pattern to see is, that changes are done on
  detached (or transient) entities and then "merged" into the persisted
  state.
* When one wants to use managed entities, one need "long living"
  EntityManager, but in this case one needs to be sure, that it is not
  thread safe.
