package com.architectalgos.list.application;

/**
 * Doubly Linked List implementation of Design Browser History problem.
 *
 * Created On : 8/23/23.
 *
 * @author : madstuff
 */
class BrowserHistoryDLL {

    // Doubly linked list representation of a Node.
    class Node {
        String data;
        Node next;
        Node prev;

        public Node(String data) {
            this.data = data;
        }
    }

    Node homepage;
    Node currentPage;
    Node forwardPage;

    public BrowserHistoryDLL(String homepage) {
        Node node = new Node(homepage);
        this.homepage = node;
        this.currentPage = node;
        this.forwardPage = node;
    }

    /**
     * When visiting a new page, all the forward history will be deleted and visited
     * page will become forward/last page.
     * @param url
     */
    public void visit(String url) {
        Node node = new Node(url);
        currentPage.next = node;
        node.prev = currentPage;
        currentPage = node;
        forwardPage = node;
    }

    /**
     * Moves back in the history by a given number of steps. If the steps exceed
     * available history, it should move to the first visited page. Returns the
     * current page after the action.
     *
     * @param steps
     * @return
     */
    public String back(int steps) {
        while(steps > 0 && currentPage != homepage) {
            currentPage = currentPage.prev;
            steps--;
        }

        return currentPage.data;
    }

    /**
     * Moves forward in the history by a given number of steps. If the steps
     * exceed available forward history, it should move to the most recently
     * visited page.
     *
     * @param steps
     * @return
     */
    public String forward(int steps) {
        while(steps > 0 && currentPage != forwardPage) {
            currentPage = currentPage.next;
            steps--;
        }

        return currentPage.data;
    }
}
