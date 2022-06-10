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



# TODO:

- describe my thought about the using JPA in "thoughts" directory in separate document.
- redesign GUI according to my thoughts about it.
  - Make it use circular references
  - Make sure, that I cleanly separate view and view controller.
- do changes in controllers to apply my thoughts about JPA. Think about trying to 
  implement GUI version, where I directly use JPA entities.

