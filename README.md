# Three to 23

[![Join the chat at https://gitter.im/anderspitman/dice-game](https://badges.gitter.im/anderspitman/dice-game.svg)](https://gitter.im/anderspitman/dice-game?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/anderspitman/dice-game.svg?branch=master)](https://travis-ci.org/anderspitman/dice-game)

A simple dice game inspired by Blackjack.

# Goal of the game
The goal of the game is to accumulate exactly 23 points, or get as close as you can without going over, by rolling 1-3 dice. Your initial roll will be used with three dice. After your first roll, you will have the choice to use 1, 2, or 3 dice to increase your overall total and achieve the goal of 23 points.

# Rules of the Game
1.  The player must enter three letters, generally initials, for their game name.
2.  The player must roll the initial 3 dice and add three die faces to get a total.
- For example, if you roll a 5, 6, and 3, your total will be 14.
3.  The player will have the option to stop there and record their score or they can roll again to increase their total.
4.  If the player rolls again, they have the option to use 1, 2, or 3 dice.
- Remember that you do no want to exceed 23 points.

# Testing
[Install Gradle](https://docs.gradle.org/current/userguide/installation.html),
then run

```bash
gradle test
```

From the `dice-game` directory.