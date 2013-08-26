--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- Name: adventure_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adventure
--

SELECT pg_catalog.setval('adventure_id_seq', 1, true);


--
-- Name: scene_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adventure
--

SELECT pg_catalog.setval('scene_id_seq', 6, true);


--
-- Name: scene_nav_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adventure
--

SELECT pg_catalog.setval('scene_nav_id_seq', 6, true);


--
-- Data for Name: adventure; Type: TABLE DATA; Schema: public; Owner: adventure
--

COPY adventure (id, title, details, author, salt, password, created_on, starting_scene_id) FROM stdin;
1	Cube Dweller	In this story, you are a CRUD programmer who has the opportunity to learn something new that will stretch your brain.	MJ	salt	pass	2013-08-11 18:31:24.150251	1
\.


--
-- Data for Name: lobos_migrations; Type: TABLE DATA; Schema: public; Owner: adventure
--

COPY lobos_migrations (name) FROM stdin;
add-adventure-table
add-scene-table
add-scene-nav-table
add-adventure-starting-scene
\.


--
-- Data for Name: scene; Type: TABLE DATA; Schema: public; Owner: adventure
--

COPY scene (id, adventure_id, title, body) FROM stdin;
1	1	The Cubicle	You are sitting in a cubicle.  On your monitor is a stack trace that was triggered by a third-party library you used on your latest project.  You thought using the library would save you development time, but it's been problematic.  You've just pieced together the undocumented way the library is supposed to work after pouring through a maze of xml config files.\r\rThe gray cube walls are doing a horrible job of filtering out the noise around you.  A salesman talking loudly on his cellphone has left his office and wandered into the cube farm.  A nearby printer has run out of paper and is beeping.  The owner of the document being printed is nowhere to be found.  A conference call is in progress by multiple members of your organization who all have their speaker phones turned on and their office doors open.  It's too much for you--the multiple pieces of information you were holding in your head to solve the problem vanish.  You'll have to mentally retrace your steps and try again.\r\rYour monitor flashes.  An IM window pops up from one of your friends.
2	1	The Message	You open the IM.  It reads:\r\r> I know you like learning programming languages.  You have to watch this video--it's a talk from the guy who created a programming language called "Clojure".\r\rThere is a link to the video.
3	1	Back to the Problem	You ignore it.  An employee walks over to the beeping printer and wonders aloud why his spreadsheet isn't printing.  After several sighs and grumblings just loud enough for you to hear, he looks over at you.  \r\r"Uhhh....hey, " he starts.  You don't need to hear the rest.
5	1	Clojure	You decide to investigate the language.  It's very different from the other languages you know.  You build a few toy projects in it, and they take longer than usual to finish.  Several times you want to give up on Clojure because you know that you could quickly complete these projects if you used something more _familiar_.  \r\rYou persist.  You find [some](https://leanpub.com/fp-oo) [good](http://www.clojurebook.com) [books](http://joyofclojure.com) and read them.  Your understanding of functional programming grows.  You notice that your toy projects using Clojure now take less time to implement than when using other languages you know better.  They are also smaller.  Even the programs you write at work change a little--you find yourself introducing functional solutions.  You become aware that these parts of your code require less testing and are easier to change later.\r\rYou find a smart, creative [community](http://planet.clojure.in) of Clojure programmers that are doing [some](http://www.datomic.com) [really](https://github.com/clojure/clojurescript) [cool](https://github.com/clojure/core.async) [things](http://pedestal.io) with the language.\r\rYou get excited about the possibilities you might help create...
6	1	Back to the Problem	You get back to work.  Clojure may not be for you (yet), but you can't help but remember a few of the things in the talk.  You begin to wonder if you really needed that problematic library in the first place.  Maybe there is a simpler way...
4	1	The Video	You watch the [video](http://www.infoq.com/presentations/Simple-Made-Easy).  It is from a talk titled "Simple Made Easy" by Rich Hickey, the author of the Clojure programming language.  In the video, Hickey advocates for the creation of simple systems by not intertwining (or "complecting") components so that they can be reasoned about and understood individually.  He warns against using solutions that seem easy:  easy being near at hand (quickly installing/integrating libraries into your system), or familiar and how easy can be deceptive in that it gets you up and running fast, yet may introduce complexity down the road.\r\rHickey argues that many things we find easy braid or complect things:  state, methods, syntax, inheritence, variables, ORMs, etc.  Using these constructs introduce incidental complexity in that you must spend extra time reasoning and dealing with the constructs in addition to addressing the problem.  He believes that there are alternative tools that enable simplicity by stripping away management of the easy constructs:  values, functions, namespaces, data, managed refs, declarative data manipulation, etc.  \r\rThere's a lot more information in the video to take in.  It challenges some of your thoughts on programming.  You wonder what the Clojure programming language is like.
\.


--
-- Data for Name: scene_nav; Type: TABLE DATA; Schema: public; Owner: adventure
--

COPY scene_nav (id, scene_id, next_scene_id, title) FROM stdin;
1	1	2	Read the message
2	1	3	Dismiss the message
3	2	4	Click the link
4	2	3	Dismiss the message
5	4	5	You check out Clojure
6	4	6	You go back to your problem
\.


--
-- PostgreSQL database dump complete
--

