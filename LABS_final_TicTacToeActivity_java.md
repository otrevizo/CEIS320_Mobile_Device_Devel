# LAB2_TicTacToeActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.ceis320;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends AppCompatActivity implements OnClickListener{
    private Button gameGrid[][] = new Button[3][3]; // 2D array of buttons for the tic-tac-toe grid
    private Button newGameButton; // Button to start a new game
    private TextView messageTextView; // TextView to display game messages

    private int turn; // Keeps track of whose turn it is
    private String message; // Message to display to the user
    private boolean gameOver; // Flag to check if the game is over
    private String gameString; // Represents the state of the game

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        // Get references to widgets
        gameGrid[0][0] = (Button) findViewById(R.id.square1);
        gameGrid[0][1] = (Button) findViewById(R.id.square2);
        gameGrid[0][2] = (Button) findViewById(R.id.square3);
        gameGrid[1][0] = (Button) findViewById(R.id.square4);
        gameGrid[1][1] = (Button) findViewById(R.id.square5);
        gameGrid[1][2] = (Button) findViewById(R.id.square6);
        gameGrid[2][0] = (Button) findViewById(R.id.square7);
        gameGrid[2][1] = (Button) findViewById(R.id.square8);
        gameGrid[2][2] = (Button) findViewById(R.id.square9);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        // Set event handlers for game grid buttons
        for (int x = 0; x < gameGrid.length; x++) {
            for (int y = 0; y < gameGrid[x].length; y++) {
                gameGrid[x][y].setOnClickListener(this);
            }
        }

        // Set event handler for new game button
        newGameButton.setOnClickListener(this);

        // Clear grid and set starting values
        for (int x = 0; x < gameGrid.length; x++) {
            for (int y = 0; y < gameGrid[x].length; y++) {
                gameGrid[x][y].setText(" "); // Use a space for each square
            }
        }

        // Initialize game state
        turn = 1;
        gameOver = false;
        message = "Player X's turn";
        messageTextView.setText(message);
        gameString = "         "; // 9 spaces (one for each square)
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newGameButton:
                // Clear grid and reset game state
                for (int x = 0; x < gameGrid.length; x++) {
                    for (int y = 0; y < gameGrid[x].length; y++) {
                        gameGrid[x][y].setText(" "); // Use a space for each square
                    }
                }
                // Reset starting values
                turn = 1;
                gameOver = false;
                message = "Player X's turn";
                messageTextView.setText(message);
                gameString = "         "; // 9 spaces (one for each square)
                break;
            default:
                if (!gameOver) {
                    Button b = (Button) v;

                    if (b.getText().equals(" ")) {
                        if (turn % 2 != 0) {
                            b.setText("X");
                            message = "Player O's turn";
                        } else {
                            b.setText("O");
                            message = "Player X's turn";
                        }

                        turn++;
                        checkForGameOver();
                    } else {
                        message = "That square is taken. Try again.";
                    }
                }
                messageTextView.setText(message);
        }
    }

    private void checkForGameOver() {
        // Check for a match in rows
        for (int x = 0; x < 3; x++) {
            if (!gameGrid[x][0].getText().equals(" ") &&
                    gameGrid[x][0].getText().equals(gameGrid[x][1].getText()) &&
                    gameGrid[x][1].getText().equals(gameGrid[x][2].getText())) {
                message = gameGrid[x][0].getText() + " wins!";
                gameOver = true;
                return;
            }
        }

        // Check for a match in columns
        for (int y = 0; y < 3; y++) {
            if (!gameGrid[0][y].getText().equals(" ") &&
                    gameGrid[0][y].getText().equals(gameGrid[1][y].getText()) &&
                    gameGrid[1][y].getText().equals(gameGrid[2][y].getText())) {
                message = gameGrid[0][y].getText() + " wins!";
                gameOver = true;
                return;
            }
        }

        // Check for a match in diagonals
        if (!gameGrid[0][0].getText().equals(" ") &&
                gameGrid[0][0].getText().equals(gameGrid[1][1].getText()) &&
                gameGrid[1][1].getText().equals(gameGrid[2][2].getText())) {
            message = gameGrid[0][0].getText() + " wins!";
            gameOver = true;
            return;
        }

        if (!gameGrid[2][0].getText().equals(" ") &&
                gameGrid[2][0].getText().equals(gameGrid[1][1].getText()) &&
                gameGrid[1][1].getText().equals(gameGrid[0][2].getText())) {
            message = gameGrid[2][0].getText() + " wins!";
            gameOver = true;
            return;
        }

        // Check for a tie
        if (turn > 9) {
            message = "It's a tie!";
            gameOver = true;
            return;
        }

        gameOver = false;
    }
}
```
## Detailed Comments Explanation

### Imports:
The import statements bring in necessary classes from the Android SDK and AndroidX libraries. These include:

- `AppCompatActivity` for the activity class.
- `Intent` for starting new activities.
- `Bundle` for saving the state.
- `View` for UI interactions.
- `Button` for the button component.
- `TextView` for displaying text.

### Class Declaration:
`TicTacToeActivity` extends `AppCompatActivity` to inherit functionality for an Android activity. It implements `OnClickListener` to handle click events.

### onCreate Method:
`onCreate` is called when the activity is created. It initializes the activity.

- `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
- `setContentView(R.layout.activity_tic_tac_toe)` sets the user interface layout for this activity.

#### Widget References:
Each button and text view is initialized:

- `gameGrid` is a 2D array of `Button` representing the tic-tac-toe grid.
- `newGameButton` is the button to start a new game.
- `messageTextView` displays game messages.

#### Event Handlers:
Event handlers are set up for all game grid buttons and the new game button:

- `gameGrid[x][y].setOnClickListener(this)` sets the current instance as the click listener for each button in the grid.
- `newGameButton.setOnClickListener(this)` sets the current instance as the click listener for the new game button.

#### Game Initialization:
The grid is cleared and starting values are set:

- `gameGrid[x][y].setText(" ")` clears each button in the grid.
- Initial game state values are set: `turn = 1`, `gameOver = false`, `message = "Player X's turn"`, and `gameString = "         "`.

### onClick Method:
`onClick` handles click events for the buttons:

- For the new game button, the grid is cleared and starting values are reset.
- For grid buttons, the clicked button is updated with "X" or "O" based on the current turn, and `checkForGameOver` is called to check the game status.

### checkForGameOver Method:
`checkForGameOver` checks if the game is over:

- It checks for matching rows, columns, and diagonals.
- If a match is found, a win message is displayed, and `gameOver` is set to `true`.
- If the grid is full without a winner, a tie message is displayed, and `gameOver` is set to `true`.

### Summary:
This code sets up an Android activity for a tic-tac-toe game. It initializes the game grid, handles user interactions, and checks for game completion. When a user clicks a button, the grid is updated, and the game status is checked. If a player wins or the game is a tie, a message
