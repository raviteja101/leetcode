class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int s = 0;
        Map<Character, Integer> copyMap = new HashMap<>(map);
        while (s < s2.length()) {
            copyMap.putAll(map);
            for (int i = s; i < s2.length(); i++) {
                if (!copyMap.containsKey(s2.charAt(i))) {
                    copyMap.clear();
                    break;
                } else {
                    copyMap.put(s2.charAt(i), copyMap.get(s2.charAt(i)) - 1);
                    if (copyMap.get(s2.charAt(i)) == 0) {
                        copyMap.remove(s2.charAt(i));
                    }
                }
                if (copyMap.isEmpty()) {
                    return true;
                }
            }
            s++;
        }
        return false;
    }
}