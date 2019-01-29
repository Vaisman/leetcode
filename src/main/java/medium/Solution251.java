package medium;

import java.util.Iterator;
import java.util.List;

public class Solution251 {
    class Vector2D {

        private Iterator<List<Integer>> iterator;
        private Iterator<Integer> internal;

        public Vector2D(List<List<Integer>> vec2d) {
            iterator = vec2d.iterator();
        }

        public int next() {
            hasNext();
            return internal.next();
        }

        public boolean hasNext() {
            while ((internal == null || !internal.hasNext()) && iterator.hasNext())
                internal = iterator.next().iterator();
            return internal != null && internal.hasNext();
        }
    }
}
