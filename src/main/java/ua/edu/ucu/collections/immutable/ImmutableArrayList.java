package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] lst;
    private final int length;

    public ImmutableArrayList(){
        this.lst = new Object[0];
        this.length = 0;
    }

    private ImmutableArrayList(Object[] obj_lst){
        this.lst = obj_lst;
        this.length = obj_lst.length;
    }

    public ImmutableList add(Object e) {
        Object[] new_list = new Object[this.length + 1];
        for(int i = 0; i < this.length; i++){
            new_list[i] = this.lst[i];
        }
        new_list[this.length] = e;
        return new ImmutableArrayList(new_list);
    }//додає елемент у кінець колекції

    public ImmutableList add(int index, Object e) {
        if(index >= this.length | index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_list = new Object[this.length + 1];
        for(int i = 0; i < this.length; i++){
            if(i < index){
                new_list[i] = this.lst[i];
            }
            else {
                new_list[i + 1] = this.lst[i];
            }
        }
        new_list[index] = e;
        return new ImmutableArrayList(new_list);
    }//додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableList addAll(Object[] c) {
        Object[] new_list = new Object[this.length + c.length];
        for(int i = 0; i < this.length; i++){
            new_list[i] = this.lst[i];
        }
        for(int i = this.length; i < this.length + c.length; i++){
            new_list[i] = c[i - this.length];
        }
        return new ImmutableArrayList(new_list);
    }//додає масив елементів у кінець колекції

    public ImmutableList addAll(int index, Object[] c) {
        if(index >= this.length | index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_list = new Object[this.length + c.length];
        for(int i = 0; i < index; i++){
            new_list[i] = this.lst[i];
        }
        for(int i = index; i < index + c.length; i++){
            new_list[i] = c[i - index];
        }
        for(int i = index + c.length; i < c.length + this.length; i++){
            new_list[i] = this.lst[i - c.length];
        }
        return new ImmutableArrayList(new_list);
    }// додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public Object get(int index) {
        if(index >= this.length | index < 0){
            throw new IndexOutOfBoundsException();
        }
        return this.lst[index];
    }//повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableList remove(int index) {
        if(index >= this.length | index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_list = new Object[this.length - 1];
        for(int i = 0; i < index; i++){
            new_list[i] = this.lst[i];
        }
        for(int i = index; i < this.length - 1; i++){
            new_list[i] = this.lst[i + 1];
        }
        return new ImmutableArrayList(new_list);
    }//видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableList set(int index, Object e) {
        if(index >= this.length | index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_list = Arrays.copyOf(this.lst, this.length);
        new_list[index] = e;
        return new ImmutableArrayList(new_list);
    }//змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public int indexOf(Object e){
        for(int i = 0; i < this.length; i++){
            if(this.lst[i] == e){
                return i;
            }
        }
        return -1;
    }//шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)

    public int size(){
        return this.length;
    }//розмір колекції

    public ImmutableList clear(){
        return new ImmutableArrayList();
    }//очищує вміст колекції

    public boolean isEmpty(){
        return this.length == 0;
    }//якщо у колеції нема елементів то повертає true

    public Object[] toArray(){
        return Arrays.copyOf(this.lst, this.length);
    }//перетворює колекцію до масиву обєктів

    @Override
    public String toString(){
        String str = "";
        if(this.length > 0) {
            str += this.lst[0];
            for (int i = 1; i < this.length; i++) {
                str += "," + this.lst[i].toString();
            }
        }
        return str;
    }//повертає рядок, де через кому відображаютсься елементи колекції
}
