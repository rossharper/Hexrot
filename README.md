# Hexrot

An hexagonal Android experiment. In progress. Playing with some ideas. They may be terrible.

Warning: hacks are abundant.

There are zero unit tests, mainly because this is a hacking playground for trying out some ideas.
I should write some really.

TODO:

- continue list abstraction (CollectionView) refactor to RecyclerView
- UNIT TEST MORE OF THIS!
- use pull down swipe refresh list

- look into better thread handling

- what about rotation - does my method of creating fragments introduce configuration change problems?

- list load spinner
- better error message
- network timeout

- stats reporting for user clicks to display rendered
- crash reporting

- Reintroduce the View and Presenter interfaces to the SodaList (wrapping/marshalling between the model and CollectionView)
- Create WEAR and TV UIs to demonstrate reusability of presenters with different views

LOOK AT
android data binding (can handle the main thread marshalling for me?)
agera
Dagger for Fragment/Activity dependency injection
