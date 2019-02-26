package medium;

import java.util.*;

public class Solution582 {

    List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (ppid.get(pid.indexOf(kill)) == 0)
            return pid;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new LinkedList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);
            List<Integer> children = map.get(curr);
            if (children == null) continue;
            stack.addAll(children);
        }
        return res;
    }
}
