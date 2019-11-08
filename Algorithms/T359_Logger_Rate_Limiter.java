class Logger {

    Map<String, Integer> map = new HashMap();
    
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || timestamp - map.get(message) >= 10){
            map.put(message, timestamp);
            return true;
        }
        if(!map.containsKey(message)) map.put(message, timestamp);
        return false;
    }
}