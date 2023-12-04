package day4;

import java.util.List;

public class Scratchcards {
    private List<Integer> yourNumbers;
    private List<Integer> winningNumbers;
    private int points;
    private int matchingCounter;

    public Scratchcards(List<Integer> yourNumbers, List<Integer> winningNumbers) {
        this.yourNumbers = yourNumbers;
        this.winningNumbers = winningNumbers;
    }

    /**
     * @return List<Integer> return the yourNumbers
     */
    public List<Integer> getYourNumbers() {
        return yourNumbers;
    }

    /**
     * @param yourNumbers the yourNumbers to set
     */
    public void setYourNumbers(List<Integer> yourNumbers) {
        this.yourNumbers = yourNumbers;
    }

    /**
     * @return List<Integer> return the winningNumbers
     */
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    /**
     * @param winningNumbers the winningNumbers to set
     */
    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    /**
     * @return int return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return int return the matchingCounter
     */
    public int getMatchingCounter() {
        return matchingCounter;
    }

    /**
     * @param matchingCounter the matchingCounter to set
     */
    public void setMatchingCounter(int matchingCounter) {
        this.matchingCounter = matchingCounter;
    }

}
