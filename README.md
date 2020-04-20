# CSE237 - My Friend Dragon#
By: Julia Smith, Katrina Ragbeer, Matthew Alexander, and Shahd Alyasiry

# How to Run From Command Line#
From the project repository directory, type the following into the command line:

```
./gradlew build
./gradlew run
```

To run the base dragon tamagotchi-like game from iteration 1, go to the file build.grade > line 51 > set main class name to game.Game

## Iteration 1 ##
During this iteration, we completed 6 stories. These stories included a functional UI of our game with a bit of backend support.
This included modification of the dragon's needs when it is fed or pet, aging-up the dragon when it's needs are fully met, and 
including animations for when the dragon is interacted with. We also wrote tests for the functionality that we added and cleaned
up our code per the Clean Code guidelines.

For the next iteration, we plan to have visible food and love meters so the user knows how much more the dragon needs. We also
intend to begin coding the minigames that reward the user with food to feed the dragon. The minigames should give the user a 
score, and the user is awarded an amount of food based on the score they received. We also want the user to be able to see how 
much food they have accumulated. Finally, we want to have some sort of visual indication that the dragon has reached its final
form (an animation).

Currently, everything that we have implemented works as intended. The only thing that doesn't work is the minigame tab, but we
plan to implement that during iteration 2.

## Iteration 2 ##
In order to see what we accomplished in this iteration, run the Gameboard.java file located in src/SpaceInvaders/ as a Java
Application.

###How to Play###

You can move the dragon side to side with the A and D keys and shoot with the X key.

###Completed Stories###

The main focus of this iteration was the Space Invaders minigame. Our goal was to create a functional game with both UI and
backend support. Currently, the game is fully functional save for two bugs that we intend to correct in the next
iteration. The issue is that the invader bullets are not shot at exactly 20ms apart. We believe that this is because
the UI is redrawing every few milliseconds, and will look into making the shots more precise in the next iteration. There may also be a problem with the hit detection that will cause shots that graze the edge of the dragon's wings to miss--again, something to be corrected in the next iteration.

Otherwise, we implemented the game so that the player can move the dragon, shoot at the invaders, and be shot by the invaders.
Internally, the invader is losing health each time it is shot, but we have yet to implement the health and scoring visuals on
the UI. Additionally, there is no winning condition in the game, so that will also be handled in iteration 3.

For the next iteration, in addition to correcting the preidentified bugs, we plan to integrate the Space Invaders game with
our full game. To do this, we will create a menu that is visible from the main screen. From there, the user can select the 
game they would like to play. We also plan to implement the Dragon Pong game and fully integrate that with the full project.

