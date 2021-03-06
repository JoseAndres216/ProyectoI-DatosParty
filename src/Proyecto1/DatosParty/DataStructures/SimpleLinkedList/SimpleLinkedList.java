package Proyecto1.DatosParty.DataStructures.SimpleLinkedList;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;

public class SimpleLinkedList <T> implements MotherList<T> {
    private SimpleNode<T> head = null;
    private SimpleNode<T> tail = null;
    private int len = 0;

    public void swap(SimpleNode<T> i, SimpleNode<T> j) {
        T temp = i.getData();
        i.setData(j.getData());
        j.setData(temp);
    }
    public SimpleNode<T> getHead() {
        return this.head;
    }

    public SimpleNode<T> getTail() {
        return this.tail;
    }

    public void emptyList() {
        this.head = this.tail = null;
    }

    public int len() {
        return this.len;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertLast(T data) {
        SimpleNode<T> newNode = new SimpleNode<>(data);
        if(isEmpty()){
            this.head = this.tail = newNode;
        } else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.len++;
    }

    @Override
    public T accessNode(int i) {
        if (i > (len - 1)) {
            throw new IllegalArgumentException("Index out of range, max: " + (this.len - 1) + "given :" + i);

        } else if (i == (len - 1)) {
            return this.tail.getData();
        }
        SimpleNode<T> temp = this.head;
        int counter = 0;
        while (counter < i) {
            temp = temp.getNext();
            counter++;
        }
        return temp.getData();
    }

    public void deleteLastnode(){
        SimpleNode temp = this.head;
        while(temp.getNext().getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(null);
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[ ");
        SimpleNode<T> temp = this.head;
        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public boolean is(T data) {
        boolean is = false;
        if (this.head == null) {
            is = false;
        }

        SimpleNode<T> temp = this.head;
        while (temp != null) {
            if (temp.getData() == data) {
                is = true;
                break;
            }
            temp = temp.getNext();
        }
        return is;
    }

}
