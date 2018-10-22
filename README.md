# Flickr-Search.
This App shows trending photos from flickr and User can search with tag.

# Project Architecture - MVVM

# What is MVVM?
There are 3 parts to the Model-View-ViewModel architecture:

**Model** is the data layer of your app. It abstracts the data source.

**View** contains the UI of your app. Most often it’s implemented as an Activity or Fragment. View informs ViewModel of user interactions and displays results received from the ViewModel. View should be lightweight and contain zero to very little business logic.

**ViewModel** serves as a bridge between your View and Model. It works with the Model to get and save the data. The View observes and reacts to the data changes exposed by the ViewModel.

Here is a typical high level MVVM app architecture:

![Alt text](https://cdn-images-1.medium.com/max/800/1*tO9RsrblUPOv_u0loUM97g.png)
