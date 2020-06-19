class BrowserHistory {
public:
    string hist[101];
    int head = -1, tail = -1, cur = -1;
    BrowserHistory(string homepage) {     
        head = tail = cur = 0;
        hist[cur] = homepage;
    }
    
    void visit(string url) {    
        tail = ++cur;
        hist[cur] = url;
    }
    
    string back(int steps) {
        cur = max(cur - steps, 0);
        return hist[cur];
    }
    
    string forward(int steps) {
        cur = min(cur + steps, tail);
        return hist[cur];
    }
};
