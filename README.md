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
5.  The player can roll as many times as they want, but as soon as their total score equals or exceeds 23 then the game is over.

# Getting the Game

Clone this repository using git. Open a terminal console and navigate to the
root of the repository.

# Running the Game

Running the tests requires Java JDK 7 or higher to be installed and available
on your `PATH`.

## Linux

### CLI Version

```bash
./gradlew :cli:run
```

### Swing GUI Version

```bash
./gradlew :gui:run
```

## Windows

### CLI Version

```
gradle.bat :cli:run
```

### Swing GUI Version
```
gradle.bat :gui:run
```

# Running the Tests

Running the tests requires Java JDK 7 or higher to be installed and available
on your `PATH`.

## Linux

```bash
./gradlew check 
```
## Windows

```
gradlew.bat check
```
