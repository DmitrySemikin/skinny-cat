# 2022-06-09, 19-32

I don't remember, what I was doing last. It was quite some time ago.
Partly this is the reason, why I decided to start this log. Hopefully
when I next open this project after couple of months not seeing it,
I will be able to remember, what I was doing and what I was thinking
about last time.

I still remember, that there were two topics, which were bothering me
last time I did the development.

1. Problem of mutual ownership of GUI view and view-controller. See
   below

2. Understanding principles of work of JPA/Hibernate and what attached
   and detached entities mean and how this all should be used.

In the latest time I developed some ideas and/or understanding regarding
both topics and correspondingly some ideas about how to approach the
further development of skinny cat.



# 2022-06-10, 21-27

Create in this repo subdirectory /docs_and_thoughts/ and create there
new document about the point "1" above: 
[2022-06-10_controller_and_view_ownership.md](./docs_and_thoughts/2022-06-10_controller_and_view_ownership.md).

Write some version of this document.

Update TODO.

I need to specify the relations between GUI elements of the main window.
It is not easy to do without using diagrams, but I want to avoid using
pictures in these markdown documents. So, let's first try to do it in text.
I will do it in [README.md]()

Trying to describe the structure of the gui and think about, how the components
needs to be connected. What will call the modifications on components: controller
or view-controller? Or call "update" on sub-components after model is updated?
Controller does the update... but view-controller has needed refrence...
still something to think about.



# 2022-06-16, 19-35

Continue to develop my thoughts about the GUI layers:
[2022-06-10_controller_and_view_ownership.md](./docs_and_thoughts/2022-06-10_controller_and_view_ownership.md).

More or less completed, what I wanted to write there. Now I'd like to rewrite
the swing-gui, which I have using those concepts (in fact I would prefer to
get rid of swing and switch to JavaFX, but for the completeness of this experiment
I will stick to swing).

So I start to do the changes. It will break a lot, but I'd like to concentrate
first on the GUI and for now disconnect it from the persistency-controllers.
This will make for a while the applicaiton non-functional, but I will try to
keep it buildable at least.



# 2022-06-17, 20-13

Last time I did not start to implement the changes, so I a looking into it now...

Trying to draw a class diagram for all layers. Diagrams are stored online
on [https://online.visual-paradigm.com]() .



# 2022-07-25, 17-20

Start trying to implement the ideas abou those layers and ownership...



# 2022-07-27, 21-34

Continue implementation. First try to implement views and view controllers.


# TODO:

- describe my thought about the using JPA in "thoughts" directory in separate document.
- redesign GUI according to my thoughts about it.
  - Make it use circular references
  - Make sure, that I cleanly separate view and view controller.
- do changes in controllers to apply my thoughts about JPA. Think about trying to 
  implement GUI version, where I directly use JPA entities.

