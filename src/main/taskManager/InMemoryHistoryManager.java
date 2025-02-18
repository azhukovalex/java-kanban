package main.taskManager;

import main.models.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private Node<Task> first;
    private Node<Task> last;
    private int size = 0;
    private Map<Integer, Node<Task>> historyMap = new HashMap<>();

    public int size() {
        return this.size;
    }

    @Override
    public void add(Task task) {
        if (task != null) {
            remove(task.getId());
            linkLast(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        List<Task> tasks = new ArrayList<>();
        Node<Task> currentNode = first;
        while (currentNode != null) {
            tasks.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return tasks;
    }

    @Override
    public void remove(int id) {
        if (historyMap.containsKey(id)) {
            removeNode(historyMap.get(id));
        }
    }

    private void removeNode(Node<Task> node) {
        if (node != null) {
            final Task element = node.data;
            final Node<Task> next = node.next;
            final Node<Task> prev = node.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                node.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                node.next = null;
            }

            node.data = null;

            size--;
        }
    }

    private void linkLast(Task task) {
        final Node<Task> oldTail = last;
        final Node<Task> newNode = new Node<>(oldTail, task, null);
        last = newNode;
        if (oldTail == null) {
            first = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;

        historyMap.put(task.getId(), newNode);
    }
}


class Node<E> {
    public E data;
    public Node<E> next;
    public Node<E> prev;

    public Node(Node<E> prev, E data, Node<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}
