package easy;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
  private double sum = 0.0;
  private int maxSize;
  private Queue<Integer> currentWindow;

  public MovingAverage(int size) {
    currentWindow = new LinkedList<>();
    maxSize = size;
  }

  public double next(int val) {
    if (currentWindow.size() == maxSize) {
        sum -= currentWindow.remove();
    }

    sum += val;
    currentWindow.add(val);
    return sum / currentWindow.size();
  }
}
