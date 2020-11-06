package com.hitesh.test.grab;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.*;

public class SnakeAndLadder {

    /**
     * 1. Design a snake and ladder game.
     * 2. N ladders and M snakes.
     * 3. starts from 1 to 100 -> 10 X 10 matrix
     * 4. All players start from outside the board.
     * 5. None of the ends of Ladders or snakes shouldn't be on same location.
     */

    /**
     * Solution:
     * 1. Players - Current Position = ZERO, Name
     * 2. Ladders - Start Position, End Position
     * 3. Snakes - Start Position, End Position
     * 4. Node - A position on the Board.
     * 5. Dice - generate Random number between 1 - X. X = 6
     * <p>
     * Property:
     * -> Position - A place on the Board - row, column
     * <p>
     * Node:
     * 1. row
     * 2. column
     * 3. type - Ladder / Snake
     * 4. SnakeOrLadder -
     * 5. Id
     * It can have only one entity of Snake or Ladder
     * <p>
     * Game Driver:
     * <p>
     * Board:
     * 1. GRID - P x Q
     * 2.
     * <p>
     * Turns are driven through a Dice Roll -> 1 - 6
     * <p>
     * <p>
     * Initialise -> new Board(int p, int q)
     * 1. Create a Grid of p X q with pq nodes.
     */

    private static final Node ZERO_NODE = new Node(0);

    public static abstract class BaseEntity {

    }

    public enum JumpType {
        LADDER,
        SNAKE
    }

    @Getter
    @Setter
    @EqualsAndHashCode(of = "id", callSuper = false)
    public static class Node extends BaseEntity {

        private Integer id;
        private Jumper jumper;

        public Node(Integer id) {
            this.id = id;
        }
    }

    public static abstract class Jumper extends BaseEntity {

        private final JumpType jumpType;
        private Node fromNode;
        private Node toNode;

        public Jumper(JumpType jumpType, Node fromNode, Node toNode) {
            this.jumpType = jumpType;
            this.fromNode = fromNode;
            this.toNode = toNode;
        }

        public Node jump(final Node currentPosition) {
            if (currentPosition == this.fromNode) {
                return this.toNode;
            }
            return currentPosition;
        }
    }

    @Getter
    @Setter
    public static class Player extends BaseEntity {

        private final int id;
        private final Node currentPosition;

        public Player(int id, Node currentPosition) {
            this.id = id;
            this.currentPosition = currentPosition;
        }
    }

    public static class Ladder extends Jumper {

        public Ladder(Node fromNode, Node toNode) {
            super(JumpType.LADDER, fromNode, toNode);
        }

    }

    public static class Snake extends Jumper {

        public Snake(Node fromNode, Node toNode) {
            super(JumpType.SNAKE, fromNode, toNode);
        }
    }

    public interface IDice {
        Integer throwDice();
    }

    public static class Dice implements IDice {

        private final int size;

        public Dice(int size) {
            this.size = size;
        }

        @Override
        public Integer throwDice() {
            return new Random().nextInt(this.size);
        }
    }


    public static class Board {

        private final Integer size;
        private final Map<Integer, Node> nodes;
        private final List<Player> players;
        private Player currentPlayer;
        private Dice dice;

        public Board(final int noOfPlayers, final Integer size) {
            this.players = new ArrayList<>(noOfPlayers + 1);
            for(int i = 1; i <= noOfPlayers; ++i) {
                this.players.add(i, new Player(i, ZERO_NODE));
            }
            this.currentPlayer = this.players.get(1);

            this.size = size;
            this.nodes = new HashMap<>(size + 1);
            for (int i = 1; i <= this.size; ++i) {
                nodes.put(i, new Node(i));
            }

            this.dice = new Dice(6);
        }

        public void setJumpers(Map<Integer, Jumper> jumperConfiguration) {
            if(jumperConfiguration != null) {
                jumperConfiguration.forEach((iNodeId, iJumper) -> {
                    final Node iNode = this.nodes.get(iNodeId);
                    if(iNode == null) throw new IllegalArgumentException("Invalid node id");
                    iNode.setJumper(iJumper);
                });
            }
        }

        public Player nextTurn() {
            if(this.currentPlayer.id + 1 == this.players.size()) return this.players.get(1);
            return this.players.get(this.currentPlayer.id + 1 % this.players.size());
        }

        public Node throwDice(final Node currentNode) {
            final int thrown = this.dice.throwDice();
            if(currentNode.id + thrown <= this.size) {
                return this.nodes.get(currentNode.id + thrown);
            }
            return currentNode;
        }

        public void playTurn() {

        }

    }

    public static class SnakeAndLadderGame {
        private final Board board;
        private final Integer noOfLadders;
        private final Integer noOfSnakes;

        public SnakeAndLadderGame(Board board, Integer noOfLadders, Integer noOfSnakes) {
            this.board = board;
            this.noOfLadders = noOfLadders;
            this.noOfSnakes = noOfSnakes;
        }

        private void generateJumpers() {
            for(int i = 0; i < noOfSnakes; ++i) {

            }
        }

    }

    public static void main(String[] args) {



    }

}
