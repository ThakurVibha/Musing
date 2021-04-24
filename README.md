# Musing
<p align="center">  

Musing is a Full-featured "Meditation application" which is in progress as I am working on the same.
I have included different functionalities such as Splashscreen, UserprofileScreen, login, Signup, Firebase Google Signup, onboarding screen, Fragments and many more.
I have used three fragments for different purpose as i have included favourite fragments for a favourite meditation session and Music fragments for soothing and calming music sessions.

I have used handler class with seek bar implementation to play meditation audios.
For user authentication and to save data I have used Firebase as a backend.

I am working on the current version of application so that i can publish application on playstore as soon as possible.

<br></p>  
# Tech stack & Open-source libraries
- Minimum SDK level 23
- Single activity Appication using [Navigation Component](https://developer.android.com/guide/navigation) to navigate between fragments
- 100% [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- JetPack
  - LiveData - Notify Domain Layer data to views.
  - LifeCycle - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct a database using the abstract layer.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - [Bindables](https://github.com/skydoves/bindables) - Android DataBinding kit for notifying data changes to UI layers.
  - Repository pattern
  - 
- [Lottie Animation](https://github.com/airbnb/lottie-android) -  Mobile library for Android that parses Adobe After Effects animations.
- [Custom google signin button](https://github.com/shobhitpuri/custom-google-signin-button) - A custom SignInButton for Android that supports 'android:text' attribute.
- [Onboarding screen](https://github.com/Ramotion/paper-onboarding-android) - Android library Paper Onboarding is a material design UI slider written on Java.
- [Glide](https://github.com/bumptech/glide) - For Loading Images
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like Navigation drawer etc.
- [Motion Layout](https://developer.android.com/training/constraint-layout/motionlayout) - To implement motions in Readings Screens


