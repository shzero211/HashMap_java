package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K,V> {
    private Object[] keys;
    private Object[] values;
    private int size;

    HashMap() {
        keys = new Object[1];
        values = new Object[1];
        size = 0;
    }
    int indexOfKey(K key){
        for(int i=0;i<size;i++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
private void extendArraySizeIfFull(){
        if(isArrayFull()){
            extendArraySize();
        }
}
private boolean isArrayFull(){
        return size>=keys.length;
}
private void extendArraySize(){
        Object[] newKeys=new Object[keys.length*2];
        Object[] newValues=new Object[values.length*2];
        for(int i=0;i<keys.length;i++){
            newKeys[i]=keys[i];
            newValues[i]=values[i];
        }
    System.out.println("내부 배열의 사이즈가 증가합니다. "+keys.length+"=>"+newKeys.length);
        keys=newKeys;
        values=newValues;
}
    public void put(K key, V value) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1) {
            extendArraySizeIfFull();
            keys[size] = key;
            values[size] = value;
            size++;
        }else{
            keys[keyIndex]=key;
            values[keyIndex]=value;
        }

    }

    public V get(K key) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1) {
            return null;
        }
        return (V) values[keyIndex];
    }

    public void remove(K key){
        int keyIndex=indexOfKey(key);
        if(keyIndex==-1){
            return ;
        }
        for(int i=keyIndex+1;i<size;i++){
            keys[i-1]=keys[i];
            values[i-1]=values[i];
        }
        size--;
    }


    public int size() {
        return size;
    }

    public List<K> keySet() {
        ArrayList<K> arr=new ArrayList<>();
        for(int i=0;i<size;i++){
            arr.add((K)keys[i]);
        }
        return arr;
    }
}
class 사람 {
    private String name;

    public 사람(String name) {
        this.name = name;
    }

    void 말하다() {
        System.out.println("사람이 말합니다.");
    }
}

class 원숭이 {
    private String name;

    public 원숭이(String name) {
        this.name = name;
    }

    void 묘기를_부리다() {
        System.out.println("원숭이가 묘기를 부립니다.");
    }
}