# LAB2_SongActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.ceis320;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class SongActivity extends AppCompatActivity {
    private VideoView vidView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        // Initialize the VideoView
        vidView = (VideoView) findViewById(R.id.vidView);

        // Add media controller to the VideoView
        vidView.setMediaController(new MediaController(this)); 

        // Set the video URI to a video resource in the raw folder
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.songname;
        vidView.setVideoURI(video);

        // Ensure the video is displayed on top of other widgets
        vidView.setZOrderOnTop(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start the video playback when the activity is resumed
        vidView.start();
    }

    @Override
    protected void onPause() {
        // Stop video playback when the activity is paused
        vidView.stopPlayback();
        super.onPause();
    }
}
```
## SongActivity.java Detailed Explanation

### Imports:
The import statements bring in necessary classes from the Android SDK and AndroidX libraries. These include:

- `AppCompatActivity` for the activity class.
- `Uri` for handling URIs.
- `Bundle` for saving the state.
- `MediaController` for media playback controls.
- `VideoView` for video playback.

### Class Declaration:
`SongActivity` extends `AppCompatActivity` to inherit functionality for an Android activity.

### Variables:
- `private VideoView vidView = null;`: Declares a `VideoView` to play the video.

### onCreate Method:
`onCreate` is called when the activity is created. It initializes the activity.

- `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
- `setContentView(R.layout.activity_song)` sets the user interface layout for this activity.

#### Initialize VideoView:
- `vidView = (VideoView) findViewById(R.id.vidView)`: Initializes the `VideoView` by finding it in the layout.

#### Add Media Controller:
- `vidView.setMediaController(new MediaController(this))`: Adds a media controller to the `VideoView` to provide playback controls like play, pause, forward, and rewind.

#### Set Video URI:
- `Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.songname)`: Creates a `Uri` for the video resource located in the raw folder.
- `vidView.setVideoURI(video)`: Sets the `Uri` of the video to be played by the `VideoView`.

#### Z Order:
- `vidView.setZOrderOnTop(true)`: Ensures the video is displayed on top of other widgets, preventing it from being merged with other UI elements.

### onResume Method:
`onResume` is called when the activity is resumed.

- `super.onResume()`: Calls the superclass's method to perform default setup.
- `vidView.start()`: Starts video playback when the activity is resumed.

### onPause Method:
`onPause` is called when the activity is paused.

- `vidView.stopPlayback()`: Stops video playback when the activity is paused.
- `super.onPause()`: Calls the superclass's method to perform default setup.

### Summary:
This code sets up an Android activity to play a video using a `VideoView`. It initializes the `VideoView`, sets a media controller for playback controls, and plays a video from the raw resources. The video playback starts when the activity is resumed and stops when the activity is paused.
