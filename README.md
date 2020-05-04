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

### How to Play 

You can move the dragon side to side with the A and D keys and shoot with the X key. Note that the game does not yet take continuous keyboard input, so you will have to continually tap the keys.

### Completed Stories

The main focus of this iteration was the Space Invaders minigame. Our goal was to create a functional game with both UI and
backend support. Currently, the game is fully functional save for a couple that we intend to correct in the next
iteration. 

Otherwise, we implemented the game so that the player can move the dragon, shoot at the invaders, and be shot by the invaders.
Internally, the invader is losing health each time it is shot, but we have yet to implement the health and scoring visuals on
the UI. Additionally, there is no winning condition in the game, so that will also be handled in iteration 3.

### Bugs
1) The issue is that the invader bullets are not shot at exactly 20ms apart. We believe that this is because
the UI is redrawing every few milliseconds, and will look into making the shots more precise in the next iteration.

2) There may also be a problem with the hit detection that will cause shots that graze the edge of the dragon's wings to miss--again, something to be corrected in the next iteration.

3) If the player successfully destroys all invaders, the game will crash. This is caused by the game trying to tell the space invaders to shoot a bullet, but there are no space invaders to shoot the bullet. This will be corrected by a gameOver() method in the next iteration.

4) If the player scoots all the way to the edge of the screen, the game may stop updating. This is likely caused by the fact that if checking the boundaries returns false, the game will not update. This will be fixed in the next iteration.

5) One test player reported that the game intermittently stopped taking keyboard input for seemingly no common circumstance. While none of us experienced this issue ourselves, you may experience it. We will be fixing it next iteration.

### Next Iteration ###

For the next iteration, in addition to correcting the preidentified bugs, 
1) We plan to integrate the Space Invaders game with our full game. To do this, we will create a menu that is visible from the main screen. From there, the user can select the game they would like to play. 

2) We also plan to implement the Dragon Pong game and fully integrate that with the full project.

3) We plan to add UI elements to the Space Invaders game that will display the health of the player and explosion animations for the spries.

4) We plan to implement a Space Invaders game over that will display scoring information and ask the user if they wish to play again.

5) We plan to implement minor UI improvements to the base game, including a food and love bar and an intermediate animation when the dragon evolves to the next state of life.

6) We plan to implement continuous keyboard input so that the player does not have to keep tapping keys over and over again in Space Invaders.

## Iteration 3 ##

### Implemented stories: ###
--Implemented menu manager so game now follows a design pattern and can exchange between screens. Dragon now has food tracking and established food and love state.

--Implemented QOL improvements, so space invader now takes continuous input and dragon has health and love bars. Space Invaders game now has shoot debouncer.

--Implemented pong (more similar to table tennis, frankly) minigame.

### Dragon Main Section How To Play ###
Pet your dragon and play minigames with it to earn food. Feed it and love it and watch it grow!

#### Dragon Main Section Known Bugs ####

--Upon clicking the minigame menu, the egg/dragon will disappear for a second before rendering the new menu. We like to think of it as the dragon leaving with you to play.

--Upon feeding your dragon your last piece of food, only half of the eating animation may only play.

--Upon reaching the game over state, the dragon will disappear for a moment before rendering the game over menu.


### Invaders How To Play ###

Press the left and right arrow keys to move. Press x to shoot bullets.

#### Invaders Known Bugs ####

-The animation for the player being damaged may fail to play. No one can figure out what causes this.

-The player (might?) be able to score double points while hitting the space invader during its explosion animation.

-The game takes a moment to switch from the end of game state to the game menu, creating a blank scene for a second or so.

### Pong (more like table tennis) How To Play ###
You can choose between one and two player:

One player: Press the w and s keys to move your racket up or down.

Two Player: Player One presses w and s keys, while Player Two uses p and l keys.

#### Pong Known Bugs ####

-Some test players have reported a rare bug in which the ball used to make the AI prediction oscillates forever between two values, crashing the game.

-Some test players have reported a bug in which the ball gets stuck between the backside of the racket and the wall, causing the unforunate other player to lose.


### Where To Go From Here ###

-Fix minor animation issues with switching in between menus.

-Add tetris-like or candy-crush like game.

-Switch minigames to dedicated Java game library/framework to improve performance and physics.

-Add more advanced physics to the pong game.

-Improve animations to be more expressive and respond more lively-like.






