//1629. slowest key
class Solution {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
    
        HashMap <Integer, ArrayList<Character>> durationMap = new HashMap <Integer, ArrayList<Character>>(); 
        ArrayList<Character> characterValues = new ArrayList<>();
        characterValues.add(keysPressed.charAt(0));
        durationMap.put(releaseTimes[0],characterValues); //don't put in the loop
        int maxValue = releaseTimes[0];
        //read thru the releasedTimes
        for (int i=1; i< releaseTimes.length; i++){
            int key = releaseTimes[i]-releaseTimes[i-1];
            maxValue = Math.max(maxValue,key);
            if(durationMap.containsKey(key)){
                durationMap.get(key).add(keysPressed.charAt(i));
            } else {
                characterValues = new ArrayList<>();
                characterValues.add(keysPressed.charAt(i));
                durationMap.put(key,characterValues);
            }
        }
        char small = durationMap.get(maxValue).get(0);
        for(char c : durationMap.get(maxValue)) {
            if(c-'a' > small-'a') small = c;
        }
        return small;
    }
}
