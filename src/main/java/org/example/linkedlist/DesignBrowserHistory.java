package org.example.linkedlist;

import java.util.Stack;

public class DesignBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        browserHistory.back(1);
        browserHistory.back(1);
        browserHistory.forward(1);
        browserHistory.visit("linkedin.com");
        browserHistory.forward(2);
        browserHistory.back(2);
        browserHistory.back(7);
    }
}

class BrowserHistory {
    //https://stackoverflow.com/posts/6869625/revisions
    private final Stack<String> back = new Stack<>();
    private final Stack<String> forward = new Stack<>();
    private String current;

    public BrowserHistory(String homepage) {
        this.current = homepage;
    }

    public void visit(String url) {
        back.push(current);
        current = url;
        forward.clear();
    }

    public String back(int steps) {
        if (steps > back.size()) {
            steps = back.size();
        }

        if (steps == 0) {
            return current;
        }

        forward.add(0, current);

        for (int i = 1; i < steps; i++) {
            forward.add(0, back.pop());
        }

        current = back.pop();

        return current;
    }

    public String forward(int steps) {
        if (steps > forward.size()) {
            steps = forward.size();
        }

        if (steps == 0) {
            return current;
        }

        back.push(current);

        for (int i = 1; i < steps; i++) {
            back.push(forward.remove(0));
        }

        current = forward.remove(0);

        return current;
    }
}
