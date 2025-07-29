**Dream Labyrinth** is a 2D arcade shooter built in JavaFX for a university project. 

## Features

- **Two Game Modes**: Story (level-based) and Labyrinth (endless)
- **Custom Game Loop**: Powered by `AnimationTimer`
- **Pause/Resume** and Game Over handling
- **Local High Score System** with top 10 leaderboard
- **Dynamic Backgrounds** and layered sprite animation

## Requirements

- **Java 8+**
- **JavaFX** (included in Java 8, separate install for Java 11+)
- IDE like IntelliJ or Eclipse recommended

## Project Structure

- `application/` — Main class, scene handling, UI
- `Player/`, `Enemy/` — Game entities
- `Assets/` — Images and sprites
- `highscore.txt` — Local leaderboard

## Notes

- Make sure `Assets/` folder is in the correct path
- Scores saved to `highscore.txt` in the working directory

---

**License**: Private/Academic use only. 


Authors: Alec Lunn, Brandon Arenas, Jasmine Roebuck, Quinton Masters
