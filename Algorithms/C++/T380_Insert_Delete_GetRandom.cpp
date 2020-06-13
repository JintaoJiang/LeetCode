class RandomizedSet {
private:
    unordered_map<int, int> map;
    vector<int> v;
public:
    /** Initialize your data structure here. */
    RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if(map.find(val) != map.end()) return false;
        v.push_back(val);
        map[val] = v.size() - 1;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        if(map.find(val) == map.end()) return false;
        int pos = map[val];
        swap(v[pos], v[v.size() - 1]);
        v.pop_back();
        map[v[pos]] = pos;
        map.erase(val);        
        return true;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        return v[rand() % v.size()];
    }
};
