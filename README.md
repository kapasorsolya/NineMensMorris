# NineMensMorris

## Description

Nine Men’s Morris is a two-player strategy board game. The game has three clearly delimited phases:

- Phase 1: Placing pieces
Players alternatively place their pieces on the board. If a player closes a morris (or mill), she will grab one of her opponent’s piece. Strategically placing the pieces is more important than closing a morris in this phase.

- Phase 2: Moving pieces
Players alternatively move their pieces one at a time to an adjacent empty point, close morrises and grab pieces.

- Phase 3: Flying pieces
A player reaches phase 3 when she is left with only 3 pieces. She can now move any of her piece to any empty point on the board.
A player wins by reducing her opponent to two pieces, or by leaving her without a legal move.

### Heuristic/Evaluation Function for Nine Men’s Morris
<p align="center">
  <img src="https://kartikkukreja.files.wordpress.com/2014/03/nine_mens_morris_board.png">
  <p align="center">Nine Men's Morris board</p>
</p>

I wrote a bot for Nine Men’s Morris for a contest and here, I describe the evaluation functions I used for each of the three phases. The evaluation functions were linear functions of features of the game state. Following features were considered to calculate the evaluation functions:

1. Morris: 1 if a morris was closed in the last move by the player (and an opponent’s piece should be grabbed in this move), -1 if a morris was closed by the opponent in the last move, 0 otherwise

<p align="center">
  <img src="https://kartikkukreja.files.wordpress.com/2014/03/closed_morris.jpg">
  <p align="center">Closed Morris</p>
</p>

2.Number of Morrises: Difference between the number of yours and yours opponent’s morrises

3.Number of blocked opponent pieces: Difference between the number of yours opponent’s and yours blocked pieces (pieces which don’t have an empty adjacent point)

<p align="center">
  <img src="https://kartikkukreja.files.wordpress.com/2014/03/blocked_piece.jpg">
  <p align="center">Blocked Piece</p>
</p>

4.Number of pieces: Difference between the number of yours and yours opponent’s pieces

5.Number of 2 piece configurations: Difference between the number of yours and yours opponent’s 2 piece configurations (A 2-piece configuration is one to which adding one more piece would close a morris)


<p align="center">
  <img src="https://kartikkukreja.files.wordpress.com/2014/03/2_piece.jpg">
  <p align="center">2 piece-configuration</p>
</p>

6.Number of 3-piece configurations: Difference between the number of yours and yours opponent’s 3 piece configurations (A 3-piece configuration is one to which a piece can be added in which one of two ways to close a morris)


<p align="center">
  <img src="https://kartikkukreja.files.wordpress.com/2014/03/3_piece.jpg">
  <p align="center">3 piece-configuration</p>
</p>

7.Double morris: Difference between number of yours and yours opponent’s double morrises (A double morris is one in which two morrises share a common piece)


<p align="center">
  <img src="https://kartikkukreja.files.wordpress.com/2014/03/double_morris.jpg">
  <p align="center">Double Morris</p>
</p>


8.Winning configuration: 1 if the state is winning for the player, -1 if losing, 0 otherwise
For the particular contest settings (elimination with the player having more pieces winning if neither side could force a win so there was a strong aversion to sacrificing material) and bot settings (depth limited to 8 and branching factor limited to 20; at each step, top 20 moves sorted by the evaluation function were selected), I found the following feature combinations to work well (‘(1)’ represents the first feature: Closed Morris and so on):

Evaluation function for Phase 1 = 18 * (1) + 26 * (2) + 1 * (3) + 9 * (4) + 10 * (5) + 7 * (6)

Evaluation function for Phase 2 = 14 * (1) + 43 * (2) + 10 * (3) + 11 * (4) + 8 * (7) + 1086 * (8)

Evaluation function for Phase 3 = 16 * (1) + 10 * (5) + 1 * (6) + 1190 * (8)






source: https://kartikkukreja.wordpress.com/2014/03/17/heuristicevaluation-function-for-nine-mens-morris/
